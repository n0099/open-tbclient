package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ij5;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TextMsg extends BaseChatMsg<com.baidu.android.imsdk.chatmessage.messages.TextMsg> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int MSG_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    @ij5(serialize = false)
    public String text;

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-105388545, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/itemdata/TextMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-105388545, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/itemdata/TextMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
    }

    public TextMsg() {
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

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = this.text;
            if (str != null) {
                this.text = str.replaceAll("\r", "\n");
            }
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return TbadkApplication.getInst().getApp().getString(R.string.last_msg_pic_text);
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg, com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @NonNull
    public static TextMsg create(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            TextMsg textMsg = new TextMsg();
            textMsg.text = str;
            return textMsg;
        }
        return (TextMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg
    @NonNull
    public com.baidu.android.imsdk.chatmessage.messages.TextMsg createSdkMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            com.baidu.android.imsdk.chatmessage.messages.TextMsg textMsg = new com.baidu.android.imsdk.chatmessage.messages.TextMsg();
            textMsg.setText(this.text);
            return textMsg;
        }
        return (com.baidu.android.imsdk.chatmessage.messages.TextMsg) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg
    public void fromSdkMsg(@NonNull com.baidu.android.imsdk.chatmessage.messages.TextMsg textMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, textMsg) == null) {
            this.text = textMsg.getText();
        }
    }
}
