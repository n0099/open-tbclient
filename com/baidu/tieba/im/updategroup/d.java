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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes17.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean can;
    protected TextView eJF;
    protected ImageButton iVz;
    private a.b iWy;
    private a.b iWz;
    protected UpdateGroupActivity jkv;
    protected String jkw;
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
        this.iWz = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.iWy = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cxB() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View csL() {
        return this.eJF;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View csa() {
        return this.iVz;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void EV() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean csB() {
        return this.can;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.iWz = null;
        this.iWy = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eJF = null;
        this.iVz = null;
        this.jkv = null;
        this.progressBar = null;
        this.jkw = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.can = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cxC();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jkv = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.jkv.setContentView(i);
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
    public void Ij(String str) {
        this.jkw = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cxA() {
        return this.jkw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zr(int i) {
        this.mParent = this.jkv.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jkv.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jkv.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jkv.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJF.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.eJF.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.jkv.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.jkv.findViewById(R.id.progress);
        pL(false);
        this.mImgBack.setOnClickListener(this.jkv);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.eJF.setOnClickListener(this.jkv);
    }

    protected void pL(boolean z) {
        this.can = z;
        this.eJF.setEnabled(z);
    }

    public boolean cxH() {
        return this.jkw != null && this.jkw.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cxE() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void csC() {
        this.eJF.setEnabled(this.can);
        ao.setBackgroundResource(this.eJF, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(int i, int i2, int i3, int i4) {
        if (i == 1) {
            pL(false);
        } else if (i2 >= i3 && i2 <= i4) {
            pL(true);
        } else {
            pL(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.jkv.getLayoutMode().setNightMode(i == 1);
        this.jkv.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jkv.getPageContext(), i);
        ao.setFrsPBBgColor(this.mParent, i);
        ao.setBackgroundResource(this.eJF, R.drawable.s_navbar_button_bg);
        ao.setViewTextColor(this.eJF, R.color.navbar_btn_color, 1);
        csC();
        this.mEditText.setHintTextColor(ao.getColorList(R.color.common_color_10005));
        ao.setBackgroundResource(this.mParent, R.color.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jkv.getPageContext().getPageActivity());
        aVar.ln(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.iWz != null) {
                    d.this.iWz.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.iWy != null) {
                    d.this.iWy.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jkv.getPageContext());
        aVar.aYL();
    }
}
