package com.baidu.tieba.yuyinala.liveroom.h;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.data.dg;
import com.baidu.live.data.dj;
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
    private ab aDd;
    private long buN;
    private String hEs;
    private String hEt;
    private boolean hEu;
    private TbPageContext mPageContext;
    private String mTips;
    private h ora;
    private a ovo;
    private c ovp;
    private com.baidu.tieba.yuyinala.liveroom.h.a ovq;
    public dg ovr;
    private boolean hEx = true;
    private boolean hEy = false;
    private CustomMessageListener bci = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.aDd == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                b.this.aDd = (ab) customResponsedMessage.getData();
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        boolean cbM();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        Mj();
    }

    public void a(a aVar) {
        this.ovo = aVar;
    }

    public void h(ab abVar) {
        if (abVar != null) {
            this.hEu = false;
            dj djVar = abVar.aIU;
            if (djVar != null) {
                try {
                    this.buN = Long.parseLong(djVar.live_id);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.hEs = djVar.cover;
                this.hEt = djVar.room_name;
                Mi();
                registerListener();
                cfM();
            }
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bci);
    }

    public void oq(boolean z) {
        this.hEx = z;
    }

    private void IZ() {
        this.hEu = false;
        this.aDd = null;
        FA();
        LiveTimerManager.getInstance().removeLiveTimerTask("yuyin_guide_follow_float", true);
        MessageManager.getInstance().unRegisterListener(this.bci);
    }

    public void onDestroy() {
        IZ();
    }

    private void Mj() {
        this.ovp = new c();
        this.ovr = new dg();
        this.ovr.parserJson(com.baidu.live.d.xc().getString("guide_follow_float_config", "{}"));
        this.mTips = this.ovr.aTw;
        String string = com.baidu.live.d.xc().getString("guide_follow_float_times_date_yuyin", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.ovp.hEE = jSONObject.optBoolean("hasShowMax");
                    if (!this.ovp.hEE) {
                        this.ovp.date = b2;
                        this.ovp.brp = jSONObject.optInt("times");
                        this.ovp.ovu = jSONObject.optInt("clickTimes");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Mi() {
        if (this.ovp == null) {
            this.ovp = new c();
        }
        String str = this.ovp.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.ovp.hEE = false;
            this.ovp.brp = 0;
        }
    }

    private void cfM() {
        int i;
        if (!this.hEu && TbadkCoreApplication.isLogin() && !this.ovp.hEE && this.ovr != null) {
            if (!k.b(new Date()).equals(this.ovp.date) || this.ovp.brp < this.ovr.aTv) {
                if ((!k.b(new Date()).equals(this.ovp.date) || this.ovp.brp < this.ovr.aTv - 1 || this.ovp.ovu != 0) && (i = this.ovr.aTu) > 0) {
                    LiveTimerManager.getInstance().addLiveTimerTask("yuyin_guide_follow_float", this.buN, new OnLiveTimerListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.2
                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                        public void onComplete(boolean z) {
                            b.this.os(z);
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
    public void os(boolean z) {
        if (z && this.hEx && !this.hEy && !this.ovp.hEE && this.ovo != null && !this.ovo.cbM()) {
            cfO();
        }
    }

    private void cfO() {
        this.hEu = true;
        cfP();
        cfQ();
    }

    private void cfP() {
        if (this.ovq == null) {
            this.ovq = new d(this.mPageContext.getPageActivity());
            this.ovq.a(new a.InterfaceC0924a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.h.a.InterfaceC0924a
                public void onConfirm() {
                    b.this.ebk();
                    b.this.ebm();
                    b.this.ebj();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.ovq.o(this.hEs, this.hEt, this.mTips);
            ebn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebj() {
        String b2 = k.b(new Date());
        if (b2.equals(this.ovp.date)) {
            this.ovp.ovu++;
        } else {
            this.ovp.date = b2;
            this.ovp.ovu = 1;
        }
        com.baidu.live.d.xc().putString("guide_follow_float_times_date_yuyin", this.ovp.toJsonString());
    }

    private void cfQ() {
        String b2 = k.b(new Date());
        if (b2.equals(this.ovp.date)) {
            this.ovp.brp++;
        } else {
            this.ovp.date = b2;
            this.ovp.brp = 1;
        }
        if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aMM != null && this.ovr != null) {
            if (this.ovp.brp >= this.ovr.aTv) {
                this.ovp.hEE = true;
            }
            com.baidu.live.d.xc().putString("guide_follow_float_times_date_yuyin", this.ovp.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebk() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
        } else if (BdUtilHelper.isNetOk()) {
            if (this.aDd != null && this.aDd.aIU != null) {
                this.ovq.LW(3);
                this.ora = new h(this.mPageContext.getPageActivity());
                this.ora.y(this.aDd.aIU.aTK, this.aDd.aIU.live_id, 1);
                this.ora.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                        b.this.ovq.LW(4);
                        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.FA();
                            }
                        }, 1000L);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "收藏成功，将收到房间的开播提醒", 3000);
                        MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, b.this.aDd.aIU.live_id)));
                        b.this.ebl();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void onFail(int i, String str) {
                        b.this.ovq.LW(1);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "房间收藏失败", 3000);
                    }
                });
            }
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，收藏失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.aTK);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void FA() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.ovq != null) {
            this.ovq.dismiss();
            this.ovq = null;
        }
    }

    public void bkp() {
        if (this.ovq != null && this.ovq.isShowing()) {
            this.ovq.cfK();
        }
    }

    public void ebm() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
            jSONObject.put("show_num", this.ovp.brp);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "collectguide_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
    }

    public void ebn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
            jSONObject.put("show_num", this.ovp.brp + 1);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "collectguide_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
