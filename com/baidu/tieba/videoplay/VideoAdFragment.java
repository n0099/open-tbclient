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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.e2a;
import com.baidu.tieba.g35;
import com.baidu.tieba.hi;
import com.baidu.tieba.ii;
import com.baidu.tieba.kx5;
import com.baidu.tieba.oy9;
import com.baidu.tieba.pl6;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.view.AdInfoButton;
import com.baidu.tieba.videoplay.view.GestureInterceptTouchFrameLayout;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.tieba.w0a;
import com.baidu.tieba.y1a;
import com.baidu.tieba.zl7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class VideoAdFragment extends BaseFragment implements kx5.b, e2a {
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
    public oy9 M;
    public ArrayList<View> N;
    public ArrayList<View> O;
    public CustomMessageListener P;
    public View.OnClickListener Q;
    public zl7.j R;
    public GestureInterceptTouchFrameLayout a;
    public FrameLayout b;
    public FrameLayout c;
    public LinearLayout d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public y1a h;
    public VideoItemModel i;
    public String j;
    public w0a k;
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

    @Override // com.baidu.tieba.kx5.b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.tieba.kx5.b
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
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
    }

    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener {
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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.v.setVisibility(8);
                this.a.L = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements zl7.j {
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

        @Override // com.baidu.tieba.zl7.j
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                int i = ((int) j) / 1000;
                if (i == 3 && !this.a) {
                    this.a = true;
                    this.c.s.addView(this.c.I);
                } else if (i == 5 && !this.b) {
                    this.b = true;
                    this.c.I.d();
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

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getActivity() != null) {
                this.a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null) {
                CustomMessage customMessage = new CustomMessage(2921566);
                customMessage.setTag(this.a.m);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.a.i.getHashCode()));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements zl7.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        @Override // com.baidu.tieba.zl7.i
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.zl7.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

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

        @Override // com.baidu.tieba.zl7.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, str) != null) {
                return;
            }
            this.a.e2("", "", 1);
        }

        @Override // com.baidu.tieba.zl7.i
        public void onAdClicked(String str, String str2, String str3) {
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param(TiebaStatic.Params.OBJ_TO, this.a.V1());
                String str5 = "";
                if (this.a.M == null) {
                    str4 = "";
                } else {
                    str4 = this.a.M.e();
                }
                StatisticItem param2 = param.param(TiebaStatic.Params.AD_TITLE, str4);
                if (this.a.M != null) {
                    str5 = this.a.M.d();
                }
                TiebaStatic.log(param2.param(TiebaStatic.Params.AD_DESC, str5).param(TiebaStatic.Params.AD_SOURCE, str2));
            }
        }

        @Override // com.baidu.tieba.zl7.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048580, this, str, str2, str3) != null) {
                return;
            }
            this.a.e2(str3, str2, 0);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements zl7.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAdFragment a;

        @Override // com.baidu.tieba.zl7.i
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.zl7.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

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

        @Override // com.baidu.tieba.zl7.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 0).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
            }
        }

        @Override // com.baidu.tieba.zl7.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLL(1048580, this, str, str2, str3) != null) {
                return;
            }
            this.a.l = false;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
            if (this.a.h != null) {
                this.a.h.c();
            }
        }

        @Override // com.baidu.tieba.zl7.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.l = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.a.j).param("obj_locate", 1).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null) {
                CustomMessage customMessage = new CustomMessage(2921566);
                customMessage.setTag(this.a.m);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.a.i.getHashCode()));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.a.j));
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.U1(0);
        }
    }

    /* loaded from: classes6.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.d2();
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

    public void Z1(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
        }
    }

    public void a2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j = str;
        }
    }

    public void b2(VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoItemModel) == null) {
            this.i = videoItemModel;
        }
    }

    public void c2(y1a y1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, y1aVar) == null) {
            this.h = y1aVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.P);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        w0a w0aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.setUserVisibleHint(z);
            if (!z && (w0aVar = this.k) != null) {
                w0aVar.j();
            }
        }
    }

    @Override // com.baidu.tieba.e2a
    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.o = i2;
        }
    }

    @Override // com.baidu.tieba.kx5.b
    public void t0(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && UbsABTestHelper.isVideoAdDrawABTestB()) {
            U1(1);
        }
    }

    @Override // com.baidu.tieba.e2a
    public VideoItemModel M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (VideoItemModel) invokeV.objValue;
    }

    public final String V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            oy9 oy9Var = this.M;
            if (oy9Var == null) {
                return "";
            }
            int c2 = oy9Var.c();
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

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.t.setOnClickListener(new k(this));
            this.y.setOnClickListener(new l(this));
            this.w.setOnClickListener(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyView();
            w0a w0aVar = this.k;
            if (w0aVar != null) {
                w0aVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (this.l && this.k != null && isPrimary()) {
                w0a w0aVar = this.k;
                w0aVar.k(getString(R.string.obfuscated_res_0x7f0f00b9));
                w0aVar.l();
            }
        }
    }

    @Override // com.baidu.tieba.e2a
    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public final void T1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a != null && (tBLottieAnimationView = this.v) != null && !this.L) {
            tBLottieAnimationView.setVisibility(0);
            this.L = true;
            SkinManager.setLottieAnimation(this.v, R.raw.lottie_agree_big_photo);
            this.v.addAnimatorListener(new b(this));
            this.v.playAnimation();
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.o0 = false;
            shareItem.p0 = true;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.closeAdListener = this.Q;
            shareDialogConfig.mShowMoreForumShare = false;
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.mIsAd = true;
            pl6.c().l(shareDialogConfig);
        }
    }

    public final void U1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 0) {
                if (this.K) {
                    this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0808bf, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView = this.u;
                    int i3 = this.J - 1;
                    this.J = i3;
                    eMTextView.setText(String.valueOf(i3));
                    this.K = false;
                } else {
                    T1();
                    this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0808c0, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView2 = this.u;
                    int i4 = this.J + 1;
                    this.J = i4;
                    eMTextView2.setText(String.valueOf(i4));
                    this.K = true;
                }
            }
            if (1 == i2) {
                T1();
                if (!this.K) {
                    this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0808c0, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView3 = this.u;
                    int i5 = this.J + 1;
                    this.J = i5;
                    eMTextView3.setText(String.valueOf(i5));
                    this.K = true;
                }
            }
            VideoItemModel videoItemModel = this.i;
            if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
                this.i.getVideoAdData().d(this.J);
                this.i.getVideoAdData().e(this.K);
            }
        }
    }

    public final void X1(oy9 oy9Var) {
        AdInfoButton.AdType adType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, oy9Var) != null) || oy9Var == null) {
            return;
        }
        if (!hi.isEmpty(oy9Var.f())) {
            this.C.N(oy9Var.f(), 12, false);
        }
        String e2 = oy9Var.e();
        if (e2.length() > 12) {
            e2 = e2.substring(0, 12);
        }
        this.D.setText(e2);
        if (hi.isEmpty(oy9Var.d())) {
            this.E.setData(TbadkCoreApplication.getInst().getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1654), false, null);
        } else {
            this.E.setData(oy9Var.d(), false, null);
        }
        if (oy9Var.c() == 3) {
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.setDuration(400L);
            this.s.setLayoutTransition(layoutTransition);
            this.I.setChannel(AdInfoButton.AdChannel.CSJ);
        } else {
            if (oy9Var.c() == 1) {
                this.I.setChannel(AdInfoButton.AdChannel.GDT);
            } else if (oy9Var.c() == 2) {
                this.I.setChannel(AdInfoButton.AdChannel.KS);
            }
            this.s.addView(this.I);
        }
        AdInfoButton adInfoButton = this.I;
        if (oy9Var.b() == 2) {
            adType = AdInfoButton.AdType.DOWNLOAD;
        } else {
            adType = AdInfoButton.AdType.INFO;
        }
        adInfoButton.setType(adType);
        this.I.setText(oy9Var.a());
    }

    public final void W1() {
        GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (gestureInterceptTouchFrameLayout = this.a) == null) {
            return;
        }
        this.p = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(R.id.obfuscated_res_0x7f090912);
        this.q = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090913);
        this.s = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090914);
        this.q.setVisibility(0);
        g35.d(this.q).p(new int[]{R.color.CAM_X0606, R.color.CAM_X0601});
        this.r = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090916);
        this.t = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090156);
        VideoItemModel videoItemModel = this.i;
        if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
            this.K = this.i.getVideoAdData().b();
        }
        if (this.K) {
            this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0808c0, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.t.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0808bf, WebPManager.ResourceStateType.NORMAL));
        }
        this.u = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f09015e);
        VideoItemModel videoItemModel2 = this.i;
        if (videoItemModel2 != null && videoItemModel2.getVideoAdData() != null) {
            this.J = this.i.getVideoAdData().a();
        }
        this.u.setText(String.valueOf(this.J));
        g35 d2 = g35.d(this.u);
        d2.B(R.dimen.T_X09);
        d2.C(R.string.F_X01);
        d2.w(R.color.CAM_X0101);
        d2.A(R.array.S_O_X001);
        this.v = (TBLottieAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f090154);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09072e);
        this.w = imageView;
        imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0808c6, WebPManager.ResourceStateType.NORMAL_DISABLE));
        EMTextView eMTextView = (EMTextView) this.a.findViewById(R.id.comment_num);
        this.x = eMTextView;
        eMTextView.setText(R.string.obfuscated_res_0x7f0f1653);
        g35 d3 = g35.d(this.x);
        d3.B(R.dimen.T_X09);
        d3.C(R.string.F_X01);
        d3.w(R.color.CAM_X0101);
        d3.A(R.array.S_O_X001);
        this.w.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.x.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.y = this.a.findViewById(R.id.obfuscated_res_0x7f0916e4);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0916eb);
        this.z = imageView2;
        imageView2.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0808c5, WebPManager.ResourceStateType.NORMAL));
        EMTextView eMTextView2 = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f0916f2);
        this.A = eMTextView2;
        eMTextView2.setText(R.string.obfuscated_res_0x7f0f1655);
        g35 d4 = g35.d(this.A);
        d4.B(R.dimen.T_X09);
        d4.C(R.string.F_X01);
        d4.w(R.color.CAM_X0101);
        d4.A(R.array.S_O_X001);
        this.B = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0900ee);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0900ed);
        this.C = headImageView;
        headImageView.setDefaultResource(17170445);
        this.C.setPlaceHolder(2);
        this.C.setIsRound(true);
        this.C.setBorderWidth(R.dimen.L_X02);
        this.C.setBorderColor(R.color.CAM_X0622);
        this.C.setDrawBorder(true);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0900e6);
        this.D = textView;
        g35 d5 = g35.d(textView);
        d5.B(R.dimen.T_X06);
        d5.C(R.string.F_X02);
        d5.w(R.color.CAM_X0101);
        ExpandableTextView expandableTextView = (ExpandableTextView) this.a.findViewById(R.id.obfuscated_res_0x7f0900a3);
        this.E = expandableTextView;
        expandableTextView.setTextSize(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.T_X07));
        this.E.setTextColor(R.color.CAM_X0621);
        this.E.setLineSpacingExtra(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.E.setExpandable(false);
        this.E.setTextMaxLine(2);
        this.E.setLimitLine(2);
        LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0900ae);
        this.F = linearLayout;
        g35 d6 = g35.d(linearLayout);
        d6.o(R.string.J_X04);
        d6.f(R.color.CAM_X0614);
        this.G = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0900af);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0900b0);
        this.H = textView2;
        textView2.setText(R.string.obfuscated_res_0x7f0f1652);
        g35 d7 = g35.d(this.H);
        d7.B(R.dimen.T_X09);
        d7.w(R.color.CAM_X0621);
        d7.C(R.string.F_X01);
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
        Y1();
        this.g.setVisibility(8);
    }

    public final void e2(String str, String str2, int i2) {
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i2) == null) {
            oy9 oy9Var = this.M;
            if (oy9Var == null) {
                str3 = "";
                str4 = str3;
                str5 = str4;
            } else {
                str3 = oy9Var.e();
                str4 = this.M.d();
                str5 = V1();
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.j).param("obj_locate", i2).param(TiebaStatic.Params.OBJ_PARAM2, str).param(TiebaStatic.Params.OBJ_TO, str5).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, str3).param(TiebaStatic.Params.AD_DESC, str4).param(TiebaStatic.Params.AD_SOURCE, str2).param(TiebaStatic.Params.AD_TYPE, "4"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.n == i2) {
                return;
            }
            this.n = i2;
            WebPManager.setMaskDrawable(this.e, R.drawable.obfuscated_res_0x7f08086c, null);
            g35.d(this.a).f(R.color.CAM_X0611);
            WebPManager.setPureDrawable(this.f, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("from");
            }
            GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout = (GestureInterceptTouchFrameLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0943, (ViewGroup) null);
            this.a = gestureInterceptTouchFrameLayout;
            this.b = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(R.id.obfuscated_res_0x7f090d47);
            this.c = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909eb);
            this.e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0900a7);
            this.d = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090107);
            this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090317);
            this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a9f);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.f.setVisibility(8);
            this.f.setOnClickListener(new e(this));
            this.g.setOnClickListener(new f(this));
            this.k = new w0a(getActivity(), this.c);
            if (UbsABTestHelper.isVideoAdDrawABTestA() && !zl7.m().v("6061002332-203360688")) {
                this.b.setVisibility(8);
                this.e.setVisibility(0);
                this.l = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.j).param("obj_locate", 2).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
                return this.a;
            } else if (UbsABTestHelper.isVideoAdDrawABTestB() && !zl7.m().v(zl7.s())) {
                this.b.setVisibility(8);
                this.g.setVisibility(8);
                this.e.setVisibility(0);
                this.l = true;
                e2("", "", 2);
                return this.a;
            } else {
                this.e.setVisibility(8);
                this.b.setVisibility(0);
                String str = "1";
                if (UbsABTestHelper.isVideoAdDrawABTestB()) {
                    W1();
                    Y1();
                    VideoItemModel videoItemModel = this.i;
                    if (videoItemModel != null && videoItemModel.getVideoAdData() != null) {
                        if (this.i.getVideoAdData().c() != null) {
                            n = this.i.getVideoAdData().c();
                        } else {
                            n = zl7.m().n(getActivity(), zl7.s());
                            this.i.getVideoAdData().f(n);
                        }
                    } else {
                        n = zl7.m().n(getActivity(), zl7.s());
                    }
                    View t = zl7.m().t(n);
                    if (t != null) {
                        if (t.getParent() != null) {
                            ((ViewGroup) t.getParent()).removeView(t);
                        }
                        this.r.addView(t);
                    }
                    oy9 I = zl7.m().I(n);
                    this.M = I;
                    X1(I);
                    zl7.m().C(n, this.R);
                    zl7.m().B(this.G, n);
                    zl7.m().F(getActivity(), n, new g(this), this.p, this.N, this.O, zl7.b(this.j, (VideoMiddleAdSwitch.isOn() && UbsABTestHelper.isVideoAdDrawABTestB()) ? "0" : "0"), zl7.s());
                    if (zl7.m().D(n) && (frameLayout = this.p) != null && (frameLayout.getParent() instanceof ViewGroup)) {
                        ViewGroup viewGroup2 = (ViewGroup) this.p.getParent();
                        if (viewGroup2.getChildCount() > 1) {
                            int childCount = viewGroup2.getChildCount() - 1;
                            if (viewGroup2.getChildAt(childCount) instanceof ImageView) {
                                viewGroup2.removeViewAt(childCount);
                            }
                        }
                    }
                } else if (UbsABTestHelper.isVideoAdDrawABTestA()) {
                    zl7 m = zl7.m();
                    FragmentActivity activity = getActivity();
                    FrameLayout frameLayout2 = this.b;
                    h hVar = new h(this);
                    if (!VideoMiddleAdSwitch.isOn()) {
                        str = "0";
                    }
                    m.E(activity, "6061002332-203360688", frameLayout2, hVar, zl7.b(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE, str));
                }
                this.a.setSimpleOnGestureListener(new i(this));
                return this.a;
            }
        }
        return (View) invokeLLL.objValue;
    }
}
