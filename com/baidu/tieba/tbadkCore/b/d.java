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
    private final /* synthetic */ BaseActivity bFW;
    private final /* synthetic */ boolean fjL;
    private final /* synthetic */ SpannableString fjM;
    private final /* synthetic */ int fjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bFW = baseActivity;
        this.fjL = z;
        this.fjM = spannableString;
        this.fjN = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bFW.getPageContext().getPageActivity());
        if (this.fjL) {
            textView.setBackgroundResource(u.f.pop_float_top);
        } else {
            textView.setBackgroundResource(u.f.pop_float);
        }
        int dimensionPixelSize = this.bFW.getResources().getDimensionPixelSize(u.e.ds32);
        int dimensionPixelSize2 = this.bFW.getResources().getDimensionPixelSize(u.e.ds22);
        if (this.fjL) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.fjM);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(this.fjN), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bFW));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cT() {
        return this.fjL ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
        return this.fjL ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.fjL ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
