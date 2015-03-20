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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private NavigationBar aPk;
    private boolean aWh;
    private boolean aeu;
    private String aev;
    private boolean aex;
    private AlphaAnimation atw;
    private HashMap<String, ImageUrlData> bgT;
    private String btQ;
    private MultiImageView buA;
    private o buB;
    private a buC;
    private HashMap<String, Boolean> buE;
    private String buF;
    private String buG;
    private String buH;
    private boolean buI;
    private ArrayList<String> but;
    private String buu;
    private p buw;
    private View bux;
    private View buy;
    private TextView buz;
    private int bus = 0;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean buv = true;
    private boolean aWg = true;
    private long buD = 0;
    private com.baidu.tbadk.core.dialog.h buJ = new f(this);
    private View.OnClickListener buK = new g(this);
    private View.OnLongClickListener buL = new i(this);
    private com.baidu.tbadk.core.view.a buM = new j(this);
    private ViewPager.OnPageChangeListener buN = new k(this);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(w.image_activity_2);
        initData(bundle);
        Nl();
        Jm();
        if (!this.buI) {
            String hp = hp(this.buu);
            if (hp == null) {
                this.aPk.setVisibility(8);
            }
            this.buC = new a(this.but, this.buG, this.btQ, hp);
            this.buC.dm(this.buv);
            this.buC.a(new l(this));
            this.buC.VK();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(com.baidu.tieba.p.big_imageview_in, com.baidu.tieba.p.fade_out);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(com.baidu.tieba.p.fade_in, com.baidu.tieba.p.big_imageview_out);
    }

    public void Re() {
        try {
            byte[] currentImageData = this.buA.getCurrentImageData();
            if (currentImageData != null) {
                this.buw = new p(this, this.buA.getCurrentImageUrl(), currentImageData);
                this.buw.execute(new String[0]);
                this.bux.setClickable(false);
            } else {
                showToast(getPageContext().getString(y.no_data));
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.buA.setBackgroundColor(ba.ce(i));
        } else {
            this.buA.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        VQ();
    }

    private void VQ() {
        ba.j(this.aPk, s.alpha80_black);
        getLayoutMode().h(this.buy);
        getLayoutMode().h(this.buz);
        getLayoutMode().h(this.bux);
    }

    private void Jm() {
        if (this.buI) {
            this.buB = new o(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.buB, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.buA.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.buA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.buA.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        O(this.mIndex, this.mIndex);
        VS();
        this.buA.onDestroy();
        if (this.buw != null) {
            this.buw.cancel();
            this.buw = null;
        }
        if (this.buI) {
            unregisterReceiver(this.buB);
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

    private void Nl() {
        Lv();
        initViewPager();
        VR();
        O(this.mIndex, this.mIndex);
    }

    private void Lv() {
        this.aPk = (NavigationBar) findViewById(v.navigation_bar);
        this.buz = this.aPk.setTitleText("");
        this.buy = this.aPk.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new m(this));
        this.bux = this.aPk.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.image_activity_save_button, (View.OnClickListener) null);
        this.bux.setOnClickListener(new n(this));
        this.aPk.findViewById(v.navBottomLine).setVisibility(8);
    }

    public void VR() {
        String str;
        if (this.but != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bus)) + "/";
            if (this.mCount > 0) {
                str = String.valueOf(str2) + this.mCount;
            } else if (!this.buI) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.but.size();
            }
            if (this.buA.getHasNext() && this.mIndex == this.buA.getItemNum() - 1) {
                this.buz.setText(getPageContext().getString(y.image_recommend));
                this.bux.setClickable(false);
                this.bux.setVisibility(8);
                return;
            }
            this.buz.setText(str);
            this.bux.setClickable(true);
            this.bux.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.buA = (MultiImageView) findViewById(v.viewpager);
        this.buA.setIsFromCDN(this.aex);
        this.buA.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.buA.v(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.buA.setOnPageChangeListener(this.buN);
        this.buA.setUrlData(this.but);
        this.buA.setAssistUrls(this.bgT);
        this.buA.setItemOnclickListener(this.buK);
        this.buA.setItemOnLongClickListener(this.buL);
        this.buA.setCurrentItem(Nr(), false);
        this.buA.setOnScrollOutListener(this.buM);
        this.buA.setHasNext(this.aeu);
        this.buA.setNextTitle(this.aev);
    }

    public int Nr() {
        if (this.but != null && this.but.size() > 0) {
            int size = this.but.size();
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
            this.but = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.mCount = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.aeu = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.aev = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.buF = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.btQ = bundle.getString("tid");
            this.buG = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.buH = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.aex = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.buu = bundle.getString(ImageViewerConfig.LAST_ID);
            this.buv = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof HashMap) {
                this.bgT = (HashMap) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.but = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.mCount = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.aeu = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.aev = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.buF = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.btQ = intent.getStringExtra("tid");
                this.buG = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.buH = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.aex = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.buu = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.buv = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof HashMap) {
                    this.bgT = (HashMap) serializableExtra;
                }
            }
        }
        if (getIntent() != null) {
            this.buI = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.buE = new HashMap<>();
        if (this.but != null) {
            this.mCount = this.but.size();
        }
        if (this.buu == null) {
            this.buu = this.mCount > 0 ? this.but.get(this.mCount - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.but);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.mCount);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.aeu);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.aev);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.buF);
        bundle.putString("tid", this.btQ);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.buG);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.buH);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.buv);
        bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, this.bgT);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.buA.setCurrentItem(this.mIndex, false);
    }

    public void O(int i, int i2) {
        synchronized (this.buE) {
            if (System.nanoTime() - this.buD > 300000000 && this.but != null && i < this.but.size()) {
                this.buE.put(this.but.get(i), true);
            }
            this.buD = System.nanoTime();
            if (this.but != null && i2 < this.but.size() && this.buE.get(this.but.get(i2)) == null) {
                this.buE.put(this.but.get(i2), false);
            }
        }
        if (this.buE.size() >= 100) {
            VS();
        }
    }

    private void VS() {
        if (this.buE != null) {
            synchronized (this.buE) {
                if (this.buE.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.buE.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.buE.size(), this.buH);
                    this.buE.clear();
                }
            }
        }
    }

    private String hp(String str) {
        int lastIndexOf;
        int indexOf;
        String aN = bd.aN(str);
        if (aN != null) {
            if (aN.indexOf(".baidu.com") != -1 && (lastIndexOf = aN.lastIndexOf("/")) != -1 && (indexOf = aN.indexOf(".", lastIndexOf)) != -1) {
                return aN.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aN;
    }
}
