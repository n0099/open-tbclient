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
    private boolean akd;
    private String ake;
    private boolean aki;
    private HashMap<String, ImageUrlData> bBP;
    private ArrayList<String> bPS;
    private String bPT;
    private b bPV;
    private View bPW;
    private View bPX;
    private TextView bPY;
    private MultiImageView bPZ;
    private String bPn;
    private a bQa;
    private j bQb;
    private HashMap<String, Boolean> bQd;
    private String bQe;
    private String bQf;
    private String bQg;
    private boolean bQh;
    private NavigationBar beE;
    private AlphaAnimation brj;
    private boolean brl;
    private String mFrom;
    private String mUserId;
    private int bPR = 0;
    private int mIndex = -1;
    private int wB = -1;
    private boolean bPU = true;
    private boolean brk = true;
    private long bQc = 0;
    private boolean bQi = true;
    private com.baidu.tieba.image.a bQj = null;
    private boolean bQk = false;
    private boolean bQl = false;
    private boolean bQm = true;
    private z.b akk = new n(this);
    private c.b bQn = new p(this);
    private View.OnClickListener bQo = new q(this);
    private View.OnLongClickListener bQp = new r(this);
    private BaseViewPager.a bQq = new s(this);
    private ViewPager.OnPageChangeListener bQr = new t(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(i.g.image_activity_2);
        initData(bundle);
        Rb();
        Lf();
        if (!this.bQh) {
            String iS = iS(this.bPT);
            if (iS == null) {
                this.beE.setVisibility(8);
            }
            this.bQb = new j(this.bPS, this.bBP, this.bQe, this.bQf, this.bPn, iS, this.mUserId, this.mFrom);
            this.bQb.dG(this.bPU);
            this.bQb.a(new u(this));
            this.bQb.aau();
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
    public void Vo() {
        byte[] bArr;
        String str;
        try {
            byte[] currentImageData = this.bPZ.getCurrentImageData();
            if (currentImageData != null) {
                String currentImageUrl = this.bPZ.getCurrentImageUrl();
                if (this.bBP != null) {
                    ImageUrlData imageUrlData = this.bBP.get(currentImageUrl);
                    if (imageUrlData == null || StringUtils.isNull(imageUrlData.originalUrl, true) || imageUrlData.originalProcess != 100) {
                        bArr = currentImageData;
                        str = currentImageUrl;
                    } else {
                        String dn = au.dn(imageUrlData.originalUrl);
                        String cV = com.baidu.tbadk.core.util.n.cV(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + ar.uE().di(dn) + "/" + dn);
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
                this.bPV = new b(str, bArr);
                this.bPV.execute(new String[0]);
                this.bPW.setClickable(false);
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
        this.bPZ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        aaz();
    }

    private void aaz() {
        an.j(this.beE, i.c.alpha80_black);
        getLayoutMode().k(this.bPX);
        getLayoutMode().k(this.bPY);
        getLayoutMode().k(this.bPW);
        this.beE.onBackBtnOnChangeSkin();
    }

    private void Lf() {
        if (this.bQh) {
            this.bQa = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.bQa, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bPZ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bPZ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bPZ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        af(this.mIndex, this.mIndex);
        aaE();
        this.bPZ.onDestroy();
        if (this.bPV != null) {
            this.bPV.cancel();
            this.bPV = null;
        }
        if (this.bQh) {
            unregisterReceiver(this.bQa);
        }
        com.baidu.tbadk.download.d.Au().dP(13);
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

    private void Rb() {
        OC();
        initViewPager();
        aaA();
        af(this.mIndex, this.mIndex);
    }

    private void OC() {
        this.beE = (NavigationBar) findViewById(i.f.navigation_bar);
        this.bPY = this.beE.setTitleText("");
        this.bPX = this.beE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new v(this));
        this.bPW = this.beE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.bPW.setOnClickListener(new w(this));
        this.beE.findViewById(i.f.navBottomLine).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        String str;
        if (this.bPS != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bPR)) + "/";
            if (this.wB > 0) {
                str = String.valueOf(str2) + this.wB;
            } else if (!this.bQh) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.bPS.size();
            }
            if (aaB()) {
                aaD();
            } else {
                iT(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaB() {
        return this.bQi && this.bQj != null && this.bQj.aad() && this.mIndex == this.bPZ.getItemNum() + (-1);
    }

    private void iT(String str) {
        this.bPY.setText(str);
        if (!this.bQm) {
            this.bPW.setVisibility(8);
            return;
        }
        this.bPW.setClickable(true);
        this.bPW.setVisibility(0);
    }

    private boolean aaC() {
        if (this.bPS == null) {
            return false;
        }
        Iterator<String> it = this.bPS.iterator();
        while (it.hasNext()) {
            if (iU(it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean iU(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }

    private void aaD() {
        this.bPY.setText(getPageContext().getString(i.h.navigation_title_ad));
        this.bPW.setClickable(false);
        this.bPW.setVisibility(8);
    }

    private void initViewPager() {
        this.bPZ = (MultiImageView) findViewById(i.f.viewpager);
        this.bPZ.setIsFromCDN(this.aki);
        this.bPZ.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.bPZ.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bPZ.setOnPageChangeListener(this.bQr);
        this.bPZ.setUrlData(this.bPS);
        this.bPZ.setAssistUrls(this.bBP);
        this.bPZ.setItemOnclickListener(this.bQo);
        this.bPZ.setItemOnLongClickListener(this.bQp);
        this.bPZ.setCurrentItem(RG(), false);
        this.bPZ.setOnScrollOutListener(this.bQq);
        this.bPZ.setHasNext(this.akd);
        this.bPZ.setNextTitle(this.ake);
        this.bQj = new com.baidu.tieba.image.a(this.aki, this.bQi, getPageContext(), this.bQe, this.bPn);
        this.bPZ.a(this.bQj);
        this.bPZ.setOriImgSelectedCallback(this.akk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int RG() {
        if (this.bPS != null && this.bPS.size() > 0) {
            int size = this.bPS.size();
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
            this.bPS = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.wB = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.akd = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.ake = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.bQe = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bPn = bundle.getString("tid");
            this.bQf = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bQg = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.aki = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.bPT = bundle.getString(ImageViewerConfig.LAST_ID);
            this.bPU = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.bQi = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof HashMap) {
                this.bBP = (HashMap) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bPS = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.wB = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.akd = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.ake = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.bQe = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bPn = intent.getStringExtra("tid");
                this.bQf = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bQg = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.aki = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.bPT = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.bPU = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.bQi = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof HashMap) {
                    this.bBP = (HashMap) serializableExtra;
                }
            }
        }
        if (getIntent() != null) {
            this.bQh = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.bQd = new HashMap<>();
        if (this.bPS != null) {
            this.wB = this.bPS.size();
        }
        if (this.bPT == null) {
            this.bPT = this.wB > 0 ? this.bPS.get(this.wB - 1) : "";
        }
        this.bQm = aaC();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.bPS);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.wB);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.akd);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.ake);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.bQe);
        bundle.putString("tid", this.bPn);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.bQf);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.bQg);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.bPU);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.bQi);
        bundle.putString("user_id", this.mUserId);
        bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, this.bBP);
        bundle.putString("from", this.mFrom);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bPZ.setCurrentItem(this.mIndex, false);
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
            if (this.mData == null && ImageViewerActivity.this.bBP != null) {
                String dn = au.dn(((ImageUrlData) ImageViewerActivity.this.bBP.get(ImageViewerActivity.this.bPZ.getCurrentImageUrl())).originalUrl);
                if (com.baidu.tbadk.core.util.n.c(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + ar.uE().di(dn) + "/" + dn, this.mUrl, true)) {
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
            ImageViewerActivity.this.bPV = null;
            ImageViewerActivity.this.bPW.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.bPV = null;
            ImageViewerActivity.this.bPW.setClickable(true);
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
            ImageViewerActivity.this.akd = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
            ImageViewerActivity.this.ake = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
            ImageViewerActivity.this.bPS = intent.getStringArrayListExtra("url");
            ImageViewerActivity.this.wB = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
            int intExtra = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
            ImageViewerActivity.this.bPZ.setUrlData(ImageViewerActivity.this.bPS);
            ImageViewerActivity.this.bPZ.setNextTitle(ImageViewerActivity.this.ake);
            ImageViewerActivity.this.bPZ.setHasNext(ImageViewerActivity.this.akd);
            if (intExtra >= 0) {
                ImageViewerActivity.this.mIndex = intExtra;
                ImageViewerActivity.this.bPZ.setCurrentItem(ImageViewerActivity.this.RG(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(int i, int i2) {
        synchronized (this.bQd) {
            if (System.nanoTime() - this.bQc > 300000000 && this.bPS != null && i < this.bPS.size()) {
                this.bQd.put(this.bPS.get(i), true);
            }
            this.bQc = System.nanoTime();
            if (this.bPS != null && i2 < this.bPS.size() && this.bQd.get(this.bPS.get(i2)) == null) {
                this.bQd.put(this.bPS.get(i2), false);
            }
        }
        if (this.bQd.size() >= 100) {
            aaE();
        }
    }

    private void aaE() {
        if (this.bQd != null) {
            synchronized (this.bQd) {
                if (this.bQd.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.bQd.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.bQd.size(), this.bQg);
                    this.bQd.clear();
                }
            }
        }
    }

    private String iS(String str) {
        int lastIndexOf;
        int indexOf;
        String aQ = as.aQ(str);
        if (aQ != null) {
            if (aQ.indexOf(".baidu.com") != -1 && (lastIndexOf = aQ.lastIndexOf("/")) != -1 && (indexOf = aQ.indexOf(".", lastIndexOf)) != -1) {
                return aQ.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaF() {
        if (this.brk) {
            if (this.beE.getVisibility() == 8) {
                this.beE.setVisibility(0);
                this.bPZ.zb();
                this.brj = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.brj = new AlphaAnimation(1.0f, 0.0f);
                this.brl = true;
                this.bPZ.zc();
            }
            this.brj.setDuration(300L);
            this.brj.setFillAfter(false);
            this.brj.setAnimationListener(new o(this));
            this.brk = false;
            this.beE.startAnimation(this.brj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaG() {
        if (aaB()) {
            this.bQl = this.beE.getVisibility() == 0;
            this.bQk = true;
            if (!this.bQl) {
                aaF();
            }
        } else if (this.bQk) {
            this.beE.setVisibility(this.bQl ? 0 : 8);
            this.bQk = false;
        }
    }
}
