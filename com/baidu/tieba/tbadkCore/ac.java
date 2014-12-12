package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.f {
    private String bSW;
    private ad bSX;
    private String bSY;
    private String from;
    private String mForumId;
    private String mForumName;

    public ac(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.bSW = null;
        this.bSX = null;
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

    public void GZ() {
        if (this.bSX != null) {
            this.bSX.cancel();
            this.bSX = null;
        }
    }

    public void r(String str, String str2, String str3) {
        aN(str, str2);
        this.bSW = str3;
    }

    public void aN(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bSX == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bSX = new ad(this, null);
            this.bSX.setPriority(2);
            this.bSX.execute(new Object[0]);
        }
    }

    public boolean aeB() {
        return this.bSX != null;
    }

    public void hX(String str) {
        this.bSY = str;
    }
}
