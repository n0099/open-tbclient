package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.mode.c;
import com.baidu.yuyinala.mode.c.a;
/* loaded from: classes10.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioModeDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0969a {
    private com.baidu.yuyinala.mode.c.a oYV;

    public b(TbPageContext tbPageContext, ab abVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        super(tbPageContext, new c(tbPageContext), alaAudioModeDialogData);
        ((c) this.bKY).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bKY).a((c.a) this);
        eN(80);
        de(true);
        df(true);
        a((DialogInterface.OnDismissListener) this.bKY);
        this.oYV = new com.baidu.yuyinala.mode.c.a(abVar, this);
    }

    public void a(ab abVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oYV.aR(abVar);
        a((b) alaAudioModeDialogData);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0969a
    public void ejv() {
        this.mPageContext.showToast(a.h.change_mode_fail);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0969a
    public void ejw() {
        this.mPageContext.showToast(a.h.change_mode_succ);
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

    @Override // com.baidu.yuyinala.mode.c.a
    public void NC(int i) {
        this.oYV.NC(i);
    }
}
