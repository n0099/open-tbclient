package com.baidu.yuyinala.more;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, AlaMoreFunctionDialogData> implements com.baidu.live.tieba.pb.interactionpopupwindow.c {
    public b(TbPageContext tbPageContext, AlaMoreFunctionDialogData alaMoreFunctionDialogData) {
        super(tbPageContext, new c(tbPageContext), alaMoreFunctionDialogData);
        ((c) this.bKA).a(this);
        gp(80);
        da(true);
        db(true);
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

    public void a(com.baidu.live.e.c cVar) {
        ((c) this.bKA).b(cVar);
    }
}
