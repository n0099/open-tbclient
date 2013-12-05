package com.baidu.tieba.motu_gallery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class g implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumActivity f2116a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(JigsawAlbumActivity jigsawAlbumActivity) {
        this.f2116a = jigsawAlbumActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar;
        u uVar;
        ArrayList arrayList;
        boolean z;
        ArrayList arrayList2;
        j jVar2;
        ArrayList arrayList3;
        u uVar2;
        u uVar3;
        jVar = this.f2116a.i;
        int i2 = jVar.f2119a.get(i).f2112a;
        uVar = this.f2116a.k;
        uVar.c();
        arrayList = this.f2116a.f;
        if (i2 < arrayList.size()) {
            arrayList2 = this.f2116a.e;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.f2112a == i2) {
                    uVar3 = this.f2116a.k;
                    uVar3.a(cVar);
                }
            }
            jVar2 = this.f2116a.i;
            String str = jVar2.f2119a.get(i).b;
            arrayList3 = this.f2116a.f;
            String substring = str.substring(((c) arrayList3.get(i)).b.lastIndexOf("/") + 1);
            uVar2 = this.f2116a.k;
            uVar2.a(substring);
        }
        z = this.f2116a.t;
        if (!z) {
            this.f2116a.startActivityForResult(new Intent(this.f2116a, JigsawAlbumListActivity.class), 10);
            this.f2116a.t = true;
        }
    }
}
