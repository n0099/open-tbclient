package com.baidu.tieba.yuyinala.liveroom.j;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.yuyinala.liveroom.j.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class a {
    protected String aWQ;
    protected long aYl;
    protected String appId;
    protected boolean bZd;
    protected int bZe;
    protected boolean bZf;
    protected String bdh;
    protected String bnW;
    protected String bno;
    protected String bpm;
    protected long bpn;
    protected String bpo;
    protected String giftId;
    protected String giftName;
    protected long groupId;
    protected long hAK;
    protected boolean isDynamic;
    protected int isShow;
    protected long liveId;
    protected long msgId;
    protected com.baidu.live.data.a owk;
    protected c.a owl;

    protected abstract void ebB();

    public void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, com.baidu.live.im.data.b bVar, JSONObject jSONObject, c.a aVar2) {
        this.owl = aVar2;
        this.owk = bVar.KZ();
        this.msgId = bVar.getMsgId();
        this.bno = bVar.bno;
        this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
        this.bnW = jSONObject.optString("gift_count");
        this.giftName = jSONObject.optString("gift_name");
        this.aWQ = jSONObject.optString("gift_url");
        this.bdh = jSONObject.optString("attach");
        this.bpn = jSONObject.optLong("charm_total");
        this.bpm = jSONObject.optString("attach_new");
        this.bpo = jSONObject.optString("gift_mul");
        this.isDynamic = jSONObject.optInt("is_dynamic_gift") == 1;
        this.bZd = jSONObject.optInt("is_comboGift") == 1;
        this.bZe = jSONObject.optInt("combo_count");
        this.bZf = jSONObject.optInt("combo_finish") != 0;
        this.aYl = jSONObject.optLong("combo_groupid");
        this.isShow = jSONObject.optInt("flag_show");
        this.liveId = 0L;
        this.groupId = 0L;
        this.hAK = 0L;
        if (aVar.ouE != null && aVar.ouE.Fm() != null && aVar.ouE.Fm().mLiveInfo != null) {
            this.liveId = aVar.ouE.Fm().mLiveInfo.live_id;
            this.groupId = aVar.ouE.Fm().mLiveInfo.group_id;
            this.hAK = aVar.ouE.Fm().aId.userId;
            this.appId = aVar.ouE.Fm().mLiveInfo.appId;
        }
        ebB();
    }
}
