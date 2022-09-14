package com.baidu.tieba;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vk5 extends ClickableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public String d;
    public String e;
    public int f;
    public int g;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public String c;

        public a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = str;
            this.c = str2;
        }
    }

    public vk5(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = -1;
        this.g = 0;
        this.d = str;
        this.c = i;
    }

    public static void a(Context context, yk5 yk5Var, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, yk5Var, Integer.valueOf(i), str, str2}) == null) || yk5Var == null) {
            return;
        }
        if (i == 2) {
            yk5Var.R(context, str, false);
        } else if (i == 16) {
            yk5Var.G(context, str);
        } else if (i == 18) {
            yk5Var.R(context, str, true);
        } else if (i == 32) {
            yk5Var.I(context, str);
        } else if (i == 64) {
            yk5Var.g1(context, str);
        } else if (i == 128) {
            yk5Var.Q(context, str);
        } else if (i == 256) {
            yk5Var.V(context, str, str2);
        } else if (i == 1024) {
            yk5Var.Y(context, str);
        } else if (i != 1282) {
        } else {
            yk5Var.R(context, str, true);
        }
    }

    public static void b(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65538, null, tbPageContext, i, str, str2) == null) && tbPageContext != null && (tbPageContext.getOrignalPage() instanceof yk5)) {
            a(tbPageContext.getPageActivity(), (yk5) tbPageContext.getOrignalPage(), i, str, str2);
        }
    }

    public static void c(TbPageContext<?> tbPageContext, yk5 yk5Var, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, yk5Var, Integer.valueOf(i), str, str2}) == null) || tbPageContext == null || yk5Var == null) {
            return;
        }
        a(tbPageContext.getPageActivity(), yk5Var, i, str, str2);
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.c;
            return i == 2 || i == 16 || i == 18 || i == 35 || i == 39;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.c;
            return i == 2 || i == 16 || i == 18 || i == 35 || i == 39 || i == 1282;
        }
        return invokeV.booleanValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a = i;
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : invokeV.intValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.e = str;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b = i;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.g = i;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001332, new a(this.c, this.d, this.e));
            int i2 = 2;
            if (this.c == 2) {
                int i3 = this.g;
                if (i3 == 1) {
                    i = 2;
                } else if (i3 == 2) {
                    i = 1;
                } else {
                    i = 1;
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).param("obj_source", i2).param("obj_type", i));
                }
                i2 = 1;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).param("obj_source", i2).param("obj_type", i));
            }
            if (view2 instanceof TbListTextView) {
                ((TbRichTextView) view2.getParent()).setPressed(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, textPaint) == null) {
            int i = this.b;
            if (i != -1) {
                textPaint.setColor(SkinManager.getColor(i));
            } else if (f()) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
            } else {
                textPaint.setColor(textPaint.linkColor);
            }
            textPaint.setUnderlineText(false);
            int i2 = this.a;
            if (i2 != -1) {
                textPaint.bgColor = i2;
            } else if (this.f == 1 && e()) {
                textPaint.bgColor = SkinManager.getColor(R.color.CAM_X0210);
            } else if (this.f == 2) {
                textPaint.bgColor = SkinManager.getColor(R.color.transparent);
            }
        }
    }
}
