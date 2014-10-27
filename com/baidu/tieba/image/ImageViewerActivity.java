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
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity {
    private boolean NY;
    private String NZ;
    private boolean Ob;
    private TextView aNq;
    private MultiImageView bkA;
    private k bkB;
    private a bkC;
    private HashMap<String, Boolean> bkE;
    private String bkF;
    private String bkG;
    private String bkH;
    private boolean bkI;
    private String bkh;
    private ArrayList<String> bkw;
    private String bkx;
    private l bkz;
    private int bkv = 0;
    private int mIndex = -1;
    private int mq = -1;
    private boolean bky = true;
    private long bkD = 0;
    private DialogInterface.OnClickListener aNs = new e(this);
    private View.OnClickListener bkJ = new f(this);
    private View.OnLongClickListener bkK = new g(this);
    private com.baidu.tbadk.core.view.a bkL = new h(this);
    private ViewPager.OnPageChangeListener bkM = new i(this);

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
        IF();
        Fs();
        if (!this.bkI) {
            this.bkC = new a(this.bkw, this.bkG, this.bkh, gJ(this.bkx));
            this.bkC.dv(this.bky);
            this.bkC.a(new j(this));
            this.bkC.RZ();
        }
    }

    public void Oq() {
        try {
            byte[] currentImageData = this.bkA.getCurrentImageData();
            if (currentImageData != null) {
                this.bkz = new l(this, this.bkA.getCurrentImageUrl(), currentImageData);
                this.bkz.execute(new String[0]);
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
            this.bkA.setBackgroundColor(aw.by(i));
        } else {
            this.bkA.setBackgroundColor(-16777216);
        }
    }

    private void Fs() {
        if (this.bkI) {
            this.bkB = new k(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tieba.data.e.yt());
            registerReceiver(this.bkB, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bkA.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bkA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bkA.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.m251getInst().delRemoteActivity(this);
        M(this.mIndex, this.mIndex);
        Sb();
        this.bkA.onDestroy();
        hideProgressBar();
        if (this.bkz != null) {
            this.bkz.cancel();
            this.bkz = null;
        }
        if (this.bkI) {
            unregisterReceiver(this.bkB);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra(ImageViewerConfig.INDEX, this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void IF() {
        this.aNq = (TextView) findViewById(v.page_num);
        initViewPager();
        OA();
        M(this.mIndex, this.mIndex);
    }

    public void OA() {
        String str;
        if (this.bkw != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bkv)) + "/";
            if (this.mq > 0) {
                str = String.valueOf(str2) + this.mq;
            } else if (!this.bkI) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.bkw.size();
            }
            if (this.bkA.getHasNext() && this.mIndex == this.bkA.getItemNum() - 1) {
                this.aNq.setVisibility(8);
                return;
            }
            this.aNq.setText(str);
            this.aNq.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.bkA = (MultiImageView) findViewById(v.viewpager);
        this.bkA.setIsFromCDN(this.Ob);
        this.bkA.setPageMargin(m.dip2px(this, 8.0f));
        this.bkA.u(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bkA.setOnPageChangeListener(this.bkM);
        this.bkA.setUrlData(this.bkw);
        this.bkA.setItemOnclickListener(this.bkJ);
        this.bkA.setItemOnLongClickListener(this.bkK);
        this.bkA.setCurrentItem(Jm(), false);
        this.bkA.setOnScrollOutListener(this.bkL);
        this.bkA.setHasNext(this.NY);
        this.bkA.setNextTitle(this.NZ);
    }

    public int Jm() {
        if (this.bkw != null && this.bkw.size() > 0) {
            int size = this.bkw.size();
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
            this.bkw = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.mq = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.NY = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.NZ = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.bkF = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bkh = bundle.getString("tid");
            this.bkG = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bkH = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.Ob = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.bkx = bundle.getString(ImageViewerConfig.LAST_ID);
            this.bky = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bkw = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.mq = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.NY = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.NZ = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.bkF = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bkh = intent.getStringExtra("tid");
                this.bkG = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bkH = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.Ob = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.bkx = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.bky = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
            }
        }
        if (getIntent() != null) {
            this.bkI = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.bkE = new HashMap<>();
        this.mq = this.bkw.size();
        if (this.bkx == null) {
            this.bkx = this.mq > 0 ? this.bkw.get(this.mq - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.bkw);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.mq);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.NY);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.NZ);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.bkF);
        bundle.putString("tid", this.bkh);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.bkG);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.bkH);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.bky);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bkA.setCurrentItem(this.mIndex, false);
    }

    public void M(int i, int i2) {
        synchronized (this.bkE) {
            if (System.nanoTime() - this.bkD > 300000000 && this.bkw != null && i < this.bkw.size()) {
                this.bkE.put(this.bkw.get(i), true);
            }
            this.bkD = System.nanoTime();
            if (this.bkw != null && i2 < this.bkw.size() && this.bkE.get(this.bkw.get(i2)) == null) {
                this.bkE.put(this.bkw.get(i2), false);
            }
        }
        if (this.bkE.size() >= 100) {
            Sb();
        }
    }

    private void Sb() {
        if (this.bkE != null) {
            synchronized (this.bkE) {
                if (this.bkE.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.bkE.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkApplication.m251getInst().sendImagePv(i, this.bkE.size(), this.bkH);
                    this.bkE.clear();
                }
            }
        }
    }

    private String gJ(String str) {
        int lastIndexOf;
        int indexOf;
        String aD = ay.aD(str);
        if (aD != null) {
            if (aD.indexOf(".baidu.com") != -1 && (lastIndexOf = aD.lastIndexOf("/")) != -1 && (indexOf = aD.indexOf(".", lastIndexOf)) != -1) {
                return aD.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aD;
    }
}
