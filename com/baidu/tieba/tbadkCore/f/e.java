package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class e {
    private String bZM;
    private String bZN;
    final AntiData bqf;
    final int errorCode;
    private String errorString;

    public e(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.bqf = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean aid() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public void setErrorString(String str) {
        this.errorString = str;
    }

    public AntiData abp() {
        return this.bqf;
    }

    public String aie() {
        return this.bZM;
    }

    public void iq(String str) {
        this.bZM = str;
    }

    public String aif() {
        return this.bZN;
    }

    public void ir(String str) {
        this.bZN = str;
    }
}
