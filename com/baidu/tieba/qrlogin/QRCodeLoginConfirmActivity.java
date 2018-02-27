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
    private View bCp;
    private LinearLayout cmX;
    private View dHy;
    private TextView gAk;
    private TextView gAl;
    private TextView gAm;
    private a gAn;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.layout_qr_code_confirm_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(d.j.login_confirm));
        this.bCp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCp.setOnClickListener(this);
        this.gAk = (TextView) findViewById(d.g.qrlogin_login_info);
        this.gAl = (TextView) findViewById(d.g.qrlogin_confirm_btn);
        this.gAm = (TextView) findViewById(d.g.qrlogin_cancel_btn);
        this.dHy = findViewById(d.g.qrlogin_tip_view);
        this.gAl.setOnClickListener(this);
        this.gAm.setOnClickListener(this);
        this.cmX = (LinearLayout) findViewById(d.g.qrlogin_content_layout);
        this.cmX.setVisibility(8);
        String str = null;
        if (getIntent() != null) {
            str = getIntent().getStringExtra(QRCodeLoginConfirmActivityConfig.QRCODE_RESULT);
        }
        if (StringUtils.isNull(str)) {
            UtilHelper.showToast(this, d.j.error);
            finish();
            return;
        }
        this.gAn = new a(this, this);
        this.gAn.start(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.r(this.gAl, d.C0141d.cp_cont_i);
        aj.s(this.gAl, d.f.selector_qr_login_confirm_btn);
        aj.r(this.gAm, d.C0141d.selector_qr_login_cancel_tv);
        aj.s(this.gAm, d.f.selector_qr_login_cancel_btn);
        aj.s(this.dHy, d.f.pc_scan_login_confirm);
        aj.r(this.gAk, d.C0141d.cp_cont_b);
    }

    @Override // com.baidu.tieba.qrlogin.b
    public void bnB() {
        this.cmX.setVisibility(0);
        bnC();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gAm) {
            TiebaStatic.log(new ak("c12709"));
            this.gAn.bnE();
        } else if (view == this.gAl) {
            TiebaStatic.log(new ak("c12710"));
            this.gAn.bnD();
        } else if (view == this.bCp) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaStatic.log(new ak("c12708"));
        this.gAn.onDestory();
    }

    private void bnC() {
        String accountNameShow;
        if (TbadkCoreApplication.getCurrentAccountInfo() != null && (accountNameShow = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow()) != null) {
            String e = am.e(accountNameShow, 30, "...");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(getString(d.j.about_to_login_with_name), e));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)), 4, e.length() + 4, 33);
            this.gAk.setText(spannableStringBuilder);
        }
    }
}
