package com.baidu.tieba.memberCenter.bubble;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
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
/* loaded from: classes5.dex */
public class BubbleListData extends OrmObject implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4612117445868668894L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<BubbleData> b_info;
    public String error_code;
    public String error_msg;

    /* loaded from: classes5.dex */
    public static class BubbleData extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1540726255641451917L;
        public transient /* synthetic */ FieldHolder $fh;
        public String b_url;
        public int bcode;
        public String bg_url;
        public String bname;
        public int can_use;
        public String dynamic_url;
        public String dynamic_url_small;
        public String icon_url;
        public int is_def;
        public int is_free;
        public String level_name;
        public int time_interval;

        public String getDynamicUrlSmall() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "" : (String) invokeV.objValue;
        }

        public BubbleData() {
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

        public boolean canUse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.can_use == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public String getB_url() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b_url;
            }
            return (String) invokeV.objValue;
        }

        public int getBcode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.bcode;
            }
            return invokeV.intValue;
        }

        public String getBg_url() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.bg_url;
            }
            return (String) invokeV.objValue;
        }

        public String getBname() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.bname;
            }
            return (String) invokeV.objValue;
        }

        public int getCan_use() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.can_use;
            }
            return invokeV.intValue;
        }

        public String getDynamicUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.dynamic_url;
            }
            return (String) invokeV.objValue;
        }

        public String getIcon_url() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.icon_url;
            }
            return (String) invokeV.objValue;
        }

        public int getIs_def() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.is_def;
            }
            return invokeV.intValue;
        }

        public int getIs_free() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.is_free;
            }
            return invokeV.intValue;
        }

        public String getLevel_name() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.level_name;
            }
            return (String) invokeV.objValue;
        }

        public int getTime_interval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.time_interval;
            }
            return invokeV.intValue;
        }

        public boolean isDef() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (this.is_def == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isFree() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.is_free == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static BubbleData parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                BubbleData bubbleData = new BubbleData();
                bubbleData.bcode = jSONObject.optInt("bcode");
                bubbleData.bname = jSONObject.optString("bname");
                bubbleData.b_url = jSONObject.optString("b_url");
                bubbleData.bg_url = jSONObject.optString("bg_url");
                bubbleData.dynamic_url = jSONObject.optString("dynamic_url");
                bubbleData.dynamic_url_small = jSONObject.optString("dynamic_url_small");
                bubbleData.icon_url = jSONObject.optString("icon_url");
                bubbleData.can_use = jSONObject.optInt("can_use");
                bubbleData.is_def = jSONObject.optInt("is_def");
                bubbleData.is_free = jSONObject.optInt("is_free");
                bubbleData.level_name = jSONObject.optString("level_name");
                bubbleData.time_interval = jSONObject.optInt("time_interval");
                return bubbleData;
            }
            return (BubbleData) invokeL.objValue;
        }

        public void setBcode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
                this.bcode = i;
            }
        }

        public void setCan_use(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
                this.can_use = i;
            }
        }

        public void setIs_def(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
                this.is_def = i;
            }
        }
    }

    public BubbleListData() {
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
        this.b_info = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public BubbleListData m59clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                Object clone = super.clone();
                if (clone instanceof BubbleListData) {
                    return (BubbleListData) clone;
                }
                return this;
            } catch (Exception e) {
                e.printStackTrace();
                return this;
            }
        }
        return (BubbleListData) invokeV.objValue;
    }

    public List<BubbleData> getB_info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b_info;
        }
        return (List) invokeV.objValue;
    }

    public String getError_code() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.error_code;
        }
        return (String) invokeV.objValue;
    }

    public String getError_msg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.error_msg;
        }
        return (String) invokeV.objValue;
    }

    public static BubbleListData parse(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            BubbleListData bubbleListData = new BubbleListData();
            bubbleListData.error_code = jSONObject.optString("error_code");
            bubbleListData.error_msg = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            JSONArray optJSONArray = jSONObject.optJSONArray("b_info");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        BubbleData parse = BubbleData.parse(optJSONArray.getJSONObject(i));
                        if (parse != null) {
                            bubbleListData.b_info.add(parse);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return bubbleListData;
        }
        return (BubbleListData) invokeL.objValue;
    }
}
