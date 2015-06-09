package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements as {
    final /* synthetic */ aj czq;
    private final /* synthetic */ String czr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(aj ajVar, String str) {
        this.czq = ajVar;
        this.czr = str;
    }

    @Override // com.baidu.tieba.write.album.as
    public void nm() {
    }

    @Override // com.baidu.tieba.write.album.as
    public void a(List<a> list, List<ImageFileInfo> list2, String str) {
        TextView textView;
        boolean z;
        AlbumActivity albumActivity;
        TextView textView2;
        p pVar;
        p pVar2;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        if (!this.czr.equals("-1")) {
            textView = this.czq.mTitleText;
            textView.setText(str);
            this.czq.asa();
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            a aVar = new a();
            aVar.jU("-1");
            albumActivity = this.czq.cya;
            String string = albumActivity.getPageContext().getString(com.baidu.tieba.t.write_album_all);
            aVar.setName(string);
            aVar.jV(String.valueOf(arrayList.size()));
            if (arrayList.size() > 0) {
                aVar.e((ImageFileInfo) arrayList.get(0));
            }
            arrayList2.add(0, aVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            arrayList.add(0, imageFileInfo);
            textView2 = this.czq.mTitleText;
            textView2.setText(string);
            pVar = this.czq.cxV;
            pVar.bf(arrayList2);
            pVar2 = this.czq.cxV;
            pVar2.bg(arrayList);
            z = true;
        }
        this.czq.setData(arrayList, z);
    }
}
