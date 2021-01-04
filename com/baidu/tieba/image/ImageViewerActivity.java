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
/* loaded from: classes8.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.c {
    private String anD;
    private String eVY;
    private Map<String, ImageUrlData> fAk;
    private String fPy;
    private String gDc;
    private VoiceManager jfh;
    private View jhI;
    private com.baidu.tieba.frs.profession.permission.c jjD;
    private String kQF;
    private String kQG;
    private int kQJ;
    private String kRG;
    private float kRL;
    private SortSwitchButton kRc;
    private View kRd;
    private HeadImageView kRe;
    private TBLottieAnimationView kRf;
    private com.baidu.tieba.c.e kRg;
    private String kRi;
    private MultiImageView kRj;
    private LinearLayout kRk;
    private com.baidu.tieba.image.a.c kRl;
    private ArrayList<String> kRm;
    private d kRn;
    private i kRo;
    private j kRp;
    private com.baidu.tieba.c.e kRq;
    private c kRr;
    private int kRw;
    private boolean kRx;
    private ImageView kiB;
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
    private boolean kRh = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a kRs = null;
    private boolean kRt = com.baidu.tbadk.a.d.bmA();
    private boolean kRu = false;
    private boolean kRv = false;
    private int abC = 0;
    private boolean kRy = false;
    private boolean kRz = true;
    private boolean fzd = true;
    private boolean kRA = true;
    private boolean mIsSeeHost = false;
    private boolean kRB = false;
    private boolean kRC = false;
    private boolean kRD = false;
    private boolean kQH = false;
    private boolean kRE = true;
    private boolean fzb = false;
    private boolean kRF = true;
    private boolean kQI = false;
    private CustomMessageListener kRH = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.dcc();
            }
        }
    };
    private final CustomMessageListener kRI = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null && !StringUtils.isNull(mVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(mVar);
                if (StringUtils.isNull(mVar.fCE)) {
                    be.bwu().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink});
                } else {
                    be.bwu().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink, mVar.fCE});
                }
            }
        }
    };
    private DragImageView.d fAM = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.x(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.kRc, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.jhI, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.kRd, 8);
            if (ImageViewerActivity.this.kRj != null) {
                ImageViewerActivity.this.kRj.kC(false);
            }
            ImageViewerActivity.this.dca();
            ImageViewerActivity.this.dcc();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new aq("c13341").an("obj_param1", ImageViewerActivity.this.kRj.getItemNum()).an(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kRj.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bJx() {
            ImageViewerActivity.this.x(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.jhI.setVisibility(0);
            if (ImageViewerActivity.this.kRj != null && !ImageViewerActivity.this.dbX()) {
                boolean bDd = ImageViewerActivity.this.kRj.bDd();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bDd) {
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kRc, 0);
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kRd, 0);
                    ImageViewerActivity.this.NP(ImageViewerActivity.this.kRi);
                    if (ImageViewerActivity.this.kRF) {
                        ImageViewerActivity.this.kRj.kC(true);
                    } else {
                        ImageViewerActivity.this.kRj.kC(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener kRJ = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13857").dX("obj_type", "3").dX("post_id", ImageViewerActivity.this.anD).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", ImageViewerActivity.this.fPy));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.jjD == null) {
                    ImageViewerActivity.this.jjD = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.jjD.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qG(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void B(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qH(boolean z) {
                            if (z && ImageViewerActivity.this.kRl != null && ImageViewerActivity.this.kRj.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.kRl.b(ImageViewerActivity.this.kRj.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kRn);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.jjD.BA((ImageViewerActivity.this.kRj == null || ImageViewerActivity.this.kRj.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kRj.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kRj.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.jjD.H(ImageViewerActivity.this.fPy, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.anD, 0L));
            }
        }
    };
    private UrlDragImageView.b fyU = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bDv() {
            TiebaStatic.log(new aq("c10351").dX("tid", ImageViewerActivity.this.anD).dX("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a kRK = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean AL(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.kRx = true;
                if (ImageViewerActivity.this.kRc != null) {
                    ImageViewerActivity.this.kRc.setEnabled(false);
                }
                ImageViewerActivity.this.k(b.NL((String) x.getItem(ImageViewerActivity.this.kRm, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new aq("c13857").an("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dX("post_id", ImageViewerActivity.this.anD).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fid", ImageViewerActivity.this.fPy));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13341").an("obj_param1", ImageViewerActivity.this.kRj.getItemNum()).an(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kRj.getCurrentMaxIndex()));
            TiebaStatic.log(new aq("c13377").dX("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener fAY = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.kRL = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.kRL = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener kRM = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (com.baidu.tbadk.a.d.bmZ()) {
                if (ImageViewerActivity.this.kRp != null) {
                    ImageViewerActivity.this.kRp.dci();
                }
            } else if (ImageViewerActivity.this.kRp != null) {
                ImageViewerActivity.this.kRp.cyb();
                ImageViewerActivity.this.kRp.show();
                ImageViewerActivity.this.kRp.dr(view);
            }
            TiebaStatic.log(new aq("c13269").dX("uid", ImageViewerActivity.this.mUserId).dX("fid", ImageViewerActivity.this.fPy).dX("tid", ImageViewerActivity.this.anD));
            return true;
        }
    };
    private BaseViewPager.a kRN = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kRn.dbC();
            } else if (ImageViewerActivity.this.dbV() != 1) {
                ImageViewerActivity.this.kRn.dbD();
            }
        }
    };
    private ViewPager.OnPageChangeListener cDO = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kRn != null && i > ImageViewerActivity.this.kRj.getItemNum() - 5) {
                ImageViewerActivity.this.kRn.dbC();
            }
            if (ImageViewerActivity.this.kRt && ImageViewerActivity.this.kRr != null && ImageViewerActivity.this.kRn != null && ImageViewerActivity.this.kRj != null) {
                ImageViewerActivity.this.kRr.X(ImageViewerActivity.this.kRn.dbB(), ImageViewerActivity.this.mCount, i);
                ImageViewerActivity.this.kRr.ES(i);
            }
            ImageViewerActivity.this.kRo.e(ImageViewerActivity.this.kRm, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.dbW();
            ImageViewerActivity.this.dcb();
            ImageViewerActivity.this.EU(i);
            if (ImageViewerActivity.this.kRo.dcf() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kRo.EX(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kRo.dcg() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kRo.EY(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.dbX()) {
                if (ImageViewerActivity.this.kRt) {
                    if (ImageViewerActivity.this.kRr != null) {
                        ImageViewerActivity.this.kRr.onAdShow();
                    }
                } else if (ImageViewerActivity.this.kRs != null) {
                    ImageViewerActivity.this.kRs.onAdShow();
                }
            }
            if (ImageViewerActivity.this.kRp != null) {
                ImageViewerActivity.this.kRp.dck();
            }
            if (ImageViewerActivity.this.kRl != null && ImageViewerActivity.this.kRj.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.kRl.a(ImageViewerActivity.this.kRj.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kRn);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.abC) {
                ImageViewerActivity.this.abC = i;
            } else if (i < ImageViewerActivity.this.abC) {
                ImageViewerActivity.this.abC = i;
            }
            if (ImageViewerActivity.this.kRj != null) {
                dragImageView = ImageViewerActivity.this.kRj.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.dbV() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.dcc();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.kRm != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.kRm.size()) {
                ImageViewerActivity.this.kRo.bA(i, (String) ImageViewerActivity.this.kRm.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener kRO = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.eGb).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.eGk).append("?").append(com.baidu.tbadk.BdToken.f.eGG).append("=").append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.eGH).append("=").append(alaInfo.thirdRoomId);
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
                TiebaStatic.log(new aq("c13711").dX("fid", ImageViewerActivity.this.fPy).dX("fname", ImageViewerActivity.this.gDc).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", ImageViewerActivity.this.anD).dX("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fAk != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fAk.values()) {
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
    private CustomMessageListener fgZ = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fAk != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fAk.values()) {
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
        com.baidu.tbadk.mutiprocess.g.bGF().c(TbadkCoreApplication.getInst());
        this.kRw = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cQv();
        k(this.kQG, this.mIsSeeHost, false);
        registerListener(this.kRI);
        registerListener(this.kRH);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.fgZ);
        this.jfh = getVoiceManager();
        this.jfh.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28) {
            if (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this)) {
                com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
            }
        }
    }

    public void setAddSize(int i) {
        if (this.kRj != null) {
            this.kRj.setAddSize(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kRn = new d(this.kRm, this.fAk, this.fPy, this.gDc, this.anD, this.eVY, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.kQJ, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kRn.setSourceImageRectInScreen(this.kQF);
        this.kRn.tm(this.kRE);
        this.kRn.tn(z);
        this.kRn.NN(this.kQG);
        this.kRn.tl(this.kQH);
        this.kRn.setPostId(this.mPostId);
        this.kRn.tp(this.kQI);
        this.kRn.a(new d.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.d.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kRj != null) {
                    if (ImageViewerActivity.this.kRx) {
                        if (!z5) {
                            ImageViewerActivity.this.kRj.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.kRx = false;
                    if (ImageViewerActivity.this.kRc != null) {
                        ImageViewerActivity.this.kRc.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kRj.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kRj.getItemNum();
                        ImageViewerActivity.this.kRj.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kRj.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kRj.setTempSize(0);
                    }
                    if (ImageViewerActivity.this.kRt) {
                        int dbB = ImageViewerActivity.this.kRn.dbB();
                        if (ImageViewerActivity.this.kRr != null) {
                            ImageViewerActivity.this.kRr.cU(x.getCount(arrayList), i2);
                            ImageViewerActivity.this.kRr.X(dbB, i2, ImageViewerActivity.this.mIndex);
                        }
                    } else if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.kRs != null) {
                        AdvertAppInfo.eNR.set(true);
                        int bpe = advertAppInfo.bpe();
                        if (bpe == 0) {
                            ImageViewerActivity.this.kRs.a(advertAppInfo, arrayList.size());
                        } else {
                            ImageViewerActivity.this.b(advertAppInfo, bpe);
                        }
                    }
                    ImageViewerActivity.this.kRj.setUrlData(arrayList);
                    ImageViewerActivity.this.kRj.setAssistUrls(ImageViewerActivity.this.fAk);
                    ImageViewerActivity.this.kRj.setHasNext(z3);
                    ImageViewerActivity.this.kRj.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kRj.getItemNum()) {
                        ImageViewerActivity.this.kRj.sh(ImageViewerActivity.this.kRj.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kRj.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kRj.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kRj.setUrlData(arrayList);
                        ImageViewerActivity.this.kRj.setCurrentItem(ImageViewerActivity.this.kRj.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.dbV() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    if (ImageViewerActivity.this.kRt) {
                        c(arrayList, i2);
                    } else {
                        a(arrayList, advertAppInfo);
                    }
                    ImageViewerActivity.this.dbW();
                    if (ImageViewerActivity.this.kRl != null && ImageViewerActivity.this.kRj.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.kRl.a(ImageViewerActivity.this.kRj.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kRn);
                    }
                }
            }

            private void c(ArrayList<String> arrayList, int i) {
                if (ImageViewerActivity.this.kRr != null && arrayList != null) {
                    if (ImageViewerActivity.this.kRr.dby()) {
                        ImageViewerActivity.this.kRr.cU(x.getCount(arrayList), i);
                        ImageViewerActivity.this.setAddSize(1);
                        return;
                    }
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (ImageViewerActivity.this.kRs == null || advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                int bpe = advertAppInfo.bpe();
                if (bpe != 0) {
                    ImageViewerActivity.this.b(advertAppInfo, bpe);
                    return;
                }
                ImageViewerActivity.this.kRs.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.kRs.dbx()) {
                    ImageViewerActivity.this.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.d.b
            public void bz(int i, String str2) {
                ImageViewerActivity.this.kRx = false;
                if (ImageViewerActivity.this.kRc != null) {
                    if (ImageViewerActivity.this.kRc.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.kRc.ki(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.kRc.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.kRm != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.kRm.size();
                    }
                    ImageViewerActivity.this.dbW();
                }
            }
        });
        this.kRn.to(true);
        this.kRn.dbC();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!k.isFastDoubleClick()) {
            TiebaStatic.log(new aq("c13377").dX("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kRj.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kRj.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.kRw = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        EW(i);
        if (this.kRp != null) {
            this.kRp.onChangeSkinType();
        }
        if (this.kRl != null) {
            this.kRl.onChangeSkinType(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jfh != null) {
            this.jfh.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kRj.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.anD, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
        if (this.jfh != null) {
            this.jfh.onPause(getPageContext());
        }
        this.kRl.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kRj.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.anD, 0L);
        if (uniqueId != null && j > 0) {
            r.b(com.baidu.tbadk.BdToken.b.eET, uniqueId.getId(), j);
        }
        if (this.jfh != null) {
            this.jfh.onResume(getPageContext());
        }
        this.kRl.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kRj.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        MessageManager.getInstance().unRegisterListener(this.kRI);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bGp().releaseBlockBitmapPool();
        this.kRo.e(this.kRm, this.mIndex, this.mIndex);
        this.kRo.dch();
        String str3 = "";
        if (this.kRs != null) {
            str3 = this.kRs.getAdId();
        }
        if (this.kRn != null) {
            str2 = this.kRn.btb();
            str = this.kRn.btc();
        } else {
            str = null;
            str2 = null;
        }
        this.kRo.a(this.kRj.getPageCount(), str3, this.fPy, this.anD, str2, str);
        if (this.kRp != null) {
            this.kRp.release();
        }
        this.kRj.onDestroy();
        this.kRl.onDestroy();
        if (this.jfh != null) {
            this.jfh.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bEE().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kRw);
        dca();
        dcc();
        if (this.kRs != null) {
            this.kRs.onDestroy();
        }
        if (this.kRr != null) {
            this.kRr.onDestroy();
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

    private void cQv() {
        bIk();
        this.kRp = new j(this);
        initViewPager();
        this.kRp.k(this.kRj);
        dbW();
        czA();
        dbR();
        dbQ();
        this.kRo.e(this.kRm, this.mIndex, this.mIndex);
    }

    private void dbQ() {
        this.kRk = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.kRl = new com.baidu.tieba.image.a.c(getPageContext(), this.kRk);
        this.kRl.setFromForumId(this.kRG);
        this.kRl.setSkinType(this.mSkinType);
        this.kRl.onChangeSkinType(this.mSkinType);
    }

    private void dbR() {
        if (com.baidu.tbadk.core.util.g.bvz()) {
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
        this.kRl.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(1284);
    }

    private void bIk() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        dbS();
        bZF();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        float[] ps = com.baidu.tbadk.core.elementsMaven.a.ps(R.array.S_O_X001);
        this.mTitleView.setShadowLayer(ps[1], ps[2], ps[3], (int) ps[0]);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (b.NM((String) x.getItem(this.kRm, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void dbS() {
        this.jhI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jhI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageViewerActivity.this.kRt && ImageViewerActivity.this.dbX()) {
                    aq.BY("c14044").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).bwn();
                }
                ImageViewerActivity.this.finish();
            }
        });
        this.kiB = (ImageView) this.jhI.findViewById(R.id.widget_navi_back_button);
        SvgManager.bwq().a(this.kiB, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jhI.setVisibility(0);
    }

    private void dbT() {
        if (this.kRt && dbX()) {
            SvgManager.bwq().a(this.kiB, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.bwq().a(this.kiB, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bZF() {
        if (!this.kRC && !this.kRB) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.kRd = addCustomView.findViewById(R.id.view_user_photo);
            this.kRe = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.kRf = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.kRe.setIsRound(true);
            this.kRe.setPlaceHolder(1);
            if (this.kRA) {
                ArrayList arrayList = new ArrayList(2);
                q qVar = new q();
                qVar.KS(0);
                qVar.Tq(getString(R.string.all));
                arrayList.add(qVar);
                q qVar2 = new q();
                qVar2.KS(1);
                qVar2.Tq(getString(R.string.host_name));
                arrayList.add(qVar2);
                this.kRc = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.kRc.setNeedDayNight(false);
                this.kRc.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.kRc.setVisibility(0);
                this.kRc.setOnSwitchChangeListener(this.kRK);
                x(this.kRd, 0);
                return;
            }
            x(this.kRc, 8);
            x(this.kRd, 8);
        }
    }

    public Map<String, ImageUrlData> dbU() {
        return this.fAk;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long dbV() {
        ImageUrlData imageUrlData;
        String str = (String) x.getItem(this.kRm, this.mIndex);
        if (this.fAk == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fAk.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbW() {
        String str;
        if (this.kRm != null) {
            long dbV = dbV();
            String str2 = ("" + dbV) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.kRy && dbV() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new aq("c13316").dX("obj_source", this.mFrom));
                this.kRy = true;
            }
            if (dbX()) {
                dbY();
            } else {
                NO(str);
            }
            long j = dbV - 1;
            EV(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dbX() {
        if (this.kRt) {
            if (this.kRz && this.kRr != null && this.kRr.dbx()) {
                return this.kRj.getItemNum() != 1 && this.mIndex == this.kRj.getItemNum() + (-1);
            }
            return false;
        } else if (this.kRz && this.kRs != null && this.kRs.dbx()) {
            return this.kRj.getItemNum() != 1 && this.mIndex == this.kRj.getItemNum() + (-1);
        } else {
            return false;
        }
    }

    private void NO(String str) {
        this.mTitleView.setText(str);
        if (this.kRA && !this.kRB && this.kRc != null) {
            this.kRc.ki(this.mIsSeeHost ? 1 : 0);
        }
        float[] ps = com.baidu.tbadk.core.elementsMaven.a.ps(R.array.S_O_X001);
        this.mTitleView.setShadowLayer(ps[1], ps[2], ps[3], (int) ps[0]);
    }

    private void dbY() {
        this.mTitleView.setText("");
        x(this.kRc, 8);
        x(this.kRd, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kRj == null) {
            this.kRj = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kRj.init();
        }
        this.kRj.setIsFromCDN(this.fzb);
        this.kRj.setIsCanDrag(this.fzd);
        this.kRj.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kRj.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kRj.setOnPageChangeListener(this.cDO);
        this.kRj.setUrlData(this.kRm);
        this.kRj.setAssistUrls(this.fAk);
        this.kRj.setOuterOnTouchListener(this.fAY);
        this.kRj.setItemOnclickListener(this.mOnClickListener);
        this.kRj.setItemOnLongClickListener(this.kRM);
        this.kRj.setCurrentItem(cWh(), false);
        this.kRj.setOnScrollOutListener(this.kRN);
        if (this.kRt) {
            this.kRr = new c(this, this.kRz);
            this.kRr.setDragToExitListener(this.fAM);
            this.kRj.a(this.kRr);
        } else {
            this.kRs = new a(this.fzb, this.kRz, getPageContext(), this.fPy, this.anD);
            this.kRs.setDragToExitListener(this.fAM);
            this.kRj.a(this.kRs);
        }
        this.kRj.setOriImgSelectedCallback(this.fyU);
        this.kRj.setDragToExitListener(this.fAM);
        this.kRj.setUserId(this.mUserId);
        this.kRj.setShowBottomContainer(this.kRF);
        this.kRj.setOnShareImageListener(this.kRp);
        this.kRj.setOnDownloadImageListener(this.kRp);
        this.kRj.setOnReplyClickListener(this.kRJ);
        TiebaStatic.log(new aq("c13340").dX("uid", this.mUserId).dX("post_id", this.anD).an("obj_source", dbZ()));
    }

    private int dbZ() {
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

    private void czA() {
        if (!this.kRB && this.kRc != null) {
            if (this.kRq == null) {
                this.kRq = new com.baidu.tieba.c.e(getPageContext(), this.kRc);
                this.kRq.fP(R.drawable.pic_sign_tip);
                this.kRq.fO(48);
                this.kRq.setUseDirectOffset(true);
                this.kRq.fQ(5000);
                this.kRq.yH(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.kRq.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.dca();
                    }
                });
            }
            this.kRq.aK(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dca() {
        if (this.kRq != null) {
            this.kRq.VL();
        }
    }

    public int cWh() {
        int count = x.getCount(this.kRm);
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
        this.kRo = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.kRC = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.kRm = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fPy = bundle.getString("fid");
            this.anD = bundle.getString("tid");
            this.eVY = bundle.getString(IntentConfig.NID);
            this.gDc = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.fzb = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.kRE = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.kRz = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.fzd = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.kRA = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.kQF = bundle.getString("source_rect_in_screen");
            this.kQH = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            isLogin = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            bduss = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            str = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.kRF = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.kQI = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.fAk = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fAk.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.kRD = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.kRB = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.kQJ = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.kRG = bundle.getString("from_forum_id");
            this.mSkinType = bundle.getInt("skin_type");
            stoken = string;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.kRC = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.kRm = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fPy = intent.getStringExtra("fid");
                this.anD = intent.getStringExtra("tid");
                this.eVY = intent.getStringExtra(IntentConfig.NID);
                this.gDc = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.fzb = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.kRE = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.kRz = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.fzd = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.kRA = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.kRF = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.kQI = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.kRD = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.kRB = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                isLogin = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                bduss = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.kQF = intent.getStringExtra("source_rect_in_screen");
                this.kQH = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.fAk = (Map) serializableExtra;
                }
                this.kQJ = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.kRG = intent.getStringExtra("from_forum_id");
                this.mSkinType = intent.getIntExtra("skin_type", 0);
                stoken = stringExtra;
            } else {
                str = tbs;
            }
        }
        com.baidu.tbadk.mutiprocess.f.lg(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(str);
        this.kRo.a(bundle, getIntent());
        this.mCount = x.getCount(this.kRm);
        if (this.kQF != null) {
            String str2 = (String) x.getItem(this.kRm, this.mIndex);
            if (!StringUtils.isNull(str2) && this.fAk != null && (imageUrlData = this.fAk.get(str2)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.kQF);
            }
        }
        this.kQG = this.kRC ? null : b.NL((String) x.getItem(this.kRm, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new aq("c13337").dX("obj_type", "2"));
        } else {
            TiebaStatic.log(new aq("c13337").dX("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.kRC);
        bundle.putStringArrayList("url", this.kRm);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fPy);
        bundle.putString("tid", this.anD);
        bundle.putString("fname", this.gDc);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.kRE);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.fzd);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.kRA);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.kRz);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.kRF);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.kQI);
        if (this.fAk instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fAk.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fAk instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fAk.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.kQF);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.kRD);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.kRB);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.kQH);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.kRG);
        bundle.putInt("skin_type", this.mSkinType);
        this.kRo.az(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kRj.setCurrentItem(this.mIndex, false);
        SvgManager.bwq().a(this.kiB, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EU(int i) {
        if (this.kRj != null) {
            this.kRj.sg(i);
            int i2 = (this.kRj.bDd() || dbX()) ? 8 : 0;
            x(this.kRc, i2);
            x(this.kRd, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcb() {
        if (dbX()) {
            this.kRv = this.mNavigationBar.getVisibility() == 0;
            this.kRu = true;
        } else if (this.kRu) {
            this.mNavigationBar.setVisibility(this.kRv ? 0 : 8);
            this.kRu = false;
        }
        dbT();
    }

    private void EV(int i) {
        if (this.kRn != null) {
            ArrayList<AlaInfoData> dbA = this.kRn.dbA();
            if (dbA != null && dbA.size() > 0) {
                tq(true);
                b(dbA.get(i % dbA.size()));
                return;
            }
            tq(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            a(this.kRe, alaInfoData.user_info.portrait);
            this.kRe.setAlaInfo(alaInfoData);
            this.kRe.setOnClickListener(this.kRO);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                NP(alaInfoData.tag);
            }
            TiebaStatic.log(new aq("c13710").dX("fid", this.fPy).dX("fname", this.gDc).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", this.anD).dX("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void tq(boolean z) {
        if (this.kRh != z) {
            if (this.kRf != null) {
                if (z) {
                    this.kRf.setVisibility(0);
                    if (!this.kRf.isAnimating()) {
                        this.kRf.setSpeed(0.8f);
                        this.kRf.setRepeatCount(-1);
                        this.kRf.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.kRf.playAnimation();
                            }
                        });
                    }
                } else {
                    this.kRf.setVisibility(8);
                    if (this.kRf.isAnimating()) {
                        this.kRf.cancelAnimation();
                    }
                }
            }
            if (this.kRe != null) {
                this.kRe.setVisibility(z ? 0 : 8);
            }
            this.kRh = z;
        }
    }

    private void EW(int i) {
        if (this.kRf != null) {
            if (i == 1) {
                this.kRf.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.kRf.setAnimation("live/card_live_bg_black.json");
            } else {
                this.kRf.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NP(@NonNull final String str) {
        if (this.kRf != null) {
            this.kRf.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.kRg != null) {
                        if (ImageViewerActivity.this.kRi == null || ImageViewerActivity.this.kRg == null || ImageViewerActivity.this.kRd == null || ImageViewerActivity.this.kRd.getVisibility() != 0) {
                            ImageViewerActivity.this.dcc();
                            return;
                        }
                        ImageViewerActivity.this.kRg.Jy(str);
                        ImageViewerActivity.this.kRi = null;
                        return;
                    }
                    ImageViewerActivity.this.kRg = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.kRf);
                    ImageViewerActivity.this.kRg.fP(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.kRg.fO(32);
                    ImageViewerActivity.this.kRg.setUseDirectOffset(true);
                    ImageViewerActivity.this.kRg.yG(1);
                    ImageViewerActivity.this.kRg.yH(0);
                    ImageViewerActivity.this.kRg.fQ(3000);
                    ImageViewerActivity.this.kRg.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.dcc();
                        }
                    });
                    if (ImageViewerActivity.this.kRd == null || ImageViewerActivity.this.kRd.getVisibility() == 0) {
                        ImageViewerActivity.this.kRg.Jy(str);
                        return;
                    }
                    ImageViewerActivity.this.kRi = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcc() {
        if (this.kRg != null) {
            this.kRg.VL();
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
                return com.baidu.tbadk.m.e.bHs().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fPy, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.anD, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Er(TbadkCoreApplication.getInst().getAdAdSense().fsN);
            }
        }
        return pageStayDurationItem;
    }

    public boolean dcd() {
        return this.kRC;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (at.isEmpty(this.anD)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.anD, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdvertAppInfo advertAppInfo, int i) {
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 5, 0);
        b2.Jm(i);
        com.baidu.tieba.recapp.report.e.dFV().a(b2);
    }
}
