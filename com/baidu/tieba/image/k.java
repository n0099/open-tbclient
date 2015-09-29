package com.baidu.tieba.image;
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.tbadkCore.q {
    private String aOU;
    private String bOW;
    private String mPackageName;

    public k(String str, String str2, String str3) {
        this.mPackageName = str;
        this.aOU = str2;
        this.bOW = str3;
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
        return this.aOU;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getAppName() {
        return this.bOW;
    }
}
