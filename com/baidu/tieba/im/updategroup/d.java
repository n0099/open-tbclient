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
    protected TextView aMR;
    protected ImageButton dUD;
    protected boolean dUS;
    private a.b dVC;
    private a.b dVD;
    protected UpdateGroupActivity ein;
    protected String eio;
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
        this.dVD = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.dVC = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aHf() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aCD() {
        return this.aMR;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aBR() {
        return this.dUD;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aCu() {
        return this.dUS;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.dVD = null;
        this.dVC = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aMR = null;
        this.dUD = null;
        this.ein = null;
        this.progressBar = null;
        this.eio = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.dUS = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aHg();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.ein = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.ein.setContentView(i);
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
    public void nS(String str) {
        this.eio = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aHe() {
        return this.eio;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oa(int i) {
        this.mParent = this.ein.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.ein.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ein.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ein.getResources().getString(d.k.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMR.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.aMR.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.ein.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.ein.findViewById(d.g.progress);
        gT(false);
        this.mImgBack.setOnClickListener(this.ein);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.aMR.setOnClickListener(this.ein);
    }

    protected void gT(boolean z) {
        this.dUS = z;
        this.aMR.setEnabled(z);
    }

    public boolean aHl() {
        return this.eio != null && this.eio.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aHi() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aCv() {
        this.aMR.setEnabled(this.dUS);
        ak.i(this.aMR, d.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i, int i2, int i3, int i4) {
        if (i == 1) {
            gT(false);
        } else if (i2 >= i3 && i2 <= i4) {
            gT(true);
        } else {
            gT(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.ein.getLayoutMode().setNightMode(i == 1);
        this.ein.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ein.getPageContext(), i);
        ak.f(this.mParent, i);
        ak.i(this.aMR, d.f.s_navbar_button_bg);
        ak.c(this.aMR, d.C0126d.navbar_btn_color, 1);
        aCv();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ein.getPageContext().getPageActivity());
        aVar.ca(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.dVD != null) {
                    d.this.dVD.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.dVC != null) {
                    d.this.dVC.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ein.getPageContext());
        aVar.tD();
    }
}
