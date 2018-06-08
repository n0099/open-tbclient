package com.baidu.tieba.thirdparty.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.sapi2.SapiAccount;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.thirdparty.AccountBundlingActivity;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends c<AccountBundlingActivity> {
    private HeadImageView eej;
    private AccountBundlingActivity gVm;
    private EditText gVn;
    private View gVo;
    private TextView gVp;
    private ImageView gVq;
    private boolean gVr;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public a(AccountBundlingActivity accountBundlingActivity) {
        super(accountBundlingActivity.getPageContext());
        this.gVm = accountBundlingActivity;
        accountBundlingActivity.setContentView(d.i.account_bunding_activty);
        n(accountBundlingActivity);
        o(accountBundlingActivity);
    }

    @SuppressLint({"ResourceAsColor"})
    private void n(AccountBundlingActivity accountBundlingActivity) {
        this.mRootView = (ViewGroup) this.gVm.findViewById(d.g.account_bunding_rootView);
        this.mNavigationBar = (NavigationBar) this.gVm.findViewById(d.g.account_bunding_navigation_bar);
        this.mNavigationBar.setTitleText(this.gVm.getPageContext().getString(d.k.login));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gVo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, accountBundlingActivity);
        this.gVp = (TextView) this.gVo.findViewById(d.g.right_textview);
        al.c(this.gVp, d.C0141d.cp_link_tip_a, 1);
    }

    private void o(AccountBundlingActivity accountBundlingActivity) {
        this.eej = (HeadImageView) accountBundlingActivity.findViewById(d.g.account_bunding_head);
        this.gVn = (EditText) accountBundlingActivity.findViewById(d.g.account_bunding_edit);
        this.gVq = (ImageView) accountBundlingActivity.findViewById(d.g.account_bunding_edit_del);
        this.gVp.setText(d.k.done);
        mT(false);
    }

    public ViewGroup adh() {
        return this.mRootView;
    }

    public HeadImageView bAv() {
        return this.eej;
    }

    public View bAw() {
        return this.gVo;
    }

    public EditText bAx() {
        return this.gVn;
    }

    public void bAy() {
        this.gVn.setText("");
    }

    public void mS(boolean z) {
        this.gVo.setEnabled(z);
    }

    public void uz(String str) {
        mT(false);
        boolean z = TextUtils.isEmpty(str.trim()) ? false : true;
        mS(z);
        mU(z);
        if (z) {
            al.c(this.gVp, d.C0141d.cp_link_tip_a, 1);
        } else {
            al.c(this.gVp, d.C0141d.navi_op_text, 1);
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            if (!TextUtils.isEmpty(sapiAccount.displayname)) {
                this.gVn.setText(sapiAccount.displayname);
                this.gVn.setSelection(sapiAccount.displayname.length());
            }
            this.eej.setIsRound(false);
            this.eej.setAutoChangeStyle(true);
            this.eej.setDrawBorder(false);
            this.eej.startLoad(sapiAccount.getSocialPortrait(), 10, false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void mT(boolean z) {
        if (this.gVr != z) {
            this.gVr = z;
            if (z) {
                al.c(this.gVn, d.C0141d.cp_cont_h, 2);
            } else {
                al.c(this.gVn, d.C0141d.cp_cont_b, 2);
            }
        }
    }

    public void mU(boolean z) {
        this.gVq.setVisibility(z ? 0 : 4);
    }

    public ImageView bAz() {
        return this.gVq;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.gVm.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gVm.getPageContext(), i);
    }
}
