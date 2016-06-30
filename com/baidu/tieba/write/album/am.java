package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag fDY;
    private final /* synthetic */ String fDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.fDY = agVar;
        this.fDZ = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void jy() {
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
        if (!this.fDZ.equals("-1")) {
            textView = this.fDY.Dj;
            textView.setText(str);
            this.fDY.bkn();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            d dVar = new d();
            dVar.setAlbumId("-1");
            albumActivity = this.fDY.fCP;
            String string = albumActivity.getPageContext().getString(u.j.write_album_all);
            dVar.setName(string);
            dVar.qK(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.g((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.fDY.Dj;
            textView2.setText(string);
            oVar = this.fDY.fCA;
            oVar.de(arrayList2);
            oVar2 = this.fDY.fCA;
            oVar2.df(arrayList);
            z = true;
        }
        this.fDY.setData(arrayList, z);
    }
}
