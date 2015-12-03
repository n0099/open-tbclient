package com.baidu.tieba.image;
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.tbadkCore.r {
    private String aUq;
    private String cfP;
    private String mPackageName;

    public k(String str, String str2, String str3) {
        this.mPackageName = str;
        this.aUq = str2;
        this.cfP = str3;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void ja(int i) {
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String getPkgName() {
        return this.mPackageName;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String getDownloadUrl() {
        return this.aUq;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String getAppName() {
        return this.cfP;
    }
}
