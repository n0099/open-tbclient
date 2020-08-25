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
    private k hlU;
    private List<g> hlX;
    private i jEI;
    private g jEJ;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a jEK;
    private a jEL;
    private k.b jEM = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cJH();
            if (b.this.jEL != null) {
                b.this.jEL.cJD();
            }
            b.this.bSa();
        }
    };
    private e mContext;

    /* loaded from: classes16.dex */
    public interface a {
        void cJD();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.hlU = new k(eVar.getPageActivity());
        this.jEJ = new g(eVar.getString(R.string.delete), this.hlU);
        this.jEJ.a(this.jEM);
        this.hlX = new ArrayList();
        this.hlX.add(this.jEJ);
        this.hlU.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.bSa();
            }
        });
        this.hlU.aT(this.hlX);
        this.jEI = new i(eVar, this.hlU);
        onChangeSkinType();
        registerTask();
    }

    public void bSa() {
        if (this.jEI != null && this.jEI.isShowing()) {
            this.jEI.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.hlU != null) {
            this.hlU.onChangeSkinType();
        }
    }

    public void show() {
        if (this.jEI != null) {
            this.jEI.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.jEK = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJH() {
        if (this.jEK != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.jEK.type);
            httpMessage.addParam("thread_id", this.jEK.threadId);
            httpMessage.addParam("post_id", this.jEK.postId);
            httpMessage.addParam("ori_ugc_nid", this.jEK.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.jEL = aVar;
    }
}
