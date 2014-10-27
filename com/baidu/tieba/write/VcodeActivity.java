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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity {
    private WriteData bTb = null;
    private TextView bJw = null;
    private ImageView acF = null;
    private EditText bBX = null;
    private ProgressBar mProgressBar = null;
    private ab bTp = null;
    private aa bTq = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bCh = null;
    private RelativeLayout mParent = null;
    private TextView atE = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener bTl = new w(this);
    private final View.OnClickListener bTm = new x(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(VcodeActivityConfig.class, VcodeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.vcode_activity);
        initUI();
        d(bundle);
        cm(this.bTb.getVcodeUrl());
    }

    private void d(Bundle bundle) {
        this.bCh = new y(this);
        if (bundle != null) {
            this.bTb = (WriteData) bundle.getSerializable("model");
        } else {
            this.bTb = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bTp != null) {
            this.bTp.cancel();
        }
        if (this.bTq != null) {
            this.bTq.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.bTb);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.d(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.f(this.bJw, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.aw.bx(i);
        } else {
            i2 = -12895429;
        }
        this.atE.setTextColor(i2);
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.atE = (TextView) findViewById(com.baidu.tieba.v.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bTl);
        this.bJw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.send), this.bTm);
        this.bBX = (EditText) findViewById(com.baidu.tieba.v.input);
        this.acF = (ImageView) findViewById(com.baidu.tieba.v.vcode_image);
        this.acF.setImageDrawable(null);
        this.acF.setOnClickListener(new z(this));
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(String str) {
        if (this.bTq != null) {
            this.bTq.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.acF.setImageDrawable(null);
        this.bTq = new aa(this, null);
        this.bTq.setPriority(3);
        this.bTq.execute(str);
    }
}
