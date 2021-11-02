package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.f1.r.b;
import b.a.r0.y0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.view.AdInfoButton;
import com.baidu.tieba.videoplay.view.GestureInterceptTouchFrameLayout;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class VideoAdFragment extends BaseFragment implements b.InterfaceC0660b, b.a.r0.b4.r.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public EMTextView B;
    public View C;
    public ImageView D;
    public EMTextView E;
    public LinearLayout F;
    public HeadImageView G;
    public TextView H;
    public ExpandableTextView I;
    public LinearLayout J;
    public ImageView K;
    public TextView L;
    public AdInfoButton M;
    public int N;
    public boolean O;
    public boolean P;
    public b.a.r0.z3.g Q;
    public ArrayList<View> R;
    public ArrayList<View> S;
    public CustomMessageListener T;
    public View.OnClickListener U;
    public a.j V;

    /* renamed from: e  reason: collision with root package name */
    public GestureInterceptTouchFrameLayout f54883e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f54884f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f54885g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f54886h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f54887i;
    public ImageView j;
    public ImageView k;
    public b.a.r0.b4.q.a l;
    public VideoItemModel m;
    public String n;
    public b.a.r0.b4.l.a o;
    public boolean p;
    public BdUniqueId q;
    public int r;
    public int s;
    public FrameLayout t;
    public LinearLayout u;
    public FrameLayout v;
    public LinearLayout w;
    public ImageView x;
    public EMTextView y;
    public TBLottieAnimationView z;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54888e;

        public b(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54888e = videoAdFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f54888e.z.setVisibility(8);
                this.f54888e.P = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f54889a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f54890b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54891c;

        public c(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54891c = videoAdFragment;
            this.f54889a = false;
            this.f54890b = false;
        }

        @Override // b.a.r0.y0.a.j
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                int i2 = ((int) j) / 1000;
                if (i2 == 3 && !this.f54889a) {
                    this.f54889a = true;
                    this.f54891c.w.addView(this.f54891c.M);
                } else if (i2 != 5 || this.f54890b) {
                } else {
                    this.f54890b = true;
                    this.f54891c.M.playStressAnimation();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54892a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoAdFragment videoAdFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment, Integer.valueOf(i2)};
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
            this.f54892a = videoAdFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921612 && this.f54892a.isResumed() && this.f54892a.isVisible()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54893e;

        public e(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54893e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54893e.getActivity() == null) {
                return;
            }
            this.f54893e.getActivity().finish();
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54894e;

        public f(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54894e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54894e.m == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921566);
            customMessage.setTag(this.f54894e.q);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.f54894e.m.getHashCode()));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f54894e.n).param("obj_locate", 0));
        }
    }

    /* loaded from: classes9.dex */
    public class g implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54895a;

        public g(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54895a = videoAdFragment;
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.f54895a.n).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param(TiebaStatic.Params.OBJ_TO, this.f54895a.r()).param(TiebaStatic.Params.AD_TITLE, this.f54895a.Q != null ? this.f54895a.Q.e() : "").param(TiebaStatic.Params.AD_DESC, this.f54895a.Q != null ? this.f54895a.Q.d() : "").param(TiebaStatic.Params.AD_SOURCE, str2));
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f54895a.x("", "", 1);
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f54895a.x(str3, str2, 0);
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54896a;

        public h(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54896a = videoAdFragment;
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.f54896a.n).param("obj_locate", 0).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f54896a.p = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.f54896a.n).param("obj_locate", 1).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f54896a.p = false;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.f54896a.n).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
                if (this.f54896a.l != null) {
                    this.f54896a.l.prefetch();
                }
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54897e;

        public i(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54897e = videoAdFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.f54897e.v();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54898e;

        public j(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54898e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54898e.m == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921566);
            customMessage.setTag(this.f54898e.q);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.f54898e.m.getHashCode()));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f54898e.n));
        }
    }

    /* loaded from: classes9.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54899e;

        public k(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54899e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54899e.q(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f54900e;

        public l(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54900e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54900e.w();
            }
        }
    }

    public VideoAdFragment() {
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
        this.p = false;
        this.r = 3;
        this.s = -1;
        this.O = false;
        this.P = false;
        this.T = new d(this, 2921612);
        this.U = new j(this);
        this.V = new c(this);
    }

    @Override // b.a.r0.b4.r.a.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (VideoItemModel) invokeV.objValue;
    }

    @Override // b.a.r0.b4.r.a.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.T);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.r == i2) {
                return;
            }
            this.r = i2;
            WebPManager.setMaskDrawable(this.f54887i, b.a.r0.b4.e.icon_mask_header40, null);
            b.a.q0.s.u.c.d(this.f54883e).f(b.a.r0.b4.c.CAM_X0611);
            WebPManager.setPureDrawable(this.j, b.a.r0.b4.e.icon_pure_topbar_return40, b.a.r0.b4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.k, b.a.r0.b4.e.icon_pure_card_close22, b.a.r0.b4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            AdInfoButton adInfoButton = this.M;
            if (adInfoButton != null) {
                adInfoButton.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Object j2;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("from");
            }
            GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout = (GestureInterceptTouchFrameLayout) layoutInflater.inflate(b.a.r0.b4.g.video_ad_view, (ViewGroup) null);
            this.f54883e = gestureInterceptTouchFrameLayout;
            this.f54884f = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(b.a.r0.b4.f.fun_ad_container);
            this.f54885g = (FrameLayout) this.f54883e.findViewById(b.a.r0.b4.f.error_tip_container);
            this.f54887i = (ImageView) this.f54883e.findViewById(b.a.r0.b4.f.ad_error_image);
            this.f54886h = (LinearLayout) this.f54883e.findViewById(b.a.r0.b4.f.ad_top_container);
            this.j = (ImageView) this.f54883e.findViewById(b.a.r0.b4.f.back_btn);
            this.k = (ImageView) this.f54883e.findViewById(b.a.r0.b4.f.feed_back);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.f54886h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f54886h.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.j.setVisibility(8);
            this.j.setOnClickListener(new e(this));
            this.k.setOnClickListener(new f(this));
            this.o = new b.a.r0.b4.l.a(getActivity(), this.f54885g);
            if (b.a.q0.b.d.Y() && !b.a.r0.y0.a.i().m("6061002332-203360688")) {
                this.f54884f.setVisibility(8);
                this.f54887i.setVisibility(0);
                this.p = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.n).param("obj_locate", 2).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
                return this.f54883e;
            } else if (b.a.q0.b.d.Z() && !b.a.r0.y0.a.i().m("6061002410-390177882")) {
                this.f54884f.setVisibility(8);
                this.k.setVisibility(8);
                this.f54887i.setVisibility(0);
                this.p = true;
                x("", "", 2);
                return this.f54883e;
            } else {
                this.f54887i.setVisibility(8);
                this.f54884f.setVisibility(0);
                if (b.a.q0.b.d.Z()) {
                    s();
                    u();
                    VideoItemModel videoItemModel = this.m;
                    if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
                        if (this.m.getVideoAdData().c() != null) {
                            j2 = this.m.getVideoAdData().c();
                        } else {
                            j2 = b.a.r0.y0.a.i().j(getActivity(), "6061002410-390177882");
                            this.m.getVideoAdData().f(j2);
                        }
                    } else {
                        j2 = b.a.r0.y0.a.i().j(getActivity(), "6061002410-390177882");
                    }
                    View k2 = b.a.r0.y0.a.i().k(j2);
                    if (k2 != null) {
                        if (k2.getParent() != null) {
                            ((ViewGroup) k2.getParent()).removeView(k2);
                        }
                        this.v.addView(k2);
                    }
                    b.a.r0.z3.g A = b.a.r0.y0.a.i().A(j2);
                    this.Q = A;
                    t(A);
                    b.a.r0.y0.a.i().t(j2, this.V);
                    b.a.r0.y0.a.i().s(this.K, j2);
                    b.a.r0.y0.a.i().x(getActivity(), j2, new g(this), this.t, this.R, this.S, b.a.r0.y0.a.b(this.n, (VideoMiddleAdSwitch.isOn() && b.a.q0.b.d.Z()) ? "0" : "0"));
                    if (b.a.r0.y0.a.i().u(j2) && (frameLayout = this.t) != null && frameLayout.getChildCount() > 1) {
                        FrameLayout frameLayout2 = this.t;
                        if (frameLayout2.getChildAt(frameLayout2.getChildCount() - 1) instanceof ImageView) {
                            FrameLayout frameLayout3 = this.t;
                            frameLayout3.removeViewAt(frameLayout3.getChildCount() - 1);
                        }
                    }
                } else if (b.a.q0.b.d.Y()) {
                    b.a.r0.y0.a.i().v(getActivity(), "6061002332-203360688", this.f54884f, new h(this), b.a.r0.y0.a.b(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE, VideoMiddleAdSwitch.isOn() ? "1" : "0"));
                }
                this.f54883e.setSimpleOnGestureListener(new i(this));
                return this.f54883e;
            }
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroyView();
            b.a.r0.b4.l.a aVar = this.o;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPrimary();
            if (this.p && this.o != null && isPrimary()) {
                b.a.r0.b4.l.a aVar = this.o;
                aVar.k(getString(b.a.r0.b4.i.ad_show_error));
                aVar.l();
            }
        }
    }

    @Override // b.a.q0.f1.r.b.InterfaceC0660b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // b.a.q0.f1.r.b.InterfaceC0660b
    public void onViewDoubleClick(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && b.a.q0.b.d.Z()) {
            q(1);
        }
    }

    @Override // b.a.q0.f1.r.b.InterfaceC0660b
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final void p() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f54883e == null || (tBLottieAnimationView = this.z) == null || this.P) {
            return;
        }
        tBLottieAnimationView.setVisibility(0);
        this.P = true;
        SkinManager.setLottieAnimation(this.z, b.a.r0.b4.h.lottie_agree_big_photo);
        this.z.addAnimatorListener(new b(this));
        this.z.playAnimation();
    }

    public final void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 0) {
                if (this.O) {
                    this.x.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView = this.y;
                    int i3 = this.N - 1;
                    this.N = i3;
                    eMTextView.setText(String.valueOf(i3));
                    this.O = false;
                } else {
                    p();
                    this.x.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_good88, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView2 = this.y;
                    int i4 = this.N + 1;
                    this.N = i4;
                    eMTextView2.setText(String.valueOf(i4));
                    this.O = true;
                }
            }
            if (1 == i2) {
                p();
                if (!this.O) {
                    this.x.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_good88, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView3 = this.y;
                    int i5 = this.N + 1;
                    this.N = i5;
                    eMTextView3.setText(String.valueOf(i5));
                    this.O = true;
                }
            }
            VideoItemModel videoItemModel = this.m;
            if (videoItemModel == null || videoItemModel.getVideoAdData() == null) {
                return;
            }
            this.m.getVideoAdData().d(this.N);
            this.m.getVideoAdData().e(this.O);
        }
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            b.a.r0.z3.g gVar = this.Q;
            if (gVar == null) {
                return "";
            }
            int c2 = gVar.c();
            return c2 != 1 ? c2 != 2 ? c2 != 3 ? "" : FunAdSdk.PLATFORM_CSJ : FunAdSdk.PLATFORM_KS : FunAdSdk.PLATFORM_GDT;
        }
        return (String) invokeV.objValue;
    }

    public final void s() {
        GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (gestureInterceptTouchFrameLayout = this.f54883e) == null) {
            return;
        }
        this.t = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(b.a.r0.b4.f.draw_container);
        this.u = (LinearLayout) this.f54883e.findViewById(b.a.r0.b4.f.draw_info_container);
        this.w = (LinearLayout) this.f54883e.findViewById(b.a.r0.b4.f.draw_info_desc_container);
        this.u.setVisibility(0);
        b.a.q0.s.u.c.d(this.u).o(new int[]{b.a.r0.b4.c.CAM_X0606, b.a.r0.b4.c.CAM_X0601});
        this.v = (FrameLayout) this.f54883e.findViewById(b.a.r0.b4.f.draw_video_container);
        this.x = (ImageView) this.f54883e.findViewById(b.a.r0.b4.f.agree_img);
        VideoItemModel videoItemModel = this.m;
        if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
            this.O = this.m.getVideoAdData().b();
        }
        if (this.O) {
            this.x.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_good88, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.x.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        this.y = (EMTextView) this.f54883e.findViewById(b.a.r0.b4.f.agree_num);
        VideoItemModel videoItemModel2 = this.m;
        if (videoItemModel2 != null && videoItemModel2.getVideoAdData() != null) {
            this.N = this.m.getVideoAdData().a();
        }
        this.y.setText(String.valueOf(this.N));
        b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.y);
        d2.z(b.a.r0.b4.d.T_X09);
        d2.A(b.a.r0.b4.i.F_X01);
        d2.v(b.a.r0.b4.c.CAM_X0101);
        d2.y(b.a.r0.b4.b.S_O_X001);
        this.z = (TBLottieAnimationView) this.f54883e.findViewById(b.a.r0.b4.f.agree_animation_view);
        ImageView imageView = (ImageView) this.f54883e.findViewById(b.a.r0.b4.f.comment_img);
        this.A = imageView;
        imageView.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_DISABLE));
        EMTextView eMTextView = (EMTextView) this.f54883e.findViewById(b.a.r0.b4.f.comment_num);
        this.B = eMTextView;
        eMTextView.setText(b.a.r0.b4.i.video_ad_draw_comment);
        b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.B);
        d3.z(b.a.r0.b4.d.T_X09);
        d3.A(b.a.r0.b4.i.F_X01);
        d3.v(b.a.r0.b4.c.CAM_X0101);
        d3.y(b.a.r0.b4.b.S_O_X001);
        this.A.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.B.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.C = this.f54883e.findViewById(b.a.r0.b4.f.more_container);
        ImageView imageView2 = (ImageView) this.f54883e.findViewById(b.a.r0.b4.f.more_img);
        this.D = imageView2;
        imageView2.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_more36, WebPManager.ResourceStateType.NORMAL));
        EMTextView eMTextView2 = (EMTextView) this.f54883e.findViewById(b.a.r0.b4.f.more_text);
        this.E = eMTextView2;
        eMTextView2.setText(b.a.r0.b4.i.video_ad_draw_more);
        b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.E);
        d4.z(b.a.r0.b4.d.T_X09);
        d4.A(b.a.r0.b4.i.F_X01);
        d4.v(b.a.r0.b4.c.CAM_X0101);
        d4.y(b.a.r0.b4.b.S_O_X001);
        this.F = (LinearLayout) this.f54883e.findViewById(b.a.r0.b4.f.ad_portrait_and_name);
        HeadImageView headImageView = (HeadImageView) this.f54883e.findViewById(b.a.r0.b4.f.ad_portrait);
        this.G = headImageView;
        headImageView.setDefaultResource(17170445);
        this.G.setPlaceHolder(2);
        this.G.setIsRound(true);
        this.G.setBorderWidth(b.a.r0.b4.d.L_X02);
        this.G.setBorderColor(b.a.r0.b4.c.CAM_X0622);
        this.G.setDrawBorder(true);
        TextView textView = (TextView) this.f54883e.findViewById(b.a.r0.b4.f.ad_name);
        this.H = textView;
        b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(textView);
        d5.z(b.a.r0.b4.d.T_X06);
        d5.A(b.a.r0.b4.i.F_X02);
        d5.v(b.a.r0.b4.c.CAM_X0101);
        ExpandableTextView expandableTextView = (ExpandableTextView) this.f54883e.findViewById(b.a.r0.b4.f.ad_desc);
        this.I = expandableTextView;
        expandableTextView.setTextSize(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.b4.d.T_X07));
        this.I.setTextColor(b.a.r0.b4.c.CAM_X0621);
        this.I.setLineSpacingExtra(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.b4.d.tbds10));
        this.I.setExpandable(false);
        this.I.setTextMaxLine(2);
        this.I.setLimitLine(2);
        LinearLayout linearLayout = (LinearLayout) this.f54883e.findViewById(b.a.r0.b4.f.ad_icon_bg);
        this.J = linearLayout;
        b.a.q0.s.u.c d6 = b.a.q0.s.u.c.d(linearLayout);
        d6.n(b.a.r0.b4.i.J_X04);
        d6.f(b.a.r0.b4.c.CAM_X0614);
        this.K = (ImageView) this.f54883e.findViewById(b.a.r0.b4.f.ad_icon_img);
        TextView textView2 = (TextView) this.f54883e.findViewById(b.a.r0.b4.f.ad_icon_text);
        this.L = textView2;
        textView2.setText(b.a.r0.b4.i.video_ad_draw_ad);
        b.a.q0.s.u.c d7 = b.a.q0.s.u.c.d(this.L);
        d7.z(b.a.r0.b4.d.T_X09);
        d7.v(b.a.r0.b4.c.CAM_X0621);
        d7.A(b.a.r0.b4.i.F_X01);
        this.M = new AdInfoButton(getContext());
        this.M.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ArrayList<View> arrayList = new ArrayList<>();
        this.R = arrayList;
        arrayList.add(this.K);
        this.R.add(this.F);
        this.R.add(this.I);
        ArrayList<View> arrayList2 = new ArrayList<>();
        this.S = arrayList2;
        arrayList2.add(this.M);
        u();
        this.k.setVisibility(8);
    }

    public void setBaseActivityId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            this.q = bdUniqueId;
        }
    }

    @Override // b.a.r0.b4.r.a.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setPageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        b.a.r0.b4.l.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z || (aVar = this.o) == null) {
                return;
            }
            aVar.j();
        }
    }

    public void setVideoAdDataModel(VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, videoItemModel) == null) {
            this.m = videoItemModel;
        }
    }

    public void setVideoPlayPrefetcher(b.a.r0.b4.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public final void t(b.a.r0.z3.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, gVar) == null) || gVar == null) {
            return;
        }
        if (!b.a.e.e.p.k.isEmpty(gVar.f())) {
            this.G.startLoad(gVar.f(), 12, false);
        }
        String e2 = gVar.e();
        if (e2.length() > 12) {
            e2 = e2.substring(0, 12);
        }
        this.H.setText(e2);
        if (b.a.e.e.p.k.isEmpty(gVar.d())) {
            this.I.setData(TbadkCoreApplication.getInst().getContext().getResources().getString(b.a.r0.b4.i.video_ad_draw_desc_default_text), false, null);
        } else {
            this.I.setData(gVar.d(), false, null);
        }
        if (gVar.c() == 3) {
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.setDuration(400L);
            this.w.setLayoutTransition(layoutTransition);
            this.M.setChannel(AdInfoButton.AdChannel.CSJ);
        } else {
            if (gVar.c() == 1) {
                this.M.setChannel(AdInfoButton.AdChannel.GDT);
            } else if (gVar.c() == 2) {
                this.M.setChannel(AdInfoButton.AdChannel.KS);
            }
            this.w.addView(this.M);
        }
        this.M.setType(gVar.b() == 2 ? AdInfoButton.AdType.DOWNLOAD : AdInfoButton.AdType.INFO);
        this.M.setText(gVar.a());
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.x.setOnClickListener(new k(this));
            this.C.setOnClickListener(new l(this));
            this.A.setOnClickListener(new a(this));
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.d0 = false;
            shareItem.e0 = true;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.closeAdListener = this.U;
            shareDialogConfig.mShowMoreForumShare = false;
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.mIsAd = true;
            b.a.r0.f0.h.c().l(shareDialogConfig);
        }
    }

    public final void x(String str, String str2, int i2) {
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048600, this, str, str2, i2) == null) {
            b.a.r0.z3.g gVar = this.Q;
            if (gVar != null) {
                str3 = gVar.e();
                str4 = this.Q.d();
                str5 = r();
            } else {
                str3 = "";
                str4 = str3;
                str5 = str4;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.n).param("obj_locate", i2).param(TiebaStatic.Params.OBJ_PARAM2, str).param(TiebaStatic.Params.OBJ_TO, str5).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, str3).param(TiebaStatic.Params.AD_DESC, str4).param(TiebaStatic.Params.AD_SOURCE, str2).param(TiebaStatic.Params.AD_TYPE, "4"));
        }
    }
}
