package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.StateInfo;
import tbclient.VirtualImageInfo;
/* loaded from: classes5.dex */
public class s28 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s28 e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public c25 b;
    public List<c25> c;
    public boolean d;

    public s28() {
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

    public static s28 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (s28.class) {
                    e = new s28();
                }
            }
            return e;
        }
        return (s28) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public void d(VirtualImageInfo virtualImageInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, virtualImageInfo) == null) || virtualImageInfo == null) {
            return;
        }
        this.a = virtualImageInfo.isset_virtual_image.intValue();
        String str = virtualImageInfo.virtual_image_url;
        virtualImageInfo.image_agree_count.intValue();
        virtualImageInfo.is_allow_agree.intValue();
        virtualImageInfo.virtual_background_type.intValue();
        String str2 = virtualImageInfo.virtual_background;
        virtualImageInfo.recent_incr_agree.intValue();
        virtualImageInfo.snapshoot_id.intValue();
        if (virtualImageInfo.personal_state != null) {
            c25 c25Var = new c25();
            this.b = c25Var;
            c25Var.d(virtualImageInfo.personal_state);
        }
        if (virtualImageInfo.state_list != null) {
            this.c = new ArrayList();
            for (int i = 0; i < virtualImageInfo.state_list.size(); i++) {
                StateInfo stateInfo = virtualImageInfo.state_list.get(i);
                if (stateInfo != null) {
                    c25 c25Var2 = new c25();
                    c25Var2.d(stateInfo);
                    this.c.add(c25Var2);
                }
            }
        }
        virtualImageInfo.allow_customize.intValue();
        this.d = true;
    }
}
