package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag gle;
    private final /* synthetic */ String glf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.gle = agVar;
        this.glf = str;
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
        if (!com.baidu.tbadk.core.util.x.t(list2)) {
            arrayList.addAll(list2);
        }
        if (!this.glf.equals("-1")) {
            textView = this.gle.FZ;
            textView.setText(str);
            this.gle.bva();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            if (!com.baidu.tbadk.core.util.x.t(list)) {
                arrayList2.addAll(list);
            }
            d dVar = new d();
            dVar.setAlbumId("-1");
            albumActivity = this.gle.gjT;
            String string = albumActivity.getPageContext().getString(r.j.write_album_all);
            dVar.setName(string);
            dVar.sQ(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.g((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.gle.FZ;
            textView2.setText(string);
            oVar = this.gle.gjE;
            oVar.dC(arrayList2);
            oVar2 = this.gle.gjE;
            oVar2.dD(arrayList);
            z = true;
        }
        this.gle.setData(arrayList, z);
    }
}
