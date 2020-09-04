package com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg;

import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private k hlY;
    private List<g> hmb;
    private i jEO;
    private g jEP;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a jEQ;
    private a jER;
    private k.b jES = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cJI();
            if (b.this.jER != null) {
                b.this.jER.cJE();
            }
            b.this.bSb();
        }
    };
    private e mContext;

    /* loaded from: classes16.dex */
    public interface a {
        void cJE();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.hlY = new k(eVar.getPageActivity());
        this.jEP = new g(eVar.getString(R.string.delete), this.hlY);
        this.jEP.a(this.jES);
        this.hmb = new ArrayList();
        this.hmb.add(this.jEP);
        this.hlY.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.bSb();
            }
        });
        this.hlY.aT(this.hmb);
        this.jEO = new i(eVar, this.hlY);
        onChangeSkinType();
        registerTask();
    }

    public void bSb() {
        if (this.jEO != null && this.jEO.isShowing()) {
            this.jEO.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.hlY != null) {
            this.hlY.onChangeSkinType();
        }
    }

    public void show() {
        if (this.jEO != null) {
            this.jEO.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.jEQ = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJI() {
        if (this.jEQ != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.jEQ.type);
            httpMessage.addParam("thread_id", this.jEQ.threadId);
            httpMessage.addParam("post_id", this.jEQ.postId);
            httpMessage.addParam("ori_ugc_nid", this.jEQ.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.jER = aVar;
    }
}
