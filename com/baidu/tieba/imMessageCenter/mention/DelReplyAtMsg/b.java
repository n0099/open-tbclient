package com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg;

import com.baidu.adp.base.f;
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
/* loaded from: classes2.dex */
public class b {
    private k iBk;
    private List<g> iBn;
    private i kTM;
    private g kTN;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a kTO;
    private a kTP;
    private k.b kTQ = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cZv();
            if (b.this.kTP != null) {
                b.this.kTP.cZr();
            }
            b.this.cfJ();
        }
    };
    private f mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void cZr();
    }

    public b(f fVar) {
        this.mContext = fVar;
        this.iBk = new k(fVar.getPageActivity());
        this.kTN = new g(fVar.getString(R.string.delete), this.iBk);
        this.kTN.a(this.kTQ);
        this.iBn = new ArrayList();
        this.iBn.add(this.kTN);
        this.iBk.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.cfJ();
            }
        });
        this.iBk.bw(this.iBn);
        this.kTM = new i(fVar, this.iBk);
        onChangeSkinType();
        registerTask();
    }

    public void cfJ() {
        if (this.kTM != null && this.kTM.isShowing()) {
            this.kTM.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.iBk != null) {
            this.iBk.onChangeSkinType();
        }
    }

    public void show() {
        if (this.kTM != null) {
            this.kTM.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.kTO = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZv() {
        if (this.kTO != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.kTO.type);
            httpMessage.addParam("thread_id", this.kTO.threadId);
            httpMessage.addParam("post_id", this.kTO.postId);
            httpMessage.addParam("ori_ugc_nid", this.kTO.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.kTP = aVar;
    }
}
