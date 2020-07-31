package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public abstract class a {
    protected b.a adO;
    protected TbPageContext dVN;
    protected aa kAq;
    protected OriginalThreadInfo kAr;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.dVN = tbPageContext;
    }

    public void a(aa aaVar) {
        this.kAq = aaVar;
    }

    public void a(b.a aVar) {
        this.adO = aVar;
    }
}
