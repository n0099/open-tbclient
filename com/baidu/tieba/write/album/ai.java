package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements al {
    final /* synthetic */ ac dkO;
    private final /* synthetic */ String dkP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ac acVar, String str) {
        this.dkO = acVar;
        this.dkP = str;
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
        if (!this.dkP.equals("-1")) {
            textView = this.dkO.LM;
            textView.setText(str);
            this.dkO.aBw();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            a aVar = new a();
            aVar.mg("-1");
            albumActivity = this.dkO.djw;
            String string = albumActivity.getPageContext().getString(i.h.write_album_all);
            aVar.setName(string);
            aVar.mh(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                aVar.e((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, aVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.dkO.LM;
            textView2.setText(string);
            lVar = this.dkO.djp;
            lVar.bG(arrayList2);
            lVar2 = this.dkO.djp;
            lVar2.bH(arrayList);
            z = true;
        }
        this.dkO.setData(arrayList, z);
    }
}
