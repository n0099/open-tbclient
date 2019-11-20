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
    protected boolean aJE;
    protected TextView cNz;
    protected ImageButton gCF;
    private a.b gDE;
    private a.b gDF;
    protected UpdateGroupActivity gQn;
    protected String gQo;
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
        this.gDF = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.gDE = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bEm() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bzP() {
        return this.cNz;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bzd() {
        return this.gCF;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void tI() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bzF() {
        return this.aJE;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.gDF = null;
        this.gDE = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cNz = null;
        this.gCF = null;
        this.gQn = null;
        this.progressBar = null;
        this.gQo = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.aJE = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bEn();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gQn = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gQn.setContentView(i);
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
        this.gQo = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bEl() {
        return this.gQo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uH(int i) {
        this.mParent = this.gQn.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gQn.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gQn.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cNz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gQn.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNz.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.cNz.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gQn.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.gQn.findViewById(R.id.progress);
        lN(false);
        this.mImgBack.setOnClickListener(this.gQn);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.cNz.setOnClickListener(this.gQn);
    }

    protected void lN(boolean z) {
        this.aJE = z;
        this.cNz.setEnabled(z);
    }

    public boolean bEs() {
        return this.gQo != null && this.gQo.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bEp() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bzG() {
        this.cNz.setEnabled(this.aJE);
        am.setBackgroundResource(this.cNz, R.drawable.s_navbar_button_bg);
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
        this.gQn.getLayoutMode().setNightMode(i == 1);
        this.gQn.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gQn.getPageContext(), i);
        am.setFrsPBBgColor(this.mParent, i);
        am.setBackgroundResource(this.cNz, R.drawable.s_navbar_button_bg);
        am.setViewTextColor(this.cNz, R.color.navbar_btn_color, 1);
        bzG();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gQn.getPageContext().getPageActivity());
        aVar.hT(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gDF != null) {
                    d.this.gDF.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gDE != null) {
                    d.this.gDE.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gQn.getPageContext());
        aVar.akM();
    }
}
