package com.baidu.tieba.image;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity {
    private boolean Oc;
    private String Od;
    private boolean Of;
    private TextView aNE;
    private View bav;
    private ArrayList<String> bkK;
    private String bkL;
    private m bkN;
    private MultiImageView bkO;
    private l bkP;
    private a bkQ;
    private HashMap<String, Boolean> bkS;
    private String bkT;
    private String bkU;
    private String bkV;
    private boolean bkW;
    private String bkv;
    private int bkJ = 0;
    private int mIndex = -1;
    private int mq = -1;
    private boolean bkM = true;
    private long bkR = 0;
    private DialogInterface.OnClickListener aNG = new e(this);
    private View.OnClickListener bkX = new f(this);
    private View.OnLongClickListener bkY = new g(this);
    private com.baidu.tbadk.core.view.a bkZ = new h(this);
    private ViewPager.OnPageChangeListener bla = new i(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010000, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.m251getInst().addRemoteActivity(this);
        setContentView(w.image_activity_2);
        d(bundle);
        IJ();
        Fu();
        if (!this.bkW) {
            this.bkQ = new a(this.bkK, this.bkU, this.bkv, gJ(this.bkL));
            this.bkQ.dv(this.bkM);
            this.bkQ.a(new j(this));
            this.bkQ.Sc();
        }
    }

    public void Ot() {
        try {
            byte[] currentImageData = this.bkO.getCurrentImageData();
            if (currentImageData != null) {
                this.bkN = new m(this, this.bkO.getCurrentImageUrl(), currentImageData);
                this.bkN.execute(new String[0]);
                showProgressBarWithOffset(0, 0);
            } else {
                showToast(getString(y.no_data));
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bkO.setBackgroundColor(aw.by(i));
        } else {
            this.bkO.setBackgroundColor(-16777216);
        }
    }

    private void Fu() {
        if (this.bkW) {
            this.bkP = new l(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tieba.data.e.yv());
            registerReceiver(this.bkP, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bkO.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bkO.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bkO.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.m251getInst().delRemoteActivity(this);
        M(this.mIndex, this.mIndex);
        Se();
        this.bkO.onDestroy();
        hideProgressBar();
        if (this.bkN != null) {
            this.bkN.cancel();
            this.bkN = null;
        }
        if (this.bkW) {
            unregisterReceiver(this.bkP);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.bav != null && this.bav.getVisibility() == 0) {
                this.bav.setVisibility(8);
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra(ImageViewerConfig.INDEX, this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void IJ() {
        long j;
        int i;
        this.bav = findViewById(v.tip_mask);
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
            this.bav.setOnClickListener(new k(this));
            com.baidu.tbadk.core.sharedPref.b.lk().putString("image_viewer_tip", String.valueOf(i + 1) + "," + System.currentTimeMillis());
        }
        this.aNE = (TextView) findViewById(v.page_num);
        initViewPager();
        OD();
        M(this.mIndex, this.mIndex);
    }

    public void OD() {
        String str;
        if (this.bkK != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bkJ)) + "/";
            if (this.mq > 0) {
                str = String.valueOf(str2) + this.mq;
            } else if (!this.bkW) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.bkK.size();
            }
            if (this.bkO.getHasNext() && this.mIndex == this.bkO.getItemNum() - 1) {
                this.aNE.setVisibility(8);
                return;
            }
            this.aNE.setText(str);
            this.aNE.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.bkO = (MultiImageView) findViewById(v.viewpager);
        this.bkO.setIsFromCDN(this.Of);
        this.bkO.setPageMargin(com.baidu.adp.lib.util.m.dip2px(this, 8.0f));
        this.bkO.u(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bkO.setOnPageChangeListener(this.bla);
        this.bkO.setUrlData(this.bkK);
        this.bkO.setItemOnclickListener(this.bkX);
        this.bkO.setItemOnLongClickListener(this.bkY);
        this.bkO.setCurrentItem(Jq(), false);
        this.bkO.setOnScrollOutListener(this.bkZ);
        this.bkO.setHasNext(this.Oc);
        this.bkO.setNextTitle(this.Od);
    }

    public int Jq() {
        if (this.bkK != null && this.bkK.size() > 0) {
            int size = this.bkK.size();
            if (this.mIndex >= size) {
                this.mIndex = size - 1;
            }
            if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        } else {
            this.mIndex = 0;
        }
        return this.mIndex;
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.bkK = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.mq = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.Oc = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.Od = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.bkT = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bkv = bundle.getString("tid");
            this.bkU = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bkV = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.Of = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.bkL = bundle.getString(ImageViewerConfig.LAST_ID);
            this.bkM = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bkK = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.mq = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.Oc = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.Od = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.bkT = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bkv = intent.getStringExtra("tid");
                this.bkU = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bkV = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.Of = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.bkL = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.bkM = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
            }
        }
        if (getIntent() != null) {
            this.bkW = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.bkS = new HashMap<>();
        this.mq = this.bkK.size();
        if (this.bkL == null) {
            this.bkL = this.mq > 0 ? this.bkK.get(this.mq - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.bkK);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.mq);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.Oc);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.Od);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.bkT);
        bundle.putString("tid", this.bkv);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.bkU);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.bkV);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.bkM);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bkO.setCurrentItem(this.mIndex, false);
    }

    public void M(int i, int i2) {
        synchronized (this.bkS) {
            if (System.nanoTime() - this.bkR > 300000000 && this.bkK != null && i < this.bkK.size()) {
                this.bkS.put(this.bkK.get(i), true);
            }
            this.bkR = System.nanoTime();
            if (this.bkK != null && i2 < this.bkK.size() && this.bkS.get(this.bkK.get(i2)) == null) {
                this.bkS.put(this.bkK.get(i2), false);
            }
        }
        if (this.bkS.size() >= 100) {
            Se();
        }
    }

    private void Se() {
        if (this.bkS != null) {
            synchronized (this.bkS) {
                if (this.bkS.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.bkS.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkApplication.m251getInst().sendImagePv(i, this.bkS.size(), this.bkV);
                    this.bkS.clear();
                }
            }
        }
    }

    private String gJ(String str) {
        int lastIndexOf;
        int indexOf;
        String aD = az.aD(str);
        if (aD != null) {
            if (aD.indexOf(".baidu.com") != -1 && (lastIndexOf = aD.lastIndexOf("/")) != -1 && (indexOf = aD.indexOf(".", lastIndexOf)) != -1) {
                return aD.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aD;
    }
}
