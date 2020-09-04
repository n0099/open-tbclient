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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes17.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean cgk;
    protected TextView eUp;
    protected ImageButton jkE;
    private a.b jlD;
    private a.b jlE;
    protected UpdateGroupActivity jzA;
    protected String jzB;
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
        this.jlE = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.jlD = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cIt() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cDD() {
        return this.eUp;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cCS() {
        return this.jkE;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void KA() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cDt() {
        return this.cgk;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.jlE = null;
        this.jlD = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.eUp = null;
        this.jkE = null;
        this.jzA = null;
        this.progressBar = null;
        this.jzB = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.cgk = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cIu();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jzA = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.jzA.setContentView(i);
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
    public void Lc(String str) {
        this.jzB = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cIs() {
        return this.jzB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BK(int i) {
        this.mParent = this.jzA.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jzA.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jzA.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eUp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jzA.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eUp.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.eUp.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.jzA.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.jzA.findViewById(R.id.progress);
        qt(false);
        this.mImgBack.setOnClickListener(this.jzA);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.eUp.setOnClickListener(this.jzA);
    }

    protected void qt(boolean z) {
        this.cgk = z;
        this.eUp.setEnabled(z);
    }

    public boolean cIz() {
        return this.jzB != null && this.jzB.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cIw() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void cDu() {
        this.eUp.setEnabled(this.cgk);
        ap.setBackgroundResource(this.eUp, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(int i, int i2, int i3, int i4) {
        if (i == 1) {
            qt(false);
        } else if (i2 >= i3 && i2 <= i4) {
            qt(true);
        } else {
            qt(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.jzA.getLayoutMode().setNightMode(i == 1);
        this.jzA.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jzA.getPageContext(), i);
        ap.setFrsPBBgColor(this.mParent, i);
        ap.setBackgroundResource(this.eUp, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.eUp, R.color.navbar_btn_color, 1);
        cDu();
        this.mEditText.setHintTextColor(ap.getColorList(R.color.common_color_10005));
        ap.setBackgroundResource(this.mParent, R.color.common_color_10041);
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
    public void Nv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jzA.getPageContext().getPageActivity());
        aVar.nt(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.jlE != null) {
                    d.this.jlE.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.jlD != null) {
                    d.this.jlD.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jzA.getPageContext());
        aVar.bhg();
    }
}
