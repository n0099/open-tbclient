package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ea extends ed {
    private TextView O;
    private SubPbLoadPreviousView P;
    private NavigationBar Q;
    private ImageView R;

    public ea(com.baidu.tieba.j jVar, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(jVar, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.P = (SubPbLoadPreviousView) this.b.findViewById(R.id.sub_pb_load_previous);
        this.Q = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.R = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.O = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, jVar.getResources().getString(R.string.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.ed
    public boolean a() {
        if (this.L.o()) {
            this.L.f();
            this.L.n();
            this.q.setEnabled(true);
        } else {
            this.e.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.ed
    public void a(int i, View view) {
        new Handler().postDelayed(new eb(this, i, view), 300L);
    }

    @Override // com.baidu.tieba.pb.ed
    protected void b() {
        this.L = (PbEditor) this.a.findViewById(R.id.sub_pb_editor);
        this.L.a(true);
        this.L.e();
        this.q.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.ed
    public void a(com.baidu.tieba.editortool.t tVar) {
        if (tVar != null) {
            this.L.setOnActionListener(new ec(this, tVar));
        }
    }

    public TextView c() {
        return this.O;
    }

    private NavigationBar F() {
        this.Q = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        return this.Q;
    }

    private SubPbLoadPreviousView G() {
        this.P = (SubPbLoadPreviousView) this.b.findViewById(R.id.sub_pb_load_previous);
        return this.P;
    }

    public void d() {
        G().a();
    }

    public void e() {
        G().b();
    }

    public void f() {
        G().c();
        this.b.setPadding(0, 0, 0, 0);
        ((ce) this.d).c(false);
    }

    public void g() {
        G().d();
        this.b.setPadding(0, 0, 0, 0);
        ((ce) this.d).c(true);
    }

    @Override // com.baidu.tieba.pb.ed
    protected void a(View.OnClickListener onClickListener) {
        this.d = new ce(this.e, onClickListener);
        this.d.a(this.y);
        this.c.setAdapter((ListAdapter) this.d);
    }

    @Override // com.baidu.tieba.pb.ed
    public void b(int i) {
        super.b(i);
        if (i == 1) {
        }
        F().c(i);
        G().a(i);
    }

    @Override // com.baidu.tieba.pb.ed
    protected void h() {
        LayoutInflater from = LayoutInflater.from(this.e);
        this.a = from.inflate(R.layout.new_sub_pb_reply_layout, (ViewGroup) null);
        this.b = from.inflate(R.layout.new_sub_pb_reply_head, (ViewGroup) null);
        G().setOnClickListener(this.w);
    }

    @Override // com.baidu.tieba.pb.ed
    protected int a(com.baidu.tieba.data.ax axVar) {
        int e = axVar.e() - (axVar.g() * axVar.f());
        if (e < 0) {
            return 0;
        }
        return e;
    }

    @Override // com.baidu.tieba.pb.ed
    public void a(String str) {
        ce ceVar;
        int a;
        if ((this.d instanceof ce) && (a = (ceVar = (ce) this.d).a(str)) > -1) {
            this.c.setSelection(a + 1);
            com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) ceVar.getItem(a);
            if (asVar != null) {
                this.L.getEditText().setText(this.e.getResources().getString(R.string.reply_sub_floor).replace("%s", asVar.g().getName()));
                this.L.getEditText().setSelection(this.L.getEditText().getText().length());
            }
            if (TiebaApplication.g().an() == 1) {
                ceVar.a(str, this.e.getResources().getColor(R.color.c_393d47));
            } else {
                ceVar.a(str, this.e.getResources().getColor(R.color.c_fdfdf1));
            }
            this.c.invalidate();
        }
    }
}
