package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public abstract class a {
    protected b.a Ka;
    protected TbPageContext cVv;
    protected z iUI;
    protected OriginalThreadInfo iUJ;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.cVv = tbPageContext;
    }

    public void a(z zVar) {
        this.iUI = zVar;
    }

    public void a(b.a aVar) {
        this.Ka = aVar;
    }
}
