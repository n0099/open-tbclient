package com.baidu.tieba.image;
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.tbadkCore.q {
    private String aPf;
    private String bPh;
    private String mPackageName;

    public k(String str, String str2, String str3) {
        this.mPackageName = str;
        this.aPf = str2;
        this.bPh = str3;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void hS(int i) {
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getPkgName() {
        return this.mPackageName;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getDownloadUrl() {
        return this.aPf;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getAppName() {
        return this.bPh;
    }
}
