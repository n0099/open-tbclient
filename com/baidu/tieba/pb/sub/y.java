package com.baidu.tieba.pb.sub;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.main.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        TbRichTextView tbRichTextView;
        if (bVar != null && !TextUtils.isEmpty(str) && (tbRichTextView = (TbRichTextView) this.a.c.findViewWithTag(str)) != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.a.f.getResources(), bVar.h(), bVar.h().getNinePatchChunk(), bVar.l(), null);
            if (TbadkApplication.j().l() == 1) {
                ninePatchDrawable.getPaint().setAlpha(bm.a);
            }
            if (tbRichTextView instanceof TbRichTextView) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
                layoutParams.bottomMargin = (int) this.a.f.getResources().getDimension(com.baidu.tieba.a.f.ds20);
                tbRichTextView.setLayoutParams(layoutParams);
                tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
            }
        }
    }
}
