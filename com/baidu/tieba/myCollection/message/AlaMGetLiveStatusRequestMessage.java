package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class AlaMGetLiveStatusRequestMessage extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> mOriginDatas;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaMGetLiveStatusRequestMessage() {
        super(CmdConfigHttp.CMD_ALA_LIVE_ROOM_CLOSED);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOriginDatas = new ArrayList();
    }

    public List<Object> getOrignData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mOriginDatas : (List) invokeV.objValue;
    }

    public void setAudienceCount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            addParam("audience_count", j);
        }
    }

    public void setListIds(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            JsonArray jsonArray = new JsonArray();
            jsonArray.add((Number) 0L);
            for (Long l : list) {
                if (l != null) {
                    jsonArray.add(l);
                }
            }
            addParam("live_ids", jsonArray.toString());
        }
    }

    public void setOriginData(List<Object> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.mOriginDatas.clear();
        this.mOriginDatas.addAll(list);
    }
}
