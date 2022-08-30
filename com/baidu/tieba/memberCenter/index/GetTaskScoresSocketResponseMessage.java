package com.baidu.tieba.memberCenter.index;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.AddTaskScores.AddTaskScoresResIdl;
import tbclient.AddTaskScores.DataRes;
import tbclient.Error;
/* loaded from: classes5.dex */
public class GetTaskScoresSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int isFinished;
    public int scores;
    public int taskId;
    public long userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTaskScoresSocketResponseMessage() {
        super(309367);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.scores = 0;
        this.isFinished = 0;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            AddTaskScoresResIdl addTaskScoresResIdl = (AddTaskScoresResIdl) new Wire(new Class[0]).parseFrom(bArr, AddTaskScoresResIdl.class);
            if (addTaskScoresResIdl == null) {
                return null;
            }
            Error error = addTaskScoresResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(addTaskScoresResIdl.error.usermsg);
            }
            DataRes dataRes = addTaskScoresResIdl.data;
            if (dataRes == null) {
                return addTaskScoresResIdl;
            }
            this.scores = dataRes.scores.intValue();
            this.isFinished = addTaskScoresResIdl.data.is_finish.intValue();
            if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                GetTaskScoresRequestMessage getTaskScoresRequestMessage = (GetTaskScoresRequestMessage) getOrginalMessage().getExtra();
                this.userId = getTaskScoresRequestMessage.getUserId();
                this.taskId = getTaskScoresRequestMessage.getTaskId();
            }
            return addTaskScoresResIdl;
        }
        return invokeIL.objValue;
    }

    public int getIsFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isFinished : invokeV.intValue;
    }

    public int getScores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.scores : invokeV.intValue;
    }

    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.taskId : invokeV.intValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.userId : invokeV.longValue;
    }

    public void setTaskId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.taskId = i;
        }
    }

    public void setUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.userId = j;
        }
    }
}
