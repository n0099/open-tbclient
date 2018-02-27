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
    protected TextView bCo;
    private a.b eAI;
    private a.b eAJ;
    protected UpdateGroupActivity eNr;
    protected String eNs;
    protected ImageButton ezJ;
    protected boolean ezY;
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
        this.eAJ = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.eAI = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aMe() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aHD() {
        return this.bCo;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aGQ() {
        return this.ezJ;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.rD.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aHt() {
        return this.ezY;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.eAJ = null;
        this.eAI = null;
        this.rD = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.bCo = null;
        this.ezJ = null;
        this.eNr = null;
        this.progressBar = null;
        this.eNs = null;
        this.mIsLoading = false;
        this.mGroupId = 0;
        this.ezY = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aMf();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eNr = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eNr.setContentView(i);
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
        this.eNs = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aMd() {
        return this.eNs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qE(int i) {
        this.mParent = this.eNr.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eNr.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eNr.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eNr.getResources().getString(d.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bCo.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds16);
        this.bCo.setLayoutParams(layoutParams);
        this.rD = (EditText) this.eNr.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.eNr.findViewById(d.g.progress);
        ho(false);
        this.mImgBack.setOnClickListener(this.eNr);
        this.rD.addTextChangedListener(this.mTextWatcher);
        this.bCo.setOnClickListener(this.eNr);
    }

    protected void ho(boolean z) {
        this.ezY = z;
        this.bCo.setEnabled(z);
    }

    public boolean aMk() {
        return this.eNs != null && this.eNs.equals(this.rD.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aMh() {
        return f.f(this.rD) || this.rD.length() >= 3;
    }

    protected void aHu() {
        this.bCo.setEnabled(this.ezY);
        aj.s(this.bCo, d.f.s_navbar_button_bg);
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
        this.eNr.getLayoutMode().aQ(i == 1);
        this.eNr.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eNr.getPageContext(), i);
        aj.p(this.mParent, i);
        aj.s(this.bCo, d.f.s_navbar_button_bg);
        aj.e(this.bCo, d.C0141d.navbar_btn_color, 1);
        aHu();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNr.getPageContext().getPageActivity());
        aVar.fb(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eAJ != null) {
                    d.this.eAJ.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.eAI != null) {
                    d.this.eAI.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eNr.getPageContext());
        aVar.AU();
    }
}
