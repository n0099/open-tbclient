package com.baidu.tieba.more;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.g {
    ImageProblemActivity bvO;
    private Button bvP;
    private LinearLayout mLayout;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ScrollView mScrollView;

    public v(ImageProblemActivity imageProblemActivity, s sVar) {
        super(imageProblemActivity.getPageContext());
        this.bvO = imageProblemActivity;
        this.bvO.setContentView(com.baidu.tieba.x.image_problem_activity);
        this.mParent = this.bvO.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) this.bvO.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bvO.getPageContext().getString(com.baidu.tieba.z.image_problem));
        this.mScrollView = (ScrollView) this.bvO.findViewById(com.baidu.tieba.w.scrollView);
        this.bvP = (Button) this.bvO.findViewById(com.baidu.tieba.w.check_btn);
        this.bvP.setOnClickListener(imageProblemActivity);
        this.mLayout = new LinearLayout(this.bvO.getPageContext().getPageActivity());
        this.mLayout.setOrientation(1);
        this.mScrollView.addView(this.mLayout);
        Iterator<t> it = sVar.bvH.iterator();
        while (it.hasNext()) {
            u uVar = new u(this.bvO.getPageContext().getPageActivity());
            uVar.tR();
            uVar.setText(it.next().title);
            this.mLayout.addView(uVar);
        }
    }

    public Button Vs() {
        return this.bvP;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mLayout.getChildCount()) {
                View childAt = this.mLayout.getChildAt(i2);
                if (childAt instanceof u) {
                    u uVar = (u) childAt;
                    uVar.setStatus(3);
                    uVar.tR();
                    uVar.setHelpText("");
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
            if (i2 < this.mLayout.getChildCount()) {
                View childAt = this.mLayout.getChildAt(i2);
                if (childAt instanceof u) {
                    ((u) childAt).setStatus(1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void b(int i, ArrayList<t> arrayList) {
        int i2 = i - 1;
        if (i2 >= 0) {
            View childAt = this.mLayout.getChildAt(i2);
            if (childAt instanceof u) {
                u uVar = (u) childAt;
                uVar.setStatus(1);
                uVar.Vr();
                if (arrayList.get(i2).bvJ == 0) {
                    uVar.setHelpText("");
                    uVar.setArrowImg(com.baidu.tieba.v.icon_diagnose_ok);
                } else {
                    uVar.setHelpText(arrayList.get(i2).bvK);
                    uVar.setArrowImg(com.baidu.tieba.v.icon_error);
                }
            }
        }
        if (i < this.mLayout.getChildCount()) {
            View childAt2 = this.mLayout.getChildAt(i);
            if (childAt2 instanceof u) {
                ((u) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bvO.getLayoutMode().ab(i == 1);
        this.bvO.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
