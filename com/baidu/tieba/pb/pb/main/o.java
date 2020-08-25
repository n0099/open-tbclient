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
/* loaded from: classes16.dex */
public abstract class o<T, V extends af.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected com.baidu.tieba.pb.videopb.b kBW;
    protected VideoPbFragment kBX;
    protected com.baidu.adp.widget.ListView.s kBY;
    private SparseArray<SoftReference<Drawable>> kyH;
    private SparseIntArray kyI;
    protected PbFragment kzt;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.cYi(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.kyH = new SparseArray<>();
        this.kyI = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.kBW = bVar;
            this.kzt = bVar.cYg();
            this.kBX = bVar.cYh();
            if (this.kzt != null) {
                this.mContext = this.kzt.getActivity();
            } else if (this.kBX != null) {
                this.mContext = this.kBX.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.kBY = (com.baidu.adp.widget.ListView.s) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.kyI.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.kyI.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
