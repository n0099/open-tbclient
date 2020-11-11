package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.mode.c;
import com.baidu.yuyinala.mode.c.a;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioModeDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0939a {
    private com.baidu.yuyinala.mode.c.a otN;

    public b(TbPageContext tbPageContext, w wVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        super(tbPageContext, new c(tbPageContext), alaAudioModeDialogData);
        ((c) this.bCp).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bCp).a((c.a) this);
        fT(80);
        cH(true);
        cI(true);
        a((DialogInterface.OnDismissListener) this.bCp);
        this.otN = new com.baidu.yuyinala.mode.c.a(wVar, this);
    }

    public void a(w wVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        this.otN.aw(wVar);
        a((b) alaAudioModeDialogData);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0939a
    public void eeJ() {
        this.mPageContext.showToast(a.h.change_mode_fail);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0939a
    public void eeK() {
        this.mPageContext.showToast(a.h.change_mode_succ);
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

    @Override // com.baidu.yuyinala.mode.c.a
    public void Ns(int i) {
        this.otN.Ns(i);
    }
}
