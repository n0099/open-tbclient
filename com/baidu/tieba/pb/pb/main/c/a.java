package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.z;
/* loaded from: classes6.dex */
public abstract class a {
    protected b.a Jz;
    protected TbPageContext cQU;
    protected z iNU;
    protected OriginalThreadInfo iNV;
    protected int mSkinType = 3;

    public abstract void f(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.cQU = tbPageContext;
    }

    public void a(z zVar) {
        this.iNU = zVar;
    }

    public void a(b.a aVar) {
        this.Jz = aVar;
    }
}
