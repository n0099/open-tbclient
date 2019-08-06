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
    protected TextView cCl;
    protected ImageButton gDF;
    private a.b gEE;
    private a.b gEF;
    protected UpdateGroupActivity gRk;
    protected String gRl;
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
        this.gEF = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.gEE = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bGP() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bCs() {
        return this.cCl;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bBG() {
        return this.gDF;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bCi() {
        return this.aqi;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.gEF = null;
        this.gEE = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cCl = null;
        this.gDF = null;
        this.gRk = null;
        this.progressBar = null;
        this.gRl = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.aqi = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bGQ();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gRk = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gRk.setContentView(i);
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
    public void zx(String str) {
        this.gRl = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bGO() {
        return this.gRl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vY(int i) {
        this.mParent = this.gRk.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gRk.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gRk.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cCl = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gRk.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cCl.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.cCl.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gRk.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.gRk.findViewById(R.id.progress);
        lW(false);
        this.mImgBack.setOnClickListener(this.gRk);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.cCl.setOnClickListener(this.gRk);
    }

    protected void lW(boolean z) {
        this.aqi = z;
        this.cCl.setEnabled(z);
    }

    public boolean bGV() {
        return this.gRl != null && this.gRl.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bGS() {
        return f.j(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bCj() {
        this.cCl.setEnabled(this.aqi);
        am.k(this.cCl, R.drawable.s_navbar_button_bg);
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
        this.gRk.getLayoutMode().setNightMode(i == 1);
        this.gRk.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gRk.getPageContext(), i);
        am.h(this.mParent, i);
        am.k(this.cCl, R.drawable.s_navbar_button_bg);
        am.f(this.cCl, R.color.navbar_btn_color, 1);
        bCj();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gRk.getPageContext().getPageActivity());
        aVar.hu(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gEF != null) {
                    d.this.gEF.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gEE != null) {
                    d.this.gEE.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gRk.getPageContext());
        aVar.agK();
    }
}
