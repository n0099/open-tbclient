package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002'(B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003JI\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0006\u0010%\u001a\u00020!J\t\u0010&\u001a\u00020\nHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006)"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo;", "Ljava/io/Serializable;", "id", "", "type", "imgInfo", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ImgInfo;", "colorInfo", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ColorInfo;", "jumpUrl", "", "endTime", "", "(IILcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ImgInfo;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ColorInfo;Ljava/lang/String;J)V", "getColorInfo", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ColorInfo;", "getEndTime", "()J", "getId", "()I", "getImgInfo", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ImgInfo;", "getJumpUrl", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "isExpired", "toString", "ColorInfo", "ImgInfo", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BubbleInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("color_info")
    public final ColorInfo colorInfo;
    @SerializedName("end_time")
    public final long endTime;
    public final int id;
    @SerializedName("img_info")
    public final ImgInfo imgInfo;
    @SerializedName(BigdayActivityConfig.JUMP_URL)
    public final String jumpUrl;
    public final int type;

    public static /* synthetic */ BubbleInfo copy$default(BubbleInfo bubbleInfo, int i, int i2, ImgInfo imgInfo, ColorInfo colorInfo, String str, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bubbleInfo.id;
        }
        if ((i3 & 2) != 0) {
            i2 = bubbleInfo.type;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            imgInfo = bubbleInfo.imgInfo;
        }
        ImgInfo imgInfo2 = imgInfo;
        if ((i3 & 8) != 0) {
            colorInfo = bubbleInfo.colorInfo;
        }
        ColorInfo colorInfo2 = colorInfo;
        if ((i3 & 16) != 0) {
            str = bubbleInfo.jumpUrl;
        }
        String str2 = str;
        if ((i3 & 32) != 0) {
            j = bubbleInfo.endTime;
        }
        return bubbleInfo.copy(i, i4, imgInfo2, colorInfo2, str2, j);
    }

    public final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.intValue;
    }

    public final int component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type : invokeV.intValue;
    }

    public final ImgInfo component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.imgInfo : (ImgInfo) invokeV.objValue;
    }

    public final ColorInfo component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.colorInfo : (ColorInfo) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.jumpUrl : (String) invokeV.objValue;
    }

    public final long component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.endTime : invokeV.longValue;
    }

    public final BubbleInfo copy(int i, int i2, ImgInfo imgInfo, ColorInfo colorInfo, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), imgInfo, colorInfo, str, Long.valueOf(j)})) == null) {
            Intrinsics.checkNotNullParameter(imgInfo, "imgInfo");
            return new BubbleInfo(i, i2, imgInfo, colorInfo, str, j);
        }
        return (BubbleInfo) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BubbleInfo) {
                BubbleInfo bubbleInfo = (BubbleInfo) obj;
                return this.id == bubbleInfo.id && this.type == bubbleInfo.type && Intrinsics.areEqual(this.imgInfo, bubbleInfo.imgInfo) && Intrinsics.areEqual(this.colorInfo, bubbleInfo.colorInfo) && Intrinsics.areEqual(this.jumpUrl, bubbleInfo.jumpUrl) && this.endTime == bubbleInfo.endTime;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int hashCode = ((((this.id * 31) + this.type) * 31) + this.imgInfo.hashCode()) * 31;
            ColorInfo colorInfo = this.colorInfo;
            int hashCode2 = (hashCode + (colorInfo == null ? 0 : colorInfo.hashCode())) * 31;
            String str = this.jumpUrl;
            return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + a.a(this.endTime);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "BubbleInfo(id=" + this.id + ", type=" + this.type + ", imgInfo=" + this.imgInfo + ", colorInfo=" + this.colorInfo + ", jumpUrl=" + this.jumpUrl + ", endTime=" + this.endTime + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ColorInfo;", "Ljava/io/Serializable;", "textColor", "", "textColorDark", "(Ljava/lang/String;Ljava/lang/String;)V", "getTextColor", "()Ljava/lang/String;", "getTextColorDark", "component1", "component2", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ColorInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR)
        public final String textColor;
        @SerializedName("text_color_dark")
        public final String textColorDark;

        public static /* synthetic */ ColorInfo copy$default(ColorInfo colorInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = colorInfo.textColor;
            }
            if ((i & 2) != 0) {
                str2 = colorInfo.textColorDark;
            }
            return colorInfo.copy(str, str2);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.textColor : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.textColorDark : (String) invokeV.objValue;
        }

        public final ColorInfo copy(String textColor, String textColorDark) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textColor, textColorDark)) == null) {
                Intrinsics.checkNotNullParameter(textColor, "textColor");
                Intrinsics.checkNotNullParameter(textColorDark, "textColorDark");
                return new ColorInfo(textColor, textColorDark);
            }
            return (ColorInfo) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ColorInfo) {
                    ColorInfo colorInfo = (ColorInfo) obj;
                    return Intrinsics.areEqual(this.textColor, colorInfo.textColor) && Intrinsics.areEqual(this.textColorDark, colorInfo.textColorDark);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.textColor.hashCode() * 31) + this.textColorDark.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "ColorInfo(textColor=" + this.textColor + ", textColorDark=" + this.textColorDark + ')';
            }
            return (String) invokeV.objValue;
        }

        public ColorInfo(String textColor, String textColorDark) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textColor, textColorDark};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(textColor, "textColor");
            Intrinsics.checkNotNullParameter(textColorDark, "textColorDark");
            this.textColor = textColor;
            this.textColorDark = textColorDark;
        }

        public final String getTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.textColor;
            }
            return (String) invokeV.objValue;
        }

        public final String getTextColorDark() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.textColorDark;
            }
            return (String) invokeV.objValue;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006%"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ImgInfo;", "Ljava/io/Serializable;", "androidLeft", "", "androidLeftDark", "androidRight", "androidRightDark", "iosLeft", "iosLeftDark", "iosRight", "iosRightDark", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAndroidLeft", "()Ljava/lang/String;", "getAndroidLeftDark", "getAndroidRight", "getAndroidRightDark", "getIosLeft", "getIosLeftDark", "getIosRight", "getIosRightDark", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ImgInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("android_left")
        public final String androidLeft;
        @SerializedName("android_left_dark")
        public final String androidLeftDark;
        @SerializedName("android_right")
        public final String androidRight;
        @SerializedName("android_right_dark")
        public final String androidRightDark;
        @SerializedName("ios_left")
        public final String iosLeft;
        @SerializedName("ios_left_dark")
        public final String iosLeftDark;
        @SerializedName("ios_right")
        public final String iosRight;
        @SerializedName("ios_right_dark")
        public final String iosRightDark;

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.androidLeft : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.androidLeftDark : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.androidRight : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.androidRightDark : (String) invokeV.objValue;
        }

        public final String component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.iosLeft : (String) invokeV.objValue;
        }

        public final String component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.iosLeftDark : (String) invokeV.objValue;
        }

        public final String component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.iosRight : (String) invokeV.objValue;
        }

        public final String component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.iosRightDark : (String) invokeV.objValue;
        }

        public final ImgInfo copy(String androidLeft, String androidLeftDark, String androidRight, String androidRightDark, String iosLeft, String iosLeftDark, String iosRight, String iosRightDark) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{androidLeft, androidLeftDark, androidRight, androidRightDark, iosLeft, iosLeftDark, iosRight, iosRightDark})) == null) {
                Intrinsics.checkNotNullParameter(androidLeft, "androidLeft");
                Intrinsics.checkNotNullParameter(androidLeftDark, "androidLeftDark");
                Intrinsics.checkNotNullParameter(androidRight, "androidRight");
                Intrinsics.checkNotNullParameter(androidRightDark, "androidRightDark");
                Intrinsics.checkNotNullParameter(iosLeft, "iosLeft");
                Intrinsics.checkNotNullParameter(iosLeftDark, "iosLeftDark");
                Intrinsics.checkNotNullParameter(iosRight, "iosRight");
                Intrinsics.checkNotNullParameter(iosRightDark, "iosRightDark");
                return new ImgInfo(androidLeft, androidLeftDark, androidRight, androidRightDark, iosLeft, iosLeftDark, iosRight, iosRightDark);
            }
            return (ImgInfo) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ImgInfo) {
                    ImgInfo imgInfo = (ImgInfo) obj;
                    return Intrinsics.areEqual(this.androidLeft, imgInfo.androidLeft) && Intrinsics.areEqual(this.androidLeftDark, imgInfo.androidLeftDark) && Intrinsics.areEqual(this.androidRight, imgInfo.androidRight) && Intrinsics.areEqual(this.androidRightDark, imgInfo.androidRightDark) && Intrinsics.areEqual(this.iosLeft, imgInfo.iosLeft) && Intrinsics.areEqual(this.iosLeftDark, imgInfo.iosLeftDark) && Intrinsics.areEqual(this.iosRight, imgInfo.iosRight) && Intrinsics.areEqual(this.iosRightDark, imgInfo.iosRightDark);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (((((((((((((this.androidLeft.hashCode() * 31) + this.androidLeftDark.hashCode()) * 31) + this.androidRight.hashCode()) * 31) + this.androidRightDark.hashCode()) * 31) + this.iosLeft.hashCode()) * 31) + this.iosLeftDark.hashCode()) * 31) + this.iosRight.hashCode()) * 31) + this.iosRightDark.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return "ImgInfo(androidLeft=" + this.androidLeft + ", androidLeftDark=" + this.androidLeftDark + ", androidRight=" + this.androidRight + ", androidRightDark=" + this.androidRightDark + ", iosLeft=" + this.iosLeft + ", iosLeftDark=" + this.iosLeftDark + ", iosRight=" + this.iosRight + ", iosRightDark=" + this.iosRightDark + ')';
            }
            return (String) invokeV.objValue;
        }

        public ImgInfo(String androidLeft, String androidLeftDark, String androidRight, String androidRightDark, String iosLeft, String iosLeftDark, String iosRight, String iosRightDark) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidLeft, androidLeftDark, androidRight, androidRightDark, iosLeft, iosLeftDark, iosRight, iosRightDark};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(androidLeft, "androidLeft");
            Intrinsics.checkNotNullParameter(androidLeftDark, "androidLeftDark");
            Intrinsics.checkNotNullParameter(androidRight, "androidRight");
            Intrinsics.checkNotNullParameter(androidRightDark, "androidRightDark");
            Intrinsics.checkNotNullParameter(iosLeft, "iosLeft");
            Intrinsics.checkNotNullParameter(iosLeftDark, "iosLeftDark");
            Intrinsics.checkNotNullParameter(iosRight, "iosRight");
            Intrinsics.checkNotNullParameter(iosRightDark, "iosRightDark");
            this.androidLeft = androidLeft;
            this.androidLeftDark = androidLeftDark;
            this.androidRight = androidRight;
            this.androidRightDark = androidRightDark;
            this.iosLeft = iosLeft;
            this.iosLeftDark = iosLeftDark;
            this.iosRight = iosRight;
            this.iosRightDark = iosRightDark;
        }

        public final String getAndroidLeft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.androidLeft;
            }
            return (String) invokeV.objValue;
        }

        public final String getAndroidLeftDark() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.androidLeftDark;
            }
            return (String) invokeV.objValue;
        }

        public final String getAndroidRight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.androidRight;
            }
            return (String) invokeV.objValue;
        }

        public final String getAndroidRightDark() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.androidRightDark;
            }
            return (String) invokeV.objValue;
        }

        public final String getIosLeft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.iosLeft;
            }
            return (String) invokeV.objValue;
        }

        public final String getIosLeftDark() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.iosLeftDark;
            }
            return (String) invokeV.objValue;
        }

        public final String getIosRight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.iosRight;
            }
            return (String) invokeV.objValue;
        }

        public final String getIosRightDark() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.iosRightDark;
            }
            return (String) invokeV.objValue;
        }
    }

    public BubbleInfo(int i, int i2, ImgInfo imgInfo, ColorInfo colorInfo, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), imgInfo, colorInfo, str, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(imgInfo, "imgInfo");
        this.id = i;
        this.type = i2;
        this.imgInfo = imgInfo;
        this.colorInfo = colorInfo;
        this.jumpUrl = str;
        this.endTime = j;
    }

    public final ColorInfo getColorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.colorInfo;
        }
        return (ColorInfo) invokeV.objValue;
    }

    public final long getEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.endTime;
        }
        return invokeV.longValue;
    }

    public final int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.id;
        }
        return invokeV.intValue;
    }

    public final ImgInfo getImgInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.imgInfo;
        }
        return (ImgInfo) invokeV.objValue;
    }

    public final String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.jumpUrl;
        }
        return (String) invokeV.objValue;
    }

    public final int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public final boolean isExpired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.endTime == 0 || TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) <= this.endTime) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
