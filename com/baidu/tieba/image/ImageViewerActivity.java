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
    private NavigationBar aPB;
    private boolean aWx;
    private boolean aeC;
    private String aeD;
    private boolean aeF;
    private AlphaAnimation atE;
    private HashMap<String, ImageUrlData> bhj;
    private ArrayList<String> buJ;
    private String buK;
    private p buM;
    private View buN;
    private View buO;
    private TextView buP;
    private MultiImageView buQ;
    private o buR;
    private a buS;
    private HashMap<String, Boolean> buU;
    private String buV;
    private String buW;
    private String buX;
    private boolean buY;
    private String buh;
    private int buI = 0;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean buL = true;
    private boolean aWw = true;
    private long buT = 0;
    private com.baidu.tbadk.core.dialog.h buZ = new f(this);
    private View.OnClickListener bva = new g(this);
    private View.OnLongClickListener bvb = new i(this);
    private com.baidu.tbadk.core.view.a bvc = new j(this);
    private ViewPager.OnPageChangeListener bvd = new k(this);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(w.image_activity_2);
        initData(bundle);
        Ny();
        Js();
        if (!this.buY) {
            String hs = hs(this.buK);
            if (hs == null) {
                this.aPB.setVisibility(8);
            }
            this.buS = new a(this.buJ, this.buW, this.buh, hs);
            this.buS.dk(this.buL);
            this.buS.a(new l(this));
            this.buS.VX();
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

    public void Rr() {
        try {
            byte[] currentImageData = this.buQ.getCurrentImageData();
            if (currentImageData != null) {
                this.buM = new p(this, this.buQ.getCurrentImageUrl(), currentImageData);
                this.buM.execute(new String[0]);
                this.buN.setClickable(false);
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
            this.buQ.setBackgroundColor(ba.ce(i));
        } else {
            this.buQ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        Wd();
    }

    private void Wd() {
        ba.j(this.aPB, s.alpha80_black);
        getLayoutMode().h(this.buO);
        getLayoutMode().h(this.buP);
        getLayoutMode().h(this.buN);
    }

    private void Js() {
        if (this.buY) {
            this.buR = new o(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.buR, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.buQ.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.buQ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.buQ.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        O(this.mIndex, this.mIndex);
        Wf();
        this.buQ.onDestroy();
        if (this.buM != null) {
            this.buM.cancel();
            this.buM = null;
        }
        if (this.buY) {
            unregisterReceiver(this.buR);
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

    private void Ny() {
        LH();
        initViewPager();
        We();
        O(this.mIndex, this.mIndex);
    }

    private void LH() {
        this.aPB = (NavigationBar) findViewById(v.navigation_bar);
        this.buP = this.aPB.setTitleText("");
        this.buO = this.aPB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new m(this));
        this.buN = this.aPB.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.image_activity_save_button, (View.OnClickListener) null);
        this.buN.setOnClickListener(new n(this));
        this.aPB.findViewById(v.navBottomLine).setVisibility(8);
    }

    public void We() {
        String str;
        if (this.buJ != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.buI)) + "/";
            if (this.mCount > 0) {
                str = String.valueOf(str2) + this.mCount;
            } else if (!this.buY) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.buJ.size();
            }
            if (this.buQ.getHasNext() && this.mIndex == this.buQ.getItemNum() - 1) {
                this.buP.setText(getPageContext().getString(y.image_recommend));
                this.buN.setClickable(false);
                this.buN.setVisibility(8);
                return;
            }
            this.buP.setText(str);
            this.buN.setClickable(true);
            this.buN.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.buQ = (MultiImageView) findViewById(v.viewpager);
        this.buQ.setIsFromCDN(this.aeF);
        this.buQ.setPageMargin(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.buQ.v(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.buQ.setOnPageChangeListener(this.bvd);
        this.buQ.setUrlData(this.buJ);
        this.buQ.setAssistUrls(this.bhj);
        this.buQ.setItemOnclickListener(this.bva);
        this.buQ.setItemOnLongClickListener(this.bvb);
        this.buQ.setCurrentItem(NE(), false);
        this.buQ.setOnScrollOutListener(this.bvc);
        this.buQ.setHasNext(this.aeC);
        this.buQ.setNextTitle(this.aeD);
    }

    public int NE() {
        if (this.buJ != null && this.buJ.size() > 0) {
            int size = this.buJ.size();
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
            this.buJ = bundle.getStringArrayList(ImageViewerConfig.URL);
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.mCount = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.aeC = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.aeD = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.buV = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.buh = bundle.getString("tid");
            this.buW = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.buX = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.aeF = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.buK = bundle.getString(ImageViewerConfig.LAST_ID);
            this.buL = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof HashMap) {
                this.bhj = (HashMap) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.buJ = intent.getStringArrayListExtra(ImageViewerConfig.URL);
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.mCount = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.aeC = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.aeD = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.buV = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.buh = intent.getStringExtra("tid");
                this.buW = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.buX = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.aeF = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.buK = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.buL = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof HashMap) {
                    this.bhj = (HashMap) serializableExtra;
                }
            }
        }
        if (getIntent() != null) {
            this.buY = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.buU = new HashMap<>();
        if (this.buJ != null) {
            this.mCount = this.buJ.size();
        }
        if (this.buK == null) {
            this.buK = this.mCount > 0 ? this.buJ.get(this.mCount - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(ImageViewerConfig.URL, this.buJ);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.mCount);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.aeC);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.aeD);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.buV);
        bundle.putString("tid", this.buh);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.buW);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.buX);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.buL);
        bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, this.bhj);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.buQ.setCurrentItem(this.mIndex, false);
    }

    public void O(int i, int i2) {
        synchronized (this.buU) {
            if (System.nanoTime() - this.buT > 300000000 && this.buJ != null && i < this.buJ.size()) {
                this.buU.put(this.buJ.get(i), true);
            }
            this.buT = System.nanoTime();
            if (this.buJ != null && i2 < this.buJ.size() && this.buU.get(this.buJ.get(i2)) == null) {
                this.buU.put(this.buJ.get(i2), false);
            }
        }
        if (this.buU.size() >= 100) {
            Wf();
        }
    }

    private void Wf() {
        if (this.buU != null) {
            synchronized (this.buU) {
                if (this.buU.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.buU.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.buU.size(), this.buX);
                    this.buU.clear();
                }
            }
        }
    }

    private String hs(String str) {
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
