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
    protected TextView biF;
    protected boolean ePK;
    protected ImageButton ePv;
    private a.b eQu;
    private a.b eQv;
    protected UpdateGroupActivity fcY;
    protected String fcZ;
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
        this.eQv = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.eQu = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aVG() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aRh() {
        return this.biF;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aQv() {
        return this.ePv;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aQX() {
        return this.ePK;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.eQv = null;
        this.eQu = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.biF = null;
        this.ePv = null;
        this.fcY = null;
        this.progressBar = null;
        this.fcZ = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.ePK = true;
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
        this.fcY = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.fcY.setContentView(i);
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
        this.fcZ = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aVF() {
        return this.fcZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qI(int i) {
        this.mParent = this.fcY.findViewById(e.g.parent);
        this.mNavigationBar = (NavigationBar) this.fcY.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.fcY.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.biF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fcY.getResources().getString(e.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.biF.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds16);
        this.biF.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.fcY.findViewById(e.g.edit_text);
        this.progressBar = (ProgressBar) this.fcY.findViewById(e.g.progress);
        is(false);
        this.mImgBack.setOnClickListener(this.fcY);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.biF.setOnClickListener(this.fcY);
    }

    protected void is(boolean z) {
        this.ePK = z;
        this.biF.setEnabled(z);
    }

    public boolean aVM() {
        return this.fcZ != null && this.fcZ.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aVJ() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aQY() {
        this.biF.setEnabled(this.ePK);
        al.i(this.biF, e.f.s_navbar_button_bg);
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
        this.fcY.getLayoutMode().setNightMode(i == 1);
        this.fcY.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.fcY.getPageContext(), i);
        al.f(this.mParent, i);
        al.i(this.biF, e.f.s_navbar_button_bg);
        al.c(this.biF, e.d.navbar_btn_color, 1);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fcY.getPageContext().getPageActivity());
        aVar.db(e.j.group_update_alert_save);
        aVar.a(e.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eQv != null) {
                    d.this.eQv.onClick(aVar2);
                }
            }
        });
        aVar.b(e.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eQu != null) {
                    d.this.eQu.onClick(aVar2);
                }
            }
        });
        aVar.b(this.fcY.getPageContext());
        aVar.BS();
    }
}
