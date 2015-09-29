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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
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
    private boolean ajX;
    private String ajY;
    private boolean akc;
    private HashMap<String, ImageUrlData> bBj;
    private String bOH;
    private String bPA;
    private boolean bPB;
    private ArrayList<String> bPm;
    private String bPn;
    private b bPp;
    private View bPq;
    private View bPr;
    private TextView bPs;
    private MultiImageView bPt;
    private a bPu;
    private j bPv;
    private HashMap<String, Boolean> bPx;
    private String bPy;
    private String bPz;
    private NavigationBar bdN;
    private AlphaAnimation bqu;
    private boolean bqw;
    private String mFrom;
    private String mUserId;
    private int bPl = 0;
    private int mIndex = -1;
    private int wB = -1;
    private boolean bPo = true;
    private boolean bqv = true;
    private long bPw = 0;
    private boolean bPC = true;
    private com.baidu.tieba.image.a bPD = null;
    private boolean bPE = false;
    private boolean bPF = false;
    private boolean bPG = true;
    private z.b ake = new n(this);
    private c.b bPH = new p(this);
    private View.OnClickListener bPI = new q(this);
    private View.OnLongClickListener bPJ = new r(this);
    private BaseViewPager.a bPK = new s(this);
    private ViewPager.OnPageChangeListener bPL = new t(this);

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
        if (!this.bPB) {
            String iQ = iQ(this.bPn);
            if (iQ == null) {
                this.bdN.setVisibility(8);
            }
            this.bPv = new j(this.bPm, this.bBj, this.bPy, this.bPz, this.bOH, iQ, this.mUserId, this.mFrom);
            this.bPv.dE(this.bPo);
            this.bPv.a(new u(this));
            this.bPv.aad();
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
            byte[] currentImageData = this.bPt.getCurrentImageData();
            if (currentImageData != null) {
                String currentImageUrl = this.bPt.getCurrentImageUrl();
                if (this.bBj != null) {
                    ImageUrlData imageUrlData = this.bBj.get(currentImageUrl);
                    if (imageUrlData == null || StringUtils.isNull(imageUrlData.originalUrl, true) || imageUrlData.originalProcess != 100) {
                        bArr = currentImageData;
                        str = currentImageUrl;
                    } else {
                        String dm = at.dm(imageUrlData.originalUrl);
                        String cU = com.baidu.tbadk.core.util.n.cU(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + aq.uC().dh(dm) + "/" + dm);
                        if (StringUtils.isNull(cU, true)) {
                            cU = "jpg";
                        }
                        str = String.valueOf(com.baidu.tbadk.core.util.n.tD()) + dm + "." + cU;
                        bArr = null;
                    }
                } else {
                    bArr = currentImageData;
                    str = currentImageUrl;
                }
                this.bPp = new b(str, bArr);
                this.bPp.execute(new String[0]);
                this.bPq.setClickable(false);
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
        this.bPt.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        aai();
    }

    private void aai() {
        am.j(this.bdN, i.c.alpha80_black);
        getLayoutMode().k(this.bPr);
        getLayoutMode().k(this.bPs);
        getLayoutMode().k(this.bPq);
        this.bdN.onBackBtnOnChangeSkin();
    }

    private void KT() {
        if (this.bPB) {
            this.bPu = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.bPu, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bPt.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bPt.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bPt.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        ad(this.mIndex, this.mIndex);
        aan();
        this.bPt.onDestroy();
        if (this.bPp != null) {
            this.bPp.cancel();
            this.bPp = null;
        }
        if (this.bPB) {
            unregisterReceiver(this.bPu);
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
        this.bdN = (NavigationBar) findViewById(i.f.navigation_bar);
        this.bPs = this.bdN.setTitleText("");
        this.bPr = this.bdN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new v(this));
        this.bPq = this.bdN.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.bPq.setOnClickListener(new w(this));
        this.bdN.findViewById(i.f.navBottomLine).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaj() {
        String str;
        if (this.bPm != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bPl)) + "/";
            if (this.wB > 0) {
                str = String.valueOf(str2) + this.wB;
            } else if (!this.bPB) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.bPm.size();
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
        return this.bPC && this.bPD != null && this.bPD.ZM() && this.mIndex == this.bPt.getItemNum() + (-1);
    }

    private void iR(String str) {
        this.bPs.setText(str);
        if (!this.bPG) {
            this.bPq.setVisibility(8);
            return;
        }
        this.bPq.setClickable(true);
        this.bPq.setVisibility(0);
    }

    private boolean aal() {
        if (this.bPm == null) {
            return false;
        }
        Iterator<String> it = this.bPm.iterator();
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
        this.bPs.setText(getPageContext().getString(i.h.navigation_title_ad));
        this.bPq.setClickable(false);
        this.bPq.setVisibility(8);
    }

    private void initViewPager() {
        this.bPt = (MultiImageView) findViewById(i.f.viewpager);
        this.bPt.setIsFromCDN(this.akc);
        this.bPt.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.bPt.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bPt.setOnPageChangeListener(this.bPL);
        this.bPt.setUrlData(this.bPm);
        this.bPt.setAssistUrls(this.bBj);
        this.bPt.setItemOnclickListener(this.bPI);
        this.bPt.setItemOnLongClickListener(this.bPJ);
        this.bPt.setCurrentItem(Ro(), false);
        this.bPt.setOnScrollOutListener(this.bPK);
        this.bPt.setHasNext(this.ajX);
        this.bPt.setNextTitle(this.ajY);
        this.bPD = new com.baidu.tieba.image.a(this.akc, this.bPC, getPageContext(), this.bPy, this.bOH);
        this.bPt.a(this.bPD);
        this.bPt.setOriImgSelectedCallback(this.ake);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ro() {
        if (this.bPm != null && this.bPm.size() > 0) {
            int size = this.bPm.size();
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
            this.bPm = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.wB = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.ajX = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.ajY = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.bPy = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bOH = bundle.getString("tid");
            this.bPz = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bPA = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.akc = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.bPn = bundle.getString(ImageViewerConfig.LAST_ID);
            this.bPo = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.bPC = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof HashMap) {
                this.bBj = (HashMap) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bPm = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.wB = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.ajX = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.ajY = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.bPy = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bOH = intent.getStringExtra("tid");
                this.bPz = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bPA = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.akc = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.bPn = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.bPo = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.bPC = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof HashMap) {
                    this.bBj = (HashMap) serializableExtra;
                }
            }
        }
        if (getIntent() != null) {
            this.bPB = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.bPx = new HashMap<>();
        if (this.bPm != null) {
            this.wB = this.bPm.size();
        }
        if (this.bPn == null) {
            this.bPn = this.wB > 0 ? this.bPm.get(this.wB - 1) : "";
        }
        this.bPG = aal();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.bPm);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.wB);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.ajX);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.ajY);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.bPy);
        bundle.putString("tid", this.bOH);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.bPz);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.bPA);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.bPo);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.bPC);
        bundle.putString("user_id", this.mUserId);
        bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, this.bBj);
        bundle.putString("from", this.mFrom);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bPt.setCurrentItem(this.mIndex, false);
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
            if (this.mData == null && ImageViewerActivity.this.bBj != null) {
                String dm = at.dm(((ImageUrlData) ImageViewerActivity.this.bBj.get(ImageViewerActivity.this.bPt.getCurrentImageUrl())).originalUrl);
                if (com.baidu.tbadk.core.util.n.c(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + aq.uC().dh(dm) + "/" + dm, this.mUrl, true)) {
                    new com.baidu.tbadk.core.util.v(ImageViewerActivity.this.getActivity()).dc(this.mUrl);
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
            ImageViewerActivity.this.bPp = null;
            ImageViewerActivity.this.bPq.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.bPp = null;
            ImageViewerActivity.this.bPq.setClickable(true);
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
            ImageViewerActivity.this.ajX = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
            ImageViewerActivity.this.ajY = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
            ImageViewerActivity.this.bPm = intent.getStringArrayListExtra("url");
            ImageViewerActivity.this.wB = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
            int intExtra = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
            ImageViewerActivity.this.bPt.setUrlData(ImageViewerActivity.this.bPm);
            ImageViewerActivity.this.bPt.setNextTitle(ImageViewerActivity.this.ajY);
            ImageViewerActivity.this.bPt.setHasNext(ImageViewerActivity.this.ajX);
            if (intExtra >= 0) {
                ImageViewerActivity.this.mIndex = intExtra;
                ImageViewerActivity.this.bPt.setCurrentItem(ImageViewerActivity.this.Ro(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(int i, int i2) {
        synchronized (this.bPx) {
            if (System.nanoTime() - this.bPw > 300000000 && this.bPm != null && i < this.bPm.size()) {
                this.bPx.put(this.bPm.get(i), true);
            }
            this.bPw = System.nanoTime();
            if (this.bPm != null && i2 < this.bPm.size() && this.bPx.get(this.bPm.get(i2)) == null) {
                this.bPx.put(this.bPm.get(i2), false);
            }
        }
        if (this.bPx.size() >= 100) {
            aan();
        }
    }

    private void aan() {
        if (this.bPx != null) {
            synchronized (this.bPx) {
                if (this.bPx.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.bPx.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.bPx.size(), this.bPA);
                    this.bPx.clear();
                }
            }
        }
    }

    private String iQ(String str) {
        int lastIndexOf;
        int indexOf;
        String aS = ar.aS(str);
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
        if (this.bqv) {
            if (this.bdN.getVisibility() == 8) {
                this.bdN.setVisibility(0);
                this.bPt.yZ();
                this.bqu = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.bqu = new AlphaAnimation(1.0f, 0.0f);
                this.bqw = true;
                this.bPt.za();
            }
            this.bqu.setDuration(300L);
            this.bqu.setFillAfter(false);
            this.bqu.setAnimationListener(new o(this));
            this.bqv = false;
            this.bdN.startAnimation(this.bqu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aap() {
        if (aak()) {
            this.bPF = this.bdN.getVisibility() == 0;
            this.bPE = true;
            if (!this.bPF) {
                aao();
            }
        } else if (this.bPE) {
            this.bdN.setVisibility(this.bPF ? 0 : 8);
            this.bPE = false;
        }
    }
}
