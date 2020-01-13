package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.z;
/* loaded from: classes7.dex */
public abstract class a {
    protected b.a JF;
    protected TbPageContext cRe;
    protected z iRy;
    protected OriginalThreadInfo iRz;
    protected int mSkinType = 3;

    public abstract void f(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.cRe = tbPageContext;
    }

    public void a(z zVar) {
        this.iRy = zVar;
    }

    public void a(b.a aVar) {
        this.JF = aVar;
    }
}
