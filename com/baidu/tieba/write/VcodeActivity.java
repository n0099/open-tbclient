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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity {
    private WriteData bTq = null;
    private TextView bJL = null;
    private ImageView acK = null;
    private EditText bCl = null;
    private ProgressBar mProgressBar = null;
    private ab bTE = null;
    private aa bTF = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bCv = null;
    private RelativeLayout mParent = null;
    private TextView atN = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener bTA = new w(this);
    private final View.OnClickListener bTB = new x(this);

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
        cm(this.bTq.getVcodeUrl());
    }

    private void d(Bundle bundle) {
        this.bCv = new y(this);
        if (bundle != null) {
            this.bTq = (WriteData) bundle.getSerializable("model");
        } else {
            this.bTq = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bTq != null && this.bTq.getType() == 3) {
            if (this.bTE != null) {
                this.bTE.cancel();
            }
            if (this.bTF != null) {
                this.bTF.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.b.b.a(this, Constants.MEDIA_INFO, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bTE != null) {
            this.bTE.cancel();
        }
        if (this.bTF != null) {
            this.bTF.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.bTq);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.d(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.f(this.bJL, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.aw.bx(i);
        } else {
            i2 = -12895429;
        }
        this.atN.setTextColor(i2);
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.atN = (TextView) findViewById(com.baidu.tieba.v.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bTA);
        this.bJL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.send), this.bTB);
        this.bCl = (EditText) findViewById(com.baidu.tieba.v.input);
        this.acK = (ImageView) findViewById(com.baidu.tieba.v.vcode_image);
        this.acK.setImageDrawable(null);
        this.acK.setOnClickListener(new z(this));
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(String str) {
        if (this.bTF != null) {
            this.bTF.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.acK.setImageDrawable(null);
        this.bTF = new aa(this, null);
        this.bTF.setPriority(3);
        this.bTF.execute(str);
    }
}
