package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.mode.c;
import com.baidu.yuyinala.mode.c.a;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioModeDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0959a {
    private com.baidu.yuyinala.mode.c.a oKz;

    public b(TbPageContext tbPageContext, w wVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        super(tbPageContext, new c(tbPageContext), alaAudioModeDialogData);
        ((c) this.bFM).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bFM).a((c.a) this);
        gn(80);
        cX(true);
        cY(true);
        a((DialogInterface.OnDismissListener) this.bFM);
        this.oKz = new com.baidu.yuyinala.mode.c.a(wVar, this);
    }

    public void a(w wVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oKz.aB(wVar);
        a((b) alaAudioModeDialogData);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0959a
    public void ekv() {
        this.mPageContext.showToast(a.h.change_mode_fail);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0959a
    public void ekw() {
        this.mPageContext.showToast(a.h.change_mode_succ);
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

    @Override // com.baidu.yuyinala.mode.c.a
    public void OT(int i) {
        this.oKz.OT(i);
    }
}
