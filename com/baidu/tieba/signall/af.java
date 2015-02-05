package com.baidu.tieba.signall;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<SignAllForumActivity> {
    private ah bSe;
    private ag bSf;
    private String mForumId;
    private String mForumName;

    public af(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mForumName = null;
        this.mForumId = null;
        this.bSe = null;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void aej() {
        if (this.bSe != null) {
            this.bSe.cancel();
            this.bSe = null;
        }
    }

    public void aq(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bSe == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bSe = new ah(this, null);
            this.bSe.setPriority(2);
            this.bSe.execute(new Object[0]);
        }
    }

    public void a(ag agVar) {
        this.bSf = agVar;
    }
}
