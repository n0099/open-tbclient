package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public abstract class a {
    protected b.a agH;
    protected TbPageContext eNx;
    protected ab lUF;
    protected OriginalThreadInfo lUG;
    protected int mSkinType = 3;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.eNx = tbPageContext;
    }

    public void a(ab abVar) {
        this.lUF = abVar;
    }

    public void a(b.a aVar) {
        this.agH = aVar;
    }
}
