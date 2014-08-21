package com.baidu.tieba.pb.sub;

import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortool.w;
import com.baidu.tieba.data.an;
import com.baidu.tieba.data.au;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class i extends l {
    private TextView P;
    private SubPbLoadPreviousView Q;
    private View R;
    private NavigationBar S;
    protected View a;

    public i(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.a = null;
        this.Q = (SubPbLoadPreviousView) this.c.findViewById(u.sub_pb_load_previous);
        this.S = (NavigationBar) this.b.findViewById(u.view_navigation_bar);
        this.a = this.S.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.P = this.S.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(x.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public boolean a() {
        if (this.M.p()) {
            this.M.f();
            this.M.o();
            this.s.setEnabled(true);
        } else {
            this.f.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.sub.l
    public void a(int i, View view) {
        new Handler().postDelayed(new j(this, i, view), 300L);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void b() {
        this.M = (PbEditor) this.b.findViewById(u.sub_pb_editor);
        this.M.a(true);
        this.M.e();
        this.s.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void a(w wVar) {
        if (wVar != null) {
            this.M.setOnActionListener(new k(this, wVar));
        }
    }

    public TextView c() {
        return this.P;
    }

    private NavigationBar E() {
        this.S = (NavigationBar) this.b.findViewById(u.view_navigation_bar);
        return this.S;
    }

    private SubPbLoadPreviousView F() {
        this.Q = (SubPbLoadPreviousView) this.c.findViewById(u.sub_pb_load_previous);
        return this.Q;
    }

    private View G() {
        this.R = this.c.findViewById(u.sub_pb_load_previous_top);
        return this.R;
    }

    public void d() {
        F().a();
        G().setVisibility(0);
    }

    public void e() {
        F().b();
        G().setVisibility(0);
    }

    public void f() {
        F().c();
        G().setVisibility(8);
        this.c.setPadding(0, 0, 0, 0);
        ((h) this.e).d(false);
    }

    public void g() {
        F().d();
        F().setVisibility(0);
        this.c.setPadding(0, 0, 0, 0);
        ((h) this.e).d(true);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void a(View.OnClickListener onClickListener) {
        this.e = new h(this.f, onClickListener);
        this.e.a(this.A);
        this.d.setAdapter((ListAdapter) this.e);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void a(int i) {
        super.a(i);
        E().c(i);
        F().a(i);
        this.f.getLayoutMode().a(G());
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void h() {
        this.b = com.baidu.adp.lib.e.b.a().a(this.f, v.new_sub_pb_reply_layout, null);
        this.c = com.baidu.adp.lib.e.b.a().a(this.f, v.new_sub_pb_reply_head, null);
        F().setOnClickListener(this.y);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected int a(au auVar) {
        if (auVar == null) {
            return 0;
        }
        int f = auVar.f() - (auVar.h() * auVar.g());
        if (f < 0) {
            f = 0;
        }
        return f;
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void a(String str) {
        h hVar;
        int a;
        if ((this.e instanceof h) && (a = (hVar = (h) this.e).a(str)) > -1) {
            this.d.setSelection(a + 1);
            an anVar = (an) hVar.getItem(a);
            if (anVar != null) {
                String userName = anVar.g().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.M.getEditText().setText(this.f.getResources().getString(x.reply_sub_floor).replace("%s", userName));
                this.M.getEditText().setSelection(this.M.getEditText().getText().length());
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                hVar.a(str, this.f.getResources().getColor(com.baidu.tieba.r.c_393d47));
            } else {
                hVar.a(str, this.f.getResources().getColor(com.baidu.tieba.r.c_fdfdf1));
            }
            this.d.invalidate();
        }
    }
}
