package com.baidu.tieba.pb.pb.sub.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected p lLH;
    protected boolean mIsFromCDN;
    protected int mSkinType;
    protected com.baidu.tieba.pb.pb.a mdG;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId) {
        this(aVar, bdUniqueId, null);
    }

    protected a(com.baidu.tieba.pb.pb.a aVar, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(aVar.getPageContext().getPageActivity(), bdUniqueId, bdUniqueId2);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.mdG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.lLH = (p) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
