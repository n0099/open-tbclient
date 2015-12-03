package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ImageProblemView extends f {
    private View Mk;
    private LinearLayout ccA;
    ImageProblemActivity chw;
    private Button chx;
    private NavigationBar mNavigationBar;
    private ScrollView mScrollView;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.chw = imageProblemActivity;
        this.chw.setContentView(n.g.image_problem_activity);
        this.Mk = this.chw.findViewById(n.f.parent);
        this.mNavigationBar = (NavigationBar) this.chw.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.chw.getPageContext().getString(n.i.image_problem));
        this.mScrollView = (ScrollView) this.chw.findViewById(n.f.scrollView);
        this.chx = (Button) this.chw.findViewById(n.f.check_btn);
        this.chx.setOnClickListener(imageProblemActivity);
        this.ccA = new LinearLayout(this.chw.getPageContext().getPageActivity());
        this.ccA.setOrientation(1);
        this.mScrollView.addView(this.ccA);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.chq.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.chw.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.ccA.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.chx;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ccA.getChildCount()) {
                View childAt = this.ccA.getChildAt(i2);
                if (childAt instanceof ImageProblemItemView) {
                    ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                    imageProblemItemView.setStatus(3);
                    imageProblemItemView.hideArrow();
                    imageProblemItemView.setHelpText("");
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void complete() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ccA.getChildCount()) {
                View childAt = this.ccA.getChildAt(i2);
                if (childAt instanceof ImageProblemItemView) {
                    ((ImageProblemItemView) childAt).setStatus(1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setValue(int i, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        int i2 = i - 1;
        if (i2 >= 0) {
            View childAt = this.ccA.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(n.e.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).chs);
                    imageProblemItemView.setArrowImg(n.e.icon_error);
                }
            }
        }
        if (i < this.ccA.getChildCount()) {
            View childAt2 = this.ccA.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.chw.getLayoutMode().af(i == 1);
        this.chw.getLayoutMode().k(this.Mk);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
