package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.ad.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.lang.ref.SoftReference;
/* loaded from: classes16.dex */
public abstract class o<T, V extends ad.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    private SparseArray<SoftReference<Drawable>> kjp;
    private SparseIntArray kjq;
    protected PbFragment kkb;
    protected com.baidu.tieba.pb.videopb.b kmE;
    protected VideoPbFragment kmF;
    protected com.baidu.adp.widget.ListView.s kmG;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.cNt(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.kjp = new SparseArray<>();
        this.kjq = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.kmE = bVar;
            this.kkb = bVar.cNr();
            this.kmF = bVar.cNs();
            if (this.kkb != null) {
                this.mContext = this.kkb.getActivity();
            } else if (this.kmF != null) {
                this.mContext = this.kmF.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.kmG = (com.baidu.adp.widget.ListView.s) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.kjq.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.kjq.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
