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
    private k izn;
    private List<g> izq;
    private k.b kRA = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cZh();
            if (b.this.kRz != null) {
                b.this.kRz.cZd();
            }
            b.this.cfw();
        }
    };
    private i kRw;
    private g kRx;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a kRy;
    private a kRz;
    private f mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void cZd();
    }

    public b(f fVar) {
        this.mContext = fVar;
        this.izn = new k(fVar.getPageActivity());
        this.kRx = new g(fVar.getString(R.string.delete), this.izn);
        this.kRx.a(this.kRA);
        this.izq = new ArrayList();
        this.izq.add(this.kRx);
        this.izn.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.cfw();
            }
        });
        this.izn.bw(this.izq);
        this.kRw = new i(fVar, this.izn);
        onChangeSkinType();
        registerTask();
    }

    public void cfw() {
        if (this.kRw != null && this.kRw.isShowing()) {
            this.kRw.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.izn != null) {
            this.izn.onChangeSkinType();
        }
    }

    public void show() {
        if (this.kRw != null) {
            this.kRw.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.kRy = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZh() {
        if (this.kRy != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.kRy.type);
            httpMessage.addParam("thread_id", this.kRy.threadId);
            httpMessage.addParam("post_id", this.kRy.postId);
            httpMessage.addParam("ori_ugc_nid", this.kRy.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.kRz = aVar;
    }
}
