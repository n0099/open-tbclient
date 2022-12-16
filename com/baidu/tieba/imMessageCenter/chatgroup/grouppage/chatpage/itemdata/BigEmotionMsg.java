package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.NonNull;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes4.dex */
public class BigEmotionMsg extends ImageMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EMOTION_MSG_TYPE = 4;
    public static final long serialVersionUID = 8778630731654009426L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("emoticon_content")
    public EmotionContent emoticonContent;

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg, com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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

    public BigEmotionMsg() {
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

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg, com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkApplication.getInst().getApp().getString(R.string.last_msg_emotion);
        }
        return (CharSequence) invokeV.objValue;
    }

    @NonNull
    public static BigEmotionMsg create(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, map)) == null) {
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
