package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class ao implements com.baidu.tieba.write.view.e {
    final /* synthetic */ aj czp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(aj ajVar) {
        this.czp = ajVar;
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
            pVar = this.czp.cxU;
            if (!albumId.equals(pVar.arO())) {
                pVar2 = this.czp.cxU;
                List<ImageFileInfo> arR = pVar2.arR();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : arR) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = arR;
                }
                pVar3 = this.czp.cxU;
                pVar3.be(list);
                pVar4 = this.czp.cxU;
                pVar4.jX(albumId);
                this.czp.setData(list, z);
                textView = this.czp.mTitleText;
                textView.setText(name);
            }
        }
    }
}
