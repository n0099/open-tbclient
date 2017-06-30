package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
/* loaded from: classes2.dex */
public class ReplyMeModel extends BdBaseModel<ReplyMessageActivity> {
    private BdUniqueId duM;
    private ReplyMessageActivity duN;
    private a duO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void b(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ReplyMeModel(ReplyMessageActivity replyMessageActivity) {
        super(com.baidu.adp.base.k.Z(replyMessageActivity.getPageContext().getPageActivity()));
        this.duM = BdUniqueId.gen();
        this.duN = replyMessageActivity;
        axN();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.duN.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void axN() {
        ar arVar = new ar(this, 303010);
        arVar.setTag(this.duN.getUniqueId());
        arVar.setSelfListener(true);
        this.duN.registerListener(arVar);
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
        this.duO = aVar;
    }
}
