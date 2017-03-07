package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
/* loaded from: classes.dex */
public class ReplyMeModel extends BdBaseModel<ReplyMessageActivity> {
    private ReplyMessageActivity dmA;
    private a dmB;
    private BdUniqueId dmz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ReplyMeModel(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.aa(replyMessageActivity.getPageContext().getPageActivity()));
        this.dmz = BdUniqueId.gen();
        this.dmA = replyMessageActivity;
        avw();
    }

    public void b(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.dmA.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void avw() {
        aq aqVar = new aq(this, 303010);
        aqVar.setTag(this.dmA.getUniqueId());
        aqVar.setSelfListener(true);
        this.dmA.registerListener(aqVar);
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
        this.dmB = aVar;
    }
}
