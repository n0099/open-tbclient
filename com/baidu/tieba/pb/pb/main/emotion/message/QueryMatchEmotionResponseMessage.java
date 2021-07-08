package com.baidu.tieba.pb.pb.main.emotion.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class QueryMatchEmotionResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<EmotionImageData> mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryMatchEmotionResponseMessage(int i2) {
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

    private List<EmotionImageData> parseImageData(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int min = Math.min(jSONArray.length(), 10);
            for (int i2 = 0; i2 < min; i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    EmotionImageData emotionImageData = new EmotionImageData();
                    emotionImageData.setPicId(jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY));
                    emotionImageData.setPicUrl(jSONObject.optString("pic_url"));
                    emotionImageData.setThumbUrl(jSONObject.optString("thumbnail"));
                    emotionImageData.setWidth(jSONObject.optInt("width"));
                    emotionImageData.setHeight(jSONObject.optInt("height"));
                    emotionImageData.setMemeContSign(jSONObject.optString("cont_sign"));
                    arrayList.add(emotionImageData);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error != 0 || jSONObject == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            this.mData = parseImageData(optJSONObject.optJSONArray("memes"));
        }
    }

    public List<EmotionImageData> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (List) invokeV.objValue;
    }
}
