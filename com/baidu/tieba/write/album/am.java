package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag eIc;
    private final /* synthetic */ String eId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.eIc = agVar;
        this.eId = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void nh() {
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
        if (!this.eId.equals("-1")) {
            textView = this.eIc.MR;
            textView.setText(str);
            this.eIc.aZv();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            d dVar = new d();
            dVar.oA("-1");
            albumActivity = this.eIc.eGS;
            String string = albumActivity.getPageContext().getString(t.j.write_album_all);
            dVar.setName(string);
            dVar.oL(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.f((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.eIc.MR;
            textView2.setText(string);
            oVar = this.eIc.eGD;
            oVar.cF(arrayList2);
            oVar2 = this.eIc.eGD;
            oVar2.cG(arrayList);
            z = true;
        }
        this.eIc.setData(arrayList, z);
    }
}
