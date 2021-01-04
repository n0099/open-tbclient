package com.baidu.tieba.yuyinala.liveroom.j;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.yuyinala.liveroom.j.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class a {
    protected String aYy;
    protected long aZQ;
    protected String appId;
    protected boolean bZN;
    protected int bZO;
    protected boolean bZP;
    protected String beQ;
    protected String boI;
    protected String bpq;
    protected String bqE;
    protected long bqF;
    protected String bqG;
    protected String giftId;
    protected String giftName;
    protected long groupId;
    protected long hAS;
    protected boolean isDynamic;
    protected int isShow;
    protected long liveId;
    protected long msgId;
    protected c.a oqA;
    protected com.baidu.live.data.a oqz;

    protected abstract void ecY();

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, com.baidu.live.im.data.b bVar, JSONObject jSONObject, c.a aVar2) {
        this.oqA = aVar2;
        this.oqz = bVar.Nw();
        this.msgId = bVar.getMsgId();
        this.boI = bVar.boI;
        this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
        this.bpq = jSONObject.optString("gift_count");
        this.giftName = jSONObject.optString("gift_name");
        this.aYy = jSONObject.optString("gift_url");
        this.beQ = jSONObject.optString("attach");
        this.bqF = jSONObject.optLong("charm_total");
        this.bqE = jSONObject.optString("attach_new");
        this.bqG = jSONObject.optString("gift_mul");
        this.isDynamic = jSONObject.optInt("is_dynamic_gift") == 1;
        this.bZN = jSONObject.optInt("is_comboGift") == 1;
        this.bZO = jSONObject.optInt("combo_count");
        this.bZP = jSONObject.optInt("combo_finish") != 0;
        this.aZQ = jSONObject.optLong("combo_groupid");
        this.isShow = jSONObject.optInt("flag_show");
        this.liveId = 0L;
        this.groupId = 0L;
        this.hAS = 0L;
        if (aVar.ooR != null && aVar.ooR.HR() != null && aVar.ooR.HR().mLiveInfo != null) {
            this.liveId = aVar.ooR.HR().mLiveInfo.live_id;
            this.groupId = aVar.ooR.HR().mLiveInfo.group_id;
            this.hAS = aVar.ooR.HR().aKu.userId;
            this.appId = aVar.ooR.HR().mLiveInfo.appId;
        }
        ecY();
    }
}
