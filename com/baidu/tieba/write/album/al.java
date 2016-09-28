package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0086a {
    final /* synthetic */ ag gdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.gdz = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0086a
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
            oVar = this.gdz.gbZ;
            if (!albumId.equals(oVar.bst())) {
                oVar2 = this.gdz.gbZ;
                List<ImageFileInfo> bsv = oVar2.bsv();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : bsv) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = bsv;
                }
                oVar3 = this.gdz.gbZ;
                oVar3.dv(list);
                oVar4 = this.gdz.gbZ;
                oVar4.sv(albumId);
                this.gdz.setData(list, z);
                textView = this.gdz.FX;
                textView.setText(name);
            }
        }
    }
}
