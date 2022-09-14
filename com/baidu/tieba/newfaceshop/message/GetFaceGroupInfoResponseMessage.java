package com.baidu.tieba.newfaceshop.message;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ar7;
import com.baidu.tieba.br7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetFaceGroupInfoResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ar7 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetFaceGroupInfoResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                this.mData = parseData(jSONObject);
            }
        }
    }

    public ar7 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (ar7) invokeV.objValue;
    }

    public ar7 parseData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ar7 ar7Var = new ar7();
            String optString = jSONObject.optString("id");
            ar7Var.a = optString;
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            ar7Var.b = jSONObject.optString("name");
            jSONObject.optInt("type");
            jSONObject.optString("owner");
            jSONObject.optString(NotificationCompat.CarExtender.KEY_AUTHOR);
            jSONObject.optString("timestamp");
            jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            ar7Var.c = jSONObject.optString("covername");
            ar7Var.d = jSONObject.optString("url");
            ar7Var.e = parsePicsData(jSONObject.optJSONArray(SocialConstants.PARAM_IMAGE));
            return ar7Var;
        }
        return (ar7) invokeL.objValue;
    }

    public List<br7> parsePicsData(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    br7 br7Var = new br7();
                    br7Var.b = jSONObject.optString("id");
                    jSONObject.optString("url");
                    jSONObject.optString("thumbnail");
                    br7Var.c = jSONObject.optString("name");
                    br7Var.d = jSONObject.optString("thumbname");
                    br7Var.f = jSONObject.optInt("width");
                    br7Var.e = jSONObject.optInt("height");
                    arrayList.add(br7Var);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
