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
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private boolean alO;
    private String alP;
    private boolean alT;
    private AlphaAnimation bGp;
    private boolean bGr;
    private HashMap<String, ImageUrlData> bQV;
    private NavigationBar bli;
    private String cfA;
    private boolean cgA;
    private ArrayList<String> cgf;
    private String cgg;
    private b cgi;
    private View cgj;
    private View cgk;
    private TextView cgl;
    private MultiImageView cgm;
    private a cgn;
    private j cgo;
    private HashMap<String, Boolean> cgq;
    private String cgr;
    private String cgs;
    private String cgt;
    private boolean cgu;
    private String mFrom;
    private String mUserId;
    private int cge = 0;
    private int mIndex = -1;
    private int wH = -1;
    private boolean cgh = true;
    private boolean bGq = true;
    private long cgp = 0;
    private boolean cgv = true;
    private com.baidu.tieba.image.a cgw = null;
    private boolean cgx = false;
    private boolean cgy = false;
    private boolean cgz = true;
    private z.b alV = new n(this);
    private c.b cgB = new p(this);
    private View.OnClickListener cgC = new q(this);
    private View.OnLongClickListener cgD = new r(this);
    private BaseViewPager.a cgE = new s(this);
    private ViewPager.OnPageChangeListener ago = new t(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(n.g.image_activity_2);
        initData(bundle);
        TH();
        MF();
        if (!this.cgu) {
            String jm = jm(this.cgg);
            if (jm == null) {
                this.bli.setVisibility(8);
            }
            if (jp(this.cgg)) {
                this.bli.setVisibility(0);
            }
            this.cgo = new j(this.cgf, this.bQV, this.cgr, this.cgs, this.cfA, jm, this.mUserId, this.mFrom);
            this.cgo.ee(this.cgh);
            this.cgo.ef(this.cgA);
            this.cgo.a(new u(this));
            this.cgo.aea();
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
    public void Yu() {
        byte[] bArr;
        String str;
        try {
            byte[] currentImageData = this.cgm.getCurrentImageData();
            if (currentImageData != null) {
                String currentImageUrl = this.cgm.getCurrentImageUrl();
                if (this.bQV != null) {
                    ImageUrlData imageUrlData = this.bQV.get(currentImageUrl);
                    if (imageUrlData == null || StringUtils.isNull(imageUrlData.originalUrl, true) || imageUrlData.originalProcess != 100) {
                        bArr = currentImageData;
                        str = currentImageUrl;
                    } else {
                        String dy = az.dy(imageUrlData.originalUrl);
                        String dd = com.baidu.tbadk.core.util.n.dd(String.valueOf(com.baidu.tbadk.core.util.n.ui()) + aw.vk().ds(dy) + "/" + dy);
                        if (StringUtils.isNull(dd, true)) {
                            dd = "jpg";
                        }
                        str = String.valueOf(com.baidu.tbadk.core.util.n.ui()) + dy + "." + dd;
                        bArr = null;
                    }
                } else {
                    bArr = currentImageData;
                    str = currentImageUrl;
                }
                this.cgi = new b(str, bArr);
                this.cgi.execute(new String[0]);
                this.cgj.setClickable(false);
                return;
            }
            showToast(getPageContext().getString(n.i.no_data));
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cgm.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        aef();
    }

    private void aef() {
        as.j(this.bli, n.c.alpha80_black);
        getLayoutMode().k(this.cgk);
        getLayoutMode().k(this.cgl);
        getLayoutMode().k(this.cgj);
        this.bli.onBackBtnOnChangeSkin();
    }

    private void MF() {
        if (this.cgu) {
            this.cgn = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.cgn, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cgm.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cgm.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.cgm.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        ah(this.mIndex, this.mIndex);
        aek();
        this.cgm.onDestroy();
        if (this.cgi != null) {
            this.cgi.cancel();
            this.cgi = null;
        }
        if (this.cgu) {
            unregisterReceiver(this.cgn);
        }
        com.baidu.tbadk.download.d.Bp().ed(13);
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

    private void TH() {
        Qh();
        initViewPager();
        aeg();
        ah(this.mIndex, this.mIndex);
    }

    private void Qh() {
        this.bli = (NavigationBar) findViewById(n.f.navigation_bar);
        this.cgl = this.bli.setTitleText("");
        this.cgk = this.bli.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new v(this));
        this.cgj = this.bli.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.image_activity_save_button, (View.OnClickListener) null);
        this.cgj.setOnClickListener(new w(this));
        this.bli.findViewById(n.f.navBottomLine).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeg() {
        String str;
        if (this.cgf != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.cge)) + "/";
            if (this.wH > 0) {
                str = String.valueOf(str2) + this.wH;
            } else if (!this.cgu) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.cgf.size();
            }
            if (aeh()) {
                aej();
            } else {
                jn(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aeh() {
        return this.cgv && this.cgw != null && this.cgw.adJ() && this.mIndex == this.cgm.getItemNum() + (-1);
    }

    private void jn(String str) {
        this.cgl.setText(str);
        if (!this.cgz) {
            this.cgj.setVisibility(8);
            return;
        }
        this.cgj.setClickable(true);
        this.cgj.setVisibility(0);
    }

    private boolean aei() {
        if (this.cgf == null) {
            return false;
        }
        Iterator<String> it = this.cgf.iterator();
        while (it.hasNext()) {
            if (jo(it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean jo(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }

    private void aej() {
        this.cgl.setText(getPageContext().getString(n.i.navigation_title_ad));
        this.cgj.setClickable(false);
        this.cgj.setVisibility(8);
    }

    private void initViewPager() {
        this.cgm = (MultiImageView) findViewById(n.f.viewpager);
        this.cgm.setIsFromCDN(this.alT);
        this.cgm.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.cgm.H(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.cgm.setOnPageChangeListener(this.ago);
        this.cgm.setUrlData(this.cgf);
        this.cgm.setAssistUrls(this.bQV);
        this.cgm.setItemOnclickListener(this.cgC);
        this.cgm.setItemOnLongClickListener(this.cgD);
        this.cgm.setCurrentItem(UM(), false);
        this.cgm.setOnScrollOutListener(this.cgE);
        this.cgm.setHasNext(this.alO);
        this.cgm.setNextTitle(this.alP);
        this.cgw = new com.baidu.tieba.image.a(this.alT, this.cgv, getPageContext(), this.cgr, this.cfA);
        this.cgm.a(this.cgw);
        this.cgm.setOriImgSelectedCallback(this.alV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int UM() {
        if (this.cgf != null && this.cgf.size() > 0) {
            int size = this.cgf.size();
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
            this.cgf = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.wH = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.alO = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.alP = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.cgr = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.cfA = bundle.getString("tid");
            this.cgs = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.cgt = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.alT = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.cgg = bundle.getString(ImageViewerConfig.LAST_ID);
            this.cgh = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.cgv = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.cgA = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof HashMap) {
                this.bQV = (HashMap) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.cgf = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.wH = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.alO = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.alP = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.cgr = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.cfA = intent.getStringExtra("tid");
                this.cgs = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.cgt = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.alT = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.cgg = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.cgh = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.cgv = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.cgA = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof HashMap) {
                    this.bQV = (HashMap) serializableExtra;
                }
            }
        }
        if (getIntent() != null) {
            this.cgu = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.cgq = new HashMap<>();
        if (this.cgf != null) {
            this.wH = this.cgf.size();
        }
        if (this.cgg == null) {
            this.cgg = this.wH > 0 ? this.cgf.get(this.wH - 1) : "";
        }
        this.cgz = aei();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.cgf);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.wH);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.alO);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.alP);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cgr);
        bundle.putString("tid", this.cfA);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.cgs);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.cgt);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.cgh);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.cgv);
        bundle.putString("user_id", this.mUserId);
        bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, this.bQV);
        bundle.putString("from", this.mFrom);
        bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.cgA);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.cgm.setCurrentItem(this.mIndex, false);
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
            if (this.mData == null && ImageViewerActivity.this.bQV != null) {
                String dy = az.dy(((ImageUrlData) ImageViewerActivity.this.bQV.get(ImageViewerActivity.this.cgm.getCurrentImageUrl())).originalUrl);
                if (com.baidu.tbadk.core.util.n.c(String.valueOf(com.baidu.tbadk.core.util.n.ui()) + aw.vk().ds(dy) + "/" + dy, this.mUrl, true)) {
                    new com.baidu.tbadk.core.util.z(ImageViewerActivity.this.getActivity()).dm(this.mUrl);
                    return ImageViewerActivity.this.getPageContext().getString(n.i.save_image_to_album);
                }
                return ImageViewerActivity.this.getPageContext().getString(n.i.save_error);
            }
            switch (com.baidu.tbadk.core.util.n.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.n.ug();
                case -1:
                default:
                    return ImageViewerActivity.this.getPageContext().getString(n.i.save_error);
                case 0:
                    return ImageViewerActivity.this.getPageContext().getString(n.i.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.cgi = null;
            ImageViewerActivity.this.cgj.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.cgi = null;
            ImageViewerActivity.this.cgj.setClickable(true);
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
            ImageViewerActivity.this.alO = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
            ImageViewerActivity.this.alP = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
            ImageViewerActivity.this.cgf = intent.getStringArrayListExtra("url");
            ImageViewerActivity.this.wH = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
            int intExtra = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
            ImageViewerActivity.this.cgm.setUrlData(ImageViewerActivity.this.cgf);
            ImageViewerActivity.this.cgm.setNextTitle(ImageViewerActivity.this.alP);
            ImageViewerActivity.this.cgm.setHasNext(ImageViewerActivity.this.alO);
            if (intExtra >= 0) {
                ImageViewerActivity.this.mIndex = intExtra;
                ImageViewerActivity.this.cgm.setCurrentItem(ImageViewerActivity.this.UM(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, int i2) {
        synchronized (this.cgq) {
            if (System.nanoTime() - this.cgp > 300000000 && this.cgf != null && i < this.cgf.size()) {
                this.cgq.put(this.cgf.get(i), true);
            }
            this.cgp = System.nanoTime();
            if (this.cgf != null && i2 < this.cgf.size() && this.cgq.get(this.cgf.get(i2)) == null) {
                this.cgq.put(this.cgf.get(i2), false);
            }
        }
        if (this.cgq.size() >= 100) {
            aek();
        }
    }

    private void aek() {
        if (this.cgq != null) {
            synchronized (this.cgq) {
                if (this.cgq.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.cgq.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.cgq.size(), this.cgt);
                    this.cgq.clear();
                }
            }
        }
    }

    private String jm(String str) {
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

    private boolean jp(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String aU = ax.aU(str);
        return !StringUtils.isNull(aU) && aU.contains("?t=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ael() {
        if (this.bGq) {
            if (this.bli.getVisibility() == 8) {
                this.bli.setVisibility(0);
                this.cgm.zX();
                this.bGp = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.bGp = new AlphaAnimation(1.0f, 0.0f);
                this.bGr = true;
                this.cgm.zY();
            }
            this.bGp.setDuration(300L);
            this.bGp.setFillAfter(false);
            this.bGp.setAnimationListener(new o(this));
            this.bGq = false;
            this.bli.startAnimation(this.bGp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aem() {
        if (aeh()) {
            this.cgy = this.bli.getVisibility() == 0;
            this.cgx = true;
            if (!this.cgy) {
                ael();
            }
        } else if (this.cgx) {
            this.bli.setVisibility(this.cgy ? 0 : 8);
            this.cgx = false;
        }
    }
}
