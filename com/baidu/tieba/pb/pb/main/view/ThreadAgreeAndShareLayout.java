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
import c.a.d.f.p.m;
import c.a.o0.j0.h;
import c.a.p0.a4.k0.e;
import c.a.p0.w2.i.f;
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
import com.baidu.tieba.tbadkCore.data.AgreeData;
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

    /* renamed from: b  reason: collision with root package name */
    public Context f35081b;

    /* renamed from: c  reason: collision with root package name */
    public d f35082c;

    /* renamed from: d  reason: collision with root package name */
    public d f35083d;

    /* renamed from: e  reason: collision with root package name */
    public d f35084e;

    /* renamed from: f  reason: collision with root package name */
    public d f35085f;

    /* renamed from: g  reason: collision with root package name */
    public f f35086g;

    /* renamed from: h  reason: collision with root package name */
    public AgreeData f35087h;
    public e i;
    public c.a.o0.r.r.f j;
    public CustomMessageListener k;
    public CustomMessageListener l;
    public View.OnClickListener m;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                AgreeData agreeData = ((e) customResponsedMessage.getData()).f12234b;
                if (this.a.f35087h == null || agreeData == null || this.a.i == null || this.a.f35087h.isInPost || this.a.i.a == this.a.i.a) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (this.a.f35086g == null || this.a.f35086g.O() == null || this.a.f35086g.O().getBaijiahaoData() == null || !TextUtils.equals(str, this.a.f35086g.O().getBaijiahaoData().oriUgcNid)) {
                        return;
                    }
                    this.a.o(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.a.f35087h.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.a.o(agreeData);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f12234b;
                if (this.a.f35087h == null || TextUtils.isEmpty(this.a.f35087h.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.f35087h.postId.equals(agreeData.postId) || this.a.f35087h.isInThread || this.a.i.a == eVar.a) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.k(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f35088b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f35089c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f35090d;

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
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d082d, null);
            this.a = inflate;
            this.f35088b = inflate.findViewById(R.id.obfuscated_res_0x7f090f5e);
            this.f35089c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090fa9);
            this.f35090d = (TBLottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f090f7b);
        }

        public void c(Animator.AnimatorListener animatorListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
                this.f35090d.addAnimatorListener(animatorListener);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TBSelector.makeDrawableSelector().cornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).defaultStrokeColor(R.color.cp_cont_f_alpha50).defaultColor(R.color.CAM_X0201).into(this.f35088b);
            }
        }

        public TBLottieAnimationView e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35090d : (TBLottieAnimationView) invokeV.objValue;
        }

        public TextView f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35089c : (TextView) invokeV.objValue;
        }

        public View g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (View) invokeV.objValue;
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f35090d.playAnimation();
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                SkinManager.setImageResource(this.f35090d, i);
            }
        }

        public void j(ImageView.ScaleType scaleType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, scaleType) == null) {
                this.f35090d.setScaleType(scaleType);
            }
        }

        public void k(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.f35089c.setText(i);
            }
        }

        public void l(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                SkinManager.setViewTextColor(this.f35089c, i, 1);
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

    public final d f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            d dVar = new d(this.f35081b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams.leftMargin = i;
            addView(dVar.g(), layoutParams);
            return dVar;
        }
        return (d) invokeI.objValue;
    }

    public final void g(AgreeData agreeData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, agreeData, str) == null) {
            AgreeEvent agreeEvent = new AgreeEvent();
            agreeEvent.agreeData = agreeData;
            agreeEvent.agreeExtra = str;
            h.i(agreeEvent);
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

    public void h() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.j == null) {
            return;
        }
        int i2 = 0;
        f fVar = this.f35086g;
        String str6 = null;
        if (fVar == null || fVar.O() == null) {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            i = 1;
        } else {
            ThreadData O = this.f35086g.O();
            if (O.isBJHArticleThreadType()) {
                i = 2;
            } else if (O.isBJHVideoThreadType()) {
                i = 3;
            } else if (O.isBJHNormalThreadType()) {
                i = 4;
            } else {
                i = O.isBJHVideoDynamicThreadType() ? 5 : 1;
            }
            String nid = O.getNid();
            if (O.getBaijiahaoData() != null && !m.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                str6 = O.getBaijiahaoData().oriUgcVid;
            }
            int recomCardType = O.getRecomCardType();
            str3 = O.mRecomSource;
            str4 = O.mRecomAbTag;
            str5 = O.mRecomWeight;
            str = O.mRecomExtra;
            i2 = recomCardType;
            str2 = str6;
            str6 = nid;
        }
        int i3 = this.j.a;
        String str7 = str2;
        String str8 = str;
        String str9 = str5;
        if (i3 != 1) {
            if (i3 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.j.f10857g).param("obj_locate", this.j.f10858h).param("obj_id", this.j.i).param("obj_name", i).param("nid", str6).param("card_type", i2).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
                if (getTbPageContext() != null) {
                    c.a.o0.o0.c.e(getTbPageContext().getPageActivity(), param);
                }
                TiebaStatic.log(param);
                return;
            }
            return;
        }
        StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.j.f10852b).param("obj_param1", this.j.f10853c).param("obj_source", this.j.f10854d).param("obj_id", this.j.f10855e).param("obj_name", i).param("nid", str6).param("card_type", i2).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
        if (getTbPageContext() != null) {
            c.a.o0.o0.c.e(getTbPageContext().getPageActivity(), param2);
        }
        c.a.o0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
        if (findPageExtraByView != null) {
            param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
        }
        if (TbPageExtraHelper.getPrePageKey() != null) {
            param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
        }
        TiebaStatic.log(param2);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            this.f35082c = f(0);
            this.f35083d = f(dimenPixelSize);
            this.f35084e = f(dimenPixelSize);
            this.f35085f = f(dimenPixelSize);
            this.f35084e.j(ImageView.ScaleType.FIT_XY);
            this.f35085f.j(ImageView.ScaleType.FIT_XY);
            this.f35084e.k(R.string.obfuscated_res_0x7f0f114b);
            this.f35085f.k(R.string.obfuscated_res_0x7f0f114f);
            this.f35082c.j(ImageView.ScaleType.CENTER_INSIDE);
            this.f35082c.c(this);
            this.f35083d.j(ImageView.ScaleType.CENTER_INSIDE);
            this.f35083d.c(this);
            this.f35082c.e().setOnClickListener(this.m);
            this.f35083d.e().setOnClickListener(this.m);
            this.f35084e.e().setOnClickListener(this.m);
            this.f35085f.e().setOnClickListener(this.m);
            j();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f35084e.l(R.color.CAM_X0107);
            this.f35085f.l(R.color.CAM_X0107);
            this.f35084e.i(R.drawable.icon_weixin_112);
            this.f35085f.i(R.drawable.icon_pengyouqun_112);
            this.f35082c.d();
            this.f35083d.d();
            this.f35084e.d();
            this.f35085f.d();
            m();
        }
    }

    public final void k(View view) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view) == null) && this.f35087h != null && ViewHelper.checkUpIsLogin(getContext())) {
            if (view != this.f35082c.e() && view != this.f35083d.e()) {
                if (view == this.f35084e.e()) {
                    f fVar2 = this.f35086g;
                    if (fVar2 != null) {
                        c.a.p0.w2.m.f.n1.b.n(this.f35081b, fVar2.O(), 3);
                        return;
                    }
                    return;
                } else if (view != this.f35085f.e() || (fVar = this.f35086g) == null) {
                    return;
                } else {
                    c.a.p0.w2.m.f.n1.b.n(this.f35081b, fVar.O(), 2);
                    return;
                }
            }
            int i = 0;
            if (view == this.f35082c.e()) {
                this.f35082c.h();
                c.a.o0.r.r.f fVar3 = this.j;
                if (fVar3 != null) {
                    fVar3.a = 1;
                    fVar3.f10852b = 4;
                }
                AgreeData agreeData = this.f35087h;
                if (agreeData.hasAgree) {
                    if (agreeData.agreeType == 2) {
                        agreeData.agreeType = 2;
                        agreeData.hasAgree = false;
                        agreeData.diffAgreeNum--;
                        agreeData.agreeNum--;
                        m();
                        c.a.o0.r.r.f fVar4 = this.j;
                        if (fVar4 != null) {
                            fVar4.f10855e = 1;
                        }
                        i = 1;
                    } else {
                        agreeData.agreeType = 2;
                        agreeData.hasAgree = true;
                        agreeData.diffAgreeNum += 2;
                        agreeData.agreeNum++;
                        agreeData.disAgreeNum--;
                        n(true);
                        c.a.o0.r.r.f fVar5 = this.j;
                        if (fVar5 != null) {
                            fVar5.f10855e = 0;
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
            } else if (view == this.f35083d.e()) {
                this.f35083d.h();
                c.a.o0.r.r.f fVar6 = this.j;
                if (fVar6 != null) {
                    fVar6.a = 2;
                    fVar6.f10852b = 4;
                }
                AgreeData agreeData2 = this.f35087h;
                if (agreeData2.hasAgree) {
                    if (agreeData2.agreeType == 5) {
                        agreeData2.agreeType = 5;
                        agreeData2.hasAgree = false;
                        agreeData2.diffAgreeNum++;
                        agreeData2.disAgreeNum--;
                        m();
                        c.a.o0.r.r.f fVar7 = this.j;
                        if (fVar7 != null) {
                            fVar7.i = 0;
                        }
                        i = 1;
                    } else {
                        agreeData2.agreeType = 5;
                        agreeData2.hasAgree = true;
                        agreeData2.diffAgreeNum -= 2;
                        agreeData2.agreeNum--;
                        agreeData2.disAgreeNum++;
                        n(false);
                        c.a.o0.r.r.f fVar8 = this.j;
                        if (fVar8 != null) {
                            fVar8.i = 1;
                        }
                    }
                } else {
                    agreeData2.agreeType = 5;
                    agreeData2.hasAgree = true;
                    agreeData2.diffAgreeNum--;
                    agreeData2.disAgreeNum++;
                    n(false);
                    c.a.o0.r.r.f fVar9 = this.j;
                    if (fVar9 != null) {
                        fVar9.i = 1;
                    }
                }
                l(i);
            }
            e eVar = this.i;
            AgreeData agreeData3 = this.f35087h;
            eVar.f12234b = agreeData3;
            if (agreeData3.isInThread) {
                f fVar10 = this.f35086g;
                if (fVar10 != null && fVar10.O() != null && this.f35086g.O().getBaijiahaoData() != null) {
                    this.f35087h.nid = this.f35086g.O().getBaijiahaoData().oriUgcNid;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.i));
                g(this.f35087h, AgreeEvent.IS_THREAD);
            } else if (agreeData3.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.i));
                g(this.f35087h, AgreeEvent.IS_POST);
            }
            setStatisticData(this.j);
            h();
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.f35087h == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage.addParam("thread_id", this.f35087h.threadId);
        httpMessage.addParam("op_type", i);
        AgreeData agreeData = this.f35087h;
        if (agreeData.objType == 0) {
            agreeData.objType = 3;
        }
        httpMessage.addParam("obj_type", this.f35087h.objType);
        httpMessage.addParam("agree_type", this.f35087h.agreeType);
        httpMessage.addParam("forum_id", this.f35087h.forumId);
        c.a.o0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
        if (findPageExtraByView != null) {
            httpMessage.addParam("obj_source", findPageExtraByView.a());
        }
        if (!TextUtils.isEmpty(this.f35087h.postId)) {
            httpMessage.addParam("post_id", this.f35087h.postId);
        }
        f fVar = this.f35086g;
        if (fVar != null && fVar.O() != null && this.f35086g.O().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = this.f35086g.O().getBaijiahaoData();
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f35087h == null) {
            return;
        }
        TBLottieAnimationView e2 = this.f35082c.e();
        SkinManager.setLottieAnimation(e2, R.raw.lottie_agree);
        TBLottieAnimationView e3 = this.f35083d.e();
        SkinManager.setLottieAnimation(e3, R.raw.lottie_disagree);
        TextView f2 = this.f35082c.f();
        TextView f3 = this.f35083d.f();
        f2.setText(StringHelper.numFormatOverWanNa(this.f35087h.agreeNum));
        f3.setText(StringHelper.numFormatOverWanNa(this.f35087h.disAgreeNum));
        AgreeData agreeData = this.f35087h;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                e3.setProgress(0.0f);
                e2.setProgress(1.0f);
                f2.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                f3.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else {
                e2.setProgress(0.0f);
                e3.setProgress(1.0f);
                f2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                f3.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        } else {
            e2.setMinAndMaxProgress(0.0f, 0.0f);
            e3.setMinAndMaxProgress(0.0f, 0.0f);
            e2.setProgress(0.0f);
            e3.setProgress(0.0f);
            f2.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            f3.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1) {
            e2.setAlpha(0.5f);
            e3.setAlpha(0.5f);
        } else if (skinType == 4) {
            e2.setAlpha(0.66f);
            e3.setAlpha(0.66f);
        } else {
            e2.setAlpha(1.0f);
            e3.setAlpha(1.0f);
        }
        f fVar = this.f35086g;
        if (fVar == null || fVar.O() == null) {
            return;
        }
        setVisibility(this.f35086g.O().isUgcThreadType() ? 8 : 0);
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.f35087h == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.f35082c.f35090d;
        TBLottieAnimationView tBLottieAnimationView2 = this.f35083d.f35090d;
        TextView textView = this.f35082c.f35089c;
        TextView textView2 = this.f35083d.f35089c;
        tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
        tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
        textView.setText(StringHelper.numFormatOverWanNa(this.f35087h.agreeNum));
        textView2.setText(StringHelper.numFormatOverWanNa(this.f35087h.disAgreeNum));
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
        AgreeData agreeData = this.f35087h;
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

    public final void o(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, agreeData) == null) || agreeData == null || (agreeData2 = this.f35087h) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
        agreeData2.agreeNum = agreeData.agreeNum;
        agreeData2.disAgreeNum = agreeData.disAgreeNum;
        m();
    }

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

    public void setData(f fVar, AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, fVar, agreeData) == null) {
            if (agreeData == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f35086g = fVar;
            this.f35087h = agreeData;
            agreeData.isInThread = true;
            m();
        }
    }

    public void setStatisticData(c.a.o0.r.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            this.j = fVar;
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
        this.f35081b = context;
        e eVar = new e();
        this.i = eVar;
        eVar.a = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        i();
        this.j = new c.a.o0.r.r.f();
    }
}
