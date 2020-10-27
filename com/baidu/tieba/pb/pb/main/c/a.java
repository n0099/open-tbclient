package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public abstract class a {
    protected b.a afG;
    protected TbPageContext eCn;
    protected ab lAx;
    protected OriginalThreadInfo lAy;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.eCn = tbPageContext;
    }

    public void a(ab abVar) {
        this.lAx = abVar;
    }

    public void a(b.a aVar) {
        this.afG = aVar;
    }
}
