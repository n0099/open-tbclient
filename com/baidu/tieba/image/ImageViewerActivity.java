package com.baidu.tieba.image;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.image.d;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.q;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.webkit.internal.ETAG;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.c {
    private String amM;
    private String eRn;
    private String fKR;
    private Map<String, ImageUrlData> fvC;
    private String gyv;
    private VoiceManager jaA;
    private View jdb;
    private com.baidu.tieba.frs.profession.permission.c jeV;
    private TBLottieAnimationView kMA;
    private com.baidu.tieba.c.e kMB;
    private String kMD;
    private MultiImageView kME;
    private LinearLayout kMF;
    private com.baidu.tieba.image.a.c kMG;
    private ArrayList<String> kMH;
    private d kMI;
    private i kMJ;
    private j kMK;
    private com.baidu.tieba.c.e kML;
    private c kMM;
    private int kMR;
    private boolean kMS;
    private String kMa;
    private String kMb;
    private int kMe;
    private SortSwitchButton kMx;
    private View kMy;
    private HeadImageView kMz;
    private String kNb;
    private float kNg;
    private ImageView kdU;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private String mPostId;
    private String mRecomAbTag;
    private String mRecomExtra;
    private String mRecomSource;
    private String mRecomWeight;
    private int mSkinType;
    private View mStatusBarView;
    private int mThreadType;
    private TextView mTitleView;
    private String mUserId;
    private boolean kMC = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a kMN = null;
    private boolean kMO = com.baidu.tbadk.a.d.biH();
    private boolean kMP = false;
    private boolean kMQ = false;
    private int abA = 0;
    private boolean kMT = false;
    private boolean kMU = true;
    private boolean fuv = true;
    private boolean kMV = true;
    private boolean mIsSeeHost = false;
    private boolean kMW = false;
    private boolean kMX = false;
    private boolean kMY = false;
    private boolean kMc = false;
    private boolean kMZ = true;
    private boolean fut = false;
    private boolean kNa = true;
    private boolean kMd = false;
    private CustomMessageListener kNc = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.cYl();
            }
        }
    };
    private final CustomMessageListener kNd = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null && !StringUtils.isNull(mVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(mVar);
                if (StringUtils.isNull(mVar.fxW)) {
                    be.bsB().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink});
                } else {
                    be.bsB().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink, mVar.fxW});
                }
            }
        }
    };
    private DragImageView.d fwe = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.x(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.kMx, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.jdb, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.kMy, 8);
            if (ImageViewerActivity.this.kME != null) {
                ImageViewerActivity.this.kME.ky(false);
            }
            ImageViewerActivity.this.cYj();
            ImageViewerActivity.this.cYl();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new aq("c13341").an("obj_param1", ImageViewerActivity.this.kME.getItemNum()).an(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kME.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bFG() {
            ImageViewerActivity.this.x(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.jdb.setVisibility(0);
            if (ImageViewerActivity.this.kME != null && !ImageViewerActivity.this.cYg()) {
                boolean bzk = ImageViewerActivity.this.kME.bzk();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bzk) {
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kMx, 0);
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kMy, 0);
                    ImageViewerActivity.this.MG(ImageViewerActivity.this.kMD);
                    if (ImageViewerActivity.this.kNa) {
                        ImageViewerActivity.this.kME.ky(true);
                    } else {
                        ImageViewerActivity.this.kME.ky(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener kNe = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13857").dW("obj_type", "3").dW("post_id", ImageViewerActivity.this.amM).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", ImageViewerActivity.this.fKR));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.jeV == null) {
                    ImageViewerActivity.this.jeV = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.jeV.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qC(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void B(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qD(boolean z) {
                            if (z && ImageViewerActivity.this.kMG != null && ImageViewerActivity.this.kME.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.kMG.b(ImageViewerActivity.this.kME.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kMI);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.jeV.zU((ImageViewerActivity.this.kME == null || ImageViewerActivity.this.kME.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kME.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kME.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.jeV.H(ImageViewerActivity.this.fKR, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.amM, 0L));
            }
        }
    };
    private UrlDragImageView.b fum = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bzC() {
            TiebaStatic.log(new aq("c10351").dW("tid", ImageViewerActivity.this.amM).dW("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a kNf = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zf(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.kMS = true;
                if (ImageViewerActivity.this.kMx != null) {
                    ImageViewerActivity.this.kMx.setEnabled(false);
                }
                ImageViewerActivity.this.k(b.MC((String) x.getItem(ImageViewerActivity.this.kMH, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new aq("c13857").an("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dW("post_id", ImageViewerActivity.this.amM).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fid", ImageViewerActivity.this.fKR));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13341").an("obj_param1", ImageViewerActivity.this.kME.getItemNum()).an(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kME.getCurrentMaxIndex()));
            TiebaStatic.log(new aq("c13377").dW("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener fwq = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.kNg = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.kNg = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener kNh = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (com.baidu.tbadk.a.d.bjg()) {
                if (ImageViewerActivity.this.kMK != null) {
                    ImageViewerActivity.this.kMK.cYr();
                }
            } else if (ImageViewerActivity.this.kMK != null) {
                ImageViewerActivity.this.kMK.cuk();
                ImageViewerActivity.this.kMK.show();
                ImageViewerActivity.this.kMK.dr(view);
            }
            TiebaStatic.log(new aq("c13269").dW("uid", ImageViewerActivity.this.mUserId).dW("fid", ImageViewerActivity.this.fKR).dW("tid", ImageViewerActivity.this.amM));
            return true;
        }
    };
    private BaseViewPager.a kNi = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kMI.cXL();
            } else if (ImageViewerActivity.this.cYe() != 1) {
                ImageViewerActivity.this.kMI.cXM();
            }
        }
    };
    private ViewPager.OnPageChangeListener czc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kMI != null && i > ImageViewerActivity.this.kME.getItemNum() - 5) {
                ImageViewerActivity.this.kMI.cXL();
            }
            if (ImageViewerActivity.this.kMO && ImageViewerActivity.this.kMM != null && ImageViewerActivity.this.kMI != null && ImageViewerActivity.this.kME != null) {
                ImageViewerActivity.this.kMM.X(ImageViewerActivity.this.kMI.cXK(), ImageViewerActivity.this.mCount, i);
                ImageViewerActivity.this.kMM.Dm(i);
            }
            ImageViewerActivity.this.kMJ.e(ImageViewerActivity.this.kMH, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.cYf();
            ImageViewerActivity.this.cYk();
            ImageViewerActivity.this.Do(i);
            if (ImageViewerActivity.this.kMJ.cYo() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kMJ.Dr(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kMJ.cYp() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kMJ.Ds(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.cYg()) {
                if (ImageViewerActivity.this.kMO) {
                    if (ImageViewerActivity.this.kMM != null) {
                        ImageViewerActivity.this.kMM.onAdShow();
                    }
                } else if (ImageViewerActivity.this.kMN != null) {
                    ImageViewerActivity.this.kMN.onAdShow();
                }
            }
            if (ImageViewerActivity.this.kMK != null) {
                ImageViewerActivity.this.kMK.cYt();
            }
            if (ImageViewerActivity.this.kMG != null && ImageViewerActivity.this.kME.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.kMG.a(ImageViewerActivity.this.kME.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kMI);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.abA) {
                ImageViewerActivity.this.abA = i;
            } else if (i < ImageViewerActivity.this.abA) {
                ImageViewerActivity.this.abA = i;
            }
            if (ImageViewerActivity.this.kME != null) {
                dragImageView = ImageViewerActivity.this.kME.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cYe() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.cYl();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.kMH != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.kMH.size()) {
                ImageViewerActivity.this.kMJ.bB(i, (String) ImageViewerActivity.this.kMH.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener kNj = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.eBp).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.eBy).append("?").append(com.baidu.tbadk.BdToken.f.eBU).append("=").append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.eBV).append("=").append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    Intent intent = new Intent(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_BROADCAST);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA_CORE, alaLiveInfoCoreData);
                    bundle.putString(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA_FROM, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP);
                    bundle.putBoolean(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA_HOST, false);
                    intent.putExtra(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA, bundle);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                TiebaStatic.log(new aq("c13711").dW("fid", ImageViewerActivity.this.fKR).dW("fname", ImageViewerActivity.this.gyv).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", ImageViewerActivity.this.amM).dW("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fvC != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fvC.values()) {
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
    private CustomMessageListener fcr = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fvC != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fvC.values()) {
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
    public void x(View view, int i) {
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
        com.baidu.tbadk.mutiprocess.g.bCN().c(TbadkCoreApplication.getInst());
        this.kMR = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cME();
        k(this.kMb, this.mIsSeeHost, false);
        registerListener(this.kNd);
        registerListener(this.kNc);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.fcr);
        this.jaA = getVoiceManager();
        this.jaA.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28) {
            if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
            }
        }
    }

    public void setAddSize(int i) {
        if (this.kME != null) {
            this.kME.setAddSize(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kMI = new d(this.kMH, this.fvC, this.fKR, this.gyv, this.amM, this.eRn, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.kMe, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kMI.setSourceImageRectInScreen(this.kMa);
        this.kMI.ti(this.kMZ);
        this.kMI.tj(z);
        this.kMI.ME(this.kMb);
        this.kMI.th(this.kMc);
        this.kMI.setPostId(this.mPostId);
        this.kMI.tl(this.kMd);
        this.kMI.a(new d.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.d.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kME != null) {
                    if (ImageViewerActivity.this.kMS) {
                        if (!z5) {
                            ImageViewerActivity.this.kME.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.kMS = false;
                    if (ImageViewerActivity.this.kMx != null) {
                        ImageViewerActivity.this.kMx.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kME.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kME.getItemNum();
                        ImageViewerActivity.this.kME.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kME.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kME.setTempSize(0);
                    }
                    if (ImageViewerActivity.this.kMO) {
                        int cXK = ImageViewerActivity.this.kMI.cXK();
                        if (ImageViewerActivity.this.kMM != null) {
                            ImageViewerActivity.this.kMM.cU(x.getCount(arrayList), i2);
                            ImageViewerActivity.this.kMM.X(cXK, i2, ImageViewerActivity.this.mIndex);
                        }
                    } else if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.kMN != null) {
                        AdvertAppInfo.eJg.set(true);
                        int bll = advertAppInfo.bll();
                        if (bll == 0) {
                            ImageViewerActivity.this.kMN.a(advertAppInfo, arrayList.size());
                        } else {
                            ImageViewerActivity.this.b(advertAppInfo, bll);
                        }
                    }
                    ImageViewerActivity.this.kME.setUrlData(arrayList);
                    ImageViewerActivity.this.kME.setAssistUrls(ImageViewerActivity.this.fvC);
                    ImageViewerActivity.this.kME.setHasNext(z3);
                    ImageViewerActivity.this.kME.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kME.getItemNum()) {
                        ImageViewerActivity.this.kME.qB(ImageViewerActivity.this.kME.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kME.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kME.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kME.setUrlData(arrayList);
                        ImageViewerActivity.this.kME.setCurrentItem(ImageViewerActivity.this.kME.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.cYe() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    if (ImageViewerActivity.this.kMO) {
                        c(arrayList, i2);
                    } else {
                        a(arrayList, advertAppInfo);
                    }
                    ImageViewerActivity.this.cYf();
                    if (ImageViewerActivity.this.kMG != null && ImageViewerActivity.this.kME.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.kMG.a(ImageViewerActivity.this.kME.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kMI);
                    }
                }
            }

            private void c(ArrayList<String> arrayList, int i) {
                if (ImageViewerActivity.this.kMM != null && arrayList != null) {
                    if (ImageViewerActivity.this.kMM.cXH()) {
                        ImageViewerActivity.this.kMM.cU(x.getCount(arrayList), i);
                        ImageViewerActivity.this.setAddSize(1);
                        return;
                    }
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (ImageViewerActivity.this.kMN == null || advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                int bll = advertAppInfo.bll();
                if (bll != 0) {
                    ImageViewerActivity.this.b(advertAppInfo, bll);
                    return;
                }
                ImageViewerActivity.this.kMN.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.kMN.cXG()) {
                    ImageViewerActivity.this.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.d.b
            public void bA(int i, String str2) {
                ImageViewerActivity.this.kMS = false;
                if (ImageViewerActivity.this.kMx != null) {
                    if (ImageViewerActivity.this.kMx.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.kMx.iC(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.kMx.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.kMH != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.kMH.size();
                    }
                    ImageViewerActivity.this.cYf();
                }
            }
        });
        this.kMI.tk(true);
        this.kMI.cXL();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!k.isFastDoubleClick()) {
            TiebaStatic.log(new aq("c13377").dW("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kME.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kME.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.kMR = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        Dq(i);
        if (this.kMK != null) {
            this.kMK.onChangeSkinType();
        }
        if (this.kMG != null) {
            this.kMG.onChangeSkinType(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jaA != null) {
            this.jaA.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jaA != null) {
            this.jaA.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kME.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.amM, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
        if (this.jaA != null) {
            this.jaA.onPause(getPageContext());
        }
        this.kMG.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kME.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.amM, 0L);
        if (uniqueId != null && j > 0) {
            r.b(com.baidu.tbadk.BdToken.b.eAh, uniqueId.getId(), j);
        }
        if (this.jaA != null) {
            this.jaA.onResume(getPageContext());
        }
        this.kMG.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kME.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        MessageManager.getInstance().unRegisterListener(this.kNd);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bCx().releaseBlockBitmapPool();
        this.kMJ.e(this.kMH, this.mIndex, this.mIndex);
        this.kMJ.cYq();
        String str3 = "";
        if (this.kMN != null) {
            str3 = this.kMN.getAdId();
        }
        if (this.kMI != null) {
            str2 = this.kMI.bpi();
            str = this.kMI.bpj();
        } else {
            str = null;
            str2 = null;
        }
        this.kMJ.a(this.kME.getPageCount(), str3, this.fKR, this.amM, str2, str);
        if (this.kMK != null) {
            this.kMK.release();
        }
        this.kME.onDestroy();
        this.kMG.onDestroy();
        if (this.jaA != null) {
            this.jaA.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bAL().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kMR);
        cYj();
        cYl();
        if (this.kMN != null) {
            this.kMN.onDestroy();
        }
        if (this.kMM != null) {
            this.kMM.onDestroy();
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

    private void cME() {
        bEt();
        this.kMK = new j(this);
        initViewPager();
        this.kMK.k(this.kME);
        cYf();
        cvJ();
        cYa();
        cXZ();
        this.kMJ.e(this.kMH, this.mIndex, this.mIndex);
    }

    private void cXZ() {
        this.kMF = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.kMG = new com.baidu.tieba.image.a.c(getPageContext(), this.kMF);
        this.kMG.setFromForumId(this.kNb);
        this.kMG.setSkinType(this.mSkinType);
        this.kMG.onChangeSkinType(this.mSkinType);
    }

    private void cYa() {
        if (com.baidu.tbadk.core.util.g.brG()) {
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
        this.kMG.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(1284);
    }

    private void bEt() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cYb();
        bVO();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        float[] nL = com.baidu.tbadk.core.elementsMaven.a.nL(R.array.S_O_X001);
        this.mTitleView.setShadowLayer(nL[1], nL[2], nL[3], (int) nL[0]);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (b.MD((String) x.getItem(this.kMH, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cYb() {
        this.jdb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jdb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageViewerActivity.this.kMO && ImageViewerActivity.this.cYg()) {
                    aq.AM("c14044").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).bsu();
                }
                ImageViewerActivity.this.finish();
            }
        });
        this.kdU = (ImageView) this.jdb.findViewById(R.id.widget_navi_back_button);
        SvgManager.bsx().a(this.kdU, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jdb.setVisibility(0);
    }

    private void cYc() {
        if (this.kMO && cYg()) {
            SvgManager.bsx().a(this.kdU, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.bsx().a(this.kdU, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bVO() {
        if (!this.kMX && !this.kMW) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.kMy = addCustomView.findViewById(R.id.view_user_photo);
            this.kMz = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.kMA = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.kMz.setIsRound(true);
            this.kMz.setPlaceHolder(1);
            if (this.kMV) {
                ArrayList arrayList = new ArrayList(2);
                q qVar = new q();
                qVar.Jl(0);
                qVar.Sh(getString(R.string.all));
                arrayList.add(qVar);
                q qVar2 = new q();
                qVar2.Jl(1);
                qVar2.Sh(getString(R.string.host_name));
                arrayList.add(qVar2);
                this.kMx = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.kMx.setNeedDayNight(false);
                this.kMx.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.kMx.setVisibility(0);
                this.kMx.setOnSwitchChangeListener(this.kNf);
                x(this.kMy, 0);
                return;
            }
            x(this.kMx, 8);
            x(this.kMy, 8);
        }
    }

    public Map<String, ImageUrlData> cYd() {
        return this.fvC;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cYe() {
        ImageUrlData imageUrlData;
        String str = (String) x.getItem(this.kMH, this.mIndex);
        if (this.fvC == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fvC.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYf() {
        String str;
        if (this.kMH != null) {
            long cYe = cYe();
            String str2 = ("" + cYe) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.kMT && cYe() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new aq("c13316").dW("obj_source", this.mFrom));
                this.kMT = true;
            }
            if (cYg()) {
                cYh();
            } else {
                MF(str);
            }
            long j = cYe - 1;
            Dp(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cYg() {
        if (this.kMO) {
            if (this.kMU && this.kMM != null && this.kMM.cXG()) {
                return this.kME.getItemNum() != 1 && this.mIndex == this.kME.getItemNum() + (-1);
            }
            return false;
        } else if (this.kMU && this.kMN != null && this.kMN.cXG()) {
            return this.kME.getItemNum() != 1 && this.mIndex == this.kME.getItemNum() + (-1);
        } else {
            return false;
        }
    }

    private void MF(String str) {
        this.mTitleView.setText(str);
        if (this.kMV && !this.kMW && this.kMx != null) {
            this.kMx.iC(this.mIsSeeHost ? 1 : 0);
        }
        float[] nL = com.baidu.tbadk.core.elementsMaven.a.nL(R.array.S_O_X001);
        this.mTitleView.setShadowLayer(nL[1], nL[2], nL[3], (int) nL[0]);
    }

    private void cYh() {
        this.mTitleView.setText("");
        x(this.kMx, 8);
        x(this.kMy, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kME == null) {
            this.kME = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kME.init();
        }
        this.kME.setIsFromCDN(this.fut);
        this.kME.setIsCanDrag(this.fuv);
        this.kME.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kME.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kME.setOnPageChangeListener(this.czc);
        this.kME.setUrlData(this.kMH);
        this.kME.setAssistUrls(this.fvC);
        this.kME.setOuterOnTouchListener(this.fwq);
        this.kME.setItemOnclickListener(this.mOnClickListener);
        this.kME.setItemOnLongClickListener(this.kNh);
        this.kME.setCurrentItem(cSq(), false);
        this.kME.setOnScrollOutListener(this.kNi);
        if (this.kMO) {
            this.kMM = new c(this, this.kMU);
            this.kMM.setDragToExitListener(this.fwe);
            this.kME.a(this.kMM);
        } else {
            this.kMN = new a(this.fut, this.kMU, getPageContext(), this.fKR, this.amM);
            this.kMN.setDragToExitListener(this.fwe);
            this.kME.a(this.kMN);
        }
        this.kME.setOriImgSelectedCallback(this.fum);
        this.kME.setDragToExitListener(this.fwe);
        this.kME.setUserId(this.mUserId);
        this.kME.setShowBottomContainer(this.kNa);
        this.kME.setOnShareImageListener(this.kMK);
        this.kME.setOnDownloadImageListener(this.kMK);
        this.kME.setOnReplyClickListener(this.kNe);
        TiebaStatic.log(new aq("c13340").dW("uid", this.mUserId).dW("post_id", this.amM).an("obj_source", cYi()));
    }

    private int cYi() {
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

    private void cvJ() {
        if (!this.kMW && this.kMx != null) {
            if (this.kML == null) {
                this.kML = new com.baidu.tieba.c.e(getPageContext(), this.kMx);
                this.kML.ej(R.drawable.pic_sign_tip);
                this.kML.ei(48);
                this.kML.setUseDirectOffset(true);
                this.kML.ek(5000);
                this.kML.xb(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.kML.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.cYj();
                    }
                });
            }
            this.kML.aJ(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYj() {
        if (this.kML != null) {
            this.kML.RS();
        }
    }

    public int cSq() {
        int count = x.getCount(this.kMH);
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
        String str;
        ImageUrlData imageUrlData;
        this.kMJ = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.kMX = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.kMH = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fKR = bundle.getString("fid");
            this.amM = bundle.getString("tid");
            this.eRn = bundle.getString(IntentConfig.NID);
            this.gyv = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.fut = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.kMZ = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.kMU = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.fuv = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.kMV = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.kMa = bundle.getString("source_rect_in_screen");
            this.kMc = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            isLogin = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            bduss = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            str = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.kNa = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.kMd = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.fvC = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fvC.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.kMY = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.kMW = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.kMe = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.kNb = bundle.getString("from_forum_id");
            this.mSkinType = bundle.getInt("skin_type");
            stoken = string;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.kMX = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.kMH = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fKR = intent.getStringExtra("fid");
                this.amM = intent.getStringExtra("tid");
                this.eRn = intent.getStringExtra(IntentConfig.NID);
                this.gyv = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.fut = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.kMZ = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.kMU = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.fuv = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.kMV = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.kNa = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.kMd = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.kMY = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.kMW = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                isLogin = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                bduss = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.kMa = intent.getStringExtra("source_rect_in_screen");
                this.kMc = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.fvC = (Map) serializableExtra;
                }
                this.kMe = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.kNb = intent.getStringExtra("from_forum_id");
                this.mSkinType = intent.getIntExtra("skin_type", 0);
                stoken = stringExtra;
            } else {
                str = tbs;
            }
        }
        com.baidu.tbadk.mutiprocess.f.lc(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(str);
        this.kMJ.a(bundle, getIntent());
        this.mCount = x.getCount(this.kMH);
        if (this.kMa != null) {
            String str2 = (String) x.getItem(this.kMH, this.mIndex);
            if (!StringUtils.isNull(str2) && this.fvC != null && (imageUrlData = this.fvC.get(str2)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.kMa);
            }
        }
        this.kMb = this.kMX ? null : b.MC((String) x.getItem(this.kMH, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new aq("c13337").dW("obj_type", "2"));
        } else {
            TiebaStatic.log(new aq("c13337").dW("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.kMX);
        bundle.putStringArrayList("url", this.kMH);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fKR);
        bundle.putString("tid", this.amM);
        bundle.putString("fname", this.gyv);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.kMZ);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.fuv);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.kMV);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.kMU);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.kNa);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.kMd);
        if (this.fvC instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fvC.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fvC instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fvC.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.kMa);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.kMY);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.kMW);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.kMc);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.kNb);
        bundle.putInt("skin_type", this.mSkinType);
        this.kMJ.az(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kME.setCurrentItem(this.mIndex, false);
        SvgManager.bsx().a(this.kdU, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Do(int i) {
        if (this.kME != null) {
            this.kME.qA(i);
            int i2 = (this.kME.bzk() || cYg()) ? 8 : 0;
            x(this.kMx, i2);
            x(this.kMy, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYk() {
        if (cYg()) {
            this.kMQ = this.mNavigationBar.getVisibility() == 0;
            this.kMP = true;
        } else if (this.kMP) {
            this.mNavigationBar.setVisibility(this.kMQ ? 0 : 8);
            this.kMP = false;
        }
        cYc();
    }

    private void Dp(int i) {
        if (this.kMI != null) {
            ArrayList<AlaInfoData> cXJ = this.kMI.cXJ();
            if (cXJ != null && cXJ.size() > 0) {
                tm(true);
                b(cXJ.get(i % cXJ.size()));
                return;
            }
            tm(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            a(this.kMz, alaInfoData.user_info.portrait);
            this.kMz.setAlaInfo(alaInfoData);
            this.kMz.setOnClickListener(this.kNj);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                MG(alaInfoData.tag);
            }
            TiebaStatic.log(new aq("c13710").dW("fid", this.fKR).dW("fname", this.gyv).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", this.amM).dW("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
        }
    }

    private void a(TbImageView tbImageView, @NonNull String str) {
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

    private void tm(boolean z) {
        if (this.kMC != z) {
            if (this.kMA != null) {
                if (z) {
                    this.kMA.setVisibility(0);
                    if (!this.kMA.isAnimating()) {
                        this.kMA.setSpeed(0.8f);
                        this.kMA.setRepeatCount(-1);
                        this.kMA.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.kMA.playAnimation();
                            }
                        });
                    }
                } else {
                    this.kMA.setVisibility(8);
                    if (this.kMA.isAnimating()) {
                        this.kMA.cancelAnimation();
                    }
                }
            }
            if (this.kMz != null) {
                this.kMz.setVisibility(z ? 0 : 8);
            }
            this.kMC = z;
        }
    }

    private void Dq(int i) {
        if (this.kMA != null) {
            ao.a(this.kMA, R.raw.card_live_header_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MG(@NonNull final String str) {
        if (this.kMA != null) {
            this.kMA.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.kMB != null) {
                        if (ImageViewerActivity.this.kMD == null || ImageViewerActivity.this.kMB == null || ImageViewerActivity.this.kMy == null || ImageViewerActivity.this.kMy.getVisibility() != 0) {
                            ImageViewerActivity.this.cYl();
                            return;
                        }
                        ImageViewerActivity.this.kMB.Im(str);
                        ImageViewerActivity.this.kMD = null;
                        return;
                    }
                    ImageViewerActivity.this.kMB = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.kMA);
                    ImageViewerActivity.this.kMB.ej(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.kMB.ei(32);
                    ImageViewerActivity.this.kMB.setUseDirectOffset(true);
                    ImageViewerActivity.this.kMB.xa(1);
                    ImageViewerActivity.this.kMB.xb(0);
                    ImageViewerActivity.this.kMB.ek(3000);
                    ImageViewerActivity.this.kMB.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.cYl();
                        }
                    });
                    if (ImageViewerActivity.this.kMy == null || ImageViewerActivity.this.kMy.getVisibility() == 0) {
                        ImageViewerActivity.this.kMB.Im(str);
                        return;
                    }
                    ImageViewerActivity.this.kMD = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYl() {
        if (this.kMB != null) {
            this.kMB.RS();
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
                return com.baidu.tbadk.m.e.bDA().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fKR, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.amM, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Df(TbadkCoreApplication.getInst().getAdAdSense().foc);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cYm() {
        return this.kMX;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (at.isEmpty(this.amM)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.amM, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jaA == null) {
            this.jaA = VoiceManager.instance();
        }
        return this.jaA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdvertAppInfo advertAppInfo, int i) {
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 5, 0);
        b2.HF(i);
        com.baidu.tieba.recapp.report.e.dCe().a(b2);
    }
}
