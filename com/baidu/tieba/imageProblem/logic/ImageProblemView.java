package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.adp.base.c;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ImageProblemView extends c {
    private View baq;
    private ScrollView coC;
    ImageProblemActivity dMA;
    private Button dMB;
    private LinearLayout mLayout;
    private NavigationBar mNavigationBar;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.dMA = imageProblemActivity;
        this.dMA.setContentView(d.j.image_problem_activity);
        this.baq = this.dMA.findViewById(d.h.parent);
        this.mNavigationBar = (NavigationBar) this.dMA.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dMA.getPageContext().getString(d.l.image_problem));
        this.coC = (ScrollView) this.dMA.findViewById(d.h.scrollView);
        this.dMB = (Button) this.dMA.findViewById(d.h.check_btn);
        this.dMB.setOnClickListener(imageProblemActivity);
        this.mLayout = new LinearLayout(this.dMA.getPageContext().getPageActivity());
        this.mLayout.setOrientation(1);
        this.coC.addView(this.mLayout);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.taskList.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.dMA.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.mLayout.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.dMB;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mLayout.getChildCount()) {
                View childAt = this.mLayout.getChildAt(i2);
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
            if (i2 < this.mLayout.getChildCount()) {
                View childAt = this.mLayout.getChildAt(i2);
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
            View childAt = this.mLayout.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(d.g.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).dMw);
                    imageProblemItemView.setArrowImg(d.g.icon_error);
                }
            }
        }
        if (i < this.mLayout.getChildCount()) {
            View childAt2 = this.mLayout.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.dMA.getLayoutMode().ah(i == 1);
        this.dMA.getLayoutMode().t(this.baq);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
