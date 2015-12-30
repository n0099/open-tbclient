package com.baidu.tieba.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.z;
import com.baidu.tieba.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private boolean amU;
    private String amV;
    private boolean amZ;
    private AlphaAnimation bJW;
    private boolean bJY;
    private NavigationBar boZ;
    private String cjE;
    private int ckE;
    private int ckF;
    private ArrayList<String> cki;
    private String ckj;
    private Map<String, ImageUrlData> ckl;
    private b ckm;
    private View ckn;
    private View cko;
    private TextView ckp;
    private MultiImageView ckq;
    private a ckr;
    private j cks;
    private HashMap<String, Boolean> cku;
    private String ckv;
    private String ckw;
    private String ckx;
    private boolean cky;
    private String mFrom;
    private boolean mIsSeeHost;
    private String mUserId;
    private int ckh = 0;
    private int mIndex = -1;
    private int wJ = -1;
    private boolean ckk = true;
    private boolean bJX = true;
    private long ckt = 0;
    private boolean ckz = true;
    private com.baidu.tieba.image.a ckA = null;
    private boolean ckB = false;
    private boolean ckC = false;
    private boolean ckD = true;
    private z.b anb = new n(this);
    private c.b ckG = new p(this);
    private View.OnClickListener ckH = new q(this);
    private View.OnLongClickListener ckI = new r(this);
    private BaseViewPager.a ckJ = new s(this);
    private ViewPager.OnPageChangeListener ahv = new t(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(n.h.image_activity_2);
        initData(bundle);
        TZ();
        MY();
        if (!this.cky) {
            String jA = jA(this.ckj);
            if (jA == null) {
                this.boZ.setVisibility(8);
            }
            if (jD(this.ckj)) {
                this.boZ.setVisibility(0);
            }
            this.cks = new j(this.cki, this.ckl, this.ckv, this.ckw, this.cjE, jA, this.mUserId, this.mFrom);
            this.cks.ee(this.ckk);
            this.cks.ef(this.mIsSeeHost);
            this.cks.a(new u(this));
            this.cks.afh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zz() {
        byte[] bArr;
        String str;
        try {
            byte[] currentImageData = this.ckq.getCurrentImageData();
            if (currentImageData != null) {
                String currentImageUrl = this.ckq.getCurrentImageUrl();
                if (this.ckl != null) {
                    ImageUrlData imageUrlData = this.ckl.get(currentImageUrl);
                    if (imageUrlData == null || StringUtils.isNull(imageUrlData.originalUrl, true) || imageUrlData.originalProcess != 100) {
                        bArr = currentImageData;
                        str = currentImageUrl;
                    } else {
                        String dB = az.dB(imageUrlData.originalUrl);
                        String dg = com.baidu.tbadk.core.util.n.dg(String.valueOf(com.baidu.tbadk.core.util.n.tS()) + aw.uU().dv(dB) + "/" + dB);
                        if (StringUtils.isNull(dg, true)) {
                            dg = "jpg";
                        }
                        str = String.valueOf(com.baidu.tbadk.core.util.n.tS()) + dB + "." + dg;
                        bArr = null;
                    }
                } else {
                    bArr = currentImageData;
                    str = currentImageUrl;
                }
                this.ckm = new b(str, bArr);
                this.ckm.execute(new String[0]);
                this.ckn.setClickable(false);
                return;
            }
            showToast(getPageContext().getString(n.j.no_data));
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ckq.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.ckq.cK(i);
        afo();
        super.onChangeSkinType(i);
    }

    private void afo() {
        as.j(this.boZ, n.d.alpha80_black);
        getLayoutMode().k(this.cko);
        getLayoutMode().k(this.ckp);
        getLayoutMode().k(this.ckn);
        as.a(this.boZ.getBackImageView(), n.f.icon_return_bg_s, n.f.icon_return_bg, 0);
    }

    private void MY() {
        if (this.cky) {
            this.ckr = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.ckr, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ckq.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ckq.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.ckq.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        at(this.mIndex, this.mIndex);
        aft();
        this.ckq.onDestroy();
        if (this.ckm != null) {
            this.ckm.cancel();
            this.ckm = null;
        }
        if (this.cky) {
            unregisterReceiver(this.ckr);
        }
        com.baidu.tbadk.download.d.Be().dX(13);
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

    private void TZ() {
        Qz();
        initViewPager();
        afp();
        at(this.mIndex, this.mIndex);
    }

    private void Qz() {
        this.boZ = (NavigationBar) findViewById(n.g.navigation_bar);
        this.ckp = this.boZ.setTitleText("");
        this.cko = this.boZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new v(this));
        this.ckn = this.boZ.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.image_activity_save_button, (View.OnClickListener) null);
        this.ckn.setOnClickListener(new w(this));
        as.a(this.boZ.getBackImageView(), n.f.icon_return_bg_s, n.f.icon_return_bg, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afp() {
        String str;
        if (this.cki != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.ckh)) + "/";
            if (this.wJ > 0) {
                str = String.valueOf(str2) + this.wJ;
            } else if (!this.cky) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.cki.size();
            }
            if (afq()) {
                afs();
            } else {
                jB(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afq() {
        return this.ckz && this.ckA != null && this.ckA.aeS() && this.mIndex == this.ckq.getItemNum() + (-1);
    }

    private void jB(String str) {
        this.ckp.setText(str);
        if (!this.ckD) {
            this.ckn.setVisibility(8);
            return;
        }
        this.ckn.setClickable(true);
        this.ckn.setVisibility(0);
    }

    private boolean afr() {
        if (this.cki == null) {
            return false;
        }
        Iterator<String> it = this.cki.iterator();
        while (it.hasNext()) {
            if (jC(it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean jC(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }

    private void afs() {
        this.ckp.setText(getPageContext().getString(n.j.navigation_title_ad));
        this.ckn.setClickable(false);
        this.ckn.setVisibility(8);
    }

    private void initViewPager() {
        this.ckq = (MultiImageView) findViewById(n.g.viewpager);
        this.ckq.setIsFromCDN(this.amZ);
        this.ckq.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.ckq.H(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.ckq.setOnPageChangeListener(this.ahv);
        this.ckq.setUrlData(this.cki);
        this.ckq.setAssistUrls(this.ckl);
        this.ckq.setItemOnclickListener(this.ckH);
        this.ckq.setItemOnLongClickListener(this.ckI);
        this.ckq.setCurrentItem(VS(), false);
        this.ckq.setOnScrollOutListener(this.ckJ);
        this.ckq.setHasNext(this.amU);
        this.ckq.setNextTitle(this.amV);
        this.ckA = new com.baidu.tieba.image.a(this.amZ, this.ckz, getPageContext(), this.ckv, this.cjE);
        this.ckq.a(this.ckA);
        this.ckq.setOriImgSelectedCallback(this.anb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int VS() {
        if (this.cki != null && this.cki.size() > 0) {
            int size = this.cki.size();
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
            this.cki = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.wJ = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.amU = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.amV = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.ckv = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.cjE = bundle.getString("tid");
            this.ckw = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.ckx = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.amZ = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.ckj = bundle.getString(ImageViewerConfig.LAST_ID);
            this.ckk = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.ckz = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof Map) {
                this.ckl = (Map) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.cki = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.wJ = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.amU = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.amV = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.ckv = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.cjE = intent.getStringExtra("tid");
                this.ckw = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.ckx = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.amZ = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.ckj = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.ckk = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.ckz = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.ckl = (Map) serializableExtra;
                }
                this.ckF = this.mIndex;
                this.ckE = this.mIndex;
            }
        }
        if (getIntent() != null) {
            this.cky = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.cku = new HashMap<>();
        if (this.cki != null) {
            this.wJ = this.cki.size();
        }
        if (StringUtils.isNull(this.ckj, true)) {
            this.ckj = this.wJ > 0 ? this.cki.get(this.wJ - 1) : "";
        }
        this.ckD = afr();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.cki);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.wJ);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.amU);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.amV);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.ckv);
        bundle.putString("tid", this.cjE);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.ckw);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.ckx);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.ckk);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.ckz);
        bundle.putString("user_id", this.mUserId);
        if (this.ckl instanceof HashMap) {
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, (HashMap) this.ckl);
        } else if (this.ckl instanceof ConcurrentHashMap) {
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, (ConcurrentHashMap) this.ckl);
        }
        bundle.putString("from", this.mFrom);
        bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.mIsSeeHost);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ckq.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        byte[] mData;
        String mUrl;

        public b(String str, byte[] bArr) {
            this.mUrl = null;
            this.mData = null;
            this.mUrl = str;
            this.mData = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.mData == null && ImageViewerActivity.this.ckl != null) {
                String dB = az.dB(((ImageUrlData) ImageViewerActivity.this.ckl.get(ImageViewerActivity.this.ckq.getCurrentImageUrl())).originalUrl);
                if (com.baidu.tbadk.core.util.n.c(String.valueOf(com.baidu.tbadk.core.util.n.tS()) + aw.uU().dv(dB) + "/" + dB, this.mUrl, true)) {
                    new com.baidu.tbadk.core.util.z(ImageViewerActivity.this.getActivity()).dq(this.mUrl);
                    return ImageViewerActivity.this.getPageContext().getString(n.j.save_image_to_album);
                }
                return ImageViewerActivity.this.getPageContext().getString(n.j.save_error);
            }
            switch (com.baidu.tbadk.core.util.n.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.n.tQ();
                case -1:
                default:
                    return ImageViewerActivity.this.getPageContext().getString(n.j.save_error);
                case 0:
                    return ImageViewerActivity.this.getPageContext().getString(n.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.ckm = null;
            ImageViewerActivity.this.ckn.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.ckm = null;
            ImageViewerActivity.this.ckn.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(ImageViewerActivity imageViewerActivity, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ImageViewerActivity.this.amU = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
            ImageViewerActivity.this.amV = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
            ImageViewerActivity.this.cki = intent.getStringArrayListExtra("url");
            ImageViewerActivity.this.wJ = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
            int intExtra = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
            ImageViewerActivity.this.ckq.setUrlData(ImageViewerActivity.this.cki);
            ImageViewerActivity.this.ckq.setAssistUrls(ImageViewerActivity.this.ckl);
            ImageViewerActivity.this.ckq.setNextTitle(ImageViewerActivity.this.amV);
            ImageViewerActivity.this.ckq.setHasNext(ImageViewerActivity.this.amU);
            if (intExtra >= 0) {
                ImageViewerActivity.this.mIndex = intExtra;
                ImageViewerActivity.this.ckq.setCurrentItem(ImageViewerActivity.this.VS(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i, int i2) {
        synchronized (this.cku) {
            if (System.nanoTime() - this.ckt > 300000000 && this.cki != null && i < this.cki.size()) {
                this.cku.put(this.cki.get(i), true);
            }
            this.ckt = System.nanoTime();
            if (this.cki != null && i2 < this.cki.size() && this.cku.get(this.cki.get(i2)) == null) {
                this.cku.put(this.cki.get(i2), false);
            }
        }
        if (this.cku.size() >= 100) {
            aft();
        }
    }

    private void aft() {
        if (this.cku != null) {
            synchronized (this.cku) {
                if (this.cku.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.cku.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.cku.size(), this.ckx, this.ckE + 1, this.ckF + 1);
                    this.cku.clear();
                }
            }
        }
    }

    private String jA(String str) {
        int lastIndexOf;
        int indexOf;
        String aU = ax.aU(str);
        if (aU != null) {
            if (aU.indexOf(".baidu.com") != -1 && (lastIndexOf = aU.lastIndexOf("/")) != -1 && (indexOf = aU.indexOf(".", lastIndexOf)) != -1) {
                return aU.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aU;
    }

    private boolean jD(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String aU = ax.aU(str);
        return !StringUtils.isNull(aU) && aU.contains("?t=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afu() {
        if (this.bJX) {
            if (this.boZ.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.ckq.setSystemUiVisibility(0);
                }
                this.boZ.setVisibility(0);
                this.ckq.zJ();
                this.ckq.aU(false);
                this.bJW = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.bJW = new AlphaAnimation(1.0f, 0.0f);
                this.bJY = true;
                this.ckq.zK();
                this.ckq.aU(true);
            }
            this.bJW.setDuration(300L);
            this.bJW.setFillAfter(false);
            this.bJW.setAnimationListener(new o(this));
            this.bJX = false;
            this.boZ.startAnimation(this.bJW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afv() {
        if (afq()) {
            this.ckC = this.boZ.getVisibility() == 0;
            this.ckB = true;
            if (!this.ckC) {
                afu();
            }
        } else if (this.ckB) {
            this.boZ.setVisibility(this.ckC ? 0 : 8);
            this.ckB = false;
        }
    }
}
