package com.baidu.tieba;

import android.content.Intent;
import com.baidu.tbadk.mutiprocess.DataType;
import com.baidu.tbadk.mutiprocess.ParcelableEvent;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tbadk.mutiprocess.StickyEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public lp5() {
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

    public void a(Intent intent, bp5 bp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, intent, bp5Var) == null) {
            if (bp5Var instanceof StickyEvent) {
                intent.putExtra("value_type", DataType.ORM.ordinal());
                intent.putExtra("value", (StickyEvent) bp5Var);
            } else if (bp5Var instanceof ParcelableEvent) {
                intent.putExtra("value_type", DataType.PARCELABLE.ordinal());
                intent.putExtra("value", (ParcelableEvent) bp5Var);
            } else if (bp5Var instanceof SerializableEvent) {
                intent.putExtra("value_type", DataType.SERIALIZABLE.ordinal());
                intent.putExtra("value", (SerializableEvent) bp5Var);
            }
        }
    }
}
