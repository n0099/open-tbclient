package com.baidu.tieba;

import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhKeyValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.bind.TypeAdapters;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Service
/* loaded from: classes7.dex */
public final class nk7 implements lu4.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.lu4.d
    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "frsPage.openNotification" : (String) invokeV.objValue;
    }

    public nk7() {
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

    @Override // com.baidu.tieba.lu4.c
    public void a(String data) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                JSONObject optJSONObject = new JSONObject(data).optJSONObject(GfhKeyValue.TYPE_DATE);
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("hour");
                    int optInt2 = optJSONObject.optInt(TypeAdapters.AnonymousClass27.MINUTE);
                    boolean z2 = false;
                    if (optInt >= 0 && optInt < 24) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (optInt2 >= 0 && optInt2 < 60) {
                            z2 = true;
                        }
                        if (z2) {
                            ia5.e().e0(optInt, optInt2);
                            if (!ia5.e().G()) {
                                ia5.e().d0(true);
                                DefaultLog.getInstance().i("OpenNotificationHybridNotify", "打开开关");
                            }
                            TbLog defaultLog = DefaultLog.getInstance();
                            defaultLog.i("OpenNotificationHybridNotify", "设置成功，时间 H：" + optInt + ", M：" + optInt2);
                            return;
                        }
                    }
                    TbLog defaultLog2 = DefaultLog.getInstance();
                    defaultLog2.i("OpenNotificationHybridNotify", "设置失败，时间 H：" + optInt + ", M：" + optInt2);
                }
            } catch (Exception e) {
                TbLog defaultLog3 = DefaultLog.getInstance();
                defaultLog3.i("OpenNotificationHybridNotify", "设置失败，异常：" + e.getMessage());
            }
        }
    }
}
