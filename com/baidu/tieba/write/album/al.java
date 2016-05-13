package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0083a {
    final /* synthetic */ ag eYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.eYU = agVar;
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
            oVar = this.eYU.eXw;
            if (!albumId.equals(oVar.bbF())) {
                oVar2 = this.eYU.eXw;
                List<ImageFileInfo> bbH = oVar2.bbH();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : bbH) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = bbH;
                }
                oVar3 = this.eYU.eXw;
                oVar3.cM(list);
                oVar4 = this.eYU.eXw;
                oVar4.pb(albumId);
                this.eYU.setData(list, z);
                textView = this.eYU.Di;
                textView.setText(name);
            }
        }
    }
}
