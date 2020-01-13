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
/* loaded from: classes7.dex */
public abstract class m<T, V extends v.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    private SparseArray<SoftReference<Drawable>> iBq;
    private SparseIntArray iBr;
    protected PbFragment iCe;
    protected com.baidu.tieba.pb.videopb.b iEA;
    protected VideoPbFragment iEB;
    protected com.baidu.adp.widget.ListView.o iEC;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.clM(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.iBq = new SparseArray<>();
        this.iBr = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.iEA = bVar;
            this.iCe = bVar.clK();
            this.iEB = bVar.clL();
            if (this.iCe != null) {
                this.mContext = this.iCe.getActivity();
            } else if (this.iEB != null) {
                this.mContext = this.iEB.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iEC = (com.baidu.adp.widget.ListView.o) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.iBr.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.iBr.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
