package com.baidu.tieba;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.personCenter.view.PersonHeadPendantView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.ThemeMyTab;
/* loaded from: classes7.dex */
public class lr9 extends cj6<sq9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public EMTextView B;
    public String C;
    public UserData D;
    public boolean E;
    public boolean F;
    public final TbPageContext<?> G;
    public int H;
    public int I;
    public CustomMessageListener J;
    public int i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public PersonHeadPendantView n;
    public TbImageView o;
    public EMTextView p;
    public TextView q;
    public RelativeLayout r;
    public CardView s;
    public RelativeLayout t;
    public TbImageView u;
    public TbImageView v;
    public VirtualImageStatusTip w;
    public View x;
    public TbImageView y;
    public View z;

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.obfuscated_res_0x7f0d07ce : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lr9 lr9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr9Var, Integer.valueOf(i)};
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
            this.a = lr9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921749) {
                if ((customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() > 0 && this.a.x != null) {
                    this.a.x.getLayoutParams().height = num.intValue() + BdUtilHelper.getDimens(this.a.c, R.dimen.tbds10);
                }
                MessageManager.getInstance().unRegisterStickyMode(2921749);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr9 a;

        public b(lr9 lr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.D.getNewGodData() != null && this.a.D.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new StatisticItem("c13690").param("uid", this.a.D.getUserId()).param("obj_locate", "1"));
                HashMap hashMap = new HashMap();
                hashMap.put("from", "6");
                hashMap.put("field_id", this.a.D.getNewGodData().getFieldId());
                hashMap.put("animated", Boolean.FALSE);
                hashMap.put("transparent", Boolean.TRUE);
                hashMap.put("swipeback", Boolean.FALSE);
                hashMap.put("present", Boolean.TRUE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.b.getPageActivity(), "GodInvitePage", hashMap)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements RequestListener<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr9 a;

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, target, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public c(lr9 lr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawable, obj, target, dataSource, Boolean.valueOf(z)})) == null) {
                drawable.getIntrinsicHeight();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                Matrix matrix = new Matrix();
                matrix.preScale(1.01f, 1.01f);
                matrix.postTranslate((-intrinsicWidth) / 30.0f, 0.0f);
                this.a.v.setImageMatrix(matrix);
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements RequestListener<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr9 a;

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, target, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public d(lr9 lr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawable, obj, target, dataSource, Boolean.valueOf(z)})) == null) {
                this.a.z();
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lr9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.i = 3;
        this.H = 0;
        this.I = 0;
        this.J = new a(this, 2921749);
        View i3 = i();
        this.G = tbPageContext;
        this.x = i3.findViewById(R.id.obfuscated_res_0x7f092956);
        PersonHeadPendantView personHeadPendantView = (PersonHeadPendantView) i3.findViewById(R.id.obfuscated_res_0x7f091c12);
        this.n = personHeadPendantView;
        personHeadPendantView.setHasPendantStyle();
        this.n.getHeadView().setIsRound(true);
        this.n.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.n.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.n.getHeadView().setPlaceHolder(2);
        this.o = (TbImageView) i3.findViewById(R.id.obfuscated_res_0x7f09173a);
        this.p = (EMTextView) i3.findViewById(R.id.obfuscated_res_0x7f091c54);
        this.q = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09199a);
        this.j = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090aff);
        this.k = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090b01);
        this.l = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f0907a5);
        this.m = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f0907a6);
        this.r = (RelativeLayout) i3.findViewById(R.id.obfuscated_res_0x7f091c2b);
        this.s = (CardView) i3.findViewById(R.id.obfuscated_res_0x7f091c2f);
        this.t = (RelativeLayout) i3.findViewById(R.id.obfuscated_res_0x7f091c27);
        this.u = (TbImageView) i3.findViewById(R.id.obfuscated_res_0x7f091c6a);
        this.y = (TbImageView) i3.findViewById(R.id.obfuscated_res_0x7f091c6b);
        TbImageView tbImageView = (TbImageView) i3.findViewById(R.id.obfuscated_res_0x7f091c39);
        this.v = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        VirtualImageStatusTip virtualImageStatusTip = (VirtualImageStatusTip) i3.findViewById(R.id.obfuscated_res_0x7f091c6d);
        this.w = virtualImageStatusTip;
        virtualImageStatusTip.setIsPersonalLocate(true);
        this.z = i3.findViewById(R.id.obfuscated_res_0x7f090e88);
        this.A = (ImageView) i3.findViewById(R.id.obfuscated_res_0x7f090e89);
        this.B = (EMTextView) i3.findViewById(R.id.obfuscated_res_0x7f090e8a);
        i3.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        if (bdUniqueId != null) {
            this.J.setTag(bdUniqueId);
        }
        tbPageContext.registerListener(this.J);
    }

    public final void A(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            if (z) {
                this.v.setVisibility(0);
                layoutParams2.addRule(0, R.id.obfuscated_res_0x7f091c39);
                if (z2) {
                    layoutParams2.rightMargin = BdUtilHelper.getDimens(c(), R.dimen.tbds55);
                    layoutParams3.setMarginEnd(BdUtilHelper.getDimens(c(), R.dimen.tbds55));
                    this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.transparent_bg));
                    BdUtilHelper.addToParentArea(c(), this.v, 12, 12, 0, 0);
                } else {
                    layoutParams2.rightMargin = 0;
                    layoutParams3.addRule(0, R.id.obfuscated_res_0x7f091c39);
                }
                this.w.setLayoutParams(layoutParams3);
                this.z.setVisibility(8);
                layoutParams.height = BdUtilHelper.getDimens(c(), R.dimen.tbds380);
            } else {
                this.v.setVisibility(8);
                this.z.setVisibility(0);
                layoutParams.height = BdUtilHelper.getDimens(c(), R.dimen.tbds251);
                layoutParams2.addRule(0, R.id.obfuscated_res_0x7f090e88);
                BdUtilHelper.addToParentArea(c(), this.z, 0, 41, 41, 41);
            }
            this.r.setLayoutParams(layoutParams);
            this.t.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i) == null) && this.i != i) {
            if (this.F) {
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1, i);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1, i);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0101, 1, i);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1, i);
            } else {
                this.j.setTextColor(R.color.CAM_X0109);
                this.k.setTextColor(R.color.CAM_X0109);
                this.l.setTextColor(R.color.CAM_X0109);
                this.m.setTextColor(R.color.CAM_X0109);
            }
            this.u.setSkinType(i);
            this.y.setSkinType(i);
            EMManager.from(this.r).setCorner(R.string.J_X14).setCardType(1);
            EMManager.from(this.p).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X05);
            EMManager.from(this.j).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
            EMManager.from(this.k).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
            EMManager.from(this.l).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
            EMManager.from(this.m).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
            if (this.F) {
                EMManager.from(this.r).setBackGroundColor(R.color.transparent);
                SkinManager.setBackgroundResource(this.z, R.drawable.obfuscated_res_0x7f080938, 0);
            } else {
                EMManager.from(this.r).setBackGroundColor(R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.z, R.drawable.obfuscated_res_0x7f080921, 0);
            }
            if (this.F && !TextUtils.isEmpty(this.C)) {
                int f = vca.f(this.C);
                this.A.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080922, f, WebPManager.ResourceStateType.NORMAL));
                this.B.setTextColor(f);
            } else {
                WebPManager.setPureDrawable(this.A, R.drawable.obfuscated_res_0x7f080922, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0304);
            }
            EMManager.from(this.B).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
            y();
            this.i = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cj6
    /* renamed from: B */
    public void j(sq9 sq9Var) {
        UserData userData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sq9Var) == null) && sq9Var != null && (userData = sq9Var.a) != null) {
            boolean C = C(userData);
            this.F = C;
            if (this.E != C) {
                this.E = C;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921755, Boolean.TRUE));
            }
            if (ProfileVirtualImageInfo.getInstance().isDisplayVirtual() && ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 1 && !this.F) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = !StringUtils.isNull(ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl());
            A(z, z2);
            if (z) {
                if (z2) {
                    K();
                    E();
                } else {
                    I();
                    J();
                }
            } else {
                this.s.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                D();
            }
            if (z) {
                this.w.setData(ProfileVirtualImageInfo.getInstance().getPersonalState(), true, "#FFFFFF");
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
            this.B.setText(R.string.obfuscated_res_0x7f0f13a8);
            UserData userData2 = sq9Var.a;
            this.D = userData2;
            this.j.setText(Integer.toString(userData2.getFansNum()));
            this.l.setText(Integer.toString(sq9Var.a.getConcernNum()));
            this.n.o(this.D);
            if (this.D.getNewGodData() != null && this.D.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new StatisticItem("c13690").param("uid", this.D.getUserId()).param("obj_locate", "0"));
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.n.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.n.setBigVDimenSize(R.dimen.tbds40);
                this.n.h(true);
            } else if (this.D.getNewGodData() != null && this.D.getNewGodData().isNewGod()) {
                this.n.setBigVDimenSize(R.dimen.tbds40);
            }
            this.n.getBigVIconView().setOnClickListener(new b(this));
            UserData userData3 = this.D;
            if (userData3.isNickNameInVerifying) {
                this.p.setText(userData3.nickNameInVerifying);
                this.q.setVisibility(0);
            } else {
                this.p.setText(userData3.getName_show());
                this.q.setVisibility(8);
            }
            y();
            k(this.b, TbadkCoreApplication.getInst().getSkinType());
            i().invalidate();
        }
    }

    public final boolean C(UserData userData) {
        InterceptResult invokeL;
        ThemeMyTab themeMyTab;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, userData)) == null) {
            if (userData != null && (themeMyTab = userData.themeMyTab) != null && (!TextUtils.isEmpty(themeMyTab.url) || !TextUtils.isEmpty(userData.themeMyTab.dynamic_url))) {
                this.C = userData.themeMyTab.button_color;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921750, Boolean.TRUE));
                return true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921750, Boolean.FALSE));
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.fictional_character_bg_personal));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
            if (this.F) {
                EMManager.from(this.r).setBackGroundColor(R.color.transparent);
                this.s.setVisibility(8);
                SkinManager.setBackgroundResource(this.z, R.drawable.obfuscated_res_0x7f080938, 0);
                if (!TextUtils.isEmpty(this.C)) {
                    int f = vca.f(this.C);
                    this.A.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080922, f, WebPManager.ResourceStateType.NORMAL));
                    this.B.setTextColor(f);
                }
                layoutParams.setMarginStart(BdUtilHelper.getDimens(this.c, R.dimen.tbds34));
                layoutParams.setMarginEnd(BdUtilHelper.getDimens(this.c, R.dimen.tbds34));
                layoutParams2.setMarginEnd(BdUtilHelper.getDimens(this.c, R.dimen.tbds0));
                this.t.setPadding(BdUtilHelper.getDimens(this.c, R.dimen.tbds0), BdUtilHelper.getDimens(this.c, R.dimen.tbds0), BdUtilHelper.getDimens(this.c, R.dimen.tbds0), BdUtilHelper.getDimens(this.c, R.dimen.tbds0));
            } else {
                EMManager.from(this.r).setBackGroundColor(R.color.CAM_X0204);
                this.s.setVisibility(0);
                SkinManager.setBackgroundResource(this.z, R.drawable.obfuscated_res_0x7f080921, 0);
                WebPManager.setPureDrawable(this.A, R.drawable.obfuscated_res_0x7f080922, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0304);
                layoutParams.setMarginStart(BdUtilHelper.getDimens(this.c, R.dimen.tbds57));
                layoutParams.setMarginEnd(BdUtilHelper.getDimens(this.c, R.dimen.tbds57));
                layoutParams2.setMarginEnd(BdUtilHelper.getDimens(this.c, R.dimen.tbds34));
                this.t.setPadding(BdUtilHelper.getDimens(this.c, R.dimen.tbds21), BdUtilHelper.getDimens(this.c, R.dimen.tbds0), BdUtilHelper.getDimens(this.c, R.dimen.tbds0), BdUtilHelper.getDimens(this.c, R.dimen.tbds0));
            }
            this.r.setLayoutParams(layoutParams);
            this.z.setLayoutParams(layoutParams2);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.u.setAlpha(1.0f);
            this.s.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            Glide.with(this.c).load(ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl()).apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.transparent_bg).placeholder(R.drawable.transparent_bg)).listener(new d(this)).into(this.u);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            UserData userData = this.D;
            if (userData != null && (userData.getIsMem() > 0 || this.D.isBigV())) {
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0301, 1);
            } else if (this.F) {
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0101, 1);
            } else {
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0610, 1);
            }
            EMManager.from(this.q).setTextColor(R.color.CAM_X0108).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0204);
        }
    }

    public final void H() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (tbImageView = this.o) == null) {
            return;
        }
        UserData userData = this.D;
        if (userData == null) {
            tbImageView.setVisibility(8);
            return;
        }
        ArrayList<IconData> tShowInfoNew = userData.getTShowInfoNew();
        if (ListUtils.getItem(tShowInfoNew, 0) != null) {
            String icon = ((IconData) ListUtils.getItem(tShowInfoNew, 0)).getIcon();
            if (StringUtils.isNotNull(icon)) {
                this.o.setVisibility(0);
                this.o.setDefaultResource(17170445);
                this.o.setPlaceHolder(2);
                this.o.startLoad(icon, 10, false);
                return;
            }
            this.o.setVisibility(8);
            return;
        }
        this.o.setVisibility(8);
    }

    public final void J() {
        String virtualImageUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!StringUtils.isNull(ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl())) {
                virtualImageUrl = ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl();
            } else {
                virtualImageUrl = ProfileVirtualImageInfo.getInstance().getVirtualImageUrl();
            }
            Glide.with(this.c).load(virtualImageUrl).apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.transparent_bg).placeholder(R.drawable.transparent_bg)).listener(new c(this)).into(this.v);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.F) {
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0101, 1);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1);
                return;
            }
            this.j.setTextColor(R.color.CAM_X0109);
            this.k.setTextColor(R.color.CAM_X0109);
            this.l.setTextColor(R.color.CAM_X0109);
            this.m.setTextColor(R.color.CAM_X0109);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Glide.with(this.c).load(ProfileVirtualImageInfo.getInstance().getVirtualImageUrl()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.fictional_character_bg_personal).error(R.drawable.fictional_character_bg_personal)).into(this.y);
            this.y.setVisibility(0);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int virtualBackgroundType = ProfileVirtualImageInfo.getInstance().getVirtualBackgroundType();
            String virtualBackground = ProfileVirtualImageInfo.getInstance().getVirtualBackground();
            if (virtualBackgroundType == 1) {
                this.u.setAlpha(0.65f);
                if (StringUtils.isNull(virtualBackground)) {
                    virtualBackground = "#FFFFFF";
                }
                this.s.setCardBackgroundColor(vca.f(virtualBackground));
                D();
            } else if (virtualBackgroundType == 2) {
                this.u.setAlpha(1.0f);
                Glide.with(this.c).load(virtualBackground).apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.fictional_character_bg_personal).placeholder(R.drawable.fictional_character_bg_personal)).into(this.u);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, view2) != null) || view2 == null) {
            return;
        }
        boolean z = false;
        if (view2 == this.o) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 2));
            if (!ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
                return;
            }
            UserData userData = this.D;
            if (userData != null) {
                ArrayList<IconData> tShowInfoNew = userData.getTShowInfoNew();
                if (ListUtils.getItem(tShowInfoNew, 0) != null) {
                    UrlManager.getInstance().dealOneLink(this.b, new String[]{((IconData) ListUtils.getItem(tShowInfoNew, 0)).getUrl()});
                }
            }
        } else if (view2 != this.z && view2 != this.v) {
            if (view2 == this.w) {
                this.H = 1;
                UtilHelper.dealUrlWithSkin(this.G, UrlUtils.appendParam(TbConfig.VIRTUAL_IMAGE_MAIN_URL, "tab", "mood"));
            } else {
                this.H = 3;
                this.I = 2;
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 1));
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    z = TbadkCoreApplication.getCurrentAccountInfo().isBigV();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, z)));
            }
        } else {
            this.H = 2;
            this.I = 1;
            UtilHelper.dealUrlWithSkin(this.G, TbConfig.VIRTUAL_IMAGE_MAIN_URL);
        }
        ws5.a(this.H, this.I);
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            H();
            G();
            F();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.y.setVisibility(8);
        }
    }
}
