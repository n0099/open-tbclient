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
    protected boolean aps;
    protected TextView csC;
    protected ImageButton gfn;
    private a.b ggm;
    private a.b ggn;
    protected UpdateGroupActivity gsR;
    protected String gsS;
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
        return this.csC;
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
        return this.aps;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.ggn = null;
        this.ggm = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.csC = null;
        this.gfn = null;
        this.gsR = null;
        this.progressBar = null;
        this.gsS = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.aps = true;
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
        this.gsR = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gsR.setContentView(i);
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
        this.gsS = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bwh() {
        return this.gsS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uo(int i) {
        this.mParent = this.gsR.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.gsR.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gsR.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gsR.getResources().getString(d.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csC.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds16);
        this.csC.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gsR.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.gsR.findViewById(d.g.progress);
        kS(false);
        this.mImgBack.setOnClickListener(this.gsR);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.csC.setOnClickListener(this.gsR);
    }

    protected void kS(boolean z) {
        this.aps = z;
        this.csC.setEnabled(z);
    }

    public boolean bwo() {
        return this.gsS != null && this.gsS.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bwl() {
        return f.j(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void brA() {
        this.csC.setEnabled(this.aps);
        al.k(this.csC, d.f.s_navbar_button_bg);
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
        this.gsR.getLayoutMode().setNightMode(i == 1);
        this.gsR.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gsR.getPageContext(), i);
        al.h(this.mParent, i);
        al.k(this.csC, d.f.s_navbar_button_bg);
        al.d(this.csC, d.C0277d.navbar_btn_color, 1);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gsR.getPageContext().getPageActivity());
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
        aVar.b(this.gsR.getPageContext());
        aVar.aaW();
    }
}
