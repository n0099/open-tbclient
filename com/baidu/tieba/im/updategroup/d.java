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
    protected TextView biG;
    protected boolean ePL;
    protected ImageButton ePw;
    private a.b eQv;
    private a.b eQw;
    protected UpdateGroupActivity fcZ;
    protected String fda;
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
        this.eQw = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.eQv = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aVG() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aRh() {
        return this.biG;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aQv() {
        return this.ePw;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aQX() {
        return this.ePL;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.eQw = null;
        this.eQv = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.biG = null;
        this.ePw = null;
        this.fcZ = null;
        this.progressBar = null;
        this.fda = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.ePL = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aVH();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.fcZ = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.fcZ.setContentView(i);
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
    public void qR(String str) {
        this.fda = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aVF() {
        return this.fda;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qI(int i) {
        this.mParent = this.fcZ.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.fcZ.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fcZ.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.biG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fcZ.getResources().getString(e.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.biG.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        this.biG.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.fcZ.findViewById(e.g.edit_text);
        this.progressBar = (ProgressBar) this.fcZ.findViewById(e.g.progress);
        is(false);
        this.mImgBack.setOnClickListener(this.fcZ);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.biG.setOnClickListener(this.fcZ);
    }

    protected void is(boolean z) {
        this.ePL = z;
        this.biG.setEnabled(z);
    }

    public boolean aVM() {
        return this.fda != null && this.fda.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aVJ() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aQY() {
        this.biG.setEnabled(this.ePL);
        al.i(this.biG, e.f.s_navbar_button_bg);
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
        this.fcZ.getLayoutMode().setNightMode(i == 1);
        this.fcZ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.fcZ.getPageContext(), i);
        al.f(this.mParent, i);
        al.i(this.biG, e.f.s_navbar_button_bg);
        al.c(this.biG, e.d.navbar_btn_color, 1);
        aQY();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fcZ.getPageContext().getPageActivity());
        aVar.db(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eQw != null) {
                    d.this.eQw.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eQv != null) {
                    d.this.eQv.onClick(aVar2);
                }
            }
        });
        aVar.b(this.fcZ.getPageContext());
        aVar.BS();
    }
}
