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
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.ei;
import com.baidu.tieba.fva;
import com.baidu.tieba.iy7;
import com.baidu.tieba.k36;
import com.baidu.tieba.ora;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.view.AdInfoButton;
import com.baidu.tieba.videoplay.view.GestureInterceptTouchFrameLayout;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.tieba.wta;
import com.baidu.tieba.zua;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class VideoAdFragment extends BaseFragment implements k36.b, fva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public HeadImageView B;
    public TextView C;
    public ExpandableTextView D;
    public LinearLayout E;
    public ImageView F;
    public TextView G;
    public AdInfoButton H;
    public int I;
    public boolean J;
    public boolean K;
    public ora L;
    public ArrayList<View> M;
    public ArrayList<View> N;
    public CustomMessageListener O;
    public View.OnClickListener P;
    public iy7.i Q;
    public GestureInterceptTouchFrameLayout a;
    public FrameLayout b;
    public FrameLayout c;
    public LinearLayout d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public VideoItemModel h;
    public String i;
    public wta j;
    public boolean k;
    public BdUniqueId l;
    public int m;
    public int n;
    public FrameLayout o;
    public LinearLayout p;
    public FrameLayout q;
    public LinearLayout r;
    public ImageView s;
    public EMTextView t;
    public TBLottieAnimationView u;
    public ImageView v;
    public EMTextView w;
    public View x;
    public ImageView y;
    public EMTextView z;

    @Override // com.baidu.tieba.k36.b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.tieba.k36.b
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public void r2(zua zuaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, zuaVar) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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

        public a(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAdFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.u.setVisibility(8);
                this.a.K = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements iy7.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final /* synthetic */ VideoAdFragment c;

        public b(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoAdFragment;
            this.a = false;
            this.b = false;
        }

        @Override // com.baidu.tieba.iy7.i
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                int i = ((int) j) / 1000;
                if (i == 3 && !this.a) {
                    this.a = true;
                    this.c.r.addView(this.c.H);
                } else if (i == 5 && !this.b) {
                    this.b = true;
                    this.c.H.d();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoAdFragment videoAdFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment, Integer.valueOf(i)};
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

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        public d(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getActivity() != null) {
                this.a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        public e(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null) {
                CustomMessage customMessage = new CustomMessage(2921566);
                customMessage.setTag(this.a.l);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.a.h.getHashCode()));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.a.i).param("obj_locate", 0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements iy7.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        @Override // com.baidu.tieba.iy7.h
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.iy7.h
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        public f(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAdFragment;
        }

        @Override // com.baidu.tieba.iy7.h
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, str) != null) {
                return;
            }
            this.a.t2("", "", 1);
        }

        @Override // com.baidu.tieba.iy7.h
        public void onAdClicked(String str, String str2, String str3) {
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.a.i).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param(TiebaStatic.Params.OBJ_TO, this.a.k2());
                String str5 = "";
                if (this.a.L == null) {
                    str4 = "";
                } else {
                    str4 = this.a.L.e();
                }
                StatisticItem param2 = param.param(TiebaStatic.Params.AD_TITLE, str4);
                if (this.a.L != null) {
                    str5 = this.a.L.d();
                }
                TiebaStatic.log(param2.param(TiebaStatic.Params.AD_DESC, str5).param(TiebaStatic.Params.AD_SOURCE, str2));
            }
        }

        @Override // com.baidu.tieba.iy7.h
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
                this.a.t2(str3, str2, 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAdFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null) {
                CustomMessage customMessage = new CustomMessage(2921566);
                customMessage.setTag(this.a.l);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.a.h.getHashCode()));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.a.i));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        public i(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.j2(0);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        public j(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.s2();
        }
    }

    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public k(VideoAdFragment videoAdFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAdFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAdFragment;
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
        this.k = false;
        this.m = 3;
        this.n = -1;
        this.J = false;
        this.K = false;
        this.O = new c(this, 2921612);
        this.P = new h(this);
        this.Q = new b(this);
    }

    @Override // com.baidu.tieba.fva
    public void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.n = i2;
        }
    }

    public void o2(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.l = bdUniqueId;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.O);
        }
    }

    public void p2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.i = str;
        }
    }

    public void q2(VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, videoItemModel) == null) {
            this.h = videoItemModel;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        wta wtaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            super.setUserVisibleHint(z);
            if (!z && (wtaVar = this.j) != null) {
                wtaVar.j();
            }
        }
    }

    @Override // com.baidu.tieba.k36.b
    public void D0(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            j2(1);
        }
    }

    @Override // com.baidu.tieba.fva
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fva
    public VideoItemModel Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (VideoItemModel) invokeV.objValue;
    }

    public final String k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ora oraVar = this.L;
            if (oraVar == null) {
                return "";
            }
            int c2 = oraVar.c();
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        return "";
                    }
                    return FunAdSdk.PLATFORM_CSJ;
                }
                return FunAdSdk.PLATFORM_KS;
            }
            return FunAdSdk.PLATFORM_GDT;
        }
        return (String) invokeV.objValue;
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.s.setOnClickListener(new i(this));
            this.x.setOnClickListener(new j(this));
            this.v.setOnClickListener(new k(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroyView();
            wta wtaVar = this.j;
            if (wtaVar != null) {
                wtaVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPrimary();
            if (this.k && this.j != null && isPrimary()) {
                wta wtaVar = this.j;
                wtaVar.k(getString(R.string.obfuscated_res_0x7f0f00e5));
                wtaVar.l();
            }
        }
    }

    public final void i2() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a != null && (tBLottieAnimationView = this.u) != null && !this.K) {
            tBLottieAnimationView.setVisibility(0);
            this.K = true;
            SkinManager.setLottieAnimation(this.u, R.raw.lottie_agree_big_photo);
            this.u.addAnimatorListener(new a(this));
            this.u.playAnimation();
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.isShowShareOuerItem = false;
            shareItem.isVideoAdShare = true;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.closeAdListener = this.P;
            shareDialogConfig.mShowMoreForumShare = false;
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.mIsAd = true;
            TransmitShareController.getInstance().showShareDialog(shareDialogConfig);
        }
    }

    public final void j2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 == 0) {
                if (this.J) {
                    this.s.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a32, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView = this.t;
                    int i3 = this.I - 1;
                    this.I = i3;
                    eMTextView.setText(String.valueOf(i3));
                    this.J = false;
                } else {
                    i2();
                    this.s.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a33, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView2 = this.t;
                    int i4 = this.I + 1;
                    this.I = i4;
                    eMTextView2.setText(String.valueOf(i4));
                    this.J = true;
                }
            }
            if (1 == i2) {
                i2();
                if (!this.J) {
                    this.s.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a33, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView3 = this.t;
                    int i5 = this.I + 1;
                    this.I = i5;
                    eMTextView3.setText(String.valueOf(i5));
                    this.J = true;
                }
            }
            VideoItemModel videoItemModel = this.h;
            if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
                this.h.getVideoAdData().d(this.I);
                this.h.getVideoAdData().e(this.J);
            }
        }
    }

    public final void m2(ora oraVar) {
        AdInfoButton.AdType adType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oraVar) != null) || oraVar == null) {
            return;
        }
        if (!ei.isEmpty(oraVar.f())) {
            this.B.startLoad(oraVar.f(), 12, false);
        }
        String e2 = oraVar.e();
        if (e2.length() > 12) {
            e2 = e2.substring(0, 12);
        }
        this.C.setText(e2);
        if (ei.isEmpty(oraVar.d())) {
            this.D.setData(TbadkCoreApplication.getInst().getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1801), false, null);
        } else {
            this.D.setData(oraVar.d(), false, null);
        }
        if (oraVar.c() == 3) {
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.setDuration(400L);
            this.r.setLayoutTransition(layoutTransition);
            this.H.setChannel(AdInfoButton.AdChannel.CSJ);
        } else {
            if (oraVar.c() == 1) {
                this.H.setChannel(AdInfoButton.AdChannel.GDT);
            } else if (oraVar.c() == 2) {
                this.H.setChannel(AdInfoButton.AdChannel.KS);
            }
            this.r.addView(this.H);
        }
        AdInfoButton adInfoButton = this.H;
        if (oraVar.b() == 2) {
            adType = AdInfoButton.AdType.DOWNLOAD;
        } else {
            adType = AdInfoButton.AdType.INFO;
        }
        adInfoButton.setType(adType);
        this.H.setText(oraVar.a());
    }

    public final void l2() {
        GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (gestureInterceptTouchFrameLayout = this.a) == null) {
            return;
        }
        this.o = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(R.id.obfuscated_res_0x7f09095c);
        this.p = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09095d);
        this.r = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09095e);
        this.p.setVisibility(0);
        EMManager.from(this.p).setGradientColor(new int[]{R.color.CAM_X0606, R.color.CAM_X0601});
        this.q = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090960);
        this.s = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090162);
        VideoItemModel videoItemModel = this.h;
        if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
            this.J = this.h.getVideoAdData().b();
        }
        if (this.J) {
            this.s.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a33, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.s.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a32, WebPManager.ResourceStateType.NORMAL));
        }
        this.t = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f09016a);
        VideoItemModel videoItemModel2 = this.h;
        if (videoItemModel2 != null && videoItemModel2.getVideoAdData() != null) {
            this.I = this.h.getVideoAdData().a();
        }
        this.t.setText(String.valueOf(this.I));
        EMManager.from(this.t).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101).setTextShadow(R.array.S_O_X001);
        this.u = (TBLottieAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f090160);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09075d);
        this.v = imageView;
        imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a39, WebPManager.ResourceStateType.NORMAL_DISABLE));
        EMTextView eMTextView = (EMTextView) this.a.findViewById(R.id.comment_num);
        this.w = eMTextView;
        eMTextView.setText(R.string.obfuscated_res_0x7f0f1800);
        EMManager.from(this.w).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101).setTextShadow(R.array.S_O_X001);
        this.v.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.w.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.x = this.a.findViewById(R.id.obfuscated_res_0x7f0917a9);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0917b1);
        this.y = imageView2;
        imageView2.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a38, WebPManager.ResourceStateType.NORMAL));
        EMTextView eMTextView2 = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f0917b8);
        this.z = eMTextView2;
        eMTextView2.setText(R.string.obfuscated_res_0x7f0f1802);
        EMManager.from(this.z).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101).setTextShadow(R.array.S_O_X001);
        this.A = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0900f9);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0900f8);
        this.B = headImageView;
        headImageView.setDefaultResource(17170445);
        this.B.setPlaceHolder(2);
        this.B.setIsRound(true);
        this.B.setBorderWidth(R.dimen.L_X02);
        this.B.setBorderColor(R.color.CAM_X0622);
        this.B.setDrawBorder(true);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0900f0);
        this.C = textView;
        EMManager.from(textView).setTextSize(R.dimen.T_X06).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0101);
        ExpandableTextView expandableTextView = (ExpandableTextView) this.a.findViewById(R.id.obfuscated_res_0x7f0900ac);
        this.D = expandableTextView;
        expandableTextView.setTextSize(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.T_X07));
        this.D.setTextColor(R.color.CAM_X0621);
        this.D.setLineSpacingExtra(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.D.setExpandable(false);
        this.D.setTextMaxLine(2);
        this.D.setLimitLine(2);
        LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0900b8);
        this.E = linearLayout;
        EMManager.from(linearLayout).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0614);
        this.F = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0900b9);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0900ba);
        this.G = textView2;
        textView2.setText(R.string.obfuscated_res_0x7f0f17ff);
        EMManager.from(this.G).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0621).setTextStyle(R.string.F_X01);
        this.H = new AdInfoButton(getContext());
        this.H.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ArrayList<View> arrayList = new ArrayList<>();
        this.M = arrayList;
        arrayList.add(this.F);
        this.M.add(this.A);
        this.M.add(this.D);
        ArrayList<View> arrayList2 = new ArrayList<>();
        this.N = arrayList2;
        arrayList2.add(this.H);
        n2();
        this.g.setVisibility(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.m == i2) {
                return;
            }
            this.m = i2;
            WebPManager.setMaskDrawable(this.e, R.drawable.obfuscated_res_0x7f0809e0, null);
            EMManager.from(this.a).setBackGroundColor(R.color.CAM_X0611);
            WebPManager.setPureDrawable(this.f, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            AdInfoButton adInfoButton = this.H;
            if (adInfoButton != null) {
                adInfoButton.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Object n;
        String str;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("from");
            }
            GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout = (GestureInterceptTouchFrameLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09e2, (ViewGroup) null);
            this.a = gestureInterceptTouchFrameLayout;
            this.b = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(R.id.obfuscated_res_0x7f090db3);
            this.c = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090a48);
            this.e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0900b0);
            this.d = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090112);
            this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09032b);
            this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090aff);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.f.setVisibility(8);
            this.f.setOnClickListener(new d(this));
            this.g.setOnClickListener(new e(this));
            this.j = new wta(getActivity(), this.c);
            if (!iy7.m().v(iy7.s())) {
                this.b.setVisibility(8);
                this.g.setVisibility(8);
                this.e.setVisibility(0);
                this.k = true;
                t2("", "", 2);
                return this.a;
            }
            this.e.setVisibility(8);
            this.b.setVisibility(0);
            l2();
            n2();
            VideoItemModel videoItemModel = this.h;
            if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
                if (this.h.getVideoAdData().c() != null) {
                    n = this.h.getVideoAdData().c();
                } else {
                    n = iy7.m().n(getActivity(), iy7.s());
                    this.h.getVideoAdData().f(n);
                }
            } else {
                n = iy7.m().n(getActivity(), iy7.s());
            }
            View t = iy7.m().t(n);
            if (t != null) {
                if (t.getParent() != null) {
                    ((ViewGroup) t.getParent()).removeView(t);
                }
                this.q.addView(t);
            }
            ora H = iy7.m().H(n);
            this.L = H;
            m2(H);
            iy7.m().B(n, this.Q);
            iy7.m().A(this.F, n);
            iy7 m = iy7.m();
            FragmentActivity activity = getActivity();
            f fVar = new f(this);
            FrameLayout frameLayout2 = this.o;
            ArrayList<View> arrayList = this.M;
            ArrayList<View> arrayList2 = this.N;
            String str2 = this.i;
            if (VideoMiddleAdSwitch.isOn()) {
                str = "1";
            } else {
                str = "0";
            }
            m.E(activity, n, fVar, frameLayout2, arrayList, arrayList2, iy7.b(str2, str), iy7.s());
            if (iy7.m().C(n) && (frameLayout = this.o) != null && (frameLayout.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) this.o.getParent();
                if (viewGroup2.getChildCount() > 1) {
                    int childCount = viewGroup2.getChildCount() - 1;
                    if (viewGroup2.getChildAt(childCount) instanceof ImageView) {
                        viewGroup2.removeViewAt(childCount);
                    }
                }
            }
            this.a.setSimpleOnGestureListener(new g(this));
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    public final void t2(String str, String str2, int i2) {
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, str, str2, i2) == null) {
            ora oraVar = this.L;
            if (oraVar == null) {
                str3 = "";
                str4 = str3;
                str5 = str4;
            } else {
                str3 = oraVar.e();
                str4 = this.L.d();
                str5 = k2();
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.i).param("obj_locate", i2).param(TiebaStatic.Params.OBJ_PARAM2, str).param(TiebaStatic.Params.OBJ_TO, str5).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, str3).param(TiebaStatic.Params.AD_DESC, str4).param(TiebaStatic.Params.AD_SOURCE, str2).param(TiebaStatic.Params.AD_TYPE, "4"));
        }
    }
}
