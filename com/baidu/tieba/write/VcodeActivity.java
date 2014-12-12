package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData cex = null;
    private TextView bOb = null;
    private ImageView akv = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private ab ceL = null;
    private aa ceM = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bFV = null;
    private RelativeLayout mParent = null;
    private TextView awW = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener ceH = new w(this);
    private final View.OnClickListener ceI = new x(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(VcodeActivityConfig.class, VcodeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.vcode_activity);
        initUI();
        initData(bundle);
        df(this.cex.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.bFV = new y(this);
        if (bundle != null) {
            this.cex = (WriteData) bundle.getSerializable("model");
        } else {
            this.cex = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cex != null && this.cex.getType() == 3) {
            if (this.ceL != null) {
                this.ceL.cancel();
            }
            if (this.ceM != null) {
                this.ceM.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), Constants.MEDIA_INFO, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ceL != null) {
            this.ceL.cancel();
        }
        if (this.ceM != null) {
            this.ceM.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cex);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ax.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ax.g(this.bOb, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.ax.bU(i);
        } else {
            i2 = -12895429;
        }
        this.awW.setTextColor(i2);
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.awW = (TextView) findViewById(com.baidu.tieba.w.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ceH);
        this.bOb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.send), this.ceI);
        this.mEdit = (EditText) findViewById(com.baidu.tieba.w.input);
        this.akv = (ImageView) findViewById(com.baidu.tieba.w.vcode_image);
        this.akv.setImageDrawable(null);
        this.akv.setOnClickListener(new z(this));
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void df(String str) {
        if (this.ceM != null) {
            this.ceM.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.akv.setImageDrawable(null);
        this.ceM = new aa(this, null);
        this.ceM.setPriority(3);
        this.ceM.execute(str);
    }
}
