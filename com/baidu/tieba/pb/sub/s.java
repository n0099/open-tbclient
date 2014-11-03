package com.baidu.tieba.pb.sub;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.main.bv;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ l bAZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar) {
        this.bAZ = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbRichTextView tbRichTextView;
        if (aVar != null && !TextUtils.isEmpty(str) && (tbRichTextView = (TbRichTextView) this.bAZ.bAE.findViewWithTag(str)) != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.bAZ.mActivity.getResources(), aVar.hl(), aVar.hl().getNinePatchChunk(), aVar.hp(), null);
            if (TbadkApplication.m251getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(bv.jh);
            }
            if (tbRichTextView instanceof TbRichTextView) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
                layoutParams.bottomMargin = (int) this.bAZ.mActivity.getResources().getDimension(t.ds20);
                tbRichTextView.setLayoutParams(layoutParams);
                tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
            }
        }
    }
}
