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
    protected TextView bCr;
    private a.b eAY;
    private a.b eAZ;
    protected boolean eAo;
    protected UpdateGroupActivity eNH;
    protected String eNI;
    protected ImageButton ezZ;
    protected int mGroupId;
    protected View mImgBack;
    protected boolean mIsLoading;
    protected NavigationBar mNavigationBar;
    protected View mParent;
    TextWatcher mTextWatcher;
    protected ProgressBar progressBar;
    protected EditText rD;

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(a.b bVar) {
        this.eAZ = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.eAY = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aMf() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aHE() {
        return this.bCr;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aGR() {
        return this.ezZ;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.rD.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aHu() {
        return this.eAo;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.eAZ = null;
        this.eAY = null;
        this.rD = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bCr = null;
        this.ezZ = null;
        this.eNH = null;
        this.progressBar = null;
        this.eNI = null;
        this.mIsLoading = false;
        this.mGroupId = 0;
        this.eAo = true;
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
        this.eNH = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eNH.setContentView(i);
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
        this.eNI = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aMe() {
        return this.eNI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qF(int i) {
        this.mParent = this.eNH.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eNH.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eNH.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eNH.getResources().getString(d.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCr.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds16);
        this.bCr.setLayoutParams(layoutParams);
        this.rD = (EditText) this.eNH.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.eNH.findViewById(d.g.progress);
        ht(false);
        this.mImgBack.setOnClickListener(this.eNH);
        this.rD.addTextChangedListener(this.mTextWatcher);
        this.bCr.setOnClickListener(this.eNH);
    }

    protected void ht(boolean z) {
        this.eAo = z;
        this.bCr.setEnabled(z);
    }

    public boolean aMl() {
        return this.eNI != null && this.eNI.equals(this.rD.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aMi() {
        return f.f(this.rD) || this.rD.length() >= 3;
    }

    protected void aHv() {
        this.bCr.setEnabled(this.eAo);
        aj.s(this.bCr, d.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i, int i2, int i3, int i4) {
        if (i == 1) {
            ht(false);
        } else if (i2 >= i3 && i2 <= i4) {
            ht(true);
        } else {
            ht(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.eNH.getLayoutMode().aQ(i == 1);
        this.eNH.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eNH.getPageContext(), i);
        aj.p(this.mParent, i);
        aj.s(this.bCr, d.f.s_navbar_button_bg);
        aj.e(this.bCr, d.C0141d.navbar_btn_color, 1);
        aHv();
        this.rD.setHintTextColor(aj.fN(d.C0141d.common_color_10005));
        aj.s(this.mParent, d.C0141d.common_color_10041);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String getText() {
        return this.rD.getText().toString();
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void setText(String str) {
        this.rD.setText(str);
        this.rD.setSelection(this.rD.getText().toString().length());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void release() {
        this.rD.removeTextChangedListener(this.mTextWatcher);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNH.getPageContext().getPageActivity());
        aVar.fb(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eAZ != null) {
                    d.this.eAZ.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eAY != null) {
                    d.this.eAY.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eNH.getPageContext());
        aVar.AV();
    }
}
