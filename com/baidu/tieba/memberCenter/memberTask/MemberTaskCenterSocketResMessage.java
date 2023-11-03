package com.baidu.tieba.memberCenter.memberTask;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.aj9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetMemberTaskList.DataRes;
import tbclient.GetMemberTaskList.GetMemberTaskListResIdl;
import tbclient.GetMemberTaskList.ImgInfo;
import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetMemberTaskList.UserPointInfo;
/* loaded from: classes7.dex */
public class MemberTaskCenterSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImgInfo> mImageList;
    public List<aj9> mTaskList;
    public UserPointInfo mUserPointInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberTaskCenterSocketResMessage() {
        super(309427);
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
        this.mTaskList = new ArrayList();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetMemberTaskListResIdl getMemberTaskListResIdl = (GetMemberTaskListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMemberTaskListResIdl.class);
            if (getMemberTaskListResIdl == null) {
                return null;
            }
            Error error = getMemberTaskListResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getMemberTaskListResIdl.error.errmsg);
            }
            DataRes dataRes = getMemberTaskListResIdl.data;
            if (dataRes == null) {
                return getMemberTaskListResIdl;
            }
            this.mImageList = dataRes.img_list;
            this.mUserPointInfo = dataRes.user_point_info;
            List<PointTaskInfo> list = dataRes.task_list;
            if (list != null && list.size() > 0) {
                int size = getMemberTaskListResIdl.data.task_list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (getMemberTaskListResIdl.data.task_list.get(i2) != null) {
                        this.mTaskList.add(new aj9(getMemberTaskListResIdl.data.task_list.get(i2)));
                    }
                }
            }
            return getMemberTaskListResIdl;
        }
        return invokeIL.objValue;
    }

    public List<ImgInfo> getImageList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mImageList;
        }
        return (List) invokeV.objValue;
    }

    public List<aj9> getTaskList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mTaskList;
        }
        return (List) invokeV.objValue;
    }

    public UserPointInfo getUserPointInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mUserPointInfo;
        }
        return (UserPointInfo) invokeV.objValue;
    }
}
