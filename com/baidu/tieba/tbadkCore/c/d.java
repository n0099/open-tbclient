package com.baidu.tieba.tbadkCore.c;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity btL;
    private final /* synthetic */ boolean cIn;
    private final /* synthetic */ SpannableString cIo;
    private final /* synthetic */ int cIp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.btL = baseActivity;
        this.cIn = z;
        this.cIo = spannableString;
        this.cIp = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.btL.getPageContext().getPageActivity());
        if (this.cIn) {
            textView.setBackgroundResource(i.e.pop_float_top);
        } else {
            textView.setBackgroundResource(i.e.pop_float);
        }
        int dimensionPixelSize = this.btL.getResources().getDimensionPixelSize(i.d.ds32);
        int dimensionPixelSize2 = this.btL.getResources().getDimensionPixelSize(i.d.ds22);
        if (this.cIn) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.cIo);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(this.cIp), (Drawable) null);
        textView.setOnClickListener(new e(this, this.btL));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gz() {
        return this.cIn ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gA() {
        return this.cIn ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.cIn ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
