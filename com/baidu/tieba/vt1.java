package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vt1 implements fh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<String> a;

    @Override // com.baidu.tieba.fh4
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fh4
    public void b(Activity activity, lh4 lh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, lh4Var) == null) {
        }
    }

    @Override // com.baidu.tieba.fh4
    public void c(int i, List<lh4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, list) == null) {
        }
    }

    @Override // com.baidu.tieba.fh4
    public void d(int i, List<lh4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, list) == null) {
        }
    }

    @Override // com.baidu.tieba.fh4
    public void g(Activity activity, lh4 lh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, lh4Var) == null) {
        }
    }

    @Override // com.baidu.tieba.fh4
    public void h(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.fh4
    public boolean j(lh4 lh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lh4Var)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public vt1() {
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
        SparseArray<String> sparseArray = new SparseArray<>();
        this.a = sparseArray;
        sparseArray.put(38, DI.BD.FAVOR);
        if (!ku2.c0().a()) {
            this.a.put(35, "add to launch");
        }
        if (ku2.n().a().equals("vivobrowser")) {
            this.a.put(4, "share");
        }
    }

    @Override // com.baidu.tieba.fh4
    public void e(int i, List<lh4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, list) == null) {
            l(i, list);
        }
    }

    public final void l(int i, List<lh4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, list) == null) && !xo3.G() && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (lh4 lh4Var : list) {
                if (this.a.get(lh4Var.c()) != null) {
                    arrayList.add(lh4Var);
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
    }
}
