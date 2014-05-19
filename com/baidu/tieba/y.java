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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public class y extends Dialog {
    public TextView a;
    public TextView b;
    public Button c;
    public Button d;
    public TextView e;
    public TextView f;
    public Button g;
    public Button h;
    private VersionData i;
    private CombineDownload j;
    private ac k;
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

    public y(Context context, int i) {
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
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(s.update_dialog);
        this.l = (LinearLayout) findViewById(r.down_dialog);
        this.a = (TextView) findViewById(r.newversion);
        this.b = (TextView) findViewById(r.desc);
        this.d = (Button) findViewById(r.update_button);
        this.c = (Button) findViewById(r.update_cancel);
        this.e = (TextView) findViewById(r.downloading);
        this.n = this.e.getText().toString();
        this.f = (TextView) findViewById(r.otherApp);
        this.m = (TextView) findViewById(r.app_size);
        this.t = (LinearLayout) findViewById(r.cancel_dialog);
        this.g = (Button) findViewById(r.sure_cancel);
        this.h = (Button) findViewById(r.cancel_button);
        this.w = (TextView) findViewById(r.cancel_tip);
        this.g.setOnClickListener(this.u);
        this.h.setOnClickListener(this.v);
        this.a.setText("新版本：" + this.i.getNewVersion());
        this.b.setText(this.i.getNewVersionDesc());
        String size = this.i.getSize();
        if (size != null && !"".equals(size)) {
            this.m.setVisibility(0);
            this.m.setText(((Object) this.m.getText()) + size + "MB");
        } else {
            this.m.setVisibility(8);
        }
        if (this.i.forceUpdate()) {
            this.s = true;
            this.c.setText(getContext().getString(u.closeapp));
        } else {
            this.c.setText(getContext().getString(u.update_after));
        }
        if (this.j != null && this.j.getIsShow() == 1) {
            this.f.setText(this.j.getAppName());
            if (!com.baidu.tieba.util.r.a(getContext(), this.j.getAppProc()) && !TextUtils.isEmpty(this.j.getAppUrl())) {
                this.f.setVisibility(0);
                Drawable drawable = this.o.getResources().getDrawable(q.btn_dailog_choose_s);
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
        this.d.setOnClickListener(new z(this));
        this.c.setOnClickListener(new aa(this));
        this.f.setOnClickListener(new ab(this));
    }

    public void a(int i) {
        this.d.setVisibility(8);
        this.c.setVisibility(8);
        this.e.setVisibility(0);
        this.e.setText(String.valueOf(this.n) + i + "%");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.r) {
            this.k.c();
            this.l.setVisibility(8);
            if (this.s) {
                this.w.setText(getContext().getString(u.download_exit));
            }
            this.t.setVisibility(0);
            return;
        }
        this.k.b();
    }

    public void a(VersionData versionData, CombineDownload combineDownload, ac acVar) {
        this.i = versionData;
        this.j = combineDownload;
        this.k = acVar;
    }

    public void a() {
        this.t.setVisibility(8);
        this.l.setVisibility(0);
    }

    public void a(View.OnClickListener onClickListener) {
        this.u = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    public void b(int i) {
        if (this.o instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.o;
            baseActivity.getLayoutMode().a(i == 1);
            baseActivity.getLayoutMode().a(findViewById(r.dialog_layout));
        }
    }
}
