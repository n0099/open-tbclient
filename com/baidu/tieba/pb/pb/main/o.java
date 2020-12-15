package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.lang.ref.SoftReference;
/* loaded from: classes22.dex */
public abstract class o<T, V extends af.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    private SparseArray<SoftReference<Drawable>> lCM;
    private SparseIntArray lCN;
    protected PbFragment lDI;
    protected com.baidu.tieba.pb.videopb.b lGq;
    protected VideoPbFragment lGr;
    protected com.baidu.adp.widget.ListView.s lGs;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.dpR(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.lCM = new SparseArray<>();
        this.lCN = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.lGq = bVar;
            this.lDI = bVar.dpP();
            this.lGr = bVar.dpQ();
            if (this.lDI != null) {
                this.mContext = this.lDI.getActivity();
            } else if (this.lGr != null) {
                this.mContext = this.lGr.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.lGs = (com.baidu.adp.widget.ListView.s) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.lCN.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.lCN.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
