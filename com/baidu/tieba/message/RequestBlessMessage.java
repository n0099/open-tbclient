package com.baidu.tieba.message;

import c.a.q0.d1.a0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.UserPk.DataReq;
import tbclient.UserPk.UserPkReqIdl;
/* loaded from: classes7.dex */
public class RequestBlessMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int click_type;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f54502common;
    public Long pk_id;
    public int pk_index;
    public int pk_type;
    public Long topic_id;
    public long user_pk_id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestBlessMessage() {
        super(CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
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
            builder.f80230common = this.f54502common;
            builder.pk_id = this.pk_id;
            builder.topic_id = this.topic_id;
            builder.pk_index = Integer.valueOf(this.pk_index);
            builder.click_type = Integer.valueOf(this.click_type);
            builder.pk_type = Integer.valueOf(this.pk_type);
            builder.user_pk_id = Long.valueOf(this.user_pk_id);
            if (z) {
                a0.a(builder, true);
            }
            UserPkReqIdl.Builder builder2 = new UserPkReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setClickType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.click_type = i2;
        }
    }

    public void setCommon(CommonReq commonReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, commonReq) == null) {
            this.f54502common = commonReq;
        }
    }

    public void setPkId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l) == null) {
            this.pk_id = l;
        }
    }

    public void setPkIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.pk_index = i2;
        }
    }

    public void setPkType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.pk_type = i2;
        }
    }

    public void setTopicId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, l) == null) {
            this.topic_id = l;
        }
    }

    public void setUserPkId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.user_pk_id = j2;
        }
    }
}
