package com.baidu.tieba.pb.pb.main;

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
/* loaded from: classes.dex */
public class w {
    private PbModel eIv;
    public a eJM;
    protected final com.baidu.adp.framework.listener.a eNX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_PB_GOD_MORE, 309446) { // from class: com.baidu.tieba.pb.pb.main.w.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage instanceof LookMoreHttpResMessage) {
                    LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                    List<PostData> data = lookMoreHttpResMessage.getData();
                    String errorString = lookMoreHttpResMessage.getErrorString();
                    int error = lookMoreHttpResMessage.getError();
                    if (error == 0) {
                        if (!com.baidu.tbadk.core.util.u.v(data)) {
                            w.this.eJM.B(data);
                            return;
                        }
                        return;
                    }
                    w.this.eJM.h(error, errorString, "");
                } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                    LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                    List<PostData> data2 = lookMoreSocketResMessage.getData();
                    String errorString2 = lookMoreSocketResMessage.getErrorString();
                    int error2 = lookMoreSocketResMessage.getError();
                    if (error2 == 0) {
                        if (data2 != null) {
                            w.this.eJM.B(data2);
                            return;
                        }
                        return;
                    }
                    w.this.eJM.h(error2, errorString2, "");
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void B(List<PostData> list);

        void h(int i, String str, String str2);
    }

    public w(PbModel pbModel, BaseActivity baseActivity) {
        this.eIv = pbModel;
        Eo();
        MessageManager.getInstance().registerListener(this.eNX);
        this.eJM = null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eNX);
    }

    public void a(a aVar) {
        this.eJM = aVar;
    }

    private void Eo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_GOD_MORE, com.baidu.tieba.tbadkCore.a.a.az(TbConfig.PB_MORE_GOD_REPLY_URL, 309446));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(309446, LookMoreSocketResMessage.class, false);
    }

    public void cF(List<Long> list) {
        if (this.eIv != null && this.eIv.getPbData() != null) {
            int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst());
            int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(com.baidu.adp.lib.g.b.d(this.eIv.eMJ, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(com.baidu.adp.lib.g.b.g(this.eIv.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(ag);
            lookMoreReqMessage.setScr_h(ah);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }
}
