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
    private final /* synthetic */ BaseActivity ccs;
    private final /* synthetic */ boolean fxu;
    private final /* synthetic */ SpannableString fxv;
    private final /* synthetic */ int fxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.ccs = baseActivity;
        this.fxu = z;
        this.fxv = spannableString;
        this.fxw = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.ccs.getPageContext().getPageActivity());
        if (this.fxu) {
            textView.setBackgroundResource(w.g.pop_float_top);
        } else {
            textView.setBackgroundResource(w.g.pop_float);
        }
        int dimensionPixelSize = this.ccs.getResources().getDimensionPixelSize(w.f.ds32);
        int dimensionPixelSize2 = this.ccs.getResources().getDimensionPixelSize(w.f.ds22);
        if (this.fxu) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.fxv);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(this.fxw), (Drawable) null);
        textView.setOnClickListener(new e(this, this.ccs));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return this.fxu ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fb() {
        return this.fxu ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.fxu ? 0 : 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return this.fxu ? 5 : 30;
    }
}
