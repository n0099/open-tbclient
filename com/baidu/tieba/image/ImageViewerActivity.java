package com.baidu.tieba.image;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.image.e;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.webkit.internal.ETAG;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpHost;
/* loaded from: classes15.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private String ajJ;
    private String eKO;
    private Map<String, ImageUrlData> ewQ;
    private String ftz;
    private ImageView gwo;
    private View hHY;
    private String jsH;
    private String jsI;
    private int jsL;
    private SortSwitchButton jsZ;
    private float jtF;
    private View jta;
    private HeadImageView jtb;
    private TBLottieAnimationView jtc;
    private com.baidu.tieba.c.e jtd;
    private String jtf;
    private MultiImageView jtg;
    private ArrayList<String> jth;
    private e jti;
    private i jtj;
    private j jtk;
    private boolean jtl;
    private float jtm;
    private com.baidu.tieba.c.e jtn;
    private int jtr;
    private boolean jts;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mNid;
    private String mPostId;
    private String mRecomAbTag;
    private String mRecomExtra;
    private String mRecomSource;
    private String mRecomWeight;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private boolean jte = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a jto = null;
    private boolean jtp = false;
    private boolean jtq = false;
    private int Yz = 0;
    private boolean isRight = false;
    private boolean jtt = false;
    private boolean jtu = false;
    private boolean jtv = true;
    private boolean evJ = true;
    private boolean jtw = true;
    private boolean mIsSeeHost = false;
    private boolean jtx = false;
    private boolean jty = false;
    private boolean jtz = false;
    private boolean jsJ = false;
    private boolean jtA = true;
    private boolean evH = false;
    private boolean jtB = true;
    private boolean jsK = false;
    private CustomMessageListener jtC = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.czZ();
            }
        }
    };
    private final CustomMessageListener jtD = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.ezd)) {
                    bd.baV().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    bd.baV().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.ezd});
                }
            }
        }
    };
    private DragImageView.d exr = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.p(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.p(ImageViewerActivity.this.jsZ, 8);
            ImageViewerActivity.this.p(ImageViewerActivity.this.hHY, 8);
            ImageViewerActivity.this.p(ImageViewerActivity.this.jta, 8);
            if (ImageViewerActivity.this.jtg != null) {
                ImageViewerActivity.this.jtg.iy(false);
            }
            ImageViewerActivity.this.czX();
            ImageViewerActivity.this.czZ();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new ap("c13341").ah("obj_param1", ImageViewerActivity.this.jtg.getItemNum()).ah(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jtg.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bnk() {
            ImageViewerActivity.this.p(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.hHY.setVisibility(0);
            if (ImageViewerActivity.this.jtg != null) {
                boolean bhk = ImageViewerActivity.this.jtg.bhk();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bhk) {
                    ImageViewerActivity.this.p(ImageViewerActivity.this.jsZ, 0);
                    ImageViewerActivity.this.p(ImageViewerActivity.this.jta, 0);
                    ImageViewerActivity.this.ID(ImageViewerActivity.this.jtf);
                    if (ImageViewerActivity.this.jtB) {
                        ImageViewerActivity.this.jtg.iy(true);
                    } else {
                        ImageViewerActivity.this.jtg.iy(false);
                    }
                }
            }
        }
    };
    private UrlDragImageView.b evA = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bhC() {
            TiebaStatic.log(new ap("c10351").dn("tid", ImageViewerActivity.this.ajJ).dn("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a jtE = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean vs(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.jts = true;
                if (ImageViewerActivity.this.jsZ != null) {
                    ImageViewerActivity.this.jsZ.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.Iz((String) x.getItem(ImageViewerActivity.this.jth, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ap("c13341").ah("obj_param1", ImageViewerActivity.this.jtg.getItemNum()).ah(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jtg.getCurrentMaxIndex()));
            TiebaStatic.log(new ap("c13377").dn("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean jtG = true;
    private View.OnTouchListener exE = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.jtF = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.jtG = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.jtF = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.jtG = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener jtH = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.jtk != null) {
                ImageViewerActivity.this.jtk.bUO();
                ImageViewerActivity.this.jtk.show();
                ImageViewerActivity.this.jtk.cw(view);
            }
            TiebaStatic.log(new ap("c13269").dn("uid", ImageViewerActivity.this.mUserId).dn("fid", ImageViewerActivity.this.eKO).dn("tid", ImageViewerActivity.this.ajJ));
            return true;
        }
    };
    private BaseViewPager.a jtI = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.jti.czB();
            } else if (ImageViewerActivity.this.czS() != 1) {
                ImageViewerActivity.this.jti.czC();
            }
        }
    };
    private ViewPager.OnPageChangeListener bLA = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.jti != null && i > ImageViewerActivity.this.jtg.getItemNum() - 5) {
                ImageViewerActivity.this.jti.czB();
            }
            ImageViewerActivity.this.jtj.g(ImageViewerActivity.this.jth, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.czT();
            ImageViewerActivity.this.czY();
            ImageViewerActivity.this.zH(i);
            if (ImageViewerActivity.this.jtj.cAb() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jtj.zK(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.jtj.cAc() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jtj.zL(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.czU()) {
                ImageViewerActivity.this.jto.czp();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.jtg.getItemNum() - 1) {
                ImageViewerActivity.this.jtu = false;
            }
            if (ImageViewerActivity.this.jtk != null) {
                ImageViewerActivity.this.jtk.cAf();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.Yz) {
                ImageViewerActivity.this.Yz = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.Yz) {
                ImageViewerActivity.this.Yz = i;
                ImageViewerActivity.this.isRight = false;
            }
            if (ImageViewerActivity.this.jtg != null) {
                dragImageView = ImageViewerActivity.this.jtg.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.czS() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.czZ();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.jth != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.jth.size()) {
                ImageViewerActivity.this.jtj.bm(i, (String) ImageViewerActivity.this.jth.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.jtg.getItemNum() - 1) {
                if (!ImageViewerActivity.this.jtG || !ImageViewerActivity.this.jtl || (!ImageViewerActivity.this.jtu && !ImageViewerActivity.this.czU() && (ImageViewerActivity.this.jtg.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.jtu = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private View.OnClickListener jtJ = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.dFL).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.dFU).append("?").append(com.baidu.tbadk.BdToken.f.dGm).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.dGn).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new ap("c13711").dn("fid", ImageViewerActivity.this.eKO).dn("fname", ImageViewerActivity.this.ftz).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", ImageViewerActivity.this.ajJ).dn("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.ewQ != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.ewQ.values()) {
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
    private CustomMessageListener eeQ = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.ewQ != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.ewQ.values()) {
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
    public void p(View view, int i) {
        if (view != null) {
            view.clearAnimation();
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 28 && TbSingleton.getInstance().isNotchScreen(this)) {
            setUseStyleImmersiveSticky(false);
        }
        super.onCreate(bundle);
        com.baidu.tbadk.mutiprocess.g.bkA().init(TbadkCoreApplication.getInst());
        this.jtr = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cln();
        k(this.jsI, this.mIsSeeHost, false);
        registerListener(this.jtD);
        registerListener(this.jtC);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.eeQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.jti = new e(this.jth, this.ewQ, this.eKO, this.ftz, this.ajJ, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.jsL, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.jti.setSourceImageRectInScreen(this.jsH);
        this.jti.qJ(this.jtA);
        this.jti.qK(z);
        this.jti.IB(this.jsI);
        this.jti.qI(this.jsJ);
        this.jti.setPostId(this.mPostId);
        this.jti.qM(this.jsK);
        this.jti.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.jtg != null) {
                    if (ImageViewerActivity.this.jts) {
                        if (!z5) {
                            ImageViewerActivity.this.jtg.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.jts = false;
                    if (ImageViewerActivity.this.jsZ != null) {
                        ImageViewerActivity.this.jsZ.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.jtg.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.jtg.getItemNum();
                        ImageViewerActivity.this.jtg.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.jtg.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.jtg.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.jto != null) {
                        ImageViewerActivity.this.jto.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.jtg.setUrlData(arrayList);
                    ImageViewerActivity.this.jtg.setAssistUrls(ImageViewerActivity.this.ewQ);
                    ImageViewerActivity.this.jtg.setHasNext(z3);
                    ImageViewerActivity.this.jtg.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.jtg.getItemNum()) {
                        ImageViewerActivity.this.jtg.nF(ImageViewerActivity.this.jtg.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.jtg.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.jtg.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.jtg.setUrlData(arrayList);
                        ImageViewerActivity.this.jtg.setCurrentItem(ImageViewerActivity.this.jtg.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.czT();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.jtg.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.jto.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.jto.czl()) {
                    ImageViewerActivity.this.jtg.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.jtg.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bl(int i, String str2) {
                ImageViewerActivity.this.jts = false;
                if (ImageViewerActivity.this.jsZ != null) {
                    ImageViewerActivity.this.jsZ.changeState(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.jsZ.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.jth != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.jth.size();
                    }
                    ImageViewerActivity.this.czT();
                }
            }
        });
        this.jti.qL(true);
        this.jti.czB();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!com.baidu.tbadk.util.k.isFastDoubleClick()) {
            TiebaStatic.log(new ap("c13377").dn("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jtg.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.jtg.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.jtr = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        zJ(i);
        if (this.jtk != null) {
            this.jtk.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jtg.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ajJ, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jtg.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ajJ, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.dEF, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.jtg.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.jtD);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bkk().releaseBlockBitmapPool();
        this.jtj.g(this.jth, this.mIndex, this.mIndex);
        this.jtj.cAd();
        String str3 = "";
        if (this.jto != null) {
            str3 = this.jto.getAdId();
        }
        if (this.jti != null) {
            str = this.jti.aXT();
            str2 = this.jti.aXU();
        } else {
            str = null;
        }
        this.jtj.a(this.jtg.getPageCount(), str3, this.eKO, this.ajJ, str, str2);
        if (this.jtk != null) {
            this.jtk.release();
        }
        this.jtg.onDestroy();
        com.baidu.tbadk.download.d.biF().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.jtr);
        czX();
        czZ();
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

    private void cln() {
        bmb();
        this.jtk = new j(this);
        initViewPager();
        this.jtk.j(this.jtg);
        czT();
        bWf();
        czP();
        this.jtj.g(this.jth, this.mIndex, this.mIndex);
    }

    private void czP() {
        if (com.baidu.tbadk.core.util.g.aZY()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        setFullScreen();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    ImageViewerActivity.this.setFullScreen();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void bmb() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        czQ();
        bBD();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.IA((String) x.getItem(this.jth, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void czQ() {
        this.hHY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hHY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.gwo = (ImageView) this.hHY.findViewById(R.id.widget_navi_back_button);
        SvgManager.baR().a(this.gwo, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hHY.setVisibility(0);
    }

    private void bBD() {
        if (!this.jty && !this.jtx) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.jta = addCustomView.findViewById(R.id.view_user_photo);
            this.jtb = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.jtc = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.jtb.setIsRound(true);
            this.jtb.setPlaceHolder(1);
            if (this.jtw) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.Ft(0);
                pVar.NO(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.Ft(1);
                pVar2.NO(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.jsZ = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.jsZ.setNeedDayNight(false);
                this.jsZ.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.jsZ.setVisibility(0);
                this.jsZ.setOnSwitchChangeListener(this.jtE);
                p(this.jta, 0);
                return;
            }
            p(this.jsZ, 8);
            p(this.jta, 8);
        }
    }

    public Map<String, ImageUrlData> czR() {
        return this.ewQ;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long czS() {
        ImageUrlData imageUrlData;
        String str = (String) x.getItem(this.jth, this.mIndex);
        if (this.ewQ == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.ewQ.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czT() {
        String str;
        if (this.jth != null) {
            long czS = czS();
            String str2 = ("" + czS) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.jtt && czS() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new ap("c13316").dn("obj_source", this.mFrom));
                this.jtt = true;
            }
            if (czU()) {
                czV();
            } else {
                IC(str);
            }
            long j = czS - 1;
            zI(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czU() {
        if (this.jtv && this.jto != null && this.jto.czl()) {
            return this.jtg.getItemNum() != 1 && this.mIndex == this.jtg.getItemNum() + (-1);
        }
        return false;
    }

    private void IC(String str) {
        this.mTitleView.setText(str);
        if (this.jtw && !this.jtx && this.jsZ != null) {
            this.jsZ.changeState(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void czV() {
        this.mTitleView.setText("");
        p(this.jsZ, 8);
        p(this.jta, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.jtg == null) {
            this.jtg = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.jtg.init();
        }
        this.jtg.setIsFromCDN(this.evH);
        this.jtg.setIsCanDrag(this.evJ);
        this.jtg.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.jtg.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.jtg.setOnPageChangeListener(this.bLA);
        this.jtg.setUrlData(this.jth);
        this.jtg.setAssistUrls(this.ewQ);
        this.jtg.setOuterOnTouchListener(this.exE);
        this.jtg.setItemOnclickListener(this.mOnClickListener);
        this.jtg.setItemOnLongClickListener(this.jtH);
        this.jtg.setCurrentItem(cqp(), false);
        this.jtg.setOnScrollOutListener(this.jtI);
        this.jto = new a(this.evH, this.jtv, getPageContext(), this.eKO, this.ajJ);
        this.jto.setDragToExitListener(this.exr);
        this.jtg.a(this.jto);
        this.jtg.setOriImgSelectedCallback(this.evA);
        this.jtg.setDragToExitListener(this.exr);
        this.jtg.setUserId(this.mUserId);
        this.jtg.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.jtl = ImageViewerActivity.this.jtm - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.jtm = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.jtg.setShowBottomContainer(this.jtB);
        this.jtg.setOnShareImageListener(this.jtk);
        this.jtg.setOnDownloadImageListener(this.jtk);
        TiebaStatic.log(new ap("c13340").dn("uid", this.mUserId).dn("post_id", this.ajJ).ah("obj_source", czW()));
    }

    private int czW() {
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

    private void bWf() {
        if (!this.jtx && this.jsZ != null) {
            if (this.jtn == null) {
                this.jtn = new com.baidu.tieba.c.e(getPageContext(), this.jsZ);
                this.jtn.cS(R.drawable.pic_sign_tip);
                this.jtn.cR(48);
                this.jtn.setUseDirectOffset(true);
                this.jtn.cT(5000);
                this.jtn.tr(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.jtn.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.czX();
                    }
                });
            }
            this.jtn.aC(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czX() {
        if (this.jtn != null) {
            this.jtn.HN();
        }
    }

    public int cqp() {
        int count = x.getCount(this.jth);
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

    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.util.Map<java.lang.String, com.baidu.tbadk.coreExtra.view.ImageUrlData> */
    /* JADX WARN: Multi-variable type inference failed */
    private void initData(Bundle bundle) {
        ImageUrlData imageUrlData;
        this.jtj = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.jty = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.jth = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eKO = bundle.getString("fid");
            this.ajJ = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.ftz = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.evH = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.jtA = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.jtv = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.evJ = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.jtw = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.jsH = bundle.getString("source_rect_in_screen");
            this.jsJ = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.jtB = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.jsK = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.ewQ = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.ewQ.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.jtz = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.jtx = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.jsL = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.jty = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.jth = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eKO = intent.getStringExtra("fid");
                this.ajJ = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.ftz = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.evH = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.jtA = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.jtv = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.evJ = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.jtw = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.jtB = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.jsK = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.jtz = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.jtx = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.jsH = intent.getStringExtra("source_rect_in_screen");
                this.jsJ = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.ewQ = (Map) serializableExtra;
                }
                this.jsL = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.iV(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.jtj.b(bundle, getIntent());
        this.mCount = x.getCount(this.jth);
        if (this.jsH != null) {
            String str = (String) x.getItem(this.jth, this.mIndex);
            if (!StringUtils.isNull(str) && this.ewQ != null && (imageUrlData = this.ewQ.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.jsH);
            }
        }
        this.jsI = this.jty ? null : d.Iz((String) x.getItem(this.jth, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new ap("c13337").dn("obj_type", "2"));
        } else {
            TiebaStatic.log(new ap("c13337").dn("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.jty);
        bundle.putStringArrayList("url", this.jth);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eKO);
        bundle.putString("tid", this.ajJ);
        bundle.putString("fname", this.ftz);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.jtA);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.evJ);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.jtw);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.jtv);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.jtB);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.jsK);
        if (this.ewQ instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.ewQ.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.ewQ instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.ewQ.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.jsH);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.jtz);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.jtx);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.jsJ);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.jtj.az(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jtg.setCurrentItem(this.mIndex, false);
        SvgManager.baR().a(this.gwo, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zH(int i) {
        if (this.jtg != null) {
            this.jtg.nE(i);
            int i2 = (this.jtg.bhk() || czU()) ? 8 : 0;
            p(this.jsZ, i2);
            p(this.jta, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czY() {
        if (czU()) {
            this.jtq = this.mNavigationBar.getVisibility() == 0;
            this.jtp = true;
        } else if (this.jtp) {
            this.mNavigationBar.setVisibility(this.jtq ? 0 : 8);
            this.jtp = false;
        }
    }

    private void zI(int i) {
        if (this.jti != null) {
            ArrayList<AlaInfoData> czA = this.jti.czA();
            if (czA != null && czA.size() > 0) {
                qN(true);
                b(czA.get(i % czA.size()));
                return;
            }
            qN(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.jtb, alaInfoData.user_info.portrait);
            this.jtb.setAlaInfo(alaInfoData);
            this.jtb.setOnClickListener(this.jtJ);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                ID(alaInfoData.tag);
            }
            TiebaStatic.log(new ap("c13710").dn("fid", this.eKO).dn("fname", this.ftz).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", this.ajJ).dn("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
        }
    }

    private void b(TbImageView tbImageView, @NonNull String str) {
        if (tbImageView != null) {
            if (TextUtils.isEmpty(str)) {
                str = " ";
            }
            if (str.toLowerCase().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                tbImageView.startLoad(str, 10, false);
            } else {
                tbImageView.startLoad(str, 12, false);
            }
        }
    }

    private void qN(boolean z) {
        if (this.jte != z) {
            if (this.jtc != null) {
                if (z) {
                    this.jtc.setVisibility(0);
                    if (!this.jtc.isAnimating()) {
                        this.jtc.setSpeed(0.8f);
                        this.jtc.setRepeatCount(-1);
                        this.jtc.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.jtc.playAnimation();
                            }
                        });
                    }
                } else {
                    this.jtc.setVisibility(8);
                    if (this.jtc.isAnimating()) {
                        this.jtc.cancelAnimation();
                    }
                }
            }
            if (this.jtb != null) {
                this.jtb.setVisibility(z ? 0 : 8);
            }
            this.jte = z;
        }
    }

    private void zJ(int i) {
        if (this.jtc != null) {
            if (i == 1) {
                this.jtc.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.jtc.setAnimation("live/card_live_bg_black.json");
            } else {
                this.jtc.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID(@NonNull final String str) {
        if (this.jtc != null) {
            this.jtc.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.jtd != null) {
                        if (ImageViewerActivity.this.jtf == null || ImageViewerActivity.this.jtd == null || ImageViewerActivity.this.jta == null || ImageViewerActivity.this.jta.getVisibility() != 0) {
                            ImageViewerActivity.this.czZ();
                            return;
                        }
                        ImageViewerActivity.this.jtd.EJ(str);
                        ImageViewerActivity.this.jtf = null;
                        return;
                    }
                    ImageViewerActivity.this.jtd = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.jtc);
                    ImageViewerActivity.this.jtd.cS(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.jtd.cR(32);
                    ImageViewerActivity.this.jtd.setUseDirectOffset(true);
                    ImageViewerActivity.this.jtd.tq(1);
                    ImageViewerActivity.this.jtd.tr(0);
                    ImageViewerActivity.this.jtd.cT(3000);
                    ImageViewerActivity.this.jtd.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.czZ();
                        }
                    });
                    if (ImageViewerActivity.this.jta == null || ImageViewerActivity.this.jta.getVisibility() == 0) {
                        ImageViewerActivity.this.jtd.EJ(str);
                        return;
                    }
                    ImageViewerActivity.this.jtf = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czZ() {
        if (this.jtd != null) {
            this.jtd.HN();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BIGIMAGE;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.blm().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.eKO, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.ajJ, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Ae(TbadkCoreApplication.getInst().getAdAdSense().epK);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cAa() {
        return this.jty;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (as.isEmpty(this.ajJ)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.ajJ, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
