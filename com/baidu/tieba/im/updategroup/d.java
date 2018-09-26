package com.baidu.tieba.im.updategroup;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected TextView aZd;
    protected UpdateGroupActivity eJD;
    protected String eJE;
    protected ImageButton evV;
    private a.b ewU;
    private a.b ewV;
    protected boolean ewk;
    protected EditText mEditText;
    protected long mGroupId;
    protected View mImgBack;
    protected boolean mIsLoading;
    protected NavigationBar mNavigationBar;
    protected View mParent;
    TextWatcher mTextWatcher;
    protected ProgressBar progressBar;

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(a.b bVar) {
        this.ewV = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.ewU = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aPQ() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aLq() {
        return this.aZd;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aKD() {
        return this.evV;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aLg() {
        return this.ewk;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.ewV = null;
        this.ewU = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aZd = null;
        this.evV = null;
        this.eJD = null;
        this.progressBar = null;
        this.eJE = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.ewk = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aPR();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eJD = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eJD.setContentView(i);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void setGroupId(long j) {
        this.mGroupId = j;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public long getGroupId() {
        return this.mGroupId;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void pt(String str) {
        this.eJE = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aPP() {
        return this.eJE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pj(int i) {
        this.mParent = this.eJD.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eJD.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eJD.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aZd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eJD.getResources().getString(e.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aZd.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0141e.ds16);
        this.aZd.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.eJD.findViewById(e.g.edit_text);
        this.progressBar = (ProgressBar) this.eJD.findViewById(e.g.progress);
        hL(false);
        this.mImgBack.setOnClickListener(this.eJD);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.aZd.setOnClickListener(this.eJD);
    }

    protected void hL(boolean z) {
        this.ewk = z;
        this.aZd.setEnabled(z);
    }

    public boolean aPW() {
        return this.eJE != null && this.eJE.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aPT() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aLh() {
        this.aZd.setEnabled(this.ewk);
        al.i(this.aZd, e.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i, int i2, int i3, int i4) {
        if (i == 1) {
            hL(false);
        } else if (i2 >= i3 && i2 <= i4) {
            hL(true);
        } else {
            hL(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.eJD.getLayoutMode().setNightMode(i == 1);
        this.eJD.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eJD.getPageContext(), i);
        al.f(this.mParent, i);
        al.i(this.aZd, e.f.s_navbar_button_bg);
        al.c(this.aZd, e.d.navbar_btn_color, 1);
        aLh();
        this.mEditText.setHintTextColor(al.db(e.d.common_color_10005));
        al.i(this.mParent, e.d.common_color_10041);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String getText() {
        return this.mEditText.getText().toString();
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void setText(String str) {
        this.mEditText.setText(str);
        this.mEditText.setSelection(this.mEditText.getText().toString().length());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void release() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eJD.getPageContext().getPageActivity());
        aVar.cp(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ewV != null) {
                    d.this.ewV.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ewU != null) {
                    d.this.ewU.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eJD.getPageContext());
        aVar.yl();
    }
}
