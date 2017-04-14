package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag fOn;
    private final /* synthetic */ String fOo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.fOn = agVar;
        this.fOo = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void lm() {
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
        if (!com.baidu.tbadk.core.util.x.q(list2)) {
            arrayList.addAll(list2);
        }
        if (!this.fOo.equals("-1")) {
            textView = this.fOn.bIG;
            textView.setText(str);
            this.fOn.bnQ();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            if (!com.baidu.tbadk.core.util.x.q(list)) {
                arrayList2.addAll(list);
            }
            d dVar = new d();
            dVar.qW("-1");
            albumActivity = this.fOn.fMV;
            String string = albumActivity.getPageContext().getString(w.l.write_album_all);
            dVar.setName(string);
            dVar.qX(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.f((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.fOn.bIG;
            textView2.setText(string);
            oVar = this.fOn.fMH;
            oVar.cY(arrayList2);
            oVar2 = this.fOn.fMH;
            oVar2.cZ(arrayList);
            z = true;
        }
        this.fOn.setData(arrayList, z);
    }
}
