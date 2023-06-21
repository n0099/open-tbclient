package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65536, null, i) == null) && TbadkCoreApplication.getInst().getFontSize() != i) {
            TbadkCoreApplication.getInst().setFontSize(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            if (fontSize == 0) {
                return TbadkCoreApplication.getInst().getString(R.string.toast_font_size_xlarge);
            }
            if (fontSize == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.toast_font_size_big);
            }
            if (fontSize == 2) {
                return TbadkCoreApplication.getInst().getString(R.string.toast_font_size_mid);
            }
            return TbadkCoreApplication.getInst().getString(R.string.toast_font_size_small);
        }
        return (String) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            int i = 3;
            if (fontSize == 0) {
                i = 1;
            } else if (fontSize == 1) {
                i = 2;
            }
            if (fontSize != i) {
                TbadkCoreApplication.getInst().setFontSize(i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
            }
            BdToast b = BdToast.b(TbadkCoreApplication.getInst(), b());
            b.f(R.drawable.icon_word_t_size);
            b.d(0);
            b.q();
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            int i = 2;
            if (fontSize == 0 || fontSize == 1) {
                i = 0;
            } else if (fontSize == 2) {
                i = 1;
            }
            if (fontSize != i) {
                TbadkCoreApplication.getInst().setFontSize(i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004018));
            }
            BdToast b = BdToast.b(TbadkCoreApplication.getInst(), b());
            b.f(R.drawable.icon_word_t_size);
            b.d(0);
            b.q();
        }
    }
}
