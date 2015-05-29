package com.baidu.tieba.tbadkCore.c;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bfU;
    private final /* synthetic */ boolean crM;
    private final /* synthetic */ SpannableString crN;
    private final /* synthetic */ int crO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bfU = baseActivity;
        this.crM = z;
        this.crN = spannableString;
        this.crO = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bfU.getPageContext().getPageActivity());
        if (this.crM) {
            textView.setBackgroundResource(p.pop_float_top);
        } else {
            textView.setBackgroundResource(p.pop_float);
        }
        int dimensionPixelSize = this.bfU.getResources().getDimensionPixelSize(o.ds32);
        int dimensionPixelSize2 = this.bfU.getResources().getDimensionPixelSize(o.ds22);
        if (this.crM) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.crN);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ay.getDrawable(this.crO), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bfU));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gE() {
        return this.crM ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gF() {
        return this.crM ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.crM ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
