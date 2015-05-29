package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class g {
    final AntiData bxl;
    private String colorMsg;
    final int errorCode;
    private String errorString;
    private String preMsg;
    private String threadId = null;
    private String postId = null;

    public g(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.bxl = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean apK() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public void setErrorString(String str) {
        this.errorString = str;
    }

    public AntiData aaG() {
        return this.bxl;
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
}
