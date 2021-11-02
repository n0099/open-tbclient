package com.baidu.tieba.memberCenter.index;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.AddTaskScores.AddTaskScoresResIdl;
import tbclient.AddTaskScores.DataRes;
import tbclient.Error;
/* loaded from: classes9.dex */
public class GetTaskScoreHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int isFinished;
    public int scores;
    public int taskId;
    public long userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTaskScoreHttpResponseMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.scores = 0;
        this.isFinished = 0;
    }

    public int getIsFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isFinished : invokeV.intValue;
    }

    public int getScores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.scores : invokeV.intValue;
    }

    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.taskId : invokeV.intValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.userId : invokeV.longValue;
    }

    public void setTaskId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.taskId = i2;
        }
    }

    public void setUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.userId = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        AddTaskScoresResIdl addTaskScoresResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (addTaskScoresResIdl = (AddTaskScoresResIdl) new Wire(new Class[0]).parseFrom(bArr, AddTaskScoresResIdl.class)) == null) {
            return;
        }
        Error error = addTaskScoresResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(addTaskScoresResIdl.error.usermsg);
        }
        DataRes dataRes = addTaskScoresResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.scores = dataRes.scores.intValue();
        this.isFinished = addTaskScoresResIdl.data.is_finish.intValue();
        if (getOrginalMessage() == null || getOrginalMessage().getExtra() == null) {
            return;
        }
        GetTaskScoresRequestMessage getTaskScoresRequestMessage = (GetTaskScoresRequestMessage) getOrginalMessage().getExtra();
        this.userId = getTaskScoresRequestMessage.getUserId();
        this.taskId = getTaskScoresRequestMessage.getTaskId();
    }
}
