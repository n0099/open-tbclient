package com.baidu.tieba.memberCenter.memberTask;

import c.a.q0.w1.c.k.r;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
    public List<r> mTaskList;
    public UserPointInfo mUserPointInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberTaskCenterSocketResMessage() {
        super(309427);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTaskList = new ArrayList();
    }

    public List<ImgInfo> getImageList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mImageList : (List) invokeV.objValue;
    }

    public List<r> getTaskList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTaskList : (List) invokeV.objValue;
    }

    public UserPointInfo getUserPointInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mUserPointInfo : (UserPointInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            GetMemberTaskListResIdl getMemberTaskListResIdl = (GetMemberTaskListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMemberTaskListResIdl.class);
            if (getMemberTaskListResIdl == null) {
                return;
            }
            Error error = getMemberTaskListResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getMemberTaskListResIdl.error.errmsg);
            }
            DataRes dataRes = getMemberTaskListResIdl.data;
            if (dataRes == null) {
                return;
            }
            this.mImageList = dataRes.img_list;
            this.mUserPointInfo = dataRes.user_point_info;
            List<PointTaskInfo> list = dataRes.task_list;
            if (list == null || list.size() <= 0) {
                return;
            }
            int size = getMemberTaskListResIdl.data.task_list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (getMemberTaskListResIdl.data.task_list.get(i3) != null) {
                    this.mTaskList.add(new r(getMemberTaskListResIdl.data.task_list.get(i3)));
                }
            }
        }
    }
}
