package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes4.dex */
public class BigEmotionMsg extends BaseImageMsg<com.baidu.android.imsdk.chatmessage.messages.ImageMsg> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int EMOTION_MSG_TYPE = 4;
    public static final long serialVersionUID = 8778630731654009426L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("emoticon_content")
    public EmotionContent emoticonContent;

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg
    public void fromSdkMsgToChildClass(@NonNull com.baidu.android.imsdk.chatmessage.messages.ImageMsg imageMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageMsg) == null) {
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public static class EmotionContent extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2675493860347749553L;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("meme_id")
        public String memeId;
        @SerializedName("meme_type")
        public String memeType;

        public EmotionContent() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-67149043, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/itemdata/BigEmotionMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-67149043, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/itemdata/BigEmotionMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
    }

    public BigEmotionMsg() {
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

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg
    public com.baidu.android.imsdk.chatmessage.messages.ImageMsg createSdkMsgByChildClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new com.baidu.android.imsdk.chatmessage.messages.ImageMsg();
        }
        return (com.baidu.android.imsdk.chatmessage.messages.ImageMsg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return TbadkApplication.getInst().getApp().getString(R.string.last_msg_emotion);
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.BaseImageMsg, com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg, com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @NonNull
    public static BigEmotionMsg create(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, map)) == null) {
            BigEmotionMsg bigEmotionMsg = new BigEmotionMsg();
            bigEmotionMsg.setThumbUrl(str);
            bigEmotionMsg.setThumbSize(str2);
            bigEmotionMsg.setBigSize(str2);
            bigEmotionMsg.emoticonContent = (EmotionContent) DataExt.toEntity(map, EmotionContent.class);
            return bigEmotionMsg;
        }
        return (BigEmotionMsg) invokeLLL.objValue;
    }
}
