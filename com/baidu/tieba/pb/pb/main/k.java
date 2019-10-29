package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.v.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.SoftReference;
/* loaded from: classes4.dex */
public abstract class k<T, V extends v.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    private SparseArray<SoftReference<Drawable>> hKq;
    private SparseIntArray hKr;
    protected PbActivity hNY;
    protected com.baidu.adp.widget.ListView.o hPy;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity == null ? null : pbActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.hKq = new SparseArray<>();
        this.hKr = new SparseIntArray();
        av(pbActivity);
    }

    public void av(PbActivity pbActivity) {
        if (pbActivity != null) {
            this.hNY = pbActivity;
            this.mContext = pbActivity.getActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.hPy = (com.baidu.adp.widget.ListView.o) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.hKr.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.hKr.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
