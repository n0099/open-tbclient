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
import com.baidu.tieba.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected TextView aVO;
    protected UpdateGroupActivity eCm;
    protected String eCn;
    protected ImageButton eoC;
    protected boolean eoR;
    private a.b epB;
    private a.b epC;
    protected EditText mEditText;
    protected long mGroupId;
    protected View mImgBack;
    protected boolean mIsLoading;
    protected NavigationBar mNavigationBar;
    protected View mParent;
    TextWatcher mTextWatcher;
    protected ProgressBar progressBar;

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(a.b bVar) {
        this.epC = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.epB = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aNB() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aJb() {
        return this.aVO;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aIo() {
        return this.eoC;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aIR() {
        return this.eoR;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.epC = null;
        this.epB = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aVO = null;
        this.eoC = null;
        this.eCm = null;
        this.progressBar = null;
        this.eCn = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.eoR = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aNC();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eCm = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eCm.setContentView(i);
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
    public void oO(String str) {
        this.eCn = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aNA() {
        return this.eCn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oF(int i) {
        this.mParent = this.eCm.findViewById(f.g.parent);
        this.mNavigationBar = (NavigationBar) this.eCm.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eCm.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eCm.getResources().getString(f.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aVO.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), f.e.ds16);
        this.aVO.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.eCm.findViewById(f.g.edit_text);
        this.progressBar = (ProgressBar) this.eCm.findViewById(f.g.progress);
        hn(false);
        this.mImgBack.setOnClickListener(this.eCm);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.aVO.setOnClickListener(this.eCm);
    }

    protected void hn(boolean z) {
        this.eoR = z;
        this.aVO.setEnabled(z);
    }

    public boolean aNH() {
        return this.eCn != null && this.eCn.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aNE() {
        return com.baidu.tieba.im.util.f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aIS() {
        this.aVO.setEnabled(this.eoR);
        am.i(this.aVO, f.C0146f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(int i, int i2, int i3, int i4) {
        if (i == 1) {
            hn(false);
        } else if (i2 >= i3 && i2 <= i4) {
            hn(true);
        } else {
            hn(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.eCm.getLayoutMode().setNightMode(i == 1);
        this.eCm.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eCm.getPageContext(), i);
        am.f(this.mParent, i);
        am.i(this.aVO, f.C0146f.s_navbar_button_bg);
        am.c(this.aVO, f.d.navbar_btn_color, 1);
        aIS();
        this.mEditText.setHintTextColor(am.cS(f.d.common_color_10005));
        am.i(this.mParent, f.d.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCm.getPageContext().getPageActivity());
        aVar.cf(f.j.group_update_alert_save);
        aVar.a(f.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.epC != null) {
                    d.this.epC.onClick(aVar2);
                }
            }
        });
        aVar.b(f.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.epB != null) {
                    d.this.epB.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eCm.getPageContext());
        aVar.xe();
    }
}
