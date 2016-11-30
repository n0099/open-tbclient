package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bXg;
    private final /* synthetic */ int fBA;
    private final /* synthetic */ boolean fBy;
    private final /* synthetic */ SpannableString fBz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bXg = baseActivity;
        this.fBy = z;
        this.fBz = spannableString;
        this.fBA = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bXg.getPageContext().getPageActivity());
        if (this.fBy) {
            textView.setBackgroundResource(r.f.pop_float_top);
        } else {
            textView.setBackgroundResource(r.f.pop_float);
        }
        int dimensionPixelSize = this.bXg.getResources().getDimensionPixelSize(r.e.ds32);
        int dimensionPixelSize2 = this.bXg.getResources().getDimensionPixelSize(r.e.ds22);
        if (this.fBy) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.fBz);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, at.getDrawable(this.fBA), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bXg));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dO() {
        return this.fBy ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dP() {
        return this.fBy ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.fBy ? 0 : 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return this.fBy ? 5 : 30;
    }
}
