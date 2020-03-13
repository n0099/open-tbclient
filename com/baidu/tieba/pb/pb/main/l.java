package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.v.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.lang.ref.SoftReference;
/* loaded from: classes9.dex */
public abstract class l<T, V extends v.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    private SparseArray<SoftReference<Drawable>> iDx;
    private SparseIntArray iDy;
    protected PbFragment iEk;
    protected com.baidu.tieba.pb.videopb.b iGs;
    protected VideoPbFragment iGt;
    protected com.baidu.adp.widget.ListView.o iGu;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.cnj(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.iDx = new SparseArray<>();
        this.iDy = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.iGs = bVar;
            this.iEk = bVar.cnh();
            this.iGt = bVar.cni();
            if (this.iEk != null) {
                this.mContext = this.iEk.getActivity();
            } else if (this.iGt != null) {
                this.mContext = this.iGt.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iGu = (com.baidu.adp.widget.ListView.o) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.iDy.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.iDy.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
