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
    public ImageProblemActivity f17713a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f17714b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f17715c;

    /* renamed from: d  reason: collision with root package name */
    public View f17716d;

    /* renamed from: e  reason: collision with root package name */
    public Button f17717e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17718f;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.f17713a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f17716d = this.f17713a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f17713a.findViewById(R.id.view_navigation_bar);
        this.f17714b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f17714b.setTitleText(this.f17713a.getPageContext().getString(R.string.image_problem));
        this.f17715c = (ScrollView) this.f17713a.findViewById(R.id.scrollView);
        Button button = (Button) this.f17713a.findViewById(R.id.check_btn);
        this.f17717e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f17713a.getPageContext().getPageActivity());
        this.f17718f = linearLayout;
        linearLayout.setOrientation(1);
        this.f17715c.addView(this.f17718f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f17703d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f17713a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f17705a);
            this.f17718f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        for (int i2 = 0; i2 < this.f17718f.getChildCount(); i2++) {
            View childAt = this.f17718f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt).setStatus(1);
            }
        }
    }

    public Button getCheckButton() {
        return this.f17717e;
    }

    public void onChangeSkinType(int i2) {
        this.f17713a.getLayoutMode().k(i2 == 1);
        this.f17713a.getLayoutMode().j(this.f17716d);
        this.f17714b.onChangeSkinType(getPageContext(), i2);
    }

    public void setValue(int i2, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        int i3 = i2 - 1;
        if (i3 >= 0) {
            View childAt = this.f17718f.getChildAt(i3);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i3).f17706b == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i3).f17707c);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i2 < this.f17718f.getChildCount()) {
            View childAt2 = this.f17718f.getChildAt(i2);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void start() {
        for (int i2 = 0; i2 < this.f17718f.getChildCount(); i2++) {
            View childAt = this.f17718f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(3);
                imageProblemItemView.hideArrow();
                imageProblemItemView.setHelpText("");
            }
        }
    }
}
