package com.baidu.tieba.videoplay.videoLive;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.kernel.YYVideoKernel;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.BasicVideoSeriesKt;
import com.baidu.searchbox.player.model.OptionState;
import com.baidu.searchbox.player.util.YYUtil;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.cz9;
import com.baidu.tieba.ei;
import com.baidu.tieba.fva;
import com.baidu.tieba.gva;
import com.baidu.tieba.k36;
import com.baidu.tieba.na5;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.tw5;
import com.baidu.tieba.ul5;
import com.baidu.tieba.ve5;
import com.baidu.tieba.video.LiveConfig;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.view.EnterLiveRoomBtn;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.tieba.xua;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
/* loaded from: classes8.dex */
public class VideoLiveFragment extends BaseFragment implements k36.b, fva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoPlayFragment.g1 A;
    public boolean B;
    public boolean C;
    public boolean D;
    public OnStatusChangedListener.VideoStatus E;
    public boolean F;
    public OnStatusChangedListener G;
    public final CustomMessageListener H;
    public final CustomMessageListener I;
    public final View.OnTouchListener J;
    public final GestureDetectorCompat K;
    public View.OnClickListener L;
    public final cz9 M;
    public LinearLayout a;
    public RelativeLayout b;
    public TbVideoView c;
    public RelativeLayout.LayoutParams d;
    public View e;
    public VideoItemData f;
    public HeadImageView g;
    public TextView h;
    public VideoItemModel i;
    public TBSpecificationBtn j;
    public ExpandableTextView k;
    public EnterLiveRoomBtn l;
    public TextView m;
    public TbImageView n;
    public LinearLayout o;
    public LinearLayout p;
    public TextView q;
    public ImageView r;
    public ImageView s;
    public TBLottieAnimationView t;
    public LiveConfig u;
    public ve5 v;
    public BdUniqueId w;
    public gva x;
    public String y;
    public int z;

    @Override // com.baidu.tieba.fva
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.k36.b
    public void D0(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    @Override // com.baidu.tieba.fva
    public void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.fva
    public VideoItemModel Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (VideoItemModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k36.b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLiveFragment a;

        public a(VideoLiveFragment videoLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLiveFragment;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                this.a.E = videoStatus;
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_ERROR) {
                    this.a.E2(0);
                    this.a.B = false;
                    if (this.a.C && !this.a.D && this.a.A != null) {
                        this.a.A.a();
                    }
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.a.B = true;
                    this.a.E2(1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoLiveFragment videoLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLiveFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoLiveFragment videoLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLiveFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.getActivity() != null) {
                this.a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLiveFragment a;

        public d(VideoLiveFragment videoLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLiveFragment;
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return this.a.K.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLiveFragment a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public e(VideoLiveFragment videoLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLiveFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (motionEvent.getX() - motionEvent2.getX() > 50.0f) {
                    this.a.onViewDragToRight();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLiveFragment a;

        public f(VideoLiveFragment videoLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLiveFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != this.a.g && view2 != this.a.h) {
                    if (view2 != this.a.j) {
                        this.a.z2("clk_into_live");
                        return;
                    } else {
                        this.a.q2();
                        return;
                    }
                }
                this.a.x.d(this.a.z, this.a.y, 1, 2);
                this.a.y2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements cz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLiveFragment a;

        public g(VideoLiveFragment videoLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLiveFragment;
        }

        @Override // com.baidu.tieba.cz9
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && this.a.u != null && this.a.u.getCutList() != null) {
                int intValue = this.a.u.getCutList().get(LiveConfig.CUT_LIST_VERTICAL_KEY).intValue();
                int intValue2 = this.a.u.getCutList().get(LiveConfig.CUT_LIST_HORIZONTAL_KEY).intValue();
                if (i2 / i >= this.a.u.getVerticalHorizontalBoundary()) {
                    this.a.F = true;
                    if (UtilHelper.isOppoFoldLargeScreen(this.a.getContext())) {
                        this.a.C2(2);
                        return;
                    } else {
                        this.a.C2(intValue);
                        return;
                    }
                }
                this.a.F = false;
                this.a.C2(intValue2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements EnterLiveRoomBtn.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLiveFragment a;

        public h(VideoLiveFragment videoLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLiveFragment;
        }

        @Override // com.baidu.tieba.videoplay.view.EnterLiveRoomBtn.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (1 == i) {
                    this.a.x.d(this.a.z, this.a.y, 4, 2);
                    this.a.z2("clk_into_live");
                } else if (2 == i) {
                    this.a.x.c(this.a.z, this.a.y, 2);
                    this.a.z2("auto_into_live");
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.view.EnterLiveRoomBtn.b
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.x.d(this.a.z, this.a.y, 3, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends CustomTarget<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLiveFragment a;

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            }
        }

        public i(VideoLiveFragment videoLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLiveFragment;
        }

        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, transition) == null) {
                this.a.s.setImageBitmap(tw5.a(bitmap, 15, false));
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }
    }

    public VideoLiveFragment() {
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
        this.v = null;
        this.w = BdUniqueId.gen();
        this.B = true;
        this.C = false;
        this.D = false;
        this.F = false;
        this.G = new a(this);
        this.H = new b(this, 2001011);
        this.I = new c(this, 2921612);
        this.J = new d(this);
        this.K = new GestureDetectorCompat(getContext(), new e(this));
        this.L = new f(this);
        this.M = new g(this);
    }

    public final void y2() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (videoItemData = this.f) != null && (userItemData = videoItemData.author_info) != null) {
            long j = JavaTypesHelper.toLong(userItemData.user_id, 0L);
            long j2 = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (j == j2) {
                z = true;
            } else {
                z = false;
            }
            if (j == 0 && j2 == 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            String str = this.f.author_info.portrait;
            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getActivity()).createNormalConfig(j, z2, false, true, PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
            createNormalConfig.setPortrait(str);
            createNormalConfig.setSourceTid(this.f.thread_id);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
        }
    }

    public void B2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.D = z;
        }
    }

    public final void C2(int i2) {
        TbVideoView tbVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (tbVideoView = this.c) != null) {
            tbVideoView.setVideoScalingMode(i2);
        }
    }

    public void D2(VideoPlayFragment.g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g1Var) == null) {
            this.A = g1Var;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.I);
            registerListener(this.H);
        }
    }

    public final void A2() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tBLottieAnimationView = this.t) != null) {
            tBLottieAnimationView.setVisibility(0);
            SkinManager.setLottieAnimation(this.t, R.raw.video_tab_attention_animation);
            if (!this.t.isAnimating()) {
                this.t.setSpeed(1.1f);
                this.t.playAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            TbVideoView tbVideoView = this.c;
            if (tbVideoView != null) {
                tbVideoView.T();
                this.c.M();
            }
            EnterLiveRoomBtn enterLiveRoomBtn = this.l;
            if (enterLiveRoomBtn != null) {
                enterLiveRoomBtn.f();
            }
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.H);
        }
    }

    public final void s2() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            VideoItemData videoItemData = this.f;
            if (videoItemData != null && (userItemData = videoItemData.author_info) != null && (userItemData == null || !"1".equals(userItemData.is_follow))) {
                this.j.setVisibility(0);
                this.j.setClickable(true);
                return;
            }
            this.j.setVisibility(4);
            this.j.setClickable(false);
        }
    }

    public final void E2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 == 0) {
                EnterLiveRoomBtn enterLiveRoomBtn = this.l;
                if (enterLiveRoomBtn != null) {
                    enterLiveRoomBtn.setVisibility(8);
                }
                ImageView imageView = this.s;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    Glide.with(this).asBitmap().load(this.f.getLivePageData().cover).into((RequestBuilder<Bitmap>) new i(this));
                }
                ImageView imageView2 = this.r;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                LinearLayout linearLayout = this.p;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else if (i2 == 1) {
                EnterLiveRoomBtn enterLiveRoomBtn2 = this.l;
                if (enterLiveRoomBtn2 != null) {
                    enterLiveRoomBtn2.setVisibility(0);
                }
                ImageView imageView3 = this.s;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                ImageView imageView4 = this.r;
                if (imageView4 != null) {
                    imageView4.setVisibility(8);
                }
                LinearLayout linearLayout2 = this.p;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            ul5.a(this.n, "enter_live_room_animation.png");
            SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f0809a2);
            EMManager.from(this.h).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X02).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.j).setCorner(R.string.J_X01).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X02).setBackGroundColor(R.color.CAM_X0302);
            EMManager.from(this.o).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0310);
            EMManager.from(this.m).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.q).setCorner(R.string.J_X04).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101).setBackGroundColor(R.color.CAM_X0615);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            LiveConfig liveConfig = this.u;
            if (liveConfig != null && liveConfig.getCutList() != null && UtilHelper.isFoldScreen()) {
                if (this.F) {
                    if (UtilHelper.isOppoFoldLargeScreen(getContext())) {
                        C2(2);
                        return;
                    } else {
                        C2(this.u.getCutList().get(LiveConfig.CUT_LIST_VERTICAL_KEY).intValue());
                        return;
                    }
                }
                C2(this.u.getCutList().get(LiveConfig.CUT_LIST_HORIZONTAL_KEY).intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.setUserVisibleHint(z);
            this.C = z;
            if (this.c != null) {
                if (z) {
                    if (this.E == OnStatusChangedListener.VideoStatus.VIDEO_ERROR) {
                        t2(false);
                    }
                    this.c.R(2);
                    this.c.setVolume(1.0f, 1.0f);
                    this.x.e(this.z, this.y, 2);
                    EnterLiveRoomBtn enterLiveRoomBtn = this.l;
                    if (enterLiveRoomBtn != null) {
                        enterLiveRoomBtn.h();
                        return;
                    }
                    return;
                }
                EnterLiveRoomBtn enterLiveRoomBtn2 = this.l;
                if (enterLiveRoomBtn2 != null) {
                    enterLiveRoomBtn2.d();
                }
                if (this.E != OnStatusChangedListener.VideoStatus.VIDEO_ERROR) {
                    this.c.pause();
                }
            }
        }
    }

    public final void z2(String str) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && this.B && (videoItemData = this.f) != null && videoItemData.getLivePageData() != null && this.f.getLivePageData().mYyExtData != null) {
            YyExtData yyExtData = this.f.getLivePageData().mYyExtData;
            xua.g("sp_live_into_id_", this.f.thread_id);
            YYLiveUtil.jumpToYYLiveRoom(getPageContext(), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", null, "video_immersion", str, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09f5, (ViewGroup) null);
            this.e = inflate;
            inflate.setOnTouchListener(this.J);
            this.a = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090462);
            this.b = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09294e);
            this.c = new TbVideoView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.d = layoutParams;
            layoutParams.bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            this.b.addView(this.c, 0, this.d);
            this.v = new ve5(null);
            v2();
            x2();
            w2();
            r2();
            t2(true);
            u2();
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroyView();
            HeadImageView headImageView = this.g;
            if (headImageView != null) {
                headImageView.setOnClickListener(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.k36.b
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            z2("clk_into_live");
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.x = new gva(this.f, this.u);
        }
    }

    public final void q2() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && ViewHelper.checkUpIsLogin(getActivity()) && this.j != null && (videoItemData = this.f) != null && (userItemData = videoItemData.author_info) != null && this.t != null) {
            this.v.j(true, userItemData.portrait, userItemData.user_id, false, "6", this.w, videoItemData.forum_id, "0", videoItemData.thread_id);
            this.x.d(this.z, this.y, 2, 2);
            s2();
            z2("clk_into_live");
            this.j.setVisibility(8);
            A2();
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.c.setVideoStatusChangeListener(this.G);
            this.c.setOnClickListener(this.L);
            this.c.setVideoStatData(this.x.f(this.z, this.y));
            this.c.setVideoSizeChangeListener(this.M);
            VideoItemData videoItemData = this.f;
            if (videoItemData != null && videoItemData.getLivePageData() != null) {
                if (UtilHelper.isOppoFoldLargeScreen(getContext())) {
                    C2(2);
                } else {
                    C2(this.f.getLivePageData().cutType);
                }
            }
        }
    }

    public final void x2() {
        Bundle arguments;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (arguments = getArguments()) != null && (arguments.get("video_data") instanceof VideoItemModel) && (arguments.get("live_config") instanceof LiveConfig)) {
            this.i = (VideoItemModel) arguments.get("video_data");
            this.u = (LiveConfig) arguments.get("live_config");
            VideoItemModel videoItemModel = this.i;
            String str = null;
            if (videoItemModel == null) {
                videoItemData = null;
            } else {
                videoItemData = videoItemModel.getVideoItemData();
            }
            this.f = videoItemData;
            LiveConfig liveConfig = this.u;
            if (videoItemData != null) {
                str = videoItemData.thread_id;
            }
            liveConfig.setCurrentId(str);
            this.y = arguments.getString("live_page_from");
            this.z = arguments.getInt("video_index");
        }
    }

    public final void r2() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (videoItemData = this.f) != null && videoItemData.author_info != null) {
            if (this.k != null) {
                this.k.setData(videoItemData.getTitle(), true, null);
                this.k.setOnClickListener(this.L);
            }
            TextView textView = this.h;
            if (textView != null) {
                textView.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.f.author_info.getUserShowName(), 16, "..."));
                this.h.setOnClickListener(this.L);
            }
            if (this.g != null) {
                if (!StringUtils.isNull(this.f.author_info.portrait) && this.f.author_info.portrait.startsWith("http")) {
                    this.g.startLoad(this.f.author_info.portrait, 10, false);
                } else {
                    this.g.startLoad(this.f.author_info.portrait, 12, false);
                }
                this.g.setOnClickListener(this.L);
            }
            EnterLiveRoomBtn enterLiveRoomBtn = this.l;
            if (enterLiveRoomBtn != null) {
                enterLiveRoomBtn.c(this.u);
                this.l.setEnterLiveRoomCallback(new h(this));
            }
            if (this.q != null) {
                if (this.f.getLivePageData() != null && !ei.isEmpty(this.f.getLivePageData().user_label_text)) {
                    this.q.setVisibility(0);
                    this.q.setText(this.f.getLivePageData().user_label_text);
                } else {
                    this.q.setVisibility(8);
                }
                this.q.setOnClickListener(this.L);
            }
            s2();
        }
    }

    public final void t2(boolean z) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && (videoItemData = this.f) != null && videoItemData.author_info != null && videoItemData.getLivePageData() != null) {
            BasicVideoSeries basicVideoSeries = BasicVideoSeriesKt.toBasicVideoSeries(this.f.getLivePageData().flv_url, true);
            basicVideoSeries.setKernelType(YYVideoKernel.KERNEL_TYPE_YY);
            YYUtil.setYYBufferSize(basicVideoSeries, 10);
            basicVideoSeries.setPreRenderOptionState(OptionState.ENABLE);
            this.c.setVideoSeries(basicVideoSeries, z);
        }
    }

    public final void v2() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (view2 = this.e) != null) {
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09030a);
            this.g = headImageView;
            headImageView.setDefaultResource(17170445);
            this.g.setPlaceHolder(2);
            this.g.setIsRound(true);
            this.g.setBorderWidth(R.dimen.L_X02);
            this.g.setBorderColor(R.color.CAM_X0622);
            this.g.setDrawBorder(true);
            this.g.setUseNightOrDarkMask(false);
            this.h = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0928fd);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f09169b);
            this.j = tBSpecificationBtn;
            tBSpecificationBtn.setText(getString(R.string.obfuscated_res_0x7f0f02ea));
            this.j.setOnClickListener(this.L);
            na5 na5Var = new na5();
            UtilHelper.addFollowUserIconStyle(na5Var);
            na5Var.i(R.color.CAM_X0101);
            na5Var.o(0, 0);
            na5Var.p(0);
            na5Var.m(true);
            na5Var.k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds145), BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60));
            this.j.setConfig(na5Var);
            ExpandableTextView expandableTextView = (ExpandableTextView) this.e.findViewById(R.id.obfuscated_res_0x7f0915fc);
            this.k = expandableTextView;
            expandableTextView.setTextSize(BdUtilHelper.getDimens(getContext(), R.dimen.T_X07));
            this.k.setTextColor(R.color.CAM_X0621);
            this.k.setLineSpacingExtra(BdUtilHelper.getDimens(getContext(), R.dimen.tbds10));
            this.k.setExpandable(false);
            this.k.setTextMaxLine(3);
            this.k.setLimitLine(3);
            this.o = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09160e);
            this.p = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0915e2);
            this.l = (EnterLiveRoomBtn) this.e.findViewById(R.id.obfuscated_res_0x7f090a26);
            this.m = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0915e1);
            this.n = (TbImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09160c);
            this.q = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0915fd);
            this.r = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f0915e4);
            this.s = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091578);
            this.t = (TBLottieAnimationView) this.e.findViewById(R.id.obfuscated_res_0x7f0902f3);
        }
    }
}
