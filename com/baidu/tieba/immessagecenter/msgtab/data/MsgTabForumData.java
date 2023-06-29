package com.baidu.tieba.immessagecenter.msgtab.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0007H\u0016J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000e\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabForumData;", "Ljava/io/Serializable;", "forumId", "", "forumName", "", "isAtMe", "", "hotNumsText", "icon", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getForumId", "()J", "getForumName", "()Ljava/lang/String;", "getHotNumsText", "setHotNumsText", "(Ljava/lang/String;)V", "getIcon", "setIcon", "()I", "setAtMe", "(I)V", "component1", "component2", "component3", "component4", "component5", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabForumData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("forum_id")
    public final long forumId;
    @SerializedName("forum_name")
    public final String forumName;
    @SerializedName("hot_num_value")
    public String hotNumsText;
    @SerializedName("avatar")
    public String icon;
    @SerializedName("is_at")
    public int isAtMe;

    public static /* synthetic */ MsgTabForumData copy$default(MsgTabForumData msgTabForumData, long j, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = msgTabForumData.forumId;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = msgTabForumData.forumName;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            i = msgTabForumData.isAtMe;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = msgTabForumData.hotNumsText;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = msgTabForumData.icon;
        }
        return msgTabForumData.copy(j2, str4, i3, str5, str3);
    }

    public final long component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.forumId : invokeV.longValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumName : (String) invokeV.objValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isAtMe : invokeV.intValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.hotNumsText : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.icon : (String) invokeV.objValue;
    }

    public final MsgTabForumData copy(long j, String forumName, int i, String str, String icon) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), forumName, Integer.valueOf(i), str, icon})) == null) {
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(icon, "icon");
            return new MsgTabForumData(j, forumName, i, str, icon);
        }
        return (MsgTabForumData) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "MsgTabForumData(forumId=" + this.forumId + ", forumName=" + this.forumName + ", isAtMe=" + this.isAtMe + ", hotNumsText=" + this.hotNumsText + ", icon=" + this.icon + ')';
        }
        return (String) invokeV.objValue;
    }

    public MsgTabForumData(long j, String forumName, int i, String str, String icon) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), forumName, Integer.valueOf(i), str, icon};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(forumName, "forumName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.forumId = j;
        this.forumName = forumName;
        this.isAtMe = i;
        this.hotNumsText = str;
        this.icon = icon;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MsgTabForumData(long j, String str, int i, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, r4, r5, r6);
        int i3;
        String str4;
        String str5;
        if ((i2 & 4) != 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if ((i2 & 8) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i2 & 16) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (!(obj instanceof MsgTabForumData)) {
                return false;
            }
            MsgTabForumData msgTabForumData = (MsgTabForumData) obj;
            if (this.forumId != msgTabForumData.forumId || !Intrinsics.areEqual(this.forumName, msgTabForumData.forumName) || this.isAtMe != msgTabForumData.isAtMe || !Intrinsics.areEqual(this.hotNumsText, msgTabForumData.hotNumsText) || !Intrinsics.areEqual(this.icon, msgTabForumData.icon)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.forumId;
        }
        return invokeV.longValue;
    }

    public final String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public final String getHotNumsText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.hotNumsText;
        }
        return (String) invokeV.objValue;
    }

    public final String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.icon;
        }
        return (String) invokeV.objValue;
    }

    public final int isAtMe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.isAtMe;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int a = ((((b.a(this.forumId) * 31) + this.forumName.hashCode()) * 31) + this.isAtMe) * 31;
            String str = this.hotNumsText;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            return ((a + i) * 31) + this.icon.hashCode();
        }
        return invokeV.intValue;
    }

    public final void setAtMe(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.isAtMe = i;
        }
    }

    public final void setHotNumsText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.hotNumsText = str;
        }
    }

    public final void setIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon = str;
        }
    }
}
