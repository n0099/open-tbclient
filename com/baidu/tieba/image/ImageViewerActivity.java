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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
    private boolean aGD;
    private boolean aGG;
    private String aVt;
    private com.baidu.tbadk.core.util.b.a biP;
    private String cBu;
    private String dqJ;
    private TextView eCA;
    private MultiImageView eCB;
    private ArrayList<String> eCC;
    private Map<String, ImageUrlData> eCE;
    private a eCF;
    private e eCG;
    private h eCH;
    private boolean eCO;
    private boolean eCP;
    private int eCQ;
    private boolean eCR;
    private float eCS;
    private com.baidu.tieba.c.d eCT;
    private float eCW;
    private String eCo;
    private String eCp;
    private AlphaAnimation ebM;
    private boolean ebO;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eCD = true;
    private boolean ebN = true;
    private boolean eCI = false;
    private boolean eCJ = true;
    private com.baidu.tieba.image.a eCK = null;
    private boolean eCL = false;
    private boolean eCM = false;
    private boolean eCN = true;
    private boolean aRg = false;
    private int currentPosition = 0;
    private Runnable eCU = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aOt();
            }
        }
    };
    private DragImageView.d aHY = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void LJ() {
            ImageViewerActivity.this.eCU.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void LK() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b aGF = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void FX() {
            TiebaStatic.log(new am("c10351").ah("tid", ImageViewerActivity.this.aVt).ah("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private b.InterfaceC0103b eCV = new b.InterfaceC0103b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu()) {
                switch (i) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eCB.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                            break;
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.aPt);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.aPu, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                            break;
                        }
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.biP == null) {
                            ImageViewerActivity.this.biP = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.biP.zU();
                        ImageViewerActivity.this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.biP.u(pageActivity)) {
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
        public void onClick(View view) {
            ImageViewerActivity.this.finish();
        }
    };
    private boolean eCX = true;
    private View.OnTouchListener aIi = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eCW = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eCX = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eCW) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.im().removeCallbacks(ImageViewerActivity.this.eCU);
                        ImageViewerActivity.this.aOt();
                    }
                    ImageViewerActivity.this.eCW = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.im().removeCallbacks(ImageViewerActivity.this.eCU);
                        com.baidu.adp.lib.g.e.im().postDelayed(ImageViewerActivity.this.eCU, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eCX = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eCY = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(new String[]{ImageViewerActivity.this.getPageContext().getString(d.k.save_to_emotion), ImageViewerActivity.this.getPageContext().getString(d.k.save_to_local)}, ImageViewerActivity.this.eCV);
            ImageViewerActivity.this.showListMenu();
            return true;
        }
    };
    private BaseViewPager.a eCZ = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void db(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eCG.aOd();
            } else if (ImageViewerActivity.this.aOn() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eCG.aOe();
            }
        }
    };
    private ViewPager.OnPageChangeListener azm = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eCG != null && i > ImageViewerActivity.this.eCB.getItemNum() - 5) {
                ImageViewerActivity.this.eCG.aOd();
            }
            ImageViewerActivity.this.eCH.d(ImageViewerActivity.this.eCC, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aOo();
            ImageViewerActivity.this.aOu();
            if (ImageViewerActivity.this.eCH.aOv() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eCH.ox(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aOp()) {
                ImageViewerActivity.this.eCK.aNS();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eCB.getItemNum() - 1) {
                ImageViewerActivity.this.eCI = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.aRg = true;
            } else if (i < ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.aRg = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eCC != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eCC.size()) {
                ImageViewerActivity.this.eCH.Z(i, (String) ImageViewerActivity.this.eCC.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eCB.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eCX || !ImageViewerActivity.this.eCR || (!ImageViewerActivity.this.eCI && !ImageViewerActivity.this.aOp() && (ImageViewerActivity.this.eCB.getItemNum() != 1 || !ImageViewerActivity.this.aRg))) {
                    ImageViewerActivity.this.eCI = true;
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
        this.eCQ = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.image_activity_2);
        initData(bundle);
        aBO();
        if (com.baidu.tbadk.core.util.g.ya()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.eCp = d.oZ((String) w.c(this.eCC, this.mIndex));
        if (d.pa((String) w.c(this.eCC, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eCp, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.im().postDelayed(this.eCU, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eCG = new e(this.eCC, this.eCE, this.cBu, this.dqJ, this.aVt, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eCG.setSourceImageRectInScreen(this.eCo);
        this.eCG.hW(this.eCD);
        this.eCG.hX(z);
        this.eCG.pc(this.eCp);
        this.eCG.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eCO) {
                    if (!z5) {
                        ImageViewerActivity.this.eCB.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(d.k.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eCO = false;
                ImageViewerActivity.this.eCA.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eCB.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eCB.getItemNum();
                    ImageViewerActivity.this.eCB.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eCB.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eCB.setTempSize(0);
                }
                ImageViewerActivity.this.eCB.setUrlData(arrayList);
                ImageViewerActivity.this.eCB.setAssistUrls(ImageViewerActivity.this.eCE);
                ImageViewerActivity.this.eCB.setHasNext(z3);
                ImageViewerActivity.this.eCB.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eCB.getItemNum()) {
                    ImageViewerActivity.this.eCB.et(ImageViewerActivity.this.eCB.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eCB.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eCB.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eCB.setUrlData(arrayList);
                    ImageViewerActivity.this.eCB.setCurrentItem(ImageViewerActivity.this.eCB.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                ImageViewerActivity.this.aOo();
                a(arrayList, advertAppInfo);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eCB.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eCK.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eCK.aNO()) {
                    ImageViewerActivity.this.eCB.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eCB.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void Y(int i, String str2) {
                ImageViewerActivity.this.eCO = false;
                ImageViewerActivity.this.eCA.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eCC.size();
                    ImageViewerActivity.this.aOo();
                }
            }
        });
        this.eCG.aOd();
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
            this.eCF = new a(this.eCB.getCurrentImageUrl(), this.eCB.getCurrentImageData());
            this.eCF.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eCB.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.eCB.dk(i);
        super.onChangeSkinType(i);
        this.eCQ = i;
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eCB.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eCB.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eCB.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.ID().IE();
        this.eCH.d(this.eCC, this.mIndex, this.mIndex);
        this.eCH.aOw();
        this.eCB.onDestroy();
        if (this.eCF != null) {
            this.eCF.cancel();
            this.eCF = null;
        }
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eCU);
        com.baidu.tbadk.download.e.GZ().eE(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eCQ);
        if (this.eCT != null) {
            this.eCT.akT();
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

    private void aBO() {
        this.mStatusBarView = findViewById(d.g.statusbar_view);
        avi();
        initViewPager();
        aOo();
        aOs();
        this.eCH.d(this.eCC, this.mIndex, this.mIndex);
    }

    private void avi() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
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
        this.eCA = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(d.g.see_host_image_txt);
        if (this.eCP) {
            if (this.mIsSeeHost) {
                this.eCA.setText(d.k.album_all);
            } else {
                this.eCA.setText(d.k.view_host);
            }
            this.eCA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.jr()) {
                        ImageViewerActivity.this.showToast(d.k.neterror);
                        return;
                    }
                    TiebaStatic.log(new am("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eCO = true;
                    ImageViewerActivity.this.eCA.setEnabled(false);
                    ImageViewerActivity.this.g(d.oZ((String) w.c(ImageViewerActivity.this.eCC, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eCA.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0141d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0141d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.e(this, d.e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(d.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aOn() {
        ImageUrlData imageUrlData;
        String str = (String) w.c(this.eCC, this.mIndex);
        if (this.eCE == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eCE.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOo() {
        String str;
        if (this.eCC != null) {
            String str2 = ("" + aOn()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aOp()) {
                aOr();
            } else {
                pd(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOp() {
        return this.eCJ && this.eCK != null && this.eCK.aNO() && this.mIndex == this.eCB.getItemNum() + (-1);
    }

    private void pd(String str) {
        this.mTitleView.setText(str);
        if (this.eCP) {
            this.eCA.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eCA.setText(d.k.album_all);
            } else {
                this.eCA.setText(d.k.view_host);
            }
        }
    }

    private boolean aOq() {
        if (this.eCC == null) {
            return false;
        }
        Iterator<String> it = this.eCC.iterator();
        while (it.hasNext()) {
            if (d.pb(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aOr() {
        this.mTitleView.setText("");
        this.eCA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eCB == null) {
            this.eCB = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.eCB.init();
        }
        this.eCB.setIsFromCDN(this.aGD);
        this.eCB.setIsCanDrag(this.aGG);
        this.eCB.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eCB.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eCB.setOnPageChangeListener(this.azm);
        this.eCB.setUrlData(this.eCC);
        this.eCB.setAssistUrls(this.eCE);
        this.eCB.setOuterOnTouchListener(this.aIi);
        this.eCB.setItemOnclickListener(this.mOnClickListener);
        this.eCB.setItemOnLongClickListener(this.eCY);
        this.eCB.setCurrentItem(aFd(), false);
        this.eCB.setOnScrollOutListener(this.eCZ);
        this.eCK = new com.baidu.tieba.image.a(this.aGD, this.eCJ, getPageContext(), this.cBu, this.aVt);
        this.eCB.a(this.eCK);
        this.eCB.setOriImgSelectedCallback(this.aGF);
        this.eCB.setDragToExitListener(this.aHY);
        this.eCB.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.eCR = ImageViewerActivity.this.eCS - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.eCS = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aOs() {
        if (this.eCT == null) {
            this.eCT = new com.baidu.tieba.c.d(getPageContext(), this.eCA);
            this.eCT.jf(d.f.pic_sign_tip);
            this.eCT.je(48);
            this.eCT.D(true);
            this.eCT.jg(2000);
            this.eCT.ji(-l.e(getPageContext().getPageActivity(), d.e.tbds26));
            this.eCT.j(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ImageViewerActivity.this.eCT != null) {
                        ImageViewerActivity.this.eCT.akT();
                    }
                }
            });
        }
        this.eCT.aQ(getPageContext().getString(d.k.click_look_all_picture), "key_large_image_tip_count");
    }

    private int aFd() {
        int y = w.y(this.eCC);
        if (y > 0) {
            if (this.mIndex >= y) {
                this.mIndex = y - 1;
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
        this.eCH = new h();
        if (bundle != null) {
            this.eCC = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cBu = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.aVt = bundle.getString("tid");
            this.dqJ = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aGD = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eCD = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eCJ = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aGG = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.eCP = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eCo = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eCE = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eCE.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eCC = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cBu = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.aVt = intent.getStringExtra("tid");
                this.dqJ = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aGD = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eCD = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eCJ = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aGG = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.eCP = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eCo = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eCE = (Map) serializableExtra;
                }
            }
        }
        this.eCH.b(bundle, getIntent());
        this.mCount = w.y(this.eCC);
        this.eCN = aOq();
        if (this.eCo != null) {
            String str = (String) w.c(this.eCC, this.mIndex);
            if (!StringUtils.isNull(str) && this.eCE != null && (imageUrlData = this.eCE.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eCo);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eCC);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cBu);
        bundle.putString("tid", this.aVt);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dqJ);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eCD);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aGG);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eCP);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eCJ);
        bundle.putString("user_id", this.mUserId);
        if (this.eCE instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eCE.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eCE instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eCE.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eCo);
        this.eCH.w(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eCB.setCurrentItem(this.mIndex, false);
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
            String eL;
            if (this.mUrl != null && ImageViewerActivity.this.eCE != null && ImageViewerActivity.this.eCE.get(this.mUrl) != null) {
                String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + an.zk().eE(eL) + "/" + ar.eL(((ImageUrlData) ImageViewerActivity.this.eCE.get(this.mUrl)).originalUrl);
                int[] eg = com.baidu.tbadk.core.util.l.eg(str);
                if (eg != null && eg.length == 2 && eg[0] > 0 && com.baidu.tbadk.core.util.l.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                    return ImageViewerActivity.this.getPageContext().getString(d.k.save_image_to_album);
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return com.baidu.tbadk.core.util.l.yc();
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
            ImageViewerActivity.this.eCF = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eCF = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOt() {
        if (this.ebN) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eCB.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eCB.FA();
                this.eCB.bq(false);
                this.ebM = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.ebM = new AlphaAnimation(1.0f, 0.0f);
                this.ebO = true;
                this.eCB.FB();
                this.eCB.bq(true);
            }
            this.ebM.setDuration(300L);
            this.ebM.setFillAfter(false);
            this.ebM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.ebN = true;
                    if (ImageViewerActivity.this.ebO) {
                        ImageViewerActivity.this.ebO = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eCB.setSystemUiVisibility(4);
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
            this.ebN = false;
            this.mNavigationBar.startAnimation(this.ebM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOu() {
        if (aOp()) {
            this.eCM = this.mNavigationBar.getVisibility() == 0;
            this.eCL = true;
            if (!this.eCM) {
                aOt();
            }
        } else if (this.eCL) {
            this.mNavigationBar.setVisibility(this.eCM ? 0 : 8);
            this.eCL = false;
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
            public boolean JU() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int JV() {
                return com.baidu.tbadk.pageStayDuration.e.JZ().Kb();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.cBu, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.aVt, 0L));
        }
        return pageStayDurationItem;
    }
}
