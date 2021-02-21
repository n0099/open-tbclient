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
    private k izB;
    private List<g> izE;
    private i kRK;
    private g kRL;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a kRM;
    private a kRN;
    private k.b kRO = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cZo();
            if (b.this.kRN != null) {
                b.this.kRN.cZk();
            }
            b.this.cfD();
        }
    };
    private f mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void cZk();
    }

    public b(f fVar) {
        this.mContext = fVar;
        this.izB = new k(fVar.getPageActivity());
        this.kRL = new g(fVar.getString(R.string.delete), this.izB);
        this.kRL.a(this.kRO);
        this.izE = new ArrayList();
        this.izE.add(this.kRL);
        this.izB.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.cfD();
            }
        });
        this.izB.bw(this.izE);
        this.kRK = new i(fVar, this.izB);
        onChangeSkinType();
        registerTask();
    }

    public void cfD() {
        if (this.kRK != null && this.kRK.isShowing()) {
            this.kRK.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.izB != null) {
            this.izB.onChangeSkinType();
        }
    }

    public void show() {
        if (this.kRK != null) {
            this.kRK.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.kRM = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZo() {
        if (this.kRM != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.kRM.type);
            httpMessage.addParam("thread_id", this.kRM.threadId);
            httpMessage.addParam("post_id", this.kRM.postId);
            httpMessage.addParam("ori_ugc_nid", this.kRM.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.kRN = aVar;
    }
}
