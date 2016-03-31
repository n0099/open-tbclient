package com.baidu.tieba.write.vote;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g eKP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.eKP = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        b bVar;
        int i;
        b bVar2;
        int i2;
        b bVar3;
        int i3;
        ImageFileInfo imageFileInfo;
        imageView = this.eKP.eKK;
        if (view != imageView) {
            imageView2 = this.eKP.eKM;
            if (view == imageView2) {
                bVar = this.eKP.eKO;
                i = this.eKP.mId;
                bVar.qG(i);
            }
        } else if (this.eKP.baB()) {
            bVar3 = this.eKP.eKO;
            i3 = this.eKP.mId;
            imageFileInfo = this.eKP.bKH;
            bVar3.P(i3, imageFileInfo.getFilePath());
        } else {
            bVar2 = this.eKP.eKO;
            i2 = this.eKP.mId;
            bVar2.qF(i2);
        }
    }
}
