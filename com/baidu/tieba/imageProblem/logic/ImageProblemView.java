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
    private View LS;
    private LinearLayout bNb;
    ImageProblemActivity bQO;
    private Button bQP;
    private NavigationBar mNavigationBar;
    private ScrollView mScrollView;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.bQO = imageProblemActivity;
        this.bQO.setContentView(i.g.image_problem_activity);
        this.LS = this.bQO.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.bQO.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bQO.getPageContext().getString(i.h.image_problem));
        this.mScrollView = (ScrollView) this.bQO.findViewById(i.f.scrollView);
        this.bQP = (Button) this.bQO.findViewById(i.f.check_btn);
        this.bQP.setOnClickListener(imageProblemActivity);
        this.bNb = new LinearLayout(this.bQO.getPageContext().getPageActivity());
        this.bNb.setOrientation(1);
        this.mScrollView.addView(this.bNb);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.bQI.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.bQO.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.bNb.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.bQP;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bNb.getChildCount()) {
                View childAt = this.bNb.getChildAt(i2);
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
            if (i2 < this.bNb.getChildCount()) {
                View childAt = this.bNb.getChildAt(i2);
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
            View childAt = this.bNb.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(i.e.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).bQK);
                    imageProblemItemView.setArrowImg(i.e.icon_error);
                }
            }
        }
        if (i < this.bNb.getChildCount()) {
            View childAt2 = this.bNb.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bQO.getLayoutMode().ad(i == 1);
        this.bQO.getLayoutMode().k(this.LS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
