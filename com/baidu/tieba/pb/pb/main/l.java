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
public abstract class l<T, V extends j.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected ListView ciD;
    protected PbActivity eGA;
    private SparseArray<SoftReference<Drawable>> eKk;
    private SparseArray<Integer> eKl;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity == null ? null : pbActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.eKk = new SparseArray<>();
        this.eKl = new SparseArray<>();
        aq(pbActivity);
    }

    public void aq(PbActivity pbActivity) {
        if (pbActivity != null) {
            this.eGA = pbActivity;
            this.mContext = pbActivity.getActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.ciD = (ListView) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        Integer num = this.eKl.get(i);
        if (num != null) {
            return num.intValue();
        }
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        this.eKl.put(i, Integer.valueOf(dimensionPixelSize));
        return dimensionPixelSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getDrawable(int i) {
        Drawable drawable;
        SoftReference<Drawable> softReference = this.eKk.get(i);
        if (softReference == null) {
            drawable = null;
        } else {
            drawable = softReference.get();
        }
        if (drawable == null && (drawable = com.baidu.tbadk.core.util.ai.getDrawable(i)) != null) {
            this.eKk.put(i, new SoftReference<>(drawable));
        }
        return drawable;
    }
}
