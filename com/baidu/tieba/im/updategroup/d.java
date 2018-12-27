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
    protected TextView bhU;
    protected ImageButton eOJ;
    protected boolean eOY;
    private a.b ePI;
    private a.b ePJ;
    protected UpdateGroupActivity fcl;
    protected String fcm;
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
        this.ePJ = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.ePI = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aVg() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aQH() {
        return this.bhU;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aPV() {
        return this.eOJ;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aQx() {
        return this.eOY;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.ePJ = null;
        this.ePI = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bhU = null;
        this.eOJ = null;
        this.fcl = null;
        this.progressBar = null;
        this.fcm = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.eOY = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aVh();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.fcl = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.fcl.setContentView(i);
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
    public void qB(String str) {
        this.fcm = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aVf() {
        return this.fcm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qH(int i) {
        this.mParent = this.fcl.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.fcl.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fcl.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bhU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fcl.getResources().getString(e.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bhU.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        this.bhU.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.fcl.findViewById(e.g.edit_text);
        this.progressBar = (ProgressBar) this.fcl.findViewById(e.g.progress);
        is(false);
        this.mImgBack.setOnClickListener(this.fcl);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.bhU.setOnClickListener(this.fcl);
    }

    protected void is(boolean z) {
        this.eOY = z;
        this.bhU.setEnabled(z);
    }

    public boolean aVm() {
        return this.fcm != null && this.fcm.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aVj() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aQy() {
        this.bhU.setEnabled(this.eOY);
        al.i(this.bhU, e.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(int i, int i2, int i3, int i4) {
        if (i == 1) {
            is(false);
        } else if (i2 >= i3 && i2 <= i4) {
            is(true);
        } else {
            is(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.fcl.getLayoutMode().setNightMode(i == 1);
        this.fcl.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.fcl.getPageContext(), i);
        al.f(this.mParent, i);
        al.i(this.bhU, e.f.s_navbar_button_bg);
        al.c(this.bhU, e.d.navbar_btn_color, 1);
        aQy();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fcl.getPageContext().getPageActivity());
        aVar.db(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ePJ != null) {
                    d.this.ePJ.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ePI != null) {
                    d.this.ePI.onClick(aVar2);
                }
            }
        });
        aVar.b(this.fcl.getPageContext());
        aVar.BF();
    }
}
