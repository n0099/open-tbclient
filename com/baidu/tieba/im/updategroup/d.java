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
    protected ImageButton eDK;
    protected boolean eDZ;
    private a.b eEJ;
    private a.b eEK;
    protected UpdateGroupActivity eRn;
    protected String eRo;
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
        this.eEK = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.eEJ = bVar;
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
        return this.eDK;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aOv() {
        return this.eDZ;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.eEK = null;
        this.eEJ = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bdD = null;
        this.eDK = null;
        this.eRn = null;
        this.progressBar = null;
        this.eRo = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.eDZ = true;
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
        this.eRn = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eRn.setContentView(i);
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
        this.eRo = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aTd() {
        return this.eRo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pH(int i) {
        this.mParent = this.eRn.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eRn.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eRn.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bdD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eRn.getResources().getString(e.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdD.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0175e.ds16);
        this.bdD.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.eRn.findViewById(e.g.edit_text);
        this.progressBar = (ProgressBar) this.eRn.findViewById(e.g.progress);
        id(false);
        this.mImgBack.setOnClickListener(this.eRn);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.bdD.setOnClickListener(this.eRn);
    }

    protected void id(boolean z) {
        this.eDZ = z;
        this.bdD.setEnabled(z);
    }

    public boolean aTk() {
        return this.eRo != null && this.eRo.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aTh() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aOw() {
        this.bdD.setEnabled(this.eDZ);
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
        this.eRn.getLayoutMode().setNightMode(i == 1);
        this.eRn.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eRn.getPageContext(), i);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eRn.getPageContext().getPageActivity());
        aVar.cz(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eEK != null) {
                    d.this.eEK.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eEJ != null) {
                    d.this.eEJ.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eRn.getPageContext());
        aVar.Au();
    }
}
