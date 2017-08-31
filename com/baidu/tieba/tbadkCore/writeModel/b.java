package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.pb.CustomDialogData;
/* loaded from: classes.dex */
public class b {
    final AntiData antiData;
    private String colorMsg;
    final int errorCode;
    private String errorString;
    private String glF;
    private String glG;
    private int isCopyTWZhibo;
    private CustomDialogData mActDialogData;
    private String preMsg;
    private String threadId = null;
    private String postId = null;

    public b(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.antiData = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean btv() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public boolean btw() {
        return this.errorCode == 1990055;
    }

    public boolean btx() {
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

    public AntiData aDm() {
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

    public String bty() {
        return this.glF;
    }

    public void ss(String str) {
        this.glF = str;
    }

    public String btz() {
        return this.glG;
    }

    public void st(String str) {
        this.glG = str;
    }

    public CustomDialogData getActivityDialog() {
        return this.mActDialogData;
    }

    public void setActivityDialog(CustomDialogData customDialogData) {
        this.mActDialogData = customDialogData;
    }
}
