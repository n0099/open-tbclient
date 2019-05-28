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
    protected TextView cAM;
    protected UpdateGroupActivity gKg;
    protected String gKh;
    protected ImageButton gwA;
    private a.b gxA;
    private a.b gxz;
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
        this.gxA = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.gxz = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bDT() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bzy() {
        return this.cAM;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View byM() {
        return this.gwA;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bzo() {
        return this.apF;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.gxA = null;
        this.gxz = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cAM = null;
        this.gwA = null;
        this.gKg = null;
        this.progressBar = null;
        this.gKh = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.apF = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bDU();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gKg = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gKg.setContentView(i);
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
    public void yJ(String str) {
        this.gKh = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bDS() {
        return this.gKh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vv(int i) {
        this.mParent = this.gKg.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gKg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gKg.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cAM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gKg.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAM.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.cAM.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gKg.findViewById(R.id.edit_text);
        this.progressBar = (ProgressBar) this.gKg.findViewById(R.id.progress);
        lH(false);
        this.mImgBack.setOnClickListener(this.gKg);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.cAM.setOnClickListener(this.gKg);
    }

    protected void lH(boolean z) {
        this.apF = z;
        this.cAM.setEnabled(z);
    }

    public boolean bDZ() {
        return this.gKh != null && this.gKh.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bDW() {
        return f.j(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bzp() {
        this.cAM.setEnabled(this.apF);
        al.k(this.cAM, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(int i, int i2, int i3, int i4) {
        if (i == 1) {
            lH(false);
        } else if (i2 >= i3 && i2 <= i4) {
            lH(true);
        } else {
            lH(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.gKg.getLayoutMode().setNightMode(i == 1);
        this.gKg.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gKg.getPageContext(), i);
        al.h(this.mParent, i);
        al.k(this.cAM, R.drawable.s_navbar_button_bg);
        al.f(this.cAM, R.color.navbar_btn_color, 1);
        bzp();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gKg.getPageContext().getPageActivity());
        aVar.ho(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gxA != null) {
                    d.this.gxA.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gxz != null) {
                    d.this.gxz.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gKg.getPageContext());
        aVar.afG();
    }
}
