package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ap {
    final /* synthetic */ ag dTB;
    private final /* synthetic */ String dTC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar, String str) {
        this.dTB = agVar;
        this.dTC = str;
    }

    @Override // com.baidu.tieba.write.album.ap
    public void mZ() {
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
        if (!this.dTC.equals("-1")) {
            textView = this.dTB.Mv;
            textView.setText(str);
            this.dTB.aKk();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            d dVar = new d();
            dVar.ng("-1");
            albumActivity = this.dTB.dSj;
            String string = albumActivity.getPageContext().getString(n.j.write_album_all);
            dVar.setName(string);
            dVar.nh(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                dVar.d((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, dVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.dTB.Mv;
            textView2.setText(string);
            oVar = this.dTB.dRW;
            oVar.cc(arrayList2);
            oVar2 = this.dTB.dRW;
            oVar2.cd(arrayList);
            z = true;
        }
        this.dTB.setData(arrayList, z);
    }
}
