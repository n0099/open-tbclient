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
/* loaded from: classes4.dex */
public class z {
    private PbModel hNp;
    private a hOa;
    protected final com.baidu.adp.framework.listener.a hTZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_PB_GOD_MORE, 309446) { // from class: com.baidu.tieba.pb.pb.main.z.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == null || responsedMessage.getOrginalMessage().getTag() == z.this.hTY) {
                    if (responsedMessage instanceof LookMoreHttpResMessage) {
                        LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                        List<PostData> data = lookMoreHttpResMessage.getData();
                        String errorString = lookMoreHttpResMessage.getErrorString();
                        int error = lookMoreHttpResMessage.getError();
                        if (error != 0) {
                            z.this.hOa.m(error, errorString, "");
                        } else if (!com.baidu.tbadk.core.util.v.aa(data)) {
                            z.this.hOa.aj(data);
                        }
                    } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                        LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                        List<PostData> data2 = lookMoreSocketResMessage.getData();
                        String errorString2 = lookMoreSocketResMessage.getErrorString();
                        int error2 = lookMoreSocketResMessage.getError();
                        if (error2 != 0) {
                            z.this.hOa.m(error2, errorString2, "");
                        } else if (data2 != null) {
                            z.this.hOa.aj(data2);
                        }
                    }
                }
            }
        }
    };
    private final BdUniqueId hTY = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public interface a {
        void aj(List<PostData> list);

        void m(int i, String str, String str2);
    }

    public z(PbModel pbModel, BaseActivity baseActivity) {
        this.hNp = pbModel;
        registerTask();
        MessageManager.getInstance().registerListener(this.hTZ);
        this.hOa = null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hTZ);
    }

    public void b(a aVar) {
        this.hOa = aVar;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_GOD_MORE, com.baidu.tieba.tbadkCore.a.a.bq(TbConfig.PB_MORE_GOD_REPLY_URL, 309446));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(309446, LookMoreSocketResMessage.class, false);
    }

    public void dI(List<Long> list) {
        if (this.hNp != null && this.hNp.getPbData() != null) {
            int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
            int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(com.baidu.adp.lib.g.b.e(this.hNp.hSu, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(com.baidu.adp.lib.g.b.f(this.hNp.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(af);
            lookMoreReqMessage.setScr_h(ah);
            lookMoreReqMessage.setTag(this.hTY);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }
}
