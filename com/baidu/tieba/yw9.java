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
/* loaded from: classes8.dex */
public class yw9 extends to6<fw9> {
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

    @Override // com.baidu.tieba.to6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? R.layout.obfuscated_res_0x7f0d07db : invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yw9 yw9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw9Var, Integer.valueOf(i)};
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
            this.a = yw9Var;
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

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw9 a;

        public b(yw9 yw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yw9Var;
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

    /* loaded from: classes8.dex */
    public class c implements RequestListener<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw9 a;

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, target, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public c(yw9 yw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yw9Var;
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

    /* loaded from: classes8.dex */
    public class d implements RequestListener<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw9 a;

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, target, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public d(yw9 yw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yw9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawable, obj, target, dataSource, Boolean.valueOf(z)})) == null) {
                this.a.y();
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yw9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        View h = h();
        this.G = tbPageContext;
        this.x = h.findViewById(R.id.obfuscated_res_0x7f092961);
        PersonHeadPendantView personHeadPendantView = (PersonHeadPendantView) h.findViewById(R.id.obfuscated_res_0x7f091bea);
        this.n = personHeadPendantView;
        personHeadPendantView.setHasPendantStyle();
        this.n.getHeadView().setIsRound(true);
        this.n.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.n.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.n.getHeadView().setPlaceHolder(2);
        this.o = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f091720);
        this.p = (EMTextView) h.findViewById(R.id.obfuscated_res_0x7f091c2c);
        this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091971);
        this.j = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090ae4);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090ae6);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090788);
        this.m = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090789);
        this.r = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f091c03);
        this.s = (CardView) h.findViewById(R.id.obfuscated_res_0x7f091c07);
        this.t = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f091bff);
        this.u = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f091c42);
        this.y = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f091c43);
        TbImageView tbImageView = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f091c11);
        this.v = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        VirtualImageStatusTip virtualImageStatusTip = (VirtualImageStatusTip) h.findViewById(R.id.obfuscated_res_0x7f091c45);
        this.w = virtualImageStatusTip;
        virtualImageStatusTip.setIsPersonalLocate(true);
        this.z = h.findViewById(R.id.obfuscated_res_0x7f090e6e);
        this.A = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090e6f);
        this.B = (EMTextView) h.findViewById(R.id.obfuscated_res_0x7f090e70);
        h.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        if (bdUniqueId != null) {
            this.J.setTag(bdUniqueId);
        }
        tbPageContext.registerListener(this.J);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.to6
    /* renamed from: A */
    public void i(fw9 fw9Var) {
        UserData userData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fw9Var) == null) && fw9Var != null && (userData = fw9Var.a) != null) {
            boolean B = B(userData);
            this.F = B;
            if (this.E != B) {
                this.E = B;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921755, Boolean.TRUE));
            }
            if (ProfileVirtualImageInfo.getInstance().isDisplayVirtual() && ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 1 && !this.F) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = !StringUtils.isNull(ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl());
            z(z, z2);
            if (z) {
                if (z2) {
                    J();
                    D();
                } else {
                    H();
                    I();
                }
            } else {
                this.s.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                C();
            }
            if (z) {
                this.w.setData(ProfileVirtualImageInfo.getInstance().getPersonalState(), true, "#FFFFFF");
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
            this.B.setText(R.string.obfuscated_res_0x7f0f1397);
            UserData userData2 = fw9Var.a;
            this.D = userData2;
            this.j.setText(Integer.toString(userData2.getFansNum()));
            this.l.setText(Integer.toString(fw9Var.a.getConcernNum()));
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
            x();
            j(this.b, TbadkCoreApplication.getInst().getSkinType());
            h().invalidate();
        }
    }

    public final boolean B(UserData userData) {
        InterceptResult invokeL;
        ThemeMyTab themeMyTab;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userData)) == null) {
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

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.fictional_character_bg_personal));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
            if (this.F) {
                EMManager.from(this.r).setBackGroundColor(R.color.transparent);
                this.s.setVisibility(8);
                SkinManager.setBackgroundResource(this.z, R.drawable.obfuscated_res_0x7f080935, 0);
                if (!TextUtils.isEmpty(this.C)) {
                    int f = fia.f(this.C);
                    this.A.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08091f, f, WebPManager.ResourceStateType.NORMAL));
                    this.B.setTextColor(f);
                }
                layoutParams.setMarginStart(BdUtilHelper.getDimens(this.c, R.dimen.tbds34));
                layoutParams.setMarginEnd(BdUtilHelper.getDimens(this.c, R.dimen.tbds34));
                layoutParams2.setMarginEnd(BdUtilHelper.getDimens(this.c, R.dimen.tbds0));
                this.t.setPadding(BdUtilHelper.getDimens(this.c, R.dimen.tbds0), BdUtilHelper.getDimens(this.c, R.dimen.tbds0), BdUtilHelper.getDimens(this.c, R.dimen.tbds0), BdUtilHelper.getDimens(this.c, R.dimen.tbds0));
            } else {
                EMManager.from(this.r).setBackGroundColor(R.color.CAM_X0204);
                this.s.setVisibility(0);
                SkinManager.setBackgroundResource(this.z, R.drawable.obfuscated_res_0x7f08091e, 0);
                WebPManager.setPureDrawable(this.A, R.drawable.obfuscated_res_0x7f08091f, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL);
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

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.u.setAlpha(1.0f);
            this.s.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            Glide.with(this.c).load(ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl()).apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.transparent_bg).placeholder(R.drawable.transparent_bg)).listener(new d(this)).into(this.u);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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

    public final void G() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (tbImageView = this.o) == null) {
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

    public final void I() {
        String virtualImageUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!StringUtils.isNull(ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl())) {
                virtualImageUrl = ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl();
            } else {
                virtualImageUrl = ProfileVirtualImageInfo.getInstance().getVirtualImageUrl();
            }
            Glide.with(this.c).load(virtualImageUrl).apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.transparent_bg).placeholder(R.drawable.transparent_bg)).listener(new c(this)).into(this.v);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Glide.with(this.c).load(ProfileVirtualImageInfo.getInstance().getVirtualImageUrl()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.fictional_character_bg_personal).error(R.drawable.fictional_character_bg_personal)).into(this.y);
            this.y.setVisibility(0);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int virtualBackgroundType = ProfileVirtualImageInfo.getInstance().getVirtualBackgroundType();
            String virtualBackground = ProfileVirtualImageInfo.getInstance().getVirtualBackground();
            if (virtualBackgroundType == 1) {
                this.u.setAlpha(0.65f);
                if (StringUtils.isNull(virtualBackground)) {
                    virtualBackground = "#FFFFFF";
                }
                this.s.setCardBackgroundColor(fia.f(virtualBackground));
                C();
            } else if (virtualBackgroundType == 2) {
                this.u.setAlpha(1.0f);
                Glide.with(this.c).load(virtualBackground).apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.fictional_character_bg_personal).placeholder(R.drawable.fictional_character_bg_personal)).into(this.u);
            }
        }
    }

    @Override // com.baidu.tieba.to6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, tbPageContext, i) == null) && this.i != i) {
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
                SkinManager.setBackgroundResource(this.z, R.drawable.obfuscated_res_0x7f080935, 0);
            } else {
                EMManager.from(this.r).setBackGroundColor(R.color.CAM_X0204);
                SkinManager.setBackgroundResource(this.z, R.drawable.obfuscated_res_0x7f08091e, 0);
            }
            if (this.F && !TextUtils.isEmpty(this.C)) {
                int f = fia.f(this.C);
                this.A.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08091f, f, WebPManager.ResourceStateType.NORMAL));
                this.B.setTextColor(f);
            } else {
                WebPManager.setPureDrawable(this.A, R.drawable.obfuscated_res_0x7f08091f, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL);
                SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0304);
            }
            EMManager.from(this.B).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
            x();
            this.i = i;
        }
    }

    public final void z(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            if (z) {
                this.v.setVisibility(0);
                layoutParams2.addRule(0, R.id.obfuscated_res_0x7f091c11);
                if (z2) {
                    layoutParams2.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds55);
                    layoutParams3.setMarginEnd(BdUtilHelper.getDimens(getContext(), R.dimen.tbds55));
                    this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.transparent_bg));
                    BdUtilHelper.addToParentArea(getContext(), this.v, 12, 12, 0, 0);
                } else {
                    layoutParams2.rightMargin = 0;
                    layoutParams3.addRule(0, R.id.obfuscated_res_0x7f091c11);
                }
                this.w.setLayoutParams(layoutParams3);
                this.z.setVisibility(8);
                layoutParams.height = BdUtilHelper.getDimens(getContext(), R.dimen.tbds380);
            } else {
                this.v.setVisibility(8);
                this.z.setVisibility(0);
                layoutParams.height = BdUtilHelper.getDimens(getContext(), R.dimen.tbds251);
                layoutParams2.addRule(0, R.id.obfuscated_res_0x7f090e6e);
                BdUtilHelper.addToParentArea(getContext(), this.z, 0, 41, 41, 41);
            }
            this.r.setLayoutParams(layoutParams);
            this.t.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, view2) != null) || view2 == null) {
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
        oy5.a(this.H, this.I);
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            G();
            F();
            E();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.y.setVisibility(8);
        }
    }
}
