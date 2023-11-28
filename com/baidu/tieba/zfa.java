package com.baidu.tieba;

import com.baidu.tieba.pb.pb.push.PbReplyPushGuide;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class zfa implements mf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zfa() {
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

    @Override // com.baidu.tieba.mf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new j28());
            arrayList.add(new k28());
            arrayList.add(new l28());
            arrayList.add(new ri8());
            arrayList.add(new q69());
            arrayList.add(new r69());
            arrayList.add(new s69());
            arrayList.add(new t69());
            arrayList.add(new u69());
            arrayList.add(new v69());
            arrayList.add(new a5a());
            arrayList.add(new PbReplyPushGuide());
            arrayList.add(new b5a());
            arrayList.add(new c5a());
            arrayList.add(new glb());
            arrayList.add(new hlb());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
