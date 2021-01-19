package com.baidu.yuyinala.background;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.yuyinala.background.c;
import com.baidu.yuyinala.background.d.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioBackgroundDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0953a {
    private com.baidu.yuyinala.background.d.a oLi;

    public b(TbPageContext tbPageContext, x xVar) {
        super(tbPageContext, new c(tbPageContext), null);
        ((c) this.bFO).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bFO).a((c.a) this);
        eI(80);
        cW(true);
        cX(true);
        this.oLi = new com.baidu.yuyinala.background.d.a(xVar, this);
        a((DialogInterface.OnDismissListener) this.bFO);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void loadData() {
        this.oLi.egE();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        this.oLi.a(aVar, bitmap);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, String str) {
        this.oLi.a(aVar, str);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void ego() {
        this.oLi.ego();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void egp() {
        this.oLi.egp();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public String getCustomRoomId() {
        return this.oLi.getCustomRoomId();
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0953a
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar) {
        ((c) this.bFO).a(alaAudioBackgroundDialogData, aVar, true);
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0953a
    public void egq() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_fail);
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0953a
    public void egr() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_success);
        egs();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QI() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QJ() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a
    public void show() {
        super.show();
        loadData();
    }

    private void egs() {
        JSONObject jSONObject = new JSONObject();
        try {
            x WA = com.baidu.live.aq.a.Wu().WA();
            String str = null;
            switch (WA.aGD.getRoomMode()) {
                case 0:
                    str = "normal";
                    break;
                case 1:
                    str = "dating";
                    break;
                case 2:
                    str = "battle";
                    break;
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, str);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, WA.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roomback_change").setContentExt(jSONObject));
    }
}
