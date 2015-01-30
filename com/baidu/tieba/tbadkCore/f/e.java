package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class e {
    final AntiData brD;
    private String cbF;
    private String cbG;
    final int errorCode;
    private String errorString;

    public e(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.brD = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean aiH() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public void setErrorString(String str) {
        this.errorString = str;
    }

    public AntiData abT() {
        return this.brD;
    }

    public String aiI() {
        return this.cbF;
    }

    public void ix(String str) {
        this.cbF = str;
    }

    public String aiJ() {
        return this.cbG;
    }

    public void iy(String str) {
        this.cbG = str;
    }
}
