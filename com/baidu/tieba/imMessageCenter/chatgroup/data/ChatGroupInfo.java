package com.baidu.tieba.imMessageCenter.chatgroup.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ChatGroupInfo extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5584248112830691490L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCollapsible;
    public String mGroupId;
    public List<ChatRoomInfo> mRoomInfoList;
    public String name;

    public ChatGroupInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mGroupId;
        }
        return (String) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public List<ChatRoomInfo> getRoomInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRoomInfoList;
        }
        return (List) invokeV.objValue;
    }

    public boolean isCollapsible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCollapsible;
        }
        return invokeV.booleanValue;
    }

    public void parse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.name = jSONObject.optString("group_name");
        this.mGroupId = jSONObject.optString("group_id");
        JSONArray optJSONArray = jSONObject.optJSONArray("room_list");
        if (optJSONArray != null) {
            this.mRoomInfoList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    ChatRoomInfo chatRoomInfo = new ChatRoomInfo();
                    chatRoomInfo.parse(optJSONObject);
                    this.mRoomInfoList.add(chatRoomInfo);
                }
            }
        }
    }

    public void setCollapsible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mCollapsible = z;
        }
    }
}
