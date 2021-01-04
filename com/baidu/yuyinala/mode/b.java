package com.baidu.yuyinala.mode;

import android.content.DialogInterface;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.yuyinala.mode.c;
import com.baidu.yuyinala.mode.c.a;
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaAudioModeDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c, c.a, a.InterfaceC0936a {
    private com.baidu.yuyinala.mode.c.a oQL;

    public b(TbPageContext tbPageContext, x xVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        super(tbPageContext, new c(tbPageContext), alaAudioModeDialogData);
        ((c) this.bKA).a((com.baidu.live.tieba.pb.interactionpopupwindow.c) this);
        ((c) this.bKA).a((c.a) this);
        gp(80);
        da(true);
        db(true);
        a((DialogInterface.OnDismissListener) this.bKA);
        this.oQL = new com.baidu.yuyinala.mode.c.a(xVar, this);
    }

    public void a(x xVar, AlaAudioModeDialogData alaAudioModeDialogData) {
        this.oQL.aO(xVar);
        a((b) alaAudioModeDialogData);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0936a
    public void ekE() {
        this.mPageContext.showToast(a.h.change_mode_fail);
    }

    @Override // com.baidu.yuyinala.mode.c.a.InterfaceC0936a
    public void ekF() {
        this.mPageContext.showToast(a.h.change_mode_succ);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean UD() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean UE() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.yuyinala.mode.c.a
    public void OI(int i) {
        this.oQL.OI(i);
    }
}
