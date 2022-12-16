package com.baidu.tieba.related;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
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
public class GameRelatedForumsResMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHasMore;
    public List<SelectForumData> mSelectForumDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRelatedForumsResMsg(int i) {
        super(CmdConfigHttp.CMD_GAME_RELATED_FORUMS);
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

    private void parseForum(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    SelectForumData selectForumData = new SelectForumData();
                    selectForumData.forumId = optJSONObject.optString("id");
                    selectForumData.avatarUrl = optJSONObject.optString("avatar");
                    selectForumData.forumName = optJSONObject.optString("name");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("block_pop_info");
                    if (optJSONObject2 != null) {
                        boolean z = true;
                        if (optJSONObject2.optInt("can_post") != 1) {
                            z = false;
                        }
                        selectForumData.isCanPost = z;
                        selectForumData.blockInfo = optJSONObject2.optString("block_info");
                    }
                    this.mSelectForumDataList.add(selectForumData);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i, jSONObject) != null) || jSONObject == null || (optJSONArray = jSONObject.optJSONArray("forum_list")) == null) {
            return;
        }
        this.mSelectForumDataList = new ArrayList();
        parseForum(optJSONArray);
        int optInt = jSONObject.optInt("has_more");
        boolean z = true;
        if (optInt != 1) {
            z = false;
        }
        this.mHasMore = z;
    }

    public boolean getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mHasMore;
        }
        return invokeV.booleanValue;
    }

    public List<SelectForumData> getSelectForumDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mSelectForumDataList;
        }
        return (List) invokeV.objValue;
    }
}
