package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.f {
    private String bUO;
    private ad bUP;
    private String bUQ;
    private String from;
    private String mForumId;
    private String mForumName;

    public ac(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.bUO = null;
        this.bUP = null;
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

    public void Hr() {
        if (this.bUP != null) {
            this.bUP.cancel();
            this.bUP = null;
        }
    }

    public void r(String str, String str2, String str3) {
        aQ(str, str2);
        this.bUO = str3;
    }

    public void aQ(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bUP == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bUP = new ad(this, null);
            this.bUP.setPriority(2);
            this.bUP.execute(new Object[0]);
        }
    }

    public boolean afa() {
        return this.bUP != null;
    }

    public void ic(String str) {
        this.bUQ = str;
    }
}
