package com.baidu.tieba.person;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonImageActivity extends BaseActivity {
    private String aNu;
    private Context mContext;
    private ProgressBar mProgress = null;
    private bi bCH = null;
    private MultiImageView aNr = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener NU = null;
    private DialogInterface.OnClickListener aNs = null;
    private com.baidu.tbadk.core.view.a aNt = null;

    public static void startActivity(Context context, String str) {
        if (context != null) {
            Intent intent = new Intent(context, PersonImageActivity.class);
            intent.putExtra("curImgUrl", str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.m251getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.person_image_activity);
        d(bundle);
        initUI();
        ArrayList<String> arrayList = new ArrayList<>();
        this.mContext = this;
        arrayList.add(this.aNu);
        this.aNr.setIsFromCDN(true);
        this.aNr.setAllowLocalUrl(true);
        this.aNr.setUrlData(arrayList);
        this.aNr.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aNr.setBackgroundColor(com.baidu.tbadk.core.util.aw.by(i));
        } else {
            this.aNr.setBackgroundColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aNr.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aNr.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aNr.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.m251getInst().delRemoteActivity(this);
        this.aNr.onDestroy();
        if (this.bCH != null) {
            this.bCH.cancel();
            this.bCH = null;
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void initUI() {
        this.mOnClickListener = new be(this);
        this.NU = new bf(this);
        this.aNs = new bg(this);
        this.aNt = new bh(this);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.aNr = (MultiImageView) findViewById(com.baidu.tieba.v.viewpager);
        this.aNr.setPageMargin(com.baidu.adp.lib.util.m.dip2px(this, 8.0f));
        this.aNr.u(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aNr.setItemOnclickListener(this.mOnClickListener);
        this.aNr.setItemOnLongClickListener(this.NU);
        this.aNr.setCurrentItem(0, false);
        this.aNr.setOnScrollOutListener(this.aNt);
        this.aNr.setHasNext(false);
        this.aNr.setNextTitle("mNextTitle");
        this.aNr.setHeadImage(true);
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.aNu = bundle.getString("curImgUrl");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.aNu = intent.getStringExtra("curImgUrl");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.aNu);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aNr.setCurrentItem(0, true);
    }
}
