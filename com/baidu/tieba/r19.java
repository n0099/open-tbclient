package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes7.dex */
public class r19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public boolean c;

    public r19() {
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

    public void a(ResponseTagInfo responseTagInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, responseTagInfo) != null) || responseTagInfo == null) {
            return;
        }
        this.a = responseTagInfo.tag_id.intValue();
        this.b = responseTagInfo.tag_name;
        boolean z = true;
        if (responseTagInfo.is_followed.intValue() != 1) {
            z = false;
        }
        this.c = z;
    }
}
