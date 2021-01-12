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
    private SparseArray<SoftReference<Drawable>> lDm;
    private SparseIntArray lDn;
    protected PbFragment lEi;
    protected com.baidu.tieba.pb.videopb.b lHa;
    protected VideoPbFragment lHb;
    protected com.baidu.adp.widget.ListView.p lHc;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.dlL(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.lDm = new SparseArray<>();
        this.lDn = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.lHa = bVar;
            this.lEi = bVar.dlJ();
            this.lHb = bVar.dlK();
            if (this.lEi != null) {
                this.mContext = this.lEi.getActivity();
            } else if (this.lHb != null) {
                this.mContext = this.lHb.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.lHc = (com.baidu.adp.widget.ListView.p) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.lDn.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.lDn.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
