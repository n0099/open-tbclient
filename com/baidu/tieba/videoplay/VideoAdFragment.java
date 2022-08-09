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
import com.repackage.av8;
import com.repackage.cw8;
import com.repackage.hw8;
import com.repackage.ms4;
import com.repackage.oj5;
import com.repackage.p16;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.ss6;
import com.repackage.ts8;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class VideoAdFragment extends BaseFragment implements oj5.b, hw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView A;
    public LinearLayout B;
    public HeadImageView C;
    public TextView D;
    public ExpandableTextView E;
    public LinearLayout F;
    public ImageView G;
    public TextView H;
    public AdInfoButton I;
    public int J;
    public boolean K;
    public boolean L;
    public ts8 M;
    public ArrayList<View> N;
    public ArrayList<View> O;
    public CustomMessageListener P;
    public View.OnClickListener Q;
    public ss6.j R;
    public GestureInterceptTouchFrameLayout a;
    public FrameLayout b;
    public FrameLayout c;
    public LinearLayout d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public cw8 h;
    public VideoItemModel i;
    public String j;
    public av8 k;
    public boolean l;
    public BdUniqueId m;
    public int n;
    public int o;
    public FrameLayout p;
    public LinearLayout q;
    public FrameLayout r;
    public LinearLayout s;
    public ImageView t;
    public EMTextView u;
    public TBLottieAnimationView v;
    public ImageView w;
    public EMTextView x;
    public View y;
    public ImageView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

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
            this.a = videoAdFragment;
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
                this.a.v.setVisibility(8);
                this.a.L = false;
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

    /* loaded from: classes4.dex */
    public class c implements ss6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final /* synthetic */ VideoAdFragment c;

        public c(VideoAdFragment videoAdFragment) {
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

        @Override // com.repackage.ss6.j
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                int i = ((int) j) / 1000;
                if (i == 3 && !this.a) {
                    this.a = true;
                    this.c.s.addView(this.c.I);
                } else if (i != 5 || this.b) {
                } else {
                    this.b = true;
                    this.c.I.d();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoAdFragment videoAdFragment, int i) {
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

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.getActivity() == null) {
                return;
            }
            this.a.getActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921566);
            customMessage.setTag(this.a.m);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.a.i.getHashCode()));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 0));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ss6.i {
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

        @Override // com.repackage.ss6.i
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.repackage.ss6.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param(TiebaStatic.Params.OBJ_TO, this.a.J1()).param(TiebaStatic.Params.AD_TITLE, this.a.M != null ? this.a.M.e() : "").param(TiebaStatic.Params.AD_DESC, this.a.M != null ? this.a.M.d() : "").param(TiebaStatic.Params.AD_SOURCE, str2));
            }
        }

        @Override // com.repackage.ss6.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // com.repackage.ss6.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.T1("", "", 1);
            }
        }

        @Override // com.repackage.ss6.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
                this.a.T1(str3, str2, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements ss6.i {
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

        @Override // com.repackage.ss6.i
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.repackage.ss6.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 0).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
            }
        }

        @Override // com.repackage.ss6.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // com.repackage.ss6.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.l = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 1).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
            }
        }

        @Override // com.repackage.ss6.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
                this.a.l = false;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
                if (this.a.h != null) {
                    this.a.h.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends GestureDetector.SimpleOnGestureListener {
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

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.a.N1();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921566);
            customMessage.setTag(this.a.m);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.a.i.getHashCode()));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.a.j));
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.I1(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        public l(VideoAdFragment videoAdFragment) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.S1();
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
        this.l = false;
        this.n = 3;
        this.o = -1;
        this.K = false;
        this.L = false;
        this.P = new d(this, 2921612);
        this.Q = new j(this);
        this.R = new c(this);
    }

    @Override // com.repackage.hw8
    public VideoItemModel E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : (VideoItemModel) invokeV.objValue;
    }

    public final void H1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null || (tBLottieAnimationView = this.v) == null || this.L) {
            return;
        }
        tBLottieAnimationView.setVisibility(0);
        this.L = true;
        SkinManager.setLottieAnimation(this.v, R.raw.obfuscated_res_0x7f11001f);
        this.v.addAnimatorListener(new b(this));
        this.v.playAnimation();
    }

    public final void I1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 0) {
                if (this.K) {
                    this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08082a, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView = this.u;
                    int i3 = this.J - 1;
                    this.J = i3;
                    eMTextView.setText(String.valueOf(i3));
                    this.K = false;
                } else {
                    H1();
                    this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08082b, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView2 = this.u;
                    int i4 = this.J + 1;
                    this.J = i4;
                    eMTextView2.setText(String.valueOf(i4));
                    this.K = true;
                }
            }
            if (1 == i2) {
                H1();
                if (!this.K) {
                    this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08082b, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView3 = this.u;
                    int i5 = this.J + 1;
                    this.J = i5;
                    eMTextView3.setText(String.valueOf(i5));
                    this.K = true;
                }
            }
            VideoItemModel videoItemModel = this.i;
            if (videoItemModel == null || videoItemModel.getVideoAdData() == null) {
                return;
            }
            this.i.getVideoAdData().d(this.J);
            this.i.getVideoAdData().e(this.K);
        }
    }

    public final String J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ts8 ts8Var = this.M;
            if (ts8Var == null) {
                return "";
            }
            int c2 = ts8Var.c();
            return c2 != 1 ? c2 != 2 ? c2 != 3 ? "" : FunAdSdk.PLATFORM_CSJ : FunAdSdk.PLATFORM_KS : FunAdSdk.PLATFORM_GDT;
        }
        return (String) invokeV.objValue;
    }

    public final void K1() {
        GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gestureInterceptTouchFrameLayout = this.a) == null) {
            return;
        }
        this.p = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(R.id.obfuscated_res_0x7f09083e);
        this.q = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09083f);
        this.s = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090840);
        this.q.setVisibility(0);
        ms4.d(this.q).o(new int[]{R.color.CAM_X0606, R.color.CAM_X0601});
        this.r = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090842);
        this.t = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090154);
        VideoItemModel videoItemModel = this.i;
        if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
            this.K = this.i.getVideoAdData().b();
        }
        if (this.K) {
            this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08082b, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08082a, WebPManager.ResourceStateType.NORMAL));
        }
        this.u = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f09015c);
        VideoItemModel videoItemModel2 = this.i;
        if (videoItemModel2 != null && videoItemModel2.getVideoAdData() != null) {
            this.J = this.i.getVideoAdData().a();
        }
        this.u.setText(String.valueOf(this.J));
        ms4 d2 = ms4.d(this.u);
        d2.z(R.dimen.T_X09);
        d2.A(R.string.F_X01);
        d2.v(R.color.CAM_X0101);
        d2.y(R.array.S_O_X001);
        this.v = (TBLottieAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f090151);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090673);
        this.w = imageView;
        imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080831, WebPManager.ResourceStateType.NORMAL_DISABLE));
        EMTextView eMTextView = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090675);
        this.x = eMTextView;
        eMTextView.setText(R.string.obfuscated_res_0x7f0f1500);
        ms4 d3 = ms4.d(this.x);
        d3.z(R.dimen.T_X09);
        d3.A(R.string.F_X01);
        d3.v(R.color.CAM_X0101);
        d3.y(R.array.S_O_X001);
        this.w.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.x.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.y = this.a.findViewById(R.id.obfuscated_res_0x7f091530);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091537);
        this.z = imageView2;
        imageView2.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080830, WebPManager.ResourceStateType.NORMAL));
        EMTextView eMTextView2 = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f09153d);
        this.A = eMTextView2;
        eMTextView2.setText(R.string.obfuscated_res_0x7f0f1502);
        ms4 d4 = ms4.d(this.A);
        d4.z(R.dimen.T_X09);
        d4.A(R.string.F_X01);
        d4.v(R.color.CAM_X0101);
        d4.y(R.array.S_O_X001);
        this.B = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0900de);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0900dd);
        this.C = headImageView;
        headImageView.setDefaultResource(17170445);
        this.C.setPlaceHolder(2);
        this.C.setIsRound(true);
        this.C.setBorderWidth(R.dimen.L_X02);
        this.C.setBorderColor(R.color.CAM_X0622);
        this.C.setDrawBorder(true);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0900da);
        this.D = textView;
        ms4 d5 = ms4.d(textView);
        d5.z(R.dimen.T_X06);
        d5.A(R.string.F_X02);
        d5.v(R.color.CAM_X0101);
        ExpandableTextView expandableTextView = (ExpandableTextView) this.a.findViewById(R.id.obfuscated_res_0x7f09009f);
        this.E = expandableTextView;
        expandableTextView.setTextSize(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.T_X07));
        this.E.setTextColor(R.color.CAM_X0621);
        this.E.setLineSpacingExtra(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.E.setExpandable(false);
        this.E.setTextMaxLine(2);
        this.E.setLimitLine(2);
        LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0900aa);
        this.F = linearLayout;
        ms4 d6 = ms4.d(linearLayout);
        d6.n(R.string.J_X04);
        d6.f(R.color.CAM_X0614);
        this.G = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0900ab);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0900ac);
        this.H = textView2;
        textView2.setText(R.string.obfuscated_res_0x7f0f14ff);
        ms4 d7 = ms4.d(this.H);
        d7.z(R.dimen.T_X09);
        d7.v(R.color.CAM_X0621);
        d7.A(R.string.F_X01);
        this.I = new AdInfoButton(getContext());
        this.I.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ArrayList<View> arrayList = new ArrayList<>();
        this.N = arrayList;
        arrayList.add(this.G);
        this.N.add(this.B);
        this.N.add(this.E);
        ArrayList<View> arrayList2 = new ArrayList<>();
        this.O = arrayList2;
        arrayList2.add(this.I);
        M1();
        this.g.setVisibility(8);
    }

    public final void L1(ts8 ts8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ts8Var) == null) || ts8Var == null) {
            return;
        }
        if (!pi.isEmpty(ts8Var.f())) {
            this.C.K(ts8Var.f(), 12, false);
        }
        String e2 = ts8Var.e();
        if (e2.length() > 12) {
            e2 = e2.substring(0, 12);
        }
        this.D.setText(e2);
        if (pi.isEmpty(ts8Var.d())) {
            this.E.setData(TbadkCoreApplication.getInst().getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1501), false, null);
        } else {
            this.E.setData(ts8Var.d(), false, null);
        }
        if (ts8Var.c() == 3) {
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.setDuration(400L);
            this.s.setLayoutTransition(layoutTransition);
            this.I.setChannel(AdInfoButton.AdChannel.CSJ);
        } else {
            if (ts8Var.c() == 1) {
                this.I.setChannel(AdInfoButton.AdChannel.GDT);
            } else if (ts8Var.c() == 2) {
                this.I.setChannel(AdInfoButton.AdChannel.KS);
            }
            this.s.addView(this.I);
        }
        this.I.setType(ts8Var.b() == 2 ? AdInfoButton.AdType.DOWNLOAD : AdInfoButton.AdType.INFO);
        this.I.setText(ts8Var.a());
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.t.setOnClickListener(new k(this));
            this.y.setOnClickListener(new l(this));
            this.w.setOnClickListener(new a(this));
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    public void O1(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
        }
    }

    public void P1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.j = str;
        }
    }

    public void Q1(VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, videoItemModel) == null) {
            this.i = videoItemModel;
        }
    }

    public void R1(cw8 cw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cw8Var) == null) {
            this.h = cw8Var;
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.k0 = false;
            shareItem.l0 = true;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.closeAdListener = this.Q;
            shareDialogConfig.mShowMoreForumShare = false;
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.mIsAd = true;
            p16.c().l(shareDialogConfig);
        }
    }

    public final void T1(String str, String str2, int i2) {
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048589, this, str, str2, i2) == null) {
            ts8 ts8Var = this.M;
            if (ts8Var != null) {
                str3 = ts8Var.e();
                str4 = this.M.d();
                str5 = J1();
            } else {
                str3 = "";
                str4 = str3;
                str5 = str4;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.j).param("obj_locate", i2).param(TiebaStatic.Params.OBJ_PARAM2, str).param(TiebaStatic.Params.OBJ_TO, str5).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, str3).param(TiebaStatic.Params.AD_DESC, str4).param(TiebaStatic.Params.AD_SOURCE, str2).param(TiebaStatic.Params.AD_TYPE, "4"));
        }
    }

    @Override // com.repackage.oj5.b
    public void k0(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && UbsABTestHelper.isVideoAdDrawABTestB()) {
            I1(1);
        }
    }

    @Override // com.repackage.hw8
    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.o = i2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.P);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.n == i2) {
                return;
            }
            this.n = i2;
            WebPManager.setMaskDrawable(this.e, R.drawable.obfuscated_res_0x7f0807d9, null);
            ms4.d(this.a).f(R.color.CAM_X0611);
            WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080a01, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            AdInfoButton adInfoButton = this.I;
            if (adInfoButton != null) {
                adInfoButton.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Object n;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("from");
            }
            GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout = (GestureInterceptTouchFrameLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08a2, (ViewGroup) null);
            this.a = gestureInterceptTouchFrameLayout;
            this.b = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(R.id.obfuscated_res_0x7f090c1c);
            this.c = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090913);
            this.e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0900a3);
            this.d = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0900f6);
            this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09030d);
            this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090994);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.f.setVisibility(8);
            this.f.setOnClickListener(new e(this));
            this.g.setOnClickListener(new f(this));
            this.k = new av8(getActivity(), this.c);
            if (UbsABTestHelper.isVideoAdDrawABTestA() && !ss6.m().v("6061002332-203360688")) {
                this.b.setVisibility(8);
                this.e.setVisibility(0);
                this.l = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.j).param("obj_locate", 2).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
                return this.a;
            } else if (UbsABTestHelper.isVideoAdDrawABTestB() && !ss6.m().v(ss6.s())) {
                this.b.setVisibility(8);
                this.g.setVisibility(8);
                this.e.setVisibility(0);
                this.l = true;
                T1("", "", 2);
                return this.a;
            } else {
                this.e.setVisibility(8);
                this.b.setVisibility(0);
                if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                    K1();
                    M1();
                    VideoItemModel videoItemModel = this.i;
                    if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
                        if (this.i.getVideoAdData().c() != null) {
                            n = this.i.getVideoAdData().c();
                        } else {
                            n = ss6.m().n(getActivity(), ss6.s());
                            this.i.getVideoAdData().f(n);
                        }
                    } else {
                        n = ss6.m().n(getActivity(), ss6.s());
                    }
                    View t = ss6.m().t(n);
                    if (t != null) {
                        if (t.getParent() != null) {
                            ((ViewGroup) t.getParent()).removeView(t);
                        }
                        this.r.addView(t);
                    }
                    ts8 I = ss6.m().I(n);
                    this.M = I;
                    L1(I);
                    ss6.m().C(n, this.R);
                    ss6.m().B(this.G, n);
                    ss6.m().F(getActivity(), n, new g(this), this.p, this.N, this.O, ss6.b(this.j, (VideoMiddleAdSwitch.isOn() && UbsABTestHelper.isVideoAdDrawABTestB()) ? "0" : "0"), ss6.s());
                    if (ss6.m().D(n) && (frameLayout = this.p) != null && (frameLayout.getParent() instanceof ViewGroup)) {
                        ViewGroup viewGroup2 = (ViewGroup) this.p.getParent();
                        if (viewGroup2.getChildCount() > 1) {
                            int childCount = viewGroup2.getChildCount() - 1;
                            if (viewGroup2.getChildAt(childCount) instanceof ImageView) {
                                viewGroup2.removeViewAt(childCount);
                            }
                        }
                    }
                } else if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                    ss6.m().E(getActivity(), "6061002332-203360688", this.b, new h(this), ss6.b(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE, VideoMiddleAdSwitch.isOn() ? "1" : "0"));
                }
                this.a.setSimpleOnGestureListener(new i(this));
                return this.a;
            }
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroyView();
            av8 av8Var = this.k;
            if (av8Var != null) {
                av8Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPrimary();
            if (this.l && this.k != null && isPrimary()) {
                av8 av8Var = this.k;
                av8Var.k(getString(R.string.obfuscated_res_0x7f0f00b6));
                av8Var.l();
            }
        }
    }

    @Override // com.repackage.oj5.b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.repackage.oj5.b
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // com.repackage.hw8
    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.o : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        av8 av8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z || (av8Var = this.k) == null) {
                return;
            }
            av8Var.j();
        }
    }
}
