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
import d.a.s0.k1.c;
import d.a.s0.u0.f2.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
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
    public d.a.s0.k1.j.c editorController;
    public boolean firstImagePv;
    public String fromForumId;
    public CustomMessageListener hideNavbarListener;
    public SortSwitchButton hostAllSwitch;
    public boolean isFunAdABTest;
    public d.a.s0.k1.k.a mAdBannerDispatcher;
    public d.a.s0.k1.k.c mAdPicPageDispatcher;
    public d.a.s0.e0.e mAlaTipController;
    public d.a.s0.k1.k.b mApPageProvier;
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
    public d.a.s0.k1.b mFunAdPageProvider;
    public d.a.s0.k1.c mGetImageHelper;
    public ArrayList<String> mImageUrls;
    public d.a.s0.k1.h mImageViewerStatisticController;
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
    public boolean mIsShowAp;
    public boolean mIsShowBottomContainer;
    public boolean mIsShowHost;
    public boolean mIsStaticLast;
    public boolean mIsVideoWorksInfo;
    public boolean mIsYoungsterMode;
    public d.a.s0.k1.i mMoreDialogController;
    public NavigationBar mNavigationBar;
    public String mNid;
    public View.OnClickListener mOnClickListener;
    public UrlDragImageView.p mOriImgSelectedCallback;
    public View.OnTouchListener mOuterOnTouchListener;
    public ViewPager.OnPageChangeListener mPageChangeListener;
    public d.a.s0.e0.e mPictureTipController;
    public CustomMessageListener mPostAgreeChangedListener;
    public String mPostId;
    public d.a.s0.u0.f2.a.c mProfessionController;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17906e;

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
            this.f17906e = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17906e.dissmissPictureTip();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17907e;

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
            this.f17907e = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.f17907e.mViewpager.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.f17907e.mViewpager.getCurrentMaxIndex()));
                TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "1"));
                this.f17907e.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17908e;

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
            this.f17908e = imageViewerActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                if (action == 0) {
                    this.f17908e.mDonwX = motionEvent.getX();
                    return false;
                } else if (action == 1 || action == 2 || action == 3) {
                    this.f17908e.mDonwX = motionEvent.getX();
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17909e;

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
            this.f17909e = imageViewerActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (d.a.r0.b.d.v()) {
                    if (this.f17909e.mMoreDialogController != null) {
                        this.f17909e.mMoreDialogController.y();
                    }
                } else if (this.f17909e.mMoreDialogController != null) {
                    this.f17909e.mMoreDialogController.D();
                    this.f17909e.mMoreDialogController.E();
                    this.f17909e.mMoreDialogController.w(view);
                }
                TiebaStatic.log(new StatisticItem("c13269").param("uid", this.f17909e.mUserId).param("fid", this.f17909e.mFid).param("tid", this.f17909e.mTid));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements BaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17910a;

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
            this.f17910a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.f17910a.mGetImageHelper.V();
                } else if (this.f17910a.getCurrentOverAllIndex() == 1) {
                } else {
                    this.f17910a.mGetImageHelper.W();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17911e;

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
            this.f17911e = imageViewerActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f17911e.mImageUrls == null || this.f17911e.mIndex >= this.f17911e.mImageUrls.size()) {
                return;
            }
            this.f17911e.mImageViewerStatisticController.e(i2, (String) this.f17911e.mImageUrls.get(this.f17911e.mIndex));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                if (i2 > this.f17911e.currentPosition) {
                    this.f17911e.currentPosition = i2;
                } else if (i2 < this.f17911e.currentPosition) {
                    this.f17911e.currentPosition = i2;
                }
                DragImageView currentView = this.f17911e.mViewpager != null ? this.f17911e.mViewpager.getCurrentView() : null;
                boolean d0 = currentView != null ? currentView.d0() : false;
                if (this.f17911e.getCurrentOverAllIndex() == 1 && d0) {
                    this.f17911e.setSwipeBackEnabled(true);
                } else {
                    this.f17911e.setSwipeBackEnabled(false);
                }
                this.f17911e.dismissAlaTip();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f17911e.mGetImageHelper != null && i2 > this.f17911e.mViewpager.getItemNum() - 5) {
                    this.f17911e.mGetImageHelper.V();
                }
                if (this.f17911e.isFunAdABTest && this.f17911e.mFunAdPageProvider != null && this.f17911e.mGetImageHelper != null && this.f17911e.mViewpager != null) {
                    this.f17911e.mFunAdPageProvider.s(this.f17911e.mGetImageHelper.Y(), this.f17911e.mCount, i2, this.f17911e.mTid, this.f17911e.mFid);
                    this.f17911e.mFunAdPageProvider.v(i2);
                }
                if (this.f17911e.mViewpager != null) {
                    this.f17911e.triggerBannerAd(i2);
                }
                this.f17911e.mImageViewerStatisticController.c(this.f17911e.mImageUrls, this.f17911e.mIndex, i2);
                this.f17911e.mIndex = i2;
                this.f17911e.updateNavigationTitle();
                this.f17911e.updateNavigationVisibility();
                this.f17911e.updateClearScreenVisibility(i2);
                if (this.f17911e.mImageViewerStatisticController.a() < this.f17911e.mIndex) {
                    this.f17911e.mImageViewerStatisticController.h(this.f17911e.mIndex);
                }
                if (this.f17911e.mImageViewerStatisticController.b() > this.f17911e.mIndex) {
                    this.f17911e.mImageViewerStatisticController.i(this.f17911e.mIndex);
                }
                if (this.f17911e.checkIsAdvertPage()) {
                    if (this.f17911e.isFunAdABTest) {
                        if (this.f17911e.mFunAdPageProvider != null) {
                            this.f17911e.mFunAdPageProvider.q();
                        }
                    } else if (this.f17911e.mApPageProvier != null) {
                        this.f17911e.mApPageProvier.e();
                    }
                }
                if (this.f17911e.mMoreDialogController != null) {
                    this.f17911e.mMoreDialogController.B();
                }
                if (this.f17911e.editorController != null && this.f17911e.mViewpager.getCurrentUrlDragImageView() != null) {
                    this.f17911e.editorController.q(this.f17911e.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData(), this.f17911e.mGetImageHelper);
                }
                if (this.f17911e.firstImagePv) {
                    return;
                }
                this.f17911e.imagePv();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17912e;

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
            this.f17912e = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaInfoData alaInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !(view instanceof HeadImageView) || (alaInfo = ((HeadImageView) view).getAlaInfo()) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f17912e.getPageContext(), null)) {
                return;
            }
            String str = "";
            if (alaInfo.isLegalYYLiveData()) {
                YyExtData yyExtData = alaInfo.mYyExtData;
                this.f17912e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(d.a.r0.a.g.f54632a + "://" + d.a.r0.a.g.f54633b + d.a.r0.a.g.l + "?" + d.a.r0.a.g.H + "=" + Base64.encodeToString(YYLiveUtil.makeJumpToYYLiveRoomUrl(yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + alaInfo.roomId, YYLiveUtil.SOURCE_PB_BIG_IMAGE_HEAD).getBytes(), 2))));
            } else if (alaInfo.isChushou) {
                this.f17912e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(d.a.r0.a.g.f54632a + "://" + d.a.r0.a.g.f54633b + d.a.r0.a.g.k + "?" + d.a.r0.a.g.F + "=" + alaInfo.thirdLiveType + "&" + d.a.r0.a.g.G + "=" + alaInfo.thirdRoomId)));
            }
            StatisticItem param = new StatisticItem("c13711").param("fid", this.f17912e.mFid).param("fname", this.f17912e.mFname).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f17912e.mTid);
            if (alaInfo.user_info != null) {
                str = "" + alaInfo.user_info.user_id;
            }
            TiebaStatic.log(param.param("obj_param1", str));
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17913e;

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
            this.f17913e = imageViewerActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17913e.alaUserPhotoAnimView.playAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17915f;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f17916e;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17916e = iVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f17916e.f17915f.dismissAlaTip();
                }
            }
        }

        public i(ImageViewerActivity imageViewerActivity, String str) {
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
            this.f17915f = imageViewerActivity;
            this.f17914e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f17915f.mAlaTipController != null) {
                    if (this.f17915f.cacheAlaTag == null || this.f17915f.mAlaTipController == null || this.f17915f.alaUserPhotoLayout == null || this.f17915f.alaUserPhotoLayout.getVisibility() != 0) {
                        this.f17915f.dismissAlaTip();
                        return;
                    }
                    this.f17915f.mAlaTipController.l0(this.f17914e);
                    this.f17915f.cacheAlaTag = null;
                    return;
                }
                ImageViewerActivity imageViewerActivity = this.f17915f;
                imageViewerActivity.mAlaTipController = new d.a.s0.e0.e(imageViewerActivity.getPageContext(), this.f17915f.alaUserPhotoAnimView);
                this.f17915f.mAlaTipController.g0(R.drawable.bg_tip_blue_up);
                this.f17915f.mAlaTipController.O(32);
                this.f17915f.mAlaTipController.h0(true);
                this.f17915f.mAlaTipController.W(1);
                this.f17915f.mAlaTipController.j0(0);
                this.f17915f.mAlaTipController.N(3000);
                this.f17915f.mAlaTipController.M(new a(this));
                if (this.f17915f.alaUserPhotoLayout == null || this.f17915f.alaUserPhotoLayout.getVisibility() == 0) {
                    this.f17915f.mAlaTipController.l0(this.f17914e);
                    return;
                }
                this.f17915f.cacheAlaTag = this.f17914e;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends d.a.r0.k0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17917a;

        public j(ImageViewerActivity imageViewerActivity) {
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
            this.f17917a = imageViewerActivity;
        }

        @Override // d.a.r0.k0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.r0.k0.e.b().c() : invokeV.intValue;
        }

        @Override // d.a.r0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17918a;

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
            this.f17918a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.f17918a.mNavigationBar.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                this.f17918a.dismissAlaTip();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17919a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ImageViewerActivity imageViewerActivity, int i2) {
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
            this.f17919a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.s0.h3.h0.e) || this.f17919a.assistUrls == null || (agreeData = ((d.a.s0.h3.h0.e) customResponsedMessage.getData()).f61216b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : this.f17919a.assistUrls.values()) {
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

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17920a;

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
            this.f17920a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.s0.h3.h0.e) || this.f17920a.assistUrls == null || (agreeData = ((d.a.s0.h3.h0.e) customResponsedMessage.getData()).f61216b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : this.f17920a.assistUrls.values()) {
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

    /* loaded from: classes5.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17921a;

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
            this.f17921a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.r0.t.m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.r0.t.m) || (mVar = (d.a.r0.t.m) customResponsedMessage.getData()) == null || StringUtils.isNull(mVar.f56722a)) {
                return;
            }
            d.a.r0.p0.b.i(mVar);
            if (StringUtils.isNull(mVar.f56724c)) {
                UrlManager.getInstance().dealOneLink(this.f17921a.getPageContext(), new String[]{mVar.f56722a});
            } else {
                UrlManager.getInstance().dealOneLink(this.f17921a.getPageContext(), new String[]{mVar.f56722a, mVar.f56724c});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17922a;

        public o(ImageViewerActivity imageViewerActivity) {
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
            this.f17922a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageViewerActivity imageViewerActivity = this.f17922a;
                imageViewerActivity.setViewVisibility(imageViewerActivity.mTitleView, 8);
                ImageViewerActivity imageViewerActivity2 = this.f17922a;
                imageViewerActivity2.setViewVisibility(imageViewerActivity2.hostAllSwitch, 8);
                ImageViewerActivity imageViewerActivity3 = this.f17922a;
                imageViewerActivity3.setViewVisibility(imageViewerActivity3.mBackLogo, 8);
                ImageViewerActivity imageViewerActivity4 = this.f17922a;
                imageViewerActivity4.setViewVisibility(imageViewerActivity4.alaUserPhotoLayout, 8);
                if (this.f17922a.mViewpager != null) {
                    this.f17922a.mViewpager.A(false);
                }
                this.f17922a.dissmissPictureTip();
                this.f17922a.dismissAlaTip();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.f17922a.mViewpager.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.f17922a.mViewpager.getCurrentMaxIndex()));
                this.f17922a.finish();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.f17922a;
                imageViewerActivity.setViewVisibility(imageViewerActivity.mTitleView, 0);
                this.f17922a.mBackLogo.setVisibility(0);
                if (this.f17922a.mViewpager == null || this.f17922a.checkIsAdvertPage()) {
                    return;
                }
                boolean t = this.f17922a.mViewpager.t();
                if ("portrait".equals(this.f17922a.mFrom) || t) {
                    return;
                }
                ImageViewerActivity imageViewerActivity2 = this.f17922a;
                imageViewerActivity2.setViewVisibility(imageViewerActivity2.hostAllSwitch, 0);
                ImageViewerActivity imageViewerActivity3 = this.f17922a;
                imageViewerActivity3.setViewVisibility(imageViewerActivity3.alaUserPhotoLayout, 0);
                ImageViewerActivity imageViewerActivity4 = this.f17922a;
                imageViewerActivity4.showAlaTip(imageViewerActivity4.cacheAlaTag);
                if (this.f17922a.mIsShowBottomContainer) {
                    this.f17922a.mViewpager.A(true);
                } else {
                    this.f17922a.mViewpager.A(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17923e;

        /* loaded from: classes5.dex */
        public class a implements c.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ p f17924a;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17924a = pVar;
            }

            @Override // d.a.s0.u0.f2.a.c.d
            public void a(boolean z, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                }
            }

            @Override // d.a.s0.u0.f2.a.c.d
            public void b(boolean z) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || !z || this.f17924a.f17923e.editorController == null || this.f17924a.f17923e.mViewpager.getCurrentUrlDragImageView() == null) {
                    return;
                }
                this.f17924a.f17923e.editorController.u(this.f17924a.f17923e.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData(), this.f17924a.f17923e.mGetImageHelper);
            }

            @Override // d.a.s0.u0.f2.a.c.d
            public void c(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                }
            }
        }

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
            this.f17923e = imageViewerActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v28, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "3").param("post_id", this.f17923e.mTid).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f17923e.mFid));
                if (d.a.r0.f0.f.a(this.f17923e)) {
                    if (this.f17923e.mProfessionController == null) {
                        ImageViewerActivity imageViewerActivity = this.f17923e;
                        imageViewerActivity.mProfessionController = new d.a.s0.u0.f2.a.c(imageViewerActivity.getPageContext());
                        this.f17923e.mProfessionController.j(new a(this));
                    }
                    this.f17923e.mProfessionController.k(((this.f17923e.mViewpager == null || this.f17923e.mViewpager.getCurrentUrlDragImageView() == null || this.f17923e.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? 1 : this.f17923e.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost) ^ 1);
                    this.f17923e.mProfessionController.h(this.f17923e.mFid, d.a.c.e.m.b.f(this.f17923e.mTid, 0L));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements UrlDragImageView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17925a;

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
            this.f17925a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.f17925a.mTid).param("obj_type", this.f17925a.mFrom));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17926a;

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
            this.f17926a = imageViewerActivity;
        }

        @Override // d.a.s0.k1.c.b
        public void a(ArrayList<String> arrayList, int i2, int i3, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) == null) || this.f17926a.mViewpager == null) {
                return;
            }
            if (this.f17926a.mIsClick) {
                if (!z3) {
                    this.f17926a.mViewpager.removeAllViews();
                    this.f17926a.mIndex = 0;
                    this.f17926a.initViewPager();
                    ImageViewerActivity imageViewerActivity = this.f17926a;
                    imageViewerActivity.mIsSeeHost = !imageViewerActivity.mIsSeeHost;
                } else if (!this.f17926a.mIsSeeHost) {
                    this.f17926a.showToast(R.string.image_view_change_img_error);
                }
            }
            this.f17926a.mIsClick = false;
            if (this.f17926a.hostAllSwitch != null) {
                this.f17926a.hostAllSwitch.setEnabled(true);
            }
            this.f17926a.hideProgressBar();
            if (z2 && this.f17926a.mViewpager.getCurrentItem() <= 4) {
                int itemNum = this.f17926a.mViewpager.getItemNum();
                this.f17926a.mViewpager.setTempSize(itemNum + 100);
                this.f17926a.mViewpager.setCurrentItem(itemNum + 90, false);
                this.f17926a.mViewpager.setTempSize(0);
            }
            this.f17926a.mViewpager.setUrlData(arrayList);
            this.f17926a.mViewpager.setAssistUrls(this.f17926a.assistUrls);
            this.f17926a.mViewpager.setHasNext(z);
            if (this.f17926a.isFunAdABTest) {
                int Y = this.f17926a.mGetImageHelper.Y();
                if (this.f17926a.mFunAdPageProvider != null) {
                    this.f17926a.mFunAdPageProvider.w(ListUtils.getCount(arrayList), i3);
                    this.f17926a.mFunAdPageProvider.s(Y, i3, this.f17926a.mIndex, this.f17926a.mTid, this.f17926a.mFid);
                }
            } else if (advertAppInfo != null && arrayList != null && this.f17926a.mApPageProvier != null) {
                AdvertAppInfo.e4.set(true);
                int w4 = advertAppInfo.w4();
                if (w4 == 0) {
                    this.f17926a.mApPageProvier.h(advertAppInfo, arrayList.size());
                } else {
                    this.f17926a.reportAdDiscardLog(advertAppInfo, w4);
                }
            }
            this.f17926a.mViewpager.setNextTitle(str);
            if (i2 < 0 || i2 >= this.f17926a.mViewpager.getItemNum()) {
                this.f17926a.mViewpager.u(this.f17926a.mViewpager.getCurrentItem());
            } else {
                this.f17926a.mViewpager.setCurrentItem(i2, false);
            }
            if (i3 != 0) {
                this.f17926a.mCount = i3;
            }
            if (arrayList != null && arrayList.size() >= 400 && this.f17926a.mViewpager.getCurrentItem() > 200) {
                for (int i4 = 0; i4 < 200; i4++) {
                    arrayList.remove(0);
                }
                this.f17926a.mViewpager.setUrlData(arrayList);
                this.f17926a.mViewpager.setCurrentItem(this.f17926a.mViewpager.getCurrentItem() - 200, false);
            }
            if (this.f17926a.getCurrentOverAllIndex() != 1) {
                this.f17926a.setSwipeBackEnabled(false);
            }
            if (this.f17926a.isFunAdABTest) {
                d(arrayList, i3);
            } else {
                c(arrayList, advertAppInfo);
            }
            this.f17926a.updateNavigationTitle();
            if (this.f17926a.editorController != null && this.f17926a.mViewpager.getCurrentUrlDragImageView() != null) {
                this.f17926a.editorController.q(this.f17926a.mViewpager.getCurrentUrlDragImageView().getmAssistUrlData(), this.f17926a.mGetImageHelper);
            }
            ImageViewerActivity imageViewerActivity2 = this.f17926a;
            imageViewerActivity2.triggerBannerAd(imageViewerActivity2.mViewpager.getCurrentItem());
            if (this.f17926a.firstImagePv) {
                this.f17926a.firstImagePv = false;
                this.f17926a.imagePv();
            }
        }

        @Override // d.a.s0.k1.c.b
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f17926a.mIsClick = false;
                if (this.f17926a.hostAllSwitch != null) {
                    if (this.f17926a.hostAllSwitch.getState() != this.f17926a.mIsSeeHost && TextUtils.isEmpty(str)) {
                        this.f17926a.showToast(R.string.image_view_change_img_error);
                    }
                    this.f17926a.hostAllSwitch.u(this.f17926a.mIsSeeHost ? 1 : 0);
                    this.f17926a.hostAllSwitch.setEnabled(true);
                }
                this.f17926a.hideProgressBar();
                this.f17926a.showToast(str);
                if (i2 == 40) {
                    if (this.f17926a.mImageUrls != null) {
                        ImageViewerActivity imageViewerActivity = this.f17926a;
                        imageViewerActivity.mCount = imageViewerActivity.mImageUrls.size();
                    }
                    this.f17926a.updateNavigationTitle();
                }
                if (this.f17926a.firstImagePv) {
                    this.f17926a.firstImagePv = false;
                    this.f17926a.imagePv();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.f17926a.mApPageProvier != null && advertAppInfo != null && arrayList != null) {
                    int w4 = advertAppInfo.w4();
                    if (w4 != 0) {
                        this.f17926a.reportAdDiscardLog(advertAppInfo, w4);
                        return;
                    }
                    this.f17926a.mApPageProvier.h(advertAppInfo, arrayList.size());
                    if (this.f17926a.mApPageProvier.d()) {
                        this.f17926a.setAddSize(1);
                        TiebaStatic.log(d.a.s0.g3.a.h("a008", "common_fill", true, 1));
                        return;
                    }
                    this.f17926a.setAddSize(0);
                    return;
                }
                this.f17926a.setAddSize(0);
            }
        }

        public final void d(ArrayList<String> arrayList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, arrayList, i2) == null) {
                if (this.f17926a.mFunAdPageProvider != null && arrayList != null) {
                    if (this.f17926a.mFunAdPageProvider.n()) {
                        this.f17926a.mFunAdPageProvider.w(ListUtils.getCount(arrayList), i2);
                        this.f17926a.setAddSize(1);
                        return;
                    }
                    this.f17926a.setAddSize(0);
                    return;
                }
                this.f17926a.setAddSize(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17927a;

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
            this.f17927a = imageViewerActivity;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (i2 & 4) == 0) {
                this.f17927a.setFullScreen();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17928e;

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
            this.f17928e = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17928e.isFunAdABTest && this.f17928e.checkIsAdvertPage() && this.f17928e.mFunAdPageProvider.o()) {
                    StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", "a008").eventStat();
                }
                this.f17928e.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageViewerActivity f17929a;

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
            this.f17929a = imageViewerActivity;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (d.a.c.e.p.j.A()) {
                    this.f17929a.mIsClick = true;
                    if (this.f17929a.hostAllSwitch != null) {
                        this.f17929a.hostAllSwitch.setEnabled(false);
                    }
                    String a2 = d.a.s0.k1.a.a((String) ListUtils.getItem(this.f17929a.mImageUrls, this.f17929a.mIndex));
                    ImageViewerActivity imageViewerActivity = this.f17929a;
                    imageViewerActivity.initImageHelper(a2, !imageViewerActivity.mIsSeeHost, true);
                    TiebaStatic.log(new StatisticItem("c13857").param("obj_type", this.f17929a.mIsSeeHost ? 7 : 8).param("post_id", this.f17929a.mTid).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f17929a.mFid));
                    return true;
                }
                this.f17929a.showToast(R.string.neterror);
                return false;
            }
            return invokeI.booleanValue;
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
        this.mApPageProvier = null;
        this.isFunAdABTest = d.a.r0.b.d.D();
        this.mIsNavigationBarVisibilitySaved = false;
        this.mSavedNavigationBarVisibility = false;
        this.currentPosition = 0;
        this.mIsStaticLast = false;
        this.mIsShowAp = true;
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
        this.mToHotTopicListener = new n(this, 2016493);
        this.mDragToExitListener = new o(this);
        this.onReplyButtonClickListener = new p(this);
        this.mOriImgSelectedCallback = new q(this);
        this.onHostViewSwitchChangeListener = new u(this);
        this.mOnClickListener = new b(this);
        this.mOuterOnTouchListener = new c(this);
        this.mShowMenuListener = new d(this);
        this.mScrollOutListener = new e(this);
        this.mPageChangeListener = new f(this);
        this.userPhotoOnClickListener = new g(this);
        this.mThreadAgreeChangedListener = new l(this, 2016528);
        this.mPostAgreeChangedListener = new m(this, 2016530);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIsAdvertPage() {
        InterceptResult invokeV;
        d.a.s0.k1.k.b bVar;
        d.a.s0.k1.b bVar2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) ? this.isFunAdABTest ? this.mIsShowAp && (bVar2 = this.mFunAdPageProvider) != null && bVar2.m() && this.mViewpager.getItemNum() != 1 && this.mIndex == this.mViewpager.getItemNum() - 1 : this.mIsShowAp && (bVar = this.mApPageProvier) != null && bVar.d() && this.mViewpager.getItemNum() != 1 && this.mIndex == this.mViewpager.getItemNum() - 1 : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAlaTip() {
        d.a.s0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65594, this) == null) || (eVar = this.mAlaTipController) == null) {
            return;
        }
        eVar.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dissmissPictureTip() {
        d.a.s0.e0.e eVar;
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
                    this.alaUserPhotoAnimView.post(new h(this));
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
            addSystemImageButton.setOnClickListener(new t(this));
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
            this.mImageViewerStatisticController = new d.a.s0.k1.h();
            boolean e2 = d.a.r0.f0.f.e();
            String b2 = d.a.r0.f0.f.b();
            String d2 = d.a.r0.f0.f.d();
            String c2 = d.a.r0.f0.f.c();
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
                    this.mIsYoungsterMode = intent.getBooleanExtra(ImageViewerConfig.IS_YOUNGSTER_MODE, false);
                } else {
                    z = e2;
                    str = b2;
                    str2 = d2;
                    str3 = c2;
                }
            }
            d.a.r0.f0.f.h(z);
            d.a.r0.f0.f.g(str);
            d.a.r0.f0.f.i(str3);
            d.a.r0.f0.f.j(str2);
            this.mImageViewerStatisticController.d(bundle, getIntent());
            this.mCount = ListUtils.getCount(this.mImageUrls);
            if (this.mSourceImageRectInScreen != null) {
                String str4 = (String) ListUtils.getItem(this.mImageUrls, this.mIndex);
                if (!StringUtils.isNull(str4) && (map = this.assistUrls) != null && (imageUrlData = map.get(str4)) != null) {
                    imageUrlData.setSourceImageRectInScreen(this.mSourceImageRectInScreen);
                }
            }
            this.mDragPicId = this.mIsBJHThread ? null : d.a.s0.k1.a.a((String) ListUtils.getItem(this.mImageUrls, this.mIndex));
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
            d.a.s0.k1.j.c cVar = new d.a.s0.k1.j.c(getPageContext(), this.replyToolRoot);
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
            d.a.s0.h3.h0.r rVar = new d.a.s0.h3.h0.r();
            rVar.c(0);
            rVar.d(getString(R.string.all));
            arrayList.add(rVar);
            d.a.s0.h3.h0.r rVar2 = new d.a.s0.h3.h0.r();
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
            d.a.s0.k1.c cVar = new d.a.s0.k1.c(this.mImageUrls, this.assistUrls, this.mFid, this.mFname, this.mTid, this.mNid, str, this.mUserId, this.mFrom, this.mThreadType, z2, this.mCardType, this.mRecomSource, this.mRecomAbTag, this.mRecomWeight, this.mRecomExtra);
            this.mGetImageHelper = cVar;
            cVar.h0(this.mSourceImageRectInScreen);
            this.mGetImageHelper.f0(this.mIsOrdinal);
            this.mGetImageHelper.g0(z);
            this.mGetImageHelper.Z(this.mDragPicId);
            this.mGetImageHelper.c0(this.mIsGodreplyImage);
            this.mGetImageHelper.e0(this.mPostId);
            this.mGetImageHelper.b0(this.mIsDynamicCard);
            this.mGetImageHelper.d0(new r(this));
            this.mGetImageHelper.a0(true);
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
            d.a.r0.r.u.c.d(this.mTitleView).w(R.array.S_O_X001);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleView, (View.OnClickListener) null);
            if (d.a.s0.k1.a.b((String) ListUtils.getItem(this.mImageUrls, this.mIndex))) {
                this.mNavigationBar.setVisibility(0);
            }
        }
    }

    private void initPicAdDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65607, this) == null) {
            d.a.s0.k1.k.c cVar = new d.a.s0.k1.k.c(this.mImageUrls, this.mFid, this.mFname);
            this.mAdPicPageDispatcher = cVar;
            cVar.b();
        }
    }

    private void initStatusBarView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65608, this) == null) && DeviceInfoUtil.isfullScreen()) {
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
        if (interceptable == null || interceptable.invokeV(65609, this) == null) {
            initNavigationBar();
            this.mMoreDialogController = new d.a.s0.k1.i(this);
            initViewPager();
            this.mMoreDialogController.v(this.mViewpager);
            updateNavigationTitle();
            showGuideTip();
            initStatusBarView();
            initEditor();
            d.a.s0.k1.h hVar = this.mImageViewerStatisticController;
            ArrayList<String> arrayList = this.mImageUrls;
            int i2 = this.mIndex;
            hVar.c(arrayList, i2, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65610, this) == null) {
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
                d.a.s0.k1.b bVar = new d.a.s0.k1.b(this, this.mIsShowAp);
                this.mFunAdPageProvider = bVar;
                bVar.u(this.mDragToExitListener);
                this.mViewpager.k(this.mFunAdPageProvider);
            } else {
                d.a.s0.k1.k.b bVar2 = new d.a.s0.k1.k.b(this.mIsCdn, this.mIsShowAp, getPageContext(), this.mFid, this.mTid);
                this.mApPageProvier = bVar2;
                bVar2.g(this.mDragToExitListener);
                this.mViewpager.k(this.mApPageProvier);
            }
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
        if (interceptable == null || interceptable.invokeV(65611, this) == null) {
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
        if (interceptable == null || interceptable.invokeLI(65612, this, advertAppInfo, i2) == null) {
            d.a.s0.w2.i0.c b2 = d.a.s0.w2.i0.g.b(advertAppInfo, 5, 0);
            b2.j(i2);
            d.a.s0.w2.i0.e.b().d(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65613, this) == null) {
            getWindow().getDecorView().setSystemUiVisibility(1284);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisibility(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65614, this, view, i2) == null) || view == null) {
            return;
        }
        view.clearAnimation();
        view.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlaTip(@NonNull String str) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65615, this, str) == null) || (tBLottieAnimationView = this.alaUserPhotoAnimView) == null) {
            return;
        }
        tBLottieAnimationView.post(new i(this, str));
    }

    private void showGuideTip() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65616, this) == null) || this.mIsFromAiApp || this.hostAllSwitch == null) {
            return;
        }
        if (this.mPictureTipController == null) {
            d.a.s0.e0.e eVar = new d.a.s0.e0.e(getPageContext(), this.hostAllSwitch);
            this.mPictureTipController = eVar;
            eVar.g0(R.drawable.pic_sign_tip);
            this.mPictureTipController.O(48);
            this.mPictureTipController.h0(true);
            this.mPictureTipController.N(5000);
            this.mPictureTipController.j0(-d.a.c.e.p.l.g(getPageContext().getPageActivity(), R.dimen.tbds26));
            this.mPictureTipController.M(new a(this));
        }
        this.mPictureTipController.m0(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
    }

    private void startLoadPortrait(TbImageView tbImageView, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65617, this, tbImageView, str) == null) || tbImageView == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65618, this)) == null) {
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
        if (interceptable == null || interceptable.invokeI(65619, this, i2) == null) {
            if (this.mAdBannerDispatcher == null) {
                AdvertAppInfo.e4.set(true);
                this.mAdBannerDispatcher = new d.a.s0.k1.k.a((ViewStub) findViewById(R.id.ad_banner_view_stub), getPageContext());
            }
            this.mAdBannerDispatcher.c(this.mViewpager, this.mIsSeeHost, i2, checkIsAdvertPage(), i2 < this.mImageUrls.size() ? this.mImageUrls.get(i2) : "", this.mCount, this.mFid, this.mFname, this.mTid);
        }
    }

    private void updateAlaLiveLayout(int i2) {
        d.a.s0.k1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65620, this, i2) == null) || (cVar = this.mGetImageHelper) == null) {
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
        if (!(interceptable == null || interceptable.invokeI(65621, this, i2) == null) || (multiImageView = this.mViewpager) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(65622, this) == null) || this.mImageUrls == null) {
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
        if (interceptable == null || interceptable.invokeV(65623, this) == null) {
            this.mTitleView.setText("");
            setViewVisibility(this.hostAllSwitch, 8);
            setViewVisibility(this.alaUserPhotoLayout, 8);
        }
    }

    private void updateNavigationTitlePic(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65624, this, str) == null) {
            this.mTitleView.setText(str);
            if (this.mIsShowHost && !this.mIsFromAiApp && (sortSwitchButton = this.hostAllSwitch) != null) {
                sortSwitchButton.u(this.mIsSeeHost ? 1 : 0);
            }
            d.a.r0.r.u.c.d(this.mTitleView).w(R.array.S_O_X001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigationVisibility() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65625, this) == null) {
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
            if (d.a.r0.z0.l.a()) {
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

    @Override // com.baidu.tbadk.BaseActivity, d.a.r0.k0.a
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
    public d.a.r0.k0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.a.r0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.q(d.a.c.e.m.b.f(this.mFid, 0L));
                pageStayDurationItem.y(d.a.c.e.m.b.f(this.mTid, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.n(TbadkCoreApplication.getInst().getAdAdSense().r);
                }
            }
            return pageStayDurationItem;
        }
        return (d.a.r0.k0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.r0.k0.a
    public d.a.r0.k0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new j(this) : (d.a.r0.k0.b) invokeV.objValue;
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
            d.a.s0.k1.i iVar = this.mMoreDialogController;
            if (iVar != null) {
                iVar.x();
            }
            d.a.s0.k1.j.c cVar = this.editorController;
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
            d.a.r0.f0.h.f().g(TbadkCoreApplication.getInst());
            this.skinTypeRecord = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            initData(bundle);
            setContentView(R.layout.image_activity_2);
            initUi();
            initPicAdDispatcher();
            initImageHelper(this.mDragPicId, this.mIsSeeHost, false);
            registerListener(this.mToHotTopicListener);
            registerListener(this.hideNavbarListener);
            registerListener(this.mThreadAgreeChangedListener);
            registerListener(this.mPostAgreeChangedListener);
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                d.a.s0.t3.c.b(1, getWindow().getAttributes(), getWindow());
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
            d.a.r0.a0.c.k().r();
            d.a.s0.k1.h hVar = this.mImageViewerStatisticController;
            ArrayList<String> arrayList = this.mImageUrls;
            int i2 = this.mIndex;
            hVar.c(arrayList, i2, i2);
            this.mImageViewerStatisticController.g();
            d.a.s0.k1.k.b bVar = this.mApPageProvier;
            String c2 = bVar != null ? bVar.c() : "";
            d.a.s0.k1.c cVar = this.mGetImageHelper;
            if (cVar != null) {
                str = cVar.U();
                str2 = this.mGetImageHelper.X();
            } else {
                str = null;
                str2 = null;
            }
            this.mImageViewerStatisticController.j(this.mViewpager.getPageCount(), c2, this.mFid, this.mTid, str, str2);
            d.a.s0.k1.i iVar = this.mMoreDialogController;
            if (iVar != null) {
                iVar.A();
            }
            this.mViewpager.v();
            this.editorController.n();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d.a.r0.v.d.j().h(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.skinTypeRecord);
            dissmissPictureTip();
            dismissAlaTip();
            d.a.s0.k1.k.b bVar2 = this.mApPageProvier;
            if (bVar2 != null) {
                bVar2.f();
            }
            d.a.s0.k1.k.a aVar = this.mAdBannerDispatcher;
            if (aVar != null) {
                aVar.b();
            }
            d.a.s0.k1.b bVar3 = this.mFunAdPageProvider;
            if (bVar3 != null) {
                bVar3.r();
            }
            d.a.r0.f0.h.i(new PrePageKeyEvent(getCurrentPageKey()));
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
                d.a.r0.a.t.f(uniqueId.getId(), f2);
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
            this.mIsLogin = d.a.r0.f0.f.e();
            BdUniqueId uniqueId = getUniqueId();
            long f2 = d.a.c.e.m.b.f(this.mTid, 0L);
            if (uniqueId != null && f2 > 0) {
                d.a.r0.a.t.j(d.a.r0.a.c.a0, uniqueId.getId(), f2);
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
            bundle.putBoolean(ImageViewerConfig.IS_LOGIN, d.a.r0.f0.f.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, d.a.r0.f0.f.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, d.a.r0.f0.f.c());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, d.a.r0.f0.f.d());
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
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new s(this));
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
