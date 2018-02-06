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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected TextView bCB;
    private a.b eAU;
    private a.b eAV;
    protected boolean eAk;
    protected UpdateGroupActivity eND;
    protected String eNE;
    protected ImageButton ezV;
    protected int mGroupId;
    protected View mImgBack;
    protected boolean mIsLoading;
    protected NavigationBar mNavigationBar;
    protected View mParent;
    TextWatcher mTextWatcher;
    protected ProgressBar progressBar;
    protected EditText rE;

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(a.b bVar) {
        this.eAV = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.eAU = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aMf() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aHE() {
        return this.bCB;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aGR() {
        return this.ezV;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.rE.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aHu() {
        return this.eAk;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.eAV = null;
        this.eAU = null;
        this.rE = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bCB = null;
        this.ezV = null;
        this.eND = null;
        this.progressBar = null;
        this.eNE = null;
        this.mIsLoading = false;
        this.mGroupId = 0;
        this.eAk = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aMg();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eND = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eND.setContentView(i);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void setGroupId(int i) {
        this.mGroupId = i;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int getGroupId() {
        return this.mGroupId;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void nO(String str) {
        this.eNE = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aMe() {
        return this.eNE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qE(int i) {
        this.mParent = this.eND.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eND.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eND.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eND.getResources().getString(d.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCB.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds16);
        this.bCB.setLayoutParams(layoutParams);
        this.rE = (EditText) this.eND.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.eND.findViewById(d.g.progress);
        ho(false);
        this.mImgBack.setOnClickListener(this.eND);
        this.rE.addTextChangedListener(this.mTextWatcher);
        this.bCB.setOnClickListener(this.eND);
    }

    protected void ho(boolean z) {
        this.eAk = z;
        this.bCB.setEnabled(z);
    }

    public boolean aMl() {
        return this.eNE != null && this.eNE.equals(this.rE.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aMi() {
        return f.f(this.rE) || this.rE.length() >= 3;
    }

    protected void aHv() {
        this.bCB.setEnabled(this.eAk);
        aj.s(this.bCB, d.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i, int i2, int i3, int i4) {
        if (i == 1) {
            ho(false);
        } else if (i2 >= i3 && i2 <= i4) {
            ho(true);
        } else {
            ho(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.eND.getLayoutMode().aQ(i == 1);
        this.eND.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eND.getPageContext(), i);
        aj.p(this.mParent, i);
        aj.s(this.bCB, d.f.s_navbar_button_bg);
        aj.e(this.bCB, d.C0140d.navbar_btn_color, 1);
        aHv();
        this.rE.setHintTextColor(aj.fN(d.C0140d.common_color_10005));
        aj.s(this.mParent, d.C0140d.common_color_10041);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String getText() {
        return this.rE.getText().toString();
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void setText(String str) {
        this.rE.setText(str);
        this.rE.setSelection(this.rE.getText().toString().length());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void release() {
        this.rE.removeTextChangedListener(this.mTextWatcher);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eND.getPageContext().getPageActivity());
        aVar.fb(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eAV != null) {
                    d.this.eAV.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eAU != null) {
                    d.this.eAU.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eND.getPageContext());
        aVar.AU();
    }
}
