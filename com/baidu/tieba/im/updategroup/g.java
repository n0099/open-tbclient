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
    protected boolean Tu;
    protected boolean aTF;
    protected ProgressBar aTH;
    protected ImageButton aTo;
    protected TextView aUj;
    private DialogInterface.OnClickListener aUv;
    private DialogInterface.OnClickListener aUw;
    TextWatcher aeW;
    protected View agA;
    protected UpdateGroupActivity biB;
    protected String biC;
    protected EditText mEditText;
    protected int mGroupId;
    protected View mImgBack;
    protected NavigationBar mNavigationBar;

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(DialogInterface.OnClickListener onClickListener) {
        this.aUw = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void d(DialogInterface.OnClickListener onClickListener) {
        this.aUv = onClickListener;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View RJ() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View LV() {
        return this.aUj;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View Li() {
        return this.aTo;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean LL() {
        return this.aTF;
    }

    public g(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.aUw = null;
        this.aUv = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.agA = null;
        this.aUj = null;
        this.aTo = null;
        this.biB = null;
        this.aTH = null;
        this.biC = null;
        this.Tu = false;
        this.mGroupId = 0;
        this.aTF = true;
        this.mImgBack = null;
        this.aeW = new h(this);
        this.biB = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.biB.setContentView(i);
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
        this.biC = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String RI() {
        return this.biC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gm(int i) {
        this.agA = this.biB.findViewById(v.parent);
        this.mNavigationBar = (NavigationBar) this.biB.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.biB.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.biB.getResources().getString(y.group_update_done));
        this.mEditText = (EditText) this.biB.findViewById(v.edit_text);
        this.aTH = (ProgressBar) this.biB.findViewById(v.progress);
        cR(false);
        this.mImgBack.setOnClickListener(this.biB);
        this.mEditText.addTextChangedListener(this.aeW);
        this.aUj.setOnClickListener(this.biB);
    }

    protected void cR(boolean z) {
        this.aTF = z;
        this.aUj.setEnabled(z);
    }

    public boolean RP() {
        return this.biC != null && this.biC.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean RM() {
        return com.baidu.tieba.im.util.j.d(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void LM() {
        if (this.aTF) {
            aw.h((View) this.aUj, u.navi_done_text_bg);
            aw.b(this.aUj, s.navi_done_text, 1);
            return;
        }
        aw.h((View) this.aUj, u.btn_titlebar_finish_d);
        aw.b(this.aUj, s.navi_done_text_d, 1);
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
        this.biB.getLayoutMode().L(i == 1);
        this.biB.getLayoutMode().h(this.agA);
        this.mNavigationBar.onChangeSkinType(i);
        aw.e(this.agA, i);
        aw.f(this.aUj, i);
        LM();
        this.mEditText.setHintTextColor(aw.bz(s.create_group_input_hintcolor));
        aw.h(this.agA, s.create_group_pages_background);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String getText() {
        return this.mEditText.getText().toString();
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void setIsLoading(boolean z) {
        this.Tu = z;
        this.aTH.setVisibility(z ? 0 : 8);
    }

    public void setText(String str) {
        this.mEditText.setText(str);
        this.mEditText.setSelection(this.mEditText.getText().toString().length());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void Mh() {
        com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this.biB).setTitle(y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(y.group_update_alert_save).setPositiveButton(y.group_update_canel, new i(this)).setNegativeButton(y.group_update_done, new j(this)).create(), this.biB);
    }
}
