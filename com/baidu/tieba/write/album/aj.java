package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements am {
    final /* synthetic */ ad cZQ;
    private final /* synthetic */ String cZR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ad adVar, String str) {
        this.cZQ = adVar;
        this.cZR = str;
    }

    @Override // com.baidu.tieba.write.album.am
    public void nt() {
    }

    @Override // com.baidu.tieba.write.album.am
    public void a(List<b> list, List<ImageFileInfo> list2, String str) {
        TextView textView;
        boolean z;
        AlbumActivity albumActivity;
        TextView textView2;
        m mVar;
        m mVar2;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        if (!this.cZR.equals("-1")) {
            textView = this.cZQ.LM;
            textView.setText(str);
            this.cZQ.ayq();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            b bVar = new b();
            bVar.lB("-1");
            albumActivity = this.cZQ.cYB;
            String string = albumActivity.getPageContext().getString(i.h.write_album_all);
            bVar.setName(string);
            bVar.lC(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                bVar.e((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, bVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.cZQ.LM;
            textView2.setText(string);
            mVar = this.cZQ.cYt;
            mVar.bx(arrayList2);
            mVar2 = this.cZQ.cYt;
            mVar2.by(arrayList);
            z = true;
        }
        this.cZQ.setData(arrayList, z);
    }
}
