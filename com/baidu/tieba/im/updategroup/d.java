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
/* loaded from: classes8.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean biA;
    protected TextView dBH;
    protected UpdateGroupActivity hHU;
    protected String hHV;
    protected ImageButton hun;
    private a.b hvm;
    private a.b hvn;
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
        this.hvn = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.hvm = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bWH() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bSo() {
        return this.dBH;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bRD() {
        return this.hun;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void vT() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bSe() {
        return this.biA;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.hvn = null;
        this.hvm = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dBH = null;
        this.hun = null;
        this.hHU = null;
        this.progressBar = null;
        this.hHV = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.biA = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bWI();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hHU = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.hHU.setContentView(i);
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
    public void Dh(String str) {
        this.hHV = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bWG() {
        return this.hHV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wO(int i) {
        this.mParent = this.hHU.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hHU.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hHU.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dBH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hHU.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBH.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.dBH.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.hHU.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.hHU.findViewById(R.id.progress);
        nn(false);
        this.mImgBack.setOnClickListener(this.hHU);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.dBH.setOnClickListener(this.hHU);
    }

    protected void nn(boolean z) {
        this.biA = z;
        this.dBH.setEnabled(z);
    }

    public boolean bWN() {
        return this.hHV != null && this.hHV.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bWK() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bSf() {
        this.dBH.setEnabled(this.biA);
        am.setBackgroundResource(this.dBH, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i, int i2, int i3, int i4) {
        if (i == 1) {
            nn(false);
        } else if (i2 >= i3 && i2 <= i4) {
            nn(true);
        } else {
            nn(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.hHU.getLayoutMode().setNightMode(i == 1);
        this.hHU.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hHU.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.dBH, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.dBH, R.color.navbar_btn_color, 1);
        bSf();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hHU.getPageContext().getPageActivity());
        aVar.jF(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hvn != null) {
                    d.this.hvn.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hvm != null) {
                    d.this.hvm.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hHU.getPageContext());
        aVar.aCp();
    }
}
