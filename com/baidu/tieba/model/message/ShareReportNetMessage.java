package com.baidu.tieba.model.message;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.b1.w;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.Share.DataReq;
import tbclient.Share.ShareReqIdl;
/* loaded from: classes7.dex */
public class ShareReportNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f54267common;
    public long fid;
    public int from;
    public long tid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareReportNetMessage() {
        super(CmdConfigHttp.CMD_SHARE_REPORT, 309480);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f79639common = getCommon();
            builder.fid = Long.valueOf(getFid());
            builder.tid = Long.valueOf(getTid());
            builder.from = Integer.valueOf(getFrom());
            if (z) {
                w.a(builder, true);
            }
            ShareReqIdl.Builder builder2 = new ShareReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public CommonReq getCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54267common : (CommonReq) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fid : invokeV.longValue;
    }

    public int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.from : invokeV.intValue;
    }

    public long getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tid : invokeV.longValue;
    }

    public void setCommon(CommonReq commonReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, commonReq) == null) {
            this.f54267common = commonReq;
        }
    }

    public void setFid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.fid = j2;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.from = i2;
        }
    }

    public void setTid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.tid = j2;
        }
    }
}
