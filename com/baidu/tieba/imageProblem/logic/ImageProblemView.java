package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.adp.base.c;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ImageProblemView extends c {
    private ScrollView bVE;
    private LinearLayout jeE;
    ImageProblemActivity jms;
    private Button jmt;
    private NavigationBar mNavigationBar;
    private View mParent;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.jms = imageProblemActivity;
        this.jms.setContentView(R.layout.image_problem_activity);
        this.mParent = this.jms.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jms.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jms.getPageContext().getString(R.string.image_problem));
        this.bVE = (ScrollView) this.jms.findViewById(R.id.scrollView);
        this.jmt = (Button) this.jms.findViewById(R.id.check_btn);
        this.jmt.setOnClickListener(imageProblemActivity);
        this.jeE = new LinearLayout(this.jms.getPageContext().getPageActivity());
        this.jeE.setOrientation(1);
        this.bVE.addView(this.jeE);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.aBj.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.jms.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.jeE.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.jmt;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jeE.getChildCount()) {
                View childAt = this.jeE.getChildAt(i2);
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
            if (i2 < this.jeE.getChildCount()) {
                View childAt = this.jeE.getChildAt(i2);
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
            View childAt = this.jeE.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).jmn);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i < this.jeE.getChildCount()) {
            View childAt2 = this.jeE.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.jms.getLayoutMode().setNightMode(i == 1);
        this.jms.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
