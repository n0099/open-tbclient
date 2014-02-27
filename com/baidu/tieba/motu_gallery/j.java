package com.baidu.tieba.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class j extends BaseAdapter {
    public List<c> a;
    final /* synthetic */ JigsawAlbumActivity b;
    private Context c;

    public j(JigsawAlbumActivity jigsawAlbumActivity, Context context) {
        this.b = jigsawAlbumActivity;
        this.c = context;
    }

    public final void a(List<c> list) {
        this.a = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        ArrayList arrayList;
        Map map;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Map map2;
        ArrayList arrayList4;
        Bitmap a;
        Map map3;
        Map map4;
        u unused;
        if (view == null) {
            view = LayoutInflater.from(this.c).inflate(R.layout.motu_albums_activity_item, (ViewGroup) null);
            kVar = new k(this);
            kVar.b = (ImageView) view.findViewById(R.id.albums_item_photo_iv);
            kVar.c = (TextView) view.findViewById(R.id.albums_name_tv);
            view.setTag(kVar);
        } else {
            kVar = (k) view.getTag();
        }
        String str = this.a.get(i).b;
        arrayList = this.b.f;
        StringBuilder append = new StringBuilder(String.valueOf(str.substring(((c) arrayList.get(i)).b.lastIndexOf("/") + 1))).append("(");
        map = this.b.g;
        arrayList2 = this.b.f;
        String sb = append.append(String.valueOf(map.get(String.valueOf(((c) arrayList2.get(i)).a)))).append(")").toString();
        JigsawAlbumActivity jigsawAlbumActivity = this.b;
        arrayList3 = this.b.f;
        String b = JigsawAlbumActivity.b(jigsawAlbumActivity, ((c) arrayList3.get(i)).a);
        kVar.c.setText(sb);
        kVar.a = String.valueOf(i);
        map2 = this.b.h;
        if (map2.containsKey(b)) {
            map4 = this.b.h;
            a = (Bitmap) map4.get(b);
        } else {
            JigsawAlbumActivity jigsawAlbumActivity2 = this.b;
            arrayList4 = this.b.f;
            c a2 = JigsawAlbumActivity.a(jigsawAlbumActivity2, ((c) arrayList4.get(i)).a);
            unused = this.b.k;
            a = u.a(this.b, a2, this.b.a(70.0f));
            if (a != null) {
                map3 = this.b.h;
                map3.put(b, a);
            }
        }
        kVar.b.setImageBitmap(a);
        kVar.b.setTag(this.a.get(i));
        return view;
    }
}
