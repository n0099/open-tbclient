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
/* loaded from: classes21.dex */
public class b {
    private k htb;
    private List<g> hte;
    private i jNq;
    private g jNr;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a jNs;
    private a jNt;
    private k.b jNu = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cNo();
            if (b.this.jNt != null) {
                b.this.jNt.cNk();
            }
            b.this.bTy();
        }
    };
    private e mContext;

    /* loaded from: classes21.dex */
    public interface a {
        void cNk();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.htb = new k(eVar.getPageActivity());
        this.jNr = new g(eVar.getString(R.string.delete), this.htb);
        this.jNr.a(this.jNu);
        this.hte = new ArrayList();
        this.hte.add(this.jNr);
        this.htb.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.bTy();
            }
        });
        this.htb.aX(this.hte);
        this.jNq = new i(eVar, this.htb);
        onChangeSkinType();
        registerTask();
    }

    public void bTy() {
        if (this.jNq != null && this.jNq.isShowing()) {
            this.jNq.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.htb != null) {
            this.htb.onChangeSkinType();
        }
    }

    public void show() {
        if (this.jNq != null) {
            this.jNq.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.jNs = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNo() {
        if (this.jNs != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.jNs.type);
            httpMessage.addParam("thread_id", this.jNs.threadId);
            httpMessage.addParam("post_id", this.jNs.postId);
            httpMessage.addParam("ori_ugc_nid", this.jNs.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.jNt = aVar;
    }
}
