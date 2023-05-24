package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DiffUtil;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.a98;
import com.baidu.tieba.es5;
import com.baidu.tieba.rn;
import com.baidu.tieba.tx4;
import com.baidu.tieba.xs5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes6.dex */
public abstract class BaseMsg extends OrmObject implements Serializable, rn, Cloneable {
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
    @Nullable
    @es5(serialize = false)
    public List<AtUserInfo> atUserInfoList;
    @es5(serialize = false)
    public CommonMsgField commonMsgField;
    @Nullable
    @es5(serialize = false)
    public Boolean isLeft;
    @es5(serialize = false)
    public boolean isShowLocateColor;
    @es5(serialize = false)
    public boolean isSysMsg;
    @es5(serialize = false)
    public a98 itemEventCallback;
    public int itemStatus;
    @Nullable
    @es5(serialize = false)
    public BaseMsg preTimestampMsg;
    @Nullable
    @es5(serialize = false)
    public ReMsgInfo reMsgInfo;
    @es5(serialize = false)
    public ChatMsg sdkMsg;
    @Nullable
    @es5(serialize = false)
    public TaskInfo taskInfo;

    public abstract int getMsgType();

    @NonNull
    public abstract CharSequence getThumbnailText();

    public abstract /* synthetic */ BdUniqueId getType();

