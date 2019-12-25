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
/* loaded from: classes6.dex */
public abstract class m<T, V extends v.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    protected com.baidu.tieba.pb.videopb.b iAW;
    protected VideoPbFragment iAX;
    protected com.baidu.adp.widget.ListView.o iAY;
    private SparseArray<SoftReference<Drawable>> ixM;
    private SparseIntArray ixN;
    protected PbFragment iyA;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(com.baidu.tieba.pb.videopb.b bVar, BdUniqueId bdUniqueId) {
        super(bVar == null ? null : bVar.ckE(), bdUniqueId);
        this.mSkinType = 3;
        this.mIsFromCDN = false;
        this.ixM = new SparseArray<>();
        this.ixN = new SparseIntArray();
        a(bVar);
    }

    public void a(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar != null) {
            this.iAW = bVar;
            this.iyA = bVar.ckC();
            this.iAX = bVar.ckD();
            if (this.iyA != null) {
                this.mContext = this.iyA.getActivity();
            } else if (this.iAX != null) {
                this.mContext = this.iAX.getActivity();
            } else {
                this.mContext = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, T t, V v) {
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iAY = (com.baidu.adp.widget.ListView.o) viewGroup;
        return null;
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDimensionPixelSize(int i) {
        int i2 = this.ixN.get(i, -1);
        if (i2 == -1) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            this.ixN.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return i2;
    }
}
