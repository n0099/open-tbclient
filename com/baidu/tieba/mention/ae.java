package com.baidu.tieba.mention;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.e<SingleMentionActivity> {
    private SingleMentionActivity bWg;
    private a bWh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void d(long j, long j2, long j3);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.c(303010, CheckPostResponseMessage.class, false);
    }

    public ae(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bWg = singleMentionActivity;
        abG();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        sendMessage(checkPostRequestMessage);
    }

    public void abG() {
        registerListener(new af(this, 303010));
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
        this.bWh = aVar;
    }
}
