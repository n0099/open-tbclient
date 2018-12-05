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
    protected TextView bhR;
    protected ImageButton eLS;
    private a.b eMR;
    private a.b eMS;
    protected boolean eMh;
    protected UpdateGroupActivity eZu;
    protected String eZv;
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
        this.eMS = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.eMR = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aUt() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aPU() {
        return this.bhR;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aPi() {
        return this.eLS;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aPK() {
        return this.eMh;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.eMS = null;
        this.eMR = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bhR = null;
        this.eLS = null;
        this.eZu = null;
        this.progressBar = null;
        this.eZv = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.eMh = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aUu();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eZu = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eZu.setContentView(i);
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
    public void qy(String str) {
        this.eZv = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aUs() {
        return this.eZv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qu(int i) {
        this.mParent = this.eZu.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eZu.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eZu.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bhR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eZu.getResources().getString(e.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bhR.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        this.bhR.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.eZu.findViewById(e.g.edit_text);
        this.progressBar = (ProgressBar) this.eZu.findViewById(e.g.progress);
        ip(false);
        this.mImgBack.setOnClickListener(this.eZu);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.bhR.setOnClickListener(this.eZu);
    }

    protected void ip(boolean z) {
        this.eMh = z;
        this.bhR.setEnabled(z);
    }

    public boolean aUz() {
        return this.eZv != null && this.eZv.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aUw() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aPL() {
        this.bhR.setEnabled(this.eMh);
        al.i(this.bhR, e.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(int i, int i2, int i3, int i4) {
        if (i == 1) {
            ip(false);
        } else if (i2 >= i3 && i2 <= i4) {
            ip(true);
        } else {
            ip(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.eZu.getLayoutMode().setNightMode(i == 1);
        this.eZu.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eZu.getPageContext(), i);
        al.f(this.mParent, i);
        al.i(this.bhR, e.f.s_navbar_button_bg);
        al.c(this.bhR, e.d.navbar_btn_color, 1);
        aPL();
        this.mEditText.setHintTextColor(al.dN(e.d.common_color_10005));
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eZu.getPageContext().getPageActivity());
        aVar.db(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eMS != null) {
                    d.this.eMS.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eMR != null) {
                    d.this.eMR.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eZu.getPageContext());
        aVar.BF();
    }
}
