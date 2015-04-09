package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private String clK;
    private ag clL;
    private String clM;
    private String from;
    private String mForumId;
    private String mForumName;

    public af(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.clK = null;
        this.clL = null;
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

    public void KK() {
        if (this.clL != null) {
            this.clL.cancel();
            this.clL = null;
        }
    }

    public void p(String str, String str2, String str3) {
        aV(str, str2);
        this.clK = str3;
    }

    public void aV(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.clL == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.clL = new ag(this, null);
            this.clL.setPriority(2);
            this.clL.execute(new Object[0]);
        }
    }

    public boolean ale() {
        return this.clL != null;
    }

    public void iB(String str) {
        this.clM = str;
    }
}
