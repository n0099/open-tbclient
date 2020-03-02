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
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes10.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean bmL;
    protected TextView dFJ;
    protected UpdateGroupActivity hJV;
    protected String hJW;
    protected ImageButton hwo;
    private a.b hxn;
    private a.b hxo;
    protected EditText mEditText;
    protected long mGroupId;
    protected View mImgBack;
    protected boolean mIsLoading;
    protected NavigationBar mNavigationBar;
    protected View mParent;
    TextWatcher mTextWatcher;
    protected ProgressBar progressBar;

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.hxo = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.hxn = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bYk() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bTR() {
        return this.dFJ;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bTg() {
        return this.hwo;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void xS() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bTH() {
        return this.bmL;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.hxo = null;
        this.hxn = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dFJ = null;
        this.hwo = null;
        this.hJV = null;
        this.progressBar = null;
        this.hJW = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.bmL = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bYl();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hJV = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.hJV.setContentView(i);
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
    public void Dx(String str) {
        this.hJW = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bYj() {
        return this.hJW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wU(int i) {
        this.mParent = this.hJV.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hJV.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hJV.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hJV.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFJ.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.dFJ.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.hJV.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.hJV.findViewById(R.id.progress);
        np(false);
        this.mImgBack.setOnClickListener(this.hJV);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.dFJ.setOnClickListener(this.hJV);
    }

    protected void np(boolean z) {
        this.bmL = z;
        this.dFJ.setEnabled(z);
    }

    public boolean bYq() {
        return this.hJW != null && this.hJW.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bYn() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bTI() {
        this.dFJ.setEnabled(this.bmL);
        am.setBackgroundResource(this.dFJ, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i, int i2, int i3, int i4) {
        if (i == 1) {
            np(false);
        } else if (i2 >= i3 && i2 <= i4) {
            np(true);
        } else {
            np(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.hJV.getLayoutMode().setNightMode(i == 1);
        this.hJV.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hJV.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.dFJ, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.dFJ, R.color.navbar_btn_color, 1);
        bTI();
        this.mEditText.setHintTextColor(am.getColorList(R.color.common_color_10005));
        am.setBackgroundResource(this.mParent, R.color.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hJV.getPageContext().getPageActivity());
        aVar.jW(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hxo != null) {
                    d.this.hxo.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hxn != null) {
                    d.this.hxn.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hJV.getPageContext());
        aVar.aEC();
    }
}
