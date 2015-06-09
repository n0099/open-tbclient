package com.baidu.tieba.signall;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.f<SignAllForumActivity> {
    private ai cju;
    private ah cjv;
    private String mForumId;
    private String mForumName;

    public ag(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.cju = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void ala() {
        if (this.cju != null) {
            this.cju.cancel();
            this.cju = null;
        }
    }

    public void au(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cju == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cju = new ai(this, null);
            this.cju.setPriority(2);
            this.cju.execute(new Object[0]);
        }
    }

    public void a(ah ahVar) {
        this.cjv = ahVar;
    }
}
