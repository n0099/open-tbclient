package com.baidu.tieba.mention;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.f<SingleMentionActivity> {
    private SingleMentionActivity btK;
    private aa btL;

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public y(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.btK = singleMentionActivity;
        Uk();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        sendMessage(checkPostRequestMessage);
    }

    public void Uk() {
        registerListener(new z(this, 303010));
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void a(aa aaVar) {
        this.btL = aaVar;
    }
}
