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
    private String fde;
    private ImageView gdY;
    private View hpq;
    private String iSO;
    private String iSP;
    private int iSS;
    private float iTM;
    private SortSwitchButton iTg;
    private View iTh;
    private HeadImageView iTi;
    private TBLottieAnimationView iTj;
    private com.baidu.tieba.c.d iTk;
    private String iTm;
    private MultiImageView iTn;
    private ArrayList<String> iTo;
    private e iTp;
    private i iTq;
    private j iTr;
    private boolean iTs;
    private float iTt;
    private com.baidu.tieba.c.d iTu;
    private int iTy;
    private boolean iTz;
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
    private boolean iTl = false;
    private int mIndex = -1;
    private int mCount = -1;
    private a iTv = null;
    private boolean iTw = false;
    private boolean iTx = false;
    private int Yf = 0;
    private boolean isRight = false;
    private boolean iTA = false;
    private boolean iTB = false;
    private boolean iTC = true;
    private boolean egK = true;
    private boolean iTD = true;
    private boolean mIsSeeHost = false;
    private boolean iTE = false;
    private boolean iTF = false;
    private boolean iTG = false;
    private boolean iSQ = false;
    private boolean iTH = true;
    private boolean egI = false;
    private boolean iTI = true;
    private boolean iSR = false;
    private CustomMessageListener iTJ = new CustomMessageListener(2016496) { // from class: com.baidu.tieba.image.ImageViewerActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                ImageViewerActivity.this.csl();
            }
        }
    };
    private final CustomMessageListener iTK = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.image.ImageViewerActivity.12
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
                    ba.aVa().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.aVa().b(ImageViewerActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.ejY});
                }
            }
        }
    };
    private DragImageView.d eip = new DragImageView.d() { // from class: com.baidu.tieba.image.ImageViewerActivity.15
        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragStart() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.iTg, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.hpq, 8);
            ImageViewerActivity.this.o(ImageViewerActivity.this.iTh, 8);
            if (ImageViewerActivity.this.iTn != null) {
                ImageViewerActivity.this.iTn.hL(false);
            }
            ImageViewerActivity.this.csj();
            ImageViewerActivity.this.csl();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void onDragEnd() {
            TiebaStatic.log(new an("c13341").ag("obj_param1", ImageViewerActivity.this.iTn.getItemNum()).ag(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.iTn.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.d
        public void bhd() {
            ImageViewerActivity.this.o(ImageViewerActivity.this.mTitleView, 0);
            ImageViewerActivity.this.hpq.setVisibility(0);
            if (ImageViewerActivity.this.iTn != null) {
                boolean bbz = ImageViewerActivity.this.iTn.bbz();
                if (!"portrait".equals(ImageViewerActivity.this.mFrom) && !bbz) {
                    ImageViewerActivity.this.o(ImageViewerActivity.this.iTg, 0);
                    ImageViewerActivity.this.o(ImageViewerActivity.this.iTh, 0);
                    ImageViewerActivity.this.Hm(ImageViewerActivity.this.iTm);
                    if (ImageViewerActivity.this.iTI) {
                        ImageViewerActivity.this.iTn.hL(true);
                    } else {
                        ImageViewerActivity.this.iTn.hL(false);
                    }
                }
            }
        }
    };
    private UrlDragImageView.b egB = new UrlDragImageView.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.16
        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.b
        public void bbR() {
            TiebaStatic.log(new an("c10351").dh("tid", ImageViewerActivity.this.ais).dh("obj_type", ImageViewerActivity.this.mFrom));
        }
    };
    private final SortSwitchButton.a iTL = new SortSwitchButton.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.20
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean uv(int i) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                ImageViewerActivity.this.iTz = true;
                if (ImageViewerActivity.this.iTg != null) {
                    ImageViewerActivity.this.iTg.setEnabled(false);
                }
                ImageViewerActivity.this.k(d.Hi((String) v.getItem(ImageViewerActivity.this.iTo, ImageViewerActivity.this.mIndex)), !ImageViewerActivity.this.mIsSeeHost, true);
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c13341").ag("obj_param1", ImageViewerActivity.this.iTn.getItemNum()).ag(TiebaInitialize.Params.OBJ_PARAM2, ImageViewerActivity.this.iTn.getCurrentMaxIndex()));
            TiebaStatic.log(new an("c13377").dh("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    };
    private boolean iTN = true;
    private View.OnTouchListener eiB = new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.4
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                case 0:
                    ImageViewerActivity.this.iTM = motionEvent.getX();
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.iTN = true;
                        break;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                    ImageViewerActivity.this.iTM = motionEvent.getX();
                    break;
                case 5:
                    if (view instanceof SubsamplingScaleImageView) {
                        ImageViewerActivity.this.iTN = false;
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private View.OnLongClickListener iTO = new View.OnLongClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (ImageViewerActivity.this.iTr != null) {
                ImageViewerActivity.this.iTr.bOy();
                ImageViewerActivity.this.iTr.show();
                ImageViewerActivity.this.iTr.cp(view);
            }
            TiebaStatic.log(new an("c13269").dh("uid", ImageViewerActivity.this.mUserId).dh("fid", ImageViewerActivity.this.evm).dh("tid", ImageViewerActivity.this.ais));
            return true;
        }
    };
    private BaseViewPager.a iTP = new BaseViewPager.a() { // from class: com.baidu.tieba.image.ImageViewerActivity.6
        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void onScrollOut(int i) {
            if (i == 0) {
                ImageViewerActivity.this.iTp.crN();
            } else if (ImageViewerActivity.this.cse() != 1) {
                ImageViewerActivity.this.iTp.crO();
            }
        }
    };
    private ViewPager.OnPageChangeListener bGq = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.7
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (ImageViewerActivity.this.iTp != null && i > ImageViewerActivity.this.iTn.getItemNum() - 5) {
                ImageViewerActivity.this.iTp.crN();
            }
            ImageViewerActivity.this.iTq.e(ImageViewerActivity.this.iTo, ImageViewerActivity.this.mIndex, i);
            ImageViewerActivity.this.mIndex = i;
            ImageViewerActivity.this.csf();
            ImageViewerActivity.this.csk();
            ImageViewerActivity.this.yw(i);
            if (ImageViewerActivity.this.iTq.csn() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.iTq.yz(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.iTq.cso() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.iTq.yA(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.csg()) {
                ImageViewerActivity.this.iTv.crA();
            }
            if (ImageViewerActivity.this.mIndex != ImageViewerActivity.this.iTn.getItemNum() - 1) {
                ImageViewerActivity.this.iTB = false;
            }
            if (ImageViewerActivity.this.iTr != null) {
                ImageViewerActivity.this.iTr.csq();
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
            if (ImageViewerActivity.this.iTn != null) {
                dragImageView = ImageViewerActivity.this.iTn.getCurrentView();
            } else {
                dragImageView = null;
            }
            boolean onLeftSide = dragImageView != null ? dragImageView.onLeftSide() : false;
            if (ImageViewerActivity.this.cse() == 1 && onLeftSide) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.csl();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ImageViewerActivity.this.iTo != null && ImageViewerActivity.this.mIndex < ImageViewerActivity.this.iTo.size()) {
                ImageViewerActivity.this.iTq.bg(i, (String) ImageViewerActivity.this.iTo.get(ImageViewerActivity.this.mIndex));
            }
            if (i == 0 && ImageViewerActivity.this.mIndex == ImageViewerActivity.this.iTn.getItemNum() - 1) {
                if (!ImageViewerActivity.this.iTN || !ImageViewerActivity.this.iTs || (!ImageViewerActivity.this.iTB && !ImageViewerActivity.this.csg() && (ImageViewerActivity.this.iTn.getItemNum() != 1 || !ImageViewerActivity.this.isRight))) {
                    ImageViewerActivity.this.iTB = true;
                } else {
                    ImageViewerActivity.this.showToast(R.string.last_page);
                }
            }
        }
    };
    private View.OnClickListener iTQ = new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.8
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
                TiebaStatic.log(new an("c13711").dh("fid", ImageViewerActivity.this.evm).dh("fname", ImageViewerActivity.this.fde).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", ImageViewerActivity.this.ais).dh("obj_param1", alaInfo.user_info != null ? "" + alaInfo.user_info.user_id : ""));
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
        com.baidu.tbadk.mutiprocess.g.beK().init(TbadkCoreApplication.getInst());
        this.iTy = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        ceq();
        k(this.iSP, this.mIsSeeHost, false);
        registerListener(this.iTK);
        registerListener(this.iTJ);
        registerListener(this.dRK);
        registerListener(this.dRL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z, boolean z2) {
        this.iTp = new e(this.iTo, this.ehO, this.evm, this.fde, this.ais, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.iSS, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.iTp.setSourceImageRectInScreen(this.iSO);
        this.iTp.pS(this.iTH);
        this.iTp.pT(z);
        this.iTp.Hk(this.iSP);
        this.iTp.pR(this.iSQ);
        this.iTp.setPostId(this.mPostId);
        this.iTp.pV(this.iSR);
        this.iTp.a(new e.b() { // from class: com.baidu.tieba.image.ImageViewerActivity.17
            @Override // com.baidu.tieba.image.e.b
            public void a(ArrayList<String> arrayList, int i, int i2, boolean z3, String str2, boolean z4, AdvertAppInfo advertAppInfo, boolean z5) {
                if (ImageViewerActivity.this.iTn != null) {
                    if (ImageViewerActivity.this.iTz) {
                        if (!z5) {
                            ImageViewerActivity.this.iTn.removeAllViews();
                            ImageViewerActivity.this.mIndex = 0;
                            ImageViewerActivity.this.initViewPager();
                            ImageViewerActivity.this.mIsSeeHost = !ImageViewerActivity.this.mIsSeeHost;
                        } else if (!ImageViewerActivity.this.mIsSeeHost) {
                            ImageViewerActivity.this.showToast(R.string.image_view_host_img_empty);
                        }
                    }
                    ImageViewerActivity.this.iTz = false;
                    if (ImageViewerActivity.this.iTg != null) {
                        ImageViewerActivity.this.iTg.setEnabled(true);
                    }
                    ImageViewerActivity.this.hideProgressBar();
                    if (z4 && ImageViewerActivity.this.iTn.getCurrentItem() <= 4) {
                        int itemNum = ImageViewerActivity.this.iTn.getItemNum();
                        ImageViewerActivity.this.iTn.setTempSize(itemNum + 100);
                        ImageViewerActivity.this.iTn.setCurrentItem(itemNum + 90, false);
                        ImageViewerActivity.this.iTn.setTempSize(0);
                    }
                    if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.iTv != null) {
                        ImageViewerActivity.this.iTv.a(advertAppInfo, arrayList.size());
                    }
                    ImageViewerActivity.this.iTn.setUrlData(arrayList);
                    ImageViewerActivity.this.iTn.setAssistUrls(ImageViewerActivity.this.ehO);
                    ImageViewerActivity.this.iTn.setHasNext(z3);
                    ImageViewerActivity.this.iTn.setNextTitle(str2);
                    if (i < 0 || i >= ImageViewerActivity.this.iTn.getItemNum()) {
                        ImageViewerActivity.this.iTn.mT(ImageViewerActivity.this.iTn.getCurrentItem());
                    } else {
                        ImageViewerActivity.this.iTn.setCurrentItem(i, false);
                    }
                    if (i2 != 0) {
                        ImageViewerActivity.this.mCount = i2;
                    }
                    if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.iTn.getCurrentItem() > 200) {
                        for (int i3 = 0; i3 < 200; i3++) {
                            arrayList.remove(0);
                        }
                        ImageViewerActivity.this.iTn.setUrlData(arrayList);
                        ImageViewerActivity.this.iTn.setCurrentItem(ImageViewerActivity.this.iTn.getCurrentItem() - 200, false);
                    }
                    a(arrayList, advertAppInfo);
                    ImageViewerActivity.this.csf();
                }
            }

            private void a(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
                if (advertAppInfo == null || arrayList == null) {
                    ImageViewerActivity.this.iTn.setAddSize(0);
                    return;
                }
                ImageViewerActivity.this.iTv.a(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.iTv.crw()) {
                    ImageViewerActivity.this.iTn.setAddSize(1);
                    TiebaStatic.log(com.baidu.tieba.s.a.b(PageStayDurationConstants.PageName.BIGIMAGE, "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.iTn.setAddSize(0);
            }

            @Override // com.baidu.tieba.image.e.b
            public void bf(int i, String str2) {
                ImageViewerActivity.this.iTz = false;
                if (ImageViewerActivity.this.iTg != null) {
                    ImageViewerActivity.this.iTg.changeState(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                    ImageViewerActivity.this.iTg.setEnabled(true);
                }
                ImageViewerActivity.this.hideProgressBar();
                ImageViewerActivity.this.showToast(str2);
                if (i == 40) {
                    if (ImageViewerActivity.this.iTo != null) {
                        ImageViewerActivity.this.mCount = ImageViewerActivity.this.iTo.size();
                    }
                    ImageViewerActivity.this.csf();
                }
            }
        });
        this.iTp.pU(true);
        this.iTp.crN();
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
        this.iTn.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.iTn.onSkinTypeChanged(i);
        super.onChangeSkinType(i);
        this.iTy = i;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        yy(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.iTn.onPause();
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
        this.iTn.onResume();
        this.mIsLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        BdUniqueId uniqueId = getUniqueId();
        long j = com.baidu.adp.lib.f.b.toLong(this.ais, 0L);
        if (uniqueId != null && j > 0) {
            q.a(com.baidu.tbadk.BdToken.b.dua, uniqueId.getId(), j);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.iTn.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2 = null;
        MessageManager.getInstance().unRegisterListener(this.iTK);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        com.baidu.tbadk.imageManager.c.beu().releaseBlockBitmapPool();
        this.iTq.e(this.iTo, this.mIndex, this.mIndex);
        this.iTq.csp();
        String str3 = "";
        if (this.iTv != null) {
            str3 = this.iTv.getAdId();
        }
        if (this.iTp != null) {
            str = this.iTp.aSh();
            str2 = this.iTp.aSi();
        } else {
            str = null;
        }
        this.iTq.a(this.iTn.getPageCount(), str3, this.evm, this.ais, str, str2);
        if (this.iTr != null) {
            this.iTr.release();
        }
        this.iTn.onDestroy();
        com.baidu.tbadk.download.d.bcU().cancelDownloadByType(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.iTy);
        csj();
        csl();
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

    private void ceq() {
        brd();
        initViewPager();
        csf();
        bPK();
        csb();
        this.iTr = new j(this);
        this.iTr.j(this.iTn);
        this.iTq.e(this.iTo, this.mIndex, this.mIndex);
    }

    private void csb() {
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

    private void brd() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        csc();
        bvt();
        this.mTitleView = new TextView(this);
        this.mTitleView.setPadding(l.getDimens(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.cp_cont_a));
        this.mTitleView.setTextSize(0, l.getDimens(this, R.dimen.tbds44));
        this.mTitleView.setShadowLayer(1.0f, 1.0f, 1.0f, ContextCompat.getColor(this, R.color.cp_mask_b_alpha42));
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.Hj((String) v.getItem(this.iTo, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void csc() {
        this.hpq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hpq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.finish();
            }
        });
        this.gdY = (ImageView) this.hpq.findViewById(R.id.widget_navi_back_button);
        SvgManager.aUW().a(this.gdY, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.hpq.setVisibility(0);
    }

    private void bvt() {
        if (!this.iTF && !this.iTE) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.iTh = addCustomView.findViewById(R.id.view_user_photo);
            this.iTi = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
            this.iTj = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
            this.iTi.setIsRound(true);
            this.iTi.setPlaceHolder(1);
            if (this.iTD) {
                ArrayList arrayList = new ArrayList(2);
                com.baidu.tieba.tbadkCore.data.q qVar = new com.baidu.tieba.tbadkCore.data.q();
                qVar.DV(0);
                qVar.ME(getString(R.string.all));
                arrayList.add(qVar);
                com.baidu.tieba.tbadkCore.data.q qVar2 = new com.baidu.tieba.tbadkCore.data.q();
                qVar2.DV(1);
                qVar2.ME(getString(R.string.host_name));
                arrayList.add(qVar2);
                this.iTg = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
                this.iTg.setNeedDayNight(false);
                this.iTg.setData(arrayList, this.mIsSeeHost ? 1 : 0);
                this.iTg.setVisibility(0);
                this.iTg.setOnSwitchChangeListener(this.iTL);
                o(this.iTh, 0);
                return;
            }
            o(this.iTg, 8);
            o(this.iTh, 8);
        }
    }

    public Map<String, ImageUrlData> csd() {
        return this.ehO;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public String getUserId() {
        return this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cse() {
        ImageUrlData imageUrlData;
        String str = (String) v.getItem(this.iTo, this.mIndex);
        if (this.ehO == null || str == null) {
            imageUrlData = null;
        } else {
            imageUrlData = this.ehO.get(str);
        }
        long j = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j == 0 ? this.mIndex + 1 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csf() {
        String str;
        if (this.iTo != null) {
            long cse = cse();
            String str2 = ("" + cse) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.iTA && cse() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new an("c13316").dh("obj_source", this.mFrom));
                this.iTA = true;
            }
            if (csg()) {
                csh();
            } else {
                Hl(str);
            }
            long j = cse - 1;
            yx(j > 0 ? (int) j : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csg() {
        if (this.iTC && this.iTv != null && this.iTv.crw()) {
            return this.iTn.getItemNum() != 1 && this.mIndex == this.iTn.getItemNum() + (-1);
        }
        return false;
    }

    private void Hl(String str) {
        this.mTitleView.setText(str);
        if (this.iTD && !this.iTE && this.iTg != null) {
            this.iTg.changeState(this.mIsSeeHost ? 1 : 0);
        }
    }

    private void csh() {
        this.mTitleView.setText("");
        o(this.iTg, 8);
        o(this.iTh, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        if (this.iTn == null) {
            this.iTn = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            this.iTn.init();
        }
        this.iTn.setIsFromCDN(this.egI);
        this.iTn.setIsCanDrag(this.egK);
        this.iTn.setIsBJHThread(this.iTF);
        this.iTn.setPageMargin(l.dip2px(getPageContext().getPageActivity(), 8.0f));
        this.iTn.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.iTn.setOnPageChangeListener(this.bGq);
        this.iTn.setUrlData(this.iTo);
        this.iTn.setAssistUrls(this.ehO);
        this.iTn.setOuterOnTouchListener(this.eiB);
        this.iTn.setItemOnclickListener(this.mOnClickListener);
        this.iTn.setItemOnLongClickListener(this.iTO);
        this.iTn.setCurrentItem(ciZ(), false);
        this.iTn.setOnScrollOutListener(this.iTP);
        this.iTv = new a(this.egI, this.iTC, getPageContext(), this.evm, this.ais);
        this.iTv.setDragToExitListener(this.eip);
        this.iTn.a(this.iTv);
        this.iTn.setOriImgSelectedCallback(this.egB);
        this.iTn.setDragToExitListener(this.eip);
        this.iTn.setUserId(this.mUserId);
        this.iTn.setViewPagerTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.21
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                    case 2:
                        ImageViewerActivity.this.iTs = ImageViewerActivity.this.iTt - motionEvent.getX() > 0.0f;
                        ImageViewerActivity.this.iTt = motionEvent.getX();
                        break;
                }
                return false;
            }
        });
        this.iTn.setShowBottomContainer(this.iTI);
        TiebaStatic.log(new an("c13340").dh("uid", this.mUserId).dh("post_id", this.ais).ag("obj_source", csi()));
    }

    private int csi() {
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

    private void bPK() {
        if (!this.iTE && this.iTg != null) {
            if (this.iTu == null) {
                this.iTu = new com.baidu.tieba.c.d(getPageContext(), this.iTg);
                this.iTu.cI(R.drawable.pic_sign_tip);
                this.iTu.cH(48);
                this.iTu.setUseDirectOffset(true);
                this.iTu.cJ(5000);
                this.iTu.sz(-l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.iTu.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ImageViewerActivity.this.csj();
                    }
                });
            }
            this.iTu.aA(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csj() {
        if (this.iTu != null) {
            this.iTu.Gu();
        }
    }

    public int ciZ() {
        int count = v.getCount(this.iTo);
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
        this.iTq = new i();
        boolean isLogin = com.baidu.tbadk.mutiprocess.f.isLogin();
        String bduss = com.baidu.tbadk.mutiprocess.f.getBduss();
        String tbs = com.baidu.tbadk.mutiprocess.f.getTbs();
        String stoken = com.baidu.tbadk.mutiprocess.f.getStoken();
        if (bundle != null) {
            this.iTF = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.iTo = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.evm = bundle.getString("fid");
            this.ais = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.fde = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.egI = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.iTH = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.iTC = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.egK = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.iTD = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.iSO = bundle.getString("source_rect_in_screen");
            this.iSQ = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.iTI = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.iSR = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
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
            this.iTG = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.iTE = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.iSS = bundle.getInt(IntentConfig.CARD_TYPE, 0);
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
                this.iTF = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.iTo = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.evm = intent.getStringExtra("fid");
                this.ais = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.fde = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.egI = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.iTH = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.iTC = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.egK = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.iTD = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.iTI = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.iSR = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.iTG = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.iTE = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                boolean booleanExtra = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                String stringExtra3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.iSO = intent.getStringExtra("source_rect_in_screen");
                this.iSQ = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.ehO = (Map) serializableExtra;
                }
                this.iSS = intent.getIntExtra(IntentConfig.CARD_TYPE, 0);
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
        this.iTq.b(bundle, getIntent());
        this.mCount = v.getCount(this.iTo);
        if (this.iSO != null) {
            String str = (String) v.getItem(this.iTo, this.mIndex);
            if (!StringUtils.isNull(str) && this.ehO != null && (imageUrlData = this.ehO.get(str)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.iSO);
            }
        }
        this.iSP = this.iTF ? null : d.Hi((String) v.getItem(this.iTo, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new an("c13337").dh("obj_type", "2"));
        } else {
            TiebaStatic.log(new an("c13337").dh("obj_type", "1"));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.iTF);
        bundle.putStringArrayList("url", this.iTo);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.evm);
        bundle.putString("tid", this.ais);
        bundle.putString("fname", this.fde);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.iTH);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.egK);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.iTD);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.iTC);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.iTI);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.iSR);
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
        bundle.putString("source_rect_in_screen", this.iSO);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.iTG);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.iTE);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.iSQ);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, com.baidu.tbadk.mutiprocess.f.isLogin());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, com.baidu.tbadk.mutiprocess.f.getBduss());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, com.baidu.tbadk.mutiprocess.f.getStoken());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, com.baidu.tbadk.mutiprocess.f.getTbs());
        this.iTq.ax(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.iTn.setCurrentItem(this.mIndex, false);
        SvgManager.aUW().a(this.gdY, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        if (this.iTn != null) {
            this.iTn.mS(i);
            int i2 = (this.iTn.bbz() || csg()) ? 8 : 0;
            o(this.iTg, i2);
            o(this.iTh, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csk() {
        if (csg()) {
            this.iTx = this.mNavigationBar.getVisibility() == 0;
            this.iTw = true;
        } else if (this.iTw) {
            this.mNavigationBar.setVisibility(this.iTx ? 0 : 8);
            this.iTw = false;
        }
    }

    private void yx(int i) {
        if (this.iTp != null) {
            ArrayList<AlaInfoData> crM = this.iTp.crM();
            if (crM != null && crM.size() > 0) {
                pW(true);
                b(crM.get(i % crM.size()));
                return;
            }
            pW(false);
        }
    }

    private void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null && alaInfoData.user_info != null) {
            b(this.iTi, alaInfoData.user_info.portrait);
            this.iTi.setAlaInfo(alaInfoData);
            this.iTi.setOnClickListener(this.iTQ);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                Hm(alaInfoData.tag);
            }
            TiebaStatic.log(new an("c13710").dh("fid", this.evm).dh("fname", this.fde).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", this.ais).dh("obj_param1", alaInfoData.user_info != null ? "" + alaInfoData.user_info.user_id : ""));
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
        if (this.iTl != z) {
            if (this.iTj != null) {
                if (z) {
                    this.iTj.setVisibility(0);
                    if (!this.iTj.isAnimating()) {
                        this.iTj.setSpeed(0.8f);
                        this.iTj.setRepeatCount(-1);
                        this.iTj.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.9
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageViewerActivity.this.iTj.playAnimation();
                            }
                        });
                    }
                } else {
                    this.iTj.setVisibility(8);
                    if (this.iTj.isAnimating()) {
                        this.iTj.cancelAnimation();
                    }
                }
            }
            if (this.iTi != null) {
                this.iTi.setVisibility(z ? 0 : 8);
            }
            this.iTl = z;
        }
    }

    private void yy(int i) {
        if (this.iTj != null) {
            if (i == 1) {
                this.iTj.setAnimation("live/card_live_bg_night.json");
            } else if (i == 4) {
                this.iTj.setAnimation("live/card_live_bg_black.json");
            } else {
                this.iTj.setAnimation("live/card_live_bg.json");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm(@NonNull final String str) {
        if (this.iTj != null) {
            this.iTj.post(new Runnable() { // from class: com.baidu.tieba.image.ImageViewerActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewerActivity.this.iTk != null) {
                        if (ImageViewerActivity.this.iTm == null || ImageViewerActivity.this.iTk == null || ImageViewerActivity.this.iTh == null || ImageViewerActivity.this.iTh.getVisibility() != 0) {
                            ImageViewerActivity.this.csl();
                            return;
                        }
                        ImageViewerActivity.this.iTk.Dx(str);
                        ImageViewerActivity.this.iTm = null;
                        return;
                    }
                    ImageViewerActivity.this.iTk = new com.baidu.tieba.c.d(ImageViewerActivity.this.getPageContext(), ImageViewerActivity.this.iTj);
                    ImageViewerActivity.this.iTk.cI(R.drawable.bg_tip_blue_up);
                    ImageViewerActivity.this.iTk.cH(32);
                    ImageViewerActivity.this.iTk.setUseDirectOffset(true);
                    ImageViewerActivity.this.iTk.sy(1);
                    ImageViewerActivity.this.iTk.sz(0);
                    ImageViewerActivity.this.iTk.cJ(3000);
                    ImageViewerActivity.this.iTk.c(new View.OnClickListener() { // from class: com.baidu.tieba.image.ImageViewerActivity.10.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ImageViewerActivity.this.csl();
                        }
                    });
                    if (ImageViewerActivity.this.iTh == null || ImageViewerActivity.this.iTh.getVisibility() == 0) {
                        ImageViewerActivity.this.iTk.Dx(str);
                        return;
                    }
                    ImageViewerActivity.this.iTm = str;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csl() {
        if (this.iTk != null) {
            this.iTk.Gu();
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
                return com.baidu.tbadk.m.e.bfv().getMaxCostFromServer();
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

    public boolean csm() {
        return this.iTF;
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
