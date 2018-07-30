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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
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
    private boolean aHv;
    private boolean aHy;
    private String aWq;
    private com.baidu.tbadk.core.util.b.a bkU;
    private String cBU;
    private String dwF;
    private String eJY;
    private String eJZ;
    private int eKA;
    private boolean eKB;
    private float eKC;
    private com.baidu.tieba.c.d eKD;
    private float eKG;
    private TextView eKk;
    private MultiImageView eKl;
    private ArrayList<String> eKm;
    private Map<String, ImageUrlData> eKo;
    private a eKp;
    private e eKq;
    private h eKr;
    private boolean eKy;
    private boolean eKz;
    private AlphaAnimation ejw;
    private boolean ejy;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eKn = true;
    private boolean ejx = true;
    private boolean eKs = false;
    private boolean eKt = true;
    private com.baidu.tieba.image.a eKu = null;
    private boolean eKv = false;
    private boolean eKw = false;
    private boolean eKx = true;
    private boolean aSc = false;
    private int atO = 0;
    private Runnable eKE = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aPZ();
            }
        }
    };
    private DragImageView.d aIX = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void LX() {
            ImageViewerActivity.this.eKE.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void LY() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b aHx = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void Gl() {
            TiebaStatic.log(new an("c10351").af("tid", ImageViewerActivity.this.aWq).af("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private b.InterfaceC0101b eKF = new b.InterfaceC0101b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu()) {
                switch (i) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eKl.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                            break;
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.aQp);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.aQq, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                            break;
                        }
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.bkU == null) {
                            ImageViewerActivity.this.bkU = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.bkU.zY();
                        ImageViewerActivity.this.bkU.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.bkU.u(pageActivity)) {
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
    private boolean eKH = true;
    private View.OnTouchListener aJm = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eKG = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eKH = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eKG) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.in().removeCallbacks(ImageViewerActivity.this.eKE);
                        ImageViewerActivity.this.aPZ();
                    }
                    ImageViewerActivity.this.eKG = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.in().removeCallbacks(ImageViewerActivity.this.eKE);
                        com.baidu.adp.lib.g.e.in().postDelayed(ImageViewerActivity.this.eKE, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eKH = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eKI = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(new String[]{ImageViewerActivity.this.getPageContext().getString(d.j.save_to_emotion), ImageViewerActivity.this.getPageContext().getString(d.j.save_to_local)}, ImageViewerActivity.this.eKF);
            ImageViewerActivity.this.showListMenu();
            return true;
        }
    };
    private BaseViewPager.a eKJ = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void de(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eKq.aPJ();
            } else if (ImageViewerActivity.this.aPT() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eKq.aPK();
            }
        }
    };
    private ViewPager.OnPageChangeListener azX = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eKq != null && i > ImageViewerActivity.this.eKl.getItemNum() - 5) {
                ImageViewerActivity.this.eKq.aPJ();
            }
            ImageViewerActivity.this.eKr.d(ImageViewerActivity.this.eKm, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aPU();
            ImageViewerActivity.this.aQa();
            if (ImageViewerActivity.this.eKr.aQb() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eKr.oT(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aPV()) {
                ImageViewerActivity.this.eKu.aPy();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eKl.getItemNum() - 1) {
                ImageViewerActivity.this.eKs = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.atO) {
                ImageViewerActivity.this.atO = i;
                ImageViewerActivity.this.aSc = true;
            } else if (i < ImageViewerActivity.this.atO) {
                ImageViewerActivity.this.atO = i;
                ImageViewerActivity.this.aSc = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eKm != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eKm.size()) {
                ImageViewerActivity.this.eKr.Y(i, (String) ImageViewerActivity.this.eKm.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eKl.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eKH || !ImageViewerActivity.this.eKB || (!ImageViewerActivity.this.eKs && !ImageViewerActivity.this.aPV() && (ImageViewerActivity.this.eKl.getItemNum() != 1 || !ImageViewerActivity.this.aSc))) {
                    ImageViewerActivity.this.eKs = true;
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
        this.eKA = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.h.image_activity_2);
        initData(bundle);
        aDd();
        if (com.baidu.tbadk.core.util.g.yf()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.eJZ = d.pc((String) w.d(this.eKm, this.mIndex));
        if (d.pd((String) w.d(this.eKm, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eJZ, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.in().postDelayed(this.eKE, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eKq = new e(this.eKm, this.eKo, this.cBU, this.dwF, this.aWq, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eKq.setSourceImageRectInScreen(this.eJY);
        this.eKq.ij(this.eKn);
        this.eKq.ik(z);
        this.eKq.pf(this.eJZ);
        this.eKq.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eKy) {
                    if (!z5) {
                        ImageViewerActivity.this.eKl.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(d.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eKy = false;
                ImageViewerActivity.this.eKk.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eKl.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eKl.getItemNum();
                    ImageViewerActivity.this.eKl.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eKl.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eKl.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.eKu.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.eKl.setUrlData(arrayList);
                ImageViewerActivity.this.eKl.setAssistUrls(ImageViewerActivity.this.eKo);
                ImageViewerActivity.this.eKl.setHasNext(z3);
                ImageViewerActivity.this.eKl.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eKl.getItemNum()) {
                    ImageViewerActivity.this.eKl.ex(ImageViewerActivity.this.eKl.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eKl.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eKl.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eKl.setUrlData(arrayList);
                    ImageViewerActivity.this.eKl.setCurrentItem(ImageViewerActivity.this.eKl.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                a(arrayList, advertAppInfo);
                ImageViewerActivity.this.aPU();
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eKl.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eKu.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eKu.aPu()) {
                    ImageViewerActivity.this.eKl.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eKl.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void X(int i, String str2) {
                ImageViewerActivity.this.eKy = false;
                ImageViewerActivity.this.eKk.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eKm.size();
                    ImageViewerActivity.this.aPU();
                }
            }
        });
        this.eKq.aPJ();
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
            this.eKp = new a(this.eKl.getCurrentImageUrl(), this.eKl.getCurrentImageData());
            this.eKp.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eKl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.eKl.dn(i);
        super.onChangeSkinType(i);
        this.eKA = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eKl.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eKl.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eKl.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.IQ().IR();
        this.eKr.d(this.eKm, this.mIndex, this.mIndex);
        this.eKr.aQc();
        this.eKl.onDestroy();
        if (this.eKp != null) {
            this.eKp.cancel();
            this.eKp = null;
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eKE);
        com.baidu.tbadk.download.d.Hn().eI(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eKA);
        if (this.eKD != null) {
            this.eKD.akM();
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

    private void aDd() {
        this.mStatusBarView = findViewById(d.g.statusbar_view);
        asl();
        initViewPager();
        aPU();
        aPY();
        this.eKr.d(this.eKm, this.mIndex, this.mIndex);
    }

    private void asl() {
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
        this.eKk = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(d.g.see_host_image_txt);
        if (this.eKz) {
            if (this.mIsSeeHost) {
                this.eKk.setText(d.j.album_all);
            } else {
                this.eKk.setText(d.j.view_host);
            }
            this.eKk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.js()) {
                        ImageViewerActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new an("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eKy = true;
                    ImageViewerActivity.this.eKk.setEnabled(false);
                    ImageViewerActivity.this.g(d.pc((String) w.d(ImageViewerActivity.this.eKm, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eKk.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0140d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0140d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.f(this, d.e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(d.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aPT() {
        ImageUrlData imageUrlData;
        String str = (String) w.d(this.eKm, this.mIndex);
        if (this.eKo == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eKo.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPU() {
        String str;
        if (this.eKm != null) {
            String str2 = ("" + aPT()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aPV()) {
                aPX();
            } else {
                pg(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aPV() {
        if (this.eKt && this.eKu != null && this.eKu.aPu()) {
            return this.eKl.getItemNum() != 1 && this.mIndex == this.eKl.getItemNum() + (-1);
        }
        return false;
    }

    private void pg(String str) {
        this.mTitleView.setText(str);
        if (this.eKz) {
            this.eKk.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eKk.setText(d.j.album_all);
            } else {
                this.eKk.setText(d.j.view_host);
            }
        }
    }

    private boolean aPW() {
        if (this.eKm == null) {
            return false;
        }
        Iterator<String> it = this.eKm.iterator();
        while (it.hasNext()) {
            if (d.pe(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aPX() {
        this.mTitleView.setText("");
        this.eKk.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eKl == null) {
            this.eKl = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.eKl.init();
        }
        this.eKl.setIsFromCDN(this.aHv);
        this.eKl.setIsCanDrag(this.aHy);
        this.eKl.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eKl.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eKl.setOnPageChangeListener(this.azX);
        this.eKl.setUrlData(this.eKm);
        this.eKl.setAssistUrls(this.eKo);
        this.eKl.setOuterOnTouchListener(this.aJm);
        this.eKl.setItemOnclickListener(this.mOnClickListener);
        this.eKl.setItemOnLongClickListener(this.eKI);
        this.eKl.setCurrentItem(aGL(), false);
        this.eKl.setOnScrollOutListener(this.eKJ);
        this.eKu = new com.baidu.tieba.image.a(this.aHv, this.eKt, getPageContext(), this.cBU, this.aWq);
        this.eKl.a(this.eKu);
        this.eKl.setOriImgSelectedCallback(this.aHx);
        this.eKl.setDragToExitListener(this.aIX);
        this.eKl.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.eKB = ImageViewerActivity.this.eKC - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.eKC = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aPY() {
        if (this.eKD == null) {
            this.eKD = new com.baidu.tieba.c.d(getPageContext(), this.eKk);
            this.eKD.jp(d.f.pic_sign_tip);
            this.eKD.jo(48);
            this.eKD.C(true);
            this.eKD.jq(2000);
            this.eKD.js(-l.f(getPageContext().getPageActivity(), d.e.tbds26));
            this.eKD.k(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ImageViewerActivity.this.eKD != null) {
                        ImageViewerActivity.this.eKD.akM();
                    }
                }
            });
        }
        this.eKD.aO(getPageContext().getString(d.j.click_look_all_picture), "key_large_image_tip_count");
    }

    private int aGL() {
        int y = w.y(this.eKm);
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
        this.eKr = new h();
        if (bundle != null) {
            this.eKm = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cBU = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.aWq = bundle.getString("tid");
            this.dwF = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aHv = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eKn = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eKt = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aHy = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.eKz = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eJY = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eKo = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eKo.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eKm = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cBU = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.aWq = intent.getStringExtra("tid");
                this.dwF = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aHv = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eKn = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eKt = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aHy = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.eKz = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eJY = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eKo = (Map) serializableExtra;
                }
            }
        }
        this.eKr.b(bundle, getIntent());
        this.mCount = w.y(this.eKm);
        this.eKx = aPW();
        if (this.eJY != null) {
            String str = (String) w.d(this.eKm, this.mIndex);
            if (!StringUtils.isNull(str) && this.eKo != null && (imageUrlData = this.eKo.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eJY);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eKm);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cBU);
        bundle.putString("tid", this.aWq);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dwF);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eKn);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aHy);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eKz);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eKt);
        bundle.putString("user_id", this.mUserId);
        if (this.eKo instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eKo.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eKo instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eKo.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eJY);
        this.eKr.w(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eKl.setCurrentItem(this.mIndex, false);
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
            String eM;
            if (this.mUrl != null && ImageViewerActivity.this.eKo != null && ImageViewerActivity.this.eKo.get(this.mUrl) != null) {
                String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ao.zq().eF(eM) + "/" + as.eM(((ImageUrlData) ImageViewerActivity.this.eKo.get(this.mUrl)).originalUrl);
                int[] eh = com.baidu.tbadk.core.util.l.eh(str);
                if (eh != null && eh.length == 2 && eh[0] > 0 && com.baidu.tbadk.core.util.l.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                    return ImageViewerActivity.this.getPageContext().getString(d.j.save_image_to_album);
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return com.baidu.tbadk.core.util.l.yi();
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
            ImageViewerActivity.this.eKp = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eKp = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPZ() {
        if (this.ejx) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eKl.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eKl.FO();
                this.eKl.br(false);
                this.ejw = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.ejw = new AlphaAnimation(1.0f, 0.0f);
                this.ejy = true;
                this.eKl.FP();
                this.eKl.br(true);
            }
            this.ejw.setDuration(300L);
            this.ejw.setFillAfter(false);
            this.ejw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.ejx = true;
                    if (ImageViewerActivity.this.ejy) {
                        ImageViewerActivity.this.ejy = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eKl.setSystemUiVisibility(4);
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
            this.ejx = false;
            this.mNavigationBar.startAnimation(this.ejw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQa() {
        if (aPV()) {
            this.eKw = this.mNavigationBar.getVisibility() == 0;
            this.eKv = true;
            if (!this.eKw) {
                aPZ();
            }
        } else if (this.eKv) {
            this.mNavigationBar.setVisibility(this.eKw ? 0 : 8);
            this.eKv = false;
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
            public boolean Kh() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Ki() {
                return com.baidu.tbadk.pageStayDuration.e.Km().Ko();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.cBU, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.aWq, 0L));
        }
        return pageStayDurationItem;
    }
}
