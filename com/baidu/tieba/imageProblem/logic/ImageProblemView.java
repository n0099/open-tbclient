package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ImageProblemView extends e {
    private View aWX;
    private ScrollView bMk;
    ImageProblemActivity dpk;
    private Button dpl;
    private LinearLayout mLayout;
    private NavigationBar mNavigationBar;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.dpk = imageProblemActivity;
        this.dpk.setContentView(w.j.image_problem_activity);
        this.aWX = this.dpk.findViewById(w.h.parent);
        this.mNavigationBar = (NavigationBar) this.dpk.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dpk.getPageContext().getString(w.l.image_problem));
        this.bMk = (ScrollView) this.dpk.findViewById(w.h.scrollView);
        this.dpl = (Button) this.dpk.findViewById(w.h.check_btn);
        this.dpl.setOnClickListener(imageProblemActivity);
        this.mLayout = new LinearLayout(this.dpk.getPageContext().getPageActivity());
        this.mLayout.setOrientation(1);
        this.bMk.addView(this.mLayout);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.dpe.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.dpk.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.mLayout.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.dpl;
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
                    imageProblemItemView.setArrowImg(w.g.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).dpg);
                    imageProblemItemView.setArrowImg(w.g.icon_error);
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
        this.dpk.getLayoutMode().ah(i == 1);
        this.dpk.getLayoutMode().t(this.aWX);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
