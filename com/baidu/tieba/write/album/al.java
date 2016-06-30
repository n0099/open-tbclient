package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0085a {
    final /* synthetic */ ag fDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.fDY = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0085a
    public void a(int i, d dVar) {
        o oVar;
        o oVar2;
        boolean z;
        List<ImageFileInfo> list;
        o oVar3;
        o oVar4;
        TextView textView;
        String albumId = dVar.getAlbumId();
        String name = dVar.getName();
        if (!TextUtils.isEmpty(albumId)) {
            oVar = this.fDY.fCA;
            if (!albumId.equals(oVar.bkb())) {
                oVar2 = this.fDY.fCA;
                List<ImageFileInfo> bkd = oVar2.bkd();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : bkd) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = bkd;
                }
                oVar3 = this.fDY.fCA;
                oVar3.dd(list);
                oVar4 = this.fDY.fCA;
                oVar4.qL(albumId);
                this.fDY.setData(list, z);
                textView = this.fDY.Dj;
                textView.setText(name);
            }
        }
    }
}
