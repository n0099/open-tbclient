package com.baidu.tieba.signall;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.f<SignAllForumActivity> {
    private ai cfa;
    private ah cfb;
    private String mForumId;
    private String mForumName;

    public ag(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.cfa = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void aja() {
        if (this.cfa != null) {
            this.cfa.cancel();
            this.cfa = null;
        }
    }

    public void ap(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cfa == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cfa = new ai(this, null);
            this.cfa.setPriority(2);
            this.cfa.execute(new Object[0]);
        }
    }

    public void a(ah ahVar) {
        this.cfb = ahVar;
    }
}
