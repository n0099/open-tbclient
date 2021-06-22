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
    public ImageProblemActivity f17871a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f17872b;

    /* renamed from: c  reason: collision with root package name */
    public ScrollView f17873c;

    /* renamed from: d  reason: collision with root package name */
    public View f17874d;

    /* renamed from: e  reason: collision with root package name */
    public Button f17875e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17876f;

    public ImageProblemView(ImageProblemActivity imageProblemActivity, ImageProblemAssistant imageProblemAssistant) {
        super(imageProblemActivity.getPageContext());
        this.f17871a = imageProblemActivity;
        imageProblemActivity.setContentView(R.layout.image_problem_activity);
        this.f17874d = this.f17871a.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) this.f17871a.findViewById(R.id.view_navigation_bar);
        this.f17872b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f17872b.setTitleText(this.f17871a.getPageContext().getString(R.string.image_problem));
        this.f17873c = (ScrollView) this.f17871a.findViewById(R.id.scrollView);
        Button button = (Button) this.f17871a.findViewById(R.id.check_btn);
        this.f17875e = button;
        button.setOnClickListener(imageProblemActivity);
        LinearLayout linearLayout = new LinearLayout(this.f17871a.getPageContext().getPageActivity());
        this.f17876f = linearLayout;
        linearLayout.setOrientation(1);
        this.f17873c.addView(this.f17876f);
        Iterator<ImageProblemAssistant.TestTask> it = imageProblemAssistant.f17861d.iterator();
        while (it.hasNext()) {
            ImageProblemItemView imageProblemItemView = new ImageProblemItemView(this.f17871a.getPageContext().getPageActivity());
            imageProblemItemView.hideArrow();
            imageProblemItemView.setText(it.next().f17863a);
            this.f17876f.addView(imageProblemItemView);
        }
    }

    public void complete() {
        for (int i2 = 0; i2 < this.f17876f.getChildCount(); i2++) {
            View childAt = this.f17876f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt).setStatus(1);
            }
        }
    }

    public Button getCheckButton() {
        return this.f17875e;
    }

    public void onChangeSkinType(int i2) {
        this.f17871a.getLayoutMode().k(i2 == 1);
        this.f17871a.getLayoutMode().j(this.f17874d);
        this.f17872b.onChangeSkinType(getPageContext(), i2);
    }

    public void setValue(int i2, ArrayList<ImageProblemAssistant.TestTask> arrayList) {
        int i3 = i2 - 1;
        if (i3 >= 0) {
            View childAt = this.f17876f.getChildAt(i3);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(1);
                imageProblemItemView.displayArrow();
                if (arrayList.get(i3).f17864b == 0) {
                    imageProblemItemView.setHelpText("");
                    imageProblemItemView.setArrowImg(R.drawable.icon_diagnose_ok);
                } else {
                    imageProblemItemView.setHelpText(arrayList.get(i3).f17865c);
                    imageProblemItemView.setArrowImg(R.drawable.icon_error);
                }
            }
        }
        if (i2 < this.f17876f.getChildCount()) {
            View childAt2 = this.f17876f.getChildAt(i2);
            if (childAt2 instanceof ImageProblemItemView) {
                ((ImageProblemItemView) childAt2).setStatus(2);
            }
        }
    }

    public void start() {
        for (int i2 = 0; i2 < this.f17876f.getChildCount(); i2++) {
            View childAt = this.f17876f.getChildAt(i2);
            if (childAt instanceof ImageProblemItemView) {
                ImageProblemItemView imageProblemItemView = (ImageProblemItemView) childAt;
                imageProblemItemView.setStatus(3);
                imageProblemItemView.hideArrow();
                imageProblemItemView.setHelpText("");
            }
        }
    }
}
