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
    protected boolean bUi;
    protected TextView eum;
    protected UpdateGroupActivity iKj;
    protected String iKk;
    protected ImageButton iwC;
    private a.b ixB;
    private a.b ixC;
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
        this.ixC = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.ixB = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cpA() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View clh() {
        return this.eum;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View ckw() {
        return this.iwC;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void El() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean ckX() {
        return this.bUi;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.ixC = null;
        this.ixB = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eum = null;
        this.iwC = null;
        this.iKj = null;
        this.progressBar = null;
        this.iKk = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.bUi = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cpB();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.iKj = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.iKj.setContentView(i);
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
    public void GS(String str) {
        this.iKk = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cpz() {
        return this.iKk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yg(int i) {
        this.mParent = this.iKj.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.iKj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iKj.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eum = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iKj.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eum.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.eum.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.iKj.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.iKj.findViewById(R.id.progress);
        oV(false);
        this.mImgBack.setOnClickListener(this.iKj);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.eum.setOnClickListener(this.iKj);
    }

    protected void oV(boolean z) {
        this.bUi = z;
        this.eum.setEnabled(z);
    }

    public boolean cpG() {
        return this.iKk != null && this.iKk.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cpD() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void ckY() {
        this.eum.setEnabled(this.bUi);
        am.setBackgroundResource(this.eum, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(int i, int i2, int i3, int i4) {
        if (i == 1) {
            oV(false);
        } else if (i2 >= i3 && i2 <= i4) {
            oV(true);
        } else {
            oV(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.iKj.getLayoutMode().setNightMode(i == 1);
        this.iKj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iKj.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.eum, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.eum, R.color.navbar_btn_color, 1);
        ckY();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iKj.getPageContext().getPageActivity());
        aVar.kD(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ixC != null) {
                    d.this.ixC.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ixB != null) {
                    d.this.ixB.onClick(aVar2);
                }
            }
        });
        aVar.b(this.iKj.getPageContext());
        aVar.aST();
    }
}
