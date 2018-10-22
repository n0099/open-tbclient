package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.godreply.LookMoreHttpResMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreReqMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreSocketResMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
/* loaded from: classes6.dex */
public class z {
    private PbModel fKF;
    private a fLn;
    protected final com.baidu.adp.framework.listener.a fRn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_PB_GOD_MORE, 309446) { // from class: com.baidu.tieba.pb.pb.main.z.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == null || responsedMessage.getOrginalMessage().getTag() == z.this.fRm) {
                    if (responsedMessage instanceof LookMoreHttpResMessage) {
                        LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                        List<PostData> data = lookMoreHttpResMessage.getData();
                        String errorString = lookMoreHttpResMessage.getErrorString();
                        int error = lookMoreHttpResMessage.getError();
                        if (error != 0) {
                            z.this.fLn.i(error, errorString, "");
                        } else if (!com.baidu.tbadk.core.util.v.J(data)) {
                            z.this.fLn.Q(data);
                        }
                    } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                        LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                        List<PostData> data2 = lookMoreSocketResMessage.getData();
                        String errorString2 = lookMoreSocketResMessage.getErrorString();
                        int error2 = lookMoreSocketResMessage.getError();
                        if (error2 != 0) {
                            z.this.fLn.i(error2, errorString2, "");
                        } else if (data2 != null) {
                            z.this.fLn.Q(data2);
                        }
                    }
                }
            }
        }
    };
    private final BdUniqueId fRm = BdUniqueId.gen();

    /* loaded from: classes6.dex */
    public interface a {
        void Q(List<PostData> list);

        void i(int i, String str, String str2);
    }

    public z(PbModel pbModel, BaseActivity baseActivity) {
        this.fKF = pbModel;
        registerTask();
        MessageManager.getInstance().registerListener(this.fRn);
        this.fLn = null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fRn);
    }

    public void b(a aVar) {
        this.fLn = aVar;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_GOD_MORE, com.baidu.tieba.tbadkCore.a.a.aT(TbConfig.PB_MORE_GOD_REPLY_URL, 309446));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(309446, LookMoreSocketResMessage.class, false);
    }

    public void dk(List<Long> list) {
        if (this.fKF != null && this.fKF.getPbData() != null) {
            int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
            int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(com.baidu.adp.lib.g.b.d(this.fKF.fPL, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(com.baidu.adp.lib.g.b.l(this.fKF.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(aO);
            lookMoreReqMessage.setScr_h(aQ);
            lookMoreReqMessage.setTag(this.fRm);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }
}
