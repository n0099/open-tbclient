package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.aa;
/* loaded from: classes22.dex */
public abstract class a {
    protected b.a afF;
    protected TbPageContext etO;
    protected aa lnU;
    protected OriginalThreadInfo lnV;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.etO = tbPageContext;
    }

    public void a(aa aaVar) {
        this.lnU = aaVar;
    }

    public void a(b.a aVar) {
        this.afF = aVar;
    }
}
