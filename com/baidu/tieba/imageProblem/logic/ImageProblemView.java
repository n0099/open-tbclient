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
    public ImageProblemActivity f17803a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f17804b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f17805c;

    /* renamed from: d  reason: collision with root package name */
    public View f17806d;

    /* renamed from: e  reason: collision with root package name */
    public Button f17807e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17808f;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.f17803a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f17806d = this.f17803a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f17803a.findViewById(R.id.view_navigation_bar);
        this.f17804b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f17804b.setTitleText(this.f17803a.getPageContext().getString(R.string.image_problem));
        this.f17805c = (ScrollView) this.f17803a.findViewById(R.id.scrollView);
        Button button = (Button) this.f17803a.findViewById(R.id.check_btn);
        this.f17807e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f17803a.getPageContext().getPageActivity());
        this.f17808f = linearLayout;
        linearLayout.setOrientation(1);
        this.f17805c.addView(this.f17808f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f17793d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f17803a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f17795a);
            this.f17808f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        for (int i2 = 0; i2 < this.f17808f.getChildCount(); i2++) {
            View childAt = this.f17808f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt).setStatus(1);
            }
        }
    }

    public Button getCheckButton() {
        return this.f17807e;
    }

    public void onChangeSkinType(int i2) {
        this.f17803a.getLayoutMode().k(i2 == 1);
        this.f17803a.getLayoutMode().j(this.f17806d);
        this.f17804b.onChangeSkinType(getPageContext(), i2);
    }

    public void setValue(int i2, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        int i3 = i2 - 1;
        if (i3 >= 0) {
            View childAt = this.f17808f.getChildAt(i3);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i3).f17796b == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i3).f17797c);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i2 < this.f17808f.getChildCount()) {
            View childAt2 = this.f17808f.getChildAt(i2);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void start() {
        for (int i2 = 0; i2 < this.f17808f.getChildCount(); i2++) {
            View childAt = this.f17808f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(3);
                imageProblemItemView.hideArrow();
                imageProblemItemView.setHelpText("");
            }
        }
    }
}
