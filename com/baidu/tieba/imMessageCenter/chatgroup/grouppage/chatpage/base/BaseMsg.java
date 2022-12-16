package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DiffUtil;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.bk5;
import com.baidu.tieba.fr4;
import com.baidu.tieba.ij5;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes4.dex */
public abstract class BaseMsg extends OrmObject implements Serializable, xn {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Comparator<BaseMsg> CHAT_MSG_COMPARATOR;
    public static final DiffUtil.ItemCallback<BaseMsg> DIFF_ITEM_CALLBACK;
    public static final int STATUS_FILE_UPLOADING = 1;
    public static final int STATUS_FILE_UPLOAD_FAILURE = 2;
    public static final int STATUS_IM_SENDING = 3;
    public static final int STATUS_IM_SEND_FAILURE = 4;
    public static final int STATUS_IM_SUCCESS = 5;
    public static final int STATUS_JUST_CREATED = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public CommonMsgField commonMsgField;
    @ij5(serialize = false)
    public boolean isSysMsg;
    public int itemStatus;
    public ChatMsg sdkMsg;

    public abstract int getMsgType();

    @NonNull
    public abstract CharSequence getThumbnailText();

    public abstract /* synthetic */ BdUniqueId getType();

    /* loaded from: classes4.dex */
    public static class a implements Comparator<BaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(BaseMsg baseMsg, BaseMsg baseMsg2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseMsg, baseMsg2)) == null) {
                if (TextUtils.equals(baseMsg.commonMsgField.getMsgKey(), baseMsg2.commonMsgField.getMsgKey())) {
                    return 0;
                }
                if (baseMsg.commonMsgField.getMsgId() == 0 || baseMsg.commonMsgField.getMsgId() - baseMsg2.commonMsgField.getMsgId() > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends DiffUtil.ItemCallback<BaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a */
        public boolean areContentsTheSame(@NonNull BaseMsg baseMsg, @NonNull BaseMsg baseMsg2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseMsg, baseMsg2)) == null) {
                if (baseMsg.getItemStatus() == baseMsg2.getItemStatus()) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@NonNull BaseMsg baseMsg, @NonNull BaseMsg baseMsg2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseMsg, baseMsg2)) == null) {
                return Objects.equals(baseMsg, baseMsg2);
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1622433393, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/base/BaseMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1622433393, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/base/BaseMsg;");
                return;
            }
        }
        CHAT_MSG_COMPARATOR = new a();
        DIFF_ITEM_CALLBACK = new b();
    }

    public BaseMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.itemStatus = 5;
    }

    @NonNull
    public CommonMsgField getCommonMsgField() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            bk5.b(this.commonMsgField);
            return this.commonMsgField;
        }
        return (CommonMsgField) invokeV.objValue;
    }

    public int getItemStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.itemStatus;
        }
        return invokeV.intValue;
    }

    @NonNull
    public ChatMsg getSdkMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            bk5.b(this.sdkMsg);
            return this.sdkMsg;
        }
        return (ChatMsg) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return Objects.hash(this.commonMsgField);
        }
        return invokeV.intValue;
    }

    public boolean isLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            fr4 s = fr4.s();
            bk5.d(s.B());
            if (s.i() != this.commonMsgField.getUserId()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSysMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.isSysMsg;
        }
        return invokeV.booleanValue;
    }

    public void setCommonMsgField(CommonMsgField commonMsgField) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, commonMsgField) == null) {
            this.commonMsgField = commonMsgField;
        }
    }

    public void setItemStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.itemStatus = i;
        }
    }

    public void setSdkMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, chatMsg) == null) {
            this.sdkMsg = chatMsg;
        }
    }

    public void setSysMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.isSysMsg = z;
        }
    }

    @WorkerThread
    public void clearSdkMsgRedundancyFields() {
        ChatMsg chatMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (chatMsg = this.sdkMsg) != null) {
            String chatRoomContentExt = chatMsg.getChatRoomContentExt();
            if (!TextUtils.isEmpty(chatRoomContentExt)) {
                try {
                    Map<String, Object> map = DataExt.toMap(chatRoomContentExt);
                    ((Map) map.get("content")).remove("itemStatus");
                    this.sdkMsg.setChatRoomContentExt(DataExt.toJson(map));
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                BaseMsg baseMsg = (BaseMsg) obj;
                bk5.b(this.commonMsgField);
                bk5.b(baseMsg.commonMsgField);
                return Objects.equals(this.commonMsgField, baseMsg.commonMsgField);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
