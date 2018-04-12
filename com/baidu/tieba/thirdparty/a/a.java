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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.thirdparty.AccountBundlingActivity;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends c<AccountBundlingActivity> {
    private HeadImageView dRS;
    private AccountBundlingActivity gIK;
    private EditText gIL;
    private View gIM;
    private TextView gIN;
    private ImageView gIO;
    private boolean gIP;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public a(AccountBundlingActivity accountBundlingActivity) {
        super(accountBundlingActivity.getPageContext());
        this.gIK = accountBundlingActivity;
        accountBundlingActivity.setContentView(d.i.account_bunding_activty);
        n(accountBundlingActivity);
        o(accountBundlingActivity);
    }

    @SuppressLint({"ResourceAsColor"})
    private void n(AccountBundlingActivity accountBundlingActivity) {
        this.mRootView = (ViewGroup) this.gIK.findViewById(d.g.account_bunding_rootView);
        this.mNavigationBar = (NavigationBar) this.gIK.findViewById(d.g.account_bunding_navigation_bar);
        this.mNavigationBar.setTitleText(this.gIK.getPageContext().getString(d.k.login));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gIM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, accountBundlingActivity);
        this.gIN = (TextView) this.gIM.findViewById(d.g.right_textview);
        ak.c(this.gIN, d.C0126d.cp_link_tip_a, 1);
    }

    private void o(AccountBundlingActivity accountBundlingActivity) {
        this.dRS = (HeadImageView) accountBundlingActivity.findViewById(d.g.account_bunding_head);
        this.gIL = (EditText) accountBundlingActivity.findViewById(d.g.account_bunding_edit);
        this.gIO = (ImageView) accountBundlingActivity.findViewById(d.g.account_bunding_edit_del);
        this.gIN.setText(d.k.done);
        mM(false);
    }

    public ViewGroup ZG() {
        return this.mRootView;
    }

    public HeadImageView bvq() {
        return this.dRS;
    }

    public View bvr() {
        return this.gIM;
    }

    public EditText bvs() {
        return this.gIL;
    }

    public void bvt() {
        this.gIL.setText("");
    }

    public void mL(boolean z) {
        this.gIM.setEnabled(z);
    }

    public void tC(String str) {
        mM(false);
        boolean z = TextUtils.isEmpty(str.trim()) ? false : true;
        mL(z);
        mN(z);
        if (z) {
            ak.c(this.gIN, d.C0126d.cp_link_tip_a, 1);
        } else {
            ak.c(this.gIN, d.C0126d.navi_op_text, 1);
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            if (!TextUtils.isEmpty(sapiAccount.displayname)) {
                this.gIL.setText(sapiAccount.displayname);
                this.gIL.setSelection(sapiAccount.displayname.length());
            }
            this.dRS.setIsRound(false);
            this.dRS.setAutoChangeStyle(true);
            this.dRS.setDrawBorder(false);
            this.dRS.startLoad(sapiAccount.getSocialPortrait(), 10, false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void mM(boolean z) {
        if (this.gIP != z) {
            this.gIP = z;
            if (z) {
                ak.c(this.gIL, d.C0126d.cp_cont_h, 2);
            } else {
                ak.c(this.gIL, d.C0126d.cp_cont_b, 2);
            }
        }
    }

    public void mN(boolean z) {
        this.gIO.setVisibility(z ? 0 : 4);
    }

    public ImageView bvu() {
        return this.gIO;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.gIK.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gIK.getPageContext(), i);
    }
}
