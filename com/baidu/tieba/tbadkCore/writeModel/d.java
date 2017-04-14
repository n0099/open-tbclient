package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class d {
    private String colorMsg;
    final AntiData dmk;
    final int errorCode;
    private String errorString;
    private String fzg;
    private String fzh;
    private int isCopyTWZhibo;
    private String preMsg;
    private String threadId = null;
    private String postId = null;

    public d(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.dmk = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean bjv() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public boolean bjw() {
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

    public AntiData aws() {
        return this.dmk;
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

    public String bjx() {
        return this.fzg;
    }

    public void qt(String str) {
        this.fzg = str;
    }

    public String bjy() {
        return this.fzh;
    }

    public void qu(String str) {
        this.fzh = str;
    }
}
