package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag dMc;
    private final /* synthetic */ String dMd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.dMc = agVar;
        this.dMd = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void nB() {
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
        if (!this.dMd.equals("-1")) {
            textView = this.dMc.Mf;
            textView.setText(str);
            this.dMc.aHP();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            d dVar = new d();
            dVar.ni("-1");
            albumActivity = this.dMc.dKK;
            String string = albumActivity.getPageContext().getString(n.i.write_album_all);
            dVar.setName(string);
            dVar.nj(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.d((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.dMc.Mf;
            textView2.setText(string);
            oVar = this.dMc.dKx;
            oVar.bZ(arrayList2);
            oVar2 = this.dMc.dKx;
            oVar2.ca(arrayList);
            z = true;
        }
        this.dMc.setData(arrayList, z);
    }
}
