package com.baidu.tieba.yuyinala.liveroom.j;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.yuyinala.liveroom.j.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class a {
    protected String aYq;
    protected long aZL;
    protected String appId;
    protected String beJ;
    protected String boO;
    protected String bpw;
    protected String bqM;
    protected long bqN;
    protected String bqO;
    protected boolean caD;
    protected int caE;
    protected boolean caF;
    protected String giftId;
    protected String giftName;
    protected long groupId;
    protected long hCt;
    protected boolean isDynamic;
    protected int isShow;
    protected long liveId;
    protected long msgId;
    protected com.baidu.live.data.a oyp;
    protected c.a oyq;

    protected abstract void ebJ();

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, com.baidu.live.im.data.b bVar, JSONObject jSONObject, c.a aVar2) {
        this.oyq = aVar2;
        this.oyp = bVar.Lc();
        this.msgId = bVar.getMsgId();
        this.boO = bVar.boO;
        this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
        this.bpw = jSONObject.optString("gift_count");
        this.giftName = jSONObject.optString("gift_name");
        this.aYq = jSONObject.optString("gift_url");
        this.beJ = jSONObject.optString("attach");
        this.bqN = jSONObject.optLong("charm_total");
        this.bqM = jSONObject.optString("attach_new");
        this.bqO = jSONObject.optString("gift_mul");
        this.isDynamic = jSONObject.optInt("is_dynamic_gift") == 1;
        this.caD = jSONObject.optInt("is_comboGift") == 1;
        this.caE = jSONObject.optInt("combo_count");
        this.caF = jSONObject.optInt("combo_finish") != 0;
        this.aZL = jSONObject.optLong("combo_groupid");
        this.isShow = jSONObject.optInt("flag_show");
        this.liveId = 0L;
        this.groupId = 0L;
        this.hCt = 0L;
        if (aVar.owJ != null && aVar.owJ.Fp() != null && aVar.owJ.Fp().mLiveInfo != null) {
            this.liveId = aVar.owJ.Fp().mLiveInfo.live_id;
            this.groupId = aVar.owJ.Fp().mLiveInfo.group_id;
            this.hCt = aVar.owJ.Fp().aJD.userId;
            this.appId = aVar.owJ.Fp().mLiveInfo.appId;
        }
        ebJ();
    }
}
