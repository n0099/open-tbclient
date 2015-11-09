package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.x.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class bz<T, V extends x.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected ListView aTd;
    protected PbActivity cjZ;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public bz(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mIsFromCDN = false;
        this.cjZ = pbActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aTd = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }
}
