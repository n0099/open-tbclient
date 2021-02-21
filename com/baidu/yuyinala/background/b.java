package com.baidu.yuyinala.background;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.yuyinala.background.c;
import com.baidu.yuyinala.background.d.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioBackgroundDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0959a {
    private com.baidu.yuyinala.background.d.a oVO;

    public b(TbPageContext tbPageContext, ab abVar) {
        super(tbPageContext, new c(tbPageContext), null);
        ((c) this.bJy).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bJy).a((c.a) this);
        eM(80);
        de(true);
        df(true);
        this.oVO = new com.baidu.yuyinala.background.d.a(abVar, this);
        a((DialogInterface.OnDismissListener) this.bJy);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void loadData() {
        this.oVO.eje();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        this.oVO.a(aVar, bitmap);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, String str) {
        this.oVO.a(aVar, str);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eiO() {
        this.oVO.eiO();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eiP() {
        this.oVO.eiP();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public String getCustomRoomId() {
        return this.oVO.getCustomRoomId();
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0959a
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar) {
        ((c) this.bJy).a(alaAudioBackgroundDialogData, aVar, true);
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0959a
    public void eiQ() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_fail);
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0959a
    public void eiR() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_success);
        eiS();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Ss() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean St() {
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

    private void eiS() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yq = com.baidu.live.ao.a.Yj().Yq();
            String str = null;
            switch (Yq.aIY.getRoomMode()) {
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
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yq.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roomback_change").setContentExt(jSONObject));
    }
}
