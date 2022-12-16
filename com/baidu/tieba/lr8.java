package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class lr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public String f;
    public String g;
    public List<FeedForumData> h;
    public List<zq8> i;
    public String j;
    public BlockPopInfoData k;
    public int l;
    public String m;

    public lr8() {
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
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.b = 0;
        this.c = 0;
        v("");
        x(0);
        t(0);
        w(0);
    }

    public BlockPopInfoData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (BlockPopInfoData) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public List<FeedForumData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public List<zq8> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.j = jSONObject.optString("block_dealurl");
        String optString = jSONObject.optString("block_content");
        if (!StringUtils.isNull(optString)) {
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            this.k = blockPopInfoData;
            blockPopInfoData.block_info = optString;
            blockPopInfoData.ahead_url = this.j;
            blockPopInfoData.ahead_info = jSONObject.optString("block_confirm");
            this.k.ok_info = jSONObject.optString("block_cancel");
        }
    }

    public void p(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONArray) == null) {
            this.i.clear();
            if (jSONArray != null && jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        zq8 a = zq8.a((JSONObject) jSONArray.opt(i));
                        if (a != null) {
                            this.i.add(a);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                r(jSONObject.optJSONObject("info"));
                o(jSONObject.optJSONArray("feed_forum"));
                p(jSONObject.optJSONArray("recom_forum"));
                this.l = jSONObject.optInt("error_code");
                this.m = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void o(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONArray) == null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                    FeedForumData feedForumData = new FeedForumData();
                    feedForumData.setForumId(jSONObject.optString("forum_id"));
                    feedForumData.setForumName(jSONObject.optString("forum_name"));
                    feedForumData.setMemberCount(jSONObject.optInt("member_count", 0));
                    feedForumData.setPostNum(jSONObject.optInt("post_num", 0));
                    feedForumData.setAvatar(jSONObject.optString("avatar"));
                    feedForumData.setReason(jSONObject.optString("reason"));
                    feedForumData.setIsLike(jSONObject.optInt("is_like", 0));
                    feedForumData.setPos(jSONObject.optInt("pos", 0));
                    this.h.add(feedForumData);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public void r(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.optInt("is_black", 0);
            this.b = jSONObject.optInt("like_num", 0);
            this.c = jSONObject.optInt("level_id", 0);
            jSONObject.optString("member_sum");
            x(jSONObject.optInt("is_like", 0));
            v(jSONObject.optString("level_name", ""));
            w(jSONObject.optInt("levelup_score", 0));
            t(jSONObject.optInt("cur_score", 0));
            n(jSONObject);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void s(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, blockPopInfoData) == null) {
            this.k = blockPopInfoData;
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.d = i;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f = str;
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.g = str;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.e = i;
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.a = i;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i) == null) && i >= 0) {
            this.c = i;
        }
    }
}
