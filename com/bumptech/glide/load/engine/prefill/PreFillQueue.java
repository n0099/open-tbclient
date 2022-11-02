package com.bumptech.glide.load.engine.prefill;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class PreFillQueue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<PreFillType, Integer> bitmapsPerType;
    public int bitmapsRemaining;
    public int keyIndex;
    public final List<PreFillType> keyList;

    public PreFillQueue(Map<PreFillType, Integer> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bitmapsPerType = map;
        this.keyList = new ArrayList(map.keySet());
        for (Integer num : map.values()) {
            this.bitmapsRemaining += num.intValue();
        }
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bitmapsRemaining;
        }
        return invokeV.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.bitmapsRemaining == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PreFillType remove() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PreFillType preFillType = this.keyList.get(this.keyIndex);
            Integer num = this.bitmapsPerType.get(preFillType);
            if (num.intValue() == 1) {
                this.bitmapsPerType.remove(preFillType);
                this.keyList.remove(this.keyIndex);
            } else {
                this.bitmapsPerType.put(preFillType, Integer.valueOf(num.intValue() - 1));
            }
            this.bitmapsRemaining--;
            if (this.keyList.isEmpty()) {
                size = 0;
            } else {
                size = (this.keyIndex + 1) % this.keyList.size();
            }
            this.keyIndex = size;
            return preFillType;
        }
        return (PreFillType) invokeV.objValue;
    }
}
