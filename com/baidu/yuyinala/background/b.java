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
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioBackgroundDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0970a {
    private com.baidu.yuyinala.background.d.a oPJ;

    public b(TbPageContext tbPageContext, x xVar) {
        super(tbPageContext, new c(tbPageContext), null);
        ((c) this.bKA).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bKA).a((c.a) this);
        gp(80);
        da(true);
        db(true);
        this.oPJ = new com.baidu.yuyinala.background.d.a(xVar, this);
        a((DialogInterface.OnDismissListener) this.bKA);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void loadData() {
        this.oPJ.eky();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        this.oPJ.a(aVar, bitmap);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, String str) {
        this.oPJ.a(aVar, str);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eki() {
        this.oPJ.eki();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void ekj() {
        this.oPJ.ekj();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public String getCustomRoomId() {
        return this.oPJ.getCustomRoomId();
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0970a
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar) {
        ((c) this.bKA).a(alaAudioBackgroundDialogData, aVar, true);
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0970a
    public void ekk() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_fail);
    }

    @Override // com.baidu.yuyinala.background.d.a.InterfaceC0970a
    public void ekl() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_success);
        ekm();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean UD() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean UE() {
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

    private void ekm() {
        JSONObject jSONObject = new JSONObject();
        try {
            x aat = com.baidu.live.aq.a.aan().aat();
            String str = null;
            switch (aat.aLq.getRoomMode()) {
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
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aat.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roomback_change").setContentExt(jSONObject));
    }
}
