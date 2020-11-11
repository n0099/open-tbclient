package com.baidu.yuyinala.background;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.background.c;
import com.baidu.yuyinala.background.c.a;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioBackgroundDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0935a {
    private com.baidu.yuyinala.background.c.a osQ;

    public b(TbPageContext tbPageContext, w wVar) {
        super(tbPageContext, new c(tbPageContext), null);
        ((c) this.bCp).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bCp).a((c.a) this);
        fT(80);
        cH(true);
        cI(true);
        this.osQ = new com.baidu.yuyinala.background.c.a(wVar, this);
        a((DialogInterface.OnDismissListener) this.bCp);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void loadData() {
        this.osQ.eeC();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void a(com.baidu.yuyinala.background.b.a aVar, Bitmap bitmap) {
        this.osQ.a(aVar, bitmap);
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eeq() {
        this.osQ.eeq();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public void eer() {
        this.osQ.eer();
    }

    @Override // com.baidu.yuyinala.background.c.a
    public String getCustomRoomId() {
        return this.osQ.getCustomRoomId();
    }

    @Override // com.baidu.yuyinala.background.c.a.InterfaceC0935a
    public void a(AlaAudioBackgroundDialogData alaAudioBackgroundDialogData, com.baidu.yuyinala.background.b.a aVar) {
        ((c) this.bCp).a(alaAudioBackgroundDialogData, aVar, true);
    }

    @Override // com.baidu.yuyinala.background.c.a.InterfaceC0935a
    public void ees() {
        this.mPageContext.showToast(a.h.ala_audio_set_background_fail);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean RJ() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean RK() {
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
