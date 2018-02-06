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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
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
    private String bDf;
    private com.baidu.tbadk.core.util.b.a bQQ;
    private boolean bmF;
    private boolean bmI;
    private String cZU;
    private String dNQ;
    private Map<String, ImageUrlData> eVB;
    private a eVC;
    private e eVD;
    private h eVE;
    private boolean eVL;
    private boolean eVM;
    private int eVN;
    private float eVQ;
    private String eVk;
    private String eVl;
    private ImageButton eVw;
    private TextView eVx;
    private MultiImageView eVy;
    private ArrayList<String> eVz;
    private AlphaAnimation euM;
    private boolean euO;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eVA = true;
    private boolean euN = true;
    private boolean eVF = false;
    private boolean eVG = true;
    private com.baidu.tieba.image.a eVH = null;
    private boolean eVI = false;
    private boolean eVJ = false;
    private boolean eVK = true;
    private boolean byr = false;
    private int currentPosition = 0;
    private Runnable eVO = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aOw();
            }
        }
    };
    private a.d bpn = new a.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // com.baidu.tbadk.widget.a.d
        public void PO() {
            ImageViewerActivity.this.eVO.run();
        }

        @Override // com.baidu.tbadk.widget.a.d
        public void PP() {
            ImageViewerActivity.this.finish();
        }
    };
    private f.b bmH = new f.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.coreExtra.view.f.b
        public void JQ() {
            TiebaStatic.log(new ak("c10351").ab("tid", ImageViewerActivity.this.bDf).ab("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private b.InterfaceC0096b eVP = new b.InterfaceC0096b() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu()) {
                switch (i) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eVy.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                            break;
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.bwI);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.bwJ, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                            break;
                        }
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.bQQ == null) {
                            ImageViewerActivity.this.bQQ = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.bQQ.DI();
                        ImageViewerActivity.this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.bQQ.v(pageActivity)) {
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
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean eVR = true;
    private View.OnTouchListener bpx = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eVQ = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eVR = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eVQ) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(ImageViewerActivity.this.eVO);
                        ImageViewerActivity.this.aOw();
                    }
                    ImageViewerActivity.this.eVQ = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(ImageViewerActivity.this.eVO);
                        com.baidu.adp.lib.g.e.ns().postDelayed(ImageViewerActivity.this.eVO, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eVR = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eVS = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(new String[]{ImageViewerActivity.this.getPageContext().getString(d.j.save_to_emotion), ImageViewerActivity.this.getPageContext().getString(d.j.save_to_local)}, ImageViewerActivity.this.eVP);
            ImageViewerActivity.this.showListMenu();
            return true;
        }
    };
    private BaseViewPager.a eVT = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void fZ(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eVD.aOh();
            } else if (ImageViewerActivity.this.aOr() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eVD.aOi();
            }
        }
    };
    private ViewPager.OnPageChangeListener eVU = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eVD != null && i > ImageViewerActivity.this.eVy.getItemNum() - 5) {
                ImageViewerActivity.this.eVD.aOh();
            }
            ImageViewerActivity.this.eVE.e(ImageViewerActivity.this.eVz, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aOs();
            ImageViewerActivity.this.aOx();
            if (ImageViewerActivity.this.eVE.aOy() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eVE.qQ(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aOt()) {
                ImageViewerActivity.this.eVH.aNW();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eVy.getItemNum() - 1) {
                ImageViewerActivity.this.eVF = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.byr = true;
            } else if (i < ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.byr = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eVz != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eVz.size()) {
                ImageViewerActivity.this.eVE.Q(i, (String) ImageViewerActivity.this.eVz.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eVy.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eVR || (!ImageViewerActivity.this.eVF && !ImageViewerActivity.this.aOt() && (ImageViewerActivity.this.eVy.getItemNum() != 1 || !ImageViewerActivity.this.byr))) {
                    ImageViewerActivity.this.eVF = true;
                } else {
                    ImageViewerActivity.this.showToast(d.j.last_page);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eVN = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        initData(bundle);
        aCb();
        this.eVl = d.oe((String) v.f(this.eVz, this.mIndex));
        if (d.og((String) v.f(this.eVz, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eVl, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.eVO, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eVD = new e(this.eVz, this.eVB, this.cZU, this.dNQ, this.bDf, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eVD.setSourceImageRectInScreen(this.eVk);
        this.eVD.im(this.eVA);
        this.eVD.in(z);
        this.eVD.oi(this.eVl);
        this.eVD.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eVL) {
                    if (!z5) {
                        ImageViewerActivity.this.eVy.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(d.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eVL = false;
                ImageViewerActivity.this.eVw.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eVy.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eVy.getItemNum();
                    ImageViewerActivity.this.eVy.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eVy.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eVy.setTempSize(0);
                }
                ImageViewerActivity.this.eVy.setUrlData(arrayList);
                ImageViewerActivity.this.eVy.setAssistUrls(ImageViewerActivity.this.eVB);
                ImageViewerActivity.this.eVy.setHasNext(z3);
                ImageViewerActivity.this.eVy.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eVy.getItemNum()) {
                    ImageViewerActivity.this.eVy.hp(ImageViewerActivity.this.eVy.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eVy.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eVy.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eVy.setUrlData(arrayList);
                    ImageViewerActivity.this.eVy.setCurrentItem(ImageViewerActivity.this.eVy.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                ImageViewerActivity.this.aOs();
                a(arrayList, advertAppInfo);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eVy.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eVH.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eVH.aNS()) {
                    ImageViewerActivity.this.eVy.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eVy.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void P(int i, String str2) {
                ImageViewerActivity.this.eVL = false;
                ImageViewerActivity.this.eVw.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eVz.size();
                    ImageViewerActivity.this.aOs();
                }
            }
        });
        this.eVD.aOh();
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
            this.eVC = new a(this.eVy.getCurrentImageUrl(), this.eVy.getCurrentImageData());
            this.eVC.execute(new String[0]);
            this.eVx.setClickable(false);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eVy.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.eVy.gi(i);
        super.onChangeSkinType(i);
        this.eVN = i;
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eVy.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eVy.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eVy.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.Mx().My();
        this.eVE.e(this.eVz, this.mIndex, this.mIndex);
        this.eVE.aOz();
        this.eVy.onDestroy();
        if (this.eVC != null) {
            this.eVC.cancel();
            this.eVC = null;
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eVO);
        com.baidu.tbadk.download.e.KU().hB(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eVN);
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

    private void aCb() {
        awN();
        initViewPager();
        aOs();
        this.eVE.e(this.eVz, this.mIndex, this.mIndex);
    }

    private void awN() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mTitleView = this.mNavigationBar.setTitleText("");
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
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.cell_image_view_right_layout, (View.OnClickListener) null);
        this.eVw = (ImageButton) addCustomView.findViewById(d.g.see_host_image_txt);
        if (this.eVM) {
            if (this.mIsSeeHost) {
                this.eVw.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.eVw.setImageResource(d.f.icon_topbar_host_white_selector);
            }
            this.eVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.ox()) {
                        ImageViewerActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eVL = true;
                    ImageViewerActivity.this.eVw.setEnabled(false);
                    ImageViewerActivity.this.g(d.oe((String) v.f(ImageViewerActivity.this.eVz, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eVw.setVisibility(8);
        }
        this.eVx = (TextView) addCustomView.findViewById(d.g.save_image_txt);
        this.eVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageViewerActivity.this.mNavigationBar.getVisibility() != 8) {
                    Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                    if (ImageViewerActivity.this.bQQ == null) {
                        ImageViewerActivity.this.bQQ = new com.baidu.tbadk.core.util.b.a();
                    }
                    ImageViewerActivity.this.bQQ.DI();
                    ImageViewerActivity.this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!ImageViewerActivity.this.bQQ.v(pageActivity)) {
                        ImageViewerActivity.this.saveImage();
                    }
                }
            }
        });
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0140d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0140d.cp_cont_g));
        this.eVx.setTextColor(ContextCompat.getColor(this, d.C0140d.cp_cont_g));
        this.mNavigationBar.getBackImageView().setImageResource(d.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aOr() {
        ImageUrlData imageUrlData;
        String str = (String) v.f(this.eVz, this.mIndex);
        if (this.eVB == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eVB.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOs() {
        String str;
        if (this.eVz != null) {
            String str2 = ("" + aOr()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aOt()) {
                aOv();
            } else {
                oj(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOt() {
        return this.eVG && this.eVH != null && this.eVH.aNS() && this.mIndex == this.eVy.getItemNum() + (-1);
    }

    private void oj(String str) {
        this.mTitleView.setText(str);
        if (!this.eVK) {
            this.eVx.setVisibility(8);
        } else {
            this.eVx.setClickable(true);
            this.eVx.setVisibility(0);
        }
        if (this.eVM) {
            this.eVw.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eVw.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.eVw.setImageResource(d.f.icon_topbar_host_white_selector);
            }
        }
    }

    private boolean aOu() {
        if (this.eVz == null) {
            return false;
        }
        Iterator<String> it = this.eVz.iterator();
        while (it.hasNext()) {
            if (d.oh(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aOv() {
        this.mTitleView.setText("");
        this.eVw.setVisibility(8);
        this.eVx.setClickable(false);
        this.eVx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eVy == null) {
            this.eVy = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.eVy.init();
        }
        this.eVy.setIsFromCDN(this.bmF);
        this.eVy.setIsCanDrag(this.bmI);
        this.eVy.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eVy.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eVy.setOnPageChangeListener(this.eVU);
        this.eVy.setUrlData(this.eVz);
        this.eVy.setAssistUrls(this.eVB);
        this.eVy.setOuterOnTouchListener(this.bpx);
        this.eVy.setItemOnclickListener(this.mOnClickListener);
        this.eVy.setItemOnLongClickListener(this.eVS);
        this.eVy.setCurrentItem(aFk(), false);
        this.eVy.setOnScrollOutListener(this.eVT);
        this.eVH = new com.baidu.tieba.image.a(this.bmF, this.eVG, getPageContext(), this.cZU, this.bDf);
        this.eVy.a(this.eVH);
        this.eVy.setOriImgSelectedCallback(this.bmH);
        this.eVy.setDragToExitListener(this.bpn);
    }

    private int aFk() {
        int D = v.D(this.eVz);
        if (D > 0) {
            if (this.mIndex >= D) {
                this.mIndex = D - 1;
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
        this.eVE = new h();
        if (bundle != null) {
            this.eVz = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cZU = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bDf = bundle.getString("tid");
            this.dNQ = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bmF = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eVA = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eVG = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.bmI = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.eVM = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eVk = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eVB = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eVB.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eVz = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cZU = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bDf = intent.getStringExtra("tid");
                this.dNQ = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bmF = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eVA = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eVG = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.bmI = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.eVM = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eVk = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eVB = (Map) serializableExtra;
                }
            }
        }
        this.eVE.b(bundle, getIntent());
        this.mCount = v.D(this.eVz);
        this.eVK = aOu();
        if (this.eVk != null) {
            String str = (String) v.f(this.eVz, this.mIndex);
            if (!StringUtils.isNull(str) && this.eVB != null && (imageUrlData = this.eVB.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eVk);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eVz);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cZU);
        bundle.putString("tid", this.bDf);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dNQ);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eVA);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.bmI);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eVM);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eVG);
        bundle.putString("user_id", this.mUserId);
        if (this.eVB instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eVB.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eVB instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eVB.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eVk);
        this.eVE.A(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eVy.setCurrentItem(this.mIndex, false);
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
            String eu;
            if (this.mUrl != null && ImageViewerActivity.this.eVB != null && ImageViewerActivity.this.eVB.get(this.mUrl) != null) {
                String str = k.BV() + al.CY().en(eu) + "/" + ap.eu(((ImageUrlData) ImageViewerActivity.this.eVB.get(this.mUrl)).originalUrl);
                int[] dO = k.dO(str);
                if (dO != null && dO.length == 2 && dO[0] > 0 && k.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                    return ImageViewerActivity.this.getPageContext().getString(d.j.save_image_to_album);
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (k.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return k.BT();
                    case 0:
                        return ImageViewerActivity.this.getPageContext().getString(d.j.save_image_to_album);
                }
            }
            return ImageViewerActivity.this.getPageContext().getString(d.j.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.eVC = null;
            ImageViewerActivity.this.eVx.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eVC = null;
            ImageViewerActivity.this.eVx.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOw() {
        if (this.euN) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eVy.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eVy.Jl();
                this.eVy.bU(false);
                this.euM = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.euM = new AlphaAnimation(1.0f, 0.0f);
                this.euO = true;
                this.eVy.Jm();
                this.eVy.bU(true);
            }
            this.euM.setDuration(300L);
            this.euM.setFillAfter(false);
            this.euM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.euN = true;
                    if (ImageViewerActivity.this.euO) {
                        ImageViewerActivity.this.euO = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eVy.setSystemUiVisibility(4);
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
            this.euN = false;
            this.mNavigationBar.startAnimation(this.euM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOx() {
        if (aOt()) {
            this.eVJ = this.mNavigationBar.getVisibility() == 0;
            this.eVI = true;
            if (!this.eVJ) {
                aOw();
            }
        } else if (this.eVI) {
            this.mNavigationBar.setVisibility(this.eVJ ? 0 : 8);
            this.eVI = false;
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
            public boolean NM() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NN() {
                return com.baidu.tbadk.pageStayDuration.e.NR().NT();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.cZU, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.bDf, 0L));
        }
        return pageStayDurationItem;
    }
}
