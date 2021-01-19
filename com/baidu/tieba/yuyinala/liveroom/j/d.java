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
/* loaded from: classes10.dex */
public class d extends a {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0098, code lost:
        if (r28.olT == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009a, code lost:
        r28.olT.UH(r28.giftId);
     */
    @Override // com.baidu.tieba.yuyinala.liveroom.j.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void dZh() {
        if (!TextUtils.isEmpty(this.blR) && !TextUtils.isEmpty(this.blT)) {
            if (this.isShow == 1) {
                aj.b(this.blT, this.olS.userId, this.olS.portrait, this.olS.getNameShow(), String.valueOf(this.liveId), String.valueOf(this.groupId), false, String.valueOf(this.hwm), this.appId, this.blR, "", "", this.msgId, this.bjV);
                try {
                    JSONArray jSONArray = new JSONArray(this.blT);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= jSONArray.length()) {
                                break;
                            }
                            if (f.Pa().gZ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
            aj.b(this.giftId, JavaTypesHelper.toInt(this.bkD, 1), this.giftName, this.aTL, this.olS.userId, this.olS.portrait, this.olS.getNameShow(), String.valueOf(this.liveId), String.valueOf(this.groupId), false, String.valueOf(this.hwm), this.appId, this.baa, "", "", this.msgId, this.bjV, this.isDynamic, this.bVb, this.aVd, this.bVc, this.bVd);
            if (this.olT != null) {
                this.olT.UH(this.giftId);
            }
        }
        com.baidu.tieba.yuyinala.liveroom.i.c cVar = new com.baidu.tieba.yuyinala.liveroom.i.c();
        cVar.blS = this.blS;
        cVar.liveId = this.liveId;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
    }
}
