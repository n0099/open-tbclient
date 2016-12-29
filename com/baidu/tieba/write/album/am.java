package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag fzH;
    private final /* synthetic */ String fzI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.fzH = agVar;
        this.fzI = str;
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
        if (!this.fzI.equals("-1")) {
            textView = this.fzH.FZ;
            textView.setText(str);
            this.fzH.blV();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            if (!com.baidu.tbadk.core.util.x.t(list)) {
                arrayList2.addAll(list);
            }
            d dVar = new d();
            dVar.rb("-1");
            albumActivity = this.fzH.fyo;
            String string = albumActivity.getPageContext().getString(r.j.write_album_all);
            dVar.setName(string);
            dVar.rc(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.f((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.fzH.FZ;
            textView2.setText(string);
            oVar = this.fzH.fxZ;
            oVar.dn(arrayList2);
            oVar2 = this.fzH.fxZ;
            oVar2.m25do(arrayList);
            z = true;
        }
        this.fzH.setData(arrayList, z);
    }
}
