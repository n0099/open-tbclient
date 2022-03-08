package com.baidu.tieba.myCollection.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaMGetLiveStatusHttpResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Long> closeLives;
    public long interval;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaMGetLiveStatusHttpResponseMessage(int i2) {
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
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (jSONObject == null) {
                return;
            }
            setError(jSONObject.optInt("error_code"));
            setErrorString(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG));
            if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("close_live");
                if (optJSONArray != null) {
                    if (this.closeLives == null) {
                        this.closeLives = new ArrayList();
                    }
                    this.closeLives.clear();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        if (optJSONArray.get(i3) instanceof Integer) {
                            this.closeLives.add(Long.valueOf(((Integer) optJSONArray.get(i3)).longValue()));
                        }
                    }
                }
                this.interval = jSONObject.optLong("interval");
            }
        }
    }

    public List<Long> getCloseLives() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.closeLives : (List) invokeV.objValue;
    }
}
