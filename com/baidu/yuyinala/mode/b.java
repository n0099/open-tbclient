package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.mode.c;
import com.baidu.yuyinala.mode.c.a;
/* loaded from: classes10.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioModeDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0957a {
    private com.baidu.yuyinala.mode.c.a oMj;

    public b(TbPageContext tbPageContext, x xVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        super(tbPageContext, new c(tbPageContext), alaAudioModeDialogData);
        ((c) this.bFO).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bFO).a((c.a) this);
        eI(80);
        cW(true);
        cX(true);
        a((DialogInterface.OnDismissListener) this.bFO);
        this.oMj = new com.baidu.yuyinala.mode.c.a(xVar, this);
    }

    public void a(x xVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oMj.aO(xVar);
        a((b) alaAudioModeDialogData);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0957a
    public void egL() {
        this.mPageContext.showToast(a.h.change_mode_fail);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0957a
    public void egM() {
        this.mPageContext.showToast(a.h.change_mode_succ);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QI() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QJ() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.yuyinala.mode.c.a
    public void Nb(int i) {
        this.oMj.Nb(i);
    }
}
