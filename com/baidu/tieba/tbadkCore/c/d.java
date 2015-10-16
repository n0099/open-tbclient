package com.baidu.tieba.tbadkCore.c;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bxE;
    private final /* synthetic */ boolean cYE;
    private final /* synthetic */ SpannableString cYF;
    private final /* synthetic */ int cYG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bxE = baseActivity;
        this.cYE = z;
        this.cYF = spannableString;
        this.cYG = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bxE.getPageContext().getPageActivity());
        if (this.cYE) {
            textView.setBackgroundResource(i.e.pop_float_top);
        } else {
            textView.setBackgroundResource(i.e.pop_float);
        }
        int dimensionPixelSize = this.bxE.getResources().getDimensionPixelSize(i.d.ds32);
        int dimensionPixelSize2 = this.bxE.getResources().getDimensionPixelSize(i.d.ds22);
        if (this.cYE) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.cYF);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(this.cYG), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bxE));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gw() {
        return this.cYE ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gx() {
        return this.cYE ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.cYE ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
