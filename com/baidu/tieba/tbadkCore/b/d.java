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
    private final /* synthetic */ BaseActivity cbA;
    private final /* synthetic */ boolean ftu;
    private final /* synthetic */ SpannableString ftv;
    private final /* synthetic */ int ftw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.cbA = baseActivity;
        this.ftu = z;
        this.ftv = spannableString;
        this.ftw = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.cbA.getPageContext().getPageActivity());
        if (this.ftu) {
            textView.setBackgroundResource(w.g.pop_float_top);
        } else {
            textView.setBackgroundResource(w.g.pop_float);
        }
        int dimensionPixelSize = this.cbA.getResources().getDimensionPixelSize(w.f.ds32);
        int dimensionPixelSize2 = this.cbA.getResources().getDimensionPixelSize(w.f.ds22);
        if (this.ftu) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.ftv);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(this.ftw), (Drawable) null);
        textView.setOnClickListener(new e(this, this.cbA));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int eU() {
        return this.ftu ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int eV() {
        return this.ftu ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.ftu ? 0 : 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return this.ftu ? 5 : 30;
    }
}
