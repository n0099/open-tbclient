package com.baidu.tieba.pb.main;

import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.richText.TbRichTextView;
/* loaded from: classes.dex */
final class cj implements com.baidu.tbadk.core.util.bp {
    final /* synthetic */ ci a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.adp.widget.ImageView.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ci ciVar, String str, com.baidu.adp.widget.ImageView.b bVar) {
        this.a = ciVar;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public final boolean a(View view) {
        SparseArray sparseArray;
        PbActivity pbActivity;
        if ((view instanceof TbRichTextView) && !this.b.equals(((TbRichTextView) view).getBackgroundImageUrl())) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (Exception e) {
                sparseArray = null;
            }
            if (sparseArray != null) {
                String str = (String) sparseArray.get(com.baidu.tieba.a.h.tag_richtext_bg);
                if (!TextUtils.isEmpty(str) && this.b.equals(str)) {
                    pbActivity = this.a.a.m;
                    NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(pbActivity.getResources(), this.c.h(), this.c.h().getNinePatchChunk(), this.c.l(), null);
                    if (TbadkApplication.j().l() == 1) {
                        ninePatchDrawable.getPaint().setAlpha(bk.a);
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
