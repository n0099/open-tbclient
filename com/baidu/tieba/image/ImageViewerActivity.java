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
import com.baidu.tieba.f;
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
    private boolean aHu;
    private boolean aHx;
    private String aWq;
    private com.baidu.tbadk.core.util.b.a bkZ;
    private String cBR;
    private String dwC;
    private String eJT;
    private String eJU;
    private float eKB;
    private TextView eKf;
    private MultiImageView eKg;
    private ArrayList<String> eKh;
    private Map<String, ImageUrlData> eKj;
    private a eKk;
    private e eKl;
    private h eKm;
    private boolean eKt;
    private boolean eKu;
    private int eKv;
    private boolean eKw;
    private float eKx;
    private com.baidu.tieba.c.d eKy;
    private AlphaAnimation ejs;
    private boolean eju;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eKi = true;
    private boolean ejt = true;
    private boolean eKn = false;
    private boolean eKo = true;
    private com.baidu.tieba.image.a eKp = null;
    private boolean eKq = false;
    private boolean eKr = false;
    private boolean eKs = true;
    private boolean aSc = false;
    private int atP = 0;
    private Runnable eKz = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aPW();
            }
        }
    };
    private DragImageView.d aIU = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Mb() {
            ImageViewerActivity.this.eKz.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Mc() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b aHw = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void Gl() {
            TiebaStatic.log(new an("c10351").ae("tid", ImageViewerActivity.this.aWq).ae("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private b.InterfaceC0101b eKA = new b.InterfaceC0101b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == ImageViewerActivity.this.getListMenu()) {
                switch (i) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eKg.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                            break;
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.aQm);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.aQn, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                            break;
                        }
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.bkZ == null) {
                            ImageViewerActivity.this.bkZ = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.bkZ.zW();
                        ImageViewerActivity.this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.bkZ.u(pageActivity)) {
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
    private boolean eKC = true;
    private View.OnTouchListener aJj = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eKB = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eKC = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eKB) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.in().removeCallbacks(ImageViewerActivity.this.eKz);
                        ImageViewerActivity.this.aPW();
                    }
                    ImageViewerActivity.this.eKB = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.in().removeCallbacks(ImageViewerActivity.this.eKz);
                        com.baidu.adp.lib.g.e.in().postDelayed(ImageViewerActivity.this.eKz, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eKC = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eKD = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ImageViewerActivity.this.createListMenu(new String[]{ImageViewerActivity.this.getPageContext().getString(f.j.save_to_emotion), ImageViewerActivity.this.getPageContext().getString(f.j.save_to_local)}, ImageViewerActivity.this.eKA);
            ImageViewerActivity.this.showListMenu();
            return true;
        }
    };
    private BaseViewPager.a eKE = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void de(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eKl.aPG();
            } else if (ImageViewerActivity.this.aPQ() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eKl.aPH();
            }
        }
    };
    private ViewPager.OnPageChangeListener azU = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eKl != null && i > ImageViewerActivity.this.eKg.getItemNum() - 5) {
                ImageViewerActivity.this.eKl.aPG();
            }
            ImageViewerActivity.this.eKm.d(ImageViewerActivity.this.eKh, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aPR();
            ImageViewerActivity.this.aPX();
            if (ImageViewerActivity.this.eKm.aPY() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eKm.oT(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aPS()) {
                ImageViewerActivity.this.eKp.aPv();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eKg.getItemNum() - 1) {
                ImageViewerActivity.this.eKn = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.atP) {
                ImageViewerActivity.this.atP = i;
                ImageViewerActivity.this.aSc = true;
            } else if (i < ImageViewerActivity.this.atP) {
                ImageViewerActivity.this.atP = i;
                ImageViewerActivity.this.aSc = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eKh != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eKh.size()) {
                ImageViewerActivity.this.eKm.Y(i, (String) ImageViewerActivity.this.eKh.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eKg.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eKC || !ImageViewerActivity.this.eKw || (!ImageViewerActivity.this.eKn && !ImageViewerActivity.this.aPS() && (ImageViewerActivity.this.eKg.getItemNum() != 1 || !ImageViewerActivity.this.aSc))) {
                    ImageViewerActivity.this.eKn = true;
                } else {
                    ImageViewerActivity.this.showToast(f.j.last_page);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eKv = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(f.h.image_activity_2);
        initData(bundle);
        aDa();
        if (com.baidu.tbadk.core.util.g.ye()) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
        this.eJU = d.pe((String) w.d(this.eKh, this.mIndex));
        if (d.pf((String) w.d(this.eKh, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.eJU, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.in().postDelayed(this.eKz, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eKl = new e(this.eKh, this.eKj, this.cBR, this.dwC, this.aWq, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eKl.setSourceImageRectInScreen(this.eJT);
        this.eKl.ij(this.eKi);
        this.eKl.ik(z);
        this.eKl.ph(this.eJU);
        this.eKl.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eKt) {
                    if (!z5) {
                        ImageViewerActivity.this.eKg.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(f.j.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eKt = false;
                ImageViewerActivity.this.eKf.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eKg.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eKg.getItemNum();
                    ImageViewerActivity.this.eKg.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eKg.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eKg.setTempSize(0);
                }
                if (advertAppInfo != null && arrayList != null) {
                    ImageViewerActivity.this.eKp.a(advertAppInfo, arrayList.size());
                }
                ImageViewerActivity.this.eKg.setUrlData(arrayList);
                ImageViewerActivity.this.eKg.setAssistUrls(ImageViewerActivity.this.eKj);
                ImageViewerActivity.this.eKg.setHasNext(z3);
                ImageViewerActivity.this.eKg.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eKg.getItemNum()) {
                    ImageViewerActivity.this.eKg.ew(ImageViewerActivity.this.eKg.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eKg.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eKg.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eKg.setUrlData(arrayList);
                    ImageViewerActivity.this.eKg.setCurrentItem(ImageViewerActivity.this.eKg.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                a(arrayList, advertAppInfo);
                ImageViewerActivity.this.aPR();
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eKg.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eKp.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eKp.aPr()) {
                    ImageViewerActivity.this.eKg.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eKg.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void X(int i, String str2) {
                ImageViewerActivity.this.eKt = false;
                ImageViewerActivity.this.eKf.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eKh.size();
                    ImageViewerActivity.this.aPR();
                }
            }
        });
        this.eKl.aPG();
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
            this.eKk = new a(this.eKg.getCurrentImageUrl(), this.eKg.getCurrentImageData());
            this.eKk.execute(new String[0]);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eKg.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.eKg.dm(i);
        super.onChangeSkinType(i);
        this.eKv = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eKg.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eKg.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eKg.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.IQ().IR();
        this.eKm.d(this.eKh, this.mIndex, this.mIndex);
        this.eKm.aPZ();
        this.eKg.onDestroy();
        if (this.eKk != null) {
            this.eKk.cancel();
            this.eKk = null;
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eKz);
        com.baidu.tbadk.download.d.Hn().eH(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eKv);
        if (this.eKy != null) {
            this.eKy.akO();
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

    private void aDa() {
        this.mStatusBarView = findViewById(f.g.statusbar_view);
        asl();
        initViewPager();
        aPR();
        aPV();
        this.eKm.d(this.eKh, this.mIndex, this.mIndex);
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) findViewById(f.g.navigation_bar);
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
        this.eKf = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(f.g.see_host_image_txt);
        if (this.eKu) {
            if (this.mIsSeeHost) {
                this.eKf.setText(f.j.album_all);
            } else {
                this.eKf.setText(f.j.view_host);
            }
            this.eKf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.js()) {
                        ImageViewerActivity.this.showToast(f.j.neterror);
                        return;
                    }
                    TiebaStatic.log(new an("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eKt = true;
                    ImageViewerActivity.this.eKf.setEnabled(false);
                    ImageViewerActivity.this.g(d.pe((String) w.d(ImageViewerActivity.this.eKh, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eKf.setVisibility(8);
        }
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, f.d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, f.d.cp_cont_i));
        this.mTitleView.setTextSize(0, l.f(this, f.e.ds34));
        this.mNavigationBar.getBackImageView().setImageResource(f.C0146f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aPQ() {
        ImageUrlData imageUrlData;
        String str = (String) w.d(this.eKh, this.mIndex);
        if (this.eKj == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eKj.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPR() {
        String str;
        if (this.eKh != null) {
            String str2 = ("" + aPQ()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aPS()) {
                aPU();
            } else {
                pi(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aPS() {
        if (this.eKo && this.eKp != null && this.eKp.aPr()) {
            return this.eKg.getItemNum() != 1 && this.mIndex == this.eKg.getItemNum() + (-1);
        }
        return false;
    }

    private void pi(String str) {
        this.mTitleView.setText(str);
        if (this.eKu) {
            this.eKf.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eKf.setText(f.j.album_all);
            } else {
                this.eKf.setText(f.j.view_host);
            }
        }
    }

    private boolean aPT() {
        if (this.eKh == null) {
            return false;
        }
        Iterator<String> it = this.eKh.iterator();
        while (it.hasNext()) {
            if (d.pg(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aPU() {
        this.mTitleView.setText("");
        this.eKf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eKg == null) {
            this.eKg = (MultiImageView) findViewById(f.g.viewpager);
        } else {
            this.eKg.init();
        }
        this.eKg.setIsFromCDN(this.aHu);
        this.eKg.setIsCanDrag(this.aHx);
        this.eKg.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eKg.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eKg.setOnPageChangeListener(this.azU);
        this.eKg.setUrlData(this.eKh);
        this.eKg.setAssistUrls(this.eKj);
        this.eKg.setOuterOnTouchListener(this.aJj);
        this.eKg.setItemOnclickListener(this.mOnClickListener);
        this.eKg.setItemOnLongClickListener(this.eKD);
        this.eKg.setCurrentItem(aGI(), false);
        this.eKg.setOnScrollOutListener(this.eKE);
        this.eKp = new com.baidu.tieba.image.a(this.aHu, this.eKo, getPageContext(), this.cBR, this.aWq);
        this.eKg.a(this.eKp);
        this.eKg.setOriImgSelectedCallback(this.aHw);
        this.eKg.setDragToExitListener(this.aIU);
        this.eKg.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.eKw = ImageViewerActivity.this.eKx - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.eKx = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private void aPV() {
        if (this.eKy == null) {
            this.eKy = new com.baidu.tieba.c.d(getPageContext(), this.eKf);
            this.eKy.jo(f.C0146f.pic_sign_tip);
            this.eKy.jn(48);
            this.eKy.C(true);
            this.eKy.jp(2000);
            this.eKy.jr(-l.f(getPageContext().getPageActivity(), f.e.tbds26));
            this.eKy.k(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ImageViewerActivity.this.eKy != null) {
                        ImageViewerActivity.this.eKy.akO();
                    }
                }
            });
        }
        this.eKy.aO(getPageContext().getString(f.j.click_look_all_picture), "key_large_image_tip_count");
    }

    private int aGI() {
        int y = w.y(this.eKh);
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
        this.eKm = new h();
        if (bundle != null) {
            this.eKh = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.cBR = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.aWq = bundle.getString("tid");
            this.dwC = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.aHu = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eKi = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eKo = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.aHx = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.eKu = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.eJT = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eKj = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eKj.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eKh = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.cBR = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.aWq = intent.getStringExtra("tid");
                this.dwC = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.aHu = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eKi = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eKo = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.aHx = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.eKu = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.eJT = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eKj = (Map) serializableExtra;
                }
            }
        }
        this.eKm.b(bundle, getIntent());
        this.mCount = w.y(this.eKh);
        this.eKs = aPT();
        if (this.eJT != null) {
            String str = (String) w.d(this.eKh, this.mIndex);
            if (!StringUtils.isNull(str) && this.eKj != null && (imageUrlData = this.eKj.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.eJT);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eKh);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cBR);
        bundle.putString("tid", this.aWq);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dwC);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eKi);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.aHx);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eKu);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eKo);
        bundle.putString("user_id", this.mUserId);
        if (this.eKj instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eKj.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eKj instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eKj.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.eJT);
        this.eKm.w(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eKg.setCurrentItem(this.mIndex, false);
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
        public String doInBackground(String... strArr) {
            String eM;
            if (this.mUrl != null && ImageViewerActivity.this.eKj != null && ImageViewerActivity.this.eKj.get(this.mUrl) != null) {
                String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + ao.zo().eF(eM) + "/" + as.eM(((ImageUrlData) ImageViewerActivity.this.eKj.get(this.mUrl)).originalUrl);
                int[] eh = com.baidu.tbadk.core.util.l.eh(str);
                if (eh != null && eh.length == 2 && eh[0] > 0 && com.baidu.tbadk.core.util.l.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                    return ImageViewerActivity.this.getPageContext().getString(f.j.save_image_to_album);
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (com.baidu.tbadk.core.util.l.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return com.baidu.tbadk.core.util.l.yh();
                    case 0:
                        return ImageViewerActivity.this.getPageContext().getString(f.j.save_image_to_album);
                }
            }
            return ImageViewerActivity.this.getPageContext().getString(f.j.save_fail);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            ImageViewerActivity.this.showToast(str);
            ImageViewerActivity.this.eKk = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eKk = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPW() {
        if (this.ejt) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eKg.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eKg.FO();
                this.eKg.bs(false);
                this.ejs = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.ejs = new AlphaAnimation(1.0f, 0.0f);
                this.eju = true;
                this.eKg.FP();
                this.eKg.bs(true);
            }
            this.ejs.setDuration(300L);
            this.ejs.setFillAfter(false);
            this.ejs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.ejt = true;
                    if (ImageViewerActivity.this.eju) {
                        ImageViewerActivity.this.eju = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eKg.setSystemUiVisibility(4);
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
            this.ejt = false;
            this.mNavigationBar.startAnimation(this.ejs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPX() {
        if (aPS()) {
            this.eKr = this.mNavigationBar.getVisibility() == 0;
            this.eKq = true;
            if (!this.eKr) {
                aPW();
            }
        } else if (this.eKq) {
            this.mNavigationBar.setVisibility(this.eKr ? 0 : 8);
            this.eKq = false;
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
            public boolean Kl() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Km() {
                return com.baidu.tbadk.pageStayDuration.e.Kq().Ks();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.cBR, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.aWq, 0L));
        }
        return pageStayDurationItem;
    }
}
