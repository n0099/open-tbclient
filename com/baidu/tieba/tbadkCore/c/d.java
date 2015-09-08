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
    private final /* synthetic */ BaseActivity bur;
    private final /* synthetic */ boolean cQN;
    private final /* synthetic */ SpannableString cQO;
    private final /* synthetic */ int cQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseActivity baseActivity, boolean z, SpannableString spannableString, int i) {
        this.bur = baseActivity;
        this.cQN = z;
        this.cQO = spannableString;
        this.cQP = i;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        TextView textView = new TextView(this.bur.getPageContext().getPageActivity());
        if (this.cQN) {
            textView.setBackgroundResource(i.e.pop_float_top);
        } else {
            textView.setBackgroundResource(i.e.pop_float);
        }
        int dimensionPixelSize = this.bur.getResources().getDimensionPixelSize(i.d.ds32);
        int dimensionPixelSize2 = this.bur.getResources().getDimensionPixelSize(i.d.ds22);
        if (this.cQN) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
        } else {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
        }
        textView.setGravity(17);
        textView.setText(this.cQO);
        textView.setCompoundDrawablePadding(dimensionPixelSize);
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(this.cQP), (Drawable) null);
        textView.setOnClickListener(new e(this, this.bur));
        return textView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gw() {
        return this.cQN ? 4 : 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gx() {
        return this.cQN ? 32 : 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return this.cQN ? 0 : 20;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 5;
    }
}
