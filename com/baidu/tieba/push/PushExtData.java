package com.baidu.tieba.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PushExtData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String feedId;
    public String gameId;
    public String gameName;
    public String gender;
    public boolean isYyGame;
    public Long liveId;
    public String mIconUrl;
    public String mRankShow;
    public String mSid;
    public String mSsid;
    public String mTemplateId;
    public String mYyUid;
    public String orderId;
    public String roomId;
    public String source;
    public String streamInfo;
    public String teamId;
    public int type;
    public String uri;
    public String uriReject;
    public String userId;

    public PushExtData() {
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

    public String getFeedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.feedId;
        }
        return (String) invokeV.objValue;
    }

    public String getGameId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.gameId;
        }
        return (String) invokeV.objValue;
    }

    public String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.gameName;
        }
        return (String) invokeV.objValue;
    }

    public String getGender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.gender;
        }
        return (String) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mIconUrl;
        }
        return (String) invokeV.objValue;
    }

    public boolean getIsYyGame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.isYyGame;
        }
        return invokeV.booleanValue;
    }

    public Long getLiveId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.liveId;
        }
        return (Long) invokeV.objValue;
    }

    public String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.orderId;
        }
        return (String) invokeV.objValue;
    }

    public String getRankShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mRankShow;
        }
        return (String) invokeV.objValue;
    }

    public String getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.roomId;
        }
        return (String) invokeV.objValue;
    }

    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mSid;
        }
        return (String) invokeV.objValue;
    }

    public String getSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.source;
        }
        return (String) invokeV.objValue;
    }

    public String getSsid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mSsid;
        }
        return (String) invokeV.objValue;
    }

    public String getStreamInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.streamInfo;
        }
        return (String) invokeV.objValue;
    }

    public String getTeamId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.teamId;
        }
        return (String) invokeV.objValue;
    }

    public String getTemplateId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mTemplateId;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public String getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.uri;
        }
        return (String) invokeV.objValue;
    }

    public String getUriReject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.uriReject;
        }
        return (String) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.userId;
        }
        return (String) invokeV.objValue;
    }

    public String getYyUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mYyUid;
        }
        return (String) invokeV.objValue;
    }

    public void parseExtData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jSONObject) == null) && jSONObject != null) {
            this.gameId = jSONObject.optString("game_id");
            this.gameName = jSONObject.optString("game_name");
            this.userId = jSONObject.optString("user_id");
            this.orderId = jSONObject.optString("order_id");
            this.gender = jSONObject.optString("gender");
            this.teamId = jSONObject.optString("team_id");
            this.type = jSONObject.optInt("type");
            this.uri = jSONObject.optString("uri");
            this.uriReject = jSONObject.optString("uri_reject");
            this.source = jSONObject.optString("source");
            JSONObject optJSONObject = jSONObject.optJSONObject("yy_ext");
            if (optJSONObject != null) {
                this.mSid = optJSONObject.optString("sid");
                this.mSsid = optJSONObject.optString(YyLiveRoomConfig.KEY_SSID);
                this.mTemplateId = optJSONObject.optString("template_id");
                this.mYyUid = optJSONObject.optString("yy_uid");
                boolean z = true;
                if (optJSONObject.optInt("is_yy_game") != 1) {
                    z = false;
                }
                this.isYyGame = z;
                this.mRankShow = optJSONObject.optString("rank_show");
                this.mIconUrl = optJSONObject.optString("icon_url");
                this.streamInfo = optJSONObject.optString("stream_info");
                this.feedId = optJSONObject.optString("feed_id");
            }
            this.liveId = Long.valueOf(jSONObject.optLong("live_id"));
            this.roomId = jSONObject.optString("room_id");
        }
    }

    public void setGameId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.gameId = str;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.gameName = str;
        }
    }

    public void setGender(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.gender = str;
        }
    }

    public void setOrderId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.orderId = str;
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.source = str;
        }
    }

    public void setTeamId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.teamId = str;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.type = i;
        }
    }

    public void setUri(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.uri = str;
        }
    }

    public void setUriReject(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.uriReject = str;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.userId = str;
        }
    }
}
