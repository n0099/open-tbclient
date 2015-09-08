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
    private View LR;
    private LinearLayout bJL;
    ImageProblemActivity bNb;
    private Button bNc;
    private NavigationBar mNavigationBar;
    private ScrollView mScrollView;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.bNb = imageProblemActivity;
        this.bNb.setContentView(i.g.image_problem_activity);
        this.LR = this.bNb.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.bNb.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bNb.getPageContext().getString(i.h.image_problem));
        this.mScrollView = (ScrollView) this.bNb.findViewById(i.f.scrollView);
        this.bNc = (Button) this.bNb.findViewById(i.f.check_btn);
        this.bNc.setOnClickListener(imageProblemActivity);
        this.bJL = new LinearLayout(this.bNb.getPageContext().getPageActivity());
        this.bJL.setOrientation(1);
        this.mScrollView.addView(this.bJL);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.bMV.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.bNb.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.bJL.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.bNc;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bJL.getChildCount()) {
                View childAt = this.bJL.getChildAt(i2);
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
            if (i2 < this.bJL.getChildCount()) {
                View childAt = this.bJL.getChildAt(i2);
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
            View childAt = this.bJL.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(i.e.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).bMX);
                    imageProblemItemView.setArrowImg(i.e.icon_error);
                }
            }
        }
        if (i < this.bJL.getChildCount()) {
            View childAt2 = this.bJL.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bNb.getLayoutMode().ad(i == 1);
        this.bNb.getLayoutMode().k(this.LR);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
