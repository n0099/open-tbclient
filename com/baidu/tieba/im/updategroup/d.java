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
    protected boolean bmZ;
    protected TextView dGm;
    protected UpdateGroupActivity hLH;
    protected String hLI;
    private a.b hyZ;
    protected ImageButton hya;
    private a.b hza;
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
        this.hza = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.hyZ = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bYD() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bUk() {
        return this.dGm;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bTz() {
        return this.hya;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void xX() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bUa() {
        return this.bmZ;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.hza = null;
        this.hyZ = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.dGm = null;
        this.hya = null;
        this.hLH = null;
        this.progressBar = null;
        this.hLI = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.bmZ = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bYE();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.hLH = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.hLH.setContentView(i);
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
        this.hLI = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bYC() {
        return this.hLI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xc(int i) {
        this.mParent = this.hLH.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.hLH.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hLH.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dGm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hLH.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGm.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.dGm.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.hLH.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.hLH.findViewById(R.id.progress);
        nv(false);
        this.mImgBack.setOnClickListener(this.hLH);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.dGm.setOnClickListener(this.hLH);
    }

    protected void nv(boolean z) {
        this.bmZ = z;
        this.dGm.setEnabled(z);
    }

    public boolean bYJ() {
        return this.hLI != null && this.hLI.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bYG() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bUb() {
        this.dGm.setEnabled(this.bmZ);
        am.setBackgroundResource(this.dGm, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i, int i2, int i3, int i4) {
        if (i == 1) {
            nv(false);
        } else if (i2 >= i3 && i2 <= i4) {
            nv(true);
        } else {
            nv(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.hLH.getLayoutMode().setNightMode(i == 1);
        this.hLH.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hLH.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.dGm, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.dGm, R.color.navbar_btn_color, 1);
        bUb();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hLH.getPageContext().getPageActivity());
        aVar.jW(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hza != null) {
                    d.this.hza.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.hyZ != null) {
                    d.this.hyZ.onClick(aVar2);
                }
            }
        });
        aVar.b(this.hLH.getPageContext());
        aVar.aEG();
    }
}
