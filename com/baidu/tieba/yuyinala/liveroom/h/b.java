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
    private h olM;
    private a oqd;
    private c oqe;
    private com.baidu.tieba.yuyinala.liveroom.h.a oqf;
    public da oqg;
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
        boolean ceJ();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        OG();
    }

    public void a(a aVar) {
        this.oqd = aVar;
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
                ciK();
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
        this.oqe = new c();
        this.oqg = new da();
        this.oqg.parserJson(com.baidu.live.d.Ba().getString("guide_follow_float_config", "{}"));
        this.mTips = this.oqg.aVg;
        String string = com.baidu.live.d.Ba().getString("guide_follow_float_times_date_yuyin", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.oqe.hFa = jSONObject.optBoolean("hasShowMax");
                    if (!this.oqe.hFa) {
                        this.oqe.date = b2;
                        this.oqe.bsA = jSONObject.optInt("times");
                        this.oqe.oqj = jSONObject.optInt("clickTimes");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void OF() {
        if (this.oqe == null) {
            this.oqe = new c();
        }
        String str = this.oqe.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.oqe.hFa = false;
            this.oqe.bsA = 0;
        }
    }

    private void ciK() {
        int i;
        if (!this.hEQ && TbadkCoreApplication.isLogin() && !this.oqe.hFa && this.oqg != null) {
            if (!k.b(new Date()).equals(this.oqe.date) || this.oqe.bsA < this.oqg.aVf) {
                if ((!k.b(new Date()).equals(this.oqe.date) || this.oqe.bsA < this.oqg.aVf - 1 || this.oqe.oqj != 0) && (i = this.oqg.aVe) > 0) {
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
        if (z && this.hET && !this.hEU && !this.oqe.hFa && this.oqd != null && !this.oqd.ceJ()) {
            ciM();
        }
    }

    private void ciM() {
        this.hEQ = true;
        ciN();
        ciO();
    }

    private void ciN() {
        if (this.oqf == null) {
            this.oqf = new d(this.mPageContext.getPageActivity());
            this.oqf.a(new a.InterfaceC0899a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.h.a.InterfaceC0899a
                public void onConfirm() {
                    b.this.ecP();
                    b.this.ecR();
                    b.this.ecO();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.oqf.p(this.hEO, this.hEP, this.mTips);
            ecS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecO() {
        String b2 = k.b(new Date());
        if (b2.equals(this.oqe.date)) {
            this.oqe.oqj++;
        } else {
            this.oqe.date = b2;
            this.oqe.oqj = 1;
        }
        com.baidu.live.d.Ba().putString("guide_follow_float_times_date_yuyin", this.oqe.toJsonString());
    }

    private void ciO() {
        String b2 = k.b(new Date());
        if (b2.equals(this.oqe.date)) {
            this.oqe.bsA++;
        } else {
            this.oqe.date = b2;
            this.oqe.bsA = 1;
        }
        if (com.baidu.live.af.a.SE().bwi != null && com.baidu.live.af.a.SE().bwi.aOM != null && this.oqg != null) {
            if (this.oqe.bsA >= this.oqg.aVf) {
                this.oqe.hFa = true;
            }
            com.baidu.live.d.Ba().putString("guide_follow_float_times_date_yuyin", this.oqe.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecP() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
        } else if (BdUtilHelper.isNetOk()) {
            if (this.aGe != null && this.aGe.aLl != null) {
                this.oqf.Ni(3);
                this.olM = new h(this.mPageContext.getPageActivity());
                this.olM.y(this.aGe.aLl.aVu, this.aGe.aLl.live_id, 1);
                this.olM.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                        b.this.oqf.Ni(4);
                        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.If();
                            }
                        }, 1000L);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "收藏成功，将收到房间的开播提醒", 3000);
                        MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, b.this.aGe.aLl.live_id)));
                        b.this.ecQ();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void onFail(int i, String str) {
                        b.this.oqf.Ni(1);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "房间收藏失败", 3000);
                    }
                });
            }
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，收藏失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecQ() {
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
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.oqf != null) {
            this.oqf.dismiss();
            this.oqf = null;
        }
    }

    public void bnO() {
        if (this.oqf != null && this.oqf.isShowing()) {
            this.oqf.ciI();
        }
    }

    public void ecR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
            jSONObject.put("show_num", this.oqe.bsA);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "collectguide_clk").setContentExt(null, "popup", jSONObject));
    }

    public void ecS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
            jSONObject.put("show_num", this.oqe.bsA + 1);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "collectguide_show").setContentExt(null, "popup", jSONObject));
    }
}
