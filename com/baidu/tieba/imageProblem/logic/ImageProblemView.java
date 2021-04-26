package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import d.a.c.a.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ImageProblemView extends d {

    /* renamed from: a  reason: collision with root package name */
    public ImageProblemActivity f18488a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18489b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f18490c;

    /* renamed from: d  reason: collision with root package name */
    public View f18491d;

    /* renamed from: e  reason: collision with root package name */
    public Button f18492e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18493f;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.f18488a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f18491d = this.f18488a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f18488a.findViewById(R.id.view_navigation_bar);
        this.f18489b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18489b.setTitleText(this.f18488a.getPageContext().getString(R.string.image_problem));
        this.f18490c = (ScrollView) this.f18488a.findViewById(R.id.scrollView);
        Button button = (Button) this.f18488a.findViewById(R.id.check_btn);
        this.f18492e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f18488a.getPageContext().getPageActivity());
        this.f18493f = linearLayout;
        linearLayout.setOrientation(1);
        this.f18490c.addView(this.f18493f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f18478d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f18488a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f18480a);
            this.f18493f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        for (int i2 = 0; i2 < this.f18493f.getChildCount(); i2++) {
            View childAt = this.f18493f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt).setStatus(1);
            }
        }
    }

    public Button getCheckButton() {
        return this.f18492e;
    }

    public void onChangeSkinType(int i2) {
        this.f18488a.getLayoutMode().k(i2 == 1);
        this.f18488a.getLayoutMode().j(this.f18491d);
        this.f18489b.onChangeSkinType(getPageContext(), i2);
    }

    public void setValue(int i2, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        int i3 = i2 - 1;
        if (i3 >= 0) {
            View childAt = this.f18493f.getChildAt(i3);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i3).f18481b == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i3).f18482c);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i2 < this.f18493f.getChildCount()) {
            View childAt2 = this.f18493f.getChildAt(i2);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void start() {
        for (int i2 = 0; i2 < this.f18493f.getChildCount(); i2++) {
            View childAt = this.f18493f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(3);
                imageProblemItemView.hideArrow();
                imageProblemItemView.setHelpText("");
            }
        }
    }
}
