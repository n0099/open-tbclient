package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import java.lang.ref.SoftReference;
/* loaded from: classes9.dex */
public abstract class l<T, V extends y.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected PbFragment jpS;
    private SparseArray<SoftReference<Drawable>> jpe;
    private SparseIntArray jpf;
    protected com.baidu.tieba.pb.videopb.b jsa;
    protected VideoPbFragment jsb;
    protected com.baidu.adp.widget.ListView.o jsc;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.cyk(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.jpe = new SparseArray<>();
        this.jpf = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.jsa = bVar;
            this.jpS = bVar.cyi();
            this.jsb = bVar.cyj();
            if (this.jpS != null) {
                this.mContext = this.jpS.getActivity();
            } else if (this.jsb != null) {
                this.mContext = this.jsb.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.jsc = (com.baidu.adp.widget.ListView.o) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.jpf.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.jpf.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
