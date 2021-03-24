package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.q1.c.b.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetMemberTaskList.DataRes;
import tbclient.GetMemberTaskList.GetMemberTaskListResIdl;
import tbclient.GetMemberTaskList.ImgInfo;
import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetMemberTaskList.UserPointInfo;
/* loaded from: classes3.dex */
public class MemberTaskCenterHttpResMessage extends TbHttpResponsedMessage {
    public List<ImgInfo> mImageList;
    public List<r> mTaskList;
    public UserPointInfo mUserPointInfo;

    public MemberTaskCenterHttpResMessage(int i) {
        super(i);
        this.mTaskList = new ArrayList();
    }

    public List<ImgInfo> getImageList() {
        return this.mImageList;
    }

    public List<r> getTaskList() {
        return this.mTaskList;
    }

    public UserPointInfo getUserPointInfo() {
        return this.mUserPointInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
        for (int i2 = 0; i2 < size; i2++) {
            if (getMemberTaskListResIdl.data.task_list.get(i2) != null) {
                this.mTaskList.add(new r(getMemberTaskListResIdl.data.task_list.get(i2)));
            }
        }
    }
}
