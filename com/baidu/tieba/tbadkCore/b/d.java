package com.baidu.tieba.tbadkCore.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    private final /* synthetic */ BaseActivity bQN;
    private final /* synthetic */ boolean dGj;
    private final /* synthetic */ SpannableString dGk;
    private final /* synthetic */ int dGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bQN = baseActivity;
        this.dGj = z;
        this.dGk = spannableString;
        this.dGl = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bQN.getPageContext().getPageActivity());
        if (this.dGj) {
            textView.setBackgroundResource(n.f.pop_float_top);
        } else {
            textView.setBackgroundResource(n.f.pop_float);
        }
        int dimensionPixelSize = this.bQN.getResources().getDimensionPixelSize(n.e.ds32);
        int dimensionPixelSize2 = this.bQN.getResources().getDimensionPixelSize(n.e.ds22);
        if (this.dGj) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.dGk);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(this.dGl), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bQN));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gx() {
        return this.dGj ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gy() {
        return this.dGj ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.dGj ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
