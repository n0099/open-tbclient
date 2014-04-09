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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.adp.a.f implements a {
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
    protected View n;
    TextWatcher o;
    private DialogInterface.OnClickListener p;

    @Override // com.baidu.tieba.im.updategroup.a
    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final void b(DialogInterface.OnClickListener onClickListener) {
        this.p = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final View e() {
        return this.n;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final View g_() {
        return this.f;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final View d() {
        return this.g;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final void f() {
        this.c.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final boolean i() {
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
    public final void c(int i) {
        this.h.setContentView(i);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final void a(int i) {
        this.l = i;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final int h() {
        return this.l;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final void a(String str) {
        this.j = str;
        this.c.setText(str);
        this.c.setSelection(this.c.getText().toString().length());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final String h_() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(int i) {
        this.e = this.h.findViewById(com.baidu.tieba.im.h.parent);
        this.d = (NavigationBar) this.h.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.d.a(this.h.getResources().getString(i));
        this.n = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.h.getResources().getString(com.baidu.tieba.im.j.group_update_done));
        this.c = (EditText) this.h.findViewById(com.baidu.tieba.im.h.edit_text);
        this.i = (ProgressBar) this.h.findViewById(com.baidu.tieba.im.h.progress);
        b(false);
        this.n.setOnClickListener(this.h);
        this.c.addTextChangedListener(this.o);
        this.f.setOnClickListener(this.h);
    }

    private void b(boolean z) {
        this.m = z;
        this.f.setEnabled(z);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final boolean l() {
        boolean z;
        EditText editText = this.c;
        String editable = editText.getText().toString();
        int length = editable.length();
        String trim = editable.trim();
        if (trim.length() < length) {
            editText.setText(trim);
            z = false;
        } else {
            z = true;
        }
        return z || this.c.length() >= 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2, int i3, int i4) {
        if (i != 1 && i2 >= i3 && i2 <= i4) {
            b(true);
        } else {
            b(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final void b(int i) {
        this.h.getLayoutMode().a(i == 1);
        this.h.getLayoutMode().a(this.e);
        this.d.b(i);
        ba.b(this.e, i);
        ba.g(this.f, i);
        if (TbadkApplication.j().l() == 1) {
            if (this.m) {
                ba.e((View) this.f, com.baidu.tieba.im.g.navi_done_text_bg_1);
                this.f.setTextColor(this.h.getResources().getColorStateList(com.baidu.tieba.im.e.navi_done_text_1));
            } else {
                ba.e((View) this.f, com.baidu.tieba.im.g.btn_titlebar_finish_d_1);
                this.f.setTextColor(this.h.getResources().getColor(com.baidu.tieba.im.e.navi_done_text_d_1));
            }
        } else if (this.m) {
            ba.e((View) this.f, com.baidu.tieba.im.g.navi_done_text_bg);
            this.f.setTextColor(this.h.getResources().getColorStateList(com.baidu.tieba.im.e.navi_done_text));
        } else {
            ba.e((View) this.f, com.baidu.tieba.im.g.btn_titlebar_finish_d);
            this.f.setTextColor(this.h.getResources().getColor(com.baidu.tieba.im.e.navi_done_text_d));
        }
        if (i == 1) {
            this.c.setHintTextColor(this.h.getResources().getColor(com.baidu.tieba.im.e.create_group_input_hintcolor_1));
            this.e.setBackgroundResource(com.baidu.tieba.im.e.create_group_pages_background_1);
            return;
        }
        this.c.setHintTextColor(this.h.getResources().getColor(com.baidu.tieba.im.e.create_group_input_hintcolor));
        this.e.setBackgroundResource(com.baidu.tieba.im.e.create_group_pages_background);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final String k() {
        return this.c.getText().toString();
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final void a(boolean z) {
        this.k = z;
        this.i.setVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final void a() {
        new AlertDialog.Builder(this.h).setTitle(com.baidu.tieba.im.j.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.im.j.group_update_alert_save).setPositiveButton(com.baidu.tieba.im.j.group_update_canel, new i(this)).setNegativeButton(com.baidu.tieba.im.j.group_update_done, new j(this)).create().show();
    }
}
