package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.g9;
import com.baidu.tieba.ri9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MemberRecommendView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public ri9 f;
    public int g;

    /* loaded from: classes6.dex */
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
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 9;
                switch (this.a.g) {
                    case 1:
                        TiebaStatic.log("c10261");
                        i = 8;
                        str = MemberPayStatistic.REFER_PAGE_DRESS_UP_CENTER;
                        break;
                    case 2:
                    case 3:
                    case 9:
                        TiebaStatic.log("c10266");
                        if (this.a.g == 9) {
                            str = MemberPayStatistic.REFER_PAGE_PERSONALITY_CARDS;
                            break;
                        }
                        str = "";
                        break;
                    case 4:
                    case 5:
                        TiebaStatic.log("c10278");
                        i = 12;
                        if (this.a.g == 4) {
                            str = MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND;
                            break;
                        } else {
                            str = MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND;
                            break;
                        }
                    case 6:
                    case 7:
                        TiebaStatic.log("c10762");
                        i = 19;
                        if (this.a.g == 7) {
                            str = MemberPayStatistic.REFER_PAGE_ALL_BUBBLE;
                            break;
                        } else {
                            str = MemberPayStatistic.REFER_PAGE_POST_BUBBLE;
                            break;
                        }
                    case 8:
                        i = 22;
                        TiebaStatic.log("c11613");
                        str = MemberPayStatistic.REFER_PAGE_AVANTAR_PENDANT;
                        break;
                    default:
                        i = 0;
                        str = "";
                        break;
                }
                if (this.a.f == null || (tbPageContext = (TbPageContext) g9.a(this.a.a)) == null) {
                    return;
                }
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(tbPageContext.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i);
                memberPayActivityConfig.setReferPageClickZone(str, MemberPayStatistic.CLICK_ZONE_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
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

    public void e(ri9 ri9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ri9Var) != null) || ri9Var == null) {
            return;
        }
        this.f = ri9Var;
        this.c.M(ri9Var.b(), 10, false);
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
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05be, this);
            this.b = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092802);
            this.c = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_vip_orange);
            this.c.setDefaultBgResource(R.drawable.transparent_bg);
            this.c.setAutoChangeStyle(true);
            this.d = (TextView) this.b.findViewById(R.id.title_view);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09119c);
            this.e = textView;
            textView.setOnClickListener(new a(this));
        }
    }
}
