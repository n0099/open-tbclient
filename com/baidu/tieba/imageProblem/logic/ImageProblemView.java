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
/* loaded from: classes13.dex */
public class ImageProblemView extends c {
    private ScrollView cKf;
    private LinearLayout kGi;
    ImageProblemActivity kOc;
    private Button kOd;
    private NavigationBar mNavigationBar;
    private View mParent;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.kOc = imageProblemActivity;
        this.kOc.setContentView(R.layout.image_problem_activity);
        this.mParent = this.kOc.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kOc.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kOc.getPageContext().getString(R.string.image_problem));
        this.cKf = (ScrollView) this.kOc.findViewById(R.id.scrollView);
        this.kOd = (Button) this.kOc.findViewById(R.id.check_btn);
        this.kOd.setOnClickListener(imageProblemActivity);
        this.kGi = new LinearLayout(this.kOc.getPageContext().getPageActivity());
        this.kGi.setOrientation(1);
        this.cKf.addView(this.kGi);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.aPa.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.kOc.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().title);
            this.kGi.addView(imageProblemItemView);
        }
    }

    public Button getCheckButton() {
        return this.kOd;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kGi.getChildCount()) {
                View childAt = this.kGi.getChildAt(i2);
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
            if (i2 < this.kGi.getChildCount()) {
                View childAt = this.kGi.getChildAt(i2);
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
            View childAt = this.kGi.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).result == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).kNZ);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i < this.kGi.getChildCount()) {
            View childAt2 = this.kGi.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.kOc.getLayoutMode().setNightMode(i == 1);
        this.kOc.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
