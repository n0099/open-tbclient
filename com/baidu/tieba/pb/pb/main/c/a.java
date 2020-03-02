package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public abstract class a {
    protected b.a Ka;
    protected TbPageContext cVh;
    protected z iSV;
    protected OriginalThreadInfo iSW;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.cVh = tbPageContext;
    }

    public void a(z zVar) {
        this.iSV = zVar;
    }

    public void a(b.a aVar) {
        this.Ka = aVar;
    }
}
