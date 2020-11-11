package com.baidu.yuyinala.privatemessage.model.message;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SingleGraphicTextMsgExt {
    public String groupId;
    public SignleGraphicTextMsg oFN;
    public String oFO;
    public double oFP;
    public String vid;
    public String videoDuration;

    /* loaded from: classes4.dex */
    public enum SingleGraphicTextType {
        DEFAULT,
        VIDEOSHARE,
        PRIVATEINVITE
    }

    public SingleGraphicTextMsgExt(SignleGraphicTextMsg signleGraphicTextMsg) {
        this.oFN = signleGraphicTextMsg;
        try {
            JSONObject jSONObject = new JSONObject(signleGraphicTextMsg.getMsgContent());
            this.oFO = jSONObject.optString("quanminUrl");
            this.groupId = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
            this.oFP = jSONObject.optDouble("coverHW");
            this.videoDuration = jSONObject.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "0:00");
            this.vid = jSONObject.optString("vid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public SingleGraphicTextType eim() {
        if (!TextUtils.isEmpty(this.oFO)) {
            return SingleGraphicTextType.VIDEOSHARE;
        }
        if (!TextUtils.isEmpty(this.groupId)) {
            return SingleGraphicTextType.PRIVATEINVITE;
        }
        return SingleGraphicTextType.DEFAULT;
    }
}
