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
    protected TextView ber;
    protected ImageButton eFd;
    protected boolean eFs;
    private a.b eGc;
    private a.b eGd;
    protected UpdateGroupActivity eSF;
    protected String eSG;
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
        this.eGd = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.eGc = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aSB() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aOc() {
        return this.ber;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aNq() {
        return this.eFd;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aNS() {
        return this.eFs;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.eGd = null;
        this.eGc = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.ber = null;
        this.eFd = null;
        this.eSF = null;
        this.progressBar = null;
        this.eSG = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.eFs = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aSC();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eSF = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eSF.setContentView(i);
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
    public void pW(String str) {
        this.eSG = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aSA() {
        return this.eSG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qa(int i) {
        this.mParent = this.eSF.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.eSF.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eSF.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ber = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eSF.getResources().getString(e.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ber.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0200e.ds16);
        this.ber.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.eSF.findViewById(e.g.edit_text);
        this.progressBar = (ProgressBar) this.eSF.findViewById(e.g.progress);
        im(false);
        this.mImgBack.setOnClickListener(this.eSF);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.ber.setOnClickListener(this.eSF);
    }

    protected void im(boolean z) {
        this.eFs = z;
        this.ber.setEnabled(z);
    }

    public boolean aSH() {
        return this.eSG != null && this.eSG.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aSE() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aNT() {
        this.ber.setEnabled(this.eFs);
        al.i(this.ber, e.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i, int i2, int i3, int i4) {
        if (i == 1) {
            im(false);
        } else if (i2 >= i3 && i2 <= i4) {
            im(true);
        } else {
            im(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.eSF.getLayoutMode().setNightMode(i == 1);
        this.eSF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eSF.getPageContext(), i);
        al.f(this.mParent, i);
        al.i(this.ber, e.f.s_navbar_button_bg);
        al.c(this.ber, e.d.navbar_btn_color, 1);
        aNT();
        this.mEditText.setHintTextColor(al.dz(e.d.common_color_10005));
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSF.getPageContext().getPageActivity());
        aVar.cN(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eGd != null) {
                    d.this.eGd.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eGc != null) {
                    d.this.eGc.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eSF.getPageContext());
        aVar.AB();
    }
}
