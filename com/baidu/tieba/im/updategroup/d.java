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
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected TextView aVO;
    protected UpdateGroupActivity eCq;
    protected String eCr;
    protected ImageButton eoG;
    protected boolean eoV;
    private a.b epF;
    private a.b epG;
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
        this.epG = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.epF = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aNE() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aJe() {
        return this.aVO;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View aIr() {
        return this.eoG;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aIU() {
        return this.eoV;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.epG = null;
        this.epF = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.aVO = null;
        this.eoG = null;
        this.eCq = null;
        this.progressBar = null;
        this.eCr = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.eoV = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.aNF();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.eCq = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.eCq.setContentView(i);
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
    public void oM(String str) {
        this.eCr = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String aND() {
        return this.eCr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oF(int i) {
        this.mParent = this.eCq.findViewById(d.g.parent);
        this.mNavigationBar = (NavigationBar) this.eCq.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eCq.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eCq.getResources().getString(d.j.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aVO.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds16);
        this.aVO.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.eCq.findViewById(d.g.edit_text);
        this.progressBar = (ProgressBar) this.eCq.findViewById(d.g.progress);
        hn(false);
        this.mImgBack.setOnClickListener(this.eCq);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.aVO.setOnClickListener(this.eCq);
    }

    protected void hn(boolean z) {
        this.eoV = z;
        this.aVO.setEnabled(z);
    }

    public boolean aNK() {
        return this.eCr != null && this.eCr.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean aNH() {
        return f.f(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void aIV() {
        this.aVO.setEnabled(this.eoV);
        am.i(this.aVO, d.f.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(int i, int i2, int i3, int i4) {
        if (i == 1) {
            hn(false);
        } else if (i2 >= i3 && i2 <= i4) {
            hn(true);
        } else {
            hn(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.eCq.getLayoutMode().setNightMode(i == 1);
        this.eCq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.eCq.getPageContext(), i);
        am.f(this.mParent, i);
        am.i(this.aVO, d.f.s_navbar_button_bg);
        am.c(this.aVO, d.C0140d.navbar_btn_color, 1);
        aIV();
        this.mEditText.setHintTextColor(am.cS(d.C0140d.common_color_10005));
        am.i(this.mParent, d.C0140d.common_color_10041);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCq.getPageContext().getPageActivity());
        aVar.cf(d.j.group_update_alert_save);
        aVar.a(d.j.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.epG != null) {
                    d.this.epG.onClick(aVar2);
                }
            }
        });
        aVar.b(d.j.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.epF != null) {
                    d.this.epF.onClick(aVar2);
                }
            }
        });
        aVar.b(this.eCq.getPageContext());
        aVar.xf();
    }
}
