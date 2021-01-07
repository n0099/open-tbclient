package com.baidu.tieba.yuyinala.liveroom.j;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.af.f;
import com.baidu.live.gift.aj;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes11.dex */
public class d extends a {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0098, code lost:
        if (r28.oqz == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009a, code lost:
        r28.oqz.VO(r28.giftId);
     */
    @Override // com.baidu.tieba.yuyinala.liveroom.j.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void ecZ() {
        if (!TextUtils.isEmpty(this.bqE) && !TextUtils.isEmpty(this.bqG)) {
            if (this.isShow == 1) {
                aj.b(this.bqG, this.oqy.userId, this.oqy.portrait, this.oqy.getNameShow(), String.valueOf(this.liveId), String.valueOf(this.groupId), false, String.valueOf(this.hAS), this.appId, this.bqE, "", "", this.msgId, this.boI);
                try {
                    JSONArray jSONArray = new JSONArray(this.bqG);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= jSONArray.length()) {
                                break;
                            }
                            if (f.SV().ik(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
            aj.b(this.giftId, JavaTypesHelper.toInt(this.bpq, 1), this.giftName, this.aYy, this.oqy.userId, this.oqy.portrait, this.oqy.getNameShow(), String.valueOf(this.liveId), String.valueOf(this.groupId), false, String.valueOf(this.hAS), this.appId, this.beQ, "", "", this.msgId, this.boI, this.isDynamic, this.bZN, this.aZQ, this.bZO, this.bZP);
            if (this.oqz != null) {
                this.oqz.VO(this.giftId);
            }
        }
        com.baidu.tieba.yuyinala.liveroom.i.c cVar = new com.baidu.tieba.yuyinala.liveroom.i.c();
        cVar.bqF = this.bqF;
        cVar.liveId = this.liveId;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
    }
}
