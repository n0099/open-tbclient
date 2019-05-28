package com.baidu.tieba.pb.pb.sub.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.v.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public abstract class a<T, V extends v.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected o hHO;
    protected com.baidu.tieba.pb.pb.a hVm;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        this(aVar, bdUniqueId, null);
    }

    protected a(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(aVar.getPageContext().getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.hVm = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.hHO = (o) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
