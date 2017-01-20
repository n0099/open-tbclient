package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0080a {
    final /* synthetic */ ag fIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.fIk = agVar;
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
            oVar = this.fIk.fGE;
            if (!albumId.equals(oVar.bng())) {
                oVar2 = this.fIk.fGE;
                List<ImageFileInfo> bnj = oVar2.bnj();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : bnj) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = bnj;
                }
                oVar3 = this.fIk.fGE;
                oVar3.dr(list);
                oVar4 = this.fIk.fGE;
                oVar4.rx(albumId);
                this.fIk.setData(list, z);
                textView = this.fIk.Fj;
                textView.setText(name);
            }
        }
    }
}
