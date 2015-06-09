package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.EditHeadsImageView;
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
        EditHeadsImageView editHeadsImageView;
        int i2;
        boolean b;
        int i3;
        String str = TbConfig.PERSON_HEAD_FILE;
        i = this.this$0.bql;
        if (i != 0) {
            str = TbConfig.GROUP_HEAD_FILE;
        }
        editHeadsImageView = this.this$0.bQY;
        i2 = this.this$0.bql;
        Bitmap bn = editHeadsImageView.bn(i2 == 0);
        if (bn == null) {
            return;
        }
        b = this.this$0.b(str, bn);
        if (b) {
            i3 = this.this$0.bql;
            if (i3 == 0) {
                this.this$0.aeb();
                return;
            }
            com.baidu.tbadk.img.a aVar = new com.baidu.tbadk.img.a(com.baidu.tbadk.core.util.o.cA(TbConfig.GROUP_HEAD_FILE), "head");
            aVar.Aq();
            aVar.a(new i(this));
            aVar.Ao();
            this.this$0.showLoadingDialog(this.this$0.getPageContext().getString(com.baidu.tieba.t.uploading));
        }
    }
}
