package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag eog;
    private final /* synthetic */ String eoh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.eog = agVar;
        this.eoh = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void np() {
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
        if (!this.eoh.equals("-1")) {
            textView = this.eog.ML;
            textView.setText(str);
            this.eog.aSV();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            d dVar = new d();
            dVar.nl("-1");
            albumActivity = this.eog.emU;
            String string = albumActivity.getPageContext().getString(t.j.write_album_all);
            dVar.setName(string);
            dVar.ny(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.d((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.eog.ML;
            textView2.setText(string);
            oVar = this.eog.emG;
            oVar.cp(arrayList2);
            oVar2 = this.eog.emG;
            oVar2.cq(arrayList);
            z = true;
        }
        this.eog.setData(arrayList, z);
    }
}
