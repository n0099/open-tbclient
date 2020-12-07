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
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.util.l;
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
/* loaded from: classes21.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.c {
    private String amY;
    private String fFV;
    private Map<String, ImageUrlData> fqD;
    private String gsb;
    private VoiceManager iSU;
    private View iVu;
    private com.baidu.tieba.frs.profession.permission.c iXo;
    private ImageView jVn;
    private SortSwitchButton kLK;
    private View kLL;
    private HeadImageView kLM;
    private TBLottieAnimationView kLN;
    private com.baidu.tieba.d.e kLO;
    private String kLQ;
    private MultiImageView kLR;
    private LinearLayout kLS;
    private com.baidu.tieba.image.a.c kLT;
    private ArrayList<String> kLU;
    private c kLV;
    private g kLW;
    private h kLX;
    private com.baidu.tieba.d.e kLY;
    private String kLo;
    private String kLp;
    private int kLs;
    private int kMc;
    private boolean kMd;
    private String kMm;
    private float kMr;
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
    private boolean kLP = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a kLZ = null;
    private boolean kMa = false;
    private boolean kMb = false;
    private int aaR = 0;
    private boolean kMe = false;
    private boolean kMf = true;
    private boolean fpw = true;
    private boolean kMg = true;
    private boolean mIsSeeHost = false;
    private boolean kMh = false;
    private boolean kMi = false;
    private boolean kMj = false;
    private boolean kLq = false;
    private boolean kMk = true;
    private boolean fpu = false;
    private boolean kMl = true;
    private boolean kLr = false;
    private CustomMessageListener kMn = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.dct();
            }
        }
    };
    private final CustomMessageListener kMo = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null && !StringUtils.isNull(mVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(mVar);
                if (StringUtils.isNull(mVar.fsY)) {
                    bf.bua().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink});
                } else {
                    bf.bua().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink, mVar.fsY});
                }
            }
        }
    };
    private DragImageView.d frg = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.u(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.u(ImageViewerActivity.this.kLK, 8);
            ImageViewerActivity.this.u(ImageViewerActivity.this.iVu, 8);
            ImageViewerActivity.this.u(ImageViewerActivity.this.kLL, 8);
            if (ImageViewerActivity.this.kLR != null) {
                ImageViewerActivity.this.kLR.kg(false);
            }
            ImageViewerActivity.this.dcr();
            ImageViewerActivity.this.dct();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new ar("c13341").al("obj_param1", ImageViewerActivity.this.kLR.getItemNum()).al(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kLR.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bHe() {
            ImageViewerActivity.this.u(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.iVu.setVisibility(0);
            if (ImageViewerActivity.this.kLR != null && !ImageViewerActivity.this.dco()) {
                boolean bAJ = ImageViewerActivity.this.kLR.bAJ();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bAJ) {
                    ImageViewerActivity.this.u(ImageViewerActivity.this.kLK, 0);
                    ImageViewerActivity.this.u(ImageViewerActivity.this.kLL, 0);
                    ImageViewerActivity.this.Oi(ImageViewerActivity.this.kLQ);
                    if (ImageViewerActivity.this.kMl) {
                        ImageViewerActivity.this.kLR.kg(true);
                    } else {
                        ImageViewerActivity.this.kLR.kg(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener kMp = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13857").dY("obj_type", "3").dY("post_id", ImageViewerActivity.this.amY).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", ImageViewerActivity.this.fFV));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.iXo == null) {
                    ImageViewerActivity.this.iXo = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.iXo.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qi(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void C(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qj(boolean z) {
                            if (z && ImageViewerActivity.this.kLT != null && ImageViewerActivity.this.kLR.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.kLT.b(ImageViewerActivity.this.kLR.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kLV);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.iXo.Bo((ImageViewerActivity.this.kLR == null || ImageViewerActivity.this.kLR.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kLR.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kLR.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.iXo.G(ImageViewerActivity.this.fFV, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.amY, 0L));
            }
        }
    };
    private UrlDragImageView.b fpm = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bBb() {
            TiebaStatic.log(new ar("c10351").dY("tid", ImageViewerActivity.this.amY).dY("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a kMq = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean Az(int i) {
            if (j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.kMd = true;
                if (ImageViewerActivity.this.kLK != null) {
                    ImageViewerActivity.this.kLK.setEnabled(false);
                }
                ImageViewerActivity.this.k(b.Oe((String) y.getItem(ImageViewerActivity.this.kLU, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new ar("c13857").al("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dY("post_id", ImageViewerActivity.this.amY).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fid", ImageViewerActivity.this.fFV));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13341").al("obj_param1", ImageViewerActivity.this.kLR.getItemNum()).al(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kLR.getCurrentMaxIndex()));
            TiebaStatic.log(new ar("c13377").dY("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener frt = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.kMr = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.kMr = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener kMs = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.kLX != null) {
                ImageViewerActivity.this.kLX.cvh();
                ImageViewerActivity.this.kLX.show();
                ImageViewerActivity.this.kLX.dh(view);
            }
            TiebaStatic.log(new ar("c13269").dY("uid", ImageViewerActivity.this.mUserId).dY("fid", ImageViewerActivity.this.fFV).dY("tid", ImageViewerActivity.this.amY));
            return true;
        }
    };
    private BaseViewPager.a kMt = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kLV.dbU();
            } else if (ImageViewerActivity.this.dcm() != 1) {
                ImageViewerActivity.this.kLV.dbV();
            }
        }
    };
    private ViewPager.OnPageChangeListener cyV = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kLV != null && i > ImageViewerActivity.this.kLR.getItemNum() - 5) {
                ImageViewerActivity.this.kLV.dbU();
            }
            ImageViewerActivity.this.kLW.e(ImageViewerActivity.this.kLU, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.dcn();
            ImageViewerActivity.this.dcs();
            ImageViewerActivity.this.Fa(i);
            if (ImageViewerActivity.this.kLW.dcv() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kLW.Fd(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kLW.dcw() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kLW.Fe(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.dco()) {
                ImageViewerActivity.this.kLZ.onAdShow();
            }
            if (ImageViewerActivity.this.kLX != null) {
                ImageViewerActivity.this.kLX.dcz();
            }
            if (ImageViewerActivity.this.kLT != null && ImageViewerActivity.this.kLR.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.kLT.a(ImageViewerActivity.this.kLR.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kLV);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.aaR) {
                ImageViewerActivity.this.aaR = i;
            } else if (i < ImageViewerActivity.this.aaR) {
                ImageViewerActivity.this.aaR = i;
            }
            if (ImageViewerActivity.this.kLR != null) {
                dragImageView = ImageViewerActivity.this.kLR.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.dcm() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.dct();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.kLU != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.kLU.size()) {
                ImageViewerActivity.this.kLW.bA(i, (String) ImageViewerActivity.this.kLU.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener kMu = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.ewL).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.ewU).append("?").append(com.baidu.tbadk.BdToken.f.exq).append("=").append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.exr).append("=").append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new ar("c13711").dY("fid", ImageViewerActivity.this.fFV).dY("fname", ImageViewerActivity.this.gsb).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", ImageViewerActivity.this.amY).dY("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fqD != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fqD.values()) {
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
    private CustomMessageListener eXy = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fqD != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fqD.values()) {
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
        com.baidu.tbadk.mutiprocess.g.bEl().d(TbadkCoreApplication.getInst());
        this.kMc = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cNo();
        k(this.kLp, this.mIsSeeHost, false);
        registerListener(this.kMo);
        registerListener(this.kMn);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.eXy);
        this.iSU = getVoiceManager();
        this.iSU.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28) {
            if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                com.baidu.tieba.w.c.a(1, getWindow().getAttributes(), getWindow());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kLV = new c(this.kLU, this.fqD, this.fFV, this.gsb, this.amY, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.kLs, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kLV.setSourceImageRectInScreen(this.kLo);
        this.kLV.tl(this.kMk);
        this.kLV.tm(z);
        this.kLV.Og(this.kLp);
        this.kLV.tk(this.kLq);
        this.kLV.setPostId(this.mPostId);
        this.kLV.to(this.kLr);
        this.kLV.a(new c.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.c.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kLR != null) {
                    if (ImageViewerActivity.this.kMd) {
                        if (!z5) {
                            ImageViewerActivity.this.kLR.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.kMd = false;
                    if (ImageViewerActivity.this.kLK != null) {
                        ImageViewerActivity.this.kLK.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kLR.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kLR.getItemNum();
                        ImageViewerActivity.this.kLR.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kLR.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kLR.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.kLZ != null) {
                        AdvertAppInfo.eEb.set(true);
                        int bmD = advertAppInfo.bmD();
                        if (bmD == 0) {
                            ImageViewerActivity.this.kLZ.a(advertAppInfo, arrayList.size());
                        } else {
                            ImageViewerActivity.this.b(advertAppInfo, bmD);
                        }
                    }
                    ImageViewerActivity.this.kLR.setUrlData(arrayList);
                    ImageViewerActivity.this.kLR.setAssistUrls(ImageViewerActivity.this.fqD);
                    ImageViewerActivity.this.kLR.setHasNext(z3);
                    ImageViewerActivity.this.kLR.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kLR.getItemNum()) {
                        ImageViewerActivity.this.kLR.rV(ImageViewerActivity.this.kLR.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kLR.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kLR.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kLR.setUrlData(arrayList);
                        ImageViewerActivity.this.kLR.setCurrentItem(ImageViewerActivity.this.kLR.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.dcm() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.dcn();
                    if (ImageViewerActivity.this.kLT != null && ImageViewerActivity.this.kLR.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.kLT.a(ImageViewerActivity.this.kLR.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kLV);
                    }
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.kLR.setAddSize(0);
                    return;
                }
                int bmD = advertAppInfo.bmD();
                if (bmD != 0) {
                    ImageViewerActivity.this.b(advertAppInfo, bmD);
                    return;
                }
                ImageViewerActivity.this.kLZ.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.kLZ.dbS()) {
                    ImageViewerActivity.this.kLR.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.t.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.kLR.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.c.b
            public void bz(int i, String str2) {
                ImageViewerActivity.this.kMd = false;
                if (ImageViewerActivity.this.kLK != null) {
                    if (ImageViewerActivity.this.kLK.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.kLK.kj(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.kLK.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.kLU != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.kLU.size();
                    }
                    ImageViewerActivity.this.dcn();
                }
            }
        });
        this.kLV.tn(true);
        this.kLV.dbU();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!l.isFastDoubleClick()) {
            TiebaStatic.log(new ar("c13377").dY("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kLR.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kLR.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.kMc = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        Fc(i);
        if (this.kLX != null) {
            this.kLX.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iSU != null) {
            this.iSU.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iSU != null) {
            this.iSU.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kLR.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.amY, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
        if (this.iSU != null) {
            this.iSU.onPause(getPageContext());
        }
        this.kLT.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kLR.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.amY, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.evD, uniqueId.getId(), j);
        }
        if (this.iSU != null) {
            this.iSU.onResume(getPageContext());
        }
        this.kLT.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kLR.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.kMo);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bDV().releaseBlockBitmapPool();
        this.kLW.e(this.kLU, this.mIndex, this.mIndex);
        this.kLW.dcx();
        String str3 = "";
        if (this.kLZ != null) {
            str3 = this.kLZ.getAdId();
        }
        if (this.kLV != null) {
            str = this.kLV.bqz();
            str2 = this.kLV.bqA();
        } else {
            str = null;
        }
        this.kLW.a(this.kLR.getPageCount(), str3, this.fFV, this.amY, str, str2);
        if (this.kLX != null) {
            this.kLX.release();
        }
        this.kLR.onDestroy();
        this.kLT.onDestroy();
        if (this.iSU != null) {
            this.iSU.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bCj().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kMc);
        dcr();
        dct();
        if (this.kLZ != null) {
            this.kLZ.onDestroy();
        }
        com.baidu.tbadk.mutiprocess.g.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
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

    private void cNo() {
        bFP();
        this.kLX = new h(this);
        initViewPager();
        this.kLX.j(this.kLR);
        dcn();
        cwG();
        dcj();
        dci();
        this.kLW.e(this.kLU, this.mIndex, this.mIndex);
    }

    private void dci() {
        this.kLS = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.kLT = new com.baidu.tieba.image.a.c(getPageContext(), this.kLS);
        this.kLT.setFromForumId(this.kMm);
    }

    private void dcj() {
        if (com.baidu.tbadk.core.util.g.bsX()) {
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
        this.kLT.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(1284);
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        dck();
        bWZ();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.CAM_X0606));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (b.Of((String) y.getItem(this.kLU, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void dck() {
        this.iVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.jVn = (ImageView) this.iVu.findViewById(R.id.widget_navi_back_button);
        SvgManager.btW().a(this.jVn, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iVu.setVisibility(0);
    }

    private void bWZ() {
        if (!this.kMi && !this.kMh) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.kLL = addCustomView.findViewById(R.id.view_user_photo);
            this.kLM = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.kLN = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.kLM.setIsRound(true);
            this.kLM.setPlaceHolder(1);
            if (this.kMg) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.KW(0);
                pVar.TH(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.KW(1);
                pVar2.TH(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.kLK = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.kLK.setNeedDayNight(false);
                this.kLK.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.kLK.setVisibility(0);
                this.kLK.setOnSwitchChangeListener(this.kMq);
                u(this.kLL, 0);
                return;
            }
            u(this.kLK, 8);
            u(this.kLL, 8);
        }
    }

    public Map<String, ImageUrlData> dcl() {
        return this.fqD;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long dcm() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.kLU, this.mIndex);
        if (this.fqD == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fqD.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcn() {
        String str;
        if (this.kLU != null) {
            long dcm = dcm();
            String str2 = ("" + dcm) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.kMe && dcm() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new ar("c13316").dY("obj_source", this.mFrom));
                this.kMe = true;
            }
            if (dco()) {
                dcp();
            } else {
                Oh(str);
            }
            long j = dcm - 1;
            Fb(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dco() {
        if (this.kMf && this.kLZ != null && this.kLZ.dbS()) {
            return this.kLR.getItemNum() != 1 && this.mIndex == this.kLR.getItemNum() + (-1);
        }
        return false;
    }

    private void Oh(String str) {
        this.mTitleView.setText(str);
        if (this.kMg && !this.kMh && this.kLK != null) {
            this.kLK.kj(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void dcp() {
        this.mTitleView.setText("");
        u(this.kLK, 8);
        u(this.kLL, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kLR == null) {
            this.kLR = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kLR.init();
        }
        this.kLR.setIsFromCDN(this.fpu);
        this.kLR.setIsCanDrag(this.fpw);
        this.kLR.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kLR.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kLR.setOnPageChangeListener(this.cyV);
        this.kLR.setUrlData(this.kLU);
        this.kLR.setAssistUrls(this.fqD);
        this.kLR.setOuterOnTouchListener(this.frt);
        this.kLR.setItemOnclickListener(this.mOnClickListener);
        this.kLR.setItemOnLongClickListener(this.kMs);
        this.kLR.setCurrentItem(cTa(), false);
        this.kLR.setOnScrollOutListener(this.kMt);
        this.kLZ = new a(this.fpu, this.kMf, getPageContext(), this.fFV, this.amY);
        this.kLZ.setDragToExitListener(this.frg);
        this.kLR.a(this.kLZ);
        this.kLR.setOriImgSelectedCallback(this.fpm);
        this.kLR.setDragToExitListener(this.frg);
        this.kLR.setUserId(this.mUserId);
        this.kLR.setShowBottomContainer(this.kMl);
        this.kLR.setOnShareImageListener(this.kLX);
        this.kLR.setOnDownloadImageListener(this.kLX);
        this.kLR.setOnReplyClickListener(this.kMp);
        TiebaStatic.log(new ar("c13340").dY("uid", this.mUserId).dY("post_id", this.amY).al("obj_source", dcq()));
    }

    private int dcq() {
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

    private void cwG() {
        if (!this.kMh && this.kLK != null) {
            if (this.kLY == null) {
                this.kLY = new com.baidu.tieba.d.e(getPageContext(), this.kLK);
                this.kLY.fO(R.drawable.pic_sign_tip);
                this.kLY.fN(48);
                this.kLY.setUseDirectOffset(true);
                this.kLY.fP(5000);
                this.kLY.yt(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.kLY.d(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.dcr();
                    }
                });
            }
            this.kLY.aP(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcr() {
        if (this.kLY != null) {
            this.kLY.UG();
        }
    }

    public int cTa() {
        int count = y.getCount(this.kLU);
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
        this.kLW = new g();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.kMi = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.kLU = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fFV = bundle.getString("fid");
            this.amY = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.gsb = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.fpu = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.kMk = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.kMf = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.fpw = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.kMg = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.kLo = bundle.getString("source_rect_in_screen");
            this.kLq = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.kMl = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.kLr = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.fqD = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fqD.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.kMj = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.kMh = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.kLs = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.kMm = bundle.getString("from_forum_id");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.kMi = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.kLU = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fFV = intent.getStringExtra("fid");
                this.amY = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.gsb = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.fpu = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.kMk = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.kMf = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.fpw = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.kMg = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.kMl = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.kLr = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.kMj = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.kMh = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.kLo = intent.getStringExtra("source_rect_in_screen");
                this.kLq = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.fqD = (Map) serializableExtra;
                }
                this.kLs = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.kMm = intent.getStringExtra("from_forum_id");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.kK(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.kLW.b(bundle, getIntent());
        this.mCount = y.getCount(this.kLU);
        if (this.kLo != null) {
            String str = (String) y.getItem(this.kLU, this.mIndex);
            if (!StringUtils.isNull(str) && this.fqD != null && (imageUrlData = this.fqD.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.kLo);
            }
        }
        this.kLp = this.kMi ? null : b.Oe((String) y.getItem(this.kLU, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new ar("c13337").dY("obj_type", "2"));
        } else {
            TiebaStatic.log(new ar("c13337").dY("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.kMi);
        bundle.putStringArrayList("url", this.kLU);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fFV);
        bundle.putString("tid", this.amY);
        bundle.putString("fname", this.gsb);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.kMk);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.fpw);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.kMg);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.kMf);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.kMl);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.kLr);
        if (this.fqD instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fqD.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fqD instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fqD.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.kLo);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.kMj);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.kMh);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.kLq);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.kMm);
        this.kLW.az(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kLR.setCurrentItem(this.mIndex, false);
        SvgManager.btW().a(this.jVn, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fa(int i) {
        if (this.kLR != null) {
            this.kLR.rU(i);
            int i2 = (this.kLR.bAJ() || dco()) ? 8 : 0;
            u(this.kLK, i2);
            u(this.kLL, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcs() {
        if (dco()) {
            this.kMb = this.mNavigationBar.getVisibility() == 0;
            this.kMa = true;
        } else if (this.kMa) {
            this.mNavigationBar.setVisibility(this.kMb ? 0 : 8);
            this.kMa = false;
        }
    }

    private void Fb(int i) {
        if (this.kLV != null) {
            ArrayList<AlaInfoData> dbT = this.kLV.dbT();
            if (dbT != null && dbT.size() > 0) {
                tp(true);
                b(dbT.get(i % dbT.size()));
                return;
            }
            tp(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.kLM, alaInfoData.user_info.portrait);
            this.kLM.setAlaInfo(alaInfoData);
            this.kLM.setOnClickListener(this.kMu);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                Oi(alaInfoData.tag);
            }
            TiebaStatic.log(new ar("c13710").dY("fid", this.fFV).dY("fname", this.gsb).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", this.amY).dY("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void tp(boolean z) {
        if (this.kLP != z) {
            if (this.kLN != null) {
                if (z) {
                    this.kLN.setVisibility(0);
                    if (!this.kLN.isAnimating()) {
                        this.kLN.setSpeed(0.8f);
                        this.kLN.setRepeatCount(-1);
                        this.kLN.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.kLN.playAnimation();
                            }
                        });
                    }
                } else {
                    this.kLN.setVisibility(8);
                    if (this.kLN.isAnimating()) {
                        this.kLN.cancelAnimation();
                    }
                }
            }
            if (this.kLM != null) {
                this.kLM.setVisibility(z ? 0 : 8);
            }
            this.kLP = z;
        }
    }

    private void Fc(int i) {
        if (this.kLN != null) {
            if (i == 1) {
                this.kLN.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.kLN.setAnimation("live/card_live_bg_black.json");
            } else {
                this.kLN.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oi(@NonNull final String str) {
        if (this.kLN != null) {
            this.kLN.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.kLO != null) {
                        if (ImageViewerActivity.this.kLQ == null || ImageViewerActivity.this.kLO == null || ImageViewerActivity.this.kLL == null || ImageViewerActivity.this.kLL.getVisibility() != 0) {
                            ImageViewerActivity.this.dct();
                            return;
                        }
                        ImageViewerActivity.this.kLO.JA(str);
                        ImageViewerActivity.this.kLQ = null;
                        return;
                    }
                    ImageViewerActivity.this.kLO = new com.baidu.tieba.d.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.kLN);
                    ImageViewerActivity.this.kLO.fO(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.kLO.fN(32);
                    ImageViewerActivity.this.kLO.setUseDirectOffset(true);
                    ImageViewerActivity.this.kLO.ys(1);
                    ImageViewerActivity.this.kLO.yt(0);
                    ImageViewerActivity.this.kLO.fP(3000);
                    ImageViewerActivity.this.kLO.d(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.dct();
                        }
                    });
                    if (ImageViewerActivity.this.kLL == null || ImageViewerActivity.this.kLL.getVisibility() == 0) {
                        ImageViewerActivity.this.kLO.JA(str);
                        return;
                    }
                    ImageViewerActivity.this.kLQ = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dct() {
        if (this.kLO != null) {
            this.kLO.UG();
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
                return com.baidu.tbadk.m.e.bEZ().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fFV, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.amY, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Eu(TbadkCoreApplication.getInst().getAdAdSense().fje);
            }
        }
        return pageStayDurationItem;
    }

    public boolean dcu() {
        return this.kMi;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (au.isEmpty(this.amY)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.amY, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iSU == null) {
            this.iSU = VoiceManager.instance();
        }
        return this.iSU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdvertAppInfo advertAppInfo, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(advertAppInfo, 5, 0);
        c.Js(i);
        com.baidu.tieba.recapp.report.d.dGf().a(c);
    }
}
