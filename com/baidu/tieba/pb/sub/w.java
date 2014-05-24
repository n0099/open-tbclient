package com.baidu.tieba.pb.sub;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.main.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbRichTextView tbRichTextView;
        if (aVar != null && !TextUtils.isEmpty(str) && (tbRichTextView = (TbRichTextView) this.a.c.findViewWithTag(str)) != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.a.f.getResources(), aVar.h(), aVar.h().getNinePatchChunk(), aVar.m(), null);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(bq.a);
            }
            if (tbRichTextView instanceof TbRichTextView) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
                layoutParams.bottomMargin = (int) this.a.f.getResources().getDimension(com.baidu.tieba.t.ds20);
                tbRichTextView.setLayoutParams(layoutParams);
                tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
            }
        }
    }
}
