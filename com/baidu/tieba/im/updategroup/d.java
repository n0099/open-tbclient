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
/* loaded from: classes7.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean bhI;
    protected TextView dBx;
    protected UpdateGroupActivity hEr;
    protected String hEs;
    protected ImageButton hqK;
    private a.b hrJ;
    private a.b hrK;
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
        this.hrK = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.hrJ = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bVy() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bRf() {
        return this.dBx;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bQu() {
        return this.hqK;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void vC() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bQV() {
        return this.bhI;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.hrK = null;
        this.hrJ = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dBx = null;
        this.hqK = null;
        this.hEr = null;
        this.progressBar = null;
        this.hEs = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.bhI = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bVz();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hEr = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.hEr.setContentView(i);
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
    public void CX(String str) {
        this.hEs = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bVx() {
        return this.hEs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wJ(int i) {
        this.mParent = this.hEr.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hEr.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hEr.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dBx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hEr.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBx.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.dBx.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.hEr.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.hEr.findViewById(R.id.progress);
        nb(false);
        this.mImgBack.setOnClickListener(this.hEr);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.dBx.setOnClickListener(this.hEr);
    }

    protected void nb(boolean z) {
        this.bhI = z;
        this.dBx.setEnabled(z);
    }

    public boolean bVE() {
        return this.hEs != null && this.hEs.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bVB() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bQW() {
        this.dBx.setEnabled(this.bhI);
        am.setBackgroundResource(this.dBx, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i, int i2, int i3, int i4) {
        if (i == 1) {
            nb(false);
        } else if (i2 >= i3 && i2 <= i4) {
            nb(true);
        } else {
            nb(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.hEr.getLayoutMode().setNightMode(i == 1);
        this.hEr.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hEr.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.dBx, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.dBx, R.color.navbar_btn_color, 1);
        bQW();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hEr.getPageContext().getPageActivity());
        aVar.jF(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hrK != null) {
                    d.this.hrK.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hrJ != null) {
                    d.this.hrJ.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hEr.getPageContext());
        aVar.aBW();
    }
}
