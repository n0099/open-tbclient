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
/* loaded from: classes10.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioBackgroundDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0965a {
    private com.baidu.yuyinala.background.d.a oXT;

    public b(TbPageContext tbPageContext, ab abVar) {
        super(tbPageContext, new c(tbPageContext), null);
        ((c) this.bKY).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bKY).a((c.a) this);
        eN(80);
        de(true);
        df(true);
        this.oXT = new com.baidu.yuyinala.background.d.a(abVar, this);
        a((DialogInterface.OnDismissListener) this.bKY);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void loadData() {
        this.oXT.ejo();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        this.oXT.a(aVar, bitmap);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, String str) {
        this.oXT.a(aVar, str);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eiY() {
        this.oXT.eiY();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eiZ() {
        this.oXT.eiZ();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public String getCustomRoomId() {
        return this.oXT.getCustomRoomId();
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0965a
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar) {
        ((c) this.bKY).a(alaAudioBackgroundDialogData, aVar, true);
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0965a
    public void eja() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_fail);
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0965a
    public void ejb() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_success);
        ejc();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Sv() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Sw() {
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

    private void ejc() {
        JSONObject jSONObject = new JSONObject();
        try {
            ab Yt = com.baidu.live.ao.a.Ym().Yt();
            String str = null;
            switch (Yt.aKy.getRoomMode()) {
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
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roomback_change").setContentExt(jSONObject));
    }
}
