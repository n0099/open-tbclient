package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ImageProblemView extends f {
    private View MW;
    private ScrollView biA;
    ImageProblemActivity cAC;
    private Button cAD;
    private LinearLayout cvF;
    private NavigationBar mNavigationBar;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.cAC = imageProblemActivity;
        this.cAC.setContentView(t.h.image_problem_activity);
        this.MW = this.cAC.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) this.cAC.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cAC.getPageContext().getString(t.j.image_problem));
        this.biA = (ScrollView) this.cAC.findViewById(t.g.scrollView);
        this.cAD = (Button) this.cAC.findViewById(t.g.check_btn);
        this.cAD.setOnClickListener(imageProblemActivity);
        this.cvF = new LinearLayout(this.cAC.getPageContext().getPageActivity());
        this.cvF.setOrientation(1);
        this.biA.addView(this.cvF);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.cAw.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.cAC.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.cvF.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.cAD;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cvF.getChildCount()) {
                View childAt = this.cvF.getChildAt(i2);
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
            if (i2 < this.cvF.getChildCount()) {
                View childAt = this.cvF.getChildAt(i2);
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
            View childAt = this.cvF.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(t.f.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).cAy);
                    imageProblemItemView.setArrowImg(t.f.icon_error);
                }
            }
        }
        if (i < this.cvF.getChildCount()) {
            View childAt2 = this.cvF.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.cAC.getLayoutMode().ab(i == 1);
        this.cAC.getLayoutMode().x(this.MW);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
