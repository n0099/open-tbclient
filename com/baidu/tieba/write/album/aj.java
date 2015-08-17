package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements am {
    final /* synthetic */ ad cRf;
    private final /* synthetic */ String cRg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ad adVar, String str) {
        this.cRf = adVar;
        this.cRg = str;
    }

    @Override // com.baidu.tieba.write.album.am
    public void nw() {
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
        if (!this.cRg.equals("-1")) {
            textView = this.cRf.LM;
            textView.setText(str);
            this.cRf.atX();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            b bVar = new b();
            bVar.kU("-1");
            albumActivity = this.cRf.cPQ;
            String string = albumActivity.getPageContext().getString(i.C0057i.write_album_all);
            bVar.setName(string);
            bVar.kV(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                bVar.e((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, bVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.cRf.LM;
            textView2.setText(string);
            mVar = this.cRf.cPJ;
            mVar.bo(arrayList2);
            mVar2 = this.cRf.cPJ;
            mVar2.bp(arrayList);
            z = true;
        }
        this.cRf.setData(arrayList, z);
    }
}
