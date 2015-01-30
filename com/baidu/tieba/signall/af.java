package com.baidu.tieba.signall;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<SignAllForumActivity> {
    private ah bSf;
    private ag bSg;
    private String mForumId;
    private String mForumName;

    public af(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.bSf = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void aeo() {
        if (this.bSf != null) {
            this.bSf.cancel();
            this.bSf = null;
        }
    }

    public void aq(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bSf == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bSf = new ah(this, null);
            this.bSf.setPriority(2);
            this.bSf.execute(new Object[0]);
        }
    }

    public void a(ag agVar) {
        this.bSg = agVar;
    }
}
