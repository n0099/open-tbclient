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
    private boolean aTD;
    private boolean aTz;
    private String biw;
    private com.baidu.tbadk.core.util.b.a bzf;
    private String cXO;
    private String dST;
    private AlphaAnimation eGL;
    private boolean eGN;
    private boolean fhA;
    private boolean fhB;
    private int fhC;
    private boolean fhD;
    private float fhE;
    private com.baidu.tieba.c.d fhF;
    private boolean fhG;
    private boolean fhH;
    private float fhL;
    private String fha;
    private String fhb;
    private TextView fhm;
    private MultiImageView fhn;
    private ArrayList<String> fho;
    private Map<String, ImageUrlData> fhq;
    private b fhr;
    private e fhs;
    private i fht;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean fhp = true;
    private boolean eGM = true;
    private boolean fhu = false;
    private boolean fhv = true;
    private com.baidu.tieba.image.a fhw = null;
    private boolean fhx = false;
    private boolean fhy = false;
    private boolean fhz = true;
    private boolean beb = false;
    private int aGa = 0;
    private boolean fhI = false;
    private Runnable fhJ = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aWM();
            }
        }
    };
    private DragImageView.d aUZ = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void QG() {
            ImageViewerActivity.this.fhJ.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void QH() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b aTB = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void KS() {
            TiebaStatic.log(new am("c10351").aA("tid", ImageViewerActivity.this.biw).aA("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private a fhK = new a();
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean fhM = true;
    private View.OnTouchListener aVo = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.fhL = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.fhM = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.fhL) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(ImageViewerActivity.this.fhJ);
                        ImageViewerActivity.this.aWM();
                    }
                    ImageViewerActivity.this.fhL = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.jG().removeCallbacks(ImageViewerActivity.this.fhJ);
                        com.baidu.adp.lib.g.e.jG().postDelayed(ImageViewerActivity.this.fhJ, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.fhM = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener fhN = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(ImageViewerActivity.this.fhK.aWO(), ImageViewerActivity.this.fhK);
            ImageViewerActivity.this.showListMenu();
            TiebaStatic.log(new am("c13269").aA("uid", ImageViewerActivity.this.mUserId).aA(ImageViewerConfig.FORUM_ID, ImageViewerActivity.this.cXO).aA("tid", ImageViewerActivity.this.biw));
            return true;
        }
    };
    private BaseViewPager.a fhO = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void eb(int i) {
            if (i == 0) {
                ImageViewerActivity.this.fhs.aWw();
            } else if (ImageViewerActivity.this.aWG() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.fhs.aWx();
            }
        }
    };
    private ViewPager.OnPageChangeListener aLU = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.fhs != null && i > ImageViewerActivity.this.fhn.getItemNum() - 5) {
                ImageViewerActivity.this.fhs.aWw();
            }
            ImageViewerActivity.this.fht.e(ImageViewerActivity.this.fho, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aWH();
            ImageViewerActivity.this.aWN();
            if (ImageViewerActivity.this.fht.aWP() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.fht.qI(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aWI()) {
                ImageViewerActivity.this.fhw.aWl();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.fhn.getItemNum() - 1) {
                ImageViewerActivity.this.fhu = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.aGa) {
                ImageViewerActivity.this.aGa = i;
                ImageViewerActivity.this.beb = true;
            } else if (i < ImageViewerActivity.this.aGa) {
                ImageViewerActivity.this.aGa = i;
                ImageViewerActivity.this.beb = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.fho != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.fho.size()) {
                ImageViewerActivity.this.fht.U(i, (String) ImageViewerActivity.this.fho.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.fhn.getItemNum() - 1) {
                if (!ImageViewerActivity.this.fhM || !ImageViewerActivity.this.fhD || (!ImageViewerActivity.this.fhu && !ImageViewerActivity.this.aWI() && (ImageViewerActivity.this.fhn.getItemNum() != 1 || !ImageViewerActivity.this.beb))) {
                    ImageViewerActivity.this.fhu = true;
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
        this.fhC = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(e.h.image_activity_2);
        initData(bundle);
        aJU();
        if (com.baidu.tbadk.core.util.g.CE()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.fhb = d.qO((String) v.d(this.fho, this.mIndex));
        if (d.qP((String) v.d(this.fho, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.fhb, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.fhJ, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.fhs = new e(this.fho, this.fhq, this.cXO, this.dST, this.biw, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.fhs.setSourceImageRectInScreen(this.fha);
        this.fhs.jl(this.fhp);
        this.fhs.jm(z);
        this.fhs.qR(this.fhb);
        this.fhs.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.fhA) {
                    if (!z5) {
                        ImageViewerActivity.this.fhn.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(e.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.fhA = false;
                ImageViewerActivity.this.fhm.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.fhn.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.fhn.getItemNum();
                    ImageViewerActivity.this.fhn.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.fhn.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.fhn.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.fhw.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.fhn.setUrlData(arrayList);
                ImageViewerActivity.this.fhn.setAssistUrls(ImageViewerActivity.this.fhq);
                ImageViewerActivity.this.fhn.setHasNext(z3);
                ImageViewerActivity.this.fhn.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.fhn.getItemNum()) {
                    ImageViewerActivity.this.fhn.ft(ImageViewerActivity.this.fhn.getCurrentItem());
                } else {
                    ImageViewerActivity.this.fhn.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.fhn.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.fhn.setUrlData(arrayList);
                    ImageViewerActivity.this.fhn.setCurrentItem(ImageViewerActivity.this.fhn.getCurrentItem() - 200, false);
                }
                a(arrayList, advertAppInfo);
                ImageViewerActivity.this.aWH();
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.fhn.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.fhw.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.fhw.aWh()) {
                    ImageViewerActivity.this.fhn.setAddSize(1);
                } else {
                    ImageViewerActivity.this.fhn.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void T(int i, String str2) {
                ImageViewerActivity.this.fhA = false;
                ImageViewerActivity.this.fhm.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.fho.size();
                    ImageViewerActivity.this.aWH();
                }
            }
        });
        this.fhs.jn(true);
        this.fhs.aWw();
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
            this.fhr = new b(this.fhn.getCurrentImageUrl(), this.fhn.getCurrentImageData());
            this.fhr.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fhn.setBackgroundColor(-16777216);
        this.fhn.ej(i);
        super.onChangeSkinType(i);
        this.fhC = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.fhn.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fhn.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.fhn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.Nu().Nv();
        this.fht.e(this.fho, this.mIndex, this.mIndex);
        this.fht.aWQ();
        this.fhn.onDestroy();
        if (this.fhr != null) {
            this.fhr.cancel();
            this.fhr = null;
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fhJ);
        com.baidu.tbadk.download.d.LR().fE(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.fhC);
        if (this.fhF != null) {
            this.fhF.arm();
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

    private void aJU() {
        this.mStatusBarView = findViewById(e.g.statusbar_view);
        ayF();
        initViewPager();
        aWH();
        aWL();
        this.fht.e(this.fho, this.mIndex, this.mIndex);
    }

    private void ayF() {
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
        this.fhm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(e.g.see_host_image_txt);
        if (this.fhH) {
            this.fhm.setVisibility(8);
        }
        if (this.fhB) {
            if (this.mIsSeeHost) {
                this.fhm.setText(e.j.album_all);
            } else {
                this.fhm.setText(e.j.view_host);
            }
            this.fhm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.kK()) {
                        ImageViewerActivity.this.showToast(e.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).x("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.fhA = true;
                    ImageViewerActivity.this.fhm.setEnabled(false);
                    ImageViewerActivity.this.g(d.qO((String) v.d(ImageViewerActivity.this.fho, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.fhm.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, e.d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, e.d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.h(this, e.C0210e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(e.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aWG() {
        ImageUrlData imageUrlData;
        String str = (String) v.d(this.fho, this.mIndex);
        if (this.fhq == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fhq.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWH() {
        String str;
        if (this.fho != null) {
            String str2 = ("" + aWG()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (this.mFrom != null && !this.fhI && aWG() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new am("c13316").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom));
                this.fhI = true;
            }
            if (aWI()) {
                aWK();
            } else {
                qS(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWI() {
        if (this.fhv && this.fhw != null && this.fhw.aWh()) {
            return this.fhn.getItemNum() != 1 && this.mIndex == this.fhn.getItemNum() + (-1);
        }
        return false;
    }

    private void qS(String str) {
        this.mTitleView.setText(str);
        if (this.fhB && !this.fhH) {
            this.fhm.setVisibility(0);
            if (this.mIsSeeHost) {
                this.fhm.setText(e.j.album_all);
            } else {
                this.fhm.setText(e.j.view_host);
            }
        }
    }

    private boolean aWJ() {
        if (this.fho == null) {
            return false;
        }
        Iterator<String> it = this.fho.iterator();
        while (it.hasNext()) {
            if (d.qQ(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aWK() {
        this.mTitleView.setText("");
        this.fhm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.fhn == null) {
            this.fhn = (MultiImageView) findViewById(e.g.viewpager);
        } else {
            this.fhn.init();
        }
        this.fhn.setIsFromCDN(this.aTz);
        this.fhn.setIsCanDrag(this.aTC);
        this.fhn.setIsHotSort(this.aTD);
        this.fhn.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.fhn.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.fhn.setOnPageChangeListener(this.aLU);
        this.fhn.setUrlData(this.fho);
        this.fhn.setAssistUrls(this.fhq);
        this.fhn.setOuterOnTouchListener(this.aVo);
        this.fhn.setItemOnclickListener(this.mOnClickListener);
        this.fhn.setItemOnLongClickListener(this.fhN);
        this.fhn.setCurrentItem(aNE(), false);
        this.fhn.setOnScrollOutListener(this.fhO);
        this.fhw = new com.baidu.tieba.image.a(this.aTz, this.fhv, getPageContext(), this.cXO, this.biw);
        this.fhn.a(this.fhw);
        this.fhn.setOriImgSelectedCallback(this.aTB);
        this.fhn.setDragToExitListener(this.aUZ);
        this.fhn.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.fhD = ImageViewerActivity.this.fhE - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.fhE = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aWL() {
        if (!this.fhH) {
            if (this.fhF == null) {
                this.fhF = new com.baidu.tieba.c.d(getPageContext(), this.fhm);
                this.fhF.kU(e.f.pic_sign_tip);
                this.fhF.kT(48);
                this.fhF.aa(true);
                this.fhF.kV(2000);
                this.fhF.kX(-l.h(getPageContext().getPageActivity(), e.C0210e.tbds26));
                this.fhF.n(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ImageViewerActivity.this.fhF != null) {
                            ImageViewerActivity.this.fhF.arm();
                        }
                    }
                });
            }
            this.fhF.bo(getPageContext().getString(e.j.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    private int aNE() {
        int H = v.H(this.fho);
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
        this.fht = new i();
        if (bundle != null) {
            this.fho = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cXO = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.biw = bundle.getString("tid");
            this.dST = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aTz = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.fhp = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.fhv = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aTC = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.aTD = bundle.getBoolean(ImageViewerConfig.IS_HOT_SORT, false);
            this.fhB = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.fha = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.fhq = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fhq.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.fhG = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.fhH = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.fho = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cXO = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.biw = intent.getStringExtra("tid");
                this.dST = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aTz = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.fhp = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.fhv = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aTC = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.aTD = intent.getBooleanExtra(ImageViewerConfig.IS_HOT_SORT, false);
                this.fhB = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.fha = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.fhq = (Map) serializableExtra;
                }
                this.fhG = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.fhH = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
            }
        }
        this.fht.b(bundle, getIntent());
        this.mCount = v.H(this.fho);
        this.fhz = aWJ();
        if (this.fha != null) {
            String str = (String) v.d(this.fho, this.mIndex);
            if (!StringUtils.isNull(str) && this.fhq != null && (imageUrlData = this.fhq.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.fha);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.fho);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cXO);
        bundle.putString("tid", this.biw);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dST);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.fhp);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aTC);
        bundle.putBoolean(ImageViewerConfig.IS_HOT_SORT, this.aTD);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.fhB);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.fhv);
        bundle.putString("user_id", this.mUserId);
        if (this.fhq instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fhq.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fhq instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fhq.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.fha);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.fhG);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.fhH);
        this.fht.D(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.fhn.setCurrentItem(this.mIndex, false);
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
            String fK;
            if (this.mUrl != null && ImageViewerActivity.this.fhq != null) {
                Iterator it = ImageViewerActivity.this.fhq.entrySet().iterator();
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
                    String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + an.DL().fD(fK) + "/" + ar.fK(imageUrlData.originalUrl);
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
            ImageViewerActivity.this.fhr = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.fhr = null;
            super.cancel(true);
        }
    }

    /* loaded from: classes3.dex */
    class a implements b.InterfaceC0158b {
        private int fhQ = 0;
        private int fhR = 1;
        private int fhS = 2;
        private List<Integer> fhT = new ArrayList();

        a() {
        }

        protected String[] aWO() {
            this.fhT.clear();
            ArrayList arrayList = new ArrayList();
            if (ImageViewerActivity.this.fhG) {
                arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.identify_image));
                this.fhT.add(Integer.valueOf(this.fhS));
            }
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_emotion));
            this.fhT.add(Integer.valueOf(this.fhQ));
            arrayList.add(ImageViewerActivity.this.getPageContext().getString(e.j.save_to_local));
            this.fhT.add(Integer.valueOf(this.fhR));
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu() && i < this.fhT.size()) {
                switch (this.fhT.get(i).intValue()) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.fhn.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.bcp);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.bcq, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                        }
                        TiebaStatic.log(new am("c13270").aA("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 2));
                        break;
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.bzf == null) {
                            ImageViewerActivity.this.bzf = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.bzf.Et();
                        ImageViewerActivity.this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.bzf.A(pageActivity)) {
                            ImageViewerActivity.this.saveImage();
                            TiebaStatic.log(new am("c13270").aA("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 3));
                            break;
                        } else {
                            return;
                        }
                    case 2:
                        g.aA(ImageViewerActivity.this.getPageContext().getPageActivity(), ImageViewerActivity.this.fhn.getCurrentImageUrl());
                        TiebaStatic.log(new am("c13270").aA("uid", ImageViewerActivity.this.mUserId).x(VideoPlayActivityConfig.OBJ_ID, 1));
                        break;
                }
                bVar.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWM() {
        if (this.eGM) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fhn.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.fhn.Kv();
                this.fhn.cf(false);
                this.eGL = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.eGL = new AlphaAnimation(1.0f, 0.0f);
                this.eGN = true;
                this.fhn.Kw();
                this.fhn.cf(true);
            }
            this.eGL.setDuration(300L);
            this.eGL.setFillAfter(false);
            this.eGL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.eGM = true;
                    if (ImageViewerActivity.this.eGN) {
                        ImageViewerActivity.this.eGN = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.fhn.setSystemUiVisibility(4);
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
            this.eGM = false;
            this.mNavigationBar.startAnimation(this.eGL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWN() {
        if (aWI()) {
            this.fhy = this.mNavigationBar.getVisibility() == 0;
            this.fhx = true;
            if (!this.fhy) {
                aWM();
            }
        } else if (this.fhx) {
            this.mNavigationBar.setVisibility(this.fhy ? 0 : 8);
            this.fhx = false;
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
            public boolean OM() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int ON() {
                return com.baidu.tbadk.pageStayDuration.e.OR().OT();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.cXO, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.biw, 0L));
        }
        return pageStayDurationItem;
    }
}
