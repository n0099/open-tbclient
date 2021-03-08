package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ReplyMeModel extends BdBaseModel {
    private a kUq;
    private com.baidu.adp.framework.listener.a kUr;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void a(long j, long j2, long j3, String str, long j4);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_CHECK_POST, CheckPostResponseMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_CHECK_POST, CmdConfigHttp.CMD_CHECK_POST, "c/f/check/checkpost", CheckPostHttpResponseMessage.class, true, true, false, false);
    }

    public ReplyMeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        cZI();
    }

    public void a(long j, int i, String str, String str2, BaijiahaoData baijiahaoData) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTid(com.baidu.adp.lib.f.b.toLong(str2, 0L));
        checkPostRequestMessage.setTag(this.mPageContext.getUniqueId());
        if (baijiahaoData != null) {
            checkPostRequestMessage.ori_ugc_type = baijiahaoData.oriUgcType;
            checkPostRequestMessage.ori_ugc_tid = baijiahaoData.oriUgcTid;
            checkPostRequestMessage.ori_ugc_nid = baijiahaoData.oriUgcNid;
            checkPostRequestMessage.ori_ugc_vid = baijiahaoData.oriUgcVid;
        }
        sendMessage(checkPostRequestMessage);
    }

    public void cZI() {
        this.kUr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHECK_POST, CmdConfigSocket.CMD_CHECK_POST) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long forumId;
                long postState;
                long quoteId;
                long repostId;
                String forumName;
                long j;
                long j2;
                if (responsedMessage != null) {
                    if (!(responsedMessage instanceof CheckPostResponseMessage) && !(responsedMessage instanceof CheckPostHttpResponseMessage)) {
                        ReplyMeModel.this.mPageContext.showToast(R.string.neterror);
                    } else if (responsedMessage.hasError()) {
                        if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                            ReplyMeModel.this.mPageContext.showToast(responsedMessage.getErrorString());
                        } else {
                            ReplyMeModel.this.mPageContext.showToast(R.string.neterror);
                        }
                    } else {
                        if (responsedMessage instanceof CheckPostResponseMessage) {
                            CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) responsedMessage;
                            forumId = checkPostResponseMessage.getForumId();
                            postState = checkPostResponseMessage.getPostState();
                            quoteId = checkPostResponseMessage.getQuoteId();
                            repostId = checkPostResponseMessage.getRepostId();
                            forumName = checkPostResponseMessage.getForumName();
                            if (responsedMessage.getOrginalMessage() == null || !(checkPostResponseMessage.getOrginalMessage().getExtra() instanceof CheckPostRequestMessage)) {
                                j2 = 0;
                            } else {
                                j2 = ((CheckPostRequestMessage) checkPostResponseMessage.getOrginalMessage().getExtra()).getTid();
                            }
                            j = j2;
                        } else {
                            CheckPostHttpResponseMessage checkPostHttpResponseMessage = (CheckPostHttpResponseMessage) responsedMessage;
                            forumId = checkPostHttpResponseMessage.getForumId();
                            postState = checkPostHttpResponseMessage.getPostState();
                            quoteId = checkPostHttpResponseMessage.getQuoteId();
                            repostId = checkPostHttpResponseMessage.getRepostId();
                            forumName = checkPostHttpResponseMessage.getForumName();
                            if (responsedMessage.getOrginalMessage() == null || !(checkPostHttpResponseMessage.getOrginalMessage().getExtra() instanceof CheckPostRequestMessage)) {
                                j = 0;
                            } else {
                                j = ((CheckPostRequestMessage) checkPostHttpResponseMessage.getOrginalMessage().getExtra()).getTid();
                            }
                        }
                        if (postState == 1) {
                            if (ReplyMeModel.this.kUq != null) {
                                ReplyMeModel.this.kUq.a(forumId, quoteId, repostId, forumName, j);
                            }
                        } else if (postState == 0) {
                            ReplyMeModel.this.mPageContext.showToast(R.string.thread_delete_tip);
                        } else if (postState == -1) {
                            ReplyMeModel.this.mPageContext.showToast(R.string.thread_shield_tip);
                        }
                    }
                }
            }
        };
        this.kUr.setTag(this.mPageContext.getUniqueId());
        this.kUr.getHttpMessageListener().setSelfListener(true);
        this.kUr.getSocketMessageListener().setSelfListener(true);
        this.mPageContext.registerListener(this.kUr);
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
        this.kUq = aVar;
    }

    public void onDestroy() {
        if (this.kUr != null) {
            MessageManager.getInstance().unRegisterListener(this.kUr);
        }
    }
}
