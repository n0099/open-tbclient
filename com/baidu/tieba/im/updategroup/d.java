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
    protected ImageButton dUA;
    protected boolean dUP;
    private a.b dVA;
    private a.b dVz;
    protected UpdateGroupActivity eik;
    protected String eil;
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
        this.dVA = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.dVz = bVar;
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
        return this.dUA;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aCu() {
        return this.dUP;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.dVA = null;
        this.dVz = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aMR = null;
        this.dUA = null;
        this.eik = null;
        this.progressBar = null;
        this.eil = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.dUP = true;
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
        this.eik = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eik.setContentView(i);
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
        this.eil = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aHe() {
        return this.eil;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nZ(int i) {
        this.mParent = this.eik.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eik.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eik.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eik.getResources().getString(d.k.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMR.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.aMR.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.eik.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.eik.findViewById(d.g.progress);
        gT(false);
        this.mImgBack.setOnClickListener(this.eik);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.aMR.setOnClickListener(this.eik);
    }

    protected void gT(boolean z) {
        this.dUP = z;
        this.aMR.setEnabled(z);
    }

    public boolean aHl() {
        return this.eil != null && this.eil.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aHi() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aCv() {
        this.aMR.setEnabled(this.dUP);
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
        this.eik.getLayoutMode().setNightMode(i == 1);
        this.eik.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eik.getPageContext(), i);
        ak.f(this.mParent, i);
        ak.i(this.aMR, d.f.s_navbar_button_bg);
        ak.c(this.aMR, d.C0126d.navbar_btn_color, 1);
        aCv();
        this.mEditText.setHintTextColor(ak.cM(d.C0126d.common_color_10005));
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eik.getPageContext().getPageActivity());
        aVar.bZ(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.dVA != null) {
                    d.this.dVA.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.dVz != null) {
                    d.this.dVz.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eik.getPageContext());
        aVar.tD();
    }
}
