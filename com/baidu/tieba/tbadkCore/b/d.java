package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity ddE;
    private final /* synthetic */ boolean fLt;
    private final /* synthetic */ SpannableString fLu;
    private final /* synthetic */ int fLv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.ddE = baseActivity;
        this.fLt = z;
        this.fLu = spannableString;
        this.fLv = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.ddE.getPageContext().getPageActivity());
        if (this.fLt) {
            textView.setBackgroundResource(w.g.pop_float_top);
        } else {
            textView.setBackgroundResource(w.g.pop_float);
        }
        int dimensionPixelSize = this.ddE.getResources().getDimensionPixelSize(w.f.ds32);
        int dimensionPixelSize2 = this.ddE.getResources().getDimensionPixelSize(w.f.ds22);
        if (this.fLt) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.fLu);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(this.fLv), (Drawable) null);
        textView.setOnClickListener(new e(this, this.ddE));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int eZ() {
        return this.fLt ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return this.fLt ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.fLt ? 0 : 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return this.fLt ? 5 : 30;
    }
}
