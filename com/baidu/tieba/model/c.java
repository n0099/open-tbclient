package com.baidu.tieba.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.personExtra.RecommendGodHttpResponseMessage;
import com.baidu.tieba.personExtra.RecommendGodReqMsg;
import com.baidu.tieba.personExtra.RecommendGodSocketResponseMessage;
import com.baidu.tieba.personPolymeric.c.q;
/* loaded from: classes8.dex */
public class c {
    private a ltX;
    private boolean ltY;
    private q recommendGodData;
    private BdUniqueId uniqueId;
    private int pageNum = 0;
    private com.baidu.adp.framework.listener.a netMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, 309684) { // from class: com.baidu.tieba.model.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.this.recommendGodData = null;
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == c.this.uniqueId) {
                    if (responsedMessage instanceof RecommendGodSocketResponseMessage) {
                        c.this.recommendGodData = ((RecommendGodSocketResponseMessage) responsedMessage).recommendGodData;
                    } else if (responsedMessage instanceof RecommendGodHttpResponseMessage) {
                        c.this.recommendGodData = ((RecommendGodHttpResponseMessage) responsedMessage).recommendGodData;
                    }
                    if (c.this.recommendGodData != null) {
                        c.this.pageNum = c.this.recommendGodData.har;
                    }
                    int error = responsedMessage.getError();
                    if (error == 0 && c.this.recommendGodData != null) {
                        if (y.isEmpty(c.this.recommendGodData.mBO)) {
                            error = c.this.ltY ? 3 : 2;
                        }
                    } else {
                        error = 1;
                    }
                    if (c.this.ltX != null) {
                        c.this.ltX.a(c.this.recommendGodData, error);
                    }
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void a(q qVar, int i);
    }

    public c(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
        this.netMessageListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.netMessageListener);
    }

    public void request(String str) {
        RecommendGodReqMsg recommendGodReqMsg = new RecommendGodReqMsg();
        recommendGodReqMsg.portrait = str;
        if (this.pageNum == 0) {
            this.ltY = false;
        } else {
            this.ltY = true;
        }
        recommendGodReqMsg.pageNum = this.pageNum + 1;
        recommendGodReqMsg.setTag(this.uniqueId);
        MessageManager.getInstance().sendMessage(recommendGodReqMsg);
    }

    public void bD(String str, int i) {
        this.pageNum = i;
        request(str);
    }

    public void onDestory() {
        MessageManager.getInstance().removeMessage(this.uniqueId);
        MessageManager.getInstance().unRegisterListener(this.uniqueId);
    }

    public void a(a aVar) {
        this.ltX = aVar;
    }
}
