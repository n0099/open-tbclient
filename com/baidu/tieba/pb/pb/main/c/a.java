package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public abstract class a {
    protected b.a aeU;
    protected TbPageContext efn;
    protected aa kPX;
    protected OriginalThreadInfo kPY;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.efn = tbPageContext;
    }

    public void a(aa aaVar) {
        this.kPX = aaVar;
    }

    public void a(b.a aVar) {
        this.aeU = aVar;
    }
}
