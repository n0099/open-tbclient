package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.e<bc> {
    private BdUniqueId ceN;
    private a ceO;
    private bc cep;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void c(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ap(bc bcVar) {
        super(com.baidu.adp.base.l.C(bcVar.getPageContext().getPageActivity()));
        this.ceN = BdUniqueId.gen();
        this.cep = bcVar;
        adA();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        checkPostRequestMessage.setTag(this.ceN);
        sendMessage(checkPostRequestMessage);
    }

    public void adA() {
        aq aqVar = new aq(this, 303010);
        aqVar.setTag(this.ceN);
        aqVar.setSelfListener(true);
        registerListener(aqVar);
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
        this.ceO = aVar;
    }

    @Override // com.baidu.adp.base.e
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(this.ceN);
    }
}
