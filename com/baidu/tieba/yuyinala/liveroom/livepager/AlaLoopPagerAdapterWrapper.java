package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class AlaLoopPagerAdapterWrapper extends PagerAdapter {
    private SparseArray<a> hkU = new SparseArray<>();
    private boolean hkV;
    private PagerAdapter mAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBoundaryCaching(boolean z) {
        this.hkV = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlaLoopPagerAdapterWrapper(PagerAdapter pagerAdapter) {
        this.mAdapter = pagerAdapter;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        if (this.hkU != null) {
            this.hkU.clear();
        }
        this.hkU = new SparseArray<>();
        super.notifyDataSetChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int vK(int i) {
        int cdz = cdz();
        if (cdz == 0) {
            return 0;
        }
        int i2 = (i - 1) % cdz;
        if (i2 < 0) {
            return i2 + cdz;
        }
        return i2;
    }

    public int vL(int i) {
        return i + 1;
    }

    private int cdx() {
        return 1;
    }

    private int cdy() {
        return (cdx() + cdz()) - 1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mAdapter.getCount() + 2;
    }

    public int cdz() {
        return this.mAdapter.getCount();
    }

    public PagerAdapter cdA() {
        return this.mAdapter;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.mAdapter.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.mAdapter.unregisterDataSetObserver(dataSetObserver);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar;
        int vK = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : vK(i);
        if (this.hkV && (aVar = this.hkU.get(i)) != null) {
            this.hkU.remove(i);
            return aVar.object;
        }
        return this.mAdapter.instantiateItem(viewGroup, vK);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int cdx = cdx();
        int cdy = cdy();
        int vK = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : vK(i);
        if (this.hkV && (i == cdx || i == cdy)) {
            this.hkU.put(i, new a(viewGroup, vK, obj));
        } else {
            this.mAdapter.destroyItem(viewGroup, vK, obj);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        this.mAdapter.finishUpdate(viewGroup);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return this.mAdapter.isViewFromObject(view, obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.mAdapter.restoreState(parcelable, classLoader);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return this.mAdapter.saveState();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        this.mAdapter.startUpdate(viewGroup);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.mAdapter.setPrimaryItem(viewGroup, i, obj);
    }

    /* loaded from: classes4.dex */
    static class a {
        ViewGroup edx;
        Object object;
        int position;

        public a(ViewGroup viewGroup, int i, Object obj) {
            this.edx = viewGroup;
            this.position = i;
            this.object = obj;
        }
    }
}
