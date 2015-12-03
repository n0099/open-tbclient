package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0091a {
    final /* synthetic */ ag dMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.dMc = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0091a
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
            oVar = this.dMc.dKx;
            if (!albumId.equals(oVar.aHC())) {
                oVar2 = this.dMc.dKx;
                List<ImageFileInfo> aHF = oVar2.aHF();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : aHF) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = aHF;
                }
                oVar3 = this.dMc.dKx;
                oVar3.bY(list);
                oVar4 = this.dMc.dKx;
                oVar4.nl(albumId);
                this.dMc.setData(list, z);
                textView = this.dMc.Mf;
                textView.setText(name);
            }
        }
    }
}
