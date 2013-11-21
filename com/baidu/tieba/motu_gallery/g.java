package com.baidu.tieba.motu_gallery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class g implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumActivity f2009a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(JigsawAlbumActivity jigsawAlbumActivity) {
        this.f2009a = jigsawAlbumActivity;
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
        jVar = this.f2009a.i;
        int i2 = jVar.f2012a.get(i).f2005a;
        uVar = this.f2009a.k;
        uVar.c();
        arrayList = this.f2009a.f;
        if (i2 < arrayList.size()) {
            arrayList2 = this.f2009a.e;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.f2005a == i2) {
                    uVar3 = this.f2009a.k;
                    uVar3.a(cVar);
                }
            }
            jVar2 = this.f2009a.i;
            String str = jVar2.f2012a.get(i).b;
            arrayList3 = this.f2009a.f;
            String substring = str.substring(((c) arrayList3.get(i)).b.lastIndexOf("/") + 1);
            uVar2 = this.f2009a.k;
            uVar2.a(substring);
        }
        z = this.f2009a.t;
        if (!z) {
            this.f2009a.startActivityForResult(new Intent(this.f2009a, JigsawAlbumListActivity.class), 10);
            this.f2009a.t = true;
        }
    }
}
