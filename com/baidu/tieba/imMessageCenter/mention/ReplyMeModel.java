package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ReplyMeModel extends BdBaseModel {
    private BdUniqueId eHI;
    private a eHJ;
    private com.baidu.adp.framework.listener.c eHK;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void a(long j, long j2, long j3, String str);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ReplyMeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eHI = BdUniqueId.gen();
        this.mPageContext = tbPageContext;
        aPg();
    }

    public void a(long j, int i, String str, String str2) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTid(com.baidu.adp.lib.g.b.c(str2, 0L));
        checkPostRequestMessage.setTag(this.mPageContext.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void aPg() {
        this.eHK = new com.baidu.adp.framework.listener.c(303010) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
                    ReplyMeModel.this.mPageContext.showToast(f.j.neterror);
                    return;
                }
                CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
                if (checkPostResponseMessage.hasError()) {
                    if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                        ReplyMeModel.this.mPageContext.showToast(checkPostResponseMessage.getErrorString());
                        return;
                    } else {
                        ReplyMeModel.this.mPageContext.showToast(f.j.neterror);
                        return;
                    }
                }
                long forumId = checkPostResponseMessage.getForumId();
                long postState = checkPostResponseMessage.getPostState();
                long quoteId = checkPostResponseMessage.getQuoteId();
                long repostId = checkPostResponseMessage.getRepostId();
                String forumName = checkPostResponseMessage.getForumName();
                if (postState == 1) {
                    if (ReplyMeModel.this.eHJ != null) {
                        ReplyMeModel.this.eHJ.a(forumId, quoteId, repostId, forumName);
                    }
                } else if (postState == 0) {
                    ReplyMeModel.this.mPageContext.showToast(f.j.thread_delete_tip);
                } else if (postState == -1) {
                    ReplyMeModel.this.mPageContext.showToast(f.j.thread_shield_tip);
                }
            }
        };
        this.eHK.setTag(this.mPageContext.getUniqueId());
        this.eHK.setSelfListener(true);
        this.mPageContext.registerListener(this.eHK);
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
        this.eHJ = aVar;
    }

    public void onDestroy() {
        if (this.eHK != null) {
            MessageManager.getInstance().unRegisterListener(this.eHK);
        }
    }
}
