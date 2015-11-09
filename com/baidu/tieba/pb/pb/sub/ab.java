package com.baidu.tieba.pb.pb.sub;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ v coo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(v vVar) {
        this.coo = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        View view;
        NewSubPbActivity newSubPbActivity;
        NewSubPbActivity newSubPbActivity2;
        if (aVar != null && !TextUtils.isEmpty(str)) {
            view = this.coo.cnV;
            TbRichTextView tbRichTextView = (TbRichTextView) view.findViewWithTag(str);
            if (tbRichTextView != null) {
                newSubPbActivity = this.coo.cnX;
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(newSubPbActivity.getResources(), aVar.nb(), aVar.nb().getNinePatchChunk(), aVar.nf(), null);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ac.mAlpha);
                }
                if (tbRichTextView instanceof TbRichTextView) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
                    newSubPbActivity2 = this.coo.cnX;
                    layoutParams.bottomMargin = (int) newSubPbActivity2.getResources().getDimension(i.d.ds20);
                    tbRichTextView.setLayoutParams(layoutParams);
                    tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
                }
            }
        }
    }
}
