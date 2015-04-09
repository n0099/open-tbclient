package com.baidu.tieba.signall;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.f<SignAllForumActivity> {
    private ai cfp;
    private ah cfq;
    private String mForumId;
    private String mForumName;

    public ag(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.cfp = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void ajp() {
        if (this.cfp != null) {
            this.cfp.cancel();
            this.cfp = null;
        }
    }

    public void ap(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cfp == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cfp = new ai(this, null);
            this.cfp.setPriority(2);
            this.cfp.execute(new Object[0]);
        }
    }

    public void a(ah ahVar) {
        this.cfq = ahVar;
    }
}
