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
/* loaded from: classes10.dex */
public class b {
    private ab aED;
    private long bwn;
    private String hGp;
    private String hGq;
    private boolean hGr;
    private TbPageContext mPageContext;
    private String mTips;
    private h otG;
    private a oxT;
    private c oxU;
    private com.baidu.tieba.yuyinala.liveroom.h.a oxV;
    public dg oxW;
    private boolean hGu = true;
    private boolean hGv = false;
    private CustomMessageListener bdI = new CustomMessageListener(2501033) { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.aED == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                b.this.aED = (ab) customResponsedMessage.getData();
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        boolean cbZ();
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        Mm();
    }

    public void a(a aVar) {
        this.oxT = aVar;
    }

    public void h(ab abVar) {
        if (abVar != null) {
            this.hGr = false;
            dj djVar = abVar.aKu;
            if (djVar != null) {
                try {
                    this.bwn = Long.parseLong(djVar.live_id);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.hGp = djVar.cover;
                this.hGq = djVar.room_name;
                Ml();
                registerListener();
                cfZ();
            }
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.bdI);
    }

    public void oq(boolean z) {
        this.hGu = z;
    }

    private void Jc() {
        this.hGr = false;
        this.aED = null;
        FD();
        LiveTimerManager.getInstance().removeLiveTimerTask("yuyin_guide_follow_float", true);
        MessageManager.getInstance().unRegisterListener(this.bdI);
    }

    public void onDestroy() {
        Jc();
    }

    private void Mm() {
        this.oxU = new c();
        this.oxW = new dg();
        this.oxW.parserJson(com.baidu.live.d.xf().getString("guide_follow_float_config", "{}"));
        this.mTips = this.oxW.aUW;
        String string = com.baidu.live.d.xf().getString("guide_follow_float_times_date_yuyin", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("date");
                String b = k.b(new Date());
                if (optString.equals(b)) {
                    this.oxU.hGB = jSONObject.optBoolean("hasShowMax");
                    if (!this.oxU.hGB) {
                        this.oxU.date = b;
                        this.oxU.bsP = jSONObject.optInt("times");
                        this.oxU.oxZ = jSONObject.optInt("clickTimes");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Ml() {
        if (this.oxU == null) {
            this.oxU = new c();
        }
        String str = this.oxU.date;
        if (!TextUtils.isEmpty(str) && !str.equals(k.b(new Date()))) {
            this.oxU.hGB = false;
            this.oxU.bsP = 0;
        }
    }

    private void cfZ() {
        int i;
        if (!this.hGr && TbadkCoreApplication.isLogin() && !this.oxU.hGB && this.oxW != null) {
            if (!k.b(new Date()).equals(this.oxU.date) || this.oxU.bsP < this.oxW.aUV) {
                if ((!k.b(new Date()).equals(this.oxU.date) || this.oxU.bsP < this.oxW.aUV - 1 || this.oxU.oxZ != 0) && (i = this.oxW.aUU) > 0) {
                    LiveTimerManager.getInstance().addLiveTimerTask("yuyin_guide_follow_float", this.bwn, new OnLiveTimerListener() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.2
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
        if (z && this.hGu && !this.hGv && !this.oxU.hGB && this.oxT != null && !this.oxT.cbZ()) {
            cgb();
        }
    }

    private void cgb() {
        this.hGr = true;
        cgc();
        cgd();
    }

    private void cgc() {
        if (this.oxV == null) {
            this.oxV = new d(this.mPageContext.getPageActivity());
            this.oxV.a(new a.InterfaceC0932a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.3
                @Override // com.baidu.tieba.yuyinala.liveroom.h.a.InterfaceC0932a
                public void onConfirm() {
                    b.this.ebA();
                    b.this.ebC();
                    b.this.ebz();
                }
            });
        }
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.oxV.o(this.hGp, this.hGq, this.mTips);
            ebD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebz() {
        String b = k.b(new Date());
        if (b.equals(this.oxU.date)) {
            this.oxU.oxZ++;
        } else {
            this.oxU.date = b;
            this.oxU.oxZ = 1;
        }
        com.baidu.live.d.xf().putString("guide_follow_float_times_date_yuyin", this.oxU.toJsonString());
    }

    private void cgd() {
        String b = k.b(new Date());
        if (b.equals(this.oxU.date)) {
            this.oxU.bsP++;
        } else {
            this.oxU.date = b;
            this.oxU.bsP = 1;
        }
        if (com.baidu.live.ae.a.Qm().bwx != null && com.baidu.live.ae.a.Qm().bwx.aOm != null && this.oxW != null) {
            if (this.oxU.bsP >= this.oxW.aUV) {
                this.oxU.hGB = true;
            }
            com.baidu.live.d.xf().putString("guide_follow_float_times_date_yuyin", this.oxU.toJsonString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebA() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mPageContext.getPageActivity());
        } else if (BdUtilHelper.isNetOk()) {
            if (this.aED != null && this.aED.aKu != null) {
                this.oxV.Mb(3);
                this.otG = new h(this.mPageContext.getPageActivity());
                this.otG.y(this.aED.aKu.aVk, this.aED.aKu.live_id, 1);
                this.otG.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4
                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                        b.this.oxV.Mb(4);
                        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.h.b.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.FD();
                            }
                        }, 1000L);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "收藏成功，将收到房间的开播提醒", 3000);
                        MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, b.this.aED.aKu.live_id)));
                        b.this.ebB();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                    public void onFail(int i, String str) {
                        b.this.oxV.Mb(1);
                        BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "房间收藏失败", 3000);
                    }
                });
            }
        } else {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), "网络不好，收藏失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.aVk);
            jSONObject.put("loc", UbcStatConstant.KEY_CONTENT_ROOM);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    public void FD() {
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing() && this.oxV != null) {
            this.oxV.dismiss();
            this.oxV = null;
        }
    }

    public void bkr() {
        if (this.oxV != null && this.oxV.isShowing()) {
            this.oxV.cfX();
        }
    }

    public void ebC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
            jSONObject.put("show_num", this.oxU.bsP);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "collectguide_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
    }

    public void ebD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
            jSONObject.put("show_num", this.oxU.bsP + 1);
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "collectguide_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
