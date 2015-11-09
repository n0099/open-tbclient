package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ImageProblemView extends f {
    private View LT;
    private LinearLayout bNw;
    ImageProblemActivity bRj;
    private Button bRk;
    private NavigationBar mNavigationBar;
    private ScrollView mScrollView;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.bRj = imageProblemActivity;
        this.bRj.setContentView(i.g.image_problem_activity);
        this.LT = this.bRj.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.bRj.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bRj.getPageContext().getString(i.h.image_problem));
        this.mScrollView = (ScrollView) this.bRj.findViewById(i.f.scrollView);
        this.bRk = (Button) this.bRj.findViewById(i.f.check_btn);
        this.bRk.setOnClickListener(imageProblemActivity);
        this.bNw = new LinearLayout(this.bRj.getPageContext().getPageActivity());
        this.bNw.setOrientation(1);
        this.mScrollView.addView(this.bNw);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.bRd.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.bRj.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.bNw.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.bRk;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bNw.getChildCount()) {
                View childAt = this.bNw.getChildAt(i2);
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
            if (i2 < this.bNw.getChildCount()) {
                View childAt = this.bNw.getChildAt(i2);
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
            View childAt = this.bNw.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(i.e.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).bRf);
                    imageProblemItemView.setArrowImg(i.e.icon_error);
                }
            }
        }
        if (i < this.bNw.getChildCount()) {
            View childAt2 = this.bNw.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bRj.getLayoutMode().ad(i == 1);
        this.bRj.getLayoutMode().k(this.LT);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
