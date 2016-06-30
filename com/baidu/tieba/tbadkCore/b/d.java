package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bEJ;
    private final /* synthetic */ boolean eWJ;
    private final /* synthetic */ SpannableString eWK;
    private final /* synthetic */ int eWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bEJ = baseActivity;
        this.eWJ = z;
        this.eWK = spannableString;
        this.eWL = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bEJ.getPageContext().getPageActivity());
        if (this.eWJ) {
            textView.setBackgroundResource(u.f.pop_float_top);
        } else {
            textView.setBackgroundResource(u.f.pop_float);
        }
        int dimensionPixelSize = this.bEJ.getResources().getDimensionPixelSize(u.e.ds32);
        int dimensionPixelSize2 = this.bEJ.getResources().getDimensionPixelSize(u.e.ds22);
        if (this.eWJ) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.eWK);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(this.eWL), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bEJ));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
        return this.eWJ ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cV() {
        return this.eWJ ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.eWJ ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
