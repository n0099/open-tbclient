package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PagerAdapter {
    private Context mContext;
    private int mPrimaryPosition = -1;
    private com.baidu.tieba.recommendfrs.b dir = new b(this);
    private ArrayList<com.baidu.tieba.recommendfrs.data.a> list = new ArrayList<>();
    private ArrayList<com.baidu.tieba.recommendfrs.d> bCW = new ArrayList<>();

    public a(Context context, com.baidu.tieba.recommendfrs.a aVar) {
        this.mContext = context;
        this.bCW.add(a(aVar));
        this.bCW.add(a(aVar));
        this.bCW.add(a(aVar));
    }

    private com.baidu.tieba.recommendfrs.d a(com.baidu.tieba.recommendfrs.a aVar) {
        com.baidu.tieba.recommendfrs.d dVar = new com.baidu.tieba.recommendfrs.d(this.mContext);
        dVar.setCallback(aVar);
        dVar.setScrollCallback(this.dir);
        return dVar;
    }

    public void an(List<com.baidu.tieba.recommendfrs.data.a> list) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.clear();
        if (list != null && list.size() > 0) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void a(boolean z, long j, com.baidu.tieba.recommendfrs.data.c cVar, boolean z2) {
        if (this.list != null && !this.list.isEmpty()) {
            Iterator<com.baidu.tieba.recommendfrs.data.a> it = this.list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.a next = it.next();
                if (next != null && next.awh() != null && j == next.awh().tag_code.longValue()) {
                    next.a(z, cVar, z2);
                    notifyDataSetChanged();
                    a(j, next);
                    return;
                }
            }
        }
    }

    public void b(long j, String str, int i) {
        if (this.bCW != null) {
            Iterator<com.baidu.tieba.recommendfrs.d> it = this.bCW.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.d next = it.next();
                if (next != null && next.bw(j)) {
                    next.ae(str, i);
                    return;
                }
            }
        }
    }

    private void a(long j, com.baidu.tieba.recommendfrs.data.a aVar) {
        if (this.bCW != null) {
            Iterator<com.baidu.tieba.recommendfrs.d> it = this.bCW.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.d next = it.next();
                if (next != null && next.bw(j)) {
                    next.a(aVar, false);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPrimaryPosition != i) {
            this.mPrimaryPosition = i;
            if (obj instanceof com.baidu.tieba.recommendfrs.d) {
                ((com.baidu.tieba.recommendfrs.d) obj).awc();
            }
        }
    }

    public int bz(long j) {
        if (this.list == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.recommendfrs.data.a aVar = this.list.get(i);
            if (aVar != null && aVar.awh() != null && aVar.awh().tag_code.longValue() == j) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.list != null) {
            this.list.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        com.baidu.tieba.recommendfrs.d dVar = this.bCW.get(i % 3);
        if (dVar.getParent() != null) {
            viewGroup.removeView(dVar);
        }
        dVar.a(this.list.get(i), true);
        viewGroup.addView(dVar);
        return dVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int count = getCount();
        if (i < 0 || i >= count) {
            return null;
        }
        if (this.list == null || this.list.get(i) == null || this.list.get(i).awh() == null) {
            return null;
        }
        return this.list.get(i).awh().tag_name;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void cX(int i) {
        if (this.bCW != null) {
            Iterator<com.baidu.tieba.recommendfrs.d> it = this.bCW.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.d next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }
}
