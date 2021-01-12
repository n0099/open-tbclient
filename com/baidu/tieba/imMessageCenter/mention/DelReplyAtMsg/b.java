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
    private k itD;
    private List<g> itG;
    private i kJt;
    private g kJu;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a kJv;
    private a kJw;
    private k.b kJx = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.cXj();
            if (b.this.kJw != null) {
                b.this.kJw.cXf();
            }
            b.this.ceD();
        }
    };
    private f mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void cXf();
    }

    public b(f fVar) {
        this.mContext = fVar;
        this.itD = new k(fVar.getPageActivity());
        this.kJu = new g(fVar.getString(R.string.delete), this.itD);
        this.kJu.a(this.kJx);
        this.itG = new ArrayList();
        this.itG.add(this.kJu);
        this.itD.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.ceD();
            }
        });
        this.itD.bB(this.itG);
        this.kJt = new i(fVar, this.itD);
        onChangeSkinType();
        registerTask();
    }

    public void ceD() {
        if (this.kJt != null && this.kJt.isShowing()) {
            this.kJt.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.itD != null) {
            this.itD.onChangeSkinType();
        }
    }

    public void show() {
        if (this.kJt != null) {
            this.kJt.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.kJv = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXj() {
        if (this.kJv != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.kJv.type);
            httpMessage.addParam("thread_id", this.kJv.threadId);
            httpMessage.addParam("post_id", this.kJv.postId);
            httpMessage.addParam("ori_ugc_nid", this.kJv.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.kJw = aVar;
    }
}
