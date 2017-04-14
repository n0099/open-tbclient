package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0078a {
    final /* synthetic */ ag fOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.fOn = agVar;
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
            oVar = this.fOn.fMH;
            if (!albumId.equals(oVar.bnD())) {
                oVar2 = this.fOn.fMH;
                List<ImageFileInfo> bnG = oVar2.bnG();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : bnG) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = bnG;
                }
                oVar3 = this.fOn.fMH;
                oVar3.cX(list);
                oVar4 = this.fOn.fMH;
                oVar4.qZ(albumId);
                this.fOn.setData(list, z);
                textView = this.fOn.bIG;
                textView.setText(name);
            }
        }
    }
}
