package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class d {
    private String colorMsg;
    final AntiData doC;
    final int errorCode;
    private String errorString;
    private String fBw;
    private String fBx;
    private int isCopyTWZhibo;
    private String preMsg;
    private String threadId = null;
    private String postId = null;

    public d(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.doC = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean bkw() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public boolean bkx() {
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

    public AntiData axt() {
        return this.doC;
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

    public String bky() {
        return this.fBw;
    }

    public void qu(String str) {
        this.fBw = str;
    }

    public String bkz() {
        return this.fBx;
    }

    public void qv(String str) {
        this.fBx = str;
    }
}
