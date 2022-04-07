package com.bumptech.glide.load.engine.bitmap_recycle;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PrettyPrintTreeMap() {
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

    @Override // java.util.AbstractMap
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("( ");
            for (Map.Entry<K, V> entry : entrySet()) {
                sb.append('{');
                sb.append(entry.getKey());
                sb.append(':');
                sb.append(entry.getValue());
                sb.append("}, ");
            }
            if (!isEmpty()) {
                sb.replace(sb.length() - 2, sb.length(), "");
            }
            sb.append(" )");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
