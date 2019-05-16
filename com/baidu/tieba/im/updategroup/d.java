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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean apF;
    protected TextView cAM;
    protected UpdateGroupActivity gKf;
    protected String gKg;
    protected ImageButton gwz;
    private a.b gxy;
    private a.b gxz;
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
        this.gxz = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.gxy = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bDQ() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bzv() {
        return this.cAM;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View byJ() {
        return this.gwz;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bzl() {
        return this.apF;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.gxz = null;
        this.gxy = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cAM = null;
        this.gwz = null;
        this.gKf = null;
        this.progressBar = null;
        this.gKg = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.apF = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bDR();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gKf = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gKf.setContentView(i);
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
    public void yJ(String str) {
        this.gKg = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bDP() {
        return this.gKg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vv(int i) {
        this.mParent = this.gKf.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gKf.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gKf.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cAM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gKf.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAM.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.cAM.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gKf.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.gKf.findViewById(R.id.progress);
        lH(false);
        this.mImgBack.setOnClickListener(this.gKf);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.cAM.setOnClickListener(this.gKf);
    }

    protected void lH(boolean z) {
        this.apF = z;
        this.cAM.setEnabled(z);
    }

    public boolean bDW() {
        return this.gKg != null && this.gKg.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bDT() {
        return f.j(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bzm() {
        this.cAM.setEnabled(this.apF);
        al.k(this.cAM, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(int i, int i2, int i3, int i4) {
        if (i == 1) {
            lH(false);
        } else if (i2 >= i3 && i2 <= i4) {
            lH(true);
        } else {
            lH(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.gKf.getLayoutMode().setNightMode(i == 1);
        this.gKf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gKf.getPageContext(), i);
        al.h(this.mParent, i);
        al.k(this.cAM, R.drawable.s_navbar_button_bg);
        al.f(this.cAM, R.color.navbar_btn_color, 1);
        bzm();
        this.mEditText.setHintTextColor(al.ic(R.color.common_color_10005));
        al.k(this.mParent, R.color.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gKf.getPageContext().getPageActivity());
        aVar.ho(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gxz != null) {
                    d.this.gxz.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gxy != null) {
                    d.this.gxy.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gKf.getPageContext());
        aVar.afG();
    }
}
