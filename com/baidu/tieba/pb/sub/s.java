package com.baidu.tieba.pb.sub;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.ak;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class s extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ l bEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar) {
        this.bEM = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbRichTextView tbRichTextView;
        if (aVar != null && !TextUtils.isEmpty(str) && (tbRichTextView = (TbRichTextView) this.bEM.bEr.findViewWithTag(str)) != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.bEM.mActivity.getResources(), aVar.ji(), aVar.ji().getNinePatchChunk(), aVar.jm(), null);
            if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(ak.mAlpha);
            }
            if (tbRichTextView instanceof TbRichTextView) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
                layoutParams.bottomMargin = (int) this.bEM.mActivity.getResources().getDimension(u.ds20);
                tbRichTextView.setLayoutParams(layoutParams);
                tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
            }
        }
    }
}
