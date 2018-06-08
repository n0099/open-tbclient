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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class QRCodeLoginConfirmActivity extends BaseActivity implements View.OnClickListener, b {
    private View aUR;
    private LinearLayout bGe;
    private View dkS;
    private TextView ghF;
    private TextView ghG;
    private TextView ghH;
    private a ghI;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.layout_qr_code_confirm_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(d.k.login_confirm));
        this.aUR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUR.setOnClickListener(this);
        this.ghF = (TextView) findViewById(d.g.qrlogin_login_info);
        this.ghG = (TextView) findViewById(d.g.qrlogin_confirm_btn);
        this.ghH = (TextView) findViewById(d.g.qrlogin_cancel_btn);
        this.dkS = findViewById(d.g.qrlogin_tip_view);
        this.ghG.setOnClickListener(this);
        this.ghH.setOnClickListener(this);
        this.bGe = (LinearLayout) findViewById(d.g.qrlogin_content_layout);
        this.bGe.setVisibility(8);
        String str = null;
        if (getIntent() != null) {
            str = getIntent().getStringExtra(QRCodeLoginConfirmActivityConfig.QRCODE_RESULT);
        }
        if (StringUtils.isNull(str)) {
            UtilHelper.showToast(this, d.k.error);
            finish();
            return;
        }
        this.ghI = new a(this, this);
        this.ghI.start(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.ghG, d.C0141d.cp_cont_i);
        al.i(this.ghG, d.f.selector_qr_login_confirm_btn);
        al.h(this.ghH, d.C0141d.selector_qr_login_cancel_tv);
        al.i(this.ghH, d.f.selector_qr_login_cancel_btn);
        al.i(this.dkS, d.f.pc_scan_login_confirm);
        al.h(this.ghF, d.C0141d.cp_cont_b);
    }

    @Override // com.baidu.tieba.qrlogin.b
    public void bnG() {
        this.bGe.setVisibility(0);
        bnH();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ghH) {
            TiebaStatic.log(new am("c12709"));
            this.ghI.bnJ();
        } else if (view == this.ghG) {
            TiebaStatic.log(new am("c12710"));
            this.ghI.bnI();
        } else if (view == this.aUR) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaStatic.log(new am("c12708"));
        this.ghI.onDestory();
    }

    private void bnH() {
        String accountNameShow;
        if (TbadkCoreApplication.getCurrentAccountInfo() != null && (accountNameShow = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow()) != null) {
            String e = ao.e(accountNameShow, 30, "...");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(getString(d.k.about_to_login_with_name), e));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_a)), 4, e.length() + 4, 33);
            this.ghF.setText(spannableStringBuilder);
        }
    }
}
