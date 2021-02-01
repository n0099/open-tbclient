package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.memberCenter.index.a.r;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.adp.framework.listener.a lnK = new com.baidu.adp.framework.listener.a(1003187, CmdConfigSocket.CMD_MEMBER_TASK) { // from class: com.baidu.tieba.memberCenter.memberTask.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof MemberTaskCenterHttpResMessage) || (responsedMessage instanceof MemberTaskCenterSocketResMessage)) {
                    if (responsedMessage instanceof MemberTaskCenterHttpResMessage) {
                        MemberTaskCenterHttpResMessage memberTaskCenterHttpResMessage = (MemberTaskCenterHttpResMessage) responsedMessage;
                        if (memberTaskCenterHttpResMessage.hasError()) {
                            if (c.this.lod != null) {
                                c.this.lod.bJ(memberTaskCenterHttpResMessage.getError(), memberTaskCenterHttpResMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        c.this.mImageList = memberTaskCenterHttpResMessage.getImageList();
                        c.this.mTaskList = memberTaskCenterHttpResMessage.getTaskList();
                        if (memberTaskCenterHttpResMessage.getUserPointInfo() != null) {
                            c.this.lob = memberTaskCenterHttpResMessage.getUserPointInfo().points_total.longValue();
                        }
                        if (c.this.lod != null) {
                            c.this.lod.a(c.this.mImageList, c.this.mTaskList, c.this.lob);
                        }
                    }
                    if (responsedMessage instanceof MemberTaskCenterSocketResMessage) {
                        MemberTaskCenterSocketResMessage memberTaskCenterSocketResMessage = (MemberTaskCenterSocketResMessage) responsedMessage;
                        if (memberTaskCenterSocketResMessage.hasError()) {
                            if (c.this.lod != null) {
                                c.this.lod.bJ(memberTaskCenterSocketResMessage.getError(), memberTaskCenterSocketResMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        c.this.mImageList = memberTaskCenterSocketResMessage.getImageList();
                        c.this.mTaskList = memberTaskCenterSocketResMessage.getTaskList();
                        if (memberTaskCenterSocketResMessage.getUserPointInfo() != null) {
                            c.this.lob = memberTaskCenterSocketResMessage.getUserPointInfo().points_total.longValue();
                        }
                        if (c.this.lod != null) {
                            c.this.lod.a(c.this.mImageList, c.this.mTaskList, c.this.lob);
                        }
                    }
                }
            }
        }
    };
    private long lob;
    private a lod;
    private List<ImgInfo> mImageList;
    private List<r> mTaskList;

    /* loaded from: classes9.dex */
    public interface a {
        void a(List<ImgInfo> list, List<r> list2, long j);

        void bJ(int i, String str);
    }

    public c() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_MEMBER_TASK, MemberTaskCenterSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_MEMBER_TASK, 1003187, TbConfig.GET_MEMBER_TASK, MemberTaskCenterHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.lnK);
    }

    public void a(a aVar) {
        this.lod = aVar;
    }

    public void loadData() {
        MessageManager.getInstance().sendMessage(new MemberTaskCenterRequestMessage());
    }

    public List<r> getTaskList() {
        return this.mTaskList;
    }

    public long dfi() {
        return this.lob;
    }

    public void hj(long j) {
        this.lob = j;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lnK);
    }
}
