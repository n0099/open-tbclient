package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0080a {
    final /* synthetic */ ag fzH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.fzH = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0080a
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
            oVar = this.fzH.fxZ;
            if (!albumId.equals(oVar.blI())) {
                oVar2 = this.fzH.fxZ;
                List<ImageFileInfo> blL = oVar2.blL();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : blL) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = blL;
                }
                oVar3 = this.fzH.fxZ;
                oVar3.dm(list);
                oVar4 = this.fzH.fxZ;
                oVar4.re(albumId);
                this.fzH.setData(list, z);
                textView = this.fzH.FZ;
                textView.setText(name);
            }
        }
    }
}
