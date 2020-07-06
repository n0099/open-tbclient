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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.image.e;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.p;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.webkit.internal.ETAG;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpHost;
/* loaded from: classes8.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> {
    private String ajO;
    private String eEs;
    private Map<String, ImageUrlData> eqy;
    private String foo;
    private ImageView gqS;
    private View hCa;
    private ArrayList<String> jkA;
    private e jkB;
    private i jkC;
    private j jkD;
    private boolean jkE;
    private float jkF;
    private com.baidu.tieba.c.e jkG;
    private int jkK;
    private boolean jkL;
    private float jkY;
    private String jka;
    private String jkb;
    private int jke;
    private SortSwitchButton jks;
    private View jkt;
    private HeadImageView jku;
    private TBLottieAnimationView jkv;
    private com.baidu.tieba.c.e jkw;
    private String jky;
    private MultiImageView jkz;
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
    private boolean jkx = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a jkH = null;
    private boolean jkI = false;
    private boolean jkJ = false;
    private int YJ = 0;
    private boolean isRight = false;
    private boolean jkM = false;
    private boolean jkN = false;
    private boolean jkO = true;
    private boolean epu = true;
    private boolean jkP = true;
    private boolean mIsSeeHost = false;
    private boolean jkQ = false;
    private boolean jkR = false;
    private boolean jkS = false;
    private boolean jkc = false;
    private boolean jkT = true;
    private boolean eps = false;
    private boolean jkU = true;
    private boolean jkd = false;
    private CustomMessageListener jkV = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.cwb();
            }
        }
    };
    private final CustomMessageListener jkW = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.esJ)) {
                    bc.aWU().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    bc.aWU().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.esJ});
                }
            }
        }
    };
    private DragImageView.d eqZ = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.jks, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.hCa, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.jkt, 8);
            if (ImageViewerActivity.this.jkz != null) {
                ImageViewerActivity.this.jkz.hU(false);
            }
            ImageViewerActivity.this.cvZ();
            ImageViewerActivity.this.cwb();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new ao("c13341").ag("obj_param1", ImageViewerActivity.this.jkz.getItemNum()).ag(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jkz.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bjr() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.hCa.setVisibility(0);
            if (ImageViewerActivity.this.jkz != null) {
                boolean bdB = ImageViewerActivity.this.jkz.bdB();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bdB) {
                    ImageViewerActivity.this.o(ImageViewerActivity.this.jks, 0);
                    ImageViewerActivity.this.o(ImageViewerActivity.this.jkt, 0);
                    ImageViewerActivity.this.HO(ImageViewerActivity.this.jky);
                    if (ImageViewerActivity.this.jkU) {
                        ImageViewerActivity.this.jkz.hU(true);
                    } else {
                        ImageViewerActivity.this.jkz.hU(false);
                    }
                }
            }
        }
    };
    private UrlDragImageView.b epl = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bdT() {
            TiebaStatic.log(new ao("c10351").dk("tid", ImageViewerActivity.this.ajO).dk("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a jkX = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean va(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.jkL = true;
                if (ImageViewerActivity.this.jks != null) {
                    ImageViewerActivity.this.jks.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.HK((String) w.getItem(ImageViewerActivity.this.jkA, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ao("c13341").ag("obj_param1", ImageViewerActivity.this.jkz.getItemNum()).ag(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.jkz.getCurrentMaxIndex()));
            TiebaStatic.log(new ao("c13377").dk("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean jkZ = true;
    private View.OnTouchListener erl = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.jkY = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.jkZ = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.jkY = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.jkZ = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener jla = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.jkD != null) {
                ImageViewerActivity.this.jkD.bRC();
                ImageViewerActivity.this.jkD.show();
                ImageViewerActivity.this.jkD.cq(view);
            }
            TiebaStatic.log(new ao("c13269").dk("uid", ImageViewerActivity.this.mUserId).dk("fid", ImageViewerActivity.this.eEs).dk("tid", ImageViewerActivity.this.ajO));
            return true;
        }
    };
    private BaseViewPager.a jlb = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.jkB.cvD();
            } else if (ImageViewerActivity.this.cvU() != 1) {
                ImageViewerActivity.this.jkB.cvE();
            }
        }
    };
    private ViewPager.OnPageChangeListener bLe = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.jkB != null && i > ImageViewerActivity.this.jkz.getItemNum() - 5) {
                ImageViewerActivity.this.jkB.cvD();
            }
            ImageViewerActivity.this.jkC.e(ImageViewerActivity.this.jkA, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.cvV();
            ImageViewerActivity.this.cwa();
            ImageViewerActivity.this.zi(i);
            if (ImageViewerActivity.this.jkC.cwd() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jkC.zl(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.jkC.cwe() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.jkC.zm(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.cvW()) {
                ImageViewerActivity.this.jkH.cvr();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.jkz.getItemNum() - 1) {
                ImageViewerActivity.this.jkN = false;
            }
            if (ImageViewerActivity.this.jkD != null) {
                ImageViewerActivity.this.jkD.cwh();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.YJ) {
                ImageViewerActivity.this.YJ = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.YJ) {
                ImageViewerActivity.this.YJ = i;
                ImageViewerActivity.this.isRight = false;
            }
            if (ImageViewerActivity.this.jkz != null) {
                dragImageView = ImageViewerActivity.this.jkz.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cvU() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.cwb();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.jkA != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.jkA.size()) {
                ImageViewerActivity.this.jkC.bk(i, (String) ImageViewerActivity.this.jkA.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.jkz.getItemNum() - 1) {
                if (!ImageViewerActivity.this.jkZ || !ImageViewerActivity.this.jkE || (!ImageViewerActivity.this.jkN && !ImageViewerActivity.this.cvW() && (ImageViewerActivity.this.jkz.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.jkN = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private View.OnClickListener jlc = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.dzP).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.dzY).append("?").append(com.baidu.tbadk.BdToken.f.dAq).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.dAr).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new ao("c13711").dk("fid", ImageViewerActivity.this.eEs).dk("fname", ImageViewerActivity.this.foo).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", ImageViewerActivity.this.ajO).dk("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener dYC = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eqy != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eqy.values()) {
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
    private CustomMessageListener dYD = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.eqy != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.eqy.values()) {
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
    public void o(View view, int i) {
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
        com.baidu.tbadk.mutiprocess.g.bgP().init(TbadkCoreApplication.getInst());
        this.jkK = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        chO();
        k(this.jkb, this.mIsSeeHost, false);
        registerListener(this.jkW);
        registerListener(this.jkV);
        registerListener(this.dYC);
        registerListener(this.dYD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.jkB = new e(this.jkA, this.eqy, this.eEs, this.foo, this.ajO, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.jke, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.jkB.setSourceImageRectInScreen(this.jka);
        this.jkB.qc(this.jkT);
        this.jkB.qd(z);
        this.jkB.HM(this.jkb);
        this.jkB.qb(this.jkc);
        this.jkB.setPostId(this.mPostId);
        this.jkB.qf(this.jkd);
        this.jkB.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.jkz != null) {
                    if (ImageViewerActivity.this.jkL) {
                        if (!z5) {
                            ImageViewerActivity.this.jkz.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.jkL = false;
                    if (ImageViewerActivity.this.jks != null) {
                        ImageViewerActivity.this.jks.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.jkz.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.jkz.getItemNum();
                        ImageViewerActivity.this.jkz.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.jkz.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.jkz.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.jkH != null) {
                        ImageViewerActivity.this.jkH.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.jkz.setUrlData(arrayList);
                    ImageViewerActivity.this.jkz.setAssistUrls(ImageViewerActivity.this.eqy);
                    ImageViewerActivity.this.jkz.setHasNext(z3);
                    ImageViewerActivity.this.jkz.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.jkz.getItemNum()) {
                        ImageViewerActivity.this.jkz.nn(ImageViewerActivity.this.jkz.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.jkz.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.jkz.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.jkz.setUrlData(arrayList);
                        ImageViewerActivity.this.jkz.setCurrentItem(ImageViewerActivity.this.jkz.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.cvV();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.jkz.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.jkH.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.jkH.cvn()) {
                    ImageViewerActivity.this.jkz.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.jkz.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bj(int i, String str2) {
                ImageViewerActivity.this.jkL = false;
                if (ImageViewerActivity.this.jks != null) {
                    ImageViewerActivity.this.jks.changeState(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.jks.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.jkA != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.jkA.size();
                    }
                    ImageViewerActivity.this.cvV();
                }
            }
        });
        this.jkB.qe(true);
        this.jkB.cvD();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!com.baidu.tbadk.util.k.isFastDoubleClick()) {
            TiebaStatic.log(new ao("c13377").dk("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jkz.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.jkz.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.jkK = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        zk(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jkz.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ajO, 0L);
        if (uniqueId != null && j > 0) {
            r.r(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jkz.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ajO, 0L);
        if (uniqueId != null && j > 0) {
            r.a(com.baidu.tbadk.BdToken.b.dyJ, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.jkz.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.jkW);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bgz().releaseBlockBitmapPool();
        this.jkC.e(this.jkA, this.mIndex, this.mIndex);
        this.jkC.cwf();
        String str3 = "";
        if (this.jkH != null) {
            str3 = this.jkH.getAdId();
        }
        if (this.jkB != null) {
            str = this.jkB.aTX();
            str2 = this.jkB.aTY();
        } else {
            str = null;
        }
        this.jkC.a(this.jkz.getPageCount(), str3, this.eEs, this.ajO, str, str2);
        if (this.jkD != null) {
            this.jkD.release();
        }
        this.jkz.onDestroy();
        com.baidu.tbadk.download.d.beW().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.jkK);
        cvZ();
        cwb();
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

    private void chO() {
        biq();
        initViewPager();
        cvV();
        bSO();
        cvR();
        this.jkD = new j(this);
        this.jkD.j(this.jkz);
        this.jkC.e(this.jkA, this.mIndex, this.mIndex);
    }

    private void cvR() {
        if (com.baidu.tbadk.core.util.g.aVY()) {
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
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.18
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    ImageViewerActivity.this.setFullScreen();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().addFlags(134217728);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    private void biq() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        cvS();
        byp();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.HL((String) w.getItem(this.jkA, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void cvS() {
        this.hCa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hCa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.gqS = (ImageView) this.hCa.findViewById(R.id.widget_navi_back_button);
        SvgManager.aWQ().a(this.gqS, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hCa.setVisibility(0);
    }

    private void byp() {
        if (!this.jkR && !this.jkQ) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.jkt = addCustomView.findViewById(R.id.view_user_photo);
            this.jku = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.jkv = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.jku.setIsRound(true);
            this.jku.setPlaceHolder(1);
            if (this.jkP) {
                ArrayList arrayList = new ArrayList(2);
                p pVar = new p();
                pVar.EX(0);
                pVar.Ng(getString(R.string.all));
                arrayList.add(pVar);
                p pVar2 = new p();
                pVar2.EX(1);
                pVar2.Ng(getString(R.string.host_name));
                arrayList.add(pVar2);
                this.jks = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.jks.setNeedDayNight(false);
                this.jks.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.jks.setVisibility(0);
                this.jks.setOnSwitchChangeListener(this.jkX);
                o(this.jkt, 0);
                return;
            }
            o(this.jks, 8);
            o(this.jkt, 8);
        }
    }

    public Map<String, ImageUrlData> cvT() {
        return this.eqy;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cvU() {
        ImageUrlData imageUrlData;
        String str = (String) w.getItem(this.jkA, this.mIndex);
        if (this.eqy == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.eqy.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvV() {
        String str;
        if (this.jkA != null) {
            long cvU = cvU();
            String str2 = ("" + cvU) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.jkM && cvU() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new ao("c13316").dk("obj_source", this.mFrom));
                this.jkM = true;
            }
            if (cvW()) {
                cvX();
            } else {
                HN(str);
            }
            long j = cvU - 1;
            zj(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cvW() {
        if (this.jkO && this.jkH != null && this.jkH.cvn()) {
            return this.jkz.getItemNum() != 1 && this.mIndex == this.jkz.getItemNum() + (-1);
        }
        return false;
    }

    private void HN(String str) {
        this.mTitleView.setText(str);
        if (this.jkP && !this.jkQ && this.jks != null) {
            this.jks.changeState(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void cvX() {
        this.mTitleView.setText("");
        o(this.jks, 8);
        o(this.jkt, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.jkz == null) {
            this.jkz = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.jkz.init();
        }
        this.jkz.setIsFromCDN(this.eps);
        this.jkz.setIsCanDrag(this.epu);
        this.jkz.setIsBJHThread(this.jkR);
        this.jkz.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.jkz.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.jkz.setOnPageChangeListener(this.bLe);
        this.jkz.setUrlData(this.jkA);
        this.jkz.setAssistUrls(this.eqy);
        this.jkz.setOuterOnTouchListener(this.erl);
        this.jkz.setItemOnclickListener(this.mOnClickListener);
        this.jkz.setItemOnLongClickListener(this.jla);
        this.jkz.setCurrentItem(cmP(), false);
        this.jkz.setOnScrollOutListener(this.jlb);
        this.jkH = new a(this.eps, this.jkO, getPageContext(), this.eEs, this.ajO);
        this.jkH.setDragToExitListener(this.eqZ);
        this.jkz.a(this.jkH);
        this.jkz.setOriImgSelectedCallback(this.epl);
        this.jkz.setDragToExitListener(this.eqZ);
        this.jkz.setUserId(this.mUserId);
        this.jkz.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.jkE = ImageViewerActivity.this.jkF - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.jkF = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.jkz.setShowBottomContainer(this.jkU);
        TiebaStatic.log(new ao("c13340").dk("uid", this.mUserId).dk("post_id", this.ajO).ag("obj_source", cvY()));
    }

    private int cvY() {
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

    private void bSO() {
        if (!this.jkQ && this.jks != null) {
            if (this.jkG == null) {
                this.jkG = new com.baidu.tieba.c.e(getPageContext(), this.jks);
                this.jkG.cS(R.drawable.pic_sign_tip);
                this.jkG.cR(48);
                this.jkG.setUseDirectOffset(true);
                this.jkG.cT(5000);
                this.jkG.sZ(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.jkG.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.cvZ();
                    }
                });
            }
            this.jkG.aC(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvZ() {
        if (this.jkG != null) {
            this.jkG.HH();
        }
    }

    public int cmP() {
        int count = w.getCount(this.jkA);
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
        this.jkC = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.jkR = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.jkA = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.eEs = bundle.getString("fid");
            this.ajO = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.foo = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.eps = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.jkT = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.jkO = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.epu = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.jkP = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.jka = bundle.getString("source_rect_in_screen");
            this.jkc = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.jkU = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.jkd = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.eqy = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.eqy.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.jkS = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.jkQ = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.jke = bundle.getInt(IntentConfig.CARD_TYPE, 0);
            this.mRecomSource = bundle.getString(IntentConfig.RECOM_SOURCE);
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            stoken = string3;
            tbs = string2;
            bduss = string;
            isLogin = z;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.jkR = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.jkA = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.eEs = intent.getStringExtra("fid");
                this.ajO = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.foo = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.eps = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.jkT = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.jkO = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.epu = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.jkP = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.jkU = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.jkd = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.jkS = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.jkQ = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.jka = intent.getStringExtra("source_rect_in_screen");
                this.jkc = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.eqy = (Map) serializableExtra;
                }
                this.jke = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
                this.mRecomSource = intent.getStringExtra(IntentConfig.RECOM_SOURCE);
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                stoken = stringExtra2;
                tbs = stringExtra3;
                bduss = stringExtra;
                isLogin = booleanExtra;
            }
        }
        com.baidu.tbadk.mutiprocess.f.iq(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.jkC.b(bundle, getIntent());
        this.mCount = w.getCount(this.jkA);
        if (this.jka != null) {
            String str = (String) w.getItem(this.jkA, this.mIndex);
            if (!StringUtils.isNull(str) && this.eqy != null && (imageUrlData = this.eqy.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.jka);
            }
        }
        this.jkb = this.jkR ? null : d.HK((String) w.getItem(this.jkA, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new ao("c13337").dk("obj_type", "2"));
        } else {
            TiebaStatic.log(new ao("c13337").dk("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.jkR);
        bundle.putStringArrayList("url", this.jkA);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.eEs);
        bundle.putString("tid", this.ajO);
        bundle.putString("fname", this.foo);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.jkT);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.epu);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.jkP);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.jkO);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.jkU);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.jkd);
        if (this.eqy instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.eqy.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.eqy instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.eqy.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.jka);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.jkS);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.jkQ);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.jkc);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.jkC.ay(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jkz.setCurrentItem(this.mIndex, false);
        SvgManager.aWQ().a(this.gqS, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(int i) {
        if (this.jkz != null) {
            this.jkz.nm(i);
            int i2 = (this.jkz.bdB() || cvW()) ? 8 : 0;
            o(this.jks, i2);
            o(this.jkt, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwa() {
        if (cvW()) {
            this.jkJ = this.mNavigationBar.getVisibility() == 0;
            this.jkI = true;
        } else if (this.jkI) {
            this.mNavigationBar.setVisibility(this.jkJ ? 0 : 8);
            this.jkI = false;
        }
    }

    private void zj(int i) {
        if (this.jkB != null) {
            ArrayList<AlaInfoData> cvC = this.jkB.cvC();
            if (cvC != null && cvC.size() > 0) {
                qg(true);
                b(cvC.get(i % cvC.size()));
                return;
            }
            qg(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.jku, alaInfoData.user_info.portrait);
            this.jku.setAlaInfo(alaInfoData);
            this.jku.setOnClickListener(this.jlc);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                HO(alaInfoData.tag);
            }
            TiebaStatic.log(new ao("c13710").dk("fid", this.eEs).dk("fname", this.foo).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", this.ajO).dk("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void qg(boolean z) {
        if (this.jkx != z) {
            if (this.jkv != null) {
                if (z) {
                    this.jkv.setVisibility(0);
                    if (!this.jkv.isAnimating()) {
                        this.jkv.setSpeed(0.8f);
                        this.jkv.setRepeatCount(-1);
                        this.jkv.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.jkv.playAnimation();
                            }
                        });
                    }
                } else {
                    this.jkv.setVisibility(8);
                    if (this.jkv.isAnimating()) {
                        this.jkv.cancelAnimation();
                    }
                }
            }
            if (this.jku != null) {
                this.jku.setVisibility(z ? 0 : 8);
            }
            this.jkx = z;
        }
    }

    private void zk(int i) {
        if (this.jkv != null) {
            if (i == 1) {
                this.jkv.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.jkv.setAnimation("live/card_live_bg_black.json");
            } else {
                this.jkv.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HO(@NonNull final String str) {
        if (this.jkv != null) {
            this.jkv.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.jkw != null) {
                        if (ImageViewerActivity.this.jky == null || ImageViewerActivity.this.jkw == null || ImageViewerActivity.this.jkt == null || ImageViewerActivity.this.jkt.getVisibility() != 0) {
                            ImageViewerActivity.this.cwb();
                            return;
                        }
                        ImageViewerActivity.this.jkw.DY(str);
                        ImageViewerActivity.this.jky = null;
                        return;
                    }
                    ImageViewerActivity.this.jkw = new com.baidu.tieba.c.e(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.jkv);
                    ImageViewerActivity.this.jkw.cS(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.jkw.cR(32);
                    ImageViewerActivity.this.jkw.setUseDirectOffset(true);
                    ImageViewerActivity.this.jkw.sY(1);
                    ImageViewerActivity.this.jkw.sZ(0);
                    ImageViewerActivity.this.jkw.cT(3000);
                    ImageViewerActivity.this.jkw.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.cwb();
                        }
                    });
                    if (ImageViewerActivity.this.jkt == null || ImageViewerActivity.this.jkt.getVisibility() == 0) {
                        ImageViewerActivity.this.jkw.DY(str);
                        return;
                    }
                    ImageViewerActivity.this.jky = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwb() {
        if (this.jkw != null) {
            this.jkw.HH();
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
                return com.baidu.tbadk.m.e.bhB().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.eEs, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.ajO, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.yX(TbadkCoreApplication.getInst().getAdAdSense().ejy);
            }
        }
        return pageStayDurationItem;
    }

    public boolean cwc() {
        return this.jkR;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (ar.isEmpty(this.ajO)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.ajO, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
