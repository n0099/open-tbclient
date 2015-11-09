package com.baidu.tieba.tbadkCore.c;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity byb;
    private final /* synthetic */ boolean dab;
    private final /* synthetic */ SpannableString dac;
    private final /* synthetic */ int dad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.byb = baseActivity;
        this.dab = z;
        this.dac = spannableString;
        this.dad = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.byb.getPageContext().getPageActivity());
        if (this.dab) {
            textView.setBackgroundResource(i.e.pop_float_top);
        } else {
            textView.setBackgroundResource(i.e.pop_float);
        }
        int dimensionPixelSize = this.byb.getResources().getDimensionPixelSize(i.d.ds32);
        int dimensionPixelSize2 = this.byb.getResources().getDimensionPixelSize(i.d.ds22);
        if (this.dab) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.dac);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(this.dad), (Drawable) null);
        textView.setOnClickListener(new e(this, this.byb));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gw() {
        return this.dab ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gx() {
        return this.dab ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.dab ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
