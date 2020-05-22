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
import com.baidu.tbadk.BdToken.q;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
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
    private String ais;
    private Map<String, ImageUrlData> ehO;
    private String evm;
    private String fcT;
    private ImageView gdN;
    private View hpf;
    private MultiImageView iSA;
    private ArrayList<String> iSB;
    private e iSC;
    private i iSD;
    private j iSE;
    private boolean iSF;
    private float iSG;
    private com.baidu.tieba.c.d iSH;
    private int iSL;
    private boolean iSM;
    private float iSZ;
    private String iSb;
    private String iSc;
    private int iSf;
    private SortSwitchButton iSt;
    private View iSu;
    private HeadImageView iSv;
    private TBLottieAnimationView iSw;
    private com.baidu.tieba.c.d iSx;
    private String iSz;
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
    private boolean iSy = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a iSI = null;
    private boolean iSJ = false;
    private boolean iSK = false;
    private int Yf = 0;
    private boolean isRight = false;
    private boolean iSN = false;
    private boolean iSO = false;
    private boolean iSP = true;
    private boolean egK = true;
    private boolean iSQ = true;
    private boolean mIsSeeHost = false;
    private boolean iSR = false;
    private boolean iSS = false;
    private boolean iST = false;
    private boolean iSd = false;
    private boolean iSU = true;
    private boolean egI = false;
    private boolean iSV = true;
    private boolean iSe = false;
    private CustomMessageListener iSW = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.csc();
            }
        }
    };
    private final CustomMessageListener iSX = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.image.ImageViewerActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.ejY)) {
                    ba.aUZ().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.aUZ().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.ejY});
                }
            }
        }
    };
    private DragImageView.d eip = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.iSt, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.hpf, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.iSu, 8);
            if (ImageViewerActivity.this.iSA != null) {
                ImageViewerActivity.this.iSA.hL(false);
            }
            ImageViewerActivity.this.csa();
            ImageViewerActivity.this.csc();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").ag("obj_param1", ImageViewerActivity.this.iSA.getItemNum()).ag(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.iSA.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bhc() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.hpf.setVisibility(0);
            if (ImageViewerActivity.this.iSA != null) {
                boolean bby = ImageViewerActivity.this.iSA.bby();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bby) {
                    ImageViewerActivity.this.o(ImageViewerActivity.this.iSt, 0);
                    ImageViewerActivity.this.o(ImageViewerActivity.this.iSu, 0);
                    ImageViewerActivity.this.Hm(ImageViewerActivity.this.iSz);
                    if (ImageViewerActivity.this.iSV) {
                        ImageViewerActivity.this.iSA.hL(true);
                    } else {
                        ImageViewerActivity.this.iSA.hL(false);
                    }
                }
            }
        }
    };
    private UrlDragImageView.b egB = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bbQ() {
            TiebaStatic.log(new an("c10351").dh("tid", ImageViewerActivity.this.ais).dh("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a iSY = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean ut(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.iSM = true;
                if (ImageViewerActivity.this.iSt != null) {
                    ImageViewerActivity.this.iSt.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.Hi((String) v.getItem(ImageViewerActivity.this.iSB, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c13341").ag("obj_param1", ImageViewerActivity.this.iSA.getItemNum()).ag(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.iSA.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").dh("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean iTa = true;
    private View.OnTouchListener eiB = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.iSZ = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.iTa = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.iSZ = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.iTa = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener iTb = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.iSE != null) {
                ImageViewerActivity.this.iSE.bOw();
                ImageViewerActivity.this.iSE.show();
                ImageViewerActivity.this.iSE.cp(view);
            }
            TiebaStatic.log(new an("c13269").dh("uid", ImageViewerActivity.this.mUserId).dh("fid", ImageViewerActivity.this.evm).dh("tid", ImageViewerActivity.this.ais));
            return true;
        }
    };
    private BaseViewPager.a iTc = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.iSC.crE();
            } else if (ImageViewerActivity.this.crV() != 1) {
                ImageViewerActivity.this.iSC.crF();
            }
        }
    };
    private ViewPager.OnPageChangeListener bGq = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.iSC != null && i > ImageViewerActivity.this.iSA.getItemNum() - 5) {
                ImageViewerActivity.this.iSC.crE();
            }
            ImageViewerActivity.this.iSD.e(ImageViewerActivity.this.iSB, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.crW();
            ImageViewerActivity.this.csb();
            ImageViewerActivity.this.yu(i);
            if (ImageViewerActivity.this.iSD.cse() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.iSD.yx(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.iSD.csf() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.iSD.yy(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.crX()) {
                ImageViewerActivity.this.iSI.crr();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.iSA.getItemNum() - 1) {
                ImageViewerActivity.this.iSO = false;
            }
            if (ImageViewerActivity.this.iSE != null) {
                ImageViewerActivity.this.iSE.csh();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            if (i > ImageViewerActivity.this.Yf) {
                ImageViewerActivity.this.Yf = i;
                ImageViewerActivity.this.isRight = true;
            } else if (i < ImageViewerActivity.this.Yf) {
                ImageViewerActivity.this.Yf = i;
                ImageViewerActivity.this.isRight = false;
            }
            if (ImageViewerActivity.this.iSA != null) {
                dragImageView = ImageViewerActivity.this.iSA.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.crV() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.csc();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.iSB != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.iSB.size()) {
                ImageViewerActivity.this.iSD.bg(i, (String) ImageViewerActivity.this.iSB.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.iSA.getItemNum() - 1) {
                if (!ImageViewerActivity.this.iTa || !ImageViewerActivity.this.iSF || (!ImageViewerActivity.this.iSO && !ImageViewerActivity.this.crX() && (ImageViewerActivity.this.iSA.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.iSO = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private View.OnClickListener iTd = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if ((view instanceof HeadImageView) && (alaInfo = ((HeadImageView) view).getAlaInfo()) != null) {
                if (alaInfo.isChushou) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.baidu.tbadk.BdToken.f.dvg).append("://").append(com.baidu.tbadk.BdToken.f.HOST).append(com.baidu.tbadk.BdToken.f.dvp).append("?").append(com.baidu.tbadk.BdToken.f.dvG).append(ETAG.EQUAL).append(alaInfo.thirdLiveType).append(ETAG.ITEM_SEPARATOR).append(com.baidu.tbadk.BdToken.f.dvH).append(ETAG.EQUAL).append(alaInfo.thirdRoomId);
                    ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
                } else if (alaInfo.live_id > 0) {
                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                    alaLiveInfoCoreData.liveID = alaInfo.live_id;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(view.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PHOTO_BROWSE_TOP, null, false, "")));
                }
                TiebaStatic.log(new an("c13711").dh("fid", ImageViewerActivity.this.evm).dh("fname", ImageViewerActivity.this.fcT).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", ImageViewerActivity.this.ais).dh("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
            }
        }
    };
    private CustomMessageListener dRK = new CustomMessageListener(2016528) { // from class: com.baidu.tieba.image.ImageViewerActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.ehO != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.ehO.values()) {
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
    private CustomMessageListener dRL = new CustomMessageListener(2016530) { // from class: com.baidu.tieba.image.ImageViewerActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e) && ImageViewerActivity.this.ehO != null && (agreeData = ((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : ImageViewerActivity.this.ehO.values()) {
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
        com.baidu.tbadk.mutiprocess.g.beJ().init(TbadkCoreApplication.getInst());
        this.iSL = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        cei();
        k(this.iSc, this.mIsSeeHost, false);
        registerListener(this.iSX);
        registerListener(this.iSW);
        registerListener(this.dRK);
        registerListener(this.dRL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.iSC = new e(this.iSB, this.ehO, this.evm, this.fcT, this.ais, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.iSf, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.iSC.setSourceImageRectInScreen(this.iSb);
        this.iSC.pS(this.iSU);
        this.iSC.pT(z);
        this.iSC.Hk(this.iSc);
        this.iSC.pR(this.iSd);
        this.iSC.setPostId(this.mPostId);
        this.iSC.pV(this.iSe);
        this.iSC.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.iSA != null) {
                    if (ImageViewerActivity.this.iSM) {
                        if (!z5) {
                            ImageViewerActivity.this.iSA.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.iSM = false;
                    if (ImageViewerActivity.this.iSt != null) {
                        ImageViewerActivity.this.iSt.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.iSA.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.iSA.getItemNum();
                        ImageViewerActivity.this.iSA.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.iSA.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.iSA.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.iSI != null) {
                        ImageViewerActivity.this.iSI.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.iSA.setUrlData(arrayList);
                    ImageViewerActivity.this.iSA.setAssistUrls(ImageViewerActivity.this.ehO);
                    ImageViewerActivity.this.iSA.setHasNext(z3);
                    ImageViewerActivity.this.iSA.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.iSA.getItemNum()) {
                        ImageViewerActivity.this.iSA.mR(ImageViewerActivity.this.iSA.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.iSA.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.iSA.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.iSA.setUrlData(arrayList);
                        ImageViewerActivity.this.iSA.setCurrentItem(ImageViewerActivity.this.iSA.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.crW();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.iSA.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.iSI.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.iSI.crn()) {
                    ImageViewerActivity.this.iSA.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.iSA.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bf(int i, String str2) {
                ImageViewerActivity.this.iSM = false;
                if (ImageViewerActivity.this.iSt != null) {
                    ImageViewerActivity.this.iSt.changeState(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.iSt.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.iSB != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.iSB.size();
                    }
                    ImageViewerActivity.this.crW();
                }
            }
        });
        this.iSC.pU(true);
        this.iSC.crE();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (!com.baidu.tbadk.util.k.isFastDoubleClick()) {
            TiebaStatic.log(new an("c13377").dh("obj_type", "4"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.iSA.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.iSA.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.iSL = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        yw(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.iSA.onPause();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ais, 0L);
        if (uniqueId != null && j > 0) {
            q.q(uniqueId.getId(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iSA.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ais, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.dua, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.iSA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.iSX);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.bet().releaseBlockBitmapPool();
        this.iSD.e(this.iSB, this.mIndex, this.mIndex);
        this.iSD.csg();
        String str3 = "";
        if (this.iSI != null) {
            str3 = this.iSI.getAdId();
        }
        if (this.iSC != null) {
            str = this.iSC.aSh();
            str2 = this.iSC.aSi();
        } else {
            str = null;
        }
        this.iSD.a(this.iSA.getPageCount(), str3, this.evm, this.ais, str, str2);
        if (this.iSE != null) {
            this.iSE.release();
        }
        this.iSA.onDestroy();
        com.baidu.tbadk.download.d.bcT().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.iSL);
        csa();
        csc();
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

    private void cei() {
        brb();
        initViewPager();
        crW();
        bPI();
        crS();
        this.iSE = new j(this);
        this.iSE.j(this.iSA);
        this.iSD.e(this.iSB, this.mIndex, this.mIndex);
    }

    private void crS() {
        if (com.baidu.tbadk.core.util.g.aUg()) {
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

    private void brb() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        crT();
        bvr();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.Hj((String) v.getItem(this.iSB, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void crT() {
        this.hpf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hpf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.gdN = (ImageView) this.hpf.findViewById(R.id.widget_navi_back_button);
        SvgManager.aUV().a(this.gdN, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hpf.setVisibility(0);
    }

    private void bvr() {
        if (!this.iSS && !this.iSR) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.iSu = addCustomView.findViewById(R.id.view_user_photo);
            this.iSv = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.iSw = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.iSv.setIsRound(true);
            this.iSv.setPlaceHolder(1);
            if (this.iSQ) {
                ArrayList arrayList = new ArrayList(2);
                com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
                qVar.DT(0);
                qVar.MD(getString(R.string.all));
                arrayList.add(qVar);
                com.baidu.tieba.tbadkCore.data.q qVar2 = new com.baidu.tieba.tbadkCore.data.q();
                qVar2.DT(1);
                qVar2.MD(getString(R.string.host_name));
                arrayList.add(qVar2);
                this.iSt = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.iSt.setNeedDayNight(false);
                this.iSt.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.iSt.setVisibility(0);
                this.iSt.setOnSwitchChangeListener(this.iSY);
                o(this.iSu, 0);
                return;
            }
            o(this.iSt, 8);
            o(this.iSu, 8);
        }
    }

    public Map<String, ImageUrlData> crU() {
        return this.ehO;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long crV() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.iSB, this.mIndex);
        if (this.ehO == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.ehO.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crW() {
        String str;
        if (this.iSB != null) {
            long crV = crV();
            String str2 = ("" + crV) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.iSN && crV() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").dh("obj_source", this.mFrom));
                this.iSN = true;
            }
            if (crX()) {
                crY();
            } else {
                Hl(str);
            }
            long j = crV - 1;
            yv(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crX() {
        if (this.iSP && this.iSI != null && this.iSI.crn()) {
            return this.iSA.getItemNum() != 1 && this.mIndex == this.iSA.getItemNum() + (-1);
        }
        return false;
    }

    private void Hl(String str) {
        this.mTitleView.setText(str);
        if (this.iSQ && !this.iSR && this.iSt != null) {
            this.iSt.changeState(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void crY() {
        this.mTitleView.setText("");
        o(this.iSt, 8);
        o(this.iSu, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.iSA == null) {
            this.iSA = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.iSA.init();
        }
        this.iSA.setIsFromCDN(this.egI);
        this.iSA.setIsCanDrag(this.egK);
        this.iSA.setIsBJHThread(this.iSS);
        this.iSA.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.iSA.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.iSA.setOnPageChangeListener(this.bGq);
        this.iSA.setUrlData(this.iSB);
        this.iSA.setAssistUrls(this.ehO);
        this.iSA.setOuterOnTouchListener(this.eiB);
        this.iSA.setItemOnclickListener(this.mOnClickListener);
        this.iSA.setItemOnLongClickListener(this.iTb);
        this.iSA.setCurrentItem(ciQ(), false);
        this.iSA.setOnScrollOutListener(this.iTc);
        this.iSI = new a(this.egI, this.iSP, getPageContext(), this.evm, this.ais);
        this.iSI.setDragToExitListener(this.eip);
        this.iSA.a(this.iSI);
        this.iSA.setOriImgSelectedCallback(this.egB);
        this.iSA.setDragToExitListener(this.eip);
        this.iSA.setUserId(this.mUserId);
        this.iSA.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.iSF = ImageViewerActivity.this.iSG - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.iSG = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.iSA.setShowBottomContainer(this.iSV);
        TiebaStatic.log(new an("c13340").dh("uid", this.mUserId).dh("post_id", this.ais).ag("obj_source", crZ()));
    }

    private int crZ() {
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

    private void bPI() {
        if (!this.iSR && this.iSt != null) {
            if (this.iSH == null) {
                this.iSH = new com.baidu.tieba.c.d(getPageContext(), this.iSt);
                this.iSH.cG(R.drawable.pic_sign_tip);
                this.iSH.cF(48);
                this.iSH.setUseDirectOffset(true);
                this.iSH.cH(5000);
                this.iSH.sx(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.iSH.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.csa();
                    }
                });
            }
            this.iSH.aA(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csa() {
        if (this.iSH != null) {
            this.iSH.Gu();
        }
    }

    public int ciQ() {
        int count = v.getCount(this.iSB);
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
        this.iSD = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.iSS = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.iSB = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.evm = bundle.getString("fid");
            this.ais = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.fcT = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.egI = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.iSU = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.iSP = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.egK = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.iSQ = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.iSb = bundle.getString("source_rect_in_screen");
            this.iSd = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.iSV = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.iSe = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.ehO = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.ehO.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            this.iST = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.iSR = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.iSf = bundle.getInt(IntentConfig.CARD_TYPE, 0);
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
                this.iSS = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.iSB = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.evm = intent.getStringExtra("fid");
                this.ais = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.fcT = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.egI = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.iSU = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.iSP = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.egK = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.iSQ = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.iSV = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.iSe = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.iST = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.iSR = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.iSb = intent.getStringExtra("source_rect_in_screen");
                this.iSd = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.ehO = (Map) serializableExtra;
                }
                this.iSf = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
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
        com.baidu.tbadk.mutiprocess.f.ih(isLogin);
        com.baidu.tbadk.mutiprocess.f.setBduss(bduss);
        com.baidu.tbadk.mutiprocess.f.setStoken(stoken);
        com.baidu.tbadk.mutiprocess.f.setTbs(tbs);
        this.iSD.b(bundle, getIntent());
        this.mCount = v.getCount(this.iSB);
        if (this.iSb != null) {
            String str = (String) v.getItem(this.iSB, this.mIndex);
            if (!StringUtils.isNull(str) && this.ehO != null && (imageUrlData = this.ehO.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.iSb);
            }
        }
        this.iSc = this.iSS ? null : d.Hi((String) v.getItem(this.iSB, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").dh("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").dh("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.iSS);
        bundle.putStringArrayList("url", this.iSB);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.evm);
        bundle.putString("tid", this.ais);
        bundle.putString("fname", this.fcT);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.iSU);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.egK);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.iSQ);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.iSP);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.iSV);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.iSe);
        if (this.ehO instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.ehO.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (this.ehO instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.ehO.entrySet()) {
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
        bundle.putString("source_rect_in_screen", this.iSb);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.iST);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.iSR);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.iSd);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.iSD.ax(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.iSA.setCurrentItem(this.mIndex, false);
        SvgManager.aUV().a(this.gdN, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu(int i) {
        if (this.iSA != null) {
            this.iSA.mQ(i);
            int i2 = (this.iSA.bby() || crX()) ? 8 : 0;
            o(this.iSt, i2);
            o(this.iSu, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csb() {
        if (crX()) {
            this.iSK = this.mNavigationBar.getVisibility() == 0;
            this.iSJ = true;
        } else if (this.iSJ) {
            this.mNavigationBar.setVisibility(this.iSK ? 0 : 8);
            this.iSJ = false;
        }
    }

    private void yv(int i) {
        if (this.iSC != null) {
            ArrayList<AlaInfoData> crD = this.iSC.crD();
            if (crD != null && crD.size() > 0) {
                pW(true);
                b(crD.get(i % crD.size()));
                return;
            }
            pW(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.iSv, alaInfoData.user_info.portrait);
            this.iSv.setAlaInfo(alaInfoData);
            this.iSv.setOnClickListener(this.iTd);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                Hm(alaInfoData.tag);
            }
            TiebaStatic.log(new an("c13710").dh("fid", this.evm).dh("fname", this.fcT).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", this.ais).dh("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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

    private void pW(boolean z) {
        if (this.iSy != z) {
            if (this.iSw != null) {
                if (z) {
                    this.iSw.setVisibility(0);
                    if (!this.iSw.isAnimating()) {
                        this.iSw.setSpeed(0.8f);
                        this.iSw.setRepeatCount(-1);
                        this.iSw.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.iSw.playAnimation();
                            }
                        });
                    }
                } else {
                    this.iSw.setVisibility(8);
                    if (this.iSw.isAnimating()) {
                        this.iSw.cancelAnimation();
                    }
                }
            }
            if (this.iSv != null) {
                this.iSv.setVisibility(z ? 0 : 8);
            }
            this.iSy = z;
        }
    }

    private void yw(int i) {
        if (this.iSw != null) {
            if (i == 1) {
                this.iSw.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.iSw.setAnimation("live/card_live_bg_black.json");
            } else {
                this.iSw.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm(@NonNull final String str) {
        if (this.iSw != null) {
            this.iSw.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.iSx != null) {
                        if (ImageViewerActivity.this.iSz == null || ImageViewerActivity.this.iSx == null || ImageViewerActivity.this.iSu == null || ImageViewerActivity.this.iSu.getVisibility() != 0) {
                            ImageViewerActivity.this.csc();
                            return;
                        }
                        ImageViewerActivity.this.iSx.Dx(str);
                        ImageViewerActivity.this.iSz = null;
                        return;
                    }
                    ImageViewerActivity.this.iSx = new com.baidu.tieba.c.d(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.iSw);
                    ImageViewerActivity.this.iSx.cG(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.iSx.cF(32);
                    ImageViewerActivity.this.iSx.setUseDirectOffset(true);
                    ImageViewerActivity.this.iSx.sw(1);
                    ImageViewerActivity.this.iSx.sx(0);
                    ImageViewerActivity.this.iSx.cH(3000);
                    ImageViewerActivity.this.iSx.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.csc();
                        }
                    });
                    if (ImageViewerActivity.this.iSu == null || ImageViewerActivity.this.iSu.getVisibility() == 0) {
                        ImageViewerActivity.this.iSx.Dx(str);
                        return;
                    }
                    ImageViewerActivity.this.iSz = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csc() {
        if (this.iSx != null) {
            this.iSx.Gu();
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
                return com.baidu.tbadk.m.e.bfu().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.evm, 0L));
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.ais, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.yE(TbadkCoreApplication.getInst().getAdAdSense().eaO);
            }
        }
        return pageStayDurationItem;
    }

    public boolean csd() {
        return this.iSS;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (aq.isEmpty(this.ais)) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.ais, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
