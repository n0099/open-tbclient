package com.baidu.tieba.image;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private NavigationBar aRM;
    private AlphaAnimation aZb;
    private boolean aZd;
    private boolean afG;
    private String afH;
    private boolean afJ;
    private HashMap<String, ImageUrlData> bjP;
    private String bwP;
    private a bxA;
    private HashMap<String, Boolean> bxC;
    private String bxD;
    private String bxE;
    private String bxF;
    private boolean bxG;
    private ArrayList<String> bxr;
    private String bxs;
    private p bxu;
    private View bxv;
    private View bxw;
    private TextView bxx;
    private MultiImageView bxy;
    private o bxz;
    private int bxq = 0;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean bxt = true;
    private boolean aZc = true;
    private long bxB = 0;
    private com.baidu.tbadk.core.dialog.h bxH = new f(this);
    private View.OnClickListener bxI = new g(this);
    private View.OnLongClickListener bxJ = new i(this);
    private com.baidu.tbadk.core.view.a bxK = new j(this);
    private ViewPager.OnPageChangeListener bxL = new k(this);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.r.image_activity_2);
        initData(bundle);
        ON();
        Kw();
        if (!this.bxG) {
            String hV = hV(this.bxs);
            if (hV == null) {
                this.aRM.setVisibility(8);
            }
            this.bxA = new a(this.bxr, this.bxE, this.bwP, hV);
            this.bxA.dw(this.bxt);
            this.bxA.a(new l(this));
            this.bxA.Xp();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(com.baidu.tieba.k.big_imageview_in, com.baidu.tieba.k.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(com.baidu.tieba.k.fade_in, com.baidu.tieba.k.big_imageview_out);
    }

    public void SE() {
        try {
            byte[] currentImageData = this.bxy.getCurrentImageData();
            if (currentImageData != null) {
                this.bxu = new p(this, this.bxy.getCurrentImageUrl(), currentImageData);
                this.bxu.execute(new String[0]);
                this.bxv.setClickable(false);
            } else {
                showToast(getPageContext().getString(t.no_data));
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bxy.setBackgroundColor(ay.ci(i));
        } else {
            this.bxy.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        Xv();
    }

    private void Xv() {
        ay.j(this.aRM, com.baidu.tieba.n.alpha80_black);
        getLayoutMode().j(this.bxw);
        getLayoutMode().j(this.bxx);
        getLayoutMode().j(this.bxv);
    }

    private void Kw() {
        if (this.bxG) {
            this.bxz = new o(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.bxz, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bxy.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bxy.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bxy.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        R(this.mIndex, this.mIndex);
        Xx();
        this.bxy.onDestroy();
        if (this.bxu != null) {
            this.bxu.cancel();
            this.bxu = null;
        }
        if (this.bxG) {
            unregisterReceiver(this.bxz);
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

    private void ON() {
        MM();
        initViewPager();
        Xw();
        R(this.mIndex, this.mIndex);
    }

    private void MM() {
        this.aRM = (NavigationBar) findViewById(com.baidu.tieba.q.navigation_bar);
        this.bxx = this.aRM.setTitleText("");
        this.bxw = this.aRM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new m(this));
        this.bxv = this.aRM.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.image_activity_save_button, (View.OnClickListener) null);
        this.bxv.setOnClickListener(new n(this));
        this.aRM.findViewById(com.baidu.tieba.q.navBottomLine).setVisibility(8);
    }

    public void Xw() {
        String str;
        if (this.bxr != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bxq)) + "/";
            if (this.mCount > 0) {
                str = String.valueOf(str2) + this.mCount;
            } else if (!this.bxG) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.bxr.size();
            }
            if (this.bxy.getHasNext() && this.mIndex == this.bxy.getItemNum() - 1) {
                this.bxx.setText(getPageContext().getString(t.image_recommend));
                this.bxv.setClickable(false);
                this.bxv.setVisibility(8);
                return;
            }
            this.bxx.setText(str);
            this.bxv.setClickable(true);
            this.bxv.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.bxy = (MultiImageView) findViewById(com.baidu.tieba.q.viewpager);
        this.bxy.setIsFromCDN(this.afJ);
        this.bxy.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.bxy.w(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bxy.setOnPageChangeListener(this.bxL);
        this.bxy.setUrlData(this.bxr);
        this.bxy.setAssistUrls(this.bjP);
        this.bxy.setItemOnclickListener(this.bxI);
        this.bxy.setItemOnLongClickListener(this.bxJ);
        this.bxy.setCurrentItem(OT(), false);
        this.bxy.setOnScrollOutListener(this.bxK);
        this.bxy.setHasNext(this.afG);
        this.bxy.setNextTitle(this.afH);
    }

    public int OT() {
        if (this.bxr != null && this.bxr.size() > 0) {
            int size = this.bxr.size();
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

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.bxr = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.mCount = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.afG = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.afH = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.bxD = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bwP = bundle.getString("tid");
            this.bxE = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bxF = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.afJ = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.bxs = bundle.getString(ImageViewerConfig.LAST_ID);
            this.bxt = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof HashMap) {
                this.bjP = (HashMap) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bxr = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.mCount = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.afG = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.afH = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.bxD = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bwP = intent.getStringExtra("tid");
                this.bxE = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bxF = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.afJ = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.bxs = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.bxt = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof HashMap) {
                    this.bjP = (HashMap) serializableExtra;
                }
            }
        }
        if (getIntent() != null) {
            this.bxG = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.bxC = new HashMap<>();
        if (this.bxr != null) {
            this.mCount = this.bxr.size();
        }
        if (this.bxs == null) {
            this.bxs = this.mCount > 0 ? this.bxr.get(this.mCount - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.bxr);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.mCount);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.afG);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.afH);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.bxD);
        bundle.putString("tid", this.bwP);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.bxE);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.bxF);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.bxt);
        bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, this.bjP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bxy.setCurrentItem(this.mIndex, false);
    }

    public void R(int i, int i2) {
        synchronized (this.bxC) {
            if (System.nanoTime() - this.bxB > 300000000 && this.bxr != null && i < this.bxr.size()) {
                this.bxC.put(this.bxr.get(i), true);
            }
            this.bxB = System.nanoTime();
            if (this.bxr != null && i2 < this.bxr.size() && this.bxC.get(this.bxr.get(i2)) == null) {
                this.bxC.put(this.bxr.get(i2), false);
            }
        }
        if (this.bxC.size() >= 100) {
            Xx();
        }
    }

    private void Xx() {
        if (this.bxC != null) {
            synchronized (this.bxC) {
                if (this.bxC.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.bxC.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.bxC.size(), this.bxF);
                    this.bxC.clear();
                }
            }
        }
    }

    private String hV(String str) {
        int lastIndexOf;
        int indexOf;
        String aW = bb.aW(str);
        if (aW != null) {
            if (aW.indexOf(".baidu.com") != -1 && (lastIndexOf = aW.lastIndexOf("/")) != -1 && (indexOf = aW.indexOf(".", lastIndexOf)) != -1) {
                return aW.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aW;
    }
}
