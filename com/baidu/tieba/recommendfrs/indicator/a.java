package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends PagerAdapter {
    private Context mContext;
    private int mPrimaryPosition = -1;
    private com.baidu.tieba.recommendfrs.b cIr = new b(this);
    private ArrayList<com.baidu.tieba.recommendfrs.data.e> rK = new ArrayList<>();
    private ArrayList<com.baidu.tieba.recommendfrs.d> bot = new ArrayList<>();

    public a(Context context, com.baidu.tieba.recommendfrs.a aVar) {
        this.mContext = context;
        this.bot.add(a(aVar));
        this.bot.add(a(aVar));
        this.bot.add(a(aVar));
    }

    private com.baidu.tieba.recommendfrs.d a(com.baidu.tieba.recommendfrs.a aVar) {
        com.baidu.tieba.recommendfrs.d dVar = new com.baidu.tieba.recommendfrs.d(this.mContext);
        dVar.setCallback(aVar);
        dVar.setScrollCallback(this.cIr);
        return dVar;
    }

    public void ad(List<com.baidu.tieba.recommendfrs.data.e> list) {
        if (this.rK == null) {
            this.rK = new ArrayList<>();
        }
        this.rK.clear();
        if (list != null && list.size() > 0) {
            this.rK.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void a(boolean z, String str, com.baidu.tieba.recommendfrs.data.g gVar, boolean z2) {
        if (this.rK != null && !this.rK.isEmpty()) {
            Iterator<com.baidu.tieba.recommendfrs.data.e> it = this.rK.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.data.e next = it.next();
                if (next != null && TextUtils.equals(str, next.getTag())) {
                    next.a(z, gVar, z2);
                    notifyDataSetChanged();
                    a(str, next);
                    return;
                }
            }
        }
    }

    public void j(String str, String str2, int i) {
        if (this.bot != null) {
            Iterator<com.baidu.tieba.recommendfrs.d> it = this.bot.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.d next = it.next();
                if (next != null && next.kW(str)) {
                    next.Z(str2, i);
                    return;
                }
            }
        }
    }

    private void a(String str, com.baidu.tieba.recommendfrs.data.e eVar) {
        if (this.bot != null) {
            Iterator<com.baidu.tieba.recommendfrs.d> it = this.bot.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.d next = it.next();
                if (next != null && next.kW(str)) {
                    next.a(eVar, false);
                    return;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.rK == null) {
            return 0;
        }
        return this.rK.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPrimaryPosition != i) {
            this.mPrimaryPosition = i;
            if (obj instanceof com.baidu.tieba.recommendfrs.d) {
                ((com.baidu.tieba.recommendfrs.d) obj).apM();
            }
        }
    }

    public int ld(String str) {
        if (this.rK == null) {
            return -1;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            com.baidu.tieba.recommendfrs.data.e eVar = this.rK.get(i);
            if (eVar != null && TextUtils.equals(eVar.getTag(), str)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.rK != null) {
            this.rK.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        com.baidu.tieba.recommendfrs.d dVar = this.bot.get(i % 3);
        if (dVar.getParent() != null) {
            viewGroup.removeView(dVar);
        }
        dVar.a(this.rK.get(i), true);
        viewGroup.addView(dVar);
        return dVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int count = getCount();
        if (i < 0 || i >= count || this.rK == null || this.rK.get(i) == null) {
            return null;
        }
        return this.rK.get(i).getTag();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void cP(int i) {
        if (this.bot != null) {
            Iterator<com.baidu.tieba.recommendfrs.d> it = this.bot.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.recommendfrs.d next = it.next();
                if (next != null) {
                    next.onChangeSkinType(i);
                }
            }
        }
    }
}
