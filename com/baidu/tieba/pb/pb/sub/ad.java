package com.baidu.tieba.pb.pb.sub;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ w cUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(w wVar) {
        this.cUl = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        View view;
        NewSubPbActivity newSubPbActivity;
        NewSubPbActivity newSubPbActivity2;
        if (aVar != null && !TextUtils.isEmpty(str)) {
            view = this.cUl.cTM;
            TbRichTextView tbRichTextView = (TbRichTextView) view.findViewWithTag(str);
            if (tbRichTextView != null) {
                newSubPbActivity = this.cUl.cTO;
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(newSubPbActivity.getResources(), aVar.mS(), aVar.mS().getNinePatchChunk(), aVar.mW(), null);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ac.mAlpha);
                }
                if (tbRichTextView instanceof TbRichTextView) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
                    newSubPbActivity2 = this.cUl.cTO;
                    layoutParams.bottomMargin = (int) newSubPbActivity2.getResources().getDimension(t.e.ds20);
                    tbRichTextView.setLayoutParams(layoutParams);
                    tbRichTextView.setBackgroundDrawable(ninePatchDrawable);
                }
            }
        }
    }
}
