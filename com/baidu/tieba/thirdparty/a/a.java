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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.thirdparty.AccountBundlingActivity;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends c<AccountBundlingActivity> {
    private HeadImageView exm;
    private AccountBundlingActivity hnk;
    private EditText hnl;
    private View hnm;
    private TextView hnn;
    private ImageView hno;
    private boolean hnp;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public a(AccountBundlingActivity accountBundlingActivity) {
        super(accountBundlingActivity.getPageContext());
        this.hnk = accountBundlingActivity;
        accountBundlingActivity.setContentView(d.h.account_bunding_activty);
        n(accountBundlingActivity);
        o(accountBundlingActivity);
    }

    @SuppressLint({"ResourceAsColor"})
    private void n(AccountBundlingActivity accountBundlingActivity) {
        this.mRootView = (ViewGroup) this.hnk.findViewById(d.g.account_bunding_rootView);
        this.mNavigationBar = (NavigationBar) this.hnk.findViewById(d.g.account_bunding_navigation_bar);
        this.mNavigationBar.setTitleText(this.hnk.getPageContext().getString(d.j.login));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hnm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, accountBundlingActivity);
        this.hnn = (TextView) this.hnm.findViewById(d.g.right_textview);
        aj.e(this.hnn, d.C0141d.cp_link_tip_a, 1);
    }

    private void o(AccountBundlingActivity accountBundlingActivity) {
        this.exm = (HeadImageView) accountBundlingActivity.findViewById(d.g.account_bunding_head);
        this.hnl = (EditText) accountBundlingActivity.findViewById(d.g.account_bunding_edit);
        this.hno = (ImageView) accountBundlingActivity.findViewById(d.g.account_bunding_edit_del);
        this.hnn.setText(d.j.done);
        nk(false);
    }

    public ViewGroup afu() {
        return this.mRootView;
    }

    public HeadImageView bAo() {
        return this.exm;
    }

    public View bAp() {
        return this.hnm;
    }

    public EditText bAq() {
        return this.hnl;
    }

    public void bAr() {
        this.hnl.setText("");
    }

    public void nj(boolean z) {
        this.hnm.setEnabled(z);
    }

    public void tv(String str) {
        nk(false);
        boolean z = TextUtils.isEmpty(str.trim()) ? false : true;
        nj(z);
        nl(z);
        if (z) {
            aj.e(this.hnn, d.C0141d.cp_link_tip_a, 1);
        } else {
            aj.e(this.hnn, d.C0141d.navi_op_text, 1);
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            if (!TextUtils.isEmpty(sapiAccount.displayname)) {
                this.hnl.setText(sapiAccount.displayname);
                this.hnl.setSelection(sapiAccount.displayname.length());
            }
            this.exm.setIsRound(false);
            this.exm.setAutoChangeStyle(true);
            this.exm.setDrawBorder(false);
            this.exm.startLoad(sapiAccount.getSocialPortrait(), 10, false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void nk(boolean z) {
        if (this.hnp != z) {
            this.hnp = z;
            if (z) {
                aj.e(this.hnl, d.C0141d.cp_cont_h, 2);
            } else {
                aj.e(this.hnl, d.C0141d.cp_cont_b, 2);
            }
        }
    }

    public void nl(boolean z) {
        this.hno.setVisibility(z ? 0 : 4);
    }

    public ImageView bAs() {
        return this.hno;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.hnk.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hnk.getPageContext(), i);
    }
}
