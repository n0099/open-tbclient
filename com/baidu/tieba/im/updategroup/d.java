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
/* loaded from: classes10.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean bLg;
    protected TextView efT;
    protected ImageButton ihN;
    private a.b iiM;
    private a.b iiN;
    protected UpdateGroupActivity ivx;
    protected String ivy;
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
        this.iiN = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.iiM = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cje() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View ceL() {
        return this.efT;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cdZ() {
        return this.ihN;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void CP() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean ceB() {
        return this.bLg;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.iiN = null;
        this.iiM = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.efT = null;
        this.ihN = null;
        this.ivx = null;
        this.progressBar = null;
        this.ivy = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.bLg = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cjf();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.ivx = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.ivx.setContentView(i);
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
    public void Fg(String str) {
        this.ivy = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cjd() {
        return this.ivy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xA(int i) {
        this.mParent = this.ivx.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.ivx.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ivx.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.efT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ivx.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efT.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.efT.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.ivx.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.ivx.findViewById(R.id.progress);
        oz(false);
        this.mImgBack.setOnClickListener(this.ivx);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.efT.setOnClickListener(this.ivx);
    }

    protected void oz(boolean z) {
        this.bLg = z;
        this.efT.setEnabled(z);
    }

    public boolean cjk() {
        return this.ivy != null && this.ivy.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cjh() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void ceC() {
        this.efT.setEnabled(this.bLg);
        am.setBackgroundResource(this.efT, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i, int i2, int i3, int i4) {
        if (i == 1) {
            oz(false);
        } else if (i2 >= i3 && i2 <= i4) {
            oz(true);
        } else {
            oz(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.ivx.getLayoutMode().setNightMode(i == 1);
        this.ivx.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.ivx.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.efT, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.efT, R.color.navbar_btn_color, 1);
        ceC();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ivx.getPageContext().getPageActivity());
        aVar.kd(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.iiN != null) {
                    d.this.iiN.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.iiM != null) {
                    d.this.iiM.onClick(aVar2);
                }
            }
        });
        aVar.b(this.ivx.getPageContext());
        aVar.aMU();
    }
}
