package com.baidu.tieba.videoplay.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class VideoAttentionPersonListData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MetaData mUserData;
    public ArrayList<VideoItemData> mVideoItemDatas;

    public VideoAttentionPersonListData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVideoItemDatas = new ArrayList<>();
        this.mUserData = new MetaData();
    }

    public MetaData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mUserData;
        }
        return (MetaData) invokeV.objValue;
    }

    public ArrayList<VideoItemData> getVideoItemDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mVideoItemDatas;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void parseJson(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONArray, jSONObject) == null) && jSONArray != null && jSONObject != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                VideoItemData videoItemData = new VideoItemData();
                videoItemData.parseFeedJson(jSONArray.getString(i), "");
                this.mVideoItemDatas.add(videoItemData);
            }
            this.mUserData.parserJson(jSONObject);
        }
    }
}
