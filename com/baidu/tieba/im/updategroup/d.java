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
/* loaded from: classes5.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean aqi;
    protected TextView cCe;
    protected ImageButton gCN;
    private a.b gDM;
    private a.b gDN;
    protected UpdateGroupActivity gQs;
    protected String gQt;
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
        this.gDN = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.gDM = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bGB() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bCe() {
        return this.cCe;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bBs() {
        return this.gCN;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bBU() {
        return this.aqi;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.gDN = null;
        this.gDM = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cCe = null;
        this.gCN = null;
        this.gQs = null;
        this.progressBar = null;
        this.gQt = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.aqi = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bGC();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gQs = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gQs.setContentView(i);
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
    public void zw(String str) {
        this.gQt = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bGA() {
        return this.gQt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vW(int i) {
        this.mParent = this.gQs.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gQs.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gQs.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gQs.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cCe.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.cCe.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gQs.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.gQs.findViewById(R.id.progress);
        lW(false);
        this.mImgBack.setOnClickListener(this.gQs);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.cCe.setOnClickListener(this.gQs);
    }

    protected void lW(boolean z) {
        this.aqi = z;
        this.cCe.setEnabled(z);
    }

    public boolean bGH() {
        return this.gQt != null && this.gQt.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bGE() {
        return f.j(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bBV() {
        this.cCe.setEnabled(this.aqi);
        am.k(this.cCe, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(int i, int i2, int i3, int i4) {
        if (i == 1) {
            lW(false);
        } else if (i2 >= i3 && i2 <= i4) {
            lW(true);
        } else {
            lW(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.gQs.getLayoutMode().setNightMode(i == 1);
        this.gQs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gQs.getPageContext(), i);
        am.h(this.mParent, i);
        am.k(this.cCe, R.drawable.s_navbar_button_bg);
        am.f(this.cCe, R.color.navbar_btn_color, 1);
        bBV();
        this.mEditText.setHintTextColor(am.ii(R.color.common_color_10005));
        am.k(this.mParent, R.color.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gQs.getPageContext().getPageActivity());
        aVar.hu(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gDN != null) {
                    d.this.gDN.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gDM != null) {
                    d.this.gDM.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gQs.getPageContext());
        aVar.agI();
    }
}
