package com.baidu.tieba.pb.pb.sub.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.ad.a;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes16.dex */
public abstract class a<T, V extends ad.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected com.baidu.tieba.pb.pb.a kDT;
    protected s kmE;
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
        this.kDT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.kmE = (s) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
