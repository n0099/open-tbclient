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
    private String aNu;
    private boolean ayh;
    private boolean ayk;
    private com.baidu.tbadk.core.util.b.a baD;
    private String crG;
    private AlphaAnimation dPt;
    private boolean dPv;
    private String dgn;
    private String epP;
    private String epQ;
    private ImageButton eqb;
    private TextView eqc;
    private MultiImageView eqd;
    private ArrayList<String> eqe;
    private Map<String, ImageUrlData> eqg;
    private a eqh;
    private e eqi;
    private h eqj;
    private boolean eqq;
    private boolean eqr;
    private int eqs;
    private boolean eqt;
    private float equ;
    private float eqx;
    private String mFrom;
    private boolean mIsSeeHost;
    private NavigationBar mNavigationBar;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean eqf = true;
    private boolean dPu = true;
    private boolean eqk = false;
    private boolean eql = true;
    private com.baidu.tieba.image.a eqm = null;
    private boolean eqn = false;
    private boolean eqo = false;
    private boolean eqp = true;
    private boolean aIE = false;
    private int currentPosition = 0;
    private Runnable eqv = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mNavigationBar != null && ImageViewerActivity.this.mNavigationBar.getVisibility() == 0) {
                ImageViewerActivity.this.aJy();
            }
        }
    };
    private DragImageView.d azC = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Ip() {
            ImageViewerActivity.this.eqv.run();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void Iq() {
            ImageViewerActivity.this.finish();
        }
    };
    private UrlDragImageView.b ayj = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void Cw() {
            TiebaStatic.log(new al("c10351").ac("tid", ImageViewerActivity.this.aNu).ac("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private b.InterfaceC0086b eqw = new b.InterfaceC0086b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
            if (bVar == ImageViewerActivity.this.getListMenu()) {
                switch (i) {
                    case 0:
                        String currentImageUrl = ImageViewerActivity.this.eqd.getCurrentImageUrl();
                        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                            break;
                        } else {
                            Intent intent = new Intent(com.baidu.tbadk.imageManager.d.aGV);
                            intent.putExtra(com.baidu.tbadk.imageManager.d.aGW, currentImageUrl);
                            TbadkCoreApplication.getInst().sendBroadcast(intent);
                            break;
                        }
                    case 1:
                        Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                        if (ImageViewerActivity.this.baD == null) {
                            ImageViewerActivity.this.baD = new com.baidu.tbadk.core.util.b.a();
                        }
                        ImageViewerActivity.this.baD.wu();
                        ImageViewerActivity.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!ImageViewerActivity.this.baD.v(pageActivity)) {
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
    private boolean eqy = true;
    private View.OnTouchListener azM = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            switch (action) {
                case 0:
                    ImageViewerActivity.this.eqx = motionEvent.getX();
                    if (view2 instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eqy = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    if (Math.abs(motionEvent.getX() - ImageViewerActivity.this.eqx) > 0.0f && ImageViewerActivity.this.mNavigationBar.getVisibility() != 0) {
                        com.baidu.adp.lib.g.e.fw().removeCallbacks(ImageViewerActivity.this.eqv);
                        ImageViewerActivity.this.aJy();
                    }
                    ImageViewerActivity.this.eqx = motionEvent.getX();
                    if (action != 2) {
                        com.baidu.adp.lib.g.e.fw().removeCallbacks(ImageViewerActivity.this.eqv);
                        com.baidu.adp.lib.g.e.fw().postDelayed(ImageViewerActivity.this.eqv, 3000L);
                        break;
                    }
                    break;
                case 5:
                    if (view2 instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.eqy = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener eqz = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            ImageViewerActivity.this.createListMenu(new String[]{ImageViewerActivity.this.getPageContext().getString(d.k.save_to_emotion), ImageViewerActivity.this.getPageContext().getString(d.k.save_to_local)}, ImageViewerActivity.this.eqw);
            ImageViewerActivity.this.showListMenu();
            return true;
        }
    };
    private BaseViewPager.a eqA = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void cY(int i) {
            if (i == 0) {
                ImageViewerActivity.this.eqi.aJj();
            } else if (ImageViewerActivity.this.aJt() != 1) {
                ImageViewerActivity.this.showProgressBarWithOffset(0, 0);
                ImageViewerActivity.this.eqi.aJk();
            }
        }
    };
    private ViewPager.OnPageChangeListener arf = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.eqi != null && i > ImageViewerActivity.this.eqd.getItemNum() - 5) {
                ImageViewerActivity.this.eqi.aJj();
            }
            ImageViewerActivity.this.eqj.e(ImageViewerActivity.this.eqe, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.aJu();
            ImageViewerActivity.this.aJz();
            if (ImageViewerActivity.this.eqj.aJA() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.eqj.om(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.aJv()) {
                ImageViewerActivity.this.eqm.aIY();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.eqd.getItemNum() - 1) {
                ImageViewerActivity.this.eqk = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i > ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.aIE = true;
            } else if (i < ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i;
                ImageViewerActivity.this.aIE = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.eqe != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.eqe.size()) {
                ImageViewerActivity.this.eqj.Z(i, (String) ImageViewerActivity.this.eqe.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.eqd.getItemNum() - 1) {
                if (!ImageViewerActivity.this.eqy || !ImageViewerActivity.this.eqt || (!ImageViewerActivity.this.eqk && !ImageViewerActivity.this.aJv() && (ImageViewerActivity.this.eqd.getItemNum() != 1 || !ImageViewerActivity.this.aIE))) {
                    ImageViewerActivity.this.eqk = true;
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
        this.eqs = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        setContentView(d.i.image_activity_2);
        initData(bundle);
        awX();
        this.epQ = d.oj((String) v.c(this.eqe, this.mIndex));
        if (d.ok((String) v.c(this.eqe, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
        g(this.epQ, this.mIsSeeHost, false);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.eqv, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z, boolean z2) {
        this.eqi = new e(this.eqe, this.eqg, this.crG, this.dgn, this.aNu, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.eqi.setSourceImageRectInScreen(this.epP);
        this.eqi.hP(this.eqf);
        this.eqi.hQ(z);
        this.eqi.om(this.epQ);
        this.eqi.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.eqq) {
                    if (!z5) {
                        ImageViewerActivity.this.eqd.removeAllViews();
                        ImageViewerActivity.this.mIndex = 0;
                        ImageViewerActivity.this.initViewPager();
                        ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                    } else if (!ImageViewerActivity.this.mIsSeeHost) {
                        ImageViewerActivity.this.showToast(d.k.image_view_host_img_empty);
                    }
                }
                ImageViewerActivity.this.eqq = false;
                ImageViewerActivity.this.eqb.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                if (z4 && ImageViewerActivity.this.eqd.getCurrentItem() <= 4) {
                    int itemNum = ImageViewerActivity.this.eqd.getItemNum();
                    ImageViewerActivity.this.eqd.setTempSize(itemNum + 100);
                    ImageViewerActivity.this.eqd.setCurrentItem(itemNum + 90, false);
                    ImageViewerActivity.this.eqd.setTempSize(0);
                }
                ImageViewerActivity.this.eqd.setUrlData(arrayList);
                ImageViewerActivity.this.eqd.setAssistUrls(ImageViewerActivity.this.eqg);
                ImageViewerActivity.this.eqd.setHasNext(z3);
                ImageViewerActivity.this.eqd.setNextTitle(str2);
                if (i < 0 || i >= ImageViewerActivity.this.eqd.getItemNum()) {
                    ImageViewerActivity.this.eqd.eo(ImageViewerActivity.this.eqd.getCurrentItem());
                } else {
                    ImageViewerActivity.this.eqd.setCurrentItem(i, false);
                }
                if (i2 != 0) {
                    ImageViewerActivity.this.mCount = i2;
                }
                if (arrayList.size() >= 400 && ImageViewerActivity.this.eqd.getCurrentItem() > 200) {
                    for (int i3 = 0; i3 < 200; i3++) {
                        arrayList.remove(0);
                    }
                    ImageViewerActivity.this.eqd.setUrlData(arrayList);
                    ImageViewerActivity.this.eqd.setCurrentItem(ImageViewerActivity.this.eqd.getCurrentItem() + SapiErrorCode.NETWORK_FAILED, false);
                }
                ImageViewerActivity.this.aJu();
                a(arrayList, advertAppInfo);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.eqd.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.eqm.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.eqm.aIU()) {
                    ImageViewerActivity.this.eqd.setAddSize(1);
                } else {
                    ImageViewerActivity.this.eqd.setAddSize(0);
                }
            }

            @Override // com.baidu.tieba.image.e.b
            public void Y(int i, String str2) {
                ImageViewerActivity.this.eqq = false;
                ImageViewerActivity.this.eqb.setEnabled(true);
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    ImageViewerActivity.this.mCount = ImageViewerActivity.this.eqe.size();
                    ImageViewerActivity.this.aJu();
                }
            }
        });
        this.eqi.aJj();
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
            this.eqh = new a(this.eqd.getCurrentImageUrl(), this.eqd.getCurrentImageData());
            this.eqh.execute(new String[0]);
            this.eqc.setClickable(false);
            if (this.mFrom.equals(ImageViewerConfig.FROM_DISCOVER_BEAUTY)) {
                TiebaStatic.log("c12173");
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eqd.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.eqd.dh(i);
        super.onChangeSkinType(i);
        this.eqs = i;
        if (UtilHelper.isFlyMeOs()) {
            TbadkCoreApplication.getInst().setSkinTypeValue(1);
        }
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eqd.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eqd.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.eqd.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.Fa().Fb();
        this.eqj.e(this.eqe, this.mIndex, this.mIndex);
        this.eqj.aJB();
        this.eqd.onDestroy();
        if (this.eqh != null) {
            this.eqh.cancel();
            this.eqh = null;
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eqv);
        com.baidu.tbadk.download.e.Dy().ez(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.eqs);
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

    private void awX() {
        are();
        initViewPager();
        aJu();
        this.eqj.e(this.eqe, this.mIndex, this.mIndex);
    }

    private void are() {
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
        this.eqb = (ImageButton) addCustomView.findViewById(d.g.see_host_image_txt);
        if (this.eqr) {
            if (this.mIsSeeHost) {
                this.eqb.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.eqb.setImageResource(d.f.icon_topbar_host_white_selector);
            }
            this.eqb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!j.gD()) {
                        ImageViewerActivity.this.showToast(d.k.neterror);
                        return;
                    }
                    TiebaStatic.log(new al("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2).r("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
                    ImageViewerActivity.this.eqq = true;
                    ImageViewerActivity.this.eqb.setEnabled(false);
                    ImageViewerActivity.this.g(d.oj((String) v.c(ImageViewerActivity.this.eqe, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
                }
            });
        } else {
            this.eqb.setVisibility(8);
        }
        this.eqc = (TextView) addCustomView.findViewById(d.g.save_image_txt);
        this.eqc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ImageViewerActivity.this.mNavigationBar.getVisibility() != 8) {
                    Activity pageActivity = ImageViewerActivity.this.getPageContext().getPageActivity();
                    if (ImageViewerActivity.this.baD == null) {
                        ImageViewerActivity.this.baD = new com.baidu.tbadk.core.util.b.a();
                    }
                    ImageViewerActivity.this.baD.wu();
                    ImageViewerActivity.this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!ImageViewerActivity.this.baD.v(pageActivity)) {
                        ImageViewerActivity.this.saveImage();
                    }
                }
            }
        });
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, d.C0126d.common_color_10222));
        this.mTitleView.setTextColor(ContextCompat.getColor(this, d.C0126d.cp_cont_g));
        this.eqc.setTextColor(ContextCompat.getColor(this, d.C0126d.cp_cont_g));
        this.mNavigationBar.getBackImageView().setImageResource(d.f.icon_return_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long aJt() {
        ImageUrlData imageUrlData;
        String str = (String) v.c(this.eqe, this.mIndex);
        if (this.eqg == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eqg.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJu() {
        String str;
        if (this.eqe != null) {
            String str2 = ("" + aJt()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + "...";
            }
            if (aJv()) {
                aJx();
            } else {
                oo(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aJv() {
        return this.eql && this.eqm != null && this.eqm.aIU() && this.mIndex == this.eqd.getItemNum() + (-1);
    }

    private void oo(String str) {
        this.mTitleView.setText(str);
        if (!this.eqp) {
            this.eqc.setVisibility(8);
        } else {
            this.eqc.setClickable(true);
            this.eqc.setVisibility(0);
        }
        if (this.eqr) {
            this.eqb.setVisibility(0);
            if (this.mIsSeeHost) {
                this.eqb.setImageResource(d.f.icon_topbar_total_white_selector);
            } else {
                this.eqb.setImageResource(d.f.icon_topbar_host_white_selector);
            }
        }
    }

    private boolean aJw() {
        if (this.eqe == null) {
            return false;
        }
        Iterator<String> it = this.eqe.iterator();
        while (it.hasNext()) {
            if (d.ol(it.next())) {
                return false;
            }
        }
        return true;
    }

    private void aJx() {
        this.mTitleView.setText("");
        this.eqb.setVisibility(8);
        this.eqc.setClickable(false);
        this.eqc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.eqd == null) {
            this.eqd = (MultiImageView) findViewById(d.g.viewpager);
        } else {
            this.eqd.init();
        }
        this.eqd.setIsFromCDN(this.ayh);
        this.eqd.setIsCanDrag(this.ayk);
        this.eqd.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.eqd.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.eqd.setOnPageChangeListener(this.arf);
        this.eqd.setUrlData(this.eqe);
        this.eqd.setAssistUrls(this.eqg);
        this.eqd.setOuterOnTouchListener(this.azM);
        this.eqd.setItemOnclickListener(this.mOnClickListener);
        this.eqd.setItemOnLongClickListener(this.eqz);
        this.eqd.setCurrentItem(aAk(), false);
        this.eqd.setOnScrollOutListener(this.eqA);
        this.eqm = new com.baidu.tieba.image.a(this.ayh, this.eql, getPageContext(), this.crG, this.aNu);
        this.eqd.a(this.eqm);
        this.eqd.setOriImgSelectedCallback(this.ayj);
        this.eqd.setDragToExitListener(this.azC);
        this.eqd.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.eqt = ImageViewerActivity.this.equ - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.equ = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
    }

    private int aAk() {
        int v = v.v(this.eqe);
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
        this.eqj = new h();
        if (bundle != null) {
            this.eqe = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.crG = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.aNu = bundle.getString("tid");
            this.dgn = bundle.getString(ImageViewerConfig.FORUM_NAME);
            this.ayh = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.eqf = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.eql = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.ayk = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.eqr = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.epP = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            if (serializable instanceof Map) {
                this.eqg = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eqg.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.eqe = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.crG = intent.getStringExtra(ImageViewerConfig.FORUM_ID);
                this.aNu = intent.getStringExtra("tid");
                this.dgn = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
                this.ayh = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.eqf = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.eql = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.ayk = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.eqr = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                this.epP = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                if (serializableExtra instanceof Map) {
                    this.eqg = (Map) serializableExtra;
                }
            }
        }
        this.eqj.b(bundle, getIntent());
        this.mCount = v.v(this.eqe);
        this.eqp = aJw();
        if (this.epP != null) {
            String str = (String) v.c(this.eqe, this.mIndex);
            if (!StringUtils.isNull(str) && this.eqg != null && (imageUrlData = this.eqg.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.epP);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArrayList("url", this.eqe);
        bundle.putInt("index", this.mIndex);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.crG);
        bundle.putString("tid", this.aNu);
        bundle.putString(ImageViewerConfig.FORUM_NAME, this.dgn);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.eqf);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.ayk);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.eqr);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.eql);
        bundle.putString("user_id", this.mUserId);
        if (this.eqg instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eqg.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eqg instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eqg.entrySet()) {
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
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.epP);
        this.eqj.v(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.eqd.setCurrentItem(this.mIndex, false);
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
            if (this.mUrl != null && ImageViewerActivity.this.eqg != null && ImageViewerActivity.this.eqg.get(this.mUrl) != null) {
                String str = k.uF() + am.vK().ef(em) + "/" + aq.em(((ImageUrlData) ImageViewerActivity.this.eqg.get(this.mUrl)).originalUrl);
                int[] dG = k.dG(str);
                if (dG != null && dG.length == 2 && dG[0] > 0 && k.e(str, this.mUrl, ImageViewerActivity.this.getPageContext().getPageActivity()) == 0) {
                    return ImageViewerActivity.this.getPageContext().getString(d.k.save_image_to_album);
                }
            }
            if (this.mUrl != null && this.mData != null) {
                switch (k.a(this.mUrl, this.mData, ImageViewerActivity.this.getPageContext().getPageActivity())) {
                    case -2:
                        return k.uD();
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
            ImageViewerActivity.this.eqh = null;
            ImageViewerActivity.this.eqc.setClickable(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageViewerActivity.this.eqh = null;
            ImageViewerActivity.this.eqc.setClickable(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJy() {
        if (this.dPu) {
            if (this.mNavigationBar.getVisibility() == 8) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eqd.setSystemUiVisibility(0);
                }
                this.mNavigationBar.setVisibility(0);
                this.eqd.BZ();
                this.eqd.bm(false);
                this.dPt = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.dPt = new AlphaAnimation(1.0f, 0.0f);
                this.dPv = true;
                this.eqd.Ca();
                this.eqd.bm(true);
            }
            this.dPt.setDuration(300L);
            this.dPt.setFillAfter(false);
            this.dPt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ImageViewerActivity.this.dPu = true;
                    if (ImageViewerActivity.this.dPv) {
                        ImageViewerActivity.this.dPv = false;
                        ImageViewerActivity.this.mNavigationBar.setVisibility(8);
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            ImageViewerActivity.this.eqd.setSystemUiVisibility(4);
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
            this.dPu = false;
            this.mNavigationBar.startAnimation(this.dPt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJz() {
        if (aJv()) {
            this.eqo = this.mNavigationBar.getVisibility() == 0;
            this.eqn = true;
            if (!this.eqo) {
                aJy();
            }
        } else if (this.eqn) {
            this.mNavigationBar.setVisibility(this.eqo ? 0 : 8);
            this.eqn = false;
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
            public boolean Go() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Gp() {
                return com.baidu.tbadk.pageStayDuration.e.Gt().Gv();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.crG, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.aNu, 0L));
        }
        return pageStayDurationItem;
    }
}
