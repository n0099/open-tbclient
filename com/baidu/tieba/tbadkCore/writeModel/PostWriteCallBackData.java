package com.baidu.tieba.tbadkCore.writeModel;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.video.VideoTitleData;
import d.a.i0.r.q.t1;
import d.a.i0.t.a;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
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
    public static final long serialVersionUID = 3542955843976043534L;
    public String colorMsg;
    public int errorCode;
    public String errorString;
    public int generalTabId;
    public IconStampData iconStampData;
    public int isCopyTWZhibo;
    public CustomDialogData mActDialogData;
    public a mAdverSegmentData;
    public ContriInfo mContriInfo;
    public int mFrom;
    public t1 mReplyPrivacyTip;
    public VideoEasterEggData mVideoEasterEggData;
    public String mVideoMd5;
    public VideoTitleData mVideoTitleData;
    public String preMsg;
    public int proZone;
    public String video_id;
    public WriteData writeDataForVideo;
    public String threadId = null;
    public String postId = null;
    public AccessState accessState = null;
    public ArrayList<String> sensitiveWords = null;
    public boolean isDyamicCallback = false;

    public PostWriteCallBackData() {
    }

    public String buildVideoFakeOnWallUrl() {
        VideoTitleData videoTitleData = this.mVideoTitleData;
        if (videoTitleData == null || StringUtils.isNull(videoTitleData.url)) {
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

    public AccessState getAccessState() {
        return this.accessState;
    }

    public CustomDialogData getActivityDialog() {
        return this.mActDialogData;
    }

    public String getColorMsg() {
        return this.colorMsg;
    }

    public ContriInfo getContriInfo() {
        return this.mContriInfo;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorString() {
        return this.errorString;
    }

    public int getGeneralTabId() {
        return this.generalTabId;
    }

    public IconStampData getIconStampData() {
        return this.iconStampData;
    }

    public int getIsCopyTWZhibo() {
        return this.isCopyTWZhibo;
    }

    public String getPostId() {
        return this.postId;
    }

    public String getPreMsg() {
        return this.preMsg;
    }

    public int getProZone() {
        return this.proZone;
    }

    public t1 getReplyPrivacyTip() {
        return this.mReplyPrivacyTip;
    }

    public ArrayList<String> getSensitiveWords() {
        return this.sensitiveWords;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public VideoEasterEggData getVideoEasterEggData() {
        return this.mVideoEasterEggData;
    }

    public String getVideoid() {
        return this.video_id;
    }

    public a getmAdverSegmentData() {
        return this.mAdverSegmentData;
    }

    public boolean isDyamicCallback() {
        return this.isDyamicCallback;
    }

    public boolean isErrorLinkCountExceedLimit() {
        return this.errorCode == 3300001;
    }

    public boolean isErrorShowApplyMemberDialog() {
        return this.errorCode == 3300003;
    }

    public boolean isSensitiveError() {
        return this.errorCode == 220015;
    }

    public void setAccessState(AccessState accessState) {
        this.accessState = accessState;
    }

    public void setActivityDialog(CustomDialogData customDialogData) {
        this.mActDialogData = customDialogData;
    }

    public void setColorMsg(String str) {
        this.colorMsg = str;
    }

    public void setContriInfo(ContriInfo contriInfo) {
        this.mContriInfo = contriInfo;
    }

    public void setDyamicCallback(boolean z) {
        this.isDyamicCallback = z;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setErrorString(String str) {
        this.errorString = str;
    }

    public void setGeneralTabId(int i2) {
        this.generalTabId = i2;
    }

    public void setIconStampData(IconStampData iconStampData) {
        this.iconStampData = iconStampData;
    }

    public void setIsCopyTWZhibo(int i2) {
        this.isCopyTWZhibo = i2;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void setPreMsg(String str) {
        this.preMsg = str;
    }

    public void setProZone(int i2) {
        this.proZone = i2;
    }

    public void setReplyPrivacyTip(t1 t1Var) {
        this.mReplyPrivacyTip = t1Var;
    }

    public void setSensitiveWords(ArrayList<String> arrayList) {
        this.sensitiveWords = arrayList;
    }

    public void setThreadId(String str) {
        this.threadId = str;
    }

    public void setVideoEasterEggData(VideoEasterEggData videoEasterEggData) {
        this.mVideoEasterEggData = videoEasterEggData;
    }

    public void setVideoid(String str) {
        this.video_id = str;
    }

    public void setmAdverSegmentData(a aVar) {
        this.mAdverSegmentData = aVar;
    }

    public PostWriteCallBackData(int i2, String str, String str2, String str3) {
        this.errorCode = i2;
        this.errorString = str;
        this.preMsg = str2;
        this.colorMsg = str3;
    }
}
