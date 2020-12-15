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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes23.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected TextView fEM;
    protected UpdateGroupActivity kDD;
    protected String kDE;
    protected ImageButton koR;
    private a.b kpQ;
    private a.b kpR;
    protected EditText mEditText;
    protected long mGroupId;
    protected View mImgBack;
    protected boolean mIsEnabled;
    protected boolean mIsLoading;
    protected NavigationBar mNavigationBar;
    protected View mParent;
    TextWatcher mTextWatcher;
    protected ProgressBar progressBar;

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.kpR = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.kpQ = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View dai() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cVv() {
        return this.fEM;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cUK() {
        return this.koR;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void OS() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cVl() {
        return this.mIsEnabled;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.kpR = null;
        this.kpQ = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.fEM = null;
        this.koR = null;
        this.kDD = null;
        this.progressBar = null;
        this.kDE = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.mIsEnabled = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.daj();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kDD = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.kDD.setContentView(i);
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
    public void NR(String str) {
        this.kDE = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String dah() {
        return this.kDE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EK(int i) {
        this.mParent = this.kDD.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kDD.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kDD.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fEM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kDD.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fEM.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.fEM.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.kDD.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.kDD.findViewById(R.id.progress);
        sn(false);
        this.mImgBack.setOnClickListener(this.kDD);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.fEM.setOnClickListener(this.kDD);
    }

    protected void sn(boolean z) {
        this.mIsEnabled = z;
        this.fEM.setEnabled(z);
    }

    public boolean dao() {
        return this.kDE != null && this.kDE.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean dal() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void cVm() {
        this.fEM.setEnabled(this.mIsEnabled);
        ap.setBackgroundResource(this.fEM, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(int i, int i2, int i3, int i4) {
        if (i == 1) {
            sn(false);
        } else if (i2 >= i3 && i2 <= i4) {
            sn(true);
        } else {
            sn(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.kDD.getLayoutMode().setNightMode(i == 1);
        this.kDD.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kDD.getPageContext(), i);
        ap.setFrsPBBgColor(this.mParent, i);
        ap.setBackgroundResource(this.fEM, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.fEM, R.color.navbar_btn_color, 1);
        cVm();
        this.mEditText.setHintTextColor(ap.getColorList(R.color.common_color_10005));
        ap.setBackgroundResource(this.mParent, R.color.common_color_10041);
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
    public void RU() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDD.getPageContext().getPageActivity());
        aVar.oQ(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.kpR != null) {
                    d.this.kpR.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.kpQ != null) {
                    d.this.kpQ.onClick(aVar2);
                }
            }
        });
        aVar.b(this.kDD.getPageContext());
        aVar.brv();
    }
}
