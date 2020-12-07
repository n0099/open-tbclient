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
/* loaded from: classes22.dex */
public class b {
    private k ilN;
    private List<g> ilQ;
    private i kIN;
    private g kIO;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a kIP;
    private a kIQ;
    private k.b kIR = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.dbw();
            if (b.this.kIQ != null) {
                b.this.kIQ.dbs();
            }
            b.this.cfD();
        }
    };
    private e mContext;

    /* loaded from: classes22.dex */
    public interface a {
        void dbs();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.ilN = new k(eVar.getPageActivity());
        this.kIO = new g(eVar.getString(R.string.delete), this.ilN);
        this.kIO.a(this.kIR);
        this.ilQ = new ArrayList();
        this.ilQ.add(this.kIO);
        this.ilN.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.cfD();
            }
        });
        this.ilN.bu(this.ilQ);
        this.kIN = new i(eVar, this.ilN);
        onChangeSkinType();
        registerTask();
    }

    public void cfD() {
        if (this.kIN != null && this.kIN.isShowing()) {
            this.kIN.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.ilN != null) {
            this.ilN.onChangeSkinType();
        }
    }

    public void show() {
        if (this.kIN != null) {
            this.kIN.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.kIP = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbw() {
        if (this.kIP != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.kIP.type);
            httpMessage.addParam("thread_id", this.kIP.threadId);
            httpMessage.addParam("post_id", this.kIP.postId);
            httpMessage.addParam("ori_ugc_nid", this.kIP.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.kIQ = aVar;
    }
}
