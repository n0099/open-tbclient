package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class al implements a.InterfaceC0092a {
    final /* synthetic */ ag eog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ag agVar) {
        this.eog = agVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0092a
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
            oVar = this.eog.emG;
            if (!albumId.equals(oVar.aSJ())) {
                oVar2 = this.eog.emG;
                List<ImageFileInfo> aSL = oVar2.aSL();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : aSL) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = aSL;
                }
                oVar3 = this.eog.emG;
                oVar3.co(list);
                oVar4 = this.eog.emG;
                oVar4.nz(albumId);
                this.eog.setData(list, z);
                textView = this.eog.ML;
                textView.setText(name);
            }
        }
    }
}
