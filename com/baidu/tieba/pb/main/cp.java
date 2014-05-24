package com.baidu.tieba.pb.main;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
class cp implements com.baidu.tbadk.core.util.br {
    final /* synthetic */ co a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar, String str, com.baidu.adp.widget.a.a aVar) {
        this.a = coVar;
        this.b = str;
        this.c = aVar;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
        SparseArray sparseArray;
        bq bqVar;
        PbActivity pbActivity;
        if ((view instanceof TbRichTextView) && !this.b.equals(((TbRichTextView) view).getBackgroundImageUrl())) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (Exception e) {
                sparseArray = null;
            }
            if (sparseArray != null) {
                String str = (String) sparseArray.get(com.baidu.tieba.v.tag_richtext_bg);
                if (!TextUtils.isEmpty(str) && this.b.equals(str)) {
                    bqVar = this.a.a;
                    pbActivity = bqVar.m;
                    NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(pbActivity.getResources(), this.c.h(), this.c.h().getNinePatchChunk(), this.c.m(), null);
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        ninePatchDrawable.getPaint().setAlpha(bq.a);
                    }
                    if (view instanceof TbRichTextView) {
                        view.setBackgroundDrawable(ninePatchDrawable);
                    }
                }
            }
        }
        return false;
    }
}
