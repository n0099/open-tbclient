package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.EditHeadsImageView;
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
        i = this.this$0.bDY;
        if (i != 0) {
            str = TbConfig.GROUP_HEAD_FILE;
        }
        EditHeadsImageView editHeadsImageView = this.this$0.chB;
        i2 = this.this$0.bDY;
        Bitmap bo = editHeadsImageView.bo(i2 == 0);
        if (bo == null) {
            return;
        }
        b = this.this$0.b(str, bo);
        if (b) {
            i3 = this.this$0.bDY;
            if (i3 == 0) {
                z = this.this$0.ayV;
                if (z) {
                    this.this$0.afS();
                    return;
                }
                this.this$0.setResult(-1);
                this.this$0.closeActivity();
                return;
            }
            com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.n.cB(TbConfig.GROUP_HEAD_FILE), "head");
            aVar.Ci();
            aVar.a(new i(this));
            aVar.Cg();
            this.this$0.showLoadingDialog(this.this$0.getPageContext().getString(i.C0057i.uploading));
        }
    }
}
