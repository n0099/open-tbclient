package com.baidu.tieba.pb.pb.sub;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ s bPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(s sVar) {
        this.bPT = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        View view;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (aVar != null && !TextUtils.isEmpty(str)) {
            view = this.bPT.bPy;
            TbRichTextView tbRichTextView = (TbRichTextView) view.findViewWithTag(str);
            if (tbRichTextView != null) {
                tbPageContext = this.bPT.Yt;
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(tbPageContext.getResources(), aVar.mS(), aVar.mS().getNinePatchChunk(), aVar.mW(), null);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.an.mAlpha);
                }
                if (tbRichTextView instanceof TbRichTextView) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
                    tbPageContext2 = this.bPT.Yt;
                    layoutParams.bottomMargin = (int) tbPageContext2.getResources().getDimension(com.baidu.tieba.o.ds20);
                    tbRichTextView.setLayoutParams(layoutParams);
                    tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
                }
            }
        }
    }
}
