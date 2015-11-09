package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.view.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class aj implements a.InterfaceC0082a {
    final /* synthetic */ ae dmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ae aeVar) {
        this.dmW = aeVar;
    }

    @Override // com.baidu.tieba.write.view.a.InterfaceC0082a
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
            mVar = this.dmW.dlv;
            if (!albumId.equals(mVar.aCf())) {
                mVar2 = this.dmW.dlv;
                List<ImageFileInfo> aCi = mVar2.aCi();
                if (!albumId.equals("-1")) {
                    list = new ArrayList<>();
                    for (ImageFileInfo imageFileInfo : aCi) {
                        if (albumId.equals(imageFileInfo.getAlbumId())) {
                            list.add(imageFileInfo);
                        }
                    }
                    z = false;
                } else {
                    z = true;
                    list = aCi;
                }
                mVar3 = this.dmW.dlv;
                mVar3.bK(list);
                mVar4 = this.dmW.dlv;
                mVar4.mq(albumId);
                this.dmW.setData(list, z);
                textView = this.dmW.LO;
                textView.setText(name);
            }
        }
    }
}
