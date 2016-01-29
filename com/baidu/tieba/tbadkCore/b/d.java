package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity biS;
    private final /* synthetic */ boolean dWe;
    private final /* synthetic */ SpannableString dWf;
    private final /* synthetic */ int dWg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.biS = baseActivity;
        this.dWe = z;
        this.dWf = spannableString;
        this.dWg = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.biS.getPageContext().getPageActivity());
        if (this.dWe) {
            textView.setBackgroundResource(t.f.pop_float_top);
        } else {
            textView.setBackgroundResource(t.f.pop_float);
        }
        int dimensionPixelSize = this.biS.getResources().getDimensionPixelSize(t.e.ds32);
        int dimensionPixelSize2 = this.biS.getResources().getDimensionPixelSize(t.e.ds22);
        if (this.dWe) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.dWf);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ar.getDrawable(this.dWg), (Drawable) null);
        textView.setOnClickListener(new e(this, this.biS));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gF() {
        return this.dWe ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gG() {
        return this.dWe ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.dWe ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
