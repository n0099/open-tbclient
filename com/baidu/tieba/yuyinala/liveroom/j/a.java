package com.baidu.tieba.yuyinala.liveroom.j;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.yuyinala.liveroom.j.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class a {
    protected String aTL;
    protected long aVd;
    protected String appId;
    protected boolean bVb;
    protected int bVc;
    protected boolean bVd;
    protected String baa;
    protected String bjV;
    protected String bkD;
    protected String blR;
    protected long blS;
    protected String blT;
    protected String giftId;
    protected String giftName;
    protected long groupId;
    protected long hwm;
    protected boolean isDynamic;
    protected int isShow;
    protected long liveId;
    protected long msgId;
    protected com.baidu.live.data.a olR;
    protected c.a olS;

    protected abstract void dZh();

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, com.baidu.live.im.data.b bVar, JSONObject jSONObject, c.a aVar2) {
        this.olS = aVar2;
        this.olR = bVar.JB();
        this.msgId = bVar.getMsgId();
        this.bjV = bVar.bjV;
        this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
        this.bkD = jSONObject.optString("gift_count");
        this.giftName = jSONObject.optString("gift_name");
        this.aTL = jSONObject.optString("gift_url");
        this.baa = jSONObject.optString("attach");
        this.blS = jSONObject.optLong("charm_total");
        this.blR = jSONObject.optString("attach_new");
        this.blT = jSONObject.optString("gift_mul");
        this.isDynamic = jSONObject.optInt("is_dynamic_gift") == 1;
        this.bVb = jSONObject.optInt("is_comboGift") == 1;
        this.bVc = jSONObject.optInt("combo_count");
        this.bVd = jSONObject.optInt("combo_finish") != 0;
        this.aVd = jSONObject.optLong("combo_groupid");
        this.isShow = jSONObject.optInt("flag_show");
        this.liveId = 0L;
        this.groupId = 0L;
        this.hwm = 0L;
        if (aVar.okk != null && aVar.okk.DW() != null && aVar.okk.DW().mLiveInfo != null) {
            this.liveId = aVar.okk.DW().mLiveInfo.live_id;
            this.groupId = aVar.okk.DW().mLiveInfo.group_id;
            this.hwm = aVar.okk.DW().aFH.userId;
            this.appId = aVar.okk.DW().mLiveInfo.appId;
        }
        dZh();
    }
}
