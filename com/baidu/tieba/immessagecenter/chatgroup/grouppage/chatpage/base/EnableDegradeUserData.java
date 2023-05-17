package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData;", "Ljava/io/Serializable;", "type", "", "icon", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$IconData;", "text", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData;", "(ILcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$IconData;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData;)V", "getIcon", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$IconData;", "getText", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData;", "getType", "()I", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "IconData", "TextData", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EnableDegradeUserData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IconData icon;
    public final TextData text;
    public final int type;

    public static /* synthetic */ EnableDegradeUserData copy$default(EnableDegradeUserData enableDegradeUserData, int i, IconData iconData, TextData textData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = enableDegradeUserData.type;
        }
        if ((i2 & 2) != 0) {
            iconData = enableDegradeUserData.icon;
        }
        if ((i2 & 4) != 0) {
            textData = enableDegradeUserData.text;
        }
        return enableDegradeUserData.copy(i, iconData, textData);
    }

    public final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : invokeV.intValue;
    }

    public final IconData component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.icon : (IconData) invokeV.objValue;
    }

    public final TextData component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.text : (TextData) invokeV.objValue;
    }

    public final EnableDegradeUserData copy(int i, IconData iconData, TextData textData) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, iconData, textData)) == null) ? new EnableDegradeUserData(i, iconData, textData) : (EnableDegradeUserData) invokeILL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EnableDegradeUserData) {
                EnableDegradeUserData enableDegradeUserData = (EnableDegradeUserData) obj;
                return this.type == enableDegradeUserData.type && Intrinsics.areEqual(this.icon, enableDegradeUserData.icon) && Intrinsics.areEqual(this.text, enableDegradeUserData.text);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.type * 31;
            IconData iconData = this.icon;
            int hashCode = (i + (iconData == null ? 0 : iconData.hashCode())) * 31;
            TextData textData = this.text;
            return hashCode + (textData != null ? textData.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "EnableDegradeUserData(type=" + this.type + ", icon=" + this.icon + ", text=" + this.text + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u00017Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0098\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0005HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00068"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData;", "Ljava/io/Serializable;", "str", "", "priority", "", "schema", "degradeEnable", "degradeLength", "degradePriority", "suffix", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;", "backgroundAlpha", "corner", "textColor", "type", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;Ljava/lang/String;)V", "getBackgroundAlpha", "()Ljava/lang/String;", "getBackgroundColor", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;", "getCorner", "getDegradeEnable", "()I", "getDegradeLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDegradePriority", "getPriority", "getSchema", "getStr", "getSuffix", "getTextColor", "getType", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;Ljava/lang/String;)Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData;", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "ColorData", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class TextData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("bg_color_alpha")
        public final String backgroundAlpha;
        @SerializedName("bg_color")
        public final ColorData backgroundColor;
        public final String corner;
        @SerializedName("short_enable")
        public final int degradeEnable;
        @SerializedName("short_length")
        public final Integer degradeLength;
        @SerializedName("short_priority")
        public final Integer degradePriority;
        public final int priority;
        public final String schema;
        public final String str;
        public final String suffix;
        @SerializedName(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR)
        public final ColorData textColor;
        public final String type;

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.str : (String) invokeV.objValue;
        }

        public final String component10() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.corner : (String) invokeV.objValue;
        }

        public final ColorData component11() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.textColor : (ColorData) invokeV.objValue;
        }

        public final String component12() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.type : (String) invokeV.objValue;
        }

        public final int component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.priority : invokeV.intValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.schema : (String) invokeV.objValue;
        }

        public final int component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.degradeEnable : invokeV.intValue;
        }

        public final Integer component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.degradeLength : (Integer) invokeV.objValue;
        }

        public final Integer component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.degradePriority : (Integer) invokeV.objValue;
        }

        public final String component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.suffix : (String) invokeV.objValue;
        }

        public final ColorData component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.backgroundColor : (ColorData) invokeV.objValue;
        }

        public final String component9() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.backgroundAlpha : (String) invokeV.objValue;
        }

        public final TextData copy(String str, int i, String str2, int i2, Integer num, Integer num2, String str3, ColorData colorData, String str4, String str5, ColorData colorData2, String str6) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), num, num2, str3, colorData, str4, str5, colorData2, str6})) == null) {
                Intrinsics.checkNotNullParameter(str, "str");
                return new TextData(str, i, str2, i2, num, num2, str3, colorData, str4, str5, colorData2, str6);
            }
            return (TextData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TextData) {
                    TextData textData = (TextData) obj;
                    return Intrinsics.areEqual(this.str, textData.str) && this.priority == textData.priority && Intrinsics.areEqual(this.schema, textData.schema) && this.degradeEnable == textData.degradeEnable && Intrinsics.areEqual(this.degradeLength, textData.degradeLength) && Intrinsics.areEqual(this.degradePriority, textData.degradePriority) && Intrinsics.areEqual(this.suffix, textData.suffix) && Intrinsics.areEqual(this.backgroundColor, textData.backgroundColor) && Intrinsics.areEqual(this.backgroundAlpha, textData.backgroundAlpha) && Intrinsics.areEqual(this.corner, textData.corner) && Intrinsics.areEqual(this.textColor, textData.textColor) && Intrinsics.areEqual(this.type, textData.type);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                int hashCode = ((this.str.hashCode() * 31) + this.priority) * 31;
                String str = this.schema;
                int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.degradeEnable) * 31;
                Integer num = this.degradeLength;
                int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
                Integer num2 = this.degradePriority;
                int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
                String str2 = this.suffix;
                int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
                ColorData colorData = this.backgroundColor;
                int hashCode6 = (hashCode5 + (colorData == null ? 0 : colorData.hashCode())) * 31;
                String str3 = this.backgroundAlpha;
                int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.corner;
                int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
                ColorData colorData2 = this.textColor;
                int hashCode9 = (hashCode8 + (colorData2 == null ? 0 : colorData2.hashCode())) * 31;
                String str5 = this.type;
                return hashCode9 + (str5 != null ? str5.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return "TextData(str=" + this.str + ", priority=" + this.priority + ", schema=" + this.schema + ", degradeEnable=" + this.degradeEnable + ", degradeLength=" + this.degradeLength + ", degradePriority=" + this.degradePriority + ", suffix=" + this.suffix + ", backgroundColor=" + this.backgroundColor + ", backgroundAlpha=" + this.backgroundAlpha + ", corner=" + this.corner + ", textColor=" + this.textColor + ", type=" + this.type + ')';
            }
            return (String) invokeV.objValue;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;", "Ljava/io/Serializable;", "type", "", "day", "", "night", "(ILjava/lang/String;Ljava/lang/String;)V", "getDay", "()Ljava/lang/String;", "getNight", "getType", "()I", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class ColorData implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final String day;
            public final String night;
            public final int type;

            public static /* synthetic */ ColorData copy$default(ColorData colorData, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = colorData.type;
                }
                if ((i2 & 2) != 0) {
                    str = colorData.day;
                }
                if ((i2 & 4) != 0) {
                    str2 = colorData.night;
                }
                return colorData.copy(i, str, str2);
            }

            public final int component1() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : invokeV.intValue;
            }

            public final String component2() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.day : (String) invokeV.objValue;
            }

            public final String component3() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.night : (String) invokeV.objValue;
            }

            public final ColorData copy(int i, String day, String str) {
                InterceptResult invokeILL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, day, str)) == null) {
                    Intrinsics.checkNotNullParameter(day, "day");
                    return new ColorData(i, day, str);
                }
                return (ColorData) invokeILL.objValue;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof ColorData) {
                        ColorData colorData = (ColorData) obj;
                        return this.type == colorData.type && Intrinsics.areEqual(this.day, colorData.day) && Intrinsics.areEqual(this.night, colorData.night);
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    int hashCode = ((this.type * 31) + this.day.hashCode()) * 31;
                    String str = this.night;
                    return hashCode + (str == null ? 0 : str.hashCode());
                }
                return invokeV.intValue;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    return "ColorData(type=" + this.type + ", day=" + this.day + ", night=" + this.night + ')';
                }
                return (String) invokeV.objValue;
            }

            public ColorData(int i, String day, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i), day, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                Intrinsics.checkNotNullParameter(day, "day");
                this.type = i;
                this.day = day;
                this.night = str;
            }

            public final String getDay() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return this.day;
                }
                return (String) invokeV.objValue;
            }

            public final String getNight() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return this.night;
                }
                return (String) invokeV.objValue;
            }

            public final int getType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return this.type;
                }
                return invokeV.intValue;
            }
        }

        public TextData(String str, int i, String str2, int i2, Integer num, Integer num2, String str3, ColorData colorData, String str4, String str5, ColorData colorData2, String str6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2), num, num2, str3, colorData, str4, str5, colorData2, str6};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(str, "str");
            this.str = str;
            this.priority = i;
            this.schema = str2;
            this.degradeEnable = i2;
            this.degradeLength = num;
            this.degradePriority = num2;
            this.suffix = str3;
            this.backgroundColor = colorData;
            this.backgroundAlpha = str4;
            this.corner = str5;
            this.textColor = colorData2;
            this.type = str6;
        }

        public final String getBackgroundAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.backgroundAlpha;
            }
            return (String) invokeV.objValue;
        }

        public final ColorData getBackgroundColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.backgroundColor;
            }
            return (ColorData) invokeV.objValue;
        }

        public final String getCorner() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.corner;
            }
            return (String) invokeV.objValue;
        }

        public final int getDegradeEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.degradeEnable;
            }
            return invokeV.intValue;
        }

        public final Integer getDegradeLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.degradeLength;
            }
            return (Integer) invokeV.objValue;
        }

        public final Integer getDegradePriority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.degradePriority;
            }
            return (Integer) invokeV.objValue;
        }

        public final int getPriority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.priority;
            }
            return invokeV.intValue;
        }

        public final String getSchema() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.schema;
            }
            return (String) invokeV.objValue;
        }

        public final String getStr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.str;
            }
            return (String) invokeV.objValue;
        }

        public final String getSuffix() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.suffix;
            }
            return (String) invokeV.objValue;
        }

        public final ColorData getTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.textColor;
            }
            return (ColorData) invokeV.objValue;
        }

        public final String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.type;
            }
            return (String) invokeV.objValue;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$IconData;", "Ljava/io/Serializable;", "url", "", "schema", "width", "", "height", "priority", "type", "(Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", "getHeight", "()I", "getPriority", "getSchema", "()Ljava/lang/String;", "getType", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class IconData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int height;
        public final int priority;
        public final String schema;
        public final String type;
        public final String url;
        public final int width;

        public static /* synthetic */ IconData copy$default(IconData iconData, String str, String str2, int i, int i2, int i3, String str3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = iconData.url;
            }
            if ((i4 & 2) != 0) {
                str2 = iconData.schema;
            }
            String str4 = str2;
            if ((i4 & 4) != 0) {
                i = iconData.width;
            }
            int i5 = i;
            if ((i4 & 8) != 0) {
                i2 = iconData.height;
            }
            int i6 = i2;
            if ((i4 & 16) != 0) {
                i3 = iconData.priority;
            }
            int i7 = i3;
            if ((i4 & 32) != 0) {
                str3 = iconData.type;
            }
            return iconData.copy(str, str4, i5, i6, i7, str3);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.url : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.schema : (String) invokeV.objValue;
        }

        public final int component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.width : invokeV.intValue;
        }

        public final int component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.height : invokeV.intValue;
        }

        public final int component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.priority : invokeV.intValue;
        }

        public final String component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.type : (String) invokeV.objValue;
        }

        public final IconData copy(String url, String str, int i, int i2, int i3, String str2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{url, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new IconData(url, str, i, i2, i3, str2);
            }
            return (IconData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof IconData) {
                    IconData iconData = (IconData) obj;
                    return Intrinsics.areEqual(this.url, iconData.url) && Intrinsics.areEqual(this.schema, iconData.schema) && this.width == iconData.width && this.height == iconData.height && this.priority == iconData.priority && Intrinsics.areEqual(this.type, iconData.type);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                int hashCode = this.url.hashCode() * 31;
                String str = this.schema;
                int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.width) * 31) + this.height) * 31) + this.priority) * 31;
                String str2 = this.type;
                return hashCode2 + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return "IconData(url=" + this.url + ", schema=" + this.schema + ", width=" + this.width + ", height=" + this.height + ", priority=" + this.priority + ", type=" + this.type + ')';
            }
            return (String) invokeV.objValue;
        }

        public IconData(String url, String str, int i, int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {url, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.schema = str;
            this.width = i;
            this.height = i2;
            this.priority = i3;
            this.type = str2;
        }

        public final int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.height;
            }
            return invokeV.intValue;
        }

        public final int getPriority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.priority;
            }
            return invokeV.intValue;
        }

        public final String getSchema() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.schema;
            }
            return (String) invokeV.objValue;
        }

        public final String getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.type;
            }
            return (String) invokeV.objValue;
        }

        public final String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.url;
            }
            return (String) invokeV.objValue;
        }

        public final int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.width;
            }
            return invokeV.intValue;
        }
    }

    public EnableDegradeUserData(int i, IconData iconData, TextData textData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), iconData, textData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = i;
        this.icon = iconData;
        this.text = textData;
    }

    public final IconData getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.icon;
        }
        return (IconData) invokeV.objValue;
    }

    public final TextData getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.text;
        }
        return (TextData) invokeV.objValue;
    }

    public final int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }
}
