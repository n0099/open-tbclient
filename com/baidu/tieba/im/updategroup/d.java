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
    protected boolean aqG;
    protected TextView cDh;
    protected ProgressBar gFM;
    protected ImageButton gFw;
    private a.b gGw;
    private a.b gGx;
    protected UpdateGroupActivity gTe;
    protected String gTf;
    protected EditText mEditText;
    protected long mGroupId;
    protected View mImgBack;
    protected boolean mIsLoading;
    protected NavigationBar mNavigationBar;
    protected View mParent;
    TextWatcher mTextWatcher;

    @Override // com.baidu.tieba.im.updategroup.a
    public void b(a.b bVar) {
        this.gGx = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void c(a.b bVar) {
        this.gGw = bVar;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bHD() {
        return this.mImgBack;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bDg() {
        return this.cDh;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public View bCu() {
        return this.gFw;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void clearText() {
        this.mEditText.setText("");
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bCW() {
        return this.aqG;
    }

    public d(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity.getPageContext());
        this.gGx = null;
        this.gGw = null;
        this.mEditText = null;
        this.mNavigationBar = null;
        this.mParent = null;
        this.cDh = null;
        this.gFw = null;
        this.gTe = null;
        this.gFM = null;
        this.gTf = null;
        this.mIsLoading = false;
        this.mGroupId = 0L;
        this.aqG = true;
        this.mImgBack = null;
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.im.updategroup.d.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                d.this.bHE();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gTe = updateGroupActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentView(int i) {
        this.gTe.setContentView(i);
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
    public void zW(String str) {
        this.gTf = str;
        setText(str);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String bHC() {
        return this.gTf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wc(int i) {
        this.mParent = this.gTe.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) this.gTe.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gTe.getResources().getString(i));
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cDh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gTe.getResources().getString(R.string.group_update_done));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cDh.getLayoutParams();
        layoutParams.rightMargin = l.g(getPageContext().getPageActivity(), R.dimen.ds16);
        this.cDh.setLayoutParams(layoutParams);
        this.mEditText = (EditText) this.gTe.findViewById(R.id.edit_text);
        this.gFM = (ProgressBar) this.gTe.findViewById(R.id.progress);
        lZ(false);
        this.mImgBack.setOnClickListener(this.gTe);
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.cDh.setOnClickListener(this.gTe);
    }

    protected void lZ(boolean z) {
        this.aqG = z;
        this.cDh.setEnabled(z);
    }

    public boolean bHJ() {
        return this.gTf != null && this.gTf.equals(this.mEditText.getText().toString());
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public boolean bHG() {
        return f.j(this.mEditText) || this.mEditText.length() >= 3;
    }

    protected void bCX() {
        this.cDh.setEnabled(this.aqG);
        am.k(this.cDh, R.drawable.s_navbar_button_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(int i, int i2, int i3, int i4) {
        if (i == 1) {
            lZ(false);
        } else if (i2 >= i3 && i2 <= i4) {
            lZ(true);
        } else {
            lZ(false);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void onChangeSkinType(int i) {
        this.gTe.getLayoutMode().setNightMode(i == 1);
        this.gTe.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gTe.getPageContext(), i);
        am.h(this.mParent, i);
        am.k(this.cDh, R.drawable.s_navbar_button_bg);
        am.f(this.cDh, R.color.navbar_btn_color, 1);
        bCX();
        this.mEditText.setHintTextColor(am.ii(R.color.common_color_10005));
        am.k(this.mParent, R.color.common_color_10041);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public String getText() {
        return this.mEditText.getText().toString();
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
        this.gFM.setVisibility(z ? 0 : 8);
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gTe.getPageContext().getPageActivity());
        aVar.hv(R.string.group_update_alert_save);
        aVar.a(R.string.group_update_canel, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gGx != null) {
                    d.this.gGx.onClick(aVar2);
                }
            }
        });
        aVar.b(R.string.group_update_done, new a.b() { // from class: com.baidu.tieba.im.updategroup.d.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (d.this.gGw != null) {
                    d.this.gGw.onClick(aVar2);
                }
            }
        });
        aVar.b(this.gTe.getPageContext());
        aVar.agO();
    }
}
