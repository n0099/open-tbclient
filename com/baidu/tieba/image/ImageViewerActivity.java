package com.baidu.tieba.image;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
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
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.baidu.tbadk.data.k;
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
/* loaded from: classes15.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.c {
    private String ala;
    private Map<String, ImageUrlData> eHu;
    private String eVx;
    private String fEW;
    private ImageView gIr;
    private VoiceManager hSU;
    private View hVu;
    private com.baidu.tieba.frs.profession.permission.c hXq;
    private String jHM;
    private String jHN;
    private int jHQ;
    private int jIA;
    private boolean jIB;
    private String jIK;
    private RelativeLayout.LayoutParams jIL;
    private float jIQ;
    private SortSwitchButton jIi;
    private View jIj;
    private HeadImageView jIk;
    private TBLottieAnimationView jIl;
    private com.baidu.tieba.c.e jIm;
    private String jIo;
    private MultiImageView jIp;
    private LinearLayout jIq;
    private com.baidu.tieba.image.a.c jIr;
    private ArrayList<String> jIs;
    private e jIt;
    private i jIu;
    private j jIv;
    private com.baidu.tieba.c.e jIw;
    private Runnable mDealyResizeRunnable;
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
    private boolean jIn = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a jIx = null;
    private boolean jIy = false;
    private boolean jIz = false;
    private int Zh = 0;
    private boolean jIC = false;
    private boolean jID = true;
    private boolean eGm = true;
    private boolean jIE = true;
    private boolean mIsSeeHost = false;
    private boolean jIF = false;
    private boolean jIG = false;
    private boolean jIH = false;
    private boolean jHO = false;
    private boolean jII = true;
    private boolean eGk = false;
    private boolean jIJ = true;
    private boolean jHP = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private CustomMessageListener jIM = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.cKQ();
            }
        }
    };
    private final CustomMessageListener jIN = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.eJF)) {
                    be.bju().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    be.bju().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.eJF});
                }
            }
        }
    };
    private DragImageView.d eHW = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.p(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.p(ImageViewerActivity.this.jIi, 8);
            ImageViewerActivity.this.p(ImageViewerActivity.this.hVu, 8);
            ImageViewerActivity.this.p(ImageViewerActivity.this.jIj, 8);
            if (ImageViewerActivity.this.jIp != null) {
                ImageViewerActivity.this.jIp.iY(false);
            }
            ImageViewerActivity.this.cKO();
            ImageViewerActivity.this.cKQ();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new aq("c13341").ai("obj_param1", ImageViewerActivity.this.jIp.getItemNum()).ai(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jIp.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bvZ() {
            ImageViewerActivity.this.p(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.hVu.setVisibility(0);
            if (ImageViewerActivity.this.jIp != null) {
                boolean bpX = ImageViewerActivity.this.jIp.bpX();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bpX) {
                    ImageViewerActivity.this.p(ImageViewerActivity.this.jIi, 0);
                    ImageViewerActivity.this.p(ImageViewerActivity.this.jIj, 0);
                    ImageViewerActivity.this.Lw(ImageViewerActivity.this.jIo);
                    if (ImageViewerActivity.this.jIJ) {
                        ImageViewerActivity.this.jIp.iY(true);
                    } else {
                        ImageViewerActivity.this.jIp.iY(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener jIO = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13857").dD("obj_type", "3").dD("post_id", ImageViewerActivity.this.ala).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", ImageViewerActivity.this.eVx));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.hXq == null) {
                    ImageViewerActivity.this.hXq = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.hXq.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.17.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void ow(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void z(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void ox(boolean z) {
                            if (z && ImageViewerActivity.this.jIr != null && ImageViewerActivity.this.jIp.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.jIr.b(ImageViewerActivity.this.jIp.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.jIt);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.hXq.yr((ImageViewerActivity.this.jIp == null || ImageViewerActivity.this.jIp.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.jIp.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.jIp.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.hXq.C(ImageViewerActivity.this.eVx, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.ala, 0L));
            }
        }
    };
    private UrlDragImageView.b eGd = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bqp() {
            TiebaStatic.log(new aq("c10351").dD("tid", ImageViewerActivity.this.ala).dD("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a jIP = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean xL(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.jIB = true;
                if (ImageViewerActivity.this.jIi != null) {
                    ImageViewerActivity.this.jIi.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.Ls((String) y.getItem(ImageViewerActivity.this.jIs, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new aq("c13857").ai("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dD("post_id", ImageViewerActivity.this.ala).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", ImageViewerActivity.this.eVx));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13341").ai("obj_param1", ImageViewerActivity.this.jIp.getItemNum()).ai(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jIp.getCurrentMaxIndex()));
            TiebaStatic.log(new aq("c13377").dD("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener eIi = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.jIQ = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.jIQ = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener jIR = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.jIv != null) {
                ImageViewerActivity.this.jIv.ceX();
                ImageViewerActivity.this.jIv.show();
                ImageViewerActivity.this.jIv.cA(view);
            }
            TiebaStatic.log(new aq("c13269").dD("uid", ImageViewerActivity.this.mUserId).dD("fid", ImageViewerActivity.this.eVx).dD("tid", ImageViewerActivity.this.ala));
            return true;
        }
    };
    private BaseViewPager.a jIS = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.jIt.cKq();
            } else if (ImageViewerActivity.this.cKJ() != 1) {
                ImageViewerActivity.this.jIt.cKr();
            }
        }
    };
    private ViewPager.OnPageChangeListener bRa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.jIt != null && i > ImageViewerActivity.this.jIp.getItemNum() - 5) {
                ImageViewerActivity.this.jIt.cKq();
            }
            ImageViewerActivity.this.jIu.e(ImageViewerActivity.this.jIs, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.cKK();
            ImageViewerActivity.this.cKP();
            ImageViewerActivity.this.Ca(i);
            if (ImageViewerActivity.this.jIu.cKS() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jIu.Cd(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.jIu.cKT() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jIu.Ce(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.cKL()) {
                ImageViewerActivity.this.jIx.cKk();
            }
            if (ImageViewerActivity.this.jIv != null) {
                ImageViewerActivity.this.jIv.cKW();
            }
            if (ImageViewerActivity.this.jIr != null && ImageViewerActivity.this.jIp.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.jIr.a(ImageViewerActivity.this.jIp.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.jIt);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.Zh) {
                ImageViewerActivity.this.Zh = i;
            } else if (i < ImageViewerActivity.this.Zh) {
                ImageViewerActivity.this.Zh = i;
            }
            if (ImageViewerActivity.this.jIp != null) {
                dragImageView = ImageViewerActivity.this.jIp.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cKJ() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.cKQ();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.jIs != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.jIs.size()) {
                ImageViewerActivity.this.jIu.bj(i, (String) ImageViewerActivity.this.jIs.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener jIT = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.dOX).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.dPg).append("?").append(com.baidu.tbadk.BdToken.f.dPy).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.dPz).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new aq("c13711").dD("fid", ImageViewerActivity.this.eVx).dD("fname", ImageViewerActivity.this.fEW).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", ImageViewerActivity.this.ala).dD("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eHu != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eHu.values()) {
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
    private CustomMessageListener eov = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eHu != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eHu.values()) {
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
        com.baidu.tbadk.mutiprocess.g.btn().init(TbadkCoreApplication.getInst());
        this.jIA = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cvX();
        k(this.jHN, this.mIsSeeHost, false);
        registerListener(this.jIN);
        registerListener(this.jIM);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.eov);
        this.hSU = getVoiceManager();
        this.hSU.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
        if (this.jIx != null) {
            this.jIx.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.jIt = new e(this.jIs, this.eHu, this.eVx, this.fEW, this.ala, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.jHQ, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.jIt.setSourceImageRectInScreen(this.jHM);
        this.jIt.rr(this.jII);
        this.jIt.rs(z);
        this.jIt.Lu(this.jHN);
        this.jIt.rq(this.jHO);
        this.jIt.setPostId(this.mPostId);
        this.jIt.ru(this.jHP);
        this.jIt.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.jIp != null) {
                    if (ImageViewerActivity.this.jIB) {
                        if (!z5) {
                            ImageViewerActivity.this.jIp.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.jIB = false;
                    if (ImageViewerActivity.this.jIi != null) {
                        ImageViewerActivity.this.jIi.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.jIp.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.jIp.getItemNum();
                        ImageViewerActivity.this.jIp.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.jIp.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.jIp.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.jIx != null) {
                        ImageViewerActivity.this.jIx.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.jIp.setUrlData(arrayList);
                    ImageViewerActivity.this.jIp.setAssistUrls(ImageViewerActivity.this.eHu);
                    ImageViewerActivity.this.jIp.setHasNext(z3);
                    ImageViewerActivity.this.jIp.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.jIp.getItemNum()) {
                        ImageViewerActivity.this.jIp.pQ(ImageViewerActivity.this.jIp.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.jIp.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.jIp.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.jIp.setUrlData(arrayList);
                        ImageViewerActivity.this.jIp.setCurrentItem(ImageViewerActivity.this.jIp.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.cKJ() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.cKK();
                    if (ImageViewerActivity.this.jIr != null && ImageViewerActivity.this.jIp.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.jIr.a(ImageViewerActivity.this.jIp.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.jIt);
                    }
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.jIp.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.jIx.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.jIx.cKd()) {
                    ImageViewerActivity.this.jIp.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.jIp.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bi(int i, String str2) {
                ImageViewerActivity.this.jIB = false;
                if (ImageViewerActivity.this.jIi != null) {
                    ImageViewerActivity.this.jIi.changeState(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.jIi.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.jIs != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.jIs.size();
                    }
                    ImageViewerActivity.this.cKK();
                }
            }
        });
        this.jIt.rt(true);
        this.jIt.cKq();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!com.baidu.tbadk.util.k.isFastDoubleClick()) {
            TiebaStatic.log(new aq("c13377").dD("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jIp.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.jIp.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.jIA = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        Cc(i);
        if (this.jIv != null) {
            this.jIv.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hSU != null) {
            this.hSU.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hSU != null) {
            this.hSU.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jIp.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ala, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
        if (this.hSU != null) {
            this.hSU.onPause(getPageContext());
        }
        this.jIr.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jIp.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ala, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.dNR, uniqueId.getId(), j);
        }
        if (this.hSU != null) {
            this.hSU.onResume(getPageContext());
        }
        this.jIr.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.jIp.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        MessageManager.getInstance().unRegisterListener(this.jIN);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bsX().releaseBlockBitmapPool();
        this.jIu.e(this.jIs, this.mIndex, this.mIndex);
        this.jIu.cKU();
        String str3 = "";
        if (this.jIx != null) {
            str3 = this.jIx.getAdId();
        }
        if (this.jIt != null) {
            str2 = this.jIt.bgm();
            str = this.jIt.bgn();
        } else {
            str = null;
            str2 = null;
        }
        this.jIu.a(this.jIp.getPageCount(), str3, this.eVx, this.ala, str2, str);
        if (this.jIv != null) {
            this.jIv.release();
        }
        this.jIp.onDestroy();
        this.jIr.onDestroy();
        if (this.hSU != null) {
            this.hSU.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.brs().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.jIA);
        cKO();
        cKQ();
        if (this.jIx != null) {
            this.jIx.onDestroy();
        }
        super.onDestroy();
        if (this.mDealyResizeRunnable != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mDealyResizeRunnable);
            this.mDealyResizeRunnable = null;
        }
        if (this.jIq != null) {
            this.jIq.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
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

    private void cvX() {
        buP();
        this.jIv = new j(this);
        initViewPager();
        this.jIv.j(this.jIp);
        cKK();
        cgt();
        cKG();
        cKF();
        this.jIu.e(this.jIs, this.mIndex, this.mIndex);
    }

    private void cKF() {
        this.jIq = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.jIr = new com.baidu.tieba.image.a.c(getPageContext(), this.jIq);
        this.jIr.setFromForumId(this.jIK);
        if ("HUAWEI".equalsIgnoreCase(Build.BRAND) && "BLA-AL00".equalsIgnoreCase(Build.MODEL)) {
            adjustResizeForSoftInput();
        } else {
            resizeForSoftInput();
        }
    }

    private void resizeForSoftInput() {
        this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            private int mScreenHeight;
            private int usableHeightPrevious;

            /* JADX INFO: Access modifiers changed from: private */
            public int computeUsableHeight() {
                if (ImageViewerActivity.this.jIp == null) {
                    return l.getEquipmentHeight(ImageViewerActivity.this);
                }
                Rect rect = new Rect();
                ImageViewerActivity.this.jIp.getWindowVisibleDisplayFrame(rect);
                return rect.bottom;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void resize() {
                ImageViewerActivity.this.jIq.requestLayout();
            }

            private void dealyResize(int i) {
                if (ImageViewerActivity.this.mDealyResizeRunnable != null) {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(ImageViewerActivity.this.mDealyResizeRunnable);
                } else {
                    ImageViewerActivity.this.mDealyResizeRunnable = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ImageViewerActivity.this.jIp != null && ImageViewerActivity.this.jIL != null) {
                                int height = ImageViewerActivity.this.jIp.getHeight();
                                if (height > AnonymousClass20.this.mScreenHeight) {
                                    AnonymousClass20.this.mScreenHeight = height;
                                }
                                int computeUsableHeight = computeUsableHeight();
                                if (computeUsableHeight != AnonymousClass20.this.usableHeightPrevious) {
                                    ImageViewerActivity.this.jIL.bottomMargin = AnonymousClass20.this.mScreenHeight - computeUsableHeight;
                                    resize();
                                    AnonymousClass20.this.usableHeightPrevious = computeUsableHeight;
                                }
                            }
                        }
                    };
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(ImageViewerActivity.this.mDealyResizeRunnable, i);
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int computeUsableHeight;
                if (ImageViewerActivity.this.jIL != null && (computeUsableHeight = computeUsableHeight()) != this.usableHeightPrevious) {
                    int i = this.mScreenHeight - computeUsableHeight;
                    if (i == 0) {
                        ImageViewerActivity.this.jIL.bottomMargin = i;
                        resize();
                        this.usableHeightPrevious = computeUsableHeight;
                        return;
                    }
                    dealyResize(100);
                    if (i != 0 && TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i) && i < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i);
                    }
                }
            }
        };
        this.jIq.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        this.jIL = (RelativeLayout.LayoutParams) this.jIq.getLayoutParams();
    }

    private void cKG() {
        if (com.baidu.tbadk.core.util.g.bit()) {
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
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
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
        this.jIr.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void buP() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cKH();
        bKY();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.Lt((String) y.getItem(this.jIs, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cKH() {
        this.hVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.gIr = (ImageView) this.hVu.findViewById(R.id.widget_navi_back_button);
        SvgManager.bjq().a(this.gIr, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hVu.setVisibility(0);
    }

    private void bKY() {
        if (!this.jIG && !this.jIF) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.jIj = addCustomView.findViewById(R.id.view_user_photo);
            this.jIk = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.jIl = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.jIk.setIsRound(true);
            this.jIk.setPlaceHolder(1);
            if (this.jIE) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.HQ(0);
                pVar.QO(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.HQ(1);
                pVar2.QO(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.jIi = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.jIi.setNeedDayNight(false);
                this.jIi.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.jIi.setVisibility(0);
                this.jIi.setOnSwitchChangeListener(this.jIP);
                p(this.jIj, 0);
                return;
            }
            p(this.jIi, 8);
            p(this.jIj, 8);
        }
    }

    public Map<String, ImageUrlData> cKI() {
        return this.eHu;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cKJ() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.jIs, this.mIndex);
        if (this.eHu == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eHu.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKK() {
        String str;
        if (this.jIs != null) {
            long cKJ = cKJ();
            String str2 = ("" + cKJ) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.jIC && cKJ() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new aq("c13316").dD("obj_source", this.mFrom));
                this.jIC = true;
            }
            if (cKL()) {
                cKM();
            } else {
                Lv(str);
            }
            long j = cKJ - 1;
            Cb(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKL() {
        if (this.jID && this.jIx != null && this.jIx.cKd()) {
            return this.jIp.getItemNum() != 1 && this.mIndex == this.jIp.getItemNum() + (-1);
        }
        return false;
    }

    private void Lv(String str) {
        this.mTitleView.setText(str);
        if (this.jIE && !this.jIF && this.jIi != null) {
            this.jIi.changeState(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void cKM() {
        this.mTitleView.setText("");
        p(this.jIi, 8);
        p(this.jIj, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.jIp == null) {
            this.jIp = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.jIp.init();
        }
        this.jIp.setIsFromCDN(this.eGk);
        this.jIp.setIsCanDrag(this.eGm);
        this.jIp.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.jIp.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.jIp.setOnPageChangeListener(this.bRa);
        this.jIp.setUrlData(this.jIs);
        this.jIp.setAssistUrls(this.eHu);
        this.jIp.setOuterOnTouchListener(this.eIi);
        this.jIp.setItemOnclickListener(this.mOnClickListener);
        this.jIp.setItemOnLongClickListener(this.jIR);
        this.jIp.setCurrentItem(cBi(), false);
        this.jIp.setOnScrollOutListener(this.jIS);
        this.jIx = new a(this.eGk, this.jID, getPageContext(), this.eVx, this.ala);
        this.jIx.setDragToExitListener(this.eHW);
        this.jIp.a(this.jIx);
        this.jIp.setOriImgSelectedCallback(this.eGd);
        this.jIp.setDragToExitListener(this.eHW);
        this.jIp.setUserId(this.mUserId);
        this.jIp.setShowBottomContainer(this.jIJ);
        this.jIp.setOnShareImageListener(this.jIv);
        this.jIp.setOnDownloadImageListener(this.jIv);
        this.jIp.setOnReplyClickListener(this.jIO);
        TiebaStatic.log(new aq("c13340").dD("uid", this.mUserId).dD("post_id", this.ala).ai("obj_source", cKN()));
    }

    private int cKN() {
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

    private void cgt() {
        if (!this.jIF && this.jIi != null) {
            if (this.jIw == null) {
                this.jIw = new com.baidu.tieba.c.e(getPageContext(), this.jIi);
                this.jIw.eL(R.drawable.pic_sign_tip);
                this.jIw.eK(48);
                this.jIw.setUseDirectOffset(true);
                this.jIw.eM(5000);
                this.jIw.vF(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.jIw.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.cKO();
                    }
                });
            }
            this.jIw.aG(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKO() {
        if (this.jIw != null) {
            this.jIw.NG();
        }
    }

    public int cBi() {
        int count = y.getCount(this.jIs);
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
        this.jIu = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.jIG = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.jIs = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eVx = bundle.getString("fid");
            this.ala = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.fEW = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.eGk = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.jII = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.jID = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.eGm = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.jIE = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.jHM = bundle.getString("source_rect_in_screen");
            this.jHO = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.jIJ = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.jHP = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.eHu = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eHu.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.jIH = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.jIF = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.jHQ = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.jIK = bundle.getString("from_forum_id");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.jIG = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.jIs = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eVx = intent.getStringExtra("fid");
                this.ala = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.fEW = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.eGk = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.jII = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.jID = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.eGm = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.jIE = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.jIJ = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.jHP = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.jIH = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.jIF = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.jHM = intent.getStringExtra("source_rect_in_screen");
                this.jHO = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.eHu = (Map) serializableExtra;
                }
                this.jHQ = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.jIK = intent.getStringExtra("from_forum_id");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.jv(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.jIu.b(bundle, getIntent());
        this.mCount = y.getCount(this.jIs);
        if (this.jHM != null) {
            String str = (String) y.getItem(this.jIs, this.mIndex);
            if (!StringUtils.isNull(str) && this.eHu != null && (imageUrlData = this.eHu.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.jHM);
            }
        }
        this.jHN = this.jIG ? null : d.Ls((String) y.getItem(this.jIs, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new aq("c13337").dD("obj_type", "2"));
        } else {
            TiebaStatic.log(new aq("c13337").dD("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.jIG);
        bundle.putStringArrayList("url", this.jIs);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eVx);
        bundle.putString("tid", this.ala);
        bundle.putString("fname", this.fEW);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.jII);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.eGm);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.jIE);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.jID);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.jIJ);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.jHP);
        if (this.eHu instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eHu.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eHu instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eHu.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.jHM);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.jIH);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.jIF);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.jHO);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.jIK);
        this.jIu.ay(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jIp.setCurrentItem(this.mIndex, false);
        SvgManager.bjq().a(this.gIr, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ca(int i) {
        if (this.jIp != null) {
            this.jIp.pP(i);
            int i2 = (this.jIp.bpX() || cKL()) ? 8 : 0;
            p(this.jIi, i2);
            p(this.jIj, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKP() {
        if (cKL()) {
            this.jIz = this.mNavigationBar.getVisibility() == 0;
            this.jIy = true;
        } else if (this.jIy) {
            this.mNavigationBar.setVisibility(this.jIz ? 0 : 8);
            this.jIy = false;
        }
    }

    private void Cb(int i) {
        if (this.jIt != null) {
            ArrayList<AlaInfoData> cKp = this.jIt.cKp();
            if (cKp != null && cKp.size() > 0) {
                rv(true);
                b(cKp.get(i % cKp.size()));
                return;
            }
            rv(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.jIk, alaInfoData.user_info.portrait);
            this.jIk.setAlaInfo(alaInfoData);
            this.jIk.setOnClickListener(this.jIT);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                Lw(alaInfoData.tag);
            }
            TiebaStatic.log(new aq("c13710").dD("fid", this.eVx).dD("fname", this.fEW).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", this.ala).dD("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void rv(boolean z) {
        if (this.jIn != z) {
            if (this.jIl != null) {
                if (z) {
                    this.jIl.setVisibility(0);
                    if (!this.jIl.isAnimating()) {
                        this.jIl.setSpeed(0.8f);
                        this.jIl.setRepeatCount(-1);
                        this.jIl.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.jIl.playAnimation();
                            }
                        });
                    }
                } else {
                    this.jIl.setVisibility(8);
                    if (this.jIl.isAnimating()) {
                        this.jIl.cancelAnimation();
                    }
                }
            }
            if (this.jIk != null) {
                this.jIk.setVisibility(z ? 0 : 8);
            }
            this.jIn = z;
        }
    }

    private void Cc(int i) {
        if (this.jIl != null) {
            if (i == 1) {
                this.jIl.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.jIl.setAnimation("live/card_live_bg_black.json");
            } else {
                this.jIl.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lw(@NonNull final String str) {
        if (this.jIl != null) {
            this.jIl.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.jIm != null) {
                        if (ImageViewerActivity.this.jIo == null || ImageViewerActivity.this.jIm == null || ImageViewerActivity.this.jIj == null || ImageViewerActivity.this.jIj.getVisibility() != 0) {
                            ImageViewerActivity.this.cKQ();
                            return;
                        }
                        ImageViewerActivity.this.jIm.Hj(str);
                        ImageViewerActivity.this.jIo = null;
                        return;
                    }
                    ImageViewerActivity.this.jIm = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.jIl);
                    ImageViewerActivity.this.jIm.eL(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.jIm.eK(32);
                    ImageViewerActivity.this.jIm.setUseDirectOffset(true);
                    ImageViewerActivity.this.jIm.vE(1);
                    ImageViewerActivity.this.jIm.vF(0);
                    ImageViewerActivity.this.jIm.eM(3000);
                    ImageViewerActivity.this.jIm.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.cKQ();
                        }
                    });
                    if (ImageViewerActivity.this.jIj == null || ImageViewerActivity.this.jIj.getVisibility() == 0) {
                        ImageViewerActivity.this.jIm.Hj(str);
                        return;
                    }
                    ImageViewerActivity.this.jIo = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKQ() {
        if (this.jIm != null) {
            this.jIm.NG();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.BIGIMAGE;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.13
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bua().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.eVx, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.ala, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Cv(TbadkCoreApplication.getInst().getAdAdSense().eAa);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cKR() {
        return this.jIG;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (at.isEmpty(this.ala)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.ala, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSU == null) {
            this.hSU = VoiceManager.instance();
        }
        return this.hSU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
