package com.baidu.tieba.pb.pb.main.emotion.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import com.baidu.tieba.m08;
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
/* loaded from: classes5.dex */
public class SuggestEmotionResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m08 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestEmotionResponseMessage(int i) {
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

    private List<String> parseHotWordsData(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        arrayList.add(jSONArray.getJSONObject(i).optString("keyword"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private List<EmotionImageData> parseImageData(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int min = Math.min(jSONArray.length(), 10);
            for (int i = 0; i < min; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    EmotionImageData emotionImageData = new EmotionImageData();
                    emotionImageData.setPicId(jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY));
                    emotionImageData.setPicUrl(jSONObject.optString("pic_url"));
                    emotionImageData.setThumbUrl(jSONObject.optString("thumbnail"));
                    emotionImageData.setWidth(jSONObject.optInt("width"));
                    emotionImageData.setHeight(jSONObject.optInt("height"));
                    arrayList.add(emotionImageData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private SingleBarEmotionRecommendData parseSingleForumRecommend(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jSONObject)) == null) {
            if (jSONObject != null) {
                SingleBarEmotionRecommendData singleBarEmotionRecommendData = new SingleBarEmotionRecommendData();
                singleBarEmotionRecommendData.pkg_id = jSONObject.optString(IntentConfig.PKG_ID);
                singleBarEmotionRecommendData.cover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                return singleBarEmotionRecommendData;
            }
            return null;
        }
        return (SingleBarEmotionRecommendData) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error != 0 || jSONObject == null || jSONObject == null) {
                return;
            }
            m08 m08Var = new m08();
            this.mData = m08Var;
            m08Var.d(parseImageData(jSONObject.optJSONArray("memes")));
            this.mData.e(parseHotWordsData(jSONObject.optJSONArray("topwords")));
            this.mData.f(parseSingleForumRecommend(jSONObject.optJSONObject("forum_pkg")));
        }
    }

    public m08 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (m08) invokeV.objValue;
    }
}
