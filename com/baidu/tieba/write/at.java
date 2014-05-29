package com.baidu.tieba.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        EditText editText;
        if (aVar != null && aVar.h() != null && aVar.m() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkApplication.m252getInst().getResources(), aVar.h(), aVar.h().getNinePatchChunk(), aVar.m(), null);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.pb.main.bq.a);
            }
            editText = this.a.h;
            editText.setBackgroundDrawable(ninePatchDrawable);
        }
    }
}
