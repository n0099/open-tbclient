package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class ai implements a.InterfaceC0076a {
    final /* synthetic */ ad cRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ad adVar) {
        this.cRf = adVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0076a
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
            mVar = this.cRf.cPJ;
            if (!albumId.equals(mVar.atM())) {
                mVar2 = this.cRf.cPJ;
                List<ImageFileInfo> atP = mVar2.atP();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : atP) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = atP;
                }
                mVar3 = this.cRf.cPJ;
                mVar3.bn(list);
                mVar4 = this.cRf.cPJ;
                mVar4.kX(albumId);
                this.cRf.setData(list, z);
                textView = this.cRf.LM;
                textView.setText(name);
            }
        }
    }
}
