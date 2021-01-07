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
    private k iyk;
    private List<g> iyn;
    private i kNY;
    private g kNZ;
    private com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a kOa;
    private a kOb;
    private k.b kOc = new k.b() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.2
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            b.this.dbb();
            if (b.this.kOb != null) {
                b.this.kOb.daX();
            }
            b.this.civ();
        }
    };
    private f mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void daX();
    }

    public b(f fVar) {
        this.mContext = fVar;
        this.iyk = new k(fVar.getPageActivity());
        this.kNZ = new g(fVar.getString(R.string.delete), this.iyk);
        this.kNZ.a(this.kOc);
        this.iyn = new ArrayList();
        this.iyn.add(this.kNZ);
        this.iyk.a(new k.a() { // from class: com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.1
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                b.this.civ();
            }
        });
        this.iyk.bB(this.iyn);
        this.kNY = new i(fVar, this.iyk);
        onChangeSkinType();
        registerTask();
    }

    public void civ() {
        if (this.kNY != null && this.kNY.isShowing()) {
            this.kNY.dismiss();
        }
    }

    public void onChangeSkinType() {
        if (this.iyk != null) {
            this.iyk.onChangeSkinType();
        }
    }

    public void show() {
        if (this.kNY != null) {
            this.kNY.show();
        }
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar) {
        this.kOa = aVar;
    }

    private void registerTask() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG, TbConfig.SERVER_ADDRESS + TbConfig.URL_DELETE_REPLY_AT_MSG);
        tbHttpMessageTask.setResponsedClass(DelReplyAtMsgResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbb() {
        if (this.kOa != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DEL_REPLY_AT_MSG);
            httpMessage.addParam("type", this.kOa.type);
            httpMessage.addParam("thread_id", this.kOa.threadId);
            httpMessage.addParam("post_id", this.kOa.postId);
            httpMessage.addParam("ori_ugc_nid", this.kOa.nid);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(a aVar) {
        this.kOb = aVar;
    }
}
