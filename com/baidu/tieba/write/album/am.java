package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag gbq;
    private final /* synthetic */ String gbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.gbq = agVar;
        this.gbr = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void ks() {
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
        if (!this.gbr.equals("-1")) {
            textView = this.gbq.FX;
            textView.setText(str);
            this.gbq.brZ();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            d dVar = new d();
            dVar.setAlbumId("-1");
            albumActivity = this.gbq.gaf;
            String string = albumActivity.getPageContext().getString(t.j.write_album_all);
            dVar.setName(string);
            dVar.sf(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.g((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.gbq.FX;
            textView2.setText(string);
            oVar = this.gbq.fZQ;
            oVar.dv(arrayList2);
            oVar2 = this.gbq.fZQ;
            oVar2.dw(arrayList);
            z = true;
        }
        this.gbq.setData(arrayList, z);
    }
}
