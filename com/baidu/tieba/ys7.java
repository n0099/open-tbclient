package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailThemeData;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTails.ColorInfo;
import tbclient.GetTails.ResData;
import tbclient.GetTails.TailInfo;
/* loaded from: classes7.dex */
public class ys7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<TailData> a;
    public List<String> b;
    public SmallTailThemeData c;

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public ys7() {
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
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public SmallTailThemeData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (SmallTailThemeData) invokeV.objValue;
    }

    public List<TailData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public void d(ResData resData) {
        List<TailInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, resData) != null) || resData == null || (list = resData.tailList) == null) {
            return;
        }
        for (TailInfo tailInfo : list) {
            if (f(tailInfo)) {
                TailData tailData = new TailData();
                tailData.setContent(tailInfo.tailContent);
                tailData.setFontColor(tailInfo.fontColor);
                tailData.setFontType(tailInfo.fontKeyName);
                tailData.setId(tailInfo.tailId.intValue());
                boolean z = true;
                if (tailInfo.is_selected.intValue() != 1) {
                    z = false;
                }
                tailData.setSelected(z);
                c().add(tailData);
            }
        }
        e(resData.default_color);
        for (ColorInfo colorInfo : resData.colorList) {
            a().add(colorInfo.fontColor);
        }
        if (resData.tail_style != null) {
            this.c = new SmallTailThemeData(resData.tail_style);
        } else {
            this.c = SmallTailThemeData.DEFAULT;
        }
    }

    public final boolean f(TailInfo tailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tailInfo)) == null) {
            Integer num = tailInfo.tailId;
            if (num == null || num.intValue() == 0 || tailInfo.fontColor == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
