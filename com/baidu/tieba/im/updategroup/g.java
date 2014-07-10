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
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.e.t;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
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
        this.d = this.g.findViewById(v.parent);
        this.c = (NavigationBar) this.g.findViewById(v.view_navigation_bar);
        this.c.a(this.g.getResources().getString(i));
        this.m = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.g.getResources().getString(y.group_update_done));
        this.b = (EditText) this.g.findViewById(v.edit_text);
        this.h = (ProgressBar) this.g.findViewById(v.progress);
        b(false);
        this.m.setOnClickListener(this.g);
        this.b.addTextChangedListener(this.n);
        this.e.setOnClickListener(this.g);
    }

    protected void b(boolean z) {
        this.l = z;
        this.e.setEnabled(z);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean l() {
        return t.c(this.b) || this.b.length() >= 3;
    }

    protected void m() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (this.l) {
                bk.e((View) this.e, u.navi_done_text_bg_1);
                this.e.setTextColor(this.g.getResources().getColorStateList(s.navi_done_text_1));
                return;
            }
            bk.e((View) this.e, u.btn_titlebar_finish_d_1);
            this.e.setTextColor(this.g.getResources().getColor(s.navi_done_text_d_1));
        } else if (this.l) {
            bk.e((View) this.e, u.navi_done_text_bg);
            this.e.setTextColor(this.g.getResources().getColorStateList(s.navi_done_text));
        } else {
            bk.e((View) this.e, u.btn_titlebar_finish_d);
            this.e.setTextColor(this.g.getResources().getColor(s.navi_done_text_d));
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
        bk.b(this.d, i);
        bk.g(this.e, i);
        m();
        if (i == 1) {
            this.b.setHintTextColor(this.g.getResources().getColor(s.create_group_input_hintcolor_1));
            this.d.setBackgroundResource(s.create_group_pages_background_1);
            return;
        }
        this.b.setHintTextColor(this.g.getResources().getColor(s.create_group_input_hintcolor));
        this.d.setBackgroundResource(s.create_group_pages_background);
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
        new AlertDialog.Builder(this.g).setTitle(y.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(y.group_update_alert_save).setPositiveButton(y.group_update_canel, new i(this)).setNegativeButton(y.group_update_done, new j(this)).create().show();
    }
}
