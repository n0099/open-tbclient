package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.TaskInfo;
import com.baidu.tieba.uu6;
import com.baidu.tieba.vq5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
/* loaded from: classes5.dex */
public class TextMsg extends BaseChatMsg<com.baidu.android.imsdk.chatmessage.messages.TextMsg> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int MSG_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    @vq5(serialize = false)
    public CharSequence cacheText;
    @vq5(serialize = false)
    public boolean mIsRobotGuideMsg;
    @Nullable
    @SerializedName("robot_params")
    public Map<String, Object> robotParams;
    @vq5(serialize = false)
    public String text;
    @vq5(serialize = false)
    public SpannableStringBuilder thumbnailText;

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg
    public boolean needBubbleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements uu6.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextMsg a;

        public a(TextMsg textMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textMsg;
        }

        @Override // com.baidu.tieba.uu6.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) && this.a.thumbnailText.length() <= 0) {
                this.a.thumbnailText.append((CharSequence) spannableStringBuilder);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1636270591, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/TextMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1636270591, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/TextMsg;");
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

    public CharSequence getCacheText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.cacheText;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public Map<String, Object> getRobotParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.robotParams;
        }
        return (Map) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String str = this.text;
            if (str != null) {
                this.text = str.replaceAll("\r", "\n");
            }
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.in
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean isRobotGuideMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mIsRobotGuideMsg;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public static TextMsg create(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            TextMsg textMsg = new TextMsg();
            textMsg.text = str;
            return textMsg;
        }
        return (TextMsg) invokeL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public boolean isContentChanged(@NonNull BaseMsg baseMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, baseMsg)) == null) {
            if (getCommonMsgField().getAbilityEffectItem() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setCacheText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, charSequence) == null) {
            this.cacheText = charSequence;
        }
    }

    public void setRobotGuideMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mIsRobotGuideMsg = z;
        }
    }

    public void setRobotParams(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            this.robotParams = map;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg
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
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg
    public void fromSdkMsg(@NonNull com.baidu.android.imsdk.chatmessage.messages.TextMsg textMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, textMsg) == null) {
            this.text = textMsg.getText();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpannableStringBuilder spannableStringBuilder = this.thumbnailText;
            if (spannableStringBuilder != null) {
                return spannableStringBuilder;
            }
            this.thumbnailText = new SpannableStringBuilder();
            uu6.d(TbadkApplication.getInst(), this.text, UtilHelper.getDimenPixelSize(R.dimen.T_X03), new a(this));
            if (this.thumbnailText.length() <= 0) {
                this.thumbnailText.append((CharSequence) this.text);
            }
            return this.thumbnailText;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @Nullable
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TaskInfo taskInfo = getTaskInfo();
            if (taskInfo == null) {
                return null;
            }
            String originMsgKey = taskInfo.getOriginMsgKey();
            if (TextUtils.isEmpty(originMsgKey) || !taskInfo.isComplete() || !getCommonMsgField().compareVersion()) {
                return null;
            }
            return Action.a(taskInfo.getOriginMsgId(), originMsgKey, Action.Op.DELETE, null);
        }
        return (Action) invokeV.objValue;
    }
}
