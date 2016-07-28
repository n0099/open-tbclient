package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0083a {
    final /* synthetic */ ag fRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.fRl = agVar;
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
            oVar = this.fRl.fPM;
            if (!albumId.equals(oVar.bnx())) {
                oVar2 = this.fRl.fPM;
                List<ImageFileInfo> bnz = oVar2.bnz();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : bnz) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = bnz;
                }
                oVar3 = this.fRl.fPM;
                oVar3.dp(list);
                oVar4 = this.fRl.fPM;
                oVar4.rw(albumId);
                this.fRl.setData(list, z);
                textView = this.fRl.DK;
                textView.setText(name);
            }
        }
    }
}
