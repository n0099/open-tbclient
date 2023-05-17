package com.baidu.tieba.immessagecenter.chatgroup.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AtInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("at_all_msg_list")
    public List<AtInfoMsg> allMsgList;
    @SerializedName("at_all_msg_count")
    public int atAllMsgCount;
    @SerializedName("at_count_all")
    public int atCountAll;
    @SerializedName("at_single_msg_count")
    public int atSingleMsgCount;
    @SerializedName("at_single_msg_list")
    public List<AtInfoMsg> singleMsgList;

    public AtInfo() {
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

    public int getAllMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.atAllMsgCount;
        }
        return invokeV.intValue;
    }

    @Nullable
    public List<AtInfoMsg> getAllMsgList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.allMsgList;
        }
        return (List) invokeV.objValue;
    }

    public int getCountAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.atCountAll;
        }
        return invokeV.intValue;
    }

    public int getSingleMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.atSingleMsgCount;
        }
        return invokeV.intValue;
    }

    @Nullable
    public List<AtInfoMsg> getSingleMsgList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.singleMsgList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public static AtInfo parse(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            AtInfo atInfo = new AtInfo();
            atInfo.atCountAll = jSONObject.optInt("at_count_all");
            atInfo.atAllMsgCount = jSONObject.optInt("at_all_msg_count");
            atInfo.atSingleMsgCount = jSONObject.optInt("at_single_msg_count");
            JSONArray optJSONArray = jSONObject.optJSONArray("at_all_msg_list");
            if (optJSONArray != null) {
                atInfo.allMsgList = parseAtInfoMsg(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("at_single_msg_list");
            if (optJSONArray2 != null) {
                atInfo.singleMsgList = parseAtInfoMsg(optJSONArray2);
            }
            return atInfo;
        }
        return (AtInfo) invokeL.objValue;
    }

    @NonNull
    public static List<AtInfoMsg> parseAtInfoMsg(@NonNull JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    AtInfoMsg atInfoMsg = new AtInfoMsg();
                    atInfoMsg.parseJson(optJSONObject);
                    arrayList.add(atInfoMsg);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void setAllMsgList(List<AtInfoMsg> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.allMsgList = list;
        }
    }

    public void setAtAllMsgCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.atAllMsgCount = i;
        }
    }

    public void setAtCountAll(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.atCountAll = i;
        }
    }

    public void setAtSingleMsgCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.atSingleMsgCount = i;
        }
    }

    public void setSingleMsgList(List<AtInfoMsg> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.singleMsgList = list;
        }
    }
}
