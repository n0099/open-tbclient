package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TaskInfo extends BaseInfo<IChatRoomEnterListener.TaskInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long originMsgId;
    public String originMsgKey;
    public String taskErrorMsg;
    public String taskId;
    public int taskProgress;
    public int taskResult;
    public int taskState;
    public int taskType;

    public TaskInfo() {
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

    @NonNull
    public static TaskInfo create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new TaskInfo();
        }
        return (TaskInfo) invokeV.objValue;
    }

    public long getOriginMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.originMsgId;
        }
        return invokeV.longValue;
    }

    public String getOriginMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.originMsgKey;
        }
        return (String) invokeV.objValue;
    }

    public String getTaskErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.taskErrorMsg;
        }
        return (String) invokeV.objValue;
    }

    public String getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.taskId;
        }
        return (String) invokeV.objValue;
    }

    public int getTaskProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.taskProgress;
        }
        return invokeV.intValue;
    }

    public int getTaskResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.taskResult;
        }
        return invokeV.intValue;
    }

    public int getTaskState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.taskState;
        }
        return invokeV.intValue;
    }

    public int getTaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.taskType;
        }
        return invokeV.intValue;
    }

    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.taskState == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isProgressChanged(@Nullable TaskInfo taskInfo, @Nullable TaskInfo taskInfo2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, taskInfo, taskInfo2)) == null) {
            if (taskInfo2 == null) {
                return false;
            }
            if (taskInfo != null && taskInfo.getTaskProgress() == taskInfo2.getTaskProgress()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseInfo
    @NonNull
    public IChatRoomEnterListener.TaskInfo createSdkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            IChatRoomEnterListener.TaskInfo taskInfo = new IChatRoomEnterListener.TaskInfo();
            taskInfo.taskId = this.taskId;
            taskInfo.taskType = this.taskType;
            taskInfo.taskState = this.taskState;
            taskInfo.taskResult = this.taskResult;
            taskInfo.taskErrorMsg = this.taskErrorMsg;
            taskInfo.originMsgId = this.originMsgId;
            taskInfo.originMsgKey = this.originMsgKey;
            taskInfo.taskProgress = this.taskProgress;
            return taskInfo;
        }
        return (IChatRoomEnterListener.TaskInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseInfo
    public void fromSdkInfo(@NonNull IChatRoomEnterListener.TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskInfo) == null) {
            this.taskId = taskInfo.taskId;
            this.taskType = taskInfo.taskType;
            this.taskState = taskInfo.taskState;
            this.taskResult = taskInfo.taskResult;
            this.taskErrorMsg = taskInfo.taskErrorMsg;
            this.originMsgId = taskInfo.originMsgId;
            this.originMsgKey = taskInfo.originMsgKey;
            this.taskProgress = taskInfo.taskProgress;
        }
    }
}
