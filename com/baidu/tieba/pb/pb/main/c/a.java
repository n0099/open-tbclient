package com.baidu.tieba.pb.pb.main.c;

import android.view.View;
import com.baidu.card.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public abstract class a {
    protected a.InterfaceC0094a ahz;
    protected TbPageContext eWx;
    protected int mSkinType = 3;
    protected ab mgI;
    protected OriginalThreadInfo mgJ;

    public abstract void g(OriginalThreadInfo originalThreadInfo);

    public abstract View getView();

    public abstract void onChangeSkinType(TbPageContext tbPageContext, int i);

    public a(TbPageContext tbPageContext) {
        this.eWx = tbPageContext;
    }

    public void a(ab abVar) {
        this.mgI = abVar;
    }

    public void a(a.InterfaceC0094a interfaceC0094a) {
        this.ahz = interfaceC0094a;
    }
}
