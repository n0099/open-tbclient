package com.baidu.tieba.motu_gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BaseAdapter {
    final /* synthetic */ JigsawAlbumListActivity a;
    private Context b;

    public r(JigsawAlbumListActivity jigsawAlbumListActivity, Context context) {
        this.a = jigsawAlbumListActivity;
        this.b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.a.b();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.a.a(i);
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
        c a = this.a.a.a(i);
        viewphotoLinkedHashMap = this.a.h;
        if (viewphotoLinkedHashMap.containsKey(Integer.valueOf(i))) {
            viewphotoLinkedHashMap3 = this.a.h;
            aVar = (a) viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i));
        } else {
            aVar = new a(this.b);
            aVar.setLayoutParams(new AbsListView.LayoutParams(this.a.d, this.a.d));
            aVar.setTag(Integer.valueOf(i));
            aVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
            aVar.setPadding(this.a.e, this.a.e, this.a.e, this.a.e);
            aVar.setOnClickListener(new s(this, a));
            viewphotoLinkedHashMap2 = this.a.h;
            viewphotoLinkedHashMap2.put(Integer.valueOf(i), (ImageView) aVar);
        }
        z = this.a.p;
        if (z) {
            this.a.p = false;
        }
        if (a != null && u.a().b(a.d)) {
            aVar.setIsSelected(true);
        } else {
            aVar.setIsSelected(false);
        }
        return aVar;
    }
}
