package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
/* loaded from: classes.dex */
public class d {
    private String colorMsg;
    final AntiData dls;
    final int errorCode;
    private String errorString;
    private String fsZ;
    private String fta;
    private int isCopyTWZhibo;
    private String preMsg;
    private String threadId = null;
    private String postId = null;

    public d(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.dls = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean biU() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public boolean biV() {
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

    public AntiData axd() {
        return this.dls;
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

    public String biW() {
        return this.fsZ;
    }

    public void qU(String str) {
        this.fsZ = str;
    }

    public String biX() {
        return this.fta;
    }

    public void qV(String str) {
        this.fta = str;
    }
}
