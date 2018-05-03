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
    private HeadImageView dRP;
    private AccountBundlingActivity gIH;
    private EditText gII;
    private View gIJ;
    private TextView gIK;
    private ImageView gIL;
    private boolean gIM;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public a(AccountBundlingActivity accountBundlingActivity) {
        super(accountBundlingActivity.getPageContext());
        this.gIH = accountBundlingActivity;
        accountBundlingActivity.setContentView(d.i.account_bunding_activty);
        n(accountBundlingActivity);
        o(accountBundlingActivity);
    }

    @SuppressLint({"ResourceAsColor"})
    private void n(AccountBundlingActivity accountBundlingActivity) {
        this.mRootView = (ViewGroup) this.gIH.findViewById(d.g.account_bunding_rootView);
        this.mNavigationBar = (NavigationBar) this.gIH.findViewById(d.g.account_bunding_navigation_bar);
        this.mNavigationBar.setTitleText(this.gIH.getPageContext().getString(d.k.login));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gIJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, accountBundlingActivity);
        this.gIK = (TextView) this.gIJ.findViewById(d.g.right_textview);
        ak.c(this.gIK, d.C0126d.cp_link_tip_a, 1);
    }

    private void o(AccountBundlingActivity accountBundlingActivity) {
        this.dRP = (HeadImageView) accountBundlingActivity.findViewById(d.g.account_bunding_head);
        this.gII = (EditText) accountBundlingActivity.findViewById(d.g.account_bunding_edit);
        this.gIL = (ImageView) accountBundlingActivity.findViewById(d.g.account_bunding_edit_del);
        this.gIK.setText(d.k.done);
        mM(false);
    }

    public ViewGroup ZG() {
        return this.mRootView;
    }

    public HeadImageView bvq() {
        return this.dRP;
    }

    public View bvr() {
        return this.gIJ;
    }

    public EditText bvs() {
        return this.gII;
    }

    public void bvt() {
        this.gII.setText("");
    }

    public void mL(boolean z) {
        this.gIJ.setEnabled(z);
    }

    public void tC(String str) {
        mM(false);
        boolean z = TextUtils.isEmpty(str.trim()) ? false : true;
        mL(z);
        mN(z);
        if (z) {
            ak.c(this.gIK, d.C0126d.cp_link_tip_a, 1);
        } else {
            ak.c(this.gIK, d.C0126d.navi_op_text, 1);
        }
    }

    public void c(SapiAccount sapiAccount) {
        if (sapiAccount != null) {
            if (!TextUtils.isEmpty(sapiAccount.displayname)) {
                this.gII.setText(sapiAccount.displayname);
                this.gII.setSelection(sapiAccount.displayname.length());
            }
            this.dRP.setIsRound(false);
            this.dRP.setAutoChangeStyle(true);
            this.dRP.setDrawBorder(false);
            this.dRP.startLoad(sapiAccount.getSocialPortrait(), 10, false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void mM(boolean z) {
        if (this.gIM != z) {
            this.gIM = z;
            if (z) {
                ak.c(this.gII, d.C0126d.cp_cont_h, 2);
            } else {
                ak.c(this.gII, d.C0126d.cp_cont_b, 2);
            }
        }
    }

    public void mN(boolean z) {
        this.gIL.setVisibility(z ? 0 : 4);
    }

    public ImageView bvu() {
        return this.gIL;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.gIH.getPageContext(), this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gIH.getPageContext(), i);
    }
}
