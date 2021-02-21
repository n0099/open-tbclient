package com.baidu.yuyinala.privatemessage.model.message;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SingleGraphicTextMsgExt {
    public String groupId;
    public SignleGraphicTextMsg piG;
    public String piH;
    public double piI;
    public String piJ;
    public String vid;

    /* loaded from: classes11.dex */
    public enum SingleGraphicTextType {
        DEFAULT,
        VIDEOSHARE,
        PRIVATEINVITE
    }

    public SingleGraphicTextMsgExt(SignleGraphicTextMsg signleGraphicTextMsg) {
        this.piG = signleGraphicTextMsg;
        try {
            JSONObject jSONObject = new JSONObject(signleGraphicTextMsg.getMsgContent());
            this.piH = jSONObject.optString("quanminUrl");
            this.groupId = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
            this.piI = jSONObject.optDouble("coverHW");
            this.piJ = jSONObject.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "0:00");
            this.vid = jSONObject.optString("vid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public SingleGraphicTextType emL() {
        if (!TextUtils.isEmpty(this.piH)) {
            return SingleGraphicTextType.VIDEOSHARE;
        }
        if (!TextUtils.isEmpty(this.groupId)) {
            return SingleGraphicTextType.PRIVATEINVITE;
        }
        return SingleGraphicTextType.DEFAULT;
    }
}
