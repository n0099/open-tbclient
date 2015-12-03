package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bNh;
    private final /* synthetic */ boolean dyP;
    private final /* synthetic */ SpannableString dyQ;
    private final /* synthetic */ int dyR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bNh = baseActivity;
        this.dyP = z;
        this.dyQ = spannableString;
        this.dyR = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bNh.getPageContext().getPageActivity());
        if (this.dyP) {
            textView.setBackgroundResource(n.e.pop_float_top);
        } else {
            textView.setBackgroundResource(n.e.pop_float);
        }
        int dimensionPixelSize = this.bNh.getResources().getDimensionPixelSize(n.d.ds32);
        int dimensionPixelSize2 = this.bNh.getResources().getDimensionPixelSize(n.d.ds22);
        if (this.dyP) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.dyQ);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(this.dyR), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bNh));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gx() {
        return this.dyP ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gy() {
        return this.dyP ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.dyP ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
