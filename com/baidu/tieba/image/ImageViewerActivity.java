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
import com.baidu.tbadk.core.util.ap;
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
import com.baidu.tieba.image.d;
import com.baidu.tieba.tbadkCore.data.AgreeData;
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
    private String amC;
    private String eTz;
    private String fNd;
    private Map<String, ImageUrlData> fxS;
    private String gBf;
    private ImageView ixA;
    private VoiceManager jgg;
    private View jiI;
    private com.baidu.tieba.frs.profession.permission.c jkC;
    private SortSwitchButton kUA;
    private View kUB;
    private HeadImageView kUC;
    private TBLottieAnimationView kUD;
    private com.baidu.tieba.c.e kUE;
    private String kUG;
    private MultiImageView kUH;
    private LinearLayout kUI;
    private com.baidu.tieba.image.a.c kUJ;
    private ArrayList<String> kUK;
    private d kUL;
    private i kUM;
    private j kUN;
    private com.baidu.tieba.c.e kUO;
    private c kUP;
    private int kUU;
    private boolean kUV;
    private String kUd;
    private String kUe;
    private int kUh;
    private String kVe;
    private float kVj;
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
    private boolean kUF = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a kUQ = null;
    private boolean kUR = com.baidu.tbadk.a.d.biT();
    private boolean kUS = false;
    private boolean kUT = false;
    private int abv = 0;
    private boolean kUW = false;
    private boolean kUX = true;
    private boolean fwL = true;
    private boolean kUY = true;
    private boolean mIsSeeHost = false;
    private boolean kUZ = false;
    private boolean kVa = false;
    private boolean kVb = false;
    private boolean kUf = false;
    private boolean kVc = true;
    private boolean fwJ = false;
    private boolean kVd = true;
    private boolean kUg = false;
    private CustomMessageListener kVf = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.daj();
            }
        }
    };
    private final CustomMessageListener kVg = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null && !StringUtils.isNull(mVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(mVar);
                if (StringUtils.isNull(mVar.fAm)) {
                    bf.bsV().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink});
                } else {
                    bf.bsV().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink, mVar.fAm});
                }
            }
        }
    };
    private DragImageView.d fyu = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.x(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.kUA, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.jiI, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.kUB, 8);
            if (ImageViewerActivity.this.kUH != null) {
                ImageViewerActivity.this.kUH.kB(false);
            }
            ImageViewerActivity.this.dah();
            ImageViewerActivity.this.daj();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new ar("c13341").ap("obj_param1", ImageViewerActivity.this.kUH.getItemNum()).ap(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kUH.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bGa() {
            ImageViewerActivity.this.x(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.jiI.setVisibility(0);
            if (ImageViewerActivity.this.kUH != null && !ImageViewerActivity.this.dae()) {
                boolean bzC = ImageViewerActivity.this.kUH.bzC();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bzC) {
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kUA, 0);
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kUB, 0);
                    ImageViewerActivity.this.Nv(ImageViewerActivity.this.kUG);
                    if (ImageViewerActivity.this.kVd) {
                        ImageViewerActivity.this.kUH.kB(true);
                    } else {
                        ImageViewerActivity.this.kUH.kB(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener kVh = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13857").dR("obj_type", "3").dR("post_id", ImageViewerActivity.this.amC).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fNd));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.jkC == null) {
                    ImageViewerActivity.this.jkC = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.jkC.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qM(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void B(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qN(boolean z) {
                            if (z && ImageViewerActivity.this.kUJ != null && ImageViewerActivity.this.kUH.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.kUJ.b(ImageViewerActivity.this.kUH.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kUL);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.jkC.Ae((ImageViewerActivity.this.kUH == null || ImageViewerActivity.this.kUH.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kUH.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kUH.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.jkC.G(ImageViewerActivity.this.fNd, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.amC, 0L));
            }
        }
    };
    private UrlDragImageView.b fwC = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bzU() {
            TiebaStatic.log(new ar("c10351").dR("tid", ImageViewerActivity.this.amC).dR("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a kVi = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zp(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.kUV = true;
                if (ImageViewerActivity.this.kUA != null) {
                    ImageViewerActivity.this.kUA.setEnabled(false);
                }
                ImageViewerActivity.this.k(b.Nr((String) y.getItem(ImageViewerActivity.this.kUK, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new ar("c13857").ap("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dR("post_id", ImageViewerActivity.this.amC).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fNd));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13341").ap("obj_param1", ImageViewerActivity.this.kUH.getItemNum()).ap(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kUH.getCurrentMaxIndex()));
            TiebaStatic.log(new ar("c13377").dR("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener fyG = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.kVj = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.kVj = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener kVk = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (com.baidu.tbadk.a.d.bjs()) {
                if (ImageViewerActivity.this.kUN != null) {
                    ImageViewerActivity.this.kUN.dap();
                }
            } else if (ImageViewerActivity.this.kUN != null) {
                ImageViewerActivity.this.kUN.cvw();
                ImageViewerActivity.this.kUN.show();
                ImageViewerActivity.this.kUN.dp(view);
            }
            TiebaStatic.log(new ar("c13269").dR("uid", ImageViewerActivity.this.mUserId).dR("fid", ImageViewerActivity.this.fNd).dR("tid", ImageViewerActivity.this.amC));
            return true;
        }
    };
    private BaseViewPager.a kVl = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kUL.cZJ();
            } else if (ImageViewerActivity.this.dac() != 1) {
                ImageViewerActivity.this.kUL.cZK();
            }
        }
    };
    private ViewPager.OnPageChangeListener cBy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kUL != null && i > ImageViewerActivity.this.kUH.getItemNum() - 5) {
                ImageViewerActivity.this.kUL.cZJ();
            }
            if (ImageViewerActivity.this.kUR && ImageViewerActivity.this.kUP != null && ImageViewerActivity.this.kUL != null && ImageViewerActivity.this.kUH != null) {
                ImageViewerActivity.this.kUP.V(ImageViewerActivity.this.kUL.cZI(), ImageViewerActivity.this.mCount, i);
                ImageViewerActivity.this.kUP.DD(i);
            }
            ImageViewerActivity.this.kUM.e(ImageViewerActivity.this.kUK, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.dad();
            ImageViewerActivity.this.dai();
            ImageViewerActivity.this.DG(i);
            if (ImageViewerActivity.this.kUM.dam() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kUM.DJ(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kUM.dan() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kUM.DK(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.dae()) {
                if (ImageViewerActivity.this.kUR) {
                    if (ImageViewerActivity.this.kUP != null) {
                        ImageViewerActivity.this.kUP.onAdShow();
                    }
                } else if (ImageViewerActivity.this.kUQ != null) {
                    ImageViewerActivity.this.kUQ.onAdShow();
                }
            }
            if (ImageViewerActivity.this.kUN != null) {
                ImageViewerActivity.this.kUN.dar();
            }
            if (ImageViewerActivity.this.kUJ != null && ImageViewerActivity.this.kUH.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.kUJ.a(ImageViewerActivity.this.kUH.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kUL);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.abv) {
                ImageViewerActivity.this.abv = i;
            } else if (i < ImageViewerActivity.this.abv) {
                ImageViewerActivity.this.abv = i;
            }
            if (ImageViewerActivity.this.kUH != null) {
                dragImageView = ImageViewerActivity.this.kUH.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.dac() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.daj();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.kUK != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.kUK.size()) {
                ImageViewerActivity.this.kUM.bH(i, (String) ImageViewerActivity.this.kUK.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener kVm = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.eDv).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.eDE).append("?").append(com.baidu.tbadk.BdToken.f.eEa).append("=").append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.eEb).append("=").append(alaInfo.thirdRoomId);
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
                TiebaStatic.log(new ar("c13711").dR("fid", ImageViewerActivity.this.fNd).dR("fname", ImageViewerActivity.this.gBf).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", ImageViewerActivity.this.amC).dR("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fxS != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fxS.values()) {
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
    private CustomMessageListener feG = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fxS != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fxS.values()) {
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
        com.baidu.tbadk.mutiprocess.g.bDf().c(TbadkCoreApplication.getInst());
        this.kUU = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cOB();
        k(this.kUe, this.mIsSeeHost, false);
        registerListener(this.kVg);
        registerListener(this.kVf);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.feG);
        this.jgg = getVoiceManager();
        this.jgg.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
            TbSingleton.getInstance().setHasDownloadEmotion(true);
        }
    }

    public void setAddSize(int i) {
        if (this.kUH != null) {
            this.kUH.setAddSize(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kUL = new d(this.kUK, this.fxS, this.fNd, this.gBf, this.amC, this.eTz, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.kUh, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kUL.setSourceImageRectInScreen(this.kUd);
        this.kUL.tv(this.kVc);
        this.kUL.tw(z);
        this.kUL.Nt(this.kUe);
        this.kUL.tu(this.kUf);
        this.kUL.setPostId(this.mPostId);
        this.kUL.ty(this.kUg);
        this.kUL.a(new d.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.d.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kUH != null) {
                    if (ImageViewerActivity.this.kUV) {
                        if (!z5) {
                            ImageViewerActivity.this.kUH.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.kUV = false;
                    if (ImageViewerActivity.this.kUA != null) {
                        ImageViewerActivity.this.kUA.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kUH.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kUH.getItemNum();
                        ImageViewerActivity.this.kUH.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kUH.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kUH.setTempSize(0);
                    }
                    if (ImageViewerActivity.this.kUR) {
                        int cZI = ImageViewerActivity.this.kUL.cZI();
                        if (ImageViewerActivity.this.kUP != null) {
                            ImageViewerActivity.this.kUP.cR(y.getCount(arrayList), i2);
                            ImageViewerActivity.this.kUP.V(cZI, i2, ImageViewerActivity.this.mIndex);
                        }
                    } else if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.kUQ != null) {
                        AdvertAppInfo.eLs.set(true);
                        int blD = advertAppInfo.blD();
                        if (blD == 0) {
                            ImageViewerActivity.this.kUQ.a(advertAppInfo, arrayList.size());
                        } else {
                            ImageViewerActivity.this.b(advertAppInfo, blD);
                        }
                    }
                    ImageViewerActivity.this.kUH.setUrlData(arrayList);
                    ImageViewerActivity.this.kUH.setAssistUrls(ImageViewerActivity.this.fxS);
                    ImageViewerActivity.this.kUH.setHasNext(z3);
                    ImageViewerActivity.this.kUH.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kUH.getItemNum()) {
                        ImageViewerActivity.this.kUH.qG(ImageViewerActivity.this.kUH.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kUH.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kUH.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kUH.setUrlData(arrayList);
                        ImageViewerActivity.this.kUH.setCurrentItem(ImageViewerActivity.this.kUH.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.dac() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    if (ImageViewerActivity.this.kUR) {
                        c(arrayList, i2);
                    } else {
                        a(arrayList, advertAppInfo);
                    }
                    ImageViewerActivity.this.dad();
                    if (ImageViewerActivity.this.kUJ != null && ImageViewerActivity.this.kUH.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.kUJ.a(ImageViewerActivity.this.kUH.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kUL);
                    }
                }
            }

            private void c(ArrayList<String> arrayList, int i) {
                if (ImageViewerActivity.this.kUP != null && arrayList != null) {
                    if (ImageViewerActivity.this.kUP.cZF()) {
                        ImageViewerActivity.this.kUP.cR(y.getCount(arrayList), i);
                        ImageViewerActivity.this.setAddSize(1);
                        return;
                    }
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (ImageViewerActivity.this.kUQ == null || advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                int blD = advertAppInfo.blD();
                if (blD != 0) {
                    ImageViewerActivity.this.b(advertAppInfo, blD);
                    return;
                }
                ImageViewerActivity.this.kUQ.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.kUQ.cZE()) {
                    ImageViewerActivity.this.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.d.b
            public void bG(int i, String str2) {
                ImageViewerActivity.this.kUV = false;
                if (ImageViewerActivity.this.kUA != null) {
                    if (ImageViewerActivity.this.kUA.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.kUA.iF(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.kUA.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.kUK != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.kUK.size();
                    }
                    ImageViewerActivity.this.dad();
                }
            }
        });
        this.kUL.tx(true);
        this.kUL.cZJ();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!l.isFastDoubleClick()) {
            TiebaStatic.log(new ar("c13377").dR("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kUH.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kUH.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.kUU = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        DI(i);
        if (this.kUN != null) {
            this.kUN.onChangeSkinType();
        }
        if (this.kUJ != null) {
            this.kUJ.onChangeSkinType(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jgg != null) {
            this.jgg.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jgg != null) {
            this.jgg.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kUH.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.amC, 0L);
        if (uniqueId != null && j > 0) {
            r.s(uniqueId.getId(), j);
        }
        if (this.jgg != null) {
            this.jgg.onPause(getPageContext());
        }
        this.kUJ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kUH.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.amC, 0L);
        if (uniqueId != null && j > 0) {
            r.b(com.baidu.tbadk.BdToken.b.eCn, uniqueId.getId(), j);
        }
        if (this.jgg != null) {
            this.jgg.onResume(getPageContext());
        }
        this.kUJ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kUH.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        MessageManager.getInstance().unRegisterListener(this.kVg);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bCP().releaseBlockBitmapPool();
        this.kUM.e(this.kUK, this.mIndex, this.mIndex);
        this.kUM.dao();
        String str3 = "";
        if (this.kUQ != null) {
            str3 = this.kUQ.getAdId();
        }
        if (this.kUL != null) {
            str2 = this.kUL.bpA();
            str = this.kUL.bpB();
        } else {
            str = null;
            str2 = null;
        }
        this.kUM.a(this.kUH.getPageCount(), str3, this.fNd, this.amC, str2, str);
        if (this.kUN != null) {
            this.kUN.release();
        }
        this.kUH.onDestroy();
        this.kUJ.onDestroy();
        if (this.jgg != null) {
            this.jgg.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bBd().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kUU);
        dah();
        daj();
        if (this.kUQ != null) {
            this.kUQ.onDestroy();
        }
        if (this.kUP != null) {
            this.kUP.onDestroy();
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

    private void cOB() {
        bEL();
        this.kUN = new j(this);
        initViewPager();
        this.kUN.k(this.kUH);
        dad();
        cwV();
        cZY();
        cZX();
        this.kUM.e(this.kUK, this.mIndex, this.mIndex);
    }

    private void cZX() {
        this.kUI = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.kUJ = new com.baidu.tieba.image.a.c(getPageContext(), this.kUI);
        this.kUJ.setFromForumId(this.kVe);
        this.kUJ.setSkinType(this.mSkinType);
        this.kUJ.onChangeSkinType(this.mSkinType);
    }

    private void cZY() {
        if (com.baidu.tbadk.core.util.g.brZ()) {
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
        this.kUJ.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(1284);
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cZZ();
        bWs();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        com.baidu.tbadk.core.elementsMaven.c.br(this.mTitleView).oi(R.array.S_O_X001);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (b.Ns((String) y.getItem(this.kUK, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cZZ() {
        this.jiI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jiI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageViewerActivity.this.kUR && ImageViewerActivity.this.dae()) {
                    ar.Bd("c14044").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).bsO();
                }
                ImageViewerActivity.this.finish();
            }
        });
        this.ixA = (ImageView) this.jiI.findViewById(R.id.widget_navi_back_button);
        SvgManager.bsR().a(this.ixA, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jiI.setVisibility(0);
    }

    private void daa() {
        if (this.kUR && dae()) {
            SvgManager.bsR().a(this.ixA, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.bsR().a(this.ixA, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bWs() {
        if (!this.kVa && !this.kUZ) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.kUB = addCustomView.findViewById(R.id.view_user_photo);
            this.kUC = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.kUD = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.kUC.setIsRound(true);
            this.kUC.setPlaceHolder(1);
            if (this.kUY) {
                ArrayList arrayList = new ArrayList(2);
                com.baidu.tieba.tbadkCore.data.r rVar = new com.baidu.tieba.tbadkCore.data.r();
                rVar.JF(0);
                rVar.Tf(getString(R.string.all));
                arrayList.add(rVar);
                com.baidu.tieba.tbadkCore.data.r rVar2 = new com.baidu.tieba.tbadkCore.data.r();
                rVar2.JF(1);
                rVar2.Tf(getString(R.string.host_name));
                arrayList.add(rVar2);
                this.kUA = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.kUA.setNeedDayNight(false);
                this.kUA.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.kUA.setVisibility(0);
                this.kUA.setOnSwitchChangeListener(this.kVi);
                x(this.kUB, 0);
                return;
            }
            x(this.kUA, 8);
            x(this.kUB, 8);
        }
    }

    public Map<String, ImageUrlData> dab() {
        return this.fxS;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long dac() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.kUK, this.mIndex);
        if (this.fxS == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fxS.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dad() {
        String str;
        if (this.kUK != null) {
            long dac = dac();
            String str2 = ("" + dac) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.kUW && dac() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new ar("c13316").dR("obj_source", this.mFrom));
                this.kUW = true;
            }
            if (dae()) {
                daf();
            } else {
                Nu(str);
            }
            long j = dac - 1;
            DH(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dae() {
        if (this.kUR) {
            if (this.kUX && this.kUP != null && this.kUP.cZE()) {
                return this.kUH.getItemNum() != 1 && this.mIndex == this.kUH.getItemNum() + (-1);
            }
            return false;
        } else if (this.kUX && this.kUQ != null && this.kUQ.cZE()) {
            return this.kUH.getItemNum() != 1 && this.mIndex == this.kUH.getItemNum() + (-1);
        } else {
            return false;
        }
    }

    private void Nu(String str) {
        this.mTitleView.setText(str);
        if (this.kUY && !this.kUZ && this.kUA != null) {
            this.kUA.iF(this.mIsSeeHost ? 1 : 0);
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.mTitleView).oi(R.array.S_O_X001);
    }

    private void daf() {
        this.mTitleView.setText("");
        x(this.kUA, 8);
        x(this.kUB, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kUH == null) {
            this.kUH = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kUH.init();
        }
        this.kUH.setIsFromCDN(this.fwJ);
        this.kUH.setIsCanDrag(this.fwL);
        this.kUH.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kUH.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kUH.setOnPageChangeListener(this.cBy);
        this.kUH.setUrlData(this.kUK);
        this.kUH.setAssistUrls(this.fxS);
        this.kUH.setOuterOnTouchListener(this.fyG);
        this.kUH.setItemOnclickListener(this.mOnClickListener);
        this.kUH.setItemOnLongClickListener(this.kVk);
        this.kUH.setCurrentItem(cUp(), false);
        this.kUH.setOnScrollOutListener(this.kVl);
        if (this.kUR) {
            this.kUP = new c(this, this.kUX);
            this.kUP.setDragToExitListener(this.fyu);
            this.kUH.a(this.kUP);
        } else {
            this.kUQ = new a(this.fwJ, this.kUX, getPageContext(), this.fNd, this.amC);
            this.kUQ.setDragToExitListener(this.fyu);
            this.kUH.a(this.kUQ);
        }
        this.kUH.setOriImgSelectedCallback(this.fwC);
        this.kUH.setDragToExitListener(this.fyu);
        this.kUH.setUserId(this.mUserId);
        this.kUH.setShowBottomContainer(this.kVd);
        this.kUH.setOnShareImageListener(this.kUN);
        this.kUH.setOnDownloadImageListener(this.kUN);
        this.kUH.setOnReplyClickListener(this.kVh);
        TiebaStatic.log(new ar("c13340").dR("uid", this.mUserId).dR("post_id", this.amC).ap("obj_source", dag()));
    }

    private int dag() {
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

    private void cwV() {
        if (!this.kUZ && this.kUA != null) {
            if (this.kUO == null) {
                this.kUO = new com.baidu.tieba.c.e(getPageContext(), this.kUA);
                this.kUO.en(R.drawable.pic_sign_tip);
                this.kUO.em(48);
                this.kUO.setUseDirectOffset(true);
                this.kUO.eo(5000);
                this.kUO.xl(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.kUO.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.dah();
                    }
                });
            }
            this.kUO.aJ(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dah() {
        if (this.kUO != null) {
            this.kUO.Tz();
        }
    }

    public int cUp() {
        int count = y.getCount(this.kUK);
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
        this.kUM = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.kVa = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.kUK = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fNd = bundle.getString("fid");
            this.amC = bundle.getString("tid");
            this.eTz = bundle.getString(IntentConfig.NID);
            this.gBf = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.fwJ = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.kVc = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.kUX = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.fwL = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.kUY = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.kUd = bundle.getString("source_rect_in_screen");
            this.kUf = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            isLogin = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            bduss = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            str = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.kVd = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.kUg = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.fxS = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fxS.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.kVb = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.kUZ = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.kUh = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.kVe = bundle.getString("from_forum_id");
            this.mSkinType = bundle.getInt("skin_type");
            stoken = string;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.kVa = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.kUK = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fNd = intent.getStringExtra("fid");
                this.amC = intent.getStringExtra("tid");
                this.eTz = intent.getStringExtra(IntentConfig.NID);
                this.gBf = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.fwJ = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.kVc = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.kUX = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.fwL = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.kUY = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.kVd = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.kUg = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.kVb = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.kUZ = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                isLogin = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                bduss = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.kUd = intent.getStringExtra("source_rect_in_screen");
                this.kUf = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.fxS = (Map) serializableExtra;
                }
                this.kUh = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.kVe = intent.getStringExtra("from_forum_id");
                this.mSkinType = intent.getIntExtra("skin_type", 0);
                stoken = stringExtra;
            } else {
                str = tbs;
            }
        }
        com.baidu.tbadk.mutiprocess.f.lf(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(str);
        this.kUM.a(bundle, getIntent());
        this.mCount = y.getCount(this.kUK);
        if (this.kUd != null) {
            String str2 = (String) y.getItem(this.kUK, this.mIndex);
            if (!StringUtils.isNull(str2) && this.fxS != null && (imageUrlData = this.fxS.get(str2)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.kUd);
            }
        }
        this.kUe = this.kVa ? null : b.Nr((String) y.getItem(this.kUK, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new ar("c13337").dR("obj_type", "2"));
        } else {
            TiebaStatic.log(new ar("c13337").dR("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.kVa);
        bundle.putStringArrayList("url", this.kUK);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fNd);
        bundle.putString("tid", this.amC);
        bundle.putString("fname", this.gBf);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.kVc);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.fwL);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.kUY);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.kUX);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.kVd);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.kUg);
        if (this.fxS instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fxS.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fxS instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fxS.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.kUd);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.kVb);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.kUZ);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.kUf);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.kVe);
        bundle.putInt("skin_type", this.mSkinType);
        this.kUM.az(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kUH.setCurrentItem(this.mIndex, false);
        SvgManager.bsR().a(this.ixA, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DG(int i) {
        if (this.kUH != null) {
            this.kUH.qF(i);
            int i2 = (this.kUH.bzC() || dae()) ? 8 : 0;
            x(this.kUA, i2);
            x(this.kUB, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dai() {
        if (dae()) {
            this.kUT = this.mNavigationBar.getVisibility() == 0;
            this.kUS = true;
        } else if (this.kUS) {
            this.mNavigationBar.setVisibility(this.kUT ? 0 : 8);
            this.kUS = false;
        }
        daa();
    }

    private void DH(int i) {
        if (this.kUL != null) {
            ArrayList<AlaInfoData> cZH = this.kUL.cZH();
            if (cZH != null && cZH.size() > 0) {
                tz(true);
                b(cZH.get(i % cZH.size()));
                return;
            }
            tz(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            a(this.kUC, alaInfoData.user_info.portrait);
            this.kUC.setAlaInfo(alaInfoData);
            this.kUC.setOnClickListener(this.kVm);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                Nv(alaInfoData.tag);
            }
            TiebaStatic.log(new ar("c13710").dR("fid", this.fNd).dR("fname", this.gBf).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.amC).dR("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void tz(boolean z) {
        if (this.kUF != z) {
            if (this.kUD != null) {
                if (z) {
                    this.kUD.setVisibility(0);
                    if (!this.kUD.isAnimating()) {
                        this.kUD.setSpeed(0.8f);
                        this.kUD.setRepeatCount(-1);
                        this.kUD.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.kUD.playAnimation();
                            }
                        });
                    }
                } else {
                    this.kUD.setVisibility(8);
                    if (this.kUD.isAnimating()) {
                        this.kUD.cancelAnimation();
                    }
                }
            }
            if (this.kUC != null) {
                this.kUC.setVisibility(z ? 0 : 8);
            }
            this.kUF = z;
        }
    }

    private void DI(int i) {
        if (this.kUD != null) {
            ap.a(this.kUD, R.raw.card_live_header_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nv(@NonNull final String str) {
        if (this.kUD != null) {
            this.kUD.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.kUE != null) {
                        if (ImageViewerActivity.this.kUG == null || ImageViewerActivity.this.kUE == null || ImageViewerActivity.this.kUB == null || ImageViewerActivity.this.kUB.getVisibility() != 0) {
                            ImageViewerActivity.this.daj();
                            return;
                        }
                        ImageViewerActivity.this.kUE.IX(str);
                        ImageViewerActivity.this.kUG = null;
                        return;
                    }
                    ImageViewerActivity.this.kUE = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.kUD);
                    ImageViewerActivity.this.kUE.en(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.kUE.em(32);
                    ImageViewerActivity.this.kUE.setUseDirectOffset(true);
                    ImageViewerActivity.this.kUE.xk(1);
                    ImageViewerActivity.this.kUE.xl(0);
                    ImageViewerActivity.this.kUE.eo(3000);
                    ImageViewerActivity.this.kUE.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.daj();
                        }
                    });
                    if (ImageViewerActivity.this.kUB == null || ImageViewerActivity.this.kUB.getVisibility() == 0) {
                        ImageViewerActivity.this.kUE.IX(str);
                        return;
                    }
                    ImageViewerActivity.this.kUG = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daj() {
        if (this.kUE != null) {
            this.kUE.Tz();
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
                return com.baidu.tbadk.m.e.bDS().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fNd, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.amC, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Dw(TbadkCoreApplication.getInst().getAdAdSense().fqv);
            }
        }
        return pageStayDurationItem;
    }

    public boolean dak() {
        return this.kVa;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (au.isEmpty(this.amC)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.amC, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgg == null) {
            this.jgg = VoiceManager.instance();
        }
        return this.jgg;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdvertAppInfo advertAppInfo, int i) {
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 5, 0);
        b2.HY(i);
        com.baidu.tieba.recapp.report.e.dEm().a(b2);
    }
}
