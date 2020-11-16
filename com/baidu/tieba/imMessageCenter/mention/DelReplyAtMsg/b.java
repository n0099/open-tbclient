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
    private k iaR;
    private List<g> iaU;
    private i kvt;
    private g kvu;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a kvv;
    private a kvw;
    private k.b kvx = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cWk();
            if (b.this.kvw != null) {
                b.this.kvw.cWg();
            }
            b.this.cbL();
        }
    };
    private e mContext;

    /* loaded from: classes21.dex */
    public interface a {
        void cWg();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.iaR = new k(eVar.getPageActivity());
        this.kvu = new g(eVar.getString(R.string.delete), this.iaR);
        this.kvu.a(this.kvx);
        this.iaU = new ArrayList();
        this.iaU.add(this.kvu);
        this.iaR.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.cbL();
            }
        });
        this.iaR.br(this.iaU);
        this.kvt = new i(eVar, this.iaR);
        onChangeSkinType();
        registerTask();
    }

    public void cbL() {
        if (this.kvt != null && this.kvt.isShowing()) {
            this.kvt.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.iaR != null) {
            this.iaR.onChangeSkinType();
        }
    }

    public void show() {
        if (this.kvt != null) {
            this.kvt.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.kvv = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWk() {
        if (this.kvv != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.kvv.type);
            httpMessage.addParam("thread_id", this.kvv.threadId);
            httpMessage.addParam("post_id", this.kvv.postId);
            httpMessage.addParam("ori_ugc_nid", this.kvv.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.kvw = aVar;
    }
}
