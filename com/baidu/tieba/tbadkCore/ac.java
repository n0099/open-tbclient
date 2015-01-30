package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.f {
    private String bUP;
    private ad bUQ;
    private String bUR;
    private String from;
    private String mForumId;
    private String mForumName;

    public ac(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.bUP = null;
        this.bUQ = null;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void Hx() {
        if (this.bUQ != null) {
            this.bUQ.cancel();
            this.bUQ = null;
        }
    }

    public void r(String str, String str2, String str3) {
        aQ(str, str2);
        this.bUP = str3;
    }

    public void aQ(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bUQ == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bUQ = new ad(this, null);
            this.bUQ.setPriority(2);
            this.bUQ.execute(new Object[0]);
        }
    }

    public boolean aff() {
        return this.bUQ != null;
    }

    public void ie(String str) {
        this.bUR = str;
    }
}
