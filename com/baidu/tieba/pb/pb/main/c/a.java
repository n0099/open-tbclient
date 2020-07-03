package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public abstract class a {
    protected b.a adY;
    protected TbPageContext dPv;
    protected aa krs;
    protected OriginalThreadInfo krt;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.dPv = tbPageContext;
    }

    public void a(aa aaVar) {
        this.krs = aaVar;
    }

    public void a(b.a aVar) {
        this.adY = aVar;
    }
}
