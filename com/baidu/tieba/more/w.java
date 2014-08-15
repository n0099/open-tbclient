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
    ImageProblemActivity a;
    private NavigationBar b;
    private ScrollView c;
    private View d;
    private Button e;
    private LinearLayout f;

    public w(ImageProblemActivity imageProblemActivity, t tVar) {
        super(imageProblemActivity);
        this.a = imageProblemActivity;
        this.a.setContentView(com.baidu.tieba.v.image_problem_activity);
        this.d = this.a.findViewById(com.baidu.tieba.u.parent);
        this.b = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b.a(this.a.getString(com.baidu.tieba.x.image_problem));
        this.c = (ScrollView) this.a.findViewById(com.baidu.tieba.u.scrollView);
        this.e = (Button) this.a.findViewById(com.baidu.tieba.u.check_btn);
        this.e.setOnClickListener(imageProblemActivity);
        this.f = new LinearLayout(this.a);
        this.f.setOrientation(1);
        this.c.addView(this.f);
        Iterator<u> it = tVar.a.iterator();
        while (it.hasNext()) {
            v vVar = new v(this.a);
            vVar.a();
            vVar.setText(it.next().a);
            this.f.addView(vVar);
        }
    }

    public Button a() {
        return this.e;
    }

    public void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f.getChildCount()) {
                View childAt = this.f.getChildAt(i2);
                if (childAt instanceof v) {
                    v vVar = (v) childAt;
                    vVar.setStatus(3);
                    vVar.a();
                    vVar.setHelpText("");
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f.getChildCount()) {
                View childAt = this.f.getChildAt(i2);
                if (childAt instanceof v) {
                    ((v) childAt).setStatus(1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, ArrayList<u> arrayList) {
        int i2 = i - 1;
        if (i2 >= 0) {
            View childAt = this.f.getChildAt(i2);
            if (childAt instanceof v) {
                v vVar = (v) childAt;
                vVar.setStatus(1);
                vVar.b();
                if (arrayList.get(i2).b == 0) {
                    vVar.setHelpText("");
                    vVar.setArrowImg(com.baidu.tieba.t.icon_diagnose_ok);
                } else {
                    vVar.setHelpText(arrayList.get(i2).c);
                    vVar.setArrowImg(com.baidu.tieba.t.icon_error);
                }
            }
        }
        if (i < this.f.getChildCount()) {
            View childAt2 = this.f.getChildAt(i);
            if (childAt2 instanceof v) {
                ((v) childAt2).setStatus(2);
            }
        }
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.d);
        this.b.c(i);
    }
}
