package com.baidu.tieba.pb.sub;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private TextView O;
    private SubPbLoadPreviousView P;
    private View Q;
    private NavigationBar R;
    protected View a;

    public i(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.a = null;
        this.P = (SubPbLoadPreviousView) this.c.findViewById(u.sub_pb_load_previous);
        this.R = (NavigationBar) this.b.findViewById(u.view_navigation_bar);
        this.a = this.R.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.O = this.R.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(x.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public boolean a() {
        if (this.L.p()) {
            this.L.f();
            this.L.o();
            this.r.setEnabled(true);
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
        this.L = (PbEditor) this.b.findViewById(u.sub_pb_editor);
        this.L.a(true);
        this.L.e();
        this.r.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void a(w wVar) {
        if (wVar != null) {
            this.L.setOnActionListener(new k(this, wVar));
        }
    }

    public TextView c() {
        return this.O;
    }

    private NavigationBar E() {
        this.R = (NavigationBar) this.b.findViewById(u.view_navigation_bar);
        return this.R;
    }

    private SubPbLoadPreviousView F() {
        this.P = (SubPbLoadPreviousView) this.c.findViewById(u.sub_pb_load_previous);
        return this.P;
    }

    private View G() {
        this.Q = this.c.findViewById(u.sub_pb_load_previous_top);
        return this.Q;
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
        this.e.a(this.z);
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
        LayoutInflater from = LayoutInflater.from(this.f);
        this.b = from.inflate(v.new_sub_pb_reply_layout, (ViewGroup) null);
        this.c = from.inflate(v.new_sub_pb_reply_head, (ViewGroup) null);
        F().setOnClickListener(this.x);
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
                this.L.getEditText().setText(this.f.getResources().getString(x.reply_sub_floor).replace("%s", userName));
                this.L.getEditText().setSelection(this.L.getEditText().getText().length());
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
