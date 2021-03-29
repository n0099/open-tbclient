package com.baidu.tieba.imageProblem.logic;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.logic.ImageProblemAssistant;
import d.b.b.a.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class ImageProblemView extends d {

    /* renamed from: a  reason: collision with root package name */
    public ImageProblemActivity f18456a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18457b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f18458c;

    /* renamed from: d  reason: collision with root package name */
    public View f18459d;

    /* renamed from: e  reason: collision with root package name */
    public Button f18460e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18461f;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.f18456a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f18459d = this.f18456a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f18456a.findViewById(R.id.view_navigation_bar);
        this.f18457b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18457b.setTitleText(this.f18456a.getPageContext().getString(R.string.image_problem));
        this.f18458c = (ScrollView) this.f18456a.findViewById(R.id.scrollView);
        Button button = (Button) this.f18456a.findViewById(R.id.check_btn);
        this.f18460e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f18456a.getPageContext().getPageActivity());
        this.f18461f = linearLayout;
        linearLayout.setOrientation(1);
        this.f18458c.addView(this.f18461f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f18447d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f18456a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f18449a);
            this.f18461f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        for (int i = 0; i < this.f18461f.getChildCount(); i++) {
            View childAt = this.f18461f.getChildAt(i);
            if (childAt instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt).setStatus(1);
            }
        }
    }

    public Button getCheckButton() {
        return this.f18460e;
    }

    public void onChangeSkinType(int i) {
        this.f18456a.getLayoutMode().k(i == 1);
        this.f18456a.getLayoutMode().j(this.f18459d);
        this.f18457b.onChangeSkinType(getPageContext(), i);
    }

    public void setValue(int i, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        int i2 = i - 1;
        if (i2 >= 0) {
            View childAt = this.f18461f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).f18450b == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).f18451c);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i < this.f18461f.getChildCount()) {
            View childAt2 = this.f18461f.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void start() {
        for (int i = 0; i < this.f18461f.getChildCount(); i++) {
            View childAt = this.f18461f.getChildAt(i);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(3);
                imageProblemItemView.hideArrow();
                imageProblemItemView.setHelpText("");
            }
        }
    }
}
