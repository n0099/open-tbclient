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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.u;
import com.baidu.tieba.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private String aer;
    private boolean anN;
    private String anO;
    private boolean anS;
    private AlphaAnimation bNF;
    private boolean bNH;
    private NavigationBar bse;
    private ArrayList<String> coJ;
    private String coK;
    private Map<String, ImageUrlData> coM;
    private b coN;
    private View coO;
    private View coP;
    private TextView coQ;
    private MultiImageView coR;
    private a coS;
    private j coT;
    private HashMap<String, Boolean> coV;
    private String coW;
    private String coX;
    private String coY;
    private boolean coZ;
    private String coe;
    private int cpf;
    private int cpg;
    private boolean mIsSeeHost;
    private int mThreadType;
    private String mUserId;
    private int coH = 0;
    private int mIndex = -1;
    private int wS = -1;
    private int coI = -1;
    private boolean coL = true;
    private boolean bNG = true;
    private long coU = 0;
    private boolean cpa = true;
    private com.baidu.tieba.image.a cpb = null;
    private boolean cpc = false;
    private boolean cpd = false;
    private boolean cpe = true;
    private u.b anU = new m(this);
    private c.b cph = new o(this);
    private View.OnClickListener cpi = new p(this);
    private View.OnLongClickListener cpj = new q(this);
    private BaseViewPager.a cpk = new r(this);
    private ViewPager.OnPageChangeListener aif = new s(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(t.h.image_activity_2);
        initData(bundle);
        Wj();
        OU();
        if (!this.coZ) {
            String jF = jF(this.coK);
            if (jF == null) {
                this.bse.setVisibility(8);
            }
            if (jI(this.coK)) {
                this.bse.setVisibility(0);
            }
            this.coT = new j(this.coJ, this.coM, this.coW, this.coX, this.coe, jF, this.mUserId, this.aer, this.mThreadType);
            this.coT.el(this.coL);
            this.coT.em(this.mIsSeeHost);
            this.coT.a(new t(this));
            this.coT.aiq();
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
    public void acm() {
        byte[] bArr;
        String str;
        try {
            byte[] currentImageData = this.coR.getCurrentImageData();
            if (currentImageData != null) {
                String currentImageUrl = this.coR.getCurrentImageUrl();
                if (this.coM != null) {
                    ImageUrlData imageUrlData = this.coM.get(currentImageUrl);
                    if (imageUrlData == null || StringUtils.isNull(imageUrlData.originalUrl, true) || imageUrlData.originalProcess != 100) {
                        bArr = currentImageData;
                        str = currentImageUrl;
                    } else {
                        String dy = ay.dy(imageUrlData.originalUrl);
                        String dd = com.baidu.tbadk.core.util.m.dd(String.valueOf(com.baidu.tbadk.core.util.m.uW()) + av.vZ().ds(dy) + "/" + dy);
                        if (StringUtils.isNull(dd, true)) {
                            dd = "jpg";
                        }
                        str = String.valueOf(com.baidu.tbadk.core.util.m.uW()) + dy + "." + dd;
                        bArr = null;
                    }
                } else {
                    bArr = currentImageData;
                    str = currentImageUrl;
                }
                this.coN = new b(str, bArr);
                this.coN.execute(new String[0]);
                this.coO.setClickable(false);
                return;
            }
            showToast(getPageContext().getString(t.j.no_data));
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.coR.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.coR.db(i);
        aiy();
        super.onChangeSkinType(i);
    }

    private void aiy() {
        ar.l(this.bse, t.d.alpha80_black);
        getLayoutMode().x(this.coP);
        getLayoutMode().x(this.coQ);
        getLayoutMode().x(this.coO);
        ar.a(this.bse.getBackImageView(), t.f.icon_return_bg_s, t.f.icon_return_bg, 0);
    }

    private void OU() {
        if (this.coZ) {
            this.coS = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.coS, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.coR.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.coR.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.coR.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        at(this.mIndex, this.mIndex);
        aiE();
        this.coR.onDestroy();
        if (this.coN != null) {
            this.coN.cancel();
            this.coN = null;
        }
        if (this.coZ) {
            unregisterReceiver(this.coS);
        }
        com.baidu.tbadk.download.d.Cu().es(13);
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

    private void Wj() {
        SG();
        initViewPager();
        aiA();
        at(this.mIndex, this.mIndex);
    }

    private void SG() {
        this.bse = (NavigationBar) findViewById(t.g.navigation_bar);
        this.coQ = this.bse.setTitleText("");
        this.coP = this.bse.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new u(this));
        this.coO = this.bse.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.image_activity_save_button, (View.OnClickListener) null);
        this.coO.setOnClickListener(new v(this));
        ar.a(this.bse.getBackImageView(), t.f.icon_return_bg_s, t.f.icon_return_bg, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aiz() {
        int i;
        String str;
        long j;
        if (this.coJ == null) {
            i = 0;
            str = null;
        } else {
            i = this.coJ.size();
            str = this.coJ.get(i - 1);
        }
        ImageUrlData imageUrlData = this.coM != null ? this.coM.get(str) : null;
        if (imageUrlData == null) {
            j = 0;
        } else if (this.coL) {
            j = (imageUrlData.overAllIndex - i) + this.mIndex + 1;
        } else {
            j = ((this.wS - imageUrlData.overAllIndex) - i) + this.mIndex + 2;
        }
        if (j <= 0) {
            return this.mIndex + 1 + this.coH;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiA() {
        String str;
        if (this.coJ != null) {
            String str2 = String.valueOf(String.valueOf("") + aiz()) + "/";
            if (this.wS > 0) {
                if (this.coI > 0) {
                    str = String.valueOf(str2) + this.coI;
                } else {
                    str = String.valueOf(str2) + this.wS;
                }
            } else if (!this.coZ) {
                str = String.valueOf(str2) + "...";
            } else if (this.coI > 0) {
                str = String.valueOf(str2) + this.coI;
            } else {
                str = String.valueOf(str2) + this.coJ.size();
            }
            if (aiB()) {
                aiD();
            } else {
                jG(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiB() {
        return this.cpa && this.cpb != null && this.cpb.aib() && this.mIndex == this.coR.getItemNum() + (-1);
    }

    private void jG(String str) {
        this.coQ.setText(str);
        if (!this.cpe) {
            this.coO.setVisibility(8);
            return;
        }
        this.coO.setClickable(true);
        this.coO.setVisibility(0);
    }

    private boolean aiC() {
        if (this.coJ == null) {
            return false;
        }
        Iterator<String> it = this.coJ.iterator();
        while (it.hasNext()) {
            if (jH(it.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean jH(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) ? false : true;
    }

    private void aiD() {
        this.coQ.setText(getPageContext().getString(t.j.navigation_title_ad));
        this.coO.setClickable(false);
        this.coO.setVisibility(8);
    }

    private void initViewPager() {
        this.coR = (MultiImageView) findViewById(t.g.viewpager);
        this.coR.setIsFromCDN(this.anS);
        this.coR.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.coR.D(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.coR.setOnPageChangeListener(this.aif);
        this.coR.setUrlData(this.coJ);
        this.coR.setAssistUrls(this.coM);
        this.coR.setItemOnclickListener(this.cpi);
        this.coR.setItemOnLongClickListener(this.cpj);
        this.coR.setCurrentItem(Ym(), false);
        this.coR.setOnScrollOutListener(this.cpk);
        this.coR.setHasNext(this.anN);
        this.coR.setNextTitle(this.anO);
        this.cpb = new com.baidu.tieba.image.a(this.anS, this.cpa, getPageContext(), this.coW, this.coe);
        this.coR.a(this.cpb);
        this.coR.setOriImgSelectedCallback(this.anU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ym() {
        if (this.coJ != null && this.coJ.size() > 0) {
            int size = this.coJ.size();
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
            this.coJ = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.wS = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.coI = bundle.getInt(ImageViewerConfig.FIXED_COUNT_IN_TITLE, -1);
            this.anN = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.anO = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.coW = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.coe = bundle.getString("tid");
            this.coX = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.coY = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.anS = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.coK = bundle.getString(ImageViewerConfig.LAST_ID);
            this.coL = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.cpa = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.aer = bundle.getString("from");
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof Map) {
                this.coM = (Map) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.coJ = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.wS = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.coI = intent.getIntExtra(ImageViewerConfig.FIXED_COUNT_IN_TITLE, -1);
                this.anN = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.anO = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.coW = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.coe = intent.getStringExtra("tid");
                this.coX = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.coY = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.anS = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.coK = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.coL = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.cpa = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.aer = intent.getStringExtra("from");
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.coM = (Map) serializableExtra;
                }
                this.cpg = this.mIndex;
                this.cpf = this.mIndex;
            }
        }
        if (getIntent() != null) {
            this.coZ = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.coV = new HashMap<>();
        if (this.coJ != null) {
            this.wS = this.coJ.size();
        }
        if (StringUtils.isNull(this.coK, true)) {
            this.coK = this.wS > 0 ? this.coJ.get(this.wS - 1) : "";
        }
        this.cpe = aiC();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.coJ);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.wS);
        bundle.putInt(ImageViewerConfig.FIXED_COUNT_IN_TITLE, this.coI);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.anN);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.anO);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.coW);
        bundle.putString("tid", this.coe);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.coX);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.coY);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.coL);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.cpa);
        bundle.putString("user_id", this.mUserId);
        if (this.coM instanceof HashMap) {
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, (HashMap) this.coM);
        } else if (this.coM instanceof ConcurrentHashMap) {
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, (ConcurrentHashMap) this.coM);
        }
        bundle.putString("from", this.aer);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.mIsSeeHost);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.coR.setCurrentItem(this.mIndex, false);
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
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            if (this.mData == null && ImageViewerActivity.this.coM != null) {
                String dy = ay.dy(((ImageUrlData) ImageViewerActivity.this.coM.get(ImageViewerActivity.this.coR.getCurrentImageUrl())).originalUrl);
                if (com.baidu.tbadk.core.util.m.c(String.valueOf(com.baidu.tbadk.core.util.m.uW()) + av.vZ().ds(dy) + "/" + dy, this.mUrl, true)) {
                    new y(ImageViewerActivity.this.getActivity()).dm(this.mUrl);
                    return ImageViewerActivity.this.getPageContext().getString(t.j.save_image_to_album);
                }
                return ImageViewerActivity.this.getPageContext().getString(t.j.save_error);
            }
            switch (com.baidu.tbadk.core.util.m.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.m.uU();
                case -1:
                default:
                    return ImageViewerActivity.this.getPageContext().getString(t.j.save_error);
                case 0:
                    return ImageViewerActivity.this.getPageContext().getString(t.j.save_image_to_album);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ek */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.coN = null;
            ImageViewerActivity.this.coO.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.coN = null;
            ImageViewerActivity.this.coO.setClickable(true);
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
            ImageViewerActivity.this.anN = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
            ImageViewerActivity.this.anO = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
            ImageViewerActivity.this.coJ = intent.getStringArrayListExtra("url");
            ImageViewerActivity.this.wS = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
            int intExtra = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
            ImageViewerActivity.this.coR.setUrlData(ImageViewerActivity.this.coJ);
            ImageViewerActivity.this.coR.setAssistUrls(ImageViewerActivity.this.coM);
            ImageViewerActivity.this.coR.setNextTitle(ImageViewerActivity.this.anO);
            ImageViewerActivity.this.coR.setHasNext(ImageViewerActivity.this.anN);
            if (intExtra >= 0) {
                ImageViewerActivity.this.mIndex = intExtra;
                ImageViewerActivity.this.coR.setCurrentItem(ImageViewerActivity.this.Ym(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i, int i2) {
        synchronized (this.coV) {
            if (System.nanoTime() - this.coU > 300000000 && this.coJ != null && i < this.coJ.size()) {
                this.coV.put(this.coJ.get(i), true);
            }
            this.coU = System.nanoTime();
            if (this.coJ != null && i2 < this.coJ.size() && this.coV.get(this.coJ.get(i2)) == null) {
                this.coV.put(this.coJ.get(i2), false);
            }
        }
        if (this.coV.size() >= 100) {
            aiE();
        }
    }

    private void aiE() {
        if (this.coV != null) {
            synchronized (this.coV) {
                if (this.coV.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.coV.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.coV.size(), this.coY, this.cpf + 1, this.cpg + 1);
                    this.coV.clear();
                }
            }
        }
    }

    private String jF(String str) {
        int lastIndexOf;
        int indexOf;
        String aT = aw.aT(str);
        if (aT != null) {
            if (aT.indexOf(".baidu.com") != -1 && (lastIndexOf = aT.lastIndexOf("/")) != -1 && (indexOf = aT.indexOf(".", lastIndexOf)) != -1) {
                return aT.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aT;
    }

    private boolean jI(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String aT = aw.aT(str);
        return !StringUtils.isNull(aT) && aT.contains("?t=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiF() {
        if (this.bNG) {
            if (this.bse.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.coR.setSystemUiVisibility(0);
                }
                this.bse.setVisibility(0);
                this.coR.AZ();
                this.coR.aW(false);
                this.bNF = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.bNF = new AlphaAnimation(1.0f, 0.0f);
                this.bNH = true;
                this.coR.Ba();
                this.coR.aW(true);
            }
            this.bNF.setDuration(300L);
            this.bNF.setFillAfter(false);
            this.bNF.setAnimationListener(new n(this));
            this.bNG = false;
            this.bse.startAnimation(this.bNF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiG() {
        if (aiB()) {
            this.cpd = this.bse.getVisibility() == 0;
            this.cpc = true;
            if (!this.cpd) {
                aiF();
            }
        } else if (this.cpc) {
            this.bse.setVisibility(this.cpd ? 0 : 8);
            this.cpc = false;
        }
    }
}
