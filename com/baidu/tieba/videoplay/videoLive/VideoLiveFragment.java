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
import com.baidu.tieba.aba;
import com.baidu.tieba.dw5;
import com.baidu.tieba.ka5;
import com.baidu.tieba.o75;
import com.baidu.tieba.pi9;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.qe5;
import com.baidu.tieba.raa;
import com.baidu.tieba.tg;
import com.baidu.tieba.ui;
import com.baidu.tieba.uk5;
import com.baidu.tieba.vi;
import com.baidu.tieba.video.LiveConfig;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.videoplay.view.EnterLiveRoomBtn;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.tieba.z26;
import com.baidu.tieba.zaa;
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
public class VideoLiveFragment extends BaseFragment implements z26.b, zaa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoPlayFragment.i1 A;
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
    public final pi9 M;
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
    public qe5 v;
    public BdUniqueId w;
    public aba x;
    public String y;
    public int z;

    @Override // com.baidu.tieba.zaa
    public VideoItemModel O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (VideoItemModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z26.b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    @Override // com.baidu.tieba.z26.b
    public void u0(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    @Override // com.baidu.tieba.zaa
    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.zaa
    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
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
                    this.a.p2(0);
                    this.a.B = false;
                    if (this.a.C && !this.a.D && this.a.A != null) {
                        this.a.A.a();
                    }
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.a.B = true;
                    this.a.p2(1);
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
                        this.a.k2("clk_into_live");
                        return;
                    } else {
                        this.a.b2();
                        return;
                    }
                }
                this.a.x.b(this.a.z, this.a.y, 1, 2);
                this.a.j2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements pi9 {
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

        @Override // com.baidu.tieba.pi9
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && this.a.u != null && this.a.u.getCutList() != null) {
                int intValue = this.a.u.getCutList().get(LiveConfig.CUT_LIST_VERTICAL_KEY).intValue();
                int intValue2 = this.a.u.getCutList().get(LiveConfig.CUT_LIST_HORIZONTAL_KEY).intValue();
                if (i2 / i >= this.a.u.getVerticalHorizontalBoundary()) {
                    this.a.F = true;
                    if (UtilHelper.isOppoFoldLargeScreen(this.a.getContext())) {
                        this.a.n2(2);
                        return;
                    } else {
                        this.a.n2(intValue);
                        return;
                    }
                }
                this.a.F = false;
                this.a.n2(intValue2);
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
                    this.a.x.b(this.a.z, this.a.y, 4, 2);
                    this.a.k2("clk_into_live");
                } else if (2 == i) {
                    this.a.x.a(this.a.z, this.a.y, 2);
                    this.a.k2("auto_into_live");
                }
            }
        }

        @Override // com.baidu.tieba.videoplay.view.EnterLiveRoomBtn.b
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.x.b(this.a.z, this.a.y, 3, 2);
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
                this.a.s.setImageBitmap(dw5.a(bitmap, 15, false));
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

    public final void j2() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (videoItemData = this.f) != null && (userItemData = videoItemData.author_info) != null) {
            long g2 = tg.g(userItemData.user_id, 0L);
            long g3 = tg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (g2 == g3) {
                z = true;
            } else {
                z = false;
            }
            if (g2 == 0 && g3 == 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            String str = this.f.author_info.portrait;
            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getActivity()).createNormalConfig(g2, z2, false, true, PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
            createNormalConfig.setPortrait(str);
            createNormalConfig.setSourceTid(this.f.thread_id);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
        }
    }

    public void m2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.D = z;
        }
    }

    public final void n2(int i2) {
        TbVideoView tbVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i2) == null) && (tbVideoView = this.c) != null) {
            tbVideoView.setVideoScalingMode(i2);
        }
    }

    public void o2(VideoPlayFragment.i1 i1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, i1Var) == null) {
            this.A = i1Var;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.I);
            registerListener(this.H);
        }
    }

    public final void b2() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && ViewHelper.checkUpIsLogin(getActivity()) && this.j != null && (videoItemData = this.f) != null && (userItemData = videoItemData.author_info) != null && this.t != null) {
            this.v.j(true, userItemData.portrait, userItemData.user_id, false, "6", this.w, videoItemData.forum_id, "0", videoItemData.thread_id);
            this.x.b(this.z, this.y, 2, 2);
            d2();
            k2("clk_into_live");
            this.j.setVisibility(8);
            l2();
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.setVideoStatusChangeListener(this.G);
            this.c.setOnClickListener(this.L);
            this.c.setVideoStatData(this.x.d(this.z, this.y));
            this.c.setVideoSizeChangeListener(this.M);
            VideoItemData videoItemData = this.f;
            if (videoItemData != null && videoItemData.getLivePageData() != null) {
                if (UtilHelper.isOppoFoldLargeScreen(getContext())) {
                    n2(2);
                } else {
                    n2(this.f.getLivePageData().cutType);
                }
            }
        }
    }

    public final void i2() {
        Bundle arguments;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (arguments = getArguments()) != null && (arguments.get("video_data") instanceof VideoItemModel) && (arguments.get("live_config") instanceof LiveConfig)) {
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
            this.y = arguments.getString("source_from");
            this.z = arguments.getInt("video_index");
        }
    }

    public final void c2() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (videoItemData = this.f) != null && videoItemData.author_info != null) {
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
                    this.g.N(this.f.author_info.portrait, 10, false);
                } else {
                    this.g.N(this.f.author_info.portrait, 12, false);
                }
                this.g.setOnClickListener(this.L);
            }
            EnterLiveRoomBtn enterLiveRoomBtn = this.l;
            if (enterLiveRoomBtn != null) {
                enterLiveRoomBtn.c(this.u);
                this.l.setEnterLiveRoomCallback(new h(this));
            }
            if (this.q != null) {
                if (this.f.getLivePageData() != null && !ui.isEmpty(this.f.getLivePageData().user_label_text)) {
                    this.q.setVisibility(0);
                    this.q.setText(this.f.getLivePageData().user_label_text);
                } else {
                    this.q.setVisibility(8);
                }
                this.q.setOnClickListener(this.L);
            }
            d2();
        }
    }

    public final void d2() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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

    public final void l2() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (tBLottieAnimationView = this.t) != null) {
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
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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

    public final void e2(boolean z) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (videoItemData = this.f) != null && videoItemData.author_info != null && videoItemData.getLivePageData() != null) {
            BasicVideoSeries basicVideoSeries = BasicVideoSeriesKt.toBasicVideoSeries(this.f.getLivePageData().flv_url, true);
            basicVideoSeries.setKernelType(YYVideoKernel.KERNEL_TYPE_YY);
            YYUtil.setYYBufferSize(basicVideoSeries, 10);
            basicVideoSeries.setPreRenderOptionState(OptionState.ENABLE);
            this.c.setVideoSeries(basicVideoSeries, z);
        }
    }

    public final void g2() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (view2 = this.e) != null) {
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090306);
            this.g = headImageView;
            headImageView.setDefaultResource(17170445);
            this.g.setPlaceHolder(2);
            this.g.setIsRound(true);
            this.g.setBorderWidth(R.dimen.L_X02);
            this.g.setBorderColor(R.color.CAM_X0622);
            this.g.setDrawBorder(true);
            this.g.setUseNightOrDarkMask(false);
            this.h = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0927d4);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f09163d);
            this.j = tBSpecificationBtn;
            tBSpecificationBtn.setText(getString(R.string.obfuscated_res_0x7f0f02e5));
            this.j.setOnClickListener(this.L);
            ka5 ka5Var = new ka5();
            UtilHelper.addFollowUserIconStyle(ka5Var);
            ka5Var.h(R.color.CAM_X0101);
            ka5Var.n(0, 0);
            ka5Var.o(0);
            ka5Var.l(true);
            ka5Var.j(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds145), vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60));
            this.j.setConfig(ka5Var);
            ExpandableTextView expandableTextView = (ExpandableTextView) this.e.findViewById(R.id.obfuscated_res_0x7f0915a0);
            this.k = expandableTextView;
            expandableTextView.setTextSize(vi.g(getContext(), R.dimen.T_X07));
            this.k.setTextColor(R.color.CAM_X0621);
            this.k.setLineSpacingExtra(vi.g(getContext(), R.dimen.tbds10));
            this.k.setExpandable(false);
            this.k.setTextMaxLine(3);
            this.k.setLimitLine(3);
            this.o = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0915b2);
            this.p = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091586);
            this.l = (EnterLiveRoomBtn) this.e.findViewById(R.id.obfuscated_res_0x7f090a03);
            this.m = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091585);
            this.n = (TbImageView) this.e.findViewById(R.id.obfuscated_res_0x7f0915b0);
            this.q = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0915a1);
            this.r = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091588);
            this.s = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09151c);
            this.t = (TBLottieAnimationView) this.e.findViewById(R.id.obfuscated_res_0x7f0902ef);
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.x = new aba(this.f, this.u);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPrimary();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.z26.b
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            k2("clk_into_live");
        }
    }

    public final void k2(String str) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && this.B && (videoItemData = this.f) != null && videoItemData.getLivePageData() != null && this.f.getLivePageData().mYyExtData != null) {
            YyExtData yyExtData = this.f.getLivePageData().mYyExtData;
            raa.g("sp_live_into_id_", this.f.thread_id);
            YYLiveUtil.jumpToYYLiveRoom(getPageContext(), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", null, "video_immersion", str, false);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            LiveConfig liveConfig = this.u;
            if (liveConfig != null && liveConfig.getCutList() != null && UtilHelper.isFoldScreen()) {
                if (this.F) {
                    if (UtilHelper.isOppoFoldLargeScreen(getContext())) {
                        n2(2);
                        return;
                    } else {
                        n2(this.u.getCutList().get(LiveConfig.CUT_LIST_VERTICAL_KEY).intValue());
                        return;
                    }
                }
                n2(this.u.getCutList().get(LiveConfig.CUT_LIST_HORIZONTAL_KEY).intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            super.setUserVisibleHint(z);
            this.C = z;
            if (this.c != null) {
                if (z) {
                    if (this.E == OnStatusChangedListener.VideoStatus.VIDEO_ERROR) {
                        e2(false);
                    }
                    this.c.R(2);
                    this.c.setVolume(1.0f, 1.0f);
                    this.x.c(this.z, this.y, 2);
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            uk5.a(this.n, "enter_live_room_animation.png");
            SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f08097b);
            o75 d2 = o75.d(this.h);
            d2.B(R.dimen.T_X06);
            d2.C(R.string.F_X02);
            d2.A(R.array.S_O_X001);
            o75 d3 = o75.d(this.j);
            d3.o(R.string.J_X01);
            d3.B(R.dimen.T_X09);
            d3.w(R.color.CAM_X0101);
            d3.C(R.string.F_X02);
            d3.f(R.color.CAM_X0302);
            o75 d4 = o75.d(this.o);
            d4.o(R.string.J_X04);
            d4.f(R.color.CAM_X0310);
            o75 d5 = o75.d(this.m);
            d5.B(R.dimen.T_X09);
            d5.w(R.color.CAM_X0101);
            o75 d6 = o75.d(this.q);
            d6.o(R.string.J_X04);
            d6.B(R.dimen.T_X09);
            d6.w(R.color.CAM_X0101);
            d6.f(R.color.CAM_X0615);
        }
    }

    public final void p2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09a2, (ViewGroup) null);
            this.e = inflate;
            inflate.setOnTouchListener(this.J);
            this.a = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09044b);
            this.b = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f092825);
            this.c = new TbVideoView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.d = layoutParams;
            layoutParams.bottomMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            this.b.addView(this.c, 0, this.d);
            this.v = new qe5(null);
            g2();
            i2();
            h2();
            c2();
            e2(true);
            f2();
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }
}
