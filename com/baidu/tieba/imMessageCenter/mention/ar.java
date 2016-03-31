package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.e<be> {
    private BdUniqueId cxT;
    private a cxU;
    private be cxs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ar(be beVar) {
        super(com.baidu.adp.base.l.s(beVar.getPageContext().getPageActivity()));
        this.cxT = BdUniqueId.gen();
        this.cxs = beVar;
        all();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.cxs.getUniqueId());
        sendMessage(checkPostRequestMessage);
    }

    public void all() {
        as asVar = new as(this, 303010);
        asVar.setTag(this.cxs.getUniqueId());
        asVar.setSelfListener(true);
        this.cxs.registerListener(asVar);
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
        this.cxU = aVar;
    }
}
