package com.baidu.tieba.pb.sub;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.data.am;
import com.baidu.tieba.editortool.PbEditor;
/* loaded from: classes.dex */
public final class j extends m {
    private TextView P;
    private SubPbLoadPreviousView Q;
    private NavigationBar R;
    protected View a;

    public j(com.baidu.tbadk.a aVar, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(aVar, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.P = null;
        this.Q = null;
        this.R = null;
        this.a = null;
        this.Q = (SubPbLoadPreviousView) this.c.findViewById(com.baidu.tieba.a.h.sub_pb_load_previous);
        this.R = (NavigationBar) this.b.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.a = this.R.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.P = this.R.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, aVar.getResources().getString(com.baidu.tieba.a.k.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.m
    public final boolean a() {
        if (this.M.n()) {
            this.M.f();
            this.M.m();
            this.r.setEnabled(true);
        } else {
            this.f.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.sub.m
    public final void a(int i, View view) {
        new Handler().postDelayed(new k(this, i, view), 300L);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected final void b() {
        this.M = (PbEditor) this.b.findViewById(com.baidu.tieba.a.h.sub_pb_editor);
        this.M.a(true);
        this.M.e();
        this.r.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.m
    public final void a(com.baidu.tbadk.editortool.x xVar) {
        if (xVar != null) {
            this.M.setOnActionListener(new l(this, xVar));
        }
    }

    public final TextView c() {
        return this.P;
    }

    private SubPbLoadPreviousView C() {
        this.Q = (SubPbLoadPreviousView) this.c.findViewById(com.baidu.tieba.a.h.sub_pb_load_previous);
        return this.Q;
    }

    public final void d() {
        C().a();
    }

    public final void e() {
        C().b();
    }

    public final void f() {
        C().d();
        this.c.setPadding(0, 0, 0, 0);
        ((i) this.e).b(false);
    }

    public final void g() {
        C().e();
        this.c.setPadding(0, 0, 0, 0);
        ((i) this.e).b(true);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected final void a(View.OnClickListener onClickListener) {
        this.e = new i(this.f, onClickListener);
        this.e.a(this.z);
        this.d.setAdapter((ListAdapter) this.e);
    }

    @Override // com.baidu.tieba.pb.sub.m
    public final void a(int i) {
        super.a(i);
        this.R = (NavigationBar) this.b.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.R.b(i);
        C();
        SubPbLoadPreviousView.c();
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected final void h() {
        LayoutInflater from = LayoutInflater.from(this.f);
        this.b = from.inflate(com.baidu.tieba.a.i.new_sub_pb_reply_layout, (ViewGroup) null);
        this.c = from.inflate(com.baidu.tieba.a.i.new_sub_pb_reply_head, (ViewGroup) null);
        C().setOnClickListener(this.x);
    }

    @Override // com.baidu.tieba.pb.sub.m
    protected final int a(am amVar) {
        int d = amVar.d() - (amVar.f() * amVar.e());
        if (d < 0) {
            return 0;
        }
        return d;
    }

    @Override // com.baidu.tieba.pb.sub.m
    public final void a(String str) {
        i iVar;
        int a;
        if ((this.e instanceof i) && (a = (iVar = (i) this.e).a(str)) >= 0) {
            this.d.setSelection(a + 1);
            ai aiVar = (ai) iVar.getItem(a);
            if (aiVar != null) {
                String userName = aiVar.g().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.M.getEditText().setText(this.f.getResources().getString(com.baidu.tieba.a.k.reply_sub_floor).replace("%s", userName));
                this.M.getEditText().setSelection(this.M.getEditText().getText().length());
            }
            if (TbadkApplication.j().l() == 1) {
                iVar.a(str, this.f.getResources().getColor(com.baidu.tieba.a.e.c_393d47));
            } else {
                iVar.a(str, this.f.getResources().getColor(com.baidu.tieba.a.e.c_fdfdf1));
            }
            this.d.invalidate();
        }
    }
}
