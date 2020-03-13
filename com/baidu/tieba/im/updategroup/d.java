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
    protected boolean bmM;
    protected TextView dFW;
    protected UpdateGroupActivity hKh;
    protected String hKi;
    protected ImageButton hwA;
    private a.b hxA;
    private a.b hxz;
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
        this.hxA = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.hxz = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bYl() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bTS() {
        return this.dFW;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bTh() {
        return this.hwA;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void xS() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bTI() {
        return this.bmM;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.hxA = null;
        this.hxz = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dFW = null;
        this.hwA = null;
        this.hKh = null;
        this.progressBar = null;
        this.hKi = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.bmM = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bYm();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hKh = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.hKh.setContentView(i);
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
    public void Dy(String str) {
        this.hKi = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bYk() {
        return this.hKi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wU(int i) {
        this.mParent = this.hKh.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hKh.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hKh.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hKh.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFW.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.dFW.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.hKh.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.hKh.findViewById(R.id.progress);
        np(false);
        this.mImgBack.setOnClickListener(this.hKh);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.dFW.setOnClickListener(this.hKh);
    }

    protected void np(boolean z) {
        this.bmM = z;
        this.dFW.setEnabled(z);
    }

    public boolean bYr() {
        return this.hKi != null && this.hKi.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bYo() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bTJ() {
        this.dFW.setEnabled(this.bmM);
        am.setBackgroundResource(this.dFW, R.drawable.s_navbar_button_bg);
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
        this.hKh.getLayoutMode().setNightMode(i == 1);
        this.hKh.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hKh.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.dFW, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.dFW, R.color.navbar_btn_color, 1);
        bTJ();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hKh.getPageContext().getPageActivity());
        aVar.jW(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hxA != null) {
                    d.this.hxA.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hxz != null) {
                    d.this.hxz.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hKh.getPageContext());
        aVar.aEC();
    }
}
