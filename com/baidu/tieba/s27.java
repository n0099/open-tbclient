package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes7.dex */
public class s27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public View c;
    public RoundRelativeLayout d;
    public ImageView e;
    public ImageView f;
    public TbImageView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public HotUserRankImageOverlayView l;
    public ImageView m;
    public int n;
    public String o;
    public String p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s27 a;

        public a(s27 s27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s27Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(this.a.b.getPageActivity());
                hotUserRankActivityConfig.setCategory(this.a.o);
                this.a.b.sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13655");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("resource_id", this.a.p);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public s27(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01dc, (ViewGroup) null);
        this.c = inflate;
        this.d = (RoundRelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092919);
        this.e = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090fd9);
        this.f = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090fda);
        this.g = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091df1);
        this.h = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091df2);
        this.i = (TextView) this.c.findViewById(R.id.forum_text);
        this.j = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09193a);
        this.l = (HotUserRankImageOverlayView) this.c.findViewById(R.id.obfuscated_res_0x7f09107d);
        this.k = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0911ee);
        this.m = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090fe2);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.l.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.l.setStrokeStyle(1);
        this.l.setLoadImageType(12);
        this.l.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.d.setOnClickListener(new a(this));
        int g = yi.g(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.n = g;
        this.d.setRoundLayoutRadius(new float[]{g, g, g, g, g, g, g, g});
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.p = str;
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a != TbadkCoreApplication.getInst().getSkinType()) {
            this.a = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0206);
            if (this.h.getVisibility() == 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.e, R.drawable.obfuscated_res_0x7f0807cf, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setImageResource(this.f, R.drawable.obfuscated_res_0x7f0811db);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0311);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0311);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080769, null);
            this.l.d();
        }
    }

    public void f(q27 q27Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q27Var) != null) || q27Var == null) {
            return;
        }
        String str = q27Var.b;
        this.o = str;
        if (TextUtils.isEmpty(str)) {
            this.o = "";
        }
        TextView textView = this.i;
        textView.setText(this.o + "榜");
        List<ShortUserInfo> list = q27Var.a;
        if (list != null && list.size() > 0) {
            TextView textView2 = this.j;
            textView2.setText("NO.1 " + q27Var.a.get(0).user_name);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (ShortUserInfo shortUserInfo : q27Var.a) {
                if (i > 2) {
                    break;
                }
                i++;
                arrayList.add(shortUserInfo.portrait);
            }
            this.l.setData(arrayList);
            if (!TextUtils.isEmpty(q27Var.c)) {
                this.g.setVisibility(0);
                this.h.setVisibility(8);
                this.g.N(q27Var.c, 12, false);
            } else {
                this.h.setVisibility(0);
                this.g.setVisibility(8);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
        e();
    }
}
