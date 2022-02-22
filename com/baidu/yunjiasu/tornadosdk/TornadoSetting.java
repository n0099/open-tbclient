package com.baidu.yunjiasu.tornadosdk;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 E2\u00020\u0001:\u0001EB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010@\u001a\u00020AH\u0016J\u0018\u0010B\u001a\u00020C2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010D\u001a\u00020AH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001a\u0010*\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u001a\u0010-\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR\"\u00100\u001a\b\u0012\u0004\u0012\u00020\u000701X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00107\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\"\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000701X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b;\u00103\"\u0004\b<\u00105R\"\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000701X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b>\u00103\"\u0004\b?\u00105¨\u0006F"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoSetting;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appPackageName", "", "getAppPackageName", "()Ljava/lang/String;", "setAppPackageName", "(Ljava/lang/String;)V", "authCUID", "getAuthCUID", "setAuthCUID", "authChannel", "getAuthChannel", "setAuthChannel", "authToken", "getAuthToken", "setAuthToken", "clientVersion", "getClientVersion", "setClientVersion", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "enableIPv6", "getEnableIPv6", "setEnableIPv6", "enablePingCMD", "getEnablePingCMD", "setEnablePingCMD", "gameID", "getGameID", "setGameID", "gameName", "getGameName", "setGameName", "gameRegion", "getGameRegion", "setGameRegion", "printLog", "getPrintLog", "setPrintLog", "sClientList", "", "getSClientList", "()[Ljava/lang/String;", "setSClientList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "vpnAllowedAllApp", "getVpnAllowedAllApp", "setVpnAllowedAllApp", "vpnAllowedPackages", "getVpnAllowedPackages", "setVpnAllowedPackages", "vpnDisallowedPackages", "getVpnDisallowedPackages", "setVpnDisallowedPackages", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TornadoSetting implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final CREATOR CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String appPackageName;
    public String authCUID;
    public String authChannel;
    public String authToken;
    public String clientVersion;
    public boolean debug;
    public boolean enableIPv6;
    public boolean enablePingCMD;
    public String gameID;
    public String gameName;
    public String gameRegion;
    public boolean printLog;
    public String[] sClientList;
    public boolean vpnAllowedAllApp;
    public String[] vpnAllowedPackages;
    public String[] vpnDisallowedPackages;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/yunjiasu/tornadosdk/TornadoSetting$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/baidu/yunjiasu/tornadosdk/TornadoSetting;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/baidu/yunjiasu/tornadosdk/TornadoSetting;", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CREATOR implements Parcelable.Creator<TornadoSetting> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public CREATOR() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TornadoSetting createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TornadoSetting(parcel);
            }
            return (TornadoSetting) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TornadoSetting[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new TornadoSetting[i2] : (TornadoSetting[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1101150213, "Lcom/baidu/yunjiasu/tornadosdk/TornadoSetting;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1101150213, "Lcom/baidu/yunjiasu/tornadosdk/TornadoSetting;");
                return;
            }
        }
        CREATOR = new CREATOR(null);
    }

    public TornadoSetting() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.appPackageName = "";
        this.printLog = true;
        this.clientVersion = "";
        this.authChannel = "";
        this.authToken = "";
        this.authCUID = "";
        this.gameID = "";
        this.gameName = "";
        this.gameRegion = "JP";
        this.vpnAllowedPackages = new String[0];
        this.vpnDisallowedPackages = new String[0];
        this.sClientList = new String[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appPackageName : (String) invokeV.objValue;
    }

    public final String getAuthCUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.authCUID : (String) invokeV.objValue;
    }

    public final String getAuthChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.authChannel : (String) invokeV.objValue;
    }

    public final String getAuthToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.authToken : (String) invokeV.objValue;
    }

    public final String getClientVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.clientVersion : (String) invokeV.objValue;
    }

    public final boolean getDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.debug : invokeV.booleanValue;
    }

    public final boolean getEnableIPv6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.enableIPv6 : invokeV.booleanValue;
    }

    public final boolean getEnablePingCMD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.enablePingCMD : invokeV.booleanValue;
    }

    public final String getGameID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.gameID : (String) invokeV.objValue;
    }

    public final String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.gameName : (String) invokeV.objValue;
    }

    public final String getGameRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.gameRegion : (String) invokeV.objValue;
    }

    public final boolean getPrintLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.printLog : invokeV.booleanValue;
    }

    public final String[] getSClientList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.sClientList : (String[]) invokeV.objValue;
    }

    public final boolean getVpnAllowedAllApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.vpnAllowedAllApp : invokeV.booleanValue;
    }

    public final String[] getVpnAllowedPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.vpnAllowedPackages : (String[]) invokeV.objValue;
    }

    public final String[] getVpnDisallowedPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.vpnDisallowedPackages : (String[]) invokeV.objValue;
    }

    public final void setAppPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appPackageName = str;
        }
    }

    public final void setAuthCUID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authCUID = str;
        }
    }

    public final void setAuthChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authChannel = str;
        }
    }

    public final void setAuthToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authToken = str;
        }
    }

    public final void setClientVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.clientVersion = str;
        }
    }

    public final void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.debug = z;
        }
    }

    public final void setEnableIPv6(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.enableIPv6 = z;
        }
    }

    public final void setEnablePingCMD(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.enablePingCMD = z;
        }
    }

    public final void setGameID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.gameID = str;
        }
    }

    public final void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.gameName = str;
        }
    }

    public final void setGameRegion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.gameRegion = str;
        }
    }

    public final void setPrintLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.printLog = z;
        }
    }

    public final void setSClientList(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, strArr) == null) {
            Intrinsics.checkNotNullParameter(strArr, "<set-?>");
            this.sClientList = strArr;
        }
    }

    public final void setVpnAllowedAllApp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.vpnAllowedAllApp = z;
        }
    }

    public final void setVpnAllowedPackages(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, strArr) == null) {
            Intrinsics.checkNotNullParameter(strArr, "<set-?>");
            this.vpnAllowedPackages = strArr;
        }
    }

    public final void setVpnDisallowedPackages(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, strArr) == null) {
            Intrinsics.checkNotNullParameter(strArr, "<set-?>");
            this.vpnDisallowedPackages = strArr;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048609, this, parcel, i2) == null) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.appPackageName);
            parcel.writeByte(this.printLog ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.debug ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.enablePingCMD ? (byte) 1 : (byte) 0);
            parcel.writeString(this.clientVersion);
            parcel.writeString(this.authChannel);
            parcel.writeString(this.authToken);
            parcel.writeString(this.authCUID);
            parcel.writeString(this.gameID);
            parcel.writeString(this.gameName);
            parcel.writeString(this.gameRegion);
            parcel.writeStringArray(this.vpnAllowedPackages);
            parcel.writeStringArray(this.vpnDisallowedPackages);
            parcel.writeByte(this.vpnAllowedAllApp ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.enableIPv6 ? (byte) 1 : (byte) 0);
            parcel.writeStringArray(this.sClientList);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TornadoSetting(Parcel parcel) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString()!!");
        this.appPackageName = readString;
        this.printLog = parcel.readByte() != 0;
        this.debug = parcel.readByte() != 0;
        this.enablePingCMD = parcel.readByte() != 0;
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        Intrinsics.checkNotNullExpressionValue(readString2, "parcel.readString()!!");
        this.clientVersion = readString2;
        String readString3 = parcel.readString();
        Intrinsics.checkNotNull(readString3);
        Intrinsics.checkNotNullExpressionValue(readString3, "parcel.readString()!!");
        this.authChannel = readString3;
        String readString4 = parcel.readString();
        Intrinsics.checkNotNull(readString4);
        Intrinsics.checkNotNullExpressionValue(readString4, "parcel.readString()!!");
        this.authToken = readString4;
        String readString5 = parcel.readString();
        Intrinsics.checkNotNull(readString5);
        Intrinsics.checkNotNullExpressionValue(readString5, "parcel.readString()!!");
        this.authCUID = readString5;
        String readString6 = parcel.readString();
        Intrinsics.checkNotNull(readString6);
        Intrinsics.checkNotNullExpressionValue(readString6, "parcel.readString()!!");
        this.gameID = readString6;
        String readString7 = parcel.readString();
        Intrinsics.checkNotNull(readString7);
        Intrinsics.checkNotNullExpressionValue(readString7, "parcel.readString()!!");
        this.gameName = readString7;
        String readString8 = parcel.readString();
        Intrinsics.checkNotNull(readString8);
        Intrinsics.checkNotNullExpressionValue(readString8, "parcel.readString()!!");
        this.gameRegion = readString8;
        String[] createStringArray = parcel.createStringArray();
        Intrinsics.checkNotNull(createStringArray);
        Intrinsics.checkNotNullExpressionValue(createStringArray, "parcel.createStringArray()!!");
        this.vpnAllowedPackages = createStringArray;
        String[] createStringArray2 = parcel.createStringArray();
        Intrinsics.checkNotNull(createStringArray2);
        Intrinsics.checkNotNullExpressionValue(createStringArray2, "parcel.createStringArray()!!");
        this.vpnDisallowedPackages = createStringArray2;
        this.vpnAllowedAllApp = parcel.readByte() != 0;
        this.enableIPv6 = parcel.readByte() != 0;
        String[] createStringArray3 = parcel.createStringArray();
        Intrinsics.checkNotNull(createStringArray3);
        Intrinsics.checkNotNullExpressionValue(createStringArray3, "parcel.createStringArray()!!");
        this.sClientList = createStringArray3;
    }
}
