package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.searchbox.live.nps.util.PluginUtils;
import com.baidu.searchbox.live.pluginmanager.MiniPluginManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yk8 implements AbConfigService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.live.interfaces.service.AbConfigService
    public Object getSwitch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AbConfigService
    public String getSwitch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public yk8() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.AbConfigService
    public boolean getSwitch(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if ("android_live_enable_nps_multi_plugin_online".equals(str)) {
                return true;
            }
            if ("android_live_enable_nps_multi_plugin".equals(str)) {
                if (PluginUtils.isLivenpsMatchMultiNps()) {
                    return true;
                }
                return false;
            } else if (!MiniPluginManager.LIVE_PRE_REQUEST_ENTER_SWITCH.equals(str) && !"android_live_media_pre_inflate_queue".equals(str) && !"live_android_mixview_pager".equals(str)) {
                return true;
            } else {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }
}
