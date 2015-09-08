package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class ai implements a.InterfaceC0079a {
    final /* synthetic */ ad cZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ad adVar) {
        this.cZQ = adVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0079a
    public void a(int i, b bVar) {
        m mVar;
        m mVar2;
        boolean z;
        List<ImageFileInfo> list;
        m mVar3;
        m mVar4;
        TextView textView;
        String albumId = bVar.getAlbumId();
        String name = bVar.getName();
        if (!TextUtils.isEmpty(albumId)) {
            mVar = this.cZQ.cYt;
            if (!albumId.equals(mVar.ayf())) {
                mVar2 = this.cZQ.cYt;
                List<ImageFileInfo> ayi = mVar2.ayi();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : ayi) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = ayi;
                }
                mVar3 = this.cZQ.cYt;
                mVar3.bw(list);
                mVar4 = this.cZQ.cYt;
                mVar4.lE(albumId);
                this.cZQ.setData(list, z);
                textView = this.cZQ.LM;
                textView.setText(name);
            }
        }
    }
}
