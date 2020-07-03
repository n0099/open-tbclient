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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes10.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean bYW;
    protected TextView eDq;
    protected ImageButton iOu;
    private a.b iPt;
    private a.b iPu;
    protected UpdateGroupActivity jbY;
    protected String jbZ;
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
        this.iPu = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.iPt = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cty() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cpf() {
        return this.eDq;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cou() {
        return this.iOu;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void EO() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean coV() {
        return this.bYW;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.iPu = null;
        this.iPt = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eDq = null;
        this.iOu = null;
        this.jbY = null;
        this.progressBar = null;
        this.jbZ = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.bYW = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.ctz();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jbY = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.jbY.setContentView(i);
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
    public void Hu(String str) {
        this.jbZ = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String ctx() {
        return this.jbZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yS(int i) {
        this.mParent = this.jbY.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jbY.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jbY.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eDq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jbY.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eDq.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.eDq.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.jbY.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.jbY.findViewById(R.id.progress);
        pf(false);
        this.mImgBack.setOnClickListener(this.jbY);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.eDq.setOnClickListener(this.jbY);
    }

    protected void pf(boolean z) {
        this.bYW = z;
        this.eDq.setEnabled(z);
    }

    public boolean ctE() {
        return this.jbZ != null && this.jbZ.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean ctB() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void coW() {
        this.eDq.setEnabled(this.bYW);
        an.setBackgroundResource(this.eDq, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(int i, int i2, int i3, int i4) {
        if (i == 1) {
            pf(false);
        } else if (i2 >= i3 && i2 <= i4) {
            pf(true);
        } else {
            pf(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.jbY.getLayoutMode().setNightMode(i == 1);
        this.jbY.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jbY.getPageContext(), i);
        an.setFrsPBBgColor(this.mParent, i);
        an.setBackgroundResource(this.eDq, R.drawable.s_navbar_button_bg);
        an.setViewTextColor(this.eDq, R.color.navbar_btn_color, 1);
        coW();
        this.mEditText.setHintTextColor(an.getColorList(R.color.common_color_10005));
        an.setBackgroundResource(this.mParent, R.color.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jbY.getPageContext().getPageActivity());
        aVar.kT(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.iPu != null) {
                    d.this.iPu.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.iPt != null) {
                    d.this.iPt.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jbY.getPageContext());
        aVar.aUN();
    }
}
