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
    private String hEG;
    private String hEH;
    private boolean hEI;
    private TbPageContext mPageContext;
    private String mTips;
    private h orB;
    private a ovO;
    private c ovP;
    private com.baidu.tieba.yuyinala.liveroom.h.a ovQ;
    public dg ovR;
    private boolean hEL = true;
    private boolean hEM = false;
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
        boolean cbT();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        Mj();
    }

    public void a(a aVar) {
        this.ovO = aVar;
    }

    public void h(ab abVar) {
        if (abVar != null) {
            this.hEI = false;
            dj djVar = abVar.aIU;
            if (djVar != null) {
                try {
                    this.buN = Long.parseLong(djVar.live_id);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.hEG = djVar.cover;
                this.hEH = djVar.room_name;
                Mi();
                registerListener();
                cfT();
            }
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bci);
    }

    public void oq(boolean z) {
        this.hEL = z;
    }

    private void IZ() {
        this.hEI = false;
        this.aDd = null;
        FA();
        LiveTimerManager.getInstance().removeLiveTimerTask("yuyin_guide_follow_float", true);
        MessageManager.getInstance().unRegisterListener(this.bci);
    }

    public void onDestroy() {
        IZ();
    }

    private void Mj() {
        this.ovP = new c();
        this.ovR = new dg();
        this.ovR.parserJson(com.baidu.live.d.xc().getString("guide_follow_float_config", "{}"));
        this.mTips = this.ovR.aTw;
        String string = com.baidu.live.d.xc().getString("guide_follow_float_times_date_yuyin", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b2 = k.b(new Date());
                if (optString.equals(b2)) {
                    this.ovP.hES = jSONObject.optBoolean("hasShowMax");
                    if (!this.ovP.hES) {
                        this.ovP.date = b2;
                        this.ovP.brp = jSONObject.optInt("times");
                        this.ovP.ovU = jSONObject.optInt("clickTimes");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Mi() {
        if (this.ovP == null) {
            this.ovP = new c();
        }
        String str = this.ovP.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.ovP.hES = false;
            this.ovP.brp = 0;
        }
    }

    private void cfT() {
        int i;
        if (!this.hEI && TbadkCoreApplication.isLogin() && !this.ovP.hES && this.ovR != null) {
            if (!k.b(new Date()).equals(this.ovP.date) || this.ovP.brp < this.ovR.aTv) {
                if ((!k.b(new Date()).equals(this.ovP.date) || this.ovP.brp < this.ovR.aTv - 1 || this.ovP.ovU != 0) && (i = this.ovR.aTu) > 0) {
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
        if (z && this.hEL && !this.hEM && !this.ovP.hES && this.ovO != null && !this.ovO.cbT()) {
            cfV();
        }
    }

    private void cfV() {
        this.hEI = true;
        cfW();
        cfX();
    }

    private void cfW() {
        if (this.ovQ == null) {
            this.ovQ = new d(this.mPageContext.getPageActivity());
            this.ovQ.a(new a.InterfaceC0926a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.h.a.InterfaceC0926a
                public void onConfirm() {
                    b.this.ebs();
                    b.this.ebu();
                    b.this.ebr();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.ovQ.o(this.hEG, this.hEH, this.mTips);
            ebv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebr() {
        String b2 = k.b(new Date());
        if (b2.equals(this.ovP.date)) {
            this.ovP.ovU++;
        } else {
            this.ovP.date = b2;
            this.ovP.ovU = 1;
        }
        com.baidu.live.d.xc().putString("guide_follow_float_times_date_yuyin", this.ovP.toJsonString());
    }

    private void cfX() {
        String b2 = k.b(new Date());
        if (b2.equals(this.ovP.date)) {
            this.ovP.brp++;
        } else {
            this.ovP.date = b2;
            this.ovP.brp = 1;
        }
        if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aMM != null && this.ovR != null) {
            if (this.ovP.brp >= this.ovR.aTv) {
                this.ovP.hES = true;
            }
            com.baidu.live.d.xc().putString("guide_follow_float_times_date_yuyin", this.ovP.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebs() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
        } else if (BdUtilHelper.isNetOk()) {
            if (this.aDd != null && this.aDd.aIU != null) {
                this.ovQ.LX(3);
                this.orB = new h(this.mPageContext.getPageActivity());
                this.orB.y(this.aDd.aIU.aTK, this.aDd.aIU.live_id, 1);
                this.orB.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                        b.this.ovQ.LX(4);
                        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.FA();
                            }
                        }, 1000L);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "收藏成功，将收到房间的开播提醒", 3000);
                        MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, b.this.aDd.aIU.live_id)));
                        b.this.ebt();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void onFail(int i, String str) {
                        b.this.ovQ.LX(1);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "房间收藏失败", 3000);
                    }
                });
            }
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，收藏失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebt() {
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
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.ovQ != null) {
            this.ovQ.dismiss();
            this.ovQ = null;
        }
    }

    public void bkp() {
        if (this.ovQ != null && this.ovQ.isShowing()) {
            this.ovQ.cfR();
        }
    }

    public void ebu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
            jSONObject.put("show_num", this.ovP.brp);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "collectguide_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
    }

    public void ebv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
            jSONObject.put("show_num", this.ovP.brp + 1);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "collectguide_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
