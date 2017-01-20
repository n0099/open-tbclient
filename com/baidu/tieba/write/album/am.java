package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag fIk;
    private final /* synthetic */ String fIl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.fIk = agVar;
        this.fIl = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void ko() {
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
        if (!com.baidu.tbadk.core.util.w.s(list2)) {
            arrayList.addAll(list2);
        }
        if (!this.fIl.equals("-1")) {
            textView = this.fIk.Fj;
            textView.setText(str);
            this.fIk.bnt();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            if (!com.baidu.tbadk.core.util.w.s(list)) {
                arrayList2.addAll(list);
            }
            d dVar = new d();
            dVar.ru("-1");
            albumActivity = this.fIk.fGS;
            String string = albumActivity.getPageContext().getString(r.l.write_album_all);
            dVar.setName(string);
            dVar.rv(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.f((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.fIk.Fj;
            textView2.setText(string);
            oVar = this.fIk.fGE;
            oVar.ds(arrayList2);
            oVar2 = this.fIk.fGE;
            oVar2.dt(arrayList);
            z = true;
        }
        this.fIk.setData(arrayList, z);
    }
}
