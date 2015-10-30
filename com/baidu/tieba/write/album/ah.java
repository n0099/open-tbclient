package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class ah implements a.InterfaceC0082a {
    final /* synthetic */ ac dlo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ac acVar) {
        this.dlo = acVar;
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
            lVar = this.dlo.djP;
            if (!albumId.equals(lVar.aBp())) {
                lVar2 = this.dlo.djP;
                List<ImageFileInfo> aBs = lVar2.aBs();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : aBs) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = aBs;
                }
                lVar3 = this.dlo.djP;
                lVar3.bG(list);
                lVar4 = this.dlo.djP;
                lVar4.mm(albumId);
                this.dlo.setData(list, z);
                textView = this.dlo.LN;
                textView.setText(name);
            }
        }
    }
}
