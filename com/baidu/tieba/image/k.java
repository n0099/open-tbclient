package com.baidu.tieba.image;
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.tbadkCore.r {
    private String aYr;
    private String cjS;
    private String mPackageName;

    public k(String str, String str2, String str3) {
        this.mPackageName = str;
        this.aYr = str2;
        this.cjS = str3;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String getPkgName() {
        return this.mPackageName;
    }
}
