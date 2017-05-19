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
    private final /* synthetic */ BaseActivity cQj;
    private final /* synthetic */ int ftA;
    private final /* synthetic */ boolean fty;
    private final /* synthetic */ SpannableString ftz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.cQj = baseActivity;
        this.fty = z;
        this.ftz = spannableString;
        this.ftA = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.cQj.getPageContext().getPageActivity());
        if (this.fty) {
            textView.setBackgroundResource(w.g.pop_float_top);
        } else {
            textView.setBackgroundResource(w.g.pop_float);
        }
        int dimensionPixelSize = this.cQj.getResources().getDimensionPixelSize(w.f.ds32);
        int dimensionPixelSize2 = this.cQj.getResources().getDimensionPixelSize(w.f.ds22);
        if (this.fty) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.ftz);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(this.ftA), (Drawable) null);
        textView.setOnClickListener(new e(this, this.cQj));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return this.fty ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fb() {
        return this.fty ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.fty ? 0 : 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return this.fty ? 5 : 30;
    }
}
