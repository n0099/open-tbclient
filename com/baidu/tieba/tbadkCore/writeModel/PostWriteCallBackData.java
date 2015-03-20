package com.baidu.tieba.tbadkCore.writeModel;

import java.io.Serializable;
/* loaded from: classes.dex */
public class PostWriteCallBackData implements Serializable {
    private static final long serialVersionUID = 3542955843976043534L;
    private String colorMsg;
    private String errorString;
    private String preMsg;
    private String threadId = null;
    private String postId = null;

    public PostWriteCallBackData() {
    }

    public PostWriteCallBackData(String str, String str2, String str3) {
        this.errorString = str;
        this.preMsg = str2;
        this.colorMsg = str3;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public void setErrorString(String str) {
        this.errorString = str;
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
