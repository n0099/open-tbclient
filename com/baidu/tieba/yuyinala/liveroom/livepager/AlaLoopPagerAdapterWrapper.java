package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
/* loaded from: classes10.dex */
public class AlaLoopPagerAdapterWrapper extends PagerAdapter {
    private SparseArray<a> hBq = new SparseArray<>();
    private boolean hBr;
    private PagerAdapter mAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBoundaryCaching(boolean z) {
        this.hBr = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlaLoopPagerAdapterWrapper(PagerAdapter pagerAdapter) {
        this.mAdapter = pagerAdapter;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        if (this.hBq != null) {
            this.hBq.clear();
        }
        this.hBq = new SparseArray<>();
        super.notifyDataSetChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int vs(int i) {
        int cfI = cfI();
        if (cfI == 0) {
            return 0;
        }
        int i2 = (i - 1) % cfI;
        if (i2 < 0) {
            return i2 + cfI;
        }
        return i2;
    }

    public int vt(int i) {
        return i + 1;
    }

    private int cfG() {
        return 1;
    }

    private int cfH() {
        return (cfG() + cfI()) - 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mAdapter.getCount() + 2;
    }

    public int cfI() {
        return this.mAdapter.getCount();
    }

    public PagerAdapter cfJ() {
        return this.mAdapter;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.mAdapter.registerDataSetObserver(dataSetObserver);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.mAdapter.unregisterDataSetObserver(dataSetObserver);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar;
        int vs = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : vs(i);
        if (this.hBr && (aVar = this.hBq.get(i)) != null) {
            this.hBq.remove(i);
            return aVar.object;
        }
        return this.mAdapter.instantiateItem(viewGroup, vs);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int cfG = cfG();
        int cfH = cfH();
        int vs = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : vs(i);
        if (this.hBr && (i == cfG || i == cfH)) {
            this.hBq.put(i, new a(viewGroup, vs, obj));
        } else {
            this.mAdapter.destroyItem(viewGroup, vs, obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        this.mAdapter.finishUpdate(viewGroup);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return this.mAdapter.isViewFromObject(view, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.mAdapter.restoreState(parcelable, classLoader);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return this.mAdapter.saveState();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        this.mAdapter.startUpdate(viewGroup);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.mAdapter.setPrimaryItem(viewGroup, i, obj);
    }

    /* loaded from: classes10.dex */
    static class a {
        ViewGroup enf;
        Object object;
        int position;

        public a(ViewGroup viewGroup, int i, Object obj) {
            this.enf = viewGroup;
            this.position = i;
            this.object = obj;
        }
    }
}
