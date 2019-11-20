package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ReplyMeModel extends BdBaseModel {
    private BdUniqueId gVF;
    private a gVG;
    private com.baidu.adp.framework.listener.c gVH;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void a(long j, long j2, long j3, String str, long j4);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_CHECK_POST, CheckPostResponseMessage.class, false);
    }

    public ReplyMeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gVF = BdUniqueId.gen();
        this.mPageContext = tbPageContext;
        bFO();
    }

    public void a(long j, int i, String str, String str2) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTid(com.baidu.adp.lib.g.b.toLong(str2, 0L));
        checkPostRequestMessage.setTag(this.mPageContext.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void bFO() {
        this.gVH = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_CHECK_POST) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (!(socketResponsedMessage instanceof CheckPostResponseMessage)) {
                    ReplyMeModel.this.mPageContext.showToast(R.string.neterror);
                    return;
                }
                CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
                if (checkPostResponseMessage.hasError()) {
                    if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                        ReplyMeModel.this.mPageContext.showToast(checkPostResponseMessage.getErrorString());
                        return;
                    } else {
                        ReplyMeModel.this.mPageContext.showToast(R.string.neterror);
                        return;
                    }
                }
                long forumId = checkPostResponseMessage.getForumId();
                long postState = checkPostResponseMessage.getPostState();
                long quoteId = checkPostResponseMessage.getQuoteId();
                long repostId = checkPostResponseMessage.getRepostId();
                String forumName = checkPostResponseMessage.getForumName();
                long j = 0;
                if (checkPostResponseMessage.getOrginalMessage() instanceof CheckPostRequestMessage) {
                    j = ((CheckPostRequestMessage) checkPostResponseMessage.getOrginalMessage()).getTid();
                }
                if (postState == 1) {
                    if (ReplyMeModel.this.gVG != null) {
                        ReplyMeModel.this.gVG.a(forumId, quoteId, repostId, forumName, j);
                    }
                } else if (postState == 0) {
                    ReplyMeModel.this.mPageContext.showToast(R.string.thread_delete_tip);
                } else if (postState == -1) {
                    ReplyMeModel.this.mPageContext.showToast(R.string.thread_shield_tip);
                }
            }
        };
        this.gVH.setTag(this.mPageContext.getUniqueId());
        this.gVH.setSelfListener(true);
        this.mPageContext.registerListener(this.gVH);
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
        this.gVG = aVar;
    }

    public void onDestroy() {
        if (this.gVH != null) {
            MessageManager.getInstance().unRegisterListener(this.gVH);
        }
    }
}
