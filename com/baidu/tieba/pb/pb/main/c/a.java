package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public abstract class a {
    protected a.InterfaceC0088a agh;
    protected TbPageContext eUY;
    protected int mSkinType = 3;
    protected ab mer;
    protected OriginalThreadInfo mes;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.eUY = tbPageContext;
    }

    public void a(ab abVar) {
        this.mer = abVar;
    }

    public void a(a.InterfaceC0088a interfaceC0088a) {
        this.agh = interfaceC0088a;
    }
}
