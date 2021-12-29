package com.baidu.tieba.videoplay.data;

import c.a.s0.s.q.d2;
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
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes12.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mUserData : (MetaData) invokeV.objValue;
    }

    public ArrayList<VideoItemData> getVideoItemDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mVideoItemDatas : (ArrayList) invokeV.objValue;
    }

    public void parseJson(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONArray, jSONObject) == null) || jSONArray == null || jSONObject == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.parseFeedJson(jSONArray.getString(i2), "");
            this.mVideoItemDatas.add(videoItemData);
        }
        this.mUserData.parserJson(jSONObject);
    }

    public void parseProto(List<ThreadInfo> list, User user) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, user) == null) || list == null || user == null) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            VideoItemData videoItemData = new VideoItemData();
            d2 d2Var = new d2();
            d2Var.c3(list.get(i2));
            videoItemData.parseProto(d2Var);
            this.mVideoItemDatas.add(videoItemData);
        }
        this.mUserData.parserProtobuf(user);
    }
}
