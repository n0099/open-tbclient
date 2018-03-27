package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.r.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public abstract class k<T, V extends r.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected com.baidu.adp.widget.ListView.k dDU;
    protected PbActivity fNg;
    private SparseArray<Integer> fOA;
    private SparseArray<SoftReference<Drawable>> fOz;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity == null ? null : pbActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.fOz = new SparseArray<>();
        this.fOA = new SparseArray<>();
        ao(pbActivity);
    }

    public void ao(PbActivity pbActivity) {
        if (pbActivity != null) {
            this.fNg = pbActivity;
            this.mContext = pbActivity.getActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dDU = (com.baidu.adp.widget.ListView.k) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        Integer num = this.fOA.get(i);
        if (num != null) {
            return num.intValue();
        }
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        this.fOA.put(i, Integer.valueOf(dimensionPixelSize));
        return dimensionPixelSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getDrawable(int i) {
        Drawable drawable;
        SoftReference<Drawable> softReference = this.fOz.get(i);
        if (softReference == null) {
            drawable = null;
        } else {
            drawable = softReference.get();
        }
        if (drawable == null && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(i)) != null) {
            this.fOz.put(i, new SoftReference<>(drawable));
        }
        return drawable;
    }
}
