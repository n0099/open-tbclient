package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private String cpK;
    private ag cpL;
    private String cpM;
    private String from;
    private String mForumId;
    private String mForumName;

    public af(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.cpK = null;
        this.cpL = null;
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

    public void LQ() {
        if (this.cpL != null) {
            this.cpL.cancel();
            this.cpL = null;
        }
    }

    public void q(String str, String str2, String str3) {
        ba(str, str2);
        this.cpK = str3;
    }

    public void ba(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cpL == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cpL = new ag(this, null);
            this.cpL.setPriority(2);
            this.cpL.execute(new Object[0]);
        }
    }

    public boolean amQ() {
        return this.cpL != null;
    }

    public void ju(String str) {
        this.cpM = str;
    }
}
