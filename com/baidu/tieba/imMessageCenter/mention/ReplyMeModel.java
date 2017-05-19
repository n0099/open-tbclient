package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
/* loaded from: classes2.dex */
public class ReplyMeModel extends BdBaseModel<ReplyMessageActivity> {
    private BdUniqueId dhu;
    private ReplyMessageActivity dhv;
    private a dhw;

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
        this.dhu = BdUniqueId.gen();
        this.dhv = replyMessageActivity;
        atl();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.dhv.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void atl() {
        ar arVar = new ar(this, 303010);
        arVar.setTag(this.dhv.getUniqueId());
        arVar.setSelfListener(true);
        this.dhv.registerListener(arVar);
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
        this.dhw = aVar;
    }
}
