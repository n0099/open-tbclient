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
    private boolean aTC;
    private boolean aTF;
    private boolean aTG;
    private String biz;
    private com.baidu.tbadk.core.util.b.a bzi;
    private String dVK;
    private String daG;
    private AlphaAnimation eJC;
    private boolean eJE;
    private String fjT;
    private String fjU;
    private boolean fkA;
    private float fkE;
    private TextView fkf;
    private MultiImageView fkg;
    private ArrayList<String> fkh;
    private Map<String, ImageUrlData> fkj;
    private b fkk;
    private e fkl;
    private i fkm;
    private boolean fkt;
    private boolean fku;
    private int fkv;
    private boolean fkw;
    private float fkx;
    private com.baidu.tieba.c.d fky;
    private boolean fkz;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean fki = true;
    private boolean eJD = true;
    private boolean fkn = false;
    private boolean fko = true;
    private com.baidu.tieba.image.a fkp = null;
    private boolean fkq = false;
    private boolean fkr = false;
    private boolean fks = true;
    private boolean bee = false;
    private int aGb = 0;
    private boolean fkB = false;
    private Runnable fkC = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aXz();
            }
        }
    };
    private DragImageView.d aVc = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void QI() {
            ImageViewerActivity.this.fkC.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void QJ() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b aTE = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void KT() {
            TiebaStatic.log(new am("c10351").aA("tid", ImageViewerActivity.this.biz).aA("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private a fkD = new a();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean fkF = true;
    private View.OnTouchListener aVr = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.fkE = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.fkF = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.fkE) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(ImageViewerActivity.this.fkC);
                        ImageViewerActivity.this.aXz();
                    }
                    ImageViewerActivity.this.fkE = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(ImageViewerActivity.this.fkC);
                        com.baidu.adp.lib.g.e.jG().postDelayed(ImageViewerActivity.this.fkC, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.fkF = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener fkG = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(ImageViewerActivity.this.fkD.aXB(), ImageViewerActivity.this.fkD);
            ImageViewerActivity.this.showListMenu();
            TiebaStatic.log(new am("c13269").aA("uid", ImageViewerActivity.this.mUserId).aA(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.daG).aA("tid", ImageViewerActivity.this.biz));
            return true;
        }
    };
    private BaseViewPager.a fkH = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void eb(int i) {
            if (i == 0) {
                ImageViewerActivity.this.fkl.aXj();
            } else if (ImageViewerActivity.this.aXt() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.fkl.aXk();
            }
        }
    };
    private ViewPager.OnPageChangeListener aLW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.fkl != null && i > ImageViewerActivity.this.fkg.getItemNum() - 5) {
                ImageViewerActivity.this.fkl.aXj();
            }
            ImageViewerActivity.this.fkm.e(ImageViewerActivity.this.fkh, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aXu();
            ImageViewerActivity.this.aXA();
            if (ImageViewerActivity.this.fkm.aXC() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.fkm.qV(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aXv()) {
                ImageViewerActivity.this.fkp.aWY();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.fkg.getItemNum() - 1) {
                ImageViewerActivity.this.fkn = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.aGb) {
                ImageViewerActivity.this.aGb = i;
                ImageViewerActivity.this.bee = true;
            } else if (i < ImageViewerActivity.this.aGb) {
                ImageViewerActivity.this.aGb = i;
                ImageViewerActivity.this.bee = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.fkh != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.fkh.size()) {
                ImageViewerActivity.this.fkm.V(i, (String) ImageViewerActivity.this.fkh.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.fkg.getItemNum() - 1) {
                if (!ImageViewerActivity.this.fkF || !ImageViewerActivity.this.fkw || (!ImageViewerActivity.this.fkn && !ImageViewerActivity.this.aXv() && (ImageViewerActivity.this.fkg.getItemNum() != 1 || !ImageViewerActivity.this.bee))) {
                    ImageViewerActivity.this.fkn = true;
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
        this.fkv = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        initData(bundle);
        aKJ();
        if (com.baidu.tbadk.core.util.g.CE()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.fjU = d.qR((String) v.d(this.fkh, this.mIndex));
        if (d.qS((String) v.d(this.fkh, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.fjU, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fkC, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.fkl = new e(this.fkh, this.fkj, this.daG, this.dVK, this.biz, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.fkl.setSourceImageRectInScreen(this.fjT);
        this.fkl.jo(this.fki);
        this.fkl.jp(z);
        this.fkl.qU(this.fjU);
        this.fkl.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.fkt) {
                    if (!z5) {
                        ImageViewerActivity.this.fkg.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(e.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.fkt = false;
                ImageViewerActivity.this.fkf.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.fkg.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.fkg.getItemNum();
                    ImageViewerActivity.this.fkg.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.fkg.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.fkg.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.fkp.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.fkg.setUrlData(arrayList);
                ImageViewerActivity.this.fkg.setAssistUrls(ImageViewerActivity.this.fkj);
                ImageViewerActivity.this.fkg.setHasNext(z3);
                ImageViewerActivity.this.fkg.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.fkg.getItemNum()) {
                    ImageViewerActivity.this.fkg.fu(ImageViewerActivity.this.fkg.getCurrentItem());
                } else {
                    ImageViewerActivity.this.fkg.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.fkg.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.fkg.setUrlData(arrayList);
                    ImageViewerActivity.this.fkg.setCurrentItem(ImageViewerActivity.this.fkg.getCurrentItem() - 200, false);
                }
                a(arrayList, advertAppInfo);
                ImageViewerActivity.this.aXu();
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.fkg.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.fkp.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.fkp.aWU()) {
                    ImageViewerActivity.this.fkg.setAddSize(1);
                } else {
                    ImageViewerActivity.this.fkg.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void U(int i, String str2) {
                ImageViewerActivity.this.fkt = false;
                ImageViewerActivity.this.fkf.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.fkh.size();
                    ImageViewerActivity.this.aXu();
                }
            }
        });
        this.fkl.jq(true);
        this.fkl.aXj();
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
            this.fkk = new b(this.fkg.getCurrentImageUrl(), this.fkg.getCurrentImageData());
            this.fkk.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fkg.setBackgroundColor(-16777216);
        this.fkg.ej(i);
        super.onChangeSkinType(i);
        this.fkv = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.fkg.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fkg.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.fkg.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.Nv().Nw();
        this.fkm.e(this.fkh, this.mIndex, this.mIndex);
        this.fkm.aXD();
        this.fkg.onDestroy();
        if (this.fkk != null) {
            this.fkk.cancel();
            this.fkk = null;
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fkC);
        com.baidu.tbadk.download.d.LS().fF(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.fkv);
        if (this.fky != null) {
            this.fky.asb();
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

    private void aKJ() {
        this.mStatusBarView = findViewById(e.g.statusbar_view);
        azu();
        initViewPager();
        aXu();
        aXy();
        this.fkm.e(this.fkh, this.mIndex, this.mIndex);
    }

    private void azu() {
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
        this.fkf = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(e.g.see_host_image_txt);
        if (this.fkA) {
            this.fkf.setVisibility(8);
        }
        if (this.fku) {
            if (this.mIsSeeHost) {
                this.fkf.setText(e.j.album_all);
            } else {
                this.fkf.setText(e.j.view_host);
            }
            this.fkf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.kK()) {
                        ImageViewerActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.fkt = true;
                    ImageViewerActivity.this.fkf.setEnabled(false);
                    ImageViewerActivity.this.g(d.qR((String) v.d(ImageViewerActivity.this.fkh, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.fkf.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, e.d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, e.d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.h(this, e.C0210e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(e.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aXt() {
        ImageUrlData imageUrlData;
        String str = (String) v.d(this.fkh, this.mIndex);
        if (this.fkj == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fkj.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXu() {
        String str;
        if (this.fkh != null) {
            String str2 = ("" + aXt()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.fkB && aXt() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new am("c13316").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.fkB = true;
            }
            if (aXv()) {
                aXx();
            } else {
                qV(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXv() {
        if (this.fko && this.fkp != null && this.fkp.aWU()) {
            return this.fkg.getItemNum() != 1 && this.mIndex == this.fkg.getItemNum() + (-1);
        }
        return false;
    }

    private void qV(String str) {
        this.mTitleView.setText(str);
        if (this.fku && !this.fkA) {
            this.fkf.setVisibility(0);
            if (this.mIsSeeHost) {
                this.fkf.setText(e.j.album_all);
            } else {
                this.fkf.setText(e.j.view_host);
            }
        }
    }

    private boolean aXw() {
        if (this.fkh == null) {
            return false;
        }
        Iterator<String> it = this.fkh.iterator();
        while (it.hasNext()) {
            if (d.qT(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aXx() {
        this.mTitleView.setText("");
        this.fkf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.fkg == null) {
            this.fkg = (MultiImageView) findViewById(e.g.viewpager);
        } else {
            this.fkg.init();
        }
        this.fkg.setIsFromCDN(this.aTC);
        this.fkg.setIsCanDrag(this.aTF);
        this.fkg.setIsHotSort(this.aTG);
        this.fkg.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.fkg.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.fkg.setOnPageChangeListener(this.aLW);
        this.fkg.setUrlData(this.fkh);
        this.fkg.setAssistUrls(this.fkj);
        this.fkg.setOuterOnTouchListener(this.aVr);
        this.fkg.setItemOnclickListener(this.mOnClickListener);
        this.fkg.setItemOnLongClickListener(this.fkG);
        this.fkg.setCurrentItem(aOr(), false);
        this.fkg.setOnScrollOutListener(this.fkH);
        this.fkp = new com.baidu.tieba.image.a(this.aTC, this.fko, getPageContext(), this.daG, this.biz);
        this.fkg.a(this.fkp);
        this.fkg.setOriImgSelectedCallback(this.aTE);
        this.fkg.setDragToExitListener(this.aVc);
        this.fkg.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.fkw = ImageViewerActivity.this.fkx - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.fkx = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aXy() {
        if (!this.fkA) {
            if (this.fky == null) {
                this.fky = new com.baidu.tieba.c.d(getPageContext(), this.fkf);
                this.fky.lh(e.f.pic_sign_tip);
                this.fky.lg(48);
                this.fky.aa(true);
                this.fky.li(2000);
                this.fky.lk(-l.h(getPageContext().getPageActivity(), e.C0210e.tbds26));
                this.fky.n(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ImageViewerActivity.this.fky != null) {
                            ImageViewerActivity.this.fky.asb();
                        }
                    }
                });
            }
            this.fky.bo(getPageContext().getString(e.j.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    private int aOr() {
        int H = v.H(this.fkh);
        if (H > 0) {
            if (this.mIndex >= H) {
                this.mIndex = H - 1;
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
        this.fkm = new i();
        if (bundle != null) {
            this.fkh = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.daG = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.biz = bundle.getString("tid");
            this.dVK = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aTC = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.fki = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.fko = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aTF = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.aTG = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.fku = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.fjT = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.fkj = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fkj.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.fkz = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.fkA = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.fkh = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.daG = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.biz = intent.getStringExtra("tid");
                this.dVK = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aTC = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.fki = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.fko = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aTF = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.aTG = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.fku = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.fjT = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.fkj = (Map) serializableExtra;
                }
                this.fkz = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.fkA = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
            }
        }
        this.fkm.b(bundle, getIntent());
        this.mCount = v.H(this.fkh);
        this.fks = aXw();
        if (this.fjT != null) {
            String str = (String) v.d(this.fkh, this.mIndex);
            if (!StringUtils.isNull(str) && this.fkj != null && (imageUrlData = this.fkj.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.fjT);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.fkh);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.daG);
        bundle.putString("tid", this.biz);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dVK);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.fki);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aTF);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.aTG);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.fku);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.fko);
        bundle.putString("user_id", this.mUserId);
        if (this.fkj instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fkj.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fkj instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fkj.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.fjT);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.fkz);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.fkA);
        this.fkm.D(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.fkg.setCurrentItem(this.mIndex, false);
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
            String fL;
            if (this.mUrl != null && ImageViewerActivity.this.fkj != null) {
                Iterator it = ImageViewerActivity.this.fkj.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + an.DL().fD(fL) + "/" + ar.fL(imageUrlData.originalUrl);
                    int[] fh = com.baidu.tbadk.core.util.l.fh(str);
                    if (fh != null && fh.length == 2 && fh[0] > 0 && com.baidu.tbadk.core.util.l.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(e.j.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return com.baidu.tbadk.core.util.l.CH();
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
            ImageViewerActivity.this.fkk = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.fkk = null;
            super.cancel(true);
        }
    }

    /* loaded from: classes3.dex */
    class a implements b.InterfaceC0158b {
        private int fkJ = 0;
        private int fkK = 1;
        private int fkL = 2;
        private List<Integer> fkM = new ArrayList();

        a() {
        }

        protected String[] aXB() {
            this.fkM.clear();
            ArrayList arrayList = new ArrayList();
            if (ImageViewerActivity.this.fkz) {
                arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.identify_image));
                this.fkM.add(Integer.valueOf(this.fkL));
            }
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_emotion));
            this.fkM.add(Integer.valueOf(this.fkJ));
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_local));
            this.fkM.add(Integer.valueOf(this.fkK));
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu() && i < this.fkM.size()) {
                switch (this.fkM.get(i).intValue()) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.fkg.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.bcs);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.bct, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                        }
                        TiebaStatic.log(new am("c13270").aA("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 2));
                        break;
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.bzi == null) {
                            ImageViewerActivity.this.bzi = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.bzi.Et();
                        ImageViewerActivity.this.bzi.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.bzi.A(pageActivity)) {
                            ImageViewerActivity.this.saveImage();
                            TiebaStatic.log(new am("c13270").aA("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 3));
                            break;
                        } else {
                            return;
                        }
                    case 2:
                        g.aA(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.fkg.getCurrentImageUrl());
                        TiebaStatic.log(new am("c13270").aA("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 1));
                        break;
                }
                bVar.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXz() {
        if (this.eJD) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fkg.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.fkg.Kw();
                this.fkg.cf(false);
                this.eJC = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.eJC = new AlphaAnimation(1.0f, 0.0f);
                this.eJE = true;
                this.fkg.Kx();
                this.fkg.cf(true);
            }
            this.eJC.setDuration(300L);
            this.eJC.setFillAfter(false);
            this.eJC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.eJD = true;
                    if (ImageViewerActivity.this.eJE) {
                        ImageViewerActivity.this.eJE = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.fkg.setSystemUiVisibility(4);
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
            this.eJD = false;
            this.mNavigationBar.startAnimation(this.eJC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXA() {
        if (aXv()) {
            this.fkr = this.mNavigationBar.getVisibility() == 0;
            this.fkq = true;
            if (!this.fkr) {
                aXz();
            }
        } else if (this.fkq) {
            this.mNavigationBar.setVisibility(this.fkr ? 0 : 8);
            this.fkq = false;
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
            public boolean ON() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int OO() {
                return com.baidu.tbadk.pageStayDuration.e.OS().OU();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.daG, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.biz, 0L));
        }
        return pageStayDurationItem;
    }
}
