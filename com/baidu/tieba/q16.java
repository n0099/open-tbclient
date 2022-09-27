package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AppPosInfo;
/* loaded from: classes5.dex */
public class q16 extends h16<w26> implements so5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public TBLottieAnimationView B;
    public TextView C;
    public TextView D;
    public LinearLayout E;
    public View F;
    public boolean G;
    public int H;
    public View.OnClickListener I;
    public CustomMessageListener J;
    public FrameLayout v;
    public LinearLayout w;
    public CardUserInfoLayout x;
    public TextView y;
    public RelativeLayout z;

    /* loaded from: classes5.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q16 a;

        public a(q16 q16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q16Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.B.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.B.cancelAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q16 a;

        public b(q16 q16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e() == null) {
                return;
            }
            this.a.e().a(view2, this.a.k);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q16 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(q16 q16Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q16Var, Integer.valueOf(i)};
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
            this.a = q16Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = this.a.k) == 0 || ((w26) t).a == null || ((w26) t).a.getTid() == null || this.a.y == null || !((String) customResponsedMessage.getData()).equals(((w26) this.a.k).a.getTid())) {
                return;
            }
            q16 q16Var = this.a;
            t16.l(q16Var.y, ((w26) q16Var.k).a.getId(), R.color.CAM_X0109, R.color.CAM_X0109);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q16(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = false;
        this.H = 0;
        this.I = new b(this);
        this.J = new c(this, 2001390);
        this.i = tbPageContext;
        this.j = bdUniqueId;
        O(h());
    }

    public View L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CardUserInfoLayout cardUserInfoLayout = this.x;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getAvatar();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.G) {
                CardUserInfoLayout cardUserInfoLayout = this.x;
                if (cardUserInfoLayout != null) {
                    return cardUserInfoLayout.getUserName();
                }
                return null;
            }
            return this.y;
        }
        return (View) invokeV.objValue;
    }

    public void N() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (hq4.c().g() && (t = this.k) != 0 && ((w26) t).getThreadData() != null && ((w26) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.A.setPlaceHolder(3);
                this.A.K(((w26) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.z.setVisibility(0);
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public final void O(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.v = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0912a7);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906ed);
            this.w = linearLayout;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            layoutParams.bottomMargin = 0;
            CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f090539);
            this.x = cardUserInfoLayout;
            cardUserInfoLayout.setPageContext(this.i);
            this.x.setPageUniqueId(this.j);
            this.y = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092136);
            this.z = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ad4);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090eae);
            this.A = tbImageView;
            tbImageView.setDrawCorner(true);
            this.A.setPlaceHolder(3);
            this.A.setDefaultResource(0);
            this.A.setRadiusById(R.string.J_X05);
            this.A.setConrers(15);
            this.A.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.A.setBorderSurroundContent(true);
            this.A.setDrawBorder(true);
            this.E = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901ed);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901ec);
            this.B = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            SkinManager.setLottieAnimation(this.B, R.raw.ala_live2);
            this.B.addOnAttachStateChangeListener(new a(this));
            this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919ed);
            this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901f6);
            this.F = view2.findViewById(R.id.obfuscated_res_0x7f0919ee);
            this.q = (ForumEnterLayout) view2.findViewById(R.id.obfuscated_res_0x7f090506);
            this.l = (ThreadCommentAndPraiseInfoLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904d5);
            this.m = (ThreadCardBottomOpSegmentWeightLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904d6);
            this.l.setUseDynamicLikeRes();
            this.l.setNeedMatchStrategy(false);
            this.m.setUseDynamicLikeRes();
            this.m.setNeedMatchStrategy(false);
            t(this.l);
            t(this.m);
            this.w.setOnClickListener(this);
            HomeGroupUbsUIHelper.handleImgMask(view2.findViewById(R.id.obfuscated_res_0x7f090e95), R.color.transparent);
        }
    }

    public final void P(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.b;
            urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1&from" + str});
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i16
    /* renamed from: Q */
    public void i(w26 w26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, w26Var) == null) {
            this.k = w26Var;
            R();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            T t = this.k;
            if (t != 0 && ((w26) t).getThreadData() != null) {
                this.v.setVisibility(0);
                int k = ej.k(this.i.getPageActivity());
                if (k != this.H) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                    int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    layoutParams.width = dimenPixelSize;
                    layoutParams.height = (dimenPixelSize * 9) / 16;
                    this.z.setLayoutParams(layoutParams);
                    this.H = k;
                }
                this.l.setShowFlag(11);
                this.l.resetShareContainer();
                this.x.setVisibility(0);
                this.x.setData(((w26) this.k).getThreadData());
                this.x.setUserAfterClickListener(this.I);
                if (((w26) this.k).getThreadData().getThreadAlaInfo() != null) {
                    this.y.setText(((w26) this.k).getThreadData().getThreadAlaInfo().friendRoomName);
                }
                if (((w26) this.k).a.getThreadAlaInfo().audience_count > 0) {
                    this.F.setVisibility(0);
                    this.C.setVisibility(0);
                    this.C.setText(String.format(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f0202), StringHelper.numFormatOverWan(((w26) this.k).a.getThreadAlaInfo().audience_count)));
                } else {
                    this.F.setVisibility(8);
                    this.C.setVisibility(8);
                }
                this.D.setVisibility(8);
                if (((w26) this.k).a.getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((w26) this.k).a.getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.D.setVisibility(0);
                        this.D.setText(str);
                    } else {
                        String latitude = ((w26) this.k).a.getLatitude();
                        String longtitude = ((w26) this.k).a.getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo c2 = kf8.e().c();
                            String str2 = c2.latitude;
                            String str3 = c2.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && ej.g(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.D.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0248));
                                this.D.setVisibility(0);
                            }
                        }
                    }
                }
                D(this.v);
                j(this.i, TbadkCoreApplication.getInst().getSkinType());
                if (t16.k(((w26) this.k).a.getId())) {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0105, 1);
                }
                N();
                this.B.playAnimation();
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void S(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) || bdUniqueId == null || this.l == null || this.J == null) {
            return;
        }
        o(bdUniqueId);
        x(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.x;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.J.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.J);
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.G = z;
        }
    }

    public void U(int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (threadCommentAndPraiseInfoLayout = this.l) == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.R = String.valueOf(i);
    }

    @Override // com.baidu.tieba.so5
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.i16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.obfuscated_res_0x7f0d0194 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i16
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        w(tbPageContext, i);
        hv4 d = hv4.d(this.w);
        d.n(R.string.J_X06);
        d.i(R.color.CAM_X0205, R.color.CAM_X0206);
        hv4 d2 = hv4.d(this.z);
        d2.l(R.dimen.L_X01);
        d2.k(R.color.CAM_X0401);
        d2.n(R.string.J_X05);
        d2.f(R.color.CAM_X0611);
        float f = ej.f(getContext(), R.dimen.tbds31);
        SkinManager.setBackgroundEndColorToAutoColor(this.E, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{f, f, f, f, f, f, f, f});
        SkinManager.setBackgroundColor(this.F, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0101);
        this.x.onChangeSkinType(g(), TbadkCoreApplication.getInst().getSkinType());
        this.A.setPlaceHolder(3);
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            if (view2 == this.w || view2 == this.l.getCommentContainer() || view2 == this.m.getCommentContainer()) {
                P(((w26) this.k).getThreadData().getThreadAlaInfo().live_id, ((w26) this.k).getThreadData().getThreadAlaInfo().roomId, this.G ? AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB : AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY);
                t16.l(this.y, ((w26) this.k).a.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                if (((w26) this.k).getThreadData() == null || ((w26) this.k).getThreadData().getThreadAlaInfo() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                statisticItem.param("obj_locate", this.G ? 2 : 1);
                statisticItem.param("obj_param1", ((w26) this.k).getThreadData().getThreadAlaInfo().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
