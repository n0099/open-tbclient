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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
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
import com.baidu.tieba.image.c;
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
    private String alZ;
    private Map<String, ImageUrlData> fjf;
    private String fyg;
    private String gjS;
    private VoiceManager iIc;
    private View iKB;
    private com.baidu.tieba.frs.profession.permission.c iMx;
    private ImageView jHK;
    private String kxW;
    private String kxX;
    private LinearLayout kyA;
    private com.baidu.tieba.image.a.c kyB;
    private ArrayList<String> kyC;
    private c kyD;
    private g kyE;
    private h kyF;
    private com.baidu.tieba.d.e kyG;
    private int kyK;
    private boolean kyL;
    private String kyU;
    private float kyZ;
    private int kya;
    private SortSwitchButton kys;
    private View kyt;
    private HeadImageView kyu;
    private TBLottieAnimationView kyv;
    private com.baidu.tieba.d.e kyw;
    private String kyy;
    private MultiImageView kyz;
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
    private boolean kyx = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a kyH = null;
    private boolean kyI = false;
    private boolean kyJ = false;
    private int ZV = 0;
    private boolean kyM = false;
    private boolean kyN = true;
    private boolean fhV = true;
    private boolean kyO = true;
    private boolean mIsSeeHost = false;
    private boolean kyP = false;
    private boolean kyQ = false;
    private boolean kyR = false;
    private boolean kxY = false;
    private boolean kyS = true;
    private boolean fhT = false;
    private boolean kyT = true;
    private boolean kxZ = false;
    private CustomMessageListener kyV = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.cXi();
            }
        }
    };
    private final CustomMessageListener kyW = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.flv)) {
                    bf.bqF().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    bf.bqF().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.flv});
                }
            }
        }
    };
    private DragImageView.d fjH = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.u(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.u(ImageViewerActivity.this.kys, 8);
            ImageViewerActivity.this.u(ImageViewerActivity.this.iKB, 8);
            ImageViewerActivity.this.u(ImageViewerActivity.this.kyt, 8);
            if (ImageViewerActivity.this.kyz != null) {
                ImageViewerActivity.this.kyz.jQ(false);
            }
            ImageViewerActivity.this.cXg();
            ImageViewerActivity.this.cXi();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new ar("c13341").ak("obj_param1", ImageViewerActivity.this.kyz.getItemNum()).ak(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kyz.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bDD() {
            ImageViewerActivity.this.u(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.iKB.setVisibility(0);
            if (ImageViewerActivity.this.kyz != null && !ImageViewerActivity.this.cXd()) {
                boolean bxj = ImageViewerActivity.this.kyz.bxj();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bxj) {
                    ImageViewerActivity.this.u(ImageViewerActivity.this.kys, 0);
                    ImageViewerActivity.this.u(ImageViewerActivity.this.kyt, 0);
                    ImageViewerActivity.this.Na(ImageViewerActivity.this.kyy);
                    if (ImageViewerActivity.this.kyT) {
                        ImageViewerActivity.this.kyz.jQ(true);
                    } else {
                        ImageViewerActivity.this.kyz.jQ(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener kyX = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13857").dR("obj_type", "3").dR("post_id", ImageViewerActivity.this.alZ).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fyg));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.iMx == null) {
                    ImageViewerActivity.this.iMx = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.iMx.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void pL(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void C(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void pM(boolean z) {
                            if (z && ImageViewerActivity.this.kyB != null && ImageViewerActivity.this.kyz.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.kyB.b(ImageViewerActivity.this.kyz.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kyD);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.iMx.AA((ImageViewerActivity.this.kyz == null || ImageViewerActivity.this.kyz.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kyz.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kyz.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.iMx.G(ImageViewerActivity.this.fyg, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.alZ, 0L));
            }
        }
    };
    private UrlDragImageView.b fhM = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bxB() {
            TiebaStatic.log(new ar("c10351").dR("tid", ImageViewerActivity.this.alZ).dR("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a kyY = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zU(int i) {
            if (j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.kyL = true;
                if (ImageViewerActivity.this.kys != null) {
                    ImageViewerActivity.this.kys.setEnabled(false);
                }
                ImageViewerActivity.this.k(b.MW((String) y.getItem(ImageViewerActivity.this.kyC, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new ar("c13857").ak("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dR("post_id", ImageViewerActivity.this.alZ).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fyg));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13341").ak("obj_param1", ImageViewerActivity.this.kyz.getItemNum()).ak(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kyz.getCurrentMaxIndex()));
            TiebaStatic.log(new ar("c13377").dR("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener fjT = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.kyZ = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.kyZ = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener kza = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.kyF != null) {
                ImageViewerActivity.this.kyF.cqT();
                ImageViewerActivity.this.kyF.show();
                ImageViewerActivity.this.kyF.da(view);
            }
            TiebaStatic.log(new ar("c13269").dR("uid", ImageViewerActivity.this.mUserId).dR("fid", ImageViewerActivity.this.fyg).dR("tid", ImageViewerActivity.this.alZ));
            return true;
        }
    };
    private BaseViewPager.a kzb = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kyD.cWI();
            } else if (ImageViewerActivity.this.cXb() != 1) {
                ImageViewerActivity.this.kyD.cWJ();
            }
        }
    };
    private ViewPager.OnPageChangeListener crZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kyD != null && i > ImageViewerActivity.this.kyz.getItemNum() - 5) {
                ImageViewerActivity.this.kyD.cWI();
            }
            ImageViewerActivity.this.kyE.e(ImageViewerActivity.this.kyC, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.cXc();
            ImageViewerActivity.this.cXh();
            ImageViewerActivity.this.El(i);
            if (ImageViewerActivity.this.kyE.cXk() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kyE.Eo(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kyE.cXl() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kyE.Ep(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.cXd()) {
                ImageViewerActivity.this.kyH.onAdShow();
            }
            if (ImageViewerActivity.this.kyF != null) {
                ImageViewerActivity.this.kyF.cXo();
            }
            if (ImageViewerActivity.this.kyB != null && ImageViewerActivity.this.kyz.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.kyB.a(ImageViewerActivity.this.kyz.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kyD);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.ZV) {
                ImageViewerActivity.this.ZV = i;
            } else if (i < ImageViewerActivity.this.ZV) {
                ImageViewerActivity.this.ZV = i;
            }
            if (ImageViewerActivity.this.kyz != null) {
                dragImageView = ImageViewerActivity.this.kyz.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cXb() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.cXi();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.kyC != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.kyC.size()) {
                ImageViewerActivity.this.kyE.bA(i, (String) ImageViewerActivity.this.kyC.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener kzc = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.epM).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.epV).append("?").append(com.baidu.tbadk.BdToken.f.eqq).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.eqr).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new ar("c13711").dR("fid", ImageViewerActivity.this.fyg).dR("fname", ImageViewerActivity.this.gjS).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", ImageViewerActivity.this.alZ).dR("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fjf != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fjf.values()) {
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
    private CustomMessageListener eQj = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fjf != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fjf.values()) {
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
    public void u(View view, int i) {
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
        com.baidu.tbadk.mutiprocess.g.bAJ().init(TbadkCoreApplication.getInst());
        this.kyK = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cIa();
        k(this.kxX, this.mIsSeeHost, false);
        registerListener(this.kyW);
        registerListener(this.kyV);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.eQj);
        this.iIc = getVoiceManager();
        this.iIc.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28) {
            if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                com.baidu.tieba.w.c.a(1, getWindow().getAttributes(), getWindow());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kyD = new c(this.kyC, this.fjf, this.fyg, this.gjS, this.alZ, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.kya, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kyD.setSourceImageRectInScreen(this.kxW);
        this.kyD.sJ(this.kyS);
        this.kyD.sK(z);
        this.kyD.MY(this.kxX);
        this.kyD.sI(this.kxY);
        this.kyD.setPostId(this.mPostId);
        this.kyD.sM(this.kxZ);
        this.kyD.a(new c.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.c.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kyz != null) {
                    if (ImageViewerActivity.this.kyL) {
                        if (!z5) {
                            ImageViewerActivity.this.kyz.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.kyL = false;
                    if (ImageViewerActivity.this.kys != null) {
                        ImageViewerActivity.this.kys.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kyz.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kyz.getItemNum();
                        ImageViewerActivity.this.kyz.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kyz.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kyz.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.kyH != null) {
                        ImageViewerActivity.this.kyH.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.kyz.setUrlData(arrayList);
                    ImageViewerActivity.this.kyz.setAssistUrls(ImageViewerActivity.this.fjf);
                    ImageViewerActivity.this.kyz.setHasNext(z3);
                    ImageViewerActivity.this.kyz.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kyz.getItemNum()) {
                        ImageViewerActivity.this.kyz.ru(ImageViewerActivity.this.kyz.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kyz.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kyz.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kyz.setUrlData(arrayList);
                        ImageViewerActivity.this.kyz.setCurrentItem(ImageViewerActivity.this.kyz.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.cXb() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.cXc();
                    if (ImageViewerActivity.this.kyB != null && ImageViewerActivity.this.kyz.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.kyB.a(ImageViewerActivity.this.kyz.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kyD);
                    }
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.kyz.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.kyH.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.kyH.cWG()) {
                    ImageViewerActivity.this.kyz.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.t.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.kyz.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.c.b
            public void bz(int i, String str2) {
                ImageViewerActivity.this.kyL = false;
                if (ImageViewerActivity.this.kys != null) {
                    if (ImageViewerActivity.this.kys.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.kys.jL(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.kys.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.kyC != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.kyC.size();
                    }
                    ImageViewerActivity.this.cXc();
                }
            }
        });
        this.kyD.sL(true);
        this.kyD.cWI();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
            TiebaStatic.log(new ar("c13377").dR("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kyz.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kyz.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.kyK = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        En(i);
        if (this.kyF != null) {
            this.kyF.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iIc != null) {
            this.iIc.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iIc != null) {
            this.iIc.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kyz.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alZ, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
        if (this.iIc != null) {
            this.iIc.onPause(getPageContext());
        }
        this.kyB.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kyz.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alZ, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.eoE, uniqueId.getId(), j);
        }
        if (this.iIc != null) {
            this.iIc.onResume(getPageContext());
        }
        this.kyB.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kyz.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.kyW);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bAt().releaseBlockBitmapPool();
        this.kyE.e(this.kyC, this.mIndex, this.mIndex);
        this.kyE.cXm();
        String str3 = "";
        if (this.kyH != null) {
            str3 = this.kyH.getAdId();
        }
        if (this.kyD != null) {
            str = this.kyD.bnm();
            str2 = this.kyD.bnn();
        } else {
            str = null;
        }
        this.kyE.a(this.kyz.getPageCount(), str3, this.fyg, this.alZ, str, str2);
        if (this.kyF != null) {
            this.kyF.release();
        }
        this.kyz.onDestroy();
        this.kyB.onDestroy();
        if (this.iIc != null) {
            this.iIc.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.byJ().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kyK);
        cXg();
        cXi();
        if (this.kyH != null) {
            this.kyH.onDestroy();
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

    private void cIa() {
        bCo();
        this.kyF = new h(this);
        initViewPager();
        this.kyF.j(this.kyz);
        cXc();
        csr();
        cWY();
        cWX();
        this.kyE.e(this.kyC, this.mIndex, this.mIndex);
    }

    private void cWX() {
        this.kyA = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.kyB = new com.baidu.tieba.image.a.c(getPageContext(), this.kyA);
        this.kyB.setFromForumId(this.kyU);
    }

    private void cWY() {
        if (com.baidu.tbadk.core.util.g.bpD()) {
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
        this.kyB.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void bCo() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cWZ();
        bTp();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.CAM_X0606));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (b.MX((String) y.getItem(this.kyC, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cWZ() {
        this.iKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.jHK = (ImageView) this.iKB.findViewById(R.id.widget_navi_back_button);
        SvgManager.bqB().a(this.jHK, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iKB.setVisibility(0);
    }

    private void bTp() {
        if (!this.kyQ && !this.kyP) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.kyt = addCustomView.findViewById(R.id.view_user_photo);
            this.kyu = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.kyv = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.kyu.setIsRound(true);
            this.kyu.setPlaceHolder(1);
            if (this.kyO) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.Kg(0);
                pVar.St(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.Kg(1);
                pVar2.St(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.kys = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.kys.setNeedDayNight(false);
                this.kys.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.kys.setVisibility(0);
                this.kys.setOnSwitchChangeListener(this.kyY);
                u(this.kyt, 0);
                return;
            }
            u(this.kys, 8);
            u(this.kyt, 8);
        }
    }

    public Map<String, ImageUrlData> cXa() {
        return this.fjf;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cXb() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.kyC, this.mIndex);
        if (this.fjf == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fjf.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXc() {
        String str;
        if (this.kyC != null) {
            long cXb = cXb();
            String str2 = ("" + cXb) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.kyM && cXb() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new ar("c13316").dR("obj_source", this.mFrom));
                this.kyM = true;
            }
            if (cXd()) {
                cXe();
            } else {
                MZ(str);
            }
            long j = cXb - 1;
            Em(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cXd() {
        if (this.kyN && this.kyH != null && this.kyH.cWG()) {
            return this.kyz.getItemNum() != 1 && this.mIndex == this.kyz.getItemNum() + (-1);
        }
        return false;
    }

    private void MZ(String str) {
        this.mTitleView.setText(str);
        if (this.kyO && !this.kyP && this.kys != null) {
            this.kys.jL(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void cXe() {
        this.mTitleView.setText("");
        u(this.kys, 8);
        u(this.kyt, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kyz == null) {
            this.kyz = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kyz.init();
        }
        this.kyz.setIsFromCDN(this.fhT);
        this.kyz.setIsCanDrag(this.fhV);
        this.kyz.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kyz.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kyz.setOnPageChangeListener(this.crZ);
        this.kyz.setUrlData(this.kyC);
        this.kyz.setAssistUrls(this.fjf);
        this.kyz.setOuterOnTouchListener(this.fjT);
        this.kyz.setItemOnclickListener(this.mOnClickListener);
        this.kyz.setItemOnLongClickListener(this.kza);
        this.kyz.setCurrentItem(cNM(), false);
        this.kyz.setOnScrollOutListener(this.kzb);
        this.kyH = new a(this.fhT, this.kyN, getPageContext(), this.fyg, this.alZ);
        this.kyH.setDragToExitListener(this.fjH);
        this.kyz.a(this.kyH);
        this.kyz.setOriImgSelectedCallback(this.fhM);
        this.kyz.setDragToExitListener(this.fjH);
        this.kyz.setUserId(this.mUserId);
        this.kyz.setShowBottomContainer(this.kyT);
        this.kyz.setOnShareImageListener(this.kyF);
        this.kyz.setOnDownloadImageListener(this.kyF);
        this.kyz.setOnReplyClickListener(this.kyX);
        TiebaStatic.log(new ar("c13340").dR("uid", this.mUserId).dR("post_id", this.alZ).ak("obj_source", cXf()));
    }

    private int cXf() {
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

    private void csr() {
        if (!this.kyP && this.kys != null) {
            if (this.kyG == null) {
                this.kyG = new com.baidu.tieba.d.e(getPageContext(), this.kys);
                this.kyG.fq(R.drawable.pic_sign_tip);
                this.kyG.fp(48);
                this.kyG.setUseDirectOffset(true);
                this.kyG.fr(5000);
                this.kyG.xO(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.kyG.d(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.cXg();
                    }
                });
            }
            this.kyG.aL(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXg() {
        if (this.kyG != null) {
            this.kyG.Si();
        }
    }

    public int cNM() {
        int count = y.getCount(this.kyC);
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
        this.kyE = new g();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.kyQ = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.kyC = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fyg = bundle.getString("fid");
            this.alZ = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.gjS = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.fhT = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.kyS = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.kyN = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.fhV = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.kyO = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.kxW = bundle.getString("source_rect_in_screen");
            this.kxY = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.kyT = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.kxZ = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.fjf = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fjf.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.kyR = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.kyP = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.kya = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.kyU = bundle.getString("from_forum_id");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.kyQ = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.kyC = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fyg = intent.getStringExtra("fid");
                this.alZ = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.gjS = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.fhT = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.kyS = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.kyN = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.fhV = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.kyO = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.kyT = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.kxZ = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.kyR = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.kyP = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.kxW = intent.getStringExtra("source_rect_in_screen");
                this.kxY = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.fjf = (Map) serializableExtra;
                }
                this.kya = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.kyU = intent.getStringExtra("from_forum_id");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.kr(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.kyE.b(bundle, getIntent());
        this.mCount = y.getCount(this.kyC);
        if (this.kxW != null) {
            String str = (String) y.getItem(this.kyC, this.mIndex);
            if (!StringUtils.isNull(str) && this.fjf != null && (imageUrlData = this.fjf.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.kxW);
            }
        }
        this.kxX = this.kyQ ? null : b.MW((String) y.getItem(this.kyC, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new ar("c13337").dR("obj_type", "2"));
        } else {
            TiebaStatic.log(new ar("c13337").dR("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.kyQ);
        bundle.putStringArrayList("url", this.kyC);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fyg);
        bundle.putString("tid", this.alZ);
        bundle.putString("fname", this.gjS);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.kyS);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.fhV);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.kyO);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.kyN);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.kyT);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.kxZ);
        if (this.fjf instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fjf.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fjf instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fjf.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.kxW);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.kyR);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.kyP);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.kxY);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.kyU);
        this.kyE.ay(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kyz.setCurrentItem(this.mIndex, false);
        SvgManager.bqB().a(this.jHK, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void El(int i) {
        if (this.kyz != null) {
            this.kyz.rt(i);
            int i2 = (this.kyz.bxj() || cXd()) ? 8 : 0;
            u(this.kys, i2);
            u(this.kyt, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXh() {
        if (cXd()) {
            this.kyJ = this.mNavigationBar.getVisibility() == 0;
            this.kyI = true;
        } else if (this.kyI) {
            this.mNavigationBar.setVisibility(this.kyJ ? 0 : 8);
            this.kyI = false;
        }
    }

    private void Em(int i) {
        if (this.kyD != null) {
            ArrayList<AlaInfoData> cWH = this.kyD.cWH();
            if (cWH != null && cWH.size() > 0) {
                sN(true);
                b(cWH.get(i % cWH.size()));
                return;
            }
            sN(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.kyu, alaInfoData.user_info.portrait);
            this.kyu.setAlaInfo(alaInfoData);
            this.kyu.setOnClickListener(this.kzc);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                Na(alaInfoData.tag);
            }
            TiebaStatic.log(new ar("c13710").dR("fid", this.fyg).dR("fname", this.gjS).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.alZ).dR("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void sN(boolean z) {
        if (this.kyx != z) {
            if (this.kyv != null) {
                if (z) {
                    this.kyv.setVisibility(0);
                    if (!this.kyv.isAnimating()) {
                        this.kyv.setSpeed(0.8f);
                        this.kyv.setRepeatCount(-1);
                        this.kyv.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.kyv.playAnimation();
                            }
                        });
                    }
                } else {
                    this.kyv.setVisibility(8);
                    if (this.kyv.isAnimating()) {
                        this.kyv.cancelAnimation();
                    }
                }
            }
            if (this.kyu != null) {
                this.kyu.setVisibility(z ? 0 : 8);
            }
            this.kyx = z;
        }
    }

    private void En(int i) {
        if (this.kyv != null) {
            if (i == 1) {
                this.kyv.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.kyv.setAnimation("live/card_live_bg_black.json");
            } else {
                this.kyv.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Na(@NonNull final String str) {
        if (this.kyv != null) {
            this.kyv.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.kyw != null) {
                        if (ImageViewerActivity.this.kyy == null || ImageViewerActivity.this.kyw == null || ImageViewerActivity.this.kyt == null || ImageViewerActivity.this.kyt.getVisibility() != 0) {
                            ImageViewerActivity.this.cXi();
                            return;
                        }
                        ImageViewerActivity.this.kyw.IK(str);
                        ImageViewerActivity.this.kyy = null;
                        return;
                    }
                    ImageViewerActivity.this.kyw = new com.baidu.tieba.d.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.kyv);
                    ImageViewerActivity.this.kyw.fq(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.kyw.fp(32);
                    ImageViewerActivity.this.kyw.setUseDirectOffset(true);
                    ImageViewerActivity.this.kyw.xN(1);
                    ImageViewerActivity.this.kyw.xO(0);
                    ImageViewerActivity.this.kyw.fr(3000);
                    ImageViewerActivity.this.kyw.d(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.cXi();
                        }
                    });
                    if (ImageViewerActivity.this.kyt == null || ImageViewerActivity.this.kyt.getVisibility() == 0) {
                        ImageViewerActivity.this.kyw.IK(str);
                        return;
                    }
                    ImageViewerActivity.this.kyy = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXi() {
        if (this.kyw != null) {
            this.kyw.Si();
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
                return com.baidu.tbadk.m.e.bBw().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fyg, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.alZ, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DJ(TbadkCoreApplication.getInst().getAdAdSense().fbE);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cXj() {
        return this.kyQ;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (au.isEmpty(this.alZ)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.alZ, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iIc == null) {
            this.iIc = VoiceManager.instance();
        }
        return this.iIc;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
