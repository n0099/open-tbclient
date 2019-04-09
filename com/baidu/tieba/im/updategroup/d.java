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
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean apt;
    protected TextView csD;
    protected ImageButton gfn;
    private a.b ggm;
    private a.b ggn;
    protected UpdateGroupActivity gsS;
    protected String gsT;
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
        this.ggn = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.ggm = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bwi() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View brJ() {
        return this.csD;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bqX() {
        return this.gfn;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean brz() {
        return this.apt;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.ggn = null;
        this.ggm = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.csD = null;
        this.gfn = null;
        this.gsS = null;
        this.progressBar = null;
        this.gsT = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.apt = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bwj();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gsS = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gsS.setContentView(i);
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
    public void xu(String str) {
        this.gsT = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bwh() {
        return this.gsT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uo(int i) {
        this.mParent = this.gsS.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.gsS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gsS.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gsS.getResources().getString(d.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csD.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds16);
        this.csD.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gsS.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.gsS.findViewById(d.g.progress);
        kS(false);
        this.mImgBack.setOnClickListener(this.gsS);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.csD.setOnClickListener(this.gsS);
    }

    protected void kS(boolean z) {
        this.apt = z;
        this.csD.setEnabled(z);
    }

    public boolean bwo() {
        return this.gsT != null && this.gsT.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bwl() {
        return f.j(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void brA() {
        this.csD.setEnabled(this.apt);
        al.k(this.csD, d.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(int i, int i2, int i3, int i4) {
        if (i == 1) {
            kS(false);
        } else if (i2 >= i3 && i2 <= i4) {
            kS(true);
        } else {
            kS(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.gsS.getLayoutMode().setNightMode(i == 1);
        this.gsS.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gsS.getPageContext(), i);
        al.h(this.mParent, i);
        al.k(this.csD, d.f.s_navbar_button_bg);
        al.d(this.csD, d.C0277d.navbar_btn_color, 1);
        brA();
        this.mEditText.setHintTextColor(al.ho(d.C0277d.common_color_10005));
        al.k(this.mParent, d.C0277d.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gsS.getPageContext().getPageActivity());
        aVar.gC(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ggn != null) {
                    d.this.ggn.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ggm != null) {
                    d.this.ggm.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gsS.getPageContext());
        aVar.aaW();
    }
}
