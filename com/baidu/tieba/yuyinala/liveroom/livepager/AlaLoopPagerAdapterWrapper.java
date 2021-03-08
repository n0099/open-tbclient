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
    private SparseArray<a> hHx = new SparseArray<>();
    private boolean hHy;
    private PagerAdapter mAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBoundaryCaching(boolean z) {
        this.hHy = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlaLoopPagerAdapterWrapper(PagerAdapter pagerAdapter) {
        this.mAdapter = pagerAdapter;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        if (this.hHx != null) {
            this.hHx.clear();
        }
        this.hHx = new SparseArray<>();
        super.notifyDataSetChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int vF(int i) {
        int cgO = cgO();
        if (cgO == 0) {
            return 0;
        }
        int i2 = (i - 1) % cgO;
        if (i2 < 0) {
            return i2 + cgO;
        }
        return i2;
    }

    public int vG(int i) {
        return i + 1;
    }

    private int cgM() {
        return 1;
    }

    private int cgN() {
        return (cgM() + cgO()) - 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mAdapter.getCount() + 2;
    }

    public int cgO() {
        return this.mAdapter.getCount();
    }

    public PagerAdapter cgP() {
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
        int vF = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : vF(i);
        if (this.hHy && (aVar = this.hHx.get(i)) != null) {
            this.hHx.remove(i);
            return aVar.object;
        }
        return this.mAdapter.instantiateItem(viewGroup, vF);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int cgM = cgM();
        int cgN = cgN();
        int vF = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : vF(i);
        if (this.hHy && (i == cgM || i == cgN)) {
            this.hHx.put(i, new a(viewGroup, vF, obj));
        } else {
            this.mAdapter.destroyItem(viewGroup, vF, obj);
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
        ViewGroup eqP;
        Object object;
        int position;

        public a(ViewGroup viewGroup, int i, Object obj) {
            this.eqP = viewGroup;
            this.position = i;
            this.object = obj;
        }
    }
}
