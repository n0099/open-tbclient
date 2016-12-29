package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bDq;
    private final /* synthetic */ boolean ffD;
    private final /* synthetic */ SpannableString ffE;
    private final /* synthetic */ int ffF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bDq = baseActivity;
        this.ffD = z;
        this.ffE = spannableString;
        this.ffF = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bDq.getPageContext().getPageActivity());
        if (this.ffD) {
            textView.setBackgroundResource(r.f.pop_float_top);
        } else {
            textView.setBackgroundResource(r.f.pop_float);
        }
        int dimensionPixelSize = this.bDq.getResources().getDimensionPixelSize(r.e.ds32);
        int dimensionPixelSize2 = this.bDq.getResources().getDimensionPixelSize(r.e.ds22);
        if (this.ffD) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.ffE);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ar.getDrawable(this.ffF), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bDq));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dO() {
        return this.ffD ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dP() {
        return this.ffD ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.ffD ? 0 : 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return this.ffD ? 5 : 30;
    }
}
