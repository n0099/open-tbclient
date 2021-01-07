package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.aa;
/* loaded from: classes2.dex */
public abstract class a {
    protected a.InterfaceC0089a ahg;
    protected TbPageContext eXu;
    protected aa lZQ;
    protected OriginalThreadInfo lZR;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.eXu = tbPageContext;
    }

    public void a(aa aaVar) {
        this.lZQ = aaVar;
    }

    public void a(a.InterfaceC0089a interfaceC0089a) {
        this.ahg = interfaceC0089a;
    }
}
