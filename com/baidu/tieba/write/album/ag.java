package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements a.InterfaceC0085a {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ac acVar) {
        this.fNP = acVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0085a
    public void a(int i, e eVar) {
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        TextView textView;
        TransparentHeadGridView transparentHeadGridView;
        String albumId = eVar.getAlbumId();
        String name = eVar.getName();
        if (!TextUtils.isEmpty(albumId)) {
            pVar = this.fNP.fLQ;
            if (!albumId.equals(pVar.bmr())) {
                pVar2 = this.fNP.fLQ;
                List<ImageFileInfo> bmu = pVar2.bmu();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : bmu) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    bmu = arrayList;
                }
                pVar3 = this.fNP.fLQ;
                pVar3.cN(bmu);
                pVar4 = this.fNP.fLQ;
                pVar4.qU(albumId);
                this.fNP.setData(bmu);
                textView = this.fNP.bKb;
                textView.setText(name);
                transparentHeadGridView = this.fNP.fNo;
                transparentHeadGridView.smoothScrollToPosition(0);
            }
        }
    }
}
