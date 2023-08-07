package com.baidu.tieba;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public final class j76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ it4 a;
        public final /* synthetic */ PopupWindow b;

        public a(it4 it4Var, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it4Var, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = it4Var;
            this.b = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090e4e) {
                    if (BdActivityStack.getInst().currentActivity() != null && !StringUtils.isNull(this.a.f())) {
                        Uri parse = Uri.parse(this.a.f());
                        if (parse != null && parse.getQueryParameters("obj_type") != null && parse.getQueryParameters("obj_source") != null) {
                            TiebaStatic.log(new StatisticItem("c13391").param("obj_type", parse.getQueryParameter("obj_type")).param("obj_source", parse.getQueryParameter("obj_source")));
                        }
                        if (this.a.f().startsWith(BdUniDispatchSchemeController.SCHEME)) {
                            Uri.Builder buildUpon = Uri.parse(this.a.f()).buildUpon();
                            buildUpon.appendQueryParameter(BdUniDispatchSchemeController.PARAM_SCHEME_FROM, BdUniDispatchSchemeController.SCHEME_FROM_TB_TOKEN);
                            parse = buildUpon.build();
                        }
                        UtilHelper.dealOneScheme(BdActivityStack.getInst().currentActivity(), parse.toString());
                    }
                    try {
                        this.b.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e4d) {
                    try {
                        this.b.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ it4 b;
        public final /* synthetic */ PopupWindow c;

        public b(String str, it4 it4Var, PopupWindow popupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, it4Var, popupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = it4Var;
            this.c = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090e4e) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, this.a));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.b.j).param("obj_source", "tb_password").param("obj_name", this.b.h).param("obj_param1", this.b.k.intValue()));
                    try {
                        this.c.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090e4d) {
                    try {
                        this.c.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        }
    }

    public static PopupWindow a(it4 it4Var) {
        InterceptResult invokeL;
        View.OnClickListener aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, it4Var)) == null) {
            Activity currentActivity = BdActivityStack.getInst().currentActivity();
            if (currentActivity == null || it4Var == null) {
                return null;
            }
            String f = it4Var.f();
            if (StringUtils.isNull(f)) {
                return null;
            }
            View inflate = LayoutInflater.from(currentActivity).inflate(R.layout.obfuscated_res_0x7f0d00de, (ViewGroup) null, true);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090e4e);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090e4d);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0925c9);
            TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0925c8);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0925ca);
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f0814e0);
            tbImageView.setAutoChangeStyle(false);
            PopupWindow popupWindow = new PopupWindow(currentActivity);
            if (it4Var.g() != 3) {
                aVar = new b(f, it4Var, popupWindow);
                if (!StringUtils.isNull(it4Var.c())) {
                    tbImageView.startLoad(it4Var.c(), 10, false);
                } else {
                    tbImageView.setImageResource(R.drawable.obfuscated_res_0x7f0814e0);
                }
            } else {
                tbImageView.setImageResource(R.drawable.obfuscated_res_0x7f0814e1);
                aVar = new a(it4Var, popupWindow);
            }
            textView.setOnClickListener(aVar);
            textView2.setOnClickListener(aVar);
            textView.setText(it4Var.b());
            textView2.setText(it4Var.a());
            textView3.setText(it4Var.e());
            textView4.setText(it4Var.d());
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(Color.argb(178, 0, 0, 0));
            popupWindow.setBackgroundDrawable(colorDrawable);
            popupWindow.setWidth(BdUtilHelper.getEquipmentWidth(currentActivity));
            popupWindow.setHeight(BdUtilHelper.getEquipmentHeight(currentActivity));
            popupWindow.setContentView(inflate);
            popupWindow.setOutsideTouchable(true);
            GreyUtil.grey(popupWindow);
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                    declaredField.setAccessible(true);
                    declaredField.set(popupWindow, Boolean.TRUE);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
            }
            return popupWindow;
        }
        return (PopupWindow) invokeL.objValue;
    }
}
