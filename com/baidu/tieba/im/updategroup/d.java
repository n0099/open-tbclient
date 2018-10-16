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
    protected TextView bdD;
    protected ImageButton eDJ;
    protected boolean eDY;
    private a.b eEI;
    private a.b eEJ;
    protected UpdateGroupActivity eRm;
    protected String eRn;
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
        this.eEJ = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.eEI = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aTe() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aOF() {
        return this.bdD;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aNT() {
        return this.eDJ;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aOv() {
        return this.eDY;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.eEJ = null;
        this.eEI = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bdD = null;
        this.eDJ = null;
        this.eRm = null;
        this.progressBar = null;
        this.eRn = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.eDY = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aTf();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eRm = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eRm.setContentView(i);
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
    public void pV(String str) {
        this.eRn = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aTd() {
        return this.eRn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pH(int i) {
        this.mParent = this.eRm.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eRm.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eRm.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bdD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eRm.getResources().getString(e.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdD.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0175e.ds16);
        this.bdD.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.eRm.findViewById(e.g.edit_text);
        this.progressBar = (ProgressBar) this.eRm.findViewById(e.g.progress);
        id(false);
        this.mImgBack.setOnClickListener(this.eRm);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.bdD.setOnClickListener(this.eRm);
    }

    protected void id(boolean z) {
        this.eDY = z;
        this.bdD.setEnabled(z);
    }

    public boolean aTk() {
        return this.eRn != null && this.eRn.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aTh() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aOw() {
        this.bdD.setEnabled(this.eDY);
        al.i(this.bdD, e.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i, int i2, int i3, int i4) {
        if (i == 1) {
            id(false);
        } else if (i2 >= i3 && i2 <= i4) {
            id(true);
        } else {
            id(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.eRm.getLayoutMode().setNightMode(i == 1);
        this.eRm.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eRm.getPageContext(), i);
        al.f(this.mParent, i);
        al.i(this.bdD, e.f.s_navbar_button_bg);
        al.c(this.bdD, e.d.navbar_btn_color, 1);
        aOw();
        this.mEditText.setHintTextColor(al.dl(e.d.common_color_10005));
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eRm.getPageContext().getPageActivity());
        aVar.cz(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eEJ != null) {
                    d.this.eEJ.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eEI != null) {
                    d.this.eEI.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eRm.getPageContext());
        aVar.Au();
    }
}
