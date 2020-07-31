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
    private k gZb;
    private List<g> gZe;
    private i jpI;
    private g jpJ;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a jpK;
    private a jpL;
    private k.b jpM = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cyQ();
            if (b.this.jpL != null) {
                b.this.jpL.cyM();
            }
            b.this.bHZ();
        }
    };
    private e mContext;

    /* loaded from: classes16.dex */
    public interface a {
        void cyM();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.gZb = new k(eVar.getPageActivity());
        this.jpJ = new g(eVar.getString(R.string.delete), this.gZb);
        this.jpJ.a(this.jpM);
        this.gZe = new ArrayList();
        this.gZe.add(this.jpJ);
        this.gZb.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.bHZ();
            }
        });
        this.gZb.aS(this.gZe);
        this.jpI = new i(eVar, this.gZb);
        onChangeSkinType();
        registerTask();
    }

    public void bHZ() {
        if (this.jpI != null && this.jpI.isShowing()) {
            this.jpI.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.gZb != null) {
            this.gZb.onChangeSkinType();
        }
    }

    public void show() {
        if (this.jpI != null) {
            this.jpI.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.jpK = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyQ() {
        if (this.jpK != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.jpK.type);
            httpMessage.addParam("thread_id", this.jpK.threadId);
            httpMessage.addParam("post_id", this.jpK.postId);
            httpMessage.addParam("ori_ugc_nid", this.jpK.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.jpL = aVar;
    }
}
