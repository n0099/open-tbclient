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
/* loaded from: classes2.dex */
public class ab {
    private PbModel lIY;
    private a lNQ;
    protected final com.baidu.adp.framework.listener.a lSe = new com.baidu.adp.framework.listener.a(1001603, CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE) { // from class: com.baidu.tieba.pb.pb.main.ab.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == null || responsedMessage.getOrginalMessage().getTag() == ab.this.lSd) {
                    if (responsedMessage instanceof LookMoreHttpResMessage) {
                        LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                        List<PostData> data = lookMoreHttpResMessage.getData();
                        String errorString = lookMoreHttpResMessage.getErrorString();
                        int error = lookMoreHttpResMessage.getError();
                        if (error != 0) {
                            ab.this.lNQ.n(error, errorString, "");
                        } else if (!com.baidu.tbadk.core.util.x.isEmpty(data)) {
                            ab.this.lNQ.ai(data);
                        }
                    } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                        LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                        List<PostData> data2 = lookMoreSocketResMessage.getData();
                        String errorString2 = lookMoreSocketResMessage.getErrorString();
                        int error2 = lookMoreSocketResMessage.getError();
                        if (error2 != 0) {
                            ab.this.lNQ.n(error2, errorString2, "");
                        } else if (data2 != null) {
                            ab.this.lNQ.ai(data2);
                        }
                    }
                }
            }
        }
    };
    private final BdUniqueId lSd = BdUniqueId.gen();

    /* loaded from: classes2.dex */
    public interface a {
        void ai(List<PostData> list);

        void n(int i, String str, String str2);
    }

    public ab(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.lIY = pbModel;
        registerTask();
        this.lSe.setTag(baseFragmentActivity.getUniqueId());
        MessageManager.getInstance().registerListener(this.lSe);
        this.lNQ = null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lSe);
    }

    public void b(a aVar) {
        this.lNQ = aVar;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001603, com.baidu.tieba.tbadkCore.a.a.bU(TbConfig.PB_MORE_GOD_REPLY_URL, CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_SOCKET_GOD_REPLY_LOOKMORE, LookMoreSocketResMessage.class, false);
    }

    public void fo(List<Long> list) {
        if (this.lIY != null && this.lIY.getPbData() != null) {
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.lIY.lQw, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(com.baidu.adp.lib.f.b.toInt(this.lIY.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(equipmentWidth);
            lookMoreReqMessage.setScr_h(equipmentHeight);
            lookMoreReqMessage.setTag(this.lSd);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }
}
