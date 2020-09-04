package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.video.VideoTitleData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PostWriteCallBackData implements Serializable {
    public static final int COPY_TW_ZHIBO_TAG = 3;
    public static final int ERROR_ANTI_USER = 340016;
    public static final int ERROR_DISABLE_AT = 230278;
    public static final int ERROR_DISABLE_REPLY = 230277;
    public static final int ERROR_LEVEL_UNDER_THREE = 1990032;
    public static final String GENERAL_TAB_ID = "general_tab_id";
    public static final int VIDEO_FROM_ACTIVITY = 3;
    public static final int VIDEO_FROM_FRS = 2;
    public static final int VIDEO_FROM_MAINTAB = 1;
    private static final long serialVersionUID = 3542955843976043534L;
    private String colorMsg;
    private int errorCode;
    private String errorString;
    private int generalTabId;
    private int isCopyTWZhibo;
    private CustomDialogData mActDialogData;
    private ContriInfo mContriInfo;
    public int mFrom;
    private bp mReplyPrivacyTip;
    private VideoEasterEggData mVideoEasterEggData;
    public String mVideoMd5;
    public VideoTitleData mVideoTitleData;
    private String preMsg;
    private int proZone;
    private String video_id;
    private String threadId = null;
    private String postId = null;
    private AccessState accessState = null;
    private ArrayList<String> sensitiveWords = null;
    private boolean isDyamicCallback = false;

    public PostWriteCallBackData() {
    }

    public PostWriteCallBackData(int i, String str, String str2, String str3) {
        this.errorCode = i;
        this.errorString = str;
        this.preMsg = str2;
        this.colorMsg = str3;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
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

    public void setIsCopyTWZhibo(int i) {
        this.isCopyTWZhibo = i;
    }

    public int getIsCopyTWZhibo() {
        return this.isCopyTWZhibo;
    }

    public String getVideoid() {
        return this.video_id;
    }

    public void setVideoid(String str) {
        this.video_id = str;
    }

    public AccessState getAccessState() {
        return this.accessState;
    }

    public void setAccessState(AccessState accessState) {
        this.accessState = accessState;
    }

    public CustomDialogData getActivityDialog() {
        return this.mActDialogData;
    }

    public void setActivityDialog(CustomDialogData customDialogData) {
        this.mActDialogData = customDialogData;
    }

    public ContriInfo getContriInfo() {
        return this.mContriInfo;
    }

    public void setContriInfo(ContriInfo contriInfo) {
        this.mContriInfo = contriInfo;
    }

    public void setVideoEasterEggData(VideoEasterEggData videoEasterEggData) {
        this.mVideoEasterEggData = videoEasterEggData;
    }

    public VideoEasterEggData getVideoEasterEggData() {
        return this.mVideoEasterEggData;
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

    public String buildVideoFakeOnWallUrl() {
        if (this.mVideoTitleData == null || StringUtils.isNull(this.mVideoTitleData.url)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mVideoTitleData.url);
        if (!StringUtils.isNull(this.mVideoMd5)) {
            sb.append("&video_md5=");
            sb.append(this.mVideoMd5);
        }
        return sb.toString();
    }

    public void setReplyPrivacyTip(bp bpVar) {
        this.mReplyPrivacyTip = bpVar;
    }

    public bp getReplyPrivacyTip() {
        return this.mReplyPrivacyTip;
    }

    public void setProZone(int i) {
        this.proZone = i;
    }

    public int getProZone() {
        return this.proZone;
    }

    public boolean isDyamicCallback() {
        return this.isDyamicCallback;
    }

    public void setDyamicCallback(boolean z) {
        this.isDyamicCallback = z;
    }

    public void setGeneralTabId(int i) {
        this.generalTabId = i;
    }

    public int getGeneralTabId() {
        return this.generalTabId;
    }

    public boolean isErrorLinkCountExceedLimit() {
        return this.errorCode == 3300001;
    }

    public boolean isErrorShowApplyMemberDialog() {
        return this.errorCode == 3300003;
    }
}
