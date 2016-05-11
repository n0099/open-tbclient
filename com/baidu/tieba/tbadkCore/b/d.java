package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bjg;
    private final /* synthetic */ boolean erV;
    private final /* synthetic */ SpannableString erW;
    private final /* synthetic */ int erX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bjg = baseActivity;
        this.erV = z;
        this.erW = spannableString;
        this.erX = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bjg.getPageContext().getPageActivity());
        if (this.erV) {
            textView.setBackgroundResource(t.f.pop_float_top);
        } else {
            textView.setBackgroundResource(t.f.pop_float);
        }
        int dimensionPixelSize = this.bjg.getResources().getDimensionPixelSize(t.e.ds32);
        int dimensionPixelSize2 = this.bjg.getResources().getDimensionPixelSize(t.e.ds22);
        if (this.erV) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.erW);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, at.getDrawable(this.erX), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bjg));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cT() {
        return this.erV ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
        return this.erV ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.erV ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
