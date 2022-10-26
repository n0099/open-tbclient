package com.baidu.tieba;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.UserVipInfoData;
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
import java.util.HashMap;
/* loaded from: classes6.dex */
public class x68 extends p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UserData A;
    public final TbPageContext B;
    public int C;
    public int D;
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
    public ImageView y;
    public EMTextView z;

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d06fa : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x68 a;

        public a(x68 x68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x68Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.A.getNewGodData() != null && this.a.A.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new StatisticItem("c13690").param("uid", this.a.A.getUserId()).param("obj_locate", "1"));
                HashMap hashMap = new HashMap();
                hashMap.put("from", "6");
                hashMap.put("field_id", this.a.A.getNewGodData().getFieldId());
                hashMap.put("animated", Boolean.FALSE);
                hashMap.put("transparent", Boolean.TRUE);
                hashMap.put("swipeback", Boolean.FALSE);
                hashMap.put("present", Boolean.TRUE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.b.getPageActivity(), "GodInvitePage", hashMap)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements RequestListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x68 a;

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glideException, obj, target, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public b(x68 x68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.RequestListener
        /* renamed from: a */
        public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
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

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ View c;

        public c(x68 x68Var, View view2, int i, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x68Var, view2, Integer.valueOf(i), view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = i;
            this.c = view3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.getHitRect(rect);
                int i = rect.top;
                int i2 = this.b;
                rect.top = i - i2;
                rect.bottom += i2;
                rect.right += i2;
                this.c.setTouchDelegate(new TouchDelegate(rect, this.a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x68(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.C = 0;
        this.D = 0;
        View k = k();
        this.B = tbPageContext;
        PersonHeadPendantView personHeadPendantView = (PersonHeadPendantView) k.findViewById(R.id.obfuscated_res_0x7f091937);
        this.n = personHeadPendantView;
        personHeadPendantView.setHasPendantStyle();
        this.n.getHeadView().setIsRound(true);
        this.n.getHeadView().setGodIconWidth(R.dimen.tbds40);
        this.n.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.n.getHeadView().setPlaceHolder(2);
        this.o = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f0914e1);
        this.p = (EMTextView) k.findViewById(R.id.obfuscated_res_0x7f091978);
        this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0916b4);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0909a4);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0909a7);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0906be);
        this.m = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0906bf);
        this.r = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f091950);
        this.s = (CardView) k.findViewById(R.id.obfuscated_res_0x7f091953);
        this.t = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f09194c);
        this.u = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f09198f);
        TbImageView tbImageView = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f09195d);
        this.v = tbImageView;
        tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081252);
        VirtualImageStatusTip virtualImageStatusTip = (VirtualImageStatusTip) k.findViewById(R.id.obfuscated_res_0x7f091991);
        this.w = virtualImageStatusTip;
        virtualImageStatusTip.setIsPersonalLocate(true);
        this.x = k.findViewById(R.id.obfuscated_res_0x7f090cf0);
        this.y = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f090cf1);
        this.z = (EMTextView) k.findViewById(R.id.obfuscated_res_0x7f090cf2);
        k.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: w */
    public void l(f68 f68Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, f68Var) == null) && f68Var != null && f68Var.a != null) {
            if (ProfileVirtualImageInfo.getInstance().isDisplayVirtual() && ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 1) {
                z = true;
            } else {
                z = false;
            }
            v(z);
            if (z) {
                B();
                C();
            } else {
                this.s.setCardBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                y();
            }
            if (z) {
                this.w.setData(ProfileVirtualImageInfo.getInstance().getPersonalState(), true, "#FFFFFF");
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
            this.z.setText(R.string.obfuscated_res_0x7f0f1151);
            UserData userData = f68Var.a;
            this.A = userData;
            this.j.setText(Integer.toString(userData.getFansNum()));
            this.l.setText(Integer.toString(f68Var.a.getConcernNum()));
            this.n.n(this.A);
            this.n.j(this.A, 3);
            if (this.A.getNewGodData() != null && this.A.getNewGodData().hasNewGodInvited()) {
                TiebaStatic.log(new StatisticItem("c13690").param("uid", this.A.getUserId()).param("obj_locate", "0"));
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.n.getBigVIconView(), R.drawable.icon_mask_shen_hui20_svg, SvgManager.SvgResourceStateType.NORMAL);
                this.n.setBigVDimenSize(R.dimen.tbds40);
                this.n.h(true);
            } else if (this.A.getNewGodData() != null && this.A.getNewGodData().isNewGod()) {
                this.n.setBigVDimenSize(R.dimen.tbds40);
            }
            this.n.getBigVIconView().setOnClickListener(new a(this));
            UserData userData2 = this.A;
            if (userData2.isNickNameInVerifying) {
                this.p.setText(userData2.nickNameInVerifying);
                this.q.setVisibility(0);
            } else {
                this.p.setText(userData2.getName_show());
                this.q.setVisibility(8);
            }
            t();
            m(this.b, TbadkCoreApplication.getInst().getSkinType());
            k().invalidate();
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            UserData userData = this.A;
            if (userData == null) {
                this.o.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
                return;
            }
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (this.A.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
                this.o.L(userVipInfo.getVipIconUrl(), 10, false);
            } else {
                this.o.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
            }
        }
    }

    public final void C() {
        String virtualImageUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!StringUtils.isNull(ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl())) {
                virtualImageUrl = ProfileVirtualImageInfo.getInstance().getDynamicVirtualImageUrl();
            } else {
                virtualImageUrl = ProfileVirtualImageInfo.getInstance().getVirtualImageUrl();
            }
            Glide.with(this.c).load(virtualImageUrl).apply((BaseRequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().error(R.drawable.obfuscated_res_0x7f081252)).placeholder(R.drawable.obfuscated_res_0x7f081252))).listener(new b(this)).into(this.v);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            UserData userData = this.A;
            if (userData != null && (userData.getIsMem() > 0 || this.A.isBigV())) {
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0610, 1);
            }
            nv4 d = nv4.d(this.q);
            d.v(R.color.CAM_X0108);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0204);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int virtualBackgroundType = ProfileVirtualImageInfo.getInstance().getVirtualBackgroundType();
            String virtualBackground = ProfileVirtualImageInfo.getInstance().getVirtualBackground();
            if (virtualBackgroundType == 1) {
                this.u.setAlpha(0.65f);
                if (StringUtils.isNull(virtualBackground)) {
                    virtualBackground = "#FFFFFF";
                }
                this.s.setCardBackgroundColor(vl8.f(virtualBackground));
                y();
            } else if (virtualBackgroundType == 2) {
                this.u.setAlpha(1.0f);
                Glide.with(this.c).load(virtualBackground).apply((BaseRequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().error(R.drawable.obfuscated_res_0x7f080566)).placeholder(R.drawable.obfuscated_res_0x7f080566))).into(this.u);
            }
        }
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) && this.i != i) {
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0204);
            this.j.setTextColor(R.color.CAM_X0109);
            this.k.setTextColor(R.color.CAM_X0109);
            this.l.setTextColor(R.color.CAM_X0109);
            this.m.setTextColor(R.color.CAM_X0109);
            this.u.setSkinType(i);
            nv4 d = nv4.d(this.r);
            d.n(R.string.J_X14);
            d.m(1);
            d.f(R.color.CAM_X0204);
            nv4 d2 = nv4.d(this.p);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X05);
            nv4 d3 = nv4.d(this.j);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X08);
            nv4 d4 = nv4.d(this.k);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X08);
            nv4 d5 = nv4.d(this.l);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X08);
            nv4 d6 = nv4.d(this.m);
            d6.A(R.string.F_X01);
            d6.z(R.dimen.T_X08);
            SkinManager.setBackgroundResource(this.x, R.drawable.obfuscated_res_0x7f080748, 0);
            WebPManager.setPureDrawable(this.y, R.drawable.obfuscated_res_0x7f080749, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
            nv4 d7 = nv4.d(this.z);
            d7.A(R.string.F_X01);
            d7.z(R.dimen.T_X08);
            t();
            this.i = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || view2 == null) {
            return;
        }
        boolean z = false;
        if (view2 == this.o) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 2));
            if (!ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.b, new String[]{TbConfig.URL_MEMBER_BUY});
        } else if (view2 != this.x && view2 != this.v) {
            if (view2 == this.w) {
                this.C = 1;
                x(UrlUtils.appendParam(TbConfig.VIRTUAL_IMAGE_MAIN_URL, "tab", "mood"));
            } else {
                this.C = 3;
                this.D = 2;
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 1));
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    z = TbadkCoreApplication.getCurrentAccountInfo().isBigV();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(eh.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, z)));
            }
        } else {
            this.C = 2;
            this.D = 1;
            x(TbConfig.VIRTUAL_IMAGE_MAIN_URL);
        }
        wi5.a(this.C, this.D);
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            A();
            z();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080566));
        }
    }

    public void u(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i) != null) || view2 == null) {
            return;
        }
        View view3 = (View) view2.getParent();
        view3.post(new c(this, view2, i, view3));
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            if (z) {
                this.v.setVisibility(0);
                this.x.setVisibility(8);
                layoutParams.height = fj.f(getContext(), R.dimen.tbds380);
                layoutParams2.addRule(0, R.id.obfuscated_res_0x7f09195d);
            } else {
                this.v.setVisibility(8);
                this.x.setVisibility(0);
                layoutParams.height = fj.f(getContext(), R.dimen.tbds251);
                layoutParams2.addRule(0, R.id.obfuscated_res_0x7f090cf0);
                u(this.x, fj.f(getContext(), R.dimen.M_W_X019));
            }
            this.r.setLayoutParams(layoutParams);
            this.t.setLayoutParams(layoutParams2);
        }
    }

    public final void x(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                str2 = "&skin=dart";
            } else if (skinType == 1) {
                str2 = "&skin=night";
            } else {
                str2 = "";
            }
            UrlManager.getInstance().dealOneLink(this.B, new String[]{str + str2});
        }
    }
}
