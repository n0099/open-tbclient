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
    private View MQ;
    private ScrollView bdN;
    private LinearLayout cla;
    ImageProblemActivity cqc;
    private Button cqd;
    private NavigationBar mNavigationBar;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.cqc = imageProblemActivity;
        this.cqc.setContentView(t.h.image_problem_activity);
        this.MQ = this.cqc.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) this.cqc.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cqc.getPageContext().getString(t.j.image_problem));
        this.bdN = (ScrollView) this.cqc.findViewById(t.g.scrollView);
        this.cqd = (Button) this.cqc.findViewById(t.g.check_btn);
        this.cqd.setOnClickListener(imageProblemActivity);
        this.cla = new LinearLayout(this.cqc.getPageContext().getPageActivity());
        this.cla.setOrientation(1);
        this.bdN.addView(this.cla);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.cpW.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.cqc.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.cla.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.cqd;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cla.getChildCount()) {
                View childAt = this.cla.getChildAt(i2);
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
            if (i2 < this.cla.getChildCount()) {
                View childAt = this.cla.getChildAt(i2);
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
            View childAt = this.cla.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(t.f.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).cpY);
                    imageProblemItemView.setArrowImg(t.f.icon_error);
                }
            }
        }
        if (i < this.cla.getChildCount()) {
            View childAt2 = this.cla.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.cqc.getLayoutMode().ac(i == 1);
        this.cqc.getLayoutMode().x(this.MQ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
