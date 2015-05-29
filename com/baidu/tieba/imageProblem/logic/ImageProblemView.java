package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.adp.base.g;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ImageProblemView extends g {
    private View LG;
    private LinearLayout bvm;
    ImageProblemActivity byF;
    private Button byG;
    private NavigationBar mNavigationBar;
    private ScrollView mScrollView;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.byF = imageProblemActivity;
        this.byF.setContentView(r.image_problem_activity);
        this.LG = this.byF.findViewById(q.parent);
        this.mNavigationBar = (NavigationBar) this.byF.findViewById(q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.byF.getPageContext().getString(t.image_problem));
        this.mScrollView = (ScrollView) this.byF.findViewById(q.scrollView);
        this.byG = (Button) this.byF.findViewById(q.check_btn);
        this.byG.setOnClickListener(imageProblemActivity);
        this.bvm = new LinearLayout(this.byF.getPageContext().getPageActivity());
        this.bvm.setOrientation(1);
        this.mScrollView.addView(this.bvm);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.byy.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.byF.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.bvm.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.byG;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bvm.getChildCount()) {
                View childAt = this.bvm.getChildAt(i2);
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
            if (i2 < this.bvm.getChildCount()) {
                View childAt = this.bvm.getChildAt(i2);
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
            View childAt = this.bvm.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).byA == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(p.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).byB);
                    imageProblemItemView.setArrowImg(p.icon_error);
                }
            }
        }
        if (i < this.bvm.getChildCount()) {
            View childAt2 = this.bvm.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.byF.getLayoutMode().ab(i == 1);
        this.byF.getLayoutMode().j(this.LG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
