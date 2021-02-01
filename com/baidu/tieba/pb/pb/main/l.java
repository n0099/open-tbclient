package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public abstract class l<T, V extends TypeAdapter.ViewHolder> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected PbFragment lMX;
    private SparseArray<SoftReference<Drawable>> lMb;
    private SparseIntArray lMc;
    protected com.baidu.tieba.pb.videopb.b lPU;
    protected VideoPbFragment lPV;
    protected com.baidu.adp.widget.ListView.p lPW;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.doa(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.lMb = new SparseArray<>();
        this.lMc = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.lPU = bVar;
            this.lMX = bVar.dnY();
            this.lPV = bVar.dnZ();
            if (this.lMX != null) {
                this.mContext = this.lMX.getActivity();
            } else if (this.lPV != null) {
                this.mContext = this.lPV.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.lPW = (com.baidu.adp.widget.ListView.p) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.lMc.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.lMc.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
