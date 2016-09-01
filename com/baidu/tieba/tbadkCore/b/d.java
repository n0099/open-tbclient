package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bRe;
    private final /* synthetic */ boolean frE;
    private final /* synthetic */ SpannableString frF;
    private final /* synthetic */ int frG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bRe = baseActivity;
        this.frE = z;
        this.frF = spannableString;
        this.frG = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bRe.getPageContext().getPageActivity());
        if (this.frE) {
            textView.setBackgroundResource(t.f.pop_float_top);
        } else {
            textView.setBackgroundResource(t.f.pop_float);
        }
        int dimensionPixelSize = this.bRe.getResources().getDimensionPixelSize(t.e.ds32);
        int dimensionPixelSize2 = this.bRe.getResources().getDimensionPixelSize(t.e.ds22);
        if (this.frE) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.frF);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(this.frG), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bRe));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dO() {
        return this.frE ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dP() {
        return this.frE ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.frE ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
