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
    protected boolean cIU;
    protected TextView fxI;
    protected ImageButton kaB;
    private a.b kbA;
    private a.b kbB;
    protected UpdateGroupActivity kpv;
    protected String kpw;
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
        this.kbB = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.kbA = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cVp() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cQA() {
        return this.fxI;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cPP() {
        return this.kaB;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void Ng() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cQq() {
        return this.cIU;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.kbB = null;
        this.kbA = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.fxI = null;
        this.kaB = null;
        this.kpv = null;
        this.progressBar = null;
        this.kpw = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.cIU = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cVq();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kpv = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.kpv.setContentView(i);
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
    public void Ni(String str) {
        this.kpw = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cVo() {
        return this.kpw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dx(int i) {
        this.mParent = this.kpv.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kpv.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kpv.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fxI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kpv.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fxI.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.fxI.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.kpv.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.kpv.findViewById(R.id.progress);
        rI(false);
        this.mImgBack.setOnClickListener(this.kpv);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.fxI.setOnClickListener(this.kpv);
    }

    protected void rI(boolean z) {
        this.cIU = z;
        this.fxI.setEnabled(z);
    }

    public boolean cVv() {
        return this.kpw != null && this.kpw.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cVs() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void cQr() {
        this.fxI.setEnabled(this.cIU);
        ap.setBackgroundResource(this.fxI, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(int i, int i2, int i3, int i4) {
        if (i == 1) {
            rI(false);
        } else if (i2 >= i3 && i2 <= i4) {
            rI(true);
        } else {
            rI(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.kpv.getLayoutMode().setNightMode(i == 1);
        this.kpv.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kpv.getPageContext(), i);
        ap.setFrsPBBgColor(this.mParent, i);
        ap.setBackgroundResource(this.fxI, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.fxI, R.color.navbar_btn_color, 1);
        cQr();
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
    public void Qj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kpv.getPageContext().getPageActivity());
        aVar.ow(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.kbB != null) {
                    d.this.kbB.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.kbA != null) {
                    d.this.kbA.onClick(aVar2);
                }
            }
        });
        aVar.b(this.kpv.getPageContext());
        aVar.bpc();
    }
}
