package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.adp.widget.ListView.j.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public abstract class m<T, V extends j.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected PbActivity eMh;
    private SparseArray<SoftReference<Drawable>> eNn;
    private SparseArray<Integer> eNo;
    protected boolean mIsFromCDN;
    protected ListView mListView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity == null ? null : pbActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.eNn = new SparseArray<>();
        this.eNo = new SparseArray<>();
        ap(pbActivity);
    }

    public void ap(PbActivity pbActivity) {
        if (pbActivity != null) {
            this.eMh = pbActivity;
            this.mContext = pbActivity.getActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.mListView = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        Integer num = this.eNo.get(i);
        if (num != null) {
            return num.intValue();
        }
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        this.eNo.put(i, Integer.valueOf(dimensionPixelSize));
        return dimensionPixelSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getDrawable(int i) {
        Drawable drawable;
        SoftReference<Drawable> softReference = this.eNn.get(i);
        if (softReference == null) {
            drawable = null;
        } else {
            drawable = softReference.get();
        }
        if (drawable == null && (drawable = com.baidu.tbadk.core.util.aj.getDrawable(i)) != null) {
            this.eNn.put(i, new SoftReference<>(drawable));
        }
        return drawable;
    }
}
