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
/* loaded from: classes3.dex */
public class a extends c<AccountBundlingActivity> {
    private HeadImageView exi;
    private AccountBundlingActivity hmZ;
    private EditText hna;
    private View hnb;
    private TextView hnc;
    private ImageView hnd;
    private boolean hne;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public a(AccountBundlingActivity accountBundlingActivity) {
        super(accountBundlingActivity.getPageContext());
        this.hmZ = accountBundlingActivity;
        accountBundlingActivity.setContentView(d.h.account_bunding_activty);
        n(accountBundlingActivity);
        o(accountBundlingActivity);
    }

    @SuppressLint({"ResourceAsColor"})
    private void n(AccountBundlingActivity accountBundlingActivity) {
        this.mRootView = (ViewGroup) this.hmZ.findViewById(d.g.account_bunding_rootView);
        this.mNavigationBar = (NavigationBar) this.hmZ.findViewById(d.g.account_bunding_navigation_bar);
        this.mNavigationBar.setTitleText(this.hmZ.getPageContext().getString(d.j.login));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hnb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, accountBundlingActivity);
        this.hnc = (TextView) this.hnb.findViewById(d.g.right_textview);
        aj.e(this.hnc, d.C0140d.cp_link_tip_a, 1);
    }

    private void o(AccountBundlingActivity accountBundlingActivity) {
        this.exi = (HeadImageView) accountBundlingActivity.findViewById(d.g.account_bunding_head);
        this.hna = (EditText) accountBundlingActivity.findViewById(d.g.account_bunding_edit);
        this.hnd = (ImageView) accountBundlingActivity.findViewById(d.g.account_bunding_edit_del);
        this.hnc.setText(d.j.done);
        nf(false);
    }

    public ViewGroup afu() {
        return this.mRootView;
    }

    public HeadImageView bAk() {
        return this.exi;
    }

    public View bAl() {
        return this.hnb;
    }

    public EditText bAm() {
        return this.hna;
    }

    public void bAn() {
        this.hna.setText("");
    }

    public void ne(boolean z) {
        this.hnb.setEnabled(z);
    }

    public void tv(String str) {
        nf(false);
        boolean z = TextUtils.isEmpty(str.trim()) ? false : true;
        ne(z);
        ng(z);
        if (z) {
            aj.e(this.hnc, d.C0140d.cp_link_tip_a, 1);
        } else {
            aj.e(this.hnc, d.C0140d.navi_op_text, 1);
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            if (!TextUtils.isEmpty(sapiAccount.displayname)) {
                this.hna.setText(sapiAccount.displayname);
                this.hna.setSelection(sapiAccount.displayname.length());
            }
            this.exi.setIsRound(false);
            this.exi.setAutoChangeStyle(true);
            this.exi.setDrawBorder(false);
            this.exi.startLoad(sapiAccount.getSocialPortrait(), 10, false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void nf(boolean z) {
        if (this.hne != z) {
            this.hne = z;
            if (z) {
                aj.e(this.hna, d.C0140d.cp_cont_h, 2);
            } else {
                aj.e(this.hna, d.C0140d.cp_cont_b, 2);
            }
        }
    }

    public void ng(boolean z) {
        this.hnd.setVisibility(z ? 0 : 4);
    }

    public ImageView bAo() {
        return this.hnd;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.hmZ.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hmZ.getPageContext(), i);
    }
}
