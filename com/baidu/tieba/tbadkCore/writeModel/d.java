package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class d {
    final AntiData antiData;
    private String colorMsg;
    final int errorCode;
    private String errorString;
    private String fPC;
    private String fPD;
    private int isCopyTWZhibo;
    private String mNickNameActivityMoney;
    private String preMsg;
    private String threadId = null;
    private String postId = null;

    public d(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.antiData = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean bnB() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public boolean bnC() {
        return this.errorCode == 1990055;
    }

    public boolean bnD() {
        return this.errorCode == 227001;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public void setErrorString(String str) {
        this.errorString = str;
    }

    public AntiData azh() {
        return this.antiData;
    }

    public String getPreMsg() {
        return this.preMsg;
    }

    public void setPreMsg(String str) {
        this.preMsg = str;
    }

    public String getColorMsg() {
        return this.colorMsg;
    }

    public void setColorMsg(String str) {
        this.colorMsg = str;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public void setThreadId(String str) {
        this.threadId = str;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void setIsCopyTWZhibo(int i) {
        this.isCopyTWZhibo = i;
    }

    public int getIsCopyTWZhibo() {
        return this.isCopyTWZhibo;
    }

    public String bnE() {
        return this.fPC;
    }

    public void rz(String str) {
        this.fPC = str;
    }

    public String bnF() {
        return this.fPD;
    }

    public void rA(String str) {
        this.fPD = str;
    }

    public String getNickNameActivityMoney() {
        return this.mNickNameActivityMoney;
    }

    public void setNickNameActivityMoney(String str) {
        this.mNickNameActivityMoney = str;
    }
}
