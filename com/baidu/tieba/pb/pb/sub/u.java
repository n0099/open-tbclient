package com.baidu.tieba.pb.pb.sub;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.an;
/* loaded from: classes.dex */
class u extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ l bOf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(l lVar) {
        this.bOf = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbRichTextView tbRichTextView;
        if (aVar != null && !TextUtils.isEmpty(str) && (tbRichTextView = (TbRichTextView) this.bOf.bNK.findViewWithTag(str)) != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.bOf.mActivity.getResources(), aVar.mz(), aVar.mz().getNinePatchChunk(), aVar.mD(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(an.mAlpha);
            }
            if (tbRichTextView instanceof TbRichTextView) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
                layoutParams.bottomMargin = (int) this.bOf.mActivity.getResources().getDimension(com.baidu.tieba.t.ds20);
                tbRichTextView.setLayoutParams(layoutParams);
                tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
            }
        }
    }
}
