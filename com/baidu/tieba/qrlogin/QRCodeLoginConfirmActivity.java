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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class QRCodeLoginConfirmActivity extends BaseActivity implements View.OnClickListener, b {
    private View aMS;
    private LinearLayout bxk;
    private View dau;
    private TextView fVk;
    private TextView fVl;
    private TextView fVm;
    private a fVn;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.layout_qr_code_confirm_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(d.k.login_confirm));
        this.aMS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aMS.setOnClickListener(this);
        this.fVk = (TextView) findViewById(d.g.qrlogin_login_info);
        this.fVl = (TextView) findViewById(d.g.qrlogin_confirm_btn);
        this.fVm = (TextView) findViewById(d.g.qrlogin_cancel_btn);
        this.dau = findViewById(d.g.qrlogin_tip_view);
        this.fVl.setOnClickListener(this);
        this.fVm.setOnClickListener(this);
        this.bxk = (LinearLayout) findViewById(d.g.qrlogin_content_layout);
        this.bxk.setVisibility(8);
        String str = null;
        if (getIntent() != null) {
            str = getIntent().getStringExtra(QRCodeLoginConfirmActivityConfig.QRCODE_RESULT);
        }
        if (StringUtils.isNull(str)) {
            UtilHelper.showToast(this, d.k.error);
            finish();
            return;
        }
        this.fVn = new a(this, this);
        this.fVn.start(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ak.h(this.fVl, d.C0126d.cp_cont_i);
        ak.i(this.fVl, d.f.selector_qr_login_confirm_btn);
        ak.h(this.fVm, d.C0126d.selector_qr_login_cancel_tv);
        ak.i(this.fVm, d.f.selector_qr_login_cancel_btn);
        ak.i(this.dau, d.f.pc_scan_login_confirm);
        ak.h(this.fVk, d.C0126d.cp_cont_b);
    }

    @Override // com.baidu.tieba.qrlogin.b
    public void biI() {
        this.bxk.setVisibility(0);
        biJ();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.fVm) {
            TiebaStatic.log(new al("c12709"));
            this.fVn.biL();
        } else if (view2 == this.fVl) {
            TiebaStatic.log(new al("c12710"));
            this.fVn.biK();
        } else if (view2 == this.aMS) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaStatic.log(new al("c12708"));
        this.fVn.onDestory();
    }

    private void biJ() {
        String accountNameShow;
        if (TbadkCoreApplication.getCurrentAccountInfo() != null && (accountNameShow = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow()) != null) {
            String e = an.e(accountNameShow, 30, "...");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(getString(d.k.about_to_login_with_name), e));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_a)), 4, e.length() + 4, 33);
            this.fVk.setText(spannableStringBuilder);
        }
    }
}
