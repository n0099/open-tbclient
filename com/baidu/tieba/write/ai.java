package com.baidu.tieba.write;

import android.graphics.Bitmap;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tieba.editortool.h {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        WriteData writeData;
        WriteData writeData2;
        if (i == 28) {
            if (obj != null && (obj instanceof Bitmap)) {
                WriteImageActivity.a(this.a, (Bitmap) obj, 12003);
            }
        } else if (i == 29) {
            this.a.showToast(R.string.pic_parser_error);
            this.a.t();
        } else if (i == 32) {
            writeData2 = this.a.b;
            writeData2.setBitmapId(null);
            this.a.t();
        } else if (i == 30) {
            writeData = this.a.b;
            writeData.setBitmapId(null);
            this.a.t();
        }
    }
}
