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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData cfW = null;
    private TextView bPL = null;
    private ImageView anr = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private ab cgk = null;
    private aa cgl = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bHG = null;
    private RelativeLayout mParent = null;
    private TextView axW = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cgg = new w(this);
    private final View.OnClickListener cgh = new x(this);

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
        de(this.cfW.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.bHG = new y(this);
        if (bundle != null) {
            this.cfW = (WriteData) bundle.getSerializable("model");
        } else {
            this.cfW = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cfW != null && this.cfW.getType() == 3) {
            if (this.cgk != null) {
                this.cgk.cancel();
            }
            if (this.cgl != null) {
                this.cgl.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cgk != null) {
            this.cgk.cancel();
        }
        if (this.cgl != null) {
            this.cgl.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cfW);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.bc.e(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.bc.g(this.bPL, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.bc.cb(i);
        } else {
            i2 = -12895429;
        }
        this.axW.setTextColor(i2);
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.axW = (TextView) findViewById(com.baidu.tieba.w.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cgg);
        this.bPL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.send), this.cgh);
        this.mEdit = (EditText) findViewById(com.baidu.tieba.w.input);
        this.anr = (ImageView) findViewById(com.baidu.tieba.w.vcode_image);
        this.anr.setImageDrawable(null);
        this.anr.setOnClickListener(new z(this));
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(String str) {
        if (this.cgl != null) {
            this.cgl.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.anr.setImageDrawable(null);
        this.cgl = new aa(this, null);
        this.cgl.setPriority(3);
        this.cgl.execute(str);
    }
}
