package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0083a {
    final /* synthetic */ ag eYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.eYV = agVar;
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
            oVar = this.eYV.eXx;
            if (!albumId.equals(oVar.bby())) {
                oVar2 = this.eYV.eXx;
                List<ImageFileInfo> bbA = oVar2.bbA();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : bbA) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = bbA;
                }
                oVar3 = this.eYV.eXx;
                oVar3.cM(list);
                oVar4 = this.eYV.eXx;
                oVar4.pb(albumId);
                this.eYV.setData(list, z);
                textView = this.eYV.Di;
                textView.setText(name);
            }
        }
    }
}
