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
    protected boolean bLl;
    protected TextView efY;
    protected ImageButton ihT;
    private a.b iiS;
    private a.b iiT;
    protected UpdateGroupActivity ivD;
    protected String ivE;
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
        this.iiT = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.iiS = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cjc() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View ceJ() {
        return this.efY;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cdX() {
        return this.ihT;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void CO() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cez() {
        return this.bLl;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.iiT = null;
        this.iiS = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.efY = null;
        this.ihT = null;
        this.ivD = null;
        this.progressBar = null;
        this.ivE = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.bLl = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cjd();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.ivD = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.ivD.setContentView(i);
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
    public void Fj(String str) {
        this.ivE = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cjb() {
        return this.ivE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xA(int i) {
        this.mParent = this.ivD.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.ivD.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ivD.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.efY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ivD.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efY.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.efY.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.ivD.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.ivD.findViewById(R.id.progress);
        oz(false);
        this.mImgBack.setOnClickListener(this.ivD);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.efY.setOnClickListener(this.ivD);
    }

    protected void oz(boolean z) {
        this.bLl = z;
        this.efY.setEnabled(z);
    }

    public boolean cji() {
        return this.ivE != null && this.ivE.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cjf() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void ceA() {
        this.efY.setEnabled(this.bLl);
        am.setBackgroundResource(this.efY, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i, int i2, int i3, int i4) {
        if (i == 1) {
            oz(false);
        } else if (i2 >= i3 && i2 <= i4) {
            oz(true);
        } else {
            oz(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.ivD.getLayoutMode().setNightMode(i == 1);
        this.ivD.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ivD.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.efY, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.efY, R.color.navbar_btn_color, 1);
        ceA();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ivD.getPageContext().getPageActivity());
        aVar.kd(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.iiT != null) {
                    d.this.iiT.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.iiS != null) {
                    d.this.iiS.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ivD.getPageContext());
        aVar.aMS();
    }
}
