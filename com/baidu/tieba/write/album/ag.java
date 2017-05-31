package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements a.InterfaceC0088a {
    final /* synthetic */ ac fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ac acVar) {
        this.fVw = acVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0088a
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
            pVar = this.fVw.fTx;
            if (!albumId.equals(pVar.bnO())) {
                pVar2 = this.fVw.fTx;
                List<ImageFileInfo> bnR = pVar2.bnR();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : bnR) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    bnR = arrayList;
                }
                pVar3 = this.fVw.fTx;
                pVar3.cP(bnR);
                pVar4 = this.fVw.fTx;
                pVar4.rh(albumId);
                this.fVw.setData(bnR);
                textView = this.fVw.bPO;
                textView.setText(name);
                transparentHeadGridView = this.fVw.fUV;
                transparentHeadGridView.smoothScrollToPosition(0);
            }
        }
    }
}
