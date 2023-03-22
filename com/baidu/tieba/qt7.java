package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qt7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static zt7 a = null;
    public static AlertDialog b = null;
    public static float c = 0.33f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948103445, "Lcom/baidu/tieba/qt7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948103445, "Lcom/baidu/tieba/qt7;");
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public static void a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, tbPageContext) == null) && (alertDialog = b) != null) {
            lg.a(alertDialog, tbPageContext.getPageActivity());
        }
    }

    public static void b(int i) {
        zt7 zt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65538, null, i) != null) || (zt7Var = a) == null) {
            return;
        }
        zt7Var.D(i);
    }

    public static yt7 c(TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull BaseMsg baseMsg, @NonNull ChatRoomDetail chatRoomDetail, @NonNull av7 av7Var, @NonNull bv7 bv7Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, tbPageContext, baseMsg, chatRoomDetail, av7Var, bv7Var)) == null) {
            a = new zt7(tbPageContext, baseMsg, chatRoomDetail, av7Var, bv7Var);
            AlertDialog create = new AlertDialog.Builder(tbPageContext.getPageActivity(), R.style.obfuscated_res_0x7f100108).create();
            b = create;
            create.setCanceledOnTouchOutside(true);
            b.setOnDismissListener(new a());
            lg.i(b, tbPageContext.getPageActivity());
            Window window = b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = hi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100404);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(a.u());
            window.setDimAmount(c);
            a.D(TbadkCoreApplication.getInst().getSkinType());
            return a;
        }
        return (yt7) invokeLLLLL.objValue;
    }
}
