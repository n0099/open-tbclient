package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class ReplyMeModel extends BdBaseModel {
    private BdUniqueId eXZ;
    private a eYa;
    private com.baidu.adp.framework.listener.c eYb;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void a(long j, long j2, long j3, String str);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ReplyMeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eXZ = BdUniqueId.gen();
        this.mPageContext = tbPageContext;
        aUg();
    }

    public void a(long j, int i, String str, String str2) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTid(com.baidu.adp.lib.g.b.d(str2, 0L));
        checkPostRequestMessage.setTag(this.mPageContext.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void aUg() {
        this.eYb = new com.baidu.adp.framework.listener.c(303010) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
                    ReplyMeModel.this.mPageContext.showToast(e.j.neterror);
                    return;
                }
                CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
                if (checkPostResponseMessage.hasError()) {
                    if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                        ReplyMeModel.this.mPageContext.showToast(checkPostResponseMessage.getErrorString());
                        return;
                    } else {
                        ReplyMeModel.this.mPageContext.showToast(e.j.neterror);
                        return;
                    }
                }
                long forumId = checkPostResponseMessage.getForumId();
                long postState = checkPostResponseMessage.getPostState();
                long quoteId = checkPostResponseMessage.getQuoteId();
                long repostId = checkPostResponseMessage.getRepostId();
                String forumName = checkPostResponseMessage.getForumName();
                if (postState == 1) {
                    if (ReplyMeModel.this.eYa != null) {
                        ReplyMeModel.this.eYa.a(forumId, quoteId, repostId, forumName);
                    }
                } else if (postState == 0) {
                    ReplyMeModel.this.mPageContext.showToast(e.j.thread_delete_tip);
                } else if (postState == -1) {
                    ReplyMeModel.this.mPageContext.showToast(e.j.thread_shield_tip);
                }
            }
        };
        this.eYb.setTag(this.mPageContext.getUniqueId());
        this.eYb.setSelfListener(true);
        this.mPageContext.registerListener(this.eYb);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.eYa = aVar;
    }

    public void onDestroy() {
        if (this.eYb != null) {
            MessageManager.getInstance().unRegisterListener(this.eYb);
        }
    }
}
