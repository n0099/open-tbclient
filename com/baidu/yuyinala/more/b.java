package com.baidu.yuyinala.more;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaMoreFunctionDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c {
    public b(TbPageContext tbPageContext, AlaMoreFunctionDialogData alaMoreFunctionDialogData) {
        super(tbPageContext, new c(tbPageContext), alaMoreFunctionDialogData);
        ((c) this.bFM).a(this);
        gn(80);
        cX(true);
        cY(true);
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

    public void a(com.baidu.live.e.c cVar) {
        ((c) this.bFM).b(cVar);
    }
}
