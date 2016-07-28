package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends com.baidu.adp.base.e<bf> {
    private bf dgI;
    private BdUniqueId dhl;
    private a dhm;

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
        this.dhl = BdUniqueId.gen();
        this.dgI = bfVar;
        aut();
    }

    public void b(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.dgI.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void aut() {
        at atVar = new at(this, 303010);
        atVar.setTag(this.dgI.getUniqueId());
        atVar.setSelfListener(true);
        this.dgI.registerListener(atVar);
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
        this.dhm = aVar;
    }
}
