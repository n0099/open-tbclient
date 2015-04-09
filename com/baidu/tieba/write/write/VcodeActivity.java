package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData cxz = null;
    private TextView cwj = null;
    private ImageView atD = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private ag cxN = null;
    private af cxO = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener ccP = null;
    private RelativeLayout aXd = null;
    private TextView aGo = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cxJ = new ab(this);
    private final View.OnClickListener cxK = new ac(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.vcode_activity);
        initUI();
        initData(bundle);
        eV(this.cxz.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.ccP = new ad(this);
        if (bundle != null) {
            this.cxz = (WriteData) bundle.getSerializable("model");
        } else {
            this.cxz = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cxz != null && this.cxz.getType() == 3) {
            if (this.cxN != null) {
                this.cxN.cancel();
            }
            if (this.cxO != null) {
                this.cxO.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cxN != null) {
            this.cxN.cancel();
        }
        if (this.cxO != null) {
            this.cxO.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cxz);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ba.e(this.aXd, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ba.g(this.cwj, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.ba.cd(i);
        } else {
            i2 = -12895429;
        }
        this.aGo.setTextColor(i2);
    }

    private void initUI() {
        this.aXd = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aGo = (TextView) findViewById(com.baidu.tieba.v.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cxJ);
        this.cwj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.send), this.cxK);
        this.mEdit = (EditText) findViewById(com.baidu.tieba.v.input);
        this.atD = (ImageView) findViewById(com.baidu.tieba.v.vcode_image);
        this.atD.setImageDrawable(null);
        this.atD.setOnClickListener(new ae(this));
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(String str) {
        if (this.cxO != null) {
            this.cxO.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.atD.setImageDrawable(null);
        this.cxO = new af(this, null);
        this.cxO.setPriority(3);
        this.cxO.execute(str);
    }
}
