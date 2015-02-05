package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class e {
    final AntiData brC;
    private String cbE;
    private String cbF;
    final int errorCode;
    private String errorString;

    public e(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.brC = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean aiC() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public void setErrorString(String str) {
        this.errorString = str;
    }

    public AntiData abO() {
        return this.brC;
    }

    public String aiD() {
        return this.cbE;
    }

    public void iv(String str) {
        this.cbE = str;
    }

    public String aiE() {
        return this.cbF;
    }

    public void iw(String str) {
        this.cbF = str;
    }
}
