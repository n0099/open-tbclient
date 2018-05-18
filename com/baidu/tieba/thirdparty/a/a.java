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
    private HeadImageView dSW;
    private AccountBundlingActivity gJK;
    private EditText gJL;
    private View gJM;
    private TextView gJN;
    private ImageView gJO;
    private boolean gJP;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public a(AccountBundlingActivity accountBundlingActivity) {
        super(accountBundlingActivity.getPageContext());
        this.gJK = accountBundlingActivity;
        accountBundlingActivity.setContentView(d.i.account_bunding_activty);
        n(accountBundlingActivity);
        o(accountBundlingActivity);
    }

    @SuppressLint({"ResourceAsColor"})
    private void n(AccountBundlingActivity accountBundlingActivity) {
        this.mRootView = (ViewGroup) this.gJK.findViewById(d.g.account_bunding_rootView);
        this.mNavigationBar = (NavigationBar) this.gJK.findViewById(d.g.account_bunding_navigation_bar);
        this.mNavigationBar.setTitleText(this.gJK.getPageContext().getString(d.k.login));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gJM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, accountBundlingActivity);
        this.gJN = (TextView) this.gJM.findViewById(d.g.right_textview);
        ak.c(this.gJN, d.C0126d.cp_link_tip_a, 1);
    }

    private void o(AccountBundlingActivity accountBundlingActivity) {
        this.dSW = (HeadImageView) accountBundlingActivity.findViewById(d.g.account_bunding_head);
        this.gJL = (EditText) accountBundlingActivity.findViewById(d.g.account_bunding_edit);
        this.gJO = (ImageView) accountBundlingActivity.findViewById(d.g.account_bunding_edit_del);
        this.gJN.setText(d.k.done);
        mN(false);
    }

    public ViewGroup ZJ() {
        return this.mRootView;
    }

    public HeadImageView bvo() {
        return this.dSW;
    }

    public View bvp() {
        return this.gJM;
    }

    public EditText bvq() {
        return this.gJL;
    }

    public void bvr() {
        this.gJL.setText("");
    }

    public void mM(boolean z) {
        this.gJM.setEnabled(z);
    }

    public void tF(String str) {
        mN(false);
        boolean z = TextUtils.isEmpty(str.trim()) ? false : true;
        mM(z);
        mO(z);
        if (z) {
            ak.c(this.gJN, d.C0126d.cp_link_tip_a, 1);
        } else {
            ak.c(this.gJN, d.C0126d.navi_op_text, 1);
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            if (!TextUtils.isEmpty(sapiAccount.displayname)) {
                this.gJL.setText(sapiAccount.displayname);
                this.gJL.setSelection(sapiAccount.displayname.length());
            }
            this.dSW.setIsRound(false);
            this.dSW.setAutoChangeStyle(true);
            this.dSW.setDrawBorder(false);
            this.dSW.startLoad(sapiAccount.getSocialPortrait(), 10, false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void mN(boolean z) {
        if (this.gJP != z) {
            this.gJP = z;
            if (z) {
                ak.c(this.gJL, d.C0126d.cp_cont_h, 2);
            } else {
                ak.c(this.gJL, d.C0126d.cp_cont_b, 2);
            }
        }
    }

    public void mO(boolean z) {
        this.gJO.setVisibility(z ? 0 : 4);
    }

    public ImageView bvs() {
        return this.gJO;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.gJK.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gJK.getPageContext(), i);
    }
}
