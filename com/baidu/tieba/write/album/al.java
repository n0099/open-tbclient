package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0090a {
    final /* synthetic */ ag eIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.eIc = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0090a
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
            oVar = this.eIc.eGD;
            if (!albumId.equals(oVar.aZj())) {
                oVar2 = this.eIc.eGD;
                List<ImageFileInfo> aZl = oVar2.aZl();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : aZl) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = aZl;
                }
                oVar3 = this.eIc.eGD;
                oVar3.cE(list);
                oVar4 = this.eIc.eGD;
                oVar4.oM(albumId);
                this.eIc.setData(list, z);
                textView = this.eIc.MR;
                textView.setText(name);
            }
        }
    }
}
