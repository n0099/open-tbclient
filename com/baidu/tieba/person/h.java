package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        boolean b;
        int i3;
        boolean z;
        String str = TbConfig.PERSON_HEAD_FILE;
        i = this.this$0.bHT;
        if (i != 0) {
            str = TbConfig.GROUP_HEAD_FILE;
        }
        EditHeadsImageView editHeadsImageView = this.this$0.cod;
        i2 = this.this$0.bHT;
        Bitmap eU = editHeadsImageView.eU(i2 == 0);
        if (eU == null) {
            return;
        }
        b = this.this$0.b(str, eU);
        if (b) {
            i3 = this.this$0.bHT;
            if (i3 == 0) {
                z = this.this$0.azp;
                if (z) {
                    this.this$0.aid();
                    return;
                }
                this.this$0.setResult(-1);
                this.this$0.closeActivity();
                return;
            }
            com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.n.cI(TbConfig.GROUP_HEAD_FILE), "head");
            aVar.Cg();
            aVar.a(new i(this));
            aVar.Ce();
            this.this$0.showLoadingDialog(this.this$0.getPageContext().getString(i.h.uploading));
        }
    }
}
