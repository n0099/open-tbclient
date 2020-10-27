package com.baidu.yuyinala.background;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.background.c;
import com.baidu.yuyinala.background.c.a;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioBackgroundDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0919a {
    private com.baidu.yuyinala.background.c.a ojK;

    public b(TbPageContext tbPageContext, w wVar) {
        super(tbPageContext, new c(tbPageContext), null);
        ((c) this.bwe).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bwe).a((c.a) this);
        fG(80);
        cA(true);
        cB(true);
        this.ojK = new com.baidu.yuyinala.background.c.a(wVar, this);
        a((DialogInterface.OnDismissListener) this.bwe);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void loadData() {
        this.ojK.eaU();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        this.ojK.a(aVar, bitmap);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eaI() {
        this.ojK.eaI();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eaJ() {
        this.ojK.eaJ();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public String getCustomRoomId() {
        return this.ojK.getCustomRoomId();
    }

    @Override // com.baidu.yuyinala.background.c.a.InterfaceC0919a
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar) {
        ((c) this.bwe).a(alaAudioBackgroundDialogData, aVar, true);
    }

    @Override // com.baidu.yuyinala.background.c.a.InterfaceC0919a
    public void eaK() {
        this.mPageContext.showToast(a.i.ala_audio_set_background_fail);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QG() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QH() {
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
