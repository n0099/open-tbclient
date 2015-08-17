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
    private LinearLayout bJe;
    ImageProblemActivity bMu;
    private Button bMv;
    private NavigationBar mNavigationBar;
    private ScrollView mScrollView;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.bMu = imageProblemActivity;
        this.bMu.setContentView(i.g.image_problem_activity);
        this.LR = this.bMu.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.bMu.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bMu.getPageContext().getString(i.C0057i.image_problem));
        this.mScrollView = (ScrollView) this.bMu.findViewById(i.f.scrollView);
        this.bMv = (Button) this.bMu.findViewById(i.f.check_btn);
        this.bMv.setOnClickListener(imageProblemActivity);
        this.bJe = new LinearLayout(this.bMu.getPageContext().getPageActivity());
        this.bJe.setOrientation(1);
        this.mScrollView.addView(this.bJe);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.bMo.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.bMu.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.bJe.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.bMv;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bJe.getChildCount()) {
                View childAt = this.bJe.getChildAt(i2);
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
            if (i2 < this.bJe.getChildCount()) {
                View childAt = this.bJe.getChildAt(i2);
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
            View childAt = this.bJe.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(i.e.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).bMq);
                    imageProblemItemView.setArrowImg(i.e.icon_error);
                }
            }
        }
        if (i < this.bJe.getChildCount()) {
            View childAt2 = this.bJe.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bMu.getLayoutMode().ad(i == 1);
        this.bMu.getLayoutMode().k(this.LR);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
