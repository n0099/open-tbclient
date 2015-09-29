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
    private LinearLayout bMQ;
    ImageProblemActivity bQD;
    private Button bQE;
    private NavigationBar mNavigationBar;
    private ScrollView mScrollView;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.bQD = imageProblemActivity;
        this.bQD.setContentView(i.g.image_problem_activity);
        this.LR = this.bQD.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.bQD.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bQD.getPageContext().getString(i.h.image_problem));
        this.mScrollView = (ScrollView) this.bQD.findViewById(i.f.scrollView);
        this.bQE = (Button) this.bQD.findViewById(i.f.check_btn);
        this.bQE.setOnClickListener(imageProblemActivity);
        this.bMQ = new LinearLayout(this.bQD.getPageContext().getPageActivity());
        this.bMQ.setOrientation(1);
        this.mScrollView.addView(this.bMQ);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.bQx.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.bQD.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.bMQ.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.bQE;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bMQ.getChildCount()) {
                View childAt = this.bMQ.getChildAt(i2);
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
            if (i2 < this.bMQ.getChildCount()) {
                View childAt = this.bMQ.getChildAt(i2);
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
            View childAt = this.bMQ.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(i.e.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).bQz);
                    imageProblemItemView.setArrowImg(i.e.icon_error);
                }
            }
        }
        if (i < this.bMQ.getChildCount()) {
            View childAt2 = this.bMQ.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bQD.getLayoutMode().ad(i == 1);
        this.bQD.getLayoutMode().k(this.LR);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
