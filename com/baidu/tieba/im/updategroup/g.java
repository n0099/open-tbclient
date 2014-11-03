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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.adp.base.f implements a {
    protected boolean Ty;
    protected ImageButton aTC;
    protected boolean aTT;
    protected ProgressBar aTV;
    private DialogInterface.OnClickListener aUJ;
    private DialogInterface.OnClickListener aUK;
    protected TextView aUx;
    TextWatcher afe;
    protected View agI;
    protected UpdateGroupActivity biP;
    protected String biQ;
    protected EditText mEditText;
    protected int mGroupId;
    protected View mImgBack;
    protected NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(DialogInterface.OnClickListener onClickListener) {
        this.aUK = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void d(DialogInterface.OnClickListener onClickListener) {
        this.aUJ = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View RM() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View LZ() {
        return this.aUx;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View Lm() {
        return this.aTC;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean LP() {
        return this.aTT;
    }

    public g(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.aUK = null;
        this.aUJ = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.agI = null;
        this.aUx = null;
        this.aTC = null;
        this.biP = null;
        this.aTV = null;
        this.biQ = null;
        this.Ty = false;
        this.mGroupId = 0;
        this.aTT = true;
        this.mImgBack = null;
        this.afe = new h(this);
        this.biP = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.biP.setContentView(i);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void setGroupId(int i) {
        this.mGroupId = i;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int getGroupId() {
        return this.mGroupId;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void gE(String str) {
        this.biQ = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String RL() {
        return this.biQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gm(int i) {
        this.agI = this.biP.findViewById(v.parent);
        this.mNavigationBar = (NavigationBar) this.biP.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.biP.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.biP.getResources().getString(y.group_update_done));
        this.mEditText = (EditText) this.biP.findViewById(v.edit_text);
        this.aTV = (ProgressBar) this.biP.findViewById(v.progress);
        cR(false);
        this.mImgBack.setOnClickListener(this.biP);
        this.mEditText.addTextChangedListener(this.afe);
        this.aUx.setOnClickListener(this.biP);
    }

    protected void cR(boolean z) {
        this.aTT = z;
        this.aUx.setEnabled(z);
    }

    public boolean RS() {
        return this.biQ != null && this.biQ.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean RP() {
        return com.baidu.tieba.im.util.j.d(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void LQ() {
        if (this.aTT) {
            aw.h((View) this.aUx, u.navi_done_text_bg);
            aw.b(this.aUx, s.navi_done_text, 1);
            return;
        }
        aw.h((View) this.aUx, u.btn_titlebar_finish_d);
        aw.b(this.aUx, s.navi_done_text_d, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, int i2, int i3, int i4) {
        if (i == 1) {
            cR(false);
        } else if (i2 >= i3 && i2 <= i4) {
            cR(true);
        } else {
            cR(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.biP.getLayoutMode().L(i == 1);
        this.biP.getLayoutMode().h(this.agI);
        this.mNavigationBar.onChangeSkinType(i);
        aw.e(this.agI, i);
        aw.f(this.aUx, i);
        LQ();
        this.mEditText.setHintTextColor(aw.bz(s.create_group_input_hintcolor));
        aw.h(this.agI, s.create_group_pages_background);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String getText() {
        return this.mEditText.getText().toString();
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void setIsLoading(boolean z) {
        this.Ty = z;
        this.aTV.setVisibility(z ? 0 : 8);
    }

    public void setText(String str) {
        this.mEditText.setText(str);
        this.mEditText.setSelection(this.mEditText.getText().toString().length());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void Ml() {
        com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this.biP).setTitle(y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(y.group_update_alert_save).setPositiveButton(y.group_update_canel, new i(this)).setNegativeButton(y.group_update_done, new j(this)).create(), this.biP);
    }
}
