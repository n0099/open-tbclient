package com.baidu.tieba;

import android.content.Intent;
import com.baidu.tbadk.mutiprocess.DataType;
import com.baidu.tbadk.mutiprocess.ParcelableEvent;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tbadk.mutiprocess.StickyEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-653878020, "Lcom/baidu/tieba/kp5$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-653878020, "Lcom/baidu/tieba/kp5$a;");
                    return;
                }
            }
            int[] iArr = new int[DataType.values().length];
            a = iArr;
            try {
                iArr[DataType.ORM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DataType.PARCELABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DataType.SERIALIZABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public kp5() {
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

    public bp5 a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            int intExtra = intent.getIntExtra("value_type", -1);
            if (intExtra < 0) {
                return null;
            }
            int i = a.a[DataType.values()[intExtra].ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return (SerializableEvent) intent.getSerializableExtra("value");
                }
                return (ParcelableEvent) intent.getParcelableExtra("value");
            }
            return (StickyEvent) intent.getSerializableExtra("value");
        }
        return (bp5) invokeL.objValue;
    }
}
