package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0083a {
    final /* synthetic */ ag gbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.gbq = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0083a
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
            oVar = this.gbq.fZQ;
            if (!albumId.equals(oVar.brN())) {
                oVar2 = this.gbq.fZQ;
                List<ImageFileInfo> brP = oVar2.brP();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : brP) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = brP;
                }
                oVar3 = this.gbq.fZQ;
                oVar3.du(list);
                oVar4 = this.gbq.fZQ;
                oVar4.sg(albumId);
                this.gbq.setData(list, z);
                textView = this.gbq.FX;
                textView.setText(name);
            }
        }
    }
}
