package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class ao implements com.baidu.tieba.write.view.e {
    final /* synthetic */ aj czq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(aj ajVar) {
        this.czq = ajVar;
    }

    @Override // com.baidu.tieba.write.view.e
    public void a(int i, a aVar) {
        p pVar;
        p pVar2;
        boolean z;
        List<ImageFileInfo> list;
        p pVar3;
        p pVar4;
        TextView textView;
        String albumId = aVar.getAlbumId();
        String name = aVar.getName();
        if (!TextUtils.isEmpty(albumId)) {
            pVar = this.czq.cxV;
            if (!albumId.equals(pVar.arP())) {
                pVar2 = this.czq.cxV;
                List<ImageFileInfo> arS = pVar2.arS();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : arS) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = arS;
                }
                pVar3 = this.czq.cxV;
                pVar3.be(list);
                pVar4 = this.czq.cxV;
                pVar4.jX(albumId);
                this.czq.setData(list, z);
                textView = this.czq.mTitleText;
                textView.setText(name);
            }
        }
    }
}
