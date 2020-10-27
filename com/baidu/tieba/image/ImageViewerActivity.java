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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.image.e;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.webkit.internal.ETAG;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpHost;
/* loaded from: classes21.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.c {
    private String alT;
    private Map<String, ImageUrlData> fee;
    private String fsZ;
    private String gew;
    private VoiceManager iBr;
    private View iDR;
    private com.baidu.tieba.frs.profession.permission.c iFN;
    private ImageView jAO;
    private String krL;
    private String krM;
    private int krP;
    private boolean ksA;
    private String ksJ;
    private float ksO;
    private SortSwitchButton ksh;
    private View ksi;
    private HeadImageView ksj;
    private TBLottieAnimationView ksk;
    private com.baidu.tieba.c.e ksl;
    private String ksn;
    private MultiImageView kso;
    private LinearLayout ksp;
    private com.baidu.tieba.image.a.c ksq;
    private ArrayList<String> ksr;
    private e kss;
    private i kst;
    private j ksu;
    private com.baidu.tieba.c.e ksv;
    private int ksz;
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
    private boolean ksm = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a ksw = null;
    private boolean ksx = false;
    private boolean ksy = false;
    private int ZQ = 0;
    private boolean ksB = false;
    private boolean ksC = true;
    private boolean fcX = true;
    private boolean ksD = true;
    private boolean mIsSeeHost = false;
    private boolean ksE = false;
    private boolean ksF = false;
    private boolean ksG = false;
    private boolean krN = false;
    private boolean ksH = true;
    private boolean fcV = false;
    private boolean ksI = true;
    private boolean krO = false;
    private CustomMessageListener ksK = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.cVl();
            }
        }
    };
    private final CustomMessageListener ksL = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.fgu)) {
                    be.boR().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    be.boR().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.fgu});
                }
            }
        }
    };
    private DragImageView.d feG = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.s(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.s(ImageViewerActivity.this.ksh, 8);
            ImageViewerActivity.this.s(ImageViewerActivity.this.iDR, 8);
            ImageViewerActivity.this.s(ImageViewerActivity.this.ksi, 8);
            if (ImageViewerActivity.this.kso != null) {
                ImageViewerActivity.this.kso.jG(false);
            }
            ImageViewerActivity.this.cVj();
            ImageViewerActivity.this.cVl();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new aq("c13341").aj("obj_param1", ImageViewerActivity.this.kso.getItemNum()).aj(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kso.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bBL() {
            ImageViewerActivity.this.s(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.iDR.setVisibility(0);
            if (ImageViewerActivity.this.kso != null && !ImageViewerActivity.this.cVg()) {
                boolean bvu = ImageViewerActivity.this.kso.bvu();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bvu) {
                    ImageViewerActivity.this.s(ImageViewerActivity.this.ksh, 0);
                    ImageViewerActivity.this.s(ImageViewerActivity.this.ksi, 0);
                    ImageViewerActivity.this.Nl(ImageViewerActivity.this.ksn);
                    if (ImageViewerActivity.this.ksI) {
                        ImageViewerActivity.this.kso.jG(true);
                    } else {
                        ImageViewerActivity.this.kso.jG(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener ksM = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13857").dR("obj_type", "3").dR("post_id", ImageViewerActivity.this.alT).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fsZ));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.iFN == null) {
                    ImageViewerActivity.this.iFN = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.iFN.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void pz(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void C(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void pA(boolean z) {
                            if (z && ImageViewerActivity.this.ksq != null && ImageViewerActivity.this.kso.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.ksq.b(ImageViewerActivity.this.kso.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kss);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.iFN.zP((ImageViewerActivity.this.kso == null || ImageViewerActivity.this.kso.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kso.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kso.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.iFN.G(ImageViewerActivity.this.fsZ, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.alT, 0L));
            }
        }
    };
    private UrlDragImageView.b fcO = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bvM() {
            TiebaStatic.log(new aq("c10351").dR("tid", ImageViewerActivity.this.alT).dR("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a ksN = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zj(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.ksA = true;
                if (ImageViewerActivity.this.ksh != null) {
                    ImageViewerActivity.this.ksh.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.Nh((String) y.getItem(ImageViewerActivity.this.ksr, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new aq("c13857").aj("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dR("post_id", ImageViewerActivity.this.alT).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fsZ));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13341").aj("obj_param1", ImageViewerActivity.this.kso.getItemNum()).aj(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kso.getCurrentMaxIndex()));
            TiebaStatic.log(new aq("c13377").dR("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener feS = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.ksO = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.ksO = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener ksP = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.ksu != null) {
                ImageViewerActivity.this.ksu.coP();
                ImageViewerActivity.this.ksu.show();
                ImageViewerActivity.this.ksu.cR(view);
            }
            TiebaStatic.log(new aq("c13269").dR("uid", ImageViewerActivity.this.mUserId).dR("fid", ImageViewerActivity.this.fsZ).dR("tid", ImageViewerActivity.this.alT));
            return true;
        }
    };
    private BaseViewPager.a ksQ = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kss.cUL();
            } else if (ImageViewerActivity.this.cVe() != 1) {
                ImageViewerActivity.this.kss.cUM();
            }
        }
    };
    private ViewPager.OnPageChangeListener cnN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kss != null && i > ImageViewerActivity.this.kso.getItemNum() - 5) {
                ImageViewerActivity.this.kss.cUL();
            }
            ImageViewerActivity.this.kst.e(ImageViewerActivity.this.ksr, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.cVf();
            ImageViewerActivity.this.cVk();
            ImageViewerActivity.this.DA(i);
            if (ImageViewerActivity.this.kst.cVn() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kst.DD(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kst.cVo() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kst.DE(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.cVg()) {
                ImageViewerActivity.this.ksw.cUF();
            }
            if (ImageViewerActivity.this.ksu != null) {
                ImageViewerActivity.this.ksu.cVr();
            }
            if (ImageViewerActivity.this.ksq != null && ImageViewerActivity.this.kso.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.ksq.a(ImageViewerActivity.this.kso.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kss);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.ZQ) {
                ImageViewerActivity.this.ZQ = i;
            } else if (i < ImageViewerActivity.this.ZQ) {
                ImageViewerActivity.this.ZQ = i;
            }
            if (ImageViewerActivity.this.kso != null) {
                dragImageView = ImageViewerActivity.this.kso.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cVe() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.cVl();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.ksr != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.ksr.size()) {
                ImageViewerActivity.this.kst.by(i, (String) ImageViewerActivity.this.ksr.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener ksR = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.elz).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.elI).append("?").append(com.baidu.tbadk.BdToken.f.emb).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.emc).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new aq("c13711").dR("fid", ImageViewerActivity.this.fsZ).dR("fname", ImageViewerActivity.this.gew).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", ImageViewerActivity.this.alT).dR("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fee != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fee.values()) {
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
    private CustomMessageListener eLt = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fee != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fee.values()) {
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
    public void s(View view, int i) {
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
        com.baidu.tbadk.mutiprocess.g.byU().init(TbadkCoreApplication.getInst());
        this.ksz = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cFU();
        k(this.krM, this.mIsSeeHost, false);
        registerListener(this.ksL);
        registerListener(this.ksK);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.eLt);
        this.iBr = getVoiceManager();
        this.iBr.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
        if (this.ksw != null) {
            this.ksw.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kss = new e(this.ksr, this.fee, this.fsZ, this.gew, this.alT, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.krP, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kss.setSourceImageRectInScreen(this.krL);
        this.kss.sx(this.ksH);
        this.kss.sy(z);
        this.kss.Nj(this.krM);
        this.kss.sw(this.krN);
        this.kss.setPostId(this.mPostId);
        this.kss.sA(this.krO);
        this.kss.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kso != null) {
                    if (ImageViewerActivity.this.ksA) {
                        if (!z5) {
                            ImageViewerActivity.this.kso.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.ksA = false;
                    if (ImageViewerActivity.this.ksh != null) {
                        ImageViewerActivity.this.ksh.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kso.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kso.getItemNum();
                        ImageViewerActivity.this.kso.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kso.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kso.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.ksw != null) {
                        ImageViewerActivity.this.ksw.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.kso.setUrlData(arrayList);
                    ImageViewerActivity.this.kso.setAssistUrls(ImageViewerActivity.this.fee);
                    ImageViewerActivity.this.kso.setHasNext(z3);
                    ImageViewerActivity.this.kso.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kso.getItemNum()) {
                        ImageViewerActivity.this.kso.qM(ImageViewerActivity.this.kso.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kso.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kso.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kso.setUrlData(arrayList);
                        ImageViewerActivity.this.kso.setCurrentItem(ImageViewerActivity.this.kso.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.cVe() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.cVf();
                    if (ImageViewerActivity.this.ksq != null && ImageViewerActivity.this.kso.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.ksq.a(ImageViewerActivity.this.kso.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kss);
                    }
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.kso.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.ksw.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.ksw.cUy()) {
                    ImageViewerActivity.this.kso.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.kso.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bx(int i, String str2) {
                ImageViewerActivity.this.ksA = false;
                if (ImageViewerActivity.this.ksh != null) {
                    if (ImageViewerActivity.this.ksh.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.ksh.jF(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.ksh.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.ksr != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.ksr.size();
                    }
                    ImageViewerActivity.this.cVf();
                }
            }
        });
        this.kss.sz(true);
        this.kss.cUL();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
            TiebaStatic.log(new aq("c13377").dR("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kso.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kso.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.ksz = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        DC(i);
        if (this.ksu != null) {
            this.ksu.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iBr != null) {
            this.iBr.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iBr != null) {
            this.iBr.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kso.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alT, 0L);
        if (uniqueId != null && j > 0) {
            r.s(uniqueId.getId(), j);
        }
        if (this.iBr != null) {
            this.iBr.onPause(getPageContext());
        }
        this.ksq.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kso.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alT, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.ekr, uniqueId.getId(), j);
        }
        if (this.iBr != null) {
            this.iBr.onResume(getPageContext());
        }
        this.ksq.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kso.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.ksL);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.byE().releaseBlockBitmapPool();
        this.kst.e(this.ksr, this.mIndex, this.mIndex);
        this.kst.cVp();
        String str3 = "";
        if (this.ksw != null) {
            str3 = this.ksw.getAdId();
        }
        if (this.kss != null) {
            str = this.kss.blI();
            str2 = this.kss.blJ();
        } else {
            str = null;
        }
        this.kst.a(this.kso.getPageCount(), str3, this.fsZ, this.alT, str, str2);
        if (this.ksu != null) {
            this.ksu.release();
        }
        this.kso.onDestroy();
        this.ksq.onDestroy();
        if (this.iBr != null) {
            this.iBr.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bwU().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.ksz);
        cVj();
        cVl();
        if (this.ksw != null) {
            this.ksw.onDestroy();
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

    private void cFU() {
        bAw();
        this.ksu = new j(this);
        initViewPager();
        this.ksu.j(this.kso);
        cVf();
        cqn();
        cVb();
        cVa();
        this.kst.e(this.ksr, this.mIndex, this.mIndex);
    }

    private void cVa() {
        this.ksp = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.ksq = new com.baidu.tieba.image.a.c(getPageContext(), this.ksp);
        this.ksq.setFromForumId(this.ksJ);
    }

    private void cVb() {
        if (com.baidu.tbadk.core.util.g.bnQ()) {
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
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    ImageViewerActivity.this.setFullScreen();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.ksq.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void bAw() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cVc();
        bRx();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.Ni((String) y.getItem(this.ksr, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cVc() {
        this.iDR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iDR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.jAO = (ImageView) this.iDR.findViewById(R.id.widget_navi_back_button);
        SvgManager.boN().a(this.jAO, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iDR.setVisibility(0);
    }

    private void bRx() {
        if (!this.ksF && !this.ksE) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.ksi = addCustomView.findViewById(R.id.view_user_photo);
            this.ksj = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.ksk = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.ksj.setIsRound(true);
            this.ksj.setPlaceHolder(1);
            if (this.ksD) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.Jr(0);
                pVar.SB(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.Jr(1);
                pVar2.SB(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.ksh = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.ksh.setNeedDayNight(false);
                this.ksh.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.ksh.setVisibility(0);
                this.ksh.setOnSwitchChangeListener(this.ksN);
                s(this.ksi, 0);
                return;
            }
            s(this.ksh, 8);
            s(this.ksi, 8);
        }
    }

    public Map<String, ImageUrlData> cVd() {
        return this.fee;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cVe() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.ksr, this.mIndex);
        if (this.fee == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fee.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVf() {
        String str;
        if (this.ksr != null) {
            long cVe = cVe();
            String str2 = ("" + cVe) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.ksB && cVe() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new aq("c13316").dR("obj_source", this.mFrom));
                this.ksB = true;
            }
            if (cVg()) {
                cVh();
            } else {
                Nk(str);
            }
            long j = cVe - 1;
            DB(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVg() {
        if (this.ksC && this.ksw != null && this.ksw.cUy()) {
            return this.kso.getItemNum() != 1 && this.mIndex == this.kso.getItemNum() + (-1);
        }
        return false;
    }

    private void Nk(String str) {
        this.mTitleView.setText(str);
        if (this.ksD && !this.ksE && this.ksh != null) {
            this.ksh.jF(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void cVh() {
        this.mTitleView.setText("");
        s(this.ksh, 8);
        s(this.ksi, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kso == null) {
            this.kso = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kso.init();
        }
        this.kso.setIsFromCDN(this.fcV);
        this.kso.setIsCanDrag(this.fcX);
        this.kso.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kso.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kso.setOnPageChangeListener(this.cnN);
        this.kso.setUrlData(this.ksr);
        this.kso.setAssistUrls(this.fee);
        this.kso.setOuterOnTouchListener(this.feS);
        this.kso.setItemOnclickListener(this.mOnClickListener);
        this.kso.setItemOnLongClickListener(this.ksP);
        this.kso.setCurrentItem(cLF(), false);
        this.kso.setOnScrollOutListener(this.ksQ);
        this.ksw = new a(this.fcV, this.ksC, getPageContext(), this.fsZ, this.alT);
        this.ksw.setDragToExitListener(this.feG);
        this.kso.a(this.ksw);
        this.kso.setOriImgSelectedCallback(this.fcO);
        this.kso.setDragToExitListener(this.feG);
        this.kso.setUserId(this.mUserId);
        this.kso.setShowBottomContainer(this.ksI);
        this.kso.setOnShareImageListener(this.ksu);
        this.kso.setOnDownloadImageListener(this.ksu);
        this.kso.setOnReplyClickListener(this.ksM);
        TiebaStatic.log(new aq("c13340").dR("uid", this.mUserId).dR("post_id", this.alT).aj("obj_source", cVi()));
    }

    private int cVi() {
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

    private void cqn() {
        if (!this.ksE && this.ksh != null) {
            if (this.ksv == null) {
                this.ksv = new com.baidu.tieba.c.e(getPageContext(), this.ksh);
                this.ksv.fh(R.drawable.pic_sign_tip);
                this.ksv.fg(48);
                this.ksv.setUseDirectOffset(true);
                this.ksv.fi(5000);
                this.ksv.xd(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.ksv.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.cVj();
                    }
                });
            }
            this.ksv.aL(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVj() {
        if (this.ksv != null) {
            this.ksv.Qh();
        }
    }

    public int cLF() {
        int count = y.getCount(this.ksr);
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
        this.kst = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.ksF = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.ksr = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fsZ = bundle.getString("fid");
            this.alT = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.gew = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.fcV = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.ksH = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.ksC = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.fcX = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.ksD = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.krL = bundle.getString("source_rect_in_screen");
            this.krN = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.ksI = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.krO = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.fee = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fee.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.ksG = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.ksE = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.krP = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.ksJ = bundle.getString("from_forum_id");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.ksF = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.ksr = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fsZ = intent.getStringExtra("fid");
                this.alT = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.gew = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.fcV = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.ksH = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.ksC = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.fcX = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.ksD = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.ksI = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.krO = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.ksG = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.ksE = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.krL = intent.getStringExtra("source_rect_in_screen");
                this.krN = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.fee = (Map) serializableExtra;
                }
                this.krP = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.ksJ = intent.getStringExtra("from_forum_id");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.kh(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.kst.b(bundle, getIntent());
        this.mCount = y.getCount(this.ksr);
        if (this.krL != null) {
            String str = (String) y.getItem(this.ksr, this.mIndex);
            if (!StringUtils.isNull(str) && this.fee != null && (imageUrlData = this.fee.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.krL);
            }
        }
        this.krM = this.ksF ? null : d.Nh((String) y.getItem(this.ksr, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new aq("c13337").dR("obj_type", "2"));
        } else {
            TiebaStatic.log(new aq("c13337").dR("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.ksF);
        bundle.putStringArrayList("url", this.ksr);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fsZ);
        bundle.putString("tid", this.alT);
        bundle.putString("fname", this.gew);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.ksH);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.fcX);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.ksD);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.ksC);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.ksI);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.krO);
        if (this.fee instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fee.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fee instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fee.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.krL);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.ksG);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.ksE);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.krN);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.ksJ);
        this.kst.ay(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kso.setCurrentItem(this.mIndex, false);
        SvgManager.boN().a(this.jAO, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DA(int i) {
        if (this.kso != null) {
            this.kso.qL(i);
            int i2 = (this.kso.bvu() || cVg()) ? 8 : 0;
            s(this.ksh, i2);
            s(this.ksi, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVk() {
        if (cVg()) {
            this.ksy = this.mNavigationBar.getVisibility() == 0;
            this.ksx = true;
        } else if (this.ksx) {
            this.mNavigationBar.setVisibility(this.ksy ? 0 : 8);
            this.ksx = false;
        }
    }

    private void DB(int i) {
        if (this.kss != null) {
            ArrayList<AlaInfoData> cUK = this.kss.cUK();
            if (cUK != null && cUK.size() > 0) {
                sB(true);
                b(cUK.get(i % cUK.size()));
                return;
            }
            sB(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.ksj, alaInfoData.user_info.portrait);
            this.ksj.setAlaInfo(alaInfoData);
            this.ksj.setOnClickListener(this.ksR);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                Nl(alaInfoData.tag);
            }
            TiebaStatic.log(new aq("c13710").dR("fid", this.fsZ).dR("fname", this.gew).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.alT).dR("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void sB(boolean z) {
        if (this.ksm != z) {
            if (this.ksk != null) {
                if (z) {
                    this.ksk.setVisibility(0);
                    if (!this.ksk.isAnimating()) {
                        this.ksk.setSpeed(0.8f);
                        this.ksk.setRepeatCount(-1);
                        this.ksk.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.ksk.playAnimation();
                            }
                        });
                    }
                } else {
                    this.ksk.setVisibility(8);
                    if (this.ksk.isAnimating()) {
                        this.ksk.cancelAnimation();
                    }
                }
            }
            if (this.ksj != null) {
                this.ksj.setVisibility(z ? 0 : 8);
            }
            this.ksm = z;
        }
    }

    private void DC(int i) {
        if (this.ksk != null) {
            if (i == 1) {
                this.ksk.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.ksk.setAnimation("live/card_live_bg_black.json");
            } else {
                this.ksk.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nl(@NonNull final String str) {
        if (this.ksk != null) {
            this.ksk.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.ksl != null) {
                        if (ImageViewerActivity.this.ksn == null || ImageViewerActivity.this.ksl == null || ImageViewerActivity.this.ksi == null || ImageViewerActivity.this.ksi.getVisibility() != 0) {
                            ImageViewerActivity.this.cVl();
                            return;
                        }
                        ImageViewerActivity.this.ksl.IS(str);
                        ImageViewerActivity.this.ksn = null;
                        return;
                    }
                    ImageViewerActivity.this.ksl = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.ksk);
                    ImageViewerActivity.this.ksl.fh(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.ksl.fg(32);
                    ImageViewerActivity.this.ksl.setUseDirectOffset(true);
                    ImageViewerActivity.this.ksl.xc(1);
                    ImageViewerActivity.this.ksl.xd(0);
                    ImageViewerActivity.this.ksl.fi(3000);
                    ImageViewerActivity.this.ksl.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.cVl();
                        }
                    });
                    if (ImageViewerActivity.this.ksi == null || ImageViewerActivity.this.ksi.getVisibility() == 0) {
                        ImageViewerActivity.this.ksl.IS(str);
                        return;
                    }
                    ImageViewerActivity.this.ksn = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVl() {
        if (this.ksl != null) {
            this.ksl.Qh();
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
                return com.baidu.tbadk.m.e.bzH().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fsZ, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.alT, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DW(TbadkCoreApplication.getInst().getAdAdSense().eWH);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cVm() {
        return this.ksF;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (at.isEmpty(this.alT)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.alT, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iBr == null) {
            this.iBr = VoiceManager.instance();
        }
        return this.iBr;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
