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
    protected boolean cDb;
    protected TextView frQ;
    protected ImageButton jUE;
    private a.b jVD;
    private a.b jVE;
    protected String kjA;
    protected UpdateGroupActivity kjz;
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
        this.jVE = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.jVD = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cSO() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cNZ() {
        return this.frQ;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cNo() {
        return this.jUE;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void MG() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cNP() {
        return this.cDb;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.jVE = null;
        this.jVD = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.frQ = null;
        this.jUE = null;
        this.kjz = null;
        this.progressBar = null;
        this.kjA = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.cDb = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cSP();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.kjz = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.kjz.setContentView(i);
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
    public void MR(String str) {
        this.kjA = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cSN() {
        return this.kjA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dk(int i) {
        this.mParent = this.kjz.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.kjz.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kjz.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.frQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kjz.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.frQ.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.frQ.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.kjz.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.kjz.findViewById(R.id.progress);
        rz(false);
        this.mImgBack.setOnClickListener(this.kjz);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.frQ.setOnClickListener(this.kjz);
    }

    protected void rz(boolean z) {
        this.cDb = z;
        this.frQ.setEnabled(z);
    }

    public boolean cSU() {
        return this.kjA != null && this.kjA.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cSR() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void cNQ() {
        this.frQ.setEnabled(this.cDb);
        ap.setBackgroundResource(this.frQ, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(int i, int i2, int i3, int i4) {
        if (i == 1) {
            rz(false);
        } else if (i2 >= i3 && i2 <= i4) {
            rz(true);
        } else {
            rz(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.kjz.getLayoutMode().setNightMode(i == 1);
        this.kjz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.kjz.getPageContext(), i);
        ap.setFrsPBBgColor(this.mParent, i);
        ap.setBackgroundResource(this.frQ, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.frQ, R.color.navbar_btn_color, 1);
        cNQ();
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
    public void PJ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kjz.getPageContext().getPageActivity());
        aVar.om(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.jVE != null) {
                    d.this.jVE.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.jVD != null) {
                    d.this.jVD.onClick(aVar2);
                }
            }
        });
        aVar.b(this.kjz.getPageContext());
        aVar.bmC();
    }
}
