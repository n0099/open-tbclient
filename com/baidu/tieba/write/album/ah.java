package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class ah implements a.InterfaceC0082a {
    final /* synthetic */ ac dkO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ac acVar) {
        this.dkO = acVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0082a
    public void a(int i, a aVar) {
        l lVar;
        l lVar2;
        boolean z;
        List<ImageFileInfo> list;
        l lVar3;
        l lVar4;
        TextView textView;
        String albumId = aVar.getAlbumId();
        String name = aVar.getName();
        if (!TextUtils.isEmpty(albumId)) {
            lVar = this.dkO.djp;
            if (!albumId.equals(lVar.aBj())) {
                lVar2 = this.dkO.djp;
                List<ImageFileInfo> aBm = lVar2.aBm();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : aBm) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = aBm;
                }
                lVar3 = this.dkO.djp;
                lVar3.bF(list);
                lVar4 = this.dkO.djp;
                lVar4.mj(albumId);
                this.dkO.setData(list, z);
                textView = this.dkO.LM;
                textView.setText(name);
            }
        }
    }
}
