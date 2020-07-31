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
    protected PbFragment kjZ;
    private SparseArray<SoftReference<Drawable>> kjn;
    private SparseIntArray kjo;
    protected com.baidu.tieba.pb.videopb.b kmC;
    protected VideoPbFragment kmD;
    protected com.baidu.adp.widget.ListView.s kmE;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.cNt(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.kjn = new SparseArray<>();
        this.kjo = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.kmC = bVar;
            this.kjZ = bVar.cNr();
            this.kmD = bVar.cNs();
            if (this.kjZ != null) {
                this.mContext = this.kjZ.getActivity();
            } else if (this.kmD != null) {
                this.mContext = this.kmD.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.kmE = (com.baidu.adp.widget.ListView.s) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.kjo.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.kjo.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
