package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ij5;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes4.dex */
public class ImageMsg extends BaseChatMsg<com.baidu.android.imsdk.chatmessage.messages.ImageMsg> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int MSG_TYPE = 2;
    public static final long serialVersionUID = 2444733934102528879L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("big_size")
    public String bigSize;
    @ij5(serialize = false)
    @SerializedName("big_src")
    public String bigSrc;
    @SerializedName("bsize")
    public String thumbSize;
    @ij5(serialize = false)
    @SerializedName("src")
    public String thumbUrl;

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1203784061, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/itemdata/ImageMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1203784061, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/itemdata/ImageMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
    }

    public ImageMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String getBigSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.bigSize;
        }
        return (String) invokeV.objValue;
    }

    public String getBigSrc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.bigSrc;
        }
        return (String) invokeV.objValue;
    }

    public String getThumbSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.thumbSize;
        }
        return (String) invokeV.objValue;
    }

    public String getThumbUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.thumbUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return TbadkApplication.getInst().getApp().getString(R.string.last_msg_pic);
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg, com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
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

    @NonNull
    public static ImageMsg create(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            ImageMsg imageMsg = new ImageMsg();
            imageMsg.setThumbUrl(str);
            imageMsg.setThumbSize(str2);
            imageMsg.setBigSize(str2);
            return imageMsg;
        }
        return (ImageMsg) invokeLL.objValue;
    }

    public void setSdkMsg(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            getSdkMsg().setThumbUrl(str);
            getSdkMsg().setContent(str2);
        }
    }

    @Nullable
    public static String[] parseImageSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return str.split(",");
        }
        return (String[]) invokeL.objValue;
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
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg
    @NonNull
    public com.baidu.android.imsdk.chatmessage.messages.ImageMsg createSdkMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            com.baidu.android.imsdk.chatmessage.messages.ImageMsg imageMsg = new com.baidu.android.imsdk.chatmessage.messages.ImageMsg();
            imageMsg.setThumbUrl(this.thumbUrl);
            String[] parseImageSize = parseImageSize(this.thumbSize);
            if (parseImageSize != null && parseImageSize.length > 1) {
                imageMsg.setImgWH(xg.e(parseImageSize[0], 0), xg.e(parseImageSize[1], 0));
            }
            return imageMsg;
        }
        return (com.baidu.android.imsdk.chatmessage.messages.ImageMsg) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg
    public void fromSdkMsg(@NonNull com.baidu.android.imsdk.chatmessage.messages.ImageMsg imageMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, imageMsg) == null) {
            this.thumbUrl = imageMsg.getThumbUrl();
            this.bigSrc = imageMsg.getRemoteUrl();
        }
    }
}
