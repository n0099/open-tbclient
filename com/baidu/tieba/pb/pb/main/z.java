package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.godreply.LookMoreHttpResMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreReqMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreSocketResMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
/* loaded from: classes4.dex */
public class z {
    private PbModel hLS;
    private a hMD;
    protected final com.baidu.adp.framework.listener.a hSH = new com.baidu.adp.framework.listener.a(1001603, CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE) { // from class: com.baidu.tieba.pb.pb.main.z.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == null || responsedMessage.getOrginalMessage().getTag() == z.this.hSG) {
                    if (responsedMessage instanceof LookMoreHttpResMessage) {
                        LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                        List<PostData> data = lookMoreHttpResMessage.getData();
                        String errorString = lookMoreHttpResMessage.getErrorString();
                        int error = lookMoreHttpResMessage.getError();
                        if (error != 0) {
                            z.this.hMD.n(error, errorString, "");
                        } else if (!com.baidu.tbadk.core.util.v.isEmpty(data)) {
                            z.this.hMD.aD(data);
                        }
                    } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                        LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                        List<PostData> data2 = lookMoreSocketResMessage.getData();
                        String errorString2 = lookMoreSocketResMessage.getErrorString();
                        int error2 = lookMoreSocketResMessage.getError();
                        if (error2 != 0) {
                            z.this.hMD.n(error2, errorString2, "");
                        } else if (data2 != null) {
                            z.this.hMD.aD(data2);
                        }
                    }
                }
            }
        }
    };
    private final BdUniqueId hSG = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void aD(List<PostData> list);

        void n(int i, String str, String str2);
    }

    public z(PbModel pbModel, BaseActivity baseActivity) {
        this.hLS = pbModel;
        registerTask();
        MessageManager.getInstance().registerListener(this.hSH);
        this.hMD = null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hSH);
    }

    public void b(a aVar) {
        this.hMD = aVar;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001603, com.baidu.tieba.tbadkCore.a.a.bl(TbConfig.PB_MORE_GOD_REPLY_URL, CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE, LookMoreSocketResMessage.class, false);
    }

    public void dV(List<Long> list) {
        if (this.hLS != null && this.hLS.getPbData() != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(com.baidu.adp.lib.g.b.toLong(this.hLS.hRb, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(com.baidu.adp.lib.g.b.toInt(this.hLS.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(equipmentWidth);
            lookMoreReqMessage.setScr_h(equipmentHeight);
            lookMoreReqMessage.setTag(this.hSG);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }
}
