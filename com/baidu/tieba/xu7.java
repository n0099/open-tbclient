package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.mvc.data.INetRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.CommonReq;
import tbclient.VoiceRoomListPage.DataReq;
import tbclient.VoiceRoomListPage.VoiceRoomListPageReqIdl;
/* loaded from: classes8.dex */
public class xu7 implements INetRequestData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final long b;

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, String> getHttpHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public xu7(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j;
        this.b = j2;
    }

    public final double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        }
        return invokeV.doubleValue;
    }

    @Override // com.baidu.tbadk.mvc.data.ISocketProtobufRequestData
    public Object encodeSocketRequestData(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.call_from = Long.valueOf(this.a);
                builder.fid = Long.valueOf(this.b);
                CommonReq.Builder builder2 = new CommonReq.Builder();
                builder2.q_type = Integer.valueOf(b05.c().e());
                builder2.scr_dip = Double.valueOf(a());
                builder2.scr_h = Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp()));
                builder2.scr_w = Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp()));
                VoiceRoomListPageReqIdl.Builder builder3 = new VoiceRoomListPageReqIdl.Builder();
                builder3.data = builder.build(false);
                return builder3.build(false);
            } catch (Exception unused) {
                BdLog.d("data convert error");
                return null;
            }
        }
        return invokeZ.objValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, Object> makeHttpParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(IntentConfig.CALL_FROM, Long.valueOf(this.a));
            hashMap.put("fid", Long.valueOf(this.b));
            hashMap.put("q_type", Integer.valueOf(b05.c().e()));
            hashMap.put("scr_dip", Double.valueOf(a()));
            hashMap.put("scr_h", Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            hashMap.put("scr_w", Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
