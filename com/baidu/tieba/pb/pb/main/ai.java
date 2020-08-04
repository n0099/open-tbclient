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
/* loaded from: classes16.dex */
public class ai {
    private PbModel kkl;
    private a koN;
    protected final com.baidu.adp.framework.listener.a ksM = new com.baidu.adp.framework.listener.a(1001603, CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE) { // from class: com.baidu.tieba.pb.pb.main.ai.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == null || responsedMessage.getOrginalMessage().getTag() == ai.this.ksL) {
                    if (responsedMessage instanceof LookMoreHttpResMessage) {
                        LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                        List<PostData> data = lookMoreHttpResMessage.getData();
                        String errorString = lookMoreHttpResMessage.getErrorString();
                        int error = lookMoreHttpResMessage.getError();
                        if (error != 0) {
                            ai.this.koN.m(error, errorString, "");
                        } else if (!com.baidu.tbadk.core.util.x.isEmpty(data)) {
                            ai.this.koN.bd(data);
                        }
                    } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                        LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                        List<PostData> data2 = lookMoreSocketResMessage.getData();
                        String errorString2 = lookMoreSocketResMessage.getErrorString();
                        int error2 = lookMoreSocketResMessage.getError();
                        if (error2 != 0) {
                            ai.this.koN.m(error2, errorString2, "");
                        } else if (data2 != null) {
                            ai.this.koN.bd(data2);
                        }
                    }
                }
            }
        }
    };
    private final BdUniqueId ksL = BdUniqueId.gen();

    /* loaded from: classes16.dex */
    public interface a {
        void bd(List<PostData> list);

        void m(int i, String str, String str2);
    }

    public ai(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.kkl = pbModel;
        registerTask();
        MessageManager.getInstance().registerListener(this.ksM);
        this.koN = null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ksM);
    }

    public void b(a aVar) {
        this.koN = aVar;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001603, com.baidu.tieba.tbadkCore.a.a.bC(TbConfig.PB_MORE_GOD_REPLY_URL, CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE, LookMoreSocketResMessage.class, false);
    }

    public void et(List<Long> list) {
        if (this.kkl != null && this.kkl.getPbData() != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.kkl.krf, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(com.baidu.adp.lib.f.b.toInt(this.kkl.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(equipmentWidth);
            lookMoreReqMessage.setScr_h(equipmentHeight);
            lookMoreReqMessage.setTag(this.ksL);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }
}
