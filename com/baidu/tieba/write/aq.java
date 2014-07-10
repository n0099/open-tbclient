package com.baidu.tieba.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity, boolean z) {
        this.a = writeActivity;
        this.b = z;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        EditText editText;
        EditText editText2;
        com.baidu.tieba.bubble.t tVar;
        if (aVar != null && aVar.h() != null && aVar.m() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkApplication.m252getInst().getResources(), aVar.h(), aVar.h().getNinePatchChunk(), aVar.m(), null);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.pb.main.bt.a);
            }
            editText = this.a.h;
            editText.setBackgroundDrawable(ninePatchDrawable);
            if (this.b) {
                WriteActivity writeActivity = this.a;
                editText2 = this.a.h;
                tVar = this.a.ac;
                com.baidu.tieba.bubble.h.a(writeActivity, editText2, true, tVar);
            }
        }
    }
}
