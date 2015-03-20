package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.write.view.e {
    final /* synthetic */ ah cuH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar) {
        this.cuH = ahVar;
    }

    @Override // com.baidu.tieba.write.view.e
    public void a(int i, a aVar) {
        n nVar;
        n nVar2;
        boolean z;
        List<ImageFileInfo> list;
        n nVar3;
        n nVar4;
        TextView textView;
        String albumId = aVar.getAlbumId();
        String name = aVar.getName();
        if (!TextUtils.isEmpty(albumId)) {
            nVar = this.cuH.ctp;
            if (!albumId.equals(nVar.apJ())) {
                nVar2 = this.cuH.ctp;
                List<ImageFileInfo> apM = nVar2.apM();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : apM) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = apM;
                }
                nVar3 = this.cuH.ctp;
                nVar3.aY(list);
                nVar4 = this.cuH.ctp;
                nVar4.jb(albumId);
                this.cuH.setData(list, z);
                textView = this.cuH.mTitleText;
                textView.setText(name);
            }
        }
    }
}
