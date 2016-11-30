package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0086a {
    final /* synthetic */ ag gle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.gle = agVar;
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
            oVar = this.gle.gjE;
            if (!albumId.equals(oVar.buO())) {
                oVar2 = this.gle.gjE;
                List<ImageFileInfo> buQ = oVar2.buQ();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : buQ) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = buQ;
                }
                oVar3 = this.gle.gjE;
                oVar3.dB(list);
                oVar4 = this.gle.gjE;
                oVar4.sR(albumId);
                this.gle.setData(list, z);
                textView = this.gle.FZ;
                textView.setText(name);
            }
        }
    }
}
