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
    protected boolean aJW;
    protected TextView cOq;
    protected ImageButton gDw;
    private a.b gEv;
    private a.b gEw;
    protected UpdateGroupActivity gRe;
    protected String gRf;
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
        this.gEw = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.gEv = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bEo() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bzR() {
        return this.cOq;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bzf() {
        return this.gDw;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void tH() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bzH() {
        return this.aJW;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.gEw = null;
        this.gEv = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cOq = null;
        this.gDw = null;
        this.gRe = null;
        this.progressBar = null;
        this.gRf = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.aJW = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bEp();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gRe = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gRe.setContentView(i);
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
    public void yo(String str) {
        this.gRf = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bEn() {
        return this.gRf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uI(int i) {
        this.mParent = this.gRe.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gRe.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gRe.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cOq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gRe.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOq.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.cOq.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gRe.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.gRe.findViewById(R.id.progress);
        lN(false);
        this.mImgBack.setOnClickListener(this.gRe);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.cOq.setOnClickListener(this.gRe);
    }

    protected void lN(boolean z) {
        this.aJW = z;
        this.cOq.setEnabled(z);
    }

    public boolean bEu() {
        return this.gRf != null && this.gRf.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bEr() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bzI() {
        this.cOq.setEnabled(this.aJW);
        am.setBackgroundResource(this.cOq, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(int i, int i2, int i3, int i4) {
        if (i == 1) {
            lN(false);
        } else if (i2 >= i3 && i2 <= i4) {
            lN(true);
        } else {
            lN(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.gRe.getLayoutMode().setNightMode(i == 1);
        this.gRe.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gRe.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.cOq, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.cOq, R.color.navbar_btn_color, 1);
        bzI();
        this.mEditText.setHintTextColor(am.getColorList(R.color.common_color_10005));
        am.setBackgroundResource(this.mParent, R.color.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gRe.getPageContext().getPageActivity());
        aVar.hU(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gEw != null) {
                    d.this.gEw.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gEv != null) {
                    d.this.gEv.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gRe.getPageContext());
        aVar.akO();
    }
}
