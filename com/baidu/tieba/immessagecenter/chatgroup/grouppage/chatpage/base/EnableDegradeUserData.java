package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData;", "Ljava/io/Serializable;", "type", "", "icon", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$IconData;", "text", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData;", "(ILcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$IconData;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData;)V", "getIcon", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$IconData;", "getText", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData;", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "", "IconData", "TextData", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
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

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u00011B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003Jy\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u00062"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData;", "Ljava/io/Serializable;", "str", "", "priority", "", "schema", "degradeEnable", "degradeLength", "degradePriority", "suffix", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;", "backgroundAlpha", "corner", "textColor", "(Ljava/lang/String;ILjava/lang/String;IIILjava/lang/String;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;)V", "getBackgroundAlpha", "()Ljava/lang/String;", "getBackgroundColor", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;", "getCorner", "getDegradeEnable", "()I", "getDegradeLength", "getDegradePriority", "getPriority", "getSchema", "getStr", "getSuffix", "getTextColor", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "ColorData", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
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
        public final int degradeLength;
        @SerializedName("short_priority")
        public final int degradePriority;
        public final int priority;
        public final String schema;
        public final String str;
        public final String suffix;
        @SerializedName(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR)
        public final ColorData textColor;

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

        public final int component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.priority : invokeV.intValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.schema : (String) invokeV.objValue;
        }

        public final int component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.degradeEnable : invokeV.intValue;
        }

        public final int component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.degradeLength : invokeV.intValue;
        }

        public final int component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.degradePriority : invokeV.intValue;
        }

        public final String component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.suffix : (String) invokeV.objValue;
        }

        public final ColorData component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.backgroundColor : (ColorData) invokeV.objValue;
        }

        public final String component9() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.backgroundAlpha : (String) invokeV.objValue;
        }

        public final TextData copy(String str, int i, String str2, int i2, int i3, int i4, String suffix, ColorData backgroundColor, String backgroundAlpha, String corner, ColorData textColor) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), suffix, backgroundColor, backgroundAlpha, corner, textColor})) == null) {
                Intrinsics.checkNotNullParameter(str, "str");
                Intrinsics.checkNotNullParameter(suffix, "suffix");
                Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
                Intrinsics.checkNotNullParameter(backgroundAlpha, "backgroundAlpha");
                Intrinsics.checkNotNullParameter(corner, "corner");
                Intrinsics.checkNotNullParameter(textColor, "textColor");
                return new TextData(str, i, str2, i2, i3, i4, suffix, backgroundColor, backgroundAlpha, corner, textColor);
            }
            return (TextData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TextData) {
                    TextData textData = (TextData) obj;
                    return Intrinsics.areEqual(this.str, textData.str) && this.priority == textData.priority && Intrinsics.areEqual(this.schema, textData.schema) && this.degradeEnable == textData.degradeEnable && this.degradeLength == textData.degradeLength && this.degradePriority == textData.degradePriority && Intrinsics.areEqual(this.suffix, textData.suffix) && Intrinsics.areEqual(this.backgroundColor, textData.backgroundColor) && Intrinsics.areEqual(this.backgroundAlpha, textData.backgroundAlpha) && Intrinsics.areEqual(this.corner, textData.corner) && Intrinsics.areEqual(this.textColor, textData.textColor);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                int hashCode = ((this.str.hashCode() * 31) + this.priority) * 31;
                String str = this.schema;
                return ((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.degradeEnable) * 31) + this.degradeLength) * 31) + this.degradePriority) * 31) + this.suffix.hashCode()) * 31) + this.backgroundColor.hashCode()) * 31) + this.backgroundAlpha.hashCode()) * 31) + this.corner.hashCode()) * 31) + this.textColor.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return "TextData(str=" + this.str + ", priority=" + this.priority + ", schema=" + this.schema + ", degradeEnable=" + this.degradeEnable + ", degradeLength=" + this.degradeLength + ", degradePriority=" + this.degradePriority + ", suffix=" + this.suffix + ", backgroundColor=" + this.backgroundColor + ", backgroundAlpha=" + this.backgroundAlpha + ", corner=" + this.corner + ", textColor=" + this.textColor + ')';
            }
            return (String) invokeV.objValue;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$TextData$ColorData;", "Ljava/io/Serializable;", "type", "", "day", "", LiveFeedPageSdk.UI_MODE_NIGHT, "(ILjava/lang/String;Ljava/lang/String;)V", "getDay", "()Ljava/lang/String;", "getNight", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
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

        public TextData(String str, int i, String str2, int i2, int i3, int i4, String suffix, ColorData backgroundColor, String backgroundAlpha, String corner, ColorData textColor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Integer.valueOf(i), str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), suffix, backgroundColor, backgroundAlpha, corner, textColor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(str, "str");
            Intrinsics.checkNotNullParameter(suffix, "suffix");
            Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
            Intrinsics.checkNotNullParameter(backgroundAlpha, "backgroundAlpha");
            Intrinsics.checkNotNullParameter(corner, "corner");
            Intrinsics.checkNotNullParameter(textColor, "textColor");
            this.str = str;
            this.priority = i;
            this.schema = str2;
            this.degradeEnable = i2;
            this.degradeLength = i3;
            this.degradePriority = i4;
            this.suffix = suffix;
            this.backgroundColor = backgroundColor;
            this.backgroundAlpha = backgroundAlpha;
            this.corner = corner;
            this.textColor = textColor;
        }

        public final String getBackgroundAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.backgroundAlpha;
            }
            return (String) invokeV.objValue;
        }

        public final ColorData getBackgroundColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.backgroundColor;
            }
            return (ColorData) invokeV.objValue;
        }

        public final String getCorner() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.corner;
            }
            return (String) invokeV.objValue;
        }

        public final int getDegradeEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.degradeEnable;
            }
            return invokeV.intValue;
        }

        public final int getDegradeLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.degradeLength;
            }
            return invokeV.intValue;
        }

        public final int getDegradePriority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.degradePriority;
            }
            return invokeV.intValue;
        }

        public final int getPriority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.priority;
            }
            return invokeV.intValue;
        }

        public final String getSchema() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.schema;
            }
            return (String) invokeV.objValue;
        }

        public final String getStr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.str;
            }
            return (String) invokeV.objValue;
        }

        public final String getSuffix() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.suffix;
            }
            return (String) invokeV.objValue;
        }

        public final ColorData getTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.textColor;
            }
            return (ColorData) invokeV.objValue;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/EnableDegradeUserData$IconData;", "Ljava/io/Serializable;", "url", "", "schema", "width", "", "height", "priority", "(Ljava/lang/String;Ljava/lang/String;III)V", "getHeight", "()I", "getPriority", "getSchema", "()Ljava/lang/String;", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class IconData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int height;
        public final int priority;
        public final String schema;
        public final String url;
        public final int width;

        public static /* synthetic */ IconData copy$default(IconData iconData, String str, String str2, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = iconData.url;
            }
            if ((i4 & 2) != 0) {
                str2 = iconData.schema;
            }
            String str3 = str2;
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
            return iconData.copy(str, str3, i5, i6, i3);
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

        public final IconData copy(String url, String str, int i, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{url, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new IconData(url, str, i, i2, i3);
            }
            return (IconData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof IconData) {
                    IconData iconData = (IconData) obj;
                    return Intrinsics.areEqual(this.url, iconData.url) && Intrinsics.areEqual(this.schema, iconData.schema) && this.width == iconData.width && this.height == iconData.height && this.priority == iconData.priority;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                int hashCode = this.url.hashCode() * 31;
                String str = this.schema;
                return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.width) * 31) + this.height) * 31) + this.priority;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return "IconData(url=" + this.url + ", schema=" + this.schema + ", width=" + this.width + ", height=" + this.height + ", priority=" + this.priority + ')';
            }
            return (String) invokeV.objValue;
        }

        public IconData(String url, String str, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {url, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
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
        }

        public final int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.height;
            }
            return invokeV.intValue;
        }

        public final int getPriority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.priority;
            }
            return invokeV.intValue;
        }

        public final String getSchema() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.schema;
            }
            return (String) invokeV.objValue;
        }

        public final String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.url;
            }
            return (String) invokeV.objValue;
        }

        public final int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
