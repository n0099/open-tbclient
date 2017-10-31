package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.pb.CustomDialogData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    final AntiData antiData;
    private String colorMsg;
    final int errorCode;
    private String errorString;
    private String gsH;
    private String gsI;
    private int isCopyTWZhibo;
    private CustomDialogData mActDialogData;
    private String preMsg;
    private String threadId = null;
    private String postId = null;
    private ArrayList<String> sensitiveWords = null;

    public b(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.antiData = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean bvA() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public boolean bvB() {
        return this.errorCode == 1990055;
    }

    public boolean bvC() {
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

    public AntiData aEB() {
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

    public String bvD() {
        return this.gsH;
    }

    public void sL(String str) {
        this.gsH = str;
    }

    public String bvE() {
        return this.gsI;
    }

    public void sM(String str) {
        this.gsI = str;
    }

    public CustomDialogData getActivityDialog() {
        return this.mActDialogData;
    }

    public void setActivityDialog(CustomDialogData customDialogData) {
        this.mActDialogData = customDialogData;
    }

    public boolean isSensitiveError() {
        return this.errorCode == 220015;
    }

    public void setSensitiveWords(ArrayList<String> arrayList) {
        this.sensitiveWords = arrayList;
    }

    public ArrayList<String> getSensitiveWords() {
        return this.sensitiveWords;
    }
}
