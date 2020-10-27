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
    private k hUs;
    private List<g> hUv;
    private i koN;
    private g koO;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a koP;
    private a koQ;
    private k.b koR = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cUd();
            if (b.this.koQ != null) {
                b.this.koQ.cTZ();
            }
            b.this.bZQ();
        }
    };
    private e mContext;

    /* loaded from: classes22.dex */
    public interface a {
        void cTZ();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.hUs = new k(eVar.getPageActivity());
        this.koO = new g(eVar.getString(R.string.delete), this.hUs);
        this.koO.a(this.koR);
        this.hUv = new ArrayList();
        this.hUv.add(this.koO);
        this.hUs.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.bZQ();
            }
        });
        this.hUs.bk(this.hUv);
        this.koN = new i(eVar, this.hUs);
        onChangeSkinType();
        registerTask();
    }

    public void bZQ() {
        if (this.koN != null && this.koN.isShowing()) {
            this.koN.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.hUs != null) {
            this.hUs.onChangeSkinType();
        }
    }

    public void show() {
        if (this.koN != null) {
            this.koN.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.koP = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUd() {
        if (this.koP != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.koP.type);
            httpMessage.addParam("thread_id", this.koP.threadId);
            httpMessage.addParam("post_id", this.koP.postId);
            httpMessage.addParam("ori_ugc_nid", this.koP.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.koQ = aVar;
    }
}
