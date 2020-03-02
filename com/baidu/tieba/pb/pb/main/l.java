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
    protected PbFragment iDY;
    private SparseArray<SoftReference<Drawable>> iDl;
    private SparseIntArray iDm;
    protected com.baidu.tieba.pb.videopb.b iGg;
    protected VideoPbFragment iGh;
    protected com.baidu.adp.widget.ListView.o iGi;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.cni(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.iDl = new SparseArray<>();
        this.iDm = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.iGg = bVar;
            this.iDY = bVar.cng();
            this.iGh = bVar.cnh();
            if (this.iDY != null) {
                this.mContext = this.iDY.getActivity();
            } else if (this.iGh != null) {
                this.mContext = this.iGh.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iGi = (com.baidu.adp.widget.ListView.o) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.iDm.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.iDm.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
