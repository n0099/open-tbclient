package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013JP\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0006\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\b\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/UserIdentificationConf;", "Ljava/io/Serializable;", "resourceKey", "", "imageUrl", "content", "isMainStatus", "", "isShortShow", "showTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getContent", "()Ljava/lang/String;", "getImageUrl", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResourceKey", "getShowTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/UserIdentificationConf;", "equals", "", ImageViewerConfig.FROM_OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserIdentificationConf implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String content;
    @SerializedName("image_url")
    public final String imageUrl;
    @SerializedName("is_main_status")
    public final Integer isMainStatus;
    @SerializedName("is_short_show")
    public final Integer isShortShow;
    @SerializedName("resource_key")
    public final String resourceKey;
    @SerializedName("show_time")
    public final Long showTime;

    public static /* synthetic */ UserIdentificationConf copy$default(UserIdentificationConf userIdentificationConf, String str, String str2, String str3, Integer num, Integer num2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userIdentificationConf.resourceKey;
        }
        if ((i & 2) != 0) {
            str2 = userIdentificationConf.imageUrl;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = userIdentificationConf.content;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            num = userIdentificationConf.isMainStatus;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            num2 = userIdentificationConf.isShortShow;
        }
        Integer num4 = num2;
        if ((i & 32) != 0) {
            l = userIdentificationConf.showTime;
        }
        return userIdentificationConf.copy(str, str4, str5, num3, num4, l);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.resourceKey : (String) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.imageUrl : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.content : (String) invokeV.objValue;
    }

    public final Integer component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isMainStatus : (Integer) invokeV.objValue;
    }

    public final Integer component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isShortShow : (Integer) invokeV.objValue;
    }

    public final Long component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.showTime : (Long) invokeV.objValue;
    }

    public final UserIdentificationConf copy(String resourceKey, String imageUrl, String content, Integer num, Integer num2, Long l) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{resourceKey, imageUrl, content, num, num2, l})) == null) {
            Intrinsics.checkNotNullParameter(resourceKey, "resourceKey");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(content, "content");
            return new UserIdentificationConf(resourceKey, imageUrl, content, num, num2, l);
        }
        return (UserIdentificationConf) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UserIdentificationConf) {
                UserIdentificationConf userIdentificationConf = (UserIdentificationConf) obj;
                return Intrinsics.areEqual(this.resourceKey, userIdentificationConf.resourceKey) && Intrinsics.areEqual(this.imageUrl, userIdentificationConf.imageUrl) && Intrinsics.areEqual(this.content, userIdentificationConf.content) && Intrinsics.areEqual(this.isMainStatus, userIdentificationConf.isMainStatus) && Intrinsics.areEqual(this.isShortShow, userIdentificationConf.isShortShow) && Intrinsics.areEqual(this.showTime, userIdentificationConf.showTime);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int hashCode = ((((this.resourceKey.hashCode() * 31) + this.imageUrl.hashCode()) * 31) + this.content.hashCode()) * 31;
            Integer num = this.isMainStatus;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.isShortShow;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Long l = this.showTime;
            return hashCode3 + (l != null ? l.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "UserIdentificationConf(resourceKey=" + this.resourceKey + ", imageUrl=" + this.imageUrl + ", content=" + this.content + ", isMainStatus=" + this.isMainStatus + ", isShortShow=" + this.isShortShow + ", showTime=" + this.showTime + ')';
        }
        return (String) invokeV.objValue;
    }

    public UserIdentificationConf(String resourceKey, String imageUrl, String content, Integer num, Integer num2, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resourceKey, imageUrl, content, num, num2, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(resourceKey, "resourceKey");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(content, "content");
        this.resourceKey = resourceKey;
        this.imageUrl = imageUrl;
        this.content = content;
        this.isMainStatus = num;
        this.isShortShow = num2;
        this.showTime = l;
    }

    public final String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public final String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.imageUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getResourceKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.resourceKey;
        }
        return (String) invokeV.objValue;
    }

    public final Long getShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.showTime;
        }
        return (Long) invokeV.objValue;
    }

    public final Integer isMainStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.isMainStatus;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer isShortShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.isShortShow;
        }
        return (Integer) invokeV.objValue;
    }
}
