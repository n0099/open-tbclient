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
    private Map<String, ImageUrlData> fjX;
    private String fyR;
    private String gkl;
    private VoiceManager iHo;
    private View iJO;
    private com.baidu.tieba.frs.profession.permission.c iLK;
    private ImageView jGL;
    private String kxH;
    private String kxI;
    private int kxL;
    private String kyF;
    private float kyK;
    private SortSwitchButton kyd;
    private View kye;
    private HeadImageView kyf;
    private TBLottieAnimationView kyg;
    private com.baidu.tieba.c.e kyh;
    private String kyj;
    private MultiImageView kyk;
    private LinearLayout kyl;
    private com.baidu.tieba.image.a.c kym;
    private ArrayList<String> kyn;
    private e kyo;
    private i kyp;
    private j kyq;
    private com.baidu.tieba.c.e kyr;
    private int kyv;
    private boolean kyw;
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
    private boolean kyi = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a kys = null;
    private boolean kyt = false;
    private boolean kyu = false;
    private int ZQ = 0;
    private boolean kyx = false;
    private boolean kyy = true;
    private boolean fiQ = true;
    private boolean kyz = true;
    private boolean mIsSeeHost = false;
    private boolean kyA = false;
    private boolean kyB = false;
    private boolean kyC = false;
    private boolean kxJ = false;
    private boolean kyD = true;
    private boolean fiO = false;
    private boolean kyE = true;
    private boolean kxK = false;
    private CustomMessageListener kyG = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.cXM();
            }
        }
    };
    private final CustomMessageListener kyH = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.fmn)) {
                    be.brr().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    be.brr().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.fmn});
                }
            }
        }
    };
    private DragImageView.d fkz = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.s(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.s(ImageViewerActivity.this.kyd, 8);
            ImageViewerActivity.this.s(ImageViewerActivity.this.iJO, 8);
            ImageViewerActivity.this.s(ImageViewerActivity.this.kye, 8);
            if (ImageViewerActivity.this.kyk != null) {
                ImageViewerActivity.this.kyk.jP(false);
            }
            ImageViewerActivity.this.cXK();
            ImageViewerActivity.this.cXM();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new aq("c13341").al("obj_param1", ImageViewerActivity.this.kyk.getItemNum()).al(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kyk.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bEk() {
            ImageViewerActivity.this.s(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.iJO.setVisibility(0);
            if (ImageViewerActivity.this.kyk != null && !ImageViewerActivity.this.cXH()) {
                boolean bxT = ImageViewerActivity.this.kyk.bxT();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bxT) {
                    ImageViewerActivity.this.s(ImageViewerActivity.this.kyd, 0);
                    ImageViewerActivity.this.s(ImageViewerActivity.this.kye, 0);
                    ImageViewerActivity.this.NC(ImageViewerActivity.this.kyj);
                    if (ImageViewerActivity.this.kyE) {
                        ImageViewerActivity.this.kyk.jP(true);
                    } else {
                        ImageViewerActivity.this.kyk.jP(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener kyI = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13857").dR("obj_type", "3").dR("post_id", ImageViewerActivity.this.alT).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fyR));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.iLK == null) {
                    ImageViewerActivity.this.iLK = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.iLK.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void pI(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void C(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void pJ(boolean z) {
                            if (z && ImageViewerActivity.this.kym != null && ImageViewerActivity.this.kyk.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.kym.b(ImageViewerActivity.this.kyk.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kyo);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.iLK.Ac((ImageViewerActivity.this.kyk == null || ImageViewerActivity.this.kyk.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kyk.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kyk.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.iLK.G(ImageViewerActivity.this.fyR, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.alT, 0L));
            }
        }
    };
    private UrlDragImageView.b fiH = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void byl() {
            TiebaStatic.log(new aq("c10351").dR("tid", ImageViewerActivity.this.alT).dR("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a kyJ = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zw(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.kyw = true;
                if (ImageViewerActivity.this.kyd != null) {
                    ImageViewerActivity.this.kyd.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.Ny((String) y.getItem(ImageViewerActivity.this.kyn, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new aq("c13857").al("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dR("post_id", ImageViewerActivity.this.alT).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fyR));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13341").al("obj_param1", ImageViewerActivity.this.kyk.getItemNum()).al(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kyk.getCurrentMaxIndex()));
            TiebaStatic.log(new aq("c13377").dR("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener fkL = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.kyK = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.kyK = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener kyL = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.kyq != null) {
                ImageViewerActivity.this.kyq.crq();
                ImageViewerActivity.this.kyq.show();
                ImageViewerActivity.this.kyq.cW(view);
            }
            TiebaStatic.log(new aq("c13269").dR("uid", ImageViewerActivity.this.mUserId).dR("fid", ImageViewerActivity.this.fyR).dR("tid", ImageViewerActivity.this.alT));
            return true;
        }
    };
    private BaseViewPager.a kyM = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kyo.cXm();
            } else if (ImageViewerActivity.this.cXF() != 1) {
                ImageViewerActivity.this.kyo.cXn();
            }
        }
    };
    private ViewPager.OnPageChangeListener ctL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kyo != null && i > ImageViewerActivity.this.kyk.getItemNum() - 5) {
                ImageViewerActivity.this.kyo.cXm();
            }
            ImageViewerActivity.this.kyp.e(ImageViewerActivity.this.kyn, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.cXG();
            ImageViewerActivity.this.cXL();
            ImageViewerActivity.this.DN(i);
            if (ImageViewerActivity.this.kyp.cXO() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kyp.DQ(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kyp.cXP() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kyp.DR(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.cXH()) {
                ImageViewerActivity.this.kys.cXg();
            }
            if (ImageViewerActivity.this.kyq != null) {
                ImageViewerActivity.this.kyq.cXS();
            }
            if (ImageViewerActivity.this.kym != null && ImageViewerActivity.this.kyk.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.kym.a(ImageViewerActivity.this.kyk.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kyo);
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
            if (ImageViewerActivity.this.kyk != null) {
                dragImageView = ImageViewerActivity.this.kyk.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cXF() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.cXM();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.kyn != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.kyn.size()) {
                ImageViewerActivity.this.kyp.bC(i, (String) ImageViewerActivity.this.kyn.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener kyN = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.eru).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.erD).append("?").append(com.baidu.tbadk.BdToken.f.erW).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.erX).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new aq("c13711").dR("fid", ImageViewerActivity.this.fyR).dR("fname", ImageViewerActivity.this.gkl).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", ImageViewerActivity.this.alT).dR("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fjX != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fjX.values()) {
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
    private CustomMessageListener eRi = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fjX != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fjX.values()) {
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
        com.baidu.tbadk.mutiprocess.g.bBt().init(TbadkCoreApplication.getInst());
        this.kyv = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cIv();
        k(this.kxI, this.mIsSeeHost, false);
        registerListener(this.kyH);
        registerListener(this.kyG);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.eRi);
        this.iHo = getVoiceManager();
        this.iHo.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
        if (this.kys != null) {
            this.kys.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kyo = new e(this.kyn, this.fjX, this.fyR, this.gkl, this.alT, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.kxL, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kyo.setSourceImageRectInScreen(this.kxH);
        this.kyo.sG(this.kyD);
        this.kyo.sH(z);
        this.kyo.NA(this.kxI);
        this.kyo.sF(this.kxJ);
        this.kyo.setPostId(this.mPostId);
        this.kyo.sJ(this.kxK);
        this.kyo.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kyk != null) {
                    if (ImageViewerActivity.this.kyw) {
                        if (!z5) {
                            ImageViewerActivity.this.kyk.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.kyw = false;
                    if (ImageViewerActivity.this.kyd != null) {
                        ImageViewerActivity.this.kyd.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kyk.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kyk.getItemNum();
                        ImageViewerActivity.this.kyk.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kyk.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kyk.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.kys != null) {
                        ImageViewerActivity.this.kys.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.kyk.setUrlData(arrayList);
                    ImageViewerActivity.this.kyk.setAssistUrls(ImageViewerActivity.this.fjX);
                    ImageViewerActivity.this.kyk.setHasNext(z3);
                    ImageViewerActivity.this.kyk.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kyk.getItemNum()) {
                        ImageViewerActivity.this.kyk.qW(ImageViewerActivity.this.kyk.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kyk.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kyk.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kyk.setUrlData(arrayList);
                        ImageViewerActivity.this.kyk.setCurrentItem(ImageViewerActivity.this.kyk.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.cXF() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.cXG();
                    if (ImageViewerActivity.this.kym != null && ImageViewerActivity.this.kyk.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.kym.a(ImageViewerActivity.this.kyk.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kyo);
                    }
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.kyk.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.kys.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.kys.cWZ()) {
                    ImageViewerActivity.this.kyk.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.kyk.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bB(int i, String str2) {
                ImageViewerActivity.this.kyw = false;
                if (ImageViewerActivity.this.kyd != null) {
                    if (ImageViewerActivity.this.kyd.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.kyd.jP(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.kyd.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.kyn != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.kyn.size();
                    }
                    ImageViewerActivity.this.cXG();
                }
            }
        });
        this.kyo.sI(true);
        this.kyo.cXm();
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
        this.kyk.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kyk.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.kyv = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        DP(i);
        if (this.kyq != null) {
            this.kyq.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kyk.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alT, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
        this.kym.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kyk.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alT, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.eql, uniqueId.getId(), j);
        }
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
        this.kym.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kyk.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.kyH);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bBd().releaseBlockBitmapPool();
        this.kyp.e(this.kyn, this.mIndex, this.mIndex);
        this.kyp.cXQ();
        String str3 = "";
        if (this.kys != null) {
            str3 = this.kys.getAdId();
        }
        if (this.kyo != null) {
            str = this.kyo.boi();
            str2 = this.kyo.boj();
        } else {
            str = null;
        }
        this.kyp.a(this.kyk.getPageCount(), str3, this.fyR, this.alT, str, str2);
        if (this.kyq != null) {
            this.kyq.release();
        }
        this.kyk.onDestroy();
        this.kym.onDestroy();
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bzt().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kyv);
        cXK();
        cXM();
        if (this.kys != null) {
            this.kys.onDestroy();
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

    private void cIv() {
        bCV();
        this.kyq = new j(this);
        initViewPager();
        this.kyq.j(this.kyk);
        cXG();
        csO();
        cXC();
        cXB();
        this.kyp.e(this.kyn, this.mIndex, this.mIndex);
    }

    private void cXB() {
        this.kyl = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.kym = new com.baidu.tieba.image.a.c(getPageContext(), this.kyl);
        this.kym.setFromForumId(this.kyF);
    }

    private void cXC() {
        if (com.baidu.tbadk.core.util.g.bqq()) {
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
        this.kym.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void bCV() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cXD();
        bTW();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.Nz((String) y.getItem(this.kyn, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cXD() {
        this.iJO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.jGL = (ImageView) this.iJO.findViewById(R.id.widget_navi_back_button);
        SvgManager.brn().a(this.jGL, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iJO.setVisibility(0);
    }

    private void bTW() {
        if (!this.kyB && !this.kyA) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.kye = addCustomView.findViewById(R.id.view_user_photo);
            this.kyf = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.kyg = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.kyf.setIsRound(true);
            this.kyf.setPlaceHolder(1);
            if (this.kyz) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.JE(0);
                pVar.SS(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.JE(1);
                pVar2.SS(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.kyd = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.kyd.setNeedDayNight(false);
                this.kyd.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.kyd.setVisibility(0);
                this.kyd.setOnSwitchChangeListener(this.kyJ);
                s(this.kye, 0);
                return;
            }
            s(this.kyd, 8);
            s(this.kye, 8);
        }
    }

    public Map<String, ImageUrlData> cXE() {
        return this.fjX;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cXF() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.kyn, this.mIndex);
        if (this.fjX == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fjX.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXG() {
        String str;
        if (this.kyn != null) {
            long cXF = cXF();
            String str2 = ("" + cXF) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.kyx && cXF() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new aq("c13316").dR("obj_source", this.mFrom));
                this.kyx = true;
            }
            if (cXH()) {
                cXI();
            } else {
                NB(str);
            }
            long j = cXF - 1;
            DO(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cXH() {
        if (this.kyy && this.kys != null && this.kys.cWZ()) {
            return this.kyk.getItemNum() != 1 && this.mIndex == this.kyk.getItemNum() + (-1);
        }
        return false;
    }

    private void NB(String str) {
        this.mTitleView.setText(str);
        if (this.kyz && !this.kyA && this.kyd != null) {
            this.kyd.jP(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void cXI() {
        this.mTitleView.setText("");
        s(this.kyd, 8);
        s(this.kye, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kyk == null) {
            this.kyk = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kyk.init();
        }
        this.kyk.setIsFromCDN(this.fiO);
        this.kyk.setIsCanDrag(this.fiQ);
        this.kyk.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kyk.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kyk.setOnPageChangeListener(this.ctL);
        this.kyk.setUrlData(this.kyn);
        this.kyk.setAssistUrls(this.fjX);
        this.kyk.setOuterOnTouchListener(this.fkL);
        this.kyk.setItemOnclickListener(this.mOnClickListener);
        this.kyk.setItemOnLongClickListener(this.kyL);
        this.kyk.setCurrentItem(cOg(), false);
        this.kyk.setOnScrollOutListener(this.kyM);
        this.kys = new a(this.fiO, this.kyy, getPageContext(), this.fyR, this.alT);
        this.kys.setDragToExitListener(this.fkz);
        this.kyk.a(this.kys);
        this.kyk.setOriImgSelectedCallback(this.fiH);
        this.kyk.setDragToExitListener(this.fkz);
        this.kyk.setUserId(this.mUserId);
        this.kyk.setShowBottomContainer(this.kyE);
        this.kyk.setOnShareImageListener(this.kyq);
        this.kyk.setOnDownloadImageListener(this.kyq);
        this.kyk.setOnReplyClickListener(this.kyI);
        TiebaStatic.log(new aq("c13340").dR("uid", this.mUserId).dR("post_id", this.alT).al("obj_source", cXJ()));
    }

    private int cXJ() {
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

    private void csO() {
        if (!this.kyA && this.kyd != null) {
            if (this.kyr == null) {
                this.kyr = new com.baidu.tieba.c.e(getPageContext(), this.kyd);
                this.kyr.fu(R.drawable.pic_sign_tip);
                this.kyr.ft(48);
                this.kyr.setUseDirectOffset(true);
                this.kyr.fv(5000);
                this.kyr.xq(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.kyr.d(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.cXK();
                    }
                });
            }
            this.kyr.aM(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXK() {
        if (this.kyr != null) {
            this.kyr.SR();
        }
    }

    public int cOg() {
        int count = y.getCount(this.kyn);
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
        this.kyp = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.kyB = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.kyn = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fyR = bundle.getString("fid");
            this.alT = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.gkl = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.fiO = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.kyD = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.kyy = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.fiQ = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.kyz = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.kxH = bundle.getString("source_rect_in_screen");
            this.kxJ = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.kyE = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.kxK = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.fjX = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fjX.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.kyC = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.kyA = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.kxL = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.kyF = bundle.getString("from_forum_id");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.kyB = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.kyn = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fyR = intent.getStringExtra("fid");
                this.alT = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.gkl = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.fiO = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.kyD = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.kyy = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.fiQ = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.kyz = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.kyE = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.kxK = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.kyC = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.kyA = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.kxH = intent.getStringExtra("source_rect_in_screen");
                this.kxJ = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.fjX = (Map) serializableExtra;
                }
                this.kxL = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.kyF = intent.getStringExtra("from_forum_id");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.kq(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.kyp.b(bundle, getIntent());
        this.mCount = y.getCount(this.kyn);
        if (this.kxH != null) {
            String str = (String) y.getItem(this.kyn, this.mIndex);
            if (!StringUtils.isNull(str) && this.fjX != null && (imageUrlData = this.fjX.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.kxH);
            }
        }
        this.kxI = this.kyB ? null : d.Ny((String) y.getItem(this.kyn, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new aq("c13337").dR("obj_type", "2"));
        } else {
            TiebaStatic.log(new aq("c13337").dR("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.kyB);
        bundle.putStringArrayList("url", this.kyn);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fyR);
        bundle.putString("tid", this.alT);
        bundle.putString("fname", this.gkl);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.kyD);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.fiQ);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.kyz);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.kyy);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.kyE);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.kxK);
        if (this.fjX instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fjX.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fjX instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fjX.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.kxH);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.kyC);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.kyA);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.kxJ);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.kyF);
        this.kyp.ay(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kyk.setCurrentItem(this.mIndex, false);
        SvgManager.brn().a(this.jGL, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DN(int i) {
        if (this.kyk != null) {
            this.kyk.qV(i);
            int i2 = (this.kyk.bxT() || cXH()) ? 8 : 0;
            s(this.kyd, i2);
            s(this.kye, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXL() {
        if (cXH()) {
            this.kyu = this.mNavigationBar.getVisibility() == 0;
            this.kyt = true;
        } else if (this.kyt) {
            this.mNavigationBar.setVisibility(this.kyu ? 0 : 8);
            this.kyt = false;
        }
    }

    private void DO(int i) {
        if (this.kyo != null) {
            ArrayList<AlaInfoData> cXl = this.kyo.cXl();
            if (cXl != null && cXl.size() > 0) {
                sK(true);
                b(cXl.get(i % cXl.size()));
                return;
            }
            sK(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.kyf, alaInfoData.user_info.portrait);
            this.kyf.setAlaInfo(alaInfoData);
            this.kyf.setOnClickListener(this.kyN);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                NC(alaInfoData.tag);
            }
            TiebaStatic.log(new aq("c13710").dR("fid", this.fyR).dR("fname", this.gkl).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.alT).dR("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void sK(boolean z) {
        if (this.kyi != z) {
            if (this.kyg != null) {
                if (z) {
                    this.kyg.setVisibility(0);
                    if (!this.kyg.isAnimating()) {
                        this.kyg.setSpeed(0.8f);
                        this.kyg.setRepeatCount(-1);
                        this.kyg.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.kyg.playAnimation();
                            }
                        });
                    }
                } else {
                    this.kyg.setVisibility(8);
                    if (this.kyg.isAnimating()) {
                        this.kyg.cancelAnimation();
                    }
                }
            }
            if (this.kyf != null) {
                this.kyf.setVisibility(z ? 0 : 8);
            }
            this.kyi = z;
        }
    }

    private void DP(int i) {
        if (this.kyg != null) {
            if (i == 1) {
                this.kyg.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.kyg.setAnimation("live/card_live_bg_black.json");
            } else {
                this.kyg.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC(@NonNull final String str) {
        if (this.kyg != null) {
            this.kyg.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.kyh != null) {
                        if (ImageViewerActivity.this.kyj == null || ImageViewerActivity.this.kyh == null || ImageViewerActivity.this.kye == null || ImageViewerActivity.this.kye.getVisibility() != 0) {
                            ImageViewerActivity.this.cXM();
                            return;
                        }
                        ImageViewerActivity.this.kyh.Jj(str);
                        ImageViewerActivity.this.kyj = null;
                        return;
                    }
                    ImageViewerActivity.this.kyh = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.kyg);
                    ImageViewerActivity.this.kyh.fu(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.kyh.ft(32);
                    ImageViewerActivity.this.kyh.setUseDirectOffset(true);
                    ImageViewerActivity.this.kyh.xp(1);
                    ImageViewerActivity.this.kyh.xq(0);
                    ImageViewerActivity.this.kyh.fv(3000);
                    ImageViewerActivity.this.kyh.d(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.cXM();
                        }
                    });
                    if (ImageViewerActivity.this.kye == null || ImageViewerActivity.this.kye.getVisibility() == 0) {
                        ImageViewerActivity.this.kyh.Jj(str);
                        return;
                    }
                    ImageViewerActivity.this.kyj = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXM() {
        if (this.kyh != null) {
            this.kyh.SR();
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
                return com.baidu.tbadk.m.e.bCg().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fyR, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.alT, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Ek(TbadkCoreApplication.getInst().getAdAdSense().fcx);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cXN() {
        return this.kyB;
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
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
