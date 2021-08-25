package com.baidu.tieba.pbextra.praise;

import c.a.q0.j2.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PraiseListResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mErrCode;
    public String mErrMsg;
    public int mTotalNum;
    public List<a> mZanItemDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PraiseListResponsedMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mErrCode = 0;
        this.mErrMsg = "";
        this.mTotalNum = 0;
        this.mZanItemDataList = null;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0) {
                this.mErrCode = jSONObject.optInt("error_code");
                this.mErrMsg = jSONObject.optString("error_msg");
                this.mTotalNum = jSONObject.optInt("num");
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                if (optJSONArray != null) {
                    this.mZanItemDataList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        this.mZanItemDataList.add(new a(jSONObject2.optString("id"), jSONObject2.optString("name"), jSONObject2.optString("portrait"), jSONObject2.optString("name_show"), 1000 * jSONObject2.optLong("zan_time")));
                    }
                }
            }
        }
    }

    public String getErrMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mErrMsg : (String) invokeV.objValue;
    }

    public int getErrNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mErrCode : invokeV.intValue;
    }

    public int getTotalNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTotalNum : invokeV.intValue;
    }

    public List<a> getmZanItemDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mZanItemDataList : (List) invokeV.objValue;
    }
}
