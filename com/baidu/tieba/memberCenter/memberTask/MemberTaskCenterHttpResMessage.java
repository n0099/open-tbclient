package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.memberCenter.index.a.r;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberTaskList.GetMemberTaskListResIdl;
import tbclient.GetMemberTaskList.ImgInfo;
import tbclient.GetMemberTaskList.UserPointInfo;
/* loaded from: classes8.dex */
public class MemberTaskCenterHttpResMessage extends TbHttpResponsedMessage {
    public List<ImgInfo> mImageList;
    public List<r> mTaskList;
    public UserPointInfo mUserPointInfo;

    public MemberTaskCenterHttpResMessage(int i) {
        super(i);
        this.mTaskList = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetMemberTaskListResIdl getMemberTaskListResIdl = (GetMemberTaskListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMemberTaskListResIdl.class);
        if (getMemberTaskListResIdl != null) {
            if (getMemberTaskListResIdl.error != null) {
                setError(getMemberTaskListResIdl.error.errorno.intValue());
                setErrorString(getMemberTaskListResIdl.error.errmsg);
            }
            if (getMemberTaskListResIdl.data != null) {
                this.mImageList = getMemberTaskListResIdl.data.img_list;
                this.mUserPointInfo = getMemberTaskListResIdl.data.user_point_info;
                if (getMemberTaskListResIdl.data.task_list != null && getMemberTaskListResIdl.data.task_list.size() > 0) {
                    int size = getMemberTaskListResIdl.data.task_list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (getMemberTaskListResIdl.data.task_list.get(i2) != null) {
                            this.mTaskList.add(new r(getMemberTaskListResIdl.data.task_list.get(i2)));
                        }
                    }
                }
            }
        }
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
}
