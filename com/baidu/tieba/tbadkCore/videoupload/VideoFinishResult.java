package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoFinishResult implements Serializable {
    private static final long serialVersionUID = 6275774083063164456L;
    private String errorMessage;
    private int errorNo;
    private boolean isSuccess = true;
    private String userMessage;
    private String videoMd5;
    private String videoUrl;

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.errorNo = optJSONObject.optInt("errno");
                    this.errorMessage = optJSONObject.optString("errmsg");
                    this.userMessage = optJSONObject.optString("usermsg");
                }
                this.videoMd5 = jSONObject.optString("video_md5");
                this.videoUrl = jSONObject.optString("video_url");
            } catch (JSONException e) {
            }
            if ((StringUtils.isNull(this.videoMd5) || StringUtils.isNull(this.videoUrl)) && this.errorNo == 0) {
                this.errorNo = -3;
                this.errorMessage = TbErrInfo.getErrMsg(-3);
                this.userMessage = TbErrInfo.getErrMsg(-3);
            }
        }
    }

    public boolean isSuccess() {
        return this.errorNo == 0 && this.isSuccess && !StringUtils.isNull(this.videoMd5) && !StringUtils.isNull(this.videoUrl);
    }

    public int getErrorNo() {
        return this.errorNo;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getUserMessage() {
        return this.userMessage;
    }

    public String getVideoMd5() {
        return this.videoMd5;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setErrorNo(int i) {
        this.errorNo = i;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setUserMessage(String str) {
        this.userMessage = str;
    }

    public void setVideoMd5(String str) {
        this.videoMd5 = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorNo:").append(this.errorNo).append("\n");
        sb.append("ErrorMessage:").append(this.errorMessage).append("\n");
        sb.append("IsSuccess:").append(this.isSuccess).append("\n");
        sb.append("VideoMd5:").append(this.videoMd5).append("\n");
        sb.append("VideoUrl:").append(this.videoUrl).append("\n");
        sb.append("UserMessage").append(this.userMessage).append("\n");
        return sb.toString();
    }
}
