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
public final class ea extends ed {
    private TextView O;
    private SubPbLoadPreviousView P;
    private NavigationBar Q;
    private ImageView R;

    public ea(com.baidu.tieba.f fVar, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(fVar, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.P = (SubPbLoadPreviousView) this.b.findViewById(R.id.sub_pb_load_previous);
        this.Q = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.R = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.O = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, fVar.getResources().getString(R.string.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.ed
    public final boolean a() {
        if (this.L.n()) {
            this.L.f();
            this.L.m();
            this.q.setEnabled(true);
        } else {
            this.e.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.ed
    public final void a(int i, View view) {
        new Handler().postDelayed(new eb(this, i, view), 300L);
    }

    @Override // com.baidu.tieba.pb.ed
    protected final void b() {
        this.L = (PbEditor) this.a.findViewById(R.id.sub_pb_editor);
        this.L.a(true);
        this.L.e();
        this.q.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.ed
    public final void a(com.baidu.tieba.editortool.aa aaVar) {
        if (aaVar != null) {
            this.L.setOnActionListener(new ec(this, aaVar));
        }
    }

    public final TextView c() {
        return this.O;
    }

    private SubPbLoadPreviousView C() {
        this.P = (SubPbLoadPreviousView) this.b.findViewById(R.id.sub_pb_load_previous);
        return this.P;
    }

    public final void d() {
        C().a();
    }

    public final void e() {
        C().b();
    }

    public final void f() {
        C().d();
        this.b.setPadding(0, 0, 0, 0);
        ((ch) this.d).b(false);
    }

    public final void g() {
        C().e();
        this.b.setPadding(0, 0, 0, 0);
        ((ch) this.d).b(true);
    }

    @Override // com.baidu.tieba.pb.ed
    protected final void a(View.OnClickListener onClickListener) {
        this.d = new ch(this.e, onClickListener);
        this.d.a(this.y);
        this.c.setAdapter((ListAdapter) this.d);
    }

    @Override // com.baidu.tieba.pb.ed
    public final void a(int i) {
        super.a(i);
        this.Q = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.Q.b(i);
        C();
        SubPbLoadPreviousView.c();
    }

    @Override // com.baidu.tieba.pb.ed
    protected final void h() {
        LayoutInflater from = LayoutInflater.from(this.e);
        this.a = from.inflate(R.layout.new_sub_pb_reply_layout, (ViewGroup) null);
        this.b = from.inflate(R.layout.new_sub_pb_reply_head, (ViewGroup) null);
        C().setOnClickListener(this.w);
    }

    @Override // com.baidu.tieba.pb.ed
    protected final int a(com.baidu.tieba.data.av avVar) {
        int d = avVar.d() - (avVar.f() * avVar.e());
        if (d < 0) {
            return 0;
        }
        return d;
    }

    @Override // com.baidu.tieba.pb.ed
    public final void a(String str) {
        ch chVar;
        int a;
        if ((this.d instanceof ch) && (a = (chVar = (ch) this.d).a(str)) >= 0) {
            this.c.setSelection(a + 1);
            com.baidu.tieba.data.aq aqVar = (com.baidu.tieba.data.aq) chVar.getItem(a);
            if (aqVar != null) {
                String userName = aqVar.g().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.L.getEditText().setText(this.e.getResources().getString(R.string.reply_sub_floor).replace("%s", userName));
                this.L.getEditText().setSelection(this.L.getEditText().getText().length());
            }
            if (TiebaApplication.g().ae() == 1) {
                chVar.a(str, this.e.getResources().getColor(R.color.c_393d47));
            } else {
                chVar.a(str, this.e.getResources().getColor(R.color.c_fdfdf1));
            }
            this.c.invalidate();
        }
    }
}
