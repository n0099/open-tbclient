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
    private String alS;
    private Map<String, ImageUrlData> eVI;
    private String fUs;
    private String fkA;
    private VoiceManager ioV;
    private View irv;
    private com.baidu.tieba.frs.profession.permission.c itr;
    private ImageView joo;
    private SortSwitchButton kfJ;
    private View kfK;
    private HeadImageView kfL;
    private TBLottieAnimationView kfM;
    private com.baidu.tieba.c.e kfN;
    private String kfP;
    private MultiImageView kfQ;
    private LinearLayout kfR;
    private com.baidu.tieba.image.a.c kfS;
    private ArrayList<String> kfT;
    private e kfU;
    private i kfV;
    private j kfW;
    private com.baidu.tieba.c.e kfX;
    private String kfn;
    private String kfo;
    private int kfr;
    private int kgb;
    private boolean kgc;
    private String kgl;
    private float kgq;
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
    private boolean kfO = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a kfY = null;
    private boolean kfZ = false;
    private boolean kga = false;
    private int ZP = 0;
    private boolean kgd = false;
    private boolean kge = true;
    private boolean eUA = true;
    private boolean kgf = true;
    private boolean mIsSeeHost = false;
    private boolean kgg = false;
    private boolean kgh = false;
    private boolean kgi = false;
    private boolean kfp = false;
    private boolean kgj = true;
    private boolean eUy = false;
    private boolean kgk = true;
    private boolean kfq = false;
    private CustomMessageListener kgm = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.cSe();
            }
        }
    };
    private final CustomMessageListener kgn = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.eXY)) {
                    be.bmY().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    be.bmY().b(ImageViewerActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.eXY});
                }
            }
        }
    };
    private DragImageView.d eWk = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.r(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.r(ImageViewerActivity.this.kfJ, 8);
            ImageViewerActivity.this.r(ImageViewerActivity.this.irv, 8);
            ImageViewerActivity.this.r(ImageViewerActivity.this.kfK, 8);
            if (ImageViewerActivity.this.kfQ != null) {
                ImageViewerActivity.this.kfQ.jt(false);
            }
            ImageViewerActivity.this.cSc();
            ImageViewerActivity.this.cSe();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new aq("c13341").aj("obj_param1", ImageViewerActivity.this.kfQ.getItemNum()).aj(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kfQ.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bzS() {
            ImageViewerActivity.this.r(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.irv.setVisibility(0);
            if (ImageViewerActivity.this.kfQ != null && !ImageViewerActivity.this.cRZ()) {
                boolean btB = ImageViewerActivity.this.kfQ.btB();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !btB) {
                    ImageViewerActivity.this.r(ImageViewerActivity.this.kfJ, 0);
                    ImageViewerActivity.this.r(ImageViewerActivity.this.kfK, 0);
                    ImageViewerActivity.this.MN(ImageViewerActivity.this.kfP);
                    if (ImageViewerActivity.this.kgk) {
                        ImageViewerActivity.this.kfQ.jt(true);
                    } else {
                        ImageViewerActivity.this.kfQ.jt(false);
                    }
                }
            }
        }
    };
    private View.OnClickListener kgo = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13857").dK("obj_type", "3").dK("post_id", ImageViewerActivity.this.alS).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", ImageViewerActivity.this.fkA));
            if (com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.itr == null) {
                    ImageViewerActivity.this.itr = new com.baidu.tieba.frs.profession.permission.c(ImageViewerActivity.this.getPageContext());
                    ImageViewerActivity.this.itr.a(new c.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.16.1
                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void ph(boolean z) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void C(boolean z, int i) {
                        }

                        @Override // com.baidu.tieba.frs.profession.permission.c.a
                        public void pi(boolean z) {
                            if (z && ImageViewerActivity.this.kfS != null && ImageViewerActivity.this.kfQ.getCurrentUrlDragImageView() != null) {
                                ImageViewerActivity.this.kfS.b(ImageViewerActivity.this.kfQ.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kfU);
                            }
                        }
                    });
                }
                ImageViewerActivity.this.itr.zw((ImageViewerActivity.this.kfQ == null || ImageViewerActivity.this.kfQ.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.kfQ.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? true : ImageViewerActivity.this.kfQ.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost ? 0 : 1);
                ImageViewerActivity.this.itr.D(ImageViewerActivity.this.fkA, com.baidu.adp.lib.f.b.toLong(ImageViewerActivity.this.alS, 0L));
            }
        }
    };
    private UrlDragImageView.b eUr = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void btT() {
            TiebaStatic.log(new aq("c10351").dK("tid", ImageViewerActivity.this.alS).dK("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a kgp = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean yQ(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.kgc = true;
                if (ImageViewerActivity.this.kfJ != null) {
                    ImageViewerActivity.this.kfJ.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.MJ((String) y.getItem(ImageViewerActivity.this.kfT, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                TiebaStatic.log(new aq("c13857").aj("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).dK("post_id", ImageViewerActivity.this.alS).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", ImageViewerActivity.this.fkA));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13341").aj("obj_param1", ImageViewerActivity.this.kfQ.getItemNum()).aj(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.kfQ.getCurrentMaxIndex()));
            TiebaStatic.log(new aq("c13377").dK("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private View.OnTouchListener eWw = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.kgq = motionEvent.getX();
                    return false;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.kgq = motionEvent.getX();
                    return false;
                default:
                    return false;
            }
        }
    };
    private View.OnLongClickListener kgr = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.kfW != null) {
                ImageViewerActivity.this.kfW.clI();
                ImageViewerActivity.this.kfW.show();
                ImageViewerActivity.this.kfW.cN(view);
            }
            TiebaStatic.log(new aq("c13269").dK("uid", ImageViewerActivity.this.mUserId).dK("fid", ImageViewerActivity.this.fkA).dK("tid", ImageViewerActivity.this.alS));
            return true;
        }
    };
    private BaseViewPager.a kgs = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.kfU.cRE();
            } else if (ImageViewerActivity.this.cRX() != 1) {
                ImageViewerActivity.this.kfU.cRF();
            }
        }
    };
    private ViewPager.OnPageChangeListener cfo = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.kfU != null && i > ImageViewerActivity.this.kfQ.getItemNum() - 5) {
                ImageViewerActivity.this.kfU.cRE();
            }
            ImageViewerActivity.this.kfV.e(ImageViewerActivity.this.kfT, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.cRY();
            ImageViewerActivity.this.cSd();
            ImageViewerActivity.this.Dh(i);
            if (ImageViewerActivity.this.kfV.cSg() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kfV.Dk(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.kfV.cSh() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.kfV.Dl(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.cRZ()) {
                ImageViewerActivity.this.kfY.cRy();
            }
            if (ImageViewerActivity.this.kfW != null) {
                ImageViewerActivity.this.kfW.cSk();
            }
            if (ImageViewerActivity.this.kfS != null && ImageViewerActivity.this.kfQ.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.kfS.a(ImageViewerActivity.this.kfQ.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kfU);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.ZP) {
                ImageViewerActivity.this.ZP = i;
            } else if (i < ImageViewerActivity.this.ZP) {
                ImageViewerActivity.this.ZP = i;
            }
            if (ImageViewerActivity.this.kfQ != null) {
                dragImageView = ImageViewerActivity.this.kfQ.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cRX() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.cSe();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.kfT != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.kfT.size()) {
                ImageViewerActivity.this.kfV.bx(i, (String) ImageViewerActivity.this.kfT.get(ImageViewerActivity.this.mIndex));
            }
        }
    };
    private View.OnClickListener kgt = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.edd).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.edm).append("?").append(com.baidu.tbadk.BdToken.f.edF).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.edG).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new aq("c13711").dK("fid", ImageViewerActivity.this.fkA).dK("fname", ImageViewerActivity.this.fUs).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", ImageViewerActivity.this.alS).dK("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eVI != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eVI.values()) {
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
    private CustomMessageListener eCX = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eVI != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eVI.values()) {
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
    public void r(View view, int i) {
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
        com.baidu.tbadk.mutiprocess.g.bxb().init(TbadkCoreApplication.getInst());
        this.kgb = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cCN();
        k(this.kfo, this.mIsSeeHost, false);
        registerListener(this.kgn);
        registerListener(this.kgm);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.eCX);
        this.ioV = getVoiceManager();
        this.ioV.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
        if (this.kfY != null) {
            this.kfY.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.kfU = new e(this.kfT, this.eVI, this.fkA, this.fUs, this.alS, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.kfr, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.kfU.setSourceImageRectInScreen(this.kfn);
        this.kfU.sf(this.kgj);
        this.kfU.sg(z);
        this.kfU.ML(this.kfo);
        this.kfU.se(this.kfp);
        this.kfU.setPostId(this.mPostId);
        this.kfU.si(this.kfq);
        this.kfU.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.kfQ != null) {
                    if (ImageViewerActivity.this.kgc) {
                        if (!z5) {
                            ImageViewerActivity.this.kfQ.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                        }
                    }
                    ImageViewerActivity.this.kgc = false;
                    if (ImageViewerActivity.this.kfJ != null) {
                        ImageViewerActivity.this.kfJ.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.kfQ.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.kfQ.getItemNum();
                        ImageViewerActivity.this.kfQ.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.kfQ.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.kfQ.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.kfY != null) {
                        ImageViewerActivity.this.kfY.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.kfQ.setUrlData(arrayList);
                    ImageViewerActivity.this.kfQ.setAssistUrls(ImageViewerActivity.this.eVI);
                    ImageViewerActivity.this.kfQ.setHasNext(z3);
                    ImageViewerActivity.this.kfQ.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.kfQ.getItemNum()) {
                        ImageViewerActivity.this.kfQ.qB(ImageViewerActivity.this.kfQ.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.kfQ.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.kfQ.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.kfQ.setUrlData(arrayList);
                        ImageViewerActivity.this.kfQ.setCurrentItem(ImageViewerActivity.this.kfQ.getCurrentItem() - 200, false);
                    }
                    if (ImageViewerActivity.this.cRX() != 1) {
                        ImageViewerActivity.this.setSwipeBackEnabled(false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.cRY();
                    if (ImageViewerActivity.this.kfS != null && ImageViewerActivity.this.kfQ.getCurrentUrlDragImageView() != null) {
                        ImageViewerActivity.this.kfS.a(ImageViewerActivity.this.kfQ.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.kfU);
                    }
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.kfQ.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.kfY.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.kfY.cRr()) {
                    ImageViewerActivity.this.kfQ.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.kfQ.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bw(int i, String str2) {
                ImageViewerActivity.this.kgc = false;
                if (ImageViewerActivity.this.kfJ != null) {
                    if (ImageViewerActivity.this.kfJ.getState() != (ImageViewerActivity.this.mIsSeeHost ? 1 : 0) && TextUtils.isEmpty(str2)) {
                        ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                    }
                    ImageViewerActivity.this.kfJ.ju(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.kfJ.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.kfT != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.kfT.size();
                    }
                    ImageViewerActivity.this.cRY();
                }
            }
        });
        this.kfU.sh(true);
        this.kfU.cRE();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
            TiebaStatic.log(new aq("c13377").dK("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kfQ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.kfQ.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.kgb = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        Dj(i);
        if (this.kfW != null) {
            this.kfW.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ioV != null) {
            this.ioV.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ioV != null) {
            this.ioV.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kfQ.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alS, 0L);
        if (uniqueId != null && j > 0) {
            r.s(uniqueId.getId(), j);
        }
        if (this.ioV != null) {
            this.ioV.onPause(getPageContext());
        }
        this.kfS.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kfQ.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.alS, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.ebV, uniqueId.getId(), j);
        }
        if (this.ioV != null) {
            this.ioV.onResume(getPageContext());
        }
        this.kfS.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.kfQ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.kgn);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bwL().releaseBlockBitmapPool();
        this.kfV.e(this.kfT, this.mIndex, this.mIndex);
        this.kfV.cSi();
        String str3 = "";
        if (this.kfY != null) {
            str3 = this.kfY.getAdId();
        }
        if (this.kfU != null) {
            str = this.kfU.bjP();
            str2 = this.kfU.bjQ();
        } else {
            str = null;
        }
        this.kfV.a(this.kfQ.getPageCount(), str3, this.fkA, this.alS, str, str2);
        if (this.kfW != null) {
            this.kfW.release();
        }
        this.kfQ.onDestroy();
        this.kfS.onDestroy();
        if (this.ioV != null) {
            this.ioV.onDestory(getPageContext());
        }
        com.baidu.tbadk.download.d.bvb().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.kgb);
        cSc();
        cSe();
        if (this.kfY != null) {
            this.kfY.onDestroy();
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

    private void cCN() {
        byD();
        this.kfW = new j(this);
        initViewPager();
        this.kfW.j(this.kfQ);
        cRY();
        cng();
        cRU();
        cRT();
        this.kfV.e(this.kfT, this.mIndex, this.mIndex);
    }

    private void cRT() {
        this.kfR = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        this.kfS = new com.baidu.tieba.image.a.c(getPageContext(), this.kfR);
        this.kfS.setFromForumId(this.kgl);
    }

    private void cRU() {
        if (com.baidu.tbadk.core.util.g.blX()) {
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
        this.kfS.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void byD() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cRV();
        bOS();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.MK((String) y.getItem(this.kfT, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cRV() {
        this.irv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.irv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.joo = (ImageView) this.irv.findViewById(R.id.widget_navi_back_button);
        SvgManager.bmU().a(this.joo, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.irv.setVisibility(0);
    }

    private void bOS() {
        if (!this.kgh && !this.kgg) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.kfK = addCustomView.findViewById(R.id.view_user_photo);
            this.kfL = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.kfM = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.kfL.setIsRound(true);
            this.kfL.setPlaceHolder(1);
            if (this.kgf) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.IZ(0);
                pVar.Sc(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.IZ(1);
                pVar2.Sc(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.kfJ = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.kfJ.setNeedDayNight(false);
                this.kfJ.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.kfJ.setVisibility(0);
                this.kfJ.setOnSwitchChangeListener(this.kgp);
                r(this.kfK, 0);
                return;
            }
            r(this.kfJ, 8);
            r(this.kfK, 8);
        }
    }

    public Map<String, ImageUrlData> cRW() {
        return this.eVI;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cRX() {
        ImageUrlData imageUrlData;
        String str = (String) y.getItem(this.kfT, this.mIndex);
        if (this.eVI == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eVI.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRY() {
        String str;
        if (this.kfT != null) {
            long cRX = cRX();
            String str2 = ("" + cRX) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.kgd && cRX() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new aq("c13316").dK("obj_source", this.mFrom));
                this.kgd = true;
            }
            if (cRZ()) {
                cSa();
            } else {
                MM(str);
            }
            long j = cRX - 1;
            Di(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRZ() {
        if (this.kge && this.kfY != null && this.kfY.cRr()) {
            return this.kfQ.getItemNum() != 1 && this.mIndex == this.kfQ.getItemNum() + (-1);
        }
        return false;
    }

    private void MM(String str) {
        this.mTitleView.setText(str);
        if (this.kgf && !this.kgg && this.kfJ != null) {
            this.kfJ.ju(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void cSa() {
        this.mTitleView.setText("");
        r(this.kfJ, 8);
        r(this.kfK, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.kfQ == null) {
            this.kfQ = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.kfQ.init();
        }
        this.kfQ.setIsFromCDN(this.eUy);
        this.kfQ.setIsCanDrag(this.eUA);
        this.kfQ.setPageMargin(com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.kfQ.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.kfQ.setOnPageChangeListener(this.cfo);
        this.kfQ.setUrlData(this.kfT);
        this.kfQ.setAssistUrls(this.eVI);
        this.kfQ.setOuterOnTouchListener(this.eWw);
        this.kfQ.setItemOnclickListener(this.mOnClickListener);
        this.kfQ.setItemOnLongClickListener(this.kgr);
        this.kfQ.setCurrentItem(cIy(), false);
        this.kfQ.setOnScrollOutListener(this.kgs);
        this.kfY = new a(this.eUy, this.kge, getPageContext(), this.fkA, this.alS);
        this.kfY.setDragToExitListener(this.eWk);
        this.kfQ.a(this.kfY);
        this.kfQ.setOriImgSelectedCallback(this.eUr);
        this.kfQ.setDragToExitListener(this.eWk);
        this.kfQ.setUserId(this.mUserId);
        this.kfQ.setShowBottomContainer(this.kgk);
        this.kfQ.setOnShareImageListener(this.kfW);
        this.kfQ.setOnDownloadImageListener(this.kfW);
        this.kfQ.setOnReplyClickListener(this.kgo);
        TiebaStatic.log(new aq("c13340").dK("uid", this.mUserId).dK("post_id", this.alS).aj("obj_source", cSb()));
    }

    private int cSb() {
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

    private void cng() {
        if (!this.kgg && this.kfJ != null) {
            if (this.kfX == null) {
                this.kfX = new com.baidu.tieba.c.e(getPageContext(), this.kfJ);
                this.kfX.ff(R.drawable.pic_sign_tip);
                this.kfX.fe(48);
                this.kfX.setUseDirectOffset(true);
                this.kfX.fg(5000);
                this.kfX.wK(-com.baidu.adp.lib.util.l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.kfX.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.cSc();
                    }
                });
            }
            this.kfX.aJ(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSc() {
        if (this.kfX != null) {
            this.kfX.Po();
        }
    }

    public int cIy() {
        int count = y.getCount(this.kfT);
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
        this.kfV = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.kgh = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.kfT = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.fkA = bundle.getString("fid");
            this.alS = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.fUs = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.eUy = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.kgj = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.kge = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.eUA = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.kgf = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.kfn = bundle.getString("source_rect_in_screen");
            this.kfp = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.kgk = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.kfq = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.eVI = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eVI.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.kgi = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.kgg = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.kfr = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.kgl = bundle.getString("from_forum_id");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.kgh = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.kfT = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.fkA = intent.getStringExtra("fid");
                this.alS = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.fUs = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.eUy = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.kgj = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.kge = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.eUA = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.kgf = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.kgk = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.kfq = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.kgi = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.kgg = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.kfn = intent.getStringExtra("source_rect_in_screen");
                this.kfp = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.eVI = (Map) serializableExtra;
                }
                this.kfr = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.kgl = intent.getStringExtra("from_forum_id");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.jU(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.kfV.b(bundle, getIntent());
        this.mCount = y.getCount(this.kfT);
        if (this.kfn != null) {
            String str = (String) y.getItem(this.kfT, this.mIndex);
            if (!StringUtils.isNull(str) && this.eVI != null && (imageUrlData = this.eVI.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.kfn);
            }
        }
        this.kfo = this.kgh ? null : d.MJ((String) y.getItem(this.kfT, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new aq("c13337").dK("obj_type", "2"));
        } else {
            TiebaStatic.log(new aq("c13337").dK("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.kgh);
        bundle.putStringArrayList("url", this.kfT);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.fkA);
        bundle.putString("tid", this.alS);
        bundle.putString("fname", this.fUs);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.kgj);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.eUA);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.kgf);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.kge);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.kgk);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.kfq);
        if (this.eVI instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eVI.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eVI instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eVI.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.kfn);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.kgi);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.kgg);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.kfp);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        bundle.putString("from_forum_id", this.kgl);
        this.kfV.ay(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kfQ.setCurrentItem(this.mIndex, false);
        SvgManager.bmU().a(this.joo, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(int i) {
        if (this.kfQ != null) {
            this.kfQ.qA(i);
            int i2 = (this.kfQ.btB() || cRZ()) ? 8 : 0;
            r(this.kfJ, i2);
            r(this.kfK, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSd() {
        if (cRZ()) {
            this.kga = this.mNavigationBar.getVisibility() == 0;
            this.kfZ = true;
        } else if (this.kfZ) {
            this.mNavigationBar.setVisibility(this.kga ? 0 : 8);
            this.kfZ = false;
        }
    }

    private void Di(int i) {
        if (this.kfU != null) {
            ArrayList<AlaInfoData> cRD = this.kfU.cRD();
            if (cRD != null && cRD.size() > 0) {
                sj(true);
                b(cRD.get(i % cRD.size()));
                return;
            }
            sj(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.kfL, alaInfoData.user_info.portrait);
            this.kfL.setAlaInfo(alaInfoData);
            this.kfL.setOnClickListener(this.kgt);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                MN(alaInfoData.tag);
            }
            TiebaStatic.log(new aq("c13710").dK("fid", this.fkA).dK("fname", this.fUs).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", this.alS).dK("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void sj(boolean z) {
        if (this.kfO != z) {
            if (this.kfM != null) {
                if (z) {
                    this.kfM.setVisibility(0);
                    if (!this.kfM.isAnimating()) {
                        this.kfM.setSpeed(0.8f);
                        this.kfM.setRepeatCount(-1);
                        this.kfM.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.kfM.playAnimation();
                            }
                        });
                    }
                } else {
                    this.kfM.setVisibility(8);
                    if (this.kfM.isAnimating()) {
                        this.kfM.cancelAnimation();
                    }
                }
            }
            if (this.kfL != null) {
                this.kfL.setVisibility(z ? 0 : 8);
            }
            this.kfO = z;
        }
    }

    private void Dj(int i) {
        if (this.kfM != null) {
            if (i == 1) {
                this.kfM.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.kfM.setAnimation("live/card_live_bg_black.json");
            } else {
                this.kfM.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MN(@NonNull final String str) {
        if (this.kfM != null) {
            this.kfM.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.kfN != null) {
                        if (ImageViewerActivity.this.kfP == null || ImageViewerActivity.this.kfN == null || ImageViewerActivity.this.kfK == null || ImageViewerActivity.this.kfK.getVisibility() != 0) {
                            ImageViewerActivity.this.cSe();
                            return;
                        }
                        ImageViewerActivity.this.kfN.It(str);
                        ImageViewerActivity.this.kfP = null;
                        return;
                    }
                    ImageViewerActivity.this.kfN = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.kfM);
                    ImageViewerActivity.this.kfN.ff(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.kfN.fe(32);
                    ImageViewerActivity.this.kfN.setUseDirectOffset(true);
                    ImageViewerActivity.this.kfN.wJ(1);
                    ImageViewerActivity.this.kfN.wK(0);
                    ImageViewerActivity.this.kfN.fg(3000);
                    ImageViewerActivity.this.kfN.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.cSe();
                        }
                    });
                    if (ImageViewerActivity.this.kfK == null || ImageViewerActivity.this.kfK.getVisibility() == 0) {
                        ImageViewerActivity.this.kfN.It(str);
                        return;
                    }
                    ImageViewerActivity.this.kfP = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSe() {
        if (this.kfN != null) {
            this.kfN.Po();
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
                return com.baidu.tbadk.m.e.bxO().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.fkA, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.alS, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DD(TbadkCoreApplication.getInst().getAdAdSense().eOl);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cSf() {
        return this.kgh;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (at.isEmpty(this.alS)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.alS, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ioV == null) {
            this.ioV = VoiceManager.instance();
        }
        return this.ioV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}
