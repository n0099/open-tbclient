package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements aq {
    final /* synthetic */ ah cuX;
    private final /* synthetic */ String cuY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ah ahVar, String str) {
        this.cuX = ahVar;
        this.cuY = str;
    }

    @Override // com.baidu.tieba.write.album.aq
    public void mU() {
    }

    @Override // com.baidu.tieba.write.album.aq
    public void a(List<a> list, List<ImageFileInfo> list2, String str) {
        TextView textView;
        boolean z;
        AlbumActivity albumActivity;
        TextView textView2;
        n nVar;
        n nVar2;
        if (!this.cuY.equals("-1")) {
            textView = this.cuX.mTitleText;
            textView.setText(str);
            this.cuX.aqj();
            z = false;
        } else {
            a aVar = new a();
            aVar.ja("-1");
            albumActivity = this.cuX.ctK;
            String string = albumActivity.getPageContext().getString(com.baidu.tieba.y.write_album_all);
            aVar.setName(string);
            aVar.jb(String.valueOf(list2.size()));
            if (list2.size() > 0) {
                aVar.e(list2.get(0));
            }
            list.add(0, aVar);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setAlbumnId("-2");
            list2.add(0, imageFileInfo);
            textView2 = this.cuX.mTitleText;
            textView2.setText(string);
            nVar = this.cuX.ctF;
            nVar.bd(list);
            nVar2 = this.cuX.ctF;
            nVar2.be(list2);
            z = true;
        }
        this.cuX.setData(list2, z);
    }
}
