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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import com.baidu.tieba.image.e;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private boolean aKI;
    private boolean aKL;
    private boolean aKM;
    private String aZG;
    private com.baidu.tbadk.core.util.b.a bqO;
    private String cHI;
    private String dDm;
    private b eRA;
    private e eRB;
    private i eRC;
    private boolean eRJ;
    private boolean eRK;
    private int eRL;
    private boolean eRM;
    private float eRN;
    private com.baidu.tieba.c.d eRO;
    private boolean eRP;
    private float eRS;
    private String eRj;
    private String eRk;
    private TextView eRv;
    private MultiImageView eRw;
    private ArrayList<String> eRx;
    private Map<String, ImageUrlData> eRz;
    private AlphaAnimation eqL;
    private boolean eqN;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eRy = true;
    private boolean eqM = true;
    private boolean eRD = false;
    private boolean eRE = true;
    private com.baidu.tieba.image.a eRF = null;
    private boolean eRG = false;
    private boolean eRH = false;
    private boolean eRI = true;
    private boolean aVr = false;
    private int axb = 0;
    private Runnable eRQ = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aSj();
            }
        }
    };
    private DragImageView.d aMk = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Nt() {
            ImageViewerActivity.this.eRQ.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Nu() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b aKK = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void HB() {
            TiebaStatic.log(new am("c10351").al("tid", ImageViewerActivity.this.aZG).al("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private a eRR = new a();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean eRT = true;
    private View.OnTouchListener aMz = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eRS = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eRT = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eRS) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.jt().removeCallbacks(ImageViewerActivity.this.eRQ);
                        ImageViewerActivity.this.aSj();
                    }
                    ImageViewerActivity.this.eRS = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.jt().removeCallbacks(ImageViewerActivity.this.eRQ);
                        com.baidu.adp.lib.g.e.jt().postDelayed(ImageViewerActivity.this.eRQ, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eRT = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eRU = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(ImageViewerActivity.this.eRR.aSl(), ImageViewerActivity.this.eRR);
            ImageViewerActivity.this.showListMenu();
            TiebaStatic.log(new am("c13269").al("uid", ImageViewerActivity.this.mUserId).al(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.cHI).al("tid", ImageViewerActivity.this.aZG));
            return true;
        }
    };
    private BaseViewPager.a eRV = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void dp(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eRB.aRT();
            } else if (ImageViewerActivity.this.aSd() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eRB.aRU();
            }
        }
    };
    private ViewPager.OnPageChangeListener aCY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eRB != null && i > ImageViewerActivity.this.eRw.getItemNum() - 5) {
                ImageViewerActivity.this.eRB.aRT();
            }
            ImageViewerActivity.this.eRC.e(ImageViewerActivity.this.eRx, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aSe();
            ImageViewerActivity.this.aSk();
            if (ImageViewerActivity.this.eRC.aSm() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eRC.px(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aSf()) {
                ImageViewerActivity.this.eRF.aRI();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eRw.getItemNum() - 1) {
                ImageViewerActivity.this.eRD = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.axb) {
                ImageViewerActivity.this.axb = i;
                ImageViewerActivity.this.aVr = true;
            } else if (i < ImageViewerActivity.this.axb) {
                ImageViewerActivity.this.axb = i;
                ImageViewerActivity.this.aVr = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eRx != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eRx.size()) {
                ImageViewerActivity.this.eRC.Y(i, (String) ImageViewerActivity.this.eRx.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eRw.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eRT || !ImageViewerActivity.this.eRM || (!ImageViewerActivity.this.eRD && !ImageViewerActivity.this.aSf() && (ImageViewerActivity.this.eRw.getItemNum() != 1 || !ImageViewerActivity.this.aVr))) {
                    ImageViewerActivity.this.eRD = true;
                } else {
                    ImageViewerActivity.this.showToast(e.j.last_page);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eRL = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        initData(bundle);
        aFn();
        if (com.baidu.tbadk.core.util.g.zl()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.eRk = d.pJ((String) v.d(this.eRx, this.mIndex));
        if (d.pK((String) v.d(this.eRx, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eRk, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.eRQ, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eRB = new e(this.eRx, this.eRz, this.cHI, this.dDm, this.aZG, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eRB.setSourceImageRectInScreen(this.eRj);
        this.eRB.iH(this.eRy);
        this.eRB.iI(z);
        this.eRB.pM(this.eRk);
        this.eRB.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eRJ) {
                    if (!z5) {
                        ImageViewerActivity.this.eRw.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(e.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eRJ = false;
                ImageViewerActivity.this.eRv.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eRw.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eRw.getItemNum();
                    ImageViewerActivity.this.eRw.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eRw.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eRw.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.eRF.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.eRw.setUrlData(arrayList);
                ImageViewerActivity.this.eRw.setAssistUrls(ImageViewerActivity.this.eRz);
                ImageViewerActivity.this.eRw.setHasNext(z3);
                ImageViewerActivity.this.eRw.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eRw.getItemNum()) {
                    ImageViewerActivity.this.eRw.eI(ImageViewerActivity.this.eRw.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eRw.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eRw.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eRw.setUrlData(arrayList);
                    ImageViewerActivity.this.eRw.setCurrentItem(ImageViewerActivity.this.eRw.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                a(arrayList, advertAppInfo);
                ImageViewerActivity.this.aSe();
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eRw.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eRF.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eRF.aRE()) {
                    ImageViewerActivity.this.eRw.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eRw.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void X(int i, String str2) {
                ImageViewerActivity.this.eRJ = false;
                ImageViewerActivity.this.eRv.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eRx.size();
                    ImageViewerActivity.this.aSe();
                }
            }
        });
        this.eRB.aRT();
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
            this.eRA = new b(this.eRw.getCurrentImageUrl(), this.eRw.getCurrentImageData());
            this.eRA.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eRw.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.eRw.dx(i);
        super.onChangeSkinType(i);
        this.eRL = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eRw.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eRw.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eRw.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.Kg().Kh();
        this.eRC.e(this.eRx, this.mIndex, this.mIndex);
        this.eRC.aSn();
        this.eRw.onDestroy();
        if (this.eRA != null) {
            this.eRA.cancel();
            this.eRA = null;
        }
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eRQ);
        com.baidu.tbadk.download.d.ID().eT(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eRL);
        if (this.eRO != null) {
            this.eRO.amz();
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

    private void aFn() {
        this.mStatusBarView = findViewById(e.g.statusbar_view);
        atZ();
        initViewPager();
        aSe();
        aSi();
        this.eRC.e(this.eRx, this.mIndex, this.mIndex);
    }

    private void atZ() {
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
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
        this.eRv = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(e.g.see_host_image_txt);
        if (this.eRK) {
            if (this.mIsSeeHost) {
                this.eRv.setText(e.j.album_all);
            } else {
                this.eRv.setText(e.j.view_host);
            }
            this.eRv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.ky()) {
                        ImageViewerActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new am("pb_onlyowner_click").w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).w("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eRJ = true;
                    ImageViewerActivity.this.eRv.setEnabled(false);
                    ImageViewerActivity.this.g(d.pJ((String) v.d(ImageViewerActivity.this.eRx, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eRv.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, e.d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, e.d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.h(this, e.C0141e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(e.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aSd() {
        ImageUrlData imageUrlData;
        String str = (String) v.d(this.eRx, this.mIndex);
        if (this.eRz == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eRz.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSe() {
        String str;
        if (this.eRx != null) {
            String str2 = ("" + aSd()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aSf()) {
                aSh();
            } else {
                pN(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aSf() {
        if (this.eRE && this.eRF != null && this.eRF.aRE()) {
            return this.eRw.getItemNum() != 1 && this.mIndex == this.eRw.getItemNum() + (-1);
        }
        return false;
    }

    private void pN(String str) {
        this.mTitleView.setText(str);
        if (this.eRK) {
            this.eRv.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eRv.setText(e.j.album_all);
            } else {
                this.eRv.setText(e.j.view_host);
            }
        }
    }

    private boolean aSg() {
        if (this.eRx == null) {
            return false;
        }
        Iterator<String> it = this.eRx.iterator();
        while (it.hasNext()) {
            if (d.pL(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aSh() {
        this.mTitleView.setText("");
        this.eRv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eRw == null) {
            this.eRw = (MultiImageView) findViewById(e.g.viewpager);
        } else {
            this.eRw.init();
        }
        this.eRw.setIsFromCDN(this.aKI);
        this.eRw.setIsCanDrag(this.aKL);
        this.eRw.setIsHotSort(this.aKM);
        this.eRw.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eRw.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eRw.setOnPageChangeListener(this.aCY);
        this.eRw.setUrlData(this.eRx);
        this.eRw.setAssistUrls(this.eRz);
        this.eRw.setOuterOnTouchListener(this.aMz);
        this.eRw.setItemOnclickListener(this.mOnClickListener);
        this.eRw.setItemOnLongClickListener(this.eRU);
        this.eRw.setCurrentItem(aIX(), false);
        this.eRw.setOnScrollOutListener(this.eRV);
        this.eRF = new com.baidu.tieba.image.a(this.aKI, this.eRE, getPageContext(), this.cHI, this.aZG);
        this.eRw.a(this.eRF);
        this.eRw.setOriImgSelectedCallback(this.aKK);
        this.eRw.setDragToExitListener(this.aMk);
        this.eRw.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.eRM = ImageViewerActivity.this.eRN - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.eRN = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aSi() {
        if (this.eRO == null) {
            this.eRO = new com.baidu.tieba.c.d(getPageContext(), this.eRv);
            this.eRO.jN(e.f.pic_sign_tip);
            this.eRO.jM(48);
            this.eRO.M(true);
            this.eRO.jO(2000);
            this.eRO.jQ(-l.h(getPageContext().getPageActivity(), e.C0141e.tbds26));
            this.eRO.k(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ImageViewerActivity.this.eRO != null) {
                        ImageViewerActivity.this.eRO.amz();
                    }
                }
            });
        }
        this.eRO.aW(getPageContext().getString(e.j.click_look_all_picture), "key_large_image_tip_count");
    }

    private int aIX() {
        int y = v.y(this.eRx);
        if (y > 0) {
            if (this.mIndex >= y) {
                this.mIndex = y - 1;
            } else if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        } else {
            this.mIndex = 0;
        }
        return this.mIndex;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: java.util.Map<java.lang.String, com.baidu.tbadk.coreExtra.view.ImageUrlData> */
    /* JADX WARN: Multi-variable type inference failed */
    private void initData(Bundle bundle) {
        ImageUrlData imageUrlData;
        this.eRC = new i();
        if (bundle != null) {
            this.eRx = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cHI = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.aZG = bundle.getString("tid");
            this.dDm = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aKI = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eRy = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eRE = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aKL = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.aKM = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.eRK = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eRj = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eRz = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eRz.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.eRP = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eRx = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cHI = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.aZG = intent.getStringExtra("tid");
                this.dDm = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aKI = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eRy = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eRE = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aKL = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.aKM = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.eRK = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eRj = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eRz = (Map) serializableExtra;
                }
                this.eRP = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            }
        }
        this.eRC.b(bundle, getIntent());
        this.mCount = v.y(this.eRx);
        this.eRI = aSg();
        if (this.eRj != null) {
            String str = (String) v.d(this.eRx, this.mIndex);
            if (!StringUtils.isNull(str) && this.eRz != null && (imageUrlData = this.eRz.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eRj);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eRx);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cHI);
        bundle.putString("tid", this.aZG);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dDm);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eRy);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aKL);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.aKM);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eRK);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eRE);
        bundle.putString("user_id", this.mUserId);
        if (this.eRz instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eRz.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eRz instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eRz.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eRj);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.eRP);
        this.eRC.w(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eRw.setCurrentItem(this.mIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
            ImageUrlData imageUrlData;
            String fe;
            if (this.mUrl != null && ImageViewerActivity.this.eRz != null) {
                Iterator it = ImageViewerActivity.this.eRz.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        imageUrlData = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry != null && entry.getKey() != null && entry.getValue() != null && ((String) entry.getKey()).contains(this.mUrl)) {
                        imageUrlData = (ImageUrlData) entry.getValue();
                        break;
                    }
                }
                if (imageUrlData != null) {
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + an.At().eX(fe) + "/" + ar.fe(imageUrlData.originalUrl);
                    int[] ez = com.baidu.tbadk.core.util.l.ez(str);
                    if (ez != null && ez.length == 2 && ez[0] > 0 && com.baidu.tbadk.core.util.l.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(e.j.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return com.baidu.tbadk.core.util.l.zo();
                    case 0:
                        return ImageViewerActivity.this.getPageContext().getString(e.j.save_image_to_album);
                }
            }
            return ImageViewerActivity.this.getPageContext().getString(e.j.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.eRA = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eRA = null;
            super.cancel(true);
        }
    }

    /* loaded from: classes3.dex */
    class a implements b.InterfaceC0100b {
        private int eRX = 0;
        private int eRY = 1;
        private int eRZ = 2;
        private List<Integer> eSa = new ArrayList();

        a() {
        }

        protected String[] aSl() {
            this.eSa.clear();
            ArrayList arrayList = new ArrayList();
            if (ImageViewerActivity.this.eRP) {
                arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.identify_image));
                this.eSa.add(Integer.valueOf(this.eRZ));
            }
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_emotion));
            this.eSa.add(Integer.valueOf(this.eRX));
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_local));
            this.eSa.add(Integer.valueOf(this.eRY));
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu() && i < this.eSa.size()) {
                switch (this.eSa.get(i).intValue()) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eRw.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.aTE);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.aTF, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                        }
                        TiebaStatic.log(new am("c13270").al("uid", ImageViewerActivity.this.mUserId).w(VideoPlayActivityConfig.OBJ_ID, 2));
                        break;
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.bqO == null) {
                            ImageViewerActivity.this.bqO = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.bqO.Bb();
                        ImageViewerActivity.this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.bqO.x(pageActivity)) {
                            ImageViewerActivity.this.saveImage();
                            TiebaStatic.log(new am("c13270").al("uid", ImageViewerActivity.this.mUserId).w(VideoPlayActivityConfig.OBJ_ID, 3));
                            break;
                        } else {
                            return;
                        }
                    case 2:
                        g.ax(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.eRw.getCurrentImageUrl());
                        TiebaStatic.log(new am("c13270").al("uid", ImageViewerActivity.this.mUserId).w(VideoPlayActivityConfig.OBJ_ID, 1));
                        break;
                }
                bVar.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSj() {
        if (this.eqM) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eRw.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eRw.He();
                this.eRw.bE(false);
                this.eqL = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.eqL = new AlphaAnimation(1.0f, 0.0f);
                this.eqN = true;
                this.eRw.Hf();
                this.eRw.bE(true);
            }
            this.eqL.setDuration(300L);
            this.eqL.setFillAfter(false);
            this.eqL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.eqM = true;
                    if (ImageViewerActivity.this.eqN) {
                        ImageViewerActivity.this.eqN = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eRw.setSystemUiVisibility(4);
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
            this.eqM = false;
            this.mNavigationBar.startAnimation(this.eqL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSk() {
        if (aSf()) {
            this.eRH = this.mNavigationBar.getVisibility() == 0;
            this.eRG = true;
            if (!this.eRH) {
                aSj();
            }
        } else if (this.eRG) {
            this.mNavigationBar.setVisibility(this.eRH ? 0 : 8);
            this.eRG = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a008";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean LB() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int LC() {
                return com.baidu.tbadk.pageStayDuration.e.LG().LI();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.cHI, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.aZG, 0L));
        }
        return pageStayDurationItem;
    }
}
