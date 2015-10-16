package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements al {
    final /* synthetic */ ac dlo;
    private final /* synthetic */ String dlp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ac acVar, String str) {
        this.dlo = acVar;
        this.dlp = str;
    }

    @Override // com.baidu.tieba.write.album.al
    public void nu() {
    }

    @Override // com.baidu.tieba.write.album.al
    public void a(List<a> list, List<ImageFileInfo> list2, String str) {
        TextView textView;
        boolean z;
        AlbumActivity albumActivity;
        TextView textView2;
        l lVar;
        l lVar2;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        if (!this.dlp.equals("-1")) {
            textView = this.dlo.LN;
            textView.setText(str);
            this.dlo.aBG();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            a aVar = new a();
            aVar.mj("-1");
            albumActivity = this.dlo.djW;
            String string = albumActivity.getPageContext().getString(i.h.write_album_all);
            aVar.setName(string);
            aVar.mk(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                aVar.e((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, aVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.dlo.LN;
            textView2.setText(string);
            lVar = this.dlo.djP;
            lVar.bH(arrayList2);
            lVar2 = this.dlo.djP;
            lVar2.bI(arrayList);
            z = true;
        }
        this.dlo.setData(arrayList, z);
    }
}
