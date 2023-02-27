package com.baidu.tieba.newfaceshop.message;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.r98;
import com.baidu.tieba.s98;
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
    public r98 mData;

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

    public r98 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mData;
        }
        return (r98) invokeV.objValue;
    }

    public r98 parseData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            r98 r98Var = new r98();
            String optString = jSONObject.optString("id");
            r98Var.a = optString;
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            r98Var.b = jSONObject.optString("name");
            jSONObject.optInt("type");
            jSONObject.optString("owner");
            jSONObject.optString(NotificationCompat.CarExtender.KEY_AUTHOR);
            jSONObject.optString("timestamp");
            jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            r98Var.c = jSONObject.optString("covername");
            r98Var.d = jSONObject.optString("url");
            r98Var.e = parsePicsData(jSONObject.optJSONArray(SocialConstants.PARAM_IMAGE));
            return r98Var;
        }
        return (r98) invokeL.objValue;
    }

    public List<s98> parsePicsData(JSONArray jSONArray) {
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
                    s98 s98Var = new s98();
                    s98Var.b = jSONObject.optString("id");
                    jSONObject.optString("url");
                    jSONObject.optString("thumbnail");
                    s98Var.c = jSONObject.optString("name");
                    s98Var.d = jSONObject.optString("thumbname");
                    s98Var.f = jSONObject.optInt("width");
                    s98Var.e = jSONObject.optInt("height");
                    arrayList.add(s98Var);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
