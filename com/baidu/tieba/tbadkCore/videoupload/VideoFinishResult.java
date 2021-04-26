package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class VideoFinishResult implements Serializable {
    public static final String KEY_ERROR = "error";
    public static final String KEY_ERROR_MSG = "errmsg";
    public static final String KEY_ERROR_NO = "errno";
    public static final String KEY_ERROR_USER_MSG = "usermsg";
    public static final String KEY_VIDEO_MD5 = "video_md5";
    public static final String KEY_VIDEO_URL = "video_url";
    public static final long serialVersionUID = 6275774083063164456L;
    public String errorMessage;
    public int errorNo;
    public String userMessage;
    public String videoMd5;
    public String videoUrl;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getErrorNo() {
        return this.errorNo;
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

    public boolean isSuccess() {
        return (this.errorNo != 0 || StringUtils.isNull(this.videoMd5) || StringUtils.isNull(this.videoUrl)) ? false : true;
    }

    public void parseJson(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.errorNo = optJSONObject.optInt("errno");
                this.errorMessage = optJSONObject.optString("errmsg");
                this.userMessage = optJSONObject.optString(KEY_ERROR_USER_MSG);
            }
            this.videoMd5 = jSONObject.optString(KEY_VIDEO_MD5);
            this.videoUrl = jSONObject.optString("video_url");
        } catch (JSONException unused) {
        }
        if ((StringUtils.isNull(this.videoMd5) || StringUtils.isNull(this.videoUrl)) && this.errorNo == 0) {
            this.errorNo = -3;
            this.errorMessage = TbErrInfo.getErrMsg(-3);
            this.userMessage = TbErrInfo.getErrMsg(-3);
        }
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setErrorNo(int i2) {
        this.errorNo = i2;
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
}
