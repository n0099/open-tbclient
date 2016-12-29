package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class e {
    private String colorMsg;
    final AntiData deh;
    final int errorCode;
    private String errorString;
    private String fjR;
    private String fjS;
    private int isCopyTWZhibo;
    private String preMsg;
    private String threadId = null;
    private String postId = null;

    public e(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.deh = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean bhm() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public boolean bhn() {
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

    public AntiData avW() {
        return this.deh;
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

    public String bho() {
        return this.fjR;
    }

    public void qA(String str) {
        this.fjR = str;
    }

    public String bhp() {
        return this.fjS;
    }

    public void qB(String str) {
        this.fjS = str;
    }
}
