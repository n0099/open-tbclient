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
    private boolean aUk;
    private boolean aUn;
    private boolean aUo;
    private String bjm;
    private String dWq;
    private String dbr;
    private AlphaAnimation eKo;
    private boolean eKq;
    private String fkO;
    private String fkP;
    private TextView fla;
    private MultiImageView flb;
    private ArrayList<String> flc;
    private Map<String, ImageUrlData> fle;
    private b flf;
    private e flg;
    private i flh;
    private boolean flo;
    private boolean flp;
    private int flq;
    private boolean flr;
    private float fls;
    private com.baidu.tieba.c.d flt;
    private boolean flu;
    private boolean flv;
    private float flz;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean fld = true;
    private boolean eKp = true;
    private boolean fli = false;
    private boolean flj = true;
    private com.baidu.tieba.image.a flk = null;
    private boolean fll = false;
    private boolean flm = false;
    private boolean fln = true;
    private boolean beQ = false;
    private int aGD = 0;
    private boolean flw = false;
    private Runnable flx = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aXZ();
            }
        }
    };
    private DragImageView.d aVK = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Rd() {
            ImageViewerActivity.this.flx.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Re() {
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Rf() {
        }
    };
    private UrlDragImageView.b aUm = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void Li() {
            TiebaStatic.log(new am("c10351").aB("tid", ImageViewerActivity.this.bjm).aB("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private a fly = new a();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean flA = true;
    private View.OnTouchListener aVZ = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.flz = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.flA = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.flz) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(ImageViewerActivity.this.flx);
                        ImageViewerActivity.this.aXZ();
                    }
                    ImageViewerActivity.this.flz = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(ImageViewerActivity.this.flx);
                        com.baidu.adp.lib.g.e.jG().postDelayed(ImageViewerActivity.this.flx, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.flA = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener flB = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(ImageViewerActivity.this.fly.xg(), ImageViewerActivity.this.fly);
            ImageViewerActivity.this.showListMenu();
            TiebaStatic.log(new am("c13269").aB("uid", ImageViewerActivity.this.mUserId).aB(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.dbr).aB("tid", ImageViewerActivity.this.bjm));
            return true;
        }
    };
    private BaseViewPager.a flC = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void eb(int i) {
            if (i == 0) {
                ImageViewerActivity.this.flg.aXJ();
            } else if (ImageViewerActivity.this.aXT() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.flg.aXK();
            }
        }
    };
    private ViewPager.OnPageChangeListener aMy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.flg != null && i > ImageViewerActivity.this.flb.getItemNum() - 5) {
                ImageViewerActivity.this.flg.aXJ();
            }
            ImageViewerActivity.this.flh.e(ImageViewerActivity.this.flc, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aXU();
            ImageViewerActivity.this.aYa();
            if (ImageViewerActivity.this.flh.aYb() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.flh.qW(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.flh.aYc() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.flh.qX(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aXV()) {
                ImageViewerActivity.this.flk.aXy();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.flb.getItemNum() - 1) {
                ImageViewerActivity.this.fli = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.aGD) {
                ImageViewerActivity.this.aGD = i;
                ImageViewerActivity.this.beQ = true;
            } else if (i < ImageViewerActivity.this.aGD) {
                ImageViewerActivity.this.aGD = i;
                ImageViewerActivity.this.beQ = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.flc != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.flc.size()) {
                ImageViewerActivity.this.flh.X(i, (String) ImageViewerActivity.this.flc.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.flb.getItemNum() - 1) {
                if (!ImageViewerActivity.this.flA || !ImageViewerActivity.this.flr || (!ImageViewerActivity.this.fli && !ImageViewerActivity.this.aXV() && (ImageViewerActivity.this.flb.getItemNum() != 1 || !ImageViewerActivity.this.beQ))) {
                    ImageViewerActivity.this.fli = true;
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
        this.flq = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        initData(bundle);
        aLh();
        if (com.baidu.tbadk.core.util.g.CR()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.fkP = d.rh((String) v.d(this.flc, this.mIndex));
        if (d.ri((String) v.d(this.flc, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.fkP, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.flx, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.flg = new e(this.flc, this.fle, this.dbr, this.dWq, this.bjm, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.flg.setSourceImageRectInScreen(this.fkO);
        this.flg.jo(this.fld);
        this.flg.jp(z);
        this.flg.rk(this.fkP);
        this.flg.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.flo) {
                    if (!z5) {
                        ImageViewerActivity.this.flb.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(e.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.flo = false;
                ImageViewerActivity.this.fla.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.flb.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.flb.getItemNum();
                    ImageViewerActivity.this.flb.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.flb.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.flb.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.flk.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.flb.setUrlData(arrayList);
                ImageViewerActivity.this.flb.setAssistUrls(ImageViewerActivity.this.fle);
                ImageViewerActivity.this.flb.setHasNext(z3);
                ImageViewerActivity.this.flb.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.flb.getItemNum()) {
                    ImageViewerActivity.this.flb.fu(ImageViewerActivity.this.flb.getCurrentItem());
                } else {
                    ImageViewerActivity.this.flb.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.flb.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.flb.setUrlData(arrayList);
                    ImageViewerActivity.this.flb.setCurrentItem(ImageViewerActivity.this.flb.getCurrentItem() - 200, false);
                }
                a(arrayList, advertAppInfo);
                ImageViewerActivity.this.aXU();
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.flb.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.flk.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.flk.aXu()) {
                    ImageViewerActivity.this.flb.setAddSize(1);
                } else {
                    ImageViewerActivity.this.flb.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void W(int i, String str2) {
                ImageViewerActivity.this.flo = false;
                ImageViewerActivity.this.fla.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.flc.size();
                    ImageViewerActivity.this.aXU();
                }
            }
        });
        this.flg.jq(true);
        this.flg.aXJ();
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
            this.flf = new b(this.flb.getCurrentImageUrl(), this.flb.getCurrentImageData());
            this.flf.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.flb.setBackgroundColor(-16777216);
        this.flb.ej(i);
        super.onChangeSkinType(i);
        this.flq = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.flb.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.flb.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.flb.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.NM().NN();
        this.flh.e(this.flc, this.mIndex, this.mIndex);
        this.flh.aYd();
        String str = "";
        if (this.flk != null) {
            str = this.flk.getAdId();
        }
        this.flh.b(this.flb.getPageCount(), str, this.dbr, this.bjm);
        this.flb.onDestroy();
        if (this.flf != null) {
            this.flf.cancel();
            this.flf = null;
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.flx);
        com.baidu.tbadk.download.d.Mj().fF(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.flq);
        if (this.flt != null) {
            this.flt.asz();
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

    private void aLh() {
        this.mStatusBarView = findViewById(e.g.statusbar_view);
        azR();
        initViewPager();
        aXU();
        aXY();
        this.flh.e(this.flc, this.mIndex, this.mIndex);
    }

    private void azR() {
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
        this.fla = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(e.g.see_host_image_txt);
        if (this.flv) {
            this.fla.setVisibility(8);
        }
        if (this.flp) {
            if (this.mIsSeeHost) {
                this.fla.setText(e.j.album_all);
            } else {
                this.fla.setText(e.j.view_host);
            }
            this.fla.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.kK()) {
                        ImageViewerActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new am("pb_onlyowner_click").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).y("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.flo = true;
                    ImageViewerActivity.this.fla.setEnabled(false);
                    ImageViewerActivity.this.g(d.rh((String) v.d(ImageViewerActivity.this.flc, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.fla.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, e.d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, e.d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.h(this, e.C0210e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(e.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aXT() {
        ImageUrlData imageUrlData;
        String str = (String) v.d(this.flc, this.mIndex);
        if (this.fle == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fle.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXU() {
        String str;
        if (this.flc != null) {
            String str2 = ("" + aXT()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.flw && aXT() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new am("c13316").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.flw = true;
            }
            if (aXV()) {
                aXX();
            } else {
                rl(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXV() {
        if (this.flj && this.flk != null && this.flk.aXu()) {
            return this.flb.getItemNum() != 1 && this.mIndex == this.flb.getItemNum() + (-1);
        }
        return false;
    }

    private void rl(String str) {
        this.mTitleView.setText(str);
        if (this.flp && !this.flv) {
            this.fla.setVisibility(0);
            if (this.mIsSeeHost) {
                this.fla.setText(e.j.album_all);
            } else {
                this.fla.setText(e.j.view_host);
            }
        }
    }

    private boolean aXW() {
        if (this.flc == null) {
            return false;
        }
        Iterator<String> it = this.flc.iterator();
        while (it.hasNext()) {
            if (d.rj(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aXX() {
        this.mTitleView.setText("");
        this.fla.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.flb == null) {
            this.flb = (MultiImageView) findViewById(e.g.viewpager);
        } else {
            this.flb.init();
        }
        this.flb.setIsFromCDN(this.aUk);
        this.flb.setIsCanDrag(this.aUn);
        this.flb.setIsHotSort(this.aUo);
        this.flb.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.flb.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.flb.setOnPageChangeListener(this.aMy);
        this.flb.setUrlData(this.flc);
        this.flb.setAssistUrls(this.fle);
        this.flb.setOuterOnTouchListener(this.aVZ);
        this.flb.setItemOnclickListener(this.mOnClickListener);
        this.flb.setItemOnLongClickListener(this.flB);
        this.flb.setCurrentItem(aOR(), false);
        this.flb.setOnScrollOutListener(this.flC);
        this.flk = new com.baidu.tieba.image.a(this.aUk, this.flj, getPageContext(), this.dbr, this.bjm);
        this.flk.setDragToExitListener(this.aVK);
        this.flb.a(this.flk);
        this.flb.setOriImgSelectedCallback(this.aUm);
        this.flb.setDragToExitListener(this.aVK);
        this.flb.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.flr = ImageViewerActivity.this.fls - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.fls = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aXY() {
        if (!this.flv) {
            if (this.flt == null) {
                this.flt = new com.baidu.tieba.c.d(getPageContext(), this.fla);
                this.flt.li(e.f.pic_sign_tip);
                this.flt.lh(48);
                this.flt.aa(true);
                this.flt.lj(2000);
                this.flt.ll(-l.h(getPageContext().getPageActivity(), e.C0210e.tbds26));
                this.flt.n(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ImageViewerActivity.this.flt != null) {
                            ImageViewerActivity.this.flt.asz();
                        }
                    }
                });
            }
            this.flt.bp(getPageContext().getString(e.j.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    private int aOR() {
        int H = v.H(this.flc);
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
        this.flh = new i();
        if (bundle != null) {
            this.flc = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.dbr = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bjm = bundle.getString("tid");
            this.dWq = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aUk = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.fld = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.flj = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aUn = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.aUo = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.flp = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.fkO = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.fle = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fle.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.flu = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.flv = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.flc = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.dbr = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bjm = intent.getStringExtra("tid");
                this.dWq = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aUk = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.fld = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.flj = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aUn = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.aUo = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.flp = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.fkO = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.fle = (Map) serializableExtra;
                }
                this.flu = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.flv = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
            }
        }
        this.flh.b(bundle, getIntent());
        this.mCount = v.H(this.flc);
        this.fln = aXW();
        if (this.fkO != null) {
            String str = (String) v.d(this.flc, this.mIndex);
            if (!StringUtils.isNull(str) && this.fle != null && (imageUrlData = this.fle.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.fkO);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.flc);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.dbr);
        bundle.putString("tid", this.bjm);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dWq);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.fld);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aUn);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.aUo);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.flp);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.flj);
        bundle.putString("user_id", this.mUserId);
        if (this.fle instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fle.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fle instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fle.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.fkO);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.flu);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.flv);
        this.flh.D(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.flb.setCurrentItem(this.mIndex, false);
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
            String fY;
            if (this.mUrl != null && ImageViewerActivity.this.fle != null) {
                Iterator it = ImageViewerActivity.this.fle.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + an.DZ().fQ(fY) + "/" + ar.fY(imageUrlData.originalUrl);
                    int[] fr = com.baidu.tbadk.core.util.l.fr(str);
                    if (fr != null && fr.length == 2 && fr[0] > 0 && com.baidu.tbadk.core.util.l.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                        return ImageViewerActivity.this.getPageContext().getString(e.j.save_image_to_album);
                    }
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return com.baidu.tbadk.core.util.l.CU();
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
            ImageViewerActivity.this.flf = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.flf = null;
            super.cancel(true);
        }
    }

    /* loaded from: classes3.dex */
    class a implements b.InterfaceC0158b {
        private int flE = 0;
        private int ani = 1;
        private int flF = 2;
        private List<Integer> ank = new ArrayList();

        a() {
        }

        protected String[] xg() {
            this.ank.clear();
            ArrayList arrayList = new ArrayList();
            if (ImageViewerActivity.this.flu) {
                arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.identify_image));
                this.ank.add(Integer.valueOf(this.flF));
            }
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_emotion));
            this.ank.add(Integer.valueOf(this.flE));
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_local));
            this.ank.add(Integer.valueOf(this.ani));
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu() && i < this.ank.size()) {
                switch (this.ank.get(i).intValue()) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.flb.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.bdc);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.bdd, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                        }
                        TiebaStatic.log(new am("c13270").aB("uid", ImageViewerActivity.this.mUserId).y(VideoPlayActivityConfig.OBJ_ID, 2));
                        break;
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.mPermissionJudgement == null) {
                            ImageViewerActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.mPermissionJudgement.EG();
                        ImageViewerActivity.this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.mPermissionJudgement.B(pageActivity)) {
                            ImageViewerActivity.this.saveImage();
                            TiebaStatic.log(new am("c13270").aB("uid", ImageViewerActivity.this.mUserId).y(VideoPlayActivityConfig.OBJ_ID, 3));
                            break;
                        } else {
                            return;
                        }
                    case 2:
                        g.ay(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.flb.getCurrentImageUrl());
                        TiebaStatic.log(new am("c13270").aB("uid", ImageViewerActivity.this.mUserId).y(VideoPlayActivityConfig.OBJ_ID, 1));
                        break;
                }
                bVar.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXZ() {
        if (this.eKp) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.flb.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.flb.KL();
                this.flb.cg(false);
                this.eKo = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.eKo = new AlphaAnimation(1.0f, 0.0f);
                this.eKq = true;
                this.flb.KM();
                this.flb.cg(true);
            }
            this.eKo.setDuration(300L);
            this.eKo.setFillAfter(false);
            this.eKo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.eKp = true;
                    if (ImageViewerActivity.this.eKq) {
                        ImageViewerActivity.this.eKq = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky() && !UtilHelper.isMiNotchDevice()) {
                            ImageViewerActivity.this.flb.setSystemUiVisibility(4);
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
            this.eKp = false;
            this.mNavigationBar.startAnimation(this.eKo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYa() {
        if (aXV()) {
            this.flm = this.mNavigationBar.getVisibility() == 0;
            this.fll = true;
            if (!this.flm) {
                aXZ();
            }
        } else if (this.fll) {
            this.mNavigationBar.setVisibility(this.flm ? 0 : 8);
            this.fll = false;
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
            public boolean Pf() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Pg() {
                return com.baidu.tbadk.pageStayDuration.e.Pk().Pm();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.dbr, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.bjm, 0L));
        }
        return pageStayDurationItem;
    }
}
