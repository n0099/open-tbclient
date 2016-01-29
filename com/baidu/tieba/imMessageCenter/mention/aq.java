package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.e<bd> {
    private bd cmQ;
    private BdUniqueId cnr;
    private a cns;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void c(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public aq(bd bdVar) {
        super(com.baidu.adp.base.l.C(bdVar.getPageContext().getPageActivity()));
        this.cnr = BdUniqueId.gen();
        this.cmQ = bdVar;
        ahR();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.cmQ.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void ahR() {
        ar arVar = new ar(this, 303010);
        arVar.setTag(this.cmQ.getUniqueId());
        arVar.setSelfListener(true);
        this.cmQ.registerListener(arVar);
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
        this.cns = aVar;
    }
}
