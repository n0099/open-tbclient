package com.baidu.tieba.immessagecenter.msgtab.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabFunctionData;", "Ljava/io/Serializable;", "icon", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabImgData;", "title", "", "scheme", "(Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabImgData;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabImgData;", "getScheme", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabFunctionData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("img")
    public final MsgTabImgData icon;
    @SerializedName("scheme")
    public final String scheme;
    @SerializedName("name")
    public final String title;

    public static /* synthetic */ MsgTabFunctionData copy$default(MsgTabFunctionData msgTabFunctionData, MsgTabImgData msgTabImgData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            msgTabImgData = msgTabFunctionData.icon;
        }
        if ((i & 2) != 0) {
            str = msgTabFunctionData.title;
        }
        if ((i & 4) != 0) {
            str2 = msgTabFunctionData.scheme;
        }
        return msgTabFunctionData.copy(msgTabImgData, str, str2);
    }

    public final MsgTabImgData component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.icon : (MsgTabImgData) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.scheme : (String) invokeV.objValue;
    }

    public final MsgTabFunctionData copy(MsgTabImgData msgTabImgData, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, msgTabImgData, str, str2)) == null) ? new MsgTabFunctionData(msgTabImgData, str, str2) : (MsgTabFunctionData) invokeLLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "MsgTabFunctionData(icon=" + this.icon + ", title=" + this.title + ", scheme=" + this.scheme + ')';
        }
        return (String) invokeV.objValue;
    }

    public MsgTabFunctionData(MsgTabImgData msgTabImgData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgTabImgData, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.icon = msgTabImgData;
        this.title = str;
        this.scheme = str2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (!(obj instanceof MsgTabFunctionData)) {
                return false;
            }
            MsgTabFunctionData msgTabFunctionData = (MsgTabFunctionData) obj;
            if (!Intrinsics.areEqual(this.icon, msgTabFunctionData.icon) || !Intrinsics.areEqual(this.title, msgTabFunctionData.title) || !Intrinsics.areEqual(this.scheme, msgTabFunctionData.scheme)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final MsgTabImgData getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.icon;
        }
        return (MsgTabImgData) invokeV.objValue;
    }

    public final String getScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            MsgTabImgData msgTabImgData = this.icon;
            int i3 = 0;
            if (msgTabImgData != null) {
                i = msgTabImgData.hashCode();
            } else {
                i = 0;
            }
            int i4 = i * 31;
            String str = this.title;
            if (str != null) {
                i2 = str.hashCode();
            } else {
                i2 = 0;
            }
            int i5 = (i4 + i2) * 31;
            String str2 = this.scheme;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i5 + i3;
        }
        return invokeV.intValue;
    }
}
