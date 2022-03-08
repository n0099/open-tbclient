package com.baidu.tieba.newfaceshop.message;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.t;
import c.a.q0.b0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetCloudFaceGroupMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<CollectEmotionData> mCollectEmotionList;
    public long mCollectUpdateTime;
    public List<String> mFaceGroupData;
    public long mFaceGroupUpdateTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCloudFaceGroupMessage(int i2) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                parseData(jSONObject.optJSONObject("data"));
            }
        }
    }

    public List<CollectEmotionData> getCollectEmotionList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCollectEmotionList : (List) invokeV.objValue;
    }

    public long getCollectUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCollectUpdateTime : invokeV.longValue;
    }

    public List<String> getFaceGroupData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFaceGroupData : (List) invokeV.objValue;
    }

    public long getFaceGroupUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFaceGroupUpdateTime : invokeV.longValue;
    }

    public void parseCollectData(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        this.mCollectEmotionList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject != null) {
                    CollectEmotionData collectEmotionData = new CollectEmotionData();
                    collectEmotionData.pid = jSONObject.optString(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY);
                    collectEmotionData.picUrl = jSONObject.optString("pic_url");
                    collectEmotionData.width = jSONObject.optInt("width");
                    collectEmotionData.height = jSONObject.optInt("height");
                    collectEmotionData.thumbnail = jSONObject.optString("thumbnail");
                    collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
                    collectEmotionData.pkgId = jSONObject.optString("pck_id");
                    StringBuilder sb = new StringBuilder(d.f12091f);
                    if (TextUtils.isEmpty(collectEmotionData.pkgId)) {
                        sb.append(collectEmotionData.pkgId);
                        sb.append(",");
                    } else {
                        sb.append(collectEmotionData.pkgId);
                        sb.append("_");
                        sb.append(collectEmotionData.pid);
                        sb.append(",");
                    }
                    sb.append(collectEmotionData.width);
                    sb.append(",");
                    sb.append(collectEmotionData.height);
                    sb.append(",");
                    String lowerCase = t.c(sb.toString().replace("collect_", "") + "7S6wbXjEKL9N").toLowerCase();
                    collectEmotionData.sharpText = SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX;
                    this.mCollectEmotionList.add(collectEmotionData);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void parseData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.mCollectUpdateTime = jSONObject.optLong("pic_update_time");
        if (c.a.r0.p2.d.k() < this.mCollectUpdateTime) {
            parseCollectData(jSONObject.optJSONArray("pic_ids"));
        }
        this.mFaceGroupUpdateTime = jSONObject.optLong("pkg_update_time");
        if (c.a.r0.p2.d.l() < this.mFaceGroupUpdateTime) {
            parseFaceGroupData(jSONObject.optString("package_ids"));
        }
    }

    public void parseFaceGroupData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mFaceGroupData = Arrays.asList(str.split("_"));
        }
    }

    public void setCollectEmotionList(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.mCollectEmotionList = list;
        }
    }

    public void setFaceGroupData(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.mFaceGroupData = list;
        }
    }
}
