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
public class v {
    private PbModel eBC;
    public a eCd;
    protected final com.baidu.adp.framework.listener.a eGE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_PB_GOD_MORE, 309446) { // from class: com.baidu.tieba.pb.pb.main.v.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage instanceof LookMoreHttpResMessage) {
                    LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                    List<PostData> data = lookMoreHttpResMessage.getData();
                    String errorString = lookMoreHttpResMessage.getErrorString();
                    int error = lookMoreHttpResMessage.getError();
                    if (error == 0) {
                        if (!com.baidu.tbadk.core.util.v.u(data)) {
                            v.this.eCd.A(data);
                            return;
                        }
                        return;
                    }
                    v.this.eCd.h(error, errorString, "");
                } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                    LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                    List<PostData> data2 = lookMoreSocketResMessage.getData();
                    String errorString2 = lookMoreSocketResMessage.getErrorString();
                    int error2 = lookMoreSocketResMessage.getError();
                    if (error2 == 0) {
                        if (data2 != null) {
                            v.this.eCd.A(data2);
                            return;
                        }
                        return;
                    }
                    v.this.eCd.h(error2, errorString2, "");
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void A(List<PostData> list);

        void h(int i, String str, String str2);
    }

    public v(PbModel pbModel, BaseActivity baseActivity) {
        this.eBC = pbModel;
        DJ();
        MessageManager.getInstance().registerListener(this.eGE);
        this.eCd = null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eGE);
    }

    public void a(a aVar) {
        this.eCd = aVar;
    }

    private void DJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_GOD_MORE, com.baidu.tieba.tbadkCore.a.a.ay(TbConfig.PB_MORE_GOD_REPLY_URL, 309446));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(309446, LookMoreSocketResMessage.class, false);
    }

    public void cu(List<Long> list) {
        if (this.eBC != null && this.eBC.getPbData() != null) {
            int ad = com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst());
            int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(com.baidu.adp.lib.g.b.c(this.eBC.eFj, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(com.baidu.adp.lib.g.b.g(this.eBC.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(ad);
            lookMoreReqMessage.setScr_h(af);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }
}
