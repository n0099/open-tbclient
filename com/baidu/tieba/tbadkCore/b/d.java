package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity cVH;
    private final /* synthetic */ boolean fBp;
    private final /* synthetic */ SpannableString fBq;
    private final /* synthetic */ int fBr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.cVH = baseActivity;
        this.fBp = z;
        this.fBq = spannableString;
        this.fBr = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.cVH.getPageContext().getPageActivity());
        if (this.fBp) {
            textView.setBackgroundResource(w.g.pop_float_top);
        } else {
            textView.setBackgroundResource(w.g.pop_float);
        }
        int dimensionPixelSize = this.cVH.getResources().getDimensionPixelSize(w.f.ds32);
        int dimensionPixelSize2 = this.cVH.getResources().getDimensionPixelSize(w.f.ds22);
        if (this.fBp) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.fBq);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(this.fBr), (Drawable) null);
        textView.setOnClickListener(new e(this, this.cVH));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return this.fBp ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fb() {
        return this.fBp ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.fBp ? 0 : 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return this.fBp ? 5 : 30;
    }
}
