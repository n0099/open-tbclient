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
    protected boolean bmK;
    protected TextView dFI;
    protected UpdateGroupActivity hJT;
    protected String hJU;
    protected ImageButton hwm;
    private a.b hxl;
    private a.b hxm;
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
        this.hxm = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.hxl = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bYi() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bTP() {
        return this.dFI;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bTe() {
        return this.hwm;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void xS() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bTF() {
        return this.bmK;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.hxm = null;
        this.hxl = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dFI = null;
        this.hwm = null;
        this.hJT = null;
        this.progressBar = null;
        this.hJU = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.bmK = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bYj();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hJT = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.hJT.setContentView(i);
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
    public void Dx(String str) {
        this.hJU = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bYh() {
        return this.hJU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wU(int i) {
        this.mParent = this.hJT.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hJT.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hJT.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hJT.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dFI.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.dFI.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.hJT.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.hJT.findViewById(R.id.progress);
        np(false);
        this.mImgBack.setOnClickListener(this.hJT);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.dFI.setOnClickListener(this.hJT);
    }

    protected void np(boolean z) {
        this.bmK = z;
        this.dFI.setEnabled(z);
    }

    public boolean bYo() {
        return this.hJU != null && this.hJU.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bYl() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bTG() {
        this.dFI.setEnabled(this.bmK);
        am.setBackgroundResource(this.dFI, R.drawable.s_navbar_button_bg);
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
        this.hJT.getLayoutMode().setNightMode(i == 1);
        this.hJT.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hJT.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.dFI, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.dFI, R.color.navbar_btn_color, 1);
        bTG();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hJT.getPageContext().getPageActivity());
        aVar.jW(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hxm != null) {
                    d.this.hxm.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hxl != null) {
                    d.this.hxl.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hJT.getPageContext());
        aVar.aEA();
    }
}
