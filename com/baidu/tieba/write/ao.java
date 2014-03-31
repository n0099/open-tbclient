package com.baidu.tieba.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ao implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        EditText editText;
        if (bVar != null && bVar.h() != null && bVar.l() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkApplication.j().getResources(), bVar.h(), bVar.h().getNinePatchChunk(), bVar.l(), null);
            editText = this.a.h;
            editText.setBackgroundDrawable(ninePatchDrawable);
        }
    }
}
