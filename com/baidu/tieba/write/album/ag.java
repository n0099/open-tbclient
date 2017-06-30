package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements a.InterfaceC0090a {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ac acVar) {
        this.ggh = acVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0090a
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
            pVar = this.ggh.gei;
            if (!albumId.equals(pVar.bsl())) {
                pVar2 = this.ggh.gei;
                List<ImageFileInfo> bso = pVar2.bso();
                if (!albumId.equals("-1")) {
                    ArrayList arrayList = new ArrayList();
                    for (ImageFileInfo imageFileInfo : bso) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            arrayList.add(imageFileInfo);
                        }
                    }
                    bso = arrayList;
                }
                pVar3 = this.ggh.gei;
                pVar3.de(bso);
                pVar4 = this.ggh.gei;
                pVar4.sg(albumId);
                this.ggh.setData(bso);
                textView = this.ggh.bWL;
                textView.setText(name);
                transparentHeadGridView = this.ggh.gfG;
                transparentHeadGridView.smoothScrollToPosition(0);
            }
        }
    }
}
