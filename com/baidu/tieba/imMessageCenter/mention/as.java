package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.e<bf> {
    private bf ddM;
    private BdUniqueId deo;
    private a dep;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public as(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.deo = BdUniqueId.gen();
        this.ddM = bfVar;
        atH();
    }

    public void b(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.ddM.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void atH() {
        at atVar = new at(this, 303010);
        atVar.setTag(this.ddM.getUniqueId());
        atVar.setSelfListener(true);
        this.ddM.registerListener(atVar);
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
        this.dep = aVar;
    }
}
