package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ImageProblemView extends f {
    private View Do;
    private ScrollView bmB;
    ImageProblemActivity dgZ;
    private Button dha;
    private LinearLayout mLayout;
    private NavigationBar mNavigationBar;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.dgZ = imageProblemActivity;
        this.dgZ.setContentView(u.h.image_problem_activity);
        this.Do = this.dgZ.findViewById(u.g.parent);
        this.mNavigationBar = (NavigationBar) this.dgZ.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dgZ.getPageContext().getString(u.j.image_problem));
        this.bmB = (ScrollView) this.dgZ.findViewById(u.g.scrollView);
        this.dha = (Button) this.dgZ.findViewById(u.g.check_btn);
        this.dha.setOnClickListener(imageProblemActivity);
        this.mLayout = new LinearLayout(this.dgZ.getPageContext().getPageActivity());
        this.mLayout.setOrientation(1);
        this.bmB.addView(this.mLayout);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.dgT.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.dgZ.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.mLayout.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.dha;
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
                    imageProblemItemView.setArrowImg(u.f.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).dgV);
                    imageProblemItemView.setArrowImg(u.f.icon_error);
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
        this.dgZ.getLayoutMode().ad(i == 1);
        this.dgZ.getLayoutMode().w(this.Do);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
