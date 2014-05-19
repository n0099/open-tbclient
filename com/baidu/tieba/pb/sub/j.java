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
import com.baidu.tbadk.editortool.x;
import com.baidu.tieba.data.ah;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.editortool.PbEditor;
/* loaded from: classes.dex */
public class j extends m {
    private TextView O;
    private SubPbLoadPreviousView P;
    private NavigationBar Q;
    protected View a;

    public j(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.O = null;
        this.P = null;
        this.Q = null;
        this.a = null;
        this.P = (SubPbLoadPreviousView) this.c.findViewById(com.baidu.tieba.r.sub_pb_load_previous);
        this.Q = (NavigationBar) this.b.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.a = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.O = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(com.baidu.tieba.u.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.m
    public boolean a() {
        if (this.L.o()) {
            this.L.f();
            this.L.n();
            this.r.setEnabled(true);
        } else {
            this.f.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.sub.m
    public void a(int i, View view) {
        new Handler().postDelayed(new k(this, i, view), 300L);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected void b() {
        this.L = (PbEditor) this.b.findViewById(com.baidu.tieba.r.sub_pb_editor);
        this.L.a(true);
        this.L.e();
        this.r.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.m
    public void a(x xVar) {
        if (xVar != null) {
            this.L.setOnActionListener(new l(this, xVar));
        }
    }

    public TextView c() {
        return this.O;
    }

    private NavigationBar D() {
        this.Q = (NavigationBar) this.b.findViewById(com.baidu.tieba.r.view_navigation_bar);
        return this.Q;
    }

    private SubPbLoadPreviousView E() {
        this.P = (SubPbLoadPreviousView) this.c.findViewById(com.baidu.tieba.r.sub_pb_load_previous);
        return this.P;
    }

    public void d() {
        E().a();
    }

    public void e() {
        E().b();
    }

    public void f() {
        E().c();
        this.c.setPadding(0, 0, 0, 0);
        ((i) this.e).d(false);
    }

    public void g() {
        E().d();
        this.c.setPadding(0, 0, 0, 0);
        ((i) this.e).d(true);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected void a(View.OnClickListener onClickListener) {
        this.e = new i(this.f, onClickListener);
        this.e.a(this.z);
        this.d.setAdapter((ListAdapter) this.e);
    }

    @Override // com.baidu.tieba.pb.sub.m
    public void a(int i) {
        super.a(i);
        D().c(i);
        E().a(i);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected void h() {
        LayoutInflater from = LayoutInflater.from(this.f);
        this.b = from.inflate(com.baidu.tieba.s.new_sub_pb_reply_layout, (ViewGroup) null);
        this.c = from.inflate(com.baidu.tieba.s.new_sub_pb_reply_head, (ViewGroup) null);
        E().setOnClickListener(this.x);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected int a(ao aoVar) {
        int e = aoVar.e() - (aoVar.g() * aoVar.f());
        if (e < 0) {
            return 0;
        }
        return e;
    }

    @Override // com.baidu.tieba.pb.sub.m
    public void a(String str) {
        i iVar;
        int a;
        if ((this.e instanceof i) && (a = (iVar = (i) this.e).a(str)) > -1) {
            this.d.setSelection(a + 1);
            ah ahVar = (ah) iVar.getItem(a);
            if (ahVar != null) {
                String userName = ahVar.g().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.L.getEditText().setText(this.f.getResources().getString(com.baidu.tieba.u.reply_sub_floor).replace("%s", userName));
                this.L.getEditText().setSelection(this.L.getEditText().getText().length());
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                iVar.a(str, this.f.getResources().getColor(com.baidu.tieba.o.c_393d47));
            } else {
                iVar.a(str, this.f.getResources().getColor(com.baidu.tieba.o.c_fdfdf1));
            }
            this.d.invalidate();
        }
    }
}
