package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.qab;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.SampleResult;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class p46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;

    public final String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i == 2) {
                return PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK;
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public final String f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i == 1) {
                return "key_card_show_type";
            }
            if (i == 2) {
                return "key_card_abstract_switch";
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public p46() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        i();
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a = SharedPrefHelper.getInstance().getInt("key_abtest_channel", 0);
            j();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.b && this.a == 1) {
            boolean h = h();
            this.b = h;
            if (!h) {
                this.a = 0;
            }
        }
    }

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == 1) {
                return d(i);
            }
            int i2 = this.a;
            if (i2 == 1) {
                return c(i);
            }
            if (i2 == 0) {
                return d(i);
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            String f = f(i);
            if (di.isEmpty(f) || SharedPrefHelper.getInstance().getInt(f, 0) != 1) {
                return 0;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i != 1 && i != 0) {
                return;
            }
            this.a = i;
            SharedPrefHelper.getInstance().putInt("key_abtest_channel", this.a);
            j();
        }
    }

    public void b(ArrayList<Integer> arrayList, o46 o46Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, o46Var) == null) && arrayList != null && o46Var != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                o46Var.b(intValue, a(intValue));
            }
        }
    }

    public final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            String e = e(i);
            if (di.isEmpty(e)) {
                return 0;
            }
            SampleResult a = pab.a(e);
            if (a != SampleResult.T1 && a != SampleResult.T2 && a != SampleResult.T3 && a != SampleResult.T4 && a != SampleResult.T5) {
                return 0;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return false;
            }
            try {
                qab.a aVar = new qab.a();
                aVar.e(TbadkCoreApplication.getInst());
                aVar.j(false);
                aVar.n(30L);
                aVar.m(1);
                aVar.l(false);
                aVar.o(15L);
                aVar.k(1000);
                pab.b(aVar.c());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
