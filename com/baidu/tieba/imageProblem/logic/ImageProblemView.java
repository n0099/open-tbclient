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
    public ImageProblemActivity f18141a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18142b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f18143c;

    /* renamed from: d  reason: collision with root package name */
    public View f18144d;

    /* renamed from: e  reason: collision with root package name */
    public Button f18145e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18146f;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.f18141a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f18144d = this.f18141a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f18141a.findViewById(R.id.view_navigation_bar);
        this.f18142b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f18142b.setTitleText(this.f18141a.getPageContext().getString(R.string.image_problem));
        this.f18143c = (ScrollView) this.f18141a.findViewById(R.id.scrollView);
        Button button = (Button) this.f18141a.findViewById(R.id.check_btn);
        this.f18145e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f18141a.getPageContext().getPageActivity());
        this.f18146f = linearLayout;
        linearLayout.setOrientation(1);
        this.f18143c.addView(this.f18146f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f18132d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f18141a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f18134a);
            this.f18146f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        for (int i = 0; i < this.f18146f.getChildCount(); i++) {
            View childAt = this.f18146f.getChildAt(i);
            if (childAt instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt).setStatus(1);
            }
        }
    }

    public Button getCheckButton() {
        return this.f18145e;
    }

    public void onChangeSkinType(int i) {
        this.f18141a.getLayoutMode().k(i == 1);
        this.f18141a.getLayoutMode().j(this.f18144d);
        this.f18142b.onChangeSkinType(getPageContext(), i);
    }

    public void setValue(int i, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        int i2 = i - 1;
        if (i2 >= 0) {
            View childAt = this.f18146f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i2).f18135b == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i2).f18136c);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i < this.f18146f.getChildCount()) {
            View childAt2 = this.f18146f.getChildAt(i);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void start() {
        for (int i = 0; i < this.f18146f.getChildCount(); i++) {
            View childAt = this.f18146f.getChildAt(i);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(3);
                imageProblemItemView.hideArrow();
                imageProblemItemView.setHelpText("");
            }
        }
    }
}
