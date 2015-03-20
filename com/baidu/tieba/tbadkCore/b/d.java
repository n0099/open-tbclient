package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bda;
    private final /* synthetic */ int cnA;
    private final /* synthetic */ boolean cny;
    private final /* synthetic */ SpannableString cnz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bda = baseActivity;
        this.cny = z;
        this.cnz = spannableString;
        this.cnA = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bda.getPageContext().getPageActivity());
        if (this.cny) {
            textView.setBackgroundResource(u.pop_float_top);
        } else {
            textView.setBackgroundResource(u.pop_float);
        }
        int dimensionPixelSize = this.bda.getResources().getDimensionPixelSize(t.ds32);
        int dimensionPixelSize2 = this.bda.getResources().getDimensionPixelSize(t.ds22);
        if (this.cny) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.cnz);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ba.getDrawable(this.cnA), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bda));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gT() {
        return this.cny ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gU() {
        return this.cny ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.cny ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
