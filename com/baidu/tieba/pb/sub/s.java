package com.baidu.tieba.pb.sub;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.main.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar) {
        this.a = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbRichTextView tbRichTextView;
        if (aVar != null && !TextUtils.isEmpty(str) && (tbRichTextView = (TbRichTextView) this.a.c.findViewWithTag(str)) != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.a.f.getResources(), aVar.h(), aVar.h().getNinePatchChunk(), aVar.l(), null);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(bs.a);
            }
            if (tbRichTextView instanceof TbRichTextView) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
                layoutParams.bottomMargin = (int) this.a.f.getResources().getDimension(com.baidu.tieba.s.ds20);
                tbRichTextView.setLayoutParams(layoutParams);
                tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
            }
        }
    }
}
