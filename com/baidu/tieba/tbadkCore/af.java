package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private String clu;
    private ag clv;
    private String clw;
    private String from;
    private String mForumId;
    private String mForumName;

    public af(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.clu = null;
        this.clv = null;
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

    public void KA() {
        if (this.clv != null) {
            this.clv.cancel();
            this.clv = null;
        }
    }

    public void p(String str, String str2, String str3) {
        aV(str, str2);
        this.clu = str3;
    }

    public void aV(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.clv == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.clv = new ag(this, null);
            this.clv.setPriority(2);
            this.clv.execute(new Object[0]);
        }
    }

    public boolean akP() {
        return this.clv != null;
    }

    public void iy(String str) {
        this.clw = str;
    }
}
