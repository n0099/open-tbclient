package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bQX;
    private final /* synthetic */ boolean ful;
    private final /* synthetic */ SpannableString fum;
    private final /* synthetic */ int fun;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bQX = baseActivity;
        this.ful = z;
        this.fum = spannableString;
        this.fun = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bQX.getPageContext().getPageActivity());
        if (this.ful) {
            textView.setBackgroundResource(r.f.pop_float_top);
        } else {
            textView.setBackgroundResource(r.f.pop_float);
        }
        int dimensionPixelSize = this.bQX.getResources().getDimensionPixelSize(r.e.ds32);
        int dimensionPixelSize2 = this.bQX.getResources().getDimensionPixelSize(r.e.ds22);
        if (this.ful) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.fum);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(this.fun), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bQX));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dO() {
        return this.ful ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dP() {
        return this.ful ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.ful ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
