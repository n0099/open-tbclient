package com.baidu.tieba.qrlogin;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeLoginConfirmActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class QRCodeLoginConfirmActivity extends BaseActivity implements View.OnClickListener, b {
    private View bCs;
    private LinearLayout cna;
    private View dHD;
    private TextView gAA;
    private TextView gAB;
    private TextView gAC;
    private a gAD;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.layout_qr_code_confirm_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(d.j.login_confirm));
        this.bCs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCs.setOnClickListener(this);
        this.gAA = (TextView) findViewById(d.g.qrlogin_login_info);
        this.gAB = (TextView) findViewById(d.g.qrlogin_confirm_btn);
        this.gAC = (TextView) findViewById(d.g.qrlogin_cancel_btn);
        this.dHD = findViewById(d.g.qrlogin_tip_view);
        this.gAB.setOnClickListener(this);
        this.gAC.setOnClickListener(this);
        this.cna = (LinearLayout) findViewById(d.g.qrlogin_content_layout);
        this.cna.setVisibility(8);
        String str = null;
        if (getIntent() != null) {
            str = getIntent().getStringExtra(QRCodeLoginConfirmActivityConfig.QRCODE_RESULT);
        }
        if (StringUtils.isNull(str)) {
            UtilHelper.showToast(this, d.j.error);
            finish();
            return;
        }
        this.gAD = new a(this, this);
        this.gAD.start(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.r(this.gAB, d.C0141d.cp_cont_i);
        aj.s(this.gAB, d.f.selector_qr_login_confirm_btn);
        aj.r(this.gAC, d.C0141d.selector_qr_login_cancel_tv);
        aj.s(this.gAC, d.f.selector_qr_login_cancel_btn);
        aj.s(this.dHD, d.f.pc_scan_login_confirm);
        aj.r(this.gAA, d.C0141d.cp_cont_b);
    }

    @Override // com.baidu.tieba.qrlogin.b
    public void bnC() {
        this.cna.setVisibility(0);
        bnD();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gAC) {
            TiebaStatic.log(new ak("c12709"));
            this.gAD.bnF();
        } else if (view == this.gAB) {
            TiebaStatic.log(new ak("c12710"));
            this.gAD.bnE();
        } else if (view == this.bCs) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaStatic.log(new ak("c12708"));
        this.gAD.onDestory();
    }

    private void bnD() {
        String accountNameShow;
        if (TbadkCoreApplication.getCurrentAccountInfo() != null && (accountNameShow = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow()) != null) {
            String e = am.e(accountNameShow, 30, "...");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(getString(d.j.about_to_login_with_name), e));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)), 4, e.length() + 4, 33);
            this.gAA.setText(spannableStringBuilder);
        }
    }
}
