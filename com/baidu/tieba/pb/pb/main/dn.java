package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.z;
import com.baidu.adp.widget.ListView.z.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public abstract class dn<T, V extends z.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected ListView bTH;
    protected PbActivity elf;
    private SparseArray<SoftReference<Drawable>> eoH;
    private SparseArray<Integer> eoI;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public dn(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity == null ? null : pbActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.eoH = new SparseArray<>();
        this.eoI = new SparseArray<>();
        af(pbActivity);
    }

    public void af(PbActivity pbActivity) {
        if (pbActivity != null) {
            this.elf = pbActivity;
            this.mContext = pbActivity.getActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.bTH = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        Integer num = this.eoI.get(i);
        if (num != null) {
            return num.intValue();
        }
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(i);
        this.eoI.put(i, Integer.valueOf(dimensionPixelSize));
        return dimensionPixelSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getDrawable(int i) {
        Drawable drawable;
        SoftReference<Drawable> softReference = this.eoH.get(i);
        if (softReference == null) {
            drawable = null;
        } else {
            drawable = softReference.get();
        }
        if (drawable == null && (drawable = com.baidu.tbadk.core.util.aq.getDrawable(i)) != null) {
            this.eoH.put(i, new SoftReference<>(drawable));
        }
        return drawable;
    }
}
