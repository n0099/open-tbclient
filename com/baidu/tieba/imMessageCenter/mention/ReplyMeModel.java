package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
/* loaded from: classes.dex */
public class ReplyMeModel extends BdBaseModel<ReplyMessageActivity> {
    private BdUniqueId dnp;
    private ReplyMessageActivity dnq;
    private a dnr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ReplyMeModel(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.Z(replyMessageActivity.getPageContext().getPageActivity()));
        this.dnp = BdUniqueId.gen();
        this.dnq = replyMessageActivity;
        awq();
    }

    public void b(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.dnq.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void awq() {
        aq aqVar = new aq(this, 303010);
        aqVar.setTag(this.dnq.getUniqueId());
        aqVar.setSelfListener(true);
        this.dnq.registerListener(aqVar);
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
        this.dnr = aVar;
    }
}
