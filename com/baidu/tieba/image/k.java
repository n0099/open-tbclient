package com.baidu.tieba.image;
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.tbadkCore.q {
    private String aPn;
    private String bPC;
    private String mPackageName;

    public k(String str, String str2, String str3) {
        this.mPackageName = str;
        this.aPn = str2;
        this.bPC = str3;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void ig(int i) {
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getPkgName() {
        return this.mPackageName;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getDownloadUrl() {
        return this.aPn;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getAppName() {
        return this.bPC;
    }
}
