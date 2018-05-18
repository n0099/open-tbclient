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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
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
    private String aNv;
    private boolean ayi;
    private boolean ayl;
    private com.baidu.tbadk.core.util.b.a baE;
    private String csP;
    private AlphaAnimation dQA;
    private boolean dQC;
    private String dhu;
    private String eqX;
    private String eqY;
    private boolean erA;
    private int erB;
    private boolean erC;
    private float erD;
    private float erG;
    private ImageButton erj;
    private TextView erk;
    private MultiImageView erl;
    private ArrayList<String> erm;
    private Map<String, ImageUrlData> ero;
    private a erp;
    private e erq;
    private h ers;
    private boolean erz;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean ern = true;
    private boolean dQB = true;
    private boolean ert = false;
    private boolean eru = true;
    private com.baidu.tieba.image.a erv = null;
    private boolean erw = false;
    private boolean erx = false;
    private boolean ery = true;
    private boolean aIF = false;
    private int currentPosition = 0;
    private Runnable erE = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aJx();
            }
        }
    };
    private DragImageView.d azD = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void In() {
            ImageViewerActivity.this.erE.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Io() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b ayk = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void Cu() {
            TiebaStatic.log(new al("c10351").ac("tid", ImageViewerActivity.this.aNv).ac("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private b.InterfaceC0086b erF = new b.InterfaceC0086b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
            if (bVar == ImageViewerActivity.this.getListMenu()) {
                switch (i) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.erl.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                            break;
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.aGW);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.aGX, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                            break;
                        }
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.baE == null) {
                            ImageViewerActivity.this.baE = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.baE.wt();
                        ImageViewerActivity.this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.baE.v(pageActivity)) {
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
        public void onClick(View view2) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean erH = true;
    private View.OnTouchListener azN = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.erG = motionEvent.getX();
                    if (view2 instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.erH = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.erG) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.fw().removeCallbacks(ImageViewerActivity.this.erE);
                        ImageViewerActivity.this.aJx();
                    }
                    ImageViewerActivity.this.erG = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.fw().removeCallbacks(ImageViewerActivity.this.erE);
                        com.baidu.adp.lib.g.e.fw().postDelayed(ImageViewerActivity.this.erE, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view2 instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.erH = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener erI = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            ImageViewerActivity.this.createListMenu(new String[]{ImageViewerActivity.this.getPageContext().getString(d.k.save_to_emotion), ImageViewerActivity.this.getPageContext().getString(d.k.save_to_local)}, ImageViewerActivity.this.erF);
            ImageViewerActivity.this.showListMenu();
            return true;
        }
    };
    private BaseViewPager.a erJ = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void cZ(int i) {
            if (i == 0) {
                ImageViewerActivity.this.erq.aJi();
            } else if (ImageViewerActivity.this.aJs() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.erq.aJj();
            }
        }
    };
    private ViewPager.OnPageChangeListener arf = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.erq != null && i > ImageViewerActivity.this.erl.getItemNum() - 5) {
                ImageViewerActivity.this.erq.aJi();
            }
            ImageViewerActivity.this.ers.d(ImageViewerActivity.this.erm, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aJt();
            ImageViewerActivity.this.aJy();
            if (ImageViewerActivity.this.ers.aJz() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.ers.ol(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aJu()) {
                ImageViewerActivity.this.erv.aIX();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.erl.getItemNum() - 1) {
                ImageViewerActivity.this.ert = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.aIF = true;
            } else if (i < ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.aIF = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.erm != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.erm.size()) {
                ImageViewerActivity.this.ers.Z(i, (String) ImageViewerActivity.this.erm.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.erl.getItemNum() - 1) {
                if (!ImageViewerActivity.this.erH || !ImageViewerActivity.this.erC || (!ImageViewerActivity.this.ert && !ImageViewerActivity.this.aJu() && (ImageViewerActivity.this.erl.getItemNum() != 1 || !ImageViewerActivity.this.aIF))) {
                    ImageViewerActivity.this.ert = true;
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
        this.erB = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.image_activity_2);
        initData(bundle);
        awW();
        this.eqY = d.om((String) v.c(this.erm, this.mIndex));
        if (d.oo((String) v.c(this.erm, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eqY, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.erE, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.erq = new e(this.erm, this.ero, this.csP, this.dhu, this.aNv, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.erq.setSourceImageRectInScreen(this.eqX);
        this.erq.hQ(this.ern);
        this.erq.hR(z);
        this.erq.oq(this.eqY);
        this.erq.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.erz) {
                    if (!z5) {
                        ImageViewerActivity.this.erl.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(d.k.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.erz = false;
                ImageViewerActivity.this.erj.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.erl.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.erl.getItemNum();
                    ImageViewerActivity.this.erl.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.erl.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.erl.setTempSize(0);
                }
                ImageViewerActivity.this.erl.setUrlData(arrayList);
                ImageViewerActivity.this.erl.setAssistUrls(ImageViewerActivity.this.ero);
                ImageViewerActivity.this.erl.setHasNext(z3);
                ImageViewerActivity.this.erl.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.erl.getItemNum()) {
                    ImageViewerActivity.this.erl.ep(ImageViewerActivity.this.erl.getCurrentItem());
                } else {
                    ImageViewerActivity.this.erl.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.erl.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.erl.setUrlData(arrayList);
                    ImageViewerActivity.this.erl.setCurrentItem(ImageViewerActivity.this.erl.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                ImageViewerActivity.this.aJt();
                a(arrayList, advertAppInfo);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.erl.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.erv.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.erv.aIT()) {
                    ImageViewerActivity.this.erl.setAddSize(1);
                } else {
                    ImageViewerActivity.this.erl.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void Y(int i, String str2) {
                ImageViewerActivity.this.erz = false;
                ImageViewerActivity.this.erj.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.erm.size();
                    ImageViewerActivity.this.aJt();
                }
            }
        });
        this.erq.aJi();
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
            this.erp = new a(this.erl.getCurrentImageUrl(), this.erl.getCurrentImageData());
            this.erp.execute(new String[0]);
            this.erk.setClickable(false);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.erl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.erl.di(i);
        super.onChangeSkinType(i);
        this.erB = i;
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.erl.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.erl.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.erl.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.EY().EZ();
        this.ers.d(this.erm, this.mIndex, this.mIndex);
        this.ers.aJA();
        this.erl.onDestroy();
        if (this.erp != null) {
            this.erp.cancel();
            this.erp = null;
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.erE);
        com.baidu.tbadk.download.e.Dw().eA(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.erB);
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

    private void awW() {
        ard();
        initViewPager();
        aJt();
        this.ers.d(this.erm, this.mIndex, this.mIndex);
    }

    private void ard() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mTitleView = this.mNavigationBar.setTitleText("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ImageViewerActivity.this.mNavigationBar.getVisibility() != 8) {
                    Intent intent = new Intent();
                    intent.putExtra("index", ImageViewerActivity.this.mIndex);
                    ImageViewerActivity.this.setResult(-1, intent);
                    ImageViewerActivity.this.finish();
                }
            }
        });
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.cell_image_view_right_layout, (View.OnClickListener) null);
        this.erj = (ImageButton) addCustomView.findViewById(d.g.see_host_image_txt);
        if (this.erA) {
            if (this.mIsSeeHost) {
                this.erj.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.erj.setImageResource(d.f.icon_topbar_host_white_selector);
            }
            this.erj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!j.gD()) {
                        ImageViewerActivity.this.showToast(d.k.neterror);
                        return;
                    }
                    TiebaStatic.log(new al("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.erz = true;
                    ImageViewerActivity.this.erj.setEnabled(false);
                    ImageViewerActivity.this.g(d.om((String) v.c(ImageViewerActivity.this.erm, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.erj.setVisibility(8);
        }
        this.erk = (TextView) addCustomView.findViewById(d.g.save_image_txt);
        this.erk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ImageViewerActivity.this.mNavigationBar.getVisibility() != 8) {
                    Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                    if (ImageViewerActivity.this.baE == null) {
                        ImageViewerActivity.this.baE = new com.baidu.tbadk.core.util.b.a();
                    }
                    ImageViewerActivity.this.baE.wt();
                    ImageViewerActivity.this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!ImageViewerActivity.this.baE.v(pageActivity)) {
                        ImageViewerActivity.this.saveImage();
                    }
                }
            }
        });
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0126d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0126d.cp_cont_g));
        this.erk.setTextColor(ContextCompat.getColor(this, d.C0126d.cp_cont_g));
        this.mNavigationBar.getBackImageView().setImageResource(d.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aJs() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.erm, this.mIndex);
        if (this.ero == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.ero.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJt() {
        String str;
        if (this.erm != null) {
            String str2 = ("" + aJs()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aJu()) {
                aJw();
            } else {
                or(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJu() {
        return this.eru && this.erv != null && this.erv.aIT() && this.mIndex == this.erl.getItemNum() + (-1);
    }

    private void or(String str) {
        this.mTitleView.setText(str);
        if (!this.ery) {
            this.erk.setVisibility(8);
        } else {
            this.erk.setClickable(true);
            this.erk.setVisibility(0);
        }
        if (this.erA) {
            this.erj.setVisibility(0);
            if (this.mIsSeeHost) {
                this.erj.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.erj.setImageResource(d.f.icon_topbar_host_white_selector);
            }
        }
    }

    private boolean aJv() {
        if (this.erm == null) {
            return false;
        }
        Iterator<String> it = this.erm.iterator();
        while (it.hasNext()) {
            if (d.op(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aJw() {
        this.mTitleView.setText("");
        this.erj.setVisibility(8);
        this.erk.setClickable(false);
        this.erk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.erl == null) {
            this.erl = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.erl.init();
        }
        this.erl.setIsFromCDN(this.ayi);
        this.erl.setIsCanDrag(this.ayl);
        this.erl.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.erl.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.erl.setOnPageChangeListener(this.arf);
        this.erl.setUrlData(this.erm);
        this.erl.setAssistUrls(this.ero);
        this.erl.setOuterOnTouchListener(this.azN);
        this.erl.setItemOnclickListener(this.mOnClickListener);
        this.erl.setItemOnLongClickListener(this.erI);
        this.erl.setCurrentItem(aAi(), false);
        this.erl.setOnScrollOutListener(this.erJ);
        this.erv = new com.baidu.tieba.image.a(this.ayi, this.eru, getPageContext(), this.csP, this.aNv);
        this.erl.a(this.erv);
        this.erl.setOriImgSelectedCallback(this.ayk);
        this.erl.setDragToExitListener(this.azD);
        this.erl.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.erC = ImageViewerActivity.this.erD - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.erD = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private int aAi() {
        int v = v.v(this.erm);
        if (v > 0) {
            if (this.mIndex >= v) {
                this.mIndex = v - 1;
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
        this.ers = new h();
        if (bundle != null) {
            this.erm = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.csP = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.aNv = bundle.getString("tid");
            this.dhu = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.ayi = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.ern = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eru = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.ayl = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.erA = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eqX = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.ero = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.ero.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.erm = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.csP = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.aNv = intent.getStringExtra("tid");
                this.dhu = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.ayi = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.ern = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eru = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.ayl = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.erA = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eqX = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.ero = (Map) serializableExtra;
                }
            }
        }
        this.ers.b(bundle, getIntent());
        this.mCount = v.v(this.erm);
        this.ery = aJv();
        if (this.eqX != null) {
            String str = (String) v.c(this.erm, this.mIndex);
            if (!StringUtils.isNull(str) && this.ero != null && (imageUrlData = this.ero.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eqX);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.erm);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.csP);
        bundle.putString("tid", this.aNv);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dhu);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.ern);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.ayl);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.erA);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eru);
        bundle.putString("user_id", this.mUserId);
        if (this.ero instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.ero.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.ero instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.ero.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eqX);
        this.ers.v(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.erl.setCurrentItem(this.mIndex, false);
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
            String em;
            if (this.mUrl != null && ImageViewerActivity.this.ero != null && ImageViewerActivity.this.ero.get(this.mUrl) != null) {
                String str = k.uE() + am.vJ().ef(em) + "/" + aq.em(((ImageUrlData) ImageViewerActivity.this.ero.get(this.mUrl)).originalUrl);
                int[] dG = k.dG(str);
                if (dG != null && dG.length == 2 && dG[0] > 0 && k.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                    return ImageViewerActivity.this.getPageContext().getString(d.k.save_image_to_album);
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (k.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return k.uC();
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
            ImageViewerActivity.this.erp = null;
            ImageViewerActivity.this.erk.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.erp = null;
            ImageViewerActivity.this.erk.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJx() {
        if (this.dQB) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.erl.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.erl.BX();
                this.erl.bm(false);
                this.dQA = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.dQA = new AlphaAnimation(1.0f, 0.0f);
                this.dQC = true;
                this.erl.BY();
                this.erl.bm(true);
            }
            this.dQA.setDuration(300L);
            this.dQA.setFillAfter(false);
            this.dQA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.dQB = true;
                    if (ImageViewerActivity.this.dQC) {
                        ImageViewerActivity.this.dQC = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.erl.setSystemUiVisibility(4);
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
            this.dQB = false;
            this.mNavigationBar.startAnimation(this.dQA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJy() {
        if (aJu()) {
            this.erx = this.mNavigationBar.getVisibility() == 0;
            this.erw = true;
            if (!this.erx) {
                aJx();
            }
        } else if (this.erw) {
            this.mNavigationBar.setVisibility(this.erx ? 0 : 8);
            this.erw = false;
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
            public boolean Gm() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Gn() {
                return com.baidu.tbadk.pageStayDuration.e.Gr().Gt();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.csP, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.aNv, 0L));
        }
        return pageStayDurationItem;
    }
}
