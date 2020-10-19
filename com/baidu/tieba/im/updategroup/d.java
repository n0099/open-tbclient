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
/* loaded from: classes23.dex */
public abstract class d extends com.baidu.adp.base.c<UpdateGroupActivity> implements a {
    protected boolean cuF;
    protected TextView fjr;
    protected ImageButton jIf;
    private a.b jJe;
    private a.b jJf;
    protected UpdateGroupActivity jWZ;
    protected String jXa;
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
        this.jJf = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.jJe = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cPH() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cKS() {
        return this.fjr;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View cKh() {
        return this.jIf;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void Mm() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cKI() {
        return this.cuF;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.jJf = null;
        this.jJe = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.fjr = null;
        this.jIf = null;
        this.jWZ = null;
        this.progressBar = null;
        this.jXa = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.cuF = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.cPI();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.jWZ = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.jWZ.setContentView(i);
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
    public void Mt(String str) {
        this.jXa = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String cPG() {
        return this.jXa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CR(int i) {
        this.mParent = this.jWZ.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.jWZ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jWZ.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fjr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jWZ.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjr.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16);
        this.fjr.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.jWZ.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.jWZ.findViewById(R.id.progress);
        rh(false);
        this.mImgBack.setOnClickListener(this.jWZ);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.fjr.setOnClickListener(this.jWZ);
    }

    protected void rh(boolean z) {
        this.cuF = z;
        this.fjr.setEnabled(z);
    }

    public boolean cPN() {
        return this.jXa != null && this.jXa.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean cPK() {
        return f.checkText(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void cKJ() {
        this.fjr.setEnabled(this.cuF);
        ap.setBackgroundResource(this.fjr, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(int i, int i2, int i3, int i4) {
        if (i == 1) {
            rh(false);
        } else if (i2 >= i3 && i2 <= i4) {
            rh(true);
        } else {
            rh(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.jWZ.getLayoutMode().setNightMode(i == 1);
        this.jWZ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.jWZ.getPageContext(), i);
        ap.setFrsPBBgColor(this.mParent, i);
        ap.setBackgroundResource(this.fjr, R.drawable.s_navbar_button_bg);
        ap.setViewTextColor(this.fjr, R.color.navbar_btn_color, 1);
        cKJ();
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
    public void Pd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jWZ.getPageContext().getPageActivity());
        aVar.ob(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.jJf != null) {
                    d.this.jJf.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.jJe != null) {
                    d.this.jJe.onClick(aVar2);
                }
            }
        });
        aVar.b(this.jWZ.getPageContext());
        aVar.bkJ();
    }
}
