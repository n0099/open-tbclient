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
    private final /* synthetic */ boolean bXQ;
    private final /* synthetic */ SpannableString bXR;
    private final /* synthetic */ int bXS;
    private final /* synthetic */ BaseActivity baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.baY = baseActivity;
        this.bXQ = z;
        this.bXR = spannableString;
        this.bXS = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.baY.getPageContext().getPageActivity());
        if (this.bXQ) {
            textView.setBackgroundResource(com.baidu.tieba.v.pop_float_top);
        } else {
            textView.setBackgroundResource(com.baidu.tieba.v.pop_float);
        }
        int dimensionPixelSize = this.baY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32);
        int dimensionPixelSize2 = this.baY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds22);
        if (this.bXQ) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.bXR);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, bc.getDrawable(this.bXS), (Drawable) null);
        textView.setOnClickListener(new q(this, this.baY));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dv() {
        return this.bXQ ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dw() {
        return this.bXQ ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.bXQ ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
