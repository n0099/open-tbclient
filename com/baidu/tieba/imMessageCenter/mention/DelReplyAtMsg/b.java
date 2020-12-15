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
    private k ilP;
    private List<g> ilS;
    private i kIP;
    private g kIQ;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a kIR;
    private a kIS;
    private k.b kIT = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.dbx();
            if (b.this.kIS != null) {
                b.this.kIS.dbt();
            }
            b.this.cfE();
        }
    };
    private e mContext;

    /* loaded from: classes22.dex */
    public interface a {
        void dbt();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.ilP = new k(eVar.getPageActivity());
        this.kIQ = new g(eVar.getString(R.string.delete), this.ilP);
        this.kIQ.a(this.kIT);
        this.ilS = new ArrayList();
        this.ilS.add(this.kIQ);
        this.ilP.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.cfE();
            }
        });
        this.ilP.bu(this.ilS);
        this.kIP = new i(eVar, this.ilP);
        onChangeSkinType();
        registerTask();
    }

    public void cfE() {
        if (this.kIP != null && this.kIP.isShowing()) {
            this.kIP.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.ilP != null) {
            this.ilP.onChangeSkinType();
        }
    }

    public void show() {
        if (this.kIP != null) {
            this.kIP.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.kIR = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbx() {
        if (this.kIR != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.kIR.type);
            httpMessage.addParam("thread_id", this.kIR.threadId);
            httpMessage.addParam("post_id", this.kIR.postId);
            httpMessage.addParam("ori_ugc_nid", this.kIR.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.kIS = aVar;
    }
}
