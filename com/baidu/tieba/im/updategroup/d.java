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
/* loaded from: classes3.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected TextView aUQ;
    protected ImageButton egU;
    private a.b ehT;
    private a.b ehU;
    protected boolean ehj;
    protected UpdateGroupActivity euI;
    protected String euJ;
    protected EditText mEditText;
    protected long mGroupId;
    protected View mImgBack;
    protected boolean mIsLoading;
    protected NavigationBar mNavigationBar;
    protected View mParent;
    TextWatcher mTextWatcher;
    protected ProgressBar progressBar;

    @Override // com.baidu.tieba.im.updategroup.a
    public void a(a.b bVar) {
        this.ehU = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.ehT = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aLY() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aHw() {
        return this.aUQ;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aGK() {
        return this.egU;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aHn() {
        return this.ehj;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.ehU = null;
        this.ehT = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aUQ = null;
        this.egU = null;
        this.euI = null;
        this.progressBar = null;
        this.euJ = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.ehj = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aLZ();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.euI = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.euI.setContentView(i);
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
    public void oJ(String str) {
        this.euJ = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aLX() {
        return this.euJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ok(int i) {
        this.mParent = this.euI.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.euI.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.euI.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.euI.getResources().getString(d.k.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aUQ.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds16);
        this.aUQ.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.euI.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.euI.findViewById(d.g.progress);
        ha(false);
        this.mImgBack.setOnClickListener(this.euI);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.aUQ.setOnClickListener(this.euI);
    }

    protected void ha(boolean z) {
        this.ehj = z;
        this.aUQ.setEnabled(z);
    }

    public boolean aMe() {
        return this.euJ != null && this.euJ.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aMb() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aHo() {
        this.aUQ.setEnabled(this.ehj);
        al.i(this.aUQ, d.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i, int i2, int i3, int i4) {
        if (i == 1) {
            ha(false);
        } else if (i2 >= i3 && i2 <= i4) {
            ha(true);
        } else {
            ha(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.euI.getLayoutMode().setNightMode(i == 1);
        this.euI.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.euI.getPageContext(), i);
        al.f(this.mParent, i);
        al.i(this.aUQ, d.f.s_navbar_button_bg);
        al.c(this.aUQ, d.C0141d.navbar_btn_color, 1);
        aHo();
        this.mEditText.setHintTextColor(al.cP(d.C0141d.common_color_10005));
        al.i(this.mParent, d.C0141d.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.euI.getPageContext().getPageActivity());
        aVar.cc(d.k.group_update_alert_save);
        aVar.a(d.k.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ehU != null) {
                    d.this.ehU.onClick(aVar2);
                }
            }
        });
        aVar.b(d.k.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.ehT != null) {
                    d.this.ehT.onClick(aVar2);
                }
            }
        });
        aVar.b(this.euI.getPageContext());
        aVar.xa();
    }
}
