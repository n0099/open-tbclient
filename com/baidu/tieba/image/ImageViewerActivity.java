package com.baidu.tieba.image;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
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
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.k1.c;
import d.a.p0.u0.f2.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_ITEM_NUM = 400;
    public static final int PAGE_LIMIT = 2;
    public static final int PROFESSION_PERMISSION_TYPE_REPLY_FLOOR = 1;
    public static final int PROFESSION_PERMISSION_TYPE_REPLY_POST = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean alaLiveIsLive;
    public TBLottieAnimationView alaUserPhotoAnimView;
    public View alaUserPhotoLayout;
    public HeadImageView alaUserPhotoView;
    public Map<String, ImageUrlData> assistUrls;
    public String cacheAlaTag;
    public int currentPosition;
    public d.a.p0.k1.j.c editorController;
    public boolean firstImagePv;
    public String fromForumId;
    public CustomMessageListener hideNavbarListener;
    public SortSwitchButton hostAllSwitch;
    public boolean isFunAdABTest;
    public d.a.p0.k1.k.a mAdBannerDispatcher;
    public d.a.p0.k1.k.b mAdPicPageDispatcher;
    public d.a.p0.e0.e mAlaTipController;
    public View mBackLogo;
    public int mCardType;
    public ImageView mClose;
    public int mCount;
    public float mDonwX;
    public String mDragPicId;
    public DragImageView.h mDragToExitListener;
    public String mFid;
    public String mFname;
    public String mFrom;
    public d.a.p0.k1.b mFunAdPageProvider;
    public d.a.p0.k1.c mGetImageHelper;
    public ArrayList<String> mImageUrls;
    public d.a.p0.k1.h mImageViewerStatisticController;
    public int mIndex;
    public boolean mIsBJHThread;
    public boolean mIsCanDrag;
    public boolean mIsCdn;
    public boolean mIsClick;
    public boolean mIsDynamicCard;
    public boolean mIsFromAiApp;
    public boolean mIsGodreplyImage;
    public boolean mIsIdentifyImage;
    public boolean mIsNavigationBarVisibilitySaved;
    public boolean mIsOrdinal;
    public boolean mIsSeeHost;
    public boolean mIsShowAd;
    public boolean mIsShowBottomContainer;
    public boolean mIsShowHost;
    public boolean mIsStaticLast;
    public boolean mIsVideoWorksInfo;
    public boolean mIsYoungsterMode;
    public d.a.p0.k1.i mMoreDialogController;
    public NavigationBar mNavigationBar;
    public String mNid;
    public View.OnClickListener mOnClickListener;
    public UrlDragImageView.p mOriImgSelectedCallback;
    public View.OnTouchListener mOuterOnTouchListener;
    public ViewPager.OnPageChangeListener mPageChangeListener;
    public d.a.p0.e0.e mPictureTipController;
    public CustomMessageListener mPostAgreeChangedListener;
    public String mPostId;
    public d.a.p0.u0.f2.a.c mProfessionController;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    public boolean mSavedNavigationBarVisibility;
    public BaseViewPager.a mScrollOutListener;
    public View.OnLongClickListener mShowMenuListener;
    public int mSkinType;
    public String mSourceImageRectInScreen;
    public View mStatusBarView;
    public CustomMessageListener mThreadAgreeChangedListener;
    public int mThreadType;
    public String mTid;
    public TextView mTitleView;
    public final CustomMessageListener mToHotTopicListener;
    public String mUserId;
    public MultiImageView mViewpager;
    public VoiceManager mVoiceManager;
    public final SortSwitchButton.f onHostViewSwitchChangeListener;
    public View.OnClickListener onReplyButtonClickListener;
    public LinearLayout replyToolRoot;
    public View rightView;
    public int skinTypeRecord;
    public View.OnClickListener userPhotoOnClickListener;

    /* loaded from: classes4.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17945a;

        public a(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17945a = imageViewerActivity;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (d.a.c.e.p.j.A()) {
                    this.f17945a.mIsClick = true;
                    if (this.f17945a.hostAllSwitch != null) {
                        this.f17945a.hostAllSwitch.setEnabled(false);
                    }
                    String a2 = d.a.p0.k1.a.a((String) ListUtils.getItem(this.f17945a.mImageUrls, this.f17945a.mIndex));
                    ImageViewerActivity imageViewerActivity = this.f17945a;
                    imageViewerActivity.initImageHelper(a2, !imageViewerActivity.mIsSeeHost, true);
                    TiebaStatic.log(new StatisticItem("c13857").param("obj_type", this.f17945a.mIsSeeHost ? 7 : 8).param("post_id", this.f17945a.mTid).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f17945a.mFid));
                    return true;
                }
                this.f17945a.showToast(R.string.neterror);
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17946e;

        public b(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17946e = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17946e.dissmissPictureTip();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17947e;

        public c(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17947e = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.f17947e.mViewpager.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.f17947e.mViewpager.getCurrentMaxIndex()));
                TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "1"));
                this.f17947e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17948e;

        public d(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17948e = imageViewerActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                if (action == 0) {
                    this.f17948e.mDonwX = motionEvent.getX();
                    return false;
                } else if (action == 1 || action == 2 || action == 3) {
                    this.f17948e.mDonwX = motionEvent.getX();
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17949e;

        public e(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17949e = imageViewerActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (d.a.o0.b.d.F()) {
                    if (this.f17949e.mMoreDialogController != null) {
                        this.f17949e.mMoreDialogController.y();
                    }
                } else if (this.f17949e.mMoreDialogController != null) {
                    this.f17949e.mMoreDialogController.D();
                    this.f17949e.mMoreDialogController.E();
                    this.f17949e.mMoreDialogController.w(view);
                }
                TiebaStatic.log(new StatisticItem("c13269").param("uid", this.f17949e.mUserId).param("fid", this.f17949e.mFid).param("tid", this.f17949e.mTid));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17950a;

        public f(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17950a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.f17950a.mGetImageHelper.V();
                } else if (this.f17950a.getCurrentOverAllIndex() == 1) {
                } else {
                    this.f17950a.mGetImageHelper.W();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17951e;

        public g(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17951e = imageViewerActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f17951e.mImageUrls == null || this.f17951e.mIndex >= this.f17951e.mImageUrls.size()) {
                return;
            }
            this.f17951e.mImageViewerStatisticController.e(i2, (String) this.f17951e.mImageUrls.get(this.f17951e.mIndex));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                if (i2 > this.f17951e.currentPosition) {
                    this.f17951e.currentPosition = i2;
                } else if (i2 < this.f17951e.currentPosition) {
                    this.f17951e.currentPosition = i2;
                }
                DragImageView currentView = this.f17951e.mViewpager != null ? this.f17951e.mViewpager.getCurrentView() : null;
                boolean d0 = currentView != null ? currentView.d0() : false;
                if (this.f17951e.getCurrentOverAllIndex() == 1 && d0) {
                    this.f17951e.setSwipeBackEnabled(true);
                } else {
                    this.f17951e.setSwipeBackEnabled(false);
                }
                this.f17951e.dismissAlaTip();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f17951e.mGetImageHelper != null && i2 > this.f17951e.mViewpager.getItemNum() - 5) {
                    this.f17951e.mGetImageHelper.V();
                }
                if (this.f17951e.isFunAdABTest && this.f17951e.mFunAdPageProvider != null && this.f17951e.mGetImageHelper != null && this.f17951e.mViewpager != null) {
                    this.f17951e.mFunAdPageProvider.t(this.f17951e.mGetImageHelper.Y(), this.f17951e.mCount, i2, this.f17951e.mTid, this.f17951e.mFid);
                    this.f17951e.mFunAdPageProvider.w(i2);
                }
                this.f17951e.mImageViewerStatisticController.c(this.f17951e.mImageUrls, this.f17951e.mIndex, i2);
                this.f17951e.mIndex = i2;
                if (this.f17951e.mViewpager != null) {
                    this.f17951e.triggerBannerAd(i2);
                }
                this.f17951e.updateNavigationTitle();
                this.f17951e.updateNavigationVisibility();
                this.f17951e.updateClearScreenVisibility(i2);
                if (this.f17951e.mImageViewerStatisticController.a() < this.f17951e.mIndex) {
                    this.f17951e.mImageViewerStatisticController.h(this.f17951e.mIndex);
                }
                if (this.f17951e.mImageViewerStatisticController.b() > this.f17951e.mIndex) {
                    this.f17951e.mImageViewerStatisticController.i(this.f17951e.mIndex);
                }
                if (this.f17951e.checkIsAdvertPage() && this.f17951e.isFunAdABTest && this.f17951e.mFunAdPageProvider != null) {
                    this.f17951e.mFunAdPageProvider.r();
                }
                if (this.f17951e.mAdPicPageDispatcher != null) {
                    this.f17951e.mAdPicPageDispatcher.k(i2);
                }
                if (this.f17951e.mMoreDialogController != null) {
                    this.f17951e.mMoreDialogController.B();
                }
                if (this.f17951e.editorController != null && this.f17951e.mViewpager.getCurrentUrlDragImageView() != null) {
                    this.f17951e.editorController.q(this.f17951e.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData(), this.f17951e.mGetImageHelper);
                }
                if (this.f17951e.firstImagePv) {
                    return;
                }
                this.f17951e.imagePv();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17952e;

        public h(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17952e = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !(view instanceof HeadImageView) || (alaInfo = ((HeadImageView) view).getAlaInfo()) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f17952e.getPageContext(), null)) {
                return;
            }
            String str = "";
            if (alaInfo.isLegalYYLiveData()) {
                YyExtData yyExtData = alaInfo.mYyExtData;
                this.f17952e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(d.a.o0.a.g.f51334a + "://" + d.a.o0.a.g.f51335b + d.a.o0.a.g.l + "?" + d.a.o0.a.g.H + "=" + Base64.encodeToString(YYLiveUtil.makeJumpToYYLiveRoomUrl(yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + alaInfo.roomId, YYLiveUtil.SOURCE_PB_BIG_IMAGE_HEAD).getBytes(), 2))));
            } else if (alaInfo.isChushou) {
                this.f17952e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(d.a.o0.a.g.f51334a + "://" + d.a.o0.a.g.f51335b + d.a.o0.a.g.k + "?" + d.a.o0.a.g.F + "=" + alaInfo.thirdLiveType + "&" + d.a.o0.a.g.G + "=" + alaInfo.thirdRoomId)));
            }
            StatisticItem param = new StatisticItem("c13711").param("fid", this.f17952e.mFid).param("fname", this.f17952e.mFname).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f17952e.mTid);
            if (alaInfo.user_info != null) {
                str = "" + alaInfo.user_info.user_id;
            }
            TiebaStatic.log(param.param("obj_param1", str));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17953e;

        public i(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17953e = imageViewerActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17953e.alaUserPhotoAnimView.playAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17954e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17955f;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f17956e;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17956e = jVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f17956e.f17955f.dismissAlaTip();
                }
            }
        }

        public j(ImageViewerActivity imageViewerActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17955f = imageViewerActivity;
            this.f17954e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f17955f.mAlaTipController != null) {
                    if (this.f17955f.cacheAlaTag == null || this.f17955f.mAlaTipController == null || this.f17955f.alaUserPhotoLayout == null || this.f17955f.alaUserPhotoLayout.getVisibility() != 0) {
                        this.f17955f.dismissAlaTip();
                        return;
                    }
                    this.f17955f.mAlaTipController.l0(this.f17954e);
                    this.f17955f.cacheAlaTag = null;
                    return;
                }
                ImageViewerActivity imageViewerActivity = this.f17955f;
                imageViewerActivity.mAlaTipController = new d.a.p0.e0.e(imageViewerActivity.getPageContext(), this.f17955f.alaUserPhotoAnimView);
                this.f17955f.mAlaTipController.g0(R.drawable.bg_tip_blue_up);
                this.f17955f.mAlaTipController.O(32);
                this.f17955f.mAlaTipController.h0(true);
                this.f17955f.mAlaTipController.W(1);
                this.f17955f.mAlaTipController.j0(0);
                this.f17955f.mAlaTipController.N(3000);
                this.f17955f.mAlaTipController.M(new a(this));
                if (this.f17955f.alaUserPhotoLayout == null || this.f17955f.alaUserPhotoLayout.getVisibility() == 0) {
                    this.f17955f.mAlaTipController.l0(this.f17954e);
                    return;
                }
                this.f17955f.cacheAlaTag = this.f17954e;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17957a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ImageViewerActivity imageViewerActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17957a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.f17957a.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                this.f17957a.dismissAlaTip();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends d.a.o0.k0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17958a;

        public l(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17958a = imageViewerActivity;
        }

        @Override // d.a.o0.k0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.o0.k0.e.b().c() : invokeV.intValue;
        }

        @Override // d.a.o0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17959a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ImageViewerActivity imageViewerActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17959a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.p0.h3.h0.e) || this.f17959a.assistUrls == null || (agreeData = ((d.a.p0.h3.h0.e) customResponsedMessage.getData()).f57972b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : this.f17959a.assistUrls.values()) {
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17960a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ImageViewerActivity imageViewerActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17960a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.p0.h3.h0.e) || this.f17960a.assistUrls == null || (agreeData = ((d.a.p0.h3.h0.e) customResponsedMessage.getData()).f57972b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : this.f17960a.assistUrls.values()) {
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
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17961a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ImageViewerActivity imageViewerActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17961a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.o0.t.m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.o0.t.m) || (mVar = (d.a.o0.t.m) customResponsedMessage.getData()) == null || StringUtils.isNull(mVar.f53441a)) {
                return;
            }
            d.a.o0.p0.b.i(mVar);
            if (StringUtils.isNull(mVar.f53443c)) {
                UrlManager.getInstance().dealOneLink(this.f17961a.getPageContext(), new String[]{mVar.f53441a});
            } else {
                UrlManager.getInstance().dealOneLink(this.f17961a.getPageContext(), new String[]{mVar.f53441a, mVar.f53443c});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17962a;

        public p(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17962a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageViewerActivity imageViewerActivity = this.f17962a;
                imageViewerActivity.setViewVisibility(imageViewerActivity.mTitleView, 8);
                ImageViewerActivity imageViewerActivity2 = this.f17962a;
                imageViewerActivity2.setViewVisibility(imageViewerActivity2.hostAllSwitch, 8);
                ImageViewerActivity imageViewerActivity3 = this.f17962a;
                imageViewerActivity3.setViewVisibility(imageViewerActivity3.mBackLogo, 8);
                ImageViewerActivity imageViewerActivity4 = this.f17962a;
                imageViewerActivity4.setViewVisibility(imageViewerActivity4.alaUserPhotoLayout, 8);
                if (this.f17962a.mViewpager != null) {
                    this.f17962a.mViewpager.A(false);
                }
                this.f17962a.dissmissPictureTip();
                this.f17962a.dismissAlaTip();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.f17962a.mViewpager.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.f17962a.mViewpager.getCurrentMaxIndex()));
                this.f17962a.finish();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.f17962a;
                imageViewerActivity.setViewVisibility(imageViewerActivity.mTitleView, 0);
                this.f17962a.mBackLogo.setVisibility(0);
                if (this.f17962a.mViewpager == null || this.f17962a.checkIsAdvertPage()) {
                    return;
                }
                boolean t = this.f17962a.mViewpager.t();
                if ("portrait".equals(this.f17962a.mFrom) || t) {
                    return;
                }
                ImageViewerActivity imageViewerActivity2 = this.f17962a;
                imageViewerActivity2.setViewVisibility(imageViewerActivity2.hostAllSwitch, 0);
                ImageViewerActivity imageViewerActivity3 = this.f17962a;
                imageViewerActivity3.setViewVisibility(imageViewerActivity3.alaUserPhotoLayout, 0);
                ImageViewerActivity imageViewerActivity4 = this.f17962a;
                imageViewerActivity4.showAlaTip(imageViewerActivity4.cacheAlaTag);
                if (this.f17962a.mIsShowBottomContainer) {
                    this.f17962a.mViewpager.A(true);
                } else {
                    this.f17962a.mViewpager.A(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17963e;

        /* loaded from: classes4.dex */
        public class a implements c.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ q f17964a;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17964a = qVar;
            }

            @Override // d.a.p0.u0.f2.a.c.d
            public void a(boolean z, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                }
            }

            @Override // d.a.p0.u0.f2.a.c.d
            public void b(boolean z) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || !z || this.f17964a.f17963e.editorController == null || this.f17964a.f17963e.mViewpager.getCurrentUrlDragImageView() == null) {
                    return;
                }
                this.f17964a.f17963e.editorController.u(this.f17964a.f17963e.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData(), this.f17964a.f17963e.mGetImageHelper);
            }

            @Override // d.a.p0.u0.f2.a.c.d
            public void c(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                }
            }
        }

        public q(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17963e = imageViewerActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v28, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "3").param("post_id", this.f17963e.mTid).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f17963e.mFid));
                if (d.a.o0.f0.f.a(this.f17963e)) {
                    if (this.f17963e.mProfessionController == null) {
                        ImageViewerActivity imageViewerActivity = this.f17963e;
                        imageViewerActivity.mProfessionController = new d.a.p0.u0.f2.a.c(imageViewerActivity.getPageContext());
                        this.f17963e.mProfessionController.j(new a(this));
                    }
                    this.f17963e.mProfessionController.k(((this.f17963e.mViewpager == null || this.f17963e.mViewpager.getCurrentUrlDragImageView() == null || this.f17963e.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? 1 : this.f17963e.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost) ^ 1);
                    this.f17963e.mProfessionController.h(this.f17963e.mFid, d.a.c.e.m.b.f(this.f17963e.mTid, 0L));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements UrlDragImageView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17965a;

        public r(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17965a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.f17965a.mTid).param("obj_type", this.f17965a.mFrom));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17966a;

        public s(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17966a = imageViewerActivity;
        }

        @Override // d.a.p0.k1.c.b
        public void a(ArrayList<String> arrayList, int i2, int i3, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) == null) || this.f17966a.mViewpager == null) {
                return;
            }
            if (this.f17966a.mIsClick) {
                if (!z3) {
                    this.f17966a.mViewpager.removeAllViews();
                    this.f17966a.mIndex = 0;
                    this.f17966a.initViewPager();
                    ImageViewerActivity imageViewerActivity = this.f17966a;
                    imageViewerActivity.mIsSeeHost = !imageViewerActivity.mIsSeeHost;
                } else if (!this.f17966a.mIsSeeHost) {
                    this.f17966a.showToast(R.string.image_view_change_img_error);
                }
            }
            this.f17966a.mIsClick = false;
            if (this.f17966a.hostAllSwitch != null) {
                this.f17966a.hostAllSwitch.setEnabled(true);
            }
            this.f17966a.hideProgressBar();
            if (z2 && this.f17966a.mViewpager.getCurrentItem() <= 4) {
                int itemNum = this.f17966a.mViewpager.getItemNum();
                this.f17966a.mViewpager.setTempSize(itemNum + 100);
                this.f17966a.mViewpager.setCurrentItem(itemNum + 90, false);
                this.f17966a.mViewpager.setTempSize(0);
            }
            this.f17966a.mViewpager.setUrlData(arrayList);
            this.f17966a.mViewpager.setAssistUrls(this.f17966a.assistUrls);
            this.f17966a.mViewpager.setHasNext(z);
            if (this.f17966a.isFunAdABTest) {
                int Y = this.f17966a.mGetImageHelper.Y();
                if (this.f17966a.mFunAdPageProvider != null) {
                    this.f17966a.mFunAdPageProvider.x(ListUtils.getCount(arrayList), i3);
                    this.f17966a.mFunAdPageProvider.t(Y, i3, this.f17966a.mIndex, this.f17966a.mTid, this.f17966a.mFid);
                }
            }
            this.f17966a.mViewpager.setNextTitle(str);
            if (i2 < 0 || i2 >= this.f17966a.mViewpager.getItemNum()) {
                this.f17966a.mViewpager.u(this.f17966a.mViewpager.getCurrentItem());
            } else {
                this.f17966a.mViewpager.setCurrentItem(i2, false);
            }
            if (i3 != 0) {
                this.f17966a.mCount = i3;
            }
            if (arrayList != null && arrayList.size() >= 400 && this.f17966a.mViewpager.getCurrentItem() > 200) {
                for (int i4 = 0; i4 < 200; i4++) {
                    arrayList.remove(0);
                }
                this.f17966a.mViewpager.setUrlData(arrayList);
                this.f17966a.mViewpager.setCurrentItem(this.f17966a.mViewpager.getCurrentItem() - 200, false);
            }
            if (this.f17966a.getCurrentOverAllIndex() != 1) {
                this.f17966a.setSwipeBackEnabled(false);
            }
            if (!this.f17966a.isFunAdABTest) {
                if (this.f17966a.mAdPicPageDispatcher != null) {
                    this.f17966a.mAdPicPageDispatcher.m(this.f17966a.getCurrentOverAllIndex(), this.f17966a.mCount);
                    this.f17966a.mAdPicPageDispatcher.j();
                    c(arrayList, advertAppInfo);
                }
            } else {
                d(arrayList, i3);
            }
            this.f17966a.updateNavigationTitle();
            if (this.f17966a.editorController != null && this.f17966a.mViewpager.getCurrentUrlDragImageView() != null) {
                this.f17966a.editorController.q(this.f17966a.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData(), this.f17966a.mGetImageHelper);
            }
            ImageViewerActivity imageViewerActivity2 = this.f17966a;
            imageViewerActivity2.triggerBannerAd(imageViewerActivity2.mViewpager.getCurrentItem());
            if (this.f17966a.firstImagePv) {
                this.f17966a.firstImagePv = false;
                this.f17966a.imagePv();
            }
        }

        @Override // d.a.p0.k1.c.b
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f17966a.mIsClick = false;
                if (this.f17966a.hostAllSwitch != null) {
                    if (this.f17966a.hostAllSwitch.getState() != this.f17966a.mIsSeeHost && TextUtils.isEmpty(str)) {
                        this.f17966a.showToast(R.string.image_view_change_img_error);
                    }
                    this.f17966a.hostAllSwitch.u(this.f17966a.mIsSeeHost ? 1 : 0);
                    this.f17966a.hostAllSwitch.setEnabled(true);
                }
                this.f17966a.hideProgressBar();
                this.f17966a.showToast(str);
                if (i2 == 40) {
                    if (this.f17966a.mImageUrls != null) {
                        ImageViewerActivity imageViewerActivity = this.f17966a;
                        imageViewerActivity.mCount = imageViewerActivity.mImageUrls.size();
                    }
                    this.f17966a.updateNavigationTitle();
                }
                if (this.f17966a.firstImagePv) {
                    this.f17966a.firstImagePv = false;
                    this.f17966a.imagePv();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.f17966a.mAdPicPageDispatcher != null && advertAppInfo != null && arrayList != null) {
                    int w4 = advertAppInfo.w4();
                    if (w4 != 0) {
                        this.f17966a.reportAdDiscardLog(advertAppInfo, w4);
                        return;
                    } else {
                        this.f17966a.mAdPicPageDispatcher.g(advertAppInfo);
                        return;
                    }
                }
                this.f17966a.setAddSize(0);
            }
        }

        public final void d(ArrayList<String> arrayList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, arrayList, i2) == null) {
                if (this.f17966a.mFunAdPageProvider != null && arrayList != null) {
                    if (this.f17966a.mFunAdPageProvider.o()) {
                        this.f17966a.mFunAdPageProvider.x(ListUtils.getCount(arrayList), i2);
                        this.f17966a.setAddSize(1);
                        return;
                    }
                    this.f17966a.setAddSize(0);
                    return;
                }
                this.f17966a.setAddSize(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements d.a.p0.w2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17967a;

        public t(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17967a = imageViewerActivity;
        }

        @Override // d.a.p0.w2.d
        public <T> void onCallback(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.f17967a.mViewpager.setUrlData(this.f17967a.mImageUrls);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17968a;

        public u(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17968a = imageViewerActivity;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (i2 & 4) == 0) {
                this.f17968a.setFullScreen();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17969e;

        public v(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17969e = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17969e.isFunAdABTest && this.f17969e.checkIsAdvertPage() && this.f17969e.mFunAdPageProvider.p()) {
                    StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", "a008").eventStat();
                }
                this.f17969e.finish();
            }
        }
    }

    public ImageViewerActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.alaLiveIsLive = false;
        this.mIndex = -1;
        this.mCount = -1;
        this.isFunAdABTest = d.a.o0.b.d.N();
        this.mIsNavigationBarVisibilitySaved = false;
        this.mSavedNavigationBarVisibility = false;
        this.currentPosition = 0;
        this.mIsStaticLast = false;
        this.mIsShowAd = true;
        this.mIsCanDrag = true;
        this.mIsShowHost = true;
        this.mIsSeeHost = false;
        this.mIsFromAiApp = false;
        this.mIsBJHThread = false;
        this.mIsIdentifyImage = false;
        this.mIsGodreplyImage = false;
        this.mIsOrdinal = true;
        this.mIsCdn = false;
        this.mIsShowBottomContainer = true;
        this.mIsDynamicCard = false;
        this.mIsVideoWorksInfo = false;
        this.mIsYoungsterMode = false;
        this.firstImagePv = true;
        this.hideNavbarListener = new k(this, 2016496);
        this.mToHotTopicListener = new o(this, 2016493);
        this.mDragToExitListener = new p(this);
        this.onReplyButtonClickListener = new q(this);
        this.mOriImgSelectedCallback = new r(this);
        this.onHostViewSwitchChangeListener = new a(this);
        this.mOnClickListener = new c(this);
        this.mOuterOnTouchListener = new d(this);
        this.mShowMenuListener = new e(this);
        this.mScrollOutListener = new f(this);
        this.mPageChangeListener = new g(this);
        this.userPhotoOnClickListener = new h(this);
        this.mThreadAgreeChangedListener = new m(this, 2016528);
        this.mPostAgreeChangedListener = new n(this, 2016530);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIsAdvertPage() {
        InterceptResult invokeV;
        d.a.p0.k1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) {
            if (this.mIsShowAd) {
                d.a.p0.k1.k.b bVar2 = this.mAdPicPageDispatcher;
                if (bVar2 == null || !bVar2.h(this.mIndex)) {
                    return this.isFunAdABTest && (bVar = this.mFunAdPageProvider) != null && bVar.n() && this.mViewpager.getItemNum() != 1 && this.mIndex == this.mViewpager.getItemNum() - 1;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAlaTip() {
        d.a.p0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65594, this) == null) || (eVar = this.mAlaTipController) == null) {
            return;
        }
        eVar.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dissmissPictureTip() {
        d.a.p0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65595, this) == null) || (eVar = this.mPictureTipController) == null) {
            return;
        }
        eVar.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getCurrentOverAllIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65596, this)) == null) {
            String str = (String) ListUtils.getItem(this.mImageUrls, this.mIndex);
            Map<String, ImageUrlData> map = this.assistUrls;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            long j2 = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
            return j2 == 0 ? this.mIndex + 1 : j2;
        }
        return invokeV.longValue;
    }

    private void handleUserAlaLiveLayout(AlaInfoData alaInfoData) {
        AlaUserInfoData alaUserInfoData;
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65597, this, alaInfoData) == null) || alaInfoData == null || (alaUserInfoData = alaInfoData.user_info) == null || (headImageView = this.alaUserPhotoView) == null) {
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
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65598, this, i2) == null) || (tBLottieAnimationView = this.alaUserPhotoAnimView) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    private void handleUserAlaLiveState(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65599, this, z) == null) || this.alaLiveIsLive == z) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.alaUserPhotoAnimView;
        if (tBLottieAnimationView != null) {
            if (z) {
                tBLottieAnimationView.setVisibility(0);
                if (!this.alaUserPhotoAnimView.isAnimating()) {
                    this.alaUserPhotoAnimView.setSpeed(0.8f);
                    this.alaUserPhotoAnimView.setRepeatCount(-1);
                    this.alaUserPhotoAnimView.post(new i(this));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void imagePv() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, this) == null) {
            String str = (String) ListUtils.getItem(this.mImageUrls, this.mIndex);
            Map<String, ImageUrlData> map = this.assistUrls;
            if (map == null || str == null || (imageUrlData = map.get(str)) == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13340").param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.mTid).param("obj_source", this.mFrom).param("obj_param1", this.mIndex).param(TiebaStatic.Params.OBJ_PARAM2, this.mCount - this.mIndex).param(TiebaStatic.Params.OBJ_PARAM3, imageUrlData.mHeigth).param(TiebaStatic.Params.OBJ_PARAM4, imageUrlData.mWidth));
        }
    }

    private void initBackView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65601, this) == null) {
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mBackLogo = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new v(this));
            this.mClose = (ImageView) this.mBackLogo.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mClose, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mBackLogo.setVisibility(0);
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, this, bundle) == null) {
            this.mImageViewerStatisticController = new d.a.p0.k1.h();
            boolean e2 = d.a.o0.f0.f.e();
            String b2 = d.a.o0.f0.f.b();
            String d2 = d.a.o0.f0.f.d();
            String c2 = d.a.o0.f0.f.c();
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
                this.mIsShowAd = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
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
                this.mIsYoungsterMode = bundle.getBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, false);
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
                    this.mIsShowAd = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
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
                    this.mIsYoungsterMode = intent.getBooleanExtra(ImageViewerConfig.IS_YOUNGSTER_MODE, false);
                } else {
                    z = e2;
                    str = b2;
                    str2 = d2;
                    str3 = c2;
                }
            }
            d.a.o0.f0.f.h(z);
            d.a.o0.f0.f.g(str);
            d.a.o0.f0.f.i(str3);
            d.a.o0.f0.f.j(str2);
            this.mImageViewerStatisticController.d(bundle, getIntent());
            this.mCount = ListUtils.getCount(this.mImageUrls);
            if (this.mSourceImageRectInScreen != null) {
                String str4 = (String) ListUtils.getItem(this.mImageUrls, this.mIndex);
                if (!StringUtils.isNull(str4) && (map = this.assistUrls) != null && (imageUrlData = map.get(str4)) != null) {
                    imageUrlData.setSourceImageRectInScreen(this.mSourceImageRectInScreen);
                }
            }
            this.mDragPicId = this.mIsBJHThread ? null : d.a.p0.k1.a.a((String) ListUtils.getItem(this.mImageUrls, this.mIndex));
            if (this.mIsSeeHost) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
        }
    }

    private void initEditor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65603, this) == null) {
            this.replyToolRoot = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
            d.a.p0.k1.j.c cVar = new d.a.p0.k1.j.c(getPageContext(), this.replyToolRoot);
            this.editorController = cVar;
            cVar.r(this.fromForumId);
            this.editorController.s(this.mSkinType);
            this.editorController.m(this.mSkinType);
        }
    }

    private void initHostView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65604, this) == null) || this.mIsBJHThread || this.mIsFromAiApp || this.mIsVideoWorksInfo) {
            return;
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
        this.rightView = addCustomView;
        addCustomView.setVisibility(this.mIsYoungsterMode ? 8 : 0);
        this.alaUserPhotoLayout = this.rightView.findViewById(R.id.view_user_photo);
        this.alaUserPhotoView = (HeadImageView) this.rightView.findViewById(R.id.normal_user_photo);
        this.alaUserPhotoAnimView = (TBLottieAnimationView) this.rightView.findViewById(R.id.user_living_lottie);
        this.alaUserPhotoView.setIsRound(true);
        this.alaUserPhotoView.setPlaceHolder(1);
        if (this.mIsShowHost) {
            ArrayList arrayList = new ArrayList(2);
            d.a.p0.h3.h0.r rVar = new d.a.p0.h3.h0.r();
            rVar.c(0);
            rVar.d(getString(R.string.all));
            arrayList.add(rVar);
            d.a.p0.h3.h0.r rVar2 = new d.a.p0.h3.h0.r();
            rVar2.c(1);
            rVar2.d(getString(R.string.host_name));
            arrayList.add(rVar2);
            SortSwitchButton sortSwitchButton = (SortSwitchButton) this.rightView.findViewById(R.id.host_all_switch_btn);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65605, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d.a.p0.k1.c cVar = new d.a.p0.k1.c(this.mImageUrls, this.assistUrls, this.mFid, this.mFname, this.mTid, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.mCardType, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
            this.mGetImageHelper = cVar;
            cVar.h0(this.mSourceImageRectInScreen);
            this.mGetImageHelper.f0(this.mIsOrdinal);
            this.mGetImageHelper.g0(z);
            this.mGetImageHelper.Z(this.mDragPicId);
            this.mGetImageHelper.c0(this.mIsGodreplyImage);
            this.mGetImageHelper.e0(this.mPostId);
            this.mGetImageHelper.b0(this.mIsDynamicCard);
            this.mGetImageHelper.d0(new s(this));
            this.mGetImageHelper.a0(true);
            this.mAdPicPageDispatcher.l(new t(this));
            this.mGetImageHelper.V();
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65606, this) == null) {
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
            d.a.o0.r.u.c.d(this.mTitleView).w(R.array.S_O_X001);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
            if (d.a.p0.k1.a.b((String) ListUtils.getItem(this.mImageUrls, this.mIndex))) {
                this.mNavigationBar.setVisibility(0);
            }
        }
    }

    private void initStatusBarView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65607, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.statusbar_view);
            this.mStatusBarView = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void initUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65608, this) == null) {
            initNavigationBar();
            this.mMoreDialogController = new d.a.p0.k1.i(this);
            initViewPager();
            this.mMoreDialogController.v(this.mViewpager);
            updateNavigationTitle();
            showGuideTip();
            initStatusBarView();
            initEditor();
            d.a.p0.k1.h hVar = this.mImageViewerStatisticController;
            ArrayList<String> arrayList = this.mImageUrls;
            int i2 = this.mIndex;
            hVar.c(arrayList, i2, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65609, this) == null) {
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
                d.a.p0.k1.b bVar = new d.a.p0.k1.b(this, this.mIsShowAd);
                this.mFunAdPageProvider = bVar;
                bVar.v(this.mDragToExitListener);
                this.mViewpager.k(this.mFunAdPageProvider);
            }
            if (this.mAdPicPageDispatcher == null) {
                this.mAdPicPageDispatcher = new d.a.p0.k1.k.b(this.mImageUrls, this.mFid, this.mFname, this.mIsCdn, this.mIsShowAd, getPageContext(), this.mDragToExitListener);
            }
            this.mViewpager.k(this.mAdPicPageDispatcher);
            this.mViewpager.setOriImgSelectedCallback(this.mOriImgSelectedCallback);
            this.mViewpager.setDragToExitListener(this.mDragToExitListener);
            this.mViewpager.setUserId(this.mUserId);
            this.mViewpager.setShowBottomContainer(this.mIsShowBottomContainer);
            this.mViewpager.setOnShareImageListener(this.mMoreDialogController);
            this.mViewpager.setOnDownloadImageListener(this.mMoreDialogController);
            this.mViewpager.setOnReplyClickListener(this.onReplyButtonClickListener);
            this.mViewpager.setYoungterCoverSomeView(this.mIsYoungsterMode);
            TiebaStatic.log(new StatisticItem("c13340").param("uid", this.mUserId).param("post_id", this.mTid).param("obj_source", transformValForFrom()));
        }
    }

    private void refreshCloseIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65610, this) == null) {
            if (this.isFunAdABTest && checkIsAdvertPage()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mClose, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mClose, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAdDiscardLog(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65611, this, advertAppInfo, i2) == null) {
            d.a.p0.w2.i0.c b2 = d.a.p0.w2.i0.g.b(advertAppInfo, 5, 0);
            b2.j(i2);
            d.a.p0.w2.i0.e.b().d(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65612, this) == null) {
            getWindow().getDecorView().setSystemUiVisibility(1284);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisibility(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65613, this, view, i2) == null) || view == null) {
            return;
        }
        view.clearAnimation();
        view.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlaTip(@NonNull String str) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65614, this, str) == null) || (tBLottieAnimationView = this.alaUserPhotoAnimView) == null) {
            return;
        }
        tBLottieAnimationView.post(new j(this, str));
    }

    private void showGuideTip() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65615, this) == null) || this.mIsFromAiApp || this.hostAllSwitch == null) {
            return;
        }
        if (this.mPictureTipController == null) {
            d.a.p0.e0.e eVar = new d.a.p0.e0.e(getPageContext(), this.hostAllSwitch);
            this.mPictureTipController = eVar;
            eVar.g0(R.drawable.pic_sign_tip);
            this.mPictureTipController.O(48);
            this.mPictureTipController.h0(true);
            this.mPictureTipController.N(5000);
            this.mPictureTipController.j0(-d.a.c.e.p.l.g(getPageContext().getPageActivity(), R.dimen.tbds26));
            this.mPictureTipController.M(new b(this));
        }
        this.mPictureTipController.m0(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
    }

    private void startLoadPortrait(TbImageView tbImageView, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65616, this, tbImageView, str) == null) || tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = " ";
        }
        if (str.toLowerCase().startsWith("http")) {
            tbImageView.M(str, 10, false);
        } else {
            tbImageView.M(str, 12, false);
        }
    }

    private int transformValForFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65617, this)) == null) {
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
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerBannerAd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65618, this, i2) == null) {
            if (this.mAdBannerDispatcher == null) {
                AdvertAppInfo.e4.set(true);
                this.mAdBannerDispatcher = new d.a.p0.k1.k.a((ViewStub) findViewById(R.id.ad_banner_view_stub), getPageContext());
            }
            this.mAdBannerDispatcher.c(this.mViewpager, this.mIsSeeHost, i2, checkIsAdvertPage(), i2 < this.mImageUrls.size() ? this.mImageUrls.get(i2) : "", this.mCount, this.mFid, this.mFname, this.mTid);
        }
    }

    private void updateAlaLiveLayout(int i2) {
        d.a.p0.k1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65619, this, i2) == null) || (cVar = this.mGetImageHelper) == null) {
            return;
        }
        ArrayList<AlaInfoData> T = cVar.T();
        if (T != null && T.size() > 0) {
            handleUserAlaLiveState(true);
            handleUserAlaLiveLayout(T.get(i2 % T.size()));
            return;
        }
        handleUserAlaLiveState(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateClearScreenVisibility(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65620, this, i2) == null) || (multiImageView = this.mViewpager) == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65621, this) == null) || this.mImageUrls == null) {
            return;
        }
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

    private void updateNavigationTitleAdvert() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65622, this) == null) {
            this.mTitleView.setText("");
            setViewVisibility(this.hostAllSwitch, 8);
            setViewVisibility(this.alaUserPhotoLayout, 8);
        }
    }

    private void updateNavigationTitlePic(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65623, this, str) == null) {
            this.mTitleView.setText(str);
            if (this.mIsShowHost && !this.mIsFromAiApp && (sortSwitchButton = this.hostAllSwitch) != null) {
                sortSwitchButton.u(this.mIsSeeHost ? 1 : 0);
            }
            d.a.o0.r.u.c.d(this.mTitleView).w(R.array.S_O_X001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigationVisibility() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65624, this) == null) {
            if (checkIsAdvertPage()) {
                this.mSavedNavigationBarVisibility = this.mNavigationBar.getVisibility() == 0;
                this.mIsNavigationBarVisibilitySaved = true;
            } else if (this.mIsNavigationBarVisibilitySaved) {
                this.mNavigationBar.setVisibility(this.mSavedNavigationBarVisibility ? 0 : 8);
                this.mIsNavigationBarVisibilitySaved = false;
            }
            refreshCloseIcon();
        }
    }

    public int calCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (d.a.o0.z0.l.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    public Map<String, ImageUrlData> getAssistUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.assistUrls : (Map) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.o0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a008" : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFrom : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (d.a.c.e.p.k.isEmpty(this.mTid)) {
                return 0L;
            }
            return d.a.c.e.m.b.f(this.mTid, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.o0.k0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.o0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.q(d.a.c.e.m.b.f(this.mFid, 0L));
                pageStayDurationItem.y(d.a.c.e.m.b.f(this.mTid, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.n(TbadkCoreApplication.getInst().getAdAdSense().r);
                }
            }
            return pageStayDurationItem;
        }
        return (d.a.o0.k0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.o0.k0.a
    public d.a.o0.k0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new l(this) : (d.a.o0.k0.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mUserId : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mVoiceManager == null) {
                this.mVoiceManager = VoiceManager.instance();
            }
            return this.mVoiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean isIsBJHThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIsBJHThread : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.editorController.l(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mViewpager.setBackgroundColor(-16777216);
            this.mViewpager.y(i2);
            super.onChangeSkinType(i2);
            this.skinTypeRecord = i2;
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
            handleUserAlaLiveSkinType(i2);
            d.a.p0.k1.i iVar = this.mMoreDialogController;
            if (iVar != null) {
                iVar.x();
            }
            d.a.p0.k1.j.c cVar = this.editorController;
            if (cVar != null) {
                cVar.m(this.mSkinType);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mViewpager.setCurrentItem(this.mIndex, false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mClose, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 28 && TbSingleton.getInstance().isNotchScreen(this)) {
                setUseStyleImmersiveSticky(false);
            }
            super.onCreate(bundle);
            d.a.o0.f0.h.f().g(TbadkCoreApplication.getInst());
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
                d.a.p0.t3.c.b(1, getWindow().getAttributes(), getWindow());
            }
            if (!TbSingleton.getInstance().hasDownloadEmotion() && d.a.c.e.p.j.H() && TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
                TbSingleton.getInstance().setHasDownloadEmotion(true);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mToHotTopicListener);
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            d.a.o0.a0.c.k().r();
            d.a.p0.k1.h hVar = this.mImageViewerStatisticController;
            ArrayList<String> arrayList = this.mImageUrls;
            int i2 = this.mIndex;
            hVar.c(arrayList, i2, i2);
            this.mImageViewerStatisticController.g();
            d.a.p0.k1.c cVar = this.mGetImageHelper;
            if (cVar != null) {
                String U = cVar.U();
                str2 = this.mGetImageHelper.X();
                str = U;
            } else {
                str = null;
                str2 = null;
            }
            this.mImageViewerStatisticController.j(this.mViewpager.getPageCount(), "", this.mFid, this.mTid, str, str2);
            d.a.p0.k1.i iVar = this.mMoreDialogController;
            if (iVar != null) {
                iVar.A();
            }
            this.mViewpager.v();
            this.editorController.n();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d.a.o0.v.e.j().h(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.skinTypeRecord);
            dissmissPictureTip();
            dismissAlaTip();
            d.a.p0.k1.k.b bVar = this.mAdPicPageDispatcher;
            if (bVar != null) {
                bVar.i();
            }
            d.a.p0.k1.k.a aVar = this.mAdBannerDispatcher;
            if (aVar != null) {
                aVar.b();
            }
            d.a.p0.k1.b bVar2 = this.mFunAdPageProvider;
            if (bVar2 != null) {
                bVar2.s();
            }
            d.a.o0.f0.h.i(new PrePageKeyEvent(getCurrentPageKey()));
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                Intent intent = new Intent();
                intent.putExtra("index", this.mIndex);
                setResult(-1, intent);
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            this.mViewpager.w();
            BdUniqueId uniqueId = getUniqueId();
            long f2 = d.a.c.e.m.b.f(this.mTid, 0L);
            if (uniqueId != null && f2 > 0) {
                d.a.o0.a.t.f(uniqueId.getId(), f2);
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.editorController.o();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            this.mViewpager.x();
            this.mIsLogin = d.a.o0.f0.f.e();
            BdUniqueId uniqueId = getUniqueId();
            long f2 = d.a.c.e.m.b.f(this.mTid, 0L);
            if (uniqueId != null && f2 > 0) {
                d.a.o0.a.t.j(d.a.o0.a.c.a0, uniqueId.getId(), f2);
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.editorController.p();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
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
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.mIsShowAd);
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
            bundle.putBoolean(ImageViewerConfig.IS_LOGIN, d.a.o0.f0.f.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, d.a.o0.f0.f.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, d.a.o0.f0.f.c());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, d.a.o0.f0.f.d());
            bundle.putString("from_forum_id", this.fromForumId);
            bundle.putInt("skin_type", this.mSkinType);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.mIsVideoWorksInfo);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.mIsYoungsterMode);
            this.mImageViewerStatisticController.f(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            super.onWindowFocusChanged(z);
            setFullScreen();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new u(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mViewpager.v();
        }
    }

    public void setAddSize(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (multiImageView = this.mViewpager) == null) {
            return;
        }
        multiImageView.setAddSize(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }
}
