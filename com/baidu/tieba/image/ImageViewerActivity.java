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
/* loaded from: classes7.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.c {
    private String anU;
    private String eVa;
    private String fOD;
    private Map<String, ImageUrlData> fzr;
    private String gDc;
    private ImageView izx;
    private VoiceManager jie;
    private View jkF;
    private com.baidu.tieba.frs.profession.permission.c jmA;
    private SortSwitchButton kWQ;
    private View kWR;
    private HeadImageView kWS;
    private TBLottieAnimationView kWT;
    private com.baidu.tieba.c.e kWU;
    private String kWW;
    private MultiImageView kWX;
    private LinearLayout kWY;
    private com.baidu.tieba.image.a.c kWZ;
    private String kWt;
    private String kWu;
    private int kWx;
    private ArrayList<String> kXa;
    private d kXb;
    private i kXc;
    private j kXd;
    private com.baidu.tieba.c.e kXe;
    private c kXf;
    private int kXk;
    private boolean kXl;
    private String kXu;
    private float kXz;
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
    private boolean kWV = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a kXg = null;
    private boolean kXh = com.baidu.tbadk.a.d.biV();
    private boolean kXi = false;
    private boolean kXj = false;
    private int acR = 0;
    private boolean kXm = false;
    private boolean kXn = true;
    private boolean fyk = true;
    private boolean kXo = true;
    private boolean mIsSeeHost = false;
    private boolean kXp = false;
    private boolean kXq = false;
    private boolean kXr = false;
    private boolean kWv = false;
    private boolean kXs = true;
    private boolean fyi = false;
    private boolean kXt = true;
    private boolean kWw = false;
    private CustomMessageListener kXv = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.daz();
            }
        }
    };
    private final CustomMessageListener kXw = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null && !StringUtils.isNull(mVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(mVar);
                if (StringUtils.isNull(mVar.fBL)) {
                    bf.bsY().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink});
                } else {
                    bf.bsY().b(ImageViewerActivity.this.getPageContext(), new String[]{mVar.mLink, mVar.fBL});
                }
            }
        }
    };
    private DragImageView.d fzT = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.x(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.kWQ, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.jkF, 8);
            ImageViewerActivity.this.x(ImageViewerActivity.this.kWR, 8);
            if (ImageViewerActivity.this.kWX != null) {
                ImageViewerActivity.this.kWX.kB(false);
            }
            ImageViewerActivity.this.dax();
            ImageViewerActivity.this.daz();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new ar("c13341").aq("obj_param1", ImageViewerActivity.this.kWX.getItemNum()).aq(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kWX.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bGe() {
            ImageViewerActivity.this.x(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.jkF.setVisibility(0);
            if (ImageViewerActivity.this.kWX != null && !ImageViewerActivity.this.dau()) {
                boolean bzF = ImageViewerActivity.this.kWX.bzF();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bzF) {
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kWQ, 0);
                    ImageViewerActivity.this.x(ImageViewerActivity.this.kWR, 0);
                    ImageViewerActivity.this.NC(ImageViewerActivity.this.kWW);
                    if (ImageViewerActivity.this.kXt) {
                        ImageViewerActivity.this.kWX.kB(true);
                    } else {
                        ImageViewerActivity.this.kWX.kB(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener kXx = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13857").dR("obj_type", "3").dR("post_id", ImageViewerActivity.this.anU).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fOD));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.jmA == null) {
                    ImageViewerActivity.this.jmA = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.jmA.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qM(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void B(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void qN(boolean z) {
                            if (z && ImageViewerActivity.this.kWZ != null && ImageViewerActivity.this.kWX.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.kWZ.b(ImageViewerActivity.this.kWX.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kXb);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.jmA.Af((ImageViewerActivity.this.kWX == null || ImageViewerActivity.this.kWX.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kWX.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kWX.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.jmA.G(ImageViewerActivity.this.fOD, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.anU, 0L));
            }
        }
    };
    private UrlDragImageView.b fyb = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bzX() {
            TiebaStatic.log(new ar("c10351").dR("tid", ImageViewerActivity.this.anU).dR("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a kXy = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zq(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.kXl = true;
                if (ImageViewerActivity.this.kWQ != null) {
                    ImageViewerActivity.this.kWQ.setEnabled(false);
                }
                ImageViewerActivity.this.k(b.Ny((String) y.getItem(ImageViewerActivity.this.kXa, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new ar("c13857").aq("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dR("post_id", ImageViewerActivity.this.anU).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", ImageViewerActivity.this.fOD));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13341").aq("obj_param1", ImageViewerActivity.this.kWX.getItemNum()).aq(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kWX.getCurrentMaxIndex()));
            TiebaStatic.log(new ar("c13377").dR("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener fAf = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.kXz = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.kXz = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener kXA = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (com.baidu.tbadk.a.d.bju()) {
                if (ImageViewerActivity.this.kXd != null) {
                    ImageViewerActivity.this.kXd.daF();
                }
            } else if (ImageViewerActivity.this.kXd != null) {
                ImageViewerActivity.this.kXd.cvJ();
                ImageViewerActivity.this.kXd.show();
                ImageViewerActivity.this.kXd.dp(view);
            }
            TiebaStatic.log(new ar("c13269").dR("uid", ImageViewerActivity.this.mUserId).dR("fid", ImageViewerActivity.this.fOD).dR("tid", ImageViewerActivity.this.anU));
            return true;
        }
    };
    private BaseViewPager.a kXB = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kXb.cZZ();
            } else if (ImageViewerActivity.this.das() != 1) {
                ImageViewerActivity.this.kXb.daa();
            }
        }
    };
    private ViewPager.OnPageChangeListener cCY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kXb != null && i > ImageViewerActivity.this.kWX.getItemNum() - 5) {
                ImageViewerActivity.this.kXb.cZZ();
            }
            if (ImageViewerActivity.this.kXh && ImageViewerActivity.this.kXf != null && ImageViewerActivity.this.kXb != null && ImageViewerActivity.this.kWX != null) {
                ImageViewerActivity.this.kXf.V(ImageViewerActivity.this.kXb.cZY(), ImageViewerActivity.this.mCount, i);
                ImageViewerActivity.this.kXf.DG(i);
            }
            ImageViewerActivity.this.kXc.e(ImageViewerActivity.this.kXa, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.dat();
            ImageViewerActivity.this.day();
            ImageViewerActivity.this.DJ(i);
            if (ImageViewerActivity.this.kXc.daC() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kXc.DM(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kXc.daD() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kXc.DN(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.dau()) {
                if (ImageViewerActivity.this.kXh) {
                    if (ImageViewerActivity.this.kXf != null) {
                        ImageViewerActivity.this.kXf.onAdShow();
                    }
                } else if (ImageViewerActivity.this.kXg != null) {
                    ImageViewerActivity.this.kXg.onAdShow();
                }
            }
            if (ImageViewerActivity.this.kXd != null) {
                ImageViewerActivity.this.kXd.daH();
            }
            if (ImageViewerActivity.this.kWZ != null && ImageViewerActivity.this.kWX.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.kWZ.a(ImageViewerActivity.this.kWX.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kXb);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.acR) {
                ImageViewerActivity.this.acR = i;
            } else if (i < ImageViewerActivity.this.acR) {
                ImageViewerActivity.this.acR = i;
            }
            if (ImageViewerActivity.this.kWX != null) {
                dragImageView = ImageViewerActivity.this.kWX.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.das() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.daz();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.kXa != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.kXa.size()) {
                ImageViewerActivity.this.kXc.bH(i, (String) ImageViewerActivity.this.kXa.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener kXC = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.eEW).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.eFf).append("?").append(com.baidu.tbadk.BdToken.f.eFB).append("=").append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.eFC).append("=").append(alaInfo.thirdRoomId);
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
                TiebaStatic.log(new ar("c13711").dR("fid", ImageViewerActivity.this.fOD).dR("fname", ImageViewerActivity.this.gDc).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", ImageViewerActivity.this.anU).dR("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fzr != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fzr.values()) {
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
    private CustomMessageListener fgf = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.fzr != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.fzr.values()) {
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
        com.baidu.tbadk.mutiprocess.g.bDi().c(TbadkCoreApplication.getInst());
        this.kXk = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cOP();
        k(this.kWu, this.mIsSeeHost, false);
        registerListener(this.kXw);
        registerListener(this.kXv);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.fgf);
        this.jie = getVoiceManager();
        this.jie.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
        if (!TbSingleton.getInstance().hasDownloadEmotion() && com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.EMOTION_SYNC_DOWNLOAD));
            TbSingleton.getInstance().setHasDownloadEmotion(true);
        }
    }

    public void setAddSize(int i) {
        if (this.kWX != null) {
            this.kWX.setAddSize(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kXb = new d(this.kXa, this.fzr, this.fOD, this.gDc, this.anU, this.eVa, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.kWx, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kXb.setSourceImageRectInScreen(this.kWt);
        this.kXb.tv(this.kXs);
        this.kXb.tw(z);
        this.kXb.NA(this.kWu);
        this.kXb.tu(this.kWv);
        this.kXb.setPostId(this.mPostId);
        this.kXb.ty(this.kWw);
        this.kXb.a(new d.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.d.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kWX != null) {
                    if (ImageViewerActivity.this.kXl) {
                        if (!z5) {
                            ImageViewerActivity.this.kWX.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.kXl = false;
                    if (ImageViewerActivity.this.kWQ != null) {
                        ImageViewerActivity.this.kWQ.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kWX.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kWX.getItemNum();
                        ImageViewerActivity.this.kWX.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kWX.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kWX.setTempSize(0);
                    }
                    ImageViewerActivity.this.kWX.setUrlData(arrayList);
                    ImageViewerActivity.this.kWX.setAssistUrls(ImageViewerActivity.this.fzr);
                    ImageViewerActivity.this.kWX.setHasNext(z3);
                    if (ImageViewerActivity.this.kXh) {
                        int cZY = ImageViewerActivity.this.kXb.cZY();
                        if (ImageViewerActivity.this.kXf != null) {
                            ImageViewerActivity.this.kXf.cS(y.getCount(arrayList), i2);
                            ImageViewerActivity.this.kXf.V(cZY, i2, ImageViewerActivity.this.mIndex);
                        }
                    } else if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.kXg != null) {
                        AdvertAppInfo.eMT.set(true);
                        int blF = advertAppInfo.blF();
                        if (blF == 0) {
                            ImageViewerActivity.this.kXg.a(advertAppInfo, arrayList.size());
                        } else {
                            ImageViewerActivity.this.b(advertAppInfo, blF);
                        }
                    }
                    ImageViewerActivity.this.kWX.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kWX.getItemNum()) {
                        ImageViewerActivity.this.kWX.qH(ImageViewerActivity.this.kWX.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kWX.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kWX.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kWX.setUrlData(arrayList);
                        ImageViewerActivity.this.kWX.setCurrentItem(ImageViewerActivity.this.kWX.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.das() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    if (ImageViewerActivity.this.kXh) {
                        c(arrayList, i2);
                    } else {
                        a(arrayList, advertAppInfo);
                    }
                    ImageViewerActivity.this.dat();
                    if (ImageViewerActivity.this.kWZ != null && ImageViewerActivity.this.kWX.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.kWZ.a(ImageViewerActivity.this.kWX.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kXb);
                    }
                }
            }

            private void c(ArrayList<String> arrayList, int i) {
                if (ImageViewerActivity.this.kXf != null && arrayList != null) {
                    if (ImageViewerActivity.this.kXf.cZT()) {
                        ImageViewerActivity.this.kXf.cS(y.getCount(arrayList), i);
                        ImageViewerActivity.this.setAddSize(1);
                        return;
                    }
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (ImageViewerActivity.this.kXg == null || advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.setAddSize(0);
                    return;
                }
                int blF = advertAppInfo.blF();
                if (blF != 0) {
                    ImageViewerActivity.this.b(advertAppInfo, blF);
                    return;
                }
                ImageViewerActivity.this.kXg.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.kXg.cZS()) {
                    ImageViewerActivity.this.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.d.b
            public void bG(int i, String str2) {
                ImageViewerActivity.this.kXl = false;
                if (ImageViewerActivity.this.kWQ != null) {
                    if (ImageViewerActivity.this.kWQ.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.kWQ.iG(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.kWQ.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.kXa != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.kXa.size();
                    }
                    ImageViewerActivity.this.dat();
                }
            }
        });
        this.kXb.tx(true);
        this.kXb.cZZ();
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
        this.kWX.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kWX.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.kXk = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        DL(i);
        if (this.kXd != null) {
            this.kXd.onChangeSkinType();
        }
        if (this.kWZ != null) {
            this.kWZ.onChangeSkinType(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jie != null) {
            this.jie.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kWX.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.anU, 0L);
        if (uniqueId != null && j > 0) {
            r.s(uniqueId.getId(), j);
        }
        if (this.jie != null) {
            this.jie.onPause(getPageContext());
        }
        this.kWZ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kWX.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.anU, 0L);
        if (uniqueId != null && j > 0) {
            r.b(com.baidu.tbadk.BdToken.b.eDO, uniqueId.getId(), j);
        }
        if (this.jie != null) {
            this.jie.onResume(getPageContext());
        }
        this.kWZ.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kWX.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        MessageManager.getInstance().unRegisterListener(this.kXw);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bCS().releaseBlockBitmapPool();
        this.kXc.e(this.kXa, this.mIndex, this.mIndex);
        this.kXc.daE();
        String str3 = "";
        if (this.kXg != null) {
            str3 = this.kXg.getAdId();
        }
        if (this.kXb != null) {
            str2 = this.kXb.bpC();
            str = this.kXb.bpD();
        } else {
            str = null;
            str2 = null;
        }
        this.kXc.a(this.kWX.getPageCount(), str3, this.fOD, this.anU, str2, str);
        if (this.kXd != null) {
            this.kXd.release();
        }
        this.kWX.onDestroy();
        this.kWZ.onDestroy();
        if (this.jie != null) {
            this.jie.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bBg().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kXk);
        dax();
        daz();
        if (this.kXg != null) {
            this.kXg.onDestroy();
        }
        if (this.kXf != null) {
            this.kXf.onDestroy();
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

    private void cOP() {
        bEP();
        this.kXd = new j(this);
        initViewPager();
        this.kXd.k(this.kWX);
        dat();
        cxi();
        dao();
        dan();
        this.kXc.e(this.kXa, this.mIndex, this.mIndex);
    }

    private void dan() {
        this.kWY = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.kWZ = new com.baidu.tieba.image.a.c(getPageContext(), this.kWY);
        this.kWZ.setFromForumId(this.kXu);
        this.kWZ.setSkinType(this.mSkinType);
        this.kWZ.onChangeSkinType(this.mSkinType);
    }

    private void dao() {
        if (com.baidu.tbadk.core.util.g.bsa()) {
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
        this.kWZ.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(1284);
    }

    private void bEP() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        dap();
        bWF();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        com.baidu.tbadk.core.elementsMaven.c.br(this.mTitleView).oj(R.array.S_O_X001);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (b.Nz((String) y.getItem(this.kXa, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void dap() {
        this.jkF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jkF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageViewerActivity.this.kXh && ImageViewerActivity.this.dau() && ImageViewerActivity.this.kXf.cZU()) {
                    ar.Bk("c14044").aq("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.BIGIMAGE).bsR();
                }
                ImageViewerActivity.this.finish();
            }
        });
        this.izx = (ImageView) this.jkF.findViewById(R.id.widget_navi_back_button);
        SvgManager.bsU().a(this.izx, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jkF.setVisibility(0);
    }

    private void daq() {
        if (this.kXh && dau()) {
            SvgManager.bsU().a(this.izx, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.bsU().a(this.izx, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bWF() {
        if (!this.kXq && !this.kXp) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.kWR = addCustomView.findViewById(R.id.view_user_photo);
            this.kWS = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.kWT = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.kWS.setIsRound(true);
            this.kWS.setPlaceHolder(1);
            if (this.kXo) {
                ArrayList arrayList = new ArrayList(2);
                com.baidu.tieba.tbadkCore.data.r rVar = new com.baidu.tieba.tbadkCore.data.r();
                rVar.JK(0);
                rVar.Ty(getString(R.string.all));
                arrayList.add(rVar);
                com.baidu.tieba.tbadkCore.data.r rVar2 = new com.baidu.tieba.tbadkCore.data.r();
                rVar2.JK(1);
                rVar2.Ty(getString(R.string.host_name));
                arrayList.add(rVar2);
                this.kWQ = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.kWQ.setNeedDayNight(false);
                this.kWQ.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.kWQ.setVisibility(0);
                this.kWQ.setOnSwitchChangeListener(this.kXy);
                x(this.kWR, 0);
                return;
            }
            x(this.kWQ, 8);
            x(this.kWR, 8);
        }
    }

    public Map<String, ImageUrlData> dar() {
        return this.fzr;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long das() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.kXa, this.mIndex);
        if (this.fzr == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.fzr.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dat() {
        String str;
        if (this.kXa != null) {
            long das = das();
            String str2 = ("" + das) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.kXm && das() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new ar("c13316").dR("obj_source", this.mFrom));
                this.kXm = true;
            }
            if (dau()) {
                dav();
            } else {
                NB(str);
            }
            long j = das - 1;
            DK(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dau() {
        if (this.kXh) {
            if (this.kXn && this.kXf != null && this.kXf.cZV()) {
                return this.kWX.getItemNum() != 1 && this.mIndex == this.kWX.getItemNum() + (-1);
            }
            return false;
        } else if (this.kXn && this.kXg != null && this.kXg.cZS()) {
            return this.kWX.getItemNum() != 1 && this.mIndex == this.kWX.getItemNum() + (-1);
        } else {
            return false;
        }
    }

    private void NB(String str) {
        this.mTitleView.setText(str);
        if (this.kXo && !this.kXp && this.kWQ != null) {
            this.kWQ.iG(this.mIsSeeHost ? 1 : 0);
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.mTitleView).oj(R.array.S_O_X001);
    }

    private void dav() {
        this.mTitleView.setText("");
        x(this.kWQ, 8);
        x(this.kWR, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kWX == null) {
            this.kWX = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kWX.init();
        }
        this.kWX.setIsFromCDN(this.fyi);
        this.kWX.setIsCanDrag(this.fyk);
        this.kWX.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kWX.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kWX.setOnPageChangeListener(this.cCY);
        this.kWX.setUrlData(this.kXa);
        this.kWX.setAssistUrls(this.fzr);
        this.kWX.setOuterOnTouchListener(this.fAf);
        this.kWX.setItemOnclickListener(this.mOnClickListener);
        this.kWX.setItemOnLongClickListener(this.kXA);
        this.kWX.setCurrentItem(cUD(), false);
        this.kWX.setOnScrollOutListener(this.kXB);
        if (this.kXh) {
            this.kXf = new c(this, this.kXn);
            this.kXf.setDragToExitListener(this.fzT);
            this.kWX.a(this.kXf);
        } else {
            this.kXg = new a(this.fyi, this.kXn, getPageContext(), this.fOD, this.anU);
            this.kXg.setDragToExitListener(this.fzT);
            this.kWX.a(this.kXg);
        }
        this.kWX.setOriImgSelectedCallback(this.fyb);
        this.kWX.setDragToExitListener(this.fzT);
        this.kWX.setUserId(this.mUserId);
        this.kWX.setShowBottomContainer(this.kXt);
        this.kWX.setOnShareImageListener(this.kXd);
        this.kWX.setOnDownloadImageListener(this.kXd);
        this.kWX.setOnReplyClickListener(this.kXx);
        TiebaStatic.log(new ar("c13340").dR("uid", this.mUserId).dR("post_id", this.anU).aq("obj_source", daw()));
    }

    private int daw() {
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

    private void cxi() {
        if (!this.kXp && this.kWQ != null) {
            if (this.kXe == null) {
                this.kXe = new com.baidu.tieba.c.e(getPageContext(), this.kWQ);
                this.kXe.eo(R.drawable.pic_sign_tip);
                this.kXe.en(48);
                this.kXe.setUseDirectOffset(true);
                this.kXe.ep(5000);
                this.kXe.xm(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.kXe.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.dax();
                    }
                });
            }
            this.kXe.aJ(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dax() {
        if (this.kXe != null) {
            this.kXe.TC();
        }
    }

    public int cUD() {
        int count = y.getCount(this.kXa);
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
        this.kXc = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.kXq = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.kXa = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fOD = bundle.getString("fid");
            this.anU = bundle.getString("tid");
            this.eVa = bundle.getString(IntentConfig.NID);
            this.gDc = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.fyi = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.kXs = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.kXn = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.fyk = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.kXo = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.kWt = bundle.getString("source_rect_in_screen");
            this.kWv = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            isLogin = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            bduss = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            str = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.kXt = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.kWw = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.fzr = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.fzr.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.kXr = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.kXp = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.kWx = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.kXu = bundle.getString("from_forum_id");
            this.mSkinType = bundle.getInt("skin_type");
            stoken = string;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.kXq = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.kXa = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fOD = intent.getStringExtra("fid");
                this.anU = intent.getStringExtra("tid");
                this.eVa = intent.getStringExtra(IntentConfig.NID);
                this.gDc = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.fyi = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.kXs = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.kXn = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.fyk = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.kXo = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.kXt = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.kWw = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.kXr = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.kXp = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                isLogin = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                bduss = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.kWt = intent.getStringExtra("source_rect_in_screen");
                this.kWv = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.fzr = (Map) serializableExtra;
                }
                this.kWx = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.kXu = intent.getStringExtra("from_forum_id");
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
        this.kXc.a(bundle, getIntent());
        this.mCount = y.getCount(this.kXa);
        if (this.kWt != null) {
            String str2 = (String) y.getItem(this.kXa, this.mIndex);
            if (!StringUtils.isNull(str2) && this.fzr != null && (imageUrlData = this.fzr.get(str2)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.kWt);
            }
        }
        this.kWu = this.kXq ? null : b.Ny((String) y.getItem(this.kXa, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new ar("c13337").dR("obj_type", "2"));
        } else {
            TiebaStatic.log(new ar("c13337").dR("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.kXq);
        bundle.putStringArrayList("url", this.kXa);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fOD);
        bundle.putString("tid", this.anU);
        bundle.putString("fname", this.gDc);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.kXs);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.fyk);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.kXo);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.kXn);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.kXt);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.kWw);
        if (this.fzr instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.fzr.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.fzr instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.fzr.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.kWt);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.kXr);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.kXp);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.kWv);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.kXu);
        bundle.putInt("skin_type", this.mSkinType);
        this.kXc.az(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kWX.setCurrentItem(this.mIndex, false);
        SvgManager.bsU().a(this.izx, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DJ(int i) {
        if (this.kWX != null) {
            this.kWX.qG(i);
            int i2 = (this.kWX.bzF() || dau()) ? 8 : 0;
            x(this.kWQ, i2);
            x(this.kWR, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void day() {
        if (dau()) {
            this.kXj = this.mNavigationBar.getVisibility() == 0;
            this.kXi = true;
        } else if (this.kXi) {
            this.mNavigationBar.setVisibility(this.kXj ? 0 : 8);
            this.kXi = false;
        }
        daq();
    }

    private void DK(int i) {
        if (this.kXb != null) {
            ArrayList<AlaInfoData> cZX = this.kXb.cZX();
            if (cZX != null && cZX.size() > 0) {
                tz(true);
                b(cZX.get(i % cZX.size()));
                return;
            }
            tz(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            a(this.kWS, alaInfoData.user_info.portrait);
            this.kWS.setAlaInfo(alaInfoData);
            this.kWS.setOnClickListener(this.kXC);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                NC(alaInfoData.tag);
            }
            TiebaStatic.log(new ar("c13710").dR("fid", this.fOD).dR("fname", this.gDc).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.anU).dR("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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
        if (this.kWV != z) {
            if (this.kWT != null) {
                if (z) {
                    this.kWT.setVisibility(0);
                    if (!this.kWT.isAnimating()) {
                        this.kWT.setSpeed(0.8f);
                        this.kWT.setRepeatCount(-1);
                        this.kWT.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.kWT.playAnimation();
                            }
                        });
                    }
                } else {
                    this.kWT.setVisibility(8);
                    if (this.kWT.isAnimating()) {
                        this.kWT.cancelAnimation();
                    }
                }
            }
            if (this.kWS != null) {
                this.kWS.setVisibility(z ? 0 : 8);
            }
            this.kWV = z;
        }
    }

    private void DL(int i) {
        if (this.kWT != null) {
            ap.a(this.kWT, R.raw.card_live_header_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC(@NonNull final String str) {
        if (this.kWT != null) {
            this.kWT.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.kWU != null) {
                        if (ImageViewerActivity.this.kWW == null || ImageViewerActivity.this.kWU == null || ImageViewerActivity.this.kWR == null || ImageViewerActivity.this.kWR.getVisibility() != 0) {
                            ImageViewerActivity.this.daz();
                            return;
                        }
                        ImageViewerActivity.this.kWU.Jh(str);
                        ImageViewerActivity.this.kWW = null;
                        return;
                    }
                    ImageViewerActivity.this.kWU = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.kWT);
                    ImageViewerActivity.this.kWU.eo(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.kWU.en(32);
                    ImageViewerActivity.this.kWU.setUseDirectOffset(true);
                    ImageViewerActivity.this.kWU.xl(1);
                    ImageViewerActivity.this.kWU.xm(0);
                    ImageViewerActivity.this.kWU.ep(3000);
                    ImageViewerActivity.this.kWU.e(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.daz();
                        }
                    });
                    if (ImageViewerActivity.this.kWR == null || ImageViewerActivity.this.kWR.getVisibility() == 0) {
                        ImageViewerActivity.this.kWU.Jh(str);
                        return;
                    }
                    ImageViewerActivity.this.kWW = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daz() {
        if (this.kWU != null) {
            this.kWU.TC();
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
                return com.baidu.tbadk.m.e.bDW().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fOD, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.anU, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DB(TbadkCoreApplication.getInst().getAdAdSense().frW);
            }
        }
        return pageStayDurationItem;
    }

    public boolean daA() {
        return this.kXq;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (au.isEmpty(this.anU)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.anU, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jie == null) {
            this.jie = VoiceManager.instance();
        }
        return this.jie;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdvertAppInfo advertAppInfo, int i) {
        com.baidu.tieba.recapp.report.c b = com.baidu.tieba.recapp.report.h.b(advertAppInfo, 5, 0);
        b.Ic(i);
        com.baidu.tieba.recapp.report.e.dEC().a(b);
    }
}
