package com.baidu.tieba.person;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        boolean z;
        int i2;
        boolean b;
        int i3;
        boolean z2;
        String str = TbConfig.PERSON_HEAD_FILE;
        i = this.this$0.bXu;
        if (i == 0) {
            z = this.this$0.aAh;
            if (!z) {
                str = TbConfig.PERSON_USER_PIC_TEMP_FILE;
            }
        } else {
            str = TbConfig.GROUP_HEAD_FILE;
        }
        EditHeadsImageView editHeadsImageView = this.this$0.cIU;
        i2 = this.this$0.bXu;
        Bitmap fC = editHeadsImageView.fC(i2 == 0);
        if (fC == null) {
            return;
        }
        b = this.this$0.b(str, fC);
        if (b) {
            i3 = this.this$0.bXu;
            if (i3 == 0) {
                z2 = this.this$0.aAh;
                if (z2) {
                    this.this$0.anm();
                    return;
                }
                Intent intent = this.this$0.getIntent();
                intent.putExtra("upload_image_type", 2);
                this.this$0.setResult(-1, intent);
                this.this$0.closeActivity();
                return;
            }
            com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.n.cQ(str), "head");
            aVar.Da();
            aVar.a(new j(this));
            aVar.br(false);
            this.this$0.showLoadingDialog(this.this$0.getPageContext().getString(n.i.uploading));
        }
    }
}
