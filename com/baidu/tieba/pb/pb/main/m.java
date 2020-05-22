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
    private SparseArray<SoftReference<Drawable>> jFR;
    private SparseIntArray jFS;
    protected PbFragment jGF;
    protected com.baidu.tieba.pb.videopb.b jJa;
    protected VideoPbFragment jJb;
    protected com.baidu.adp.widget.ListView.q jJc;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.cFc(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.jFR = new SparseArray<>();
        this.jFS = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.jJa = bVar;
            this.jGF = bVar.cFa();
            this.jJb = bVar.cFb();
            if (this.jGF != null) {
                this.mContext = this.jGF.getActivity();
            } else if (this.jJb != null) {
                this.mContext = this.jJb.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.jJc = (com.baidu.adp.widget.ListView.q) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.jFS.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.jFS.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
