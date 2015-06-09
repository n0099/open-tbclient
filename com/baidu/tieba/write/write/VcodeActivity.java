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
    private WriteData cBS = null;
    private TextView cAA = null;
    private ImageView avb = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private ah cCg = null;
    private ag cCh = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener bSJ = null;
    private RelativeLayout aZK = null;
    private TextView aIx = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cCc = new ac(this);
    private final View.OnClickListener cCd = new ad(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.vcode_activity);
        initUI();
        initData(bundle);
        fq(this.cBS.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.bSJ = new ae(this);
        if (bundle != null) {
            this.cBS = (WriteData) bundle.getSerializable("model");
        } else {
            this.cBS = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cBS != null && this.cBS.getType() == 3) {
            if (this.cCg != null) {
                this.cCg.cancel();
            }
            if (this.cCh != null) {
                this.cCh.cancel();
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
        if (this.cCg != null) {
            this.cCg.cancel();
        }
        if (this.cCh != null) {
            this.cCh.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cBS);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ay.e(this.aZK, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ay.g(this.cAA, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.ay.ch(i);
        } else {
            i2 = -12895429;
        }
        this.aIx.setTextColor(i2);
    }

    private void initUI() {
        this.aZK = (RelativeLayout) findViewById(com.baidu.tieba.q.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.aIx = (TextView) findViewById(com.baidu.tieba.q.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cCc);
        this.cAA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.t.send), this.cCd);
        this.mEdit = (EditText) findViewById(com.baidu.tieba.q.input);
        this.avb = (ImageView) findViewById(com.baidu.tieba.q.vcode_image);
        this.avb.setImageDrawable(null);
        this.avb.setOnClickListener(new af(this));
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.q.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(String str) {
        if (this.cCh != null) {
            this.cCh.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.avb.setImageDrawable(null);
        this.cCh = new ag(this, null);
        this.cCh.setPriority(3);
        this.cCh.execute(str);
    }
}
