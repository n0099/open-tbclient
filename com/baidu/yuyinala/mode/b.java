package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.mode.c;
import com.baidu.yuyinala.mode.c.a;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioModeDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0942a {
    private com.baidu.yuyinala.mode.c.a ovr;

    public b(TbPageContext tbPageContext, w wVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        super(tbPageContext, new c(tbPageContext), alaAudioModeDialogData);
        ((c) this.bAE).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bAE).a((c.a) this);
        fP(80);
        cJ(true);
        cK(true);
        a((DialogInterface.OnDismissListener) this.bAE);
        this.ovr = new com.baidu.yuyinala.mode.c.a(wVar, this);
    }

    public void a(w wVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        this.ovr.aw(wVar);
        a((b) alaAudioModeDialogData);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0942a
    public void eeH() {
        this.mPageContext.showToast(a.h.change_mode_fail);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0942a
    public void eeI() {
        this.mPageContext.showToast(a.h.change_mode_succ);
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

    @Override // com.baidu.yuyinala.mode.c.a
    public void NV(int i) {
        this.ovr.NV(i);
    }
}
