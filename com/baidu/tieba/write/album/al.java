package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0078a {
    final /* synthetic */ ag fQJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.fQJ = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0078a
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
            oVar = this.fQJ.fPd;
            if (!albumId.equals(oVar.boE())) {
                oVar2 = this.fQJ.fPd;
                List<ImageFileInfo> boH = oVar2.boH();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : boH) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = boH;
                }
                oVar3 = this.fQJ.fPd;
                oVar3.cX(list);
                oVar4 = this.fQJ.fPd;
                oVar4.ra(albumId);
                this.fQJ.setData(list, z);
                textView = this.fQJ.bKX;
                textView.setText(name);
            }
        }
    }
}
