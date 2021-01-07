package com.baidu.tieba.yuyinala.liveroom.h;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.da;
import com.baidu.live.data.dd;
import com.baidu.live.data.x;
import com.baidu.live.message.FollowRoom;
import com.baidu.live.message.YuyinFollowRoomMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.tieba.yuyinala.liveroom.h.a;
import com.baidu.tieba.yuyinala.liveroom.roomcard.AlaGetCollectRoomHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.roomcard.h;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private x aGe;
    private long bvY;
    private String hEO;
    private String hEP;
    private boolean hEQ;
    private TbPageContext mPageContext;
    private String mTips;
    private h olL;
    private a oqc;
    private c oqd;
    private com.baidu.tieba.yuyinala.liveroom.h.a oqe;
    public da oqf;
    private boolean hET = true;
    private boolean hEU = false;
    private CustomMessageListener bdO = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.aGe == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                b.this.aGe = (x) customResponsedMessage.getData();
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        boolean ceK();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        OG();
    }

    public void a(a aVar) {
        this.oqc = aVar;
    }

    public void f(x xVar) {
        if (xVar != null) {
            this.hEQ = false;
            dd ddVar = xVar.aLl;
            if (ddVar != null) {
                try {
                    this.bvY = Long.parseLong(ddVar.live_id);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.hEO = ddVar.cover;
                this.hEP = ddVar.room_name;
                OF();
                registerListener();
                ciL();
            }
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bdO);
    }

    public void ok(boolean z) {
        this.hET = z;
    }

    private void LE() {
        this.hEQ = false;
        this.aGe = null;
        If();
        LiveTimerManager.getInstance().removeLiveTimerTask("yuyin_guide_follow_float", true);
        MessageManager.getInstance().unRegisterListener(this.bdO);
    }

    public void onDestroy() {
        LE();
    }

    private void OG() {
        this.oqd = new c();
        this.oqf = new da();
        this.oqf.parserJson(com.baidu.live.d.Ba().getString("guide_follow_float_config", "{}"));
        this.mTips = this.oqf.aVg;
        String string = com.baidu.live.d.Ba().getString("guide_follow_float_times_date_yuyin", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.oqd.hFa = jSONObject.optBoolean("hasShowMax");
                    if (!this.oqd.hFa) {
                        this.oqd.date = b2;
                        this.oqd.bsA = jSONObject.optInt("times");
                        this.oqd.oqi = jSONObject.optInt("clickTimes");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void OF() {
        if (this.oqd == null) {
            this.oqd = new c();
        }
        String str = this.oqd.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.oqd.hFa = false;
            this.oqd.bsA = 0;
        }
    }

    private void ciL() {
        int i;
        if (!this.hEQ && TbadkCoreApplication.isLogin() && !this.oqd.hFa && this.oqf != null) {
            if (!k.b(new Date()).equals(this.oqd.date) || this.oqd.bsA < this.oqf.aVf) {
                if ((!k.b(new Date()).equals(this.oqd.date) || this.oqd.bsA < this.oqf.aVf - 1 || this.oqd.oqi != 0) && (i = this.oqf.aVe) > 0) {
                    LiveTimerManager.getInstance().addLiveTimerTask("yuyin_guide_follow_float", this.bvY, new OnLiveTimerListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.2
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z) {
                            b.this.om(z);
                        }

                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onInterrupt() {
                        }
                    }, i * 1000, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om(boolean z) {
        if (z && this.hET && !this.hEU && !this.oqd.hFa && this.oqc != null && !this.oqc.ceK()) {
            ciN();
        }
    }

    private void ciN() {
        this.hEQ = true;
        ciO();
        ciP();
    }

    private void ciO() {
        if (this.oqe == null) {
            this.oqe = new d(this.mPageContext.getPageActivity());
            this.oqe.a(new a.InterfaceC0937a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.h.a.InterfaceC0937a
                public void onConfirm() {
                    b.this.ecQ();
                    b.this.ecS();
                    b.this.ecP();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.oqe.p(this.hEO, this.hEP, this.mTips);
            ecT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecP() {
        String b2 = k.b(new Date());
        if (b2.equals(this.oqd.date)) {
            this.oqd.oqi++;
        } else {
            this.oqd.date = b2;
            this.oqd.oqi = 1;
        }
        com.baidu.live.d.Ba().putString("guide_follow_float_times_date_yuyin", this.oqd.toJsonString());
    }

    private void ciP() {
        String b2 = k.b(new Date());
        if (b2.equals(this.oqd.date)) {
            this.oqd.bsA++;
        } else {
            this.oqd.date = b2;
            this.oqd.bsA = 1;
        }
        if (com.baidu.live.af.a.SE().bwi != null && com.baidu.live.af.a.SE().bwi.aOM != null && this.oqf != null) {
            if (this.oqd.bsA >= this.oqf.aVf) {
                this.oqd.hFa = true;
            }
            com.baidu.live.d.Ba().putString("guide_follow_float_times_date_yuyin", this.oqd.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecQ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
        } else if (BdUtilHelper.isNetOk()) {
            if (this.aGe != null && this.aGe.aLl != null) {
                this.oqe.Ni(3);
                this.olL = new h(this.mPageContext.getPageActivity());
                this.olL.y(this.aGe.aLl.aVu, this.aGe.aLl.live_id, 1);
                this.olL.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                        b.this.oqe.Ni(4);
                        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.If();
                            }
                        }, 1000L);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "收藏成功，将收到房间的开播提醒", 3000);
                        MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, b.this.aGe.aLl.live_id)));
                        b.this.ecR();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void onFail(int i, String str) {
                        b.this.oqe.Ni(1);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "房间收藏失败", 3000);
                    }
                });
            }
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，收藏失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.aVu);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void If() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.oqe != null) {
            this.oqe.dismiss();
            this.oqe = null;
        }
    }

    public void bnP() {
        if (this.oqe != null && this.oqe.isShowing()) {
            this.oqe.ciJ();
        }
    }

    public void ecS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
            jSONObject.put("show_num", this.oqd.bsA);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "collectguide_clk").setContentExt(null, "popup", jSONObject));
    }

    public void ecT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
            jSONObject.put("show_num", this.oqd.bsA + 1);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "collectguide_show").setContentExt(null, "popup", jSONObject));
    }
}
