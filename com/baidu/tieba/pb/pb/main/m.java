package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.aa.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.lang.ref.SoftReference;
/* loaded from: classes9.dex */
public abstract class m<T, V extends aa.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    private SparseArray<SoftReference<Drawable>> jGX;
    private SparseIntArray jGY;
    protected PbFragment jHL;
    protected com.baidu.tieba.pb.videopb.b jKg;
    protected VideoPbFragment jKh;
    protected com.baidu.adp.widget.ListView.q jKi;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.cFs(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.jGX = new SparseArray<>();
        this.jGY = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.jKg = bVar;
            this.jHL = bVar.cFq();
            this.jKh = bVar.cFr();
            if (this.jHL != null) {
                this.mContext = this.jHL.getActivity();
            } else if (this.jKh != null) {
                this.mContext = this.jKh.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.jKi = (com.baidu.adp.widget.ListView.q) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.jGY.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.jGY.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
