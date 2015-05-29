package com.baidu.tieba.signall;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.f<SignAllForumActivity> {
    private ai cjt;
    private ah cju;
    private String mForumId;
    private String mForumName;

    public ag(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.cjt = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void akZ() {
        if (this.cjt != null) {
            this.cjt.cancel();
            this.cjt = null;
        }
    }

    public void au(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cjt == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cjt = new ai(this, null);
            this.cjt.setPriority(2);
            this.cjt.execute(new Object[0]);
        }
    }

    public void a(ah ahVar) {
        this.cju = ahVar;
    }
}
