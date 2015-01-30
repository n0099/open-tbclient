package com.baidu.tieba.tbadkCore.bubble;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.guide.b;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
class p implements b {
    private final /* synthetic */ boolean bXR;
    private final /* synthetic */ SpannableString bXS;
    private final /* synthetic */ int bXT;
    private final /* synthetic */ BaseActivity baZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.baZ = baseActivity;
        this.bXR = z;
        this.bXS = spannableString;
        this.bXT = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.baZ.getPageContext().getPageActivity());
        if (this.bXR) {
            textView.setBackgroundResource(com.baidu.tieba.v.pop_float_top);
        } else {
            textView.setBackgroundResource(com.baidu.tieba.v.pop_float);
        }
        int dimensionPixelSize = this.baZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32);
        int dimensionPixelSize2 = this.baZ.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds22);
        if (this.bXR) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.bXS);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, bc.getDrawable(this.bXT), (Drawable) null);
        textView.setOnClickListener(new q(this, this.baZ));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dv() {
        return this.bXR ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dw() {
        return this.bXR ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.bXR ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
