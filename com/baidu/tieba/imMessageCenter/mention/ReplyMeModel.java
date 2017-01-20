package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
/* loaded from: classes.dex */
public class ReplyMeModel extends BdBaseModel<ReplyMessageActivity> {
    private BdUniqueId dkf;
    private ReplyMessageActivity dkg;
    private a dkh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ReplyMeModel(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.C(replyMessageActivity.getPageContext().getPageActivity()));
        this.dkf = BdUniqueId.gen();
        this.dkg = replyMessageActivity;
        awa();
    }

    public void b(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.dkg.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void awa() {
        aq aqVar = new aq(this, 303010);
        aqVar.setTag(this.dkg.getUniqueId());
        aqVar.setSelfListener(true);
        this.dkg.registerListener(aqVar);
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
        this.dkh = aVar;
    }
}
