package com.baidu.tieba.image;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.image.e;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private boolean aHv;
    private boolean aHy;
    private String aWo;
    private com.baidu.tbadk.core.util.b.a bkp;
    private String czo;
    private String dtS;
    private boolean eGE;
    private boolean eGF;
    private int eGG;
    private boolean eGH;
    private float eGI;
    private com.baidu.tieba.c.d eGJ;
    private float eGM;
    private String eGe;
    private String eGf;
    private TextView eGq;
    private MultiImageView eGr;
    private ArrayList<String> eGs;
    private Map<String, ImageUrlData> eGu;
    private a eGv;
    private e eGw;
    private h eGx;
    private AlphaAnimation efG;
    private boolean efI;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eGt = true;
    private boolean efH = true;
    private boolean eGy = false;
    private boolean eGz = true;
    private com.baidu.tieba.image.a eGA = null;
    private boolean eGB = false;
    private boolean eGC = false;
    private boolean eGD = true;
    private boolean aSc = false;
    private int currentPosition = 0;
    private Runnable eGK = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aOZ();
            }
        }
    };
    private DragImageView.d aIV = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Mb() {
            ImageViewerActivity.this.eGK.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Mc() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b aHx = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void Gp() {
            TiebaStatic.log(new an("c10351").ah("tid", ImageViewerActivity.this.aWo).ah("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private b.InterfaceC0104b eGL = new b.InterfaceC0104b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu()) {
                switch (i) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eGr.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                            break;
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.aQp);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.aQq, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                            break;
                        }
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.bkp == null) {
                            ImageViewerActivity.this.bkp = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.bkp.Aj();
                        ImageViewerActivity.this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.bkp.u(pageActivity)) {
                            ImageViewerActivity.this.saveImage();
                            break;
                        } else {
                            return;
                        }
                }
                bVar.dismiss();
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean eGN = true;
    private View.OnTouchListener aJf = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eGM = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eGN = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eGM) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.im().removeCallbacks(ImageViewerActivity.this.eGK);
                        ImageViewerActivity.this.aOZ();
                    }
                    ImageViewerActivity.this.eGM = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.im().removeCallbacks(ImageViewerActivity.this.eGK);
                        com.baidu.adp.lib.g.e.im().postDelayed(ImageViewerActivity.this.eGK, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eGN = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eGO = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(new String[]{ImageViewerActivity.this.getPageContext().getString(d.k.save_to_emotion), ImageViewerActivity.this.getPageContext().getString(d.k.save_to_local)}, ImageViewerActivity.this.eGL);
            ImageViewerActivity.this.showListMenu();
            return true;
        }
    };
    private BaseViewPager.a eGP = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void dc(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eGw.aOJ();
            } else if (ImageViewerActivity.this.aOT() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eGw.aOK();
            }
        }
    };
    private ViewPager.OnPageChangeListener aAe = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eGw != null && i > ImageViewerActivity.this.eGr.getItemNum() - 5) {
                ImageViewerActivity.this.eGw.aOJ();
            }
            ImageViewerActivity.this.eGx.d(ImageViewerActivity.this.eGs, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aOU();
            ImageViewerActivity.this.aPa();
            if (ImageViewerActivity.this.eGx.aPb() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eGx.oE(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aOV()) {
                ImageViewerActivity.this.eGA.aOy();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eGr.getItemNum() - 1) {
                ImageViewerActivity.this.eGy = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.aSc = true;
            } else if (i < ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.aSc = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eGs != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eGs.size()) {
                ImageViewerActivity.this.eGx.W(i, (String) ImageViewerActivity.this.eGs.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eGr.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eGN || !ImageViewerActivity.this.eGH || (!ImageViewerActivity.this.eGy && !ImageViewerActivity.this.aOV() && (ImageViewerActivity.this.eGr.getItemNum() != 1 || !ImageViewerActivity.this.aSc))) {
                    ImageViewerActivity.this.eGy = true;
                } else {
                    ImageViewerActivity.this.showToast(d.k.last_page);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eGG = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.image_activity_2);
        initData(bundle);
        aCu();
        if (com.baidu.tbadk.core.util.g.yn()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.eGf = d.pa((String) w.d(this.eGs, this.mIndex));
        if (d.pb((String) w.d(this.eGs, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eGf, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.im().postDelayed(this.eGK, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eGw = new e(this.eGs, this.eGu, this.czo, this.dtS, this.aWo, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eGw.setSourceImageRectInScreen(this.eGe);
        this.eGw.ig(this.eGt);
        this.eGw.ih(z);
        this.eGw.pd(this.eGf);
        this.eGw.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eGE) {
                    if (!z5) {
                        ImageViewerActivity.this.eGr.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(d.k.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eGE = false;
                ImageViewerActivity.this.eGq.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eGr.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eGr.getItemNum();
                    ImageViewerActivity.this.eGr.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eGr.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eGr.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.eGA.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.eGr.setUrlData(arrayList);
                ImageViewerActivity.this.eGr.setAssistUrls(ImageViewerActivity.this.eGu);
                ImageViewerActivity.this.eGr.setHasNext(z3);
                ImageViewerActivity.this.eGr.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eGr.getItemNum()) {
                    ImageViewerActivity.this.eGr.eu(ImageViewerActivity.this.eGr.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eGr.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eGr.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eGr.setUrlData(arrayList);
                    ImageViewerActivity.this.eGr.setCurrentItem(ImageViewerActivity.this.eGr.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                ImageViewerActivity.this.aOU();
                a(arrayList, advertAppInfo);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eGr.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eGA.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eGA.aOu()) {
                    ImageViewerActivity.this.eGr.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eGr.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void V(int i, String str2) {
                ImageViewerActivity.this.eGE = false;
                ImageViewerActivity.this.eGq.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eGs.size();
                    ImageViewerActivity.this.aOU();
                }
            }
        });
        this.eGw.aOJ();
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
    public void saveImage() {
        try {
            this.eGv = new a(this.eGr.getCurrentImageUrl(), this.eGr.getCurrentImageData());
            this.eGv.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eGr.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.eGr.dl(i);
        super.onChangeSkinType(i);
        this.eGG = i;
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eGr.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eGr.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eGr.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.IV().IW();
        this.eGx.d(this.eGs, this.mIndex, this.mIndex);
        this.eGx.aPc();
        this.eGr.onDestroy();
        if (this.eGv != null) {
            this.eGv.cancel();
            this.eGv = null;
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eGK);
        com.baidu.tbadk.download.e.Hr().eF(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eGG);
        if (this.eGJ != null) {
            this.eGJ.akn();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aCu() {
        this.mStatusBarView = findViewById(d.g.statusbar_view);
        arI();
        initViewPager();
        aOU();
        aOY();
        this.eGx.d(this.eGs, this.mIndex, this.mIndex);
    }

    private void arI() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageViewerActivity.this.mNavigationBar.getVisibility() != 8) {
                    Intent intent = new Intent();
                    intent.putExtra("index", ImageViewerActivity.this.mIndex);
                    ImageViewerActivity.this.setResult(-1, intent);
                    ImageViewerActivity.this.finish();
                }
            }
        });
        this.eGq = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(d.g.see_host_image_txt);
        if (this.eGF) {
            if (this.mIsSeeHost) {
                this.eGq.setText(d.k.album_all);
            } else {
                this.eGq.setText(d.k.view_host);
            }
            this.eGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.jr()) {
                        ImageViewerActivity.this.showToast(d.k.neterror);
                        return;
                    }
                    TiebaStatic.log(new an("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eGE = true;
                    ImageViewerActivity.this.eGq.setEnabled(false);
                    ImageViewerActivity.this.g(d.pa((String) w.d(ImageViewerActivity.this.eGs, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eGq.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0142d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0142d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.e(this, d.e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(d.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aOT() {
        ImageUrlData imageUrlData;
        String str = (String) w.d(this.eGs, this.mIndex);
        if (this.eGu == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eGu.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOU() {
        String str;
        if (this.eGs != null) {
            String str2 = ("" + aOT()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aOV()) {
                aOX();
            } else {
                pe(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOV() {
        if (this.eGz && this.eGA != null && this.eGA.aOu()) {
            return this.eGr.getItemNum() != 1 && this.mIndex == this.eGr.getItemNum() + (-1);
        }
        return false;
    }

    private void pe(String str) {
        this.mTitleView.setText(str);
        if (this.eGF) {
            this.eGq.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eGq.setText(d.k.album_all);
            } else {
                this.eGq.setText(d.k.view_host);
            }
        }
    }

    private boolean aOW() {
        if (this.eGs == null) {
            return false;
        }
        Iterator<String> it = this.eGs.iterator();
        while (it.hasNext()) {
            if (d.pc(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aOX() {
        this.mTitleView.setText("");
        this.eGq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eGr == null) {
            this.eGr = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.eGr.init();
        }
        this.eGr.setIsFromCDN(this.aHv);
        this.eGr.setIsCanDrag(this.aHy);
        this.eGr.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eGr.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eGr.setOnPageChangeListener(this.aAe);
        this.eGr.setUrlData(this.eGs);
        this.eGr.setAssistUrls(this.eGu);
        this.eGr.setOuterOnTouchListener(this.aJf);
        this.eGr.setItemOnclickListener(this.mOnClickListener);
        this.eGr.setItemOnLongClickListener(this.eGO);
        this.eGr.setCurrentItem(aFL(), false);
        this.eGr.setOnScrollOutListener(this.eGP);
        this.eGA = new com.baidu.tieba.image.a(this.aHv, this.eGz, getPageContext(), this.czo, this.aWo);
        this.eGr.a(this.eGA);
        this.eGr.setOriImgSelectedCallback(this.aHx);
        this.eGr.setDragToExitListener(this.aIV);
        this.eGr.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.eGH = ImageViewerActivity.this.eGI - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.eGI = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aOY() {
        if (this.eGJ == null) {
            this.eGJ = new com.baidu.tieba.c.d(getPageContext(), this.eGq);
            this.eGJ.jd(d.f.pic_sign_tip);
            this.eGJ.jc(48);
            this.eGJ.D(true);
            this.eGJ.je(2000);
            this.eGJ.jg(-l.e(getPageContext().getPageActivity(), d.e.tbds26));
            this.eGJ.k(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ImageViewerActivity.this.eGJ != null) {
                        ImageViewerActivity.this.eGJ.akn();
                    }
                }
            });
        }
        this.eGJ.aQ(getPageContext().getString(d.k.click_look_all_picture), "key_large_image_tip_count");
    }

    private int aFL() {
        int z = w.z(this.eGs);
        if (z > 0) {
            if (this.mIndex >= z) {
                this.mIndex = z - 1;
            } else if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        } else {
            this.mIndex = 0;
        }
        return this.mIndex;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: java.util.Map<java.lang.String, com.baidu.tbadk.coreExtra.view.ImageUrlData> */
    /* JADX WARN: Multi-variable type inference failed */
    private void initData(Bundle bundle) {
        ImageUrlData imageUrlData;
        this.eGx = new h();
        if (bundle != null) {
            this.eGs = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.czo = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.aWo = bundle.getString("tid");
            this.dtS = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aHv = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eGt = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eGz = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aHy = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.eGF = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eGe = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eGu = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eGu.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eGs = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.czo = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.aWo = intent.getStringExtra("tid");
                this.dtS = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aHv = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eGt = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eGz = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aHy = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.eGF = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eGe = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eGu = (Map) serializableExtra;
                }
            }
        }
        this.eGx.b(bundle, getIntent());
        this.mCount = w.z(this.eGs);
        this.eGD = aOW();
        if (this.eGe != null) {
            String str = (String) w.d(this.eGs, this.mIndex);
            if (!StringUtils.isNull(str) && this.eGu != null && (imageUrlData = this.eGu.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eGe);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eGs);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.czo);
        bundle.putString("tid", this.aWo);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dtS);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eGt);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aHy);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eGF);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eGz);
        bundle.putString("user_id", this.mUserId);
        if (this.eGu instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eGu.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eGu instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eGu.entrySet()) {
                if (entry2 != null && (entry2.getValue() instanceof ImageUrlData) && (entry2.getKey() instanceof String)) {
                    try {
                        concurrentHashMap.put(entry2.getKey(), OrmObject.jsonStrWithObject(entry2.getValue()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, concurrentHashMap);
        }
        bundle.putString("from", this.mFrom);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.mIsSeeHost);
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eGe);
        this.eGx.w(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eGr.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {
        byte[] mData;
        String mUrl;

        public a(String str, byte[] bArr) {
            this.mUrl = null;
            this.mData = null;
            this.mUrl = str;
            this.mData = bArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            String eO;
            if (this.mUrl != null && ImageViewerActivity.this.eGu != null && ImageViewerActivity.this.eGu.get(this.mUrl) != null) {
                String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ao.zz().eH(eO) + "/" + as.eO(((ImageUrlData) ImageViewerActivity.this.eGu.get(this.mUrl)).originalUrl);
                int[] ej = com.baidu.tbadk.core.util.l.ej(str);
                if (ej != null && ej.length == 2 && ej[0] > 0 && com.baidu.tbadk.core.util.l.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                    return ImageViewerActivity.this.getPageContext().getString(d.k.save_image_to_album);
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return com.baidu.tbadk.core.util.l.yq();
                    case 0:
                        return ImageViewerActivity.this.getPageContext().getString(d.k.save_image_to_album);
                }
            }
            return ImageViewerActivity.this.getPageContext().getString(d.k.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.eGv = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eGv = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOZ() {
        if (this.efH) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eGr.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eGr.FS();
                this.eGr.bt(false);
                this.efG = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.efG = new AlphaAnimation(1.0f, 0.0f);
                this.efI = true;
                this.eGr.FT();
                this.eGr.bt(true);
            }
            this.efG.setDuration(300L);
            this.efG.setFillAfter(false);
            this.efG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.efH = true;
                    if (ImageViewerActivity.this.efI) {
                        ImageViewerActivity.this.efI = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eGr.setSystemUiVisibility(4);
                        }
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.efH = false;
            this.mNavigationBar.startAnimation(this.efG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPa() {
        if (aOV()) {
            this.eGC = this.mNavigationBar.getVisibility() == 0;
            this.eGB = true;
            if (!this.eGC) {
                aOZ();
            }
        } else if (this.eGB) {
            this.mNavigationBar.setVisibility(this.eGC ? 0 : 8);
            this.eGB = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a008";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Km() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Kn() {
                return com.baidu.tbadk.pageStayDuration.e.Kr().Kt();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.czo, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.aWo, 0L));
        }
        return pageStayDurationItem;
    }
}
