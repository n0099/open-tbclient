package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class l59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final EditorTools a;
    public final Map<Integer, n59> b;

    public l59(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap();
        this.a = editorTools;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Map.Entry<Integer, n59> entry : this.b.entrySet()) {
                this.a.setToolEnabled(entry.getValue().a(entry.getKey().intValue()), entry.getKey().intValue());
            }
        }
    }

    public void b(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) {
            for (int i : iArr) {
                if (this.b.containsKey(Integer.valueOf(i))) {
                    this.a.setToolEnabled(this.b.get(Integer.valueOf(i)).a(i), i);
                }
            }
        }
    }

    public void c(int i, @NonNull n59 n59Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, n59Var) == null) || this.b.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.b.put(Integer.valueOf(i), n59Var);
    }
}
