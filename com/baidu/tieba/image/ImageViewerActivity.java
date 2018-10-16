package com.baidu.tieba.image;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
    private boolean aPk;
    private boolean aPn;
    private boolean aPo;
    private String beh;
    private com.baidu.tbadk.core.util.b.a buX;
    private String cQb;
    private String dLm;
    private String eYQ;
    private String eYR;
    private float eZA;
    private TextView eZc;
    private MultiImageView eZd;
    private ArrayList<String> eZe;
    private Map<String, ImageUrlData> eZg;
    private b eZh;
    private e eZi;
    private i eZj;
    private boolean eZq;
    private boolean eZr;
    private int eZs;
    private boolean eZt;
    private float eZu;
    private com.baidu.tieba.c.d eZv;
    private boolean eZw;
    private boolean eZx;
    private AlphaAnimation eyC;
    private boolean eyE;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eZf = true;
    private boolean eyD = true;
    private boolean eZk = false;
    private boolean eZl = true;
    private com.baidu.tieba.image.a eZm = null;
    private boolean eZn = false;
    private boolean eZo = false;
    private boolean eZp = true;
    private boolean aZQ = false;
    private int aBL = 0;
    private Runnable eZy = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aVx();
            }
        }
    };
    private DragImageView.d aQM = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Pr() {
            ImageViewerActivity.this.eZy.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Ps() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b aPm = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void JC() {
            TiebaStatic.log(new am("c10351").ax("tid", ImageViewerActivity.this.beh).ax("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private a eZz = new a();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean eZB = true;
    private View.OnTouchListener aRb = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eZA = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eZB = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eZA) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.jI().removeCallbacks(ImageViewerActivity.this.eZy);
                        ImageViewerActivity.this.aVx();
                    }
                    ImageViewerActivity.this.eZA = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.jI().removeCallbacks(ImageViewerActivity.this.eZy);
                        com.baidu.adp.lib.g.e.jI().postDelayed(ImageViewerActivity.this.eZy, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eZB = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eZC = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(ImageViewerActivity.this.eZz.aVz(), ImageViewerActivity.this.eZz);
            ImageViewerActivity.this.showListMenu();
            TiebaStatic.log(new am("c13269").ax("uid", ImageViewerActivity.this.mUserId).ax(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.cQb).ax("tid", ImageViewerActivity.this.beh));
            return true;
        }
    };
    private BaseViewPager.a eZD = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void dz(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eZi.aVh();
            } else if (ImageViewerActivity.this.aVr() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eZi.aVi();
            }
        }
    };
    private ViewPager.OnPageChangeListener aHE = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eZi != null && i > ImageViewerActivity.this.eZd.getItemNum() - 5) {
                ImageViewerActivity.this.eZi.aVh();
            }
            ImageViewerActivity.this.eZj.e(ImageViewerActivity.this.eZe, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aVs();
            ImageViewerActivity.this.aVy();
            if (ImageViewerActivity.this.eZj.aVA() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eZj.pV(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aVt()) {
                ImageViewerActivity.this.eZm.aUW();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eZd.getItemNum() - 1) {
                ImageViewerActivity.this.eZk = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.aBL) {
                ImageViewerActivity.this.aBL = i;
                ImageViewerActivity.this.aZQ = true;
            } else if (i < ImageViewerActivity.this.aBL) {
                ImageViewerActivity.this.aBL = i;
                ImageViewerActivity.this.aZQ = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eZe != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eZe.size()) {
                ImageViewerActivity.this.eZj.Y(i, (String) ImageViewerActivity.this.eZe.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eZd.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eZB || !ImageViewerActivity.this.eZt || (!ImageViewerActivity.this.eZk && !ImageViewerActivity.this.aVt() && (ImageViewerActivity.this.eZd.getItemNum() != 1 || !ImageViewerActivity.this.aZQ))) {
                    ImageViewerActivity.this.eZk = true;
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
        this.eZs = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        initData(bundle);
        aIF();
        if (com.baidu.tbadk.core.util.g.Bt()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.eYR = d.ql((String) v.d(this.eZe, this.mIndex));
        if (d.qm((String) v.d(this.eZe, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eYR, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.eZy, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eZi = new e(this.eZe, this.eZg, this.cQb, this.dLm, this.beh, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eZi.setSourceImageRectInScreen(this.eYQ);
        this.eZi.iZ(this.eZf);
        this.eZi.ja(z);
        this.eZi.qo(this.eYR);
        this.eZi.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eZq) {
                    if (!z5) {
                        ImageViewerActivity.this.eZd.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(e.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eZq = false;
                ImageViewerActivity.this.eZc.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eZd.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eZd.getItemNum();
                    ImageViewerActivity.this.eZd.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eZd.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eZd.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.eZm.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.eZd.setUrlData(arrayList);
                ImageViewerActivity.this.eZd.setAssistUrls(ImageViewerActivity.this.eZg);
                ImageViewerActivity.this.eZd.setHasNext(z3);
                ImageViewerActivity.this.eZd.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eZd.getItemNum()) {
                    ImageViewerActivity.this.eZd.eR(ImageViewerActivity.this.eZd.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eZd.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eZd.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eZd.setUrlData(arrayList);
                    ImageViewerActivity.this.eZd.setCurrentItem(ImageViewerActivity.this.eZd.getCurrentItem() - 200, false);
                }
                a(arrayList, advertAppInfo);
                ImageViewerActivity.this.aVs();
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eZd.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eZm.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eZm.aUS()) {
                    ImageViewerActivity.this.eZd.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eZd.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void X(int i, String str2) {
                ImageViewerActivity.this.eZq = false;
                ImageViewerActivity.this.eZc.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eZe.size();
                    ImageViewerActivity.this.aVs();
                }
            }
        });
        this.eZi.aVh();
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
            this.eZh = new b(this.eZd.getCurrentImageUrl(), this.eZd.getCurrentImageData());
            this.eZh.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eZd.setBackgroundColor(-16777216);
        this.eZd.dH(i);
        super.onChangeSkinType(i);
        this.eZs = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eZd.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eZd.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eZd.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.Me().Mf();
        this.eZj.e(this.eZe, this.mIndex, this.mIndex);
        this.eZj.aVB();
        this.eZd.onDestroy();
        if (this.eZh != null) {
            this.eZh.cancel();
            this.eZh = null;
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.eZy);
        com.baidu.tbadk.download.d.KB().fc(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eZs);
        if (this.eZv != null) {
            this.eZv.apY();
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

    private void aIF() {
        this.mStatusBarView = findViewById(e.g.statusbar_view);
        axv();
        initViewPager();
        aVs();
        aVw();
        this.eZj.e(this.eZe, this.mIndex, this.mIndex);
    }

    private void axv() {
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
        this.eZc = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(e.g.see_host_image_txt);
        if (this.eZx) {
            this.eZc.setVisibility(8);
        }
        if (this.eZr) {
            if (this.mIsSeeHost) {
                this.eZc.setText(e.j.album_all);
            } else {
                this.eZc.setText(e.j.view_host);
            }
            this.eZc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.kM()) {
                        ImageViewerActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eZq = true;
                    ImageViewerActivity.this.eZc.setEnabled(false);
                    ImageViewerActivity.this.g(d.ql((String) v.d(ImageViewerActivity.this.eZe, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eZc.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, e.d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, e.d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.h(this, e.C0175e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(e.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aVr() {
        ImageUrlData imageUrlData;
        String str = (String) v.d(this.eZe, this.mIndex);
        if (this.eZg == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eZg.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVs() {
        String str;
        if (this.eZe != null) {
            String str2 = ("" + aVr()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aVt()) {
                aVv();
            } else {
                qp(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVt() {
        if (this.eZl && this.eZm != null && this.eZm.aUS()) {
            return this.eZd.getItemNum() != 1 && this.mIndex == this.eZd.getItemNum() + (-1);
        }
        return false;
    }

    private void qp(String str) {
        this.mTitleView.setText(str);
        if (this.eZr && !this.eZx) {
            this.eZc.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eZc.setText(e.j.album_all);
            } else {
                this.eZc.setText(e.j.view_host);
            }
        }
    }

    private boolean aVu() {
        if (this.eZe == null) {
            return false;
        }
        Iterator<String> it = this.eZe.iterator();
        while (it.hasNext()) {
            if (d.qn(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aVv() {
        this.mTitleView.setText("");
        this.eZc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eZd == null) {
            this.eZd = (MultiImageView) findViewById(e.g.viewpager);
        } else {
            this.eZd.init();
        }
        this.eZd.setIsFromCDN(this.aPk);
        this.eZd.setIsCanDrag(this.aPn);
        this.eZd.setIsHotSort(this.aPo);
        this.eZd.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eZd.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eZd.setOnPageChangeListener(this.aHE);
        this.eZd.setUrlData(this.eZe);
        this.eZd.setAssistUrls(this.eZg);
        this.eZd.setOuterOnTouchListener(this.aRb);
        this.eZd.setItemOnclickListener(this.mOnClickListener);
        this.eZd.setItemOnLongClickListener(this.eZC);
        this.eZd.setCurrentItem(aMo(), false);
        this.eZd.setOnScrollOutListener(this.eZD);
        this.eZm = new com.baidu.tieba.image.a(this.aPk, this.eZl, getPageContext(), this.cQb, this.beh);
        this.eZd.a(this.eZm);
        this.eZd.setOriImgSelectedCallback(this.aPm);
        this.eZd.setDragToExitListener(this.aQM);
        this.eZd.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.eZt = ImageViewerActivity.this.eZu - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.eZu = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aVw() {
        if (!this.eZx) {
            if (this.eZv == null) {
                this.eZv = new com.baidu.tieba.c.d(getPageContext(), this.eZc);
                this.eZv.kl(e.f.pic_sign_tip);
                this.eZv.kk(48);
                this.eZv.M(true);
                this.eZv.km(2000);
                this.eZv.ko(-l.h(getPageContext().getPageActivity(), e.C0175e.tbds26));
                this.eZv.l(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ImageViewerActivity.this.eZv != null) {
                            ImageViewerActivity.this.eZv.apY();
                        }
                    }
                });
            }
            this.eZv.bj(getPageContext().getString(e.j.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    private int aMo() {
        int I = v.I(this.eZe);
        if (I > 0) {
            if (this.mIndex >= I) {
                this.mIndex = I - 1;
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
        this.eZj = new i();
        if (bundle != null) {
            this.eZe = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cQb = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.beh = bundle.getString("tid");
            this.dLm = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aPk = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eZf = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eZl = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aPn = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.aPo = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.eZr = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eYQ = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eZg = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eZg.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.eZw = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.eZx = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eZe = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cQb = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.beh = intent.getStringExtra("tid");
                this.dLm = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aPk = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eZf = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eZl = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aPn = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.aPo = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.eZr = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eYQ = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eZg = (Map) serializableExtra;
                }
                this.eZw = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.eZx = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
            }
        }
        this.eZj.b(bundle, getIntent());
        this.mCount = v.I(this.eZe);
        this.eZp = aVu();
        if (this.eYQ != null) {
            String str = (String) v.d(this.eZe, this.mIndex);
            if (!StringUtils.isNull(str) && this.eZg != null && (imageUrlData = this.eZg.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eYQ);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eZe);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cQb);
        bundle.putString("tid", this.beh);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dLm);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eZf);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aPn);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.aPo);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eZr);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eZl);
        bundle.putString("user_id", this.mUserId);
        if (this.eZg instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eZg.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eZg instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eZg.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eYQ);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.eZw);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.eZx);
        this.eZj.x(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eZd.setCurrentItem(this.mIndex, false);
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
            String fs;
            if (this.mUrl != null && ImageViewerActivity.this.eZg != null) {
                Iterator it = ImageViewerActivity.this.eZg.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + an.CA().fl(fs) + "/" + ar.fs(imageUrlData.originalUrl);
                    int[] eP = com.baidu.tbadk.core.util.l.eP(str);
                    if (eP != null && eP.length == 2 && eP[0] > 0 && com.baidu.tbadk.core.util.l.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(e.j.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return com.baidu.tbadk.core.util.l.Bw();
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
            ImageViewerActivity.this.eZh = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eZh = null;
            super.cancel(true);
        }
    }

    /* loaded from: classes3.dex */
    class a implements b.InterfaceC0124b {
        private int eZF = 0;
        private int eZG = 1;
        private int eZH = 2;
        private List<Integer> eZI = new ArrayList();

        a() {
        }

        protected String[] aVz() {
            this.eZI.clear();
            ArrayList arrayList = new ArrayList();
            if (ImageViewerActivity.this.eZw) {
                arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.identify_image));
                this.eZI.add(Integer.valueOf(this.eZH));
            }
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_emotion));
            this.eZI.add(Integer.valueOf(this.eZF));
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_local));
            this.eZI.add(Integer.valueOf(this.eZG));
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu() && i < this.eZI.size()) {
                switch (this.eZI.get(i).intValue()) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eZd.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.aYd);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.aYe, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                        }
                        TiebaStatic.log(new am("c13270").ax("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 2));
                        break;
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.buX == null) {
                            ImageViewerActivity.this.buX = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.buX.Di();
                        ImageViewerActivity.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.buX.z(pageActivity)) {
                            ImageViewerActivity.this.saveImage();
                            TiebaStatic.log(new am("c13270").ax("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 3));
                            break;
                        } else {
                            return;
                        }
                    case 2:
                        g.az(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.eZd.getCurrentImageUrl());
                        TiebaStatic.log(new am("c13270").ax("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 1));
                        break;
                }
                bVar.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVx() {
        if (this.eyD) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eZd.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eZd.Jf();
                this.eZd.bN(false);
                this.eyC = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.eyC = new AlphaAnimation(1.0f, 0.0f);
                this.eyE = true;
                this.eZd.Jg();
                this.eZd.bN(true);
            }
            this.eyC.setDuration(300L);
            this.eyC.setFillAfter(false);
            this.eyC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.eyD = true;
                    if (ImageViewerActivity.this.eyE) {
                        ImageViewerActivity.this.eyE = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eZd.setSystemUiVisibility(4);
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
            this.eyD = false;
            this.mNavigationBar.startAnimation(this.eyC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVy() {
        if (aVt()) {
            this.eZo = this.mNavigationBar.getVisibility() == 0;
            this.eZn = true;
            if (!this.eZo) {
                aVx();
            }
        } else if (this.eZn) {
            this.mNavigationBar.setVisibility(this.eZo ? 0 : 8);
            this.eZn = false;
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
            public boolean Nz() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NA() {
                return com.baidu.tbadk.pageStayDuration.e.NE().NG();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.cQb, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.beh, 0L));
        }
        return pageStayDurationItem;
    }
}
