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
/* loaded from: classes22.dex */
public class ReplyMeModel extends BdBaseModel {
    private a kvn;
    private com.baidu.adp.framework.listener.a kvo;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
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
        cWR();
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

    public void cWR() {
        this.kvo = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CHECK_POST, CmdConfigSocket.CMD_CHECK_POST) { // from class: com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long quoteId;
                long repostId;
                String forumName;
                long j;
                long j2;
                long j3;
                long j4;
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
                            long forumId = checkPostResponseMessage.getForumId();
                            long postState = checkPostResponseMessage.getPostState();
                            quoteId = checkPostResponseMessage.getQuoteId();
                            repostId = checkPostResponseMessage.getRepostId();
                            forumName = checkPostResponseMessage.getForumName();
                            if (responsedMessage.getOrginalMessage() == null || !(checkPostResponseMessage.getOrginalMessage().getExtra() instanceof CheckPostRequestMessage)) {
                                j4 = 0;
                            } else {
                                j4 = ((CheckPostRequestMessage) checkPostResponseMessage.getOrginalMessage().getExtra()).getTid();
                            }
                            j3 = forumId;
                            j2 = j4;
                            j = postState;
                        } else {
                            CheckPostHttpResponseMessage checkPostHttpResponseMessage = (CheckPostHttpResponseMessage) responsedMessage;
                            long forumId2 = checkPostHttpResponseMessage.getForumId();
                            long postState2 = checkPostHttpResponseMessage.getPostState();
                            quoteId = checkPostHttpResponseMessage.getQuoteId();
                            repostId = checkPostHttpResponseMessage.getRepostId();
                            forumName = checkPostHttpResponseMessage.getForumName();
                            if (responsedMessage.getOrginalMessage() == null || !(checkPostHttpResponseMessage.getOrginalMessage().getExtra() instanceof CheckPostRequestMessage)) {
                                j = postState2;
                                j2 = 0;
                                j3 = forumId2;
                            } else {
                                long tid = ((CheckPostRequestMessage) checkPostHttpResponseMessage.getOrginalMessage().getExtra()).getTid();
                                j = postState2;
                                j2 = tid;
                                j3 = forumId2;
                            }
                        }
                        if (j == 1) {
                            if (ReplyMeModel.this.kvn != null) {
                                ReplyMeModel.this.kvn.a(j3, quoteId, repostId, forumName, j2);
                            }
                        } else if (j == 0) {
                            ReplyMeModel.this.mPageContext.showToast(R.string.thread_delete_tip);
                        } else if (j == -1) {
                            ReplyMeModel.this.mPageContext.showToast(R.string.thread_shield_tip);
                        }
                    }
                }
            }
        };
        this.kvo.setTag(this.mPageContext.getUniqueId());
        this.kvo.getHttpMessageListener().setSelfListener(true);
        this.kvo.getSocketMessageListener().setSelfListener(true);
        this.mPageContext.registerListener(this.kvo);
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
        this.kvn = aVar;
    }

    public void onDestroy() {
        if (this.kvo != null) {
            MessageManager.getInstance().unRegisterListener(this.kvo);
        }
    }
}
