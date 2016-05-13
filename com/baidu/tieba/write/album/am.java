package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag eYU;
    private final /* synthetic */ String eYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.eYU = agVar;
        this.eYV = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void jv() {
    }

    @Override // com.baidu.tieba.write.album.ap
    public void a(List<d> list, List<ImageFileInfo> list2, String str) {
        TextView textView;
        boolean z;
        AlbumActivity albumActivity;
        TextView textView2;
        o oVar;
        o oVar2;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        if (!this.eYV.equals("-1")) {
            textView = this.eYU.Di;
            textView.setText(str);
            this.eYU.bbR();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            d dVar = new d();
            dVar.setAlbumId("-1");
            albumActivity = this.eYU.eXL;
            String string = albumActivity.getPageContext().getString(t.j.write_album_all);
            dVar.setName(string);
            dVar.pa(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.f((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.eYU.Di;
            textView2.setText(string);
            oVar = this.eYU.eXw;
            oVar.cN(arrayList2);
            oVar2 = this.eYU.eXw;
            oVar2.cO(arrayList);
            z = true;
        }
        this.eYU.setData(arrayList, z);
    }
}
