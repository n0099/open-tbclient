package com.baidu.tieba.tbadkCore.bubble;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.b;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
class p implements b {
    private final /* synthetic */ BaseActivity aZC;
    private final /* synthetic */ boolean bVZ;
    private final /* synthetic */ SpannableString bWa;
    private final /* synthetic */ int bWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.aZC = baseActivity;
        this.bVZ = z;
        this.bWa = spannableString;
        this.bWb = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.aZC.getPageContext().getPageActivity());
        if (this.bVZ) {
            textView.setBackgroundResource(com.baidu.tieba.v.pop_float_top);
        } else {
            textView.setBackgroundResource(com.baidu.tieba.v.pop_float);
        }
        int dimensionPixelSize = this.aZC.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32);
        int dimensionPixelSize2 = this.aZC.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds22);
        if (this.bVZ) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.bWa);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ax.getDrawable(this.bWb), (Drawable) null);
        textView.setOnClickListener(new q(this, this.aZC));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dx() {
        return this.bVZ ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
        return this.bVZ ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.bVZ ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
