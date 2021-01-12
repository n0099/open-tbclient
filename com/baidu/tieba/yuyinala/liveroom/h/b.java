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
/* loaded from: classes10.dex */
public class b {
    private x aBr;
    private long brk;
    private String hAi;
    private String hAj;
    private boolean hAk;
    private TbPageContext mPageContext;
    private String mTips;
    private h ohg;
    private a olv;
    private c olw;
    private com.baidu.tieba.yuyinala.liveroom.h.a olx;
    public da oly;
    private boolean hAn = true;
    private boolean hAo = false;
    private CustomMessageListener aZa = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.aBr == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x)) {
                b.this.aBr = (x) customResponsedMessage.getData();
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        boolean caS();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        KL();
    }

    public void a(a aVar) {
        this.olv = aVar;
    }

    public void f(x xVar) {
        if (xVar != null) {
            this.hAk = false;
            dd ddVar = xVar.aGy;
            if (ddVar != null) {
                try {
                    this.brk = Long.parseLong(ddVar.live_id);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.hAi = ddVar.cover;
                this.hAj = ddVar.room_name;
                KK();
                registerListener();
                ceT();
            }
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.aZa);
    }

    public void og(boolean z) {
        this.hAn = z;
    }

    private void HJ() {
        this.hAk = false;
        this.aBr = null;
        Ek();
        LiveTimerManager.getInstance().removeLiveTimerTask("yuyin_guide_follow_float", true);
        MessageManager.getInstance().unRegisterListener(this.aZa);
    }

    public void onDestroy() {
        HJ();
    }

    private void KL() {
        this.olw = new c();
        this.oly = new da();
        this.oly.parserJson(com.baidu.live.d.xf().getString("guide_follow_float_config", "{}"));
        this.mTips = this.oly.aQt;
        String string = com.baidu.live.d.xf().getString("guide_follow_float_times_date_yuyin", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.olw.hAu = jSONObject.optBoolean("hasShowMax");
                    if (!this.olw.hAu) {
                        this.olw.date = b2;
                        this.olw.bnO = jSONObject.optInt("times");
                        this.olw.olB = jSONObject.optInt("clickTimes");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void KK() {
        if (this.olw == null) {
            this.olw = new c();
        }
        String str = this.olw.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.olw.hAu = false;
            this.olw.bnO = 0;
        }
    }

    private void ceT() {
        int i;
        if (!this.hAk && TbadkCoreApplication.isLogin() && !this.olw.hAu && this.oly != null) {
            if (!k.b(new Date()).equals(this.olw.date) || this.olw.bnO < this.oly.aQs) {
                if ((!k.b(new Date()).equals(this.olw.date) || this.olw.bnO < this.oly.aQs - 1 || this.olw.olB != 0) && (i = this.oly.aQr) > 0) {
                    LiveTimerManager.getInstance().addLiveTimerTask("yuyin_guide_follow_float", this.brk, new OnLiveTimerListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.2
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z) {
                            b.this.oi(z);
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
    public void oi(boolean z) {
        if (z && this.hAn && !this.hAo && !this.olw.hAu && this.olv != null && !this.olv.caS()) {
            ceV();
        }
    }

    private void ceV() {
        this.hAk = true;
        ceW();
        ceX();
    }

    private void ceW() {
        if (this.olx == null) {
            this.olx = new d(this.mPageContext.getPageActivity());
            this.olx.a(new a.InterfaceC0920a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.h.a.InterfaceC0920a
                public void onConfirm() {
                    b.this.dYY();
                    b.this.dZa();
                    b.this.dYX();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.olx.o(this.hAi, this.hAj, this.mTips);
            dZb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYX() {
        String b2 = k.b(new Date());
        if (b2.equals(this.olw.date)) {
            this.olw.olB++;
        } else {
            this.olw.date = b2;
            this.olw.olB = 1;
        }
        com.baidu.live.d.xf().putString("guide_follow_float_times_date_yuyin", this.olw.toJsonString());
    }

    private void ceX() {
        String b2 = k.b(new Date());
        if (b2.equals(this.olw.date)) {
            this.olw.bnO++;
        } else {
            this.olw.date = b2;
            this.olw.bnO = 1;
        }
        if (com.baidu.live.af.a.OJ().bru != null && com.baidu.live.af.a.OJ().bru.aJZ != null && this.oly != null) {
            if (this.olw.bnO >= this.oly.aQs) {
                this.olw.hAu = true;
            }
            com.baidu.live.d.xf().putString("guide_follow_float_times_date_yuyin", this.olw.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYY() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
        } else if (BdUtilHelper.isNetOk()) {
            if (this.aBr != null && this.aBr.aGy != null) {
                this.olx.LB(3);
                this.ohg = new h(this.mPageContext.getPageActivity());
                this.ohg.y(this.aBr.aGy.aQH, this.aBr.aGy.live_id, 1);
                this.ohg.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                        b.this.olx.LB(4);
                        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.Ek();
                            }
                        }, 1000L);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "收藏成功，将收到房间的开播提醒", 3000);
                        MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, b.this.aBr.aGy.live_id)));
                        b.this.dYZ();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void onFail(int i, String str) {
                        b.this.olx.LB(1);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "房间收藏失败", 3000);
                    }
                });
            }
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，收藏失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.aQH);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void Ek() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.olx != null) {
            this.olx.dismiss();
            this.olx = null;
        }
    }

    public void bjV() {
        if (this.olx != null && this.olx.isShowing()) {
            this.olx.ceR();
        }
    }

    public void dZa() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
            jSONObject.put("show_num", this.olw.bnO);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "collectguide_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
    }

    public void dZb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
            jSONObject.put("show_num", this.olw.bnO + 1);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "collectguide_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
    }
}
