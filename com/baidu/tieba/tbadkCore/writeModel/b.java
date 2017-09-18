package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.pb.CustomDialogData;
/* loaded from: classes.dex */
public class b {
    final AntiData antiData;
    private String colorMsg;
    final int errorCode;
    private String errorString;
    private String gmA;
    private String gmz;
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

    public boolean btG() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public boolean btH() {
        return this.errorCode == 1990055;
    }

    public boolean btI() {
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

    public AntiData aDx() {
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

    public String btJ() {
        return this.gmz;
    }

    public void su(String str) {
        this.gmz = str;
    }

    public String btK() {
        return this.gmA;
    }

    public void sv(String str) {
        this.gmA = str;
    }

    public CustomDialogData getActivityDialog() {
        return this.mActDialogData;
    }

    public void setActivityDialog(CustomDialogData customDialogData) {
        this.mActDialogData = customDialogData;
    }
}
