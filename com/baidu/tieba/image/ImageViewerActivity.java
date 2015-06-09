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
    private NavigationBar aRN;
    private AlphaAnimation aZc;
    private boolean aZe;
    private boolean afG;
    private String afH;
    private boolean afJ;
    private HashMap<String, ImageUrlData> bjQ;
    private String bwQ;
    private o bxA;
    private a bxB;
    private HashMap<String, Boolean> bxD;
    private String bxE;
    private String bxF;
    private String bxG;
    private boolean bxH;
    private ArrayList<String> bxs;
    private String bxt;
    private p bxv;
    private View bxw;
    private View bxx;
    private TextView bxy;
    private MultiImageView bxz;
    private int bxr = 0;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean bxu = true;
    private boolean aZd = true;
    private long bxC = 0;
    private com.baidu.tbadk.core.dialog.h bxI = new f(this);
    private View.OnClickListener bxJ = new g(this);
    private View.OnLongClickListener bxK = new i(this);
    private com.baidu.tbadk.core.view.a bxL = new j(this);
    private ViewPager.OnPageChangeListener bxM = new k(this);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.r.image_activity_2);
        initData(bundle);
        OO();
        Kx();
        if (!this.bxH) {
            String hV = hV(this.bxt);
            if (hV == null) {
                this.aRN.setVisibility(8);
            }
            this.bxB = new a(this.bxs, this.bxF, this.bwQ, hV);
            this.bxB.dw(this.bxu);
            this.bxB.a(new l(this));
            this.bxB.Xq();
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

    public void SF() {
        try {
            byte[] currentImageData = this.bxz.getCurrentImageData();
            if (currentImageData != null) {
                this.bxv = new p(this, this.bxz.getCurrentImageUrl(), currentImageData);
                this.bxv.execute(new String[0]);
                this.bxw.setClickable(false);
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
            this.bxz.setBackgroundColor(ay.ci(i));
        } else {
            this.bxz.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        Xw();
    }

    private void Xw() {
        ay.j(this.aRN, com.baidu.tieba.n.alpha80_black);
        getLayoutMode().j(this.bxx);
        getLayoutMode().j(this.bxy);
        getLayoutMode().j(this.bxw);
    }

    private void Kx() {
        if (this.bxH) {
            this.bxA = new o(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.bxA, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bxz.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bxz.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bxz.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        R(this.mIndex, this.mIndex);
        Xy();
        this.bxz.onDestroy();
        if (this.bxv != null) {
            this.bxv.cancel();
            this.bxv = null;
        }
        if (this.bxH) {
            unregisterReceiver(this.bxA);
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

    private void OO() {
        MN();
        initViewPager();
        Xx();
        R(this.mIndex, this.mIndex);
    }

    private void MN() {
        this.aRN = (NavigationBar) findViewById(com.baidu.tieba.q.navigation_bar);
        this.bxy = this.aRN.setTitleText("");
        this.bxx = this.aRN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new m(this));
        this.bxw = this.aRN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.image_activity_save_button, (View.OnClickListener) null);
        this.bxw.setOnClickListener(new n(this));
        this.aRN.findViewById(com.baidu.tieba.q.navBottomLine).setVisibility(8);
    }

    public void Xx() {
        String str;
        if (this.bxs != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bxr)) + "/";
            if (this.mCount > 0) {
                str = String.valueOf(str2) + this.mCount;
            } else if (!this.bxH) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.bxs.size();
            }
            if (this.bxz.getHasNext() && this.mIndex == this.bxz.getItemNum() - 1) {
                this.bxy.setText(getPageContext().getString(t.image_recommend));
                this.bxw.setClickable(false);
                this.bxw.setVisibility(8);
                return;
            }
            this.bxy.setText(str);
            this.bxw.setClickable(true);
            this.bxw.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.bxz = (MultiImageView) findViewById(com.baidu.tieba.q.viewpager);
        this.bxz.setIsFromCDN(this.afJ);
        this.bxz.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.bxz.w(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bxz.setOnPageChangeListener(this.bxM);
        this.bxz.setUrlData(this.bxs);
        this.bxz.setAssistUrls(this.bjQ);
        this.bxz.setItemOnclickListener(this.bxJ);
        this.bxz.setItemOnLongClickListener(this.bxK);
        this.bxz.setCurrentItem(OU(), false);
        this.bxz.setOnScrollOutListener(this.bxL);
        this.bxz.setHasNext(this.afG);
        this.bxz.setNextTitle(this.afH);
    }

    public int OU() {
        if (this.bxs != null && this.bxs.size() > 0) {
            int size = this.bxs.size();
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
            this.bxs = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.mCount = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.afG = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.afH = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.bxE = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bwQ = bundle.getString("tid");
            this.bxF = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bxG = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.afJ = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.bxt = bundle.getString(ImageViewerConfig.LAST_ID);
            this.bxu = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof HashMap) {
                this.bjQ = (HashMap) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bxs = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.mCount = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.afG = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.afH = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.bxE = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bwQ = intent.getStringExtra("tid");
                this.bxF = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bxG = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.afJ = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.bxt = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.bxu = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof HashMap) {
                    this.bjQ = (HashMap) serializableExtra;
                }
            }
        }
        if (getIntent() != null) {
            this.bxH = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.bxD = new HashMap<>();
        if (this.bxs != null) {
            this.mCount = this.bxs.size();
        }
        if (this.bxt == null) {
            this.bxt = this.mCount > 0 ? this.bxs.get(this.mCount - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.bxs);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.mCount);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.afG);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.afH);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.bxE);
        bundle.putString("tid", this.bwQ);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.bxF);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.bxG);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.bxu);
        bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, this.bjQ);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bxz.setCurrentItem(this.mIndex, false);
    }

    public void R(int i, int i2) {
        synchronized (this.bxD) {
            if (System.nanoTime() - this.bxC > 300000000 && this.bxs != null && i < this.bxs.size()) {
                this.bxD.put(this.bxs.get(i), true);
            }
            this.bxC = System.nanoTime();
            if (this.bxs != null && i2 < this.bxs.size() && this.bxD.get(this.bxs.get(i2)) == null) {
                this.bxD.put(this.bxs.get(i2), false);
            }
        }
        if (this.bxD.size() >= 100) {
            Xy();
        }
    }

    private void Xy() {
        if (this.bxD != null) {
            synchronized (this.bxD) {
                if (this.bxD.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.bxD.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.bxD.size(), this.bxG);
                    this.bxD.clear();
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
