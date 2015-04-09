package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.write.view.e {
    final /* synthetic */ ah cuX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar) {
        this.cuX = ahVar;
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
            nVar = this.cuX.ctF;
            if (!albumId.equals(nVar.apY())) {
                nVar2 = this.cuX.ctF;
                List<ImageFileInfo> aqb = nVar2.aqb();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : aqb) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = aqb;
                }
                nVar3 = this.cuX.ctF;
                nVar3.bc(list);
                nVar4 = this.cuX.ctF;
                nVar4.je(albumId);
                this.cuX.setData(list, z);
                textView = this.cuX.mTitleText;
                textView.setText(name);
            }
        }
    }
}
