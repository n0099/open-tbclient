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
    private View bCC;
    private com.baidu.tbadk.core.view.b bCM;
    private LinearLayout cnj;
    private View dHK;
    private TextView gAv;
    private TextView gAw;
    private TextView gAx;
    private a gAy;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.layout_qr_code_confirm_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(d.j.login_confirm));
        this.bCC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bCC.setOnClickListener(this);
        this.gAv = (TextView) findViewById(d.g.qrlogin_login_info);
        this.gAw = (TextView) findViewById(d.g.qrlogin_confirm_btn);
        this.gAx = (TextView) findViewById(d.g.qrlogin_cancel_btn);
        this.dHK = findViewById(d.g.qrlogin_tip_view);
        this.gAw.setOnClickListener(this);
        this.gAx.setOnClickListener(this);
        this.cnj = (LinearLayout) findViewById(d.g.qrlogin_content_layout);
        this.cnj.setVisibility(8);
        String str = null;
        if (getIntent() != null) {
            str = getIntent().getStringExtra(QRCodeLoginConfirmActivityConfig.QRCODE_RESULT);
        }
        if (StringUtils.isNull(str)) {
            UtilHelper.showToast(this, d.j.error);
            finish();
            return;
        }
        this.gAy = new a(this, this);
        this.gAy.start(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.r(this.gAw, d.C0140d.cp_cont_i);
        aj.s(this.gAw, d.f.selector_qr_login_confirm_btn);
        aj.r(this.gAx, d.C0140d.selector_qr_login_cancel_tv);
        aj.s(this.gAx, d.f.selector_qr_login_cancel_btn);
        aj.s(this.dHK, d.f.pc_scan_login_confirm);
        aj.r(this.gAv, d.C0140d.cp_cont_b);
    }

    @Override // com.baidu.tieba.qrlogin.b
    public void bnC() {
        this.cnj.setVisibility(0);
        bnD();
    }

    @Override // com.baidu.tieba.qrlogin.b
    public void bnj() {
        if (this.bCM == null) {
            this.bCM = new com.baidu.tbadk.core.view.b(getPageContext());
            this.bCM.d(null);
            this.bCM.ga(d.j.loading);
        }
        this.bCM.bq(true);
    }

    @Override // com.baidu.tieba.qrlogin.b
    public void bnk() {
        if (this.bCM != null) {
            this.bCM.bq(false);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gAx) {
            TiebaStatic.log(new ak("c12709"));
            this.gAy.bnF();
        } else if (view == this.gAw) {
            TiebaStatic.log(new ak("c12710"));
            this.gAy.bnE();
        } else if (view == this.bCC) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaStatic.log(new ak("c12708"));
        this.gAy.onDestory();
    }

    private void bnD() {
        String accountNameShow;
        if (TbadkCoreApplication.getCurrentAccountInfo() != null && (accountNameShow = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow()) != null) {
            String e = am.e(accountNameShow, 30, "...");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(getString(d.j.about_to_login_with_name), e));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0140d.cp_link_tip_a)), 4, e.length() + 4, 33);
            this.gAv.setText(spannableStringBuilder);
        }
    }
}
