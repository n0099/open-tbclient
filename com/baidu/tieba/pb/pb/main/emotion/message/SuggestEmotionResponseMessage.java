package com.baidu.tieba.pb.pb.main.emotion.message;

import c.a.t0.s2.u.f.c1.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
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
/* loaded from: classes12.dex */
public class SuggestEmotionResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestEmotionResponseMessage(int i2) {
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

    private List<String> parseHotWordsData(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        arrayList.add(jSONArray.getJSONObject(i2).optString("keyword"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
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
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error != 0 || jSONObject == null || jSONObject == null) {
                return;
            }
            a aVar = new a();
            this.mData = aVar;
            aVar.d(parseImageData(jSONObject.optJSONArray("memes")));
            this.mData.e(parseHotWordsData(jSONObject.optJSONArray("topwords")));
            this.mData.f(parseSingleForumRecommend(jSONObject.optJSONObject("forum_pkg")));
        }
    }

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (a) invokeV.objValue;
    }
}
