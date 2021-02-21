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
    private String gBt;
    private ImageView ixO;
    private VoiceManager jgu;
    private View jiW;
    private com.baidu.tieba.frs.profession.permission.c jkQ;
    private SortSwitchButton kUO;
    private View kUP;
    private HeadImageView kUQ;
    private TBLottieAnimationView kUR;
    private com.baidu.tieba.c.e kUS;
    private String kUU;
    private MultiImageView kUV;
    private LinearLayout kUW;
    private com.baidu.tieba.image.a.c kUX;
    private ArrayList<String> kUY;
    private d kUZ;
    private String kUr;
    private String kUs;
    private int kUv;
    private i kVa;
    private j kVb;
    private com.baidu.tieba.c.e kVc;
    private c kVd;
    private int kVi;
    private boolean kVj;
    private String kVs;
    private float kVx;
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
    private boolean kUT = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a kVe = null;
    private boolean kVf = com.baidu.tbadk.a.d.biT();
    private boolean kVg = false;
    private boolean kVh = false;
    private int abv = 0;
    private boolean kVk = false;
    private boolean kVl = true;
    private boolean fwL = true;
    private boolean kVm = true;
    private boolean mIsSeeHost = false;
    private boolean kVn = false;
    private boolean kVo = false;
    private boolean kVp = false;
    private boolean kUt = false;
    private boolean kVq = true;
    private boolean fwJ = false;
    private boolean kVr = true;
    private boolean kUu = false;
    private CustomMessageListener kVt = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.daq();
            }
        }
    };
    private final CustomMessageListener kVu = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
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
            ImageViewerActivity.this.x(ImageViewerActivity.this.kUO, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.jiW, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.kUP, 8);
            if (ImageViewerActivity.this.kUV != null) {
                ImageViewerActivity.this.kUV.kB(false);
            }
            ImageViewerActivity.this.dao();
            ImageViewerActivity.this.daq();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new ar("c13341").ap("obj_param1", ImageViewerActivity.this.kUV.getItemNum()).ap(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kUV.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bGa() {
            ImageViewerActivity.this.x(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.jiW.setVisibility(0);
            if (ImageViewerActivity.this.kUV != null && !ImageViewerActivity.this.dal()) {
                boolean bzC = ImageViewerActivity.this.kUV.bzC();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bzC) {
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kUO, 0);
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kUP, 0);
                    ImageViewerActivity.this.Nw(ImageViewerActivity.this.kUU);
                    if (ImageViewerActivity.this.kVr) {
                        ImageViewerActivity.this.kUV.kB(true);
                    } else {
                        ImageViewerActivity.this.kUV.kB(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener kVv = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13857").dR("obj_type", "3").dR("post_id", ImageViewerActivity.this.amC).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fNd));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.jkQ == null) {
                    ImageViewerActivity.this.jkQ = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.jkQ.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qM(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void B(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qN(boolean z) {
                            if (z && ImageViewerActivity.this.kUX != null && ImageViewerActivity.this.kUV.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.kUX.b(ImageViewerActivity.this.kUV.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kUZ);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.jkQ.Ae((ImageViewerActivity.this.kUV == null || ImageViewerActivity.this.kUV.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kUV.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kUV.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.jkQ.G(ImageViewerActivity.this.fNd, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.amC, 0L));
            }
        }
    };
    private UrlDragImageView.b fwC = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bzU() {
            TiebaStatic.log(new ar("c10351").dR("tid", ImageViewerActivity.this.amC).dR("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a kVw = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zp(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.kVj = true;
                if (ImageViewerActivity.this.kUO != null) {
                    ImageViewerActivity.this.kUO.setEnabled(false);
                }
                ImageViewerActivity.this.k(b.Ns((String) y.getItem(ImageViewerActivity.this.kUY, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
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
            TiebaStatic.log(new ar("c13341").ap("obj_param1", ImageViewerActivity.this.kUV.getItemNum()).ap(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kUV.getCurrentMaxIndex()));
            TiebaStatic.log(new ar("c13377").dR("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener fyG = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.kVx = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.kVx = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener kVy = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (com.baidu.tbadk.a.d.bjs()) {
                if (ImageViewerActivity.this.kVb != null) {
                    ImageViewerActivity.this.kVb.daw();
                }
            } else if (ImageViewerActivity.this.kVb != null) {
                ImageViewerActivity.this.kVb.cvD();
                ImageViewerActivity.this.kVb.show();
                ImageViewerActivity.this.kVb.dp(view);
            }
            TiebaStatic.log(new ar("c13269").dR("uid", ImageViewerActivity.this.mUserId).dR("fid", ImageViewerActivity.this.fNd).dR("tid", ImageViewerActivity.this.amC));
            return true;
        }
    };
    private BaseViewPager.a kVz = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kUZ.cZQ();
            } else if (ImageViewerActivity.this.daj() != 1) {
                ImageViewerActivity.this.kUZ.cZR();
            }
        }
    };
    private ViewPager.OnPageChangeListener cBy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kUZ != null && i > ImageViewerActivity.this.kUV.getItemNum() - 5) {
                ImageViewerActivity.this.kUZ.cZQ();
            }
            if (ImageViewerActivity.this.kVf && ImageViewerActivity.this.kVd != null && ImageViewerActivity.this.kUZ != null && ImageViewerActivity.this.kUV != null) {
                ImageViewerActivity.this.kVd.V(ImageViewerActivity.this.kUZ.cZP(), ImageViewerActivity.this.mCount, i);
                ImageViewerActivity.this.kVd.DD(i);
            }
            ImageViewerActivity.this.kVa.e(ImageViewerActivity.this.kUY, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.dak();
            ImageViewerActivity.this.dap();
            ImageViewerActivity.this.DG(i);
            if (ImageViewerActivity.this.kVa.dat() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kVa.DJ(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kVa.dau() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kVa.DK(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.dal()) {
                if (ImageViewerActivity.this.kVf) {
                    if (ImageViewerActivity.this.kVd != null) {
                        ImageViewerActivity.this.kVd.onAdShow();
                    }
                } else if (ImageViewerActivity.this.kVe != null) {
                    ImageViewerActivity.this.kVe.onAdShow();
                }
            }
            if (ImageViewerActivity.this.kVb != null) {
                ImageViewerActivity.this.kVb.day();
            }
            if (ImageViewerActivity.this.kUX != null && ImageViewerActivity.this.kUV.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.kUX.a(ImageViewerActivity.this.kUV.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kUZ);
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
            if (ImageViewerActivity.this.kUV != null) {
                dragImageView = ImageViewerActivity.this.kUV.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.daj() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.daq();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.kUY != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.kUY.size()) {
                ImageViewerActivity.this.kVa.bH(i, (String) ImageViewerActivity.this.kUY.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener kVA = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
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
                TiebaStatic.log(new ar("c13711").dR("fid", ImageViewerActivity.this.fNd).dR("fname", ImageViewerActivity.this.gBt).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", ImageViewerActivity.this.amC).dR("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
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
        this.kVi = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cOI();
        k(this.kUs, this.mIsSeeHost, false);
        registerListener(this.kVu);
        registerListener(this.kVt);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.feG);
        this.jgu = getVoiceManager();
        this.jgu.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
            TbSingleton.getInstance().setHasDownloadEmotion(true);
        }
    }

    public void setAddSize(int i) {
        if (this.kUV != null) {
            this.kUV.setAddSize(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kUZ = new d(this.kUY, this.fxS, this.fNd, this.gBt, this.amC, this.eTz, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.kUv, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kUZ.setSourceImageRectInScreen(this.kUr);
        this.kUZ.tv(this.kVq);
        this.kUZ.tw(z);
        this.kUZ.Nu(this.kUs);
        this.kUZ.tu(this.kUt);
        this.kUZ.setPostId(this.mPostId);
        this.kUZ.ty(this.kUu);
        this.kUZ.a(new d.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.d.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kUV != null) {
                    if (ImageViewerActivity.this.kVj) {
                        if (!z5) {
                            ImageViewerActivity.this.kUV.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.kVj = false;
                    if (ImageViewerActivity.this.kUO != null) {
                        ImageViewerActivity.this.kUO.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kUV.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kUV.getItemNum();
                        ImageViewerActivity.this.kUV.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kUV.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kUV.setTempSize(0);
                    }
                    if (ImageViewerActivity.this.kVf) {
                        int cZP = ImageViewerActivity.this.kUZ.cZP();
                        if (ImageViewerActivity.this.kVd != null) {
                            ImageViewerActivity.this.kVd.cS(y.getCount(arrayList), i2);
                            ImageViewerActivity.this.kVd.V(cZP, i2, ImageViewerActivity.this.mIndex);
                        }
                    } else if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.kVe != null) {
                        AdvertAppInfo.eLs.set(true);
                        int blD = advertAppInfo.blD();
                        if (blD == 0) {
                            ImageViewerActivity.this.kVe.a(advertAppInfo, arrayList.size());
                        } else {
                            ImageViewerActivity.this.b(advertAppInfo, blD);
                        }
                    }
                    ImageViewerActivity.this.kUV.setUrlData(arrayList);
                    ImageViewerActivity.this.kUV.setAssistUrls(ImageViewerActivity.this.fxS);
                    ImageViewerActivity.this.kUV.setHasNext(z3);
                    ImageViewerActivity.this.kUV.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kUV.getItemNum()) {
                        ImageViewerActivity.this.kUV.qG(ImageViewerActivity.this.kUV.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kUV.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kUV.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kUV.setUrlData(arrayList);
                        ImageViewerActivity.this.kUV.setCurrentItem(ImageViewerActivity.this.kUV.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.daj() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    if (ImageViewerActivity.this.kVf) {
                        c(arrayList, i2);
                    } else {
                        a(arrayList, advertAppInfo);
                    }
                    ImageViewerActivity.this.dak();
                    if (ImageViewerActivity.this.kUX != null && ImageViewerActivity.this.kUV.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.kUX.a(ImageViewerActivity.this.kUV.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kUZ);
                    }
                }
            }

            private void c(ArrayList<String> arrayList, int i) {
                if (ImageViewerActivity.this.kVd != null && arrayList != null) {
                    if (ImageViewerActivity.this.kVd.cZM()) {
                        ImageViewerActivity.this.kVd.cS(y.getCount(arrayList), i);
                        ImageViewerActivity.this.setAddSize(1);
                        return;
                    }
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (ImageViewerActivity.this.kVe == null || advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                int blD = advertAppInfo.blD();
                if (blD != 0) {
                    ImageViewerActivity.this.b(advertAppInfo, blD);
                    return;
                }
                ImageViewerActivity.this.kVe.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.kVe.cZL()) {
                    ImageViewerActivity.this.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.d.b
            public void bG(int i, String str2) {
                ImageViewerActivity.this.kVj = false;
                if (ImageViewerActivity.this.kUO != null) {
                    if (ImageViewerActivity.this.kUO.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.kUO.iF(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.kUO.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.kUY != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.kUY.size();
                    }
                    ImageViewerActivity.this.dak();
                }
            }
        });
        this.kUZ.tx(true);
        this.kUZ.cZQ();
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
        this.kUV.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kUV.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.kVi = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        DI(i);
        if (this.kVb != null) {
            this.kVb.onChangeSkinType();
        }
        if (this.kUX != null) {
            this.kUX.onChangeSkinType(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jgu != null) {
            this.jgu.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kUV.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.amC, 0L);
        if (uniqueId != null && j > 0) {
            r.s(uniqueId.getId(), j);
        }
        if (this.jgu != null) {
            this.jgu.onPause(getPageContext());
        }
        this.kUX.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kUV.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.amC, 0L);
        if (uniqueId != null && j > 0) {
            r.b(com.baidu.tbadk.BdToken.b.eCn, uniqueId.getId(), j);
        }
        if (this.jgu != null) {
            this.jgu.onResume(getPageContext());
        }
        this.kUX.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kUV.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        MessageManager.getInstance().unRegisterListener(this.kVu);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bCP().releaseBlockBitmapPool();
        this.kVa.e(this.kUY, this.mIndex, this.mIndex);
        this.kVa.dav();
        String str3 = "";
        if (this.kVe != null) {
            str3 = this.kVe.getAdId();
        }
        if (this.kUZ != null) {
            str2 = this.kUZ.bpA();
            str = this.kUZ.bpB();
        } else {
            str = null;
            str2 = null;
        }
        this.kVa.a(this.kUV.getPageCount(), str3, this.fNd, this.amC, str2, str);
        if (this.kVb != null) {
            this.kVb.release();
        }
        this.kUV.onDestroy();
        this.kUX.onDestroy();
        if (this.jgu != null) {
            this.jgu.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bBd().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kVi);
        dao();
        daq();
        if (this.kVe != null) {
            this.kVe.onDestroy();
        }
        if (this.kVd != null) {
            this.kVd.onDestroy();
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

    private void cOI() {
        bEL();
        this.kVb = new j(this);
        initViewPager();
        this.kVb.k(this.kUV);
        dak();
        cxc();
        daf();
        dae();
        this.kVa.e(this.kUY, this.mIndex, this.mIndex);
    }

    private void dae() {
        this.kUW = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.kUX = new com.baidu.tieba.image.a.c(getPageContext(), this.kUW);
        this.kUX.setFromForumId(this.kVs);
        this.kUX.setSkinType(this.mSkinType);
        this.kUX.onChangeSkinType(this.mSkinType);
    }

    private void daf() {
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
        this.kUX.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(1284);
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        dag();
        bWz();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        com.baidu.tbadk.core.elementsMaven.c.br(this.mTitleView).oi(R.array.S_O_X001);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (b.Nt((String) y.getItem(this.kUY, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void dag() {
        this.jiW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jiW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageViewerActivity.this.kVf && ImageViewerActivity.this.dal()) {
                    ar.Bd("c14044").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).bsO();
                }
                ImageViewerActivity.this.finish();
            }
        });
        this.ixO = (ImageView) this.jiW.findViewById(R.id.widget_navi_back_button);
        SvgManager.bsR().a(this.ixO, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jiW.setVisibility(0);
    }

    private void dah() {
        if (this.kVf && dal()) {
            SvgManager.bsR().a(this.ixO, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.bsR().a(this.ixO, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bWz() {
        if (!this.kVo && !this.kVn) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.kUP = addCustomView.findViewById(R.id.view_user_photo);
            this.kUQ = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.kUR = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.kUQ.setIsRound(true);
            this.kUQ.setPlaceHolder(1);
            if (this.kVm) {
                ArrayList arrayList = new ArrayList(2);
                com.baidu.tieba.tbadkCore.data.r rVar = new com.baidu.tieba.tbadkCore.data.r();
                rVar.JF(0);
                rVar.Tr(getString(R.string.all));
                arrayList.add(rVar);
                com.baidu.tieba.tbadkCore.data.r rVar2 = new com.baidu.tieba.tbadkCore.data.r();
                rVar2.JF(1);
                rVar2.Tr(getString(R.string.host_name));
                arrayList.add(rVar2);
                this.kUO = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.kUO.setNeedDayNight(false);
                this.kUO.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.kUO.setVisibility(0);
                this.kUO.setOnSwitchChangeListener(this.kVw);
                x(this.kUP, 0);
                return;
            }
            x(this.kUO, 8);
            x(this.kUP, 8);
        }
    }

    public Map<String, ImageUrlData> dai() {
        return this.fxS;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long daj() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.kUY, this.mIndex);
        if (this.fxS == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fxS.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dak() {
        String str;
        if (this.kUY != null) {
            long daj = daj();
            String str2 = ("" + daj) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.kVk && daj() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new ar("c13316").dR("obj_source", this.mFrom));
                this.kVk = true;
            }
            if (dal()) {
                dam();
            } else {
                Nv(str);
            }
            long j = daj - 1;
            DH(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dal() {
        if (this.kVf) {
            if (this.kVl && this.kVd != null && this.kVd.cZL()) {
                return this.kUV.getItemNum() != 1 && this.mIndex == this.kUV.getItemNum() + (-1);
            }
            return false;
        } else if (this.kVl && this.kVe != null && this.kVe.cZL()) {
            return this.kUV.getItemNum() != 1 && this.mIndex == this.kUV.getItemNum() + (-1);
        } else {
            return false;
        }
    }

    private void Nv(String str) {
        this.mTitleView.setText(str);
        if (this.kVm && !this.kVn && this.kUO != null) {
            this.kUO.iF(this.mIsSeeHost ? 1 : 0);
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.mTitleView).oi(R.array.S_O_X001);
    }

    private void dam() {
        this.mTitleView.setText("");
        x(this.kUO, 8);
        x(this.kUP, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kUV == null) {
            this.kUV = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kUV.init();
        }
        this.kUV.setIsFromCDN(this.fwJ);
        this.kUV.setIsCanDrag(this.fwL);
        this.kUV.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kUV.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kUV.setOnPageChangeListener(this.cBy);
        this.kUV.setUrlData(this.kUY);
        this.kUV.setAssistUrls(this.fxS);
        this.kUV.setOuterOnTouchListener(this.fyG);
        this.kUV.setItemOnclickListener(this.mOnClickListener);
        this.kUV.setItemOnLongClickListener(this.kVy);
        this.kUV.setCurrentItem(cUw(), false);
        this.kUV.setOnScrollOutListener(this.kVz);
        if (this.kVf) {
            this.kVd = new c(this, this.kVl);
            this.kVd.setDragToExitListener(this.fyu);
            this.kUV.a(this.kVd);
        } else {
            this.kVe = new a(this.fwJ, this.kVl, getPageContext(), this.fNd, this.amC);
            this.kVe.setDragToExitListener(this.fyu);
            this.kUV.a(this.kVe);
        }
        this.kUV.setOriImgSelectedCallback(this.fwC);
        this.kUV.setDragToExitListener(this.fyu);
        this.kUV.setUserId(this.mUserId);
        this.kUV.setShowBottomContainer(this.kVr);
        this.kUV.setOnShareImageListener(this.kVb);
        this.kUV.setOnDownloadImageListener(this.kVb);
        this.kUV.setOnReplyClickListener(this.kVv);
        TiebaStatic.log(new ar("c13340").dR("uid", this.mUserId).dR("post_id", this.amC).ap("obj_source", dan()));
    }

    private int dan() {
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

    private void cxc() {
        if (!this.kVn && this.kUO != null) {
            if (this.kVc == null) {
                this.kVc = new com.baidu.tieba.c.e(getPageContext(), this.kUO);
                this.kVc.en(R.drawable.pic_sign_tip);
                this.kVc.em(48);
                this.kVc.setUseDirectOffset(true);
                this.kVc.eo(5000);
                this.kVc.xl(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.kVc.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.dao();
                    }
                });
            }
            this.kVc.aJ(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dao() {
        if (this.kVc != null) {
            this.kVc.Tz();
        }
    }

    public int cUw() {
        int count = y.getCount(this.kUY);
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
        this.kVa = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.kVo = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.kUY = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fNd = bundle.getString("fid");
            this.amC = bundle.getString("tid");
            this.eTz = bundle.getString(IntentConfig.NID);
            this.gBt = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.fwJ = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.kVq = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.kVl = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.fwL = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.kVm = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.kUr = bundle.getString("source_rect_in_screen");
            this.kUt = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            isLogin = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            bduss = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            str = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.kVr = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.kUu = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
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
            this.kVp = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.kVn = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.kUv = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.kVs = bundle.getString("from_forum_id");
            this.mSkinType = bundle.getInt("skin_type");
            stoken = string;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.kVo = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.kUY = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fNd = intent.getStringExtra("fid");
                this.amC = intent.getStringExtra("tid");
                this.eTz = intent.getStringExtra(IntentConfig.NID);
                this.gBt = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.fwJ = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.kVq = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.kVl = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.fwL = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.kVm = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.kVr = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.kUu = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.kVp = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.kVn = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                isLogin = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                bduss = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.kUr = intent.getStringExtra("source_rect_in_screen");
                this.kUt = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.fxS = (Map) serializableExtra;
                }
                this.kUv = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.kVs = intent.getStringExtra("from_forum_id");
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
        this.kVa.a(bundle, getIntent());
        this.mCount = y.getCount(this.kUY);
        if (this.kUr != null) {
            String str2 = (String) y.getItem(this.kUY, this.mIndex);
            if (!StringUtils.isNull(str2) && this.fxS != null && (imageUrlData = this.fxS.get(str2)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.kUr);
            }
        }
        this.kUs = this.kVo ? null : b.Ns((String) y.getItem(this.kUY, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new ar("c13337").dR("obj_type", "2"));
        } else {
            TiebaStatic.log(new ar("c13337").dR("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.kVo);
        bundle.putStringArrayList("url", this.kUY);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fNd);
        bundle.putString("tid", this.amC);
        bundle.putString("fname", this.gBt);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.kVq);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.fwL);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.kVm);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.kVl);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.kVr);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.kUu);
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
        bundle.putString("source_rect_in_screen", this.kUr);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.kVp);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.kVn);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.kUt);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.kVs);
        bundle.putInt("skin_type", this.mSkinType);
        this.kVa.az(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kUV.setCurrentItem(this.mIndex, false);
        SvgManager.bsR().a(this.ixO, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DG(int i) {
        if (this.kUV != null) {
            this.kUV.qF(i);
            int i2 = (this.kUV.bzC() || dal()) ? 8 : 0;
            x(this.kUO, i2);
            x(this.kUP, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dap() {
        if (dal()) {
            this.kVh = this.mNavigationBar.getVisibility() == 0;
            this.kVg = true;
        } else if (this.kVg) {
            this.mNavigationBar.setVisibility(this.kVh ? 0 : 8);
            this.kVg = false;
        }
        dah();
    }

    private void DH(int i) {
        if (this.kUZ != null) {
            ArrayList<AlaInfoData> cZO = this.kUZ.cZO();
            if (cZO != null && cZO.size() > 0) {
                tz(true);
                b(cZO.get(i % cZO.size()));
                return;
            }
            tz(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            a(this.kUQ, alaInfoData.user_info.portrait);
            this.kUQ.setAlaInfo(alaInfoData);
            this.kUQ.setOnClickListener(this.kVA);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                Nw(alaInfoData.tag);
            }
            TiebaStatic.log(new ar("c13710").dR("fid", this.fNd).dR("fname", this.gBt).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.amC).dR("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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
        if (this.kUT != z) {
            if (this.kUR != null) {
                if (z) {
                    this.kUR.setVisibility(0);
                    if (!this.kUR.isAnimating()) {
                        this.kUR.setSpeed(0.8f);
                        this.kUR.setRepeatCount(-1);
                        this.kUR.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.kUR.playAnimation();
                            }
                        });
                    }
                } else {
                    this.kUR.setVisibility(8);
                    if (this.kUR.isAnimating()) {
                        this.kUR.cancelAnimation();
                    }
                }
            }
            if (this.kUQ != null) {
                this.kUQ.setVisibility(z ? 0 : 8);
            }
            this.kUT = z;
        }
    }

    private void DI(int i) {
        if (this.kUR != null) {
            ap.a(this.kUR, R.raw.card_live_header_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nw(@NonNull final String str) {
        if (this.kUR != null) {
            this.kUR.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.kUS != null) {
                        if (ImageViewerActivity.this.kUU == null || ImageViewerActivity.this.kUS == null || ImageViewerActivity.this.kUP == null || ImageViewerActivity.this.kUP.getVisibility() != 0) {
                            ImageViewerActivity.this.daq();
                            return;
                        }
                        ImageViewerActivity.this.kUS.IY(str);
                        ImageViewerActivity.this.kUU = null;
                        return;
                    }
                    ImageViewerActivity.this.kUS = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.kUR);
                    ImageViewerActivity.this.kUS.en(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.kUS.em(32);
                    ImageViewerActivity.this.kUS.setUseDirectOffset(true);
                    ImageViewerActivity.this.kUS.xk(1);
                    ImageViewerActivity.this.kUS.xl(0);
                    ImageViewerActivity.this.kUS.eo(3000);
                    ImageViewerActivity.this.kUS.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.daq();
                        }
                    });
                    if (ImageViewerActivity.this.kUP == null || ImageViewerActivity.this.kUP.getVisibility() == 0) {
                        ImageViewerActivity.this.kUS.IY(str);
                        return;
                    }
                    ImageViewerActivity.this.kUU = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daq() {
        if (this.kUS != null) {
            this.kUS.Tz();
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
                pageStayDurationItem.Du(TbadkCoreApplication.getInst().getAdAdSense().fqv);
            }
        }
        return pageStayDurationItem;
    }

    public boolean dar() {
        return this.kVo;
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
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdvertAppInfo advertAppInfo, int i) {
        com.baidu.tieba.recapp.report.c b2 = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 5, 0);
        b2.HY(i);
        com.baidu.tieba.recapp.report.e.dEu().a(b2);
    }
}
