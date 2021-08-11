package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.d1.q.a;
import c.a.p0.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class VideoAdFragment extends BaseFragment implements a.b, c.a.p0.y3.i.a.a {
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
    public c.a.p0.w3.g Q;
    public ArrayList<View> R;
    public ArrayList<View> S;
    public View.OnClickListener T;
    public a.j U;

    /* renamed from: e  reason: collision with root package name */
    public View f57468e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f57469f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f57470g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f57471h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f57472i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f57473j;
    public ImageView k;
    public c.a.p0.y3.h.a l;
    public VideoItemModel m;
    public String n;
    public c.a.p0.y3.c.a o;
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

    /* loaded from: classes7.dex */
    public class a implements a.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f57474a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f57475b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57476c;

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
            this.f57476c = videoAdFragment;
            this.f57474a = false;
            this.f57475b = false;
        }

        @Override // c.a.p0.w0.a.j
        public void a(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                int i2 = ((int) j2) / 1000;
                if (i2 == 3 && !this.f57474a) {
                    this.f57474a = true;
                    this.f57476c.w.addView(this.f57476c.M);
                } else if (i2 != 5 || this.f57475b) {
                } else {
                    this.f57475b = true;
                    this.f57476c.M.playStressAnimation();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57477e;

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
            this.f57477e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57477e.getActivity() == null) {
                return;
            }
            this.f57477e.getActivity().finish();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57478e;

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
            this.f57478e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57478e.m == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921566);
            customMessage.setTag(this.f57478e.q);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.f57478e.m.getHashCode()));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f57478e.n).param("obj_locate", 0));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57479a;

        public d(VideoAdFragment videoAdFragment) {
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
            this.f57479a = videoAdFragment;
        }

        @Override // c.a.p0.w0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.f57479a.n).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param(TiebaStatic.Params.OBJ_TO, this.f57479a.q()).param(TiebaStatic.Params.AD_TITLE, this.f57479a.Q != null ? this.f57479a.Q.e() : "").param(TiebaStatic.Params.AD_DESC, this.f57479a.Q != null ? this.f57479a.Q.d() : "").param(TiebaStatic.Params.AD_SOURCE, str2));
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f57479a.v("", "", 1);
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f57479a.v(str3, str2, 0);
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57480a;

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
            this.f57480a = videoAdFragment;
        }

        @Override // c.a.p0.w0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", this.f57480a.n).param("obj_locate", 0).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f57480a.p = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.f57480a.n).param("obj_locate", 1).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f57480a.p = false;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.f57480a.n).param("obj_locate", 0).param(TiebaStatic.Params.OBJ_PARAM2, str3).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4").param(TiebaStatic.Params.OBJ_TO, str2).param(TiebaStatic.Params.OBJ_PARAM2, str3));
                if (this.f57480a.l != null) {
                    this.f57480a.l.prefetch();
                }
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57481e;

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
            this.f57481e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57481e.m == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921566);
            customMessage.setTag(this.f57481e.q);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921566, Integer.valueOf(this.f57481e.m.getHashCode()));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f57481e.n));
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57482e;

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
            this.f57482e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57482e.p(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57483e;

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
            this.f57483e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57483e.u();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57484e;

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
            this.f57484e = videoAdFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAdFragment f57485e;

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
            this.f57485e = videoAdFragment;
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
                this.f57485e.z.setVisibility(8);
                this.f57485e.P = false;
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
        this.T = new f(this);
        this.U = new a(this);
    }

    @Override // c.a.p0.y3.i.a.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (VideoItemModel) invokeV.objValue;
    }

    @Override // c.a.p0.y3.i.a.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : invokeV.intValue;
    }

    public final void o() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f57468e == null || (tBLottieAnimationView = this.z) == null || this.P) {
            return;
        }
        tBLottieAnimationView.setVisibility(0);
        this.P = true;
        SkinManager.setLottieAnimation(this.z, R.raw.lottie_agree_big_photo);
        this.z.addAnimatorListener(new j(this));
        this.z.playAnimation();
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
            WebPManager.setMaskDrawable(this.f57472i, R.drawable.icon_mask_header40, null);
            c.a.o0.s.u.c.d(this.f57468e).f(R.color.CAM_X0611);
            WebPManager.setPureDrawable(this.f57473j, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            AdInfoButton adInfoButton = this.M;
            if (adInfoButton != null) {
                adInfoButton.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Object j2;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("from");
            }
            View inflate = layoutInflater.inflate(R.layout.video_ad_view, (ViewGroup) null);
            this.f57468e = inflate;
            this.f57469f = (FrameLayout) inflate.findViewById(R.id.fun_ad_container);
            this.f57470g = (FrameLayout) this.f57468e.findViewById(R.id.error_tip_container);
            this.f57472i = (ImageView) this.f57468e.findViewById(R.id.ad_error_image);
            this.f57471h = (LinearLayout) this.f57468e.findViewById(R.id.ad_top_container);
            this.f57473j = (ImageView) this.f57468e.findViewById(R.id.back_btn);
            this.k = (ImageView) this.f57468e.findViewById(R.id.feed_back);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.f57471h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f57471h.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.f57473j.setVisibility(8);
            this.f57473j.setOnClickListener(new b(this));
            this.k.setOnClickListener(new c(this));
            this.o = new c.a.p0.y3.c.a(getActivity(), this.f57470g);
            if (c.a.o0.b.d.d0() && !c.a.p0.w0.a.i().m("6061002332-203360688")) {
                this.f57469f.setVisibility(8);
                this.f57472i.setVisibility(0);
                this.p = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.n).param("obj_locate", 2).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, "").param(TiebaStatic.Params.AD_DESC, "").param("ad_pic", "").param(TiebaStatic.Params.AD_SOURCE, "").param(TiebaStatic.Params.AD_TYPE, "4"));
                return this.f57468e;
            } else if (c.a.o0.b.d.e0() && !c.a.p0.w0.a.i().m("6061002410-390177882")) {
                this.f57469f.setVisibility(8);
                this.k.setVisibility(8);
                this.f57472i.setVisibility(0);
                this.p = true;
                v("", "", 2);
                return this.f57468e;
            } else {
                this.f57472i.setVisibility(8);
                this.f57469f.setVisibility(0);
                if (c.a.o0.b.d.e0()) {
                    r();
                    t();
                    if (this.m.getVideoAdData().c() != null) {
                        j2 = this.m.getVideoAdData().c();
                    } else {
                        j2 = c.a.p0.w0.a.i().j(getActivity(), "6061002410-390177882");
                        this.m.getVideoAdData().f(j2);
                    }
                    View k = c.a.p0.w0.a.i().k(j2);
                    if (k != null) {
                        if (k.getParent() != null) {
                            ((ViewGroup) k.getParent()).removeView(k);
                        }
                        this.v.addView(k);
                    }
                    c.a.p0.w3.g A = c.a.p0.w0.a.i().A(j2);
                    this.Q = A;
                    s(A);
                    c.a.p0.w0.a.i().t(j2, this.U);
                    c.a.p0.w0.a.i().s(this.K, j2);
                    c.a.p0.w0.a.i().x(getActivity(), j2, new d(this), this.t, this.R, this.S, c.a.p0.w0.a.b(this.n, (VideoMiddleAdSwitch.isOn() && c.a.o0.b.d.e0()) ? "0" : "0"));
                    if (c.a.p0.w0.a.i().u(j2) && (frameLayout = this.t) != null && frameLayout.getChildCount() > 1) {
                        FrameLayout frameLayout2 = this.t;
                        if (frameLayout2.getChildAt(frameLayout2.getChildCount() - 1) instanceof ImageView) {
                            FrameLayout frameLayout3 = this.t;
                            frameLayout3.removeViewAt(frameLayout3.getChildCount() - 1);
                        }
                    }
                } else if (c.a.o0.b.d.d0()) {
                    c.a.p0.w0.a.i().v(getActivity(), "6061002332-203360688", this.f57469f, new e(this), c.a.p0.w0.a.b("video_middle", VideoMiddleAdSwitch.isOn() ? "1" : "0"));
                }
                return this.f57468e;
            }
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroyView();
            c.a.p0.y3.c.a aVar = this.o;
            if (aVar != null) {
                aVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPrimary();
            if (this.p && this.o != null && isPrimary()) {
                c.a.p0.y3.c.a aVar = this.o;
                aVar.k(getString(R.string.ad_show_error));
                aVar.l();
            }
        }
    }

    @Override // c.a.o0.d1.q.a.b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // c.a.o0.d1.q.a.b
    public void onViewDoubleClick(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && c.a.o0.b.d.e0()) {
            p(1);
        }
    }

    @Override // c.a.o0.d1.q.a.b
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 0) {
                if (this.O) {
                    this.x.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView = this.y;
                    int i3 = this.N - 1;
                    this.N = i3;
                    eMTextView.setText(String.valueOf(i3));
                    this.O = false;
                } else {
                    o();
                    this.x.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good88, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView2 = this.y;
                    int i4 = this.N + 1;
                    this.N = i4;
                    eMTextView2.setText(String.valueOf(i4));
                    this.O = true;
                }
            }
            if (1 == i2) {
                o();
                if (!this.O) {
                    this.x.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good88, WebPManager.ResourceStateType.NORMAL));
                    EMTextView eMTextView3 = this.y;
                    int i5 = this.N + 1;
                    this.N = i5;
                    eMTextView3.setText(String.valueOf(i5));
                    this.O = true;
                }
            }
            this.m.getVideoAdData().d(this.N);
            this.m.getVideoAdData().e(this.O);
        }
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.p0.w3.g gVar = this.Q;
            if (gVar == null) {
                return "";
            }
            int c2 = gVar.c();
            return c2 != 1 ? c2 != 2 ? c2 != 3 ? "" : FunAdSdk.PLATFORM_CSJ : FunAdSdk.PLATFORM_KS : FunAdSdk.PLATFORM_GDT;
        }
        return (String) invokeV.objValue;
    }

    public final void r() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (view = this.f57468e) == null) {
            return;
        }
        this.t = (FrameLayout) view.findViewById(R.id.draw_container);
        this.u = (LinearLayout) this.f57468e.findViewById(R.id.draw_info_container);
        this.w = (LinearLayout) this.f57468e.findViewById(R.id.draw_info_desc_container);
        this.u.setVisibility(0);
        c.a.o0.s.u.c.d(this.u).o(new int[]{R.color.CAM_X0606, R.color.CAM_X0601});
        this.v = (FrameLayout) this.f57468e.findViewById(R.id.draw_video_container);
        this.x = (ImageView) this.f57468e.findViewById(R.id.agree_img);
        boolean b2 = this.m.getVideoAdData().b();
        this.O = b2;
        if (b2) {
            this.x.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good88, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.x.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        this.y = (EMTextView) this.f57468e.findViewById(R.id.agree_num);
        int a2 = this.m.getVideoAdData().a();
        this.N = a2;
        this.y.setText(String.valueOf(a2));
        c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(this.y);
        d2.x(R.dimen.T_X09);
        d2.y(R.string.F_X01);
        d2.t(R.color.CAM_X0101);
        d2.w(R.array.S_O_X001);
        this.z = (TBLottieAnimationView) this.f57468e.findViewById(R.id.agree_animation_view);
        ImageView imageView = (ImageView) this.f57468e.findViewById(R.id.comment_img);
        this.A = imageView;
        imageView.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_DISABLE));
        EMTextView eMTextView = (EMTextView) this.f57468e.findViewById(R.id.comment_num);
        this.B = eMTextView;
        eMTextView.setText(R.string.video_ad_draw_comment);
        c.a.o0.s.u.c d3 = c.a.o0.s.u.c.d(this.B);
        d3.x(R.dimen.T_X09);
        d3.y(R.string.F_X01);
        d3.t(R.color.CAM_X0101);
        d3.w(R.array.S_O_X001);
        this.A.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.B.setAlpha(SkinManager.RESOURCE_ALPHA_PRESS);
        this.C = this.f57468e.findViewById(R.id.more_container);
        ImageView imageView2 = (ImageView) this.f57468e.findViewById(R.id.more_img);
        this.D = imageView2;
        imageView2.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_more36, WebPManager.ResourceStateType.NORMAL));
        EMTextView eMTextView2 = (EMTextView) this.f57468e.findViewById(R.id.more_text);
        this.E = eMTextView2;
        eMTextView2.setText(R.string.video_ad_draw_more);
        c.a.o0.s.u.c d4 = c.a.o0.s.u.c.d(this.E);
        d4.x(R.dimen.T_X09);
        d4.y(R.string.F_X01);
        d4.t(R.color.CAM_X0101);
        d4.w(R.array.S_O_X001);
        this.F = (LinearLayout) this.f57468e.findViewById(R.id.ad_portrait_and_name);
        HeadImageView headImageView = (HeadImageView) this.f57468e.findViewById(R.id.ad_portrait);
        this.G = headImageView;
        headImageView.setDefaultResource(17170445);
        this.G.setPlaceHolder(2);
        this.G.setIsRound(true);
        this.G.setBorderWidth(R.dimen.L_X02);
        this.G.setBorderColor(R.color.CAM_X0622);
        this.G.setDrawBorder(true);
        TextView textView = (TextView) this.f57468e.findViewById(R.id.ad_name);
        this.H = textView;
        c.a.o0.s.u.c d5 = c.a.o0.s.u.c.d(textView);
        d5.x(R.dimen.T_X06);
        d5.y(R.string.F_X02);
        d5.t(R.color.CAM_X0101);
        ExpandableTextView expandableTextView = (ExpandableTextView) this.f57468e.findViewById(R.id.ad_desc);
        this.I = expandableTextView;
        expandableTextView.setTextSize(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.T_X07));
        this.I.setTextColor(R.color.CAM_X0621);
        this.I.setLineSpacingExtra(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.I.setExpandable(false);
        this.I.setTextMaxLine(2);
        this.I.setLimitLine(2);
        LinearLayout linearLayout = (LinearLayout) this.f57468e.findViewById(R.id.ad_icon_bg);
        this.J = linearLayout;
        c.a.o0.s.u.c d6 = c.a.o0.s.u.c.d(linearLayout);
        d6.n(R.string.J_X04);
        d6.f(R.color.CAM_X0614);
        this.K = (ImageView) this.f57468e.findViewById(R.id.ad_icon_img);
        TextView textView2 = (TextView) this.f57468e.findViewById(R.id.ad_icon_text);
        this.L = textView2;
        textView2.setText(R.string.video_ad_draw_ad);
        c.a.o0.s.u.c d7 = c.a.o0.s.u.c.d(this.L);
        d7.x(R.dimen.T_X09);
        d7.t(R.color.CAM_X0621);
        d7.y(R.string.F_X01);
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
        t();
        this.k.setVisibility(8);
    }

    public final void s(c.a.p0.w3.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) || gVar == null) {
            return;
        }
        if (!k.isEmpty(gVar.f())) {
            this.G.startLoad(gVar.f(), 12, false);
        }
        String e2 = gVar.e();
        if (e2.length() > 12) {
            e2 = e2.substring(0, 12);
        }
        this.H.setText(e2);
        if (k.isEmpty(gVar.d())) {
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

    public void setBaseActivityId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.q = bdUniqueId;
        }
    }

    @Override // c.a.p0.y3.i.a.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setPageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        c.a.p0.y3.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            super.setUserVisibleHint(z);
            if (z || (aVar = this.o) == null) {
                return;
            }
            aVar.j();
        }
    }

    public void setVideoAdDataModel(VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, videoItemModel) == null) {
            this.m = videoItemModel;
        }
    }

    public void setVideoPlayPrefetcher(c.a.p0.y3.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.x.setOnClickListener(new g(this));
            this.C.setOnClickListener(new h(this));
            this.A.setOnClickListener(new i(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.a0 = false;
            shareItem.b0 = true;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
            shareDialogConfig.closeAdListener = this.T;
            shareDialogConfig.mShowMoreForumShare = false;
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.mIsAd = true;
            c.a.p0.e0.f.b().k(shareDialogConfig);
        }
    }

    public final void v(String str, String str2, int i2) {
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, str, str2, i2) == null) {
            c.a.p0.w3.g gVar = this.Q;
            if (gVar != null) {
                str3 = gVar.e();
                str4 = this.Q.d();
                str5 = q();
            } else {
                str3 = "";
                str4 = str3;
                str5 = str4;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", this.n).param("obj_locate", i2).param(TiebaStatic.Params.OBJ_PARAM2, str).param(TiebaStatic.Params.OBJ_TO, str5).param("tid", "").param("fid", "").param(TiebaStatic.Params.AD_TITLE, str3).param(TiebaStatic.Params.AD_DESC, str4).param(TiebaStatic.Params.AD_SOURCE, str2).param(TiebaStatic.Params.AD_TYPE, "4"));
        }
    }
}
