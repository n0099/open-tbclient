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
    private boolean aUl;
    private boolean aUo;
    private boolean aUp;
    private String bjn;
    private String dWr;
    private String dbs;
    private AlphaAnimation eKp;
    private boolean eKr;
    private String fkP;
    private String fkQ;
    private float flA;
    private TextView flb;
    private MultiImageView flc;
    private ArrayList<String> fld;
    private Map<String, ImageUrlData> flf;
    private b flg;
    private e flh;
    private i fli;
    private boolean flp;
    private boolean flq;
    private int flr;
    private boolean fls;
    private float flt;
    private com.baidu.tieba.c.d flu;
    private boolean flv;
    private boolean flw;
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
    private boolean fle = true;
    private boolean eKq = true;
    private boolean flj = false;
    private boolean flk = true;
    private com.baidu.tieba.image.a fll = null;
    private boolean flm = false;
    private boolean fln = false;
    private boolean flo = true;
    private boolean beR = false;
    private int aGE = 0;
    private boolean flx = false;
    private Runnable fly = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aXZ();
            }
        }
    };
    private DragImageView.d aVL = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Rd() {
            ImageViewerActivity.this.fly.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Re() {
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Rf() {
        }
    };
    private UrlDragImageView.b aUn = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void Li() {
            TiebaStatic.log(new am("c10351").aB("tid", ImageViewerActivity.this.bjn).aB("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private a flz = new a();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean flB = true;
    private View.OnTouchListener aWa = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.flA = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.flB = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.flA) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(ImageViewerActivity.this.fly);
                        ImageViewerActivity.this.aXZ();
                    }
                    ImageViewerActivity.this.flA = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(ImageViewerActivity.this.fly);
                        com.baidu.adp.lib.g.e.jG().postDelayed(ImageViewerActivity.this.fly, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.flB = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener flC = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(ImageViewerActivity.this.flz.xg(), ImageViewerActivity.this.flz);
            ImageViewerActivity.this.showListMenu();
            TiebaStatic.log(new am("c13269").aB("uid", ImageViewerActivity.this.mUserId).aB(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.dbs).aB("tid", ImageViewerActivity.this.bjn));
            return true;
        }
    };
    private BaseViewPager.a flD = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void eb(int i) {
            if (i == 0) {
                ImageViewerActivity.this.flh.aXJ();
            } else if (ImageViewerActivity.this.aXT() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.flh.aXK();
            }
        }
    };
    private ViewPager.OnPageChangeListener aMz = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.flh != null && i > ImageViewerActivity.this.flc.getItemNum() - 5) {
                ImageViewerActivity.this.flh.aXJ();
            }
            ImageViewerActivity.this.fli.e(ImageViewerActivity.this.fld, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aXU();
            ImageViewerActivity.this.aYa();
            if (ImageViewerActivity.this.fli.aYb() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.fli.qW(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.fli.aYc() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.fli.qX(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aXV()) {
                ImageViewerActivity.this.fll.aXy();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.flc.getItemNum() - 1) {
                ImageViewerActivity.this.flj = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.aGE) {
                ImageViewerActivity.this.aGE = i;
                ImageViewerActivity.this.beR = true;
            } else if (i < ImageViewerActivity.this.aGE) {
                ImageViewerActivity.this.aGE = i;
                ImageViewerActivity.this.beR = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.fld != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.fld.size()) {
                ImageViewerActivity.this.fli.X(i, (String) ImageViewerActivity.this.fld.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.flc.getItemNum() - 1) {
                if (!ImageViewerActivity.this.flB || !ImageViewerActivity.this.fls || (!ImageViewerActivity.this.flj && !ImageViewerActivity.this.aXV() && (ImageViewerActivity.this.flc.getItemNum() != 1 || !ImageViewerActivity.this.beR))) {
                    ImageViewerActivity.this.flj = true;
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
        this.flr = TbadkCoreApplication.getInst().getSkinType();
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
        this.fkQ = d.rh((String) v.d(this.fld, this.mIndex));
        if (d.ri((String) v.d(this.fld, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.fkQ, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fly, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.flh = new e(this.fld, this.flf, this.dbs, this.dWr, this.bjn, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.flh.setSourceImageRectInScreen(this.fkP);
        this.flh.jo(this.fle);
        this.flh.jp(z);
        this.flh.rk(this.fkQ);
        this.flh.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.flp) {
                    if (!z5) {
                        ImageViewerActivity.this.flc.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(e.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.flp = false;
                ImageViewerActivity.this.flb.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.flc.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.flc.getItemNum();
                    ImageViewerActivity.this.flc.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.flc.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.flc.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.fll.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.flc.setUrlData(arrayList);
                ImageViewerActivity.this.flc.setAssistUrls(ImageViewerActivity.this.flf);
                ImageViewerActivity.this.flc.setHasNext(z3);
                ImageViewerActivity.this.flc.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.flc.getItemNum()) {
                    ImageViewerActivity.this.flc.fu(ImageViewerActivity.this.flc.getCurrentItem());
                } else {
                    ImageViewerActivity.this.flc.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.flc.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.flc.setUrlData(arrayList);
                    ImageViewerActivity.this.flc.setCurrentItem(ImageViewerActivity.this.flc.getCurrentItem() - 200, false);
                }
                a(arrayList, advertAppInfo);
                ImageViewerActivity.this.aXU();
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.flc.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.fll.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.fll.aXu()) {
                    ImageViewerActivity.this.flc.setAddSize(1);
                } else {
                    ImageViewerActivity.this.flc.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void W(int i, String str2) {
                ImageViewerActivity.this.flp = false;
                ImageViewerActivity.this.flb.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.fld.size();
                    ImageViewerActivity.this.aXU();
                }
            }
        });
        this.flh.jq(true);
        this.flh.aXJ();
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
            this.flg = new b(this.flc.getCurrentImageUrl(), this.flc.getCurrentImageData());
            this.flg.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.flc.setBackgroundColor(-16777216);
        this.flc.ej(i);
        super.onChangeSkinType(i);
        this.flr = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.flc.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.flc.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.flc.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.NM().NN();
        this.fli.e(this.fld, this.mIndex, this.mIndex);
        this.fli.aYd();
        String str = "";
        if (this.fll != null) {
            str = this.fll.getAdId();
        }
        this.fli.b(this.flc.getPageCount(), str, this.dbs, this.bjn);
        this.flc.onDestroy();
        if (this.flg != null) {
            this.flg.cancel();
            this.flg = null;
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fly);
        com.baidu.tbadk.download.d.Mj().fF(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.flr);
        if (this.flu != null) {
            this.flu.asz();
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
        this.fli.e(this.fld, this.mIndex, this.mIndex);
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
        this.flb = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(e.g.see_host_image_txt);
        if (this.flw) {
            this.flb.setVisibility(8);
        }
        if (this.flq) {
            if (this.mIsSeeHost) {
                this.flb.setText(e.j.album_all);
            } else {
                this.flb.setText(e.j.view_host);
            }
            this.flb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.kK()) {
                        ImageViewerActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new am("pb_onlyowner_click").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).y("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.flp = true;
                    ImageViewerActivity.this.flb.setEnabled(false);
                    ImageViewerActivity.this.g(d.rh((String) v.d(ImageViewerActivity.this.fld, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.flb.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, e.d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, e.d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.h(this, e.C0210e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(e.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aXT() {
        ImageUrlData imageUrlData;
        String str = (String) v.d(this.fld, this.mIndex);
        if (this.flf == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.flf.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXU() {
        String str;
        if (this.fld != null) {
            String str2 = ("" + aXT()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.flx && aXT() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new am("c13316").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.flx = true;
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
        if (this.flk && this.fll != null && this.fll.aXu()) {
            return this.flc.getItemNum() != 1 && this.mIndex == this.flc.getItemNum() + (-1);
        }
        return false;
    }

    private void rl(String str) {
        this.mTitleView.setText(str);
        if (this.flq && !this.flw) {
            this.flb.setVisibility(0);
            if (this.mIsSeeHost) {
                this.flb.setText(e.j.album_all);
            } else {
                this.flb.setText(e.j.view_host);
            }
        }
    }

    private boolean aXW() {
        if (this.fld == null) {
            return false;
        }
        Iterator<String> it = this.fld.iterator();
        while (it.hasNext()) {
            if (d.rj(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aXX() {
        this.mTitleView.setText("");
        this.flb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.flc == null) {
            this.flc = (MultiImageView) findViewById(e.g.viewpager);
        } else {
            this.flc.init();
        }
        this.flc.setIsFromCDN(this.aUl);
        this.flc.setIsCanDrag(this.aUo);
        this.flc.setIsHotSort(this.aUp);
        this.flc.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.flc.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.flc.setOnPageChangeListener(this.aMz);
        this.flc.setUrlData(this.fld);
        this.flc.setAssistUrls(this.flf);
        this.flc.setOuterOnTouchListener(this.aWa);
        this.flc.setItemOnclickListener(this.mOnClickListener);
        this.flc.setItemOnLongClickListener(this.flC);
        this.flc.setCurrentItem(aOR(), false);
        this.flc.setOnScrollOutListener(this.flD);
        this.fll = new com.baidu.tieba.image.a(this.aUl, this.flk, getPageContext(), this.dbs, this.bjn);
        this.fll.setDragToExitListener(this.aVL);
        this.flc.a(this.fll);
        this.flc.setOriImgSelectedCallback(this.aUn);
        this.flc.setDragToExitListener(this.aVL);
        this.flc.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.fls = ImageViewerActivity.this.flt - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.flt = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aXY() {
        if (!this.flw) {
            if (this.flu == null) {
                this.flu = new com.baidu.tieba.c.d(getPageContext(), this.flb);
                this.flu.li(e.f.pic_sign_tip);
                this.flu.lh(48);
                this.flu.aa(true);
                this.flu.lj(2000);
                this.flu.ll(-l.h(getPageContext().getPageActivity(), e.C0210e.tbds26));
                this.flu.n(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ImageViewerActivity.this.flu != null) {
                            ImageViewerActivity.this.flu.asz();
                        }
                    }
                });
            }
            this.flu.bp(getPageContext().getString(e.j.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    private int aOR() {
        int H = v.H(this.fld);
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
        this.fli = new i();
        if (bundle != null) {
            this.fld = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.dbs = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bjn = bundle.getString("tid");
            this.dWr = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aUl = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.fle = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.flk = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aUo = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.aUp = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.flq = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.fkP = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.flf = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.flf.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.flv = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.flw = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.fld = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.dbs = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bjn = intent.getStringExtra("tid");
                this.dWr = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aUl = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.fle = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.flk = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aUo = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.aUp = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.flq = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.fkP = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.flf = (Map) serializableExtra;
                }
                this.flv = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.flw = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
            }
        }
        this.fli.b(bundle, getIntent());
        this.mCount = v.H(this.fld);
        this.flo = aXW();
        if (this.fkP != null) {
            String str = (String) v.d(this.fld, this.mIndex);
            if (!StringUtils.isNull(str) && this.flf != null && (imageUrlData = this.flf.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.fkP);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.fld);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.dbs);
        bundle.putString("tid", this.bjn);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dWr);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.fle);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aUo);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.aUp);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.flq);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.flk);
        bundle.putString("user_id", this.mUserId);
        if (this.flf instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.flf.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.flf instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.flf.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.fkP);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.flv);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.flw);
        this.fli.D(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.flc.setCurrentItem(this.mIndex, false);
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
            if (this.mUrl != null && ImageViewerActivity.this.flf != null) {
                Iterator it = ImageViewerActivity.this.flf.entrySet().iterator();
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
            ImageViewerActivity.this.flg = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.flg = null;
            super.cancel(true);
        }
    }

    /* loaded from: classes3.dex */
    class a implements b.InterfaceC0158b {
        private int flF = 0;
        private int ani = 1;
        private int flG = 2;
        private List<Integer> ank = new ArrayList();

        a() {
        }

        protected String[] xg() {
            this.ank.clear();
            ArrayList arrayList = new ArrayList();
            if (ImageViewerActivity.this.flv) {
                arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.identify_image));
                this.ank.add(Integer.valueOf(this.flG));
            }
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_emotion));
            this.ank.add(Integer.valueOf(this.flF));
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_local));
            this.ank.add(Integer.valueOf(this.ani));
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu() && i < this.ank.size()) {
                switch (this.ank.get(i).intValue()) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.flc.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.bdd);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.bde, currentImageUrl);
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
                        g.ay(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.flc.getCurrentImageUrl());
                        TiebaStatic.log(new am("c13270").aB("uid", ImageViewerActivity.this.mUserId).y(VideoPlayActivityConfig.OBJ_ID, 1));
                        break;
                }
                bVar.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXZ() {
        if (this.eKq) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.flc.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.flc.KL();
                this.flc.cg(false);
                this.eKp = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.eKp = new AlphaAnimation(1.0f, 0.0f);
                this.eKr = true;
                this.flc.KM();
                this.flc.cg(true);
            }
            this.eKp.setDuration(300L);
            this.eKp.setFillAfter(false);
            this.eKp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.eKq = true;
                    if (ImageViewerActivity.this.eKr) {
                        ImageViewerActivity.this.eKr = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky() && !UtilHelper.isMiNotchDevice()) {
                            ImageViewerActivity.this.flc.setSystemUiVisibility(4);
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
            this.eKq = false;
            this.mNavigationBar.startAnimation(this.eKp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYa() {
        if (aXV()) {
            this.fln = this.mNavigationBar.getVisibility() == 0;
            this.flm = true;
            if (!this.fln) {
                aXZ();
            }
        } else if (this.flm) {
            this.mNavigationBar.setVisibility(this.fln ? 0 : 8);
            this.flm = false;
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
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.dbs, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.bjn, 0L));
        }
        return pageStayDurationItem;
    }
}
