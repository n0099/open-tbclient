package com.baidu.tieba.more;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.f {
    private View agA;
    ImageProblemActivity bqQ;
    private ScrollView bqR;
    private Button bqS;
    private LinearLayout mLayout;
    private NavigationBar mNavigationBar;

    public w(ImageProblemActivity imageProblemActivity, t tVar) {
        super(imageProblemActivity);
        this.bqQ = imageProblemActivity;
        this.bqQ.setContentView(com.baidu.tieba.w.image_problem_activity);
        this.agA = this.bqQ.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.bqQ.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bqQ.getString(com.baidu.tieba.y.image_problem));
        this.bqR = (ScrollView) this.bqQ.findViewById(com.baidu.tieba.v.scrollView);
        this.bqS = (Button) this.bqQ.findViewById(com.baidu.tieba.v.check_btn);
        this.bqS.setOnClickListener(imageProblemActivity);
        this.mLayout = new LinearLayout(this.bqQ);
        this.mLayout.setOrientation(1);
        this.bqR.addView(this.mLayout);
        Iterator<u> it = tVar.bqJ.iterator();
        while (it.hasNext()) {
            v vVar = new v(this.bqQ);
            vVar.ql();
            vVar.setText(it.next().title);
            this.mLayout.addView(vVar);
        }
    }

    public Button UK() {
        return this.bqS;
    }

    public void start() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mLayout.getChildCount()) {
                View childAt = this.mLayout.getChildAt(i2);
                if (childAt instanceof v) {
                    v vVar = (v) childAt;
                    vVar.setStatus(3);
                    vVar.ql();
                    vVar.setHelpText("");
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
                if (childAt instanceof v) {
                    ((v) childAt).setStatus(1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void b(int i, ArrayList<u> arrayList) {
        int i2 = i - 1;
        if (i2 >= 0) {
            View childAt = this.mLayout.getChildAt(i2);
            if (childAt instanceof v) {
                v vVar = (v) childAt;
                vVar.setStatus(1);
                vVar.UJ();
                if (arrayList.get(i2).bqL == 0) {
                    vVar.setHelpText("");
                    vVar.setArrowImg(com.baidu.tieba.u.icon_diagnose_ok);
                } else {
                    vVar.setHelpText(arrayList.get(i2).bqM);
                    vVar.setArrowImg(com.baidu.tieba.u.icon_error);
                }
            }
        }
        if (i < this.mLayout.getChildCount()) {
            View childAt2 = this.mLayout.getChildAt(i);
            if (childAt2 instanceof v) {
                ((v) childAt2).setStatus(2);
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.bqQ.getLayoutMode().L(i == 1);
        this.bqQ.getLayoutMode().h(this.agA);
        this.mNavigationBar.onChangeSkinType(i);
    }
}
