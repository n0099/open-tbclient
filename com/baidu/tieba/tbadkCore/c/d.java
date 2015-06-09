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
    private final /* synthetic */ BaseActivity bfV;
    private final /* synthetic */ boolean crN;
    private final /* synthetic */ SpannableString crO;
    private final /* synthetic */ int crP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bfV = baseActivity;
        this.crN = z;
        this.crO = spannableString;
        this.crP = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bfV.getPageContext().getPageActivity());
        if (this.crN) {
            textView.setBackgroundResource(p.pop_float_top);
        } else {
            textView.setBackgroundResource(p.pop_float);
        }
        int dimensionPixelSize = this.bfV.getResources().getDimensionPixelSize(o.ds32);
        int dimensionPixelSize2 = this.bfV.getResources().getDimensionPixelSize(o.ds22);
        if (this.crN) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.crO);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ay.getDrawable(this.crP), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bfV));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gE() {
        return this.crN ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gF() {
        return this.crN ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.crN ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
