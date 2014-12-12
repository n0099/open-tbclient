package com.baidu.tieba.signall;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<SignAllForumActivity> {
    private ah bQu;
    private ag bQv;
    private String mForumId;
    private String mForumName;

    public af(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.bQu = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void adK() {
        if (this.bQu != null) {
            this.bQu.cancel();
            this.bQu = null;
        }
    }

    public void an(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bQu == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bQu = new ah(this, null);
            this.bQu.setPriority(2);
            this.bQu.execute(new Object[0]);
        }
    }

    public void a(ag agVar) {
        this.bQv = agVar;
    }
}
