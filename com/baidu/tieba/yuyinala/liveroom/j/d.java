package com.baidu.tieba.yuyinala.liveroom.j;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.ae.f;
import com.baidu.live.gift.aj;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes11.dex */
public class d extends a {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0098, code lost:
        if (r28.owl == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009a, code lost:
        r28.owl.VR(r28.giftId);
     */
    @Override // com.baidu.tieba.yuyinala.liveroom.j.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void ebB() {
        if (!TextUtils.isEmpty(this.bpm) && !TextUtils.isEmpty(this.bpo)) {
            if (this.isShow == 1) {
                aj.b(this.bpo, this.owk.userId, this.owk.portrait, this.owk.getNameShow(), String.valueOf(this.liveId), String.valueOf(this.groupId), false, String.valueOf(this.hAK), this.appId, this.bpm, "", "", this.msgId, this.bno);
                try {
                    JSONArray jSONArray = new JSONArray(this.bpo);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= jSONArray.length()) {
                                break;
                            }
                            if (f.QB().hv(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                break;
                            }
                            i++;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            aj.b(this.giftId, JavaTypesHelper.toInt(this.bnW, 1), this.giftName, this.aWQ, this.owk.userId, this.owk.portrait, this.owk.getNameShow(), String.valueOf(this.liveId), String.valueOf(this.groupId), false, String.valueOf(this.hAK), this.appId, this.bdh, "", "", this.msgId, this.bno, this.isDynamic, this.bZd, this.aYl, this.bZe, this.bZf);
            if (this.owl != null) {
                this.owl.VR(this.giftId);
            }
        }
        com.baidu.tieba.yuyinala.liveroom.i.c cVar = new com.baidu.tieba.yuyinala.liveroom.i.c();
        cVar.bpn = this.bpn;
        cVar.liveId = this.liveId;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
    }
}
