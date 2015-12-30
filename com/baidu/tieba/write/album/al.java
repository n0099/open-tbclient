package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0087a {
    final /* synthetic */ ag dTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.dTB = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0087a
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
            oVar = this.dTB.dRW;
            if (!albumId.equals(oVar.aJX())) {
                oVar2 = this.dTB.dRW;
                List<ImageFileInfo> aKa = oVar2.aKa();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : aKa) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = aKa;
                }
                oVar3 = this.dTB.dRW;
                oVar3.cb(list);
                oVar4 = this.dTB.dRW;
                oVar4.nj(albumId);
                this.dTB.setData(list, z);
                textView = this.dTB.Mv;
                textView.setText(name);
            }
        }
    }
}
