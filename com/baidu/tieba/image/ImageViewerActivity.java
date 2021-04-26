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
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.view.SortSwitchButton;
import d.a.j0.g1.d;
import d.a.j0.q0.f2.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.j {
    public static final int MAX_ITEM_NUM = 400;
    public static final int PAGE_LIMIT = 2;
    public static final int PROFESSION_PERMISSION_TYPE_REPLY_FLOOR = 1;
    public static final int PROFESSION_PERMISSION_TYPE_REPLY_POST = 0;
    public TBLottieAnimationView alaUserPhotoAnimView;
    public View alaUserPhotoLayout;
    public HeadImageView alaUserPhotoView;
    public Map<String, ImageUrlData> assistUrls;
    public String cacheAlaTag;
    public d.a.j0.g1.k.d editorController;
    public String fromForumId;
    public SortSwitchButton hostAllSwitch;
    public d.a.j0.g1.k.a mAdBannerProxy;
    public d.a.j0.b0.e mAlaTipController;
    public View mBackLogo;
    public int mCardType;
    public ImageView mClose;
    public float mDonwX;
    public String mDragPicId;
    public String mFid;
    public String mFname;
    public String mFrom;
    public d.a.j0.g1.c mFunAdPageProvider;
    public d.a.j0.g1.d mGetImageHelper;
    public ArrayList<String> mImageUrls;
    public d.a.j0.g1.i mImageViewerStatisticController;
    public boolean mIsClick;
    public d.a.j0.g1.j mMoreDialogController;
    public NavigationBar mNavigationBar;
    public String mNid;
    public d.a.j0.b0.e mPictureTipController;
    public String mPostId;
    public d.a.j0.q0.f2.a.c mProfessionController;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    public int mSkinType;
    public String mSourceImageRectInScreen;
    public View mStatusBarView;
    public int mThreadType;
    public String mTid;
    public TextView mTitleView;
    public String mUserId;
    public MultiImageView mViewpager;
    public VoiceManager mVoiceManager;
    public LinearLayout replyToolRoot;
    public int skinTypeRecord;
    public boolean alaLiveIsLive = false;
    public int mIndex = -1;
    public int mCount = -1;
    public d.a.j0.g1.a mApPageProvier = null;
    public boolean isFunAdABTest = d.a.i0.b.d.D();
    public boolean mIsNavigationBarVisibilitySaved = false;
    public boolean mSavedNavigationBarVisibility = false;
    public int currentPosition = 0;
    public boolean mIsStaticLast = false;
    public boolean mIsShowAp = true;
    public boolean mIsCanDrag = true;
    public boolean mIsShowHost = true;
    public boolean mIsSeeHost = false;
    public boolean mIsFromAiApp = false;
    public boolean mIsBJHThread = false;
    public boolean mIsIdentifyImage = false;
    public boolean mIsGodreplyImage = false;
    public boolean mIsOrdinal = true;
    public boolean mIsCdn = false;
    public boolean mIsShowBottomContainer = true;
    public boolean mIsDynamicCard = false;
    public boolean mIsVideoWorksInfo = false;
    public CustomMessageListener hideNavbarListener = new k(2016496);
    public final CustomMessageListener mToHotTopicListener = new n(2016493);
    public DragImageView.h mDragToExitListener = new o();
    public View.OnClickListener onReplyButtonClickListener = new p();
    public UrlDragImageView.p mOriImgSelectedCallback = new q();
    public final SortSwitchButton.f onHostViewSwitchChangeListener = new u();
    public View.OnClickListener mOnClickListener = new b();
    public View.OnTouchListener mOuterOnTouchListener = new c();
    public View.OnLongClickListener mShowMenuListener = new d();
    public BaseViewPager.a mScrollOutListener = new e();
    public ViewPager.OnPageChangeListener mPageChangeListener = new f();
    public View.OnClickListener userPhotoOnClickListener = new g();
    public CustomMessageListener mThreadAgreeChangedListener = new l(2016528);
    public CustomMessageListener mPostAgreeChangedListener = new m(2016530);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageViewerActivity.this.dissmissPictureTip();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", ImageViewerActivity.this.mViewpager.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, ImageViewerActivity.this.mViewpager.getCurrentMaxIndex()));
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "1"));
            ImageViewerActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            if (action == 0) {
                ImageViewerActivity.this.mDonwX = motionEvent.getX();
                return false;
            } else if (action == 1 || action == 2 || action == 3) {
                ImageViewerActivity.this.mDonwX = motionEvent.getX();
                return false;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnLongClickListener {
        public d() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (d.a.i0.b.d.v()) {
                if (ImageViewerActivity.this.mMoreDialogController != null) {
                    ImageViewerActivity.this.mMoreDialogController.y();
                }
            } else if (ImageViewerActivity.this.mMoreDialogController != null) {
                ImageViewerActivity.this.mMoreDialogController.D();
                ImageViewerActivity.this.mMoreDialogController.E();
                ImageViewerActivity.this.mMoreDialogController.w(view);
            }
            TiebaStatic.log(new StatisticItem("c13269").param("uid", ImageViewerActivity.this.mUserId).param("fid", ImageViewerActivity.this.mFid).param("tid", ImageViewerActivity.this.mTid));
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BaseViewPager.a {
        public e() {
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i2) {
            if (i2 == 0) {
                ImageViewerActivity.this.mGetImageHelper.V();
            } else if (ImageViewerActivity.this.getCurrentOverAllIndex() == 1) {
            } else {
                ImageViewerActivity.this.mGetImageHelper.W();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public f() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            if (ImageViewerActivity.this.mImageUrls == null || ImageViewerActivity.this.mIndex >= ImageViewerActivity.this.mImageUrls.size()) {
                return;
            }
            ImageViewerActivity.this.mImageViewerStatisticController.e(i2, (String) ImageViewerActivity.this.mImageUrls.get(ImageViewerActivity.this.mIndex));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (i2 > ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i2;
            } else if (i2 < ImageViewerActivity.this.currentPosition) {
                ImageViewerActivity.this.currentPosition = i2;
            }
            DragImageView currentView = ImageViewerActivity.this.mViewpager != null ? ImageViewerActivity.this.mViewpager.getCurrentView() : null;
            boolean d0 = currentView != null ? currentView.d0() : false;
            if (ImageViewerActivity.this.getCurrentOverAllIndex() == 1 && d0) {
                ImageViewerActivity.this.setSwipeBackEnabled(true);
            } else {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            ImageViewerActivity.this.dismissAlaTip();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (ImageViewerActivity.this.mGetImageHelper != null && i2 > ImageViewerActivity.this.mViewpager.getItemNum() - 5) {
                ImageViewerActivity.this.mGetImageHelper.V();
            }
            if (ImageViewerActivity.this.isFunAdABTest && ImageViewerActivity.this.mFunAdPageProvider != null && ImageViewerActivity.this.mGetImageHelper != null && ImageViewerActivity.this.mViewpager != null) {
                ImageViewerActivity.this.mFunAdPageProvider.s(ImageViewerActivity.this.mGetImageHelper.Y(), ImageViewerActivity.this.mCount, i2, ImageViewerActivity.this.mTid, ImageViewerActivity.this.mFid);
                ImageViewerActivity.this.mFunAdPageProvider.v(i2);
            }
            if (ImageViewerActivity.this.mViewpager != null) {
                ImageViewerActivity.this.triggerBannerAd(i2);
            }
            ImageViewerActivity.this.mImageViewerStatisticController.c(ImageViewerActivity.this.mImageUrls, ImageViewerActivity.this.mIndex, i2);
            ImageViewerActivity.this.mIndex = i2;
            ImageViewerActivity.this.updateNavigationTitle();
            ImageViewerActivity.this.updateNavigationVisibility();
            ImageViewerActivity.this.updateClearScreenVisibility(i2);
            if (ImageViewerActivity.this.mImageViewerStatisticController.a() < ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.mImageViewerStatisticController.h(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.mImageViewerStatisticController.b() > ImageViewerActivity.this.mIndex) {
                ImageViewerActivity.this.mImageViewerStatisticController.i(ImageViewerActivity.this.mIndex);
            }
            if (ImageViewerActivity.this.checkIsAdvertPage()) {
                if (ImageViewerActivity.this.isFunAdABTest) {
                    if (ImageViewerActivity.this.mFunAdPageProvider != null) {
                        ImageViewerActivity.this.mFunAdPageProvider.q();
                    }
                } else if (ImageViewerActivity.this.mApPageProvier != null) {
                    ImageViewerActivity.this.mApPageProvier.e();
                }
            }
            if (ImageViewerActivity.this.mMoreDialogController != null) {
                ImageViewerActivity.this.mMoreDialogController.B();
            }
            if (ImageViewerActivity.this.editorController == null || ImageViewerActivity.this.mViewpager.getCurrentUrlDragImageView() == null) {
                return;
            }
            ImageViewerActivity.this.editorController.q(ImageViewerActivity.this.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.mGetImageHelper);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            if (!(view instanceof HeadImageView) || (alaInfo = ((HeadImageView) view).getAlaInfo()) == null) {
                return;
            }
            if (alaInfo.isChushou) {
                ImageViewerActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(d.a.i0.a.f.f47853a + "://" + d.a.i0.a.f.f47854b + d.a.i0.a.f.k + "?" + d.a.i0.a.f.E + "=" + alaInfo.thirdLiveType + "&" + d.a.i0.a.f.F + "=" + alaInfo.thirdRoomId)));
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
            StatisticItem param = new StatisticItem("c13711").param("fid", ImageViewerActivity.this.mFid).param("fname", ImageViewerActivity.this.mFname).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", ImageViewerActivity.this.mTid);
            String str = "";
            if (alaInfo.user_info != null) {
                str = "" + alaInfo.user_info.user_id;
            }
            TiebaStatic.log(param.param("obj_param1", str));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageViewerActivity.this.alaUserPhotoAnimView.playAnimation();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18405e;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerActivity.this.dismissAlaTip();
            }
        }

        public i(String str) {
            this.f18405e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ImageViewerActivity.this.mAlaTipController != null) {
                if (ImageViewerActivity.this.cacheAlaTag == null || ImageViewerActivity.this.mAlaTipController == null || ImageViewerActivity.this.alaUserPhotoLayout == null || ImageViewerActivity.this.alaUserPhotoLayout.getVisibility() != 0) {
                    ImageViewerActivity.this.dismissAlaTip();
                    return;
                }
                ImageViewerActivity.this.mAlaTipController.h0(this.f18405e);
                ImageViewerActivity.this.cacheAlaTag = null;
                return;
            }
            ImageViewerActivity imageViewerActivity = ImageViewerActivity.this;
            imageViewerActivity.mAlaTipController = new d.a.j0.b0.e(imageViewerActivity.getPageContext(), ImageViewerActivity.this.alaUserPhotoAnimView);
            ImageViewerActivity.this.mAlaTipController.c0(R.drawable.bg_tip_blue_up);
            ImageViewerActivity.this.mAlaTipController.N(32);
            ImageViewerActivity.this.mAlaTipController.d0(true);
            ImageViewerActivity.this.mAlaTipController.V(1);
            ImageViewerActivity.this.mAlaTipController.f0(0);
            ImageViewerActivity.this.mAlaTipController.M(3000);
            ImageViewerActivity.this.mAlaTipController.L(new a());
            if (ImageViewerActivity.this.alaUserPhotoLayout == null || ImageViewerActivity.this.alaUserPhotoLayout.getVisibility() == 0) {
                ImageViewerActivity.this.mAlaTipController.h0(this.f18405e);
                return;
            }
            ImageViewerActivity.this.cacheAlaTag = this.f18405e;
        }
    }

    /* loaded from: classes4.dex */
    public class j extends d.a.i0.k0.b {
        public j() {
        }

        @Override // d.a.i0.k0.b
        public int getMaxCost() {
            return d.a.i0.k0.e.b().c();
        }

        @Override // d.a.i0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            ImageViewerActivity.this.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
            ImageViewerActivity.this.dismissAlaTip();
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.d3.h0.e) || ImageViewerActivity.this.assistUrls == null || (agreeData = ((d.a.j0.d3.h0.e) customResponsedMessage.getData()).f53077b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : ImageViewerActivity.this.assistUrls.values()) {
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

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public m(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.j0.d3.h0.e) || ImageViewerActivity.this.assistUrls == null || (agreeData = ((d.a.j0.d3.h0.e) customResponsedMessage.getData()).f53077b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : ImageViewerActivity.this.assistUrls.values()) {
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

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public n(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.i0.t.m mVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.i0.t.m) || (mVar = (d.a.i0.t.m) customResponsedMessage.getData()) == null || StringUtils.isNull(mVar.f49905a)) {
                return;
            }
            d.a.i0.p0.b.i(mVar);
            if (StringUtils.isNull(mVar.f49907c)) {
                UrlManager.getInstance().dealOneLink(ImageViewerActivity.this.getPageContext(), new String[]{mVar.f49905a});
            } else {
                UrlManager.getInstance().dealOneLink(ImageViewerActivity.this.getPageContext(), new String[]{mVar.f49905a, mVar.f49907c});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements DragImageView.h {
        public o() {
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            ImageViewerActivity imageViewerActivity = ImageViewerActivity.this;
            imageViewerActivity.setViewVisibility(imageViewerActivity.mTitleView, 8);
            ImageViewerActivity imageViewerActivity2 = ImageViewerActivity.this;
            imageViewerActivity2.setViewVisibility(imageViewerActivity2.hostAllSwitch, 8);
            ImageViewerActivity imageViewerActivity3 = ImageViewerActivity.this;
            imageViewerActivity3.setViewVisibility(imageViewerActivity3.mBackLogo, 8);
            ImageViewerActivity imageViewerActivity4 = ImageViewerActivity.this;
            imageViewerActivity4.setViewVisibility(imageViewerActivity4.alaUserPhotoLayout, 8);
            if (ImageViewerActivity.this.mViewpager != null) {
                ImageViewerActivity.this.mViewpager.A(false);
            }
            ImageViewerActivity.this.dissmissPictureTip();
            ImageViewerActivity.this.dismissAlaTip();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", ImageViewerActivity.this.mViewpager.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, ImageViewerActivity.this.mViewpager.getCurrentMaxIndex()));
            ImageViewerActivity.this.finish();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            ImageViewerActivity imageViewerActivity = ImageViewerActivity.this;
            imageViewerActivity.setViewVisibility(imageViewerActivity.mTitleView, 0);
            ImageViewerActivity.this.mBackLogo.setVisibility(0);
            if (ImageViewerActivity.this.mViewpager == null || ImageViewerActivity.this.checkIsAdvertPage()) {
                return;
            }
            boolean t = ImageViewerActivity.this.mViewpager.t();
            if ("portrait".equals(ImageViewerActivity.this.mFrom) || t) {
                return;
            }
            ImageViewerActivity imageViewerActivity2 = ImageViewerActivity.this;
            imageViewerActivity2.setViewVisibility(imageViewerActivity2.hostAllSwitch, 0);
            ImageViewerActivity imageViewerActivity3 = ImageViewerActivity.this;
            imageViewerActivity3.setViewVisibility(imageViewerActivity3.alaUserPhotoLayout, 0);
            ImageViewerActivity imageViewerActivity4 = ImageViewerActivity.this;
            imageViewerActivity4.showAlaTip(imageViewerActivity4.cacheAlaTag);
            if (ImageViewerActivity.this.mIsShowBottomContainer) {
                ImageViewerActivity.this.mViewpager.A(true);
            } else {
                ImageViewerActivity.this.mViewpager.A(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class a implements c.d {
            public a() {
            }

            @Override // d.a.j0.q0.f2.a.c.d
            public void a(boolean z, int i2) {
            }

            @Override // d.a.j0.q0.f2.a.c.d
            public void b(boolean z) {
                if (!z || ImageViewerActivity.this.editorController == null || ImageViewerActivity.this.mViewpager.getCurrentUrlDragImageView() == null) {
                    return;
                }
                ImageViewerActivity.this.editorController.u(ImageViewerActivity.this.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.mGetImageHelper);
            }

            @Override // d.a.j0.q0.f2.a.c.d
            public void c(boolean z) {
            }
        }

        public p() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v28, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "3").param("post_id", ImageViewerActivity.this.mTid).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", ImageViewerActivity.this.mFid));
            if (d.a.i0.f0.f.a(ImageViewerActivity.this)) {
                if (ImageViewerActivity.this.mProfessionController == null) {
                    ImageViewerActivity imageViewerActivity = ImageViewerActivity.this;
                    imageViewerActivity.mProfessionController = new d.a.j0.q0.f2.a.c(imageViewerActivity.getPageContext());
                    ImageViewerActivity.this.mProfessionController.j(new a());
                }
                ImageViewerActivity.this.mProfessionController.k(((ImageViewerActivity.this.mViewpager == null || ImageViewerActivity.this.mViewpager.getCurrentUrlDragImageView() == null || ImageViewerActivity.this.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? 1 : ImageViewerActivity.this.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost) ^ 1);
                ImageViewerActivity.this.mProfessionController.g(ImageViewerActivity.this.mFid, d.a.c.e.m.b.f(ImageViewerActivity.this.mTid, 0L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements UrlDragImageView.p {
        public q() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.p
        public void a() {
            TiebaStatic.log(new StatisticItem("c10351").param("tid", ImageViewerActivity.this.mTid).param("obj_type", ImageViewerActivity.this.mFrom));
        }
    }

    /* loaded from: classes4.dex */
    public class r implements d.b {
        public r() {
        }

        @Override // d.a.j0.g1.d.b
        public void a(ArrayList<String> arrayList, int i2, int i3, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            if (ImageViewerActivity.this.mViewpager == null) {
                return;
            }
            if (ImageViewerActivity.this.mIsClick) {
                if (!z3) {
                    ImageViewerActivity.this.mViewpager.removeAllViews();
                    ImageViewerActivity.this.mIndex = 0;
                    ImageViewerActivity.this.initViewPager();
                    ImageViewerActivity imageViewerActivity = ImageViewerActivity.this;
                    imageViewerActivity.mIsSeeHost = !imageViewerActivity.mIsSeeHost;
                } else if (!ImageViewerActivity.this.mIsSeeHost) {
                    ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                }
            }
            ImageViewerActivity.this.mIsClick = false;
            if (ImageViewerActivity.this.hostAllSwitch != null) {
                ImageViewerActivity.this.hostAllSwitch.setEnabled(true);
            }
            ImageViewerActivity.this.hideProgressBar();
            if (z2 && ImageViewerActivity.this.mViewpager.getCurrentItem() <= 4) {
                int itemNum = ImageViewerActivity.this.mViewpager.getItemNum();
                ImageViewerActivity.this.mViewpager.setTempSize(itemNum + 100);
                ImageViewerActivity.this.mViewpager.setCurrentItem(itemNum + 90, false);
                ImageViewerActivity.this.mViewpager.setTempSize(0);
            }
            ImageViewerActivity.this.mViewpager.setUrlData(arrayList);
            ImageViewerActivity.this.mViewpager.setAssistUrls(ImageViewerActivity.this.assistUrls);
            ImageViewerActivity.this.mViewpager.setHasNext(z);
            if (ImageViewerActivity.this.isFunAdABTest) {
                int Y = ImageViewerActivity.this.mGetImageHelper.Y();
                if (ImageViewerActivity.this.mFunAdPageProvider != null) {
                    ImageViewerActivity.this.mFunAdPageProvider.w(ListUtils.getCount(arrayList), i3);
                    ImageViewerActivity.this.mFunAdPageProvider.s(Y, i3, ImageViewerActivity.this.mIndex, ImageViewerActivity.this.mTid, ImageViewerActivity.this.mFid);
                }
            } else if (advertAppInfo != null && arrayList != null && ImageViewerActivity.this.mApPageProvier != null) {
                AdvertAppInfo.t4.set(true);
                int E4 = advertAppInfo.E4();
                if (E4 == 0) {
                    ImageViewerActivity.this.mApPageProvier.h(advertAppInfo, arrayList.size());
                } else {
                    ImageViewerActivity.this.reportAdDiscardLog(advertAppInfo, E4);
                }
            }
            ImageViewerActivity.this.mViewpager.setNextTitle(str);
            if (i2 < 0 || i2 >= ImageViewerActivity.this.mViewpager.getItemNum()) {
                ImageViewerActivity.this.mViewpager.u(ImageViewerActivity.this.mViewpager.getCurrentItem());
            } else {
                ImageViewerActivity.this.mViewpager.setCurrentItem(i2, false);
            }
            if (i3 != 0) {
                ImageViewerActivity.this.mCount = i3;
            }
            if (arrayList != null && arrayList.size() >= 400 && ImageViewerActivity.this.mViewpager.getCurrentItem() > 200) {
                for (int i4 = 0; i4 < 200; i4++) {
                    arrayList.remove(0);
                }
                ImageViewerActivity.this.mViewpager.setUrlData(arrayList);
                ImageViewerActivity.this.mViewpager.setCurrentItem(ImageViewerActivity.this.mViewpager.getCurrentItem() - 200, false);
            }
            if (ImageViewerActivity.this.getCurrentOverAllIndex() != 1) {
                ImageViewerActivity.this.setSwipeBackEnabled(false);
            }
            if (ImageViewerActivity.this.isFunAdABTest) {
                d(arrayList, i3);
            } else {
                c(arrayList, advertAppInfo);
            }
            ImageViewerActivity.this.updateNavigationTitle();
            if (ImageViewerActivity.this.editorController != null && ImageViewerActivity.this.mViewpager.getCurrentUrlDragImageView() != null) {
                ImageViewerActivity.this.editorController.q(ImageViewerActivity.this.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData(), ImageViewerActivity.this.mGetImageHelper);
            }
            ImageViewerActivity imageViewerActivity2 = ImageViewerActivity.this;
            imageViewerActivity2.triggerBannerAd(imageViewerActivity2.mViewpager.getCurrentItem());
        }

        @Override // d.a.j0.g1.d.b
        public void b(int i2, String str) {
            ImageViewerActivity.this.mIsClick = false;
            if (ImageViewerActivity.this.hostAllSwitch != null) {
                if (ImageViewerActivity.this.hostAllSwitch.getState() != ImageViewerActivity.this.mIsSeeHost && TextUtils.isEmpty(str)) {
                    ImageViewerActivity.this.showToast(R.string.image_view_change_img_error);
                }
                ImageViewerActivity.this.hostAllSwitch.u(ImageViewerActivity.this.mIsSeeHost ? 1 : 0);
                ImageViewerActivity.this.hostAllSwitch.setEnabled(true);
            }
            ImageViewerActivity.this.hideProgressBar();
            ImageViewerActivity.this.showToast(str);
            if (i2 == 40) {
                if (ImageViewerActivity.this.mImageUrls != null) {
                    ImageViewerActivity imageViewerActivity = ImageViewerActivity.this;
                    imageViewerActivity.mCount = imageViewerActivity.mImageUrls.size();
                }
                ImageViewerActivity.this.updateNavigationTitle();
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            if (ImageViewerActivity.this.mApPageProvier != null && advertAppInfo != null && arrayList != null) {
                int E4 = advertAppInfo.E4();
                if (E4 != 0) {
                    ImageViewerActivity.this.reportAdDiscardLog(advertAppInfo, E4);
                    return;
                }
                ImageViewerActivity.this.mApPageProvier.h(advertAppInfo, arrayList.size());
                if (ImageViewerActivity.this.mApPageProvier.d()) {
                    ImageViewerActivity.this.setAddSize(1);
                    TiebaStatic.log(d.a.j0.c3.a.h("a008", "common_fill", true, 1));
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
                return;
            }
            ImageViewerActivity.this.setAddSize(0);
        }

        public final void d(ArrayList<String> arrayList, int i2) {
            if (ImageViewerActivity.this.mFunAdPageProvider != null && arrayList != null) {
                if (ImageViewerActivity.this.mFunAdPageProvider.n()) {
                    ImageViewerActivity.this.mFunAdPageProvider.w(ListUtils.getCount(arrayList), i2);
                    ImageViewerActivity.this.setAddSize(1);
                    return;
                }
                ImageViewerActivity.this.setAddSize(0);
                return;
            }
            ImageViewerActivity.this.setAddSize(0);
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnSystemUiVisibilityChangeListener {
        public s() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            if ((i2 & 4) == 0) {
                ImageViewerActivity.this.setFullScreen();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImageViewerActivity.this.isFunAdABTest && ImageViewerActivity.this.checkIsAdvertPage() && ImageViewerActivity.this.mFunAdPageProvider.o()) {
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", "a008").eventStat();
            }
            ImageViewerActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class u implements SortSwitchButton.f {
        public u() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            if (d.a.c.e.p.j.A()) {
                ImageViewerActivity.this.mIsClick = true;
                if (ImageViewerActivity.this.hostAllSwitch != null) {
                    ImageViewerActivity.this.hostAllSwitch.setEnabled(false);
                }
                String a2 = d.a.j0.g1.b.a((String) ListUtils.getItem(ImageViewerActivity.this.mImageUrls, ImageViewerActivity.this.mIndex));
                ImageViewerActivity imageViewerActivity = ImageViewerActivity.this;
                imageViewerActivity.initImageHelper(a2, !imageViewerActivity.mIsSeeHost, true);
                TiebaStatic.log(new StatisticItem("c13857").param("obj_type", ImageViewerActivity.this.mIsSeeHost ? 7 : 8).param("post_id", ImageViewerActivity.this.mTid).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", ImageViewerActivity.this.mFid));
                return true;
            }
            ImageViewerActivity.this.showToast(R.string.neterror);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIsAdvertPage() {
        d.a.j0.g1.a aVar;
        d.a.j0.g1.c cVar;
        return this.isFunAdABTest ? this.mIsShowAp && (cVar = this.mFunAdPageProvider) != null && cVar.m() && this.mViewpager.getItemNum() != 1 && this.mIndex == this.mViewpager.getItemNum() - 1 : this.mIsShowAp && (aVar = this.mApPageProvier) != null && aVar.d() && this.mViewpager.getItemNum() != 1 && this.mIndex == this.mViewpager.getItemNum() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAlaTip() {
        d.a.j0.b0.e eVar = this.mAlaTipController;
        if (eVar != null) {
            eVar.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dissmissPictureTip() {
        d.a.j0.b0.e eVar = this.mPictureTipController;
        if (eVar != null) {
            eVar.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getCurrentOverAllIndex() {
        String str = (String) ListUtils.getItem(this.mImageUrls, this.mIndex);
        Map<String, ImageUrlData> map = this.assistUrls;
        ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
        long j2 = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
        return j2 == 0 ? this.mIndex + 1 : j2;
    }

    private void handleUserAlaLiveLayout(AlaInfoData alaInfoData) {
        AlaUserInfoData alaUserInfoData;
        HeadImageView headImageView;
        if (alaInfoData == null || (alaUserInfoData = alaInfoData.user_info) == null || (headImageView = this.alaUserPhotoView) == null) {
            return;
        }
        startLoadPortrait(headImageView, alaUserInfoData.portrait);
        this.alaUserPhotoView.setAlaInfo(alaInfoData);
        this.alaUserPhotoView.setOnClickListener(this.userPhotoOnClickListener);
        if (!TextUtils.isEmpty(alaInfoData.tag)) {
            showAlaTip(alaInfoData.tag);
        }
        StatisticItem param = new StatisticItem("c13710").param("fid", this.mFid).param("fname", this.mFname).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.mTid);
        String str = "";
        if (alaInfoData.user_info != null) {
            str = "" + alaInfoData.user_info.user_id;
        }
        TiebaStatic.log(param.param("obj_param1", str));
    }

    private void handleUserAlaLiveSkinType(int i2) {
        TBLottieAnimationView tBLottieAnimationView = this.alaUserPhotoAnimView;
        if (tBLottieAnimationView != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    private void handleUserAlaLiveState(boolean z) {
        if (this.alaLiveIsLive != z) {
            TBLottieAnimationView tBLottieAnimationView = this.alaUserPhotoAnimView;
            if (tBLottieAnimationView != null) {
                if (z) {
                    tBLottieAnimationView.setVisibility(0);
                    if (!this.alaUserPhotoAnimView.isAnimating()) {
                        this.alaUserPhotoAnimView.setSpeed(0.8f);
                        this.alaUserPhotoAnimView.setRepeatCount(-1);
                        this.alaUserPhotoAnimView.post(new h());
                    }
                } else {
                    tBLottieAnimationView.setVisibility(8);
                    if (this.alaUserPhotoAnimView.isAnimating()) {
                        this.alaUserPhotoAnimView.cancelAnimation();
                    }
                }
            }
            HeadImageView headImageView = this.alaUserPhotoView;
            if (headImageView != null) {
                headImageView.setVisibility(z ? 0 : 8);
            }
            this.alaLiveIsLive = z;
        }
    }

    private void initBackView() {
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBackLogo = addSystemImageButton;
        addSystemImageButton.setOnClickListener(new t());
        this.mClose = (ImageView) this.mBackLogo.findViewById(R.id.widget_navi_back_button);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mClose, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mBackLogo.setVisibility(0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v7, resolved type: java.util.Map<java.lang.String, com.baidu.tbadk.coreExtra.view.ImageUrlData> */
    /* JADX WARN: Multi-variable type inference failed */
    private void initData(Bundle bundle) {
        boolean z;
        String str;
        String str2;
        String str3;
        Map<String, ImageUrlData> map;
        ImageUrlData imageUrlData;
        this.mImageViewerStatisticController = new d.a.j0.g1.i();
        boolean e2 = d.a.i0.f0.f.e();
        String b2 = d.a.i0.f0.f.b();
        String d2 = d.a.i0.f0.f.d();
        String c2 = d.a.i0.f0.f.c();
        if (bundle != null) {
            this.mIsBJHThread = bundle.getBoolean(ImageViewerConfig.IS_BJH);
            this.mImageUrls = bundle.getStringArrayList("url");
            this.mIndex = bundle.getInt("index", -1);
            this.mFid = bundle.getString("fid");
            this.mTid = bundle.getString("tid");
            this.mNid = bundle.getString("nid");
            this.mFname = bundle.getString("fname");
            this.mPostId = bundle.getString("post_id");
            this.mIsCdn = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            this.mIsOrdinal = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
            this.mIsShowAp = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
            this.mUserId = bundle.getString("user_id");
            this.mFrom = bundle.getString("from");
            this.mIsCanDrag = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
            this.mIsShowHost = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
            this.mThreadType = bundle.getInt("thread_type");
            this.mIsSeeHost = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
            Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
            this.mSourceImageRectInScreen = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
            this.mIsGodreplyImage = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
            boolean z2 = bundle.getBoolean(ImageViewerConfig.IS_LOGIN);
            String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
            String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
            String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
            this.mIsShowBottomContainer = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
            this.mIsDynamicCard = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
            if (serializable instanceof Map) {
                this.assistUrls = new ConcurrentHashMap();
                for (Map.Entry entry : ((Map) serializable).entrySet()) {
                    if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                        try {
                            this.assistUrls.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            this.mIsIdentifyImage = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
            this.mIsFromAiApp = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
            this.mCardType = bundle.getInt("card_type", 0);
            this.mRecomSource = bundle.getString("recom_source");
            this.mRecomAbTag = bundle.getString("ab_tag");
            this.mRecomWeight = bundle.getString("weight");
            this.mRecomExtra = bundle.getString("extra");
            this.fromForumId = bundle.getString("from_forum_id");
            this.mSkinType = bundle.getInt("skin_type");
            this.mIsVideoWorksInfo = bundle.getBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
            z = z2;
            str = string;
            str2 = string2;
            str3 = string3;
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.mIsBJHThread = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                this.mImageUrls = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.mFid = intent.getStringExtra("fid");
                this.mTid = intent.getStringExtra("tid");
                this.mNid = intent.getStringExtra("nid");
                this.mFname = intent.getStringExtra("fname");
                this.mPostId = intent.getStringExtra("post_id");
                this.mIsCdn = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                this.mIsOrdinal = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                this.mIsShowAp = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                this.mUserId = intent.getStringExtra("user_id");
                this.mFrom = intent.getStringExtra("from");
                this.mIsCanDrag = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                this.mIsShowHost = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                this.mIsSeeHost = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                this.mThreadType = intent.getIntExtra("thread_type", 0);
                this.mIsShowBottomContainer = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.mIsDynamicCard = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                this.mIsIdentifyImage = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.mIsFromAiApp = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                z = intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false);
                str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                str3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                str2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                this.mSourceImageRectInScreen = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.mIsGodreplyImage = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                if (serializableExtra instanceof Map) {
                    this.assistUrls = (Map) serializableExtra;
                }
                this.mCardType = intent.getIntExtra("card_type", 0);
                this.mRecomSource = intent.getStringExtra("recom_source");
                this.mRecomAbTag = intent.getStringExtra("ab_tag");
                this.mRecomWeight = intent.getStringExtra("weight");
                this.mRecomExtra = intent.getStringExtra("extra");
                this.fromForumId = intent.getStringExtra("from_forum_id");
                this.mSkinType = intent.getIntExtra("skin_type", 0);
                this.mIsVideoWorksInfo = intent.getBooleanExtra(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
            } else {
                z = e2;
                str = b2;
                str2 = d2;
                str3 = c2;
            }
        }
        d.a.i0.f0.f.h(z);
        d.a.i0.f0.f.g(str);
        d.a.i0.f0.f.i(str3);
        d.a.i0.f0.f.j(str2);
        this.mImageViewerStatisticController.d(bundle, getIntent());
        this.mCount = ListUtils.getCount(this.mImageUrls);
        if (this.mSourceImageRectInScreen != null) {
            String str4 = (String) ListUtils.getItem(this.mImageUrls, this.mIndex);
            if (!StringUtils.isNull(str4) && (map = this.assistUrls) != null && (imageUrlData = map.get(str4)) != null) {
                imageUrlData.setSourceImageRectInScreen(this.mSourceImageRectInScreen);
            }
        }
        this.mDragPicId = this.mIsBJHThread ? null : d.a.j0.g1.b.a((String) ListUtils.getItem(this.mImageUrls, this.mIndex));
        if (this.mIsSeeHost) {
            TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
        } else {
            TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
        }
    }

    private void initEditor() {
        this.replyToolRoot = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
        d.a.j0.g1.k.d dVar = new d.a.j0.g1.k.d(getPageContext(), this.replyToolRoot);
        this.editorController = dVar;
        dVar.r(this.fromForumId);
        this.editorController.s(this.mSkinType);
        this.editorController.m(this.mSkinType);
    }

    private void initHostView() {
        if (this.mIsBJHThread || this.mIsFromAiApp || this.mIsVideoWorksInfo) {
            return;
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
        this.alaUserPhotoLayout = addCustomView.findViewById(R.id.view_user_photo);
        this.alaUserPhotoView = (HeadImageView) addCustomView.findViewById(R.id.normal_user_photo);
        this.alaUserPhotoAnimView = (TBLottieAnimationView) addCustomView.findViewById(R.id.user_living_lottie);
        this.alaUserPhotoView.setIsRound(true);
        this.alaUserPhotoView.setPlaceHolder(1);
        if (this.mIsShowHost) {
            ArrayList arrayList = new ArrayList(2);
            d.a.j0.d3.h0.r rVar = new d.a.j0.d3.h0.r();
            rVar.c(0);
            rVar.d(getString(R.string.all));
            arrayList.add(rVar);
            d.a.j0.d3.h0.r rVar2 = new d.a.j0.d3.h0.r();
            rVar2.c(1);
            rVar2.d(getString(R.string.host_name));
            arrayList.add(rVar2);
            SortSwitchButton sortSwitchButton = (SortSwitchButton) addCustomView.findViewById(R.id.host_all_switch_btn);
            this.hostAllSwitch = sortSwitchButton;
            sortSwitchButton.setNeedDayNight(false);
            this.hostAllSwitch.setData(arrayList, this.mIsSeeHost ? 1 : 0);
            this.hostAllSwitch.setVisibility(0);
            this.hostAllSwitch.setOnSwitchChangeListener(this.onHostViewSwitchChangeListener);
            setViewVisibility(this.alaUserPhotoLayout, 0);
            return;
        }
        setViewVisibility(this.hostAllSwitch, 8);
        setViewVisibility(this.alaUserPhotoLayout, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initImageHelper(String str, boolean z, boolean z2) {
        d.a.j0.g1.d dVar = new d.a.j0.g1.d(this.mImageUrls, this.assistUrls, this.mFid, this.mFname, this.mTid, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.mCardType, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
        this.mGetImageHelper = dVar;
        dVar.h0(this.mSourceImageRectInScreen);
        this.mGetImageHelper.f0(this.mIsOrdinal);
        this.mGetImageHelper.g0(z);
        this.mGetImageHelper.Z(this.mDragPicId);
        this.mGetImageHelper.c0(this.mIsGodreplyImage);
        this.mGetImageHelper.e0(this.mPostId);
        this.mGetImageHelper.b0(this.mIsDynamicCard);
        this.mGetImageHelper.d0(new r());
        this.mGetImageHelper.a0(true);
        this.mGetImageHelper.V();
    }

    private void initNavigationBar() {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        this.mNavigationBar.setClickable(false);
        initBackView();
        initHostView();
        TextView textView = new TextView(this);
        this.mTitleView = textView;
        textView.setPadding(d.a.c.e.p.l.g(this, R.dimen.tbds15), 0, 0, 0);
        this.mTitleView.setGravity(17);
        this.mTitleView.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
        this.mTitleView.setTextSize(0, d.a.c.e.p.l.g(this, R.dimen.tbds44));
        d.a.i0.r.u.c.d(this.mTitleView).t(R.array.S_O_X001);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
        if (d.a.j0.g1.b.b((String) ListUtils.getItem(this.mImageUrls, this.mIndex))) {
            this.mNavigationBar.setVisibility(0);
        }
    }

    private void initStatusBarView() {
        if (DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.statusbar_view);
            this.mStatusBarView = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void initUi() {
        initNavigationBar();
        this.mMoreDialogController = new d.a.j0.g1.j(this);
        initViewPager();
        this.mMoreDialogController.v(this.mViewpager);
        updateNavigationTitle();
        showGuideTip();
        initStatusBarView();
        initEditor();
        d.a.j0.g1.i iVar = this.mImageViewerStatisticController;
        ArrayList<String> arrayList = this.mImageUrls;
        int i2 = this.mIndex;
        iVar.c(arrayList, i2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        MultiImageView multiImageView = this.mViewpager;
        if (multiImageView == null) {
            this.mViewpager = (MultiImageView) findViewById(R.id.viewpager);
        } else {
            multiImageView.q();
        }
        this.mViewpager.setIsFromCDN(this.mIsCdn);
        this.mViewpager.setIsCanDrag(this.mIsCanDrag);
        this.mViewpager.setPageMargin(d.a.c.e.p.l.e(getPageContext().getPageActivity(), 8.0f));
        this.mViewpager.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
        this.mViewpager.setOnPageChangeListener(this.mPageChangeListener);
        this.mViewpager.setUrlData(this.mImageUrls);
        this.mViewpager.setAssistUrls(this.assistUrls);
        this.mViewpager.setOuterOnTouchListener(this.mOuterOnTouchListener);
        this.mViewpager.setItemOnclickListener(this.mOnClickListener);
        this.mViewpager.setItemOnLongClickListener(this.mShowMenuListener);
        this.mViewpager.setCurrentItem(calCurrentIndex(), false);
        this.mViewpager.setOnScrollOutListener(this.mScrollOutListener);
        if (this.isFunAdABTest) {
            d.a.j0.g1.c cVar = new d.a.j0.g1.c(this, this.mIsShowAp);
            this.mFunAdPageProvider = cVar;
            cVar.u(this.mDragToExitListener);
            this.mViewpager.k(this.mFunAdPageProvider);
        } else {
            d.a.j0.g1.a aVar = new d.a.j0.g1.a(this.mIsCdn, this.mIsShowAp, getPageContext(), this.mFid, this.mTid);
            this.mApPageProvier = aVar;
            aVar.g(this.mDragToExitListener);
            this.mViewpager.k(this.mApPageProvier);
        }
        this.mViewpager.setOriImgSelectedCallback(this.mOriImgSelectedCallback);
        this.mViewpager.setDragToExitListener(this.mDragToExitListener);
        this.mViewpager.setUserId(this.mUserId);
        this.mViewpager.setShowBottomContainer(this.mIsShowBottomContainer);
        this.mViewpager.setOnShareImageListener(this.mMoreDialogController);
        this.mViewpager.setOnDownloadImageListener(this.mMoreDialogController);
        this.mViewpager.setOnReplyClickListener(this.onReplyButtonClickListener);
        TiebaStatic.log(new StatisticItem("c13340").param("uid", this.mUserId).param("post_id", this.mTid).param("obj_source", transformValForFrom()));
    }

    private void refreshCloseIcon() {
        if (this.isFunAdABTest && checkIsAdvertPage()) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mClose, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mClose, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAdDiscardLog(AdvertAppInfo advertAppInfo, int i2) {
        d.a.j0.s2.h0.c b2 = d.a.j0.s2.h0.h.b(advertAppInfo, 5, 0);
        b2.k(i2);
        d.a.j0.s2.h0.e.b().d(b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        getWindow().getDecorView().setSystemUiVisibility(1284);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisibility(View view, int i2) {
        if (view != null) {
            view.clearAnimation();
            view.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlaTip(@NonNull String str) {
        TBLottieAnimationView tBLottieAnimationView = this.alaUserPhotoAnimView;
        if (tBLottieAnimationView == null) {
            return;
        }
        tBLottieAnimationView.post(new i(str));
    }

    private void showGuideTip() {
        if (this.mIsFromAiApp || this.hostAllSwitch == null) {
            return;
        }
        if (this.mPictureTipController == null) {
            d.a.j0.b0.e eVar = new d.a.j0.b0.e(getPageContext(), this.hostAllSwitch);
            this.mPictureTipController = eVar;
            eVar.c0(R.drawable.pic_sign_tip);
            this.mPictureTipController.N(48);
            this.mPictureTipController.d0(true);
            this.mPictureTipController.M(5000);
            this.mPictureTipController.f0(-d.a.c.e.p.l.g(getPageContext().getPageActivity(), R.dimen.tbds26));
            this.mPictureTipController.L(new a());
        }
        this.mPictureTipController.i0(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
    }

    private void startLoadPortrait(TbImageView tbImageView, @NonNull String str) {
        if (tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = " ";
        }
        if (str.toLowerCase().startsWith("http")) {
            tbImageView.V(str, 10, false);
        } else {
            tbImageView.V(str, 12, false);
        }
    }

    private int transformValForFrom() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerBannerAd(int i2) {
        if (this.mAdBannerProxy == null) {
            AdvertAppInfo.t4.set(true);
            this.mAdBannerProxy = new d.a.j0.g1.k.a((ViewStub) findViewById(R.id.ad_banner_view_stub), getPageContext());
        }
        this.mAdBannerProxy.c(this.mViewpager, this.mIsSeeHost, i2, checkIsAdvertPage(), i2 < this.mImageUrls.size() ? this.mImageUrls.get(i2) : "", this.mCount, this.mFid, this.mFname, this.mTid);
    }

    private void updateAlaLiveLayout(int i2) {
        d.a.j0.g1.d dVar = this.mGetImageHelper;
        if (dVar != null) {
            ArrayList<AlaInfoData> T = dVar.T();
            if (T != null && T.size() > 0) {
                handleUserAlaLiveState(true);
                handleUserAlaLiveLayout(T.get(i2 % T.size()));
                return;
            }
            handleUserAlaLiveState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateClearScreenVisibility(int i2) {
        MultiImageView multiImageView = this.mViewpager;
        if (multiImageView == null) {
            return;
        }
        multiImageView.l(i2);
        int i3 = (this.mViewpager.t() || checkIsAdvertPage()) ? 8 : 0;
        setViewVisibility(this.hostAllSwitch, i3);
        setViewVisibility(this.alaUserPhotoLayout, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigationTitle() {
        String str;
        if (this.mImageUrls != null) {
            long currentOverAllIndex = getCurrentOverAllIndex();
            String str2 = ("" + currentOverAllIndex) + "/";
            if (this.mCount > 0) {
                str = str2 + this.mCount;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.mFrom != null && !this.mIsStaticLast && getCurrentOverAllIndex() == this.mCount && (this.mFrom.equals("frs") || this.mFrom.equals("index"))) {
                TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.mFrom));
                this.mIsStaticLast = true;
            }
            if (checkIsAdvertPage()) {
                updateNavigationTitleAdvert();
            } else {
                updateNavigationTitlePic(str);
            }
            long j2 = currentOverAllIndex - 1;
            updateAlaLiveLayout(j2 > 0 ? (int) j2 : 0);
        }
    }

    private void updateNavigationTitleAdvert() {
        this.mTitleView.setText("");
        setViewVisibility(this.hostAllSwitch, 8);
        setViewVisibility(this.alaUserPhotoLayout, 8);
    }

    private void updateNavigationTitlePic(String str) {
        SortSwitchButton sortSwitchButton;
        this.mTitleView.setText(str);
        if (this.mIsShowHost && !this.mIsFromAiApp && (sortSwitchButton = this.hostAllSwitch) != null) {
            sortSwitchButton.u(this.mIsSeeHost ? 1 : 0);
        }
        d.a.i0.r.u.c.d(this.mTitleView).t(R.array.S_O_X001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigationVisibility() {
        if (checkIsAdvertPage()) {
            this.mSavedNavigationBarVisibility = this.mNavigationBar.getVisibility() == 0;
            this.mIsNavigationBarVisibilitySaved = true;
        } else if (this.mIsNavigationBarVisibilitySaved) {
            this.mNavigationBar.setVisibility(this.mSavedNavigationBarVisibility ? 0 : 8);
            this.mIsNavigationBarVisibilitySaved = false;
        }
        refreshCloseIcon();
    }

    public int calCurrentIndex() {
        int count = ListUtils.getCount(this.mImageUrls);
        if (count > 0) {
            int i2 = this.mIndex;
            if (i2 >= count) {
                this.mIndex = count - 1;
            } else if (i2 < 0) {
                this.mIndex = 0;
            }
        } else {
            this.mIndex = 0;
        }
        return this.mIndex;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
        if (d.a.i0.z0.l.a()) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
    }

    public Map<String, ImageUrlData> getAssistUrls() {
        return this.assistUrls;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a008";
    }

    public String getFrom() {
        return this.mFrom;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (d.a.c.e.p.k.isEmpty(this.mTid)) {
            return 0L;
        }
        return d.a.c.e.m.b.f(this.mTid, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.i0.k0.d getPageStayDurationItem() {
        d.a.i0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.q(d.a.c.e.m.b.f(this.mFid, 0L));
            pageStayDurationItem.y(d.a.c.e.m.b.f(this.mTid, 0L));
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.n(TbadkCoreApplication.getInst().getAdAdSense().r);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.i0.k0.a
    public d.a.i0.k0.b getPageStayFilter() {
        return new j();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    public String getUserId() {
        return this.mUserId;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    public boolean isIsBJHThread() {
        return this.mIsBJHThread;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.editorController.l(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        this.mViewpager.setBackgroundColor(-16777216);
        this.mViewpager.y(i2);
        super.onChangeSkinType(i2);
        this.skinTypeRecord = i2;
        UtilHelper.changeStatusBarIconAndTextColor(true, this);
        handleUserAlaLiveSkinType(i2);
        d.a.j0.g1.j jVar = this.mMoreDialogController;
        if (jVar != null) {
            jVar.x();
        }
        d.a.j0.g1.k.d dVar = this.editorController;
        if (dVar != null) {
            dVar.m(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mViewpager.setCurrentItem(this.mIndex, false);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mClose, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 28 && TbSingleton.getInstance().isNotchScreen(this)) {
            setUseStyleImmersiveSticky(false);
        }
        super.onCreate(bundle);
        d.a.i0.f0.h.f().g(TbadkCoreApplication.getInst());
        this.skinTypeRecord = TbadkCoreApplication.getInst().getSkinType();
        setSwipeBackEnabled(false);
        TbadkCoreApplication.getInst().addRemoteActivity(this);
        initData(bundle);
        setContentView(R.layout.image_activity_2);
        initUi();
        initImageHelper(this.mDragPicId, this.mIsSeeHost, false);
        registerListener(this.mToHotTopicListener);
        registerListener(this.hideNavbarListener);
        registerListener(this.mThreadAgreeChangedListener);
        registerListener(this.mPostAgreeChangedListener);
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onCreate(getPageContext());
        if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
            d.a.j0.p3.c.b(1, getWindow().getAttributes(), getWindow());
        }
        if (!TbSingleton.getInstance().hasDownloadEmotion() && d.a.c.e.p.j.H() && TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            TbSingleton.getInstance().setHasDownloadEmotion(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        MessageManager.getInstance().unRegisterListener(this.mToHotTopicListener);
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        d.a.i0.a0.c.k().r();
        d.a.j0.g1.i iVar = this.mImageViewerStatisticController;
        ArrayList<String> arrayList = this.mImageUrls;
        int i2 = this.mIndex;
        iVar.c(arrayList, i2, i2);
        this.mImageViewerStatisticController.g();
        d.a.j0.g1.a aVar = this.mApPageProvier;
        String c2 = aVar != null ? aVar.c() : "";
        d.a.j0.g1.d dVar = this.mGetImageHelper;
        if (dVar != null) {
            str = dVar.U();
            str2 = this.mGetImageHelper.X();
        } else {
            str = null;
            str2 = null;
        }
        this.mImageViewerStatisticController.j(this.mViewpager.getPageCount(), c2, this.mFid, this.mTid, str, str2);
        d.a.j0.g1.j jVar = this.mMoreDialogController;
        if (jVar != null) {
            jVar.A();
        }
        this.mViewpager.v();
        this.editorController.n();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.a.i0.v.d.j().h(13);
        TbadkCoreApplication.getInst().setSkinTypeValue(this.skinTypeRecord);
        dissmissPictureTip();
        dismissAlaTip();
        d.a.j0.g1.a aVar2 = this.mApPageProvier;
        if (aVar2 != null) {
            aVar2.f();
        }
        d.a.j0.g1.k.a aVar3 = this.mAdBannerProxy;
        if (aVar3 != null) {
            aVar3.b();
        }
        d.a.j0.g1.c cVar = this.mFunAdPageProvider;
        if (cVar != null) {
            cVar.r();
        }
        d.a.i0.f0.h.i(new PrePageKeyEvent(getCurrentPageKey()));
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mViewpager.w();
        BdUniqueId uniqueId = getUniqueId();
        long f2 = d.a.c.e.m.b.f(this.mTid, 0L);
        if (uniqueId != null && f2 > 0) {
            d.a.i0.a.r.f(uniqueId.getId(), f2);
        }
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        this.editorController.o();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mViewpager.x();
        this.mIsLogin = d.a.i0.f0.f.e();
        BdUniqueId uniqueId = getUniqueId();
        long f2 = d.a.c.e.m.b.f(this.mTid, 0L);
        if (uniqueId != null && f2 > 0) {
            d.a.i0.a.r.j(d.a.i0.a.b.a0, uniqueId.getId(), f2);
        }
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        this.editorController.p();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(ImageViewerConfig.IS_BJH, this.mIsBJHThread);
        bundle.putStringArrayList("url", this.mImageUrls);
        bundle.putInt("index", this.mIndex);
        bundle.putString("fid", this.mFid);
        bundle.putString("tid", this.mTid);
        bundle.putString("fname", this.mFname);
        bundle.putString("post_id", this.mPostId);
        bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
        bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.mIsOrdinal);
        bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.mIsCanDrag);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.mIsShowHost);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.mIsShowAp);
        bundle.putString("user_id", this.mUserId);
        bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.mIsShowBottomContainer);
        bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.mIsDynamicCard);
        Map<String, ImageUrlData> map = this.assistUrls;
        if (map instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImageUrlData> entry : this.assistUrls.entrySet()) {
                if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                    try {
                        hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
        } else if (map instanceof ConcurrentHashMap) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map.Entry<String, ImageUrlData> entry2 : this.assistUrls.entrySet()) {
                if (entry2 != null && (entry2.getValue() instanceof ImageUrlData) && (entry2.getKey() instanceof String)) {
                    try {
                        concurrentHashMap.put(entry2.getKey(), OrmObject.jsonStrWithObject(entry2.getValue()));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, concurrentHashMap);
        }
        bundle.putString("from", this.mFrom);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.mIsSeeHost);
        bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.mSourceImageRectInScreen);
        bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.mIsIdentifyImage);
        bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.mIsFromAiApp);
        bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.mIsGodreplyImage);
        bundle.putBoolean(ImageViewerConfig.IS_LOGIN, d.a.i0.f0.f.e());
        bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, d.a.i0.f0.f.b());
        bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, d.a.i0.f0.f.c());
        bundle.putString(ImageViewerConfig.ACCOUNT_TBS, d.a.i0.f0.f.d());
        bundle.putString("from_forum_id", this.fromForumId);
        bundle.putInt("skin_type", this.mSkinType);
        bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.mIsVideoWorksInfo);
        this.mImageViewerStatisticController.f(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        setFullScreen();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new s());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.mViewpager.v();
    }

    public void setAddSize(int i2) {
        MultiImageView multiImageView = this.mViewpager;
        if (multiImageView != null) {
            multiImageView.setAddSize(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
    }
}
