package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public abstract class a {
    protected b.a aeW;
    protected TbPageContext efr;
    protected aa kQe;
    protected OriginalThreadInfo kQf;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.efr = tbPageContext;
    }

    public void a(aa aaVar) {
        this.kQe = aaVar;
    }

    public void a(b.a aVar) {
        this.aeW = aVar;
    }
}
