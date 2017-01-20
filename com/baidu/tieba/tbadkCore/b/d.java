package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bUo;
    private final /* synthetic */ boolean foY;
    private final /* synthetic */ SpannableString foZ;
    private final /* synthetic */ int fpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bUo = baseActivity;
        this.foY = z;
        this.foZ = spannableString;
        this.fpa = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bUo.getPageContext().getPageActivity());
        if (this.foY) {
            textView.setBackgroundResource(r.g.pop_float_top);
        } else {
            textView.setBackgroundResource(r.g.pop_float);
        }
        int dimensionPixelSize = this.bUo.getResources().getDimensionPixelSize(r.f.ds32);
        int dimensionPixelSize2 = this.bUo.getResources().getDimensionPixelSize(r.f.ds22);
        if (this.foY) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.foZ);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(this.fpa), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bUo));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dM() {
        return this.foY ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dN() {
        return this.foY ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.foY ? 0 : 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return this.foY ? 5 : 30;
    }
}
