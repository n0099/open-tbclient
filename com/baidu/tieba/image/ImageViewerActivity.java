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
    private String akY;
    private Map<String, ImageUrlData> eHq;
    private String eVt;
    private String fES;
    private ImageView gIn;
    private VoiceManager hSO;
    private View hVo;
    private com.baidu.tieba.frs.profession.permission.c hXk;
    private String jHG;
    private String jHH;
    private int jHK;
    private String jIE;
    private RelativeLayout.LayoutParams jIF;
    private float jIK;
    private SortSwitchButton jIc;
    private View jId;
    private HeadImageView jIe;
    private TBLottieAnimationView jIf;
    private com.baidu.tieba.c.e jIg;
    private String jIi;
    private MultiImageView jIj;
    private LinearLayout jIk;
    private com.baidu.tieba.image.a.c jIl;
    private ArrayList<String> jIm;
    private e jIn;
    private i jIo;
    private j jIp;
    private com.baidu.tieba.c.e jIq;
    private int jIu;
    private boolean jIv;
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
    private boolean jIh = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a jIr = null;
    private boolean jIs = false;
    private boolean jIt = false;
    private int Zf = 0;
    private boolean jIw = false;
    private boolean jIx = true;
    private boolean eGi = true;
    private boolean jIy = true;
    private boolean mIsSeeHost = false;
    private boolean jIz = false;
    private boolean jIA = false;
    private boolean jIB = false;
    private boolean jHI = false;
    private boolean jIC = true;
    private boolean eGg = false;
    private boolean jID = true;
    private boolean jHJ = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private CustomMessageListener jIG = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.cKP();
            }
        }
    };
    private final CustomMessageListener jIH = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.eJB)) {
                    be.bju().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    be.bju().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.eJB});
                }
            }
        }
    };
    private DragImageView.d eHS = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.p(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.p(ImageViewerActivity.this.jIc, 8);
            ImageViewerActivity.this.p(ImageViewerActivity.this.hVo, 8);
            ImageViewerActivity.this.p(ImageViewerActivity.this.jId, 8);
            if (ImageViewerActivity.this.jIj != null) {
                ImageViewerActivity.this.jIj.iW(false);
            }
            ImageViewerActivity.this.cKN();
            ImageViewerActivity.this.cKP();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new aq("c13341").ai("obj_param1", ImageViewerActivity.this.jIj.getItemNum()).ai(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jIj.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bvY() {
            ImageViewerActivity.this.p(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.hVo.setVisibility(0);
            if (ImageViewerActivity.this.jIj != null) {
                boolean bpW = ImageViewerActivity.this.jIj.bpW();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bpW) {
                    ImageViewerActivity.this.p(ImageViewerActivity.this.jIc, 0);
                    ImageViewerActivity.this.p(ImageViewerActivity.this.jId, 0);
                    ImageViewerActivity.this.Lv(ImageViewerActivity.this.jIi);
                    if (ImageViewerActivity.this.jID) {
                        ImageViewerActivity.this.jIj.iW(true);
                    } else {
                        ImageViewerActivity.this.jIj.iW(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener jII = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13857").dD("obj_type", "3").dD("post_id", ImageViewerActivity.this.akY).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", ImageViewerActivity.this.eVt));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.hXk == null) {
                    ImageViewerActivity.this.hXk = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.hXk.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.17.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void ou(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void z(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void ov(boolean z) {
                            if (z && ImageViewerActivity.this.jIl != null && ImageViewerActivity.this.jIj.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.jIl.b(ImageViewerActivity.this.jIj.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.jIn);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.hXk.yr((ImageViewerActivity.this.jIj == null || ImageViewerActivity.this.jIj.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.jIj.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.jIj.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.hXk.C(ImageViewerActivity.this.eVt, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.akY, 0L));
            }
        }
    };
    private UrlDragImageView.b eFZ = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bqo() {
            TiebaStatic.log(new aq("c10351").dD("tid", ImageViewerActivity.this.akY).dD("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a jIJ = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean xL(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.jIv = true;
                if (ImageViewerActivity.this.jIc != null) {
                    ImageViewerActivity.this.jIc.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.Lr((String) y.getItem(ImageViewerActivity.this.jIm, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new aq("c13857").ai("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dD("post_id", ImageViewerActivity.this.akY).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", ImageViewerActivity.this.eVt));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13341").ai("obj_param1", ImageViewerActivity.this.jIj.getItemNum()).ai(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jIj.getCurrentMaxIndex()));
            TiebaStatic.log(new aq("c13377").dD("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener eIe = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.jIK = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.jIK = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener jIL = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.jIp != null) {
                ImageViewerActivity.this.jIp.ceW();
                ImageViewerActivity.this.jIp.show();
                ImageViewerActivity.this.jIp.cA(view);
            }
            TiebaStatic.log(new aq("c13269").dD("uid", ImageViewerActivity.this.mUserId).dD("fid", ImageViewerActivity.this.eVt).dD("tid", ImageViewerActivity.this.akY));
            return true;
        }
    };
    private BaseViewPager.a jIM = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.jIn.cKp();
            } else if (ImageViewerActivity.this.cKI() != 1) {
                ImageViewerActivity.this.jIn.cKq();
            }
        }
    };
    private ViewPager.OnPageChangeListener bQW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.jIn != null && i > ImageViewerActivity.this.jIj.getItemNum() - 5) {
                ImageViewerActivity.this.jIn.cKp();
            }
            ImageViewerActivity.this.jIo.e(ImageViewerActivity.this.jIm, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.cKJ();
            ImageViewerActivity.this.cKO();
            ImageViewerActivity.this.Ca(i);
            if (ImageViewerActivity.this.jIo.cKR() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jIo.Cd(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.jIo.cKS() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jIo.Ce(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.cKK()) {
                ImageViewerActivity.this.jIr.cKj();
            }
            if (ImageViewerActivity.this.jIp != null) {
                ImageViewerActivity.this.jIp.cKV();
            }
            if (ImageViewerActivity.this.jIl != null && ImageViewerActivity.this.jIj.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.jIl.a(ImageViewerActivity.this.jIj.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.jIn);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.Zf) {
                ImageViewerActivity.this.Zf = i;
            } else if (i < ImageViewerActivity.this.Zf) {
                ImageViewerActivity.this.Zf = i;
            }
            if (ImageViewerActivity.this.jIj != null) {
                dragImageView = ImageViewerActivity.this.jIj.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cKI() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.cKP();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.jIm != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.jIm.size()) {
                ImageViewerActivity.this.jIo.bk(i, (String) ImageViewerActivity.this.jIm.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener jIN = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.dOT).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.dPc).append("?").append(com.baidu.tbadk.BdToken.f.dPu).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.dPv).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new aq("c13711").dD("fid", ImageViewerActivity.this.eVt).dD("fname", ImageViewerActivity.this.fES).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", ImageViewerActivity.this.akY).dD("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eHq != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eHq.values()) {
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
    private CustomMessageListener eor = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eHq != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eHq.values()) {
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
        com.baidu.tbadk.mutiprocess.g.btm().init(TbadkCoreApplication.getInst());
        this.jIu = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cvW();
        k(this.jHH, this.mIsSeeHost, false);
        registerListener(this.jIH);
        registerListener(this.jIG);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.eor);
        this.hSO = getVoiceManager();
        this.hSO.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
        if (this.jIr != null) {
            this.jIr.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.jIn = new e(this.jIm, this.eHq, this.eVt, this.fES, this.akY, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.jHK, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.jIn.setSourceImageRectInScreen(this.jHG);
        this.jIn.rp(this.jIC);
        this.jIn.rq(z);
        this.jIn.Lt(this.jHH);
        this.jIn.ro(this.jHI);
        this.jIn.setPostId(this.mPostId);
        this.jIn.rs(this.jHJ);
        this.jIn.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.jIj != null) {
                    if (ImageViewerActivity.this.jIv) {
                        if (!z5) {
                            ImageViewerActivity.this.jIj.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.jIv = false;
                    if (ImageViewerActivity.this.jIc != null) {
                        ImageViewerActivity.this.jIc.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.jIj.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.jIj.getItemNum();
                        ImageViewerActivity.this.jIj.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.jIj.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.jIj.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.jIr != null) {
                        ImageViewerActivity.this.jIr.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.jIj.setUrlData(arrayList);
                    ImageViewerActivity.this.jIj.setAssistUrls(ImageViewerActivity.this.eHq);
                    ImageViewerActivity.this.jIj.setHasNext(z3);
                    ImageViewerActivity.this.jIj.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.jIj.getItemNum()) {
                        ImageViewerActivity.this.jIj.pQ(ImageViewerActivity.this.jIj.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.jIj.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.jIj.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.jIj.setUrlData(arrayList);
                        ImageViewerActivity.this.jIj.setCurrentItem(ImageViewerActivity.this.jIj.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.cKI() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.cKJ();
                    if (ImageViewerActivity.this.jIl != null && ImageViewerActivity.this.jIj.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.jIl.a(ImageViewerActivity.this.jIj.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.jIn);
                    }
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.jIj.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.jIr.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.jIr.cKc()) {
                    ImageViewerActivity.this.jIj.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.jIj.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bj(int i, String str2) {
                ImageViewerActivity.this.jIv = false;
                if (ImageViewerActivity.this.jIc != null) {
                    ImageViewerActivity.this.jIc.changeState(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.jIc.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.jIm != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.jIm.size();
                    }
                    ImageViewerActivity.this.cKJ();
                }
            }
        });
        this.jIn.rr(true);
        this.jIn.cKp();
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
        this.jIj.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.jIj.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.jIu = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        Cc(i);
        if (this.jIp != null) {
            this.jIp.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hSO != null) {
            this.hSO.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jIj.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.akY, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
        if (this.hSO != null) {
            this.hSO.onPause(getPageContext());
        }
        this.jIl.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jIj.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.akY, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.dNN, uniqueId.getId(), j);
        }
        if (this.hSO != null) {
            this.hSO.onResume(getPageContext());
        }
        this.jIl.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.jIj.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        MessageManager.getInstance().unRegisterListener(this.jIH);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bsW().releaseBlockBitmapPool();
        this.jIo.e(this.jIm, this.mIndex, this.mIndex);
        this.jIo.cKT();
        String str3 = "";
        if (this.jIr != null) {
            str3 = this.jIr.getAdId();
        }
        if (this.jIn != null) {
            str2 = this.jIn.bgm();
            str = this.jIn.bgn();
        } else {
            str = null;
            str2 = null;
        }
        this.jIo.a(this.jIj.getPageCount(), str3, this.eVt, this.akY, str2, str);
        if (this.jIp != null) {
            this.jIp.release();
        }
        this.jIj.onDestroy();
        this.jIl.onDestroy();
        if (this.hSO != null) {
            this.hSO.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.brr().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.jIu);
        cKN();
        cKP();
        if (this.jIr != null) {
            this.jIr.onDestroy();
        }
        super.onDestroy();
        if (this.mDealyResizeRunnable != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mDealyResizeRunnable);
            this.mDealyResizeRunnable = null;
        }
        if (this.jIk != null) {
            this.jIk.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
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

    private void cvW() {
        buO();
        this.jIp = new j(this);
        initViewPager();
        this.jIp.j(this.jIj);
        cKJ();
        cgs();
        cKF();
        cKE();
        this.jIo.e(this.jIm, this.mIndex, this.mIndex);
    }

    private void cKE() {
        this.jIk = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.jIl = new com.baidu.tieba.image.a.c(getPageContext(), this.jIk);
        this.jIl.setFromForumId(this.jIE);
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
                if (ImageViewerActivity.this.jIj == null) {
                    return l.getEquipmentHeight(ImageViewerActivity.this);
                }
                Rect rect = new Rect();
                ImageViewerActivity.this.jIj.getWindowVisibleDisplayFrame(rect);
                return rect.bottom;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void resize() {
                ImageViewerActivity.this.jIk.requestLayout();
            }

            private void dealyResize(int i) {
                if (ImageViewerActivity.this.mDealyResizeRunnable != null) {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(ImageViewerActivity.this.mDealyResizeRunnable);
                } else {
                    ImageViewerActivity.this.mDealyResizeRunnable = new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ImageViewerActivity.this.jIj != null && ImageViewerActivity.this.jIF != null) {
                                int height = ImageViewerActivity.this.jIj.getHeight();
                                if (height > AnonymousClass20.this.mScreenHeight) {
                                    AnonymousClass20.this.mScreenHeight = height;
                                }
                                int computeUsableHeight = computeUsableHeight();
                                if (computeUsableHeight != AnonymousClass20.this.usableHeightPrevious) {
                                    ImageViewerActivity.this.jIF.bottomMargin = AnonymousClass20.this.mScreenHeight - computeUsableHeight;
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
                if (ImageViewerActivity.this.jIF != null && (computeUsableHeight = computeUsableHeight()) != this.usableHeightPrevious) {
                    int i = this.mScreenHeight - computeUsableHeight;
                    if (i == 0) {
                        ImageViewerActivity.this.jIF.bottomMargin = i;
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
        this.jIk.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        this.jIF = (RelativeLayout.LayoutParams) this.jIk.getLayoutParams();
    }

    private void cKF() {
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
        this.jIl.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void buO() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cKG();
        bKX();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.Ls((String) y.getItem(this.jIm, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cKG() {
        this.hVo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hVo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.gIn = (ImageView) this.hVo.findViewById(R.id.widget_navi_back_button);
        SvgManager.bjq().a(this.gIn, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hVo.setVisibility(0);
    }

    private void bKX() {
        if (!this.jIA && !this.jIz) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.jId = addCustomView.findViewById(R.id.view_user_photo);
            this.jIe = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.jIf = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.jIe.setIsRound(true);
            this.jIe.setPlaceHolder(1);
            if (this.jIy) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.HQ(0);
                pVar.QO(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.HQ(1);
                pVar2.QO(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.jIc = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.jIc.setNeedDayNight(false);
                this.jIc.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.jIc.setVisibility(0);
                this.jIc.setOnSwitchChangeListener(this.jIJ);
                p(this.jId, 0);
                return;
            }
            p(this.jIc, 8);
            p(this.jId, 8);
        }
    }

    public Map<String, ImageUrlData> cKH() {
        return this.eHq;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cKI() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.jIm, this.mIndex);
        if (this.eHq == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eHq.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKJ() {
        String str;
        if (this.jIm != null) {
            long cKI = cKI();
            String str2 = ("" + cKI) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.jIw && cKI() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new aq("c13316").dD("obj_source", this.mFrom));
                this.jIw = true;
            }
            if (cKK()) {
                cKL();
            } else {
                Lu(str);
            }
            long j = cKI - 1;
            Cb(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKK() {
        if (this.jIx && this.jIr != null && this.jIr.cKc()) {
            return this.jIj.getItemNum() != 1 && this.mIndex == this.jIj.getItemNum() + (-1);
        }
        return false;
    }

    private void Lu(String str) {
        this.mTitleView.setText(str);
        if (this.jIy && !this.jIz && this.jIc != null) {
            this.jIc.changeState(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void cKL() {
        this.mTitleView.setText("");
        p(this.jIc, 8);
        p(this.jId, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.jIj == null) {
            this.jIj = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.jIj.init();
        }
        this.jIj.setIsFromCDN(this.eGg);
        this.jIj.setIsCanDrag(this.eGi);
        this.jIj.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.jIj.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.jIj.setOnPageChangeListener(this.bQW);
        this.jIj.setUrlData(this.jIm);
        this.jIj.setAssistUrls(this.eHq);
        this.jIj.setOuterOnTouchListener(this.eIe);
        this.jIj.setItemOnclickListener(this.mOnClickListener);
        this.jIj.setItemOnLongClickListener(this.jIL);
        this.jIj.setCurrentItem(cBh(), false);
        this.jIj.setOnScrollOutListener(this.jIM);
        this.jIr = new a(this.eGg, this.jIx, getPageContext(), this.eVt, this.akY);
        this.jIr.setDragToExitListener(this.eHS);
        this.jIj.a(this.jIr);
        this.jIj.setOriImgSelectedCallback(this.eFZ);
        this.jIj.setDragToExitListener(this.eHS);
        this.jIj.setUserId(this.mUserId);
        this.jIj.setShowBottomContainer(this.jID);
        this.jIj.setOnShareImageListener(this.jIp);
        this.jIj.setOnDownloadImageListener(this.jIp);
        this.jIj.setOnReplyClickListener(this.jII);
        TiebaStatic.log(new aq("c13340").dD("uid", this.mUserId).dD("post_id", this.akY).ai("obj_source", cKM()));
    }

    private int cKM() {
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

    private void cgs() {
        if (!this.jIz && this.jIc != null) {
            if (this.jIq == null) {
                this.jIq = new com.baidu.tieba.c.e(getPageContext(), this.jIc);
                this.jIq.eL(R.drawable.pic_sign_tip);
                this.jIq.eK(48);
                this.jIq.setUseDirectOffset(true);
                this.jIq.eM(5000);
                this.jIq.vF(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.jIq.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.cKN();
                    }
                });
            }
            this.jIq.aG(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKN() {
        if (this.jIq != null) {
            this.jIq.NG();
        }
    }

    public int cBh() {
        int count = y.getCount(this.jIm);
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
        this.jIo = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.jIA = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.jIm = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eVt = bundle.getString("fid");
            this.akY = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.fES = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.eGg = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.jIC = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.jIx = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.eGi = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.jIy = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.jHG = bundle.getString("source_rect_in_screen");
            this.jHI = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.jID = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.jHJ = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.eHq = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eHq.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.jIB = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.jIz = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.jHK = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.jIE = bundle.getString("from_forum_id");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.jIA = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.jIm = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eVt = intent.getStringExtra("fid");
                this.akY = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.fES = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.eGg = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.jIC = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.jIx = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.eGi = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.jIy = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.jID = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.jHJ = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.jIB = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.jIz = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.jHG = intent.getStringExtra("source_rect_in_screen");
                this.jHI = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.eHq = (Map) serializableExtra;
                }
                this.jHK = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.jIE = intent.getStringExtra("from_forum_id");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.jt(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.jIo.b(bundle, getIntent());
        this.mCount = y.getCount(this.jIm);
        if (this.jHG != null) {
            String str = (String) y.getItem(this.jIm, this.mIndex);
            if (!StringUtils.isNull(str) && this.eHq != null && (imageUrlData = this.eHq.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.jHG);
            }
        }
        this.jHH = this.jIA ? null : d.Lr((String) y.getItem(this.jIm, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new aq("c13337").dD("obj_type", "2"));
        } else {
            TiebaStatic.log(new aq("c13337").dD("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.jIA);
        bundle.putStringArrayList("url", this.jIm);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eVt);
        bundle.putString("tid", this.akY);
        bundle.putString("fname", this.fES);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.jIC);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.eGi);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.jIy);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.jIx);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.jID);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.jHJ);
        if (this.eHq instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eHq.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eHq instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eHq.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.jHG);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.jIB);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.jIz);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.jHI);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.jIE);
        this.jIo.ay(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jIj.setCurrentItem(this.mIndex, false);
        SvgManager.bjq().a(this.gIn, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ca(int i) {
        if (this.jIj != null) {
            this.jIj.pP(i);
            int i2 = (this.jIj.bpW() || cKK()) ? 8 : 0;
            p(this.jIc, i2);
            p(this.jId, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKO() {
        if (cKK()) {
            this.jIt = this.mNavigationBar.getVisibility() == 0;
            this.jIs = true;
        } else if (this.jIs) {
            this.mNavigationBar.setVisibility(this.jIt ? 0 : 8);
            this.jIs = false;
        }
    }

    private void Cb(int i) {
        if (this.jIn != null) {
            ArrayList<AlaInfoData> cKo = this.jIn.cKo();
            if (cKo != null && cKo.size() > 0) {
                rt(true);
                b(cKo.get(i % cKo.size()));
                return;
            }
            rt(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.jIe, alaInfoData.user_info.portrait);
            this.jIe.setAlaInfo(alaInfoData);
            this.jIe.setOnClickListener(this.jIN);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                Lv(alaInfoData.tag);
            }
            TiebaStatic.log(new aq("c13710").dD("fid", this.eVt).dD("fname", this.fES).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", this.akY).dD("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void rt(boolean z) {
        if (this.jIh != z) {
            if (this.jIf != null) {
                if (z) {
                    this.jIf.setVisibility(0);
                    if (!this.jIf.isAnimating()) {
                        this.jIf.setSpeed(0.8f);
                        this.jIf.setRepeatCount(-1);
                        this.jIf.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.jIf.playAnimation();
                            }
                        });
                    }
                } else {
                    this.jIf.setVisibility(8);
                    if (this.jIf.isAnimating()) {
                        this.jIf.cancelAnimation();
                    }
                }
            }
            if (this.jIe != null) {
                this.jIe.setVisibility(z ? 0 : 8);
            }
            this.jIh = z;
        }
    }

    private void Cc(int i) {
        if (this.jIf != null) {
            if (i == 1) {
                this.jIf.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.jIf.setAnimation("live/card_live_bg_black.json");
            } else {
                this.jIf.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lv(@NonNull final String str) {
        if (this.jIf != null) {
            this.jIf.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.jIg != null) {
                        if (ImageViewerActivity.this.jIi == null || ImageViewerActivity.this.jIg == null || ImageViewerActivity.this.jId == null || ImageViewerActivity.this.jId.getVisibility() != 0) {
                            ImageViewerActivity.this.cKP();
                            return;
                        }
                        ImageViewerActivity.this.jIg.Hi(str);
                        ImageViewerActivity.this.jIi = null;
                        return;
                    }
                    ImageViewerActivity.this.jIg = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.jIf);
                    ImageViewerActivity.this.jIg.eL(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.jIg.eK(32);
                    ImageViewerActivity.this.jIg.setUseDirectOffset(true);
                    ImageViewerActivity.this.jIg.vE(1);
                    ImageViewerActivity.this.jIg.vF(0);
                    ImageViewerActivity.this.jIg.eM(3000);
                    ImageViewerActivity.this.jIg.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.11.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.cKP();
                        }
                    });
                    if (ImageViewerActivity.this.jId == null || ImageViewerActivity.this.jId.getVisibility() == 0) {
                        ImageViewerActivity.this.jIg.Hi(str);
                        return;
                    }
                    ImageViewerActivity.this.jIi = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKP() {
        if (this.jIg != null) {
            this.jIg.NG();
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
                return com.baidu.tbadk.m.e.btZ().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.eVt, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.akY, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Cu(TbadkCoreApplication.getInst().getAdAdSense().ezW);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cKQ() {
        return this.jIA;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (at.isEmpty(this.akY)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.akY, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSO == null) {
            this.hSO = VoiceManager.instance();
        }
        return this.hSO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
