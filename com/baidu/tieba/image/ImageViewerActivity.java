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
    private String bCV;
    private com.baidu.tbadk.core.util.b.a bQG;
    private boolean bmv;
    private boolean bmy;
    private String cZL;
    private String dNJ;
    private MultiImageView eVA;
    private ArrayList<String> eVB;
    private Map<String, ImageUrlData> eVD;
    private a eVE;
    private e eVF;
    private h eVG;
    private boolean eVN;
    private boolean eVO;
    private int eVP;
    private float eVS;
    private String eVm;
    private String eVn;
    private ImageButton eVy;
    private TextView eVz;
    private AlphaAnimation euQ;
    private boolean euS;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eVC = true;
    private boolean euR = true;
    private boolean eVH = false;
    private boolean eVI = true;
    private com.baidu.tieba.image.a eVJ = null;
    private boolean eVK = false;
    private boolean eVL = false;
    private boolean eVM = true;
    private boolean byh = false;
    private int currentPosition = 0;
    private Runnable eVQ = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aOw();
            }
        }
    };
    private a.d bpd = new a.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // com.baidu.tbadk.widget.a.d
        public void PO() {
            ImageViewerActivity.this.eVQ.run();
        }

        @Override // com.baidu.tbadk.widget.a.d
        public void PP() {
            ImageViewerActivity.this.finish();
        }
    };
    private f.b bmx = new f.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.coreExtra.view.f.b
        public void JQ() {
            TiebaStatic.log(new ak("c10351").ab("tid", ImageViewerActivity.this.bCV).ab("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private b.InterfaceC0097b eVR = new b.InterfaceC0097b() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu()) {
                switch (i) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eVA.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                            break;
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.bwy);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.bwz, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                            break;
                        }
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.bQG == null) {
                            ImageViewerActivity.this.bQG = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.bQG.DI();
                        ImageViewerActivity.this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.bQG.v(pageActivity)) {
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
    private boolean eVT = true;
    private View.OnTouchListener bpn = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eVS = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eVT = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eVS) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(ImageViewerActivity.this.eVQ);
                        ImageViewerActivity.this.aOw();
                    }
                    ImageViewerActivity.this.eVS = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(ImageViewerActivity.this.eVQ);
                        com.baidu.adp.lib.g.e.ns().postDelayed(ImageViewerActivity.this.eVQ, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eVT = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eVU = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(new String[]{ImageViewerActivity.this.getPageContext().getString(d.j.save_to_emotion), ImageViewerActivity.this.getPageContext().getString(d.j.save_to_local)}, ImageViewerActivity.this.eVR);
            ImageViewerActivity.this.showListMenu();
            return true;
        }
    };
    private BaseViewPager.a eVV = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void fZ(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eVF.aOh();
            } else if (ImageViewerActivity.this.aOr() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eVF.aOi();
            }
        }
    };
    private ViewPager.OnPageChangeListener eVW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eVF != null && i > ImageViewerActivity.this.eVA.getItemNum() - 5) {
                ImageViewerActivity.this.eVF.aOh();
            }
            ImageViewerActivity.this.eVG.e(ImageViewerActivity.this.eVB, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aOs();
            ImageViewerActivity.this.aOx();
            if (ImageViewerActivity.this.eVG.aOy() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eVG.qR(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aOt()) {
                ImageViewerActivity.this.eVJ.aNW();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eVA.getItemNum() - 1) {
                ImageViewerActivity.this.eVH = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.byh = true;
            } else if (i < ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.byh = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eVB != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eVB.size()) {
                ImageViewerActivity.this.eVG.Q(i, (String) ImageViewerActivity.this.eVB.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eVA.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eVT || (!ImageViewerActivity.this.eVH && !ImageViewerActivity.this.aOt() && (ImageViewerActivity.this.eVA.getItemNum() != 1 || !ImageViewerActivity.this.byh))) {
                    ImageViewerActivity.this.eVH = true;
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
        this.eVP = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        initData(bundle);
        aCb();
        this.eVn = d.oe((String) v.f(this.eVB, this.mIndex));
        if (d.og((String) v.f(this.eVB, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eVn, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.eVQ, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eVF = new e(this.eVB, this.eVD, this.cZL, this.dNJ, this.bCV, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eVF.setSourceImageRectInScreen(this.eVm);
        this.eVF.ir(this.eVC);
        this.eVF.is(z);
        this.eVF.oi(this.eVn);
        this.eVF.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eVN) {
                    if (!z5) {
                        ImageViewerActivity.this.eVA.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(d.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eVN = false;
                ImageViewerActivity.this.eVy.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eVA.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eVA.getItemNum();
                    ImageViewerActivity.this.eVA.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eVA.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eVA.setTempSize(0);
                }
                ImageViewerActivity.this.eVA.setUrlData(arrayList);
                ImageViewerActivity.this.eVA.setAssistUrls(ImageViewerActivity.this.eVD);
                ImageViewerActivity.this.eVA.setHasNext(z3);
                ImageViewerActivity.this.eVA.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eVA.getItemNum()) {
                    ImageViewerActivity.this.eVA.hp(ImageViewerActivity.this.eVA.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eVA.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eVA.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eVA.setUrlData(arrayList);
                    ImageViewerActivity.this.eVA.setCurrentItem(ImageViewerActivity.this.eVA.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                ImageViewerActivity.this.aOs();
                a(arrayList, advertAppInfo);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eVA.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eVJ.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eVJ.aNS()) {
                    ImageViewerActivity.this.eVA.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eVA.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void P(int i, String str2) {
                ImageViewerActivity.this.eVN = false;
                ImageViewerActivity.this.eVy.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eVB.size();
                    ImageViewerActivity.this.aOs();
                }
            }
        });
        this.eVF.aOh();
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
            this.eVE = new a(this.eVA.getCurrentImageUrl(), this.eVA.getCurrentImageData());
            this.eVE.execute(new String[0]);
            this.eVz.setClickable(false);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eVA.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.eVA.gi(i);
        super.onChangeSkinType(i);
        this.eVP = i;
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eVA.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eVA.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eVA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.Mx().My();
        this.eVG.e(this.eVB, this.mIndex, this.mIndex);
        this.eVG.aOz();
        this.eVA.onDestroy();
        if (this.eVE != null) {
            this.eVE.cancel();
            this.eVE = null;
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eVQ);
        com.baidu.tbadk.download.e.KU().hB(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eVP);
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
        awO();
        initViewPager();
        aOs();
        this.eVG.e(this.eVB, this.mIndex, this.mIndex);
    }

    private void awO() {
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
        this.eVy = (ImageButton) addCustomView.findViewById(d.g.see_host_image_txt);
        if (this.eVO) {
            if (this.mIsSeeHost) {
                this.eVy.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.eVy.setImageResource(d.f.icon_topbar_host_white_selector);
            }
            this.eVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.ox()) {
                        ImageViewerActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eVN = true;
                    ImageViewerActivity.this.eVy.setEnabled(false);
                    ImageViewerActivity.this.g(d.oe((String) v.f(ImageViewerActivity.this.eVB, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eVy.setVisibility(8);
        }
        this.eVz = (TextView) addCustomView.findViewById(d.g.save_image_txt);
        this.eVz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageViewerActivity.this.mNavigationBar.getVisibility() != 8) {
                    Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                    if (ImageViewerActivity.this.bQG == null) {
                        ImageViewerActivity.this.bQG = new com.baidu.tbadk.core.util.b.a();
                    }
                    ImageViewerActivity.this.bQG.DI();
                    ImageViewerActivity.this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!ImageViewerActivity.this.bQG.v(pageActivity)) {
                        ImageViewerActivity.this.saveImage();
                    }
                }
            }
        });
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0141d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0141d.cp_cont_g));
        this.eVz.setTextColor(ContextCompat.getColor(this, d.C0141d.cp_cont_g));
        this.mNavigationBar.getBackImageView().setImageResource(d.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aOr() {
        ImageUrlData imageUrlData;
        String str = (String) v.f(this.eVB, this.mIndex);
        if (this.eVD == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eVD.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOs() {
        String str;
        if (this.eVB != null) {
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
        return this.eVI && this.eVJ != null && this.eVJ.aNS() && this.mIndex == this.eVA.getItemNum() + (-1);
    }

    private void oj(String str) {
        this.mTitleView.setText(str);
        if (!this.eVM) {
            this.eVz.setVisibility(8);
        } else {
            this.eVz.setClickable(true);
            this.eVz.setVisibility(0);
        }
        if (this.eVO) {
            this.eVy.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eVy.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.eVy.setImageResource(d.f.icon_topbar_host_white_selector);
            }
        }
    }

    private boolean aOu() {
        if (this.eVB == null) {
            return false;
        }
        Iterator<String> it = this.eVB.iterator();
        while (it.hasNext()) {
            if (d.oh(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aOv() {
        this.mTitleView.setText("");
        this.eVy.setVisibility(8);
        this.eVz.setClickable(false);
        this.eVz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eVA == null) {
            this.eVA = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.eVA.init();
        }
        this.eVA.setIsFromCDN(this.bmv);
        this.eVA.setIsCanDrag(this.bmy);
        this.eVA.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eVA.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eVA.setOnPageChangeListener(this.eVW);
        this.eVA.setUrlData(this.eVB);
        this.eVA.setAssistUrls(this.eVD);
        this.eVA.setOuterOnTouchListener(this.bpn);
        this.eVA.setItemOnclickListener(this.mOnClickListener);
        this.eVA.setItemOnLongClickListener(this.eVU);
        this.eVA.setCurrentItem(aFk(), false);
        this.eVA.setOnScrollOutListener(this.eVV);
        this.eVJ = new com.baidu.tieba.image.a(this.bmv, this.eVI, getPageContext(), this.cZL, this.bCV);
        this.eVA.a(this.eVJ);
        this.eVA.setOriImgSelectedCallback(this.bmx);
        this.eVA.setDragToExitListener(this.bpd);
    }

    private int aFk() {
        int D = v.D(this.eVB);
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
        this.eVG = new h();
        if (bundle != null) {
            this.eVB = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cZL = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bCV = bundle.getString("tid");
            this.dNJ = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bmv = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eVC = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eVI = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.bmy = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.eVO = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eVm = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eVD = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eVD.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eVB = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cZL = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bCV = intent.getStringExtra("tid");
                this.dNJ = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bmv = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eVC = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eVI = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.bmy = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.eVO = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eVm = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eVD = (Map) serializableExtra;
                }
            }
        }
        this.eVG.b(bundle, getIntent());
        this.mCount = v.D(this.eVB);
        this.eVM = aOu();
        if (this.eVm != null) {
            String str = (String) v.f(this.eVB, this.mIndex);
            if (!StringUtils.isNull(str) && this.eVD != null && (imageUrlData = this.eVD.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eVm);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eVB);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cZL);
        bundle.putString("tid", this.bCV);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dNJ);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eVC);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.bmy);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eVO);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eVI);
        bundle.putString("user_id", this.mUserId);
        if (this.eVD instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eVD.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eVD instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eVD.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eVm);
        this.eVG.A(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eVA.setCurrentItem(this.mIndex, false);
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
            if (this.mUrl != null && ImageViewerActivity.this.eVD != null && ImageViewerActivity.this.eVD.get(this.mUrl) != null) {
                String str = k.BV() + al.CY().en(eu) + "/" + ap.eu(((ImageUrlData) ImageViewerActivity.this.eVD.get(this.mUrl)).originalUrl);
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
            ImageViewerActivity.this.eVE = null;
            ImageViewerActivity.this.eVz.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eVE = null;
            ImageViewerActivity.this.eVz.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOw() {
        if (this.euR) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eVA.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eVA.Jl();
                this.eVA.bU(false);
                this.euQ = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.euQ = new AlphaAnimation(1.0f, 0.0f);
                this.euS = true;
                this.eVA.Jm();
                this.eVA.bU(true);
            }
            this.euQ.setDuration(300L);
            this.euQ.setFillAfter(false);
            this.euQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.euR = true;
                    if (ImageViewerActivity.this.euS) {
                        ImageViewerActivity.this.euS = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eVA.setSystemUiVisibility(4);
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
            this.euR = false;
            this.mNavigationBar.startAnimation(this.euQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOx() {
        if (aOt()) {
            this.eVL = this.mNavigationBar.getVisibility() == 0;
            this.eVK = true;
            if (!this.eVL) {
                aOw();
            }
        } else if (this.eVK) {
            this.mNavigationBar.setVisibility(this.eVL ? 0 : 8);
            this.eVK = false;
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
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.cZL, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.bCV, 0L));
        }
        return pageStayDurationItem;
    }
}
