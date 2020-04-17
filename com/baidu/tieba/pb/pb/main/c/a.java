package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public abstract class a {
    protected b.a acY;
    protected TbPageContext duG;
    protected z jER;
    protected OriginalThreadInfo jES;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.duG = tbPageContext;
    }

    public void a(z zVar) {
        this.jER = zVar;
    }

    public void a(b.a aVar) {
        this.acY = aVar;
    }
}
