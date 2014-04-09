package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public final class k extends Dialog {
    public TextView a;
    public TextView b;
    public Button c;
    public Button d;
    public Button e;
    public TextView f;
    public Button g;
    public Button h;
    private VersionData i;
    private CombineDownload j;
    private o k;
    private LinearLayout l;
    private TextView m;
    private String n;
    private Context o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private LinearLayout t;
    private View.OnClickListener u;
    private View.OnClickListener v;
    private TextView w;

    public k(Context context, int i) {
        super(context, i);
        this.j = null;
        this.k = null;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = false;
        this.o = context;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.update_dialog);
        this.l = (LinearLayout) findViewById(com.baidu.tieba.a.h.down_dialog);
        this.a = (TextView) findViewById(com.baidu.tieba.a.h.newversion);
        this.b = (TextView) findViewById(com.baidu.tieba.a.h.desc);
        this.d = (Button) findViewById(com.baidu.tieba.a.h.update_button);
        this.c = (Button) findViewById(com.baidu.tieba.a.h.update_cancel);
        this.e = (Button) findViewById(com.baidu.tieba.a.h.downloading);
        this.n = this.e.getText().toString();
        this.f = (TextView) findViewById(com.baidu.tieba.a.h.otherApp);
        this.m = (TextView) findViewById(com.baidu.tieba.a.h.app_size);
        this.t = (LinearLayout) findViewById(com.baidu.tieba.a.h.cancel_dialog);
        this.g = (Button) findViewById(com.baidu.tieba.a.h.sure_cancel);
        this.h = (Button) findViewById(com.baidu.tieba.a.h.cancel_button);
        this.w = (TextView) findViewById(com.baidu.tieba.a.h.cancel_tip);
        this.g.setOnClickListener(this.u);
        this.h.setOnClickListener(this.v);
        this.a.setText("新版本：" + this.i.getNew_version());
        this.b.setText(this.i.getNew_version_desc());
        String size = this.i.getSize();
        if (size != null && !"".equals(size)) {
            this.m.setVisibility(0);
            this.m.setText(((Object) this.m.getText()) + size + "MB");
        } else {
            this.m.setVisibility(8);
        }
        if (this.i.getForce_update() == 1) {
            this.s = true;
            this.c.setText(getContext().getString(com.baidu.tieba.a.k.closeapp));
        } else {
            this.c.setText(getContext().getString(com.baidu.tieba.a.k.update_after));
        }
        if (this.j != null && this.j.getIsShow() == 1) {
            this.f.setText(this.j.getAppName());
            if (!com.baidu.tieba.util.r.a(getContext(), this.j.getAppProc()) && !TextUtils.isEmpty(this.j.getAppUrl())) {
                this.f.setVisibility(0);
                Drawable drawable = this.o.getResources().getDrawable(com.baidu.tieba.a.g.btn_dailog_choose_s);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f.setCompoundDrawables(drawable, null, null, null);
                this.p = true;
            } else {
                this.f.setVisibility(8);
                this.p = false;
            }
        } else {
            this.f.setVisibility(8);
            this.p = false;
        }
        this.d.setOnClickListener(new l(this));
        this.c.setOnClickListener(new m(this));
        this.f.setOnClickListener(new n(this));
    }

    public final void a(int i) {
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setText(String.valueOf(this.n) + i + "%");
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        if (this.r) {
            this.k.c();
            this.l.setVisibility(8);
            if (this.s) {
                this.w.setText(getContext().getString(com.baidu.tieba.a.k.download_exit));
            }
            this.t.setVisibility(0);
            return;
        }
        this.k.b();
    }

    public final void a(VersionData versionData, CombineDownload combineDownload, o oVar) {
        this.i = versionData;
        this.j = combineDownload;
        this.k = oVar;
    }

    public final void a() {
        this.t.setVisibility(8);
        this.l.setVisibility(0);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public final void b(View.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    public final void b(int i) {
        if (this.o instanceof com.baidu.tbadk.a) {
            com.baidu.tbadk.a aVar = (com.baidu.tbadk.a) this.o;
            aVar.getLayoutMode().a(i == 1);
            aVar.getLayoutMode().a(findViewById(com.baidu.tieba.a.h.dialog_layout));
        }
    }
}
