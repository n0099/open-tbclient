package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import d.b.c.a.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ImageProblemView extends d {

    /* renamed from: a  reason: collision with root package name */
    public ImageProblemActivity f18133a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18134b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f18135c;

    /* renamed from: d  reason: collision with root package name */
    public View f18136d;

    /* renamed from: e  reason: collision with root package name */
    public Button f18137e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18138f;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.f18133a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f18136d = this.f18133a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f18133a.findViewById(R.id.view_navigation_bar);
        this.f18134b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18134b.setTitleText(this.f18133a.getPageContext().getString(R.string.image_problem));
        this.f18135c = (ScrollView) this.f18133a.findViewById(R.id.scrollView);
        Button button = (Button) this.f18133a.findViewById(R.id.check_btn);
        this.f18137e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f18133a.getPageContext().getPageActivity());
        this.f18138f = linearLayout;
        linearLayout.setOrientation(1);
        this.f18135c.addView(this.f18138f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f18124d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f18133a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f18126a);
            this.f18138f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        for (int i = 0; i < this.f18138f.getChildCount(); i++) {
            View childAt = this.f18138f.getChildAt(i);
            if (childAt instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt).setStatus(1);
            }
        }
    }

    public Button getCheckButton() {
        return this.f18137e;
    }

    public void onChangeSkinType(int i) {
        this.f18133a.getLayoutMode().k(i == 1);
        this.f18133a.getLayoutMode().j(this.f18136d);
        this.f18134b.onChangeSkinType(getPageContext(), i);
    }

    public void setValue(int i, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        int i2 = i - 1;
        if (i2 >= 0) {
            View childAt = this.f18138f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).f18127b == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).f18128c);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i < this.f18138f.getChildCount()) {
            View childAt2 = this.f18138f.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void start() {
        for (int i = 0; i < this.f18138f.getChildCount(); i++) {
            View childAt = this.f18138f.getChildAt(i);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(3);
                imageProblemItemView.hideArrow();
                imageProblemItemView.setHelpText("");
            }
        }
    }
}
