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
    private SparseArray<SoftReference<Drawable>> loW;
    private SparseIntArray loX;
    protected PbFragment lpI;
    protected com.baidu.tieba.pb.videopb.b lsm;
    protected VideoPbFragment lsn;
    protected com.baidu.adp.widget.ListView.s lso;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.dle(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.loW = new SparseArray<>();
        this.loX = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.lsm = bVar;
            this.lpI = bVar.dlc();
            this.lsn = bVar.dld();
            if (this.lpI != null) {
                this.mContext = this.lpI.getActivity();
            } else if (this.lsn != null) {
                this.mContext = this.lsn.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.lso = (com.baidu.adp.widget.ListView.s) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.loX.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.loX.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
