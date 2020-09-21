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
/* loaded from: classes22.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean cim;
    protected TextView eXf;
    protected UpdateGroupActivity jIc;
    protected String jId;
    protected ImageButton jti;
    private a.b juh;
    private a.b jui;
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
        this.jui = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.juh = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cLZ() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cHj() {
        return this.eXf;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cGy() {
        return this.jti;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void Lh() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cGZ() {
        return this.cim;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.jui = null;
        this.juh = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eXf = null;
        this.jti = null;
        this.jIc = null;
        this.progressBar = null;
        this.jId = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.cim = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cMa();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jIc = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.jIc.setContentView(i);
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
    public void LE(String str) {
        this.jId = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cLY() {
        return this.jId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cl(int i) {
        this.mParent = this.jIc.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jIc.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jIc.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jIc.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXf.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.eXf.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.jIc.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.jIc.findViewById(R.id.progress);
        qB(false);
        this.mImgBack.setOnClickListener(this.jIc);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.eXf.setOnClickListener(this.jIc);
    }

    protected void qB(boolean z) {
        this.cim = z;
        this.eXf.setEnabled(z);
    }

    public boolean cMf() {
        return this.jId != null && this.jId.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cMc() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void cHa() {
        this.eXf.setEnabled(this.cim);
        ap.setBackgroundResource(this.eXf, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(int i, int i2, int i3, int i4) {
        if (i == 1) {
            qB(false);
        } else if (i2 >= i3 && i2 <= i4) {
            qB(true);
        } else {
            qB(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.jIc.getLayoutMode().setNightMode(i == 1);
        this.jIc.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jIc.getPageContext(), i);
        ap.setFrsPBBgColor(this.mParent, i);
        ap.setBackgroundResource(this.eXf, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.eXf, R.color.navbar_btn_color, 1);
        cHa();
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
    public void NY() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jIc.getPageContext().getPageActivity());
        aVar.nE(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.jui != null) {
                    d.this.jui.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.juh != null) {
                    d.this.juh.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jIc.getPageContext());
        aVar.bia();
    }
}
