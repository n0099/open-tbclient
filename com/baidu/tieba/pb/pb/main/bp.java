package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class bp<T, V extends com.baidu.adp.widget.ListView.am> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected PbActivity bIF;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bp(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.bIF = pbActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.mListView = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
