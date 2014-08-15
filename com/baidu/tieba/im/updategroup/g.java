package com.baidu.tieba.im.updategroup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.d.l;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.adp.base.f implements a {
    private DialogInterface.OnClickListener a;
    protected EditText b;
    protected NavigationBar c;
    protected View d;
    protected TextView e;
    protected ImageButton f;
    protected UpdateGroupActivity g;
    protected ProgressBar h;
    protected String i;
    protected boolean j;
    protected int k;
    protected boolean l;
    protected View m;
    TextWatcher n;
    private DialogInterface.OnClickListener o;

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(DialogInterface.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(DialogInterface.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View e() {
        return this.m;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View c() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View d() {
        return this.f;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void f() {
        this.b.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean i() {
        return this.l;
    }

    public g(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.a = null;
        this.o = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = 0;
        this.l = true;
        this.m = null;
        this.n = new h(this);
        this.g = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.g.setContentView(i);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(int i) {
        this.k = i;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int h() {
        return this.k;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(String str) {
        this.i = str;
        b(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String b() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i) {
        this.d = this.g.findViewById(u.parent);
        this.c = (NavigationBar) this.g.findViewById(u.view_navigation_bar);
        this.c.a(this.g.getResources().getString(i));
        this.m = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.g.getResources().getString(x.group_update_done));
        this.b = (EditText) this.g.findViewById(u.edit_text);
        this.h = (ProgressBar) this.g.findViewById(u.progress);
        b(false);
        this.m.setOnClickListener(this.g);
        this.b.addTextChangedListener(this.n);
        this.e.setOnClickListener(this.g);
    }

    protected void b(boolean z) {
        this.l = z;
        this.e.setEnabled(z);
    }

    public boolean m() {
        return this.i != null && this.i.equals(this.b.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean l() {
        return l.c(this.b) || this.b.length() >= 3;
    }

    protected void n() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (this.l) {
                ay.e((View) this.e, t.navi_done_text_bg_1);
                this.e.setTextColor(this.g.getResources().getColorStateList(r.navi_done_text_1));
                return;
            }
            ay.e((View) this.e, t.btn_titlebar_finish_d_1);
            this.e.setTextColor(this.g.getResources().getColor(r.navi_done_text_d_1));
        } else if (this.l) {
            ay.e((View) this.e, t.navi_done_text_bg);
            this.e.setTextColor(this.g.getResources().getColorStateList(r.navi_done_text));
        } else {
            ay.e((View) this.e, t.btn_titlebar_finish_d);
            this.e.setTextColor(this.g.getResources().getColor(r.navi_done_text_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2, int i3, int i4) {
        if (i == 1) {
            b(false);
        } else if (i2 >= i3 && i2 <= i4) {
            b(true);
        } else {
            b(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(int i) {
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a(this.d);
        this.c.c(i);
        ay.b(this.d, i);
        ay.g(this.e, i);
        n();
        if (i == 1) {
            this.b.setHintTextColor(this.g.getResources().getColor(r.create_group_input_hintcolor_1));
            this.d.setBackgroundResource(r.create_group_pages_background_1);
            return;
        }
        this.b.setHintTextColor(this.g.getResources().getColor(r.create_group_input_hintcolor));
        this.d.setBackgroundResource(r.create_group_pages_background);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String k() {
        return this.b.getText().toString();
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(boolean z) {
        this.j = z;
        this.h.setVisibility(z ? 0 : 8);
    }

    public void b(String str) {
        this.b.setText(str);
        this.b.setSelection(this.b.getText().toString().length());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void a() {
        com.baidu.adp.lib.e.d.a(new AlertDialog.Builder(this.g).setTitle(x.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(x.group_update_alert_save).setPositiveButton(x.group_update_canel, new i(this)).setNegativeButton(x.group_update_done, new j(this)).create(), this.g);
    }
}
