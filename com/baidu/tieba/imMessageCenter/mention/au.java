package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e<ReplyMessageActivity> {
    private BdUniqueId dcU;
    private ReplyMessageActivity dcV;
    private a dcW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public au(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.l.C(replyMessageActivity.getPageContext().getPageActivity()));
        this.dcU = BdUniqueId.gen();
        this.dcV = replyMessageActivity;
        auT();
    }

    public void b(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.dcV.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void auT() {
        av avVar = new av(this, 303010);
        avVar.setTag(this.dcV.getUniqueId());
        avVar.setSelfListener(true);
        this.dcV.registerListener(avVar);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.dcW = aVar;
    }
}
