package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.ExcFrsPage.DataRes;
import tbclient.ExcFrsPage.ExcFrsPageResIdl;
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* loaded from: classes6.dex */
public class ru7 implements yk5, el5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public List<Object> b;

    @Override // com.baidu.tieba.zk5
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.el5
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.yk5
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public ru7() {
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

    @Override // com.baidu.tieba.yk5
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            try {
                initByProtobuf((ExcFrsPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcFrsPageResIdl.class));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.el5
    public void initByProtobuf(Message message) {
        ExcFrsPageResIdl excFrsPageResIdl;
        Error error;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, message) != null) || !(message instanceof ExcFrsPageResIdl) || (excFrsPageResIdl = (ExcFrsPageResIdl) message) == null || (error = excFrsPageResIdl.error) == null || error.errorno.intValue() != 0 || (dataRes = excFrsPageResIdl.data) == null) {
            return;
        }
        if (dataRes.thread_list != null) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.addAll(excFrsPageResIdl.data.thread_list);
        }
        excFrsPageResIdl.data.has_more.intValue();
        excFrsPageResIdl.data.pn.intValue();
        if (excFrsPageResIdl.data.tag_list != null) {
            this.b = new ArrayList();
            for (ExcellentTagInfo excellentTagInfo : excFrsPageResIdl.data.tag_list) {
                if (excellentTagInfo != null) {
                    this.b.add(excellentTagInfo);
                }
            }
        }
    }
}
