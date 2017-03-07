package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0079a {
    final /* synthetic */ ag fME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.fME = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0079a
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
            oVar = this.fME.fKY;
            if (!albumId.equals(oVar.bmT())) {
                oVar2 = this.fME.fKY;
                List<ImageFileInfo> bmW = oVar2.bmW();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : bmW) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = bmW;
                }
                oVar3 = this.fME.fKY;
                oVar3.cY(list);
                oVar4 = this.fME.fKY;
                oVar4.qF(albumId);
                this.fME.setData(list, z);
                textView = this.fME.bIN;
                textView.setText(name);
            }
        }
    }
}
