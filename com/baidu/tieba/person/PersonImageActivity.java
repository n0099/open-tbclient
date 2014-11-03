package com.baidu.tieba.person;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PersonImageActivity extends BaseActivity {
    private String aNI;
    private View bav;
    private Context mContext;
    private bj bCV = null;
    private MultiImageView aNF = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener NY = null;
    private DialogInterface.OnClickListener aNG = null;
    private com.baidu.tbadk.core.view.a aNH = null;

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
        arrayList.add(this.aNI);
        this.aNF.setIsFromCDN(true);
        this.aNF.setAllowLocalUrl(true);
        this.aNF.setUrlData(arrayList);
        this.aNF.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.aNF.setBackgroundColor(com.baidu.tbadk.core.util.aw.by(i));
        } else {
            this.aNF.setBackgroundColor(-16777216);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aNF.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aNF.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.aNF.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.m251getInst().delRemoteActivity(this);
        this.aNF.onDestroy();
        if (this.bCV != null) {
            this.bCV.cancel();
            this.bCV = null;
        }
        hideProgressBar();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bav != null && this.bav.getVisibility() == 0) {
                this.bav.setVisibility(8);
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void initUI() {
        long j;
        int i;
        this.mOnClickListener = new be(this);
        this.NY = new bf(this);
        this.aNG = new bg(this);
        this.aNH = new bh(this);
        this.bav = findViewById(com.baidu.tieba.v.tip_mask);
        String string = com.baidu.tbadk.core.sharedPref.b.lk().getString("image_viewer_tip", "");
        if (string == null || string.indexOf(",") <= 0) {
            j = 0;
            i = 0;
        } else {
            String[] split = string.split(",");
            i = com.baidu.adp.lib.g.c.f(split[0], 0);
            j = com.baidu.adp.lib.g.c.a(split[1], 0L);
        }
        if (i < 5 && (j == 0 || System.currentTimeMillis() - j > 86400000)) {
            this.bav.setVisibility(0);
            this.bav.setOnClickListener(new bi(this));
            com.baidu.tbadk.core.sharedPref.b.lk().putString("image_viewer_tip", String.valueOf(i + 1) + "," + System.currentTimeMillis());
        }
        this.aNF = (MultiImageView) findViewById(com.baidu.tieba.v.viewpager);
        this.aNF.setPageMargin(com.baidu.adp.lib.util.m.dip2px(this, 8.0f));
        this.aNF.u(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.aNF.setItemOnclickListener(this.mOnClickListener);
        this.aNF.setItemOnLongClickListener(this.NY);
        this.aNF.setCurrentItem(0, false);
        this.aNF.setOnScrollOutListener(this.aNH);
        this.aNF.setHasNext(false);
        this.aNF.setNextTitle("mNextTitle");
        this.aNF.setHeadImage(true);
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.aNI = bundle.getString("curImgUrl");
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.aNI = intent.getStringExtra("curImgUrl");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("curImgUrl", this.aNI);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aNF.setCurrentItem(0, true);
    }
}
