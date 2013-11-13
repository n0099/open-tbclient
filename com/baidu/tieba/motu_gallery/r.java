package com.baidu.tieba.motu_gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
/* loaded from: classes.dex */
class r extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumListActivity f2037a;
    private Context b;

    public r(JigsawAlbumListActivity jigsawAlbumListActivity, Context context) {
        this.f2037a = jigsawAlbumListActivity;
        this.b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2037a.f2020a.b();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f2037a.f2020a.a(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewphotoLinkedHashMap viewphotoLinkedHashMap;
        a aVar;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap2;
        boolean z;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap3;
        c a2 = this.f2037a.f2020a.a(i);
        viewphotoLinkedHashMap = this.f2037a.h;
        if (viewphotoLinkedHashMap.containsKey(Integer.valueOf(i))) {
            viewphotoLinkedHashMap3 = this.f2037a.h;
            aVar = (a) viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i));
        } else {
            aVar = new a(this.b);
            aVar.setLayoutParams(new AbsListView.LayoutParams(this.f2037a.d, this.f2037a.d));
            aVar.setTag(Integer.valueOf(i));
            aVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            aVar.setPadding(this.f2037a.e, this.f2037a.e, this.f2037a.e, this.f2037a.e);
            aVar.setOnClickListener(new s(this, a2));
            viewphotoLinkedHashMap2 = this.f2037a.h;
            viewphotoLinkedHashMap2.put(Integer.valueOf(i), (ImageView) aVar);
        }
        z = this.f2037a.p;
        if (z) {
            this.f2037a.p = false;
        }
        if (a2 != null && u.a().b(a2.d)) {
            aVar.setIsSelected(true);
        } else {
            aVar.setIsSelected(false);
        }
        return aVar;
    }
}
