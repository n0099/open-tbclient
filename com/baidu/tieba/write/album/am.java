package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    private final /* synthetic */ String gdA;
    final /* synthetic */ ag gdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.gdz = agVar;
        this.gdA = str;
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
        if (!com.baidu.tbadk.core.util.y.t(list2)) {
            arrayList.addAll(list2);
        }
        if (!this.gdA.equals("-1")) {
            textView = this.gdz.FX;
            textView.setText(str);
            this.gdz.bsF();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            d dVar = new d();
            dVar.setAlbumId("-1");
            albumActivity = this.gdz.gco;
            String string = albumActivity.getPageContext().getString(r.j.write_album_all);
            dVar.setName(string);
            dVar.su(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.g((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.gdz.FX;
            textView2.setText(string);
            oVar = this.gdz.gbZ;
            oVar.dw(arrayList2);
            oVar2 = this.gdz.gbZ;
            oVar2.dx(arrayList);
            z = true;
        }
        this.gdz.setData(arrayList, z);
    }
}
