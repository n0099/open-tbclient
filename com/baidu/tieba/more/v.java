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
    ImageProblemActivity bvP;
    private Button bvQ;
    private LinearLayout mLayout;
    private NavigationBar mNavigationBar;
    private View mParent;
    private ScrollView mScrollView;

    public v(ImageProblemActivity imageProblemActivity, s sVar) {
        super(imageProblemActivity.getPageContext());
        this.bvP = imageProblemActivity;
        this.bvP.setContentView(com.baidu.tieba.x.image_problem_activity);
        this.mParent = this.bvP.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) this.bvP.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bvP.getPageContext().getString(com.baidu.tieba.z.image_problem));
        this.mScrollView = (ScrollView) this.bvP.findViewById(com.baidu.tieba.w.scrollView);
        this.bvQ = (Button) this.bvP.findViewById(com.baidu.tieba.w.check_btn);
        this.bvQ.setOnClickListener(imageProblemActivity);
        this.mLayout = new LinearLayout(this.bvP.getPageContext().getPageActivity());
        this.mLayout.setOrientation(1);
        this.mScrollView.addView(this.mLayout);
        Iterator<t> it = sVar.bvI.iterator();
        while (it.hasNext()) {
            u uVar = new u(this.bvP.getPageContext().getPageActivity());
            uVar.tX();
            uVar.setText(it.next().title);
            this.mLayout.addView(uVar);
        }
    }

    public Button Vx() {
        return this.bvQ;
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
                    uVar.tX();
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
                uVar.Vw();
                if (arrayList.get(i2).bvK == 0) {
                    uVar.setHelpText("");
                    uVar.setArrowImg(com.baidu.tieba.v.icon_diagnose_ok);
                } else {
                    uVar.setHelpText(arrayList.get(i2).bvL);
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
        this.bvP.getLayoutMode().ab(i == 1);
        this.bvP.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
