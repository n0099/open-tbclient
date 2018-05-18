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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected TextView aMS;
    protected ImageButton dVH;
    protected boolean dVW;
    private a.b dWG;
    private a.b dWH;
    protected UpdateGroupActivity ejr;
    protected String ejs;
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
        this.dWH = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.dWG = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aHd() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aCB() {
        return this.aMS;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aBP() {
        return this.dVH;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aCs() {
        return this.dVW;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.dWH = null;
        this.dWG = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aMS = null;
        this.dVH = null;
        this.ejr = null;
        this.progressBar = null;
        this.ejs = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.dVW = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aHe();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.ejr = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.ejr.setContentView(i);
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
    public void nV(String str) {
        this.ejs = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aHc() {
        return this.ejs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nY(int i) {
        this.mParent = this.ejr.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.ejr.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ejr.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ejr.getResources().getString(d.k.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMS.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.aMS.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.ejr.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.ejr.findViewById(d.g.progress);
        gU(false);
        this.mImgBack.setOnClickListener(this.ejr);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.aMS.setOnClickListener(this.ejr);
    }

    protected void gU(boolean z) {
        this.dVW = z;
        this.aMS.setEnabled(z);
    }

    public boolean aHj() {
        return this.ejs != null && this.ejs.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aHg() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aCt() {
        this.aMS.setEnabled(this.dVW);
        ak.i(this.aMS, d.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i, int i2, int i3, int i4) {
        if (i == 1) {
            gU(false);
        } else if (i2 >= i3 && i2 <= i4) {
            gU(true);
        } else {
            gU(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.ejr.getLayoutMode().setNightMode(i == 1);
        this.ejr.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ejr.getPageContext(), i);
        ak.f(this.mParent, i);
        ak.i(this.aMS, d.f.s_navbar_button_bg);
        ak.c(this.aMS, d.C0126d.navbar_btn_color, 1);
        aCt();
        this.mEditText.setHintTextColor(ak.cN(d.C0126d.common_color_10005));
        ak.i(this.mParent, d.C0126d.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ejr.getPageContext().getPageActivity());
        aVar.ca(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.dWH != null) {
                    d.this.dWH.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.dWG != null) {
                    d.this.dWG.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ejr.getPageContext());
        aVar.tC();
    }
}
