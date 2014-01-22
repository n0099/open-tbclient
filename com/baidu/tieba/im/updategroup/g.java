package com.baidu.tieba.im.updategroup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.adp.a.e implements a {
    private DialogInterface.OnClickListener a;
    protected EditText c;
    protected NavigationBar d;
    protected View e;
    protected TextView f;
    protected ImageButton g;
    protected UpdateGroupActivity h;
    protected ProgressBar i;
    protected String j;
    protected boolean k;
    protected int l;
    protected boolean m;
    protected ImageView n;
    TextWatcher o;
    private DialogInterface.OnClickListener p;

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(DialogInterface.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(DialogInterface.OnClickListener onClickListener) {
        this.p = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View e() {
        return this.n;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View e_() {
        return this.f;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View d() {
        return this.g;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void f() {
        this.c.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean i() {
        return this.m;
    }

    public g(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.a = null;
        this.p = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = 0;
        this.m = true;
        this.n = null;
        this.o = new h(this);
        this.h = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.h.setContentView(i);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(int i) {
        this.l = i;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int h() {
        return this.l;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(String str) {
        this.j = str;
        b(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String f_() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i) {
        this.e = this.h.findViewById(R.id.parent);
        this.d = (NavigationBar) this.h.findViewById(R.id.view_navigation_bar);
        this.d.a(this.h.getResources().getString(i));
        this.n = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.h.getResources().getString(R.string.group_update_done));
        this.c = (EditText) this.h.findViewById(R.id.edit_text);
        this.i = (ProgressBar) this.h.findViewById(R.id.progress);
        b(false);
        this.n.setOnClickListener(this.h);
        this.c.addTextChangedListener(this.o);
        this.f.setOnClickListener(this.h);
    }

    protected void b(boolean z) {
        this.m = z;
        this.f.setEnabled(z);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean l() {
        return com.baidu.tieba.im.d.h.b(this.c) || this.c.length() >= 3;
    }

    protected void m() {
        if (TiebaApplication.h().al() == 1) {
            if (this.m) {
                bs.e((View) this.f, (int) R.drawable.navi_done_text_bg_1);
                this.f.setTextColor(this.h.getResources().getColorStateList(R.color.navi_done_text_1));
                return;
            }
            bs.e((View) this.f, (int) R.drawable.btn_titlebar_finish_d_1);
            this.f.setTextColor(this.h.getResources().getColor(R.color.navi_done_text_d_1));
        } else if (this.m) {
            bs.e((View) this.f, (int) R.drawable.navi_done_text_bg);
            this.f.setTextColor(this.h.getResources().getColorStateList(R.color.navi_done_text));
        } else {
            bs.e((View) this.f, (int) R.drawable.btn_titlebar_finish_d);
            this.f.setTextColor(this.h.getResources().getColor(R.color.navi_done_text_d));
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
        this.h.getLayoutMode().a(i == 1);
        this.h.getLayoutMode().a(this.e);
        this.d.c(i);
        bs.b(this.e, i);
        bs.h(this.f, i);
        m();
        if (i == 1) {
            this.c.setHintTextColor(this.h.getResources().getColor(R.color.create_group_input_hintcolor_1));
            this.e.setBackgroundResource(R.color.create_group_pages_background_1);
            return;
        }
        this.c.setHintTextColor(this.h.getResources().getColor(R.color.create_group_input_hintcolor));
        this.e.setBackgroundResource(R.color.create_group_pages_background);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String k() {
        return this.c.getText().toString();
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(boolean z) {
        this.k = z;
        this.i.setVisibility(z ? 0 : 8);
    }

    public void b(String str) {
        this.c.setText(str);
        this.c.setSelection(this.c.getText().toString().length());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void a() {
        new AlertDialog.Builder(this.h).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.group_update_alert_save).setPositiveButton(R.string.group_update_canel, new j(this)).setNegativeButton(R.string.group_update_done, new i(this)).create().show();
    }
}
