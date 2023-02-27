package com.baidu.tun2tornadolite.booster.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/data/HandShakePacketRequest;", "", "()V", "gameinfo", "Lcom/baidu/tun2tornadolite/booster/data/HandShakePacketRequest$GameInfo;", "getGameinfo", "()Lcom/baidu/tun2tornadolite/booster/data/HandShakePacketRequest$GameInfo;", "setGameinfo", "(Lcom/baidu/tun2tornadolite/booster/data/HandShakePacketRequest$GameInfo;)V", TableDefine.DB_TABLE_USERINFO, "Lcom/baidu/tun2tornadolite/booster/data/HandShakePacketRequest$UserInfo;", "getUserinfo", "()Lcom/baidu/tun2tornadolite/booster/data/HandShakePacketRequest$UserInfo;", "setUserinfo", "(Lcom/baidu/tun2tornadolite/booster/data/HandShakePacketRequest$UserInfo;)V", "GameInfo", "UserInfo", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HandShakePacketRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GameInfo gameinfo;
    public UserInfo userinfo;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/data/HandShakePacketRequest$GameInfo;", "", "()V", "game_id", "", "getGame_id", "()Ljava/lang/String;", "setGame_id", "(Ljava/lang/String;)V", "package_name", "getPackage_name", "setPackage_name", "region", "getRegion", "setRegion", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class GameInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String game_id;
        public String package_name;
        public String region;

        public GameInfo() {
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
            this.game_id = "";
            this.package_name = "";
            this.region = "";
        }

        public final String getGame_id() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.game_id;
            }
            return (String) invokeV.objValue;
        }

        public final String getPackage_name() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.package_name;
            }
            return (String) invokeV.objValue;
        }

        public final String getRegion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.region;
            }
            return (String) invokeV.objValue;
        }

        public final void setGame_id(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.game_id = str;
            }
        }

        public final void setPackage_name(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.package_name = str;
            }
        }

        public final void setRegion(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.region = str;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/data/HandShakePacketRequest$UserInfo;", "", "()V", "bduss", "", "getBduss", "()Ljava/lang/String;", "setBduss", "(Ljava/lang/String;)V", "channel", "getChannel", "setChannel", "client_ver", "getClient_ver", "setClient_ver", "cuid", "getCuid", "setCuid", Config.DEVICE_PART, "getDevice", "setDevice", "sys_ver", "getSys_ver", "setSys_ver", "token", "getToken", "setToken", "yjsid", "getYjsid", "setYjsid", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class UserInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bduss;
        public String channel;
        public String client_ver;
        public String cuid;
        public String device;
        public String sys_ver;
        public String token;
        public String yjsid;

        public UserInfo() {
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
            this.bduss = "";
            this.yjsid = "";
            this.token = "";
            this.device = "";
            this.cuid = "";
            this.channel = "";
            this.client_ver = "";
            this.sys_ver = "";
        }

        public final String getBduss() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.bduss;
            }
            return (String) invokeV.objValue;
        }

        public final String getChannel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.channel;
            }
            return (String) invokeV.objValue;
        }

        public final String getClient_ver() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.client_ver;
            }
            return (String) invokeV.objValue;
        }

        public final String getCuid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.cuid;
            }
            return (String) invokeV.objValue;
        }

        public final String getDevice() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.device;
            }
            return (String) invokeV.objValue;
        }

        public final String getSys_ver() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.sys_ver;
            }
            return (String) invokeV.objValue;
        }

        public final String getToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.token;
            }
            return (String) invokeV.objValue;
        }

        public final String getYjsid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.yjsid;
            }
            return (String) invokeV.objValue;
        }

        public final void setBduss(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.bduss = str;
            }
        }

        public final void setChannel(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.channel = str;
            }
        }

        public final void setClient_ver(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.client_ver = str;
            }
        }

        public final void setCuid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.cuid = str;
            }
        }

        public final void setDevice(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.device = str;
            }
        }

        public final void setSys_ver(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.sys_ver = str;
            }
        }

        public final void setToken(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.token = str;
            }
        }

        public final void setYjsid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.yjsid = str;
            }
        }
    }

    public HandShakePacketRequest() {
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

    public final GameInfo getGameinfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.gameinfo;
        }
        return (GameInfo) invokeV.objValue;
    }

    public final UserInfo getUserinfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.userinfo;
        }
        return (UserInfo) invokeV.objValue;
    }

    public final void setGameinfo(GameInfo gameInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gameInfo) == null) {
            this.gameinfo = gameInfo;
        }
    }

    public final void setUserinfo(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, userInfo) == null) {
            this.userinfo = userInfo;
        }
    }
}
