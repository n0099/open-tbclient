package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.mode.c;
import com.baidu.yuyinala.mode.c.a;
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioModeDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0963a {
    private com.baidu.yuyinala.mode.c.a oWQ;

    public b(TbPageContext tbPageContext, ab abVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        super(tbPageContext, new c(tbPageContext), alaAudioModeDialogData);
        ((c) this.bJy).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bJy).a((c.a) this);
        eM(80);
        de(true);
        df(true);
        a((DialogInterface.OnDismissListener) this.bJy);
        this.oWQ = new com.baidu.yuyinala.mode.c.a(abVar, this);
    }

    public void a(ab abVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oWQ.aR(abVar);
        a((b) alaAudioModeDialogData);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0963a
    public void ejl() {
        this.mPageContext.showToast(a.h.change_mode_fail);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0963a
    public void ejm() {
        this.mPageContext.showToast(a.h.change_mode_succ);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Ss() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean St() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.yuyinala.mode.c.a
    public void Ny(int i) {
        this.oWQ.Ny(i);
    }
}
