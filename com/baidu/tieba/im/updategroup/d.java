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
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean apF;
    protected TextView cAN;
    protected UpdateGroupActivity gKi;
    protected String gKj;
    protected ImageButton gwC;
    private a.b gxB;
    private a.b gxC;
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
        this.gxC = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.gxB = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bDU() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bzz() {
        return this.cAN;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View byN() {
        return this.gwC;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bzp() {
        return this.apF;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.gxC = null;
        this.gxB = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cAN = null;
        this.gwC = null;
        this.gKi = null;
        this.progressBar = null;
        this.gKj = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.apF = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bDV();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gKi = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gKi.setContentView(i);
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
    public void yL(String str) {
        this.gKj = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bDT() {
        return this.gKj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vv(int i) {
        this.mParent = this.gKi.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gKi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gKi.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cAN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gKi.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAN.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.cAN.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gKi.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.gKi.findViewById(R.id.progress);
        lI(false);
        this.mImgBack.setOnClickListener(this.gKi);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.cAN.setOnClickListener(this.gKi);
    }

    protected void lI(boolean z) {
        this.apF = z;
        this.cAN.setEnabled(z);
    }

    public boolean bEa() {
        return this.gKj != null && this.gKj.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bDX() {
        return f.j(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bzq() {
        this.cAN.setEnabled(this.apF);
        al.k(this.cAN, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(int i, int i2, int i3, int i4) {
        if (i == 1) {
            lI(false);
        } else if (i2 >= i3 && i2 <= i4) {
            lI(true);
        } else {
            lI(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.gKi.getLayoutMode().setNightMode(i == 1);
        this.gKi.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gKi.getPageContext(), i);
        al.h(this.mParent, i);
        al.k(this.cAN, R.drawable.s_navbar_button_bg);
        al.f(this.cAN, R.color.navbar_btn_color, 1);
        bzq();
        this.mEditText.setHintTextColor(al.ic(R.color.common_color_10005));
        al.k(this.mParent, R.color.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gKi.getPageContext().getPageActivity());
        aVar.ho(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gxC != null) {
                    d.this.gxC.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gxB != null) {
                    d.this.gxB.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gKi.getPageContext());
        aVar.afG();
    }
}
