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
    private WriteData cxg = null;
    private TextView cvT = null;
    private ImageView atv = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private ag cxu = null;
    private af cxv = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener ccA = null;
    private RelativeLayout aWN = null;
    private TextView aGg = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cxq = new ab(this);
    private final View.OnClickListener cxr = new ac(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.vcode_activity);
        initUI();
        initData(bundle);
        eS(this.cxg.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.ccA = new ad(this);
        if (bundle != null) {
            this.cxg = (WriteData) bundle.getSerializable("model");
        } else {
            this.cxg = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cxg != null && this.cxg.getType() == 3) {
            if (this.cxu != null) {
                this.cxu.cancel();
            }
            if (this.cxv != null) {
                this.cxv.cancel();
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
        if (this.cxu != null) {
            this.cxu.cancel();
        }
        if (this.cxv != null) {
            this.cxv.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cxg);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ba.e(this.aWN, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ba.g(this.cvT, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.ba.cd(i);
        } else {
            i2 = -12895429;
        }
        this.aGg.setTextColor(i2);
    }

    private void initUI() {
        this.aWN = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aGg = (TextView) findViewById(com.baidu.tieba.v.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cxq);
        this.cvT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.send), this.cxr);
        this.mEdit = (EditText) findViewById(com.baidu.tieba.v.input);
        this.atv = (ImageView) findViewById(com.baidu.tieba.v.vcode_image);
        this.atv.setImageDrawable(null);
        this.atv.setOnClickListener(new ae(this));
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS(String str) {
        if (this.cxv != null) {
            this.cxv.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.atv.setImageDrawable(null);
        this.cxv = new af(this, null);
        this.cxv.setPriority(3);
        this.cxv.execute(str);
    }
}
