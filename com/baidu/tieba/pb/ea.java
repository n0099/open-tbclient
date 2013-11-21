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
    private TextView L;
    private SubPbLoadPreviousView M;
    private NavigationBar N;
    private ImageView O;

    public ea(com.baidu.tieba.j jVar, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        super(jVar, z, onClickListener, onClickListener2, onClickListener3, onClickListener4);
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.M = (SubPbLoadPreviousView) this.b.findViewById(R.id.sub_pb_load_previous);
        this.N = (NavigationBar) this.f2143a.findViewById(R.id.view_navigation_bar);
        this.O = this.N.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.L = this.N.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, jVar.getResources().getString(R.string.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.ed
    public boolean a() {
        if (this.I.p()) {
            this.I.g();
            this.I.o();
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
        this.I = (SubPbEditor) this.f2143a.findViewById(R.id.sub_pb_editor);
        this.I.v();
        this.I.f();
        this.q.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.ed
    public void a(com.baidu.tieba.editortool.h hVar) {
        if (hVar != null) {
            this.I.setOnActionListener(new ec(this, hVar));
        }
    }

    public TextView c() {
        return this.L;
    }

    private NavigationBar F() {
        this.N = (NavigationBar) this.f2143a.findViewById(R.id.view_navigation_bar);
        return this.N;
    }

    private SubPbLoadPreviousView G() {
        this.M = (SubPbLoadPreviousView) this.b.findViewById(R.id.sub_pb_load_previous);
        return this.M;
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
        ((cc) this.d).c(false);
    }

    public void g() {
        G().d();
        this.b.setPadding(0, 0, 0, 0);
        ((cc) this.d).c(true);
    }

    @Override // com.baidu.tieba.pb.ed
    protected void a(View.OnClickListener onClickListener) {
        this.d = new cc(this.e, onClickListener);
        this.d.a(this.x);
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
        this.f2143a = from.inflate(R.layout.new_sub_pb_reply_layout, (ViewGroup) null);
        this.b = from.inflate(R.layout.new_sub_pb_reply_head, (ViewGroup) null);
        G().setOnClickListener(this.v);
    }

    @Override // com.baidu.tieba.pb.ed
    protected int a(com.baidu.tieba.data.av avVar) {
        int e = avVar.e() - (avVar.g() * avVar.f());
        if (e < 0) {
            return 0;
        }
        return e;
    }

    @Override // com.baidu.tieba.pb.ed
    public void a(String str) {
        cc ccVar;
        int a2;
        if ((this.d instanceof cc) && (a2 = (ccVar = (cc) this.d).a(str)) > -1) {
            this.c.setSelection(a2 + 1);
            com.baidu.tieba.data.ar arVar = (com.baidu.tieba.data.ar) ccVar.getItem(a2);
            if (arVar != null) {
                this.I.getEditText().setText(this.e.getResources().getString(R.string.reply_sub_floor).replace("%s", arVar.g().getName()));
                this.I.getEditText().setSelection(this.I.getEditText().getText().length());
            }
            if (TiebaApplication.g().ap() == 1) {
                ccVar.a(str, this.e.getResources().getColor(R.color.c_393d47));
            } else {
                ccVar.a(str, this.e.getResources().getColor(R.color.c_fdfdf1));
            }
            this.c.invalidate();
        }
    }
}
