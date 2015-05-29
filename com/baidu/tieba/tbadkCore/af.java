package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private String cpJ;
    private ag cpK;
    private String cpL;
    private String from;
    private String mForumId;
    private String mForumName;

    public af(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.cpJ = null;
        this.cpK = null;
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

    public void LP() {
        if (this.cpK != null) {
            this.cpK.cancel();
            this.cpK = null;
        }
    }

    public void q(String str, String str2, String str3) {
        ba(str, str2);
        this.cpJ = str3;
    }

    public void ba(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cpK == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cpK = new ag(this, null);
            this.cpK.setPriority(2);
            this.cpK.execute(new Object[0]);
        }
    }

    public boolean amP() {
        return this.cpK != null;
    }

    public void ju(String str) {
        this.cpL = str;
    }
}
