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
/* loaded from: classes17.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean cgg;
    protected TextView eUl;
    protected ImageButton jky;
    private a.b jlx;
    private a.b jly;
    protected UpdateGroupActivity jzu;
    protected String jzv;
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
        this.jly = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.jlx = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cIs() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cDC() {
        return this.eUl;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cCR() {
        return this.jky;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void KA() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cDs() {
        return this.cgg;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.jly = null;
        this.jlx = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eUl = null;
        this.jky = null;
        this.jzu = null;
        this.progressBar = null;
        this.jzv = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.cgg = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cIt();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jzu = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.jzu.setContentView(i);
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
    public void Lb(String str) {
        this.jzv = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cIr() {
        return this.jzv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BK(int i) {
        this.mParent = this.jzu.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jzu.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jzu.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eUl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jzu.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eUl.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.eUl.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.jzu.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.jzu.findViewById(R.id.progress);
        qr(false);
        this.mImgBack.setOnClickListener(this.jzu);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.eUl.setOnClickListener(this.jzu);
    }

    protected void qr(boolean z) {
        this.cgg = z;
        this.eUl.setEnabled(z);
    }

    public boolean cIy() {
        return this.jzv != null && this.jzv.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cIv() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void cDt() {
        this.eUl.setEnabled(this.cgg);
        ap.setBackgroundResource(this.eUl, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(int i, int i2, int i3, int i4) {
        if (i == 1) {
            qr(false);
        } else if (i2 >= i3 && i2 <= i4) {
            qr(true);
        } else {
            qr(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.jzu.getLayoutMode().setNightMode(i == 1);
        this.jzu.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jzu.getPageContext(), i);
        ap.setFrsPBBgColor(this.mParent, i);
        ap.setBackgroundResource(this.eUl, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.eUl, R.color.navbar_btn_color, 1);
        cDt();
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
    public void Nv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jzu.getPageContext().getPageActivity());
        aVar.nt(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.jly != null) {
                    d.this.jly.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.jlx != null) {
                    d.this.jlx.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jzu.getPageContext());
        aVar.bhg();
    }
}
