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
/* loaded from: classes20.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.c {
    private String alA;
    private Map<String, ImageUrlData> eJB;
    private String eYo;
    private String fIi;
    private VoiceManager hZU;
    private ImageView iZp;
    private View icu;
    private com.baidu.tieba.frs.profession.permission.c ieu;
    private SortSwitchButton jQK;
    private View jQL;
    private HeadImageView jQM;
    private TBLottieAnimationView jQN;
    private com.baidu.tieba.c.e jQO;
    private String jQQ;
    private MultiImageView jQR;
    private LinearLayout jQS;
    private com.baidu.tieba.image.a.c jQT;
    private ArrayList<String> jQU;
    private e jQV;
    private i jQW;
    private j jQX;
    private com.baidu.tieba.c.e jQY;
    private String jQo;
    private String jQp;
    private int jQs;
    private int jRc;
    private boolean jRd;
    private String jRm;
    private float jRr;
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
    private boolean jQP = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a jQZ = null;
    private boolean jRa = false;
    private boolean jRb = false;
    private int Zz = 0;
    private boolean jRe = false;
    private boolean jRf = true;
    private boolean eIt = true;
    private boolean jRg = true;
    private boolean mIsSeeHost = false;
    private boolean jRh = false;
    private boolean jRi = false;
    private boolean jRj = false;
    private boolean jQq = false;
    private boolean jRk = true;
    private boolean eIr = false;
    private boolean jRl = true;
    private boolean jQr = false;
    private CustomMessageListener jRn = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.cOw();
            }
        }
    };
    private final CustomMessageListener jRo = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.eLR)) {
                    be.bkp().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    be.bkp().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.eLR});
                }
            }
        }
    };
    private DragImageView.d eKd = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.q(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.q(ImageViewerActivity.this.jQK, 8);
            ImageViewerActivity.this.q(ImageViewerActivity.this.icu, 8);
            ImageViewerActivity.this.q(ImageViewerActivity.this.jQL, 8);
            if (ImageViewerActivity.this.jQR != null) {
                ImageViewerActivity.this.jQR.iV(false);
            }
            ImageViewerActivity.this.cOu();
            ImageViewerActivity.this.cOw();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new aq("c13341").ai("obj_param1", ImageViewerActivity.this.jQR.getItemNum()).ai(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jQR.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bxi() {
            ImageViewerActivity.this.q(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.icu.setVisibility(0);
            if (ImageViewerActivity.this.jQR != null && !ImageViewerActivity.this.cOr()) {
                boolean bqR = ImageViewerActivity.this.jQR.bqR();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bqR) {
                    ImageViewerActivity.this.q(ImageViewerActivity.this.jQK, 0);
                    ImageViewerActivity.this.q(ImageViewerActivity.this.jQL, 0);
                    ImageViewerActivity.this.LY(ImageViewerActivity.this.jQQ);
                    if (ImageViewerActivity.this.jRl) {
                        ImageViewerActivity.this.jQR.iV(true);
                    } else {
                        ImageViewerActivity.this.jQR.iV(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener jRp = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13857").dF("obj_type", "3").dF("post_id", ImageViewerActivity.this.alA).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", ImageViewerActivity.this.eYo));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.ieu == null) {
                    ImageViewerActivity.this.ieu = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.ieu.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void oC(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void z(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void oD(boolean z) {
                            if (z && ImageViewerActivity.this.jQT != null && ImageViewerActivity.this.jQR.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.jQT.b(ImageViewerActivity.this.jQR.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.jQV);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.ieu.yQ((ImageViewerActivity.this.jQR == null || ImageViewerActivity.this.jQR.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.jQR.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.jQR.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.ieu.D(ImageViewerActivity.this.eYo, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.alA, 0L));
            }
        }
    };
    private UrlDragImageView.b eIk = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void brj() {
            TiebaStatic.log(new aq("c10351").dF("tid", ImageViewerActivity.this.alA).dF("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a jRq = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean yk(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.jRd = true;
                if (ImageViewerActivity.this.jQK != null) {
                    ImageViewerActivity.this.jQK.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.LU((String) y.getItem(ImageViewerActivity.this.jQU, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new aq("c13857").ai("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dF("post_id", ImageViewerActivity.this.alA).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", ImageViewerActivity.this.eYo));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13341").ai("obj_param1", ImageViewerActivity.this.jQR.getItemNum()).ai(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jQR.getCurrentMaxIndex()));
            TiebaStatic.log(new aq("c13377").dF("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener eKp = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.jRr = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.jRr = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener jRs = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.jQX != null) {
                ImageViewerActivity.this.jQX.cim();
                ImageViewerActivity.this.jQX.show();
                ImageViewerActivity.this.jQX.cJ(view);
            }
            TiebaStatic.log(new aq("c13269").dF("uid", ImageViewerActivity.this.mUserId).dF("fid", ImageViewerActivity.this.eYo).dF("tid", ImageViewerActivity.this.alA));
            return true;
        }
    };
    private BaseViewPager.a jRt = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.jQV.cNW();
            } else if (ImageViewerActivity.this.cOp() != 1) {
                ImageViewerActivity.this.jQV.cNX();
            }
        }
    };
    private ViewPager.OnPageChangeListener bTa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.jQV != null && i > ImageViewerActivity.this.jQR.getItemNum() - 5) {
                ImageViewerActivity.this.jQV.cNW();
            }
            ImageViewerActivity.this.jQW.e(ImageViewerActivity.this.jQU, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.cOq();
            ImageViewerActivity.this.cOv();
            ImageViewerActivity.this.CB(i);
            if (ImageViewerActivity.this.jQW.cOy() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jQW.CE(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.jQW.cOz() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jQW.CF(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.cOr()) {
                ImageViewerActivity.this.jQZ.cNQ();
            }
            if (ImageViewerActivity.this.jQX != null) {
                ImageViewerActivity.this.jQX.cOC();
            }
            if (ImageViewerActivity.this.jQT != null && ImageViewerActivity.this.jQR.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.jQT.a(ImageViewerActivity.this.jQR.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.jQV);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.Zz) {
                ImageViewerActivity.this.Zz = i;
            } else if (i < ImageViewerActivity.this.Zz) {
                ImageViewerActivity.this.Zz = i;
            }
            if (ImageViewerActivity.this.jQR != null) {
                dragImageView = ImageViewerActivity.this.jQR.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cOp() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.cOw();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.jQU != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.jQU.size()) {
                ImageViewerActivity.this.jQW.bn(i, (String) ImageViewerActivity.this.jQU.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener jRu = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.dRc).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.dRl).append("?").append(com.baidu.tbadk.BdToken.f.dRE).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.dRF).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new aq("c13711").dF("fid", ImageViewerActivity.this.eYo).dF("fname", ImageViewerActivity.this.fIi).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", ImageViewerActivity.this.alA).dF("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eJB != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eJB.values()) {
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
    private CustomMessageListener eqL = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eJB != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eJB.values()) {
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
    public void q(View view, int i) {
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
        com.baidu.tbadk.mutiprocess.g.bur().init(TbadkCoreApplication.getInst());
        this.jRc = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        czq();
        k(this.jQp, this.mIsSeeHost, false);
        registerListener(this.jRo);
        registerListener(this.jRn);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.eqL);
        this.hZU = getVoiceManager();
        this.hZU.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
        if (this.jQZ != null) {
            this.jQZ.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.jQV = new e(this.jQU, this.eJB, this.eYo, this.fIi, this.alA, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.jQs, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.jQV.setSourceImageRectInScreen(this.jQo);
        this.jQV.rz(this.jRk);
        this.jQV.rA(z);
        this.jQV.LW(this.jQp);
        this.jQV.ry(this.jQq);
        this.jQV.setPostId(this.mPostId);
        this.jQV.rC(this.jQr);
        this.jQV.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.jQR != null) {
                    if (ImageViewerActivity.this.jRd) {
                        if (!z5) {
                            ImageViewerActivity.this.jQR.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.jRd = false;
                    if (ImageViewerActivity.this.jQK != null) {
                        ImageViewerActivity.this.jQK.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.jQR.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.jQR.getItemNum();
                        ImageViewerActivity.this.jQR.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.jQR.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.jQR.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.jQZ != null) {
                        ImageViewerActivity.this.jQZ.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.jQR.setUrlData(arrayList);
                    ImageViewerActivity.this.jQR.setAssistUrls(ImageViewerActivity.this.eJB);
                    ImageViewerActivity.this.jQR.setHasNext(z3);
                    ImageViewerActivity.this.jQR.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.jQR.getItemNum()) {
                        ImageViewerActivity.this.jQR.qd(ImageViewerActivity.this.jQR.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.jQR.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.jQR.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.jQR.setUrlData(arrayList);
                        ImageViewerActivity.this.jQR.setCurrentItem(ImageViewerActivity.this.jQR.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.cOp() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.cOq();
                    if (ImageViewerActivity.this.jQT != null && ImageViewerActivity.this.jQR.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.jQT.a(ImageViewerActivity.this.jQR.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.jQV);
                    }
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.jQR.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.jQZ.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.jQZ.cNJ()) {
                    ImageViewerActivity.this.jQR.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.jQR.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bm(int i, String str2) {
                ImageViewerActivity.this.jRd = false;
                if (ImageViewerActivity.this.jQK != null) {
                    if (ImageViewerActivity.this.jQK.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.jQK.iX(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.jQK.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.jQU != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.jQU.size();
                    }
                    ImageViewerActivity.this.cOq();
                }
            }
        });
        this.jQV.rB(true);
        this.jQV.cNW();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
            TiebaStatic.log(new aq("c13377").dF("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jQR.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.jQR.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.jRc = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        CD(i);
        if (this.jQX != null) {
            this.jQX.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hZU != null) {
            this.hZU.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hZU != null) {
            this.hZU.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jQR.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alA, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
        if (this.hZU != null) {
            this.hZU.onPause(getPageContext());
        }
        this.jQT.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jQR.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alA, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.dPU, uniqueId.getId(), j);
        }
        if (this.hZU != null) {
            this.hZU.onResume(getPageContext());
        }
        this.jQT.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.jQR.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.jRo);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bub().releaseBlockBitmapPool();
        this.jQW.e(this.jQU, this.mIndex, this.mIndex);
        this.jQW.cOA();
        String str3 = "";
        if (this.jQZ != null) {
            str3 = this.jQZ.getAdId();
        }
        if (this.jQV != null) {
            str = this.jQV.bhg();
            str2 = this.jQV.bhh();
        } else {
            str = null;
        }
        this.jQW.a(this.jQR.getPageCount(), str3, this.eYo, this.alA, str, str2);
        if (this.jQX != null) {
            this.jQX.release();
        }
        this.jQR.onDestroy();
        this.jQT.onDestroy();
        if (this.hZU != null) {
            this.hZU.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bsr().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.jRc);
        cOu();
        cOw();
        if (this.jQZ != null) {
            this.jQZ.onDestroy();
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

    private void czq() {
        bvT();
        this.jQX = new j(this);
        initViewPager();
        this.jQX.j(this.jQR);
        cOq();
        cjK();
        cOm();
        cOl();
        this.jQW.e(this.jQU, this.mIndex, this.mIndex);
    }

    private void cOl() {
        this.jQS = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.jQT = new com.baidu.tieba.image.a.c(getPageContext(), this.jQS);
        this.jQT.setFromForumId(this.jRm);
    }

    private void cOm() {
        if (com.baidu.tbadk.core.util.g.bjo()) {
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
        this.jQT.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void bvT() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cOn();
        bMi();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.LV((String) y.getItem(this.jQU, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cOn() {
        this.icu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.icu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.iZp = (ImageView) this.icu.findViewById(R.id.widget_navi_back_button);
        SvgManager.bkl().a(this.iZp, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.icu.setVisibility(0);
    }

    private void bMi() {
        if (!this.jRi && !this.jRh) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.jQL = addCustomView.findViewById(R.id.view_user_photo);
            this.jQM = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.jQN = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.jQM.setIsRound(true);
            this.jQM.setPlaceHolder(1);
            if (this.jRg) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.It(0);
                pVar.Ro(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.It(1);
                pVar2.Ro(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.jQK = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.jQK.setNeedDayNight(false);
                this.jQK.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.jQK.setVisibility(0);
                this.jQK.setOnSwitchChangeListener(this.jRq);
                q(this.jQL, 0);
                return;
            }
            q(this.jQK, 8);
            q(this.jQL, 8);
        }
    }

    public Map<String, ImageUrlData> cOo() {
        return this.eJB;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cOp() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.jQU, this.mIndex);
        if (this.eJB == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eJB.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOq() {
        String str;
        if (this.jQU != null) {
            long cOp = cOp();
            String str2 = ("" + cOp) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.jRe && cOp() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new aq("c13316").dF("obj_source", this.mFrom));
                this.jRe = true;
            }
            if (cOr()) {
                cOs();
            } else {
                LX(str);
            }
            long j = cOp - 1;
            CC(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cOr() {
        if (this.jRf && this.jQZ != null && this.jQZ.cNJ()) {
            return this.jQR.getItemNum() != 1 && this.mIndex == this.jQR.getItemNum() + (-1);
        }
        return false;
    }

    private void LX(String str) {
        this.mTitleView.setText(str);
        if (this.jRg && !this.jRh && this.jQK != null) {
            this.jQK.iX(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void cOs() {
        this.mTitleView.setText("");
        q(this.jQK, 8);
        q(this.jQL, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.jQR == null) {
            this.jQR = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.jQR.init();
        }
        this.jQR.setIsFromCDN(this.eIr);
        this.jQR.setIsCanDrag(this.eIt);
        this.jQR.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.jQR.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.jQR.setOnPageChangeListener(this.bTa);
        this.jQR.setUrlData(this.jQU);
        this.jQR.setAssistUrls(this.eJB);
        this.jQR.setOuterOnTouchListener(this.eKp);
        this.jQR.setItemOnclickListener(this.mOnClickListener);
        this.jQR.setItemOnLongClickListener(this.jRs);
        this.jQR.setCurrentItem(cEP(), false);
        this.jQR.setOnScrollOutListener(this.jRt);
        this.jQZ = new a(this.eIr, this.jRf, getPageContext(), this.eYo, this.alA);
        this.jQZ.setDragToExitListener(this.eKd);
        this.jQR.a(this.jQZ);
        this.jQR.setOriImgSelectedCallback(this.eIk);
        this.jQR.setDragToExitListener(this.eKd);
        this.jQR.setUserId(this.mUserId);
        this.jQR.setShowBottomContainer(this.jRl);
        this.jQR.setOnShareImageListener(this.jQX);
        this.jQR.setOnDownloadImageListener(this.jQX);
        this.jQR.setOnReplyClickListener(this.jRp);
        TiebaStatic.log(new aq("c13340").dF("uid", this.mUserId).dF("post_id", this.alA).ai("obj_source", cOt()));
    }

    private int cOt() {
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

    private void cjK() {
        if (!this.jRh && this.jQK != null) {
            if (this.jQY == null) {
                this.jQY = new com.baidu.tieba.c.e(getPageContext(), this.jQK);
                this.jQY.eW(R.drawable.pic_sign_tip);
                this.jQY.eV(48);
                this.jQY.setUseDirectOffset(true);
                this.jQY.eX(5000);
                this.jQY.we(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.jQY.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.cOu();
                    }
                });
            }
            this.jQY.aG(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOu() {
        if (this.jQY != null) {
            this.jQY.Oj();
        }
    }

    public int cEP() {
        int count = y.getCount(this.jQU);
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
        this.jQW = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.jRi = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.jQU = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eYo = bundle.getString("fid");
            this.alA = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.fIi = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.eIr = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.jRk = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.jRf = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.eIt = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.jRg = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.jQo = bundle.getString("source_rect_in_screen");
            this.jQq = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.jRl = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.jQr = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.eJB = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eJB.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.jRj = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.jRh = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.jQs = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.jRm = bundle.getString("from_forum_id");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.jRi = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.jQU = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eYo = intent.getStringExtra("fid");
                this.alA = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.fIi = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.eIr = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.jRk = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.jRf = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.eIt = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.jRg = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.jRl = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.jQr = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.jRj = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.jRh = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.jQo = intent.getStringExtra("source_rect_in_screen");
                this.jQq = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.eJB = (Map) serializableExtra;
                }
                this.jQs = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.jRm = intent.getStringExtra("from_forum_id");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.jw(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.jQW.b(bundle, getIntent());
        this.mCount = y.getCount(this.jQU);
        if (this.jQo != null) {
            String str = (String) y.getItem(this.jQU, this.mIndex);
            if (!StringUtils.isNull(str) && this.eJB != null && (imageUrlData = this.eJB.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.jQo);
            }
        }
        this.jQp = this.jRi ? null : d.LU((String) y.getItem(this.jQU, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new aq("c13337").dF("obj_type", "2"));
        } else {
            TiebaStatic.log(new aq("c13337").dF("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.jRi);
        bundle.putStringArrayList("url", this.jQU);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eYo);
        bundle.putString("tid", this.alA);
        bundle.putString("fname", this.fIi);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.jRk);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.eIt);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.jRg);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.jRf);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.jRl);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.jQr);
        if (this.eJB instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eJB.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eJB instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eJB.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.jQo);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.jRj);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.jRh);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.jQq);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.jRm);
        this.jQW.ay(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jQR.setCurrentItem(this.mIndex, false);
        SvgManager.bkl().a(this.iZp, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CB(int i) {
        if (this.jQR != null) {
            this.jQR.qc(i);
            int i2 = (this.jQR.bqR() || cOr()) ? 8 : 0;
            q(this.jQK, i2);
            q(this.jQL, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOv() {
        if (cOr()) {
            this.jRb = this.mNavigationBar.getVisibility() == 0;
            this.jRa = true;
        } else if (this.jRa) {
            this.mNavigationBar.setVisibility(this.jRb ? 0 : 8);
            this.jRa = false;
        }
    }

    private void CC(int i) {
        if (this.jQV != null) {
            ArrayList<AlaInfoData> cNV = this.jQV.cNV();
            if (cNV != null && cNV.size() > 0) {
                rD(true);
                b(cNV.get(i % cNV.size()));
                return;
            }
            rD(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.jQM, alaInfoData.user_info.portrait);
            this.jQM.setAlaInfo(alaInfoData);
            this.jQM.setOnClickListener(this.jRu);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                LY(alaInfoData.tag);
            }
            TiebaStatic.log(new aq("c13710").dF("fid", this.eYo).dF("fname", this.fIi).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", this.alA).dF("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void rD(boolean z) {
        if (this.jQP != z) {
            if (this.jQN != null) {
                if (z) {
                    this.jQN.setVisibility(0);
                    if (!this.jQN.isAnimating()) {
                        this.jQN.setSpeed(0.8f);
                        this.jQN.setRepeatCount(-1);
                        this.jQN.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.jQN.playAnimation();
                            }
                        });
                    }
                } else {
                    this.jQN.setVisibility(8);
                    if (this.jQN.isAnimating()) {
                        this.jQN.cancelAnimation();
                    }
                }
            }
            if (this.jQM != null) {
                this.jQM.setVisibility(z ? 0 : 8);
            }
            this.jQP = z;
        }
    }

    private void CD(int i) {
        if (this.jQN != null) {
            if (i == 1) {
                this.jQN.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.jQN.setAnimation("live/card_live_bg_black.json");
            } else {
                this.jQN.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LY(@NonNull final String str) {
        if (this.jQN != null) {
            this.jQN.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.jQO != null) {
                        if (ImageViewerActivity.this.jQQ == null || ImageViewerActivity.this.jQO == null || ImageViewerActivity.this.jQL == null || ImageViewerActivity.this.jQL.getVisibility() != 0) {
                            ImageViewerActivity.this.cOw();
                            return;
                        }
                        ImageViewerActivity.this.jQO.HG(str);
                        ImageViewerActivity.this.jQQ = null;
                        return;
                    }
                    ImageViewerActivity.this.jQO = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.jQN);
                    ImageViewerActivity.this.jQO.eW(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.jQO.eV(32);
                    ImageViewerActivity.this.jQO.setUseDirectOffset(true);
                    ImageViewerActivity.this.jQO.wd(1);
                    ImageViewerActivity.this.jQO.we(0);
                    ImageViewerActivity.this.jQO.eX(3000);
                    ImageViewerActivity.this.jQO.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.cOw();
                        }
                    });
                    if (ImageViewerActivity.this.jQL == null || ImageViewerActivity.this.jQL.getVisibility() == 0) {
                        ImageViewerActivity.this.jQO.HG(str);
                        return;
                    }
                    ImageViewerActivity.this.jQQ = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOw() {
        if (this.jQO != null) {
            this.jQO.Oj();
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
                return com.baidu.tbadk.m.e.bve().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.eYo, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.alA, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.CR(TbadkCoreApplication.getInst().getAdAdSense().eCe);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cOx() {
        return this.jRi;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (at.isEmpty(this.alA)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.alA, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hZU == null) {
            this.hZU = VoiceManager.instance();
        }
        return this.hZU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
