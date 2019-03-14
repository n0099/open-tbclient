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
    protected boolean apn;
    protected TextView csA;
    protected ImageButton gfz;
    private a.b ggy;
    private a.b ggz;
    protected UpdateGroupActivity gte;
    protected String gtf;
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
        this.ggz = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.ggy = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bwl() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View brM() {
        return this.csA;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bra() {
        return this.gfz;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean brC() {
        return this.apn;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.ggz = null;
        this.ggy = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.csA = null;
        this.gfz = null;
        this.gte = null;
        this.progressBar = null;
        this.gtf = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.apn = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bwm();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gte = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gte.setContentView(i);
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
    public void xv(String str) {
        this.gtf = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bwk() {
        return this.gtf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void us(int i) {
        this.mParent = this.gte.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.gte.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gte.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.csA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gte.getResources().getString(d.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.csA.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds16);
        this.csA.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gte.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.gte.findViewById(d.g.progress);
        kS(false);
        this.mImgBack.setOnClickListener(this.gte);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.csA.setOnClickListener(this.gte);
    }

    protected void kS(boolean z) {
        this.apn = z;
        this.csA.setEnabled(z);
    }

    public boolean bwr() {
        return this.gtf != null && this.gtf.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bwo() {
        return f.j(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void brD() {
        this.csA.setEnabled(this.apn);
        al.k(this.csA, d.f.s_navbar_button_bg);
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
        this.gte.getLayoutMode().setNightMode(i == 1);
        this.gte.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gte.getPageContext(), i);
        al.h(this.mParent, i);
        al.k(this.csA, d.f.s_navbar_button_bg);
        al.d(this.csA, d.C0277d.navbar_btn_color, 1);
        brD();
        this.mEditText.setHintTextColor(al.hp(d.C0277d.common_color_10005));
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gte.getPageContext().getPageActivity());
        aVar.gD(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ggz != null) {
                    d.this.ggz.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ggy != null) {
                    d.this.ggy.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gte.getPageContext());
        aVar.aaZ();
    }
}
