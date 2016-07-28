package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public abstract class cs<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected ListView bFG;
    private SparseArray<SoftReference<Drawable>> bQP;
    protected PbActivity eat;
    private SparseArray<Integer> ecN;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public cs(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity == null ? null : pbActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.bQP = new SparseArray<>();
        this.ecN = new SparseArray<>();
        ac(pbActivity);
    }

    public void ac(PbActivity pbActivity) {
        if (pbActivity != null) {
            this.eat = pbActivity;
            this.mContext = pbActivity.getActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        this.bFG = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        Integer num = this.ecN.get(i);
        if (num != null) {
            return num.intValue();
        }
        int dimensionPixelSize = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(i);
        this.ecN.put(i, Integer.valueOf(dimensionPixelSize));
        return dimensionPixelSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getDrawable(int i) {
        Drawable drawable;
        SoftReference<Drawable> softReference = this.bQP.get(i);
        if (softReference == null) {
            drawable = null;
        } else {
            drawable = softReference.get();
        }
        if (drawable == null && (drawable = com.baidu.tbadk.core.util.av.getDrawable(i)) != null) {
            this.bQP.put(i, new SoftReference<>(drawable));
        }
        return drawable;
    }
}
