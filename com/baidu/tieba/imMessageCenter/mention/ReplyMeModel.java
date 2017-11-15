package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ReplyMeModel extends BdBaseModel<ReplyMessageActivity> {
    private BdUniqueId dRV;
    private ReplyMessageActivity dRW;
    private a dRX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void a(long j, long j2, long j3, String str);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ReplyMeModel(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.i.Y(replyMessageActivity.getPageContext().getPageActivity()));
        this.dRV = BdUniqueId.gen();
        this.dRW = replyMessageActivity;
        aDi();
    }

    public void a(long j, int i, String str, String str2) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTid(com.baidu.adp.lib.g.b.c(str2, 0L));
        checkPostRequestMessage.setTag(this.dRW.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void aDi() {
        com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(303010) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
                    ReplyMeModel.this.dRW.showToast(d.j.neterror);
                    return;
                }
                CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
                if (checkPostResponseMessage.hasError()) {
                    if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                        ReplyMeModel.this.dRW.showToast(checkPostResponseMessage.getErrorString());
                        return;
                    } else {
                        ReplyMeModel.this.dRW.showToast(d.j.neterror);
                        return;
                    }
                }
                long forumId = checkPostResponseMessage.getForumId();
                long postState = checkPostResponseMessage.getPostState();
                long quoteId = checkPostResponseMessage.getQuoteId();
                long repostId = checkPostResponseMessage.getRepostId();
                String forumName = checkPostResponseMessage.getForumName();
                if (postState == 1) {
                    ReplyMeModel.this.dRX.a(forumId, quoteId, repostId, forumName);
                } else if (postState == 0) {
                    ReplyMeModel.this.dRW.showToast(d.j.thread_delete_tip);
                } else if (postState == -1) {
                    ReplyMeModel.this.dRW.showToast(d.j.thread_shield_tip);
                }
            }
        };
        cVar.setTag(this.dRW.getUniqueId());
        cVar.setSelfListener(true);
        this.dRW.registerListener(cVar);
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
        this.dRX = aVar;
    }
}
