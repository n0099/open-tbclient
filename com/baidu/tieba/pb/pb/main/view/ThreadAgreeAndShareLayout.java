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
import c.a.e.e.p.k;
import c.a.p0.h0.h;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.f;
import c.a.q0.i2.h.e;
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
/* loaded from: classes7.dex */
public class ThreadAgreeAndShareLayout extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f55187e;

    /* renamed from: f  reason: collision with root package name */
    public Context f55188f;

    /* renamed from: g  reason: collision with root package name */
    public d f55189g;

    /* renamed from: h  reason: collision with root package name */
    public d f55190h;

    /* renamed from: i  reason: collision with root package name */
    public d f55191i;

    /* renamed from: j  reason: collision with root package name */
    public d f55192j;
    public e k;
    public AgreeData l;
    public c.a.q0.i3.i0.e m;
    public f n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public View.OnClickListener q;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadAgreeAndShareLayout f55193a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ThreadAgreeAndShareLayout threadAgreeAndShareLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAgreeAndShareLayout, Integer.valueOf(i2)};
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
            this.f55193a = threadAgreeAndShareLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.i3.i0.e)) {
                AgreeData agreeData = ((c.a.q0.i3.i0.e) customResponsedMessage.getData()).f20277b;
                if (this.f55193a.l == null || agreeData == null || this.f55193a.m == null || this.f55193a.l.isInPost || this.f55193a.m.f20276a == this.f55193a.m.f20276a) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (this.f55193a.k == null || this.f55193a.k.O() == null || this.f55193a.k.O().L() == null || !TextUtils.equals(str, this.f55193a.k.O().L().oriUgcNid)) {
                        return;
                    }
                    this.f55193a.j(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f55193a.l.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f55193a.j(agreeData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadAgreeAndShareLayout f55194a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ThreadAgreeAndShareLayout threadAgreeAndShareLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAgreeAndShareLayout, Integer.valueOf(i2)};
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
            this.f55194a = threadAgreeAndShareLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.q0.i3.i0.e)) {
                c.a.q0.i3.i0.e eVar = (c.a.q0.i3.i0.e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f20277b;
                if (this.f55194a.l == null || TextUtils.isEmpty(this.f55194a.l.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.f55194a.l.postId.equals(agreeData.postId) || this.f55194a.l.isInThread || this.f55194a.m.f20276a == eVar.f20276a) {
                    return;
                }
                this.f55194a.j(agreeData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAgreeAndShareLayout f55195e;

        public c(ThreadAgreeAndShareLayout threadAgreeAndShareLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAgreeAndShareLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55195e = threadAgreeAndShareLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55195e.i(view);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f55196a;

        /* renamed from: b  reason: collision with root package name */
        public View f55197b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f55198c;

        /* renamed from: d  reason: collision with root package name */
        public TBLottieAnimationView f55199d;

        public d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            View inflate = View.inflate(context, R.layout.thread_agree_and_share_item_view, null);
            this.f55196a = inflate;
            this.f55197b = inflate.findViewById(R.id.item_bg);
            this.f55198c = (TextView) inflate.findViewById(R.id.item_text);
            this.f55199d = (TBLottieAnimationView) inflate.findViewById(R.id.item_icon);
        }

        public void c(Animator.AnimatorListener animatorListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
                this.f55199d.addAnimatorListener(animatorListener);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TBSelector.makeDrawableSelector().cornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds47)).strokeWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).defaultStrokeColor(R.color.cp_cont_f_alpha50).defaultColor(R.color.CAM_X0201).into(this.f55197b);
            }
        }

        public TBLottieAnimationView e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55199d : (TBLottieAnimationView) invokeV.objValue;
        }

        public TextView f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55198c : (TextView) invokeV.objValue;
        }

        public View g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55196a : (View) invokeV.objValue;
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f55199d.playAnimation();
            }
        }

        public void i(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                SkinManager.setImageResource(this.f55199d, i2);
            }
        }

        public void j(ImageView.ScaleType scaleType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, scaleType) == null) {
                this.f55199d.setScaleType(scaleType);
            }
        }

        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f55198c.setText(i2);
            }
        }

        public void l(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                SkinManager.setViewTextColor(this.f55198c, i2, 1);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void doStatistic() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.n == null) {
            return;
        }
        int i3 = 0;
        e eVar = this.k;
        String str6 = null;
        if (eVar == null || eVar.O() == null) {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            i2 = 1;
        } else {
            c2 O = this.k.O();
            if (O.J1()) {
                i2 = 2;
            } else if (O.M1()) {
                i2 = 3;
            } else if (O.K1()) {
                i2 = 4;
            } else {
                i2 = O.L1() ? 5 : 1;
            }
            String D0 = O.D0();
            if (O.L() != null && !k.isEmpty(O.L().oriUgcVid)) {
                str6 = O.L().oriUgcVid;
            }
            int O0 = O.O0();
            str3 = O.U0;
            str4 = O.W0;
            str5 = O.V0;
            str = O.X0;
            i3 = O0;
            str2 = str6;
            str6 = D0;
        }
        int i4 = this.n.f14218a;
        String str7 = str2;
        String str8 = str;
        String str9 = str5;
        if (i4 != 1) {
            if (i4 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.n.f14224g).param("obj_locate", this.n.f14225h).param("obj_id", this.n.f14226i).param("obj_name", i2).param("nid", str6).param("card_type", i3).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
                if (getTbPageContext() != null) {
                    c.a.p0.l0.c.e(getTbPageContext().getPageActivity(), param);
                }
                TiebaStatic.log(param);
                return;
            }
            return;
        }
        StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.n.f14219b).param("obj_param1", this.n.f14220c).param("obj_source", this.n.f14221d).param("obj_id", this.n.f14222e).param("obj_name", i2).param("nid", str6).param("card_type", i3).param("recom_source", str3).param("ab_tag", str4).param("weight", str9).param(TiebaStatic.Params.RECOM_EXTRA, str8).param(TiebaStatic.Params.OBJ_PARAM6, str7);
        if (getTbPageContext() != null) {
            c.a.p0.l0.c.e(getTbPageContext().getPageActivity(), param2);
        }
        c.a.p0.k0.c f2 = TbPageExtraHelper.f(this);
        if (f2 != null) {
            param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
        }
        if (TbPageExtraHelper.m() != null) {
            param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
        }
        TiebaStatic.log(param2);
    }

    public final d f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            d dVar = new d(this.f55188f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams.leftMargin = i2;
            addView(dVar.g(), layoutParams);
            return dVar;
        }
        return (d) invokeI.objValue;
    }

    public final void g(AgreeData agreeData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, agreeData, str) == null) {
            AgreeEvent agreeEvent = new AgreeEvent();
            agreeEvent.agreeData = agreeData;
            agreeEvent.agreeExtra = str;
            h.i(agreeEvent);
        }
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f55187e == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.f55187e = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.f55187e = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.f55187e;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds24);
            this.f55189g = f(0);
            this.f55190h = f(dimenPixelSize);
            this.f55191i = f(dimenPixelSize);
            this.f55192j = f(dimenPixelSize);
            this.f55191i.j(ImageView.ScaleType.FIT_XY);
            this.f55192j.j(ImageView.ScaleType.FIT_XY);
            this.f55191i.k(R.string.share_weixin_friend);
            this.f55192j.k(R.string.share_weixin_timeline);
            this.f55189g.j(ImageView.ScaleType.CENTER_INSIDE);
            this.f55189g.c(this);
            this.f55190h.j(ImageView.ScaleType.CENTER_INSIDE);
            this.f55190h.c(this);
            this.f55189g.e().setOnClickListener(this.q);
            this.f55190h.e().setOnClickListener(this.q);
            this.f55191i.e().setOnClickListener(this.q);
            this.f55192j.e().setOnClickListener(this.q);
            onChangeSkin();
        }
    }

    public final void i(View view) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && this.l != null && ViewHelper.checkUpIsLogin(getContext())) {
            if (view != this.f55189g.e() && view != this.f55190h.e()) {
                if (view == this.f55191i.e()) {
                    e eVar2 = this.k;
                    if (eVar2 != null) {
                        c.a.q0.i2.k.e.d1.b.n(this.f55188f, eVar2.O(), 3);
                        return;
                    }
                    return;
                } else if (view != this.f55192j.e() || (eVar = this.k) == null) {
                    return;
                } else {
                    c.a.q0.i2.k.e.d1.b.n(this.f55188f, eVar.O(), 2);
                    return;
                }
            }
            int i2 = 0;
            if (view == this.f55189g.e()) {
                this.f55189g.h();
                f fVar = this.n;
                if (fVar != null) {
                    fVar.f14218a = 1;
                    fVar.f14219b = 4;
                }
                AgreeData agreeData = this.l;
                if (agreeData.hasAgree) {
                    if (agreeData.agreeType == 2) {
                        agreeData.agreeType = 2;
                        agreeData.hasAgree = false;
                        agreeData.diffAgreeNum--;
                        agreeData.agreeNum--;
                        updateAgreeUI();
                        f fVar2 = this.n;
                        if (fVar2 != null) {
                            fVar2.f14222e = 1;
                        }
                        i2 = 1;
                    } else {
                        agreeData.agreeType = 2;
                        agreeData.hasAgree = true;
                        agreeData.diffAgreeNum += 2;
                        agreeData.agreeNum++;
                        agreeData.disAgreeNum--;
                        updateAgreeUiWithAnimation(true);
                        f fVar3 = this.n;
                        if (fVar3 != null) {
                            fVar3.f14222e = 0;
                        }
                    }
                } else {
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = true;
                    agreeData.diffAgreeNum++;
                    agreeData.agreeNum++;
                    updateAgreeUiWithAnimation(true);
                }
                sendMesage(i2);
            } else if (view == this.f55190h.e()) {
                this.f55190h.h();
                f fVar4 = this.n;
                if (fVar4 != null) {
                    fVar4.f14218a = 2;
                    fVar4.f14219b = 4;
                }
                AgreeData agreeData2 = this.l;
                if (agreeData2.hasAgree) {
                    if (agreeData2.agreeType == 5) {
                        agreeData2.agreeType = 5;
                        agreeData2.hasAgree = false;
                        agreeData2.diffAgreeNum++;
                        agreeData2.disAgreeNum--;
                        updateAgreeUI();
                        f fVar5 = this.n;
                        if (fVar5 != null) {
                            fVar5.f14226i = 0;
                        }
                        i2 = 1;
                    } else {
                        agreeData2.agreeType = 5;
                        agreeData2.hasAgree = true;
                        agreeData2.diffAgreeNum -= 2;
                        agreeData2.agreeNum--;
                        agreeData2.disAgreeNum++;
                        updateAgreeUiWithAnimation(false);
                        f fVar6 = this.n;
                        if (fVar6 != null) {
                            fVar6.f14226i = 1;
                        }
                    }
                } else {
                    agreeData2.agreeType = 5;
                    agreeData2.hasAgree = true;
                    agreeData2.diffAgreeNum--;
                    agreeData2.disAgreeNum++;
                    updateAgreeUiWithAnimation(false);
                    f fVar7 = this.n;
                    if (fVar7 != null) {
                        fVar7.f14226i = 1;
                    }
                }
                sendMesage(i2);
            }
            c.a.q0.i3.i0.e eVar3 = this.m;
            AgreeData agreeData3 = this.l;
            eVar3.f20277b = agreeData3;
            if (agreeData3.isInThread) {
                e eVar4 = this.k;
                if (eVar4 != null && eVar4.O() != null && this.k.O().L() != null) {
                    this.l.nid = this.k.O().L().oriUgcNid;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.m));
                g(this.l, AgreeEvent.IS_THREAD);
            } else if (agreeData3.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.m));
                g(this.l, AgreeEvent.IS_POST);
            }
            setStatisticData(this.n);
            doStatistic();
        }
    }

    public final void j(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, agreeData) == null) || agreeData == null || (agreeData2 = this.l) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
        agreeData2.agreeNum = agreeData.agreeNum;
        agreeData2.disAgreeNum = agreeData.disAgreeNum;
        updateAgreeUI();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    public void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f55191i.l(R.color.CAM_X0107);
            this.f55192j.l(R.color.CAM_X0107);
            this.f55191i.i(R.drawable.icon_weixin_112);
            this.f55192j.i(R.drawable.icon_pengyouqun_112);
            this.f55189g.d();
            this.f55190h.d();
            this.f55191i.d();
            this.f55192j.d();
            updateAgreeUI();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public void sendMesage(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.l == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
        httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
        httpMessage.addParam("thread_id", this.l.threadId);
        httpMessage.addParam("op_type", i2);
        AgreeData agreeData = this.l;
        if (agreeData.objType == 0) {
            agreeData.objType = 3;
        }
        httpMessage.addParam("obj_type", this.l.objType);
        httpMessage.addParam("agree_type", this.l.agreeType);
        httpMessage.addParam("forum_id", this.l.forumId);
        c.a.p0.k0.c f2 = TbPageExtraHelper.f(this);
        if (f2 != null) {
            httpMessage.addParam("obj_source", f2.a());
        }
        if (!TextUtils.isEmpty(this.l.postId)) {
            httpMessage.addParam("post_id", this.l.postId);
        }
        e eVar = this.k;
        if (eVar != null && eVar.O() != null && this.k.O().L() != null) {
            BaijiahaoData L = this.k.O().L();
            httpMessage.addParam("ori_ugc_tid", L.oriUgcTid);
            httpMessage.addParam("ori_ugc_nid", L.oriUgcNid);
            httpMessage.addParam("ori_ugc_vid", L.oriUgcVid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, L.oriUgcType);
        }
        httpMessage.setTag(getPageId());
        httpMessage.setExtra(Integer.valueOf(i2));
        httpMessage.addHeader("needSig", "1");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void setData(e eVar, AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, agreeData) == null) {
            if (agreeData == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.k = eVar;
            this.l = agreeData;
            agreeData.isInThread = true;
            updateAgreeUI();
        }
    }

    public void setStatisticData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void updateAgreeUI() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.l == null) {
            return;
        }
        TBLottieAnimationView e2 = this.f55189g.e();
        SkinManager.setLottieAnimation(e2, R.raw.lottie_agree);
        TBLottieAnimationView e3 = this.f55190h.e();
        SkinManager.setLottieAnimation(e3, R.raw.lottie_disagree);
        TextView f2 = this.f55189g.f();
        TextView f3 = this.f55190h.f();
        f2.setText(StringHelper.numFormatOverWanNa(this.l.agreeNum));
        f3.setText(StringHelper.numFormatOverWanNa(this.l.disAgreeNum));
        AgreeData agreeData = this.l;
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
        e eVar = this.k;
        if (eVar == null || eVar.O() == null) {
            return;
        }
        setVisibility(this.k.O().z2() ? 8 : 0);
    }

    public void updateAgreeUiWithAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.l == null) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.f55189g.f55199d;
        TBLottieAnimationView tBLottieAnimationView2 = this.f55190h.f55199d;
        TextView textView = this.f55189g.f55198c;
        TextView textView2 = this.f55190h.f55198c;
        tBLottieAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
        tBLottieAnimationView2.setMinAndMaxProgress(0.0f, 1.0f);
        textView.setText(StringHelper.numFormatOverWanNa(this.l.agreeNum));
        textView2.setText(StringHelper.numFormatOverWanNa(this.l.disAgreeNum));
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
        AgreeData agreeData = this.l;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadAgreeAndShareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = new a(this, 2016528);
        this.p = new b(this, 2016530);
        this.q = new c(this);
        setOrientation(0);
        setGravity(17);
        this.f55188f = context;
        c.a.q0.i3.i0.e eVar = new c.a.q0.i3.i0.e();
        this.m = eVar;
        eVar.f20276a = getPageId();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds43);
        setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        h();
        this.n = new f();
    }
}