    public boolean isContentChanged(@NonNull BaseMsg baseMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, baseMsg)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @WorkerThread
    public void onClearRedundancyFields(@NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, map) == null) {
        }
    }

    @Nullable
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (Action) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
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
                if (baseMsg.commonMsgField.isLocalMsgId() || baseMsg.commonMsgField.getMsgId() == 0 || baseMsg.commonMsgField.getMsgId() - baseMsg2.commonMsgField.getMsgId() > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
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
                if (baseMsg.getItemStatus() == baseMsg2.getItemStatus() && !baseMsg.isContentChanged(baseMsg2)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1219936881, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1219936881, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/BaseMsg;");
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
        this.isShowLocateColor = false;
    }

    @Nullable
    public List<AtUserInfo> getAtUserInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.atUserInfoList;
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public CommonMsgField getCommonMsgField() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            xs5.b(this.commonMsgField);
            return this.commonMsgField;
        }
        return (CommonMsgField) invokeV.objValue;
    }

    @Nullable
    public CommonMsgField getCommonMsgFieldNullable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.commonMsgField;
        }
        return (CommonMsgField) invokeV.objValue;
    }

    @NonNull
    public <T extends BaseMsg> a98<T> getItemEventCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            xs5.b(this.itemEventCallback);
            return this.itemEventCallback;
        }
        return (a98) invokeV.objValue;
    }

    public int getItemStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.itemStatus;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ReMsgInfo getReMsgInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.reMsgInfo;
        }
        return (ReMsgInfo) invokeV.objValue;
    }

    @NonNull
    public CharSequence getReplyPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0411), getCommonMsgField().getUserName());
        }
        return (CharSequence) invokeV.objValue;
    }

    @NonNull
    public ChatMsg getSdkMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            xs5.b(this.sdkMsg);
            return this.sdkMsg;
        }
        return (ChatMsg) invokeV.objValue;
    }

    public boolean getShowLocatedColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.isShowLocateColor;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public TaskInfo getTaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TaskInfo taskInfo = this.taskInfo;
            if (taskInfo != null) {
                return taskInfo;
            }
            CommonMsgField commonMsgField = this.commonMsgField;
            if (commonMsgField != null) {
                return commonMsgField.getTaskInfo();
            }
            return null;
        }
        return (TaskInfo) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return Objects.hash(this.commonMsgField);
        }
        return invokeV.intValue;
    }

    public boolean isSysMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.isSysMsg;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public BaseMsg shallowClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            try {
                return (BaseMsg) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (BaseMsg) invokeV.objValue;
    }

    public void addAtUserInfo(@NonNull AtUserInfo atUserInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, atUserInfo) == null) {
            if (this.atUserInfoList == null) {
                this.atUserInfoList = new ArrayList();
            }
            this.atUserInfoList.add(atUserInfo);
        }
    }

    public final void fillSdkMsg4Base(@NonNull BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baseMsg) == null) {
            addAtUserInfo(baseMsg.getAtUserInfoList());
            setReMsgInfo(baseMsg.getReMsgInfo());
            setTaskInfo(baseMsg.getTaskInfo());
        }
    }

    public void setCommonMsgField(CommonMsgField commonMsgField) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, commonMsgField) == null) {
            this.commonMsgField = commonMsgField;
        }
    }

    public void setItemEventCallback(@NonNull a98 a98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, a98Var) == null) {
            this.itemEventCallback = a98Var;
        }
    }

    public void setItemStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.itemStatus = i;
        }
    }

    public void setPreTimestampMsg(@Nullable BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, baseMsg) == null) {
            this.preTimestampMsg = baseMsg;
        }
    }

    public void setReMsgInfo(@Nullable ReMsgInfo reMsgInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, reMsgInfo) == null) {
            this.reMsgInfo = reMsgInfo;
        }
    }

    public void setSdkMsg(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, chatMsg) == null) {
            this.sdkMsg = chatMsg;
        }
    }

    public void setShowLocatedColor(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bool) == null) {
            this.isShowLocateColor = bool.booleanValue();
        }
    }

    public void setSysMsg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.isSysMsg = z;
        }
    }

    public void setTaskInfo(@Nullable TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, taskInfo) == null) {
            this.taskInfo = taskInfo;
        }
    }

    @NonNull
    public static BaseMsg createShadowMsg(long j, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, str)) == null) {
            CommonMsgField commonMsgField = new CommonMsgField();
            commonMsgField.setMsgId(j);
            commonMsgField.setMsgKey(str);
            BaseMsg baseMsg = new BaseMsg() { // from class: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
                public int getMsgType() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return 0;
                    }
                    return invokeV.intValue;
                }

                @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
                @NonNull
                public CharSequence getThumbnailText() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (CharSequence) invokeV.objValue;
                }

                @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.rn
                public BdUniqueId getType() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return null;
                    }
                    return (BdUniqueId) invokeV.objValue;
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }
            };
            baseMsg.setCommonMsgField(commonMsgField);
            return baseMsg;
        }
        return (BaseMsg) invokeJL.objValue;
    }

    public void addAtUserInfo(@Nullable List<AtUserInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && list != null && !list.isEmpty()) {
            List<AtUserInfo> list2 = this.atUserInfoList;
            if (list2 == null) {
                this.atUserInfoList = new ArrayList(list);
            } else {
                list2.addAll(list);
            }
        }
    }

    @WorkerThread
    public void clearSdkMsgRedundancyFields() {
        ChatMsg chatMsg;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (chatMsg = this.sdkMsg) != null) {
            String chatRoomContentExt = chatMsg.getChatRoomContentExt();
            if (!TextUtils.isEmpty(chatRoomContentExt)) {
                try {
                    Map<String, Object> map = DataExt.toMap(chatRoomContentExt);
                    map.remove("isLocalMsgId");
                    Map<String, Object> map2 = (Map) map.get("content");
                    map2.remove("itemStatus");
                    onClearRedundancyFields(map2);
                    this.sdkMsg.setChatRoomContentExt(DataExt.toJson(map));
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    public boolean isLeft() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.isLeft == null) {
                tx4 t = tx4.t();
                xs5.d(t.C());
                if (t.j() != this.commonMsgField.getUserId()) {
                    z = true;
                } else {
                    z = false;
                }
                this.isLeft = Boolean.valueOf(z);
            }
            return this.isLeft.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                BaseMsg baseMsg = (BaseMsg) obj;
                xs5.b(this.commonMsgField);
                xs5.b(baseMsg.commonMsgField);
                return Objects.equals(this.commonMsgField, baseMsg.commonMsgField);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void syncServerMsgId(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, chatMsg) == null) {
            getCommonMsgField().setMsgId(chatMsg.getMsgId());
            getCommonMsgField().setLocalMsgId(false);
            BaseMsg baseMsg = this.preTimestampMsg;
            if (baseMsg != null) {
                baseMsg.getCommonMsgField().setMsgId(chatMsg.getMsgId() - 1);
            }
        }
    }

    public final void fillSdkMsg4Base(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatMsg) == null) {
            List<AtUserInfo> list = this.atUserInfoList;
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (AtUserInfo atUserInfo : this.atUserInfoList) {
                    arrayList.add(atUserInfo.createSdkInfo());
                }
                chatMsg.setAtUserList(arrayList);
            }
            ReMsgInfo reMsgInfo = this.reMsgInfo;
            if (reMsgInfo != null) {
                chatMsg.setReMsgInfo(reMsgInfo.createSdkInfo());
            }
            TaskInfo taskInfo = this.taskInfo;
            if (taskInfo != null) {
                chatMsg.setTaskInfo(taskInfo.createSdkInfo());
            }
        }
    }

    public final void parseSdkMsg4Base(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, chatMsg) == null) {
            List<IChatRoomEnterListener.AtUserInfo> atUserList = chatMsg.getAtUserList();
            if (atUserList != null && !atUserList.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (IChatRoomEnterListener.AtUserInfo atUserInfo : atUserList) {
                    AtUserInfo create = AtUserInfo.create();
                    create.fromSdkInfo(atUserInfo);
                    arrayList.add(create);
                }
                this.atUserInfoList = arrayList;
            }
            IChatRoomEnterListener.ReMsgInfo reMsgInfo = chatMsg.getReMsgInfo();
            if (reMsgInfo != null) {
                ReMsgInfo create2 = ReMsgInfo.create();
                create2.fromSdkInfo(reMsgInfo);
                this.reMsgInfo = create2;
            }
            IChatRoomEnterListener.TaskInfo taskInfo = chatMsg.getTaskInfo();
            if (taskInfo != null) {
                TaskInfo create3 = TaskInfo.create();
                create3.fromSdkInfo(taskInfo);
                this.taskInfo = create3;
            }
        }
    }
}
