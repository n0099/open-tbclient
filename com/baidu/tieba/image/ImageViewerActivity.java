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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.z;
import com.baidu.tieba.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private boolean ajY;
    private String ajZ;
    private boolean akd;
    private HashMap<String, ImageUrlData> bBu;
    private String bOS;
    private b bPA;
    private View bPB;
    private View bPC;
    private TextView bPD;
    private MultiImageView bPE;
    private a bPF;
    private j bPG;
    private HashMap<String, Boolean> bPI;
    private String bPJ;
    private String bPK;
    private String bPL;
    private boolean bPM;
    private ArrayList<String> bPx;
    private String bPy;
    private NavigationBar bdY;
    private AlphaAnimation bqF;
    private boolean bqH;
    private String mFrom;
    private String mUserId;
    private int bPw = 0;
    private int mIndex = -1;
    private int wB = -1;
    private boolean bPz = true;
    private boolean bqG = true;
    private long bPH = 0;
    private boolean bPN = true;
    private com.baidu.tieba.image.a bPO = null;
    private boolean bPP = false;
    private boolean bPQ = false;
    private boolean bPR = true;
    private z.b akf = new n(this);
    private c.b bPS = new p(this);
    private View.OnClickListener bPT = new q(this);
    private View.OnLongClickListener bPU = new r(this);
    private BaseViewPager.a bPV = new s(this);
    private ViewPager.OnPageChangeListener bPW = new t(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(i.g.image_activity_2);
        initData(bundle);
        QJ();
        KT();
        if (!this.bPM) {
            String iQ = iQ(this.bPy);
            if (iQ == null) {
                this.bdY.setVisibility(8);
            }
            this.bPG = new j(this.bPx, this.bBu, this.bPJ, this.bPK, this.bOS, iQ, this.mUserId, this.mFrom);
            this.bPG.dE(this.bPz);
            this.bPG.a(new u(this));
            this.bPG.aad();
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
    public void UX() {
        byte[] bArr;
        String str;
        try {
            byte[] currentImageData = this.bPE.getCurrentImageData();
            if (currentImageData != null) {
                String currentImageUrl = this.bPE.getCurrentImageUrl();
                if (this.bBu != null) {
                    ImageUrlData imageUrlData = this.bBu.get(currentImageUrl);
                    if (imageUrlData == null || StringUtils.isNull(imageUrlData.originalUrl, true) || imageUrlData.originalProcess != 100) {
                        bArr = currentImageData;
                        str = currentImageUrl;
                    } else {
                        String dn = au.dn(imageUrlData.originalUrl);
                        String cV = com.baidu.tbadk.core.util.n.cV(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + ar.uD().di(dn) + "/" + dn);
                        if (StringUtils.isNull(cV, true)) {
                            cV = "jpg";
                        }
                        str = String.valueOf(com.baidu.tbadk.core.util.n.tD()) + dn + "." + cV;
                        bArr = null;
                    }
                } else {
                    bArr = currentImageData;
                    str = currentImageUrl;
                }
                this.bPA = new b(str, bArr);
                this.bPA.execute(new String[0]);
                this.bPB.setClickable(false);
                return;
            }
            showToast(getPageContext().getString(i.h.no_data));
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bPE.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        aai();
    }

    private void aai() {
        an.j(this.bdY, i.c.alpha80_black);
        getLayoutMode().k(this.bPC);
        getLayoutMode().k(this.bPD);
        getLayoutMode().k(this.bPB);
        this.bdY.onBackBtnOnChangeSkin();
    }

    private void KT() {
        if (this.bPM) {
            this.bPF = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.bPF, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bPE.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bPE.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bPE.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        ad(this.mIndex, this.mIndex);
        aan();
        this.bPE.onDestroy();
        if (this.bPA != null) {
            this.bPA.cancel();
            this.bPA = null;
        }
        if (this.bPM) {
            unregisterReceiver(this.bPF);
        }
        com.baidu.tbadk.download.d.As().dP(13);
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

    private void QJ() {
        Ok();
        initViewPager();
        aaj();
        ad(this.mIndex, this.mIndex);
    }

    private void Ok() {
        this.bdY = (NavigationBar) findViewById(i.f.navigation_bar);
        this.bPD = this.bdY.setTitleText("");
        this.bPC = this.bdY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new v(this));
        this.bPB = this.bdY.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.bPB.setOnClickListener(new w(this));
        this.bdY.findViewById(i.f.navBottomLine).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaj() {
        String str;
        if (this.bPx != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bPw)) + "/";
            if (this.wB > 0) {
                str = String.valueOf(str2) + this.wB;
            } else if (!this.bPM) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.bPx.size();
            }
            if (aak()) {
                aam();
            } else {
                iR(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aak() {
        return this.bPN && this.bPO != null && this.bPO.ZM() && this.mIndex == this.bPE.getItemNum() + (-1);
    }

    private void iR(String str) {
        this.bPD.setText(str);
        if (!this.bPR) {
            this.bPB.setVisibility(8);
            return;
        }
        this.bPB.setClickable(true);
        this.bPB.setVisibility(0);
    }

    private boolean aal() {
        if (this.bPx == null) {
            return false;
        }
        Iterator<String> it = this.bPx.iterator();
        while (it.hasNext()) {
            if (iS(it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean iS(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }

    private void aam() {
        this.bPD.setText(getPageContext().getString(i.h.navigation_title_ad));
        this.bPB.setClickable(false);
        this.bPB.setVisibility(8);
    }

    private void initViewPager() {
        this.bPE = (MultiImageView) findViewById(i.f.viewpager);
        this.bPE.setIsFromCDN(this.akd);
        this.bPE.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.bPE.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bPE.setOnPageChangeListener(this.bPW);
        this.bPE.setUrlData(this.bPx);
        this.bPE.setAssistUrls(this.bBu);
        this.bPE.setItemOnclickListener(this.bPT);
        this.bPE.setItemOnLongClickListener(this.bPU);
        this.bPE.setCurrentItem(Ro(), false);
        this.bPE.setOnScrollOutListener(this.bPV);
        this.bPE.setHasNext(this.ajY);
        this.bPE.setNextTitle(this.ajZ);
        this.bPO = new com.baidu.tieba.image.a(this.akd, this.bPN, getPageContext(), this.bPJ, this.bOS);
        this.bPE.a(this.bPO);
        this.bPE.setOriImgSelectedCallback(this.akf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ro() {
        if (this.bPx != null && this.bPx.size() > 0) {
            int size = this.bPx.size();
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
            this.bPx = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.wB = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.ajY = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.ajZ = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.bPJ = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bOS = bundle.getString("tid");
            this.bPK = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bPL = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.akd = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.bPy = bundle.getString(ImageViewerConfig.LAST_ID);
            this.bPz = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.bPN = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof HashMap) {
                this.bBu = (HashMap) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bPx = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.wB = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.ajY = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.ajZ = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.bPJ = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bOS = intent.getStringExtra("tid");
                this.bPK = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bPL = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.akd = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.bPy = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.bPz = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.bPN = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof HashMap) {
                    this.bBu = (HashMap) serializableExtra;
                }
            }
        }
        if (getIntent() != null) {
            this.bPM = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.bPI = new HashMap<>();
        if (this.bPx != null) {
            this.wB = this.bPx.size();
        }
        if (this.bPy == null) {
            this.bPy = this.wB > 0 ? this.bPx.get(this.wB - 1) : "";
        }
        this.bPR = aal();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.bPx);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.wB);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.ajY);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.ajZ);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.bPJ);
        bundle.putString("tid", this.bOS);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.bPK);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.bPL);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.bPz);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.bPN);
        bundle.putString("user_id", this.mUserId);
        bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, this.bBu);
        bundle.putString("from", this.mFrom);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bPE.setCurrentItem(this.mIndex, false);
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
            if (this.mData == null && ImageViewerActivity.this.bBu != null) {
                String dn = au.dn(((ImageUrlData) ImageViewerActivity.this.bBu.get(ImageViewerActivity.this.bPE.getCurrentImageUrl())).originalUrl);
                if (com.baidu.tbadk.core.util.n.c(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + ar.uD().di(dn) + "/" + dn, this.mUrl, true)) {
                    new com.baidu.tbadk.core.util.v(ImageViewerActivity.this.getActivity()).dd(this.mUrl);
                    return ImageViewerActivity.this.getPageContext().getString(i.h.save_image_to_album);
                }
                return ImageViewerActivity.this.getPageContext().getString(i.h.save_error);
            }
            switch (com.baidu.tbadk.core.util.n.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.n.tB();
                case -1:
                default:
                    return ImageViewerActivity.this.getPageContext().getString(i.h.save_error);
                case 0:
                    return ImageViewerActivity.this.getPageContext().getString(i.h.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.bPA = null;
            ImageViewerActivity.this.bPB.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.bPA = null;
            ImageViewerActivity.this.bPB.setClickable(true);
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
            ImageViewerActivity.this.ajY = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
            ImageViewerActivity.this.ajZ = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
            ImageViewerActivity.this.bPx = intent.getStringArrayListExtra("url");
            ImageViewerActivity.this.wB = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
            int intExtra = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
            ImageViewerActivity.this.bPE.setUrlData(ImageViewerActivity.this.bPx);
            ImageViewerActivity.this.bPE.setNextTitle(ImageViewerActivity.this.ajZ);
            ImageViewerActivity.this.bPE.setHasNext(ImageViewerActivity.this.ajY);
            if (intExtra >= 0) {
                ImageViewerActivity.this.mIndex = intExtra;
                ImageViewerActivity.this.bPE.setCurrentItem(ImageViewerActivity.this.Ro(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(int i, int i2) {
        synchronized (this.bPI) {
            if (System.nanoTime() - this.bPH > 300000000 && this.bPx != null && i < this.bPx.size()) {
                this.bPI.put(this.bPx.get(i), true);
            }
            this.bPH = System.nanoTime();
            if (this.bPx != null && i2 < this.bPx.size() && this.bPI.get(this.bPx.get(i2)) == null) {
                this.bPI.put(this.bPx.get(i2), false);
            }
        }
        if (this.bPI.size() >= 100) {
            aan();
        }
    }

    private void aan() {
        if (this.bPI != null) {
            synchronized (this.bPI) {
                if (this.bPI.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.bPI.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.bPI.size(), this.bPL);
                    this.bPI.clear();
                }
            }
        }
    }

    private String iQ(String str) {
        int lastIndexOf;
        int indexOf;
        String aS = as.aS(str);
        if (aS != null) {
            if (aS.indexOf(".baidu.com") != -1 && (lastIndexOf = aS.lastIndexOf("/")) != -1 && (indexOf = aS.indexOf(".", lastIndexOf)) != -1) {
                return aS.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aao() {
        if (this.bqG) {
            if (this.bdY.getVisibility() == 8) {
                this.bdY.setVisibility(0);
                this.bPE.yZ();
                this.bqF = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.bqF = new AlphaAnimation(1.0f, 0.0f);
                this.bqH = true;
                this.bPE.za();
            }
            this.bqF.setDuration(300L);
            this.bqF.setFillAfter(false);
            this.bqF.setAnimationListener(new o(this));
            this.bqG = false;
            this.bdY.startAnimation(this.bqF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aap() {
        if (aak()) {
            this.bPQ = this.bdY.getVisibility() == 0;
            this.bPP = true;
            if (!this.bPQ) {
                aao();
            }
        } else if (this.bPP) {
            this.bdY.setVisibility(this.bPQ ? 0 : 8);
            this.bPP = false;
        }
    }
}
