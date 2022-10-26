package com.baidu.tieba.videoplay.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes6.dex */
public class VideoAttentionPersonListData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MetaData mUserData;
    public ArrayList mVideoItemDatas;

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
        this.mVideoItemDatas = new ArrayList();
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

    public ArrayList getVideoItemDatas() {
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

    public void parseProto(List list, User user) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, list, user) == null) && list != null && user != null) {
            for (int i = 0; i < list.size(); i++) {
                VideoItemData videoItemData = new VideoItemData();
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf((ThreadInfo) list.get(i));
                videoItemData.parseProto(threadData);
                this.mVideoItemDatas.add(videoItemData);
            }
            this.mUserData.parserProtobuf(user);
        }
    }
}
