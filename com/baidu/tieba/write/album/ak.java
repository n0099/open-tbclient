package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements an {
    final /* synthetic */ ae dmW;
    private final /* synthetic */ String dmX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ae aeVar, String str) {
        this.dmW = aeVar;
        this.dmX = str;
    }

    @Override // com.baidu.tieba.write.album.an
    public void nv() {
    }

    @Override // com.baidu.tieba.write.album.an
    public void a(List<b> list, List<ImageFileInfo> list2, String str) {
        TextView textView;
        boolean z;
        AlbumActivity albumActivity;
        TextView textView2;
        m mVar;
        m mVar2;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        if (!this.dmX.equals("-1")) {
            textView = this.dmW.LO;
            textView.setText(str);
            this.dmW.aCs();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            b bVar = new b();
            bVar.mn("-1");
            albumActivity = this.dmW.dlE;
            String string = albumActivity.getPageContext().getString(i.h.write_album_all);
            bVar.setName(string);
            bVar.mo(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                bVar.f((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, bVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.dmW.LO;
            textView2.setText(string);
            mVar = this.dmW.dlv;
            mVar.bL(arrayList2);
            mVar2 = this.dmW.dlv;
            mVar2.bM(arrayList);
            z = true;
        }
        this.dmW.setData(arrayList, z);
    }
}
