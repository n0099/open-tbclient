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
    private final /* synthetic */ BaseActivity bdq;
    private final /* synthetic */ boolean cnO;
    private final /* synthetic */ SpannableString cnP;
    private final /* synthetic */ int cnQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bdq = baseActivity;
        this.cnO = z;
        this.cnP = spannableString;
        this.cnQ = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bdq.getPageContext().getPageActivity());
        if (this.cnO) {
            textView.setBackgroundResource(u.pop_float_top);
        } else {
            textView.setBackgroundResource(u.pop_float);
        }
        int dimensionPixelSize = this.bdq.getResources().getDimensionPixelSize(t.ds32);
        int dimensionPixelSize2 = this.bdq.getResources().getDimensionPixelSize(t.ds22);
        if (this.cnO) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.cnP);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ba.getDrawable(this.cnQ), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bdq));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gT() {
        return this.cnO ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gU() {
        return this.cnO ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.cnO ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
