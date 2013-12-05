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
public class j extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<c> f2119a;
    final /* synthetic */ JigsawAlbumActivity b;
    private Context c;

    public j(JigsawAlbumActivity jigsawAlbumActivity, Context context) {
        this.b = jigsawAlbumActivity;
        this.c = context;
    }

    public void a(List<c> list) {
        this.f2119a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f2119a != null) {
            return this.f2119a.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f2119a == null || i < 0 || i >= this.f2119a.size()) {
            return null;
        }
        return this.f2119a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        ArrayList arrayList;
        Map map;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String a2;
        Map map2;
        ArrayList arrayList4;
        c b;
        u uVar;
        Bitmap a3;
        Map map3;
        Map map4;
        if (view == null) {
            view = LayoutInflater.from(this.c).inflate(R.layout.motu_albums_activity_item, (ViewGroup) null);
            k a4 = a(view);
            view.setTag(a4);
            kVar = a4;
        } else {
            kVar = (k) view.getTag();
        }
        StringBuilder sb = new StringBuilder();
        String str = this.f2119a.get(i).b;
        arrayList = this.b.f;
        StringBuilder append = sb.append(str.substring(((c) arrayList.get(i)).b.lastIndexOf("/") + 1)).append("(");
        map = this.b.g;
        arrayList2 = this.b.f;
        String sb2 = append.append(String.valueOf(map.get(String.valueOf(((c) arrayList2.get(i)).f2112a)))).append(")").toString();
        JigsawAlbumActivity jigsawAlbumActivity = this.b;
        arrayList3 = this.b.f;
        a2 = jigsawAlbumActivity.a(((c) arrayList3.get(i)).f2112a);
        kVar.c.setText(sb2);
        kVar.f2120a = String.valueOf(i);
        map2 = this.b.h;
        if (map2.containsKey(a2)) {
            map4 = this.b.h;
            a3 = (Bitmap) map4.get(a2);
        } else {
            JigsawAlbumActivity jigsawAlbumActivity2 = this.b;
            arrayList4 = this.b.f;
            b = jigsawAlbumActivity2.b(((c) arrayList4.get(i)).f2112a);
            uVar = this.b.k;
            a3 = uVar.a(this.b, b, this.b.a(70.0f));
            if (a3 != null) {
                map3 = this.b.h;
                map3.put(a2, a3);
            }
        }
        kVar.b.setImageBitmap(a3);
        kVar.b.setTag(this.f2119a.get(i));
        return view;
    }

    private k a(View view) {
        k kVar = new k(this);
        kVar.b = (ImageView) view.findViewById(R.id.albums_item_photo_iv);
        kVar.c = (TextView) view.findViewById(R.id.albums_name_tv);
        return kVar;
    }
}
