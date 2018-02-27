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
    private HeadImageView ewW;
    private AccountBundlingActivity hmM;
    private EditText hmN;
    private View hmO;
    private TextView hmP;
    private ImageView hmQ;
    private boolean hmR;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public a(AccountBundlingActivity accountBundlingActivity) {
        super(accountBundlingActivity.getPageContext());
        this.hmM = accountBundlingActivity;
        accountBundlingActivity.setContentView(d.h.account_bunding_activty);
        n(accountBundlingActivity);
        o(accountBundlingActivity);
    }

    @SuppressLint({"ResourceAsColor"})
    private void n(AccountBundlingActivity accountBundlingActivity) {
        this.mRootView = (ViewGroup) this.hmM.findViewById(d.g.account_bunding_rootView);
        this.mNavigationBar = (NavigationBar) this.hmM.findViewById(d.g.account_bunding_navigation_bar);
        this.mNavigationBar.setTitleText(this.hmM.getPageContext().getString(d.j.login));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hmO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, accountBundlingActivity);
        this.hmP = (TextView) this.hmO.findViewById(d.g.right_textview);
        aj.e(this.hmP, d.C0141d.cp_link_tip_a, 1);
    }

    private void o(AccountBundlingActivity accountBundlingActivity) {
        this.ewW = (HeadImageView) accountBundlingActivity.findViewById(d.g.account_bunding_head);
        this.hmN = (EditText) accountBundlingActivity.findViewById(d.g.account_bunding_edit);
        this.hmQ = (ImageView) accountBundlingActivity.findViewById(d.g.account_bunding_edit_del);
        this.hmP.setText(d.j.done);
        nf(false);
    }

    public ViewGroup aft() {
        return this.mRootView;
    }

    public HeadImageView bAj() {
        return this.ewW;
    }

    public View bAk() {
        return this.hmO;
    }

    public EditText bAl() {
        return this.hmN;
    }

    public void bAm() {
        this.hmN.setText("");
    }

    public void ne(boolean z) {
        this.hmO.setEnabled(z);
    }

    public void tv(String str) {
        nf(false);
        boolean z = TextUtils.isEmpty(str.trim()) ? false : true;
        ne(z);
        ng(z);
        if (z) {
            aj.e(this.hmP, d.C0141d.cp_link_tip_a, 1);
        } else {
            aj.e(this.hmP, d.C0141d.navi_op_text, 1);
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            if (!TextUtils.isEmpty(sapiAccount.displayname)) {
                this.hmN.setText(sapiAccount.displayname);
                this.hmN.setSelection(sapiAccount.displayname.length());
            }
            this.ewW.setIsRound(false);
            this.ewW.setAutoChangeStyle(true);
            this.ewW.setDrawBorder(false);
            this.ewW.startLoad(sapiAccount.getSocialPortrait(), 10, false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void nf(boolean z) {
        if (this.hmR != z) {
            this.hmR = z;
            if (z) {
                aj.e(this.hmN, d.C0141d.cp_cont_h, 2);
            } else {
                aj.e(this.hmN, d.C0141d.cp_cont_b, 2);
            }
        }
    }

    public void ng(boolean z) {
        this.hmQ.setVisibility(z ? 0 : 4);
    }

    public ImageView bAn() {
        return this.hmQ;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.hmM.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hmM.getPageContext(), i);
    }
}
