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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.e1.r.b;
import c.a.r0.e1.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tieba.R;
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
/* loaded from: classes6.dex */
public class VideoAdFragment extends BaseFragment implements b.InterfaceC0839b, c.a.r0.n4.j.b.a {
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
    public c.a.r0.l4.g Q;
    public ArrayList<View> R;
    public ArrayList<View> S;
    public CustomMessageListener T;
    public View.OnClickListener U;
    public a.j V;

    /* renamed from: e  reason: collision with root package name */
    public GestureInterceptTouchFrameLayout f47333e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f47334f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f47335g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f47336h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f47337i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f47338j;
    public ImageView k;
    public c.a.r0.n4.i.a l;
    public VideoItemModel m;
    public String n;
    public c.a.r0.n4.c.a o;
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f47339e;

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
                    return;
                }
            }
            this.f47339e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f47340e;

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
            this.f47340e = videoAdFragment;
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
                this.f47340e.z.setVisibility(8);
                this.f47340e.P = false;
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

    /* loaded from: classes6.dex */
    public class c implements a.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f47341b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f47342c;

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
            this.f47342c = videoAdFragment;
            this.a = false;
            this.f47341b = false;
        }

        @Override // c.a.r0.e1.a.j
        public void a(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                int i2 = ((int) j2) / 1000;
                if (i2 == 3 && !this.a) {
                    this.a = true;
                    this.f47342c.w.addView(this.f47342c.M);
                } else if (i2 != 5 || this.f47341b) {
                } else {
                    this.f47341b = true;
                    this.f47342c.M.playStressAnimation();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

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
            this.a = videoAdFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921612 && this.a.isResumed() && this.a.isVisible()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
                if (this.a.getActivity() != null) {
                    this.a.getActivity().finish();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f47343e;

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
            this.f47343e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47343e.getActivity() == null) {
                return;
            }
            this.f47343e.getActivity().finish();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f47344e;

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
            this.f47344e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47344e.m == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921566);
            customMessage.setTag(this.f47344e.q);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.f47344e.m.getHashCode()));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f47344e.n).param("obj_locate", 0));
        }
    }

    /* loaded from: classes6.dex */
    public class g implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

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
            this.a = videoAdFragment;
        }

        @Override // c.a.r0.e1.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.a.n).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param(TiebaStatic.Params.OBJ_TO, this.a.w()).param(TiebaStatic.Params.AD_TITLE, this.a.Q != null ? this.a.Q.e() : "").param(TiebaStatic.Params.AD_DESC, this.a.Q != null ? this.a.Q.d() : "").param(TiebaStatic.Params.AD_SOURCE, str2));
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.C("", "", 1);
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.a.C(str3, str2, 0);
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

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
            this.a = videoAdFragment;
        }

        @Override // c.a.r0.e1.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.a.n).param("obj_locate", 0).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.p = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.a.n).param("obj_locate", 1).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.a.p = false;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.a.n).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
                if (this.a.l != null) {
                    this.a.l.prefetch();
                }
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f47345e;

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
            this.f47345e = videoAdFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.f47345e.A();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f47346e;

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
            this.f47346e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47346e.m == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921566);
            customMessage.setTag(this.f47346e.q);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.f47346e.m.getHashCode()));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f47346e.n));
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f47347e;

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
            this.f47347e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47347e.v(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f47348e;

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
            this.f47348e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47348e.B();
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

    public final void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.f0 = false;
            shareItem.g0 = true;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.closeAdListener = this.U;
            shareDialogConfig.mShowMoreForumShare = false;
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.mIsAd = true;
            c.a.r0.j0.h.c().l(shareDialogConfig);
        }
    }

    public final void C(String str, String str2, int i2) {
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i2) == null) {
            c.a.r0.l4.g gVar = this.Q;
            if (gVar != null) {
                str3 = gVar.e();
                str4 = this.Q.d();
                str5 = w();
            } else {
                str3 = "";
                str4 = str3;
                str5 = str4;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.n).param("obj_locate", i2).param(TiebaStatic.Params.OBJ_PARAM2, str).param(TiebaStatic.Params.OBJ_TO, str5).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, str3).param(TiebaStatic.Params.AD_DESC, str4).param(TiebaStatic.Params.AD_SOURCE, str2).param(TiebaStatic.Params.AD_TYPE, "4"));
        }
    }

    @Override // c.a.r0.n4.j.b.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (VideoItemModel) invokeV.objValue;
    }

    @Override // c.a.r0.n4.j.b.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.T);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.r == i2) {
                return;
            }
            this.r = i2;
            WebPManager.setMaskDrawable(this.f47337i, R.drawable.icon_mask_header40, null);
            c.a.q0.r.v.c.d(this.f47333e).f(R.color.CAM_X0611);
            WebPManager.setPureDrawable(this.f47338j, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("from");
            }
            GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout = (GestureInterceptTouchFrameLayout) layoutInflater.inflate(R.layout.video_ad_view, (ViewGroup) null);
            this.f47333e = gestureInterceptTouchFrameLayout;
            this.f47334f = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(R.id.fun_ad_container);
            this.f47335g = (FrameLayout) this.f47333e.findViewById(R.id.error_tip_container);
            this.f47337i = (ImageView) this.f47333e.findViewById(R.id.ad_error_image);
            this.f47336h = (LinearLayout) this.f47333e.findViewById(R.id.ad_top_container);
            this.f47338j = (ImageView) this.f47333e.findViewById(R.id.back_btn);
            this.k = (ImageView) this.f47333e.findViewById(R.id.feed_back);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.f47336h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f47336h.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.f47338j.setVisibility(8);
            this.f47338j.setOnClickListener(new e(this));
            this.k.setOnClickListener(new f(this));
            this.o = new c.a.r0.n4.c.a(getActivity(), this.f47335g);
            if (UbsABTestHelper.isVideoAdDrawABTestA() && !c.a.r0.e1.a.i().m("6061002332-203360688")) {
                this.f47334f.setVisibility(8);
                this.f47337i.setVisibility(0);
                this.p = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.n).param("obj_locate", 2).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
                return this.f47333e;
            } else if (UbsABTestHelper.isVideoAdDrawABTestB() && !c.a.r0.e1.a.i().m("6061002410-390177882")) {
                this.f47334f.setVisibility(8);
                this.k.setVisibility(8);
                this.f47337i.setVisibility(0);
                this.p = true;
                C("", "", 2);
                return this.f47333e;
            } else {
                this.f47337i.setVisibility(8);
                this.f47334f.setVisibility(0);
                if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                    x();
                    z();
                    VideoItemModel videoItemModel = this.m;
                    if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
                        if (this.m.getVideoAdData().c() != null) {
                            j2 = this.m.getVideoAdData().c();
                        } else {
                            j2 = c.a.r0.e1.a.i().j(getActivity(), "6061002410-390177882");
                            this.m.getVideoAdData().f(j2);
                        }
                    } else {
                        j2 = c.a.r0.e1.a.i().j(getActivity(), "6061002410-390177882");
                    }
                    View k2 = c.a.r0.e1.a.i().k(j2);
                    if (k2 != null) {
                        if (k2.getParent() != null) {
                            ((ViewGroup) k2.getParent()).removeView(k2);
                        }
                        this.v.addView(k2);
                    }
                    c.a.r0.l4.g A = c.a.r0.e1.a.i().A(j2);
                    this.Q = A;
                    y(A);
                    c.a.r0.e1.a.i().t(j2, this.V);
                    c.a.r0.e1.a.i().s(this.K, j2);
                    c.a.r0.e1.a.i().x(getActivity(), j2, new g(this), this.t, this.R, this.S, c.a.r0.e1.a.b(this.n, (VideoMiddleAdSwitch.isOn() && UbsABTestHelper.isVideoAdDrawABTestB()) ? "0" : "0"));
                    if (c.a.r0.e1.a.i().u(j2) && (frameLayout = this.t) != null && frameLayout.getChildCount() > 1) {
                        FrameLayout frameLayout2 = this.t;
                        if (frameLayout2.getChildAt(frameLayout2.getChildCount() - 1) instanceof ImageView) {
                            FrameLayout frameLayout3 = this.t;
                            frameLayout3.removeViewAt(frameLayout3.getChildCount() - 1);
                        }
                    }
                } else if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                    c.a.r0.e1.a.i().v(getActivity(), "6061002332-203360688", this.f47334f, new h(this), c.a.r0.e1.a.b(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE, VideoMiddleAdSwitch.isOn() ? "1" : "0"));
                }
                this.f47333e.setSimpleOnGestureListener(new i(this));
                return this.f47333e;
            }
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroyView();
            c.a.r0.n4.c.a aVar = this.o;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
            if (this.p && this.o != null && isPrimary()) {
                c.a.r0.n4.c.a aVar = this.o;
                aVar.k(getString(R.string.ad_show_error));
                aVar.l();
            }
        }
    }

    @Override // c.a.q0.e1.r.b.InterfaceC0839b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // c.a.q0.e1.r.b.InterfaceC0839b
    public void onViewDoubleClick(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && UbsABTestHelper.isVideoAdDrawABTestB()) {
            v(1);
        }
    }

    @Override // c.a.q0.e1.r.b.InterfaceC0839b
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void setBaseActivityId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            this.q = bdUniqueId;
        }
    }

    @Override // c.a.r0.n4.j.b.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setPageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        c.a.r0.n4.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z || (aVar = this.o) == null) {
                return;
            }
            aVar.j();
        }
    }

    public void setVideoAdDataModel(VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, videoItemModel) == null) {
            this.m = videoItemModel;
        }
    }

    public void setVideoPlayPrefetcher(c.a.r0.n4.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public final void u() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.f47333e == null || (tBLottieAnimationView = this.z) == null || this.P) {
            return;
        }
        tBLottieAnimationView.setVisibility(0);
        this.P = true;
        SkinManager.setLottieAnimation(this.z, R.raw.lottie_agree_big_photo);
        this.z.addAnimatorListener(new b(this));
        this.z.playAnimation();
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 0) {
                if (this.O) {
                    this.x.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView = this.y;
                    int i3 = this.N - 1;
                    this.N = i3;
                    eMTextView.setText(String.valueOf(i3));
                    this.O = false;
                } else {
                    u();
                    this.x.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_video_good88, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView2 = this.y;
                    int i4 = this.N + 1;
                    this.N = i4;
                    eMTextView2.setText(String.valueOf(i4));
                    this.O = true;
                }
            }
            if (1 == i2) {
                u();
                if (!this.O) {
                    this.x.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_video_good88, WebPManager.ResourceStateType.NORMAL));
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

    public final String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c.a.r0.l4.g gVar = this.Q;
            if (gVar == null) {
                return "";
            }
            int c2 = gVar.c();
            return c2 != 1 ? c2 != 2 ? c2 != 3 ? "" : FunAdSdk.PLATFORM_CSJ : FunAdSdk.PLATFORM_KS : FunAdSdk.PLATFORM_GDT;
        }
        return (String) invokeV.objValue;
    }

    public final void x() {
        GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (gestureInterceptTouchFrameLayout = this.f47333e) == null) {
            return;
        }
        this.t = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(R.id.draw_container);
        this.u = (LinearLayout) this.f47333e.findViewById(R.id.draw_info_container);
        this.w = (LinearLayout) this.f47333e.findViewById(R.id.draw_info_desc_container);
        this.u.setVisibility(0);
        c.a.q0.r.v.c.d(this.u).o(new int[]{R.color.CAM_X0606, R.color.CAM_X0601});
        this.v = (FrameLayout) this.f47333e.findViewById(R.id.draw_video_container);
        this.x = (ImageView) this.f47333e.findViewById(R.id.agree_img);
        VideoItemModel videoItemModel = this.m;
        if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
            this.O = this.m.getVideoAdData().b();
        }
        if (this.O) {
            this.x.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_video_good88, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.x.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        this.y = (EMTextView) this.f47333e.findViewById(R.id.agree_num);
        VideoItemModel videoItemModel2 = this.m;
        if (videoItemModel2 != null && videoItemModel2.getVideoAdData() != null) {
            this.N = this.m.getVideoAdData().a();
        }
        this.y.setText(String.valueOf(this.N));
        c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.y);
        d2.z(R.dimen.T_X09);
        d2.A(R.string.F_X01);
        d2.v(R.color.CAM_X0101);
        d2.y(R.array.S_O_X001);
        this.z = (TBLottieAnimationView) this.f47333e.findViewById(R.id.agree_animation_view);
        ImageView imageView = (ImageView) this.f47333e.findViewById(R.id.comment_img);
        this.A = imageView;
        imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_DISABLE));
        EMTextView eMTextView = (EMTextView) this.f47333e.findViewById(R.id.comment_num);
        this.B = eMTextView;
        eMTextView.setText(R.string.video_ad_draw_comment);
        c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(this.B);
        d3.z(R.dimen.T_X09);
        d3.A(R.string.F_X01);
        d3.v(R.color.CAM_X0101);
        d3.y(R.array.S_O_X001);
        this.A.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.B.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.C = this.f47333e.findViewById(R.id.more_container);
        ImageView imageView2 = (ImageView) this.f47333e.findViewById(R.id.more_img);
        this.D = imageView2;
        imageView2.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_video_more36, WebPManager.ResourceStateType.NORMAL));
        EMTextView eMTextView2 = (EMTextView) this.f47333e.findViewById(R.id.more_text);
        this.E = eMTextView2;
        eMTextView2.setText(R.string.video_ad_draw_more);
        c.a.q0.r.v.c d4 = c.a.q0.r.v.c.d(this.E);
        d4.z(R.dimen.T_X09);
        d4.A(R.string.F_X01);
        d4.v(R.color.CAM_X0101);
        d4.y(R.array.S_O_X001);
        this.F = (LinearLayout) this.f47333e.findViewById(R.id.ad_portrait_and_name);
        HeadImageView headImageView = (HeadImageView) this.f47333e.findViewById(R.id.ad_portrait);
        this.G = headImageView;
        headImageView.setDefaultResource(17170445);
        this.G.setPlaceHolder(2);
        this.G.setIsRound(true);
        this.G.setBorderWidth(R.dimen.L_X02);
        this.G.setBorderColor(R.color.CAM_X0622);
        this.G.setDrawBorder(true);
        TextView textView = (TextView) this.f47333e.findViewById(R.id.ad_name);
        this.H = textView;
        c.a.q0.r.v.c d5 = c.a.q0.r.v.c.d(textView);
        d5.z(R.dimen.T_X06);
        d5.A(R.string.F_X02);
        d5.v(R.color.CAM_X0101);
        ExpandableTextView expandableTextView = (ExpandableTextView) this.f47333e.findViewById(R.id.ad_desc);
        this.I = expandableTextView;
        expandableTextView.setTextSize(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.T_X07));
        this.I.setTextColor(R.color.CAM_X0621);
        this.I.setLineSpacingExtra(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.I.setExpandable(false);
        this.I.setTextMaxLine(2);
        this.I.setLimitLine(2);
        LinearLayout linearLayout = (LinearLayout) this.f47333e.findViewById(R.id.ad_icon_bg);
        this.J = linearLayout;
        c.a.q0.r.v.c d6 = c.a.q0.r.v.c.d(linearLayout);
        d6.n(R.string.J_X04);
        d6.f(R.color.CAM_X0614);
        this.K = (ImageView) this.f47333e.findViewById(R.id.ad_icon_img);
        TextView textView2 = (TextView) this.f47333e.findViewById(R.id.ad_icon_text);
        this.L = textView2;
        textView2.setText(R.string.video_ad_draw_ad);
        c.a.q0.r.v.c d7 = c.a.q0.r.v.c.d(this.L);
        d7.z(R.dimen.T_X09);
        d7.v(R.color.CAM_X0621);
        d7.A(R.string.F_X01);
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
        z();
        this.k.setVisibility(8);
    }

    public final void y(c.a.r0.l4.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, gVar) == null) || gVar == null) {
            return;
        }
        if (!m.isEmpty(gVar.f())) {
            this.G.startLoad(gVar.f(), 12, false);
        }
        String e2 = gVar.e();
        if (e2.length() > 12) {
            e2 = e2.substring(0, 12);
        }
        this.H.setText(e2);
        if (m.isEmpty(gVar.d())) {
            this.I.setData(TbadkCoreApplication.getInst().getContext().getResources().getString(R.string.video_ad_draw_desc_default_text), false, null);
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

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.x.setOnClickListener(new k(this));
            this.C.setOnClickListener(new l(this));
            this.A.setOnClickListener(new a(this));
        }
    }
}
