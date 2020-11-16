package com.baidu.yuyinala.background;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.background.c;
import com.baidu.yuyinala.background.c.a;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioBackgroundDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0938a {
    private com.baidu.yuyinala.background.c.a ouu;

    public b(TbPageContext tbPageContext, w wVar) {
        super(tbPageContext, new c(tbPageContext), null);
        ((c) this.bAE).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bAE).a((c.a) this);
        fP(80);
        cJ(true);
        cK(true);
        this.ouu = new com.baidu.yuyinala.background.c.a(wVar, this);
        a((DialogInterface.OnDismissListener) this.bAE);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void loadData() {
        this.ouu.eeA();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        this.ouu.a(aVar, bitmap);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eeo() {
        this.ouu.eeo();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eep() {
        this.ouu.eep();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public String getCustomRoomId() {
        return this.ouu.getCustomRoomId();
    }

    @Override // com.baidu.yuyinala.background.c.a.InterfaceC0938a
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar) {
        ((c) this.bAE).a(alaAudioBackgroundDialogData, aVar, true);
    }

    @Override // com.baidu.yuyinala.background.c.a.InterfaceC0938a
    public void eeq() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_fail);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Ra() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Rb() {
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
