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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected TextView aVM;
    protected ImageButton ekN;
    private a.b elM;
    private a.b elN;
    protected boolean elc;
    protected String eyA;
    protected UpdateGroupActivity eyz;
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
        this.elN = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.elM = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aME() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aId() {
        return this.aVM;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aHr() {
        return this.ekN;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aHU() {
        return this.elc;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.elN = null;
        this.elM = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aVM = null;
        this.ekN = null;
        this.eyz = null;
        this.progressBar = null;
        this.eyA = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.elc = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aMF();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eyz = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eyz.setContentView(i);
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
    public void oK(String str) {
        this.eyA = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aMD() {
        return this.eyA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void or(int i) {
        this.mParent = this.eyz.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eyz.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eyz.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eyz.getResources().getString(d.k.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aVM.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.aVM.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.eyz.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.eyz.findViewById(d.g.progress);
        hk(false);
        this.mImgBack.setOnClickListener(this.eyz);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.aVM.setOnClickListener(this.eyz);
    }

    protected void hk(boolean z) {
        this.elc = z;
        this.aVM.setEnabled(z);
    }

    public boolean aMK() {
        return this.eyA != null && this.eyA.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aMH() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aHV() {
        this.aVM.setEnabled(this.elc);
        am.i(this.aVM, d.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i, int i2, int i3, int i4) {
        if (i == 1) {
            hk(false);
        } else if (i2 >= i3 && i2 <= i4) {
            hk(true);
        } else {
            hk(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.eyz.getLayoutMode().setNightMode(i == 1);
        this.eyz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eyz.getPageContext(), i);
        am.f(this.mParent, i);
        am.i(this.aVM, d.f.s_navbar_button_bg);
        am.c(this.aVM, d.C0142d.navbar_btn_color, 1);
        aHV();
        this.mEditText.setHintTextColor(am.cQ(d.C0142d.common_color_10005));
        am.i(this.mParent, d.C0142d.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eyz.getPageContext().getPageActivity());
        aVar.cd(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.elN != null) {
                    d.this.elN.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.elM != null) {
                    d.this.elM.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eyz.getPageContext());
        aVar.xn();
    }
}
