package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
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
public class en {
    private PbModel ele;
    public a emq;
    protected final com.baidu.adp.framework.listener.a equ = new eo(this, CmdConfigHttp.CMD_PB_GOD_MORE, 309446);

    /* loaded from: classes.dex */
    public interface a {
        void d(int i, String str, String str2);

        void onSuccess(List<PostData> list);
    }

    public en(PbModel pbModel, BaseActivity baseActivity) {
        this.ele = pbModel;
        DA();
        MessageManager.getInstance().registerListener(this.equ);
        this.emq = null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.equ);
    }

    public void a(a aVar) {
        this.emq = aVar;
    }

    private void DA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_GOD_MORE, com.baidu.tieba.tbadkCore.a.a.aw(TbConfig.PB_MORE_GOD_REPLY_URL, 309446));
        tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(309446, LookMoreSocketResMessage.class, false);
    }

    public void bV(List<Long> list) {
        if (this.ele != null && this.ele.getPbData() != null) {
            int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst());
            int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst());
            LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
            lookMoreReqMessage.setKz(Long.valueOf(com.baidu.adp.lib.g.b.c(this.ele.eph, 0L)));
            lookMoreReqMessage.setPost_id(list);
            lookMoreReqMessage.setSt_type(com.baidu.adp.lib.g.b.g(this.ele.mStType, 0));
            lookMoreReqMessage.setWith_floor(1);
            lookMoreReqMessage.setScr_w(af);
            lookMoreReqMessage.setScr_h(ag);
            MessageManager.getInstance().sendMessage(lookMoreReqMessage);
        }
    }
}
