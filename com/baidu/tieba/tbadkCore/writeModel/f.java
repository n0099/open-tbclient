package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    final AntiData antiData;
    private String colorMsg;
    final int errorCode;
    private String errorString;
    private IconStampData iconStampData;
    private int isCopyTWZhibo;
    private CustomDialogData mActDialogData;
    private ContriInfo mContriInfo;
    private bs mReplyPrivacyTip;
    private VideoEasterEggData mVideoEasterEggData;
    private String nwa;
    private String nwb;
    private String preMsg;
    private String videoId;
    private String threadId = null;
    private String postId = null;
    private ArrayList<String> sensitiveWords = null;

    public f(int i, String str, AntiData antiData) {
        this.errorCode = i;
        this.errorString = str;
        this.antiData = antiData;
    }

    public boolean hasError() {
        return this.errorCode != 0;
    }

    public boolean dQU() {
        return this.errorCode == 5 || this.errorCode == 6;
    }

    public boolean dQV() {
        return this.errorCode == 1990055;
    }

    public boolean dQW() {
        return this.errorCode == 3250012;
    }

    public boolean dQX() {
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

    public AntiData cDZ() {
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

    public String dQY() {
        return this.nwa;
    }

    public void TS(String str) {
        this.nwa = str;
    }

    public String dQZ() {
        return this.nwb;
    }

    public void TT(String str) {
        this.nwb = str;
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

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public ContriInfo getContriInfo() {
        return this.mContriInfo;
    }

    public void setContriInfo(ContriInfo contriInfo) {
        this.mContriInfo = contriInfo;
    }

    public void setReplyPrivacyTip(bs bsVar) {
        this.mReplyPrivacyTip = bsVar;
    }

    public bs getReplyPrivacyTip() {
        return this.mReplyPrivacyTip;
    }

    public void setVideoEasterEggData(VideoEasterEggData videoEasterEggData) {
        this.mVideoEasterEggData = videoEasterEggData;
    }

    public VideoEasterEggData getVideoEasterEggData() {
        return this.mVideoEasterEggData;
    }

    public void setIconStampData(IconStampData iconStampData) {
        this.iconStampData = iconStampData;
    }

    public IconStampData getIconStampData() {
        return this.iconStampData;
    }
}
