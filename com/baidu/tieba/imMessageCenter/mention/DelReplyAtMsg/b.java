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
    private k iap;
    private List<g> ias;
    private i kuJ;
    private g kuK;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a kuL;
    private a kuM;
    private k.b kuN = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cWE();
            if (b.this.kuM != null) {
                b.this.kuM.cWA();
            }
            b.this.ccs();
        }
    };
    private e mContext;

    /* loaded from: classes22.dex */
    public interface a {
        void cWA();
    }

    public b(e eVar) {
        this.mContext = eVar;
        this.iap = new k(eVar.getPageActivity());
        this.kuK = new g(eVar.getString(R.string.delete), this.iap);
        this.kuK.a(this.kuN);
        this.ias = new ArrayList();
        this.ias.add(this.kuK);
        this.iap.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.ccs();
            }
        });
        this.iap.br(this.ias);
        this.kuJ = new i(eVar, this.iap);
        onChangeSkinType();
        registerTask();
    }

    public void ccs() {
        if (this.kuJ != null && this.kuJ.isShowing()) {
            this.kuJ.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.iap != null) {
            this.iap.onChangeSkinType();
        }
    }

    public void show() {
        if (this.kuJ != null) {
            this.kuJ.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.kuL = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWE() {
        if (this.kuL != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.kuL.type);
            httpMessage.addParam("thread_id", this.kuL.threadId);
            httpMessage.addParam("post_id", this.kuL.postId);
            httpMessage.addParam("ori_ugc_nid", this.kuL.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.kuM = aVar;
    }
}
