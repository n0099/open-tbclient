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
/* loaded from: classes2.dex */
public class ImageProblemView extends c {
    private ScrollView bvD;
    ImageProblemActivity haQ;
    private Button haR;
    private LinearLayout mLayout;
    private NavigationBar mNavigationBar;
    private View mParent;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.haQ = imageProblemActivity;
        this.haQ.setContentView(R.layout.image_problem_activity);
        this.mParent = this.haQ.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.haQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.haQ.getPageContext().getString(R.string.image_problem));
        this.bvD = (ScrollView) this.haQ.findViewById(R.id.scrollView);
        this.haR = (Button) this.haQ.findViewById(R.id.check_btn);
        this.haR.setOnClickListener(imageProblemActivity);
        this.mLayout = new LinearLayout(this.haQ.getPageContext().getPageActivity());
        this.mLayout.setOrientation(1);
        this.bvD.addView(this.mLayout);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.SC.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.haQ.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.mLayout.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.haR;
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
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).haM);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
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
        this.haQ.getLayoutMode().setNightMode(i == 1);
        this.haQ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
