package com.baidu.tieba.pb.pb.main.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.bs4;
import com.baidu.tieba.cs8;
import com.baidu.tieba.i08;
import com.baidu.tieba.i68;
import com.baidu.tieba.mc5;
import com.baidu.tieba.pe5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.ue5;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public d c;
    public d d;
    public d e;
    public d f;
    public i08 g;
    public AgreeData h;
    public cs8 i;
    public bs4 j;
    public CustomMessageListener k;
    public CustomMessageListener l;
    public View.OnClickListener m;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, animator) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAgreeAndShareLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ThreadAgreeAndShareLayout threadAgreeAndShareLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAgreeAndShareLayout, Integer.valueOf(i)};
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
            this.a = threadAgreeAndShareLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cs8)) {
                AgreeData agreeData = ((cs8) customResponsedMessage.getData()).b;
                if (this.a.h != null && agreeData != null && this.a.i != null && !this.a.h.isInPost && this.a.i.a != this.a.i.a) {
                    String str = agreeData.nid;
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        if (this.a.g == null || this.a.g.Q() == null || this.a.g.Q().getBaijiahaoData() == null || !TextUtils.equals(str, this.a.g.Q().getBaijiahaoData().oriUgcNid)) {
                            return;
                        }
                        this.a.o(agreeData);
                        return;
                    }
                    String str2 = agreeData.threadId;
                    String str3 = this.a.h.threadId;
                    if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                        return;
                    }
                    this.a.o(agreeData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAgreeAndShareLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ThreadAgreeAndShareLayout threadAgreeAndShareLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAgreeAndShareLayout, Integer.valueOf(i)};
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
            this.a = threadAgreeAndShareLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cs8)) {
                cs8 cs8Var = (cs8) customResponsedMessage.getData();
                AgreeData agreeData = cs8Var.b;
                if (this.a.h == null || TextUtils.isEmpty(this.a.h.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.h.postId.equals(agreeData.postId) || this.a.h.isInThread || this.a.i.a == cs8Var.a) {
                    return;
                }
                this.a.o(agreeData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAgreeAndShareLayout a;

        public c(ThreadAgreeAndShareLayout threadAgreeAndShareLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAgreeAndShareLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadAgreeAndShareLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.k(view2);
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public TextView c;
        public TBLottieAnimationView d;

        public d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d08ad, null);
            this.a = inflate;
            this.b = inflate.findViewById(R.id.obfuscated_res_0x7f09101e);
            this.c = (TextView) inflate.findViewById(R.id.item_text);
            this.d = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public void c(Animator.AnimatorListener animatorListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
                this.d.addAnimatorListener(animatorListener);
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                SkinManager.setImageResource(this.d, i);
            }
        }

        public void j(ImageView.ScaleType scaleType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, scaleType) == null) {
                this.d.setScaleType(scaleType);
            }
        }

        public void k(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.c.setText(i);
            }
        }

        public void l(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                SkinManager.setViewTextColor(this.c, i, 1);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TBSelector.makeDrawableSelector().cornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).defaultStrokeColor(R.color.cp_cont_f_alpha50).defaultColor(R.color.CAM_X0201).into(this.b);
            }
        }

        public TBLottieAnimationView e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d;
            }
            return (TBLottieAnimationView) invokeV.objValue;
        }

        public TextView f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c;
            }
            return (TextView) invokeV.objValue;
        }

        public View g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a;
            }
            return (View) invokeV.objValue;
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.d.playAnimation();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThreadAgreeAndShareLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new a(this, 2016528);
        this.l = new b(this, 2016530);
        this.m = new c(this);
        setOrientation(0);
        setGravity(17);
        this.b = context;
        cs8 cs8Var = new cs8();
        this.i = cs8Var;
        cs8Var.a = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        i();
        this.j = new bs4();
    }

    public final d f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            d dVar = new d(this.b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams.leftMargin = i;
            addView(dVar.g(), layoutParams);
            return dVar;
        }
        return (d) invokeI.objValue;
    }

    public final void o(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, agreeData) == null) && agreeData != null && (agreeData2 = this.h) != null) {
            agreeData2.agreeType = agreeData.agreeType;
            agreeData2.hasAgree = agreeData.hasAgree;
            agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
            agreeData2.agreeNum = agreeData.agreeNum;
            agreeData2.disAgreeNum = agreeData.disAgreeNum;
            m();
        }
    }

    public void setStatisticData(bs4 bs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bs4Var) == null) {
            this.j = bs4Var;
        }
    }

    public final void g(AgreeData agreeData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, agreeData, str) == null) {
            AgreeEvent agreeEvent = new AgreeEvent();
            agreeEvent.agreeData = agreeData;
            agreeEvent.agreeExtra = str;
            mc5.i(agreeEvent);
        }
    }

    public void setData(i08 i08Var, AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, i08Var, agreeData) == null) {
            if (agreeData == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.g = i08Var;
            this.h = agreeData;
            agreeData.isInThread = true;
            m();
        }
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbPageContext tbPageContext = getTbPageContext();
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.k);
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.a = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.a = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.a;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.l(R.color.CAM_X0107);
            this.f.l(R.color.CAM_X0107);
            this.e.i(R.drawable.icon_weixin_112);
            this.f.i(R.drawable.icon_pengyouqun_112);
            this.c.d();
            this.d.d();
            this.e.d();
            this.f.d();
            m();
        }
    }

    public void h() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.j == null) {
            return;
        }
        int i2 = 0;
        i08 i08Var = this.g;
        String str6 = null;
        if (i08Var != null && i08Var.Q() != null) {
            ThreadData Q = this.g.Q();
            if (Q.isBJHArticleThreadType()) {
                i = 2;
            } else if (Q.isBJHVideoThreadType()) {
                i = 3;
            } else if (Q.isBJHNormalThreadType()) {
                i = 4;
            } else if (Q.isBJHVideoDynamicThreadType()) {
                i = 5;
            } else {
                i = 1;
            }
            String nid = Q.getNid();
            if (Q.getBaijiahaoData() != null && !xi.isEmpty(Q.getBaijiahaoData().oriUgcVid)) {
                str6 = Q.getBaijiahaoData().oriUgcVid;
            }
            int recomCardType = Q.getRecomCardType();
            str3 = Q.mRecomSource;
            str4 = Q.mRecomAbTag;
            str5 = Q.mRecomWeight;
            str = Q.mRecomExtra;
            i2 = recomCardType;
            str2 = str6;
            str6 = nid;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            i = 1;
        }
        int i3 = this.j.a;
        String str7 = str2;
        String str8 = str;
        String str9 = str5;
        if (i3 == 1) {
            StatisticItem param = new StatisticItem("c12003").param("obj_locate", this.j.b).param("obj_param1", this.j.c).param("obj_source", this.j.d).param("obj_id", this.j.e).param("obj_name", i).param("nid", str6).param("card_type", i2).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
            if (getTbPageContext() != null) {
                ue5.e(getTbPageContext().getPageActivity(), param);
            }
            pe5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                param.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                param.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(param);
        } else if (i3 == 2) {
            StatisticItem param2 = new StatisticItem("c13271").param("obj_type", this.j.g).param("obj_locate", this.j.h).param("obj_id", this.j.i).param("obj_name", i).param("nid", str6).param("card_type", i2).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
            if (getTbPageContext() != null) {
                ue5.e(getTbPageContext().getPageActivity(), param2);
            }
            TiebaStatic.log(param2);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            this.c = f(0);
            this.d = f(dimenPixelSize);
            this.e = f(dimenPixelSize);
            this.f = f(dimenPixelSize);
            this.e.j(ImageView.ScaleType.FIT_XY);
            this.f.j(ImageView.ScaleType.FIT_XY);
            this.e.k(R.string.share_weixin_friend);
            this.f.k(R.string.share_weixin_timeline);
            this.c.j(ImageView.ScaleType.CENTER_INSIDE);
            this.c.c(this);
            this.d.j(ImageView.ScaleType.CENTER_INSIDE);
            this.d.c(this);
            this.c.e().setOnClickListener(this.m);
            this.d.e().setOnClickListener(this.m);
            this.e.e().setOnClickListener(this.m);
            this.f.e().setOnClickListener(this.m);
            j();
        }
    }

    public final void k(View view2) {
        i08 i08Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || this.h == null || !ViewHelper.checkUpIsLogin(getContext())) {
            return;
        }
        if (view2 != this.c.e() && view2 != this.d.e()) {
            if (view2 == this.e.e()) {
                i08 i08Var2 = this.g;
                if (i08Var2 != null) {
                    i68.n(this.b, i08Var2.Q(), 3);
                    return;
                }
                return;
            } else if (view2 == this.f.e() && (i08Var = this.g) != null) {
                i68.n(this.b, i08Var.Q(), 2);
                return;
            } else {
                return;
            }
        }
        int i = 0;
        if (view2 == this.c.e()) {
            this.c.h();
            bs4 bs4Var = this.j;
            if (bs4Var != null) {
                bs4Var.a = 1;
                bs4Var.b = 4;
            }
            AgreeData agreeData = this.h;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = false;
                    agreeData.diffAgreeNum--;
                    agreeData.agreeNum--;
                    m();
                    bs4 bs4Var2 = this.j;
                    if (bs4Var2 != null) {
                        bs4Var2.e = 1;
                    }
                    i = 1;
                } else {
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = true;
                    agreeData.diffAgreeNum += 2;
                    agreeData.agreeNum++;
                    agreeData.disAgreeNum--;
                    n(true);
                    bs4 bs4Var3 = this.j;
                    if (bs4Var3 != null) {
                        bs4Var3.e = 0;
                    }
                }
            } else {
                agreeData.agreeType = 2;
                agreeData.hasAgree = true;
                agreeData.diffAgreeNum++;
                agreeData.agreeNum++;
                n(true);
            }
            l(i);
        } else if (view2 == this.d.e()) {
            this.d.h();
            bs4 bs4Var4 = this.j;
            if (bs4Var4 != null) {
                bs4Var4.a = 2;
                bs4Var4.b = 4;
            }
            AgreeData agreeData2 = this.h;
            if (agreeData2.hasAgree) {
                if (agreeData2.agreeType == 5) {
                    agreeData2.agreeType = 5;
                    agreeData2.hasAgree = false;
                    agreeData2.diffAgreeNum++;
                    agreeData2.disAgreeNum--;
                    m();
                    bs4 bs4Var5 = this.j;
                    if (bs4Var5 != null) {
                        bs4Var5.i = 0;
                    }
                    i = 1;
                } else {
                    agreeData2.agreeType = 5;
                    agreeData2.hasAgree = true;
                    agreeData2.diffAgreeNum -= 2;
                    agreeData2.agreeNum--;
                    agreeData2.disAgreeNum++;
                    n(false);
                    bs4 bs4Var6 = this.j;
                    if (bs4Var6 != null) {
                        bs4Var6.i = 1;
                    }
                }
            } else {
                agreeData2.agreeType = 5;
                agreeData2.hasAgree = true;
                agreeData2.diffAgreeNum--;
                agreeData2.disAgreeNum++;
                n(false);
                bs4 bs4Var7 = this.j;
                if (bs4Var7 != null) {
                    bs4Var7.i = 1;
                }
            }
            l(i);
        }
        cs8 cs8Var = this.i;
        AgreeData agreeData3 = this.h;
        cs8Var.b = agreeData3;
        if (agreeData3.isInThread) {
            i08 i08Var3 = this.g;
            if (i08Var3 != null && i08Var3.Q() != null && this.g.Q().getBaijiahaoData() != null) {
                this.h.nid = this.g.Q().getBaijiahaoData().oriUgcNid;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.i));
            g(this.h, AgreeEvent.IS_THREAD);
        } else if (agreeData3.isInPost) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.i));
            g(this.h, AgreeEvent.IS_POST);
        }
        setStatisticData(this.j);
        h();
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || this.h == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage.addParam("thread_id", this.h.threadId);
        httpMessage.addParam("op_type", i);
        AgreeData agreeData = this.h;
        if (agreeData.objType == 0) {
            agreeData.objType = 3;
        }
        httpMessage.addParam("obj_type", this.h.objType);
        httpMessage.addParam("agree_type", this.h.agreeType);
        httpMessage.addParam("forum_id", this.h.forumId);
        pe5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
        if (findPageExtraByView != null) {
            httpMessage.addParam("obj_source", findPageExtraByView.a());
        }
        if (!TextUtils.isEmpty(this.h.postId)) {
            httpMessage.addParam("post_id", this.h.postId);
        }
        i08 i08Var = this.g;
        if (i08Var != null && i08Var.Q() != null && this.g.Q().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = this.g.Q().getBaijiahaoData();
            httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
            httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
            httpMessage.addParam("ori_ugc_vid", baijiahaoData.oriUgcVid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, baijiahaoData.oriUgcType);
        }
        httpMessage.setTag(getPageId());
        httpMessage.setExtra(Integer.valueOf(i));
        httpMessage.addHeader("needSig", "1");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void m() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.h == null) {
            return;
        }
        TBLottieAnimationView e = this.c.e();
        SkinManager.setLottieAnimation(e, R.raw.lottie_agree);
        TBLottieAnimationView e2 = this.d.e();
        SkinManager.setLottieAnimation(e2, R.raw.lottie_disagree);
        TextView f = this.c.f();
        TextView f2 = this.d.f();
        f.setText(StringHelper.numFormatOverWanNa(this.h.agreeNum));
        f2.setText(StringHelper.numFormatOverWanNa(this.h.disAgreeNum));
        AgreeData agreeData = this.h;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                e2.setProgress(0.0f);
                e.setProgress(1.0f);
                f.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                f2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else {
                e.setProgress(0.0f);
                e2.setProgress(1.0f);
                f.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                f2.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        } else {
            e.setMinAndMaxProgress(0.0f, 0.0f);
            e2.setMinAndMaxProgress(0.0f, 0.0f);
            e.setProgress(0.0f);
            e2.setProgress(0.0f);
            f.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            f2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1) {
            e.setAlpha(0.5f);
            e2.setAlpha(0.5f);
        } else if (skinType == 4) {
            e.setAlpha(0.66f);
            e2.setAlpha(0.66f);
        } else {
            e.setAlpha(1.0f);
            e2.setAlpha(1.0f);
        }
        i08 i08Var = this.g;
        if (i08Var != null && i08Var.Q() != null) {
            if (this.g.Q().isUgcThreadType()) {
                i = 8;
            } else {
                i = 0;
            }
            setVisibility(i);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.h != null) {
            TBLottieAnimationView tBLottieAnimationView = this.c.d;
            TBLottieAnimationView tBLottieAnimationView2 = this.d.d;
            TextView textView = this.c.c;
            TextView textView2 = this.d.c;
            tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
            tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
            textView.setText(StringHelper.numFormatOverWanNa(this.h.agreeNum));
            textView2.setText(StringHelper.numFormatOverWanNa(this.h.disAgreeNum));
            tBLottieAnimationView.clearColorFilter();
            tBLottieAnimationView2.clearColorFilter();
            if (z) {
                tBLottieAnimationView.playAnimation();
                tBLottieAnimationView2.cancelAnimation();
                tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 0.0f);
            } else {
                tBLottieAnimationView2.playAnimation();
                tBLottieAnimationView.cancelAnimation();
                tBLottieAnimationView.setMinAndMaxProgress(0.0f, 0.0f);
            }
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView2.setFrame(0);
            AgreeData agreeData = this.h;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                    return;
                }
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
                return;
            }
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        }
    }
}
