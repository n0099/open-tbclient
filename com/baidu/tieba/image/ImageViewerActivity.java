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
    private String bCS;
    private com.baidu.tbadk.core.util.b.a bQD;
    private boolean bms;
    private boolean bmv;
    private String cZI;
    private String dNE;
    private String eUY;
    private String eUZ;
    private boolean eVA;
    private int eVB;
    private float eVE;
    private ImageButton eVk;
    private TextView eVl;
    private MultiImageView eVm;
    private ArrayList<String> eVn;
    private Map<String, ImageUrlData> eVp;
    private a eVq;
    private e eVr;
    private h eVs;
    private boolean eVz;
    private AlphaAnimation euA;
    private boolean euC;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eVo = true;
    private boolean euB = true;
    private boolean eVt = false;
    private boolean eVu = true;
    private com.baidu.tieba.image.a eVv = null;
    private boolean eVw = false;
    private boolean eVx = false;
    private boolean eVy = true;
    private boolean bye = false;
    private int currentPosition = 0;
    private Runnable eVC = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aOv();
            }
        }
    };
    private a.d bpa = new a.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // com.baidu.tbadk.widget.a.d
        public void PN() {
            ImageViewerActivity.this.eVC.run();
        }

        @Override // com.baidu.tbadk.widget.a.d
        public void PO() {
            ImageViewerActivity.this.finish();
        }
    };
    private f.b bmu = new f.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.coreExtra.view.f.b
        public void JP() {
            TiebaStatic.log(new ak("c10351").ab("tid", ImageViewerActivity.this.bCS).ab("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private b.InterfaceC0097b eVD = new b.InterfaceC0097b() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu()) {
                switch (i) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eVm.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                            break;
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.bwv);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.bww, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                            break;
                        }
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.bQD == null) {
                            ImageViewerActivity.this.bQD = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.bQD.DH();
                        ImageViewerActivity.this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.bQD.v(pageActivity)) {
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
    private boolean eVF = true;
    private View.OnTouchListener bpk = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eVE = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eVF = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eVE) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(ImageViewerActivity.this.eVC);
                        ImageViewerActivity.this.aOv();
                    }
                    ImageViewerActivity.this.eVE = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.ns().removeCallbacks(ImageViewerActivity.this.eVC);
                        com.baidu.adp.lib.g.e.ns().postDelayed(ImageViewerActivity.this.eVC, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eVF = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eVG = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(new String[]{ImageViewerActivity.this.getPageContext().getString(d.j.save_to_emotion), ImageViewerActivity.this.getPageContext().getString(d.j.save_to_local)}, ImageViewerActivity.this.eVD);
            ImageViewerActivity.this.showListMenu();
            return true;
        }
    };
    private BaseViewPager.a eVH = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void fZ(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eVr.aOg();
            } else if (ImageViewerActivity.this.aOq() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eVr.aOh();
            }
        }
    };
    private ViewPager.OnPageChangeListener eVI = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eVr != null && i > ImageViewerActivity.this.eVm.getItemNum() - 5) {
                ImageViewerActivity.this.eVr.aOg();
            }
            ImageViewerActivity.this.eVs.e(ImageViewerActivity.this.eVn, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aOr();
            ImageViewerActivity.this.aOw();
            if (ImageViewerActivity.this.eVs.aOx() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eVs.qR(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aOs()) {
                ImageViewerActivity.this.eVv.aNV();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eVm.getItemNum() - 1) {
                ImageViewerActivity.this.eVt = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.bye = true;
            } else if (i < ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.bye = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eVn != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eVn.size()) {
                ImageViewerActivity.this.eVs.Q(i, (String) ImageViewerActivity.this.eVn.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eVm.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eVF || (!ImageViewerActivity.this.eVt && !ImageViewerActivity.this.aOs() && (ImageViewerActivity.this.eVm.getItemNum() != 1 || !ImageViewerActivity.this.bye))) {
                    ImageViewerActivity.this.eVt = true;
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
        this.eVB = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        initData(bundle);
        aCa();
        this.eUZ = d.oe((String) v.f(this.eVn, this.mIndex));
        if (d.og((String) v.f(this.eVn, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eUZ, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.eVC, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eVr = new e(this.eVn, this.eVp, this.cZI, this.dNE, this.bCS, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eVr.setSourceImageRectInScreen(this.eUY);
        this.eVr.im(this.eVo);
        this.eVr.in(z);
        this.eVr.oi(this.eUZ);
        this.eVr.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eVz) {
                    if (!z5) {
                        ImageViewerActivity.this.eVm.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(d.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eVz = false;
                ImageViewerActivity.this.eVk.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eVm.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eVm.getItemNum();
                    ImageViewerActivity.this.eVm.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eVm.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eVm.setTempSize(0);
                }
                ImageViewerActivity.this.eVm.setUrlData(arrayList);
                ImageViewerActivity.this.eVm.setAssistUrls(ImageViewerActivity.this.eVp);
                ImageViewerActivity.this.eVm.setHasNext(z3);
                ImageViewerActivity.this.eVm.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eVm.getItemNum()) {
                    ImageViewerActivity.this.eVm.hp(ImageViewerActivity.this.eVm.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eVm.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eVm.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eVm.setUrlData(arrayList);
                    ImageViewerActivity.this.eVm.setCurrentItem(ImageViewerActivity.this.eVm.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                ImageViewerActivity.this.aOr();
                a(arrayList, advertAppInfo);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eVm.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eVv.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eVv.aNR()) {
                    ImageViewerActivity.this.eVm.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eVm.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void P(int i, String str2) {
                ImageViewerActivity.this.eVz = false;
                ImageViewerActivity.this.eVk.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eVn.size();
                    ImageViewerActivity.this.aOr();
                }
            }
        });
        this.eVr.aOg();
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
            this.eVq = new a(this.eVm.getCurrentImageUrl(), this.eVm.getCurrentImageData());
            this.eVq.execute(new String[0]);
            this.eVl.setClickable(false);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eVm.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.eVm.gi(i);
        super.onChangeSkinType(i);
        this.eVB = i;
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eVm.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eVm.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eVm.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.Mw().Mx();
        this.eVs.e(this.eVn, this.mIndex, this.mIndex);
        this.eVs.aOy();
        this.eVm.onDestroy();
        if (this.eVq != null) {
            this.eVq.cancel();
            this.eVq = null;
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eVC);
        com.baidu.tbadk.download.e.KT().hB(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eVB);
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

    private void aCa() {
        awM();
        initViewPager();
        aOr();
        this.eVs.e(this.eVn, this.mIndex, this.mIndex);
    }

    private void awM() {
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
        this.eVk = (ImageButton) addCustomView.findViewById(d.g.see_host_image_txt);
        if (this.eVA) {
            if (this.mIsSeeHost) {
                this.eVk.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.eVk.setImageResource(d.f.icon_topbar_host_white_selector);
            }
            this.eVk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.ox()) {
                        ImageViewerActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new ak("pb_onlyowner_click").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).s("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eVz = true;
                    ImageViewerActivity.this.eVk.setEnabled(false);
                    ImageViewerActivity.this.g(d.oe((String) v.f(ImageViewerActivity.this.eVn, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eVk.setVisibility(8);
        }
        this.eVl = (TextView) addCustomView.findViewById(d.g.save_image_txt);
        this.eVl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageViewerActivity.this.mNavigationBar.getVisibility() != 8) {
                    Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                    if (ImageViewerActivity.this.bQD == null) {
                        ImageViewerActivity.this.bQD = new com.baidu.tbadk.core.util.b.a();
                    }
                    ImageViewerActivity.this.bQD.DH();
                    ImageViewerActivity.this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!ImageViewerActivity.this.bQD.v(pageActivity)) {
                        ImageViewerActivity.this.saveImage();
                    }
                }
            }
        });
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0141d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0141d.cp_cont_g));
        this.eVl.setTextColor(ContextCompat.getColor(this, d.C0141d.cp_cont_g));
        this.mNavigationBar.getBackImageView().setImageResource(d.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aOq() {
        ImageUrlData imageUrlData;
        String str = (String) v.f(this.eVn, this.mIndex);
        if (this.eVp == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eVp.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOr() {
        String str;
        if (this.eVn != null) {
            String str2 = ("" + aOq()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aOs()) {
                aOu();
            } else {
                oj(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOs() {
        return this.eVu && this.eVv != null && this.eVv.aNR() && this.mIndex == this.eVm.getItemNum() + (-1);
    }

    private void oj(String str) {
        this.mTitleView.setText(str);
        if (!this.eVy) {
            this.eVl.setVisibility(8);
        } else {
            this.eVl.setClickable(true);
            this.eVl.setVisibility(0);
        }
        if (this.eVA) {
            this.eVk.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eVk.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.eVk.setImageResource(d.f.icon_topbar_host_white_selector);
            }
        }
    }

    private boolean aOt() {
        if (this.eVn == null) {
            return false;
        }
        Iterator<String> it = this.eVn.iterator();
        while (it.hasNext()) {
            if (d.oh(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aOu() {
        this.mTitleView.setText("");
        this.eVk.setVisibility(8);
        this.eVl.setClickable(false);
        this.eVl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eVm == null) {
            this.eVm = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.eVm.init();
        }
        this.eVm.setIsFromCDN(this.bms);
        this.eVm.setIsCanDrag(this.bmv);
        this.eVm.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eVm.aF(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eVm.setOnPageChangeListener(this.eVI);
        this.eVm.setUrlData(this.eVn);
        this.eVm.setAssistUrls(this.eVp);
        this.eVm.setOuterOnTouchListener(this.bpk);
        this.eVm.setItemOnclickListener(this.mOnClickListener);
        this.eVm.setItemOnLongClickListener(this.eVG);
        this.eVm.setCurrentItem(aFj(), false);
        this.eVm.setOnScrollOutListener(this.eVH);
        this.eVv = new com.baidu.tieba.image.a(this.bms, this.eVu, getPageContext(), this.cZI, this.bCS);
        this.eVm.a(this.eVv);
        this.eVm.setOriImgSelectedCallback(this.bmu);
        this.eVm.setDragToExitListener(this.bpa);
    }

    private int aFj() {
        int D = v.D(this.eVn);
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
        this.eVs = new h();
        if (bundle != null) {
            this.eVn = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cZI = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.bCS = bundle.getString("tid");
            this.dNE = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.bms = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eVo = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eVu = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.bmv = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.eVA = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eUY = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eVp = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eVp.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eVn = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cZI = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.bCS = intent.getStringExtra("tid");
                this.dNE = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.bms = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eVo = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eVu = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.bmv = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.eVA = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eUY = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eVp = (Map) serializableExtra;
                }
            }
        }
        this.eVs.b(bundle, getIntent());
        this.mCount = v.D(this.eVn);
        this.eVy = aOt();
        if (this.eUY != null) {
            String str = (String) v.f(this.eVn, this.mIndex);
            if (!StringUtils.isNull(str) && this.eVp != null && (imageUrlData = this.eVp.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eUY);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eVn);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cZI);
        bundle.putString("tid", this.bCS);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dNE);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eVo);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.bmv);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eVA);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eVu);
        bundle.putString("user_id", this.mUserId);
        if (this.eVp instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eVp.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eVp instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eVp.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eUY);
        this.eVs.A(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eVm.setCurrentItem(this.mIndex, false);
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
            if (this.mUrl != null && ImageViewerActivity.this.eVp != null && ImageViewerActivity.this.eVp.get(this.mUrl) != null) {
                String str = k.BU() + al.CX().en(eu) + "/" + ap.eu(((ImageUrlData) ImageViewerActivity.this.eVp.get(this.mUrl)).originalUrl);
                int[] dO = k.dO(str);
                if (dO != null && dO.length == 2 && dO[0] > 0 && k.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                    return ImageViewerActivity.this.getPageContext().getString(d.j.save_image_to_album);
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (k.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return k.BS();
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
            ImageViewerActivity.this.eVq = null;
            ImageViewerActivity.this.eVl.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eVq = null;
            ImageViewerActivity.this.eVl.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOv() {
        if (this.euB) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eVm.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eVm.Jk();
                this.eVm.bU(false);
                this.euA = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.euA = new AlphaAnimation(1.0f, 0.0f);
                this.euC = true;
                this.eVm.Jl();
                this.eVm.bU(true);
            }
            this.euA.setDuration(300L);
            this.euA.setFillAfter(false);
            this.euA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.euB = true;
                    if (ImageViewerActivity.this.euC) {
                        ImageViewerActivity.this.euC = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eVm.setSystemUiVisibility(4);
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
            this.euB = false;
            this.mNavigationBar.startAnimation(this.euA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOw() {
        if (aOs()) {
            this.eVx = this.mNavigationBar.getVisibility() == 0;
            this.eVw = true;
            if (!this.eVx) {
                aOv();
            }
        } else if (this.eVw) {
            this.mNavigationBar.setVisibility(this.eVx ? 0 : 8);
            this.eVw = false;
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
            public boolean NL() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NM() {
                return com.baidu.tbadk.pageStayDuration.e.NQ().NS();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.cZI, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.bCS, 0L));
        }
        return pageStayDurationItem;
    }
}
