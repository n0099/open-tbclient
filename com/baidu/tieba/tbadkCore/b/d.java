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
    private final /* synthetic */ BaseActivity cab;
    private final /* synthetic */ boolean fvd;
    private final /* synthetic */ SpannableString fve;
    private final /* synthetic */ int fvf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.cab = baseActivity;
        this.fvd = z;
        this.fve = spannableString;
        this.fvf = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.cab.getPageContext().getPageActivity());
        if (this.fvd) {
            textView.setBackgroundResource(w.g.pop_float_top);
        } else {
            textView.setBackgroundResource(w.g.pop_float);
        }
        int dimensionPixelSize = this.cab.getResources().getDimensionPixelSize(w.f.ds32);
        int dimensionPixelSize2 = this.cab.getResources().getDimensionPixelSize(w.f.ds22);
        if (this.fvd) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.fve);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(this.fvf), (Drawable) null);
        textView.setOnClickListener(new e(this, this.cab));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int eZ() {
        return this.fvd ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return this.fvd ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.fvd ? 0 : 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return this.fvd ? 5 : 30;
    }
}
