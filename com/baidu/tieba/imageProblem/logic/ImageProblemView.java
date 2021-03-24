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
/* loaded from: classes4.dex */
public class ImageProblemView extends d {

    /* renamed from: a  reason: collision with root package name */
    public ImageProblemActivity f18455a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18456b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f18457c;

    /* renamed from: d  reason: collision with root package name */
    public View f18458d;

    /* renamed from: e  reason: collision with root package name */
    public Button f18459e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18460f;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.f18455a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f18458d = this.f18455a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f18455a.findViewById(R.id.view_navigation_bar);
        this.f18456b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18456b.setTitleText(this.f18455a.getPageContext().getString(R.string.image_problem));
        this.f18457c = (ScrollView) this.f18455a.findViewById(R.id.scrollView);
        Button button = (Button) this.f18455a.findViewById(R.id.check_btn);
        this.f18459e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f18455a.getPageContext().getPageActivity());
        this.f18460f = linearLayout;
        linearLayout.setOrientation(1);
        this.f18457c.addView(this.f18460f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f18446d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f18455a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f18448a);
            this.f18460f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        for (int i = 0; i < this.f18460f.getChildCount(); i++) {
            View childAt = this.f18460f.getChildAt(i);
            if (childAt instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt).setStatus(1);
            }
        }
    }

    public Button getCheckButton() {
        return this.f18459e;
    }

    public void onChangeSkinType(int i) {
        this.f18455a.getLayoutMode().k(i == 1);
        this.f18455a.getLayoutMode().j(this.f18458d);
        this.f18456b.onChangeSkinType(getPageContext(), i);
    }

    public void setValue(int i, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        int i2 = i - 1;
        if (i2 >= 0) {
            View childAt = this.f18460f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).f18449b == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).f18450c);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i < this.f18460f.getChildCount()) {
            View childAt2 = this.f18460f.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void start() {
        for (int i = 0; i < this.f18460f.getChildCount(); i++) {
            View childAt = this.f18460f.getChildAt(i);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(3);
                imageProblemItemView.hideArrow();
                imageProblemItemView.setHelpText("");
            }
        }
    }
}
