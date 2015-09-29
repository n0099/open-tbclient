package com.baidu.tieba.tbadkCore.c;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bxt;
    private final /* synthetic */ boolean cYe;
    private final /* synthetic */ SpannableString cYf;
    private final /* synthetic */ int cYg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bxt = baseActivity;
        this.cYe = z;
        this.cYf = spannableString;
        this.cYg = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bxt.getPageContext().getPageActivity());
        if (this.cYe) {
            textView.setBackgroundResource(i.e.pop_float_top);
        } else {
            textView.setBackgroundResource(i.e.pop_float);
        }
        int dimensionPixelSize = this.bxt.getResources().getDimensionPixelSize(i.d.ds32);
        int dimensionPixelSize2 = this.bxt.getResources().getDimensionPixelSize(i.d.ds22);
        if (this.cYe) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.cYf);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(this.cYg), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bxt));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gw() {
        return this.cYe ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gx() {
        return this.cYe ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.cYe ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
