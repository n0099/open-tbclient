package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag fRl;
    private final /* synthetic */ String fRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.fRl = agVar;
        this.fRm = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void jx() {
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
        if (!this.fRm.equals("-1")) {
            textView = this.fRl.DK;
            textView.setText(str);
            this.fRl.bnJ();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            d dVar = new d();
            dVar.setAlbumId("-1");
            albumActivity = this.fRl.fQb;
            String string = albumActivity.getPageContext().getString(u.j.write_album_all);
            dVar.setName(string);
            dVar.rv(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.g((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.fRl.DK;
            textView2.setText(string);
            oVar = this.fRl.fPM;
            oVar.dq(arrayList2);
            oVar2 = this.fRl.fPM;
            oVar2.dr(arrayList);
            z = true;
        }
        this.fRl.setData(arrayList, z);
    }
}
