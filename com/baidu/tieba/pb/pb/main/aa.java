package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.godreply.LookMoreHttpResMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreReqMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreSocketResMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
/* loaded from: classes7.dex */
public class aa {
    private PbModel iCx;
    private a iGD;
    protected final com.baidu.adp.framework.listener.a iKd = new com.baidu.adp.framework.listener.a(1001603, CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE) { // from class: com.baidu.tieba.pb.pb.main.aa.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == null || responsedMessage.getOrginalMessage().getTag() == aa.this.iKc) {
                    if (responsedMessage instanceof LookMoreHttpResMessage) {
                        LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                        List<PostData> data = lookMoreHttpResMessage.getData();
                        String errorString = lookMoreHttpResMessage.getErrorString();
                        int error = lookMoreHttpResMessage.getError();
                        if (error != 0) {
                            aa.this.iGD.l(error, errorString, "");
                        } else if (!com.baidu.tbadk.core.util.v.isEmpty(data)) {
                            aa.this.iGD.onSuccess(data);
                        }
                    } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                        LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                        List<PostData> data2 = lookMoreSocketResMessage.getData();
                        String errorString2 = lookMoreSocketResMessage.getErrorString();
                        int error2 = lookMoreSocketResMessage.getError();
                        if (error2 != 0) {
                            aa.this.iGD.l(error2, errorString2, "");
                        } else if (data2 != null) {
                            aa.this.iGD.onSuccess(data2);
                        }
                    }
                }
            }
        }
    };
    private final BdUniqueId iKc = BdUniqueId.gen();

    /* loaded from: classes7.dex */
    public interface a {
        void l(int i, String str, String str2);

        void onSuccess(List<PostData> list);
    }

    public aa(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.iCx = pbModel;
        rT();
        MessageManager.getInstance().registerListener(this.iKd);
        this.iGD = null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iKd);
    }

    public void b(a aVar) {
        this.iGD = aVar;
    }

    private void rT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001603, com.baidu.tieba.tbadkCore.a.a.bv(TbConfig.PB_MORE_GOD_REPLY_URL, CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE, LookMoreSocketResMessage.class, false);
    }

    public void dK(List<Long> list) {
        if (this.iCx != null && this.iCx.getPbData() != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.iCx.iIx, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(com.baidu.adp.lib.f.b.toInt(this.iCx.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(equipmentWidth);
            lookMoreReqMessage.setScr_h(equipmentHeight);
            lookMoreReqMessage.setTag(this.iKc);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }
}
