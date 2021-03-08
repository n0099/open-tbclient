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
/* loaded from: classes10.dex */
public class d extends a {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0098, code lost:
        if (r28.oyq == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009a, code lost:
        r28.oyq.VY(r28.giftId);
     */
    @Override // com.baidu.tieba.yuyinala.liveroom.j.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void ebJ() {
        if (!TextUtils.isEmpty(this.bqM) && !TextUtils.isEmpty(this.bqO)) {
            if (this.isShow == 1) {
                aj.b(this.bqO, this.oyp.userId, this.oyp.portrait, this.oyp.getNameShow(), String.valueOf(this.liveId), String.valueOf(this.groupId), false, String.valueOf(this.hCt), this.appId, this.bqM, "", "", this.msgId, this.boO);
                try {
                    JSONArray jSONArray = new JSONArray(this.bqO);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= jSONArray.length()) {
                                break;
                            }
                            if (f.QE().hB(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
            aj.b(this.giftId, JavaTypesHelper.toInt(this.bpw, 1), this.giftName, this.aYq, this.oyp.userId, this.oyp.portrait, this.oyp.getNameShow(), String.valueOf(this.liveId), String.valueOf(this.groupId), false, String.valueOf(this.hCt), this.appId, this.beJ, "", "", this.msgId, this.boO, this.isDynamic, this.caD, this.aZL, this.caE, this.caF);
            if (this.oyq != null) {
                this.oyq.VY(this.giftId);
            }
        }
        com.baidu.tieba.yuyinala.liveroom.i.c cVar = new com.baidu.tieba.yuyinala.liveroom.i.c();
        cVar.bqN = this.bqN;
        cVar.liveId = this.liveId;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
    }
}
