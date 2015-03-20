package com.baidu.tieba.mention;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.f<SingleMentionActivity> {
    private SingleMentionActivity bDg;
    private ad bDh;

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ab(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bDg = singleMentionActivity;
        XF();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        sendMessage(checkPostRequestMessage);
    }

    public void XF() {
        registerListener(new ac(this, 303010));
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void a(ad adVar) {
        this.bDh = adVar;
    }
}
