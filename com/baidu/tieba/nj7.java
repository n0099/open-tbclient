package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.headerimage.FrsHeaderBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public RelativeLayout b;
    public LinearGradientView c;
    public BarImageView d;
    public TextView e;
    public FrsHeaderBannerView f;
    public LinearLayout g;
    public ImageView h;
    public View i;
    public TbImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(nj7 nj7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nj7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.a;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    public nj7(Context context) {
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
        UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        UtilHelper.getStatusBarHeight();
        UtilHelper.getDimenPixelSize(R.dimen.tbds50);
        UtilHelper.getStatusBarHeight();
        UtilHelper.getDimenPixelSize(R.dimen.tbds51);
        UtilHelper.getStatusBarHeight();
        if (context == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0326, (ViewGroup) null);
        this.a = inflate;
        this.b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090e94);
        this.c = (LinearGradientView) this.a.findViewById(R.id.obfuscated_res_0x7f090e97);
        TbImageView tbImageView = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090e95);
        this.j = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.j.setDefaultResource(R.drawable.obfuscated_res_0x7f080ff2);
        this.d = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090c70);
        TextView textView = (TextView) this.a.findViewById(R.id.forum_name);
        this.e = textView;
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
        this.f = (FrsHeaderBannerView) this.a.findViewById(R.id.obfuscated_res_0x7f090c5f);
        this.g = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090a80);
        this.h = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a7f);
        this.i = this.a.findViewById(R.id.obfuscated_res_0x7f090eaf);
        this.k = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a82);
        this.l = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a84);
        this.m = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a81);
        this.n = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090a83);
        this.k.setOnClickListener(new a(this, context));
        this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setContentDescription(context.getResources().getString(R.string.obfuscated_res_0x7f0f02ed));
        this.d.setStrokeWith(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.d.setShowOval(true);
        this.d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.d.setStrokeColorResId(R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        g35 d = g35.d(this.i);
        d.n(1);
        d.o(R.string.J_X14);
        d.f(R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.h, R.color.CAM_X0201);
        SkinManager.setImageResource(this.k, R.drawable.ic_icon_pure_topbar_return40_svg);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.obfuscated_res_0x7f0802ea, R.color.CAM_X0204, SvgManager.SvgResourceStateType.NORMAL);
    }
}
