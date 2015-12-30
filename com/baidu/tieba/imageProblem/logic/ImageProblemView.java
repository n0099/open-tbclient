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
    private View MA;
    private LinearLayout cgA;
    ImageProblemActivity clB;
    private Button clC;
    private NavigationBar mNavigationBar;
    private ScrollView mScrollView;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.clB = imageProblemActivity;
        this.clB.setContentView(n.h.image_problem_activity);
        this.MA = this.clB.findViewById(n.g.parent);
        this.mNavigationBar = (NavigationBar) this.clB.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.clB.getPageContext().getString(n.j.image_problem));
        this.mScrollView = (ScrollView) this.clB.findViewById(n.g.scrollView);
        this.clC = (Button) this.clB.findViewById(n.g.check_btn);
        this.clC.setOnClickListener(imageProblemActivity);
        this.cgA = new LinearLayout(this.clB.getPageContext().getPageActivity());
        this.cgA.setOrientation(1);
        this.mScrollView.addView(this.cgA);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.clv.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.clB.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.cgA.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.clC;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cgA.getChildCount()) {
                View childAt = this.cgA.getChildAt(i2);
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
            if (i2 < this.cgA.getChildCount()) {
                View childAt = this.cgA.getChildAt(i2);
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
            View childAt = this.cgA.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(n.f.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).clx);
                    imageProblemItemView.setArrowImg(n.f.icon_error);
                }
            }
        }
        if (i < this.cgA.getChildCount()) {
            View childAt2 = this.cgA.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.clB.getLayoutMode().ac(i == 1);
        this.clB.getLayoutMode().k(this.MA);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
