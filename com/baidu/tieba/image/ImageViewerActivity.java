package com.baidu.tieba.image;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.image.e;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements com.baidu.tbadk.coreExtra.view.a {
    private String Pk;
    private Map<String, ImageUrlData> dtF;
    private String emF;
    private String emG;
    private ImageView fkG;
    private View gra;
    private TextView hTF;
    private MultiImageView hTG;
    private ArrayList<String> hTH;
    private e hTI;
    private i hTJ;
    private j hTK;
    private boolean hTL;
    private float hTM;
    private com.baidu.tieba.c.d hTN;
    private int hTR;
    private boolean hTS;
    private String hTp;
    private String hTq;
    private float hUf;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private int mIndex = -1;
    private int mCount = -1;
    private a hTO = null;
    private boolean hTP = false;
    private boolean hTQ = false;
    private int Ev = 0;
    private boolean isRight = false;
    private boolean hTT = false;
    private boolean hTU = false;
    private boolean hTV = true;
    private boolean dsy = true;
    private boolean hTW = true;
    private boolean mIsSeeHost = false;
    private boolean hTX = false;
    private boolean hTY = false;
    private boolean hTZ = false;
    private boolean hTr = false;
    private boolean hUa = true;
    private boolean hUb = false;
    private boolean dsw = false;
    private boolean hUc = true;
    private boolean hTs = false;
    private final CustomMessageListener hUd = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.dwd)) {
                    ba.aGK().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    ba.aGK().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.dwd});
                }
            }
        }
    };
    private DragImageView.d dug = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hTF, 8);
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.gra, 8);
            if (ImageViewerActivity.this.hTG != null) {
                ImageViewerActivity.this.hTG.gr(false);
            }
            ImageViewerActivity.this.caZ();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").X("obj_param1", ImageViewerActivity.this.hTG.getItemNum()).X(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hTG.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void aSK() {
            ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.mTitleView, 0);
            if (!ImageViewerActivity.this.hUb || !TbadkCoreApplication.isLogin()) {
                ImageViewerActivity.this.gra.setVisibility(8);
            } else {
                ImageViewerActivity.this.gra.setVisibility(0);
            }
            if (ImageViewerActivity.this.hTG != null) {
                boolean aMU = ImageViewerActivity.this.hTG.aMU();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !aMU) {
                    ImageViewerActivity.this.setViewVisibility(ImageViewerActivity.this.hTF, 0);
                    if (ImageViewerActivity.this.hUc) {
                        ImageViewerActivity.this.hTG.gr(true);
                    } else {
                        ImageViewerActivity.this.hTG.gr(false);
                    }
                }
            }
        }
    };
    private UrlDragImageView.b dso = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void aNm() {
            TiebaStatic.log(new an("c10351").cx("tid", ImageViewerActivity.this.Pk).cx("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final View.OnClickListener hUe = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.showToast(R.string.neterror);
                return;
            }
            TiebaStatic.log(new an("pb_onlyowner_click").X("obj_source", 2).X("obj_type", ImageViewerActivity.this.mIsSeeHost ? 1 : 0));
            TiebaStatic.log(new an("c13338").X("obj_locate", ImageViewerActivity.this.mIsSeeHost ? 1 : 2));
            ImageViewerActivity.this.hTS = true;
            if (ImageViewerActivity.this.hTF != null) {
                ImageViewerActivity.this.hTF.setEnabled(false);
            }
            ImageViewerActivity.this.k(d.DO((String) v.getItem(ImageViewerActivity.this.hTH, ImageViewerActivity.this.mIndex)), ImageViewerActivity.this.mIsSeeHost ? false : true, true);
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            if (ImageViewerActivity.this.hUb && ImageViewerActivity.this.hTG != null) {
                boolean aMU = ImageViewerActivity.this.hTG.aMU();
                if (ImageViewerActivity.this.hTF == null) {
                    i = 0;
                } else if (!aMU) {
                    com.baidu.tieba.v.a.v(ImageViewerActivity.this.hTF, 100);
                    i = 1;
                } else {
                    com.baidu.tieba.v.a.w(ImageViewerActivity.this.hTF, 100);
                    i = 2;
                }
                ImageViewerActivity.this.hTG.n(aMU ? false : true, 100);
                TiebaStatic.log(new an("c13397").X("obj_type", i));
                return;
            }
            TiebaStatic.log(new an("c13341").X("obj_param1", ImageViewerActivity.this.hTG.getItemNum()).X(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.hTG.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").cx("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean hUg = true;
    private View.OnTouchListener dus = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.hUf = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hUg = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.hUf = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.hUg = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener hUh = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.hTK != null) {
                ImageViewerActivity.this.hTK.byk();
                ImageViewerActivity.this.hTK.show();
                ImageViewerActivity.this.hTK.ch(view);
            }
            TiebaStatic.log(new an("c13269").cx("uid", ImageViewerActivity.this.mUserId).cx("fid", ImageViewerActivity.this.emF).cx("tid", ImageViewerActivity.this.Pk));
            return true;
        }
    };
    private BaseViewPager.a hUi = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.hTI.caE();
            } else if (ImageViewerActivity.this.caU() != 1) {
                ImageViewerActivity.this.hTI.caF();
            }
        }
    };
    private ViewPager.OnPageChangeListener bah = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.hTI != null && i > ImageViewerActivity.this.hTG.getItemNum() - 5) {
                ImageViewerActivity.this.hTI.caE();
            }
            ImageViewerActivity.this.hTJ.d(ImageViewerActivity.this.hTH, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.caV();
            ImageViewerActivity.this.cba();
            ImageViewerActivity.this.xo(i);
            if (ImageViewerActivity.this.hTJ.cbc() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hTJ.xp(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.hTJ.cbd() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.hTJ.xq(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.caW()) {
                ImageViewerActivity.this.hTO.cas();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.hTG.getItemNum() - 1) {
                ImageViewerActivity.this.hTU = false;
            }
            if (ImageViewerActivity.this.hTK != null) {
                ImageViewerActivity.this.hTK.cbf();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.Ev) {
                ImageViewerActivity.this.Ev = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.Ev) {
                ImageViewerActivity.this.Ev = i;
                ImageViewerActivity.this.isRight = false;
            }
            if (ImageViewerActivity.this.hTG != null) {
                dragImageView = ImageViewerActivity.this.hTG.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.caU() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.hTH != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.hTH.size()) {
                ImageViewerActivity.this.hTJ.aM(i, (String) ImageViewerActivity.this.hTH.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.hTG.getItemNum() - 1) {
                if (!ImageViewerActivity.this.hUg || !ImageViewerActivity.this.hTL || (!ImageViewerActivity.this.hTU && !ImageViewerActivity.this.caW() && (ImageViewerActivity.this.hTG.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.hTU = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private CustomMessageListener ddV = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dtF != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dtF.values()) {
                    if (imageUrlData != null) {
                        String valueOf = String.valueOf(imageUrlData.threadId);
                        String valueOf2 = String.valueOf(imageUrlData.postId);
                        if (agreeData.threadId.equals(valueOf) && agreeData.postId.equals(valueOf2) && (agreeData2 = imageUrlData.agreeData) != null) {
                            agreeData2.agreeType = agreeData.agreeType;
                            agreeData2.hasAgree = agreeData.hasAgree;
                            agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
                            agreeData2.agreeNum = agreeData.agreeNum;
                            agreeData2.disAgreeNum = agreeData.disAgreeNum;
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener ddW = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.dtF != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.dtF.values()) {
                    if (imageUrlData != null) {
                        String valueOf = String.valueOf(imageUrlData.threadId);
                        String valueOf2 = String.valueOf(imageUrlData.postId);
                        if (agreeData.threadId.equals(valueOf) && agreeData.postId.equals(valueOf2) && (agreeData2 = imageUrlData.agreeData) != null) {
                            agreeData2.agreeType = agreeData.agreeType;
                            agreeData2.hasAgree = agreeData.hasAgree;
                            agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
                            agreeData2.agreeNum = agreeData.agreeNum;
                            agreeData2.disAgreeNum = agreeData.disAgreeNum;
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisibility(View view, int i) {
        if (view != null) {
            view.clearAnimation();
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 28 && (UtilHelper.hasNotchAndroidP(this) || UtilHelper.hasNotchAtHuawei(this))) {
            setUseStyleImmersiveSticky(false);
        }
        super.onCreate(bundle);
        com.baidu.tbadk.mutiprocess.g.aQk().init(TbadkCoreApplication.getInst());
        this.hTR = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        bNk();
        k(this.hTq, this.mIsSeeHost, false);
        registerListener(this.hUd);
        registerListener(this.ddV);
        registerListener(this.ddW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.hTI = new e(this.hTH, this.dtF, this.emF, this.emG, this.Pk, str, this.mUserId, this.mFrom, this.mThreadType, z2);
        this.hTI.setSourceImageRectInScreen(this.hTp);
        this.hTI.os(this.hUa);
        this.hTI.ot(z);
        this.hTI.DQ(this.hTq);
        this.hTI.or(this.hTr);
        this.hTI.setPostId(this.mPostId);
        this.hTI.ov(this.hTs);
        this.hTI.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.hTG != null) {
                    if (ImageViewerActivity.this.hTS) {
                        if (!z5) {
                            ImageViewerActivity.this.hTG.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.hTS = false;
                    if (ImageViewerActivity.this.hTF != null) {
                        ImageViewerActivity.this.hTF.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.hTG.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.hTG.getItemNum();
                        ImageViewerActivity.this.hTG.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.hTG.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.hTG.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.hTO != null) {
                        ImageViewerActivity.this.hTO.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.hTG.setUrlData(arrayList);
                    ImageViewerActivity.this.hTG.setAssistUrls(ImageViewerActivity.this.dtF);
                    ImageViewerActivity.this.hTG.setHasNext(z3);
                    ImageViewerActivity.this.hTG.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.hTG.getItemNum()) {
                        ImageViewerActivity.this.hTG.md(ImageViewerActivity.this.hTG.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.hTG.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.hTG.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.hTG.setUrlData(arrayList);
                        ImageViewerActivity.this.hTG.setCurrentItem(ImageViewerActivity.this.hTG.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.caV();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.hTG.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.hTO.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.hTO.cao()) {
                    ImageViewerActivity.this.hTG.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.hTG.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void aL(int i, String str2) {
                ImageViewerActivity.this.hTS = false;
                if (ImageViewerActivity.this.hTF != null) {
                    ImageViewerActivity.this.hTF.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.hTH != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.hTH.size();
                    }
                    ImageViewerActivity.this.caV();
                }
            }
        });
        this.hTI.ou(true);
        this.hTI.caE();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!k.isFastDoubleClick()) {
            TiebaStatic.log(new an("c13377").cx("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.hTG.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.hTG.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.hTR = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hTG.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.Pk, 0L);
        if (uniqueId != null && j > 0) {
            q.q(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hTG.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.Pk, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.cHf, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.hTG.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.hUd);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.aPV().releaseBlockBitmapPool();
        this.hTJ.d(this.hTH, this.mIndex, this.mIndex);
        this.hTJ.cbe();
        String str3 = "";
        if (this.hTO != null) {
            str3 = this.hTO.getAdId();
        }
        if (this.hTI != null) {
            str = this.hTI.aDW();
            str2 = this.hTI.aDX();
        } else {
            str = null;
        }
        this.hTJ.a(this.hTG.getPageCount(), str3, this.emF, this.Pk, str, str2);
        if (this.hTK != null) {
            this.hTK.release();
        }
        this.hTG.onDestroy();
        com.baidu.tbadk.download.d.aOu().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.hTR);
        caZ();
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

    private void bNk() {
        bcO();
        initViewPager();
        caV();
        bzo();
        caR();
        this.hTK = new j(this);
        this.hTK.j(this.hTG);
        this.hTJ.d(this.hTH, this.mIndex, this.mIndex);
    }

    private void caR() {
        if (com.baidu.tbadk.core.util.g.aFQ()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void bcO() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        caS();
        bgl();
        this.mTitleView = this.mNavigationBar.setCenterTextTitle("");
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        if (d.DP((String) v.getItem(this.hTH, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void caS() {
        this.gra = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gra.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.fkG = (ImageView) this.gra.findViewById(R.id.widget_navi_back_button);
        SvgManager.aGG().a(this.fkG, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (this.hUb && TbadkCoreApplication.isLogin()) {
            this.gra.setVisibility(0);
        } else {
            this.gra.setVisibility(8);
        }
    }

    private void bgl() {
        if (!this.hTY && !this.hTX) {
            this.hTF = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null).findViewById(R.id.see_host_image_txt);
            if (this.hTW) {
                this.hTF.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
                this.hTF.setOnClickListener(this.hUe);
                return;
            }
            setViewVisibility(this.hTF, 8);
        }
    }

    public Map<String, ImageUrlData> caT() {
        return this.dtF;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long caU() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.hTH, this.mIndex);
        if (this.dtF == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.dtF.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caV() {
        String str;
        if (this.hTH != null) {
            String str2 = ("" + caU()) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.hTT && caU() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").cx("obj_source", this.mFrom));
                this.hTT = true;
            }
            if (caW()) {
                caX();
            } else {
                DR(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean caW() {
        if (this.hTV && this.hTO != null && this.hTO.cao()) {
            return this.hTG.getItemNum() != 1 && this.mIndex == this.hTG.getItemNum() + (-1);
        }
        return false;
    }

    private void DR(String str) {
        this.mTitleView.setText(str);
        if (this.hTW && !this.hTX && this.hTF != null) {
            this.hTF.setText(this.mIsSeeHost ? R.string.album_all_thread : R.string.view_host);
        }
    }

    private void caX() {
        this.mTitleView.setText("");
        setViewVisibility(this.hTF, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.hTG == null) {
            this.hTG = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.hTG.init();
        }
        this.hTG.setIsFromCDN(this.dsw);
        this.hTG.setIsCanDrag(this.dsy);
        this.hTG.setIsBJHThread(this.hTY);
        this.hTG.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.hTG.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.hTG.setOnPageChangeListener(this.bah);
        this.hTG.setUrlData(this.hTH);
        this.hTG.setAssistUrls(this.dtF);
        this.hTG.setOuterOnTouchListener(this.dus);
        this.hTG.setItemOnclickListener(this.mOnClickListener);
        this.hTG.setItemOnLongClickListener(this.hUh);
        this.hTG.setCurrentItem(bRU(), false);
        this.hTG.setOnScrollOutListener(this.hUi);
        this.hTO = new a(this.dsw, this.hTV, getPageContext(), this.emF, this.Pk);
        this.hTO.setDragToExitListener(this.dug);
        this.hTG.a(this.hTO);
        this.hTG.setOriImgSelectedCallback(this.dso);
        this.hTG.setDragToExitListener(this.dug);
        this.hTG.setUserId(this.mUserId);
        this.hTG.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.hTL = ImageViewerActivity.this.hTM - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.hTM = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.hTG.setShowBottomContainer(this.hUc);
        TiebaStatic.log(new an("c13340").cx("uid", this.mUserId).cx("post_id", this.Pk).X("obj_source", caY()));
    }

    private int caY() {
        if (StringUtils.isNULL(this.mFrom)) {
            return 7;
        }
        if (this.mFrom.equals("pb")) {
            return 5;
        }
        if (this.mFrom.equals("frs")) {
            return 3;
        }
        return this.mFrom.equals("index") ? 1 : 7;
    }

    private void bzo() {
        if (!this.hTX && this.hTF != null) {
            if (this.hTN == null) {
                this.hTN = new com.baidu.tieba.c.d(getPageContext(), this.hTF);
                this.hTN.ck(R.drawable.pic_sign_tip);
                this.hTN.cj(48);
                this.hTN.setUseDirectOffset(true);
                this.hTN.cl(5000);
                this.hTN.rB(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.hTN.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.caZ();
                    }
                });
            }
            this.hTN.ai(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caZ() {
        if (this.hTN != null) {
            this.hTN.zG();
        }
    }

    public int bRU() {
        int count = v.getCount(this.hTH);
        if (count > 0) {
            if (this.mIndex >= count) {
                this.mIndex = count - 1;
            } else if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        } else {
            this.mIndex = 0;
        }
        return this.mIndex;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.Map<java.lang.String, com.baidu.tbadk.coreExtra.view.ImageUrlData> */
    /* JADX WARN: Multi-variable type inference failed */
    private void initData(Bundle bundle) {
        ImageUrlData imageUrlData;
        this.hTJ = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.hTY = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.hUb = bundle.getBoolean("abtest");
            this.hTH = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.emF = bundle.getString("fid");
            this.Pk = bundle.getString("tid");
            this.emG = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.dsw = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.hUa = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.hTV = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.dsy = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.hTW = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.hTp = bundle.getString("source_rect_in_screen");
            this.hTr = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.hUc = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.hTs = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.dtF = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.dtF.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.hTZ = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.hTX = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.hTY = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.hUb = intent.getBooleanExtra("abtest", false);
                this.hTH = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.emF = intent.getStringExtra("fid");
                this.Pk = intent.getStringExtra("tid");
                this.emG = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.dsw = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.hUa = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.hTV = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.dsy = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.hTW = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.hUc = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.hTs = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.hTZ = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.hTX = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.hTp = intent.getStringExtra("source_rect_in_screen");
                this.hTr = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.dtF = (Map) serializableExtra;
                }
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.gN(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.hTJ.b(bundle, getIntent());
        this.mCount = v.getCount(this.hTH);
        if (this.hTp != null) {
            String str = (String) v.getItem(this.hTH, this.mIndex);
            if (!StringUtils.isNull(str) && this.dtF != null && (imageUrlData = this.dtF.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.hTp);
            }
        }
        this.hTq = this.hTY ? null : d.DO((String) v.getItem(this.hTH, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").cx("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").cx("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.hTY);
        bundle.putBoolean("abtest", this.hUb);
        bundle.putStringArrayList("url", this.hTH);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.emF);
        bundle.putString("tid", this.Pk);
        bundle.putString("fname", this.emG);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.hUa);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.dsy);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.hTW);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.hTV);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.hUc);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.hTs);
        if (this.dtF instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.dtF.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.dtF instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.dtF.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.hTp);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.hTZ);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.hTX);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.hTr);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.hTJ.ar(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.hTG.setCurrentItem(this.mIndex, false);
        SvgManager.aGG().a(this.fkG, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xo(int i) {
        if (this.hTG != null) {
            this.hTG.mc(i);
            setViewVisibility(this.hTF, (this.hTG.aMU() || caW()) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cba() {
        if (caW()) {
            this.hTQ = this.mNavigationBar.getVisibility() == 0;
            this.hTP = true;
        } else if (this.hTP) {
            this.mNavigationBar.setVisibility(this.hTQ ? 0 : 8);
            this.hTP = false;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BIGIMAGE;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.aRc().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.emF, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.Pk, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vG(TbadkCoreApplication.getInst().getAdAdSense().dmy);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.coreExtra.view.a
    public boolean aML() {
        return this.hUb;
    }

    public boolean cbb() {
        return this.hTY;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.Pk)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.Pk, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
