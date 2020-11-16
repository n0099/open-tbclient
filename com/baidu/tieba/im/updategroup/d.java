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
    protected boolean cHk;
    protected TextView fwX;
    protected ImageButton kbl;
    private a.b kck;
    private a.b kcl;
    protected UpdateGroupActivity kqf;
    protected String kqg;
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
        this.kcl = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.kck = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cUV() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cQg() {
        return this.fwX;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cPv() {
        return this.kbl;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void Mx() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cPW() {
        return this.cHk;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.kcl = null;
        this.kck = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.fwX = null;
        this.kbl = null;
        this.kqf = null;
        this.progressBar = null;
        this.kqg = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.cHk = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cUW();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kqf = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.kqf.setContentView(i);
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
    public void MJ(String str) {
        this.kqg = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cUU() {
        return this.kqg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DV(int i) {
        this.mParent = this.kqf.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kqf.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kqf.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fwX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kqf.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fwX.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.fwX.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.kqf.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.kqf.findViewById(R.id.progress);
        rL(false);
        this.mImgBack.setOnClickListener(this.kqf);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.fwX.setOnClickListener(this.kqf);
    }

    protected void rL(boolean z) {
        this.cHk = z;
        this.fwX.setEnabled(z);
    }

    public boolean cVb() {
        return this.kqg != null && this.kqg.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cUY() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void cPX() {
        this.fwX.setEnabled(this.cHk);
        ap.setBackgroundResource(this.fwX, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(int i, int i2, int i3, int i4) {
        if (i == 1) {
            rL(false);
        } else if (i2 >= i3 && i2 <= i4) {
            rL(true);
        } else {
            rL(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.kqf.getLayoutMode().setNightMode(i == 1);
        this.kqf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kqf.getPageContext(), i);
        ap.setFrsPBBgColor(this.mParent, i);
        ap.setBackgroundResource(this.fwX, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.fwX, R.color.navbar_btn_color, 1);
        cPX();
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
    public void PA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kqf.getPageContext().getPageActivity());
        aVar.os(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.kcl != null) {
                    d.this.kcl.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.kck != null) {
                    d.this.kck.onClick(aVar2);
                }
            }
        });
        aVar.b(this.kqf.getPageContext());
        aVar.bog();
    }
}
