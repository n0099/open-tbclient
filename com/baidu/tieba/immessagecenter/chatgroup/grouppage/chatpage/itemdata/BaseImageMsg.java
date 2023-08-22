package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.cw5;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public abstract class BaseImageMsg<SdkMsg extends com.baidu.android.imsdk.chatmessage.messages.ImageMsg> extends BaseChatMsg<SdkMsg> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @cw5(serialize = false)
    public final String IMG_THUMBNAIL_TEXT;
    @SerializedName("big_size")
    public String bigSize;
    @SerializedName("big_src")
    @cw5(serialize = false)
    public String bigSrc;
    @SerializedName("bsize")
    public String thumbSize;
    @SerializedName("src")
    @cw5(serialize = false)
    public String thumbUrl;

    public abstract SdkMsg createSdkMsgByChildClass();

    public abstract void fromSdkMsgToChildClass(@NonNull SdkMsg sdkmsg);

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.bn
    public abstract /* synthetic */ BdUniqueId getType();

    public BaseImageMsg() {
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
        this.IMG_THUMBNAIL_TEXT = TbadkApplication.getInst().getString(R.string.last_msg_pic);
    }

    public String getBigSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.bigSize;
        }
        return (String) invokeV.objValue;
    }

    public String getBigSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.bigSrc;
        }
        return (String) invokeV.objValue;
    }

    public String getThumbSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.thumbSize;
        }
        return (String) invokeV.objValue;
    }

    public String getThumbUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.thumbUrl;
        }
        return (String) invokeV.objValue;
    }

    public boolean isInvalidAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (StringUtils.isNull(this.thumbUrl)) {
                return true;
            }
            return !this.thumbUrl.startsWith("http");
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public static String[] parseImageSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return str.split(",");
        }
        return (String[]) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg<SdkMsg extends com.baidu.android.imsdk.chatmessage.messages.ImageMsg> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg
    public /* bridge */ /* synthetic */ void fromSdkMsg(@NonNull ChatMsg chatMsg) {
        fromSdkMsg((BaseImageMsg<SdkMsg>) ((com.baidu.android.imsdk.chatmessage.messages.ImageMsg) chatMsg));
    }

    public void setBigSize(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.bigSize = str;
        }
    }

    public void setBigSrc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.bigSrc = str;
        }
    }

    public void setThumbSize(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.thumbSize = str;
        }
    }

    public void setThumbUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.thumbUrl = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg
    @NonNull
    public final SdkMsg createSdkMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SdkMsg createSdkMsgByChildClass = createSdkMsgByChildClass();
            createSdkMsgByChildClass.setThumbUrl(this.thumbUrl);
            createSdkMsgByChildClass.setContent(this.bigSrc);
            String[] parseImageSize = parseImageSize(this.thumbSize);
            if (parseImageSize != null && parseImageSize.length > 1) {
                createSdkMsgByChildClass.setImgWH(JavaTypesHelper.toInt(parseImageSize[0], 0), JavaTypesHelper.toInt(parseImageSize[1], 0));
            }
            return createSdkMsgByChildClass;
        }
        return (SdkMsg) invokeV.objValue;
    }

    public final void fromSdkMsg(@NonNull SdkMsg sdkmsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sdkmsg) == null) {
            this.thumbUrl = sdkmsg.getThumbUrl();
            this.bigSrc = sdkmsg.getRemoteUrl();
            fromSdkMsgToChildClass(sdkmsg);
        }
    }

    public void setSdkMsg(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            ((com.baidu.android.imsdk.chatmessage.messages.ImageMsg) getSdkMsg()).setThumbUrl(str);
            ((com.baidu.android.imsdk.chatmessage.messages.ImageMsg) getSdkMsg()).setContent(str2);
        }
    }
}
