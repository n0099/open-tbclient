package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u0017J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo;", "Ljava/io/Serializable;", "id", "", "type", "imgInfo", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ImgInfo;", "endTime", "", "(IILcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ImgInfo;J)V", "getEndTime", "()J", "getId", "()I", "getImgInfo", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ImgInfo;", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "isExpired", "toString", "", "ImgInfo", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BubbleInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("end_time")
    public final long endTime;
    public final int id;
    @SerializedName("img_info")
    public final ImgInfo imgInfo;
    public final int type;

    public static /* synthetic */ BubbleInfo copy$default(BubbleInfo bubbleInfo, int i, int i2, ImgInfo imgInfo, long j, int i3, Object obj) {
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
            j = bubbleInfo.endTime;
        }
        return bubbleInfo.copy(i, i4, imgInfo2, j);
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

    public final long component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.endTime : invokeV.longValue;
    }

    public final BubbleInfo copy(int i, int i2, ImgInfo imgInfo, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), imgInfo, Long.valueOf(j)})) == null) {
            Intrinsics.checkNotNullParameter(imgInfo, "imgInfo");
            return new BubbleInfo(i, i2, imgInfo, j);
        }
        return (BubbleInfo) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BubbleInfo) {
                BubbleInfo bubbleInfo = (BubbleInfo) obj;
                return this.id == bubbleInfo.id && this.type == bubbleInfo.type && Intrinsics.areEqual(this.imgInfo, bubbleInfo.imgInfo) && this.endTime == bubbleInfo.endTime;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (((((this.id * 31) + this.type) * 31) + this.imgInfo.hashCode()) * 31) + a.a(this.endTime) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "BubbleInfo(id=" + this.id + ", type=" + this.type + ", imgInfo=" + this.imgInfo + ", endTime=" + this.endTime + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/BubbleInfo$ImgInfo;", "Ljava/io/Serializable;", "androidLeft", "", "androidRight", "iosLeft", "iosRight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAndroidLeft", "()Ljava/lang/String;", "getAndroidRight", "getIosLeft", "getIosRight", "component1", "component2", "component3", "component4", "copy", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ImgInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("android_left")
        public final String androidLeft;
        @SerializedName("android_right")
        public final String androidRight;
        @SerializedName("ios_left")
        public final String iosLeft;
        @SerializedName("ios_right")
        public final String iosRight;

        public static /* synthetic */ ImgInfo copy$default(ImgInfo imgInfo, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imgInfo.androidLeft;
            }
            if ((i & 2) != 0) {
                str2 = imgInfo.androidRight;
            }
            if ((i & 4) != 0) {
                str3 = imgInfo.iosLeft;
            }
            if ((i & 8) != 0) {
                str4 = imgInfo.iosRight;
            }
            return imgInfo.copy(str, str2, str3, str4);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.androidLeft : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.androidRight : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.iosLeft : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.iosRight : (String) invokeV.objValue;
        }

        public final ImgInfo copy(String androidLeft, String androidRight, String iosLeft, String iosRight) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, androidLeft, androidRight, iosLeft, iosRight)) == null) {
                Intrinsics.checkNotNullParameter(androidLeft, "androidLeft");
                Intrinsics.checkNotNullParameter(androidRight, "androidRight");
                Intrinsics.checkNotNullParameter(iosLeft, "iosLeft");
                Intrinsics.checkNotNullParameter(iosRight, "iosRight");
                return new ImgInfo(androidLeft, androidRight, iosLeft, iosRight);
            }
            return (ImgInfo) invokeLLLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ImgInfo) {
                    ImgInfo imgInfo = (ImgInfo) obj;
                    return Intrinsics.areEqual(this.androidLeft, imgInfo.androidLeft) && Intrinsics.areEqual(this.androidRight, imgInfo.androidRight) && Intrinsics.areEqual(this.iosLeft, imgInfo.iosLeft) && Intrinsics.areEqual(this.iosRight, imgInfo.iosRight);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (((((this.androidLeft.hashCode() * 31) + this.androidRight.hashCode()) * 31) + this.iosLeft.hashCode()) * 31) + this.iosRight.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "ImgInfo(androidLeft=" + this.androidLeft + ", androidRight=" + this.androidRight + ", iosLeft=" + this.iosLeft + ", iosRight=" + this.iosRight + ')';
            }
            return (String) invokeV.objValue;
        }

        public ImgInfo(String androidLeft, String androidRight, String iosLeft, String iosRight) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidLeft, androidRight, iosLeft, iosRight};
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
            Intrinsics.checkNotNullParameter(androidRight, "androidRight");
            Intrinsics.checkNotNullParameter(iosLeft, "iosLeft");
            Intrinsics.checkNotNullParameter(iosRight, "iosRight");
            this.androidLeft = androidLeft;
            this.androidRight = androidRight;
            this.iosLeft = iosLeft;
            this.iosRight = iosRight;
        }

        public final String getAndroidLeft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.androidLeft;
            }
            return (String) invokeV.objValue;
        }

        public final String getAndroidRight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.androidRight;
            }
            return (String) invokeV.objValue;
        }

        public final String getIosLeft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.iosLeft;
            }
            return (String) invokeV.objValue;
        }

        public final String getIosRight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.iosRight;
            }
            return (String) invokeV.objValue;
        }
    }

    public BubbleInfo(int i, int i2, ImgInfo imgInfo, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), imgInfo, Long.valueOf(j)};
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
        this.endTime = j;
    }

    public final long getEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.endTime;
        }
        return invokeV.longValue;
    }

    public final int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.id;
        }
        return invokeV.intValue;
    }

    public final ImgInfo getImgInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.imgInfo;
        }
        return (ImgInfo) invokeV.objValue;
    }

    public final int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public final boolean isExpired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.endTime == 0 || TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) <= this.endTime) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
