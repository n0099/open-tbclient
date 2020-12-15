package com.baidu.yuyinala.background;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.background.c;
import com.baidu.yuyinala.background.c.a;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioBackgroundDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0955a {
    private com.baidu.yuyinala.background.c.a oJC;

    public b(TbPageContext tbPageContext, w wVar) {
        super(tbPageContext, new c(tbPageContext), null);
        ((c) this.bFM).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bFM).a((c.a) this);
        gn(80);
        cX(true);
        cY(true);
        this.oJC = new com.baidu.yuyinala.background.c.a(wVar, this);
        a((DialogInterface.OnDismissListener) this.bFM);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void loadData() {
        this.oJC.eko();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        this.oJC.a(aVar, bitmap);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void ekc() {
        this.oJC.ekc();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void ekd() {
        this.oJC.ekd();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public String getCustomRoomId() {
        return this.oJC.getCustomRoomId();
    }

    @Override // com.baidu.yuyinala.background.c.a.InterfaceC0955a
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar) {
        ((c) this.bFM).a(alaAudioBackgroundDialogData, aVar, true);
    }

    @Override // com.baidu.yuyinala.background.c.a.InterfaceC0955a
    public void eke() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_fail);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Ty() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Tz() {
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
}
