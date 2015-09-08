package com.baidu.tieba.image;

import android.content.BroadcastReceiver;
import android.content.Context;
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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private boolean alf;
    private String alg;
    private boolean ali;
    private ArrayList<String> bLO;
    private String bLP;
    private b bLR;
    private View bLS;
    private View bLT;
    private TextView bLU;
    private MultiImageView bLV;
    private a bLW;
    private com.baidu.tieba.image.a bLX;
    private HashMap<String, Boolean> bLZ;
    private String bLn;
    private String bMa;
    private String bMb;
    private String bMc;
    private boolean bMd;
    private NavigationBar bdE;
    private AlphaAnimation bnv;
    private boolean bnx;
    private HashMap<String, ImageUrlData> byh;
    private int bLN = 0;
    private int mIndex = -1;
    private int wA = -1;
    private boolean bLQ = true;
    private boolean bnw = true;
    private long bLY = 0;
    private c.b bMe = new d(this);
    private View.OnClickListener bMf = new e(this);
    private View.OnLongClickListener bMg = new g(this);
    private BaseViewPager.a bMh = new h(this);
    private ViewPager.OnPageChangeListener bMi = new i(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().addRemoteActivity(this);
        setContentView(i.g.image_activity_2);
        initData(bundle);
        QB();
        KZ();
        if (!this.bMd) {
            String iH = iH(this.bLP);
            if (iH == null) {
                this.bdE.setVisibility(8);
            }
            this.bLX = new com.baidu.tieba.image.a(this.bLO, this.bMb, this.bLn, iH);
            this.bLX.dE(this.bLQ);
            this.bLX.a(new j(this));
            this.bLX.YY();
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
    public void Uo() {
        try {
            byte[] currentImageData = this.bLV.getCurrentImageData();
            if (currentImageData != null) {
                this.bLR = new b(this.bLV.getCurrentImageUrl(), currentImageData);
                this.bLR.execute(new String[0]);
                this.bLS.setClickable(false);
            } else {
                showToast(getPageContext().getString(i.h.no_data));
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.bLV.setBackgroundColor(al.cs(i));
        } else {
            this.bLV.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        Zd();
    }

    private void Zd() {
        al.i(this.bdE, i.c.alpha80_black);
        getLayoutMode().k(this.bLT);
        getLayoutMode().k(this.bLU);
        getLayoutMode().k(this.bLS);
    }

    private void KZ() {
        if (this.bMd) {
            this.bLW = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionPageAdded());
            registerReceiver(this.bLW, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bLV.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bLV.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.bLV.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
        ac(this.mIndex, this.mIndex);
        Zf();
        this.bLV.onDestroy();
        if (this.bLR != null) {
            this.bLR.cancel();
            this.bLR = null;
        }
        if (this.bMd) {
            unregisterReceiver(this.bLW);
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

    private void QB() {
        Oj();
        initViewPager();
        Ze();
        ac(this.mIndex, this.mIndex);
    }

    private void Oj() {
        this.bdE = (NavigationBar) findViewById(i.f.navigation_bar);
        this.bLU = this.bdE.setTitleText("");
        this.bLT = this.bdE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.bLS = this.bdE.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.image_activity_save_button, (View.OnClickListener) null);
        this.bLS.setOnClickListener(new l(this));
        this.bdE.findViewById(i.f.navBottomLine).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ze() {
        String str;
        if (this.bLO != null) {
            String str2 = String.valueOf(String.valueOf(this.mIndex + 1 + this.bLN)) + "/";
            if (this.wA > 0) {
                str = String.valueOf(str2) + this.wA;
            } else if (!this.bMd) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.bLO.size();
            }
            if (this.bLV.getHasNext() && this.mIndex == this.bLV.getItemNum() - 1) {
                this.bLU.setText(getPageContext().getString(i.h.image_recommend));
                this.bLS.setClickable(false);
                this.bLS.setVisibility(8);
                return;
            }
            this.bLU.setText(str);
            this.bLS.setClickable(true);
            this.bLS.setVisibility(0);
        }
    }

    private void initViewPager() {
        this.bLV = (MultiImageView) findViewById(i.f.viewpager);
        this.bLV.setIsFromCDN(this.ali);
        this.bLV.setPageMargin(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.bLV.G(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.bLV.setOnPageChangeListener(this.bMi);
        this.bLV.setUrlData(this.bLO);
        this.bLV.setAssistUrls(this.byh);
        this.bLV.setItemOnclickListener(this.bMf);
        this.bLV.setItemOnLongClickListener(this.bMg);
        this.bLV.setCurrentItem(QH(), false);
        this.bLV.setOnScrollOutListener(this.bMh);
        this.bLV.setHasNext(this.alf);
        this.bLV.setNextTitle(this.alg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int QH() {
        if (this.bLO != null && this.bLO.size() > 0) {
            int size = this.bLO.size();
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
            this.bLO = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt(ImageViewerConfig.INDEX, -1);
            this.wA = bundle.getInt(ImageViewerConfig.COUNT, -1);
            this.alf = bundle.getBoolean(ImageViewerConfig.HAS_NEXT, false);
            this.alg = bundle.getString(ImageViewerConfig.NEXT_TILE);
            this.bMa = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bLn = bundle.getString("tid");
            this.bMb = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bMc = bundle.getString(ImageViewerConfig.PV_TYPE);
            this.ali = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.bLP = bundle.getString(ImageViewerConfig.LAST_ID);
            this.bLQ = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            if (serializable instanceof HashMap) {
                this.byh = (HashMap) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bLO = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
                this.wA = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
                this.alf = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
                this.alg = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
                this.bMa = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bLn = intent.getStringExtra("tid");
                this.bMb = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bMc = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
                this.ali = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.bLP = intent.getStringExtra(ImageViewerConfig.LAST_ID);
                this.bLQ = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof HashMap) {
                    this.byh = (HashMap) serializableExtra;
                }
            }
        }
        if (getIntent() != null) {
            this.bMd = getIntent().getBooleanExtra(ImageViewerConfig.NEED_BROADCAST, false);
        }
        this.bLZ = new HashMap<>();
        if (this.bLO != null) {
            this.wA = this.bLO.size();
        }
        if (this.bLP == null) {
            this.bLP = this.wA > 0 ? this.bLO.get(this.wA - 1) : "";
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.bLO);
        bundle.putInt(ImageViewerConfig.INDEX, this.mIndex);
        bundle.putInt(ImageViewerConfig.COUNT, this.wA);
        bundle.putBoolean(ImageViewerConfig.HAS_NEXT, this.alf);
        bundle.putString(ImageViewerConfig.NEXT_TILE, this.alg);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.bMa);
        bundle.putString("tid", this.bLn);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.bMb);
        bundle.putString(ImageViewerConfig.PV_TYPE, this.bMc);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.bLQ);
        bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, this.byh);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bLV.setCurrentItem(this.mIndex, false);
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
            switch (com.baidu.tbadk.core.util.n.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                case -2:
                    return com.baidu.tbadk.core.util.n.tD();
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
            ImageViewerActivity.this.bLR = null;
            ImageViewerActivity.this.bLS.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.bLR = null;
            ImageViewerActivity.this.bLS.setClickable(true);
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
            ImageViewerActivity.this.alf = intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false);
            ImageViewerActivity.this.alg = intent.getStringExtra(ImageViewerConfig.NEXT_TILE);
            ImageViewerActivity.this.bLO = intent.getStringArrayListExtra("url");
            ImageViewerActivity.this.wA = intent.getIntExtra(ImageViewerConfig.COUNT, -1);
            int intExtra = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
            ImageViewerActivity.this.bLV.setUrlData(ImageViewerActivity.this.bLO);
            ImageViewerActivity.this.bLV.setNextTitle(ImageViewerActivity.this.alg);
            ImageViewerActivity.this.bLV.setHasNext(ImageViewerActivity.this.alf);
            if (intExtra >= 0) {
                ImageViewerActivity.this.mIndex = intExtra;
                ImageViewerActivity.this.bLV.setCurrentItem(ImageViewerActivity.this.QH(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, int i2) {
        synchronized (this.bLZ) {
            if (System.nanoTime() - this.bLY > 300000000 && this.bLO != null && i < this.bLO.size()) {
                this.bLZ.put(this.bLO.get(i), true);
            }
            this.bLY = System.nanoTime();
            if (this.bLO != null && i2 < this.bLO.size() && this.bLZ.get(this.bLO.get(i2)) == null) {
                this.bLZ.put(this.bLO.get(i2), false);
            }
        }
        if (this.bLZ.size() >= 100) {
            Zf();
        }
    }

    private void Zf() {
        if (this.bLZ != null) {
            synchronized (this.bLZ) {
                if (this.bLZ.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.bLZ.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.m411getInst().sendImagePv(i, this.bLZ.size(), this.bMc);
                    this.bLZ.clear();
                }
            }
        }
    }

    private String iH(String str) {
        int lastIndexOf;
        int indexOf;
        String aS = aq.aS(str);
        if (aS != null) {
            if (aS.indexOf(".baidu.com") != -1 && (lastIndexOf = aS.lastIndexOf("/")) != -1 && (indexOf = aS.indexOf(".", lastIndexOf)) != -1) {
                return aS.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aS;
    }
}
