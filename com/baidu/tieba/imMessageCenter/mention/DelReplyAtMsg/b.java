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
/* loaded from: classes9.dex */
public class b {
    private k gTw;
    private List<g> gTz;
    private i jgR;
    private g jgS;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a jgT;
    private a jgU;
    private k.b jgV = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cuN();
            if (b.this.jgU != null) {
                b.this.jgU.cuI();
            }
            b.this.bEQ();
        }
    };
    private e mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void cuI();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.gTw = new k(eVar.getPageActivity());
        this.jgS = new g(eVar.getString(R.string.delete), this.gTw);
        this.jgS.a(this.jgV);
        this.gTz = new ArrayList();
        this.gTz.add(this.jgS);
        this.gTw.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.bEQ();
            }
        });
        this.gTw.aL(this.gTz);
        this.jgR = new i(eVar, this.gTw);
        onChangeSkinType();
        xp();
    }

    public void bEQ() {
        if (this.jgR != null && this.jgR.isShowing()) {
            this.jgR.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.gTw != null) {
            this.gTw.onChangeSkinType();
        }
    }

    public void show() {
        if (this.jgR != null) {
            this.jgR.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.jgT = aVar;
    }

    private void xp() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuN() {
        if (this.jgT != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.jgT.type);
            httpMessage.addParam("thread_id", this.jgT.threadId);
            httpMessage.addParam("post_id", this.jgT.postId);
            httpMessage.addParam("ori_ugc_nid", this.jgT.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.jgU = aVar;
    }
}
