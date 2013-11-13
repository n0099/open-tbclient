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
public class dy extends eb {
    private TextView L;
    private SubPbLoadPreviousView M;
    private NavigationBar N;
    private ImageView O;

    public dy(com.baidu.tieba.j jVar, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        super(jVar, z, onClickListener, onClickListener2, onClickListener3, onClickListener4);
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.M = (SubPbLoadPreviousView) this.b.findViewById(R.id.sub_pb_load_previous);
        this.N = (NavigationBar) this.f2158a.findViewById(R.id.view_navigation_bar);
        this.O = this.N.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.L = this.N.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, jVar.getResources().getString(R.string.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.eb
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
    @Override // com.baidu.tieba.pb.eb
    public void a(int i, View view) {
        new Handler().postDelayed(new dz(this, i, view), 300L);
    }

    @Override // com.baidu.tieba.pb.eb
    protected void b() {
        this.I = (SubPbEditor) this.f2158a.findViewById(R.id.sub_pb_editor);
        this.I.v();
        this.I.f();
        this.q.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.eb
    public void a(com.baidu.tieba.editortool.h hVar) {
        if (hVar != null) {
            this.I.setOnActionListener(new ea(this, hVar));
        }
    }

    public TextView c() {
        return this.L;
    }

    private NavigationBar F() {
        this.N = (NavigationBar) this.f2158a.findViewById(R.id.view_navigation_bar);
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
        ((ca) this.d).c(false);
    }

    public void g() {
        G().d();
        this.b.setPadding(0, 0, 0, 0);
        ((ca) this.d).c(true);
    }

    @Override // com.baidu.tieba.pb.eb
    protected void a(View.OnClickListener onClickListener) {
        this.d = new ca(this.e, onClickListener);
        this.d.a(this.x);
        this.c.setAdapter((ListAdapter) this.d);
    }

    @Override // com.baidu.tieba.pb.eb
    public void b(int i) {
        super.b(i);
        if (i == 1) {
        }
        F().c(i);
        G().a(i);
    }

    @Override // com.baidu.tieba.pb.eb
    protected void h() {
        LayoutInflater from = LayoutInflater.from(this.e);
        this.f2158a = from.inflate(R.layout.new_sub_pb_reply_layout, (ViewGroup) null);
        this.b = from.inflate(R.layout.new_sub_pb_reply_head, (ViewGroup) null);
        G().setOnClickListener(this.v);
    }

    @Override // com.baidu.tieba.pb.eb
    protected int a(com.baidu.tieba.data.aw awVar) {
        int e = awVar.e() - (awVar.g() * awVar.f());
        if (e < 0) {
            return 0;
        }
        return e;
    }

    @Override // com.baidu.tieba.pb.eb
    public void a(String str) {
        ca caVar;
        int a2;
        if ((this.d instanceof ca) && (a2 = (caVar = (ca) this.d).a(str)) > -1) {
            this.c.setSelection(a2 + 1);
            com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) caVar.getItem(a2);
            if (asVar != null) {
                this.I.getEditText().setText(this.e.getResources().getString(R.string.reply_sub_floor).replace("%s", asVar.g().getName()));
                this.I.getEditText().setSelection(this.I.getEditText().getText().length());
            }
            if (TiebaApplication.g().ap() == 1) {
                caVar.a(str, this.e.getResources().getColor(R.color.c_393d47));
            } else {
                caVar.a(str, this.e.getResources().getColor(R.color.c_fdfdf1));
            }
            this.c.invalidate();
        }
    }
}
