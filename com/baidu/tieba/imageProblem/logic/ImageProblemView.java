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
    private LinearLayout bvn;
    ImageProblemActivity byG;
    private Button byH;
    private NavigationBar mNavigationBar;
    private ScrollView mScrollView;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.byG = imageProblemActivity;
        this.byG.setContentView(r.image_problem_activity);
        this.LG = this.byG.findViewById(q.parent);
        this.mNavigationBar = (NavigationBar) this.byG.findViewById(q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.byG.getPageContext().getString(t.image_problem));
        this.mScrollView = (ScrollView) this.byG.findViewById(q.scrollView);
        this.byH = (Button) this.byG.findViewById(q.check_btn);
        this.byH.setOnClickListener(imageProblemActivity);
        this.bvn = new LinearLayout(this.byG.getPageContext().getPageActivity());
        this.bvn.setOrientation(1);
        this.mScrollView.addView(this.bvn);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.byz.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.byG.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.bvn.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.byH;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bvn.getChildCount()) {
                View childAt = this.bvn.getChildAt(i2);
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
            if (i2 < this.bvn.getChildCount()) {
                View childAt = this.bvn.getChildAt(i2);
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
            View childAt = this.bvn.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).byB == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(p.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).byC);
                    imageProblemItemView.setArrowImg(p.icon_error);
                }
            }
        }
        if (i < this.bvn.getChildCount()) {
            View childAt2 = this.bvn.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.byG.getLayoutMode().ab(i == 1);
        this.byG.getLayoutMode().j(this.LG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
