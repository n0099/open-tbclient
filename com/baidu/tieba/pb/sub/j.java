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
import com.baidu.tieba.data.am;
import com.baidu.tieba.data.at;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.y;
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
        this.P = (SubPbLoadPreviousView) this.c.findViewById(com.baidu.tieba.v.sub_pb_load_previous);
        this.Q = (NavigationBar) this.b.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.a = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.O = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(y.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.m
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
    @Override // com.baidu.tieba.pb.sub.m
    public void a(int i, View view) {
        new Handler().postDelayed(new k(this, i, view), 300L);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected void b() {
        this.L = (PbEditor) this.b.findViewById(com.baidu.tieba.v.sub_pb_editor);
        this.L.a(true);
        this.L.e();
        this.r.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.m
    public void a(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.L.setOnActionListener(new l(this, wVar));
        }
    }

    public TextView c() {
        return this.O;
    }

    private NavigationBar E() {
        this.Q = (NavigationBar) this.b.findViewById(com.baidu.tieba.v.view_navigation_bar);
        return this.Q;
    }

    private SubPbLoadPreviousView F() {
        this.P = (SubPbLoadPreviousView) this.c.findViewById(com.baidu.tieba.v.sub_pb_load_previous);
        return this.P;
    }

    public void d() {
        F().a();
    }

    public void e() {
        F().b();
    }

    public void f() {
        F().c();
        this.c.setPadding(0, 0, 0, 0);
        ((i) this.e).d(false);
    }

    public void g() {
        F().d();
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
        E().c(i);
        F().a(i);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected void h() {
        LayoutInflater from = LayoutInflater.from(this.f);
        this.b = from.inflate(com.baidu.tieba.w.new_sub_pb_reply_layout, (ViewGroup) null);
        this.c = from.inflate(com.baidu.tieba.w.new_sub_pb_reply_head, (ViewGroup) null);
        F().setOnClickListener(this.x);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected int a(at atVar) {
        int e = atVar.e() - (atVar.g() * atVar.f());
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
            am amVar = (am) iVar.getItem(a);
            if (amVar != null) {
                String userName = amVar.o().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.L.getEditText().setText(this.f.getResources().getString(y.reply_sub_floor).replace("%s", userName));
                this.L.getEditText().setSelection(this.L.getEditText().getText().length());
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                iVar.a(str, this.f.getResources().getColor(com.baidu.tieba.s.c_393d47));
            } else {
                iVar.a(str, this.f.getResources().getColor(com.baidu.tieba.s.c_fdfdf1));
            }
            this.d.invalidate();
        }
    }
}
