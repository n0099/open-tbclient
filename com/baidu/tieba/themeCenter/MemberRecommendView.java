package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.j3b;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class MemberRecommendView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public j3b f;
    public int g;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberRecommendView a;

        public a(MemberRecommendView memberRecommendView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberRecommendView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = memberRecommendView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 2006;
                String str3 = "";
                switch (this.a.g) {
                    case 1:
                        TiebaStatic.log("c10261");
                        str3 = MemberPayStatistic.REFER_PAGE_DRESS_UP_CENTER;
                        break;
                    case 2:
                    case 3:
                    case 9:
                        TiebaStatic.log("c10266");
                        if (this.a.g == 9) {
                            str3 = MemberPayStatistic.REFER_PAGE_PERSONALITY_CARDS;
                            break;
                        }
                        break;
                    case 4:
                    case 5:
                        TiebaStatic.log("c10278");
                        if (this.a.g == 4) {
                            str = MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND;
                        } else {
                            str = MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND;
                        }
                        str3 = str;
                        i = 2010;
                        break;
                    case 6:
                    case 7:
                        TiebaStatic.log("c10762");
                        if (this.a.g == 7) {
                            str2 = MemberPayStatistic.REFER_PAGE_ALL_BUBBLE;
                        } else {
                            str2 = MemberPayStatistic.REFER_PAGE_POST_BUBBLE;
                        }
                        str3 = str2;
                        i = IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION;
                        break;
                    case 8:
                        TiebaStatic.log("c11613");
                        i = 2015;
                        str3 = MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (this.a.f == null || (tbPageContext = (TbPageContext) a5.a(this.a.a)) == null) {
                    return;
                }
                PayPanelUtils.launchPayPanel(tbPageContext, i, str3, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRecommendView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRecommendView(Context context, AttributeSet attributeSet) {
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
        this.a = context;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = context;
        f();
    }

    public void setFromType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.g = i;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0207);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0108);
        }
    }

    public View getButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public int getFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public void e(j3b j3bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j3bVar) != null) || j3bVar == null) {
            return;
        }
        this.f = j3bVar;
        this.c.startLoad(j3bVar.b(), 10, false);
        this.d.setText(this.f.c());
        if (StringUtils.isNull(this.f.a())) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.e.setText(this.f.a());
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d063b, this);
            this.b = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092a88);
            this.c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_vip_orange);
            this.c.setDefaultBgResource(R.drawable.transparent_bg);
            this.c.setAutoChangeStyle(true);
            this.d = (TextView) this.b.findViewById(R.id.title_view);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0912c5);
            this.e = textView;
            textView.setOnClickListener(new a(this));
        }
    }
}
