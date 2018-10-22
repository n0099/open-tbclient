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
    private String eYR;
    private String eYS;
    private float eZB;
    private TextView eZd;
    private MultiImageView eZe;
    private ArrayList<String> eZf;
    private Map<String, ImageUrlData> eZh;
    private b eZi;
    private e eZj;
    private i eZk;
    private boolean eZr;
    private boolean eZs;
    private int eZt;
    private boolean eZu;
    private float eZv;
    private com.baidu.tieba.c.d eZw;
    private boolean eZx;
    private boolean eZy;
    private AlphaAnimation eyD;
    private boolean eyF;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eZg = true;
    private boolean eyE = true;
    private boolean eZl = false;
    private boolean eZm = true;
    private com.baidu.tieba.image.a eZn = null;
    private boolean eZo = false;
    private boolean eZp = false;
    private boolean eZq = true;
    private boolean aZQ = false;
    private int aBL = 0;
    private Runnable eZz = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
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
            ImageViewerActivity.this.eZz.run();
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
    private a eZA = new a();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean eZC = true;
    private View.OnTouchListener aRb = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eZB = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eZC = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eZB) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.jI().removeCallbacks(ImageViewerActivity.this.eZz);
                        ImageViewerActivity.this.aVx();
                    }
                    ImageViewerActivity.this.eZB = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.jI().removeCallbacks(ImageViewerActivity.this.eZz);
                        com.baidu.adp.lib.g.e.jI().postDelayed(ImageViewerActivity.this.eZz, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eZC = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eZD = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(ImageViewerActivity.this.eZA.aVz(), ImageViewerActivity.this.eZA);
            ImageViewerActivity.this.showListMenu();
            TiebaStatic.log(new am("c13269").ax("uid", ImageViewerActivity.this.mUserId).ax(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.cQb).ax("tid", ImageViewerActivity.this.beh));
            return true;
        }
    };
    private BaseViewPager.a eZE = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void dz(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eZj.aVh();
            } else if (ImageViewerActivity.this.aVr() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eZj.aVi();
            }
        }
    };
    private ViewPager.OnPageChangeListener aHE = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eZj != null && i > ImageViewerActivity.this.eZe.getItemNum() - 5) {
                ImageViewerActivity.this.eZj.aVh();
            }
            ImageViewerActivity.this.eZk.e(ImageViewerActivity.this.eZf, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aVs();
            ImageViewerActivity.this.aVy();
            if (ImageViewerActivity.this.eZk.aVA() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eZk.pV(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aVt()) {
                ImageViewerActivity.this.eZn.aUW();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eZe.getItemNum() - 1) {
                ImageViewerActivity.this.eZl = false;
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
            if (ImageViewerActivity.this.eZf != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eZf.size()) {
                ImageViewerActivity.this.eZk.Y(i, (String) ImageViewerActivity.this.eZf.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eZe.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eZC || !ImageViewerActivity.this.eZu || (!ImageViewerActivity.this.eZl && !ImageViewerActivity.this.aVt() && (ImageViewerActivity.this.eZe.getItemNum() != 1 || !ImageViewerActivity.this.aZQ))) {
                    ImageViewerActivity.this.eZl = true;
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
        this.eZt = TbadkCoreApplication.getInst().getSkinType();
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
        this.eYS = d.ql((String) v.d(this.eZf, this.mIndex));
        if (d.qm((String) v.d(this.eZf, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eYS, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.eZz, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eZj = new e(this.eZf, this.eZh, this.cQb, this.dLm, this.beh, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eZj.setSourceImageRectInScreen(this.eYR);
        this.eZj.iZ(this.eZg);
        this.eZj.ja(z);
        this.eZj.qo(this.eYS);
        this.eZj.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eZr) {
                    if (!z5) {
                        ImageViewerActivity.this.eZe.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(e.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eZr = false;
                ImageViewerActivity.this.eZd.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eZe.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eZe.getItemNum();
                    ImageViewerActivity.this.eZe.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eZe.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eZe.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.eZn.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.eZe.setUrlData(arrayList);
                ImageViewerActivity.this.eZe.setAssistUrls(ImageViewerActivity.this.eZh);
                ImageViewerActivity.this.eZe.setHasNext(z3);
                ImageViewerActivity.this.eZe.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eZe.getItemNum()) {
                    ImageViewerActivity.this.eZe.eR(ImageViewerActivity.this.eZe.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eZe.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eZe.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eZe.setUrlData(arrayList);
                    ImageViewerActivity.this.eZe.setCurrentItem(ImageViewerActivity.this.eZe.getCurrentItem() - 200, false);
                }
                a(arrayList, advertAppInfo);
                ImageViewerActivity.this.aVs();
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eZe.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eZn.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eZn.aUS()) {
                    ImageViewerActivity.this.eZe.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eZe.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void X(int i, String str2) {
                ImageViewerActivity.this.eZr = false;
                ImageViewerActivity.this.eZd.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eZf.size();
                    ImageViewerActivity.this.aVs();
                }
            }
        });
        this.eZj.aVh();
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
            this.eZi = new b(this.eZe.getCurrentImageUrl(), this.eZe.getCurrentImageData());
            this.eZi.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eZe.setBackgroundColor(-16777216);
        this.eZe.dH(i);
        super.onChangeSkinType(i);
        this.eZt = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eZe.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eZe.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eZe.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.Me().Mf();
        this.eZk.e(this.eZf, this.mIndex, this.mIndex);
        this.eZk.aVB();
        this.eZe.onDestroy();
        if (this.eZi != null) {
            this.eZi.cancel();
            this.eZi = null;
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.eZz);
        com.baidu.tbadk.download.d.KB().fc(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eZt);
        if (this.eZw != null) {
            this.eZw.apZ();
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
        axw();
        initViewPager();
        aVs();
        aVw();
        this.eZk.e(this.eZf, this.mIndex, this.mIndex);
    }

    private void axw() {
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
        this.eZd = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(e.g.see_host_image_txt);
        if (this.eZy) {
            this.eZd.setVisibility(8);
        }
        if (this.eZs) {
            if (this.mIsSeeHost) {
                this.eZd.setText(e.j.album_all);
            } else {
                this.eZd.setText(e.j.view_host);
            }
            this.eZd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.kM()) {
                        ImageViewerActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eZr = true;
                    ImageViewerActivity.this.eZd.setEnabled(false);
                    ImageViewerActivity.this.g(d.ql((String) v.d(ImageViewerActivity.this.eZf, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eZd.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, e.d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, e.d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.h(this, e.C0175e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(e.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aVr() {
        ImageUrlData imageUrlData;
        String str = (String) v.d(this.eZf, this.mIndex);
        if (this.eZh == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eZh.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVs() {
        String str;
        if (this.eZf != null) {
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
        if (this.eZm && this.eZn != null && this.eZn.aUS()) {
            return this.eZe.getItemNum() != 1 && this.mIndex == this.eZe.getItemNum() + (-1);
        }
        return false;
    }

    private void qp(String str) {
        this.mTitleView.setText(str);
        if (this.eZs && !this.eZy) {
            this.eZd.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eZd.setText(e.j.album_all);
            } else {
                this.eZd.setText(e.j.view_host);
            }
        }
    }

    private boolean aVu() {
        if (this.eZf == null) {
            return false;
        }
        Iterator<String> it = this.eZf.iterator();
        while (it.hasNext()) {
            if (d.qn(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aVv() {
        this.mTitleView.setText("");
        this.eZd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eZe == null) {
            this.eZe = (MultiImageView) findViewById(e.g.viewpager);
        } else {
            this.eZe.init();
        }
        this.eZe.setIsFromCDN(this.aPk);
        this.eZe.setIsCanDrag(this.aPn);
        this.eZe.setIsHotSort(this.aPo);
        this.eZe.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eZe.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eZe.setOnPageChangeListener(this.aHE);
        this.eZe.setUrlData(this.eZf);
        this.eZe.setAssistUrls(this.eZh);
        this.eZe.setOuterOnTouchListener(this.aRb);
        this.eZe.setItemOnclickListener(this.mOnClickListener);
        this.eZe.setItemOnLongClickListener(this.eZD);
        this.eZe.setCurrentItem(aMo(), false);
        this.eZe.setOnScrollOutListener(this.eZE);
        this.eZn = new com.baidu.tieba.image.a(this.aPk, this.eZm, getPageContext(), this.cQb, this.beh);
        this.eZe.a(this.eZn);
        this.eZe.setOriImgSelectedCallback(this.aPm);
        this.eZe.setDragToExitListener(this.aQM);
        this.eZe.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.eZu = ImageViewerActivity.this.eZv - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.eZv = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aVw() {
        if (!this.eZy) {
            if (this.eZw == null) {
                this.eZw = new com.baidu.tieba.c.d(getPageContext(), this.eZd);
                this.eZw.kl(e.f.pic_sign_tip);
                this.eZw.kk(48);
                this.eZw.M(true);
                this.eZw.km(2000);
                this.eZw.ko(-l.h(getPageContext().getPageActivity(), e.C0175e.tbds26));
                this.eZw.l(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ImageViewerActivity.this.eZw != null) {
                            ImageViewerActivity.this.eZw.apZ();
                        }
                    }
                });
            }
            this.eZw.bj(getPageContext().getString(e.j.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    private int aMo() {
        int I = v.I(this.eZf);
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
        this.eZk = new i();
        if (bundle != null) {
            this.eZf = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cQb = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.beh = bundle.getString("tid");
            this.dLm = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aPk = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eZg = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eZm = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aPn = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.aPo = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.eZs = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eYR = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eZh = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eZh.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.eZx = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.eZy = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eZf = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cQb = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.beh = intent.getStringExtra("tid");
                this.dLm = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aPk = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eZg = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eZm = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aPn = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.aPo = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.eZs = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eYR = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eZh = (Map) serializableExtra;
                }
                this.eZx = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.eZy = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
            }
        }
        this.eZk.b(bundle, getIntent());
        this.mCount = v.I(this.eZf);
        this.eZq = aVu();
        if (this.eYR != null) {
            String str = (String) v.d(this.eZf, this.mIndex);
            if (!StringUtils.isNull(str) && this.eZh != null && (imageUrlData = this.eZh.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eYR);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eZf);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cQb);
        bundle.putString("tid", this.beh);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dLm);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eZg);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aPn);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.aPo);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eZs);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eZm);
        bundle.putString("user_id", this.mUserId);
        if (this.eZh instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eZh.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eZh instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eZh.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eYR);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.eZx);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.eZy);
        this.eZk.x(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eZe.setCurrentItem(this.mIndex, false);
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
            if (this.mUrl != null && ImageViewerActivity.this.eZh != null) {
                Iterator it = ImageViewerActivity.this.eZh.entrySet().iterator();
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
            ImageViewerActivity.this.eZi = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eZi = null;
            super.cancel(true);
        }
    }

    /* loaded from: classes3.dex */
    class a implements b.InterfaceC0124b {
        private int eZG = 0;
        private int eZH = 1;
        private int eZI = 2;
        private List<Integer> eZJ = new ArrayList();

        a() {
        }

        protected String[] aVz() {
            this.eZJ.clear();
            ArrayList arrayList = new ArrayList();
            if (ImageViewerActivity.this.eZx) {
                arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.identify_image));
                this.eZJ.add(Integer.valueOf(this.eZI));
            }
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_emotion));
            this.eZJ.add(Integer.valueOf(this.eZG));
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_local));
            this.eZJ.add(Integer.valueOf(this.eZH));
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu() && i < this.eZJ.size()) {
                switch (this.eZJ.get(i).intValue()) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eZe.getCurrentImageUrl();
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
                        g.az(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.eZe.getCurrentImageUrl());
                        TiebaStatic.log(new am("c13270").ax("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 1));
                        break;
                }
                bVar.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVx() {
        if (this.eyE) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eZe.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eZe.Jf();
                this.eZe.bN(false);
                this.eyD = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.eyD = new AlphaAnimation(1.0f, 0.0f);
                this.eyF = true;
                this.eZe.Jg();
                this.eZe.bN(true);
            }
            this.eyD.setDuration(300L);
            this.eyD.setFillAfter(false);
            this.eyD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.eyE = true;
                    if (ImageViewerActivity.this.eyF) {
                        ImageViewerActivity.this.eyF = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eZe.setSystemUiVisibility(4);
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
            this.eyE = false;
            this.mNavigationBar.startAnimation(this.eyD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVy() {
        if (aVt()) {
            this.eZp = this.mNavigationBar.getVisibility() == 0;
            this.eZo = true;
            if (!this.eZp) {
                aVx();
            }
        } else if (this.eZo) {
            this.mNavigationBar.setVisibility(this.eZp ? 0 : 8);
            this.eZo = false;
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
