package com.baidu.yuyinala.more;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaMoreFunctionDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c {
    public b(TbPageContext tbPageContext, AlaMoreFunctionDialogData alaMoreFunctionDialogData) {
        super(tbPageContext, new c(tbPageContext), alaMoreFunctionDialogData);
        ((c) this.bAE).a(this);
        fP(80);
        cJ(true);
        cK(true);
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

    public void a(com.baidu.live.c.c cVar) {
        ((c) this.bAE).b(cVar);
    }
}
